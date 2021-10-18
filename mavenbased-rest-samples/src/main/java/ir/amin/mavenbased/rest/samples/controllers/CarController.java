package ir.amin.mavenbased.rest.samples.controllers;

import java.text.ParseException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import ir.amin.mavenbased.jpa.samples.CarDAO;
import ir.amin.mavenbased.jpa.samples.entity.Car;

@RequestScoped
@Path("/car")
@Produces("application/json")
@Consumes("application/json")
public class CarController {

	@Inject
	CarDAO carDAO;


	@POST
	@Path("/sample")
	@Transactional(value = TxType.REQUIRED)
//	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Response insertSampleDate() throws ParseException {
		carDAO.insertSampleData();
		return Response.noContent().build();
	}
	
	@POST
	@Transactional
	public Response create(final Car car) {
		carDAO.insert(car);
		return Response.ok(car).build();
	}

	@GET
	@Path("/{id:[0-9][0-9]*}")
	public Response findById(@PathParam("id") final Long id) {
		Car car = carDAO.findById(id);
		Jsonb jsonb = JsonbBuilder.create();
		System.out.println(jsonb.toJson(car));
		if (car == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		
		Response response = null;
		try {
			response = Response.ok(car).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return response;
	}

	@GET
	@Path("/all")
	public List<Car> findAll() {
		return carDAO.findAll();
	}

	@PUT
	@Path("/update")
	@Transactional
	public Response update(final Car car) {
		carDAO.update(car);
		return Response.ok(car).build();
	}

	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	@Transactional
	public Response deleteById(@PathParam("id") final Long id) {
		Car car = carDAO.findById(id);
		carDAO.delete(car);
		return Response.noContent().build();
	}

	@GET
	@Path("/findByValidLicence")
	public List<Car> findByValidLicence() {
		return carDAO.findByValidLicence();
	}

	@GET
	@Path("/findByOwnerName")
	public List<Car> findByOwnerName(@QueryParam("name") final String name) {
		return carDAO.findByOwnerName(name);
	}

	@GET
	@Path("/findByProductionYear/{year:[0-9][0-9][0-9][0-9]*}")
	public List<Car> findByProductionYear(@PathParam("year") final Integer year) {
		return carDAO.findByProductionYear(year);
	}

}