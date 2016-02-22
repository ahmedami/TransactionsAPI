package org.ahmed.transactions.exception;

public class DataNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 8756744346253569704L;

	public DataNotFoundException(String message) {
		super(message);
	}
}
