package com.org.panthers.service;

import java.util.ArrayList;
import java.util.List;

import com.org.panthers.business.busConstant;
import com.org.panthers.business.busNotification;
import com.org.panthers.business.busPoint;
import com.org.panthers.business.busPostVote;
import com.org.panthers.business.busUser;
import com.org.panthers.entity.doComment;
import com.org.panthers.entity.doPostVote;
import com.org.panthers.entity.doQuestion;
import com.org.panthers.entity.doQuestionAnswer;
import com.org.panthers.framework.busBaseDAOImpl;
import com.org.panthers.framework.busDBFunctions;
import com.org.panthers.framework.busParameter;

public class VotesService {

	/** this method loads all PostVotes from PostVote table */
	public List<busPostVote> loadPostVotes() {

		busBaseDAOImpl<doPostVote> baseDAOImpl = new busBaseDAOImpl<doPostVote>();
		busPostVote lbusPostVote = new busPostVote();
		List<busPostVote> llstbusPostVote = lbusPostVote.getCollection(baseDAOImpl.getAll(doPostVote.class));
		return llstbusPostVote;
	}

	/**
	 * this method loads PostVote based it primary key passed from PostVote
	 * table
	 */
	public busPostVote loadPostVote(int id) {
		busPostVote lbusPostVote = new busPostVote();
		lbusPostVote.idoPostVote.setPostVoteId(id);
		lbusPostVote.idoPostVote = lbusPostVote.idoPostVote.get();
		return lbusPostVote;
	}

	/**
	 * this method loads PostVote based it primary key passed from PostVote
	 * table
	 */
	public int deletePostVote(int id) {
		busPostVote lbusPostVote = new busPostVote();
		lbusPostVote.idoPostVote.setPostVoteId(id);

		return lbusPostVote.idoPostVote.delete();
	}

	/**
	 * this method updates PostVote based it's object passed from front end
	 */
	public int updatePostVote(busPostVote abusPostVote) {		
		
		return abusPostVote.idoPostVote.update();
	}

