package com.educare.admin.model;

import java.util.List;

public class AdminSubjectWiserightwrongrepo {

	private String studentid;
	private String studentname;
	private String section;
	private String branch;
	private String subject;
	private int rightcount;
	private int wrongcount;
	private int unattempt;
	private String campusid;
	private String sectionid;
	private String subjectid;
	private List<String> lstudentid;
	private List<String> lstudentname;
	private List<String> lsection;
	private List<String> lbranch;
	private List<String> lwrongcount;
	private List<String> lrightcount;
	private List<String> lunattempcount;

	public String getSubjectid() {
		return subjectid;
	}

	public void setSubjectid(String subjectid) {
		this.subjectid = subjectid;
	}

	public String getCampusid() {
		return campusid;
	}

	public void setCampusid(String campusid) {
		this.campusid = campusid;
	}

	public String getSectionid() {
		return sectionid;
	}

	public void setSectionid(String sectionid) {
		this.sectionid = sectionid;
	}

	public List<String> getLstudentid() {
		return lstudentid;
	}

	public void setLstudentid(List<String> lstudentid) {
		this.lstudentid = lstudentid;
	}

	public List<String> getLstudentname() {
		return lstudentname;
	}

	public void setLstudentname(List<String> lstudentname) {
		this.lstudentname = lstudentname;
	}

	public List<String> getLsection() {
		return lsection;
	}

	public void setLsection(List<String> lsection) {
		this.lsection = lsection;
	}

	public List<String> getLbranch() {
		return lbranch;
	}

	public void setLbranch(List<String> lbranch) {
		this.lbranch = lbranch;
	}

	public List<String> getLwrongcount() {
		return lwrongcount;
	}

	public void setLwrongcount(List<String> lwrongcount) {
		this.lwrongcount = lwrongcount;
	}

	public List<String> getLrightcount() {
		return lrightcount;
	}

	public void setLrightcount(List<String> lrightcount) {
		this.lrightcount = lrightcount;
	}

	public List<String> getLunattempcount() {
		return lunattempcount;
	}

	public void setLunattempcount(List<String> lunattempcount) {
		this.lunattempcount = lunattempcount;
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

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getRightcount() {
		return rightcount;
	}

	public void setRightcount(int rightcount) {
		this.rightcount = rightcount;
	}

	public int getWrongcount() {
		return wrongcount;
	}

	public void setWrongcount(int wrongcount) {
		this.wrongcount = wrongcount;
	}

	public int getUnattempt() {
		return unattempt;
	}

	public void setUnattempt(int unattempt) {
		this.unattempt = unattempt;
	}

}
