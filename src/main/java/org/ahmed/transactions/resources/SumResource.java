package org.ahmed.transactions.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.ahmed.transactions.facade.FacadeService;

@Path("/sum")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SumResource {
	FacadeService facade = new FacadeService();
	
	@GET
	@Path("/{parentId}")
	public Response getSum(@Context UriInfo uriInfo, @PathParam("parentId") long parentId) {
		URI uri = uriInfo.getAbsolutePathBuilder().build();
		return Response.created(uri)
				.entity(facade.getSum(parentId))
				.build();
	}
}
