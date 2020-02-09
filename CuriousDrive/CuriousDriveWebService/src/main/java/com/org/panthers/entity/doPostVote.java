package com.org.panthers.entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.ws.rs.core.UriInfo;

import com.org.panthers.framework.busBaseDAOImpl;
import com.org.panthers.framework.doBase;

import java.util.Date;


/**
 * The persistent class for the TRAN_POST_VOTES database table.
 * 
 */
@Entity
@Table(name="TRAN_POST_VOTE")
@NamedQuery(name="doPostVote.findAll", query="SELECT d FROM doPostVote d")
public class doPostVote extends doBase implements Serializable {
	public static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="POST_VOTE_ID")
	public int postVoteId;
	
	@Column(name="QUESTION_ID")
	public int questionId;
	
	@Column(name="SUBSYSTEM_ID")
	public int subsystemId;

	@Column(name="SUBSYSTEM_REFERENCE_ID")
	public int subsystemReferenceId;

	@Column(name="SUBSYSTEM_VALUE")
	public String subsystemValue;

	@Column(name="SUBYSTEM_VALUE")
	public String subystemValue;
	
	@Column(name="USER_ID")
	public int userId;

	@Column(name="VOTE_ID")
	public int voteId;

	@Column(name="VOTE_VALUE")
	public String voteValue;
	
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



	public doPostVote() {
	}

	public int getPostVoteId() {
		return this.postVoteId;
	}

	public void setPostVoteId(int postVoteId) {
		this.postVoteId = postVoteId;
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

	public int getSubsystemId() {
		return this.subsystemId;
	}

	public void setSubsystemId(int subsystemId) {
		this.subsystemId = subsystemId;
	}

	public int getSubsystemReferenceId() {
		return this.subsystemReferenceId;
	}

	public void setSubsystemReferenceId(int subsystemReferenceId) {
		this.subsystemReferenceId = subsystemReferenceId;
	}

	public String getSubsystemValue() {
		return this.subsystemValue;
	}

	public void setSubsystemValue(String subsystemValue) {
		this.subsystemValue = subsystemValue;
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

	public int getVoteId() {
		return this.voteId;
	}

	public void setVoteId(int voteId) {
		this.voteId = voteId;
	}

	public String getVoteValue() {
		return this.voteValue;
	}

	public void setVoteValue(String voteValue) {
		this.voteValue = voteValue;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	@Override
	public int insert() {
		busBaseDAOImpl<doPostVote> baseDAOImpl = new busBaseDAOImpl<doPostVote>();
		this.loadCreatedByProperties();
		baseDAOImpl.insert(this);
		return this.getPostVoteId();
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doPostVote> baseDAOImpl = new busBaseDAOImpl<doPostVote>();
		baseDAOImpl.delete(doPostVote.class, this.getPostVoteId());
		return 1;
	}

	@Override
	public int update() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doPostVote> baseDAOImpl = new busBaseDAOImpl<doPostVote>();
		this.loadModifiedByProperties();
		baseDAOImpl.update(this);
		return 1;
	}

	@Override
	public doPostVote get() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doPostVote> baseDAOImpl = new busBaseDAOImpl<doPostVote>();
		return baseDAOImpl.get(this.getPostVoteId(), doPostVote.class);
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

	
	public enum enmPostVote {
		
		postVoteId,
		questionId,
		createdBy,
		createdDate,
		modifiedBy,
		modifiedDate,
		subsystemId,
		subsystemReferenceId,
		subsystemValue,
		updateSeq,
		userId,
		voteId,
		voteValue
	}

}
