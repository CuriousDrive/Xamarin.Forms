package com.org.panthers.entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.ws.rs.core.UriInfo;

import com.org.panthers.framework.busBaseDAOImpl;
import com.org.panthers.framework.doBase;

import java.util.Date;


/**
 * The persistent class for the TRAN_THREADS database table.
 * 
 */
@Entity
@Table(name="TRAN_THREAD")
@NamedQuery(name="doThread.findAll", query="SELECT d FROM doThread d")
public class doThread extends doBase implements Serializable {
	public static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="THREAD_ID")
	public int threadId;
	
	@Column(name="DESCRIPTION")
	public String description;

	@Column(name="STATUS_ID")
	public int statusId;

	@Column(name="STATUS_VALUE")
	public String statusValue;

	@Column(name="THREAD")
	public String thread;

	@Column(name="THREAD_LINK")
	public String threadLink;
	
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

	public doThread() {
	}

	public int getThreadId() {
		return this.threadId;
	}

	public void setThreadId(int threadId) {
		this.threadId = threadId;
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

	public int getStatusId() {
		return this.statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getStatusValue() {
		return this.statusValue;
	}

	public void setStatusValue(String statusValue) {
		this.statusValue = statusValue;
	}

	public String getThread() {
		return this.thread;
	}

	public void setThread(String thread) {
		this.thread = thread;
	}

	public String getThreadLink() {
		return this.threadLink;
	}

	public void setThreadLink(String threadLink) {
		this.threadLink = threadLink;
	}

	public int getUpdateSeq() {
		return this.updateSeq;
	}

	public void setUpdateSeq(int updateSeq) {
		this.updateSeq = updateSeq;
	}

	@Override
	public int insert() {
		busBaseDAOImpl<doThread> baseDAOImpl = new busBaseDAOImpl<doThread>();
		this.loadCreatedByProperties();
		baseDAOImpl.insert(this);
		return this.getThreadId();
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doThread> baseDAOImpl = new busBaseDAOImpl<doThread>();
		baseDAOImpl.delete(doThread.class, this.getThreadId());
		return 1;
	}

	@Override
	public int update() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doThread> baseDAOImpl = new busBaseDAOImpl<doThread>();
		this.loadModifiedByProperties();
		baseDAOImpl.update(this);
		return 1;
	}

	@Override
	public doThread get() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doThread> baseDAOImpl = new busBaseDAOImpl<doThread>();
		return baseDAOImpl.get(this.getThreadId(), doThread.class);
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

	
	public enum enmThread {
		
		threadId,
		createdBy,
		createdDate,
		description,
		statusId,
		statusValue,
		modifiedBy,
		modifiedDate,
		thread,
		threadLink,
		updateSeq
	}

}
