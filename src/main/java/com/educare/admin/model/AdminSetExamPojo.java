package com.educare.admin.model;

public class AdminSetExamPojo {
	private String examname;
	private String classname;
	private String state;
	private String branch;
	private String sectionname;
	private String subjectname;
	private String topic;
	private String topicid;
	private String subtopic;
	private String subtopicid;
	private String starttime;
	private String endtime;
	private String startdate;
	private String enddate;
	private String examtime;
	private String totalquestion;
	private int marksperqn;
	private String qntypes;

	private String fixedmarks;
	private String filenames;

	public String getTotalquestion() {
		return totalquestion;
	}

	public void setTotalquestion(String totalquestion) {
		this.totalquestion = totalquestion;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getExamtime() {
		return examtime;
	}

	public void setExamtime(String examtime) {
		this.examtime = examtime;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getTopicid() {
		return topicid;
	}

	public void setTopicid(String topicid) {
		this.topicid = topicid;
	}

	public String getSubtopic() {
		return subtopic;
	}

	public void setSubtopic(String subtopic) {
		this.subtopic = subtopic;
	}

	public String getSubtopicid() {
		return subtopicid;
	}

	public void setSubtopicid(String subtopicid) {
		this.subtopicid = subtopicid;
	}

	public String getSectionname() {
		return sectionname;
	}

	public void setSectionname(String sectionname) {
		this.sectionname = sectionname;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getExamname() {
		return examname;
	}

	public void setExamname(String examname) {
		this.examname = examname;
	}

	public String getSubjectname() {
		return subjectname;
	}

	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}

	public String getFixedmarks() {
		return fixedmarks;
	}

	public void setFixedmarks(String fixedmarks) {
		this.fixedmarks = fixedmarks;
	}

	public int getMarksperqn() {
		return marksperqn;
	}

	public void setMarksperqn(int marksperqn) {
		this.marksperqn = marksperqn;
	}

	public String getQntypes() {
		return qntypes;
	}

	public void setQntypes(String qntypes) {
		this.qntypes = qntypes;
	}

	public String getFilenames() {
		return filenames;
	}

	public void setFilenames(String filenames) {
		this.filenames = filenames;
	}

}
