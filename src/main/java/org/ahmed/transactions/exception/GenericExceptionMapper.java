package org.ahmed.transactions.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.ahmed.transactions.dto.Error;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable exception) {
		Error error = new Error(exception.getMessage(), 500, "http://ahmed.org");
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(error)
				.build();
	}

}