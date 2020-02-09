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
import com.org.panthers.business.busUser;
import com.org.panthers.framework.busLink;
import com.org.panthers.framework.busMessage;
import com.org.panthers.framework.busUtil;
import com.org.panthers.service.UserService;

@Path(busLink.USERS)
public class UserController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response list(@Context UriInfo info, @DefaultValue("false") @QueryParam("expand") boolean expand) {

		return new busUtil().getResponse(new UserService().loadUsers());
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(@Context UriInfo info, busUser abusUser) {

		new UserService().insertUser(abusUser);
		return new busUtil().getResponse(abusUser);
	}

	@Path("/user")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@Context UriInfo info, @QueryParam("aintUserId") int aintUserId) {

		return new busUtil().getResponse(new UserService().loadUser(aintUserId));
	}
	
	@Path("/user/getUserProfile")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserProfile(@Context UriInfo info, @QueryParam("aintUserId") int aintUserId, 
														  @QueryParam("aintLoggedInUserId") int aintLoggedInUserId) {

		return new busUtil().getResponse(new UserService().getUserProfile(aintUserId,aintLoggedInUserId));
	}
	
	@Path("/user/getUsers/{role}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers(@Context UriInfo info,@QueryParam("astrSearchTerm") String astrSearchTerm,@QueryParam("astrIsAutocomplete") String astrIsAutocomplete,@PathParam("role") String astrRole) {

		return new busUtil().getResponse(new UserService().getUsers(astrSearchTerm,astrIsAutocomplete, astrRole));
	}

	@Path("/user/getAutocompleteList/{role}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAutocompleteList(@Context UriInfo info,@QueryParam("astrSearchTerm") String astrSearchTerm,@PathParam("role") String astrRole) {

		return new busUtil().getResponse(new UserService().getAutocompleteList(astrSearchTerm, astrRole));
	}

	
	@Path("/user/getUserQuestions/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserQuestions(@Context UriInfo info, @PathParam("id") int aintUserId) {

		return new busUtil().getResponse(new UserService().getUserQuestions(aintUserId));
	}
	
	@Path("/user/getUserQuestionAnswers/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserQuestionAnswers(@Context UriInfo info, @PathParam("id") int aintUserId) {

		return new busUtil().getResponse(new UserService().getUserQuestionAnswers(aintUserId));
	}
	
	@Path("/user/getUserComments/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserComments(@Context UriInfo info, @PathParam("id") int aintUserId) {

		return new busUtil().getResponse(new UserService().getUserComments(aintUserId));
	}
	
	@Path("/user/getUserNotifications/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserNotifications(@Context UriInfo info, @DefaultValue("false") @QueryParam("expand") boolean expand,@PathParam("id") int aintUserId) {

		return new busUtil().getResponse(new UserService().getUserNotifications(aintUserId));
	}

	@Path("/user/updateUserNotifications/{id}")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUserNotifications(@Context UriInfo info, @PathParam("id") int aintUserId) {

		return new busUtil().getResponse(new UserService().updateUserNotifications(aintUserId));
	}
	
	@POST
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@Context UriInfo info, @PathParam("id") int id, busUser abusUser) {

		new UserService().updateUser(abusUser);		
		return new busUtil().getResponse(abusUser);
	}

	@POST
	@Path("/user/updateUserProfile")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateUserProfile(@Context UriInfo info, busUser abusUser) {

		new UserService().updateUser(abusUser);
		abusUser.addMessage(busConstant.UpdatedSuccessfully);
		return new busUtil().getResponse(abusUser);
	}
	
	@POST
	@Path("/user/updateUserProfilePicture/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateUserProfilePicture(@Context UriInfo info, @PathParam("id") int id) {

		new UserService().updateUserProfilePicture(id);
		return null;
	}
	
	@Path("/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") String id) {

		new UserService().deleteUser(Integer.parseInt(id));
		return new busUtil().getResponse(new busMessage(busConstant.DeleteMessage));
	}
	
	@POST
	@Path("/enrollUser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response enrollUser(@Context UriInfo info, busUser abusUser) {

		busUser lbusUser = new UserService().enrollUser(abusUser);
		return new busUtil().getResponse(lbusUser);
	}
	
	@POST
	@Path("/registerOrLoginSocialUser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response registerOrLoginSocialUser(@Context UriInfo info, busUser abusUser) {

		busUser lbusUser = new UserService().registerOrLoginSocialUser(abusUser);
		return new busUtil().getResponse(lbusUser);
	}
	
	@POST
	@Path("/forgotPassword")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response forgotPassword(@Context UriInfo info, busUser abusUser) {

		busUser lbusUser = new UserService().forgotPassword(abusUser);
		return new busUtil().getResponse(lbusUser);
	}
	
	@POST
	@Path("/validateUser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response validateUser(@Context UriInfo info, busUser abusUser) {

		busUser lbusUser = new UserService().validateUser(abusUser);
		return new busUtil().getResponse(lbusUser);
	}
	
	@POST
	@Path("/getUserByEmailAndOTP")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserByEmailAndOTP(@Context UriInfo info, busUser abusUser) {

		busUser lbusUser = new UserService().getUserByEmailAndOTP(abusUser);
		return new busUtil().getResponse(lbusUser);
	}

	@POST
	@Path("/setNewPassword")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response setNewPassword(@Context UriInfo info, busUser abusUser) {

		busUser lbusUser = new UserService().setNewPassword(abusUser);
		return new busUtil().getResponse(lbusUser);
	}
	
	@Path("/notifications")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getNotifications(@Context UriInfo info, @DefaultValue("false") @QueryParam("expand") boolean expand) {

		return new busUtil().getResponse(new UserService().loadNotification());
	}
	
	@Path("/tags")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTags(@Context UriInfo info) {

		return new busUtil().getResponse(new UserService().loadTags());
	}
	
	@Path("/getSaltValue")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getNotifications(@Context UriInfo info, @QueryParam("astrEmailAddress") String astrEmailAddress) {

		return new busUtil().getResponse(new UserService().getSaltValue(astrEmailAddress));
	}


}
