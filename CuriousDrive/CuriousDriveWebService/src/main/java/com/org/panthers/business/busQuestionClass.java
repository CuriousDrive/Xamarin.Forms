package com.org.panthers.business;

import java.util.ArrayList;
import java.util.List;

import com.org.panthers.entity.doClass;
import com.org.panthers.entity.doQuestionClass;
import com.org.panthers.framework.busBase;
import com.org.panthers.framework.busBaseDAOImpl;
import com.org.panthers.framework.busParameter;

public class busQuestionClass extends busBase{

	public doQuestionClass idoQuestionClass;
	public String istrClassName;
	
	public busQuestionClass() {
		idoQuestionClass = new doQuestionClass();
	}
	
	public List<busQuestionClass> getCollection(List<doQuestionClass> alstQuestionClasss) {

		List<busQuestionClass> llstbusQuestionClasss = new ArrayList<busQuestionClass>();

		for (doQuestionClass lQuestionClass : alstQuestionClasss) {

			busQuestionClass lbusQuestionClass = new busQuestionClass();
			lbusQuestionClass.idoQuestionClass = lQuestionClass;
			llstbusQuestionClasss.add(lbusQuestionClass);

		}
		return llstbusQuestionClasss;
	}
	
	public void loadClassName(){
		
		busBaseDAOImpl<doClass> lBaseDAOImpl = new busBaseDAOImpl<doClass>();

		List<busParameter> llstbusParameters = new ArrayList<busParameter>();
		llstbusParameters.add(new busParameter(doClass.enmClass.classId.toString(),String.valueOf(this.idoQuestionClass.getClassId()), 
				busConstant.DataTypeInteger));
		
		doClass ldoClass = lBaseDAOImpl.selectFirstOrDefault(doClass.class, busConstant.doClass, llstbusParameters);
		this.istrClassName = ldoClass.getClassName();
	}
	
}
