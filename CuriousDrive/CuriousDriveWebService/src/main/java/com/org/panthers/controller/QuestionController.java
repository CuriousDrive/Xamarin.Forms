package com.org.panthers.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.org.panthers.business.busComment;
import com.org.panthers.business.busConstant;
import com.org.panthers.business.busQuestion;
import com.org.panthers.business.busQuestionAnswer;
import com.org.panthers.business.busQuestionAnswerHistory;
import com.org.panthers.business.busQuestionClass;
import com.org.panthers.business.busQuestionFavorite;
import com.org.panthers.business.busQuestionHistory;
import com.org.panthers.business.busQuestionValid;
import com.org.panthers.business.busQuestionView;
import com.org.panthers.business.busReportAbuse;
import com.org.panthers.framework.busBaseController;
import com.org.panthers.framework.busLink;
import com.org.panthers.framework.busMessage;
import com.org.panthers.framework.busUtil;
import com.org.panthers.service.QuestionService;

@Path(busLink.QUESTIONS)
public class QuestionController extends busBaseController {
	
	@Path("/questions")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getQuestions(@Context UriInfo info, @DefaultValue("false") @QueryParam("expand") boolean expand) {

		return Response.ok(new QuestionService().loadAllQuestions(), MediaType.APPLICATION_JSON)
						.header("Access-Control-Allow-Origin", "*")
						.build();
	}

	@Path("/questions/getQuestionsByThread")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getQuestionsByThread(@Context UriInfo info,
			@QueryParam("astrType") String astrType) {

		List<busQuestion> obj = new QuestionService().loadQuestionsByThread(astrType);
		return new busUtil().getResponse(obj);
	}
	
	@Path("/questions")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createQuestions(@Context UriInfo info, busQuestion abusQuestion) {

		if(new QuestionService().createQuestion(abusQuestion) > 1)
			abusQuestion.loadQuestionTitleURL(true);
		
		return new busUtil().getResponse(abusQuestion);
	}

	@Path("/getQuestionDetails")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getQuestionDetails(@Context UriInfo info, @QueryParam("aintQuestionId") int aintQuestionId,
			@QueryParam("aintLoggedInUserId") int aintLoggedInUserId) {
		
		return new busUtil().getResponse(new QuestionService().getQuestionDetails(aintQuestionId,aintLoggedInUserId));		
	}
	
	@Path("/getQuestion")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getQuestion(@Context UriInfo info, @QueryParam("aintQuestionId") int aintQuestionId) {

		busQuestion lbusQuestion =  new QuestionService().loadQuestion(aintQuestionId);
		lbusQuestion.loadQuestionTitleURL(true);
		return new busUtil().getResponse(lbusQuestion);
	}
	
	@POST
	@Path("/questions/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateQuestion(@Context UriInfo info, @PathParam("id") int id, busQuestion abusQuestion) {

		new QuestionService().updateQuestion(abusQuestion.idoQuestion);
		return new busUtil().getResponse(abusQuestion);

	}
	
	@Path("/questions/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteQuestion(@PathParam("id") int id) {

		new QuestionService().deleteQuestionNew(id);
		return new busUtil().getResponse(new busMessage(busConstant.DeleteMessage));
	}
	
	@Path("/questionAnswers")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getQuestionAnswers(@Context UriInfo info, @DefaultValue("false") @QueryParam("expand") boolean expand) {

		return new busUtil().getResponse(new QuestionService().loadQuestionAnswers());
	}

	@Path("/questionAnswers")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createQuestionAnswers(@Context UriInfo info, busQuestionAnswer abusQuestionAnswer) {

		new QuestionService().createQuestionAnswer(abusQuestionAnswer);
		return new busUtil().getResponse(abusQuestionAnswer);
	}

	@Path("/questionAnswers/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getQuestionAnswer(@Context UriInfo info, @PathParam("id") int id) {

		return new busUtil().getResponse(new QuestionService().loadQuestionAnswer(id));
	}
	
	@POST
	@Path("/questionAnswers/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateQuestionAnswer(@Context UriInfo info, @PathParam("id") int id, busQuestionAnswer abusQuestionAnswer) {

		new QuestionService().updateQuestionAnswer(abusQuestionAnswer.idoQuestionAnswer);
		return new busUtil().getResponse(abusQuestionAnswer);
	}
	
	@Path("/questionAnswers/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteQuestionAnswer(@PathParam("id") int id) {

		new QuestionService().deleteQuestionAnswerNew(id);
		return new busUtil().getResponse(new busMessage(busConstant.DeleteMessage));
	}
	
	@Path("/questionAnswerHistorys")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getQuestionAnswerHistorys(@Context UriInfo info, @DefaultValue("false") @QueryParam("expand") boolean expand) {

		return new busUtil().getResponse(new QuestionService().loadQuestionAnswerHistorys());
	}

