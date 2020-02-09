package com.org.panthers.business;

public class busConstant {

	// Version
	public static String Version = "vAero";
	
	// Data Objects
	public static String Employee = "Employee";
	public static String doUser = "doUser";
	public static String doUserRole = "doUserRole";
	public static String doRole = "doRole";
	public static String doCode = "doCode";
	public static String doCodeValue = "doCodeValue";
	public static String doQuestionAnswer = "doQuestionAnswer";
	public static String doQuestion = "doQuestion";
	public static String doAnnouncement = "doAnnouncement";
	public static String doQuestionView = "doQuestionView";
	public static String doQuestionClass = "doQuestionClass";
	public static String doClass = "doClass";
	public static String doNotification = "doNotification";
	public static String doThread = "doThread";
	public static String doComment = "doComment";
	public static String doPoint = "doPoint";
	public static String doFeedback = "doFeedback";
	public static String doTag = "doTag";
	public static String doTagDetail = "doTagDetail";
	public static String doUserGroup = "doUserGroup";
	public static String doUserGroupDetail = "doUserGroupDetail";

	// Data Types
	public static String DataTypeInteger = "Interger";
	public static String DataTypeString = "String";

	// Severities
	public static String SeveritySevere = "Severe";
	public static String SeverityInfo = "Info";
	
	public static String DeleteMessage = "Record has been deleted successfully";
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
	public static int IsQuestionTitleLongerThan10Characters = 13;
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
	public static int IsAnnouncementDescriptionLongerThan30Characters = 30;
	public static int IsGroupNameOrDescriptionEmpty = 31;
	public static int IsUserListEmpty = 32;
	public static int IsGroupNameDuplicate = 33;
	public static int PleaseSelectRoleAndUserGroup = 34;
	public static int SystemCannotFindTheAccount = 35;
	public static int PleaseEnterThePassword = 36;
	public static int PasswordMustContainLetters = 37;
	public static int PasswordMustContainAtleastOneNumber = 38;
	public static int PasswordCannotbeSameAsEmailAddress = 39;
	public static int ForgotPasswordSuccess = 40;
	public static int IsAnnouncementTitleLongerThan10Characters = 41;
	public static int SuccessAnnouncement = 42;
	public static int SavedSuccessfully = 43;
	public static int UpdatedSuccessfully = 44;
	public static int DeletedSuccessfully = 45;
	

	//Code Id
	public static int PostTypeId = 10;
	public static int ActionTypeId = 11;
	public static int PointTypeId = 12;
	public static int RoleId = 14;
	public static int UserGroupId = 15;
	public static int GroupStatusId = 16;
	public static int UserGroupTypeId = 17;
	
	// Code Value
	public static String NetWorkValueApplication = "APPC";
	public static String VoteTypeUp = "UPVT";
	public static String VoteTypeDown = "DNVT";
	
	public static String ThreadStatusApproved = "THRA";
	public static String ThreadStatusPendingForApproval = "THRP";
	
	public static String PointTypeVote = "VOTE";
	public static String PointTypeBonus = "BONS";
	
	//code values - post types
	public static String PostTypeQuestion = "QUES";
	public static String PostTypeAnswer = "ANSR";
	public static String PostTypeComment = "CMNT";
	public static String PostTypeAnnouncement = "ANNC";
	
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
	
	//code values - action types
	public static String GroupStatusActive = "ACTV";
	public static String GroupStatusInactive = "INAC";
	
	//Roles
	public static String RoleGeneral = "GNRL";
	public static String RoleStudent = "STUD";
	public static String RoleModerator = "MDTR";
	public static String RoleTeacher = "TCHR";
	public static String RoleAdmin = "ADMN";
	
	// User Groups
	public static String UserGroupFreshman = "FRSH";
	public static String UserGroupSophomore = "SPMR";
	public static String UserGroupJunior = "JUNR";
	public static String UserGroupSenior = "SENR";
	public static String UserGroupGeneral = "GNRL";
	
	public static String MessageTypeError = "ERRR";
	public static String MessageTypeInformation = "INFO";
	
	//Email constant
	public static String WelcomeToCuriousDrive = "Welcome to Curious Drive";
	public static String VerifyEmailAddressSubject = "Email Verification for Curious Drive Account";
	public static String ResetPasswordSubject = "Reset your password";
	
	public static String AdminEmail = "mail.privateemail.com";
	public static String SalesEmailAddress = "sales@curiousdrive.com";
	public static String SalesEmailName = "Curious Drive Sales";
	public static String MailServerPassword = "4Aces@Dcompany";
	
	

	//Query paths
	//Admin
	public static String loadVerifiedFeedbacks = "SQLScripts/Admin/loadVerifiedFeedbacks.sql";
	public static String loadFeedbacksToVerify = "SQLScripts/Admin/loadFeedbacksToVerify.sql";
	public static String deleteClass = "SQLScripts/Admin/deleteClass.sql";
	public static String deleteUserGroupDetail = "SQLScripts/Admin/deleteUserGroupDetail.sql";
	public static String getUserGroupsByName = "SQLScripts/Admin/getUserGroupsByName.sql";
	public static String loadUserGroupDetails = "SQLScripts/Admin/loadUserGroupDetails.sql";
	
