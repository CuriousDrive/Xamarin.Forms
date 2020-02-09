package com.org.panthers.service;

import java.util.ArrayList;
import java.util.List;

import com.org.panthers.business.busAnnouncement;
import com.org.panthers.business.busAutocompleteListItem;
import com.org.panthers.business.busCode;
import com.org.panthers.business.busComment;
import com.org.panthers.business.busConstant;
import com.org.panthers.business.busNotification;
import com.org.panthers.business.busQuestion;
import com.org.panthers.business.busQuestionAnswer;
import com.org.panthers.business.busRole;
import com.org.panthers.business.busTag;
import com.org.panthers.business.busUser;
import com.org.panthers.business.busUserRole;
import com.org.panthers.entity.doAnnouncement;
import com.org.panthers.entity.doCode;
import com.org.panthers.entity.doNotification;
import com.org.panthers.entity.doRole;
import com.org.panthers.entity.doTag;
import com.org.panthers.entity.doUser;
import com.org.panthers.entity.doUserRole;
import com.org.panthers.framework.busBaseDAOImpl;
import com.org.panthers.framework.busDBFunctions;
import com.org.panthers.framework.busParameter;

import net.casper.data.model.CDataRowSet;

public class UserService {

	/** this method loads all Users from User table */
	public List<busUser> loadUsers() {

		busBaseDAOImpl<doUser> baseDAOImpl = new busBaseDAOImpl<doUser>();
		busUser lbusUser = new busUser();
		List<busUser> llstBusEmploeyees = lbusUser.getCollection(baseDAOImpl.getAll(doUser.class));
		return llstBusEmploeyees;
	}

	/**
	 * this method loads User based it primary key passed from User table
	 */
	public busUser loadUser(int id) {
		busUser lbusUser = new busUser();
		lbusUser.idoUser.setUserId(id);
		lbusUser.idoUser = lbusUser.idoUser.get();
		return lbusUser;
	}

	/**
	 * this method loads User based it primary key passed from User table
	 */
	public int deleteUser(int id) {
		busUser lbusUser = new busUser();
		lbusUser.idoUser.setUserId(id);

		return lbusUser.idoUser.delete();

	}

	/**
	 * this method updates User based it's object passed from front end
	 */
	public int updateUser(busUser abusUser) {
		
		return abusUser.idoUser.update();

	}
	
	/**
	 * this method updates User based it's object passed from front end
	 */
	public int updateUserProfilePicture(int id) {
		
		busDBFunctions ldbFunctions = new busDBFunctions();
		String[] primaryKeys = { "USER_ID" };

		// get thread id
		List<busParameter> llstbusParameters = new ArrayList<busParameter>();
		llstbusParameters.add(new busParameter(doUser.enmUser.pictureUrl.toString(), "\\ProfilePictures\\pp_"+ id +".jpg", busConstant.DataTypeString));
		llstbusParameters.add(new busParameter(doUser.enmUser.userId.toString(), String.valueOf(id), busConstant.DataTypeInteger));
		
		ldbFunctions.DBExecute(busConstant.updateUserProfilePicture, llstbusParameters, primaryKeys,busConstant.Update);
		
		return 1;
	}
	
	/**
	 * this method updates User based it's object passed from front end
	 */
	public int updateUserNotifications(int aintUserId) {
		
		return new busUser().updateUserNotifications(aintUserId);
	}

	/**
	 * this method inserts User based it's object passed from front end
	 */
	public int insertUser(busUser abusUser) {
		
		return abusUser.idoUser.insert();
	}
	
	/*
	 * this method inserts User based it's object passed from front end
	 */
	public busUser enrollUser(busUser abusUser) {

		if(abusUser.validateEnrollUser())
		{
			abusUser.enrollUser();
			abusUser.loadUserRole();
		}
			
		return abusUser;
	}
	
