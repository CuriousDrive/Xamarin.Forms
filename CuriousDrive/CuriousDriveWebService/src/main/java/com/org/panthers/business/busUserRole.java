package com.org.panthers.business;

import java.util.ArrayList;
import java.util.List;

import com.org.panthers.entity.doUserRole;
import com.org.panthers.framework.busBase;

public class busUserRole extends busBase{

	public doUserRole idoUserRole;
	public String istrUserGroup;

	public busUserRole() {

		idoUserRole = new doUserRole();
	}
	
	public List<busUserRole> getCollection(List<doUserRole> alstUserRoles) {

		List<busUserRole> llstbusUserRoles = new ArrayList<busUserRole>();

		for (doUserRole lUserRole : alstUserRoles) {

			busUserRole lbusUserRole = new busUserRole();
			lbusUserRole.idoUserRole = lUserRole;
			llstbusUserRoles.add(lbusUserRole);

		}
		return llstbusUserRoles;
	}

}
