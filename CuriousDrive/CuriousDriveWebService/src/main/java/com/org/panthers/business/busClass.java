package com.org.panthers.business;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.org.panthers.entity.doClass;
import com.org.panthers.entity.doThread;
import com.org.panthers.framework.busBase;
import com.org.panthers.framework.busBaseDAOImpl;
import com.org.panthers.framework.busParameter;

public class busClass extends busBase{

	public doClass idoClass;
	public boolean approveClass;
	public boolean rejectClass;
	
	public List<busClass> ilstbusExistingClasses;
	
	public busClass() {

		idoClass = new doClass();
	}
	
	public boolean validateInsertClass() {
		// TODO Auto-generated method stub
		isClassNameAndDescriptionEntered();
		isUserLoggedIn();
		isClassDuplicate();
		
		if(this.ilstbusMessages.size() > 0)
			return false;
		else 
			return true;
	}
	
	private void isClassDuplicate() {
		// TODO Auto-generated method stub
		if(!StringUtils.isEmpty(this.idoClass.getClassName()))
		{
			busBaseDAOImpl<doClass> lBaseDAOImpl = new busBaseDAOImpl<doClass>();

			List<busParameter> llstbusParameters = new ArrayList<busParameter>();
			llstbusParameters.add(new busParameter(doClass.enmClass.className.toString(), this.idoClass.getClassName(), busConstant.DataTypeString));

			List<doClass> llstdoClass = lBaseDAOImpl.select(doClass.class, busConstant.doClass, llstbusParameters);

			if (llstdoClass != null && llstdoClass.size() > 0)
				this.addMessage(busConstant.IsClassDuplicate);
		}
	}

	private void isUserLoggedIn() {
		// TODO Auto-generated method stub
		if(this.idoClass.iintUserId == 0)
			this.addMessage(busConstant.IsUserLoggedIn);
		
	}

	private void isClassNameAndDescriptionEntered() {
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(this.idoClass.getClassName()) || StringUtils.isEmpty(this.idoClass.getDescription())) 
			this.addMessage(busConstant.IsClassEntered);
		
	}

	public List<busClass> getCollection(List<doClass> alstClasss) {

		List<busClass> llstbusClasss = new ArrayList<busClass>();

		for (doClass lClass : alstClasss) {

			busClass lbusClass = new busClass();
			lbusClass.idoClass = lClass;
			llstbusClasss.add(lbusClass);

		}
		return llstbusClasss;
	}
	
}
