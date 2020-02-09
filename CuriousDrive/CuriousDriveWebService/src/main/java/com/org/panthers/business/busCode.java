package com.org.panthers.business;

import java.util.ArrayList;
import java.util.List;

import com.org.panthers.entity.doCode;
import com.org.panthers.framework.busBase;

public class busCode extends busBase{

	public doCode idoCode;

	public busCode() {

		idoCode = new doCode();
	}
	
	public List<busCode> getCollection(List<doCode> alstCodes) {

		List<busCode> llstbusCodes = new ArrayList<busCode>();

		for (doCode lCode : alstCodes) {

			busCode lbusCode = new busCode();
			lbusCode.idoCode = lCode;
			llstbusCodes.add(lbusCode);

		}
		return llstbusCodes;
	}

}
