using System;
using System.Configuration;

namespace CuriousDriveService.Global
{
    public class busConstant
    {
        public static String Encryption = "Y";

        public static String FlagY = "Y";
        public static String FlagN = "N";
        public static String ValidationMessages = "ValidationMessages";

        public static String Region = "DEV"; //ConfigurationManager.AppSettings["Region"];

        public static String FacebookLOCClientId = "801162613266480";
        public static String FacebookSYSClientId = "764678906943496";
        public static String FacebookUATClientId = "768654456560330";

        public static String GoogleAPIKey = "AIzaSyAYgWqulBraOvk0Anw3n9ACE15ajq2WQrc";

        public static String CosmologyThreadId = "1";
        public static String ReligionThreadId = "2";

        public static String Cosmology = "cosmology";
        public static String SiteName = " Curious Drive ";
        public static String TitleQuestions = " Questions ";

        public static String pictureUrl = "./assets/global/img/profile_default.jpg";

        public static String QuestionAnswer = "ANSR";
        public static String Question = "QUES";
        public static String QuestionComment = "QCOM";
        public static String AnswerComment = "ACOM";

        //Codes
        public static int GenderId = 2;
        public static int CategoryStatus = 6;
        public static int ThreadStatus = 7;
        public static int VoteType = 9;
        public static int PostType = 10;
        public static int RoleId = 14;
        public static int UserGroupId = 15;
        public static int UserStatusId = 18;

        //function names 
        public static String UpdateQuestionAnswer = "UpdateQuestionAnswer";
        public static String DeleteQuestionAnswer = "DeleteQuestionAnswer";
        public static String PostQuestionAnswerVoteUp = "PostQuestionAnswerVoteUp";
        public static String PostQuestionAnswerVoteDown = "PostQuestionAnswerVoteDown";

        // Code Values
        public static String GoogleClientIdUAT = "GCIU";
        public static String GoogleClientIdSYS = "GCIS";
        public static String GoogleClientIdLOC = "GCIL";
        public static String GoogleAPIKeyUAT = "GAKU";
        public static String GoogleAPIKeySYS = "GAKS";
        public static String GoogleAPIKeyLOC = "GAKL";
        public static String FacebookClientIdUAT = "FCIU";
        public static String FacebookClientIdSYS = "FCIS";
        public static String FacebookClientIdLOC = "FCIS";
        public static String RedirectUrlUAT = "RDUU";
        public static String RedirectUrlSYS = "RDUS";
        public static String RedirectUrlLOC = "RDUL";
        public static String RESTUrlUAT = "RSUU";
        public static String RESTUrlSYS = "RSUS";
        public static String RESTUrlLOC = "RSUL";
        public static String CategoryStatusApproved = "CATA";
        public static String CategoryStatusPendingForApproval = "CATP";

        public static String ThreadStatusApproved = "THRA";
        public static String ThreadStatusPendingForApproval = "THRP";

        public static String VoteTypeUp = "UPVT";
        public static String VoteTypeDown = "DNVT";

        public static String PostTypeQuestion = "QUES";
        public static String PostTypeAnswer = "ANSR";
        public static String PostTypeComment = "CMNT";
        public static String PostTypeAnnouncement = "ANNC";

        public static String GoogleNetwork = "GOOG";
        public static String FacebookNetwork = "FACE";
        public static String TwitterNetwork = "TWIT";
        public static String ApplicationNetwork = "APPC";

        public static String GenderMaleValue = "MALE";
        public static String GenderFemaleValue = "FEMALE";

        //Roles
        public static String RoleGeneral = "GNRL";
        public static String RoleStudent = "STUD";
        public static String RoleModerator = "MDTR";
        public static String RoleTeacher = "TCHR";
        public static String RoleAdmin = "ADMN";
        public static String RoleAll = "All";

        // User Groups
        public static String UserGroupFreshman = "FRSH";
        public static String UserGroupSophomore = "SPMR";
        public static String UserGroupJunior = "JUNR";
        public static String UserGroupSenior = "SENR";

