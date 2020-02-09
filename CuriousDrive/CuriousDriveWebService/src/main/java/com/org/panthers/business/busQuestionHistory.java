package com.org.panthers.business;

import java.util.ArrayList;
import java.util.List;

import com.org.panthers.entity.doQuestionHistory;
import com.org.panthers.framework.busBase;

public class busQuestionHistory extends busBase{

	public doQuestionHistory idoQuestionHistory;

	public busQuestionHistory() {

		idoQuestionHistory = new doQuestionHistory();
	}
	
	public List<busQuestionHistory> getCollection(List<doQuestionHistory> alstQuestionHistorys) {

		List<busQuestionHistory> llstbusQuestionHistorys = new ArrayList<busQuestionHistory>();

		for (doQuestionHistory lQuestionHistory : alstQuestionHistorys) {

			busQuestionHistory lbusQuestionHistory = new busQuestionHistory();
			lbusQuestionHistory.idoQuestionHistory = lQuestionHistory;
			llstbusQuestionHistorys.add(lbusQuestionHistory);

		}
		return llstbusQuestionHistorys;
	}
}
