package com.educare.admin.model;

import java.util.List;

public class AdminSecwiseAttendeesWithAvgPojo {

	private String campusname;
	private int campusid;
	private String sectionname;
	private int sectionid;
	private int stusectionactcnt;
	private int examappcnttotal;
	private float averageinsubject;
	private float averageintotal;

	public float getAverageintotal() {
		return averageintotal;
	}

	public void setAverageintotal(float averageintotal) {
		this.averageintotal = averageintotal;
	}

	private List<Float> lsubjectavg;

	public String getCampusname() {
		return campusname;
	}

	public void setCampusname(String campusname) {
		this.campusname = campusname;
	}

	public int getCampusid() {
		return campusid;
	}

	public void setCampusid(int campusid) {
		this.campusid = campusid;
	}

	public String getSectionname() {
		return sectionname;
	}

	public void setSectionname(String sectionname) {
		this.sectionname = sectionname;
	}

	public int getSectionid() {
		return sectionid;
	}

	public void setSectionid(int sectionid) {
		this.sectionid = sectionid;
	}

	public int getStusectionactcnt() {
		return stusectionactcnt;
	}

	public void setStusectionactcnt(int stusectionactcnt) {
		this.stusectionactcnt = stusectionactcnt;
	}

	public int getExamappcnttotal() {
		return examappcnttotal;
	}

	public void setExamappcnttotal(int examappcnttotal) {
		this.examappcnttotal = examappcnttotal;
	}

	public float getAverageinsubject() {
		return averageinsubject;
	}

	public void setAverageinsubject(float averageinsubject) {
		this.averageinsubject = averageinsubject;
	}

	public List<Float> getLsubjectavg() {
		return lsubjectavg;
	}

	public void setLsubjectavg(List<Float> lsubjectavg) {
		this.lsubjectavg = lsubjectavg;
	}

}
