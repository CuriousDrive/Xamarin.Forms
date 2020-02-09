using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.IO;
using CuriousDriveWebClient.Attributes;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Http;
using CuriousDriveWebAPI.CuriousDrive.UnitsOfWork;
using CuriousDriveWebAPI.CuriousDrive.Models;
using CuriousDriveWebClient.Models;
using Newtonsoft.Json.Linq;
using CuriousDriveWebAPI.CuriousDrive;

namespace CuriousDriveWebClient.Controllers
{
    public class UserProfileController : Controller
    { 
        #region UserProfile

        // GET: UserProfile
        
        public IActionResult UserProfile(int id)
        {
            UserProfileViewModel userProfileViewModel = new UserProfileViewModel();

            using (var unitOfWork = new UnitOfWork(new CuriousDriveContext()))
            {
                User user = unitOfWork.Users.Get(id);

                userProfileViewModel.displayName = user.DisplayName;
                userProfileViewModel.pictureUrl = user.PictureUrl;
                userProfileViewModel.networkValue = user.NetworkValue;
                userProfileViewModel.occupation = user.Occupation;
                userProfileViewModel.aboutMe = user.AboutMe;
                userProfileViewModel.facebookUrl = user.FacebookUrl;
                userProfileViewModel.twitterUrl = user.TwitterUrl;
                userProfileViewModel.instagramUrl = user.InstagramUrl;

                userProfileViewModel.newsFeedsViewModel = new List<NewsFeedViewModel>();

                

            }
            
            return View(userProfileViewModel);
        }

        
        [HttpPost]
        public PartialViewResult DisplayUserProfileDetails(string detailType, int userId)
        {
            if (detailType == "Questions")
            {
                List<Question> llstUserQuestions = new List<Question>();//UserService().GetUserQuestions(aintUserId);
                return PartialView("_UserQuestionsList", llstUserQuestions);
            }
            else if (detailType == "Answers")
            {
                List<QuestionAnswer> llstUserQuestionAnswers = new List<QuestionAnswer>();//UserService().GetUserQuestionAnswers(aintUserId);
                return PartialView("_UserQuestionAnswersList", llstUserQuestionAnswers);
            }
            else
            {
                List<Comment> llstUserComments = new List<Comment>();//UserService().GetUserComments(aintUserId);
                return PartialView("_UserCommentsList", llstUserComments);
            }

            //return null;
        }

        #endregion

        #region AccountSettings

        [HttpGet]
        
        
        public IActionResult AccountSettings(int id)
        {
            int lintUserId = HttpContext.Session.GetInt32("UserId") ?? 0;
            //UserService userService = new UserService();
            User lUser = new User();//userService.GetUserProfile(id, lintUserId);

            return View(lUser);
        }

        [HttpPost]
        
        public IActionResult AccountSettings(AccountSettingsViewModel accountSettingsViewModel)
        {
            int lintUserId = HttpContext.Session.GetInt32("UserId") ?? 0;
            //UserService userService = new UserService();
            User lReturnedUser = new User();//userService.UpdateUserProfile(aUser);

            //if (lReturnedUser.ilstMessages != null && !lReturnedUser.ilstMessages.Any(lMessage => lMessage.idoMessage.severityValue == "ERRR"))
            //{
            //    ViewData[Constant.ValidationMessages] = lReturnedUser.ilstMessages;
            //    return RedirectToAction("AccountSettings");
            //}
            //else
            //{
            //    return View(lReturnedUser);
            //}
            return View(lReturnedUser);
        }

        public void RenderImage(string filepath)
        {
            if (filepath != null)
            {
                try
                {
                    filepath = "C:\\CuriousDrive\\Files" + filepath;
                    string contenttype = "image/" + Path.GetExtension(filepath);
                    FileStream fs = new FileStream(filepath, FileMode.Open, FileAccess.Read);
                    BinaryReader br = new BinaryReader(fs);
                    Byte[] bytes = br.ReadBytes((Int32)fs.Length);
                    br.Close();
                    fs.Close();

                    //Write the file to response Stream
                    //Response.Buffer = true;
                    //Response.Charset = "";
                    //Response.Cache.SetCacheability(HttpCacheability.NoCache);
                    //Response.ContentType = contenttype;
                    //Response.AddHeader("content-disposition", "attachment;filename=" + Path.GetFileName(filepath));
                    //Response.BinaryWrite(bytes);
                    //Response.Flush();
                    //Response.End();
                }
                catch (Exception ex)
                {
                    Console.WriteLine(ex.Message);
                }
            }
        }

        #endregion

        #region UploadProfilePicture

        [HttpGet]
        
        public IActionResult UploadProfilePicture(int id)
        {
            return View();
        }

        [HttpPost]
        public IActionResult UploadProfilePicture(String aHttpPostedFileBase)
        {
            string lstrUserId = (string)this.RouteData.Values["id"];

            //if (aHttpPostedFileBase.ContentLength > 0)
            //{
            //    var path = Path.Combine(Server.MapPath("~/Content/Temp"), "pp_" + lstrUserId + ".jpg");
            //    new UserService().UpdateUserProfilePicture(Convert.ToInt32(lstrUserId));
            //    aHttpPostedFileBase.SaveAs(path);
            //}

            return RedirectToAction("AccountSettings", new { id = lstrUserId });
        }

        #endregion

        #region Users

        [HttpGet]        
        public IActionResult Users()
        {
            return View();
        }

        [HttpPost]
        public PartialViewResult DisplayUsersList([FromBody] JObject jObject)
        {
            using (var unitOfWork = new UnitOfWork(new CuriousDriveContext()))
            {
                string prefix = (string)jObject.SelectToken("prefix");

                List<User> users = unitOfWork.Users.GetUsersByPrefix(prefix);

                List<UserProfileCardViewModel> userProfileCardsViewModel = new List<UserProfileCardViewModel>();

                foreach (User user in users)
                {
                    UserProfileCardViewModel userProfileCardViewModel = new UserProfileCardViewModel();

                    userProfileCardViewModel.userId = user.UserId;
                    userProfileCardViewModel.displayName = user.DisplayName;
                    userProfileCardViewModel.urlTitle = Utility.GetURLTitle(user.DisplayName);

                    userProfileCardViewModel.profilePictureViewModel = new ProfilePictureViewModel();

                    userProfileCardsViewModel.Add(userProfileCardViewModel);
                }

                return PartialView("_UsersList", userProfileCardsViewModel);
            }                
        }

        #endregion

        #region Notifications

        [HttpGet]
        
        public IActionResult Notifications()
        {
            int lintUserId = HttpContext.Session.GetInt32("UserId") ?? 0;
            List<Notification> llstNotifications = new List<Notification>();//UserService().GetUserNotifications(lintUserId);

            //new UserService().UpdateUserNotifications(lintUserId);

            return View(llstNotifications);
        }

        [HttpPost]
        public PartialViewResult DisplayNotificationCount(int userId)
        {
            List<Notification> llstNotifications = new List<Notification>();//UserService().GetUserNotifications(aintUserId);
            int lintNotificationCount = 0;
            if (llstNotifications != null && llstNotifications.Count() > 0)
                lintNotificationCount = llstNotifications.Where(lNotification => lNotification.IsRead == "N").Count();

            return PartialView("_NotificationCount", lintNotificationCount);
        }

        #endregion
    }
}