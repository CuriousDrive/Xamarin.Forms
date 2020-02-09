package com.org.panthers.service;

import java.util.ArrayList;
import java.util.List;
import net.casper.data.model.CDataRowSet;

import com.org.panthers.business.busComment;
import com.org.panthers.business.busConstant;
import com.org.panthers.business.busNotification;
import com.org.panthers.business.busPostVote;
import com.org.panthers.business.busQuestion;
import com.org.panthers.business.busQuestionAnswer;
import com.org.panthers.business.busQuestionAnswerHistory;
import com.org.panthers.business.busQuestionClass;
import com.org.panthers.business.busQuestionFavorite;
import com.org.panthers.business.busQuestionHistory;
import com.org.panthers.business.busQuestionValid;
import com.org.panthers.business.busQuestionView;
import com.org.panthers.business.busReportAbuse;
import com.org.panthers.business.busTag;
import com.org.panthers.business.busUser;
import com.org.panthers.business.busUserRole;
import com.org.panthers.entity.doComment;
import com.org.panthers.entity.doPostVote;
import com.org.panthers.entity.doQuestion;
import com.org.panthers.entity.doQuestionAnswer;
import com.org.panthers.entity.doQuestionAnswerHistory;
import com.org.panthers.entity.doQuestionClass;
import com.org.panthers.entity.doQuestionFavorite;
import com.org.panthers.entity.doQuestionHistory;
import com.org.panthers.entity.doQuestionValid;
import com.org.panthers.entity.doQuestionView;
import com.org.panthers.entity.doReportAbuse;
import com.org.panthers.framework.busBaseDAOImpl;
import com.org.panthers.framework.busDBFunctions;
import com.org.panthers.framework.busParameter;

public class QuestionService {

	/** this method loads all Questions from Question table */
	
	public List<busQuestion> loadQuestions() {

		busBaseDAOImpl<doQuestion> baseDAOImpl = new busBaseDAOImpl<doQuestion>();
		busQuestion lbusQuestion = new busQuestion();
		List<busQuestion> llstbusQuestion = lbusQuestion.getCollection(baseDAOImpl.getAll(doQuestion.class));

		for (busQuestion lbusQuestionLoad : llstbusQuestion) {

			lbusQuestionLoad.loadQuestionTitleURL(false);
		}

		return llstbusQuestion;
	}

