package com.org.panthers.entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.ws.rs.core.UriInfo;

import com.org.panthers.framework.busBaseDAOImpl;
import com.org.panthers.framework.doBase;

import java.util.Date;


/**
 * The persistent class for the TRAN_QUESTION_VIEWS database table.
 * 
 */
@Entity
@Table(name="TRAN_QUESTION_VIEW")
@NamedQuery(name="doQuestionView.findAll", query="SELECT d FROM doQuestionView d")
public class doQuestionView extends doBase implements Serializable {
	public static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="QUESTION_VIEW_ID")
	public int questionViewId;

	@Column(name="QUESTION_ID")
	public int questionId;

	@Column(name="USER_ID")
	public int userId;
	
	@Column(name="BROWSER")
	public String browser;
	
	@Column(name="IP_ADDRESS")
	public String ipAddress;
	
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
	
	public doQuestionView() {
	}

	public int getQuestionViewId() {
		return this.questionViewId;
	}

	public void setQuestionViewId(int questionViewId) {
		this.questionViewId = questionViewId;
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

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	@Override
	public int insert() {
		busBaseDAOImpl<doQuestionView> baseDAOImpl = new busBaseDAOImpl<doQuestionView>();
		this.loadCreatedByProperties();
		baseDAOImpl.insert(this);
		return this.getQuestionViewId();
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doQuestionView> baseDAOImpl = new busBaseDAOImpl<doQuestionView>();
		baseDAOImpl.delete(doQuestionView.class, this.getQuestionViewId());
		return 1;
	}

	@Override
	public int update() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doQuestionView> baseDAOImpl = new busBaseDAOImpl<doQuestionView>();
		this.loadModifiedByProperties();
		baseDAOImpl.update(this);
		return 1;
	}

	@Override
	public doQuestionView get() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doQuestionView> baseDAOImpl = new busBaseDAOImpl<doQuestionView>();
		return baseDAOImpl.get(this.getQuestionViewId(), doQuestionView.class);
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

	
	public enum enmQuestionView {
		
		questionViewId,
		createdBy,
		createdDate,
		modifiedBy,
		modifiedDate,
		questionId,
		updateSeq,
		userId,
		browser,
		ipAddress
	}

}
