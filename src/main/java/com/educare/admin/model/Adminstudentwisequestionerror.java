package com.educare.admin.model;

import java.util.List;

public class Adminstudentwisequestionerror {
	private String studentid;
	private String studentname;
	private String section;
	private String campus;
	private int questionid;
	private String rightanswer;
	private String wronganswer;
	private String unattempt;
	private String campusid;
	private int questionrowid;

	public int getQuestionrowid() {
		return questionrowid;
	}

	public void setQuestionrowid(int questionrowid) {
		this.questionrowid = questionrowid;
	}

	public String getCampusid() {
		return campusid;
	}

	public void setCampusid(String campusid) {
		this.campusid = campusid;
	}

	private String sectionid;

	public String getSectionid() {
		return sectionid;
	}

	public void setSectionid(String sectionid) {
		this.sectionid = sectionid;
	}

	private List<Integer> lquestionid;

	private List<String> lcorrect;
	private List<String> lwrong;
	private List<String> lunattempt;

	public List<String> getLcorrect() {
		return lcorrect;
	}

	public void setLcorrect(List<String> lcorrect) {
		this.lcorrect = lcorrect;
	}

	public List<String> getLwrong() {
		return lwrong;
	}

	public void setLwrong(List<String> lwrong) {
		this.lwrong = lwrong;
	}

	public List<String> getLunattempt() {
		return lunattempt;
	}

	public void setLunattempt(List<String> lunattempt) {
		this.lunattempt = lunattempt;
	}

	public List<Integer> getLquestionid() {
		return lquestionid;
	}

	public void setLquestionid(List<Integer> lquestionid) {
		this.lquestionid = lquestionid;
	}

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public int getQuestionid() {
		return questionid;
	}

	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}

	public String getRightanswer() {
		return rightanswer;
	}

	public void setRightanswer(String rightanswer) {
		this.rightanswer = rightanswer;
	}

	public String getWronganswer() {
		return wronganswer;
	}

	public void setWronganswer(String wronganswer) {
		this.wronganswer = wronganswer;
	}

	public String getUnattempt() {
		return unattempt;
	}

	public void setUnattempt(String unattempt) {
		this.unattempt = unattempt;
	}

}