	@Path("/questionAnswerHistory")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createQuestionAnswerHistorys(@Context UriInfo info, busQuestionAnswerHistory abusQuestionAnswerHistory) {

		new QuestionService().insertQuestionAnswerHistory(abusQuestionAnswerHistory);
		return new busUtil().getResponse(abusQuestionAnswerHistory);
	}

	@Path("/questionAnswerHistory/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getQuestionAnswerHistory(@Context UriInfo info, @PathParam("id") int id) {

		return new busUtil().getResponse(new QuestionService().loadQuestionAnswerHistory(id));
	}
	
	@POST
	@Path("/questionAnswerHistory/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateQuestionAnswerHistory(@Context UriInfo info, @PathParam("id") int id, busQuestionAnswerHistory abusQuestionAnswerHistory) {

		new QuestionService().updateQuestionAnswerHistory(abusQuestionAnswerHistory);
		return new busUtil().getResponse(new busMessage(busConstant.DeleteMessage));

	}
	
	@Path("/questionAnswerHistory/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteQuestionAnswerHistory(@PathParam("id") int id) {

		new QuestionService().deleteQuestionAnswerHistory(id);
		return new busUtil().getResponse(new busMessage(busConstant.DeleteMessage));
	}
	
	@Path("/questionFavorites")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getQuestionFavorites(@Context UriInfo info, @DefaultValue("false") @QueryParam("expand") boolean expand) {

		return new busUtil().getResponse(new QuestionService().loadQuestionFavorites());
	}

	@Path("/questionFavorites")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createQuestionFavorites(@Context UriInfo info, busQuestionFavorite abusQuestionFavorite) {

		new QuestionService().insertQuestionFavorite(abusQuestionFavorite);
		return new busUtil().getResponse(abusQuestionFavorite);
	}

	@Path("/questionFavorites/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getQuestionFavorite(@Context UriInfo info, @PathParam("id") int id) {
		
		return new busUtil().getResponse(new QuestionService().loadQuestionFavorite(id));
	}
	
	@POST
	@Path("/questionFavorites/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateQuestionFavorite(@Context UriInfo info, @PathParam("id") int id, busQuestionFavorite abusQuestionFavorite) {

		new QuestionService().updateQuestionFavorite(abusQuestionFavorite.idoQuestionFavorite);
		return new busUtil().getResponse(abusQuestionFavorite);

	}
	
	@Path("/questionFavorites/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteQuestionFavorite(@PathParam("id") int id) {

		new QuestionService().deleteQuestionFavorite(id);
		return new busUtil().getResponse(new busMessage(busConstant.DeleteMessage));
	}
	
	@Path("/questionHistorys")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getQuestionHistorys(@Context UriInfo info, @DefaultValue("false") @QueryParam("expand") boolean expand) {

		return new busUtil().getResponse(new QuestionService().loadQuestionHistorys());
	}

	@Path("/questionHistory")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createQuestionHistorys(@Context UriInfo info, busQuestionHistory abusQuestionHistory) {

		new QuestionService().insertQuestionHistory(abusQuestionHistory);
		return new busUtil().getResponse(abusQuestionHistory);
	}

	@Path("/questionHistory/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getQuestionHistory(@Context UriInfo info, @PathParam("id") int id) {

		return new busUtil().getResponse(new QuestionService().loadQuestionHistory(id));
	}
	
	@POST
	@Path("/questionHistory/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateQuestionHistory(@Context UriInfo info, @PathParam("id") int id, busQuestionHistory abusQuestionHistory) {

		new QuestionService().updateQuestionHistory(abusQuestionHistory);
		return new busUtil().getResponse(abusQuestionHistory);

	}
	
	@Path("/questionHistory/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteQuestionHistory(@PathParam("id") int id) {

		new QuestionService().deleteQuestionHistory(id);
		return new busUtil().getResponse(new busMessage(busConstant.DeleteMessage));
	}
	
	@Path("/questionValids")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getQuestionValids(@Context UriInfo info, @DefaultValue("false") @QueryParam("expand") boolean expand) {

		return new busUtil().getResponse(new QuestionService().loadQuestionValids());
	}

	@Path("/questionValids")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createQuestionValids(@Context UriInfo info, busQuestionValid abusQuestionValid) {

		new QuestionService().insertQuestionValid(abusQuestionValid);
		return new busUtil().getResponse(abusQuestionValid);
	}

	@Path("/questionValids/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getQuestionValid(@Context UriInfo info, @PathParam("id") int id) {

		return new busUtil().getResponse(new QuestionService().loadQuestionValid(id));
	}
	
	@POST
	@Path("/questionValids/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateQuestionValid(@Context UriInfo info, @PathParam("id") int id, busQuestionValid abusQuestionValid) {

		new QuestionService().updateQuestionValid(abusQuestionValid);
		return new busUtil().getResponse(abusQuestionValid);

	}
	
