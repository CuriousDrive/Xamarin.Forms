package com.org.panthers.business;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import net.casper.data.model.CDataRowSet;

import com.org.panthers.entity.doComment;
import com.org.panthers.entity.doQuestion;
import com.org.panthers.entity.doQuestionAnswer;
import com.org.panthers.entity.doQuestionClass;
import com.org.panthers.entity.doQuestionView;
import com.org.panthers.entity.doThread;
import com.org.panthers.framework.busBase;
import com.org.panthers.framework.busBaseDAOImpl;
import com.org.panthers.framework.busDBFunctions;
import com.org.panthers.framework.busParameter;
import com.org.panthers.framework.busUtil;
import com.org.panthers.service.UserService;

public class busQuestion extends busBase {

	public doQuestion idoQuestion;
	public busUser ibusUser;
	public List<busQuestionAnswer> ilstQuestionAnswer;
	public List<busComment> ilstComments;
	public List<busQuestionClass> ilstQuestionClasses;
	public List<busTag> ilstbusTags;
	
	public int iintViews;
	public int iintVoteCount;
	public int iintUpVoteCount;
	public int iintDownVoteCount;
	public int iintAnswerCount;
	
	public String istrQuestionClasses;
	public String istrDropdownClass;
	public String istrShortUrl;
	public String istrClassIds;
	public String istrUserTags;
	public String istrQuestionTitleURL;
	
	
	public String istrQuestionComment;

	public busQuestion() {

		idoQuestion = new doQuestion();
	}

	public List<busQuestion> getCollection(List<doQuestion> alstQuestions) {

		List<busQuestion> llstbusQuestions = new ArrayList<busQuestion>();

		for (doQuestion lQuestion : alstQuestions) {

			busQuestion lbusQuestion = new busQuestion();
			lbusQuestion.idoQuestion = lQuestion;
			llstbusQuestions.add(lbusQuestion);

		}
		return llstbusQuestions;
	}

	public void loadDetails(int aintLoggedInUser) {
		
		this.idoQuestion = this.idoQuestion.get();
		this.loadUser();
		this.assignOwner(aintLoggedInUser);
		this.loadQuestionVotes();
		this.loadQuestionClasses();
		this.loadQuestionAnswers();
		this.loadComments();
		this.loadQuestionTitleURL(true);
		this.loadQuestionAnswerDetails(aintLoggedInUser);
		this.loadQuestionViews();
		this.loadUserTags();
	}

	public void assignOwner(int aintLoggedInUser) {
		// TODO Auto-generated method stub
		if(this.idoQuestion.getCreatedBy() == aintLoggedInUser)
			this.isOwner = true;
	}
	
	public void loadUserTags() {

		this.ilstbusTags = new busUser().getUserTags(this.idoQuestion.questionId, busConstant.PostTypeQuestion);
	}


	public void loadQuestionAnswers() {

		List<busParameter> llstbusParameters = new ArrayList<busParameter>();
		
		llstbusParameters.add(new busParameter(doQuestionAnswer.enmQuestionAnswer.questionId.toString(), String.valueOf(this.idoQuestion.getQuestionId()), busConstant.DataTypeInteger));
		List<doQuestionAnswer> llstQuestionAnswer = new busBaseDAOImpl<doQuestionAnswer>().select(doQuestionAnswer.class, busConstant.doQuestionAnswer, llstbusParameters);

		this.ilstQuestionAnswer = new busQuestionAnswer().getCollection(llstQuestionAnswer);
		
		//replace line breaks with break lines - as its not detected in div tag 
		for (busQuestionAnswer lbusQuestionAnswer : ilstQuestionAnswer) {
			
			lbusQuestionAnswer.loadUser();
		}
	}

