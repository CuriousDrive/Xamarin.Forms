package com.org.panthers.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import net.casper.data.model.CDataRowSet;

import com.org.panthers.business.busClass;
import com.org.panthers.business.busCode;
import com.org.panthers.business.busCodeValue;
import com.org.panthers.business.busComment;
import com.org.panthers.business.busConstant;
import com.org.panthers.business.busFeedback;
import com.org.panthers.business.busRole;
import com.org.panthers.business.busThread;
import com.org.panthers.business.busUser;
import com.org.panthers.business.busUserGroup;
import com.org.panthers.business.busUserGroupDetail;
import com.org.panthers.business.busUserRole;
import com.org.panthers.entity.doClass;
import com.org.panthers.entity.doCode;
import com.org.panthers.entity.doCodeValue;
import com.org.panthers.entity.doComment;
import com.org.panthers.entity.doFeedback;
import com.org.panthers.entity.doQuestion;
import com.org.panthers.entity.doRole;
import com.org.panthers.entity.doThread;
import com.org.panthers.entity.doUser;
import com.org.panthers.entity.doUserGroup;
import com.org.panthers.entity.doUserGroupDetail;
import com.org.panthers.entity.doUserRole;
import com.org.panthers.framework.busBaseDAOImpl;
import com.org.panthers.framework.busDBFunctions;
import com.org.panthers.framework.busMessage;
import com.org.panthers.framework.busParameter;
import com.org.panthers.framework.busUtil;

public class AdminService {

	/** this method loads all Categories from Class table */
	public List<busClass> loadClasss() {

		busBaseDAOImpl<doClass> baseDAOImpl = new busBaseDAOImpl<doClass>();
		busClass lbusClass = new busClass();
		List<busClass> llstbusClass = lbusClass.getCollection(baseDAOImpl.getAll(doClass.class));
		return llstbusClass;
	}

	
	/** this method loads all categories from Class table */
	public List<busClass> getClasses() {

		busBaseDAOImpl<doClass> lBaseDAOImplClass = new busBaseDAOImpl<doClass>();
		List<doClass> llstClass = lBaseDAOImplClass.getAll(doClass.class);

		return new busClass().getCollection(llstClass);
		
	}
	
	/**
	 * this method loads Class based it primary key passed from Class
	 * table
	 */
	public busClass getClass(int id) {
		busClass lbusClass = new busClass();
		lbusClass.idoClass.setClassId(id);
		lbusClass.idoClass = lbusClass.idoClass.get();
		return lbusClass;
	}
	
	/**
	 * this method gets Message based it primary key passed from Message
	 * table
	 */
	public busMessage getMessage(int id) {
		busMessage lbusMessage = new busMessage();
		lbusMessage.idoMessage.setMessageId(id);
		lbusMessage.idoMessage = lbusMessage.idoMessage.get();
		return lbusMessage;
	}

	/**
	 * this method loads Class based it primary key passed from Class
	 * table
	 */
	public int deleteClass(int id) {
		busClass lbusClass = new busClass();
		lbusClass.idoClass.setClassId(id);

		return lbusClass.idoClass.delete();

	}
	
	public int deleteClassNew(int id) {
		
		busDBFunctions ldbFunctions = new busDBFunctions();
		String[] primaryKeys = { "CLASS_ID" };

		List<busParameter> llstbusParameters = new ArrayList<busParameter>();
		llstbusParameters.add(new busParameter(doClass.enmClass.classId.toString(), String.valueOf(id), busConstant.DataTypeInteger));
		
		ldbFunctions.DBExecute(busConstant.deleteClass, llstbusParameters, primaryKeys,busConstant.Delete);
		
		return 1;

	}

	/**
	 * this method updates Class based it's object passed from front end
	 */
	public int updateClass(busClass abusClass) {
		
		return abusClass.idoClass.update();
	}