	public List<busQuestion> loadAllQuestions() {
		busDBFunctions ldbFunctions = new busDBFunctions();
		String[] primaryKeys = { "QUESTION_ID" };
		CDataRowSet lCDataRowset = ldbFunctions.DBExecute(busConstant.loadAllQuestions, null, primaryKeys,busConstant.Select);
		List<busQuestion> llstbusQuestion = new ArrayList<busQuestion>();

		try {
			while (lCDataRowset.next()) {

				busQuestion lbusQuestion = new busQuestion();

				lbusQuestion.idoQuestion.setQuestionHtml(lCDataRowset.getString("QUESTION_HTML"));
				lbusQuestion.idoQuestion.setQuestionTitle(lCDataRowset.getString("QUESTION_TITLE"));
				lbusQuestion.idoQuestion.setQuestionId(lCDataRowset.getInt("QUESTION_ID"));

				lbusQuestion.iintAnswerCount = lCDataRowset.getInt("COUNT_OF_ANSWERS");
				lbusQuestion.iintViews = lCDataRowset.getInt("COUNT_OF_VIEWS");

				lbusQuestion.loadQuestionTitleURL(false);
				llstbusQuestion.add(lbusQuestion);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return llstbusQuestion;
	}

	public List<busQuestion> loadQuestionsByThread(String astrType) {
		
		busDBFunctions ldbFunctions = new busDBFunctions();
		
		CDataRowSet lCDataRowset = null;
		
		if(astrType.equals("Popular"))
			lCDataRowset = ldbFunctions.DBExecute(busConstant.loadAllQuestionsPopular, null, null,busConstant.Select);	
		else if(astrType.equals("Unanswered"))
			lCDataRowset = ldbFunctions.DBExecute(busConstant.loadAllQuestionsUnanswered, null, null,busConstant.Select);
		else
			lCDataRowset = ldbFunctions.DBExecute(busConstant.loadAllQuestionsRecent, null, null,busConstant.Select);
		
		List<busQuestion> llstbusQuestion = new ArrayList<busQuestion>();

		try {
			while (lCDataRowset.next()) {

				busQuestion lbusQuestion = new busQuestion();
				lbusQuestion.ibusUser = new busUser();
				lbusQuestion.ibusUser.ibusUserRole = new busUserRole();
				

				lbusQuestion.idoQuestion.setQuestionId(lCDataRowset.getInt("QUESTION_ID"));
				lbusQuestion.idoQuestion.setQuestionHtml(lCDataRowset.getString("QUESTION_HTML"));
				lbusQuestion.idoQuestion.setQuestionTitle(lCDataRowset.getString("QUESTION_TITLE"));
				lbusQuestion.idoQuestion.setCreatedDate(lCDataRowset.getDate("CREATED_DATE"));
				
				lbusQuestion.iintAnswerCount = lCDataRowset.getInt("COUNT_OF_ANSWERS");
				lbusQuestion.iintViews = lCDataRowset.getInt("COUNT_OF_VIEWS");
				
				lbusQuestion.ibusUser.idoUser.setUserId(lCDataRowset.getInt("USER_ID"));
				lbusQuestion.ibusUser.idoUser.setDisplayName(lCDataRowset.getString("DISPLAY_NAME"));
				lbusQuestion.ibusUser.idoUser.setPictureUrl(lCDataRowset.getString("PICTURE_URL"));
				lbusQuestion.ibusUser.idoUser.setFirstName(lCDataRowset.getString("FIRST_NAME"));
				lbusQuestion.ibusUser.idoUser.setLastName(lCDataRowset.getString("LAST_NAME"));
				lbusQuestion.ibusUser.idoUser.setNetworkValue(lCDataRowset.getString("NETWORK_VALUE"));
				
				lbusQuestion.ibusUser.iintTotalPoint = lCDataRowset.getInt("POINTS");
				lbusQuestion.ibusUser.ibusUserRole.istrUserGroup = lCDataRowset.getString("DESCRIPTION");
				
				lbusQuestion.loadQuestionTitleURL(false);
				lbusQuestion.ibusUser.istrURLTitle = lbusQuestion.ibusUser.idoUser.getFirstName().toLowerCase() + "_" + lbusQuestion.ibusUser.idoUser.getLastName().toLowerCase();
				
				lbusQuestion.loadQuestionClasses();
				
				llstbusQuestion.add(lbusQuestion);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return llstbusQuestion;
	}

	/** this method loads all Questions from Question table */
	public List<busQuestion> loadQuestionsByThread2(String astrThread) {

		busQuestion lbusQuestion = new busQuestion();
		List<busQuestion> llstbusQuestion = lbusQuestion.loadQuestionsByThread(astrThread);

		for (busQuestion lbusQuestionLoad : llstbusQuestion) {
			lbusQuestionLoad.loadQuestionTitleURL(false);
		}

		return llstbusQuestion;
	}

	/**
	 * this method loads Question based it primary key passed from Question
	 * table
	 */
	public busQuestion loadQuestion(int id) {
		busQuestion lbusQuestion = new busQuestion();
		lbusQuestion.idoQuestion.setQuestionId(id);
		lbusQuestion.idoQuestion = lbusQuestion.idoQuestion.get();
		return lbusQuestion;
	}

	/**
	 * this method loads Question based it primary key passed from Question
	 * table
	 */
	public busQuestion getQuestionDetails(int id,int aintLoggedInUserId) {
		busQuestion lbusQuestion = new busQuestion();
		lbusQuestion.idoQuestion.setQuestionId(id);
		lbusQuestion.loadDetails(aintLoggedInUserId);
		return lbusQuestion;
	}

	/**
	 * this method loads Question based it primary key passed from Question
	 * table
	 */
	public int deleteQuestion(int id) {
		busQuestion lbusQuestion = new busQuestion();
		lbusQuestion.idoQuestion.setQuestionId(id);

		return lbusQuestion.idoQuestion.delete();

	}
	
	/**
	* this method deletes Question based it primary key passed from Question
	 * table
	 */
	
	public int deleteQuestionNew(int id) {
		
		busDBFunctions ldbFunctions = new busDBFunctions();
		String[] primaryKeys = { "QUESTION_ID" };

		// get thread id
		List<busParameter> llstbusParameters = new ArrayList<busParameter>();
		llstbusParameters.add(new busParameter(doQuestion.enmQuestion.questionId.toString(), String.valueOf(id), busConstant.DataTypeInteger));
		
		ldbFunctions.DBExecute(busConstant.deleteQuestion, llstbusParameters, primaryKeys,busConstant.Delete);
		
		return 1;

	}

	/**
	 * this method updates Question based it's object passed from front end
	 */
	public int updateQuestion(doQuestion aQuestion) {
	
		busQuestion lbusQuestion = this.loadQuestion(aQuestion.getQuestionId());
		lbusQuestion.idoQuestion.setQuestionTitle(aQuestion.getQuestionTitle());
		lbusQuestion.idoQuestion.setQuestionHtml(aQuestion.getQuestionHtml());
		lbusQuestion.idoQuestion.iintUserId = aQuestion.iintUserId;
		return lbusQuestion.idoQuestion.update();
	}

	/**
	 * this method inserts Question based it's object passed from front end
	 */
	public int createQuestion(busQuestion abusQuestion) {	

		if(abusQuestion.validateCreateQuestion())
		{
			int lintQuestionId =  abusQuestion.idoQuestion.insert();
			abusQuestion.addMessage(busConstant.SuccessQuestion);
			
			if(abusQuestion.istrClassIds != "")
			{
				String[] arrClassIds = abusQuestion.istrClassIds.split(",");
				
				for (String classId : arrClassIds) {
					
					busQuestionClass lbusQuestionClass = new busQuestionClass();
					lbusQuestionClass.idoQuestionClass.setClassId(Integer.parseInt(classId));
					lbusQuestionClass.idoQuestionClass.setQuestionId(lintQuestionId);
					
					lbusQuestionClass.idoQuestionClass.insert();
				}
			}
			
			new busTag().insertUserTags(abusQuestion.istrUserTags, abusQuestion.idoQuestion.iintUserId, busConstant.PostTypeQuestion,abusQuestion.idoQuestion.questionId,busConstant.ActionTypeMentionInQuestion);
			
			return 1;
		}
		else
			return 0;
	}	

	/** this method loads all QuestionAnswers from QuestionAnswer table */
	public List<busQuestionAnswer> loadQuestionAnswers() {

		busBaseDAOImpl<doQuestionAnswer> baseDAOImpl = new busBaseDAOImpl<doQuestionAnswer>();
		busQuestionAnswer lbusQuestionAnswer = new busQuestionAnswer();
		List<busQuestionAnswer> llstbusQuestionAnswer = lbusQuestionAnswer.getCollection(baseDAOImpl.getAll(doQuestionAnswer.class));
		return llstbusQuestionAnswer;
	}

	/**
	 * this method loads QuestionAnswer based it primary key passed from
	 * QuestionAnswer table
	 */
	public busQuestionAnswer loadQuestionAnswer(int id) {
		busQuestionAnswer lbusQuestionAnswer = new busQuestionAnswer();
		lbusQuestionAnswer.idoQuestionAnswer.setQuestionAnswerId(id);
		lbusQuestionAnswer.idoQuestionAnswer = lbusQuestionAnswer.idoQuestionAnswer.get();
		return lbusQuestionAnswer;
	}

	/**
	 * this method loads QuestionAnswer based it primary key passed from
	 * QuestionAnswer table
	 */
	public int deleteQuestionAnswer(int id) {
		busQuestionAnswer lbusQuestionAnswer = new busQuestionAnswer();
		lbusQuestionAnswer.idoQuestionAnswer.setQuestionAnswerId(id);

		return lbusQuestionAnswer.idoQuestionAnswer.delete();

	}

	/**
	 * this method loads QuestionAnswer based it primary key passed from
	 * QuestionAnswer table
	 */
	public int deleteQuestionAnswerNew(int id) {
		
		busDBFunctions ldbFunctions = new busDBFunctions();
		String[] primaryKeys = { "QUESTION_ANSWER_ID" };

		// get thread id
		List<busParameter> llstbusParameters = new ArrayList<busParameter>();
		llstbusParameters.add(new busParameter(doQuestionAnswer.enmQuestionAnswer.questionAnswerId.toString(), String.valueOf(id), busConstant.DataTypeInteger));
		
		ldbFunctions.DBExecute(busConstant.deleteQuestionAnswers, llstbusParameters, primaryKeys,busConstant.Delete);
		
		return 1;

	}
	
	/**
	 * this method updates QuestionAnswer based it's object passed from front
	 * end
	 */
	public int updateQuestionAnswer(doQuestionAnswer aQuestionAnswer) {
		//get the object here!!
		busQuestionAnswer lbusQuestionAnswer = this.loadQuestionAnswer(aQuestionAnswer.getQuestionAnswerId());
		lbusQuestionAnswer.idoQuestionAnswer.setAnswerHtml(aQuestionAnswer.getAnswerHtml());
		lbusQuestionAnswer.idoQuestionAnswer.iintUserId = aQuestionAnswer.iintUserId;
		
		return lbusQuestionAnswer.idoQuestionAnswer.update();

	}

	/**
	 * this method inserts QuestionAnswer based it's object passed from front
	 * end
	 */
	public int createQuestionAnswer(busQuestionAnswer abusQuestionAnswer) {
		
		
		if(abusQuestionAnswer.validateCreateQuestionAnswer())
		{
			int lintAnswerId = abusQuestionAnswer.idoQuestionAnswer.insert();
			abusQuestionAnswer.addMessage(busConstant.SuccessAnswer);
			
			busNotification lbusNotification = new busNotification();
			int lintToUserId = new busUser().getUserIdByQuestionId(abusQuestionAnswer.idoQuestionAnswer.getQuestionId());
			
			if(lintToUserId != abusQuestionAnswer.idoQuestionAnswer.iintUserId)
			{
				lbusNotification.createNotification(abusQuestionAnswer.idoQuestionAnswer.iintUserId, lintToUserId, busConstant.ActionTypeAnswer
						,lintAnswerId, 0, 0, busConstant.FlagN, busConstant.FlagN);
			}
			
			return 1;
		}
		else
			return 0;
	}

	/**
	 * this method loads all QuestionAnswerHistorys from QuestionAnswerHistory
	 * table
	 */
	public List<busQuestionAnswerHistory> loadQuestionAnswerHistorys() {

		busBaseDAOImpl<doQuestionAnswerHistory> baseDAOImpl = new busBaseDAOImpl<doQuestionAnswerHistory>();
		busQuestionAnswerHistory lbusQuestionAnswerHistory = new busQuestionAnswerHistory();
		List<busQuestionAnswerHistory> llstbusQuestionAnswerHistory = lbusQuestionAnswerHistory.getCollection(baseDAOImpl.getAll(doQuestionAnswerHistory.class));
		return llstbusQuestionAnswerHistory;
	}

	/**
	 * this method loads QuestionAnswerHistory based it primary key passed from
	 * QuestionAnswerHistory table
	 */
	public busQuestionAnswerHistory loadQuestionAnswerHistory(int id) {
		busQuestionAnswerHistory lbusQuestionAnswerHistory = new busQuestionAnswerHistory();
		lbusQuestionAnswerHistory.idoQuestionAnswerHistory.setQuestionAnswerHistoryId(id);
		lbusQuestionAnswerHistory.idoQuestionAnswerHistory = lbusQuestionAnswerHistory.idoQuestionAnswerHistory.get();
		return lbusQuestionAnswerHistory;
	}

	/**
	 * this method loads QuestionAnswerHistory based it primary key passed from
	 * QuestionAnswerHistory table
	 */
	public int deleteQuestionAnswerHistory(int id) {
		busQuestionAnswerHistory lbusQuestionAnswerHistory = new busQuestionAnswerHistory();
		lbusQuestionAnswerHistory.idoQuestionAnswerHistory.setQuestionAnswerHistoryId(id);

		return lbusQuestionAnswerHistory.idoQuestionAnswerHistory.delete();

	}

	/**
	 * this method updates QuestionAnswerHistory based it's object passed from
	 * front end
	 */
	public int updateQuestionAnswerHistory(busQuestionAnswerHistory abusQuestionAnswerHistory) {

		return abusQuestionAnswerHistory.idoQuestionAnswerHistory.update();
	}

	/**
	 * this method inserts QuestionAnswerHistory based it's object passed from
	 * front end
	 */
	public int insertQuestionAnswerHistory(busQuestionAnswerHistory abusQuestionAnswerHistory) {
		
		return abusQuestionAnswerHistory.idoQuestionAnswerHistory.insert();
	}

	/** this method loads all QuestionFavorites from QuestionFavorite table */
	public List<busQuestionFavorite> loadQuestionFavorites() {

		busBaseDAOImpl<doQuestionFavorite> baseDAOImpl = new busBaseDAOImpl<doQuestionFavorite>();
		busQuestionFavorite lbusQuestionFavorite = new busQuestionFavorite();
		List<busQuestionFavorite> llstbusQuestionFavorite = lbusQuestionFavorite.getCollection(baseDAOImpl.getAll(doQuestionFavorite.class));
		return llstbusQuestionFavorite;
	}

	/**
	 * this method loads QuestionFavorite based it primary key passed from
	 * QuestionFavorite table
	 */
	public busQuestionFavorite loadQuestionFavorite(int id) {
		busQuestionFavorite lbusQuestionFavorite = new busQuestionFavorite();
		lbusQuestionFavorite.idoQuestionFavorite.setQuestionFavoriteId(id);
		lbusQuestionFavorite.idoQuestionFavorite = lbusQuestionFavorite.idoQuestionFavorite.get();
		return lbusQuestionFavorite;
	}

	/**
	 * this method loads QuestionFavorite based it primary key passed from
	 * QuestionFavorite table
	 */
	public int deleteQuestionFavorite(int id) {
		busQuestionFavorite lbusQuestionFavorite = new busQuestionFavorite();
		lbusQuestionFavorite.idoQuestionFavorite.setQuestionFavoriteId(id);

		return lbusQuestionFavorite.idoQuestionFavorite.delete();

	}

	/**
	 * this method updates QuestionFavorite based it's object passed from front
	 * end
	 */
	public int updateQuestionFavorite(doQuestionFavorite aQuestionFavorite) {
		busQuestionFavorite lbusQuestionFavorite = new busQuestionFavorite();
		lbusQuestionFavorite.idoQuestionFavorite = aQuestionFavorite;
		
		return lbusQuestionFavorite.idoQuestionFavorite.update();

	}

	/**
	 * this method inserts QuestionFavorite based it's object passed from front
	 * end
	 */
	public int insertQuestionFavorite(busQuestionFavorite abusQuestionFavorite) {
		
		return abusQuestionFavorite.idoQuestionFavorite.insert();
	}

	/** this method loads all QuestionHistorys from QuestionHistory table */
	public List<busQuestionHistory> loadQuestionHistorys() {

		busBaseDAOImpl<doQuestionHistory> baseDAOImpl = new busBaseDAOImpl<doQuestionHistory>();
		busQuestionHistory lbusQuestionHistory = new busQuestionHistory();
		List<busQuestionHistory> llstbusQuestionHistory = lbusQuestionHistory.getCollection(baseDAOImpl.getAll(doQuestionHistory.class));
		return llstbusQuestionHistory;
	}

	/**
	 * this method loads QuestionHistory based it primary key passed from
	 * QuestionHistory table
	 */
	public busQuestionHistory loadQuestionHistory(int id) {
		busQuestionHistory lbusQuestionHistory = new busQuestionHistory();
		lbusQuestionHistory.idoQuestionHistory.setQuestionHistoryId(id);
		lbusQuestionHistory.idoQuestionHistory = lbusQuestionHistory.idoQuestionHistory.get();
		
		return lbusQuestionHistory;
	}

	/**
	 * this method loads QuestionHistory based it primary key passed from
	 * QuestionHistory table
	 */
	public int deleteQuestionHistory(int id) {
		busQuestionHistory lbusQuestionHistory = new busQuestionHistory();
		lbusQuestionHistory.idoQuestionHistory.setQuestionHistoryId(id);

		return lbusQuestionHistory.idoQuestionHistory.delete();

	}

	/**
	 * this method updates QuestionHistory based it's object passed from front
	 * end
	 */
	public int updateQuestionHistory(busQuestionHistory abusQuestionHistory) {
		
		return abusQuestionHistory.idoQuestionHistory.update();
	}

	/**
	 * this method inserts QuestionHistory based it's object passed from front
	 * end
	 */
	public int insertQuestionHistory(busQuestionHistory abusQuestionHistory) {
		
		return abusQuestionHistory.idoQuestionHistory.insert();
	}

	/** this method loads all QuestionValids from QuestionValid table */
	public List<busQuestionValid> loadQuestionValids() {

		busBaseDAOImpl<doQuestionValid> baseDAOImpl = new busBaseDAOImpl<doQuestionValid>();
		busQuestionValid lbusQuestionValid = new busQuestionValid();
		List<busQuestionValid> llstbusQuestionValid = lbusQuestionValid.getCollection(baseDAOImpl.getAll(doQuestionValid.class));
		return llstbusQuestionValid;
	}

	/**
	 * this method loads QuestionValid based it primary key passed from
	 * QuestionValid table
	 */
	public busQuestionValid loadQuestionValid(int id) {
		busQuestionValid lbusQuestionValid = new busQuestionValid();
		lbusQuestionValid.idoQuestionValid.setQuestionValidId(id);
		lbusQuestionValid.idoQuestionValid = lbusQuestionValid.idoQuestionValid.get();
		return lbusQuestionValid;
	}

	/**
	 * this method loads QuestionValid based it primary key passed from
	 * QuestionValid table
	 */
	public int deleteQuestionValid(int id) {
		busQuestionValid lbusQuestionValid = new busQuestionValid();
		lbusQuestionValid.idoQuestionValid.setQuestionValidId(id);

		return lbusQuestionValid.idoQuestionValid.delete();

	}

	/**
	 * this method updates QuestionValid based it's object passed from front end
	 */
	public int updateQuestionValid(busQuestionValid abusQuestionValid) {
		
		return abusQuestionValid.idoQuestionValid.update();
	}

	/**
	 * this method inserts QuestionValid based it's object passed from front end
	 */
	public int insertQuestionValid(busQuestionValid abusQuestionValid) {
		
		return abusQuestionValid.idoQuestionValid.insert();
	}

	/** this method loads all QuestionViews from QuestionView table */
	public List<busQuestionView> loadQuestionViews() {

		busBaseDAOImpl<doQuestionView> baseDAOImpl = new busBaseDAOImpl<doQuestionView>();
		busQuestionView lbusQuestionView = new busQuestionView();
		List<busQuestionView> llstbusQuestionView = lbusQuestionView.getCollection(baseDAOImpl.getAll(doQuestionView.class));
		return llstbusQuestionView;
	}

	/**
	 * this method loads QuestionView based it primary key passed from
	 * QuestionView table
	 */
	public busQuestionView loadQuestionView(int id) {
		busQuestionView lbusQuestionView = new busQuestionView();
		lbusQuestionView.idoQuestionView.setQuestionViewId(id);
		lbusQuestionView.idoQuestionView = lbusQuestionView.idoQuestionView.get();
		return lbusQuestionView;
	}

	/**
	 * this method loads QuestionView based it primary key passed from
	 * QuestionView table
	 */
	public int deleteQuestionView(int id) {
		busQuestionView lbusQuestionView = new busQuestionView();
		lbusQuestionView.idoQuestionView.setQuestionViewId(id);

		return lbusQuestionView.idoQuestionView.delete();

	}

	/**
	 * this method updates QuestionView based it's object passed from front end
	 */
	public int updateQuestionView(busQuestionView abusQuestionView) {
		
		return abusQuestionView.idoQuestionView.update();
	}

	/**
	 * this method inserts QuestionView based it's object passed from front end
	 */
	public int insertQuestionView(busQuestionView abusQuestionView) {
		
		if(!abusQuestionView.isQuestionViewDuplicate())
			return abusQuestionView.idoQuestionView.insert();
		else
			return 0;

	}

	/** this method loads all ReportAbuses from ReportAbuse table */
	public List<busReportAbuse> loadReportAbuses() {

		busBaseDAOImpl<doReportAbuse> baseDAOImpl = new busBaseDAOImpl<doReportAbuse>();
		busReportAbuse lbusReportAbuse = new busReportAbuse();
		List<busReportAbuse> llstbusReportAbuse = lbusReportAbuse.getCollection(baseDAOImpl.getAll(doReportAbuse.class));
		return llstbusReportAbuse;
	}

	/**
	 * this method loads ReportAbuse based it primary key passed from
	 * ReportAbuse table
	 */
	public busReportAbuse loadReportAbuse(int id) {
		busReportAbuse lbusReportAbuse = new busReportAbuse();
		lbusReportAbuse.idoReportAbuse.setReportAbuseId(id);
		lbusReportAbuse.idoReportAbuse = lbusReportAbuse.idoReportAbuse.get();
		return lbusReportAbuse;
	}

	/**
	 * this method loads ReportAbuse based it primary key passed from
	 * ReportAbuse table
	 */
	public int deleteReportAbuse(int id) {
		busReportAbuse lbusReportAbuse = new busReportAbuse();
		lbusReportAbuse.idoReportAbuse.setReportAbuseId(id);

		return lbusReportAbuse.idoReportAbuse.delete();

	}

	/**
	 * this method updates ReportAbuse based it's object passed from front end
	 */
	public int updateReportAbuse(busReportAbuse abusReportAbuse) {

		return abusReportAbuse.idoReportAbuse.update();
	}

	/**
	 * this method inserts ReportAbuse based it's object passed from front end
	 */
	public int insertReportAbuse(busReportAbuse abusReportAbuse) {
		
		return abusReportAbuse.idoReportAbuse.insert();
	}

	/** this method loads all Comments from Comment table */
	public List<busComment> loadComments() {

		busBaseDAOImpl<doComment> baseDAOImpl = new busBaseDAOImpl<doComment>();
		busComment lbusComment = new busComment();
		List<busComment> llstbusComment = lbusComment.getCollection(baseDAOImpl.getAll(doComment.class));
		return llstbusComment;
	}

	/**
	 * this method loads Comment based it primary key passed from Comment table
	 */
	public busComment loadComment(int id) {
		busComment lbusComment = new busComment();
		lbusComment.idoComment.setCommentId(id);
		lbusComment.idoComment = lbusComment.idoComment.get();
		return lbusComment;
	}

	/**
	 * this method loads Comment based it primary key passed from Comment table
	 */
	public int deleteComment(int id) {
		busComment lbusComment = new busComment();
		lbusComment.idoComment.setCommentId(id);

		return lbusComment.idoComment.delete();

	}

	/**
	 * this method updates Comment based it's object passed from front end
	 */
	public int updateComment(busComment abusComment) {
		
		return abusComment.idoComment.update();
	}

	/**
	 * this method inserts Comment based it's object passed from front end
	 */
	public int insertComment(busComment abusComment) {
		if(abusComment.validateInsertComment())
		{
			int lintCommentId = abusComment.idoComment.insert();
			abusComment.addMessage(busConstant.SuccessComments);
			
			//add notification 
			busNotification lbusNotification;
			
			if(abusComment.idoComment.subsystemValue.equals(busConstant.PostTypeQuestion))
			{
				lbusNotification = new busNotification();
				int lintToUserId = new busUser().getUserIdByQuestionId(abusComment.idoComment.getSubsystemReferenceId());
				
				if(lintToUserId != abusComment.idoComment.getUserId())
				{
					lbusNotification.createNotification(abusComment.idoComment.getUserId(), lintToUserId, busConstant.ActionTypeCommentOnQuestion
							,lintCommentId, 0, 0, busConstant.FlagN, busConstant.FlagN);	
				}
					
			}
			
			if(abusComment.idoComment.subsystemValue.equals(busConstant.PostTypeAnswer))
			{
				lbusNotification = new busNotification();
				int lintToUserId = new busUser().getUserIdByQuestionAnswerId(abusComment.idoComment.getSubsystemReferenceId());
				
				if(lintToUserId != abusComment.idoComment.getUserId())
				{
					lbusNotification.createNotification(abusComment.idoComment.getUserId(), lintToUserId, busConstant.ActionTypeCommentOnAnswer
							,lintCommentId, 0, 0, busConstant.FlagN, busConstant.FlagN);
				}
			}
			
			return 1;
		}
		else
			return 0;

	}

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

		return abusPostVote.idoPostVote.insert();
	}

	/** this method loads all QuestionClasss from QuestionClass table */
	public List<busQuestionClass> loadQuestionClasss() {

		busBaseDAOImpl<doQuestionClass> baseDAOImpl = new busBaseDAOImpl<doQuestionClass>();
		busQuestionClass lbusQuestionClass = new busQuestionClass();
		List<busQuestionClass> llstBusEmploeyees = lbusQuestionClass.getCollection(baseDAOImpl.getAll(doQuestionClass.class));
		return llstBusEmploeyees;
	}

	/**
	 * this method loads QuestionClass based it primary key passed from
	 * QuestionClass table
	 */
	public busQuestionClass loadQuestionClass(int id) {
		busQuestionClass lbusQuestionClass = new busQuestionClass();
		lbusQuestionClass.idoQuestionClass.setQuestionClassId(id);
		
		lbusQuestionClass.idoQuestionClass = lbusQuestionClass.idoQuestionClass.get();
		return lbusQuestionClass;
	}

	/**
	 * this method loads QuestionClass based it primary key passed from
	 * QuestionClass table
	 */
	public int deleteQuestionClass(int id) {
		busQuestionClass lbusQuestionClass = new busQuestionClass();
		lbusQuestionClass.idoQuestionClass.setQuestionClassId(id);

		return lbusQuestionClass.idoQuestionClass.delete();
	}

	/**
	 * this method updates QuestionClass based it's object passed from front
	 * end
	 */
	public int updateQuestionClass(busQuestionClass abusQuestionClass) {
		
		return abusQuestionClass.idoQuestionClass.update();
	}

	/**
	 * this method inserts QuestionClass based it's object passed from front
	 * end
	 */
	public int insertQuestionClass(busQuestionClass abusQuestionClass) {

		return abusQuestionClass.idoQuestionClass.insert();
	}

}
