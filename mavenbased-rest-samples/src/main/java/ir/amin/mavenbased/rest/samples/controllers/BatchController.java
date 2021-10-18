package ir.amin.mavenbased.rest.samples.controllers;

import java.util.Properties;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.batch.runtime.JobExecution;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/batch")
public class BatchController {
		
	@GET
	@Path("/executeBatch")
	public Response addRequest(@QueryParam("name") final String name) {
		
		JobOperator jobOperator = BatchRuntime.getJobOperator();
	    Long executionId = jobOperator.start(name, new Properties());
	    JobExecution jobExecution = jobOperator.getJobExecution(executionId);
	    
	    System.out.println(jobExecution.getJobName());
	    System.out.println(jobExecution.getExecutionId());
	    printCurrentThread();
		return Response.ok(name + " Start").build();
	}

	private void printCurrentThread() {
		Thread currentThread = Thread.currentThread();
		System.out.println("currentThread Name : " + currentThread.getName()
				+ " - currentThread Id : " + currentThread.getId());
	}
}