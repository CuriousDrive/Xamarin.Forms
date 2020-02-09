package com.org.panthers.entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.ws.rs.core.UriInfo;

import com.org.panthers.framework.busBaseDAOImpl;
import com.org.panthers.framework.doBase;

import java.util.Date;


/**
 * The persistent class for the TRAN_QUESTION database table.
 * 
 */
@Entity
@Table(name="TRAN_QUESTION")
@NamedQuery(name="doQuestion.findAll", query="SELECT d FROM doQuestion d")
public class doQuestion extends doBase<doQuestion> implements Serializable {
	public static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="QUESTION_ID")
	public int questionId;
	
	@Column(name="IS_VALID")
	public byte isValid;
	
	@Lob
	@Column(name="QUESTION_HTML")
	public String questionHtml;

	@Column(name="QUESTION_TITLE")
	public String questionTitle;

	@Column(name="THREAD_ID")
	public int threadId;
	
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

	public doQuestion() {
	}

	public int getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	
	public byte getIsValid() {
		return this.isValid;
	}

	public void setIsValid(byte isValid) {
		this.isValid = isValid;
	}
	
	public String getQuestionHtml() {
		return this.questionHtml;
	}

	public void setQuestionHtml(String questionHtml) {
		this.questionHtml = questionHtml;
	}

	public String getQuestionTitle() {
		return this.questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
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
		busBaseDAOImpl<doQuestion> baseDAOImpl = new busBaseDAOImpl<doQuestion>();
		this.loadCreatedByProperties();
		baseDAOImpl.insert(this);
		return this.getQuestionId();
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doQuestion> baseDAOImpl = new busBaseDAOImpl<doQuestion>();
		baseDAOImpl.delete(doQuestion.class, this.getQuestionId());
		return 1;
	}

	@Override
	public int update() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doQuestion> baseDAOImpl = new busBaseDAOImpl<doQuestion>();
		this.loadModifiedByProperties();
		baseDAOImpl.update(this);
		return 1;
	}

	@Override
	public doQuestion get() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doQuestion> baseDAOImpl = new busBaseDAOImpl<doQuestion>();
		return baseDAOImpl.get(this.getQuestionId(), doQuestion.class);
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

	
	public enum enmQuestion {
	
		questionId,
		createdBy,
		createdDate,
		isValid,
		modifiedBy,
		modifiedDate,
		questionHtml,
		questionTitle,
		threadId,
		updateSeq
	}

}
