using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using CuriousDriveWebClient.Attributes;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Http;
using CuriousDriveWebAPI.CuriousDrive;
using CuriousDriveWebAPI.CuriousDrive.Models;
using CuriousDriveWebAPI.CuriousDrive.UnitsOfWork;
using System.Threading.Tasks;

namespace CuriousDriveWebClient.Controllers
{
    public class QuestionController : Controller
    {
        #region Questions

        [HttpGet]        
        public IActionResult Questions(string questionsType, int? pageNumber)
        {
            QuestionsViewModel questionsViewModel = new QuestionsViewModel();
            questionsViewModel.questionsViewModel = new List<QuestionViewModel>();

            using (var unitOfWork = new UnitOfWork(new CuriousDriveContext()))
            {
                List<Question> questions = unitOfWork.Questions.GetRecentQuestions();

                foreach (Question question in questions)
                {
                    QuestionViewModel questionViewModel = new QuestionViewModel();

                    questionViewModel.questionId = question.QuestionId;
                    questionViewModel.questionTitle = question.QuestionTitle;
                    questionViewModel.createdDate = question.CreatedDate;

                    questionViewModel.answerCount = unitOfWork.QuestionAnswers.GetAnswerCountByQuestionId(question.QuestionId);
                    List<QuestionClass> questionClasses = unitOfWork.QuestionClasses.GetQuestionClassesByQuestionId(question.QuestionId);

                    questionViewModel.questionClassesViewModel = new List<QuestionClassViewModel>();

                    foreach (QuestionClass questionClass in questionClasses)
                    {
                        QuestionClassViewModel questionClassViewModel = new QuestionClassViewModel();

                        questionClassViewModel.classId = questionClass.ClassId;
                        questionClassViewModel.className = questionClass.Class.ClassName;

                        questionViewModel.questionClassesViewModel.Add(questionClassViewModel);
                    }

                    User user = unitOfWork.Users.Get((int)question.CreatedBy);

                    questionViewModel.userDetailsViewModel = new UserDetailsViewModel();
                    questionViewModel.userDetailsViewModel.userId = user.UserId;
                    questionViewModel.userDetailsViewModel.displayName = user.DisplayName;
                    questionViewModel.userDetailsViewModel.urlTitle = Utility.GetURLTitle(user.DisplayName);

                    questionViewModel.userDetailsViewModel.profilePictureViewModel = new ProfilePictureViewModel();

                    questionsViewModel.questionsViewModel.Add(questionViewModel);
                }
            }

            return View(questionsViewModel);
        }

        [HttpPost]                
        public IActionResult Questions()
        {
            QuestionsViewModel questionsViewModel = new QuestionsViewModel();
            questionsViewModel.questionsViewModel = new List<QuestionViewModel>();          

            return View(questionsViewModel);
        }

        [HttpPost]
        public PartialViewResult DisplayQuestionsList(string questionsType, int? pageNumber)
        {

            //int pageSize = 5;
            int pageIndex = 1;
            pageIndex = pageNumber.HasValue ? Convert.ToInt32(pageNumber) : 1;

            //QuestionService questionService = new QuestionService();
            List<Question> llstQuestions = null;//questionService.GetQuestions(questionsType).ToPagedList(pageIndex, pageSize);

            return PartialView("_QuestionsList", llstQuestions);
        }

        #endregion

        #region AskQuestion        
        public IActionResult AskQuestion(int questionId)
        {
            AskQuestionViewModel askQuestionViewModel = new AskQuestionViewModel();
            askQuestionViewModel.classesViewModel = new List<ClassViewModel>();

            using (var unitOfWork = new UnitOfWork(new CuriousDriveContext()))
            {
                List<Class> classes = unitOfWork.Classes.GetAll().ToList();

                foreach (Class @class in classes)
                {
                    ClassViewModel classViewModel = new ClassViewModel();

                    classViewModel.classId = @class.ClassId;
                    classViewModel.className = @class.ClassName;

                    askQuestionViewModel.classesViewModel.Add(classViewModel);

                }
            }

            return View(askQuestionViewModel);
        }

