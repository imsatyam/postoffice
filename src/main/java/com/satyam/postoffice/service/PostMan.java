package com.satyam.postoffice.service;

import com.satyam.postoffice.model.Email;

/**
 * Provides specification for the send email API
 * @author Satyam Shandilya
 *
 */
public interface PostMan {

	/**
	 * Method to send email
	 * @param email
	 * @return status
	 */
	public boolean sendEmail(Email email);
	
}
