package com.org.panthers.business;

import java.util.ArrayList;
import java.util.List;

import com.org.panthers.entity.doUserGroupDetail;
import com.org.panthers.framework.busBase;

public class busUserGroupDetail extends busBase{

	public doUserGroupDetail idoUserGroupDetail;
	public busUser ibusUser;
	
	public busUserGroupDetail() {

		idoUserGroupDetail = new doUserGroupDetail();
	}
	
	public List<busUserGroupDetail> getCollection(List<doUserGroupDetail> alstUserGroupDetails) {

		List<busUserGroupDetail> llstbusUserGroupDetails = new ArrayList<busUserGroupDetail>();

		for (doUserGroupDetail lUserGroupDetail : alstUserGroupDetails) {

			busUserGroupDetail lbusUserGroupDetail = new busUserGroupDetail();
			lbusUserGroupDetail.idoUserGroupDetail = lUserGroupDetail;
			llstbusUserGroupDetails.add(lbusUserGroupDetail);

		}
		return llstbusUserGroupDetails;
	}
}