        [HttpPost]
        public IActionResult AskQuestion(IFormCollection formCollection,AskQuestionViewModel askQuestionViewModel, string submitType)
        {
            using (var unitOfWork = new UnitOfWork(new CuriousDriveContext()))
            {
                int userId = HttpContext.Session.GetInt32("UserId") ?? 0;
                if (submitType == "UpdateQuestion")
                {
                    //new QuestionService().UpdateQuestion(aQuestion, lintUserId);
                    return RedirectToAction("Question", new
                    {
                        id = askQuestionViewModel.questionId,
                        title = ""
                    });
                }
                else if (submitType == "CancelUpdateQuestion")
                {
                    return RedirectToAction("Question", new
                    {
                        id = askQuestionViewModel.questionId,
                        title = ""
                    });
                }
                else
                {
                    Question question = new Question();

                    question.UserId = userId;
                    question.QuestionTitle = askQuestionViewModel.questionTitle;
                    question.QuestionHtml = askQuestionViewModel.questionHtml;

                    question.CreatedBy = question.ModifiedBy = userId;                    

                    //tag classes
                    string classIds = formCollection["txtClassIds"];

                    if (classIds.Length > 0)
                    {
                        question.QuestionClass = new List<QuestionClass>();

                        foreach (string classId in classIds.Split(','))
                        {
                            QuestionClass questionClass = new QuestionClass();
                            questionClass.ClassId = Convert.ToInt32(classId);

                            question.QuestionClass.Add(questionClass);
                        }                        
                    }

                    //tag users
                    string taggedUserIds = formCollection["txtUserTags"];

                    if (taggedUserIds.Length > 0)
                    {
                        question.Tag = new List<Tag>();

                        foreach (string taggedUserId in taggedUserIds.Split(','))
                        {
                            Tag tag = new Tag();

                            tag.UserGroupTypeId = Constant.UserGroupTypeId;
                            tag.UserGroupTypeValue = Constant.UserGroupTypeIndividual;
                            tag.CreatedBy = tag.ModifiedBy = userId;

                            tag.TagDetail = new List<TagDetail>();

                            TagDetail tagDetail = new TagDetail();
                            tagDetail.TaggedUserId = Convert.ToInt32(taggedUserId);

                            tag.TagDetail.Add(tagDetail);
                            question.Tag.Add(tag);
                        }
                    }

                    unitOfWork.Questions.Add(question);
                    unitOfWork.Complete();

                    return RedirectToAction("Question","Question", new { questionId = question.QuestionId });
                }
            }                
        }

        [Produces("application/json")]
        [HttpGet]
        public IActionResult AutoCompleteUsers()
        {
            using (var unitOfWork = new UnitOfWork(new CuriousDriveContext()))
            {
                string prefix = HttpContext.Request.Query["term"].ToString();
                List<User> users = unitOfWork.Users.GetTop10UsersByPrefix(prefix);

                if (users != null && users.Count() > 0)
                {
                    var lfltrUsers = (from user in users
                                      select new
                                      {
                                          label = user.DisplayName,
                                          val = user.UserId
                                      }).ToList();
                    return Ok(lfltrUsers);
                }
                else
                    return Ok(null);

               
            }
        }

        [HttpPost]
        public JsonResult AutoCompleteClasses(string prefix)
        {
            //AdminService adminService = new AdminService();
            List<Class> llstClasses = new List<Class>();//adminService.GetClasses();

            llstClasses = llstClasses.Where(lClass => lClass.ClassName.ToLower().Contains(prefix.ToLower())).Take(10).ToList();

            var lfltrClasses = (from Class in llstClasses
                                   select new
                                   {
                                       label = Class.ClassName,
                                       val = Class.ClassId
                                   }).ToList();

            return Json(lfltrClasses);
        }       

        #endregion

        #region Question        
        [HttpGet]
        
