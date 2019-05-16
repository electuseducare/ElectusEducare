package com.educare.servicecalls.model;

import java.util.List;

public class DisplayExamsServiceModel {

	private String enddate;
	private String slotdate;
	private String starttime;
	private String endtime;
	private String examname;
	private String examtype;
	private String examstatus;
	private List<String> subnamelist;
	private List<String> subidlist;

	public String getExamstatus() {
		return examstatus;
	}

	public void setExamstatus(String examstatus) {
		this.examstatus = examstatus;
	}

	public List<String> getSubidlist() {
		return subidlist;
	}

	public void setSubidlist(List<String> subidlist) {
		this.subidlist = subidlist;
	}

	public List<String> getSubnamelist() {
		return subnamelist;
	}

	public void setSubnamelist(List<String> subnamelist) {
		this.subnamelist = subnamelist;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
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

	public String getExamtype() {
		return examtype;
	}

	public void setExamtype(String examtype) {
		this.examtype = examtype;
	}

}
