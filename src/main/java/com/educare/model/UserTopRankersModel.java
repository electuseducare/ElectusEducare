package com.educare.model;

public class UserTopRankersModel {
	private String examname;
	private String examtype;
	private String studentname;
	private String examtotalmarks;
	private String examscoredmarks;
	private String rank;

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public String getExamtotalmarks() {
		return examtotalmarks;
	}

	public void setExamtotalmarks(String examtotalmarks) {
		this.examtotalmarks = examtotalmarks;
	}

	public String getExamscoredmarks() {
		return examscoredmarks;
	}

	public void setExamscoredmarks(String examscoredmarks) {
		this.examscoredmarks = examscoredmarks;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getExamname() {
		return examname;
	}

	public void setExamname(String examname) {
		this.examname = examname;
	}

	public String getExamtype() {
		return examtype;
	}

	public void setExamtype(String examtype) {
		this.examtype = examtype;
	}

}