        public IActionResult Question(int questionId, string title)
        {
            int lintUserId = HttpContext.Session.GetInt32("UserId") ?? 0;
            QuestionViewModel questionViewModel = new QuestionViewModel();

            using (var unitOfWork = new UnitOfWork(new CuriousDriveContext()))
            {
                Question question = unitOfWork.Questions.GetQuestionDetails(questionId);

                questionViewModel.questionId = question.QuestionId;
                questionViewModel.questionTitle = question.QuestionTitle;
                questionViewModel.questionHtml = question.QuestionHtml;
                questionViewModel.createdDate = question.CreatedDate;              

                questionViewModel.userDetailsViewModel = new UserDetailsViewModel();

                questionViewModel.userDetailsViewModel.userId = question.User.UserId;
                questionViewModel.userDetailsViewModel.displayName = question.User.DisplayName;
                questionViewModel.userDetailsViewModel.urlTitle = Utility.GetURLTitle(question.User.DisplayName);

                questionViewModel.userDetailsViewModel.profilePictureViewModel = new ProfilePictureViewModel();

                questionViewModel.userTagListViewModel = new List<UserTagViewModel>();

                foreach (Tag tag in question.Tag)
                {
                    foreach (TagDetail tagDetail in tag.TagDetail)
                    {
                        UserTagViewModel userTagViewModel = new UserTagViewModel();

                        userTagViewModel.userId = tagDetail.TaggedUser.UserId;
                        userTagViewModel.userTag = tagDetail.TaggedUser.DisplayName;

                        questionViewModel.userTagListViewModel.Add(userTagViewModel);

                    }
                }

                questionViewModel.commentsViewModel = new List<CommentViewModel>();

                foreach (Comment comment in question.Comment)
                {
                    CommentViewModel commentViewModel = new CommentViewModel();

                    commentViewModel.commentId = comment.CommentId;
                    commentViewModel.commentHtml = comment.CommentHtml;
                    commentViewModel.userId = comment.User.UserId;
                    commentViewModel.displayName = comment.User.DisplayName;
                    commentViewModel.urlTitle = Utility.GetURLTitle(comment.User.DisplayName);

                    questionViewModel.commentsViewModel.Add(commentViewModel);
                }

                questionViewModel.questionAnswersViewModel = new List<QuestionAnswerViewModel>();

                foreach (QuestionAnswer questionAnswer in question.QuestionAnswer)
                {
                    QuestionAnswerViewModel questionAnswerViewModel = new QuestionAnswerViewModel();

                    questionAnswerViewModel.questionId = question.QuestionId;
                    questionAnswerViewModel.questionAnswerId = questionAnswer.QuestionAnswerId;
                    questionAnswerViewModel.answerHtml = questionAnswer.AnswerHtml;
                    questionAnswerViewModel.createdDate = questionAnswer.CreatedDate;

                    questionAnswerViewModel.commentsViewModel = new List<CommentViewModel>();

                    foreach (Comment comment in questionAnswer.Comment)
                    {
                        CommentViewModel commentViewModel = new CommentViewModel();

                        commentViewModel.commentId = comment.CommentId;
                        commentViewModel.commentHtml = comment.CommentHtml;
                        commentViewModel.userId = comment.User.UserId;
                        commentViewModel.displayName = comment.User.DisplayName;
                        commentViewModel.urlTitle = Utility.GetURLTitle(comment.User.DisplayName);

                        questionAnswerViewModel.commentsViewModel.Add(commentViewModel);

                    }

                    questionAnswerViewModel.userDetailsViewModel = new UserDetailsViewModel();

                    questionAnswerViewModel.userDetailsViewModel.userId = questionAnswer.UserId;
                    questionAnswerViewModel.userDetailsViewModel.displayName = questionAnswer.User.DisplayName;
                    questionAnswerViewModel.userDetailsViewModel.urlTitle = Utility.GetURLTitle(questionAnswer.User.DisplayName);

                    questionAnswerViewModel.userDetailsViewModel.profilePictureViewModel = new ProfilePictureViewModel();

                    questionViewModel.questionAnswersViewModel.Add(questionAnswerViewModel);

                }

                questionViewModel.questionClassesViewModel = new List<QuestionClassViewModel>();

                foreach (QuestionClass questionClass in question.QuestionClass)
                {
                    QuestionClassViewModel questionClassViewModel = new QuestionClassViewModel();

                    questionClassViewModel.classId = questionClass.ClassId;
                    questionClassViewModel.className = questionClass.Class.ClassName;

                    questionViewModel.questionClassesViewModel.Add(questionClassViewModel);
                }
            }     
            
            return View(questionViewModel);
        }
                
