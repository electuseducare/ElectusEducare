package com.educare.model;

import java.sql.Time;
import java.util.List;

import org.jsoup.nodes.Document;

public class QuestionPojo {

	private Document ques;
	private String displayquest;
	private String options;
	private String answer;
	private String question_id;
	private String bquestion_id;
	private String actualAnswer;
	private String typeOfQuestion;
	private List<OptionPojo> optionsList;
	private String exam_reg_id;
	private String exam_type;
	private String subject_type;
	private String package_name;
	private String orderid;
	private String selected_answer;
	private String reg_id;
	private Time Time_Taken;
	private Time Total_Time;
	private int scoredmarks;
	private String examname;
	private int marksperqustype;
	private String isjumbling;

	private String location;
	private int locationid;
	private String branch;
	private int branchid;
	private String classname;
	private int classid;
	private String section;
	private int sectionid;
	private String starttime;
	private String endtime;
	private String slotdate;
	private String subject;
	private int subjectid;
	private String topicid;
	private String subtopicid;
	private int numofquesperqustype;
	private String qustypeid;
	private String startdate;
	private String enddate;
	private String testduration;
	private String markforreview;
	private String markforansreview;
	private int stateid;
	private String username;

	private String marks_per_qus_type;
	private String negative_marks;
	private int total_available_students;
	private String toatalmarks;
	private String time_taken_value;
	private String exam_status;
	private int questionrowid;
	private String multianswer;
	private String filenames;

	private List<String> sublist;
	private List<String> subidlist;

	private String examenddate;
	private String examendtime;
	private String examstartdate;
	private String examstarttime;

	private String patterntypeid;

	public String getPatterntypeid() {
		return patterntypeid;
	}

	public void setPatterntypeid(String patterntypeid) {
		this.patterntypeid = patterntypeid;
	}

	public String getExamenddate() {
		return examenddate;
	}

	public void setExamenddate(String examenddate) {
		this.examenddate = examenddate;
	}

	public String getExamendtime() {
		return examendtime;
	}

	public void setExamendtime(String examendtime) {
		this.examendtime = examendtime;
	}

	public String getExamstartdate() {
		return examstartdate;
	}

	public void setExamstartdate(String examstartdate) {
		this.examstartdate = examstartdate;
	}

	public String getExamstarttime() {
		return examstarttime;
	}

	public void setExamstarttime(String examstarttime) {
		this.examstarttime = examstarttime;
	}

	public String getMarkforreview() {
		return markforreview;
	}

	public void setMarkforreview(String markforreview) {
		this.markforreview = markforreview;
	}

	public String getMarkforansreview() {
		return markforansreview;
	}

	public void setMarkforansreview(String markforansreview) {
		this.markforansreview = markforansreview;
	}

	public String getMarks_per_qus_type() {
		return marks_per_qus_type;
	}

	public void setMarks_per_qus_type(String marks_per_qus_type) {
		this.marks_per_qus_type = marks_per_qus_type;
	}

	public String getNegative_marks() {
		return negative_marks;
	}

	public void setNegative_marks(String negative_marks) {
		this.negative_marks = negative_marks;
	}

	public String getFilenames() {
		return filenames;
	}

	public void setFilenames(String filenames) {
		this.filenames = filenames;
	}

	public String getTime_taken_value() {
		return time_taken_value;
	}

	public void setTime_taken_value(String time_taken_value) {
		this.time_taken_value = time_taken_value;
	}

	public int getTotal_available_students() {
		return total_available_students;
	}

	public void setTotal_available_students(int total_available_students) {
		this.total_available_students = total_available_students;
	}

	public String getTestduration() {
		return testduration;
	}

