package com.org.panthers.entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.ws.rs.core.UriInfo;

import com.org.panthers.framework.busBaseDAOImpl;
import com.org.panthers.framework.doBase;

import java.util.Date;


/**
 * The persistent class for the TRAN_TAG database table.
 * 
 */
@Entity
@Table(name="TRAN_TAG")
@NamedQuery(name="doTag.findAll", query="SELECT d FROM doTag d")
public class doTag extends doBase implements Serializable {
	public static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TAG_ID")
	public int tagId;
	
	@Column(name="USER_ID")
	public int userId;
	
	@Column(name="USER_GROUP_TYPE_ID")
	public int userGroupTypeId;
	
	@Column(name="USER_GROUP_TYPE_VALUE")
	public String userGroupTypeValue;
	
	@Column(name="USER_GROUP_VALUE")
	public String userGroupValue;
	
	@Column(name="SUBSYSTEM_ID")
	public int subsystemId;

	@Column(name="SUBSYSTEM_VALUE")
	public String subsystemValue;
	
	@Column(name="SUBSYSTEM_REFERENCE_ID")
	public int subsystemReferenceId;
	
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
	

	public doTag() {
		// TODO Auto-generated constructor stub
	}
	
	public int getTagId() {
		return tagId;
	}

	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserGroupTypeId() {
		return userGroupTypeId;
	}

	public void setUserGroupTypeId(int userGroupTypeId) {
		this.userGroupTypeId = userGroupTypeId;
	}

	public String getUserGroupTypeValue() {
		return userGroupTypeValue;
	}

	public void setUserGroupTypeValue(String userGroupTypeValue) {
		this.userGroupTypeValue = userGroupTypeValue;
	}
	
	public String getUserGroupValue() {
		return userGroupValue;
	}

	public void setUserGroupValue(String userGroupValue) {
		this.userGroupValue = userGroupValue;
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
		busBaseDAOImpl<doTag> baseDAOImpl = new busBaseDAOImpl<doTag>();
		this.loadCreatedByProperties();
		baseDAOImpl.insert(this);
		return this.getTagId();
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doTag> baseDAOImpl = new busBaseDAOImpl<doTag>();
		baseDAOImpl.delete(doTag.class, this.getTagId());
		return 1;
	}

	@Override
	public int update() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doTag> baseDAOImpl = new busBaseDAOImpl<doTag>();
		this.loadModifiedByProperties();
		baseDAOImpl.update(this);
		return 1;
	}

	@Override
	public doTag get() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doTag> baseDAOImpl = new busBaseDAOImpl<doTag>();
		return baseDAOImpl.get(this.getTagId(), doTag.class);
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

	
	public enum enmTag {
		
		tagId,
		userId,
		userGroupTypeId,
		userGroupTypeValue,
		userGroupId,
		subsystemId,
		subsystemValue,
		subsystemReferenceId,
		createdBy,
		createdDate,
		modifiedBy,
		modifiedDate,
		updateSeq
	}
}
