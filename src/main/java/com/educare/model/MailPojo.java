package com.educare.model;

import java.util.ArrayList;

public class MailPojo {
	String mailFrom = "";
	String mailSubject = "";
	ArrayList<String> toRecipients = new ArrayList<String>();
	ArrayList<String> ccRecipients = new ArrayList<String>();
	ArrayList<String> bccRecipients = new ArrayList<String>();
	String msgContent = "";
	ArrayList<String> mailAttachments = new ArrayList<String>();
	private String mailid;
	private String mailpwd;

	public String getMailid() {
		return mailid;
	}

	public void setMailid(String mailid) {
		this.mailid = mailid;
	}

	public String getMailpwd() {
		return mailpwd;
	}

	public void setMailpwd(String mailpwd) {
		this.mailpwd = mailpwd;
	}

	public String getMailFrom() {
		return mailFrom;
	}

	public void setMailFrom(String from) {
		if (from == null || from.length() == 0) {
			this.mailFrom = "chiselon.dev@gmail.com";
		} else {
			this.mailFrom = from;
		}
	}

	public String getMailSubject() {
		return mailSubject;
	}

	public void setMailSubject(String subject) {
		mailSubject = subject;
	}

	public ArrayList<String> getToRecipients() {
		return toRecipients;
	}

	public void setToRecipients(ArrayList<String> value) {
		toRecipients = value;
	}

	public ArrayList<String> getCCRecipients() {
		return ccRecipients;
	}

	public void setCCRecipients(ArrayList<String> value) {
		ccRecipients = value;
	}

	public ArrayList<String> getBCCRecipients() {
		return bccRecipients;
	}

	public void setBCCRecipients(ArrayList<String> value) {
		bccRecipients = value;
	}

	public String getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(String value) {
		msgContent = value;
	}

	public ArrayList<String> getMailAttachments() {
		return mailAttachments;
	}

	public void setMailAttachments(ArrayList<String> value) {
		mailAttachments = value;
	}

}