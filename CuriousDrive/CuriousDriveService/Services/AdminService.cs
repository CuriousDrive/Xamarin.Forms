using System;
using CuriousDriveService.Models;
using System.Collections.Generic;
using CuriousDriveService.Global;

namespace CuriousDriveService
{
    public class AdminService
    {
        busRestService ibusRestService = null;
        string modularUrl = "/admin";

        public busClass CreateClass(busClass abusClass)
        {
            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/classes";

            return ibusRestService.Post<busClass>(modularUrl, abusClass);
        }

        public busMessage GetMessage(int aintMessageId)
        {
            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/messages/getMessage/" + aintMessageId;

            return ibusRestService.Get<busMessage>(modularUrl);
        }

        public busMessage DeleteClass(int aintClassId)
        {
            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/classes/";
            modularUrl = modularUrl + aintClassId;

            return ibusRestService.Delete<busMessage>(modularUrl);
        }

        public busMessage DeleteUserGroupDeails(int aintUserGroupDetailId)
        {
            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/classes/";
            modularUrl = modularUrl + aintUserGroupDetailId;

            return ibusRestService.Delete<busMessage>(modularUrl);
        }

        public busFeedback loadVerifiedFeedbacks()
        {
            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/feedbacks/loadVerifiedFeedbacks/";

            return ibusRestService.Get<busFeedback>(modularUrl);
        }

        public busFeedback loadFeedbacksToVerify()
        {
            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/feedbacks/loadFeedbacksToVerify";

            return ibusRestService.Get<busFeedback>(modularUrl);
        }

        public busFeedback InsertFeedback(string astrFeedback, int aintUserId = 0)
        {
            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/feedbacks";

            busFeedback lbusFeedback = new busFeedback()  { idoFeedback = new doFeedback() } ;
            lbusFeedback.idoFeedback.userId = aintUserId;
            lbusFeedback.idoFeedback.feedback = astrFeedback;
            lbusFeedback.idoFeedback.iintUserId = aintUserId;

            return ibusRestService.Post<busFeedback>(modularUrl, lbusFeedback);
        }

        public busFeedback InsertFeedback(busFeedback abusFeedback)
        {
            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/feedbacks";

            return ibusRestService.Post<busFeedback>(modularUrl, abusFeedback);
        }

        public busUserGroup CreateUserGroup(busUserGroup abusUserGroup)
        {
            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/userGroups";

            return ibusRestService.Post<busUserGroup>(modularUrl, abusUserGroup);
        }

        public busUserGroup UpdateUserGroup(busUserGroup abusUserGroup)
        {
            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/userGroups/";
            modularUrl = modularUrl + abusUserGroup.idoUserGroup.userGroupId;

            return ibusRestService.Post<busUserGroup>(modularUrl, abusUserGroup);
        }

        public List<busUserGroup> GetUserGroupsByName(string astrSearchTerm)
        {
            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/getUserGroupsByName?astrSearchTerm=" + astrSearchTerm;

            return ibusRestService.GetList<busUserGroup>(modularUrl);
        }

        public busUserGroup GetUserGroup(int aintUserGroupId)
        {
            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/userGroups/" + aintUserGroupId;

            return ibusRestService.Get<busUserGroup>(modularUrl);
        }

        public List<busUserGroup> GetActiveUserGroups()
        {
            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/getActiveUserGroups";

            return ibusRestService.GetList<busUserGroup>(modularUrl);
        }

        public busClass UpdateClass(busClass abusClass)
        {
            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/classes/";
            modularUrl = modularUrl + abusClass.idoClass.classId;

            return ibusRestService.Post<busClass>(modularUrl, abusClass);
        }

        public busMessage DeleteFeedback(int aintFeedbackId)
        {
            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/feedbacks/";
            modularUrl = modularUrl + aintFeedbackId;

            return ibusRestService.Delete<busMessage>(modularUrl);
        }

        public List<busClass> GetClasses()
        {
            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/classes/getClasses";

            return ibusRestService.GetList<busClass>(modularUrl);
        }

        public List<object> GetThreads()
        {
            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/getApprovedThreads";

            return ibusRestService.GetList<object>(modularUrl);
        }

        public string GetThreadId(string astrThread)
        {
            if (astrThread.Contains("cosmology"))
                return busConstant.CosmologyThreadId;
            else if (astrThread.Contains("religion"))
                return busConstant.ReligionThreadId;

            return string.Empty;

        }

        public List<object> GetConstants(string astrCodeValue)
        {
            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/codeValues/getConstants";
            modularUrl = modularUrl + "?codeValue=" + astrCodeValue;

            return ibusRestService.GetList<object>(modularUrl);
        }

        public List<busCodeValue> GetCodeValues(int aintCodeId)
        {
            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/codeValues/getCodeValues/" + aintCodeId;

            return ibusRestService.GetList<busCodeValue>(modularUrl);
        }

        public busClass UpdateFeedback(busFeedback abusFeedback)
        {
            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/feedbacks/";
            modularUrl = modularUrl + abusFeedback.idoFeedback.feedbackId;

            return ibusRestService.Post<busClass>(modularUrl, abusFeedback);
        }

        public object InsertThread(object abusThread)
        {
            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/threads/";

            return ibusRestService.Post<object>(modularUrl, abusThread);
        }

        public List<object> GetGoogleClientId()
        {
            if (busConstant.Region == "DEV")
                return this.GetConstants(busConstant.GoogleClientIdLOC);
            if (busConstant.Region == "SYS")
                return this.GetConstants(busConstant.GoogleClientIdSYS);
            if (busConstant.Region == "UAT")
                return this.GetConstants(busConstant.GoogleClientIdUAT);

            return null;
        }

        public List<object> GetGoogleAPIKey()
        {
            if (busConstant.Region == "DEV")
                return this.GetConstants(busConstant.GoogleAPIKeyLOC);
            if (busConstant.Region == "SYS")
                return this.GetConstants(busConstant.GoogleAPIKeySYS);
            if (busConstant.Region == "UAT")
                return this.GetConstants(busConstant.GoogleAPIKeyUAT);

            return null;
        }

        public object SendBookADemoEmail(string astrEmailAddress)
        {
            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/bookADemo?astrEmailAddress=" + astrEmailAddress;

            return ibusRestService.Get<object>(modularUrl);
        }

        public object SendContactUsEmail(string astrName,string astrEmailAddress,string astrSubject, string astrTelNumber, string astrComments)
        {
            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/dropUsAMessage?astrName=" + astrName + "&astrEmailAddress=" + astrEmailAddress + "&astrSubject=" + astrSubject + "&astrTelNumber=" + astrTelNumber + "&astrComments=" + astrComments;

            return ibusRestService.Get<object>(modularUrl);
        }

        
    }
}