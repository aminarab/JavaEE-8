package ir.amin.mavenbased.rest.samples.qualifier;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import ir.amin.mavenbased.rest.samples.qualifier.custom.CustomQualifier;
import ir.amin.mavenbased.rest.samples.qualifier.custom.ShapeService;

@RequestScoped
@Path("/qualifier")
public class QualifierController {
	
	@Inject
	@Named("engneeringCalculatorService")
	CalculatorService calculatorService;
	
	
	@GET
	@Path("calculator/sum")
	public Response sum(@QueryParam("a") final Integer a,
			@QueryParam("b") final Integer b) {
		return Response.ok(calculatorService.sum(a, b)).build();
	}
	
	
	@Inject
	@CustomQualifier
	ShapeService shapeService;

	@GET
	@Path("shapeName")
	public Response shapeName() {
		return Response.ok(shapeService.name()).build();
	}
	
}
