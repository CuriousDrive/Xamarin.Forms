package com.org.panthers.business;

import java.util.ArrayList;
import java.util.List;

import com.org.panthers.entity.doQuestionView;
import com.org.panthers.framework.busBase;
import com.org.panthers.framework.busBaseDAOImpl;
import com.org.panthers.framework.busParameter;

public class busQuestionView extends busBase{

	public doQuestionView idoQuestionView;

	public busQuestionView() {
		
		idoQuestionView = new doQuestionView();
	}
	
	public List<busQuestionView> getCollection(List<doQuestionView> alstQuestionViews) {

		List<busQuestionView> llstbusQuestionViews = new ArrayList<busQuestionView>();

		for (doQuestionView lQuestionView : alstQuestionViews) {

			busQuestionView lbusQuestionView = new busQuestionView();
			lbusQuestionView.idoQuestionView = lQuestionView;
			llstbusQuestionViews.add(lbusQuestionView);

		}
		return llstbusQuestionViews;
	}

	public boolean validateInsertQuestionView() {
		
		// TODO Auto-generated method stub
		if(this.ilstbusMessages.size() > 0)
			return false;
		else 
			return true;
	}

	public boolean isQuestionViewDuplicate() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doQuestionView> lBaseDAOImpl = new busBaseDAOImpl<doQuestionView>();

		List<busParameter> llstbusParameters = new ArrayList<busParameter>();
		llstbusParameters.add(new busParameter(doQuestionView.enmQuestionView.questionId.toString(), String.valueOf(this.idoQuestionView.getQuestionId()), busConstant.DataTypeInteger));
		llstbusParameters.add(new busParameter(doQuestionView.enmQuestionView.userId.toString(), String.valueOf(this.idoQuestionView.getUserId()), busConstant.DataTypeInteger));
		llstbusParameters.add(new busParameter(doQuestionView.enmQuestionView.browser.toString(), String.valueOf(this.idoQuestionView.getBrowser()), busConstant.DataTypeString));
		llstbusParameters.add(new busParameter(doQuestionView.enmQuestionView.ipAddress.toString(), String.valueOf(this.idoQuestionView.getIpAddress()), busConstant.DataTypeString));
		
		List<doQuestionView> llstdoQuestionView = lBaseDAOImpl.select(doQuestionView.class, busConstant.doQuestionView, llstbusParameters);

		if (llstdoQuestionView != null && llstdoQuestionView.size() > 0)
			return true;
		else
			return false;
		
	}

}
