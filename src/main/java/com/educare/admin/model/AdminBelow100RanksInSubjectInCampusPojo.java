package com.educare.admin.model;

import java.util.List;

public class AdminBelow100RanksInSubjectInCampusPojo {
	private String campus;
	private int examstrength;
	private String subject;
	private int rankcount;
	private int maxmarks;
	private int campusid;
	private List<Integer> lsub_rankcount;
	private List<String> lcampus;
	private List<String> lmaxmarkst;

	public List<String> getLmaxmarkst() {
		return lmaxmarkst;
	}

	public void setLmaxmarkst(List<String> lmaxmarkst) {
		this.lmaxmarkst = lmaxmarkst;
	}

	public List<Integer> getLsub_rankcount() {
		return lsub_rankcount;
	}

	public void setLsub_rankcount(List<Integer> lsub_rankcount) {
		this.lsub_rankcount = lsub_rankcount;
	}

	public List<String> getLcampus() {
		return lcampus;
	}

	public void setLcampus(List<String> lcampus) {
		this.lcampus = lcampus;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public int getExamstrength() {
		return examstrength;
	}

	public void setExamstrength(int examstrength) {
		this.examstrength = examstrength;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getRankcount() {
		return rankcount;
	}

	public void setRankcount(int rankcount) {
		this.rankcount = rankcount;
	}

	public int getMaxmarks() {
		return maxmarks;
	}

	public void setMaxmarks(int maxmarks) {
		this.maxmarks = maxmarks;
	}

	public int getCampusid() {
		return campusid;
	}

	public void setCampusid(int campusid) {
		this.campusid = campusid;
	}

}
