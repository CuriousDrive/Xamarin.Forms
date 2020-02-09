package com.org.panthers.business;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.org.panthers.entity.doAnnouncement;
import com.org.panthers.entity.doComment;
import com.org.panthers.entity.doQuestion;
import com.org.panthers.framework.busBase;
import com.org.panthers.framework.busBaseDAOImpl;
import com.org.panthers.framework.busParameter;
import com.org.panthers.framework.busUtil;
import com.org.panthers.service.UserService;

public class busAnnouncement extends busBase{

	public doAnnouncement idoAnnouncement;
	public busUser ibusUser;
	public List<busTag> ilstbusTags;
	
    public String istrAnnouncementTitleURL;
    public String istrClassIds;
    public String istrUserTags;
    public String istrAnnouncementComment;
    public int iintViews;
    
    public List<busComment> ilstComments;
    
	public busAnnouncement() {
		
		idoAnnouncement = new doAnnouncement();
	}

	public List<busAnnouncement> getCollection(List<doAnnouncement> alstAnnouncements) {

		List<busAnnouncement> llstbusAnnouncements = new ArrayList<busAnnouncement>();

		for (doAnnouncement lAnnouncement : alstAnnouncements) {

			busAnnouncement lbusAnnouncement = new busAnnouncement();
			lbusAnnouncement.idoAnnouncement = lAnnouncement;
			llstbusAnnouncements.add(lbusAnnouncement);

		}
		return llstbusAnnouncements;
	}
	
	public void loadUser() {
		ibusUser = new UserService().getUserProfile(this.idoAnnouncement.userId, 0);		
	}
	
	public void loadDetails(int aintLoggedInUser) {
		
		this.idoAnnouncement = this.idoAnnouncement.get();
		this.loadUser();
		this.assignOwner(aintLoggedInUser);
		this.loadComments();
		this.loadAnnouncementTitleURL(true);
		this.loadUserTags();
	}
	
	public void loadUserTags() {

		this.ilstbusTags = new busUser().getUserTags(this.idoAnnouncement.announcementId, busConstant.PostTypeAnnouncement);
	}

	
	public void assignOwner(int aintLoggedInUser) {
		// TODO Auto-generated method stub
		if(this.idoAnnouncement.getCreatedBy() == aintLoggedInUser)
			this.isOwner = true;
	}
	
	public void loadComments() {
		busBaseDAOImpl<doComment> lBaseDAOImpl = new busBaseDAOImpl<doComment>();

		List<busParameter> llstbusParameters = new ArrayList<busParameter>();
		llstbusParameters.add(new busParameter(doComment.enmComment.subsystemValue.toString(),busConstant.PostTypeAnnouncement, 
				busConstant.DataTypeString));
		llstbusParameters.add(new busParameter(doComment.enmComment.subsystemReferenceId.toString(), String.valueOf(this.idoAnnouncement.getAnnouncementId()), 
				busConstant.DataTypeInteger));
		
		List<doComment> llstComments = lBaseDAOImpl.select(doComment.class, busConstant.doComment, llstbusParameters);

		this.ilstComments = new busComment().getCollection(llstComments);
		
		for (busComment lbusComment : this.ilstComments) {
			lbusComment.loadUser();
		}
	}
	
	public void loadAnnouncementTitleURL(boolean ablnLoadShortUrl) {

		this.istrAnnouncementTitleURL = busUtil.getTitleUrl(this.idoAnnouncement.getAnnouncementTitle());
				
		//String lstrLongUrl = busConstant.DomainName + "question/question/" + this.idoAnnouncement.getAnnouncementId() + "/" + this.istrAnnouncementTitleURL;
		//if(ablnLoadShortUrl)
		//	this.istrShortUrl = new busUtil().shortenUrl(lstrLongUrl);
	}
	
	public boolean validateInsertAnnouncement()
	{
		// TODO Auto-generated method stub
		isAnnouncementTitleEntered();
		isAnnouncementTitleLongerThan10Characters();
		isAnnouncementDescriptionLongerThan100Characters();
		isAnnouncementTitleDuplicate();

		if(this.ilstbusMessages.size() > 0)
			return false;
		else 
			return true;
	}
	
	private void isAnnouncementTitleEntered() {
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(this.idoAnnouncement.getAnnouncementTitle()))
			this.addMessage(busConstant.IsAnnouncementTitleEntered);
	}
	
	private void isAnnouncementTitleDuplicate() {
		// TODO Auto-generated method stub
		if(!StringUtils.isEmpty(this.idoAnnouncement.getAnnouncementTitle()))
		{
			busBaseDAOImpl<doAnnouncement> lBaseDAOImpl = new busBaseDAOImpl<doAnnouncement>();

			List<busParameter> llstbusParameters = new ArrayList<busParameter>();
			llstbusParameters.add(new busParameter(doAnnouncement.enmAnnouncement.announcementTitle.toString(), this.idoAnnouncement.getAnnouncementTitle(), busConstant.DataTypeString));

			List<doAnnouncement> llstdoAnnouncement = lBaseDAOImpl.select(doAnnouncement.class, busConstant.doAnnouncement, llstbusParameters);

			if (llstdoAnnouncement != null && llstdoAnnouncement.size() > 0)
				this.addMessage(busConstant.IsAnnouncementTitleDuplicate);
		}
	}

	private void isAnnouncementTitleLongerThan10Characters() {
		// TODO Auto-generated method stub
		if(!StringUtils.isEmpty(this.idoAnnouncement.getAnnouncementTitle()) 
				&& this.idoAnnouncement.getAnnouncementTitle().length() < busConstant.QuestionTitleLength)
			this.addMessage(busConstant.IsAnnouncementTitleLongerThan10Characters);		
	}
	
	private void isAnnouncementDescriptionLongerThan100Characters() {
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(this.idoAnnouncement.getAnnouncementHtml()) || this.idoAnnouncement.getAnnouncementHtml().length() < busConstant.AnnouncementDescriptionLength)
			this.addMessage(busConstant.IsAnnouncementDescriptionLongerThan30Characters);
	}

	


}
