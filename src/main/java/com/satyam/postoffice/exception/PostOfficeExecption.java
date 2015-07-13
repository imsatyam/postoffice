package com.satyam.postoffice.exception;

/**
 * Unchecked exception to track any erroneous scenario
 * @author Satyam Shandilya
 *
 */
public class PostOfficeExecption extends RuntimeException{

	private static final long serialVersionUID = -397835999599967279L;

	public PostOfficeExecption(String message, Throwable exception){
		super(message, exception);
	}
	
	public PostOfficeExecption(String message){
		super(message);
	}
	
}