        [HttpPost]
        
        public IActionResult Question(QuestionViewModel questionViewModel, string submitType)
        {
            using (var unitOfWork = new UnitOfWork(new CuriousDriveContext()))
            {
                int questionAnswerId = 0;

                Comment comment = null;
                PostVote postVote = null;
                QuestionAnswer questionAnswer = null;

                string lstrQuestionAnswerHtml = string.Empty;
                List<Message> llstMessages = new List<Message>();

                int userId = HttpContext.Session.GetInt32("UserId") ?? 0;

                if (submitType.Contains(Constant.UpdateQuestionAnswer))
                {
                    questionAnswerId = Convert.ToInt32(submitType.Substring(Constant.UpdateQuestionAnswer.Length));
                    submitType = submitType.Substring(0, Constant.UpdateQuestionAnswer.Length);
                }
                else if (submitType.Contains(Constant.DeleteQuestionAnswer))
                {
                    questionAnswerId = Convert.ToInt32(submitType.Substring(Constant.DeleteQuestionAnswer.Length));
                    submitType = submitType.Substring(0, Constant.DeleteQuestionAnswer.Length);
                }
                else if (submitType.Contains(Constant.PostQuestionAnswerVoteUp))
                {
                    questionAnswerId = Convert.ToInt32(submitType.Substring(Constant.PostQuestionAnswerVoteUp.Length));
                    submitType = submitType.Substring(0, Constant.PostQuestionAnswerVoteUp.Length);
                }
                else if (submitType.Contains(Constant.PostQuestionAnswerVoteDown))
                {
                    questionAnswerId = Convert.ToInt32(submitType.Substring(Constant.PostQuestionAnswerVoteDown.Length));
                    submitType = submitType.Substring(0, Constant.PostQuestionAnswerVoteDown.Length);
                }

                switch (submitType)
                {
                    case "PostQuestionComment":
                        comment = new Comment();
                        comment.QuestionId = questionViewModel.questionId;
                        comment.CommentHtml = questionViewModel.questionComment;
                        comment.UserId = userId;
                        comment.CreatedBy = comment.ModifiedBy = userId;

                        unitOfWork.Comments.Add(comment);
                        break;

                    case "PostQuestionAnswer":
                        questionAnswer = new QuestionAnswer();

                        questionAnswer.QuestionId = questionViewModel.questionId;
                        questionAnswer.AnswerHtml = questionViewModel.questionAnswerHtml;
                        questionAnswer.UserId = userId;
                        questionAnswer.CreatedBy = questionAnswer.ModifiedBy = userId;

                        unitOfWork.QuestionAnswers.Add(questionAnswer);

                        break;

                    case "PostQuestionAnswerComment":
                        comment = new Comment();
                        comment.QuestionAnswerId = questionViewModel.questionAnswersViewModel.Where(qa => qa.questionAnswerComment != null).FirstOrDefault().questionAnswerId;
                        comment.CommentHtml = questionViewModel.questionAnswersViewModel.Where(qa => qa.questionAnswerComment != null).FirstOrDefault().questionAnswerComment;
                        comment.UserId = userId;
                        comment.CreatedBy = comment.ModifiedBy = userId;

                        unitOfWork.Comments.Add(comment);

                        break;

                    case "UpdateQuestion":
                        
                        break;

                    case "UpdateQuestionAnswer":
                        questionAnswer = new QuestionAnswer();//aQuestion.ilstQuestionAnswer.Where(lQuestionAns => lQuestionAns.idoQuestionAnswer.questionAnswerId == lintQuestionAnswerId).FirstOrDefault();
                        
                        break;

                    case "PostQuestionVoteUp":
                        postVote = new PostVote();//VotesService().InsertVote(aQuestion.idoQuestion.questionId, Constant.PostTypeQuestion, Constant.VoteTypeUp, aQuestion.idoQuestion.questionId, lintUserId);
                        
                        break;

                    case "PostQuestionVoteDown":
                        postVote = new PostVote();//VotesService().InsertVote(aQuestion.idoQuestion.questionId, Constant.PostTypeQuestion, Constant.VoteTypeDown, aQuestion.idoQuestion.questionId, lintUserId);
                        
                        break;

                    case "PostQuestionAnswerVoteUp":
                        postVote = new PostVote();//VotesService().InsertVote(aQuestion.idoQuestion.questionId, Constant.PostTypeAnswer, Constant.VoteTypeUp, lintQuestionAnswerId, lintUserId);
                        
                        break;

                    case "PostQuestionAnswerVoteDown":
                        postVote = new PostVote();//VotesService().InsertVote(aQuestion.idoQuestion.questionId, Constant.PostTypeAnswer, Constant.VoteTypeDown, lintQuestionAnswerId, lintUserId);
                        
                        break;

                    default:
                        break;
                }

                ModelState.Clear();

                unitOfWork.Complete();

                return RedirectToAction("Question", new { questionId = questionViewModel.questionId, title = "" });
            }
            
        }

