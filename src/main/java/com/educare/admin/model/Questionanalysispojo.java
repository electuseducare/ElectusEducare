package com.educare.admin.model;

import java.util.List;

public class Questionanalysispojo {
	private String username;
	private String studentid;
	private String classval;
	private String section;
	private String branch;
	private String firstname;
	private String differ;
	private String totalsec;
	private String avgtime;
	private String lastname;

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAvgtime() {
		return avgtime;
	}

	public void setAvgtime(String avgtime) {
		this.avgtime = avgtime;
	}

	public String getTotalsec() {
		return totalsec;
	}

	public void setTotalsec(String totalsec) {
		this.totalsec = totalsec;
	}

	public String getDiffer() {
		return differ;
	}

	public void setDiffer(String differ) {
		this.differ = differ;
	}

	private List<String> ldifference;

	public List<String> getLdifference() {
		return ldifference;
	}

	public void setLdifference(List<String> ldifference) {
		this.ldifference = ldifference;
	}

	private String filename;
	private String timedifference;
	private String selectedanswer;
	private String questionid;

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getTimedifference() {
		return timedifference;
	}

	public void setTimedifference(String timedifference) {
		this.timedifference = timedifference;
	}

	public String getSelectedanswer() {
		return selectedanswer;
	}

	public void setSelectedanswer(String selectedanswer) {
		this.selectedanswer = selectedanswer;
	}

	public String getQuestionid() {
		return questionid;
	}

	public void setQuestionid(String questionid) {
		this.questionid = questionid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public String getClassval() {
		return classval;
	}

	public void setClassval(String classval) {
		this.classval = classval;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

}
