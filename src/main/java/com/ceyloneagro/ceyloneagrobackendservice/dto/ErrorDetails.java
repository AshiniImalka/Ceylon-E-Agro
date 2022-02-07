package com.ceyloneagro.ceyloneagrobackendservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@ToString
@JsonInclude(Include.NON_NULL)
public class ErrorDetails {

	private String message;
	private Map<String,String> fieldErrors = new HashMap<>();

	public ErrorDetails(String message) {
		super();
		this.message = message;
		this.fieldErrors = null;
	}

	public ErrorDetails(Map<String,String> fieldErrors) {
		super();
		this.fieldErrors = fieldErrors;
		this.message = null;
	}
	
}
