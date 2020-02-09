package com.org.panthers.business;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.ocpsoft.prettytime.PrettyTime;

import net.casper.data.model.CDataGridException;
import net.casper.data.model.CDataRowSet;

import com.org.panthers.entity.doComment;
import com.org.panthers.entity.doQuestion;
import com.org.panthers.entity.doQuestionAnswer;
import com.org.panthers.entity.doUser;
import com.org.panthers.entity.doUserRole;
import com.org.panthers.framework.busBase;
import com.org.panthers.framework.busBaseDAOImpl;
import com.org.panthers.framework.busDBFunctions;
import com.org.panthers.framework.busParameter;
import com.org.panthers.framework.busUtil;

public class busUser extends busBase {

	public doUser idoUser;
	public busUserRole ibusUserRole;
	public List<busNewsFeed> ilstbusNewsFeed;
	
	public String istrURLTitle;
	public String istrRoleValue;
    public String istrUserGroupValue;
    public String istrCurrentLevel;
    public String istrNextLevel;
    public String istrPlainOtp;
    public String istrEmailVerificationCode;
    public String istrRetypePassword;
    
    public int iintTotalPoint = 0;
    public int iintCurrentLevelPoints;
	public int iintNextLevelPoints;
	public int iintLevelCompletionPercentage;
	
	public busUser() {
		idoUser = new doUser();
	}

	//region main functions 
	
	public List<busUser> getCollection(List<doUser> alstUsers) {

		List<busUser> llstbusUsers = new ArrayList<busUser>();

		for (doUser lUser : alstUsers) {

			busUser lbusUser = new busUser();
			lbusUser.idoUser = lUser;
			llstbusUsers.add(lbusUser);

		}
		return llstbusUsers;
	}

	public void loadUserRole() {
		// code to assign user roles
		busBaseDAOImpl<doUserRole> lBaseDAOImpl = new busBaseDAOImpl<doUserRole>();

		List<busParameter> llstbusParameters = new ArrayList<busParameter>();
		llstbusParameters.add(new busParameter(doUserRole.enmUserRole.userId.toString(), String.valueOf(this.idoUser.getUserId()), busConstant.DataTypeInteger));
		
		this.ibusUserRole = new busUserRole();
		this.ibusUserRole.idoUserRole = lBaseDAOImpl.select(doUserRole.class, busConstant.doUserRole, llstbusParameters).get(0);

	}

	public boolean loginUser() {
		// Code to validate user and get user
		busBaseDAOImpl<doUser> lBaseDAOImpl = new busBaseDAOImpl<doUser>();

		List<busParameter> llstbusParameters = new ArrayList<busParameter>();
		llstbusParameters.add(new busParameter(doUser.enmUser.emailAddress.toString(), this.idoUser.getEmailAddress(), busConstant.DataTypeString));
		llstbusParameters.add(new busParameter(doUser.enmUser.networkValue.toString(), this.idoUser.getNetworkValue(), busConstant.DataTypeString));
		llstbusParameters.add(new busParameter(doUser.enmUser.password.toString(), this.idoUser.getPassword(), busConstant.DataTypeString));

		List<doUser> llstdoUser = lBaseDAOImpl.select(doUser.class, busConstant.doUser, llstbusParameters);

		if (llstdoUser != null && llstdoUser.size() > 0)
		{
			//assigning new profile pictures - 
			doUser ldoUser = llstdoUser.get(0);
			
			if(this.idoUser.getPictureUrl() != null)
			{
				ldoUser.setPictureUrl(this.idoUser.getPictureUrl());
				ldoUser.update();
			}
			
			this.idoUser = ldoUser;
			this.loadUserRole();
			return true;
		}	
		else
		{
			this.addMessage(busConstant.IsLoginEmailAddressAndPasswordValid);
			return false;
		}
			
	}

