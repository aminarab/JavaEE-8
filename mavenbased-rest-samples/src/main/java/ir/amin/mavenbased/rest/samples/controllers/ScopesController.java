package ir.amin.mavenbased.rest.samples.controllers;

import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import ir.amin.mavenbased.ejb.samples.SingletoneSample;
import ir.amin.mavenbased.ejb.samples.interfaces.SingletoneSampleLocal;
import ir.amin.mavenbased.ejb.samples.interfaces.StatefullSampleLocal;
import ir.amin.mavenbased.ejb.samples.interfaces.StatelessSampleLocal;
import ir.amin.mavenbased.rest.samples.scopes.ApplicationScopePOJO;
import ir.amin.mavenbased.rest.samples.scopes.RequestScopePOJO;
import ir.amin.mavenbased.rest.samples.scopes.SessionScopePOJO;

@RequestScoped
@Path("/scopes")
public class ScopesController {
	
	@Inject
	private ApplicationScopePOJO applicationScopePOJO;
	
	@Inject
	private SessionScopePOJO sessionScopePOJO;
	
	@Inject
	private RequestScopePOJO requestScopePOJO;
	
	@Inject
	private HttpServletRequest request;
	
	@Inject
	private SingletoneSampleLocal singletoneSampleLocal;
	
	@Inject
	private StatefullSampleLocal statefullSampleLocal;
	
	@Inject
	private StatelessSampleLocal statelessSampleLocal;
	
	
	@GET
	@Path("addRequest/{id:[0-9][0-9]*}")
	public Response addRequest(@PathParam("id") final String id ) {
		requestScopePOJO.addRequest(createRequestInfo(id, request));
		sessionScopePOJO.addRequest(createRequestInfo(id, request));
		applicationScopePOJO.addRequest(createRequestInfo(id, request));
		
		singletoneSampleLocal.addState(createRequestInfo(id, request));
		statefullSampleLocal.addState(createRequestInfo(id, request));
		statelessSampleLocal.addState(createRequestInfo(id, request));
		
		
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append( "requestScope : <br />"  + requestScopePOJO.getRequests()+"<br /><hr />");
		stringBuilder.append( "sessionScope : <br />"  +sessionScopePOJO.getRequests()+"<br /><hr />");
		stringBuilder.append( "applicationScope : <br />"  +applicationScopePOJO.getRequests()+"<br /><hr />");
		
		stringBuilder.append( "singletoneSampleLocal : <br />"  + singletoneSampleLocal.getStates()+"<br /><hr />");
		stringBuilder.append( "statefullSampleLocal : <br />"  +statefullSampleLocal.getStates()+"<br /><hr />");
		stringBuilder.append( "statelessSampleLocal : <br />"  +statelessSampleLocal.getStates()+"<br /><hr />");
		
		return Response.ok(stringBuilder.toString()).build();
	}

	private String createRequestInfo(final String name, HttpServletRequest request) {
		return name + " : " + new Date() + " - " + request.getHeader("User-Agent");
	}
	
}
