package com.apifut.resources.exceptions;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StandardError implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant timeStamp;
	private Integer statusCode;
	private String error;
	private String message;
	private String path;
	
	public StandardError() {
		
	}

	public StandardError(Instant timeStamp, Integer statusCode, String error, String message, String path) {
		super();
		this.timeStamp = timeStamp;
		this.statusCode = statusCode;
		this.error = error;
		this.message = message;
		this.path = path;
	}

	public Instant getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Instant timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}


	
	
}
