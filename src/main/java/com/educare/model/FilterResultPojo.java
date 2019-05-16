package com.educare.model;

import org.jsoup.nodes.Document;

public class FilterResultPojo {

	private Document ques;
	String answered;
	String notanswered;
	String wronganswered;
	int Question_Id;
	int Exam_type_id;
	String qanswer;
	private String bquestion_id;
	private String subjname;
	private int leasttime;
	private int timedifference;
	private String optiona;
	private String optionb;
	private String optionc;
	private String optiond;
	private String questiontype;

	public String getOptiona() {
		return optiona;
	}

	public void setOptiona(String optiona) {
		this.optiona = optiona;
	}

	public String getOptionb() {
		return optionb;
	}

	public void setOptionb(String optionb) {
		this.optionb = optionb;
	}

	public String getOptionc() {
		return optionc;
	}

	public void setOptionc(String optionc) {
		this.optionc = optionc;
	}

	public String getOptiond() {
		return optiond;
	}

	public void setOptiond(String optiond) {
		this.optiond = optiond;
	}

	public String getQuestiontype() {
		return questiontype;
	}

	public void setQuestiontype(String questiontype) {
		this.questiontype = questiontype;
	}

	public String getBquestion_id() {
		return bquestion_id;
	}

	public void setBquestion_id(String bquestion_id) {
		this.bquestion_id = bquestion_id;
	}

	public String getQanswer() {
		return qanswer;
	}

	public void setQanswer(String qanswer) {
		this.qanswer = qanswer;
	}

	public Document getQues() {
		return ques;
	}

	public void setQues(Document ques) {
		this.ques = ques;
	}

	public String getAnswered() {
		return answered;
	}

	public String getNotanswered() {
		return notanswered;
	}

	public String getWronganswered() {
		return wronganswered;
	}

	public int getQuestion_Id() {
		return Question_Id;
	}

	public int getExam_type_id() {
		return Exam_type_id;
	}

	public void setAnswered(String answered) {
		this.answered = answered;
	}

	public void setNotanswered(String notanswered) {
		this.notanswered = notanswered;
	}

	public void setWronganswered(String wronganswered) {
		this.wronganswered = wronganswered;
	}

	public void setQuestion_Id(int question_Id) {
		Question_Id = question_Id;
	}

	public void setExam_type_id(int exam_type_id) {
		Exam_type_id = exam_type_id;
	}

	public String getSubjname() {
		return subjname;
	}

	public void setSubjname(String subjname) {
		this.subjname = subjname;
	}

	public int getTimedifference() {
		return timedifference;
	}

	public void setTimedifference(int string) {
		this.timedifference = string;
	}

	public int getLeasttime() {
		return leasttime;
	}

	public void setLeasttime(int leasttime) {
		this.leasttime = leasttime;
	}

}