	@Path("/questionValids/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteQuestionValid(@PathParam("id") int id) {

		new QuestionService().deleteQuestionValid(id);
		return new busUtil().getResponse(new busMessage(busConstant.DeleteMessage));
	}
	
	@Path("/questionViews")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getQuestionViews(@Context UriInfo info, @DefaultValue("false") @QueryParam("expand") boolean expand) {

		return new busUtil().getResponse(new QuestionService().loadQuestionViews());
	}

	@Path("/questionViews")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createQuestionViews(@Context UriInfo info, busQuestionView abusQuestionView) {

		new QuestionService().insertQuestionView(abusQuestionView);
		return new busUtil().getResponse(abusQuestionView);
	}

	@Path("/questionViews/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getQuestionView(@Context UriInfo info, @PathParam("id") int id) {

		return new busUtil().getResponse(new QuestionService().loadQuestionView(id));
	}
	
	@POST
	@Path("/questionViews/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateQuestionView(@Context UriInfo info, @PathParam("id") int id, busQuestionView abusQuestionView) {

		new QuestionService().updateQuestionView(abusQuestionView);		
		return new busUtil().getResponse(abusQuestionView);

	}
	
	@Path("/questionViews/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteQuestionView(@PathParam("id") int id) {

		new QuestionService().deleteQuestionView(id);
		return Response.ok(new busMessage(busConstant.DeleteMessage), MediaType.APPLICATION_JSON).build();
	}
	
	@Path("/reportAbuses")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getReportAbuses(@Context UriInfo info, @DefaultValue("false") @QueryParam("expand") boolean expand) {

		return new busUtil().getResponse(new QuestionService().loadReportAbuses());
	}

	@Path("/reportAbuses")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createReportAbuses(@Context UriInfo info, busReportAbuse abusReportAbuse) {

		new QuestionService().insertReportAbuse(abusReportAbuse);
		return new busUtil().getResponse(abusReportAbuse);
	}

	@Path("/reportAbuses/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getReportAbuse(@Context UriInfo info, @PathParam("id") int id) {

		return new busUtil().getResponse(new QuestionService().loadReportAbuse(id));
	}
	
	@POST
	@Path("/reportAbuses/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateReportAbuse(@Context UriInfo info, @PathParam("id") int id, busReportAbuse abusReportAbuse) {

		new QuestionService().updateReportAbuse(abusReportAbuse);
		return new busUtil().getResponse(abusReportAbuse);

	}
	
	@Path("/reportAbuses/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteReportAbuse(@PathParam("id") int id) {

		new QuestionService().deleteReportAbuse(id);
		return new busUtil().getResponse(new busMessage(busConstant.DeleteMessage));
	}

	@Path("/questionClasss")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getquestionClasss(@Context UriInfo info, @DefaultValue("false") @QueryParam("expand") boolean expand) {

		return new busUtil().getResponse(new QuestionService().loadQuestionClasss());
	}
	
	@Path("/questionClasss")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createQuestionClasss(@Context UriInfo info, busQuestionClass abusQuestionClass) {

		new QuestionService().insertQuestionClass(abusQuestionClass);
		return new busUtil().getResponse(abusQuestionClass);
	}

	@Path("/questionClasss/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getQuestionClass(@Context UriInfo info, @PathParam("id") int id) {

		return new busUtil().getResponse(new QuestionService().loadQuestionClass(id));
	}
	
	@POST
	@Path("/questionClasss/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateQuestionClass(@Context UriInfo info, @PathParam("id") int id, busQuestionClass abusQuestionClass) {

		new QuestionService().updateQuestionClass(abusQuestionClass);
		return new busUtil().getResponse(abusQuestionClass);

	}

	@Path("/questionClasss/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteQuestionClass(@PathParam("id") int id) {

		new QuestionService().deleteQuestionClass(id);
		return new busUtil().getResponse(new busMessage(busConstant.DeleteMessage));
	}
	
	@Path("/comments")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getComments(@Context UriInfo info, @DefaultValue("false") @QueryParam("expand") boolean expand) {

		return new busUtil().getResponse(new QuestionService().loadComments());
	}
	
	@Path("/comments")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createComments(@Context UriInfo info, busComment abusComment) {

		new QuestionService().insertComment(abusComment);
		return new busUtil().getResponse(abusComment);
	}

	@Path("/comments/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getComment(@Context UriInfo info, @PathParam("id") int id) {

		return new busUtil().getResponse(new QuestionService().loadComment(id));
	}
		
	@POST
	@Path("/comments/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateComment(@Context UriInfo info, @PathParam("id") int id, busComment abusComment) {

		new QuestionService().updateComment(abusComment);
		return new busUtil().getResponse(abusComment);

	}

	@Path("/comments/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteComment(@PathParam("id") int id) {

		new QuestionService().deleteComment(id);
		return new busUtil().getResponse(new busMessage(busConstant.DeleteMessage));
	}
}
