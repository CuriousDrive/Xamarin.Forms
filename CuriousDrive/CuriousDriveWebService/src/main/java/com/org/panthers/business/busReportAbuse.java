package com.org.panthers.business;

import java.util.ArrayList;
import java.util.List;

import com.org.panthers.entity.doReportAbuse;
import com.org.panthers.framework.busBase;

public class busReportAbuse extends busBase{

	public doReportAbuse idoReportAbuse;

	public busReportAbuse() {

		idoReportAbuse = new doReportAbuse();
	}
	
	public List<busReportAbuse> getCollection(List<doReportAbuse> alstReportAbuses) {

		List<busReportAbuse> llstbusReportAbuses = new ArrayList<busReportAbuse>();

		for (doReportAbuse lReportAbuse : alstReportAbuses) {

			busReportAbuse lbusReportAbuse = new busReportAbuse();
			lbusReportAbuse.idoReportAbuse = lReportAbuse;
			llstbusReportAbuses.add(lbusReportAbuse);

		}
		return llstbusReportAbuses;
	}
}
