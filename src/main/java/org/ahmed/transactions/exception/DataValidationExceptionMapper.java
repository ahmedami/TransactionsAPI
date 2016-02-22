package org.ahmed.transactions.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.ahmed.transactions.dto.Error;

@Provider
public class DataValidationExceptionMapper implements ExceptionMapper<DataValidationException> {

	@Override
	public Response toResponse(DataValidationException exception) {
		Error error = new Error(exception.getMessage(), 400, "http://ahmed.org");
		return Response.status(Status.BAD_REQUEST)
					.entity(error)
					.build();
	}
}