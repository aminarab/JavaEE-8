package ir.amin.mavenbased.rest.samples.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
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

import ir.amin.mavenbased.rest.samples.InventoryItem;

import javax.ws.rs.core.UriBuilder;

@RequestScoped
@Path("/inventoryitems")
@Produces("application/json")
@Consumes("application/json")
public class InventoryItemEndpoint {

	
	Map<Long, InventoryItem> inventoryitems = new HashMap<Long, InventoryItem>();
	
	@POST
	public Response create(final InventoryItem inventoryitem) {
		inventoryitems.put(inventoryitem.getCatalogItemId(), inventoryitem);
		
		return Response.ok(inventoryitem).build();
	}

	@GET
	@Path("/{id:[0-9][0-9]*}")
	public Response findById(@PathParam("id") final Long id) {
		InventoryItem inventoryitem = inventoryitems.get(id);
		inventoryitem = new InventoryItem(1L, 1L, "Mittens", 100L); 
		if (inventoryitem == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(inventoryitem).build();
	}

	@GET
	public List<InventoryItem> listAll(@QueryParam("start") final Integer startPosition,
			@QueryParam("max") final Integer maxResult) {
		//TODO: retrieve the inventoryitems 
		final List<InventoryItem> inventoryitemList = (List<InventoryItem>) inventoryitems.values();
		return inventoryitemList;
	}

	@PUT
	@Path("/{id:[0-9][0-9]*}")
	public Response update(@PathParam("id") Long id, final InventoryItem inventoryitem) {
		inventoryitems.put(id, inventoryitem);
//		inventoryitem.setCatalogItemId(id);
		return Response.noContent().build();
	}

	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	public Response deleteById(@PathParam("id") final Long id) {
		inventoryitems.remove(id);
		return Response.noContent().build();
	}

}
