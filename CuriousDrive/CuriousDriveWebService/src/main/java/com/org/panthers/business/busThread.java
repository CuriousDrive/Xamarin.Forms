package com.org.panthers.business;

import java.util.ArrayList;
import java.util.List;

import com.org.panthers.entity.doThread;
import com.org.panthers.framework.busBase;
import com.org.panthers.framework.busBaseDAOImpl;
import com.org.panthers.framework.busParameter;

public class busThread extends busBase{

	public doThread idoThread;

	public busThread() {

		idoThread = new doThread();
	}
	
	public List<busThread> getCollection(List<doThread> alstThreads) {

		List<busThread> llstbusThreads = new ArrayList<busThread>();

		for (doThread lThread : alstThreads) {

			busThread lbusThread = new busThread();
			lbusThread.idoThread = lThread;
			llstbusThreads.add(lbusThread);

		}
		return llstbusThreads;
	}
	
	public List<busThread> loadApprovedThreads() {
		// TODO Auto-generated method stub 
		List<busParameter> llstbusParameters = new ArrayList<busParameter>();
		llstbusParameters.add(new busParameter(doThread.enmThread.statusValue.toString(),busConstant.ThreadStatusApproved,busConstant.DataTypeString));
		List<doThread> llstThread = new busBaseDAOImpl<doThread>().select(doThread.class, busConstant.doThread,llstbusParameters);

		return this.getCollection(llstThread);
	}

}
