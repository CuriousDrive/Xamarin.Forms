package com.org.panthers.business;

import java.util.ArrayList;
import java.util.List;

import com.org.panthers.entity.doPoint;
import com.org.panthers.framework.busBase;
import com.org.panthers.framework.busDBFunctions;
import com.org.panthers.framework.busParameter;

public class busPoint extends busBase{

	public doPoint idoPoint;
	
	public busPoint() {
		idoPoint = new doPoint();
	}
	
	public List<busPoint> getCollection(List<doPoint> alstPoints) {

		List<busPoint> llstbusPoints = new ArrayList<busPoint>();

		for (doPoint lPoint : alstPoints) {

			busPoint lbusPoint = new busPoint();
			lbusPoint.idoPoint = lPoint;
			llstbusPoints.add(lbusPoint);

		}
		return llstbusPoints;
	}

	public int createPoint(int aintQuestionId,int aintUserId,int aintByUserId,String astrSubsystemValue, int aintSubsystemReferenceId,String astrPointType ,int aintPoints)
	{
		if(this.idoPoint == null)
			this.idoPoint = new doPoint();
		
		this.idoPoint.iintUserId = aintByUserId;
		
		this.idoPoint.setQuestionId(aintQuestionId);
		this.idoPoint.setUserId(aintUserId);
		this.idoPoint.setSubsystemId(busConstant.ActionTypeId);
		this.idoPoint.setSubsystemValue(astrSubsystemValue);
		this.idoPoint.setSubsystemReferenceId(aintSubsystemReferenceId);
		this.idoPoint.setPointsTypeId(busConstant.PointTypeId);
		this.idoPoint.setPointsTypeValue(astrPointType);
		this.idoPoint.setPoints(aintPoints);
		
		this.deleteOppositePoint();
		
		return this.idoPoint.insert();
	}
	
	private void deleteOppositePoint()
	{
		String[] primaryKeys = { "POINT_ID" };

		// delete opposite points 
		List<busParameter> llstbusParameters = new ArrayList<busParameter>();
		
		llstbusParameters.add(new busParameter(doPoint.enmPoint.questionId.toString(), String.valueOf(this.idoPoint.getQuestionId()), busConstant.DataTypeInteger));
		llstbusParameters.add(new busParameter(doPoint.enmPoint.userId.toString(), String.valueOf(this.idoPoint.getUserId()), busConstant.DataTypeInteger));
		llstbusParameters.add(new busParameter(doPoint.enmPoint.pointsTypeValue.toString(), this.idoPoint.getPointsTypeValue(), busConstant.DataTypeString));
		llstbusParameters.add(new busParameter(doPoint.enmPoint.subsystemReferenceId.toString(), String.valueOf(this.idoPoint.getSubsystemReferenceId()), busConstant.DataTypeInteger));
		llstbusParameters.add(new busParameter(doPoint.enmPoint.createdBy.toString(), String.valueOf(this.idoPoint.iintUserId), busConstant.DataTypeInteger));
				
		if(this.idoPoint.getSubsystemValue().equals(busConstant.ActionTypeUpVoteQuestion))
			llstbusParameters.add(new busParameter(doPoint.enmPoint.subsystemValue.toString(), busConstant.ActionTypeDownVoteQuestion, busConstant.DataTypeString));
		if(this.idoPoint.getSubsystemValue().equals(busConstant.ActionTypeDownVoteQuestion))
			llstbusParameters.add(new busParameter(doPoint.enmPoint.subsystemValue.toString(), busConstant.ActionTypeUpVoteQuestion, busConstant.DataTypeString));
		
		if(this.idoPoint.getSubsystemValue().equals(busConstant.ActionTypeUpVoteAnswer))
			llstbusParameters.add(new busParameter(doPoint.enmPoint.subsystemValue.toString(), busConstant.ActionTypeDownVoteAnswer, busConstant.DataTypeString));
		if(this.idoPoint.getSubsystemValue().equals(busConstant.ActionTypeDownVoteAnswer))
			llstbusParameters.add(new busParameter(doPoint.enmPoint.subsystemValue.toString(), busConstant.ActionTypeUpVoteAnswer, busConstant.DataTypeString));
		
		if(this.idoPoint.getSubsystemValue().equals(busConstant.ActionTypeUpVoteComment))
			llstbusParameters.add(new busParameter(doPoint.enmPoint.subsystemValue.toString(), busConstant.ActionTypeDownVoteComment, busConstant.DataTypeString));
		if(this.idoPoint.getSubsystemValue().equals(busConstant.ActionTypeDownVoteComment))
			llstbusParameters.add(new busParameter(doPoint.enmPoint.subsystemValue.toString(), busConstant.ActionTypeUpVoteComment, busConstant.DataTypeString));
		
		new busDBFunctions().DBExecute(busConstant.deletePoint, llstbusParameters, primaryKeys,busConstant.Delete);
		
	}
}