	public void loadQuestionViews() {

		List<busParameter> llstbusParameters = new ArrayList<busParameter>();
		
		llstbusParameters.add(new busParameter(doQuestionAnswer.enmQuestionAnswer.questionId.toString(), String.valueOf(this.idoQuestion.getQuestionId()), busConstant.DataTypeInteger));
		List<doQuestionView> llstQuestionViews = new busBaseDAOImpl<doQuestionView>().select(doQuestionView.class, busConstant.doQuestionView, llstbusParameters);

		this.iintViews = new busQuestionView().getCollection(llstQuestionViews).size();
	}

	
	public void loadQuestionAnswerDetails(int aintLoggedInUserId)
	{
		for (busQuestionAnswer lbusQuestionAnswer : this.ilstQuestionAnswer) {
			
			lbusQuestionAnswer.loadComments();
			lbusQuestionAnswer.loadQuestionAnswerVotes();
			lbusQuestionAnswer.assignOwner(aintLoggedInUserId);
		}
	}
	
	public void loadComments() {
		busBaseDAOImpl<doComment> lBaseDAOImpl = new busBaseDAOImpl<doComment>();

		List<busParameter> llstbusParameters = new ArrayList<busParameter>();
		llstbusParameters.add(new busParameter(doComment.enmComment.subsystemValue.toString(),busConstant.PostTypeQuestion, 
				busConstant.DataTypeString));
		llstbusParameters.add(new busParameter(doComment.enmComment.subsystemReferenceId.toString(), String.valueOf(this.idoQuestion.getQuestionId()), 
				busConstant.DataTypeInteger));
		
		List<doComment> llstComments = lBaseDAOImpl.select(doComment.class, busConstant.doComment, llstbusParameters);

		this.ilstComments = new busComment().getCollection(llstComments);
		
		for (busComment lbusComment : this.ilstComments) {
			lbusComment.loadUser();
		}
	}

	public List<busQuestion> loadQuestionsByThread(String astrThread) {

		busBaseDAOImpl<doQuestion> lBaseDAOImplQuestion = new busBaseDAOImpl<doQuestion>();
		busBaseDAOImpl<doThread> lBaseDAOImplThread = new busBaseDAOImpl<doThread>();

		// get thread id
		List<busParameter> llstbusParameters = new ArrayList<busParameter>();
		llstbusParameters.add(new busParameter(doThread.enmThread.thread.toString(), astrThread, busConstant.DataTypeString));
		doThread ldoThread = lBaseDAOImplThread.selectFirstOrDefault(doThread.class, busConstant.doThread, llstbusParameters);

		// get questions base on thread id pulled
		llstbusParameters = new ArrayList<busParameter>();
		llstbusParameters.add(new busParameter(doQuestion.enmQuestion.threadId.toString(), String.valueOf(ldoThread.getThreadId()), busConstant.DataTypeInteger));
		List<doQuestion> llstQuestion = lBaseDAOImplQuestion.select(doQuestion.class, busConstant.doQuestion, llstbusParameters);

		return this.getCollection(llstQuestion);
	}

	public void loadQuestionTitleURL(boolean ablnLoadShortUrl) {

		this.istrQuestionTitleURL = busUtil.getTitleUrl(this.idoQuestion.getQuestionTitle());		
		
		//String lstrLongUrl = busConstant.DomainName + "question/question/" + this.idoQuestion.getQuestionId() + "/" + this.istrQuestionTitleURL;		
		//if(ablnLoadShortUrl)
		//	this.istrShortUrl = new busUtil().shortenUrl(lstrLongUrl);
	}
	
