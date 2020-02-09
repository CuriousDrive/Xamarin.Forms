package com.org.panthers.business;

import java.util.ArrayList;
import java.util.List;

import org.glassfish.grizzly.asyncqueue.AsyncQueueEnabledTransport;

import com.org.panthers.entity.doNotification;
import com.org.panthers.entity.doPoint;
import com.org.panthers.entity.doQuestion;
import com.org.panthers.framework.busBase;
import com.org.panthers.framework.busBaseDAOImpl;
import com.org.panthers.framework.busDBFunctions;
import com.org.panthers.framework.busParameter;

public class busNotification extends busBase{

	public doNotification idoNotification;
	public busUser ibusFromUser;
	
	public int iintReferenceId;
	public String istrNotificationHeader;
	public String istrNotificationDetail;
	
	
	
	public busNotification() {
		
		idoNotification = new doNotification();
	}

	public List<busNotification> getCollection(List<doNotification> alstNotifications) {

		List<busNotification> llstbusNotifications = new ArrayList<busNotification>();

		for (doNotification lNotification : alstNotifications) {

			busNotification lbusNotification = new busNotification();
			lbusNotification.idoNotification = lNotification;
			llstbusNotifications.add(lbusNotification);

		}
		return llstbusNotifications;
	}
	
	public int createNotification(int aintFromUserId, int aintToUserId, String astrActionValue, int aintActionReferenceId, int aintPointId, int aintMessageId, String astrIsRead, String astrIsEmail)
	{
		if(this.idoNotification == null)
			this.idoNotification = new doNotification();
		
		this.idoNotification.iintUserId = aintFromUserId;
		
		this.idoNotification.setFromUserId(aintFromUserId);
		this.idoNotification.setToUserId(aintToUserId);
		this.idoNotification.setSubsystemId(busConstant.ActionTypeId);
		this.idoNotification.setSubsystemValue(astrActionValue);
		this.idoNotification.setSubsystemReferenceId(aintActionReferenceId);
		this.idoNotification.setPointId(aintPointId);
		this.idoNotification.setMessageId(aintMessageId);
		this.idoNotification.setIsRead(astrIsRead);
		this.idoNotification.setIsEmail(astrIsEmail);
		
		this.deleteOppositeNotification();
		
		if(!this.isDuplicateNotification())
			return this.idoNotification.insert();
		else
			return 0;
	}

	private void deleteOppositeNotification()
	{
		// delete opposite Notifications 
		List<busParameter> llstbusParameters = new ArrayList<busParameter>();
		
		llstbusParameters.add(new busParameter(doNotification.enmNotification.fromUserId.toString(), String.valueOf(this.idoNotification.getFromUserId()), busConstant.DataTypeInteger));
		llstbusParameters.add(new busParameter(doNotification.enmNotification.toUserId.toString(), String.valueOf(this.idoNotification.getToUserId()), busConstant.DataTypeInteger));
		llstbusParameters.add(new busParameter(doNotification.enmNotification.subsystemReferenceId.toString(), String.valueOf(this.idoNotification.getSubsystemReferenceId()), busConstant.DataTypeInteger));
				
		if(this.idoNotification.getSubsystemValue().equals(busConstant.ActionTypeUpVoteQuestion))
			llstbusParameters.add(new busParameter(doNotification.enmNotification.subsystemValue.toString(), busConstant.ActionTypeDownVoteQuestion, busConstant.DataTypeString));
		if(this.idoNotification.getSubsystemValue().equals(busConstant.ActionTypeDownVoteQuestion))
			llstbusParameters.add(new busParameter(doNotification.enmNotification.subsystemValue.toString(), busConstant.ActionTypeUpVoteQuestion, busConstant.DataTypeString));
		
		if(this.idoNotification.getSubsystemValue().equals(busConstant.ActionTypeUpVoteAnswer))
			llstbusParameters.add(new busParameter(doNotification.enmNotification.subsystemValue.toString(), busConstant.ActionTypeDownVoteAnswer, busConstant.DataTypeString));
		if(this.idoNotification.getSubsystemValue().equals(busConstant.ActionTypeDownVoteAnswer))
			llstbusParameters.add(new busParameter(doNotification.enmNotification.subsystemValue.toString(), busConstant.ActionTypeUpVoteAnswer, busConstant.DataTypeString));
		
		if(this.idoNotification.getSubsystemValue().equals(busConstant.ActionTypeUpVoteComment))
			llstbusParameters.add(new busParameter(doNotification.enmNotification.subsystemValue.toString(), busConstant.ActionTypeDownVoteComment, busConstant.DataTypeString));
		if(this.idoNotification.getSubsystemValue().equals(busConstant.ActionTypeDownVoteComment))
			llstbusParameters.add(new busParameter(doNotification.enmNotification.subsystemValue.toString(), busConstant.ActionTypeUpVoteComment, busConstant.DataTypeString));
		
		if(llstbusParameters.size() == 4)
			new busDBFunctions().DBExecute(busConstant.deleteNotification, llstbusParameters, null,busConstant.Delete);
		
	}
	
	private boolean isDuplicateNotification()
	{
		// delete opposite Notifications 
		List<busParameter> llstbusParameters = new ArrayList<busParameter>();
		
		llstbusParameters.add(new busParameter(doNotification.enmNotification.fromUserId.toString(),String.valueOf(this.idoNotification.getFromUserId()), busConstant.DataTypeInteger));
		llstbusParameters.add(new busParameter(doNotification.enmNotification.toUserId.toString(),String.valueOf(this.idoNotification.getToUserId()), busConstant.DataTypeInteger));
		llstbusParameters.add(new busParameter(doNotification.enmNotification.subsystemReferenceId.toString(),String.valueOf(this.idoNotification.getSubsystemReferenceId()), busConstant.DataTypeInteger));
		llstbusParameters.add(new busParameter(doNotification.enmNotification.subsystemValue.toString(),this.idoNotification.getSubsystemValue(), busConstant.DataTypeString));

		busBaseDAOImpl<doNotification> lBaseDAOImpl = new busBaseDAOImpl<doNotification>();
		List<doNotification> llstdoNotifications = lBaseDAOImpl.select(doNotification.class, busConstant.doNotification,llstbusParameters);

		if (llstdoNotifications != null && llstdoNotifications.size() > 0)
			return true;
		else
			return false;			
		
	}

}
