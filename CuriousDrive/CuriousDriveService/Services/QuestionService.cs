using System.Collections.Generic;
using CuriousDriveService.Models;
using CuriousDriveService.Global;

namespace CuriousDriveService
{
    public class QuestionService
    {
        busRestService ibusRestService = null;
        string modularUrl = "/questions";

        public busQuestion InsertQuestion(busQuestion abusQuestion)
        {
            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/questions";
            return ibusRestService.Post<busQuestion>(modularUrl, abusQuestion);
        }

        public busQuestion UpdateQuestion(busQuestion abusQuestion)
        {
            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/questions/";
            modularUrl = modularUrl + abusQuestion.idoQuestion.questionId;

            return ibusRestService.Post<busQuestion>(modularUrl, abusQuestion);
        }

        public busClass InsertQuestionCategory(busQuestionClass abusQuestionCategory)
        {
            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/questionCategorys";

            return ibusRestService.Post<busClass>(modularUrl, abusQuestionCategory);
        }

        public busComment InsertComment(busComment abusComment)
        {
            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/comments";

            return ibusRestService.Post<busComment>(modularUrl, abusComment);
        }

        public busQuestionAnswer InsertQuestionAnswer(busQuestionAnswer abusQuestionAnswer)
        {
            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/questionAnswers";

            return ibusRestService.Post<busQuestionAnswer>(modularUrl, abusQuestionAnswer);
        }

        public busQuesitonView InsertQuestionView(int aintQuestionId, int aintUserId, string astrIPAddress, string astrBrowser)
        {
            busQuesitonView lbusQuesitonView = new busQuesitonView { idoQuestionView = new doQuestionView() } ;
            lbusQuesitonView.idoQuestionView.browser = astrBrowser;
            lbusQuesitonView.idoQuestionView.ipAddress = astrIPAddress;
            lbusQuesitonView.idoQuestionView.questionId = aintQuestionId;
            lbusQuesitonView.idoQuestionView.userId = aintUserId;

            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/questionViews";

            return ibusRestService.Post<busQuesitonView>(modularUrl, lbusQuesitonView);
        }

        public busQuestionAnswer UpdateQuestionAnswer(busQuestionAnswer abusQuestionAnswer)
        {
            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/questionAnswers/";
            modularUrl = modularUrl + abusQuestionAnswer.idoQuestionAnswer.questionAnswerId;

            return ibusRestService.Post<busQuestionAnswer>(modularUrl, abusQuestionAnswer);
        }

        public List<busQuestion> GetQuestions(string astrType)
        {
            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/questions/getQuestionsByThread";
            modularUrl = modularUrl + "?astrType=" + astrType;

            return ibusRestService.GetList<busQuestion>(modularUrl);
        }

        public List<busQuestion> GetQuestions()
        {
            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/questions";

            return ibusRestService.GetList<busQuestion>(modularUrl);
        }

        public busQuestion GetQuestionDetails(int aintQuestionId, int aintLoggedInUserId)
        {
            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/getQuestionDetails";
            modularUrl = modularUrl + "?aintQuestionId=" + aintQuestionId + "&aintLoggedInUserId=" + aintLoggedInUserId;

            return ibusRestService.Get<busQuestion>(modularUrl);
        }

        public busQuestion GetQuestion(int aintQuestionId)
        {
            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/getQuestion";
            modularUrl = modularUrl + "?aintQuestionId=" + aintQuestionId;

            return ibusRestService.Get<busQuestion>(modularUrl);
        }

        public busMessage DeleteQuestion(int aintQuestionId)
        {
            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/questions/";
            modularUrl = modularUrl + aintQuestionId;

            return ibusRestService.Delete<busMessage>(modularUrl);
        }

        public busMessage DeleteQuestionAnswer(int aintQuestionAnswerId)
        {
            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/questionAnswers/";
            modularUrl = modularUrl + aintQuestionAnswerId;

            return ibusRestService.Delete<busMessage>(modularUrl);
        }

        public busComment InsertComment(string astrCommentType, string astrComment, int aintSubsystemReferenceId, int aintUserId)
        {
            busComment lbusComment = new busComment { idoComment = new doComment() };

            lbusComment.idoComment.subsystemId = busConstant.PostType;
            lbusComment.idoComment.commentHtml = astrComment;
            lbusComment.idoComment.subsystemReferenceId = aintSubsystemReferenceId;
            lbusComment.idoComment.subsystemValue = astrCommentType;
            lbusComment.idoComment.iintUserId = aintUserId;
            lbusComment.idoComment.userId = aintUserId;

            return this.InsertComment(lbusComment);
        }

        public busQuestionAnswer InsertQuestionAnswer(int aintQuestionId, string astrQuestionAnswerHtml, int aintUserId)
        {
            busQuestionAnswer lbusQuestionAnswer = new busQuestionAnswer { idoQuestionAnswer = new doQuestionAnswer() };

            lbusQuestionAnswer.idoQuestionAnswer.questionId = aintQuestionId;
            lbusQuestionAnswer.idoQuestionAnswer.answerHtml = astrQuestionAnswerHtml;
            lbusQuestionAnswer.idoQuestionAnswer.iintUserId = aintUserId;

            return this.InsertQuestionAnswer(lbusQuestionAnswer);
        }

        public void UpdateQuestion(busQuestion abusQuestion, int aintUserId)
        {
            abusQuestion.idoQuestion.iintUserId = aintUserId;

            this.UpdateQuestion(abusQuestion);
        }

        public void UpdateQuestionAnswer(busQuestionAnswer abusQuestionAnswer, int aintUserId)
        {
            abusQuestionAnswer.idoQuestionAnswer.iintUserId = aintUserId;

            this.UpdateQuestionAnswer(abusQuestionAnswer);
        }
    }
}

