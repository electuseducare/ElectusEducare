package com.educare.admin.model;

public class AdminInsertQuestionsInTempModel {
	private String studentid;
	private int subjectid;
	private int questionid;
	private int questionpaperid;
	private int markperquestiontype;
	private int nagativemarks;
	private String filenames;
	private String questiontypeid;
	private int classid;
	private int sectionid;
	private int brancid;

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

	public int getBrancid() {
		return brancid;
	}

	public void setBrancid(int brancid) {
		this.brancid = brancid;
	}

	public int getLocationid() {
		return locationid;
	}

	public void setLocationid(int locationid) {
		this.locationid = locationid;
	}

	private int locationid;

	public int getSubjectid() {
		return subjectid;
	}

	public void setSubjectid(int subjectid) {
		this.subjectid = subjectid;
	}

	public int getQuestionid() {
		return questionid;
	}

	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}

	public int getQuestionpaperid() {
		return questionpaperid;
	}

	public void setQuestionpaperid(int questionpaperid) {
		this.questionpaperid = questionpaperid;
	}

	public int getMarkperquestiontype() {
		return markperquestiontype;
	}

	public void setMarkperquestiontype(int markperquestiontype) {
		this.markperquestiontype = markperquestiontype;
	}

	public int getNagativemarks() {
		return nagativemarks;
	}

	public void setNagativemarks(int nagativemarks) {
		this.nagativemarks = nagativemarks;
	}

	public String getFilenames() {
		return filenames;
	}

	public void setFilenames(String filenames) {
		this.filenames = filenames;
	}

	public String getQuestiontypeid() {
		return questiontypeid;
	}

	public void setQuestiontypeid(String questiontypeid) {
		this.questiontypeid = questiontypeid;
	}

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

}
