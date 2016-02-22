package org.ahmed.transactions.exception;

public class DataValidationException extends RuntimeException {

	private static final long serialVersionUID = -6332709301333360186L;

	public DataValidationException(String message) {
		super(message);
	}
}
