package com.org.panthers.framework;

import java.util.ArrayList;
import java.util.List;

import com.org.panthers.entity.doMessage;

public class busMessage extends busBase{

	public doMessage idoMessage;

	public busMessage() {
		idoMessage = new doMessage();
	}

	public busMessage(String astrDisplayMesage) {
		this.idoMessage = new doMessage();
		this.idoMessage.setDisplayMessage(astrDisplayMesage);
	}

	public List<busMessage> getCollection(List<doMessage> alstMessages) {

		List<busMessage> llstBusMessages = new ArrayList<busMessage>();

		for (doMessage lMessage : alstMessages) {

			busMessage lbusMessage = new busMessage();
			lbusMessage.idoMessage = lMessage;
			llstBusMessages.add(lbusMessage);

		}
		return llstBusMessages;
	}
}
