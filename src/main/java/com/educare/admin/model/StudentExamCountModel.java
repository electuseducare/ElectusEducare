package com.educare.admin.model;

public class StudentExamCountModel {

	private String examname;
	private String studentname;
	private String username;
	private String examstatus;

	
	public String getExamstatus() {
		return examstatus;
	}

	public void setExamstatus(String examstatus) {
		this.examstatus = examstatus;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getExamname() {
		return examname;
	}

	public void setExamname(String examname) {
		this.examname = examname;
	}

}
