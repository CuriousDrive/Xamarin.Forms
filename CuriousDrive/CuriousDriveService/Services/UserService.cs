using System;
using System.Security.Cryptography;
using System.Collections.Generic;
using CuriousDriveService.Models;
using CuriousDriveService.Global;
using System.Linq;

namespace CuriousDriveService
{
	public class UserService
	{
		busRestService ibusRestService = null;
		string modularUrl = "/users";

		public busUser EnrollUser(busUser abusUser)
		{

			ibusRestService = new busRestService ();
			modularUrl = modularUrl + "/enrollUser";

			return ibusRestService.Post<busUser>(modularUrl,abusUser);
		}

        public busUser RegisterOrLoginSocialUser(busUser abusUser)
        {

            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/registerOrLoginSocialUser";

            return ibusRestService.Post<busUser>(modularUrl, abusUser);
        }

        public busUser ForgotPassword(busUser abusUser)
		{
			ibusRestService = new busRestService ();
			modularUrl = modularUrl + "/forgotPassword";

			return ibusRestService.Post<busUser>(modularUrl,abusUser);
		}

		public busUser ValidateUser(busUser abusUser)
		{
			ibusRestService = new busRestService ();
			modularUrl = modularUrl + "/validateUser";

			return ibusRestService.Post<busUser>(modularUrl, abusUser);
		}

		public busUser GetUserProfile(int aintUserId,int aintLoggedInUserId)
		{
			ibusRestService = new busRestService ();
			modularUrl = modularUrl + "/user/getUserProfile";
			modularUrl = modularUrl + "?aintUserId=" + aintUserId + "&aintLoggedInUserId=" + aintLoggedInUserId;

			return ibusRestService.Get<busUser>(modularUrl);
		}

        public List<busUser> GetUsers(string astrSearchTerm, string astrIsAutocomplete, string astrRole)
        {
            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/user/getUsers/" + astrRole + "?astrSearchTerm=" + astrSearchTerm + "&astrIsAutocomplete=" + astrIsAutocomplete;

            return ibusRestService.GetList<busUser>(modularUrl);
        }

        public dynamic GetAutocompleteList(string astrSearchTerm, string astrRole)
        {
            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/user/getAutocompleteList/" + astrRole + "?astrSearchTerm=" + astrSearchTerm;

            List<busAutocompleteListItem> llstbusAutocompleListItem =  ibusRestService.GetList<busAutocompleteListItem>(modularUrl);

            var lfltrbusUsers = (from lbusAutocompleListItem in llstbusAutocompleListItem
                                 select new
                                 {
                                     label = lbusAutocompleListItem.istrLabel,
                                     val = lbusAutocompleListItem.istrUserGroupType + "$" + lbusAutocompleListItem.istrValue
                                 }).ToList();

            return lfltrbusUsers;

        }

        public List<busQuestion> GetUserQuestions(int aintUserId)
        {
            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/user/getUserQuestions/" + aintUserId;

            return ibusRestService.GetList<busQuestion>(modularUrl);
        }

        public List<busQuestionAnswer> GetUserQuestionAnswers(int aintUserId)
        {
            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/user/getUserQuestionAnswers/" + aintUserId;
          
            return ibusRestService.GetList<busQuestionAnswer>(modularUrl);
        }

        public List<busComment> GetUserComments(int aintUserId)
        {
            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/user/getUserComments/" + aintUserId;
            
            return ibusRestService.GetList<busComment>(modularUrl);
        }

        public List<busNotification> GetUserNotifications(int aintUserId)
        {
            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/user/getUserNotifications/" + aintUserId;

            return ibusRestService.GetList<busNotification>(modularUrl);
        }

        public void UpdateUserNotifications(int aintUserId)
        {
            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/user/updateUserNotifications/" + aintUserId;

            ibusRestService.Post<busNotification>(modularUrl,null);
        }

        public List<busRole> GetRoles()
        {
            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/user/getRoles";

            return ibusRestService.GetList<busRole>(modularUrl);
        }

        public busUser UpdateUserProfile(busUser abusUser)
		{
			ibusRestService = new busRestService ();
			modularUrl = modularUrl + "/user/updateUserProfile";

			return ibusRestService.Post<busUser>(modularUrl, abusUser);
		}

        public busUser UpdateUserProfilePicture(int aintUserId)
        {
            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/user/updateUserProfilePicture/" + aintUserId;

            return ibusRestService.Post<busUser>(modularUrl, null);
        }

        public busUser Enroll(busUser abusUser)
        {
            busUser lbusUser = null;

            abusUser.idoUser.networkId = 1;

            if (abusUser.idoUser.networkValue == null)
                abusUser.idoUser.networkValue = busConstant.ApplicationNetwork;

            abusUser.idoUser.networkUserId = abusUser.idoUser.emailAddress;

            abusUser.idoUser.displayName = abusUser.idoUser.firstName + " " + abusUser.idoUser.lastName;
            abusUser.idoUser.birthDate = "";
            abusUser.idoUser.iintUserId = 1;

            UserService userService = new UserService();
            if (abusUser.idoUser.networkValue == busConstant.ApplicationNetwork)
                lbusUser = userService.EnrollUser(abusUser);
            else
                lbusUser = userService.RegisterOrLoginSocialUser(abusUser);

            return lbusUser;
        }

        public busUser GetUserByEmailAndOTP(busUser abusUser)
        {
            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/getUserByEmailAndOTP";

            return ibusRestService.Post<busUser>(modularUrl, abusUser);
        }

        public busUser SetNewPassword(busUser abusUser)
        {
            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/setNewPassword";

            return ibusRestService.Post<busUser>(modularUrl, abusUser);
        }

        public string GetSaltValue(string astrEmailAddress)
        {
            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/getSaltValue?astrEmailAddress=" + astrEmailAddress;

            return ibusRestService.Get<string>(modularUrl);
        }
    }
}

