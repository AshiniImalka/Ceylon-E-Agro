package com.ceyloneagro.ceyloneagrobackendservice.dto.response;

import com.ceyloneagro.ceyloneagrobackendservice.dto.ErrorDetails;
import com.ceyloneagro.ceyloneagrobackendservice.enumeration.ApplicationStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Setter
@Getter
@ToString
@JsonInclude(Include.NON_NULL)
public class BaseResponse<T> {

	private String timestamp;
	private String statusCode;
	private String statusMessage;
	private ErrorDetails errorDetails;
	private T responseBody;

	public BaseResponse() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		timestamp = LocalDateTime.now().format(formatter);
	}

	public BaseResponse(ApplicationStatus status) {
		this();
		this.statusMessage = status.getMessage();
		this.statusCode = status.getCode();
		this.errorDetails = null;
		this.responseBody =null;
	}
	
	public BaseResponse(ApplicationStatus status, T responseBody) {
		this();
		this.statusMessage = status.getMessage();
		this.statusCode = status.getCode();
		this.responseBody = responseBody;
		this.errorDetails = null;
	}
	
	public BaseResponse(ApplicationStatus status, ErrorDetails errorDetails) {
		this();
		this.statusMessage = status.getMessage();
		this.statusCode = status.getCode();
		this.errorDetails = errorDetails;
		this.responseBody =null;
	}

	public BaseResponse(String statusCode, String statusMessage, ErrorDetails errorDetails) {
		this();
		this.statusMessage = statusMessage;
		this.statusCode = statusCode;
		this.errorDetails = errorDetails;
		this.responseBody =null;
	}
	
	public BaseResponse(String statusCode, String statusMessage, T responseBody) {
		this();
		this.statusMessage = statusMessage;
		this.statusCode = statusCode;
		this.responseBody = responseBody;
		this.errorDetails = null;
	}

	public BaseResponse(String statusCode, String statusMessage) {
		this();
		this.statusMessage = statusMessage;
		this.statusCode = statusCode;
		this.errorDetails = null;
		this.responseBody =null;
	}

}
