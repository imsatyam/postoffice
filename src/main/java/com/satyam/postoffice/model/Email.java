package com.satyam.postoffice.model;

import java.util.Map;

import javax.activation.DataSource;

import com.satyam.app.util.base.constant.Constants;
import com.satyam.postoffice.util.PostOfficeConstant;

/**
 * Email class which represents an email to be sent 
 * @author Satyam Shandilya
 *
 */
public class Email {

	/**
	 * To recipients
	 */
	private String[] toRecipients;
	
	/**
	 * CC Recipients
	 */
	private String[] ccRecipients;
	
	/**
	 * BCC Recipients
	 */
	private String[] bccRecipients;
	
	/**
	 * Subject of the email
	 */
	private String subject;
	
	/**
	 * Message to be sent
	 */
	private String messageBody;
	
	/**
	 * Email sender
	 */
	private String from;
	
	/**
	 * Reply to
	 */
	private String replyTo;
	
	/**
	 * Attachments map. Key = File Name. Value = file
	 */
	private Map<String, DataSource> attachments;
	
	/**
	 * Is there an attachment in this email.
	 */
	private boolean multipart;
	
	/**
	 * Is this an HTML email or a text email.
	 */
	private boolean contentTypeHTML;

	/**
	 * @return the toRecipients
	 */
	public String[] getToRecipients() {
		return toRecipients;
	}

	/**
	 * @param toRecipients the toRecipients to set
	 */
	public void setToRecipients(String[] toRecipients) {
		this.toRecipients = toRecipients;
	}

	/**
	 * @return the ccRecipients
	 */
	public String[] getCcRecipients() {
		return ccRecipients;
	}

	/**
	 * @param ccRecipients the ccRecipients to set
	 */
	public void setCcRecipients(String[] ccRecipients) {
		this.ccRecipients = ccRecipients;
	}

	/**
	 * @return the bccRecipients
	 */
	public String[] getBccRecipients() {
		return bccRecipients;
	}

	/**
	 * @param bccRecipients the bccRecipients to set
	 */
	public void setBccRecipients(String[] bccRecipients) {
		this.bccRecipients = bccRecipients;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the messageBody
	 */
	public String getMessageBody() {
		return messageBody;
	}

	/**
	 * @param messageBody the messageBody to set
	 */
	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}

	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * @return the replyTo
	 */
	public String getReplyTo() {
		return replyTo;
	}

	/**
	 * @param replyTo the replyTo to set
	 */
	public void setReplyTo(String replyTo) {
		this.replyTo = replyTo;
	}

	/**
	 * @return the attachments
	 */
	public Map<String, DataSource> getAttachments() {
		return attachments;
	}

	/**
	 * @param attachments the attachments to set
	 */
	public void setAttachments(Map<String, DataSource> attachments) {
		this.attachments = attachments;
	}

	/**
	 * @return the multipart
	 */
	public boolean isMultipart() {
		return multipart;
	}

	/**
	 * @param multipart the multipart to set
	 */
	public void setMultipart(boolean multipart) {
		this.multipart = multipart;
	}

	/**
	 * @return the contentTypeHTML
	 */
	public boolean isContentTypeHTML() {
		return contentTypeHTML;
	}

	/**
	 * @param contentTypeHTML the contentTypeHTML to set
	 */
	public void setContentTypeHTML(boolean contentTypeHTML) {
		this.contentTypeHTML = contentTypeHTML;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(Constants.LEFT_BRACKET)
				.append(PostOfficeConstant.FROM).append(this.from)
				.append(PostOfficeConstant.TO).append(this.toRecipients)
				.append(PostOfficeConstant.CC).append(this.ccRecipients)
				.append(PostOfficeConstant.BCC).append(this.bccRecipients)
				.append(PostOfficeConstant.SUBJECT).append(this.subject)
				.append(Constants.RIGHT_BRACKET);
		return builder.toString();
	}
	
}
