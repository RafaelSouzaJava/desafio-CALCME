package com.rafael.calcme.desafio.controllers.exceptions;

import java.io.Serializable;

public class FieldMessage implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String FildName;
	private String message;
	
	public FieldMessage() {		
	}

	public FieldMessage(String fildName, String message) {
		super();
		FildName = fildName;
		this.message = message;
	}

	public String getFildName() {
		return FildName;
	}

	public void setFildName(String fildName) {
		FildName = fildName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
