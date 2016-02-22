package org.ahmed.transactions.dto;

public class Response {
	public static final String STATUS_OK = "ok";
	public static final String STATUS_WRONG = "wrong";
	
	private String status;

	public Response(String status) {
		super();
		this.status = status;
	}
	
	public Response() {
		super();
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}


}
