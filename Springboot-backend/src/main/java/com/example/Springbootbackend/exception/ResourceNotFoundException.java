package com.example.Springbootbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)

public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID=1L;
	private String resourseName;
	private String fieldName;
	private Object fildValue;
	
	public ResourceNotFoundException(String resourseName, String fieldName, Object fildValue) {
		super(String.format("%s not found with %s : '%s'",resourseName,fieldName,fildValue));
		this.resourseName = resourseName;
		this.fieldName = fieldName;
		this.fildValue = fildValue;
	}
	public String getResourseName() {
		return resourseName;
	}
	public String getFieldName() {
		return fieldName;
	}
	public Object getFildValue() {
		return fildValue;
	}
	
}
