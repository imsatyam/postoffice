package com.satyam.postoffice.util;

/**
 * Holds the constants used in Post Office
 * @author Satyam Shandilya
 *
 */
public interface PostOfficeConstant {

	//Exception message
	String EMAIL_NULL_EX_MSG = "Email object cannot be null.";
	String FROM_NULL_EX_MSG = "From parameter cannot be null.";
	String TO_NULL_EX_MSG = "To parameter cannot be null.";
	
	//Email constants
	String TO = "\nTo: ";
	String FROM = "\nFrom: ";
	String CC = "\nCC: ";
	String BCC = "\nBCC: ";
	String SUBJECT = "\nSubject: ";
	
}
