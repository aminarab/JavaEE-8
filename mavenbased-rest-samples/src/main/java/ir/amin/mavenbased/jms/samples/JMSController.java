package ir.amin.mavenbased.jms.samples;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import ir.amin.mavenbased.jpa.samples.JMSService;

@RequestScoped
@Path("/jms")
@Produces("application/json")
@Consumes("application/json")
public class JMSController {

	@Inject
	JMSService jmsService;
	
	@GET
	@Path("/Send")
	public Response send(@QueryParam("name") final String name) {
		jmsService.send(name);
		return Response.noContent().build();
	}

}