	public void setTestduration(String testduration) {
		this.testduration = testduration;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
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

	public String getSlotdate() {
		return slotdate;
	}

	public void setSlotdate(String slotdate) {
		this.slotdate = slotdate;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTopicid() {
		return topicid;
	}

	public void setTopicid(String topicid) {
		this.topicid = topicid;
	}

	public String getSubtopicid() {
		return subtopicid;
	}

	public void setSubtopicid(String subtopicid) {
		this.subtopicid = subtopicid;
	}

	public int getNumofquesperqustype() {
		return numofquesperqustype;
	}

	public void setNumofquesperqustype(int numofquesperqustype) {
		this.numofquesperqustype = numofquesperqustype;
	}

	public String getQustypeid() {
		return qustypeid;
	}

	public void setQustypeid(String qustypeid) {
		this.qustypeid = qustypeid;
	}

	public String getExamname() {
		return examname;
	}

	public void setExamname(String examname) {
		this.examname = examname;
	}

	public int getMarksperqustype() {
		return marksperqustype;
	}

	public void setMarksperqustype(int marksperqustype) {
		this.marksperqustype = marksperqustype;
	}

	public int getScoredmarks() {
		return scoredmarks;
	}

	public void setScoredmarks(int scoredmarks) {
		this.scoredmarks = scoredmarks;
	}

	public Time getTotal_Time() {
		return Total_Time;
	}

	public void setTotal_Time(Time total_Time) {
		Total_Time = total_Time;
	}

	public Time getTime_Taken() {
		return Time_Taken;
	}

	public void setTime_Taken(Time time_Taken) {
		Time_Taken = time_Taken;
	}

	public String getReg_id() {
		return reg_id;
	}

	public void setReg_id(String reg_id) {
		this.reg_id = reg_id;
	}

	public String getSelected_answer() {
		return selected_answer;
	}

	public void setSelected_answer(String selected_answer) {
		this.selected_answer = selected_answer;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getExam_type() {
		return exam_type;
	}

	public void setExam_type(String exam_type) {
		this.exam_type = exam_type;
	}

	public String getSubject_type() {
		return subject_type;
	}

	public void setSubject_type(String subject_type) {
		this.subject_type = subject_type;
	}

	public String getPackage_name() {
		return package_name;
	}

	public void setPackage_name(String package_name) {
		this.package_name = package_name;
	}

	public String getExam_reg_id() {
		return exam_reg_id;
	}

	public void setExam_reg_id(String exam_reg_id) {
		this.exam_reg_id = exam_reg_id;
	}

	public String getActualAnswer() {
		return actualAnswer;
	}

	public void setActualAnswer(String actualAnswer) {
		this.actualAnswer = actualAnswer;
	}

	public String getBquestion_id() {
		return bquestion_id;
	}

	public void setBquestion_id(String bquestion_id) {
		this.bquestion_id = bquestion_id;
	}

	public String getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(String question_id) {
		this.question_id = question_id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getDisplayquest() {
		return displayquest;
	}

	public void setDisplayquest(String displayquest) {
		this.displayquest = displayquest;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public Document getQues() {
		return ques;
	}

	public void setQues(Document doc) {
		this.ques = doc;
	}

	/**
	 * @return the typeOfQuestion
	 */
	public String getTypeOfQuestion() {
		return typeOfQuestion;
	}

	/**
	 * @param typeOfQuestion
	 *            the typeOfQuestion to set
	 */
	public void setTypeOfQuestion(String typeOfQuestion) {
		this.typeOfQuestion = typeOfQuestion;
	}

	/**
	 * @return the optionsList
	 */
	public List<OptionPojo> getOptionsList() {
		return optionsList;
	}

	/**
	 * @param optionsList
	 *            the optionsList to set
	 */
	public void setOptionsList(List<OptionPojo> optionsList) {
		this.optionsList = optionsList;
	}

	public int getLocationid() {
		return locationid;
	}

	public void setLocationid(int locationid) {
		this.locationid = locationid;
	}

	public int getBranchid() {
		return branchid;
	}

	public void setBranchid(int branchid) {
		this.branchid = branchid;
	}

	public int getClassid() {
		return classid;
	}

	public void setClassid(int classid) {
		this.classid = classid;
	}

	public int getSectionid() {
		return sectionid;
	}

	public void setSectionid(int sectionid) {
		this.sectionid = sectionid;
	}

	public int getSubjectid() {
		return subjectid;
	}

	public void setSubjectid(int subjectid) {
		this.subjectid = subjectid;
	}

	public String getExam_status() {
		return exam_status;
	}

	public void setExam_status(String exam_status) {
		this.exam_status = exam_status;
	}

	public List<String> getSublist() {
		return sublist;
	}

	public void setSublist(List<String> sublist) {
		this.sublist = sublist;
	}

	public List<String> getSubidlist() {
		return subidlist;
	}

	public void setSubidlist(List<String> subidlist) {
		this.subidlist = subidlist;
	}

	public int getQuestionrowid() {
		return questionrowid;
	}

	public void setQuestionrowid(int questionrowid) {
		this.questionrowid = questionrowid;
	}

	public String getMultianswer() {
		return multianswer;
	}

	public void setMultianswer(String multianswer) {
		this.multianswer = multianswer;
	}

	public String getIsjumbling() {
		return isjumbling;
	}

	public void setIsjumbling(String isjumbling) {
		this.isjumbling = isjumbling;
	}

	public String getToatalmarks() {
		return toatalmarks;
	}

	public void setToatalmarks(String toatalmarks) {
		this.toatalmarks = toatalmarks;
	}

	public int getStateid() {
		return stateid;
	}

	public void setStateid(int stateid) {
		this.stateid = stateid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}