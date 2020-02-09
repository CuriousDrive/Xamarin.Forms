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
@Table(name="TRAN_COMMENT")
@NamedQuery(name="doComment.findAll", query="SELECT d FROM doComment d")
public class doComment extends doBase implements Serializable {
	

	public static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="COMMENT_ID")
	public int commentId;

	@Lob
	@Column(name="COMMENT_HTML")
	public String commentHtml;
	
	@Column(name="SUBSYSTEM_ID")
	public int subsystemId;

	@Column(name="SUBSYSTEM_REFERENCE_ID")
	public int subsystemReferenceId;

	@Column(name="SUBSYSTEM_VALUE")
	public String subsystemValue;

	@Column(name="UPDATE_SEQ")
	public int updateSeq;

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


	public doComment() {
	}

	public int getCommentId() {
		return this.commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getCommentHtml() {
		return this.commentHtml;
	}

	public void setCommentHtml(String commentHtml) {
		this.commentHtml = commentHtml;
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

	public String getSubsystemValue() {
		return this.subsystemValue;
	}

	public void setSubsystemValue(String subsystemValue) {
		this.subsystemValue = subsystemValue;
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
		busBaseDAOImpl<doComment> baseDAOImpl = new busBaseDAOImpl<doComment>();
		this.loadCreatedByProperties();
		baseDAOImpl.insert(this);
		return this.getCommentId();
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doComment> baseDAOImpl = new busBaseDAOImpl<doComment>();
		baseDAOImpl.delete(doComment.class, this.getCommentId());
		return 1;
	}

	@Override
	public int update() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doComment> baseDAOImpl = new busBaseDAOImpl<doComment>();
		this.loadModifiedByProperties();
		baseDAOImpl.update(this);
		return 1;
	}

	@Override
	public doComment get() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doComment> baseDAOImpl = new busBaseDAOImpl<doComment>();
		return baseDAOImpl.get(this.getCommentId(), doComment.class);
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

	
	public enum enmComment {
		
		commentId,
		commentHtml,
		subsystemId,
		subsystemReferenceId,
		subsystemValue,
		createdBy,
		createdDate,
		modifiedBy,
		modifiedDate,
		updateSeq,
		userId
	}
}