	public void loadQuestionVotes() {

		String[] primaryKeys = { "TOTAL_VOTES" };

		// get question vote count 
		List<busParameter> llstbusParameters = new ArrayList<busParameter>();
		llstbusParameters.add(new busParameter(doQuestion.enmQuestion.questionId.toString(), String.valueOf(this.idoQuestion.getQuestionId()), busConstant.DataTypeInteger));

		CDataRowSet lCDataRowset = new busDBFunctions().DBExecute(busConstant.loadQuestionVotes, llstbusParameters, primaryKeys,busConstant.Select);

		try {
			while (lCDataRowset.next()) {
				this.iintVoteCount = Integer.valueOf(lCDataRowset.getString("TOTAL_VOTES"));
				this.iintUpVoteCount = Integer.valueOf(lCDataRowset.getString("UP_VOTES"));
				this.iintDownVoteCount = Integer.valueOf(lCDataRowset.getString("DOWN_VOTES"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void loadQuestionClasses() {
		busBaseDAOImpl<doQuestionClass> lBaseDAOImpl = new busBaseDAOImpl<doQuestionClass>();

		List<busParameter> llstbusParameters = new ArrayList<busParameter>();
		llstbusParameters.add(new busParameter(doQuestionClass.enmQuestionClass.questionId.toString(),String.valueOf(this.idoQuestion.getQuestionId()), 
				busConstant.DataTypeInteger));
		
		List<doQuestionClass> llstQuestionClass = lBaseDAOImpl.select(doQuestionClass.class, busConstant.doQuestionClass, llstbusParameters);

		this.ilstQuestionClasses = new busQuestionClass().getCollection(llstQuestionClass);
		this.istrQuestionClasses = "";
		
		for (int i =0; i < this.ilstQuestionClasses.size(); i++) {
			
			busQuestionClass lbusQuestionClass = this.ilstQuestionClasses.get(i);
			lbusQuestionClass.loadClassName();
			
			if(i == this.ilstQuestionClasses.size() - 1)
				this.istrQuestionClasses = this.istrQuestionClasses + lbusQuestionClass.istrClassName;
			else
				this.istrQuestionClasses = this.istrQuestionClasses + lbusQuestionClass.istrClassName + ",";
		}
	}

	public void loadUser() {
		ibusUser = new UserService().getUserProfile(this.idoQuestion.getCreatedBy(), 0);		
	}

	public boolean validateCreateQuestion() {
		// TODO Auto-generated method stub
		isQuestionTitleEntered();
		isQuestionDescriptionLongerThan30Characters();
		isQuestionTitleLongerThan10Characters();
		isQuestionTitleDuplicate();
		isUserLoggedIn();
		
		if(this.ilstbusMessages.size() > 0)
			return false;
		else 
			return true;
	}

	private void isUserLoggedIn() {
		// TODO Auto-generated method stub
		if(this.idoQuestion.iintUserId == 0)
			this.addMessage(busConstant.IsUserLoggedIn);
		
	}
	
	private void isQuestionTitleDuplicate() {
		// TODO Auto-generated method stub
		if(!StringUtils.isEmpty(this.idoQuestion.getQuestionTitle()))
		{
			busBaseDAOImpl<doQuestion> lBaseDAOImpl = new busBaseDAOImpl<doQuestion>();

			List<busParameter> llstbusParameters = new ArrayList<busParameter>();
			llstbusParameters.add(new busParameter(doQuestion.enmQuestion.questionTitle.toString(), this.idoQuestion.getQuestionTitle(), busConstant.DataTypeString));

			List<doQuestion> llstdoQuestion = lBaseDAOImpl.select(doQuestion.class, busConstant.doQuestion, llstbusParameters);

			if (llstdoQuestion != null && llstdoQuestion.size() > 0)
				this.addMessage(busConstant.IsQuestionTitleDuplicate);
		}
	}

	private void isQuestionTitleLongerThan10Characters() {
		// TODO Auto-generated method stub
		if(!StringUtils.isEmpty(this.idoQuestion.getQuestionTitle()) 
				&& this.idoQuestion.getQuestionTitle().length() < busConstant.QuestionTitleLength)
			this.addMessage(busConstant.IsQuestionTitleLongerThan10Characters);		
	}

	private void isQuestionDescriptionLongerThan30Characters() {
		// TODO Auto-generated method stub
		if(StringUtils.length(this.idoQuestion.getQuestionHtml())  < busConstant.QuestionDescriptionLength)
			this.addMessage(busConstant.IsQuestionDescriptionLongerThan100Characters);
	}

	private void isQuestionTitleEntered() {
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(this.idoQuestion.getQuestionTitle()))
			this.addMessage(busConstant.IsQuestionTitleEntered);
	}
}