	/**
	 * this method inserts Class based it's object passed from front end
	 */
	public int createClass(busClass abusClass) {
		
		if(abusClass.validateInsertClass())
		{
			abusClass.addMessage(busConstant.SuccessClasses);
			return abusClass.idoClass.insert();
		}
		else
			return 0;

	}
	
	/** this method loads all Threads from Thread table */
	public List<busThread> loadThreads() {

		busBaseDAOImpl<doThread> baseDAOImpl = new busBaseDAOImpl<doThread>();
		busThread lbusThread = new busThread();
		List<busThread> llstbusThread = lbusThread.getCollection(baseDAOImpl.getAll(doThread.class));
		return llstbusThread;
	}

	/** this method loads all Threads from Thread table */
	public List<busThread> loadApprovedThreads() {

		return new busThread().loadApprovedThreads();
	}

	
	/**
	 * this method loads Thread based it primary key passed from Thread
	 * table
	 */
	public busThread loadThread(int id) {
		busThread lbusThread = new busThread();
		lbusThread.idoThread.setThreadId(id);
		lbusThread.idoThread = lbusThread.idoThread.get();
		return lbusThread;
	}

	/**
	 * this method loads Thread based it primary key passed from Thread
	 * table
	 */	
	public int deleteThread(int id) {
		busThread lbusThread = new busThread();
		lbusThread.idoThread.setThreadId(id);

		return lbusThread.idoThread.delete();

	}

	/**
	 * this method updates Thread based it's object passed from front end
	 */
	public int updateThread(busThread abusThread) {

		return abusThread.idoThread.update();
	}

	/**
	 * this method inserts Thread based it's object passed from front end
	 */
	public int insertThread(busThread abusThread) {

		return abusThread.idoThread.insert();
	}
	

	/** this method loads all Codes from Code table */
	public List<busCode> loadCodes() {

		busBaseDAOImpl<doCode> baseDAOImpl = new busBaseDAOImpl<doCode>();
		busCode lbusCode = new busCode();
		List<busCode> llstbusCode = lbusCode.getCollection(baseDAOImpl.getAll(doCode.class));
		return llstbusCode;
	}

	/**
	 * this method loads Code based it primary key passed from Code
	 * table
	 */
	public busCode loadCode(int id) {
		busCode lbusCode = new busCode();
		lbusCode.idoCode = lbusCode.idoCode.get();
		return lbusCode;
	}

	/**
	 * this method loads Code based it primary key passed from Code
	 * table
	 */
	public int deleteCode(int id) {
		busCode lbusCode = new busCode();
		lbusCode.idoCode.setCodeId(id);

		return lbusCode.idoCode.delete();

	}

	/**
	 * this method updates Code based it's object passed from front end
	 */
	public int updateCode(busCode abusCode) {

		return abusCode.idoCode.update();
	}

	/**
	 * this method inserts Code based it's object passed from front end
	 */
	public int insertCode(busCode abusCode) {

		return abusCode.idoCode.insert();
	}
	
	/** this method loads all CodeValues from CodeValue table */
	public List<busCodeValue> loadCodeValues() {

		busBaseDAOImpl<doCodeValue> baseDAOImpl = new busBaseDAOImpl<doCodeValue>();
		busCodeValue lbusCodeValue = new busCodeValue();
		List<busCodeValue> llstbusCodeValues = lbusCodeValue.getCollection(baseDAOImpl.getAll(doCodeValue.class));
		return llstbusCodeValues;
	}

	/**
	 * this method loads CodeValue based it primary key passed from CodeValue
	 * table
	 */
	public busCodeValue loadCodeValue(int id) {
		busCodeValue lbusCodeValue = new busCodeValue();
		lbusCodeValue.idoCodeValue.setCodeValueId(id);
		lbusCodeValue.idoCodeValue = lbusCodeValue.idoCodeValue.get();
		return lbusCodeValue;
	}
	
