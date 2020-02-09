package com.org.panthers.entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.ws.rs.core.UriInfo;

import com.org.panthers.framework.busBaseDAOImpl;
import com.org.panthers.framework.doBase;

import java.util.Date;


/**
 * The persistent class for the TRAN_POINTS database table.
 * 
 */
@Entity
@Table(name="TRAN_POINT")
@NamedQuery(name="doPoint.findAll", query="SELECT d FROM doPoint d")
public class doPoint extends doBase implements Serializable {
	public static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="POINT_ID")
	public int pointId;
	
	@Column(name="QUESTION_ID")
	public int questionId;

	@Column(name="USER_ID")
	public int userId;
	
	@Column(name="SUBSYSTEM_ID")
	public int subsystemId;
	
	@Column(name="SUBSYSTEM_VALUE")
	public String subsystemValue;
	
	@Column(name="SUBSYSTEM_REFERENCE_ID")
	public int subsystemReferenceId;
	
	@Column(name="POINTS_TYPE_ID")
	public int pointsTypeId;
	
	@Column(name="POINTS_TYPE_VALUE")
	public String pointsTypeValue;
	
	@Column(name="POINTS")
	public int points;

	@Column(name="CREATED_BY")
	public int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_DATE")
	public Date createdDate;
	
	@Column(name="MODIFIED_BY")
	public int modifiedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="MODIFIED_DATE")
	public Date modifiedDate;

	@Column(name="UPDATE_SEQ")
	public int updateSeq;

	public doPoint() {
		// TODO Auto-generated constructor stub
	}
	
	public int getPointId() {
		return pointId;
	}

	public void setPointsId(int pointId) {
		this.pointId = pointId;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getSubsystemId() {
		return subsystemId;
	}

	public void setSubsystemId(int subsystemId) {
		this.subsystemId = subsystemId;
	}

	public String getSubsystemValue() {
		return subsystemValue;
	}

	public void setSubsystemValue(String subsystemValue) {
		this.subsystemValue = subsystemValue;
	}

	public int getSubsystemReferenceId() {
		return subsystemReferenceId;
	}

	public void setSubsystemReferenceId(int subsystemReferenceId) {
		this.subsystemReferenceId = subsystemReferenceId;
	}

	public int getPointsTypeId() {
		return pointsTypeId;
	}

	public void setPointsTypeId(int pointsTypeId) {
		this.pointsTypeId = pointsTypeId;
	}

	public String getPointsTypeValue() {
		return pointsTypeValue;
	}

	public void setPointsTypeValue(String pointsTypeValue) {
		this.pointsTypeValue = pointsTypeValue;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public int getUpdateSeq() {
		return updateSeq;
	}

	public void setUpdateSeq(int updateSeq) {
		this.updateSeq = updateSeq;
	}

	@Override
	public int insert() {
		busBaseDAOImpl<doPoint> baseDAOImpl = new busBaseDAOImpl<doPoint>();
		this.loadCreatedByProperties();
		baseDAOImpl.insert(this);
		return this.getPointId();
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doPoint> baseDAOImpl = new busBaseDAOImpl<doPoint>();
		baseDAOImpl.delete(doPoint.class, this.getPointId());
		return 1;
	}

	@Override
	public int update() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doPoint> baseDAOImpl = new busBaseDAOImpl<doPoint>();
		this.loadModifiedByProperties();
		baseDAOImpl.update(this);
		return 1;
	}

	@Override
	public doPoint get() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doPoint> baseDAOImpl = new busBaseDAOImpl<doPoint>();
		return baseDAOImpl.get(this.getPointId(), doPoint.class);
	}

	@Override
	public void loadCreatedByProperties() {
		// TODO Auto-generated method stub
		this.setCreatedBy(this.iintUserId);
		this.setCreatedDate(new Date());
		this.setModifiedBy(this.iintUserId);		
		this.setModifiedDate(new Date());
	}

	@Override
	public void loadModifiedByProperties() {
		// TODO Auto-generated method stub
		this.setModifiedBy(this.iintUserId);		
		this.setModifiedDate(new Date());
	}

	
	public enum enmPoint {
		pointId,
		questionId,
		userId,
		subsystemId,
		subsystemValue,
		subsystemReferenceId,
		pointsTypeId,
		pointsTypeValue,
		points,
		createdBy,
		createdDate,
		modifiedBy,
		modifiedDate,
		updateSeq
	}
}
