package com.org.panthers.business;

import java.util.ArrayList;
import java.util.List;

import com.org.panthers.entity.doTag;
import com.org.panthers.framework.busBase;
import com.org.panthers.service.UserService;

public class busTag extends busBase{

	public doTag idoTag;
	public String istrUserTag;
	
	public busTag() {
		
		idoTag = new doTag();
	}

	public List<busTag> getCollection(List<doTag> alstTags) {

		List<busTag> llstbusTags = new ArrayList<busTag>();

		for (doTag lTag : alstTags) {

			busTag lbusTag = new busTag();
			lbusTag.idoTag = lTag;
			llstbusTags.add(lbusTag);

		}
		return llstbusTags;
	}
	
	public void insertUserTags(String astrUserTags, int aintFromUserId,String astrPostType ,int aintSubsystemReferenceId, String astrActionTypeValue)
	{
		if(astrUserTags != "")
		{
			String[] arrUserTags = astrUserTags.split("\\,");
			
			for (String userTag : arrUserTags) {
				
				String[] userType = userTag.split("\\$");
				
				if(userType[0].equals(busConstant.UserGroupTypeUserGroup))
				{
					int lintUserGroupId = Integer.parseInt(userType[1]);
					List<busUser> llstbusUser = new UserService().getUsersByUserGroupId(lintUserGroupId);
					
					int lintTagId = createTag(aintFromUserId, busConstant.UserGroupTypeUserGroup,userType[1],astrPostType, aintSubsystemReferenceId);
					
					for (busUser lbusUser : llstbusUser) {
						
						if(aintFromUserId != lbusUser.idoUser.userId)
						{
							createTagDetail(lintTagId, aintFromUserId, lbusUser.idoUser.userId);
							
							new busNotification().createNotification(aintFromUserId, lbusUser.idoUser.userId, astrActionTypeValue,aintSubsystemReferenceId, 0, 0, busConstant.FlagN, busConstant.FlagN);
						}
					}
					
				}
				if(userType[0].equals(busConstant.UserGroupTypeYear))
				{
					List<busUser> llstbusUser = new UserService().getUsersByYear(userType[1]);
					
					int lintTagId = createTag(aintFromUserId, busConstant.UserGroupTypeYear,userType[1],astrPostType, aintSubsystemReferenceId);
					
					for (busUser lbusUser : llstbusUser) {
						
						if(aintFromUserId != lbusUser.idoUser.userId)
						{
							createTagDetail(lintTagId, aintFromUserId, lbusUser.idoUser.userId);
							
							new busNotification().createNotification(aintFromUserId, lbusUser.idoUser.userId, astrActionTypeValue,aintSubsystemReferenceId, 0, 0, busConstant.FlagN, busConstant.FlagN);
						}
					}
					
				}
				if(userType[0].equals(busConstant.UserGroupTypeIndividual))
				{
					int lintToUserId = Integer.parseInt(userType[1]);
					
					int lintTagId = createTag(aintFromUserId, busConstant.UserGroupTypeIndividual,null,astrPostType, aintSubsystemReferenceId);
					
					if(aintFromUserId != lintToUserId)
					{
						createTagDetail(lintTagId, aintFromUserId, lintToUserId);
						
						new busNotification().createNotification(aintFromUserId, lintToUserId, astrActionTypeValue,aintSubsystemReferenceId, 0, 0, busConstant.FlagN, busConstant.FlagN);
					}
				}
			}
		}
	}


	private int createTag(int aintFromUserId,String astrUserGroupTypeValue,String astrUserGroupValue, String astrSubsystemValue, int aintSubsystemReferenceId)
	{

		busTag lbusTag = new busTag();
		
		lbusTag.idoTag.iintUserId = aintFromUserId;
		lbusTag.idoTag.userId = aintFromUserId;
		lbusTag.idoTag.userGroupTypeId = busConstant.UserGroupTypeId;
		lbusTag.idoTag.userGroupTypeValue = astrUserGroupTypeValue;
		lbusTag.idoTag.userGroupValue = astrUserGroupValue;
		lbusTag.idoTag.subsystemId = busConstant.PostTypeId;
		lbusTag.idoTag.subsystemValue = astrSubsystemValue;
		lbusTag.idoTag.subsystemReferenceId = aintSubsystemReferenceId;
		
		return lbusTag.idoTag.insert();
	}
	
	private void createTagDetail(int aintTagId, int aintFromUserId, int aintToUserId)
	{
		busTagDetail lbusTagDetail = new busTagDetail();
		
		lbusTagDetail.idoTagDetail.iintUserId = aintFromUserId;
		lbusTagDetail.idoTagDetail.tagId = aintTagId;
		lbusTagDetail.idoTagDetail.taggedUserId = aintToUserId;
		
		lbusTagDetail.idoTagDetail.insert();
	}
}
