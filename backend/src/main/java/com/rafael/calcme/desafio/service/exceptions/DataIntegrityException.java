package com.rafael.calcme.desafio.service.exceptions;

public class DataIntegrityException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public DataIntegrityException(String msg) {
		super(msg);
	}
	
	public DataIntegrityException(String msg, Throwable cause) {
		super(msg, cause);
	}
	

}
