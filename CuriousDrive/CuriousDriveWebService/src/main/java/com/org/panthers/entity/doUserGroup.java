package com.org.panthers.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.org.panthers.framework.busBaseDAOImpl;
import com.org.panthers.framework.doBase;

import java.util.Date;


/**
 * The persistent class for the SYS_CODE database table.
 * 
 */
@Entity
@Table(name="TRAN_USER_GROUP")
@NamedQuery(name="doUserGroup.findAll", query="SELECT d FROM doUserGroup d")
public class doUserGroup extends doBase implements Serializable {
	public static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_GROUP_ID")
	public int userGroupId;

	@Column(name="GROUP_NAME")
	public String groupName;
	
	@Column(name="GROUP_DESCRIPTION")
	public String groupDescription;

	@Column(name="GROUP_STATUS_ID")
	public int groupStatusId;

	@Column(name="GROUP_STATUS_VALUE")
	public String groupStatusValue;

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
	

	public doUserGroup() {
	}
	
	public int getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(int userGroupId) {
		this.userGroupId = userGroupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupDescription() {
		return groupDescription;
	}

	public void setGroupDescription(String groupDescription) {
		this.groupDescription = groupDescription;
	}

	public int getGroupStatusId() {
		return groupStatusId;
	}

	public void setGroupStatusId(int groupStatusId) {
		this.groupStatusId = groupStatusId;
	}

	public String getGroupStatusValue() {
		return groupStatusValue;
	}

	public void setGroupStatusValue(String groupStatusValue) {
		this.groupStatusValue = groupStatusValue;
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
		busBaseDAOImpl<doUserGroup> baseDAOImpl = new busBaseDAOImpl<doUserGroup>();
		this.loadCreatedByProperties();
		baseDAOImpl.insert(this);
		return this.getUserGroupId();
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doUserGroup> baseDAOImpl = new busBaseDAOImpl<doUserGroup>();
		baseDAOImpl.delete(doUserGroup.class, this.getUserGroupId());
		return 1;
	}

	@Override
	public int update() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doUserGroup> baseDAOImpl = new busBaseDAOImpl<doUserGroup>();
		this.loadModifiedByProperties();
		baseDAOImpl.update(this);
		return 1;
	}

	@Override
	public doUserGroup get() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doUserGroup> baseDAOImpl = new busBaseDAOImpl<doUserGroup>();
		return baseDAOImpl.get(this.getUserGroupId(), doUserGroup.class);
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
	
	public enum enmUserGroup {
		userGroupId,
		groupName,
		groupDescription,
		groupStatusId,
		groupStatusValue,
		createdBy,
		createdDate,
		modifiedBy,
		modifiedDate,
		updateSeq
	}
}

