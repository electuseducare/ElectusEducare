package com.educare.admin.model;

public class AdminSetStartExamPatternModel {
	private int examtypeid;
	private String examtype;
	private String patterntype;
	private int patternid;
	private String hiddenexamtype;

	public String getHiddenexamtype() {
		return hiddenexamtype;
	}

	public void setHiddenexamtype(String hiddenexamtype) {
		this.hiddenexamtype = hiddenexamtype;
	}

	public int getExamtypeid() {
		return examtypeid;
	}

	public void setExamtypeid(int examtypeid) {
		this.examtypeid = examtypeid;
	}

	public String getExamtype() {
		return examtype;
	}

	public void setExamtype(String examtype) {
		this.examtype = examtype;
	}

	public String getPatterntype() {
		return patterntype;
	}

	public void setPatterntype(String patterntype) {
		this.patterntype = patterntype;
	}

	public int getPatternid() {
		return patternid;
	}

	public void setPatternid(int patternid) {
		this.patternid = patternid;
	}

}
