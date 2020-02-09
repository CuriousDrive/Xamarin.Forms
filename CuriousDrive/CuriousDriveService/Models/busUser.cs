using CuriousDriveService.Global;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;
using System.Web;

namespace CuriousDriveService.Models
{
	public class doUser
	{
		public object istrMode { get; set; }
		public int iintUserId { get; set; }
		public int userId { get; set; }
		public string aboutMe { get; set; }
		public string birthDate { get; set; }
		public int createdBy { get; set; }
		public string createdDate { get; set; }
		public string displayName { get; set; }
		public string emailAddress { get; set; }
		public string facebookUrl { get; set; }
        public string instagramUrl { get; set; }
        public string firstName { get; set; }
		public int genderId { get; set; }
		public string genderValue { get; set; }
		public string interests { get; set; }
		public string lastName { get; set; }
		public int modifiedBy { get; set; }
		public string modifiedDate { get; set; }
		public int networkId { get; set; }
		public string networkUserId { get; set; }
		public string networkValue { get; set; }
		public string occupation { get; set; }
        public string saltValue { get; set; }
        public string password { get; set; }
        public string otp { get; set; }
        public string isUserVerified { get; set; }
        public string isPasswordForgotten { get; set; }
        public int userStatusId { get; set; }
        public string userStatusValue { get; set; }
        public string phoneNumber { get; set; }
		public string pictureUrl { get; set; }
		public string twitterUrl { get; set; }
		public int updateSeq { get; set; }
		public string websiteUrl { get; set; }
	}

	public class busUser : busBase
    {        
        public doUser idoUser { get; set; }
        public busUserRole ibusUserRole { get; set; }
        public List<busNewsFeed> ilstbusNewsFeed { get; set; }
        public string istrRoleValue { get; set; }
        public string istrUserGroupValue { get; set; }
        public string istrURLTitle { get; set; }
        public string istrCurrentLevel { get; set; }
        public string istrNextLevel { get; set; }
        public string istrPlainOtp { get; set; }
        public string istrEmailVerificationCode { get; set; }
        public string istrRetypePassword { get; set; }
        public int iintLevelCompletionPercentage { get; set; }
        public int iintTotalPoint { get; set; }
        public int iintCurrentLevelPoints { get; set; }
        public int iintNextLevelPoints { get; set; }

        public bool ValidateNewPassword()
        {
            IsPasswordEntered();
            DoesRetypedPasswordMatch();
            ArePasswordGuidenceFollowed();

            if (this.ilstbusMessages.Count() > 0)
                return false;
            else
                return true;

        }

        private void ArePasswordGuidenceFollowed()
        {
            if (this.idoUser.password != null && this.idoUser.password != string.Empty && this.idoUser.password == this.istrRetypePassword)
            {
                if (this.idoUser.password.Length < 8)
                    this.AddMessage(busConstant.IsPasswordLongerThan8Characters);

                if (Regex.Matches(this.idoUser.password, "[a-zA-Z]").Count == 0)
                    this.AddMessage(busConstant.PasswordMustContainLetters);

                if (!this.idoUser.password.Any(password => char.IsDigit(password)))
                    this.AddMessage(busConstant.PasswordMustContainAtleastOneNumber);

                if(this.idoUser.password == this.idoUser.emailAddress)
                    this.AddMessage(busConstant.PasswordCannotbeSameAsEmailAddress);
            }
        }

        private void DoesRetypedPasswordMatch()
        {
            if (this.idoUser.password != this.istrRetypePassword)
                this.AddMessage(busConstant.DoesPasswordAndRetypedPasswordMatch);
        }
        
        private void IsPasswordEntered()
        {
            if (this.idoUser.password == string.Empty || this.idoUser.password == null)
                this.AddMessage(busConstant.PleaseEnterThePassword);
        }
    }
}