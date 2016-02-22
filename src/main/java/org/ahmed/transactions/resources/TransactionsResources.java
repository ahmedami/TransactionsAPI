package org.ahmed.transactions.resources;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.ahmed.transactions.dto.TransactionDto;
import org.ahmed.transactions.facade.FacadeService;

@Path("/transactions")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TransactionsResources {
	
	FacadeService facade = new FacadeService();
	
	@GET
	@Path("/{transactionId}")
	public Response getTransaction(@Context UriInfo uriInfo, @PathParam("transactionId") long transactionId) {
		TransactionDto transaction = facade.getTransaction(transactionId);
		URI uri = uriInfo.getAbsolutePathBuilder().build();
		return Response.created(uri)
				.entity(transaction)
				.build();	
		
	}
	
	@PUT
	@Path("/{transactionId}")
	public Response addTransaction(@Context UriInfo uriInfo, @PathParam("transactionId") long transactionId,TransactionDto transaction){
		URI uri = uriInfo.getAbsolutePathBuilder().build();
		return Response.created(uri)
				.entity(facade.addTransaction(transactionId, transaction))
				.build();
	}
}
