package com.org.panthers.entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.ws.rs.core.UriInfo;

import com.org.panthers.framework.busBaseDAOImpl;
import com.org.panthers.framework.doBase;

import java.util.Date;


/**
 * The persistent class for the SYS_CODE_VALUE database table.
 * 
 */
@Entity
@Table(name="SYS_CODE_VALUE")
@NamedQuery(name="doCodeValue.findAll", query="SELECT d FROM doCodeValue d")
public class doCodeValue extends doBase implements Serializable {
	public static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CODE_VALUE_ID")
	public int codeValueId;

	@Column(name="CODE_ID")
	public int codeId;

	@Column(name="CODE_VALUE")
	public String codeValue;

	@Column(name="COMMENTS")
	public String comments;

	@Column(name="CREATED_BY")
	public int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_DATE")
	public Date createdDate;

	@Column(name="DATA1")
	public String data1;

	@Column(name="DATA2")
	public String data2;

	@Column(name="DATA3")
	public String data3;

	@Column(name="DESCRIPTION")
	public String description;

	@Column(name="MODIFIED_BY")
	public int modifiedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="MODIFIED_DATE")
	public Date modifiedDate;

	@Column(name="UPDATE_SEQ")
	public int updateSeq;

	public doCodeValue() {
	}

	public int getCodeValueId() {
		return this.codeValueId;
	}

	public void setCodeValueId(int codeValueId) {
		this.codeValueId = codeValueId;
	}

	public int getCodeId() {
		return this.codeId;
	}

	public void setCodeId(int codeId) {
		this.codeId = codeId;
	}

	public String getCodeValue() {
		return this.codeValue;
	}

	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
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

	public String getData1() {
		return this.data1;
	}

	public void setData1(String data1) {
		this.data1 = data1;
	}

	public String getData2() {
		return this.data2;
	}

	public void setData2(String data2) {
		this.data2 = data2;
	}

	public String getData3() {
		return this.data3;
	}

	public void setData3(String data3) {
		this.data3 = data3;
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

	public int getUpdateSeq() {
		return this.updateSeq;
	}

	public void setUpdateSeq(int updateSeq) {
		this.updateSeq = updateSeq;
	}

	@Override
	public int insert() {
		busBaseDAOImpl<doCodeValue> baseDAOImpl = new busBaseDAOImpl<doCodeValue>();
		this.loadCreatedByProperties();
		baseDAOImpl.insert(this);
		return this.getCodeValueId();
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doCodeValue> baseDAOImpl = new busBaseDAOImpl<doCodeValue>();
		baseDAOImpl.delete(doCodeValue.class, this.getCodeValueId());
		return 1;
	}

	@Override
	public int update() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doCodeValue> baseDAOImpl = new busBaseDAOImpl<doCodeValue>();
		this.loadModifiedByProperties();
		baseDAOImpl.update(this);
		return 1;
	}

	@Override
	public doCodeValue get() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doCodeValue> baseDAOImpl = new busBaseDAOImpl<doCodeValue>();
		return baseDAOImpl.get(this.getCodeValueId(), doCodeValue.class);
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

	
	public enum enmCodeValue {
		
		codeValueId,
		codeId,
		codeValue,
		comments,
		createdBy,
		data1,
		data2,
		data3,
		description,
		modifiedBy,
		modifiedDate,
		updateSeq
	}
}
