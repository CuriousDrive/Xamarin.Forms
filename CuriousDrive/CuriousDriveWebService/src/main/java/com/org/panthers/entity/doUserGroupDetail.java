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
@Table(name="TRAN_USER_GROUP_DETAIL")
@NamedQuery(name="doUserGroupDetail.findAll", query="SELECT d FROM doUserGroupDetail d")
public class doUserGroupDetail extends doBase implements Serializable {
	public static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_GROUP_DETAIL_ID")
	public int userGroupDetailId;

	@Column(name="USER_GROUP_ID")
	public int userGroupId;
	
	@Column(name="USER_ID")
	public int userId ;
	
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
	

	public doUserGroupDetail() {
	}
	
	public int getUserGroupDetailId() {
		return userGroupDetailId;
	}

	public void setUserGroupDetailId(int userGroupDetailId) {
		this.userGroupDetailId = userGroupDetailId;
	}

	public int getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(int userGroupId) {
		this.userGroupId = userGroupId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
		busBaseDAOImpl<doUserGroupDetail> baseDAOImpl = new busBaseDAOImpl<doUserGroupDetail>();
		this.loadCreatedByProperties();
		baseDAOImpl.insert(this);
		return this.getUserGroupDetailId();
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doUserGroupDetail> baseDAOImpl = new busBaseDAOImpl<doUserGroupDetail>();
		baseDAOImpl.delete(doUserGroupDetail.class, this.getUserGroupDetailId());
		return 1;
	}

	@Override
	public int update() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doUserGroupDetail> baseDAOImpl = new busBaseDAOImpl<doUserGroupDetail>();
		this.loadModifiedByProperties();
		baseDAOImpl.update(this);
		return 1;
	}

	@Override
	public doUserGroupDetail get() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doUserGroupDetail> baseDAOImpl = new busBaseDAOImpl<doUserGroupDetail>();
		return baseDAOImpl.get(this.getUserGroupDetailId(), doUserGroupDetail.class);
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
	
	public enum enmUserGroupDetail {
		userGroupDetailId,
		userGroupId,
		userId,
		createdBy,
		createdDate,
		modifiedBy,
		modifiedDate,
		updateSeq
	}
}