	/**
	 * this method loads CodeValue based it primary key passed from CodeValue
	 * table
	 */
	public List<busCodeValue> getCodeValues(int codeId) {
		
		busBaseDAOImpl<doCodeValue> lBaseDAOImpl = new busBaseDAOImpl<doCodeValue>();

		List<busParameter> llstbusParameters = new ArrayList<busParameter>();
		llstbusParameters.add(new busParameter(doCodeValue.enmCodeValue.codeId.toString(), String.valueOf(codeId), busConstant.DataTypeInteger));
		
		List<doCodeValue> llstCodeValue = lBaseDAOImpl.select(doCodeValue.class, busConstant.doCodeValue, llstbusParameters);
		
		return new busCodeValue().getCollection(llstCodeValue);
	}

	/**
	 * this method loads CodeValue based it primary key passed from CodeValue
	 * table
	 */
	public int deleteCodeValue(int id) {
		busCodeValue lbusCodeValue = new busCodeValue();
		lbusCodeValue.idoCodeValue.setCodeValueId(id);

		return lbusCodeValue.idoCodeValue.delete();

	}

	/**
	 * this method updates CodeValue based it's object passed from front end
	 */
	public int updateCodeValue(busCodeValue abusCodeValue) {
		
		return abusCodeValue.idoCodeValue.update();
	}

	/**
	 * this method inserts CodeValue based it's object passed from front end
	 */
	public int insertCodeValue(busCodeValue abusCodeValue) {

		return abusCodeValue.idoCodeValue.insert();
	}
	
	public busCodeValue getConstants(busCodeValue abusCodeValue){
		abusCodeValue.loadConstats();
		return abusCodeValue;
	}
	
