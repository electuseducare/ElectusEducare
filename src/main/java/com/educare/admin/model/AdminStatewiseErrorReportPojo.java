package com.educare.admin.model;

import java.util.ArrayList;
import java.util.List;

public class AdminStatewiseErrorReportPojo {
	private String campus;
	private int campusid;
	private String subjectname;
	private int examstrength;
	private int questionid;
	private int countofErrorQid;
	private List<Integer> lcountofErrorQid;
	private List<Float> lqiderrorpercentage;
	private List<Integer> lquestionid;
	private float qiderrorpercentage;
	private int questiocnt;

	public ArrayList<List<Integer>> getLquestionerrorcnt() {
		return lquestionerrorcnt;
	}

	public void setLquestionerrorcnt(ArrayList<List<Integer>> lquestionerrorcnt) {
		this.lquestionerrorcnt = lquestionerrorcnt;
	}

	public ArrayList<List<Float>> getLqnerrorpercentage() {
		return lqnerrorpercentage;
	}

	public void setLqnerrorpercentage(ArrayList<List<Float>> lqnerrorpercentage) {
		this.lqnerrorpercentage = lqnerrorpercentage;
	}

	private ArrayList<List<Integer>> lquestionerrorcnt;
	private ArrayList<List<Float>> lqnerrorpercentage;

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public String getSubjectname() {
		return subjectname;
	}

	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}

	public int getCampusid() {
		return campusid;
	}

	public void setCampusid(int campusid) {
		this.campusid = campusid;
	}

	public int getExamstrength() {
		return examstrength;
	}

	public void setExamstrength(int examstrength) {
		this.examstrength = examstrength;
	}

	public int getQuestionid() {
		return questionid;
	}

	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}

	public int getCountofErrorQid() {
		return countofErrorQid;
	}

	public void setCountofErrorQid(int countofErrorQid) {
		this.countofErrorQid = countofErrorQid;
	}

	public float getQiderrorpercentage() {
		return qiderrorpercentage;
	}

	public void setQiderrorpercentage(float qiderrorpercentage) {
		this.qiderrorpercentage = qiderrorpercentage;
	}

	public List<Integer> getLcountofErrorQid() {
		return lcountofErrorQid;
	}

	public void setLcountofErrorQid(List<Integer> lcountofErrorQid) {
		this.lcountofErrorQid = lcountofErrorQid;
	}

	public List<Float> getLqiderrorpercentage() {
		return lqiderrorpercentage;
	}

	public void setLqiderrorpercentage(List<Float> lqiderrorpercentage) {
		this.lqiderrorpercentage = lqiderrorpercentage;
	}

	public List<Integer> getLquestionid() {
		return lquestionid;
	}

	public void setLquestionid(List<Integer> lquestionid) {
		this.lquestionid = lquestionid;
	}

	public int getQuestiocnt() {
		return questiocnt;
	}

	public void setQuestiocnt(int questiocnt) {
		this.questiocnt = questiocnt;
	}

}
