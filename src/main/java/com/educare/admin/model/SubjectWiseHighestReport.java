package com.educare.admin.model;

import java.util.List;

public class SubjectWiseHighestReport {
	String aggrsubjectwisehighest;
	String highestsubject1;
	String highestsubject2;
	String highestsubject3;
	int rank;
	float totalscoreval;

	public String getSubjectwisemarks() {
		return subjectwisemarks;
	}

	public void setSubjectwisemarks(String subjectwisemarks) {
		this.subjectwisemarks = subjectwisemarks;
	}

	String subjectwisemarks;
	String scoredmarkspercampus;

	public String getScoredmarkspercampus() {
		return scoredmarkspercampus;
	}

	public void setScoredmarkspercampus(String scoredmarkspercampus) {
		this.scoredmarkspercampus = scoredmarkspercampus;
	}

	int campuswisemarks;
	int campuswiserank;
	int subjectwisevalue;
	List<Integer> subjectwiseranklist;

	public List<Integer> getSubjectwiseranklist() {
		return subjectwiseranklist;
	}

	public void setSubjectwiseranklist(List<Integer> subjectwiseranklist) {
		this.subjectwiseranklist = subjectwiseranklist;
	}

	public int getSubjectwisevalue() {
		return subjectwisevalue;
	}

	public void setSubjectwisevalue(int subjectwisevalue) {
		this.subjectwisevalue = subjectwisevalue;
	}

	private List<Integer> campusranklist;

	public List<Integer> getCampusranklist() {
		return campusranklist;
	}

	public void setCampusranklist(List<Integer> campusranklist) {
		this.campusranklist = campusranklist;
	}

	public int getCampuswiserank() {
		return campuswiserank;
	}

	public void setCampuswiserank(int campuswiserank) {
		this.campuswiserank = campuswiserank;
	}

	public int getSubjectwiserank() {
		return subjectwiserank;
	}

	public void setSubjectwiserank(int subjectwiserank) {
		this.subjectwiserank = subjectwiserank;
	}

	int subjectwiserank;

	public int getCampuswisemarks() {
		return campuswisemarks;
	}

	public void setCampuswisemarks(int campuswisemarks) {
		this.campuswisemarks = campuswisemarks;
	}

	private List<String> campusscore;

	public List<String> getCampusscore() {
		return campusscore;
	}

	public void setCampusscore(List<String> campusscore) {
		this.campusscore = campusscore;
	}

	private List<String> subjectwisescore;

	public List<String> getSubjectwisescore() {
		return subjectwisescore;
	}

	public void setSubjectwisescore(List<String> subjectwisescore) {
		this.subjectwisescore = subjectwisescore;
	}

	public float getTotalscoreval() {
		return totalscoreval;
	}

	public void setTotalscoreval(float totalscoreval) {
		this.totalscoreval = totalscoreval;
	}

	private int examstrength;

	public int getExamstrength() {
		return examstrength;
	}

	public void setExamstrength(int examstrength) {
		this.examstrength = examstrength;
	}

	String campus;
	String campusid;

	public String getCampusid() {
		return campusid;
	}

	public void setCampusid(String campusid) {
		this.campusid = campusid;
	}

	String subjcampus;

	public String getAggrsubjectwisehighest() {
		return aggrsubjectwisehighest;
	}

	public void setAggrsubjectwisehighest(String aggrsubjectwisehighest) {
		this.aggrsubjectwisehighest = aggrsubjectwisehighest;
	}

	public String getHighestsubject1() {
		return highestsubject1;
	}

	public void setHighestsubject1(String highestsubject1) {
		this.highestsubject1 = highestsubject1;
	}

	public String getHighestsubject2() {
		return highestsubject2;
	}

	public void setHighestsubject2(String highestsubject2) {
		this.highestsubject2 = highestsubject2;
	}

	public String getHighestsubject3() {
		return highestsubject3;
	}

	public void setHighestsubject3(String highestsubject3) {
		this.highestsubject3 = highestsubject3;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public String getSubjcampus() {
		return subjcampus;
	}

	public void setSubjcampus(String subjcampus) {
		this.subjcampus = subjcampus;
	}

}
