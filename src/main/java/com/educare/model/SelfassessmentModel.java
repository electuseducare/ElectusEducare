package com.educare.model;

public class SelfassessmentModel {

	private String examtype;
	private String examtypeid;
	private String examname;
	private String totalmarks;
	private String scoredmarks;
	private String questionpaper;

	public String getQuestionpaper() {
		return questionpaper;
	}

	public void setQuestionpaper(String questionpaper) {
		this.questionpaper = questionpaper;
	}

	public String getExamname() {
		return examname;
	}

	public void setExamname(String examname) {
		this.examname = examname;
	}

	public String getTotalmarks() {
		return totalmarks;
	}

	public void setTotalmarks(String totalmarks) {
		this.totalmarks = totalmarks;
	}

	public String getScoredmarks() {
		return scoredmarks;
	}

	public void setScoredmarks(String scoredmarks) {
		this.scoredmarks = scoredmarks;
	}

	public String getExamtype() {
		return examtype;
	}

	public void setExamtype(String examtype) {
		this.examtype = examtype;
	}

	public String getExamtypeid() {
		return examtypeid;
	}

	public void setExamtypeid(String examtypeid) {
		this.examtypeid = examtypeid;
	}

}
