package com.org.panthers.entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.ws.rs.core.UriInfo;

import com.org.panthers.framework.busBaseDAOImpl;
import com.org.panthers.framework.doBase;

import java.util.Date;


/**
 * The persistent class for the TRAN_TAGS database table.
 * 
 */
@Entity
@Table(name="TRAN_TAG_DETAIL")
@NamedQuery(name="doTagDetail.findAll", query="SELECT d FROM doTagDetail d")
public class doTagDetail extends doBase implements Serializable {
	
	public static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TAG_DETAIL_ID")
	public int tagDetailId;
	
	@Column(name="TAG_ID")
	public int tagId;
	
	@Column(name="TAGGED_USER_ID")
	public int taggedUserId;
	
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


	public doTagDetail() {
		// TODO Auto-generated constructor stub
	}
	
	public int getTagDetailId() {
		return tagDetailId;
	}

	public void setTagDetailId(int tagDetailId) {
		this.tagDetailId = tagDetailId;
	}

	public int getTagId() {
		return tagId;
	}

	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

	public int getTaggedUserId() {
		return taggedUserId;
	}

	public void setTaggedUserId(int taggedUserId) {
		this.taggedUserId = taggedUserId;
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
		busBaseDAOImpl<doTagDetail> baseDAOImpl = new busBaseDAOImpl<doTagDetail>();
		this.loadCreatedByProperties();
		baseDAOImpl.insert(this);
		return this.getTagDetailId();
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doTagDetail> baseDAOImpl = new busBaseDAOImpl<doTagDetail>();
		baseDAOImpl.delete(doTagDetail.class, this.getTagDetailId());
		return 1;
	}

	@Override
	public int update() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doTagDetail> baseDAOImpl = new busBaseDAOImpl<doTagDetail>();
		this.loadModifiedByProperties();
		baseDAOImpl.update(this);
		return 1;
	}

	@Override
	public doTagDetail get() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doTagDetail> baseDAOImpl = new busBaseDAOImpl<doTagDetail>();
		return baseDAOImpl.get(this.getTagDetailId(), doTagDetail.class);
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
		
		tagDetailId,
		tagId,
		taggedUserId,
		createdBy,
		createdDate,
		modifiedBy,
		modifiedDate,
		updateSeq
	}
	
}
