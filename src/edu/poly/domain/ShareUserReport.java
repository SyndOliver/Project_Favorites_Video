package edu.poly.domain;

import java.util.Date;

public class ShareUserReport {
	private String senderName;
	private String senderEmail;
	private String receiverEmail;
	private Date sentDate;
	
	
	
	public ShareUserReport() {
	}
	public ShareUserReport(String senderName, String senderEmail, String receiverEmail, Date sentDate) {
		this.senderName = senderName;
		this.senderEmail = senderEmail;
		this.receiverEmail = receiverEmail;
		this.sentDate = sentDate;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getSenderEmail() {
		return senderEmail;
	}
	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}
	public String getReceiverEmail() {
		return receiverEmail;
	}
	public void setReceiverEmail(String receiverEmail) {
		this.receiverEmail = receiverEmail;
	}
	public Date getSentDate() {
		return sentDate;
	}
	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}
	
	
	
	
	
}
