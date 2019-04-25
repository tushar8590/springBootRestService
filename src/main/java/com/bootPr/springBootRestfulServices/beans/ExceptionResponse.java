package com.bootPr.springBootRestfulServices.beans;

import java.time.LocalDateTime;

public class ExceptionResponse {

	private LocalDateTime timeStamp;
	private String message;
	private String detail;
	
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public ExceptionResponse(LocalDateTime timeStamp, String message, String detail) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.detail = detail;
	}
	public String getMessage() {
		return message;
	}
	public String getDetail() {
		return detail;
	}

	
}
