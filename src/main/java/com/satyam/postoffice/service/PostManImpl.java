package com.satyam.postoffice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

import javax.mail.internet.MimeMessage;

import com.satyam.app.util.base.lang.Assert;
import com.satyam.postoffice.exception.PostOfficeExecption;
import com.satyam.postoffice.model.Email;
import com.satyam.postoffice.util.PostOfficeConstant;

/**
 * Provides implementation of the PostMan interface
 * @author Satyam Shandilya
 *
 */
public class PostManImpl implements PostMan{
	
	private final static Logger log = LoggerFactory.getLogger(PostManImpl.class);
	
	@Autowired
	private JavaMailSender mailSender;

	/* (non-Javadoc)
	 * @see com.satyam.postoffice.service.PostMan#sendEmail(com.satyam.postoffice.model.Email)
	 */
	public boolean sendEmail(final Email email) {
		boolean isEmailSendSuccess = false;
		
		log.info("Email object input: {}", email.toString());
		
		try {
			
			//validate the email
			validateEmail(email);
			
			MimeMessagePreparator preparator = new MimeMessagePreparator() {
				
				public void prepare(MimeMessage mimeMessage) throws Exception {
					
					MimeMessageHelper message = new MimeMessageHelper(mimeMessage, email.isMultipart());
					
					//Populate the message information
					message.setTo(email.getToRecipients());
					message.setFrom(email.getFrom());
					
					if(email.getCcRecipients() != null){
						message.setCc(email.getCcRecipients());
					}
					
					if(email.getBccRecipients() != null){
						message.setBcc(email.getBccRecipients());
					}
					
					if(email.getSubject() != null){
						message.setSubject(email.getSubject());
					}
					
					if(email.getMessageBody() != null){
						message.setText(email.getMessageBody(), email.isContentTypeHTML());
					}
					
					if(email.isMultipart() && email.getAttachments() != null){
						for(String fileName : email.getAttachments().keySet()){
							message.addAttachment(fileName, email.getAttachments().get(fileName));
						}
					}
				}
			};
			
			log.info("Sending email now...");
			
			mailSender.send(preparator);
			
			log.info("Email sent successfully...");
			
			//Set email success flag
			isEmailSendSuccess = true;
			
		} catch (Exception exception) {
			log.error("An exception occurred while sending email: ", exception);
			throw new PostOfficeExecption(exception.getMessage(), exception);
		}
		
		//return the status
		return isEmailSendSuccess;
	}
	
	
	/**
	 * Validates the email parameter
	 * @param email
	 */
	private void validateEmail(Email email){
		
		Assert.notNull(email, PostOfficeConstant.EMAIL_NULL_EX_MSG);
		Assert.hasLength(email.getFrom(), PostOfficeConstant.FROM_NULL_EX_MSG);
		Assert.notEmpty(email.getToRecipients(), PostOfficeConstant.TO_NULL_EX_MSG);
		
	}
	
}
