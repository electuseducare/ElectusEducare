package com.educare.model;

import java.util.List;

public class FormQuestionPojo {
	private List<QuestionPojo> list;
	private List<QuestionPojo> list1;
	private String subjectid;
	private String subjectname;

	public String getSubjectid() {
		return subjectid;
	}

	public void setSubjectid(String subjectid) {
		this.subjectid = subjectid;
	}

	public String getSubjectname() {
		return subjectname;
	}

	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}

	public List<QuestionPojo> getList() {
		return list;
	}

	public void setList(List<QuestionPojo> list) {
		this.list = list;
	}

	public List<QuestionPojo> getList1() {
		return list1;
	}

	public void setList1(List<QuestionPojo> list1) {
		this.list1 = list1;
	}

}