	public boolean enrollUser() {

		try {
			
			// register user if user is not in the system
			int lintUserId = this.idoUser.insert();
			
			//insert record into user roles table
			busUserRole lbusUserRole = new busUserRole();
			lbusUserRole.idoUserRole.iintUserId = 1;
			lbusUserRole.idoUserRole.setUserId(lintUserId);
			lbusUserRole.idoUserRole.setRoleId(busConstant.RoleId);
			lbusUserRole.idoUserRole.setRoleValue(this.istrRoleValue);
			lbusUserRole.idoUserRole.setUserGroupId(busConstant.UserGroupId);
			lbusUserRole.idoUserRole.setUserGroupValue(this.istrUserGroupValue);
			
			lbusUserRole.idoUserRole.insert();
			
			this.addMessage(busConstant.SavedSuccessfully);
			
			// send new user registration email
			busUtil lbusUtil = new busUtil();
			lbusUtil.sendEmail(this.idoUser.getEmailAddress(), busConstant.VerifyEmailAddressSubject, busConstant.VerifyEmailAddressTemplate, 
					new Object[] { this.idoUser.getFirstName(),this.istrEmailVerificationCode });
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//abusUser.validateUser();	
		return true;
	}
	
	public void forgotPassword(busUser abusUser) {
		// TODO Auto-generated method stub
		try {
			
		busBaseDAOImpl<doUser> lBaseDAOImpl = new busBaseDAOImpl<doUser>();

		List<busParameter> llstbusParameters = new ArrayList<busParameter>();
		llstbusParameters.add(new busParameter(doUser.enmUser.emailAddress.toString(), abusUser.idoUser.getEmailAddress(), busConstant.DataTypeString));

		this.idoUser = lBaseDAOImpl.selectFirstOrDefault(doUser.class, busConstant.doUser, llstbusParameters);

		this.idoUser.isPasswordForgotten = busConstant.FlagY; 
		this.idoUser.otp = abusUser.idoUser.otp;
		this.idoUser.update();
		
		//this.addMessage(busConstant.ForgotPasswordSuccess);
		
		// send new user registration email
		busUtil lbusUtil = new busUtil();
		lbusUtil.sendEmail(this.idoUser.getEmailAddress(), busConstant.ResetPasswordSubject, busConstant.ResetPasswordTemplate, 
				new Object[] { this.idoUser.getFirstName(),abusUser.istrEmailVerificationCode });
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadUserByEmailAndOTP() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doUser> lBaseDAOImpl = new busBaseDAOImpl<doUser>();

		List<busParameter> llstbusParameters = new ArrayList<busParameter>();
		llstbusParameters.add(new busParameter(doUser.enmUser.emailAddress.toString(), this.idoUser.getEmailAddress(), busConstant.DataTypeString));
		llstbusParameters.add(new busParameter(doUser.enmUser.otp.toString(), this.idoUser.getOtp(), busConstant.DataTypeString));

		this.idoUser = lBaseDAOImpl.selectFirstOrDefault(doUser.class, busConstant.doUser, llstbusParameters);

		if (this.idoUser == null)
			this.addMessage(busConstant.IsLoginEmailAddressAndPasswordValid);
		
	}
	
	public void setNewPassword() {
		// TODO Auto-generated method stub
		this.idoUser.update();
	}
	
	public String getSaltValue(String astrEmailAddress) {
		
		busBaseDAOImpl<doUser> lBaseDAOImpl = new busBaseDAOImpl<doUser>();
		
		List<busParameter> llstbusParameters = new ArrayList<busParameter>();
		llstbusParameters.add(new busParameter(doUser.enmUser.emailAddress.toString(), astrEmailAddress, busConstant.DataTypeString));

		this.idoUser = lBaseDAOImpl.selectFirstOrDefault(doUser.class, busConstant.doUser, llstbusParameters);

		if (this.idoUser != null)
			return idoUser.saltValue;
		else
			return "";
	}
	
	public busUser getUserProfile(int aintUserId)
	{
		List<busParameter> llstbusParameters = new ArrayList<busParameter>();
		llstbusParameters.add(new busParameter(doUser.enmUser.userId.toString(), Integer.toString(aintUserId), busConstant.DataTypeInteger));
		CDataRowSet ldrUserProfile = new busDBFunctions().DBExecute(busConstant.loadUserProfile, llstbusParameters, null,busConstant.Select);
		
		try {
			
			busUser lbusUser = new busUser();
			lbusUser.ibusUserRole = new busUserRole();
			
			ldrUserProfile.next();
			
			// load table columns --
			lbusUser.idoUser.setUserId(aintUserId);
			lbusUser.idoUser.setEmailAddress(ldrUserProfile.getString("EMAIL_ADDRESS"));
			lbusUser.idoUser.setPassword(ldrUserProfile.getString("PASSWORD"));
			lbusUser.idoUser.setSaltValue(ldrUserProfile.getString("SALT_VALUE"));
			lbusUser.idoUser.setOtp(ldrUserProfile.getString("OTP"));
			lbusUser.idoUser.setIsUserVerfied(ldrUserProfile.getString("IS_USER_VERIFIED"));
			lbusUser.idoUser.setIsPasswordForgotten(ldrUserProfile.getString("IS_PASSWORD_FORGOTTEN"));
			lbusUser.idoUser.setUserStatusId(ldrUserProfile.getInt("USER_STATUS_ID"));
			lbusUser.idoUser.setUserStatusValue(ldrUserProfile.getString("USER_STATUS_VALUE"));
			lbusUser.idoUser.setIsPasswordForgotten(ldrUserProfile.getString("IS_PASSWORD_FORGOTTEN"));
			lbusUser.idoUser.setDisplayName(ldrUserProfile.getString("DISPLAY_NAME"));
			lbusUser.idoUser.setFirstName(ldrUserProfile.getString("FIRST_NAME"));
			lbusUser.idoUser.setLastName(ldrUserProfile.getString("LAST_NAME"));
			lbusUser.idoUser.setPictureUrl(ldrUserProfile.getString("PICTURE_URL"));
			lbusUser.idoUser.setNetworkId(ldrUserProfile.getInt("NETWORK_ID"));
			lbusUser.idoUser.setNetworkValue(ldrUserProfile.getString("NETWORK_VALUE"));
			lbusUser.idoUser.setNetworkUserId(ldrUserProfile.getString("NETWORK_USER_ID"));
			lbusUser.idoUser.setBirthDate(ldrUserProfile.getDate("BIRTH_DATE"));
			lbusUser.idoUser.setGenderValue(ldrUserProfile.getString("GENDER_VALUE"));
			lbusUser.idoUser.setPhoneNumber(ldrUserProfile.getString("PHONE_NUMBER"));
			lbusUser.idoUser.setAboutMe(ldrUserProfile.getString("ABOUT_ME"));
			lbusUser.idoUser.setFacebookUrl(ldrUserProfile.getString("FACEBOOK_URL"));
			lbusUser.idoUser.setInterests(ldrUserProfile.getString("INTERESTS"));
			lbusUser.idoUser.setOccupation(ldrUserProfile.getString("OCCUPATION"));
			lbusUser.idoUser.setTwitterUrl(ldrUserProfile.getString("TWITTER_URL"));
			lbusUser.idoUser.setWebsiteUrl(ldrUserProfile.getString("WEBSITE_URL"));
			
			//assign user group
			lbusUser.ibusUserRole.istrUserGroup = ldrUserProfile.getString("DESCRIPTION");
			
			// load points and levels
			lbusUser.iintTotalPoint = ldrUserProfile.getInt("POINTS");

			// load news feed
			lbusUser.ilstbusNewsFeed = this.getNewsFeed();
			
			return lbusUser;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	public List<busNotification> getUserNotifications(int aintUserId)
	{
		List<busParameter> llstbusParameters = new ArrayList<busParameter>();
		llstbusParameters.add(new busParameter(doUser.enmUser.userId.toString(), Integer.toString(aintUserId), busConstant.DataTypeInteger));
		CDataRowSet ldrUserNotifications = new busDBFunctions().DBExecute(busConstant.getUserNotifications, llstbusParameters, null,busConstant.Select);
		
		List<busNotification> llstbusNotification = new ArrayList<busNotification>();
		
		try {
			while(ldrUserNotifications.next()){
				
				busNotification lbusNotification = new busNotification();
				lbusNotification.ibusFromUser = new busUser();
				
				lbusNotification.idoNotification.setNotificationId(ldrUserNotifications.getInt("NOTIFICATION_ID"));
				lbusNotification.idoNotification.setSubsystemReferenceId(ldrUserNotifications.getInt("SUBSYSTEM_REFERENCE_ID"));
				lbusNotification.idoNotification.setSubsystemValue(ldrUserNotifications.getString("SUBSYSTEM_VALUE"));
				lbusNotification.idoNotification.setIsRead(ldrUserNotifications.getString("IS_READ"));
				lbusNotification.idoNotification.setCreatedDate(ldrUserNotifications.getDate("CREATED_DATE"));
				lbusNotification.idoNotification.setFromUserId(ldrUserNotifications.getInt("FROM_USER_ID"));
				
				lbusNotification.ibusFromUser.idoUser.setDisplayName(ldrUserNotifications.getString("FROM_USER_DISPLAY_NAME"));
				lbusNotification.ibusFromUser.idoUser.setPictureUrl(ldrUserNotifications.getString("FROM_USER_PICTURE_URL"));
				lbusNotification.ibusFromUser.idoUser.setNetworkValue(ldrUserNotifications.getString("NETWORK_VALUE"));
				
				lbusNotification.istrNotificationDetail = ldrUserNotifications.getString("NOTIFICATION_DETAIL");
				lbusNotification.iintReferenceId = ldrUserNotifications.getInt("REFERENCE_ID");
				
				//make header and detail
				if(lbusNotification.idoNotification.getSubsystemValue().equals(busConstant.ActionTypeUpVoteQuestion))
				{
					lbusNotification.istrNotificationHeader = " upvoted your question";
				}
				if(lbusNotification.idoNotification.getSubsystemValue().equals(busConstant.ActionTypeUpVoteAnswer))
				{
					lbusNotification.istrNotificationHeader = " upvoted your answer";
					lbusNotification.istrNotificationDetail = busUtil.convertHTMLtoString(lbusNotification.istrNotificationDetail, 100);
				}
				if(lbusNotification.idoNotification.getSubsystemValue().equals(busConstant.ActionTypeDownVoteQuestion))
				{
					lbusNotification.istrNotificationHeader = " downvoted your question";
				}
				if(lbusNotification.idoNotification.getSubsystemValue().equals(busConstant.ActionTypeDownVoteAnswer))
				{
					lbusNotification.istrNotificationHeader = " downvoted your answer";
					lbusNotification.istrNotificationDetail = busUtil.convertHTMLtoString(lbusNotification.istrNotificationDetail, 100);
				}
				if(lbusNotification.idoNotification.getSubsystemValue().equals(busConstant.ActionTypeCommentOnQuestion))
				{
					lbusNotification.istrNotificationHeader = " commented your question";
				}
				if(lbusNotification.idoNotification.getSubsystemValue().equals(busConstant.ActionTypeCommentOnAnswer))
				{
					lbusNotification.istrNotificationHeader = " commented your answer";
					lbusNotification.istrNotificationDetail = busUtil.convertHTMLtoString(lbusNotification.istrNotificationDetail, 100);
				}
				if(lbusNotification.idoNotification.getSubsystemValue().equals(busConstant.ActionTypeAnswer))
				{
					lbusNotification.istrNotificationHeader = " answered your question";
					lbusNotification.istrNotificationDetail = busUtil.convertHTMLtoString(lbusNotification.istrNotificationDetail, 100);
				}
				if(lbusNotification.idoNotification.getSubsystemValue().equals(busConstant.ActionTypeAskQuestion))
				{
					lbusNotification.istrNotificationHeader = " asked you a question";
					lbusNotification.istrNotificationDetail = busUtil.convertHTMLtoString(lbusNotification.istrNotificationDetail, 100);
				}
				if(lbusNotification.idoNotification.getSubsystemValue().equals(busConstant.ActionTypeMentionInQuestion))
				{
					lbusNotification.istrNotificationHeader = " mentioned you in a question";
					lbusNotification.istrNotificationDetail = busUtil.convertHTMLtoString(lbusNotification.istrNotificationDetail, 100);
				}
				if(lbusNotification.idoNotification.getSubsystemValue().equals(busConstant.ActionTypeMentionInAnnouncement))
				{
					lbusNotification.istrNotificationHeader = " mentioned you in an announcement";
					lbusNotification.istrNotificationDetail = busUtil.convertHTMLtoString(lbusNotification.istrNotificationDetail, 100);
				}
				
				llstbusNotification.add(lbusNotification);
			}
			
		} catch (CDataGridException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return llstbusNotification;
	}
	
	public List<busQuestion> getUserQuestions(int aintUserId) {
	
		List<busParameter> llstbusParameters = new ArrayList<busParameter>();
		llstbusParameters.add(new busParameter(doUser.enmUser.userId.toString(), Integer.toString(aintUserId), busConstant.DataTypeInteger));
		CDataRowSet ldrUserQuestions = new busDBFunctions().DBExecute(busConstant.getUserQuestions, llstbusParameters, null,busConstant.Select);
		List<busQuestion> llstbusQuestions = new ArrayList<busQuestion>();
		
		try 
		{
			while(ldrUserQuestions.next()) 
			{
				busQuestion lbusQuestion = new busQuestion();
				
				lbusQuestion.idoQuestion.setQuestionId(ldrUserQuestions.getInt("QUESTION_ID"));
				lbusQuestion.idoQuestion.setQuestionTitle(ldrUserQuestions.getString("QUESTION_TITLE"));
				lbusQuestion.idoQuestion.setIsValid(ldrUserQuestions.getByte("IS_VALID"));
				lbusQuestion.idoQuestion.setCreatedDate(ldrUserQuestions.getDate("CREATED_DATE"));
				lbusQuestion.iintVoteCount = ldrUserQuestions.getInt("VOTES");
				
				llstbusQuestions.add(lbusQuestion);
			}
		
			return llstbusQuestions;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
		
	public List<busQuestionAnswer> getUserQuestionAnswers(int aintUserId) {

		List<busParameter> llstbusParameters = new ArrayList<busParameter>();
		llstbusParameters.add(new busParameter(doUser.enmUser.userId.toString(), Integer.toString(aintUserId), busConstant.DataTypeInteger));
		CDataRowSet ldrUserQuestionAnswers = new busDBFunctions().DBExecute(busConstant.getUserQuestionAnswers, llstbusParameters, null,busConstant.Select);
		List<busQuestionAnswer> llstbusQuestionAnswer = new ArrayList<busQuestionAnswer>();
		
		try 
		{
			while(ldrUserQuestionAnswers.next()) 
			{
				//Initializing 
				busQuestionAnswer lbusQuestionAnswer = new busQuestionAnswer();
				
				lbusQuestionAnswer.ibusQuestion = new busQuestion();
				
				//Assigning
				lbusQuestionAnswer.ibusQuestion.idoQuestion.setQuestionId(ldrUserQuestionAnswers.getInt("QUESTION_ID"));
				lbusQuestionAnswer.ibusQuestion.idoQuestion.setQuestionTitle(ldrUserQuestionAnswers.getString("QUESTION_TITLE"));
				lbusQuestionAnswer.ibusQuestion.idoQuestion.setIsValid(ldrUserQuestionAnswers.getByte("IS_VALID"));
				
				lbusQuestionAnswer.idoQuestionAnswer.setQuestionAnswerId(ldrUserQuestionAnswers.getInt("QUESTION_ANSWER_ID"));
				lbusQuestionAnswer.idoQuestionAnswer.setCreatedDate(ldrUserQuestionAnswers.getDate("CREATED_DATE"));
				lbusQuestionAnswer.iintVoteCount = ldrUserQuestionAnswers.getInt("VOTES");
				
				lbusQuestionAnswer.idoQuestionAnswer.setAnswerHtml(busUtil.convertHTMLtoString(ldrUserQuestionAnswers.getString("ANSWER_HTML"), 120));
				
				llstbusQuestionAnswer.add(lbusQuestionAnswer);
			}
			
			return llstbusQuestionAnswer;
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
		
	public List<busComment> getUserComments(int aintUserId) {

		List<busParameter> llstbusParameters = new ArrayList<busParameter>();
		llstbusParameters.add(new busParameter(doUser.enmUser.userId.toString(), Integer.toString(aintUserId), busConstant.DataTypeInteger));
		CDataRowSet ldrUserComments = new busDBFunctions().DBExecute(busConstant.getUserComments, llstbusParameters, null,busConstant.Select);
		List<busComment> llstbusComments = new ArrayList<busComment>();

		try 
		{
			while(ldrUserComments.next()) 
			{
				//Initializing
				busComment lbusComment = new busComment();
				
				lbusComment.ibusQuestion = new busQuestion();
				
				//Assigning 
				lbusComment.ibusQuestion.idoQuestion.setQuestionId(ldrUserComments.getInt("QUESTION_ID"));
				lbusComment.ibusQuestion.idoQuestion.setQuestionTitle(ldrUserComments.getString("QUESTION_TITLE"));
				lbusComment.ibusQuestion.idoQuestion.setIsValid(ldrUserComments.getByte("IS_VALID"));
				
				lbusComment.idoComment.setCommentId(ldrUserComments.getInt("COMMENT_ID"));
				lbusComment.idoComment.setCommentHtml(StringUtils.substring(ldrUserComments.getString("COMMENT_HTML"), 0, 120));
				lbusComment.idoComment.setCreatedDate(ldrUserComments.getDate("CREATED_DATE"));
				lbusComment.iintVoteCount = ldrUserComments.getInt("VOTES");
				
				llstbusComments.add(lbusComment);
			}
		
			return llstbusComments;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
		
	public List<busTag> getUserTags(int aintReferenceId, String astrReferenceValue)
	{
		List<busParameter> llstbusParameters = new ArrayList<busParameter>();
		llstbusParameters.add(new busParameter("", Integer.toString(aintReferenceId), busConstant.DataTypeInteger));
		llstbusParameters.add(new busParameter("", astrReferenceValue, busConstant.DataTypeString));
		
		CDataRowSet ldrUserTags = new busDBFunctions().DBExecute(busConstant.getUserTags, llstbusParameters, null,busConstant.Select);
		List<busTag> llstbusTag = new ArrayList<busTag>();

		try 
		{
			while(ldrUserTags.next()) 
			{
				//Initializing
				busTag lbusTag = new busTag();
				lbusTag.istrUserTag = ldrUserTags.getString("USER_TAG");
				
				llstbusTag.add(lbusTag);
			}
		
			return llstbusTag;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
		
	public int updateUserNotifications(int aintUserId) {
		
		busDBFunctions ldbFunctions = new busDBFunctions();
		String[] primaryKeys = { "USER_ID" };

		// get thread id
		List<busParameter> llstbusParameters = new ArrayList<busParameter>();
		llstbusParameters.add(new busParameter(doUser.enmUser.userId.toString(), String.valueOf(aintUserId), busConstant.DataTypeInteger));
		
		ldbFunctions.DBExecute(busConstant.updateUserNotifications, llstbusParameters, primaryKeys,busConstant.Update);
		
		return 1;
	}
		
	public int getUserIdByQuestionId(int aintQuestionId) {
		// TODO Auto-generated method stub
		List<busParameter> llstbusParameters = new ArrayList<busParameter>();
		
		llstbusParameters.add(new busParameter(doQuestion.enmQuestion.questionId.toString(), String.valueOf(aintQuestionId), busConstant.DataTypeInteger));
		doQuestion ldoQuestion = new busBaseDAOImpl<doQuestion>().selectFirstOrDefault(doQuestion.class, busConstant.doQuestion, llstbusParameters);

		return ldoQuestion.getCreatedBy();
	}
		
	public int getUserIdByQuestionAnswerId(int aintQuestionAnswerId) {
		// TODO Auto-generated method stub
		List<busParameter> llstbusParameters = new ArrayList<busParameter>();
		
		llstbusParameters.add(new busParameter(doQuestionAnswer.enmQuestionAnswer.questionAnswerId.toString(), String.valueOf(aintQuestionAnswerId), busConstant.DataTypeInteger));
		doQuestionAnswer ldoQuestionAnswer = new busBaseDAOImpl<doQuestionAnswer>().selectFirstOrDefault(doQuestionAnswer.class, busConstant.doQuestionAnswer, llstbusParameters);

		return ldoQuestionAnswer.getCreatedBy();
	}
		
	public int getUserIdByCommentId(int aintCommentId) {
		// TODO Auto-generated method stub
		List<busParameter> llstbusParameters = new ArrayList<busParameter>();
		
		llstbusParameters.add(new busParameter(doComment.enmComment.commentId.toString(), String.valueOf(aintCommentId), busConstant.DataTypeInteger));
		doComment ldoComment = new busBaseDAOImpl<doComment>().selectFirstOrDefault(doComment.class, busConstant.doComment, llstbusParameters);

		return ldoComment.getCreatedBy();
	}
		
	public void assignOwner(int aintLoggedInUserId) {
		// TODO Auto-generated method stub
		if(this.idoUser.getUserId() == aintLoggedInUserId)
			this.isOwner = true;
		
	}
	
	public List<busNewsFeed> getNewsFeed(){
		
		List<busParameter> llstbusParameters = new ArrayList<busParameter>();
		CDataRowSet ldrNewsFeed = new busDBFunctions().DBExecute(busConstant.getNewsFeed, llstbusParameters, null,busConstant.Select);
		List<busNewsFeed> llstbusNewsFeed = new ArrayList<busNewsFeed>();

		try 
		{
			while(ldrNewsFeed.next()) 
			{
				//Initializing
				busNewsFeed lbusNewsFeed = new busNewsFeed();
				
				//Assigning 
				lbusNewsFeed.iintPostId = ldrNewsFeed.getInt("POST_ID");
				lbusNewsFeed.istrPostTitle = ldrNewsFeed.getString("POST_TITLE");
				lbusNewsFeed.istrPostTitleUrl = busUtil.getTitleUrl(lbusNewsFeed.istrPostTitle);
				lbusNewsFeed.istrPostType = ldrNewsFeed.getString("POST_TYPE");
				lbusNewsFeed.iintUserId = ldrNewsFeed.getInt("USER_ID");
				lbusNewsFeed.istrUserName = ldrNewsFeed.getString("USER_NAME");
				lbusNewsFeed.istrUserPictureUrl = ldrNewsFeed.getString("USER_PICTURE_URL");
				lbusNewsFeed.idtCreatedDate = ldrNewsFeed.getDate("CREATED_DATE");
				
				lbusNewsFeed.istrCreatedDuration = new PrettyTime().format(lbusNewsFeed.idtCreatedDate); 
				
				llstbusNewsFeed.add(lbusNewsFeed);
			}		
			return llstbusNewsFeed;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
		
	//end region main functions 

	//region validations
	
	public boolean validateEnrollUser(){
		//validation functions
		isDuplicateEmailAddress();
		isFirstNameorLastNameEntered();
		isRegisterEmailAddressEntered();
		isPasswordStrong();
		isRoleAndUserGroupSelected();
				
		if(this.ilstbusMessages.size() > 0)
			return false;
		else 
			return true;
	}
		
	public boolean validateLoginUser(){
		//validation functions
		isLoginEmailAddressAndPasswordEntered();
		
		if(this.ilstbusMessages.size() > 0)
			return false;
		else 
			return true;
	}
		
	public boolean validateForgotPassword() {
		// TODO Auto-generated method stub
		isEmailAddressEntered();
		isEmailAddressValid();
		
		if(this.ilstbusMessages.size() > 0)
			return false;
		else 
			return true;
	}
		
	public boolean validateVerifyAccount() {
		// TODO Auto-generated method stub
		return false;
	}
		
	private void isLoginEmailAddressAndPasswordEntered() {

		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(this.idoUser.getEmailAddress()) || StringUtils.isEmpty(this.idoUser.getPassword()))
			this.addMessage(busConstant.IsLoginEmailAddressAndPasswordEntered);
	}
	
	private void isPasswordStrong() {
		// TODO Auto-generated method stub
		if(!StringUtils.isEmpty(this.idoUser.getPassword()) && this.idoUser.getPassword().length() < 6)
			this.addMessage(busConstant.IsPasswordLongerThan8Characters);
	}

	private void isRegisterEmailAddressEntered() {
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(this.idoUser.getEmailAddress()))
			this.addMessage(busConstant.IsRegisterEmailAddressAndPasswordEntered);
	}
	
	private void isFirstNameorLastNameEntered() {
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(this.idoUser.getFirstName()) || StringUtils.isEmpty(this.idoUser.getLastName()))
			this.addMessage(busConstant.IsFirstNameOrLastNameEntered);
	}
	
	private void isRoleAndUserGroupSelected() {
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(this.istrRoleValue) || StringUtils.isEmpty(this.istrUserGroupValue))
			this.addMessage(busConstant.PleaseSelectRoleAndUserGroup);
	}
	
	private void isDuplicateEmailAddress()
	{
		if(!StringUtils.isEmpty(this.idoUser.getEmailAddress()) || !StringUtils.isEmpty(this.idoUser.getNetworkValue()))
		{
			busBaseDAOImpl<doUser> lBaseDAOImpl = new busBaseDAOImpl<doUser>();

			List<busParameter> llstbusParameters = new ArrayList<busParameter>();
			llstbusParameters.add(new busParameter(doUser.enmUser.emailAddress.toString(), this.idoUser.getEmailAddress(), busConstant.DataTypeString));
			llstbusParameters.add(new busParameter(doUser.enmUser.networkValue.toString(), this.idoUser.getNetworkValue(), busConstant.DataTypeString));

			List<doUser> llstdoUser = lBaseDAOImpl.select(doUser.class, busConstant.doUser, llstbusParameters);

			if (llstdoUser != null && llstdoUser.size() > 0)
				this.addMessage(busConstant.IsDuplicateEmailAddressMessageId);
		}
	}
	
	private void isEmailAddressEntered() {
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(this.idoUser.getEmailAddress()))
			this.addMessage(busConstant.IsForgotPasswordEmailAddressEntered);
	}

	private void isEmailAddressValid() {
		// TODO Auto-generated method stub
		if(!StringUtils.isEmpty(this.idoUser.getEmailAddress()))
		{
			busBaseDAOImpl<doUser> lBaseDAOImpl = new busBaseDAOImpl<doUser>();

			List<busParameter> llstbusParameters = new ArrayList<busParameter>();
			llstbusParameters.add(new busParameter(doUser.enmUser.emailAddress.toString(), this.idoUser.getEmailAddress(), busConstant.DataTypeString));

			List<doUser> llstdoUser = lBaseDAOImpl.select(doUser.class, busConstant.doUser, llstbusParameters);

			if (llstdoUser.size() == 0)
				this.addMessage(busConstant.IsForgotPasswordEmailAddressValid);
		}		
	}

	//end region validations
}
