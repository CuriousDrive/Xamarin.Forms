package com.org.panthers.business;

import java.util.ArrayList;
import java.util.List;

import com.org.panthers.entity.doQuestionAnswerHistory;
import com.org.panthers.framework.busBase;

public class busQuestionAnswerHistory extends busBase{

	public doQuestionAnswerHistory idoQuestionAnswerHistory;

	public busQuestionAnswerHistory() {

		idoQuestionAnswerHistory = new doQuestionAnswerHistory();
	}
	
	public List<busQuestionAnswerHistory> getCollection(List<doQuestionAnswerHistory> alstQuestionAnswerHistorys) {

		List<busQuestionAnswerHistory> llstbusQuestionAnswerHistorys = new ArrayList<busQuestionAnswerHistory>();

		for (doQuestionAnswerHistory lQuestionAnswerHistory : alstQuestionAnswerHistorys) {

			busQuestionAnswerHistory lbusQuestionAnswerHistory = new busQuestionAnswerHistory();
			lbusQuestionAnswerHistory.idoQuestionAnswerHistory = lQuestionAnswerHistory;
			llstbusQuestionAnswerHistorys.add(lbusQuestionAnswerHistory);

		}
		return llstbusQuestionAnswerHistorys;
	}

}