	/**
	 * this method inserts PostVote based it's object passed from front end
	 */
	public int insertPostVote(busPostVote abusPostVote) {		
		
		try{
			
			busPoint lbusPoint;
			busUser lbusUser;
			busNotification lbusNotification;
			
			abusPostVote.idoPostVote.insert();
			//abusPostVote.addMessage(busConstant.SuccessVotes);
			
			if(abusPostVote.idoPostVote.getSubsystemValue().equals(busConstant.PostTypeQuestion) && abusPostVote.idoPostVote.getVoteValue().equals(busConstant.VoteTypeUp))
			{
				lbusUser = new busUser();
				int iintUserId = lbusUser.getUserIdByQuestionId(abusPostVote.idoPostVote.getSubsystemReferenceId());
								
				lbusPoint = new busPoint();
				lbusPoint.createPoint(abusPostVote.idoPostVote.getQuestionId(),iintUserId,abusPostVote.idoPostVote.iintUserId,busConstant.ActionTypeUpVoteQuestion,abusPostVote.idoPostVote.getQuestionId(),busConstant.PointTypeVote,5);
			
				lbusNotification = new busNotification();
				lbusNotification.createNotification(abusPostVote.idoPostVote.iintUserId, iintUserId, busConstant.ActionTypeUpVoteQuestion,abusPostVote.idoPostVote.getQuestionId(), 0, 0, busConstant.FlagN, busConstant.FlagN);
				
			}
			if(abusPostVote.idoPostVote.getSubsystemValue().equals(busConstant.PostTypeQuestion) && abusPostVote.idoPostVote.getVoteValue().equals(busConstant.VoteTypeDown))
			{
				lbusUser = new busUser();
				int iintUserId = lbusUser.getUserIdByQuestionId(abusPostVote.idoPostVote.getSubsystemReferenceId());
				
				lbusPoint = new busPoint();
				lbusPoint.createPoint(abusPostVote.idoPostVote.getQuestionId(), iintUserId, abusPostVote.idoPostVote.iintUserId, busConstant.ActionTypeDownVoteQuestion, abusPostVote.idoPostVote.getQuestionId(),busConstant.PointTypeVote,-3);
				
				lbusNotification = new busNotification();
				lbusNotification.createNotification(abusPostVote.idoPostVote.iintUserId, iintUserId, busConstant.ActionTypeDownVoteQuestion,abusPostVote.idoPostVote.getQuestionId(), 0, 0, busConstant.FlagN, busConstant.FlagN);
			}
			
			if(abusPostVote.idoPostVote.getSubsystemValue().equals(busConstant.PostTypeAnswer) && abusPostVote.idoPostVote.getVoteValue().equals(busConstant.VoteTypeUp))
			{
				lbusUser = new busUser();
				int iintUserId = lbusUser.getUserIdByQuestionAnswerId(abusPostVote.idoPostVote.getSubsystemReferenceId());
				
				lbusPoint = new busPoint();
				lbusPoint.createPoint(abusPostVote.idoPostVote.getQuestionId(), iintUserId, abusPostVote.idoPostVote.iintUserId, busConstant.ActionTypeUpVoteAnswer, abusPostVote.idoPostVote.getSubsystemReferenceId(),busConstant.PointTypeVote,5);
				
				lbusNotification = new busNotification();
				lbusNotification.createNotification(abusPostVote.idoPostVote.iintUserId, iintUserId, busConstant.ActionTypeUpVoteAnswer, abusPostVote.idoPostVote.getSubsystemReferenceId(), 0, 0, busConstant.FlagN, busConstant.FlagN);
			}
			
			if(abusPostVote.idoPostVote.getSubsystemValue().equals(busConstant.PostTypeAnswer) && abusPostVote.idoPostVote.getVoteValue().equals(busConstant.VoteTypeDown))
			{
				lbusUser = new busUser();
				int iintUserId = lbusUser.getUserIdByQuestionAnswerId(abusPostVote.idoPostVote.getSubsystemReferenceId());
				
				lbusPoint = new busPoint();
				lbusPoint.createPoint(abusPostVote.idoPostVote.getQuestionId(), iintUserId, abusPostVote.idoPostVote.iintUserId, busConstant.ActionTypeDownVoteAnswer, abusPostVote.idoPostVote.getSubsystemReferenceId(),busConstant.PointTypeVote,-3);
				
				lbusNotification = new busNotification();
				lbusNotification.createNotification(abusPostVote.idoPostVote.iintUserId, iintUserId, busConstant.ActionTypeDownVoteAnswer, abusPostVote.idoPostVote.getSubsystemReferenceId(), 0, 0, busConstant.FlagN, busConstant.FlagN);
			}
			
			if(abusPostVote.idoPostVote.getSubsystemValue().equals(busConstant.PostTypeComment) && abusPostVote.idoPostVote.getVoteValue().equals(busConstant.VoteTypeUp))
			{
				lbusUser = new busUser();
				int iintUserId = lbusUser.getUserIdByCommentId(abusPostVote.idoPostVote.getSubsystemReferenceId());
				
				lbusPoint = new busPoint();
				lbusPoint.createPoint(abusPostVote.idoPostVote.getQuestionId(),	iintUserId,abusPostVote.idoPostVote.iintUserId,busConstant.ActionTypeUpVoteComment,	abusPostVote.idoPostVote.getSubsystemReferenceId(),busConstant.PointTypeVote,2);
				
				lbusNotification = new busNotification();
				lbusNotification.createNotification(abusPostVote.idoPostVote.iintUserId, iintUserId, busConstant.ActionTypeUpVoteComment, abusPostVote.idoPostVote.getSubsystemReferenceId(), 0, 0, busConstant.FlagN, busConstant.FlagN);
			}
			
			return 1;
		} catch (Exception ex) {
			return 0;
		}	
	}
	
	private int getUpVoteCountForAnswer(int aintUserId, int aintQuestionAnswerId) {
		// TODO Auto-generated method stub
		busDBFunctions ldbFunctions = new busDBFunctions();
		
		// get thread id
		List<busParameter> llstbusParameters = new ArrayList<busParameter>();
		llstbusParameters.add(new busParameter(doPostVote.enmPostVote.userId.toString(), Integer.toString(aintUserId), busConstant.DataTypeInteger));
		llstbusParameters.add(new busParameter(doPostVote.enmPostVote.subsystemReferenceId.toString(), Integer.toString(aintQuestionAnswerId), busConstant.DataTypeInteger));
		
		return  ldbFunctions.DBExecuteScalar(busConstant.getUpVoteCountForAnswer, llstbusParameters, null);
	}

	private int getUpVoteCountForQuestion(int aintUserId, int aintQuestionId) {
		// TODO Auto-generated method stub
		busDBFunctions ldbFunctions = new busDBFunctions();
		
		// get thread id
		List<busParameter> llstbusParameters = new ArrayList<busParameter>();
		llstbusParameters.add(new busParameter(doPostVote.enmPostVote.userId.toString(), Integer.toString(aintUserId), busConstant.DataTypeInteger));
		llstbusParameters.add(new busParameter(doPostVote.enmPostVote.questionId.toString(), Integer.toString(aintQuestionId), busConstant.DataTypeInteger));
		
		return  ldbFunctions.DBExecuteScalar(busConstant.getUpVoteCountForQuestion, llstbusParameters, null);	
	}

	/**
	 * this method inserts PostVote based it's object passed from front end
	 */
	public busPostVote createPostVote(busPostVote abusPostVote) {
		
		if (abusPostVote.validate() == 0)
			return abusPostVote;
		else {
			insertPostVote(abusPostVote);
		}
		
		return abusPostVote;
	}

}
