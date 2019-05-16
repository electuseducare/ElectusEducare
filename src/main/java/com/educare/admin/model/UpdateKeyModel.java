package com.educare.admin.model;

public class UpdateKeyModel {

	private int examnameid;
	private String examname;
	private int quesid;
	private String questions;
	private String key;

	private String impfilename;

	public String getImpfilename() {
		return impfilename;
	}

	public void setImpfilename(String impfilename) {
		this.impfilename = impfilename;
	}

	public int getExamnameid() {
		return examnameid;
	}

	public void setExamnameid(int examnameid) {
		this.examnameid = examnameid;
	}

	public String getExamname() {
		return examname;
	}

	public void setExamname(String examname) {
		this.examname = examname;
	}

	public int getQuesid() {
		return quesid;
	}

	public void setQuesid(int quesid) {
		this.quesid = quesid;
	}

	public String getQuestions() {
		return questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
