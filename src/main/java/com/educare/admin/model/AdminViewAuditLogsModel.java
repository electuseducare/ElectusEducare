package com.educare.admin.model;

public class AdminViewAuditLogsModel {

	private String studentid;
	private String username;
	private String logindate;
	private String logoutdate;
	private String examname;
	private String examstarttime;
	private String examendtime;
	private String examresumetime;

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLogindate() {
		return logindate;
	}

	public void setLogindate(String logindate) {
		this.logindate = logindate;
	}

	public String getLogoutdate() {
		return logoutdate;
	}

	public void setLogoutdate(String logoutdate) {
		this.logoutdate = logoutdate;
	}

	public String getExamname() {
		return examname;
	}

	public void setExamname(String examname) {
		this.examname = examname;
	}

	public String getExamstarttime() {
		return examstarttime;
	}

	public void setExamstarttime(String examstarttime) {
		this.examstarttime = examstarttime;
	}

	public String getExamendtime() {
		return examendtime;
	}

	public void setExamendtime(String examendtime) {
		this.examendtime = examendtime;
	}

	public String getExamresumetime() {
		return examresumetime;
	}

	public void setExamresumetime(String examresumetime) {
		this.examresumetime = examresumetime;
	}

}
