package com.educare.admin.model;

public class AdminFilterCriteria {

	private String examtype;
	private String subjectype;
	private String subjecttopic;
	private String subjectsubtopic;
	private int questioncnt;
	private String filename;
	private String questiontype;
	private String questnlevel;
	private String question;
	private String analysis;
	private int classid;
	private String classtype;
	private String topicids;
	private String topicnames;
	

	public String getTopicnames() {
		return topicnames;
	}

	public void setTopicnames(String topicnames) {
		this.topicnames = topicnames;
	}

	public String getTopicids() {
		return topicids;
	}

	public void setTopicids(String topicids) {
		this.topicids = topicids;
	}

	public int getClassid() {
		return classid;
	}

	public void setClassid(int classid) {
		this.classid = classid;
	}

	public String getClasstype() {
		return classtype;
	}

	public void setClasstype(String classtype) {
		this.classtype = classtype;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getQuestiontype() {
		return questiontype;
	}

	public void setQuestiontype(String questiontype) {
		this.questiontype = questiontype;
	}

	public String getQuestnlevel() {
		return questnlevel;
	}

	public void setQuestnlevel(String questnlevel) {
		this.questnlevel = questnlevel;
	}

	public String getExamtype() {
		return examtype;
	}

	public void setExamtype(String examtype) {
		this.examtype = examtype;
	}

	public String getSubjectype() {
		return subjectype;
	}

	public void setSubjectype(String subjectype) {
		this.subjectype = subjectype;
	}

	public String getSubjecttopic() {
		return subjecttopic;
	}

	public void setSubjecttopic(String subjecttopic) {
		this.subjecttopic = subjecttopic;
	}

	public String getSubjectsubtopic() {
		return subjectsubtopic;
	}

	public void setSubjectsubtopic(String subjectsubtopic) {
		this.subjectsubtopic = subjectsubtopic;
	}

	public int getQuestioncnt() {
		return questioncnt;
	}

	public void setQuestioncnt(int questioncnt) {
		this.questioncnt = questioncnt;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnalysis() {
		return analysis;
	}

	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}
}
