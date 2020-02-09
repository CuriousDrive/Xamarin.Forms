package com.org.panthers.business;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;

import com.org.panthers.entity.doComment;
import com.org.panthers.entity.doUser;
import com.org.panthers.framework.busBase;
import com.org.panthers.framework.busBaseDAOImpl;
import com.org.panthers.framework.busParameter;

public class busComment extends busBase{

	public doComment idoComment;
	public busUser ibusUser;
	public busQuestion ibusQuestion;
	
	public int iintVoteCount;
	
	public busComment() {

		idoComment = new doComment();
	}

	public List<busComment> getCollection(List<doComment> alstComments) {

		List<busComment> llstbusComments = new ArrayList<busComment>();

		for (doComment lComment : alstComments) {

			busComment lbusComment = new busComment();
			lbusComment.idoComment = lComment;
			llstbusComments.add(lbusComment);

		}
		return llstbusComments;
	}

	public boolean validateInsertComment() {
		// TODO Auto-generated method stub
		isCommentEnterted();
		isUserLoggedIn();
		
		if(this.ilstbusMessages.size() > 0)
			return false;
		else 
			return true;
	}
	
	private void isUserLoggedIn() {
		// TODO Auto-generated method stub
		if(this.idoComment.iintUserId == 0)
			this.addMessage(busConstant.IsUserLoggedIn);
		
	}

	private void isCommentEnterted() {
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(this.idoComment.getCommentHtml()))
			this.addMessage(busConstant.IsCommentEntered);
	}
	
	public void loadUser() {
		busBaseDAOImpl<doUser> lBaseDAOImpl = new busBaseDAOImpl<doUser>();

		List<busParameter> llstbusParameters = new ArrayList<busParameter>();
		llstbusParameters.add(new busParameter(doUser.enmUser.userId.toString(),String.valueOf(this.idoComment.getCreatedBy()), 
				busConstant.DataTypeInteger));
		
		doUser ldoUser = lBaseDAOImpl.selectFirstOrDefault(doUser.class, busConstant.doUser, llstbusParameters);

		ibusUser = new busUser();
		ibusUser.idoUser = ldoUser;
		
		//loading user title URL value - 
		ibusUser.istrURLTitle = ibusUser.idoUser.getFirstName().toLowerCase() + "_" + ibusUser.idoUser.getLastName().toLowerCase();
		
	}
}
