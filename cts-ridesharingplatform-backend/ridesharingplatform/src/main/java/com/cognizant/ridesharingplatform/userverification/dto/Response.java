package com.cognizant.ridesharingplatform.userverification.dto;


import org.springframework.http.HttpStatus;

public class Response {

	private int status;
	private  HttpStatus message;
	 private String body;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public HttpStatus getMessage() {
		return message;
	}
	public void setMessage(HttpStatus message) {
		this.message = message;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Response(int status, HttpStatus message, String body) {
		super();
		this.status = status;
		this.message = message;
		this.body = body;
	}
	 
			
}
