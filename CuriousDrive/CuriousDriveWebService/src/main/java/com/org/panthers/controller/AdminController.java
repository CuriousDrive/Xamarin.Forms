package com.org.panthers.controller;

import java.io.IOException;

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

import com.org.panthers.business.busClass;
import com.org.panthers.business.busCode;
import com.org.panthers.business.busCodeValue;
import com.org.panthers.business.busConstant;
import com.org.panthers.business.busFeedback;
import com.org.panthers.business.busThread;
import com.org.panthers.business.busUserGroup;
import com.org.panthers.framework.busBaseController;
import com.org.panthers.framework.busLink;
import com.org.panthers.framework.busMessage;
import com.org.panthers.framework.busUtil;
import com.org.panthers.service.AdminService;


@Path(busLink.ADMIN)
public class AdminController extends busBaseController {

	@Path("/classes")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCategories(@Context UriInfo info, @DefaultValue("false") @QueryParam("expand") boolean expand) {

		return new busUtil().getResponse(new AdminService().loadClasss());
	}
	
	@Path("/classes/getClasses/")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCategoriesByThread(@Context UriInfo info, 
			@DefaultValue("false") @QueryParam("expand") boolean expand) {

		return new busUtil().getResponse(new AdminService().getClasses());
	}
	
	@Path("/classes")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createClasss(@Context UriInfo info, busClass abusClass) {

		new AdminService().createClass(abusClass);
		return new busUtil().getResponse(abusClass);
	}

	@Path("/classes/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getClass(@Context UriInfo info, @PathParam("id") int id) {

		return new busUtil().getResponse(new AdminService().getClass(id));
	}

	@Path("/messages/getMessage/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMessage(@Context UriInfo info, @PathParam("id") int id) {

		return new busUtil().getResponse(new AdminService().getMessage(id));
	}
	
	@POST
	@Path("/classes/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateClass(@Context UriInfo info, @PathParam("id") int id, busClass abusClass) {
		
		new AdminService().updateClass(abusClass);
		return new busUtil().getResponse(abusClass);
	}
	
	@Path("/classes/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteClass(@PathParam("id") int id) {

		new AdminService().deleteClassNew(id);
		return new busUtil().getResponse(new busMessage(busConstant.DeleteMessage));
	}
	
	@Path("/threads")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getThreads(@Context UriInfo info, @DefaultValue("false") @QueryParam("expand") boolean expand) {

		return new busUtil().getResponse(new AdminService().loadThreads());
	}

	@Path("/getApprovedThreads")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getApprovedThreads(@Context UriInfo info, @DefaultValue("false") @QueryParam("expand") boolean expand) {

		return new busUtil().getResponse(new AdminService().loadApprovedThreads());
	}
	
	@Path("/threads")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createThreads(@Context UriInfo info, busThread abusThread) {

		new AdminService().insertThread(abusThread);
		return new busUtil().getResponse(abusThread);
	}

	@Path("/threads/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getThread(@Context UriInfo info, @PathParam("id") int id) {

		return new busUtil().getResponse(new AdminService().loadThread(id));
	}
	
	@POST
	@Path("/threads/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateThread(@Context UriInfo info, @PathParam("id") int id, busThread abusThread) {

		new AdminService().updateThread(abusThread);
		return new busUtil().getResponse(abusThread);

	}
	
	@Path("/threads/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteThread(@PathParam("id") int id) {

		new AdminService().deleteThread(id);
		return new busUtil().getResponse(new busMessage(busConstant.DeleteMessage));
	}

	@Path("/codes")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCodes(@Context UriInfo info, @DefaultValue("false") @QueryParam("expand") boolean expand) {

		return new busUtil().getResponse(new AdminService().loadCodes());
	}

	@Path("/codes")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createCodes(@Context UriInfo info, busCode abusCode) {

		new AdminService().insertCode(abusCode);
		return new busUtil().getResponse(abusCode);
	}

	@Path("/codes/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCode(@Context UriInfo info, @PathParam("id") int id) {

		return new busUtil().getResponse(new AdminService().loadCode(id));
	}
	
	@POST
	@Path("/codes/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCode(@Context UriInfo info, @PathParam("id") int id, busCode abusCode) {

		new AdminService().updateCode(abusCode);
		return new busUtil().getResponse(abusCode);

	}
	
	@Path("/codes/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteCode(@PathParam("id") int id) {

		new AdminService().deleteCode(id);
		return new busUtil().getResponse(new busMessage(busConstant.DeleteMessage));
	}
	
	@Path("/codeValues")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createCodeValues(@Context UriInfo info, busCodeValue abusCodeValue) {

		new AdminService().insertCodeValue(abusCodeValue);
		return new busUtil().getResponse(abusCodeValue);
	}

	@Path("/codeValues/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCodeValue(@Context UriInfo info, @PathParam("id") int id) {

		return new busUtil().getResponse(new AdminService().loadCodeValue(id));
	}
	
	@Path("/codeValues/getConstants")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getConstants(@Context UriInfo info, @QueryParam("codeValue") String astrCodevalue) {

		busCodeValue abusCodeValue = new busCodeValue();
		abusCodeValue.idoCodeValue.setCodeValue(astrCodevalue);
		
		return new busUtil().getResponse(new AdminService().getConstants(abusCodeValue));
	}
	
