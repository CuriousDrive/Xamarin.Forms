package com.org.panthers.entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.ws.rs.core.UriInfo;

import com.org.panthers.framework.busBaseDAOImpl;
import com.org.panthers.framework.doBase;

import java.util.Date;


/**
 * The persistent class for the SYS_MESSAGES database table.
 * 
 */
@Entity
@Table(name="SYS_MESSAGE")
@NamedQuery(name="doMessage.findAll", query="SELECT d FROM doMessage d")
public class doMessage extends doBase implements Serializable {
	public static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="MESSAGE_ID")
	public int messageId;

	@Column(name="CREATED_BY")
	public int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_DATE")
	public Date createdDate;

	@Column(name="DISPLAY_MESSAGE")
	public String displayMessage;

	@Column(name="INTERNAL_INSTRUCTIONS")
	public String internalInstructions;

	@Column(name="MODIFIED_BY")
	public int modifiedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="MODIFIED_DATE")
	public Date modifiedDate;

	@Column(name="SEVERITY_ID")
	public String severityId;

	@Column(name="SEVERITY_VALUE")
	public String severityValue;

	@Column(name="UPDATE_SEQ")
	public int updateSeq;

	@Column(name="USER_INSTRUCTIONS")
	public String userInstructions;

	public doMessage() {
	}

	public int getMessageId() {
		return this.messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
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

	public String getDisplayMessage() {
		return this.displayMessage;
	}

	public void setDisplayMessage(String displayMessage) {
		this.displayMessage = displayMessage;
	}

	public String getInternalInstructions() {
		return this.internalInstructions;
	}

	public void setInternalInstructions(String internalInstructions) {
		this.internalInstructions = internalInstructions;
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

	public String getSeverityId() {
		return this.severityId;
	}

	public void setSeverityId(String severityId) {
		this.severityId = severityId;
	}

	public String getSeverityValue() {
		return this.severityValue;
	}

	public void setSeverityValue(String severityValue) {
		this.severityValue = severityValue;
	}

	public int getUpdateSeq() {
		return this.updateSeq;
	}

	public void setUpdateSeq(int updateSeq) {
		this.updateSeq = updateSeq;
	}

	public String getUserInstructions() {
		return this.userInstructions;
	}

	public void setUserInstructions(String userInstructions) {
		this.userInstructions = userInstructions;
	}

	@Override
	public int insert() {
		busBaseDAOImpl<doMessage> baseDAOImpl = new busBaseDAOImpl<doMessage>();
		this.loadCreatedByProperties();
		baseDAOImpl.insert(this);
		return this.getMessageId();
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doMessage> baseDAOImpl = new busBaseDAOImpl<doMessage>();
		baseDAOImpl.delete(doMessage.class, this.getMessageId());
		return 1;
	}

	@Override
	public int update() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doMessage> baseDAOImpl = new busBaseDAOImpl<doMessage>();
		this.loadModifiedByProperties();
		baseDAOImpl.update(this);
		return 1;
	}

	@Override
	public doMessage get() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doMessage> baseDAOImpl = new busBaseDAOImpl<doMessage>();
		return baseDAOImpl.get(this.getMessageId(), doMessage.class);
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

	
	public enum enmMessage {
		
		messageId,
		createdBy,
		createdDate,
		displayMessage,
		internalInstructions,
		modifiedBy,
		modifiedDate,
		severityId,
		severityValue,
		updateSeq,
		userInstructions
	}

}
