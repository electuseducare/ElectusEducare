package com.educare.admin.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CampuswiseErrorreportPojo {
	private String campus;
	private int campusid;
	private String subjectname;
	private int examstrength;
	private int questionid;
	private int countofErrorQid;
	private List<Integer> lcountofErrorQid;
	private List<Float> lqiderrorpercentage;
	private HashMap<String, ArrayList<String>> lquestionid;
	private float qiderrorpercentage;
	private int questiocnt;
	private String state;
	private int stateid;
	private List<String> listsubject;
	private List<String> listsubject1;
	private String qnerrorcnt;
	private int questionrowid;

	private HashMap<String, ArrayList<Integer>> lquestionerrorcnt;
	private HashMap<String, ArrayList<Float>> lqnerrorpercentage;
	private ArrayList<List<Integer>> lquestionerrorcnt1;
	private ArrayList<List<Float>> lqnerrorpercentage1;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getStateid() {
		return stateid;
	}

	public void setStateid(int stateid) {
		this.stateid = stateid;
	}

	public List<String> getListsubject() {
		return listsubject;
	}

	public void setListsubject(List<String> listsubject) {
		this.listsubject = listsubject;
	}

	public List<String> getListsubject1() {
		return listsubject1;
	}

	public void setListsubject1(List<String> listsubject1) {
		this.listsubject1 = listsubject1;
	}

	public String getQnerrorcnt() {
		return qnerrorcnt;
	}

	public void setQnerrorcnt(String qnerrorcnt) {
		this.qnerrorcnt = qnerrorcnt;
	}

	public HashMap<String, ArrayList<Integer>> getLquestionerrorcnt() {
		return lquestionerrorcnt;
	}

	public void setLquestionerrorcnt(HashMap<String, ArrayList<Integer>> lquestionerrorcnt) {
		this.lquestionerrorcnt = lquestionerrorcnt;
	}

	public HashMap<String, ArrayList<Float>> getLqnerrorpercentage() {
		return lqnerrorpercentage;
	}

	public void setLqnerrorpercentage(HashMap<String, ArrayList<Float>> lqnerrorpercentage) {
		this.lqnerrorpercentage = lqnerrorpercentage;
	}

	public ArrayList<List<Integer>> getLquestionerrorcnt1() {
		return lquestionerrorcnt1;
	}

	public void setLquestionerrorcnt1(ArrayList<List<Integer>> lquestionerrorcnt1) {
		this.lquestionerrorcnt1 = lquestionerrorcnt1;
	}

	public ArrayList<List<Float>> getLqnerrorpercentage1() {
		return lqnerrorpercentage1;
	}

	public void setLqnerrorpercentage1(ArrayList<List<Float>> lqnerrorpercentage1) {
		this.lqnerrorpercentage1 = lqnerrorpercentage1;
	}

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

	public int getQuestiocnt() {
		return questiocnt;
	}

	public void setQuestiocnt(int questiocnt) {
		this.questiocnt = questiocnt;
	}

	public HashMap<String, ArrayList<String>> getLquestionid() {
		return lquestionid;
	}

	public void setLquestionid(HashMap<String, ArrayList<String>> lquestionid) {
		this.lquestionid = lquestionid;
	}

	public int getQuestionrowid() {
		return questionrowid;
	}

	public void setQuestionrowid(int questionrowid) {
		this.questionrowid = questionrowid;
	}

}
