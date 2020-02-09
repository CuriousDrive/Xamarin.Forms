package com.org.panthers.controller;

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

import com.org.panthers.business.busConstant;
import com.org.panthers.business.busPostVote;
import com.org.panthers.framework.busLink;
import com.org.panthers.framework.busMessage;
import com.org.panthers.framework.busUtil;
import com.org.panthers.service.VotesService;

@Path(busLink.VOTES)
public class VotesController {
	
	@Path("/postVotes")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPostVotes(@Context UriInfo info, @DefaultValue("false") @QueryParam("expand") boolean expand) {

		return new busUtil().getResponse(new VotesService().loadPostVotes());
	}

	@Path("/postVotes")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createPostVotes(@Context UriInfo info, busPostVote abusPostVote) {
		
		busPostVote lreturnedbusPostVote = new VotesService().createPostVote(abusPostVote);
		return new busUtil().getResponse(lreturnedbusPostVote);
	}

	@Path("/postVotes/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPostVote(@Context UriInfo info, @PathParam("id") int id) {

		return new busUtil().getResponse(new VotesService().loadPostVote(id));
	}
	
	@POST
	@Path("/postVotes/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updatePostVote(@Context UriInfo info, @PathParam("id") int id, busPostVote abusPostVote) {

		new VotesService().updatePostVote(abusPostVote);
		return new busUtil().getResponse(abusPostVote);

	}
	
	@Path("/postVotes/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletePostVote(@PathParam("id") int id) {

		new VotesService().deletePostVote(id);
		return new busUtil().getResponse(new busMessage(busConstant.DeleteMessage));
	}


}
