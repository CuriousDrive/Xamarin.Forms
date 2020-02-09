package com.org.panthers.entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.ws.rs.core.UriInfo;

import com.org.panthers.framework.busBaseDAOImpl;
import com.org.panthers.framework.doBase;

import java.util.Date;


/**
 * The persistent class for the SYS_USER_ROLES database table.
 * 
 */
@Entity
@Table(name="SYS_USER_ROLE")
@NamedQuery(name="doUserRole.findAll", query="SELECT d FROM doUserRole d")
public class doUserRole extends doBase implements Serializable {
	public static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ROLE_ID")
	public int userRoleId;

	@Column(name="USER_ID")
	public int userId;
		
	@Column(name="ROLE_ID")
	public int roleId;
	
	@Column(name="ROLE_VALUE")
	public String roleValue;
	
	@Column(name="USER_GROUP_ID")
	public int userGroupId;
	
	@Column(name="USER_GROUP_VALUE")
	public String userGroupValue;
	
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


	public doUserRole() {
	}

	public int getUserRoleId() {
		return this.userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}
	
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
		
	public String getRoleValue() {
		return roleValue;
	}

	public void setRoleValue(String roleValue) {
		this.roleValue = roleValue;
	}

	public int getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(int userGroupId) {
		this.userGroupId = userGroupId;
	}

	public String getUserGroupValue() {
		return userGroupValue;
	}

	public void setUserGroupValue(String userGroupValue) {
		this.userGroupValue = userGroupValue;
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

	public int getUpdateSeq() {
		return this.updateSeq;
	}

	public void setUpdateSeq(int updateSeq) {
		this.updateSeq = updateSeq;
	}
	
	@Override
	public int insert() {
		busBaseDAOImpl<doUserRole> baseDAOImpl = new busBaseDAOImpl<doUserRole>();
		this.loadCreatedByProperties();
		baseDAOImpl.insert(this);
		return this.getUserRoleId();
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doUserRole> baseDAOImpl = new busBaseDAOImpl<doUserRole>();
		baseDAOImpl.delete(doUserRole.class, this.getUserRoleId());
		return 1;
	}

	@Override
	public int update() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doUserRole> baseDAOImpl = new busBaseDAOImpl<doUserRole>();
		this.loadModifiedByProperties();
		baseDAOImpl.update(this);
		return 1;
	}

	@Override
	public doUserRole get() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doUserRole> baseDAOImpl = new busBaseDAOImpl<doUserRole>();
		return baseDAOImpl.get(this.getUserRoleId(), doUserRole.class);
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

	
	public enum enmUserRole {
		roleId,
		createdBy,
		createdDate,
		modifiedBy,
		modifiedDate,
		updateSeq,
		userId,
		userRoleId
	}
}
