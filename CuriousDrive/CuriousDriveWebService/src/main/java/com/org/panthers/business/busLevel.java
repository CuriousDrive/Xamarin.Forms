package com.org.panthers.business;

import java.util.ArrayList;
import java.util.List;

import com.org.panthers.entity.doLevel;
import com.org.panthers.framework.busBase;

public class busLevel extends busBase{

	public doLevel idoLevel;
	
	public busLevel() {
		idoLevel = new doLevel();
	}

	public List<busLevel> getCollection(List<doLevel> alstLevels) {

		List<busLevel> llstbusLevels = new ArrayList<busLevel>();

		for (doLevel lLevel : alstLevels) {

			busLevel lbusLevel = new busLevel();
			lbusLevel.idoLevel = lLevel;
			llstbusLevels.add(lbusLevel);

		}
		return llstbusLevels;
	}
}
