package com.org.panthers.business;

import java.util.ArrayList;
import java.util.List;

import com.org.panthers.entity.doTagDetail;
import com.org.panthers.framework.busBase;

public class busTagDetail extends busBase{

	public doTagDetail idoTagDetail;
	
	public busTagDetail() {
		
		idoTagDetail = new doTagDetail();
	}

	public List<busTagDetail> getCollection(List<doTagDetail> alstTagDetails) {

		List<busTagDetail> llstbusTagDetails = new ArrayList<busTagDetail>();

		for (doTagDetail lTagDetail : alstTagDetails) {

			busTagDetail lbusTagDetail = new busTagDetail();
			lbusTagDetail.idoTagDetail = lTagDetail;
			llstbusTagDetails.add(lbusTagDetail);

		}
		return llstbusTagDetails;
	}
}
