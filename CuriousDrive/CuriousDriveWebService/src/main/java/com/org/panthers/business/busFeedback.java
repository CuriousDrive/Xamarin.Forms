package com.org.panthers.business;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.org.panthers.entity.doFeedback;
import com.org.panthers.framework.busBase;

public class busFeedback extends busBase{

	public doFeedback idoFeedback;
	public String istrURLTitle;
	public String istrDisplayName;
	public List<busFeedback> ilstVerifiedFeedbacks;
	public List<busFeedback> ilstFeedbacksToVerify;
	
	public busFeedback() {

		idoFeedback = new doFeedback();
	}

	public List<busFeedback> getCollection(List<doFeedback> alstFeedbacks) {

		List<busFeedback> llstbusFeedbacks = new ArrayList<busFeedback>();

		for (doFeedback lFeedback : alstFeedbacks) {

			busFeedback lbusFeedback = new busFeedback();
			lbusFeedback.idoFeedback = lFeedback;
			llstbusFeedbacks.add(lbusFeedback);

		}
		return llstbusFeedbacks;
	}

	public boolean validateInsertFeedback() {
		// TODO Auto-generated method stub
		isFeedbackEmpty();
		
		if(this.ilstbusMessages.size() > 0)
			return false;
		else 
			return true;
	}

	private void isFeedbackEmpty() {
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(this.idoFeedback.getFeedback()))
			this.addMessage(busConstant.NoFeedbackWasEntered);
	}
	
}