        private void InsertQuestionView(int questionId, int userId)
        {
            string lstrIPAddress = ""; // new Security().GetIPAddress();
            String userAgent = Request.Headers["User-Agent"];
            string lstrBrowser = "";//Request.Browser.Browser + '-' + Request.Browser.Version;

            //new QuestionService().InsertQuestionView(aintQuestionId, aintUserId, lstrIPAddress, lstrBrowser);
        }

        public IActionResult DeleteQuestionAnswer(int questionAnswerId, int questionId)
        {
            using (var unitOfWork = new UnitOfWork(new CuriousDriveContext()))
            {
                QuestionAnswer questionAnswer = unitOfWork.QuestionAnswers.Get(questionAnswerId);
                List<Comment> comments = unitOfWork.Comments.Find(comment => comment.QuestionAnswerId == questionAnswerId).ToList();

                unitOfWork.QuestionAnswers.Remove(questionAnswer);
                unitOfWork.Comments.RemoveRange(comments);

                unitOfWork.Complete();
            }

            return RedirectToAction("Question", "Question", new { id = questionId });
        }

        public IActionResult DeleteQuestion(int questionId)
        {
            using (var unitOfWork = new UnitOfWork(new CuriousDriveContext()))
            {
                Question question = unitOfWork.Questions.Get(questionId);
                List<Comment> comments = unitOfWork.Comments.Find(comment => comment.QuestionId == questionId).ToList();
                List<QuestionAnswer> questionAnswers = unitOfWork.QuestionAnswers.Find(questionAnswer => questionAnswer.QuestionId == questionId).ToList();
                List<Tag> tags = unitOfWork.Tags.Find(tag => tag.QuestionId == questionId).ToList();
                List<TagDetail> tagDetails = new List<TagDetail>();

                foreach (QuestionAnswer questionAnswerIn in questionAnswers)
                    comments.AddRange(unitOfWork.Comments.Find(comment => comment.QuestionAnswerId == questionAnswerIn.QuestionAnswerId).ToList());

                foreach (Tag tag in tags)
                    tagDetails.AddRange(unitOfWork.TagDetails.Find(tagDetail => tagDetail.TagId == tag.TagId).ToList());


                unitOfWork.Questions.Remove(question);
                unitOfWork.QuestionAnswers.RemoveRange(questionAnswers);
                unitOfWork.Comments.RemoveRange(comments);
                unitOfWork.Tags.RemoveRange(tags);
                unitOfWork.TagDetails.RemoveRange(tagDetails);

                unitOfWork.Complete();
            }
            return RedirectToAction("Questions","Question");
        }

        #endregion

    }
}