	@Path("/codeValues/getCodeValues/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCodeValues(@Context UriInfo info, @PathParam("id") int codeId) {

		return new busUtil().getResponse(new AdminService().getCodeValues(codeId));
	}

	@POST
	@Path("/codeValues/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCodeValue(@Context UriInfo info, @PathParam("id") int id, busCodeValue abusCodeValue) {

		new AdminService().updateCodeValue(abusCodeValue);
		return new busUtil().getResponse(abusCodeValue);

	}

	@Path("/codeValues/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteCodeValue(@PathParam("id") int id) {

		new AdminService().deleteCodeValue(id);
		return new busUtil().getResponse(new busMessage(busConstant.DeleteMessage));
	}
	
	@Path("/feedbacks/loadVerifiedFeedbacks")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVerifiedFeedbacks(@Context UriInfo info, @DefaultValue("false") @QueryParam("expand") boolean expand) {

		return new busUtil().getResponse(new AdminService().loadVerifiedFeedbacks());
	}
	
	@Path("/feedbacks/loadFeedbacksToVerify")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFeedbacksToVerfiy(@Context UriInfo info, @DefaultValue("false") @QueryParam("expand") boolean expand) {

		return new busUtil().getResponse(new AdminService().loadFeedbacksToVerify());
	}
		
	@Path("/feedbacks")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createFeedback(@Context UriInfo info, busFeedback abusFeedback) {

		new AdminService().insertFeedback(abusFeedback);
		return new busUtil().getResponse(abusFeedback);
	}

	@Path("/feedbacks/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFeedback(@Context UriInfo info, @PathParam("id") int id) {

		return new busUtil().getResponse(new AdminService().loadFeedback(id));
	}
	
	@POST
	@Path("/feedbacks/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateFeedback(@Context UriInfo info, @PathParam("id") int id, busFeedback abusFeedback) 
	{		
		new AdminService().updateFeedback(abusFeedback);
		return new busUtil().getResponse(abusFeedback);
	}
	
	@Path("/userGroups/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteUserGroup(@PathParam("id") int id) {

		new AdminService().deleteUserGroup(id);
		return new busUtil().getResponse(new busMessage(busConstant.DeleteMessage));
	}

	@Path("/userGroups")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createUserGroup(@Context UriInfo info, busUserGroup abusUserGroup) {

		busUserGroup lbusUserGroup = new AdminService().createUserGroup(abusUserGroup);
		return new busUtil().getResponse(lbusUserGroup);
	}
	
	@Path("/userGroups/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserGroup(@Context UriInfo info, @PathParam("id") int id) {

		return new busUtil().getResponse(new AdminService().loadUserGroup(id));
	}

	@Path("/userGroups")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserGroups(@Context UriInfo info) {

		return new busUtil().getResponse(new AdminService().getUserGroups());
	}
	
	@Path("/getUserGroupsByName")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserGroupsByName(@Context UriInfo info,@QueryParam("astrSearchTerm") String astrSearchTerm) {

		return new busUtil().getResponse(new AdminService().getUserGroupsByName(astrSearchTerm));
	}
	
	@Path("/getActiveUserGroups")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getActiveUserGroups(@Context UriInfo info) {

		return new busUtil().getResponse(new AdminService().getActiveUserGroups());
	}
	
	@POST
	@Path("/userGroups/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateUserGroup(@Context UriInfo info, @PathParam("id") int id, busUserGroup abusUserGroup) 
	{		
		abusUserGroup = new AdminService().updateUserGroup(abusUserGroup);
		return new busUtil().getResponse(abusUserGroup);
	}
	
	@Path("/roles")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRoles(@Context UriInfo info, @DefaultValue("false") @QueryParam("expand") boolean expand) {

		return new busUtil().getResponse(new AdminService().loadRoles());
	}
	
	@Path("/userGroupDetail/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserGroupDetail(@Context UriInfo info, @PathParam("id") int id) {

		return new busUtil().getResponse(new AdminService().loadUserGroupDetail(id));
	}
	
	@Path("/bookADemo")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response bookADemo(@Context UriInfo info, @QueryParam("astrEmailAddress") String astrEmailAddress) {

		try {
			new busUtil().sendEmail(busConstant.salesEmailAddress, "Webportal - Book a Demo", busConstant.BookADemoTemplate, new Object[] { astrEmailAddress } );
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new busUtil().getResponse("The message has been sent!!");
	}

	@Path("/dropUsAMessage")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response dropUsAMessage(@Context UriInfo info, @QueryParam("astrName") String astrName,@QueryParam("astrEmailAddress") String astrEmailAddress,
			@QueryParam("astrSubject") String astrSubject,@QueryParam("astrTelNumber") String astrTelNumber,@QueryParam("astrComments") String astrComments) {

		try {
			new busUtil().sendEmail(busConstant.salesEmailAddress, "Webportal - Drop Us a Message", busConstant.DropUsAMessageTemplate, 
					new Object[] { astrName ,astrEmailAddress, astrSubject, astrTelNumber, astrComments } );
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new busUtil().getResponse("The message has been sent!!");
	}


}
