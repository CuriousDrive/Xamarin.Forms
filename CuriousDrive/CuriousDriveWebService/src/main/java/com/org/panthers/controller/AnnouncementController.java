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

import com.org.panthers.business.busAnnouncement;
import com.org.panthers.business.busConstant;
import com.org.panthers.framework.busLink;
import com.org.panthers.framework.busMessage;
import com.org.panthers.framework.busUtil;
import com.org.panthers.service.AnnouncementService;

@Path(busLink.ANNOUNCEMENTS)
public class AnnouncementController {
	
	@Path("/announcements")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadAnnouncements(@Context UriInfo info, @DefaultValue("false") @QueryParam("expand") boolean expand) {

		return new busUtil().getResponse(new AnnouncementService().loadAnnouncements());
	}
	
	@Path("/getAnnouncements")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAnnouncements(@Context UriInfo info, @DefaultValue("false") @QueryParam("expand") boolean expand) {

		return new busUtil().getResponse(new AnnouncementService().getAnnouncements());
	}

	@Path("/announcements")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createAnnouncement(@Context UriInfo info, busAnnouncement abusAnnouncement) {
		
		busAnnouncement lreturnedbusAnnouncement = new AnnouncementService().createAnnouncement(abusAnnouncement);
		return new busUtil().getResponse(lreturnedbusAnnouncement);
	}

	@Path("/announcements/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAnnouncement(@Context UriInfo info, @PathParam("id") int id) {

		return new busUtil().getResponse(new AnnouncementService().loadAnnouncement(id));
	}
	
	@POST
	@Path("/announcements/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateAnnouncement(@Context UriInfo info, @PathParam("id") int id, busAnnouncement abusAnnouncement) {

		new AnnouncementService().updateAnnouncement(abusAnnouncement);
		return new busUtil().getResponse(abusAnnouncement);

	}
	
	@Path("/announcements/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteAnnouncement(@PathParam("id") int id) {

		new AnnouncementService().deleteAnnouncement(id);
		return new busUtil().getResponse(new busMessage(busConstant.DeleteMessage));
	}

	@Path("/getAnnouncementDetails")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAnnouncementDetails(@Context UriInfo info, @QueryParam("aintAnnouncementId") int aintAnnouncementId,
			@QueryParam("aintLoggedInUserId") int aintLoggedInUserId) {
		
		return new busUtil().getResponse(new AnnouncementService().getAnnouncementDetails(aintAnnouncementId,aintLoggedInUserId));		
	}
}
