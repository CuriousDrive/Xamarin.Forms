package com.org.panthers.entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.ws.rs.core.UriInfo;

import com.org.panthers.framework.busBaseDAOImpl;
import com.org.panthers.framework.doBase;

import java.util.Date;


/**
 * The persistent class for the SYS_CODE database table.
 * 
 */
@Entity
@Table(name="SYS_CODE")
@NamedQuery(name="doCode.findAll", query="SELECT d FROM doCode d")
public class doCode extends doBase implements Serializable {
	public static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CODE_ID")
	public int codeId;

	@Column(name="CODE_DESCRIPTION")
	public String codeDescription;

	@Column(name="COMMENTS")
	public String comments;
	
	@Column(name="DATA1_CAPTION")
	public String data1Caption;

	@Column(name="DATA1_TYPE")
	public String data1Type;

	@Column(name="DATA2_CAPTION")
	public String data2Caption;

	@Column(name="DATA2_TYPE")
	public String data2Type;

	@Column(name="DATA3_CAPTION")
	public String data3Caption;

	@Column(name="DATA3_TYPE")
	public String data3Type;

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

	public doCode() {
	}

	public int getCodeId() {
		return this.codeId;
	}

	public void setCodeId(int codeId) {
		this.codeId = codeId;
	}

	public String getCodeDescription() {
		return this.codeDescription;
	}

	public void setCodeDescription(String codeDescription) {
		this.codeDescription = codeDescription;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	
	public String getData1Caption() {
		return this.data1Caption;
	}

	public void setData1Caption(String data1Caption) {
		this.data1Caption = data1Caption;
	}

	public String getData1Type() {
		return this.data1Type;
	}

	public void setData1Type(String data1Type) {
		this.data1Type = data1Type;
	}

	public String getData2Caption() {
		return this.data2Caption;
	}

	public void setData2Caption(String data2Caption) {
		this.data2Caption = data2Caption;
	}

	public String getData2Type() {
		return this.data2Type;
	}

	public void setData2Type(String data2Type) {
		this.data2Type = data2Type;
	}

	public String getData3Caption() {
		return this.data3Caption;
	}

	public void setData3Caption(String data3Caption) {
		this.data3Caption = data3Caption;
	}

	public String getData3Type() {
		return this.data3Type;
	}

	public void setData3Type(String data3Type) {
		this.data3Type = data3Type;
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
		busBaseDAOImpl<doCode> baseDAOImpl = new busBaseDAOImpl<doCode>();
		this.loadCreatedByProperties();
		baseDAOImpl.insert(this);
		return this.getCodeId();
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doCode> baseDAOImpl = new busBaseDAOImpl<doCode>();
		baseDAOImpl.delete(doCode.class, this.getCodeId());
		return 1;
	}

	@Override
	public int update() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doCode> baseDAOImpl = new busBaseDAOImpl<doCode>();
		this.loadModifiedByProperties();
		baseDAOImpl.update(this);
		return 1;
	}

	@Override
	public doCode get() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doCode> baseDAOImpl = new busBaseDAOImpl<doCode>();
		return baseDAOImpl.get(this.getCodeId(), doCode.class);
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

	
	public enum enmCode {
		codeId,
		codeDescription,
		comments,
		createdBy,
		data1Caption,
		data1Type,
		data2Caption,
		data2Type,
		data3Caption,
		data3Type,
		modifiedBy,
		modifiedDate,
		updateSeq
	}
}

