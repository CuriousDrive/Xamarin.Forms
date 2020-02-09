package com.org.panthers.business;

import java.util.ArrayList;
import java.util.List;

import net.casper.data.model.CDataRowSet;

import com.org.panthers.entity.doPostVote;
import com.org.panthers.entity.doQuestion;
import com.org.panthers.entity.doQuestionAnswer;
import com.org.panthers.framework.busBase;
import com.org.panthers.framework.busBaseDAOImpl;
import com.org.panthers.framework.busDBFunctions;
import com.org.panthers.framework.busParameter;

public class busPostVote extends busBase{

	public doPostVote idoPostVote;

	public busPostVote() {
		
		idoPostVote = new doPostVote();
	}
	
	public List<busPostVote> getCollection(List<doPostVote> alstPostVotes) {

		List<busPostVote> llstbusPostVotes = new ArrayList<busPostVote>();

		for (doPostVote lPostVote : alstPostVotes) {

			busPostVote lbusPostVote = new busPostVote();
			lbusPostVote.idoPostVote = lPostVote;
			llstbusPostVotes.add(lbusPostVote);

		}
		return llstbusPostVotes;
	}

	public int validate() {
		// TODO Auto-generated method stub
		isUserLoggedIn();
		isPostOwnerSameAsVoter();
		isVoteAlreadyPostedByUser();
		
		if(this.ilstbusMessages.size() > 0)
			return 0;
		else 
			return 1;
	}

	private void isPostOwnerSameAsVoter() {
		// TODO Auto-generated method stub
		
		if(this.idoPostVote.getSubsystemValue().equals(busConstant.PostTypeQuestion))
		{
			busBaseDAOImpl<doQuestion> lBaseDAOImpl = new busBaseDAOImpl<doQuestion>();

			List<busParameter> llstbusParameters = new ArrayList<busParameter>();
			llstbusParameters.add(new busParameter(doQuestion.enmQuestion.questionId.toString(), Integer.toString(this.idoPostVote.getSubsystemReferenceId()), busConstant.DataTypeInteger));
			llstbusParameters.add(new busParameter(doQuestion.enmQuestion.createdBy.toString(), Integer.toString(this.idoPostVote.iintUserId), busConstant.DataTypeInteger));

			List<doQuestion> llstdoQuestion = lBaseDAOImpl.select(doQuestion.class, busConstant.doQuestion, llstbusParameters);

			if (llstdoQuestion != null && llstdoQuestion.size() > 0)
				this.addMessage(busConstant.IsPostOwnerSameAsVoter);
		}
		if(this.idoPostVote.getSubsystemValue().equals(busConstant.PostTypeAnswer))
		{
			busBaseDAOImpl<doQuestionAnswer> lBaseDAOImpl = new busBaseDAOImpl<doQuestionAnswer>();

			List<busParameter> llstbusParameters = new ArrayList<busParameter>();
			llstbusParameters.add(new busParameter(doQuestionAnswer.enmQuestionAnswer.questionAnswerId.toString(), Integer.toString(this.idoPostVote.getSubsystemReferenceId()), busConstant.DataTypeInteger));
			llstbusParameters.add(new busParameter(doQuestionAnswer.enmQuestionAnswer.createdBy.toString(), Integer.toString(this.idoPostVote.iintUserId), busConstant.DataTypeInteger));

			List<doQuestionAnswer> llstdoQuestionAnswer = lBaseDAOImpl.select(doQuestionAnswer.class, busConstant.doQuestionAnswer, llstbusParameters);

			if (llstdoQuestionAnswer != null && llstdoQuestionAnswer.size() > 0)
				this.addMessage(busConstant.IsPostOwnerSameAsVoter);
		}
	}

	private void isUserLoggedIn() {
		// TODO Auto-generated method stub
		if(this.idoPostVote.iintUserId == 0)
			this.addMessage(busConstant.IsUserLoggedIn);
		
	}

	private void isVoteAlreadyPostedByUser() {
		// TODO Auto-generated method stub
		//delete opposite vote by the same user
		deleteOppositeVotes();
		
		//now check if the same vote is posted by 
		String[] primaryKeys = { "POST_VOTE_ID" };

		// delete votes by vote type
		List<busParameter> llstbusParameters = new ArrayList<busParameter>();
		
		llstbusParameters.add(new busParameter(doPostVote.enmPostVote.subsystemValue.toString(), this.idoPostVote.getSubsystemValue(), busConstant.DataTypeString));
		llstbusParameters.add(new busParameter(doPostVote.enmPostVote.voteValue.toString(), this.idoPostVote.getVoteValue(), busConstant.DataTypeString));
		llstbusParameters.add(new busParameter(doPostVote.enmPostVote.userId.toString(), String.valueOf(this.idoPostVote.getUserId()), busConstant.DataTypeInteger));
		llstbusParameters.add(new busParameter(doPostVote.enmPostVote.subsystemReferenceId.toString(), String.valueOf(this.idoPostVote.getSubsystemReferenceId()), busConstant.DataTypeInteger));
			
		CDataRowSet lCDataRowset = new busDBFunctions().DBExecute(busConstant.loadVoteByUser, llstbusParameters, primaryKeys, busConstant.Select);
		
		if(lCDataRowset.size() == 0)
			return;
		else
		{
			this.addMessage(busConstant.IsDuplicateVote);
		}
	}

	private void deleteOppositeVotes() {
		// TODO Auto-generated method stub
		
		String[] primaryKeys = { "POST_VOTE_ID" };

		// delete votes by vote type
		List<busParameter> llstbusParameters = new ArrayList<busParameter>();
		
		String lstrVoteValue = this.idoPostVote.getVoteValue();
		
		if(lstrVoteValue.equals(busConstant.VoteTypeDown))
		{
			llstbusParameters.add(new busParameter(doPostVote.enmPostVote.subsystemValue.toString(), this.idoPostVote.getSubsystemValue(), busConstant.DataTypeString));
			llstbusParameters.add(new busParameter(doPostVote.enmPostVote.voteValue.toString(), busConstant.VoteTypeUp, busConstant.DataTypeString));
			llstbusParameters.add(new busParameter(doPostVote.enmPostVote.userId.toString(), String.valueOf(this.idoPostVote.getUserId()), busConstant.DataTypeInteger));
			llstbusParameters.add(new busParameter(doPostVote.enmPostVote.subsystemReferenceId.toString(), String.valueOf(this.idoPostVote.getSubsystemReferenceId()), busConstant.DataTypeInteger));
			
			new busDBFunctions().DBExecute(busConstant.deleteVote, llstbusParameters, primaryKeys,busConstant.Delete);
		}
		if(lstrVoteValue.equals(busConstant.VoteTypeUp))
		{
			llstbusParameters.add(new busParameter(doPostVote.enmPostVote.subsystemValue.toString(), this.idoPostVote.getSubsystemValue(), busConstant.DataTypeString));
			llstbusParameters.add(new busParameter(doPostVote.enmPostVote.voteValue.toString(), busConstant.VoteTypeDown, busConstant.DataTypeString));
			llstbusParameters.add(new busParameter(doPostVote.enmPostVote.userId.toString(), String.valueOf(this.idoPostVote.getUserId()), busConstant.DataTypeInteger));
			llstbusParameters.add(new busParameter(doPostVote.enmPostVote.subsystemReferenceId.toString(), String.valueOf(this.idoPostVote.getSubsystemReferenceId()), busConstant.DataTypeInteger));
			
			new busDBFunctions().DBExecute(busConstant.deleteVote, llstbusParameters, primaryKeys,busConstant.Delete);
		}
	}
}