	//Question
	public static String loadAllQuestions = "SQLScripts/Question/loadAllQuestions.sql";
	public static String loadAllQuestionsPopular = "SQLScripts/Question/loadAllQuestionsPopular.sql";
	public static String loadAllQuestionsRecent = "SQLScripts/Question/loadAllQuestionsRecent.sql";
	public static String loadAllQuestionsUnanswered = "SQLScripts/Question/loadAllQuestionsUnanswered.sql";
	public static String loadQuestionVotes = "SQLScripts/Question/loadQuestionVotes.sql";
	public static String loadQuestionAnswerVotes = "SQLScripts/Question/loadQuestionAnswerVotes.sql";
	public static String deleteQuestionAnswers = "SQLScripts/Question/deleteQuestionAnswers.sql";
	public static String deleteQuestion = "SQLScripts/Question/deleteQuestion.sql";
	
	//User
	public static String loadVoteByUser = "SQLScripts/Vote/loadVoteByUser.sql";
	public static String loadUserPoints = "SQLScripts/User/loadUserPoints.sql";
	public static String loadUserProfile = "SQLScripts/User/loadUserProfile.sql";
	public static String getAllUsers = "SQLScripts/User/getAllUsers.sql";
	public static String getUsersByRole = "SQLScripts/User/getUsersByRole.sql";
	public static String getUserQuestions = "SQLScripts/User/getUserQuestions.sql";
	public static String getUserQuestionAnswers = "SQLScripts/User/getUserQuestionAnswers.sql";
	public static String getUserComments = "SQLScripts/User/getUserComments.sql";
	public static String getUserNotifications = "SQLScripts/User/getUserNotifications.sql";
	public static String getStudentsAutocompleteList = "SQLScripts/User/getStudentsAutocompleteList.sql";
	public static String getTeachersAutocompleteList = "SQLScripts/User/getTeachersAutocompleteList.sql";
	public static String getUsersByUserGroupId = "SQLScripts/User/getUsersByUserGroupId.sql";
	public static String getUsersByYear = "SQLScripts/User/getUsersByYear.sql";
	public static String getUserTags = "SQLScripts/User/getUserTags.sql";
	public static String getNewsFeed = "SQLScripts/User/getNewsFeed.sql";
	
	public static String loadCurrentLevel = "SQLScripts/User/loadCurrentLevel.sql";
	public static String loadNextLevel = "SQLScripts/User/loadNextLevel.sql";
	
	public static String deletePoint = "SQLScripts/User/deletePoint.sql";
	public static String deleteNotification = "SQLScripts/User/deleteNotification.sql";
	public static String updateUserProfilePicture = "SQLScripts/User/updateUserProfilePicture.sql";
	public static String updateUserNotifications = "SQLScripts/User/updateUserNotifications.sql";
	
	//Vote
	public static String getUpVoteCountForQuestion = "SQLScripts/Vote/getUpVoteCountForQuestion.sql";
	public static String getUpVoteCountForAnswer = "SQLScripts/Vote/getUpVoteCountForAnswer.sql";
	public static String deleteVote = "SQLScripts/Vote/deleteVote.sql";
	
	//HTML template paths
	public static String WelcomeNewUserTemplate = "htmlTemplates/welcomeNewUser.html";
	public static String BookADemoTemplate = "htmlTemplates/bookADemo.html";
	public static String DropUsAMessageTemplate = "htmlTemplates/dropUsAMessage.html";
	public static String VerifyEmailAddressTemplate = "htmlTemplates/verifyEmailAddress.html";
	public static String ResetPasswordTemplate = "htmlTemplates/resetYourPassword.html";
	
	//Misc
	public static int PasswordLength = 6;
	public static int QuestionDescriptionLength = 30;
	public static int AnnouncementDescriptionLength = 30;
	public static int QuestionAnswerDescriptionLength = 30;
	public static int QuestionTitleLength = 10;
	public static String GoogleUrlShortApi = "https://www.googleapis.com/urlshortener/v1/url";
	public static String GoogleApiKey = "AIzaSyAYgWqulBraOvk0Anw3n9ACE15ajq2WQrc";
	public static String DomainName = "https://www.curiousdrive.com/";
	public static String Select = "Select";
	public static String Delete = "Delete";
	public static String Update = "Update";
	public static String salesEmailAddress = "sales@curiousdrive.com";
	
	public static String FlagY = "Y";
	public static String FlagN = "N";
	
	// user group types
    public static String UserGroupTypeIndividual = "INDV";
    public static String UserGroupTypeYear = "YEAR";
    public static String UserGroupTypeUserGroup = "USGP";

}
