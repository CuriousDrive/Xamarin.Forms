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
@Table(name="SYS_LEVEL")
@NamedQuery(name="doLevel.findAll", query="SELECT d FROM doLevel d")
public class doLevel extends doBase implements Serializable {
	public static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="LEVEL_ID")
	public int levelId;

	@Column(name="ORDER_NO")
	public int orderNo;

	@Column(name="LEVEL_NAME")
	public String levelName;
	
	@Column(name="POINTS")
	public int points;
	
	@Column(name="DESCRIPTION")
	public String description;

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

	public doLevel()
	{
		
	}
	
	public int getLevelId() {
		return levelId;
	}

	public void setLevelId(int levelId) {
		this.levelId = levelId;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		busBaseDAOImpl<doLevel> baseDAOImpl = new busBaseDAOImpl<doLevel>();
		this.loadCreatedByProperties();
		baseDAOImpl.insert(this);
		return this.getLevelId();
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doLevel> baseDAOImpl = new busBaseDAOImpl<doLevel>();
		baseDAOImpl.delete(doLevel.class, this.getLevelId());
		return 1;
	}

	@Override
	public int update() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doLevel> baseDAOImpl = new busBaseDAOImpl<doLevel>();
		this.loadModifiedByProperties();
		baseDAOImpl.update(this);
		return 1;
	}

	@Override
	public doLevel get() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doLevel> baseDAOImpl = new busBaseDAOImpl<doLevel>();
		return baseDAOImpl.get(this.getLevelId(), doLevel.class);
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

	
	public enum enmLevel {
		levelId,
		orderNo,
		levelName,
		points,
		description,
		createdBy,
		createdDate,
		modifiedBy,
		modifiedDate,
		updateSeq
	}
}
