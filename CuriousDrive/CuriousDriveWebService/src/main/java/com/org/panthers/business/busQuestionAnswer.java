package com.org.panthers.business;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import net.casper.data.model.CDataRowSet;

import com.org.panthers.entity.doComment;
import com.org.panthers.entity.doQuestion;
import com.org.panthers.entity.doQuestionAnswer;
import com.org.panthers.framework.busBase;
import com.org.panthers.framework.busBaseDAOImpl;
import com.org.panthers.framework.busDBFunctions;
import com.org.panthers.framework.busParameter;
import com.org.panthers.service.UserService;

public class busQuestionAnswer extends busBase{

	public doQuestionAnswer idoQuestionAnswer;
	public List<busComment> ilstComments;
	public busUser ibusUser;
	public busQuestion ibusQuestion;
	
	public String istrQuestionAnswerComment;
	public int iintVoteCount;
	public int iintUpVoteCount;
	public int iintDownVoteCount;

	public busQuestionAnswer() {
		idoQuestionAnswer = new doQuestionAnswer();
	}
	
	public List<busQuestionAnswer> getCollection(List<doQuestionAnswer> alstQuestionAnswers) {

		List<busQuestionAnswer> llstbusQuestionAnswers = new ArrayList<busQuestionAnswer>();

		for (doQuestionAnswer lQuestionAnswer : alstQuestionAnswers) {

			busQuestionAnswer lbusQuestionAnswer = new busQuestionAnswer();
			lbusQuestionAnswer.idoQuestionAnswer = lQuestionAnswer;
			llstbusQuestionAnswers.add(lbusQuestionAnswer);

		}
		return llstbusQuestionAnswers;
	}

	public void loadComments() {
		busBaseDAOImpl<doComment> lBaseDAOImpl = new busBaseDAOImpl<doComment>();

		List<busParameter> llstbusParameters = new ArrayList<busParameter>();
		llstbusParameters.add(new busParameter(doComment.enmComment.subsystemValue.toString(),busConstant.PostTypeAnswer, 
				busConstant.DataTypeString));
		llstbusParameters.add(new busParameter(doComment.enmComment.subsystemReferenceId.toString(), String.valueOf(this.idoQuestionAnswer.getQuestionAnswerId()), 
				busConstant.DataTypeInteger));

		List<doComment> llstComments = lBaseDAOImpl.select(doComment.class, busConstant.doComment, llstbusParameters);

		this.ilstComments = new busComment().getCollection(llstComments);
		
		for (busComment lbusComment : this.ilstComments) {
			lbusComment.loadUser();
		}
	}

	public void loadQuestionAnswerVotes() {

		String[] primaryKeys = { "TOTAL_VOTES" };

		// get question vote count 
		List<busParameter> llstbusParameters = new ArrayList<busParameter>();
		llstbusParameters.add(new busParameter(doQuestion.enmQuestion.questionId.toString(), String.valueOf(this.idoQuestionAnswer.getQuestionAnswerId()), busConstant.DataTypeInteger));

		CDataRowSet lCDataRowset = new busDBFunctions().DBExecute(busConstant.loadQuestionAnswerVotes, llstbusParameters, primaryKeys,busConstant.Select);

		try {
			while (lCDataRowset.next()) {
				this.iintVoteCount = Integer.valueOf(lCDataRowset.getString("TOTAL_VOTES"));
				this.iintUpVoteCount = Integer.valueOf(lCDataRowset.getString("UP_VOTE"));
				this.iintDownVoteCount = Integer.valueOf(lCDataRowset.getString("DOWN_VOTE"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void assignOwner(int aintLoggedInUserId) {
		// TODO Auto-generated method stub
		if(this.idoQuestionAnswer.getCreatedBy() == aintLoggedInUserId)
			this.isOwner = true;
		
	}
	
	public void loadUser() {
		ibusUser = new UserService().getUserProfile(this.idoQuestionAnswer.getCreatedBy(), 0);		
	}

	public boolean validateCreateQuestionAnswer() {
		// TODO Auto-generated method stub
		isUserLoggedIn();
		isQuestionAnswerLongerThan30Characters();
		
		if(this.ilstbusMessages.size() > 0)
			return false;
		else 
			return true;
	}

	private void isQuestionAnswerLongerThan30Characters() {
		// TODO Auto-generated method stub
		if((!StringUtils.isEmpty(this.idoQuestionAnswer.getAnswerHtml()) && 
				this.idoQuestionAnswer.getAnswerHtml().length() < busConstant.QuestionAnswerDescriptionLength)
				|| StringUtils.isEmpty(this.idoQuestionAnswer.getAnswerHtml()))
			this.addMessage(busConstant.IsQuestionAnswerLongerThan100Characters);
		
	}

	private void isUserLoggedIn() {
		// TODO Auto-generated method stub
		if(this.idoQuestionAnswer.iintUserId == 0)
			this.addMessage(busConstant.IsUserLoggedIn);
	}
	
	
}
