package com.educare.model;

public class UserExamPojo {
	private String examname;
	private String location;
	private String branch;
	private String classname;
	private String section;
	private String starttime;
	private String endtime;
	private String slotdate;
	private String subject;
	private String topicid;
	private String subtopicid;
	private int numofquesperqustype;
	private String qustypeid;

	public String getQustypeid() {
		return qustypeid;
	}

	public void setQustypeid(String qustypeid) {
		this.qustypeid = qustypeid;
	}

	public int getNumofquesperqustype() {
		return numofquesperqustype;
	}

	public void setNumofquesperqustype(int numofquesperqustype) {
		this.numofquesperqustype = numofquesperqustype;
	}

	public String getTopicid() {
		return topicid;
	}

	public void setTopicid(String topicid) {
		this.topicid = topicid;
	}

	public String getSubtopicid() {
		return subtopicid;
	}

	public void setSubtopicid(String subtopicid) {
		this.subtopicid = subtopicid;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSlotdate() {
		return slotdate;
	}

	public void setSlotdate(String slotdate) {
		this.slotdate = slotdate;
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

	public String getExamname() {
		return examname;
	}

	public void setExamname(String examname) {
		this.examname = examname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

}
