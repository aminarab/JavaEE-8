package ir.amin.mavenbased.rest.samples.controllers;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import ir.amin.mavenbased.ejb.samples.concurrency.ParentThread;

@RequestScoped
@Path("/mt")
public class MultiThreadController {

	@EJB
	ParentThread parentThread;
	
	@GET
	@Path("addRequest/{id:[0-9][0-9]*}")
	public Response addRequest(@PathParam("id") final Long id ) {
		parentThread.preparedMessage(id);
		return Response.ok().build();
	}

	@GET
	@Path("addAysncRequest/{id:[0-9][0-9]*}")
	public Response addAysncRequest(@PathParam("id") final Long id ) {
		parentThread.asynchronousPreparedMessage(id);
		return Response.ok().build();
	}
	
	@GET
	@Path("addCallableRequest/{id:[0-9][0-9]*}")
	public Response addCallableRequest(@PathParam("id") final Long id ) {
		parentThread.preparedMessageByCallable(id);
		return Response.ok().build();
	}
	
	@GET
	@Path("addRunnableRequest/{id:[0-9][0-9]*}")
	public Response addRunnableRequest(@PathParam("id") final Long id ) {
		parentThread.preparedMessageByRunnable(id);
		return Response.ok().build();
	}
}