	/*
	 * this method inserts User based it's object passed from front end
	 */
	public busUser validateUser(busUser abusUser) {

		if(abusUser.validateLoginUser())
			abusUser.loginUser();
		return abusUser;
	}

	/*
	 * this method inserts User based it's object passed from front end
	 */
	public busUser registerOrLoginSocialUser(busUser abusUser) {

		abusUser.loginUser();
		if(abusUser.ilstbusMessages.size() == 0)
			return abusUser;
		else{
			abusUser.enrollUser();
			abusUser.loadUserRole();
			return abusUser;
		}
	}

	
	/** this method loads all Roles from Role table */
	public List<busRole> loadRoles() {

		busBaseDAOImpl<doRole> baseDAOImpl = new busBaseDAOImpl<doRole>();
		busRole lbusRole = new busRole();
		List<busRole> llstBusEmploeyees = lbusRole.getCollection(baseDAOImpl.getAll(doRole.class));
		return llstBusEmploeyees;
	}

	/**
	 * this method loads Role based it primary key passed from Role table
	 */
	public busRole loadRole(int id) {
		busRole lbusRole = new busRole();
		lbusRole.idoRole.setRoleId(id);
		lbusRole.idoRole = lbusRole.idoRole.get();
		return lbusRole;
	}

	/**
	 * this method loads Role based it primary key passed from Role table
	 */
	public int deleteRole(int id) {
		busRole lbusRole = new busRole();
		lbusRole.idoRole.setRoleId(id);

		return lbusRole.idoRole.delete();

	}

	/**
	 * this method updates Role based it's object passed from front end
	 */
	public int updateRole(busRole abusRole) {
		
		return abusRole.idoRole.update();
	}

	/**
	 * this method inserts Role based it's object passed from front end
	 */
	public int insertRole(busRole abusRole) {

		return abusRole.idoRole.insert();
	}

	/** this method loads all UserRoles from UserRole table */
	public List<busUserRole> loadUserRoles() {

		busBaseDAOImpl<doUserRole> baseDAOImpl = new busBaseDAOImpl<doUserRole>();
		busUserRole lbusUserRole = new busUserRole();
		List<busUserRole> llstBusEmploeyees = lbusUserRole.getCollection(baseDAOImpl.getAll(doUserRole.class));
		return llstBusEmploeyees;
	}

	/**
	 * this method loads UserRole based it primary key passed from UserRole
	 * table
	 */
	public busUserRole loadUserRole(int id) {
		busUserRole lbusUserRole = new busUserRole();
		lbusUserRole.idoUserRole.setUserRoleId(id);
		lbusUserRole.idoUserRole = lbusUserRole.idoUserRole.get();
		return lbusUserRole;
	}

	/**
	 * this method loads UserRole based it primary key passed from UserRole
	 * table
	 */
	public int deleteUserRole(int id) {
		busUserRole lbusUserRole = new busUserRole();
		lbusUserRole.idoUserRole.setUserRoleId(id);

		return lbusUserRole.idoUserRole.delete();

	}

	/**
	 * this method updates UserRole based it's object passed from front end
	 */
	public int updateUserRole(busUserRole abusUserRole) {
		
		return abusUserRole.idoUserRole.update();
	}

	/**
	 * this method inserts UserRole based it's object passed from front end
	 */
	public int insertUserRole(busUserRole abusUserRole) {

		return abusUserRole.idoUserRole.insert();
	}

	public busUser getUserProfile(int aintUserId, int aintLoggedInUserId) {
		busUser lbusUser = new busUser().getUserProfile(aintUserId);
		lbusUser.assignOwner(aintLoggedInUserId);
		return lbusUser;
	}
	
