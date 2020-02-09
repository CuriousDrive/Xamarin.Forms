package com.org.panthers.entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.ws.rs.core.UriInfo;

import com.org.panthers.framework.busBaseDAOImpl;
import com.org.panthers.framework.doBase;

import java.util.Date;


/**
 * The persistent class for the TRAN_COMMENTS database table.
 * 
 */
@Entity
@Table(name="TRAN_NOTIFICATION")
@NamedQuery(name="doNotification.findAll", query="SELECT d FROM doNotification d")
public class doNotification extends doBase implements Serializable {
	public static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="NOTIFICATION_ID")
	public int notificationId;
	
	@Column(name="FROM_USER_ID")
	public int fromUserId;
	
	@Column(name="TO_USER_ID")
	public int toUserId;
	
	@Column(name="SUBSYSTEM_ID")
	public int subsystemId;

	@Column(name="SUBSYSTEM_VALUE")
	public String subsystemValue;
	
	@Column(name="SUBSYSTEM_REFERENCE_ID")
	public int subsystemReferenceId;
	
	@Column(name="POINT_ID")
	public int pointId;
	
	@Column(name="MESSAGE_ID")
	public int messageId;
	
	@Column(name="IS_READ")
	public String isRead;
	
	@Column(name="IS_EMAIL")
	public String isEmail;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="EMAIL_SENT_DATE")
	public Date emailSentDate;

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

	public doNotification() {
		// TODO Auto-generated constructor stub
	}
	
	public int getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}
	
	public int getFromUserId() {
		return fromUserId;
	}

	public void setFromUserId(int fromUserId) {
		this.fromUserId = fromUserId;
	}

	public int getToUserId() {
		return toUserId;
	}

	public void setToUserId(int toUserId) {
		this.toUserId = toUserId;
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
	
	public int getPointId() {
		return pointId;
	}

	public void setPointId(int pointId) {
		this.pointId = pointId;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getIsRead() {
		return isRead;
	}

	public void setIsRead(String isRead) {
		this.isRead = isRead;
	}

	public String getIsEmail() {
		return isEmail;
	}

	public void setIsEmail(String isEmail) {
		this.isEmail = isEmail;
	}

	public Date getEmailSentDate() {
		return emailSentDate;
	}

	public void setEmailSentDate(Date emailSentDate) {
		this.emailSentDate = emailSentDate;
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
		busBaseDAOImpl<doNotification> baseDAOImpl = new busBaseDAOImpl<doNotification>();
		this.loadCreatedByProperties();
		baseDAOImpl.insert(this);
		return this.getNotificationId();
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doNotification> baseDAOImpl = new busBaseDAOImpl<doNotification>();
		baseDAOImpl.delete(doNotification.class, this.getNotificationId());
		return 1;
	}

	@Override
	public int update() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doNotification> baseDAOImpl = new busBaseDAOImpl<doNotification>();
		this.loadModifiedByProperties();
		baseDAOImpl.update(this);
		return 1;
	}

	@Override
	public doNotification get() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doNotification> baseDAOImpl = new busBaseDAOImpl<doNotification>();
		return baseDAOImpl.get(this.getNotificationId(), doNotification.class);
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

	
	public enum enmNotification {
		
		notificationId,
		fromUserId,
		toUserId,
		subsystemId,
		subsystemValue,
		subsystemReferenceId,
		pointId,
		messageId,
		isRead,
		isEmail,
		emailSentDate,
		createdBy,
		createdDate,
		modifiedBy,
		modifiedDate,
		updateSeq
	}
}
