package ir.amin.mavenbased.rest.samples.controllers;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.quartz.SchedulerException;

import ir.amin.mavenbased.ejb.samples.interfaces.QuartzLocal;

@RequestScoped
@Path("/scheduler")
public class SchedulerController implements Serializable {

	@Inject
	QuartzLocal quartzLocal;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GET
	@Path("/start")
	public Response start(@QueryParam("jobKey") final String jobKeyName) throws SchedulerException {
		quartzLocal.start(jobKeyName);
		printCurrentThread();
		return Response.ok(jobKeyName + " Start").build();

	}

	@GET
	@Path("/stop")
	public Response stop(@QueryParam("jobKey") final String jobKeyName) throws SchedulerException {
		boolean result = quartzLocal.stop(jobKeyName);
		return Response.ok(jobKeyName + " Stop : " + result).build();
	}

	private void printCurrentThread() {
		Thread currentThread = Thread.currentThread();
		System.out.println(
				"currentThread Name : " + currentThread.getName() + " - currentThread Id : " + currentThread.getId());
	}
}