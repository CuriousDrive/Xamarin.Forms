package com.org.panthers.business;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.org.panthers.entity.doAnnouncement;
import com.org.panthers.entity.doUserGroup;
import com.org.panthers.framework.busBase;
import com.org.panthers.framework.busBaseDAOImpl;
import com.org.panthers.framework.busDBFunctions;
import com.org.panthers.framework.busParameter;

import net.casper.data.model.CDataGridException;
import net.casper.data.model.CDataRowSet;

public class busUserGroup extends busBase{

	public doUserGroup idoUserGroup;
	public List<busUserGroupDetail> ilstUserGroupDetail;
	public List<busUserGroup> ilstExistingUserGroups;
	public String istrUserIds;
	public String istrGroupStatusDescription;
	
	public busUserGroup() {

		idoUserGroup = new doUserGroup();
	}
	
	public List<busUserGroup> getCollection(List<doUserGroup> alstUserGroups) {

		List<busUserGroup> llstbusUserGroups = new ArrayList<busUserGroup>();

		for (doUserGroup lUserGroup : alstUserGroups) {

			busUserGroup lbusUserGroup = new busUserGroup();
			lbusUserGroup.idoUserGroup = lUserGroup;
			llstbusUserGroups.add(lbusUserGroup);

		}
		return llstbusUserGroups;
	}
	
	public boolean validateInsertUserGroup() {
		// TODO Auto-generated method stub
		isUserGroupNameOrGroupDescriptionEntered();
		isUserListEmpty();
		isGroupNameDuplicate();
		
		if(this.ilstbusMessages.size() > 0)
			return false;
		else 
			return true;
	}
	
	private void isUserListEmpty() {
		// TODO Auto-generated method stub
		
		if(StringUtils.isEmpty(this.istrUserIds) )
			this.addMessage(busConstant.IsUserListEmpty);
	}

	private void isUserGroupNameOrGroupDescriptionEntered() {
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(this.idoUserGroup.groupName) ||  StringUtils.isEmpty(this.idoUserGroup.groupDescription))
			this.addMessage(busConstant.IsGroupNameOrDescriptionEmpty);
	}
	
	private void isGroupNameDuplicate() {
		// TODO Auto-generated method stub
		if(!StringUtils.isEmpty(this.idoUserGroup.getGroupName()))
		{
			busBaseDAOImpl<doUserGroup> lBaseDAOImpl = new busBaseDAOImpl<doUserGroup>();

			List<busParameter> llstbusParameters = new ArrayList<busParameter>();
			llstbusParameters.add(new busParameter(doUserGroup.enmUserGroup.groupName.toString(), this.idoUserGroup.getGroupName(), busConstant.DataTypeString));

			List<doUserGroup> llstdoUserGroup = lBaseDAOImpl.select(doUserGroup.class, busConstant.doUserGroup, llstbusParameters);

			if (llstdoUserGroup != null && llstdoUserGroup.size() > 0)
				this.addMessage(busConstant.IsGroupNameDuplicate);
		}
	}


	public void loadUserGroupDetail()
	{
		List<busParameter> llstbusParameters = new ArrayList<busParameter>();
		llstbusParameters.add(new busParameter(doUserGroup.enmUserGroup.userGroupId.toString(), Integer.toString(this.idoUserGroup.userGroupId), busConstant.DataTypeInteger));
		CDataRowSet ldrUserGroupDetails = new busDBFunctions().DBExecute(busConstant.loadUserGroupDetails, llstbusParameters, null,busConstant.Select);
		
		this.ilstUserGroupDetail = new ArrayList<busUserGroupDetail>();
		
		try {
			while(ldrUserGroupDetails.next()){
				
				busUserGroupDetail lbusUserGroupDetails = new busUserGroupDetail();
				lbusUserGroupDetails.idoUserGroupDetail.userGroupDetailId = ldrUserGroupDetails.getInt("USER_GROUP_DETAIL_ID");
				lbusUserGroupDetails.idoUserGroupDetail.userId = ldrUserGroupDetails.getInt("USER_ID");
				
				lbusUserGroupDetails.ibusUser = new busUser();
				lbusUserGroupDetails.ibusUser.idoUser.displayName = ldrUserGroupDetails.getString("DISPLAY_NAME");
				
				this.ilstUserGroupDetail.add(lbusUserGroupDetails);
			}
			
		} catch (CDataGridException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
	}

}
