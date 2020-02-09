package com.org.panthers.entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.ws.rs.core.UriInfo;

import com.org.panthers.framework.busBaseDAOImpl;
import com.org.panthers.framework.doBase;

import java.util.Date;


/**
 * The persistent class for the TRAN_QUESTION_CLASSES database table.
 * 
 */
@Entity
@Table(name="TRAN_QUESTION_CLASS")
@NamedQuery(name="doQuestionClass.findAll", query="SELECT d FROM doQuestionClass d")
public class doQuestionClass extends doBase implements Serializable {
	public static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="QUESTION_CLASS_ID")
	public int questionClassId;

	@Column(name="CLASS_ID")
	public int classId;

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

	@Column(name="QUESTION_ID")
	public int questionId;

	@Column(name="UPDATE_SEQ")
	public int updateSeq;

	public doQuestionClass() {
	}

	public int getQuestionClassId() {
		return questionClassId;
	}

	public void setQuestionClassId(int questionClassId) {
		this.questionClassId = questionClassId;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
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

	public int getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public int getUpdateSeq() {
		return this.updateSeq;
	}

	public void setUpdateSeq(int updateSeq) {
		this.updateSeq = updateSeq;
	}
	
	@Override
	public int insert() {
		busBaseDAOImpl<doQuestionClass> baseDAOImpl = new busBaseDAOImpl<doQuestionClass>();
		this.loadCreatedByProperties();
		baseDAOImpl.insert(this);
		return this.getQuestionClassId();
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doQuestionClass> baseDAOImpl = new busBaseDAOImpl<doQuestionClass>();
		baseDAOImpl.delete(doQuestionClass.class, this.getQuestionClassId());
		return 1;
	}

	@Override
	public int update() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doQuestionClass> baseDAOImpl = new busBaseDAOImpl<doQuestionClass>();
		this.loadModifiedByProperties();
		baseDAOImpl.update(this);
		return 1;
	}

	@Override
	public doQuestionClass get() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doQuestionClass> baseDAOImpl = new busBaseDAOImpl<doQuestionClass>();
		return baseDAOImpl.get(this.getQuestionClassId(), doQuestionClass.class);
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

	public enum enmQuestionClass {
		
		questionClassId,
		classId,
		createdBy,
		createdDate,
		modifiedBy,
		modifiedDate,
		questionId,
		updateSeq
	}

}
