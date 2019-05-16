package com.educare.admin.model;

import java.util.List;

import org.jsoup.nodes.Document;

import com.educare.model.OptionPojo;

public class AdminViewExamQuesPaperModel {

	private String examname;
	private int subjectid;
	private String subjectname;
	private Document ques;
	private String typeOfQuestion;
	private List<OptionPojo> optionsList;
	private String answer;
	private String question_id;
	private Document solutions;

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(String question_id) {
		this.question_id = question_id;
	}

	public String getTypeOfQuestion() {
		return typeOfQuestion;
	}

	public void setTypeOfQuestion(String typeOfQuestion) {
		this.typeOfQuestion = typeOfQuestion;
	}

	public List<OptionPojo> getOptionsList() {
		return optionsList;
	}

	public void setOptionsList(List<OptionPojo> optionsList) {
		this.optionsList = optionsList;
	}

	public Document getQues() {
		return ques;
	}

	public void setQues(Document ques) {
		this.ques = ques;
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

	public String getExamname() {
		return examname;
	}

	public void setExamname(String examname) {
		this.examname = examname;
	}

	public Document getSolutions() {
		return solutions;
	}

	public void setSolutions(Document solutions) {
		this.solutions = solutions;
	}

}
