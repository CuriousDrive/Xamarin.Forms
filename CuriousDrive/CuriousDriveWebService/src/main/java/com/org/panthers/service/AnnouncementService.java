package com.org.panthers.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.org.panthers.business.busAnnouncement;
import com.org.panthers.business.busConstant;
import com.org.panthers.business.busTag;
import com.org.panthers.entity.doAnnouncement;
import com.org.panthers.framework.busBaseDAOImpl;
import com.org.panthers.framework.busUtil;

public class AnnouncementService {

	/** this method loads all Announcements from Announcement table */
	public List<busAnnouncement> loadAnnouncements() {

		busBaseDAOImpl<doAnnouncement> baseDAOImpl = new busBaseDAOImpl<doAnnouncement>();
		busAnnouncement lbusAnnouncement = new busAnnouncement();
		List<busAnnouncement> llstbusAnnouncement = lbusAnnouncement.getCollection(baseDAOImpl.getAll(doAnnouncement.class));
		return llstbusAnnouncement;
	}
	
	/** this method loads all Announcements from Announcement table */
	public List<busAnnouncement> getAnnouncements() {

		busBaseDAOImpl<doAnnouncement> baseDAOImpl = new busBaseDAOImpl<doAnnouncement>();
		List<busAnnouncement> llstbusAnnouncement = new busAnnouncement().getCollection(baseDAOImpl.getAll(doAnnouncement.class));
		
		for (busAnnouncement lbusAnnouncement : llstbusAnnouncement) {
			
			lbusAnnouncement.idoAnnouncement.announcementHtml = busUtil.convertHTMLtoString(lbusAnnouncement.idoAnnouncement.announcementHtml, 300);
			lbusAnnouncement.loadAnnouncementTitleURL(false);
			
			lbusAnnouncement.loadUser();
		}
		
		return llstbusAnnouncement;
	}

	/**
	 * this method loads Announcement based it primary key passed from Announcement
	 * table
	 */
	public busAnnouncement loadAnnouncement(int id) {
		busAnnouncement lbusAnnouncement = new busAnnouncement();
		lbusAnnouncement.idoAnnouncement.setAnnouncementId(id);
		lbusAnnouncement.idoAnnouncement = lbusAnnouncement.idoAnnouncement.get();
		return lbusAnnouncement;
	}

	/**
	 * this method loads Announcement based it primary key passed from Announcement
	 * table
	 */
	public int deleteAnnouncement(int id) {
		busAnnouncement lbusAnnouncement = new busAnnouncement();
		lbusAnnouncement.idoAnnouncement.setAnnouncementId(id);

		return lbusAnnouncement.idoAnnouncement.delete();
	}

	/**
	 * this method updates Announcement based it's object passed from front end
	 */
	public int updateAnnouncement(busAnnouncement abusAnnouncement) {		
		
		return abusAnnouncement.idoAnnouncement.update();
	}
	
	/**
	 * this method inserts Announcement based it's object passed from front end
	 */
	public busAnnouncement createAnnouncement(busAnnouncement abusAnnouncement) {
		
		if (abusAnnouncement.validateInsertAnnouncement())
		{
			int lintAnnouncementId = abusAnnouncement.idoAnnouncement.insert();
			abusAnnouncement.addMessage(busConstant.SuccessAnnouncement);
			
			new busTag().insertUserTags(abusAnnouncement.istrUserTags, abusAnnouncement.idoAnnouncement.iintUserId, busConstant.PostTypeAnnouncement,lintAnnouncementId,busConstant.ActionTypeMentionInAnnouncement);
		}
		else 
		{
			return abusAnnouncement;
		}
		
		return abusAnnouncement;
	}
	
	public busAnnouncement getAnnouncementDetails(int id,int aintLoggedInUserId) {
		busAnnouncement lbusAnnouncement = new busAnnouncement();
		lbusAnnouncement.idoAnnouncement.setAnnouncementId(id);
		lbusAnnouncement.loadDetails(aintLoggedInUserId);
		return lbusAnnouncement;
	}
}
