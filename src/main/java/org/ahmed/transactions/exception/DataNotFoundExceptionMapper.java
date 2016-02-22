package org.ahmed.transactions.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.ahmed.transactions.dto.Error;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException exception) {
		Error error = new Error(exception.getMessage(), 404, "http://ahmed.org");
		return Response.status(Status.NOT_FOUND)
					.entity(error)
					.build();
		}
}
