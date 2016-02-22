package org.ahmed.transactions.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.ahmed.transactions.entity.Type;
import org.ahmed.transactions.facade.FacadeService;
import org.json.JSONArray;

@Path("/types")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TypeResource {

FacadeService facade = new FacadeService();
	
	@GET
	@Path("/{typeName}")
	public Response getTransactionsByType(@Context UriInfo uriInfo, @PathParam("typeName") String typeName) {
		List<Long> transactionsIds = facade.getTransactionsByType(typeName);
		JSONArray mJSONArray = new JSONArray(transactionsIds);
		URI uri = uriInfo.getAbsolutePathBuilder().build();
		return Response.created(uri)
				.entity(mJSONArray.toString())
				.build();
	}
}