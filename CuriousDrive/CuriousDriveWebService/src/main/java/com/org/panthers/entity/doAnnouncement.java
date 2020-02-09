package com.org.panthers.entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.ws.rs.core.UriInfo;

import com.org.panthers.framework.busBaseDAOImpl;
import com.org.panthers.framework.doBase;

import java.util.Date;


/**
 * The persistent class for the TRAN_ANNOUNCEMENTS database table.
 * 
 */
@Entity
@Table(name="TRAN_ANNOUNCEMENT")
@NamedQuery(name="doAnnouncement.findAll", query="SELECT d FROM doAnnouncement d")
public class doAnnouncement extends doBase implements Serializable {
	public static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ANNOUNCEMENT_ID")
	public int announcementId;
	
	@Column(name="USER_ID")
	public int userId;
	
	@Column(name="ANNOUNCEMENT_TITLE")
	public String announcementTitle;
	
	@Lob
	@Column(name="ANNOUNCEMENT_HTML")
	public String announcementHtml;

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

	public doAnnouncement() {
	
	}
	
	public int getAnnouncementId() {
		return announcementId;
	}

	public void setAnnouncementId(int announcementId) {
		this.announcementId = announcementId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAnnouncementTitle() {
		return announcementTitle;
	}

	public void setAnnouncementTitle(String announcementTitle) {
		this.announcementTitle = announcementTitle;
	}

	public String getAnnouncementHtml() {
		return announcementHtml;
	}

	public void setAnnouncementHtml(String announcementHtml) {
		this.announcementHtml = announcementHtml;
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
		busBaseDAOImpl<doAnnouncement> baseDAOImpl = new busBaseDAOImpl<doAnnouncement>();
		this.loadCreatedByProperties();
		baseDAOImpl.insert(this);
		return this.getAnnouncementId();
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doAnnouncement> baseDAOImpl = new busBaseDAOImpl<doAnnouncement>();
		baseDAOImpl.delete(doAnnouncement.class, this.getAnnouncementId());
		return 1;
	}

	@Override
	public int update() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doAnnouncement> baseDAOImpl = new busBaseDAOImpl<doAnnouncement>();
		this.loadModifiedByProperties();
		baseDAOImpl.update(this);
		return 1;
	}

	@Override
	public doAnnouncement get() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doAnnouncement> baseDAOImpl = new busBaseDAOImpl<doAnnouncement>();
		return baseDAOImpl.get(this.getAnnouncementId(), doAnnouncement.class);
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

	
	public enum enmAnnouncement {
	
		announcementId,
		userId,
		announcementHtml,
		announcementTitle,
		createdBy,
		createdDate,
		modifiedBy,
		modifiedDate,
		updateSeq
	}

}