        // actions for users who are not logged in
        public static String ActionQuestionVoteUp = "QVUP";
        public static String ActionQuestionVoteDown = "QVDN";
        public static String ActionAnswerVoteUp = "AVUP";
        public static String ActionAnswerVoteDown = "AVDN";
        public static String ActionPostQuestionComment = "PQCO";
        public static String ActionPostAnnouncementComment = "PACO";
        public static String ActionPostQuestionAnswer = "PQAN";
        public static String ActionPostQuestionAnswerComment = "PQAC";

        //code values - action types
        public static String ActionTypeUpVoteQuestion = "UPVQ";
        public static String ActionTypeDownVoteQuestion = "DNVQ";
        public static String ActionTypeUpVoteAnswer = "UPVA";
        public static String ActionTypeDownVoteAnswer = "DNVA";
        public static String ActionTypeUpVoteComment = "UPVC";
        public static String ActionTypeDownVoteComment = "DNVC";
        public static String ActionTypeQuestion = "QUES";
        public static String ActionTypeAnswer = "ANSR";
        public static String ActionTypeAskQuestion = "ASKQ";
        public static String ActionTypeCommentOnQuestion = "CMTQ";
        public static String ActionTypeCommentOnAnswer = "CMTA";
        public static String ActionTypeMentionInQuestion = "MNQU";
        public static String ActionTypeMentionInAnnouncement = "MNAN";

        // statuses
        public static String Active = "ACTV";
        public static String Inactive = "INAC";

        // user group types
        public static String UserGroupTypeIndividual = "INDV";
        public static String UserGroupTypeYear = "CLSS";
        public static String UserGroupTypeUserGroup = "USGP";

        // messages 
        public static String DeleteMessage = "Records deleted successfully!!!!";
        public static String UpdateMessage = "Records updated successfully!!!!";

        public static int IsFirstNameOrLastNameEntered = 1;
        public static int IsDuplicateEmailAddressMessageId = 2;
        public static int IsRegisterEmailAddressAndPasswordEntered = 3;
        public static int DoesPasswordAndRetypedPasswordMatch = 4;
        public static int IsPasswordLongerThan8Characters = 5;
        public static int IsLoginEmailAddressAndPasswordEntered = 6;
        public static int IsLoginEmailAddressAndPasswordValid = 7;
        public static int IsForgotPasswordEmailAddressEntered = 8;
        public static int IsForgotPasswordEmailAddressValid = 9;
        public static int IsQuestionTitleEntered = 10;
        public static int IsQuestionTitleDuplicate = 11;
        public static int IsQuestionDescriptionLongerThan100Characters = 12;
        public static int IsQuestionTitleLongerThan20Characters = 13;
        public static int IsUserLoggedIn = 14;
        public static int IsQuestionAnswerLongerThan100Characters = 15;
        public static int IsDuplicateVote = 16;
        public static int IsPostOwnerSameAsVoter = 17;
        public static int IsCommentEntered = 18;
        public static int IsClassEntered = 19;
        public static int NoFeedbackWasEntered = 20;
        public static int SuccessFeedback = 21;
        public static int SuccessClasses = 22;
        public static int IsClassDuplicate = 23;
        public static int SuccessVotes = 24;
        public static int SuccessComments = 25;
        public static int SuccessAnswer = 26;
        public static int SuccessQuestion = 27;
        public static int IsAnnouncementTitleEntered = 28;
        public static int IsAnnouncementTitleDuplicate = 29;
        public static int IsAnnouncementDescriptionLongerThan100Characters = 30;
        public static int IsGroupNameOrDescriptionEmpty = 31;
        public static int IsUserListEmpty = 32;
        public static int IsGroupNameDuplicate = 33;
        public static int PleaseSelectRoleAndUserGroup = 34;
        public static int SystemCannotFindTheAccount = 35;
        public static int PleaseEnterThePassword = 36;
        public static int PasswordMustContainLetters = 37;
        public static int PasswordMustContainAtleastOneNumber = 38;
        public static int PasswordCannotbeSameAsEmailAddress = 39;
    }
}

