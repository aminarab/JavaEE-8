package ir.amin.mavenbased.interceptor.samples;

import java.util.UUID;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import ir.amin.mavenbased.jpa.samples.Intercept;
import ir.amin.mavenbased.jpa.samples.InterceptDAO;
import ir.amin.mavenbased.jpa.samples.entity.Deposit;

@RequestScoped
@Path("/transaction")
@Produces("application/json")
@Consumes("application/json")
public class InterceptorController {

	@Inject
	Intercept intercept;
	
	@Inject
	InterceptDAO interceptDAO;
	
	
	@GET
	@Path("/insertDeposit")
	public Response insertDeposit() {
		Deposit deposit = new Deposit();
		deposit.setNumber(UUID.randomUUID());
		interceptDAO.insertDeposit(deposit);
		return Response.noContent().build();
	}
	
	@GET
	@Path("/correct")
	public Response correct() {
		Deposit deposit = new Deposit();
		deposit.setNumber(UUID.randomUUID());
		intercept.insertDeposit(deposit);
		return Response.noContent().build();
	}

	@GET
	@Path("/wrong")
	public Response wrong() {
		Deposit deposit = new Deposit();
		deposit.setId(1000l);
		deposit.setNumber(UUID.randomUUID());
		intercept.insertDeposit(deposit);
		return Response.noContent().build();
	}
	
}
