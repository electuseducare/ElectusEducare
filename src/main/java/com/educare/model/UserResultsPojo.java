package com.educare.model;

public class UserResultsPojo {
	private String subject;
	private String totalmarks;
	private String negativemarks;
	private float scoredmarks;
	private int correctanswers;
	private int wronganswers;
	private int unattempt;
	private String examscored;
	private String subjectwisetotal;

	public int getCorrectanswers() {
		return correctanswers;
	}

	public void setCorrectanswers(int correctanswers) {
		this.correctanswers = correctanswers;
	}

	public int getWronganswers() {
		return wronganswers;
	}

	public void setWronganswers(int wronganswers) {
		this.wronganswers = wronganswers;
	}

	public int getUnattempt() {
		return unattempt;
	}

	public void setUnattempt(int unattempt) {
		this.unattempt = unattempt;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTotalmarks() {
		return totalmarks;
	}

	public void setTotalmarks(String totalmarks) {
		this.totalmarks = totalmarks;
	}

	public String getNegativemarks() {
		return negativemarks;
	}

	public void setNegativemarks(String negativemarks) {
		this.negativemarks = negativemarks;
	}

	public String getExamscored() {
		return examscored;
	}

	public void setExamscored(String examscored) {
		this.examscored = examscored;
	}

	public String getSubjectwisetotal() {
		return subjectwisetotal;
	}

	public void setSubjectwisetotal(String subjectwisetotal) {
		this.subjectwisetotal = subjectwisetotal;
	}

	public float getScoredmarks() {
		return scoredmarks;
	}

	public void setScoredmarks(float scoredmarks) {
		this.scoredmarks = scoredmarks;
	}

}