	public List<busUser> getUsers(String astrSearchTerm, String astrIsAutocomplete,String astrRole)
	{
		CDataRowSet ldrUsers = null;
		List<busParameter> llstbusParameters = new ArrayList<busParameter>();
		
		if(astrRole.equals("All"))
		{
			llstbusParameters.add(new busParameter(doUser.enmUser.displayName.toString(),"%" + astrSearchTerm + "%", busConstant.DataTypeString));
			if(astrIsAutocomplete.equals("Y"))
				llstbusParameters.add(new busParameter(doUser.enmUser.userId.toString(),"15", busConstant.DataTypeInteger));
			else
				llstbusParameters.add(new busParameter(doUser.enmUser.userId.toString(),"200", busConstant.DataTypeInteger));
			
			ldrUsers = new busDBFunctions().DBExecute(busConstant.getAllUsers, llstbusParameters, null,busConstant.Select);
		}
		else
		{
			llstbusParameters.add(new busParameter(doRole.enmRole.roleName.toString(), astrRole, busConstant.DataTypeString));
			llstbusParameters.add(new busParameter(doUser.enmUser.displayName.toString(), "%" + astrSearchTerm + "%", busConstant.DataTypeString));
			
			if(astrIsAutocomplete.equals("Y"))
				llstbusParameters.add(new busParameter(doUser.enmUser.userId.toString(),"15", busConstant.DataTypeInteger));
			else
				llstbusParameters.add(new busParameter(doUser.enmUser.userId.toString(),"200", busConstant.DataTypeInteger));
			
			ldrUsers = new busDBFunctions().DBExecute(busConstant.getUsersByRole, llstbusParameters, null,busConstant.Select);
		}
				
		List<busUser> llstbusUsers = new ArrayList<busUser>();
		
		try {
			while(ldrUsers.next())
			{
				busUser lbusUser = new busUser();
				lbusUser.ibusUserRole = new busUserRole();
				
				// load table columns --
				lbusUser.idoUser.setUserId(ldrUsers.getInt("USER_ID"));
				lbusUser.idoUser.setDisplayName(ldrUsers.getString("DISPLAY_NAME"));
				lbusUser.idoUser.setFirstName(ldrUsers.getString("FIRST_NAME"));
				lbusUser.idoUser.setLastName(ldrUsers.getString("LAST_NAME"));
				lbusUser.idoUser.setPictureUrl(ldrUsers.getString("PICTURE_URL"));
				lbusUser.idoUser.setNetworkValue(ldrUsers.getString("NETWORK_VALUE"));

				// load other details
				lbusUser.iintTotalPoint = ldrUsers.getInt("POINTS");
				lbusUser.ibusUserRole.idoUserRole.setRoleId(ldrUsers.getInt("ROLE_ID"));
				lbusUser.ibusUserRole.istrUserGroup = ldrUsers.getString("DESCRIPTION");

				// load URL title
				lbusUser.istrURLTitle = lbusUser.idoUser.getFirstName().toLowerCase() + "_" + lbusUser.idoUser.getLastName().toLowerCase();
				llstbusUsers.add(lbusUser);
			}
									
			return llstbusUsers;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

	public List<busAutocompleteListItem> getAutocompleteList(String astrSearchTerm, String astrRole)
	{
		CDataRowSet ldrAutocompleteList = null;
		List<busParameter> llstbusParameters = new ArrayList<busParameter>();

		if(astrRole.equals(busConstant.RoleStudent) || astrRole.equals(busConstant.RoleModerator))
		{
			llstbusParameters.add(new busParameter("", "%" + astrSearchTerm + "%",busConstant.DataTypeString));
			ldrAutocompleteList = new busDBFunctions().DBExecute(busConstant.getStudentsAutocompleteList, llstbusParameters, null,busConstant.Select);
		}
		if(astrRole.equals(busConstant.RoleTeacher) || astrRole.equals(busConstant.RoleAdmin))
		{
			llstbusParameters.add(new busParameter("", "%" + astrSearchTerm + "%",busConstant.DataTypeString));
			ldrAutocompleteList = new busDBFunctions().DBExecute(busConstant.getTeachersAutocompleteList, llstbusParameters, null,busConstant.Select);
		}
				
		List<busAutocompleteListItem> llstAutocompleteListItem = new ArrayList<busAutocompleteListItem>();
		
		try {
			while(ldrAutocompleteList.next())
			{
				busAutocompleteListItem lbusAutocompleteList = 
						new busAutocompleteListItem(ldrAutocompleteList.getString("LABEL"), ldrAutocompleteList.getString("USER_GROUP_TYPE"), ldrAutocompleteList.getString("VALUE"));
				
				llstAutocompleteListItem.add(lbusAutocompleteList);
			}
									
			return llstAutocompleteListItem;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

	
	public List<busUser> getUsersByUserGroupId(int aintUserGroupId)
	{
		CDataRowSet ldrUsers = null;
		List<busParameter> llstbusParameters = new ArrayList<busParameter>();

		llstbusParameters.add(new busParameter("", String.valueOf(aintUserGroupId), busConstant.DataTypeInteger));
		ldrUsers = new busDBFunctions().DBExecute(busConstant.getUsersByUserGroupId, llstbusParameters, null, busConstant.Select);
				
		List<doUser> llstUsers = new busBaseDAOImpl<doUser>().getDataObjectCollectionFromDataSet(ldrUsers, doUser.class);
		
		return new busUser().getCollection(llstUsers);
	}
	
	public List<busUser> getUsersByYear(String astrYear)
	{
		CDataRowSet ldrUsers = null;
		List<busParameter> llstbusParameters = new ArrayList<busParameter>();

		llstbusParameters.add(new busParameter("", astrYear, busConstant.DataTypeString));
		ldrUsers = new busDBFunctions().DBExecute(busConstant.getUsersByYear, llstbusParameters, null, busConstant.Select);
				
		List<doUser> llstUsers = new busBaseDAOImpl<doUser>().getDataObjectCollectionFromDataSet(ldrUsers, doUser.class);
		
		return new busUser().getCollection(llstUsers);
	}

	
	public List<busQuestion> getUserQuestions(int aintUserId) {
		
		return new busUser().getUserQuestions(aintUserId);
	}
	
	public List<busQuestionAnswer> getUserQuestionAnswers(int aintUserId) {
		
		return new busUser().getUserQuestionAnswers(aintUserId);
	}

	public List<busComment> getUserComments(int aintUserId) {
	
		return new busUser().getUserComments(aintUserId);
	}

	public busUser forgotPassword(busUser abusUser) {
		// TODO Auto-generated method stub
		if(abusUser.validateForgotPassword())
		{
			new busUser().forgotPassword(abusUser);
		}
			
		return abusUser;
	}

	/** this method loads all Codes from Code table */
	public List<busNotification> loadNotification() {

		busBaseDAOImpl<doNotification> baseDAOImpl = new busBaseDAOImpl<doNotification>();
		busNotification lbusNotification = new busNotification();
		List<busNotification> llstbusNotification = lbusNotification.getCollection(baseDAOImpl.getAll(doNotification.class));
		return llstbusNotification;
	}
	
	public List<busNotification> getUserNotifications(int aintUserId) {
		return new busUser().getUserNotifications(aintUserId);
	}
	
	public List<busTag> loadTags() {

		busBaseDAOImpl<doTag> baseDAOImpl = new busBaseDAOImpl<doTag>();
		busTag lbusTag = new busTag();
		List<busTag> llstbusTag = lbusTag.getCollection(baseDAOImpl.getAll(doTag.class));
		return llstbusTag;
	}
	
	public busUser getUserByEmailAndOTP(busUser abusUser) {
		// TODO Auto-generated method stub
		abusUser.loadUserByEmailAndOTP();		
		return abusUser;
	}

	
	public busUser setNewPassword(busUser abusUser) {
		// TODO Auto-generated method stub
		abusUser.setNewPassword();		
		return abusUser;
	}
	
	public String getSaltValue(String astrEmailAddress) {
		// TODO Auto-generated method stub
		return new busUser().getSaltValue(astrEmailAddress);

	}
}
