package com.ilan.exception;

import java.util.Date;

public class ExceptionResponse {
	
	private Date timeStamp;
	private String errorMessage;
	private String requestedURI;
	
	public ExceptionResponse(Date timeStamp, String errorMessage, String requestedURI) {
	    super();
	    this.timeStamp = timeStamp;
	    this.errorMessage = errorMessage;
	    this.requestedURI = requestedURI;
	  }



	
	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}


	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(final String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getRequestedURI() {
		return requestedURI;
	}
	
	public void setRequestedURI(final String requestedURI) {
		this.requestedURI = requestedURI;
	}
	


}
