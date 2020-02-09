package com.org.panthers.framework;

import java.util.ArrayList;
import java.util.List;


public abstract class busBase {

	public List<busMessage> ilstbusMessages;
	public boolean isOwner;	
		
	public busBase(){
		ilstbusMessages = new ArrayList<busMessage>();
	}
	
	public void addMessage(int aintMessageId){
		
		busMessage lbusMessage = new busMessage();
		lbusMessage = new busMessage();
		lbusMessage.idoMessage.setMessageId(aintMessageId);
		lbusMessage.idoMessage = lbusMessage.idoMessage.get();
		ilstbusMessages.add(lbusMessage);
	}

}
