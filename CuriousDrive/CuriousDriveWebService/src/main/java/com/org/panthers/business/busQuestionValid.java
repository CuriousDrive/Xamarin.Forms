package com.org.panthers.business;

import java.util.ArrayList;
import java.util.List;

import com.org.panthers.entity.doQuestionValid;
import com.org.panthers.framework.busBase;

public class busQuestionValid extends busBase{

	public doQuestionValid idoQuestionValid;

	public busQuestionValid() {

		idoQuestionValid = new doQuestionValid();
	}
	
	public List<busQuestionValid> getCollection(List<doQuestionValid> alstQuestionValids) {

		List<busQuestionValid> llstbusQuestionValids = new ArrayList<busQuestionValid>();

		for (doQuestionValid lQuestionValid : alstQuestionValids) {

			busQuestionValid lbusQuestionValid = new busQuestionValid();
			lbusQuestionValid.idoQuestionValid = lQuestionValid;
			llstbusQuestionValids.add(lbusQuestionValid);

		}
		return llstbusQuestionValids;
	}
}
