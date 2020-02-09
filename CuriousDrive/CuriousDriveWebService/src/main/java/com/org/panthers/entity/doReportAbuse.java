package com.org.panthers.entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.ws.rs.core.UriInfo;

import com.org.panthers.framework.busBaseDAOImpl;
import com.org.panthers.framework.doBase;

import java.util.Date;


/**
 * The persistent class for the TRAN_REPORT_ABUSE database table.
 * 
 */
@Entity
@Table(name="TRAN_REPORT_ABUSE")
@NamedQuery(name="doReportAbuse.findAll", query="SELECT d FROM doReportAbuse d")
public class doReportAbuse extends doBase implements Serializable {
	public static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="REPORT_ABUSE_ID")
	public int reportAbuseId;

	@Column(name="ABUSE_TYPE_ID")
	public int abuseTypeId;

	@Column(name="ABUSE_TYPE_VALUE")
	public String abuseTypeValue;

	@Column(name="DESCRIPTION")
	public String description;

	@Column(name="SUBSYSTEM_ID")
	public int subsystemId;

	@Column(name="SUBSYSTEM_REFERENCE_ID")
	public int subsystemReferenceId;

	@Column(name="SUSYSTEM_VALUE")
	public String susystemValue;

	@Column(name="USER_ID")
	public int userId;
	
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

	public doReportAbuse() {
	}

	public int getReportAbuseId() {
		return this.reportAbuseId;
	}

	public void setReportAbuseId(int reportAbuseId) {
		this.reportAbuseId = reportAbuseId;
	}

	public int getAbuseTypeId() {
		return this.abuseTypeId;
	}

	public void setAbuseTypeId(int abuseTypeId) {
		this.abuseTypeId = abuseTypeId;
	}

	public String getAbuseTypeValue() {
		return this.abuseTypeValue;
	}

	public void setAbuseTypeValue(String abuseTypeValue) {
		this.abuseTypeValue = abuseTypeValue;
	}

	public int getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public int getSubsystemId() {
		return this.subsystemId;
	}

	public void setSubsystemId(int subsystemId) {
		this.subsystemId = subsystemId;
	}

	public int getSubsystemReferenceId() {
		return this.subsystemReferenceId;
	}

	public void setSubsystemReferenceId(int subsystemReferenceId) {
		this.subsystemReferenceId = subsystemReferenceId;
	}

	public String getSusystemValue() {
		return this.susystemValue;
	}

	public void setSusystemValue(String susystemValue) {
		this.susystemValue = susystemValue;
	}

	public int getUpdateSeq() {
		return this.updateSeq;
	}

	public void setUpdateSeq(int updateSeq) {
		this.updateSeq = updateSeq;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public int insert() {
		busBaseDAOImpl<doReportAbuse> baseDAOImpl = new busBaseDAOImpl<doReportAbuse>();
		this.loadCreatedByProperties();
		baseDAOImpl.insert(this);
		return this.getReportAbuseId();
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doReportAbuse> baseDAOImpl = new busBaseDAOImpl<doReportAbuse>();
		baseDAOImpl.delete(doReportAbuse.class, this.getReportAbuseId());
		return 1;
	}

	@Override
	public int update() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doReportAbuse> baseDAOImpl = new busBaseDAOImpl<doReportAbuse>();
		this.loadModifiedByProperties();
		baseDAOImpl.update(this);
		return 1;
	}

	@Override
	public doReportAbuse get() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doReportAbuse> baseDAOImpl = new busBaseDAOImpl<doReportAbuse>();
		return baseDAOImpl.get(this.getReportAbuseId(), doReportAbuse.class);
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


	public enum enmReportAbuse {
		
		reportAbuseId,
		abuseTypeId,
		abuseTypeValue,
		createdBy,
		createdDate,
		description,
		modifiedBy,
		modifiedDate,
		subsystemId,
		subsystemReferenceId,
		susystemValue,
		updateSeq,
		userId
	}
}
