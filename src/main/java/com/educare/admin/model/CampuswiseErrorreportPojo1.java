package com.educare.admin.model;

import java.util.HashMap;
import java.util.List;

public class CampuswiseErrorreportPojo1 {

	private HashMap<String, List<Integer>> lquestionid;
	private HashMap<String, HashMap<String, List<Integer>>> lquestionerrorcnt;
	private HashMap<String, HashMap<String, List<Float>>> lqnerrorpercentage;

	public HashMap<String, List<Integer>> getLquestionid() {
		return lquestionid;
	}

	public void setLquestionid(HashMap<String, List<Integer>> lquestionid) {
		this.lquestionid = lquestionid;
	}

	public HashMap<String, HashMap<String, List<Integer>>> getLquestionerrorcnt() {
		return lquestionerrorcnt;
	}

	public void setLquestionerrorcnt(HashMap<String, HashMap<String, List<Integer>>> lquestionerrorcnt) {
		this.lquestionerrorcnt = lquestionerrorcnt;
	}

	public HashMap<String, HashMap<String, List<Float>>> getLqnerrorpercentage() {
		return lqnerrorpercentage;
	}

	public void setLqnerrorpercentage(HashMap<String, HashMap<String, List<Float>>> lqnerrorpercentage) {
		this.lqnerrorpercentage = lqnerrorpercentage;
	}

}
