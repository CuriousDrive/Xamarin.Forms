package com.org.panthers.business;

import java.util.ArrayList;
import java.util.List;

import com.org.panthers.entity.doRole;
import com.org.panthers.framework.busBase;

public class busRole extends busBase{

	public doRole idoRole;

	public busRole() {
		
		idoRole = new doRole();
	}
	
	public List<busRole> getCollection(List<doRole> alstRoles) {

		List<busRole> llstbusRoles = new ArrayList<busRole>();

		for (doRole lRole : alstRoles) {

			busRole lbusRole = new busRole();
			lbusRole.idoRole = lRole;
			llstbusRoles.add(lbusRole);

		}
		return llstbusRoles;
	}
}
