package com.educare.admin.model;

import java.util.List;

import com.educare.model.QuestionPojo;

public class AdminFormViewExamQuesPaperModel {
	private int subjectid;
	private String subjectname;
	private String answer;
	private List<AdminViewExamQuesPaperModel> list;
	private List<QuestionPojo> list1;

	public List<QuestionPojo> getList1() {
		return list1;
	}

	public void setList1(List<QuestionPojo> list1) {
		this.list1 = list1;
	}

	public int getSubjectid() {
		return subjectid;
	}

	public void setSubjectid(int subjectid) {
		this.subjectid = subjectid;
	}

	public String getSubjectname() {
		return subjectname;
	}

	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}

	public List<AdminViewExamQuesPaperModel> getList() {
		return list;
	}

	public void setList(List<AdminViewExamQuesPaperModel> list) {
		this.list = list;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
