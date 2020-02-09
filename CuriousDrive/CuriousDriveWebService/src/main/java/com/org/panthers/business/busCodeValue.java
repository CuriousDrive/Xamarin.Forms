package com.org.panthers.business;

import java.util.ArrayList;
import java.util.List;

import com.org.panthers.entity.doCodeValue;
import com.org.panthers.framework.busBase;
import com.org.panthers.framework.busBaseDAOImpl;
import com.org.panthers.framework.busParameter;

public class busCodeValue extends busBase{

	public doCodeValue idoCodeValue;
	
	public busCodeValue() {
		
		idoCodeValue = new doCodeValue();
	}

	public List<busCodeValue> getCollection(List<doCodeValue> alstCodeValues) {

		List<busCodeValue> llstbusCodeValues = new ArrayList<busCodeValue>();

		for (doCodeValue lCodeValue : alstCodeValues) {

			busCodeValue lbusCodeValue = new busCodeValue();
			lbusCodeValue.idoCodeValue = lCodeValue;
			llstbusCodeValues.add(lbusCodeValue);
		}
		
		return llstbusCodeValues;
	}
	
	public void loadConstats(){
		
		busBaseDAOImpl<doCodeValue> lBaseDAOImpl = new busBaseDAOImpl<doCodeValue>();
		
		List<busParameter> llstbusParameters = new ArrayList<busParameter>();
		llstbusParameters.add(new busParameter(doCodeValue.enmCodeValue.codeId.toString(), "3", busConstant.DataTypeInteger));
		llstbusParameters.add(new busParameter(doCodeValue.enmCodeValue.codeValue.toString(), this.idoCodeValue.getCodeValue(), busConstant.DataTypeString));
		
		List<doCodeValue> llstCodeValue = lBaseDAOImpl.select(doCodeValue.class, busConstant.doCodeValue, llstbusParameters);
		
		if(llstCodeValue != null && llstCodeValue.size() > 0){
			this.idoCodeValue = llstCodeValue.get(0);
		}
	}

	

}
