package com.educare.model;

public class TempHistoryPackage {
	private String Student_Id;
	private String examname;
	private int locationid;
	private int classid;
	private int sectionid;
	private int branchid;
	private int subjectid;
	private int questionid;
	private String selectedanswer;
	private String time_taken_val;
	private String actualexamstarttime;
	private String actualqunattemptime;
	private String timediff;

	public String getActualexamstarttime() {
		return actualexamstarttime;
	}

	public void setActualexamstarttime(String actualexamstarttime) {
		this.actualexamstarttime = actualexamstarttime;
	}

	public String getActualqunattemptime() {
		return actualqunattemptime;
	}

	public void setActualqunattemptime(String actualqunattemptime) {
		this.actualqunattemptime = actualqunattemptime;
	}

	public String getTimediff() {
		return timediff;
	}

	public void setTimediff(String timediff) {
		this.timediff = timediff;
	}

	public String getExamname() {
		return examname;
	}

	public void setExamname(String examname) {
		this.examname = examname;
	}

	public int getLocationid() {
		return locationid;
	}

	public void setLocationid(int locationid) {
		this.locationid = locationid;
	}

	public int getClassid() {
		return classid;
	}

	public void setClassid(int classid) {
		this.classid = classid;
	}

	public int getSectionid() {
		return sectionid;
	}

	public void setSectionid(int sectionid) {
		this.sectionid = sectionid;
	}

	public int getBranchid() {
		return branchid;
	}

	public void setBranchid(int branchid) {
		this.branchid = branchid;
	}

	public int getSubjectid() {
		return subjectid;
	}

	public void setSubjectid(int subjectid) {
		this.subjectid = subjectid;
	}

	public String getTime_taken_val() {
		return time_taken_val;
	}

	public void setTime_taken_val(String time_taken_val) {
		this.time_taken_val = time_taken_val;
	}

	public String getStudent_Id() {
		return Student_Id;
	}

	public int getQuestionid() {
		return questionid;
	}

	public String getSelectedanswer() {
		return selectedanswer;
	}

	public void setStudent_Id(String student_Id) {
		Student_Id = student_Id;
	}

	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}

	public void setSelectedanswer(String selectedanswer) {
		this.selectedanswer = selectedanswer;
	}

}