	/** 
	 * this method loads all Feedbacks from Feedbacks table 
	 * */
	public busFeedback loadVerifiedFeedbacks() {

		busDBFunctions ldbFunctions = new busDBFunctions();
		String[] primaryKeys = { "FEEDBACK_ID" };
		CDataRowSet lCDataRowset = ldbFunctions.DBExecute(busConstant.loadVerifiedFeedbacks, null, primaryKeys,busConstant.Select);
		busFeedback lbusFeedback = new busFeedback();
		lbusFeedback.ilstVerifiedFeedbacks = new ArrayList<busFeedback>();

		try {
			while (lCDataRowset.next()) {

				busFeedback lbusVerifiedFeedback = new busFeedback();
				lbusVerifiedFeedback.idoFeedback = new doFeedback();
				
				lbusVerifiedFeedback.idoFeedback.setFeedbackId(lCDataRowset.getInt("FEEDBACK_ID"));
				lbusVerifiedFeedback.idoFeedback.setFeedback(lCDataRowset.getString("FEEDBACK"));
				lbusVerifiedFeedback.idoFeedback.setUserId(lCDataRowset.getInt("USER_ID"));
				lbusVerifiedFeedback.idoFeedback.setValue(lCDataRowset.getInt("VALUE"));
				
				lbusVerifiedFeedback.istrDisplayName = lCDataRowset.getString("DISPLAY_NAME");
				lbusVerifiedFeedback.istrURLTitle = lCDataRowset.getString("FIRST_NAME").toLowerCase() + "_" + lCDataRowset.getString("LAST_NAME").toLowerCase();

				lbusFeedback.ilstVerifiedFeedbacks.add(lbusVerifiedFeedback);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lbusFeedback;

	}

	/** 
	 * this method loads all Feedbacks from Feedbacks table 
	 * */
	public busFeedback loadFeedbacksToVerify() {

		busDBFunctions ldbFunctions = new busDBFunctions();
		String[] primaryKeys = { "FEEDBACK_ID" };
		CDataRowSet lCDataRowset = ldbFunctions.DBExecute(busConstant.loadFeedbacksToVerify, null, primaryKeys,busConstant.Select);
		busFeedback lbusFeedback = new busFeedback();
		lbusFeedback.ilstFeedbacksToVerify = new ArrayList<busFeedback>();
		boolean lblnFirst = true;
		try {
			while (lCDataRowset.next()) {

				if(lblnFirst)
				{					
					lbusFeedback.idoFeedback.setFeedbackId(lCDataRowset.getInt("FEEDBACK_ID"));
					lbusFeedback.idoFeedback.setFeedback(lCDataRowset.getString("FEEDBACK"));
					
					if(lCDataRowset.getInt("USER_ID") != null)
						lbusFeedback.idoFeedback.setUserId(lCDataRowset.getInt("USER_ID"));
					if(lCDataRowset.getInt("CREATED_BY") != null)
						lbusFeedback.idoFeedback.setCreatedBy(lCDataRowset.getInt("CREATED_BY"));
					if(lCDataRowset.getDate("CREATED_DATE") != null)
						lbusFeedback.idoFeedback.setCreatedDate(lCDataRowset.getDate("CREATED_DATE"));
					if(lCDataRowset.getString("DISPLAY_NAME") != null)
						lbusFeedback.istrDisplayName = lCDataRowset.getString("DISPLAY_NAME");
					if(lCDataRowset.getString("FIRST_NAME") !=  null && lCDataRowset.getString("LAST_NAME") != null)
						lbusFeedback.istrURLTitle = lCDataRowset.getString("FIRST_NAME").toLowerCase() + "_" + lCDataRowset.getString("LAST_NAME").toLowerCase();
					
					lblnFirst = false;
					
					continue;
				}
				
				busFeedback lbusFeedbackToVerify = new busFeedback();
				
				lbusFeedbackToVerify.idoFeedback.setFeedbackId(lCDataRowset.getInt("FEEDBACK_ID"));
				lbusFeedbackToVerify.idoFeedback.setFeedback(lCDataRowset.getString("FEEDBACK"));
				
				if(lCDataRowset.getInt("USER_ID") != null)
					lbusFeedbackToVerify.idoFeedback.setUserId(lCDataRowset.getInt("USER_ID"));
				if(lCDataRowset.getInt("CREATED_BY") != null)
					lbusFeedbackToVerify.idoFeedback.setCreatedBy(lCDataRowset.getInt("CREATED_BY"));
				if(lCDataRowset.getDate("CREATED_DATE") != null)
					lbusFeedbackToVerify.idoFeedback.setCreatedDate(lCDataRowset.getDate("CREATED_DATE"));
				if(lCDataRowset.getString("DISPLAY_NAME") != null)
					lbusFeedbackToVerify.istrDisplayName = lCDataRowset.getString("DISPLAY_NAME");
				if(lCDataRowset.getString("FIRST_NAME") !=  null && lCDataRowset.getString("LAST_NAME") != null)
					lbusFeedbackToVerify.istrURLTitle = lCDataRowset.getString("FIRST_NAME").toLowerCase() + "_" + lCDataRowset.getString("LAST_NAME").toLowerCase();

				lbusFeedback.ilstFeedbacksToVerify.add(lbusFeedbackToVerify);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lbusFeedback;

	}

	/**
	 * this method loads Feedback based it primary key passed from User table
	 */
	public busFeedback loadFeedback(int id) {
		busFeedback lbusFeedback = new busFeedback();
		lbusFeedback.idoFeedback.setFeedbackId(id);
		lbusFeedback.idoFeedback = lbusFeedback.idoFeedback.get();
		return lbusFeedback;
	}

	/**
	 * this method loads Feedback based it primary key passed from User table
	 */
	public int deleteFeedback(int id) {
		
		busFeedback lbusFeedback = new busFeedback();
		lbusFeedback.idoFeedback.setFeedbackId(id);

		return lbusFeedback.idoFeedback.delete();
	}

	/**
	 * this method updates Feedback based it's object passed from front end
	 */
	public int updateFeedback(busFeedback abusFeedback) {
		
		return abusFeedback.idoFeedback.update();
	}

	/**
	 * this method inserts Feedback based it's object passed from front end
	 */
	public int insertFeedback(busFeedback abusFeedback) {
		
		if(abusFeedback.validateInsertFeedback())
		{
			abusFeedback.addMessage(busConstant.SuccessFeedback);
			return abusFeedback.idoFeedback.insert();
		}
		else
			return 0;
	}
	
	/** 
	 * this method loads all Roles from Code table 
	 * */
	public List<busRole> loadRoles() {

		busBaseDAOImpl<doRole> baseDAOImpl = new busBaseDAOImpl<doRole>();
		busRole lbusRole = new busRole();
		List<busRole> llstbusRole = lbusRole.getCollection(baseDAOImpl.getAll(doRole.class));
		return llstbusRole;
	}
	
	/**
	 * this method loads UserGroup based it primary key passed from User table
	 */
	public busUserGroup loadUserGroup(int id) {
		
		busUserGroup lbusUserGroup = new busUserGroup();
		lbusUserGroup.idoUserGroup.setUserGroupId(id);
		lbusUserGroup.idoUserGroup = lbusUserGroup.idoUserGroup.get();
		lbusUserGroup.loadUserGroupDetail();
		
		return lbusUserGroup;
	}
	
	/**
	 * this method loads UserGroup based it primary key passed from User table
	 */
	public List<busUserGroup> getUserGroups() {

		busBaseDAOImpl<doUserGroup> baseDAOImpl = new busBaseDAOImpl<doUserGroup>();
		List<busUserGroup> llstbusUserGroups = new busUserGroup().getCollection(baseDAOImpl.getAll(doUserGroup.class));
		return llstbusUserGroups;
	}

	/**
	 * this method loads UserGroup based it primary key passed from User table
	 */
	public List<busUserGroup> getUserGroupsByName(String astrSearchTerm) {

		CDataRowSet ldrUserGroups = null;
		List<busParameter> llstbusParameters = new ArrayList<busParameter>();

		llstbusParameters.add(new busParameter(doUserGroup.enmUserGroup.groupName.toString(), "%" + astrSearchTerm + "%", busConstant.DataTypeString));
		ldrUserGroups = new busDBFunctions().DBExecute(busConstant.getUserGroupsByName, llstbusParameters, null, busConstant.Select);

		List<busUserGroup> llstbusUserGroups = new ArrayList<busUserGroup>();

		try {
			while(ldrUserGroups.next())
			{
				busUserGroup lbusUserGroup = new busUserGroup();
				
				// load table columns --
				lbusUserGroup.idoUserGroup.setUserGroupId(ldrUserGroups.getInt("USER_GROUP_ID"));
				lbusUserGroup.idoUserGroup.setGroupName(ldrUserGroups.getString("GROUP_NAME"));
				lbusUserGroup.idoUserGroup.setGroupDescription(ldrUserGroups.getString("GROUP_DESCRIPTION"));
				lbusUserGroup.idoUserGroup.setGroupStatusValue(ldrUserGroups.getString("GROUP_STATUS_VALUE"));
				lbusUserGroup.istrGroupStatusDescription = ldrUserGroups.getString("DESCRIPTION");
				
				if(lbusUserGroup.idoUserGroup.groupDescription.length() > 70)
					lbusUserGroup.idoUserGroup.groupDescription = StringUtils.substring(lbusUserGroup.idoUserGroup.groupDescription, 0, 70) + "...";
				
				// load other details
				llstbusUserGroups.add(lbusUserGroup);
			}
									
			return llstbusUserGroups;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public List<busUserGroup> getActiveUserGroups() {
		
		busBaseDAOImpl<doUserGroup> lBaseDAOImpl = new busBaseDAOImpl<doUserGroup>();

		List<busParameter> llstbusParameters = new ArrayList<busParameter>();
		llstbusParameters.add(new busParameter(doUserGroup.enmUserGroup.groupStatusValue.toString(),busConstant.GroupStatusActive, busConstant.DataTypeString));
		
		List<doUserGroup> llstUserGroup = lBaseDAOImpl.select(doUserGroup.class, busConstant.doUserGroup, llstbusParameters);

		return new busUserGroup().getCollection(llstUserGroup);
		
	}

	/**
	 * this method loads UserGroup based it primary key passed from User table
	 */
	public int deleteUserGroup(int id) {
		
		busUserGroup lbusUserGroup = new busUserGroup();
		lbusUserGroup.idoUserGroup.setUserGroupId(id);

		return lbusUserGroup.idoUserGroup.delete();
	}
	
	public int deleteUserGroupDetail(int userGroupId) {
		
		busDBFunctions ldbFunctions = new busDBFunctions();
		String[] primaryKeys = { "USER_GROUP_DETAIL_ID" };

		List<busParameter> llstbusParameters = new ArrayList<busParameter>();
		llstbusParameters.add(new busParameter(doUserGroupDetail.enmUserGroupDetail.userGroupId.toString(), String.valueOf(userGroupId), busConstant.DataTypeInteger));
		
		ldbFunctions.DBExecute(busConstant.deleteUserGroupDetail, llstbusParameters, primaryKeys,busConstant.Delete);
		
		return 1;

	}

	/**
	 * this method updates UserGroup based it's object passed from front end
	 */
	public busUserGroup updateUserGroup(busUserGroup abusUserGroup) {
		
		abusUserGroup.idoUserGroup.update();
		
		//delete all user group detail
		deleteUserGroupDetail(abusUserGroup.idoUserGroup.userGroupId);
		
		//insert new user group detail
		insertUserGroupDetail(abusUserGroup);
		
		abusUserGroup.addMessage(busConstant.UpdatedSuccessfully);
		
		return abusUserGroup;
	}
	
	public void insertUserGroupDetail(busUserGroup abusUserGroup)
	{
		String[] strArrUserIds = abusUserGroup.istrUserIds.split(",");
		
		for (String strUserId : strArrUserIds) {
			
			busUserGroupDetail lbusUserGroupDetail = new busUserGroupDetail();
			lbusUserGroupDetail.idoUserGroupDetail.iintUserId = abusUserGroup.idoUserGroup.iintUserId;
			lbusUserGroupDetail.idoUserGroupDetail.userGroupId = abusUserGroup.idoUserGroup.userGroupId;
			lbusUserGroupDetail.idoUserGroupDetail.userId = Integer.parseInt(strUserId);
		
			lbusUserGroupDetail.idoUserGroupDetail.insert();
		}
	}

	/**
	 * this method inserts UserGroup based it's object passed from front end
	 */
	public busUserGroup createUserGroup(busUserGroup abusUserGroup) {
		
		if(abusUserGroup.validateInsertUserGroup())
		{
			//abusUserGroup.addMessage(busConstant.SuccessUserGroup);
			abusUserGroup.idoUserGroup.groupStatusValue = busConstant.GroupStatusActive;
			abusUserGroup.idoUserGroup.groupStatusId = busConstant.GroupStatusId;
			
			abusUserGroup.idoUserGroup.insert();
			insertUserGroupDetail(abusUserGroup);
			
			abusUserGroup.addMessage(busConstant.SavedSuccessfully);
		}

		return abusUserGroup;
	}
	
	/**
	 * this method loads UserGroup based it primary key passed from User table
	 */
	public busUserGroupDetail loadUserGroupDetail(int id) {
		busUserGroupDetail lbusUserGroupDetail = new busUserGroupDetail();
		lbusUserGroupDetail.idoUserGroupDetail.setUserGroupDetailId(id);
		lbusUserGroupDetail.idoUserGroupDetail = lbusUserGroupDetail.idoUserGroupDetail.get();
		return lbusUserGroupDetail;
	}

}
