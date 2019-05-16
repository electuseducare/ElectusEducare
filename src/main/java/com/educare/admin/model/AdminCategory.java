package com.educare.admin.model;

import java.util.List;

public class AdminCategory {
	private String filenames;
	private String category;
	private String categoryid;
	private String categoryname;
	private String section;
	private String sectionid;
	private String sectioncheckname;
	private String branch;
	private String branchid;
	private String branchcheckname;
	private String subject;
	private String subjectid;
	private String subjectcheckvalue;
	private String location;
	private String locationid;
	private String loactioncheckvalue;
	private String group;
	private String groupid;
	private String groupcheckvalue;
	private String questiontype;
	private String questiontypeid;
	private int marksperqn;
	private String fixedmarks;
	private String examname;
	private String state;
	private String classname;
	private String sectionname;
	private String subjectname;
	private String startdate;
	private String enddate;
	private String starttime;
	private String endtime;
	private String examtime;
	private String totalquestion;
	private String qntypes;
	private String topic;
	private String topicid;
	private String subtopic;
	private int negativemarks;
	private String statename;
	private int stateid;
	private String statechckbox;
	private String questiontypecheckvalue;
	private int totalmarks;
	private String availablestates;
	private String topicnames;
	private String topicnametext;
	private String subtopicnames;
	private String subtopicnametext;
	private String subtopicid;
	private String examtype;
	private int examtypeid;
	private String questionleveltype;
	private int questionleveltypeid;
	private String examtypeselectbox;
	private String qnleveltypecheckbox;
	private String examtypeckeckbox;
	private String examtype_name;
	private String examtype_id;
	private String questionlevel;
	private String qnlevelckeckbox;
	private String quesntion_level;
	private String hiddenstatename;
	private String hiddenlocationname;

	private String hiddenstateid;
	private String hiddenclassname;
	private String selectedexam;
	private String selectedstateids;
	private String selectedlocationids;
	private String selectedbranchid;
	private String selectedquslevelid;
	private String selectedclassid;
	private String selectedsectionid;
	private String selectedsubjectid;
	private String selectedsubjectqns;
	private String selectedtopics;
	private String selectedtopicnames;
	private String selectedsubtopics;
	private String selectedsubtopicnames;
	private String selectedqustype;
	private List<String> selectednumofqusperqustype;
	private List<String> selectedmarksperqustype;
	private String numofqusperqustype;
	private String marksperquestiontype;
	private List<String> subjectlist;
	private List<String> selnegmarksperqntype;
	private String nmarksperquestiontype;
	private int positivemarks;
	private String questions;

	private String studentid;
	private String studentidchkname;
	private String username;
	private String usernamechk;
	private String scoredmarks;
	private String studentname;
	private List<String> lsubavg;
	private List<Integer> lsubrank;
	private String totalavg;
	private String ranktotal;
	private int examcount;

	private String examdate;
	private String examtotalmarks;

	private List<String> subscoremarkslist;
	private String avgmarks;
	private List<String> avgmarkslist;
	private String examwiserank;

	private String smstype;
	private String smsdescription;
	private String firstname;
	private String mobile;
	private String negativemarks1;


	private List<String> filenamelist;
	private List<String> topiclist;
	private List<String> stopiclist;
	
	
	
	public List<String> getStopiclist() {
		return stopiclist;
	}

	public void setStopiclist(List<String> stopiclist) {
		this.stopiclist = stopiclist;
	}

	public List<String> getFilenamelist() {
		return filenamelist;
	}

	public void setFilenamelist(List<String> filenamelist) {
		this.filenamelist = filenamelist;
	}

	public String getSmstype() {
		return smstype;
	}

	public void setSmstype(String smstype) {
		this.smstype = smstype;
	}

	public String getSmsdescription() {
		return smsdescription;
	}

	public void setSmsdescription(String smsdescription) {
		this.smsdescription = smsdescription;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getExamdate() {
		return examdate;
	}

	public void setExamdate(String examdate) {
		this.examdate = examdate;
	}

	public String getExamtotalmarks() {
		return examtotalmarks;
	}

	public void setExamtotalmarks(String examtotalmarks) {
		this.examtotalmarks = examtotalmarks;
	}

	public List<String> getSubscoremarkslist() {
		return subscoremarkslist;
	}

	public void setSubscoremarkslist(List<String> subscoremarkslist) {
		this.subscoremarkslist = subscoremarkslist;
	}

	public String getAvgmarks() {
		return avgmarks;
	}

	public void setAvgmarks(String avgmarks) {
		this.avgmarks = avgmarks;
	}

	public List<String> getAvgmarkslist() {
		return avgmarkslist;
	}

	public void setAvgmarkslist(List<String> avgmarkslist) {
		this.avgmarkslist = avgmarkslist;
	}

	public String getExamwiserank() {
		return examwiserank;
	}

	public void setExamwiserank(String examwiserank) {
		this.examwiserank = examwiserank;
	}

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public String getStudentidchkname() {
		return studentidchkname;
	}

	public void setStudentidchkname(String studentidchkname) {
		this.studentidchkname = studentidchkname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsernamechk() {
		return usernamechk;
	}

	public void setUsernamechk(String usernamechk) {
		this.usernamechk = usernamechk;
	}

	public String getScoredmarks() {
		return scoredmarks;
	}

	public void setScoredmarks(String scoredmarks) {
		this.scoredmarks = scoredmarks;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public List<String> getLsubavg() {
		return lsubavg;
	}

	public void setLsubavg(List<String> lsubavg) {
		this.lsubavg = lsubavg;
	}

	public List<Integer> getLsubrank() {
		return lsubrank;
	}

	public void setLsubrank(List<Integer> lsubrank) {
		this.lsubrank = lsubrank;
	}

	public String getTotalavg() {
		return totalavg;
	}

	public void setTotalavg(String totalavg) {
		this.totalavg = totalavg;
	}

	public String getRanktotal() {
		return ranktotal;
	}

	public void setRanktotal(String ranktotal) {
		this.ranktotal = ranktotal;
	}

	public List<String> getSubjectlist() {
		return subjectlist;
	}

	public void setSubjectlist(List<String> subjectlist) {
		this.subjectlist = subjectlist;
	}

	public String getNumofqusperqustype() {
		return numofqusperqustype;
	}

	public void setNumofqusperqustype(String numofqusperqustype) {
		this.numofqusperqustype = numofqusperqustype;
	}

	public String getMarksperquestiontype() {
		return marksperquestiontype;
	}

	public void setMarksperquestiontype(String marksperquestiontype) {
		this.marksperquestiontype = marksperquestiontype;
	}

	public List<String> getSelectednumofqusperqustype() {
		return selectednumofqusperqustype;
	}

	public void setSelectednumofqusperqustype(List<String> selectednumofqusperqustype) {
		this.selectednumofqusperqustype = selectednumofqusperqustype;
	}

	public List<String> getSelectedmarksperqustype() {
		return selectedmarksperqustype;
	}

	public void setSelectedmarksperqustype(List<String> selectedmarksperqustype) {
		this.selectedmarksperqustype = selectedmarksperqustype;
	}

	public String getSelectedsubtopics() {
		return selectedsubtopics;
	}

	public void setSelectedsubtopics(String selectedsubtopics) {
		this.selectedsubtopics = selectedsubtopics;
	}

	public String getSelectedsubtopicnames() {
		return selectedsubtopicnames;
	}

	public void setSelectedsubtopicnames(String selectedsubtopicnames) {
		this.selectedsubtopicnames = selectedsubtopicnames;
	}

	public String getQnlevelckeckbox() {
		return qnlevelckeckbox;
	}

	public void setQnlevelckeckbox(String qnlevelckeckbox) {
		this.qnlevelckeckbox = qnlevelckeckbox;
	}

	public String getQuesntion_level() {
		return quesntion_level;
	}

	public void setQuesntion_level(String quesntion_level) {
		this.quesntion_level = quesntion_level;
	}

	public String getExamtypeselectbox() {
		return examtypeselectbox;
	}

	public void setExamtypeselectbox(String examtypeselectbox) {
		this.examtypeselectbox = examtypeselectbox;
	}

	public String getExamtype() {
		return examtype;
	}

	public void setExamtype(String examtype) {
		this.examtype = examtype;
	}

	public int getExamtypeid() {
		return examtypeid;
	}

	public void setExamtypeid(int examtypeid) {
		this.examtypeid = examtypeid;
	}

	public String getQuestionleveltype() {
		return questionleveltype;
	}

	public void setQuestionleveltype(String questionleveltype) {
		this.questionleveltype = questionleveltype;
	}

	public int getQuestionleveltypeid() {
		return questionleveltypeid;
	}

	public void setQuestionleveltypeid(int questionleveltypeid) {
		this.questionleveltypeid = questionleveltypeid;
	}

	public String getSubtopicnames() {
		return subtopicnames;
	}

	public void setSubtopicnames(String subtopicnames) {
		this.subtopicnames = subtopicnames;
	}

	public String getSubtopicnametext() {
		return subtopicnametext;
	}

	public void setSubtopicnametext(String subtopicnametext) {
		this.subtopicnametext = subtopicnametext;
	}

	public String getTopicnames() {
		return topicnames;
	}

	public void setTopicnames(String topicnames) {
		this.topicnames = topicnames;
	}

	public String getTopicnametext() {
		return topicnametext;
	}

	public void setTopicnametext(String topicnametext) {
		this.topicnametext = topicnametext;
	}

	public String getStatechckbox() {
		return statechckbox;
	}

	public void setStatechckbox(String statechckbox) {
		this.statechckbox = statechckbox;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getTopicid() {
		return topicid;
	}

	public void setTopicid(String topicid) {
		this.topicid = topicid;
	}

	public String getSubtopic() {
		return subtopic;
	}

	public void setSubtopic(String subtopic) {
		this.subtopic = subtopic;
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

	public String getExamtime() {
		return examtime;
	}

	public void setExamtime(String examtime) {
		this.examtime = examtime;
	}

	public String getTotalquestion() {
		return totalquestion;
	}

	public void setTotalquestion(String totalquestion) {
		this.totalquestion = totalquestion;
	}

	public String getQntypes() {
		return qntypes;
	}

	public void setQntypes(String qntypes) {
		this.qntypes = qntypes;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getGroupid() {
		return groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	public String getGroupcheckvalue() {
		return groupcheckvalue;
	}

	public void setGroupcheckvalue(String groupcheckvalue) {
		this.groupcheckvalue = groupcheckvalue;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLocationid() {
		return locationid;
	}

	public void setLocationid(String locationid) {
		this.locationid = locationid;
	}

	public String getLoactioncheckvalue() {
		return loactioncheckvalue;
	}

	public void setLoactioncheckvalue(String loactioncheckvalue) {
		this.loactioncheckvalue = loactioncheckvalue;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSubjectid() {
		return subjectid;
	}

	public void setSubjectid(String subjectid) {
		this.subjectid = subjectid;
	}

	public String getSubjectcheckvalue() {
		return subjectcheckvalue;
	}

	public void setSubjectcheckvalue(String subjectcheckvalue) {
		this.subjectcheckvalue = subjectcheckvalue;
	}

	public String getBranchid() {
		return branchid;
	}

	public void setBranchid(String branchid) {
		this.branchid = branchid;
	}

	public String getBranchcheckname() {
		return branchcheckname;
	}

	public void setBranchcheckname(String branchcheckname) {
		this.branchcheckname = branchcheckname;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getSectionid() {
		return sectionid;
	}

	public void setSectionid(String sectionid) {
		this.sectionid = sectionid;
	}

	public String getSectioncheckname() {
		return sectioncheckname;
	}

	public void setSectioncheckname(String sectioncheckname) {
		this.sectioncheckname = sectioncheckname;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
	}

	public String getQuestiontype() {
		return questiontype;
	}

	public void setQuestiontype(String questiontype) {
		this.questiontype = questiontype;
	}

	public String getQuestiontypeid() {
		return questiontypeid;
	}

	public void setQuestiontypeid(String questiontypeid) {
		this.questiontypeid = questiontypeid;
	}

	public int getMarksperqn() {
		return marksperqn;
	}

	public void setMarksperqn(int marksperqn) {
		this.marksperqn = marksperqn;
	}

	public String getFixedmarks() {
		return fixedmarks;
	}

	public void setFixedmarks(String fixedmarks) {
		this.fixedmarks = fixedmarks;
	}

	public String getExamname() {
		return examname;
	}

	public void setExamname(String examname) {
		this.examname = examname;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getSectionname() {
		return sectionname;
	}

	public void setSectionname(String sectionname) {
		this.sectionname = sectionname;
	}

	public String getSubjectname() {
		return subjectname;
	}

	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
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

	public String getStatename() {
		return statename;
	}

	public void setStatename(String statename) {
		this.statename = statename;
	}

	public int getStateid() {
		return stateid;
	}

	public void setStateid(int stateid) {
		this.stateid = stateid;
	}

	public String getQuestiontypecheckvalue() {
		return questiontypecheckvalue;
	}

	public void setQuestiontypecheckvalue(String questiontypecheckvalue) {
		this.questiontypecheckvalue = questiontypecheckvalue;
	}

	public int getTotalmarks() {
		return totalmarks;
	}

	public void setTotalmarks(int totalmarks) {
		this.totalmarks = totalmarks;
	}

	public String getAvailablestates() {
		return availablestates;
	}

	public void setAvailablestates(String availablestates) {
		this.availablestates = availablestates;
	}

	public String getSubtopicid() {
		return subtopicid;
	}

	public void setSubtopicid(String subtopicid) {
		this.subtopicid = subtopicid;
	}

	public String getQnleveltypecheckbox() {
		return qnleveltypecheckbox;
	}

	public void setQnleveltypecheckbox(String qnleveltypecheckbox) {
		this.qnleveltypecheckbox = qnleveltypecheckbox;
	}

	public String getQuestionlevel() {
		return questionlevel;
	}

	public void setQuestionlevel(String questionlevel) {
		this.questionlevel = questionlevel;
	}

	public String getExamtypeckeckbox() {
		return examtypeckeckbox;
	}

	public void setExamtypeckeckbox(String examtypeckeckbox) {
		this.examtypeckeckbox = examtypeckeckbox;
	}

	public String getExamtype_name() {
		return examtype_name;
	}

	public void setExamtype_name(String examtype_name) {
		this.examtype_name = examtype_name;
	}

	public String getExamtype_id() {
		return examtype_id;
	}

	public void setExamtype_id(String examtype_id) {
		this.examtype_id = examtype_id;
	}

	public String getHiddenstatename() {
		return hiddenstatename;
	}

	public void setHiddenstatename(String hiddenstatename) {
		this.hiddenstatename = hiddenstatename;
	}

	public String getHiddenlocationname() {
		return hiddenlocationname;
	}

	public void setHiddenlocationname(String hiddenlocationname) {
		this.hiddenlocationname = hiddenlocationname;
	}

	public String getHiddenstateid() {
		return hiddenstateid;
	}

	public void setHiddenstateid(String hiddenstateid) {
		this.hiddenstateid = hiddenstateid;
	}

	public String getHiddenclassname() {
		return hiddenclassname;
	}

	public void setHiddenclassname(String hiddenclassname) {
		this.hiddenclassname = hiddenclassname;
	}

	public String getSelectedexam() {
		return selectedexam;
	}

	public void setSelectedexam(String selectedexam) {
		this.selectedexam = selectedexam;
	}

	public String getSelectedstateids() {
		return selectedstateids;
	}

	public void setSelectedstateids(String selectedstateids) {
		this.selectedstateids = selectedstateids;
	}

	public String getSelectedlocationids() {
		return selectedlocationids;
	}

	public void setSelectedlocationids(String selectedlocationids) {
		this.selectedlocationids = selectedlocationids;
	}

	public String getSelectedbranchid() {
		return selectedbranchid;
	}

	public void setSelectedbranchid(String selectedbranchid) {
		this.selectedbranchid = selectedbranchid;
	}

	public String getSelectedquslevelid() {
		return selectedquslevelid;
	}

	public void setSelectedquslevelid(String selectedquslevelid) {
		this.selectedquslevelid = selectedquslevelid;
	}

	public String getSelectedclassid() {
		return selectedclassid;
	}

	public void setSelectedclassid(String selectedclassid) {
		this.selectedclassid = selectedclassid;
	}

	public String getSelectedsectionid() {
		return selectedsectionid;
	}

	public void setSelectedsectionid(String selectedsectionid) {
		this.selectedsectionid = selectedsectionid;
	}

	public String getSelectedsubjectid() {
		return selectedsubjectid;
	}

	public void setSelectedsubjectid(String selectedsubjectid) {
		this.selectedsubjectid = selectedsubjectid;
	}

	public String getSelectedsubjectqns() {
		return selectedsubjectqns;
	}

	public void setSelectedsubjectqns(String selectedsubjectqns) {
		this.selectedsubjectqns = selectedsubjectqns;
	}

	public String getSelectedtopics() {
		return selectedtopics;
	}

	public void setSelectedtopics(String selectedtopics) {
		this.selectedtopics = selectedtopics;
	}

	public String getSelectedtopicnames() {
		return selectedtopicnames;
	}

	public void setSelectedtopicnames(String selectedtopicnames) {
		this.selectedtopicnames = selectedtopicnames;
	}

	public String getSelectedqustype() {
		return selectedqustype;
	}

	public void setSelectedqustype(String selectedqustype) {
		this.selectedqustype = selectedqustype;
	}

	public String getFilenames() {
		return filenames;
	}

	public void setFilenames(String filenames) {
		this.filenames = filenames;
	}

	public int getPositivemarks() {
		return positivemarks;
	}

	public void setPositivemarks(int positivemarks) {
		this.positivemarks = positivemarks;
	}

	public List<String> getSelnegmarksperqntype() {
		return selnegmarksperqntype;
	}

	public void setSelnegmarksperqntype(List<String> selnegmarksperqntype) {
		this.selnegmarksperqntype = selnegmarksperqntype;
	}

	public String getNmarksperquestiontype() {
		return nmarksperquestiontype;
	}

	public void setNmarksperquestiontype(String nmarksperquestiontype) {
		this.nmarksperquestiontype = nmarksperquestiontype;
	}

	public String getQuestions() {
		return questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}

	public int getExamcount() {
		return examcount;
	}

	public void setExamcount(int examcount) {
		this.examcount = examcount;
	}

	public int getNegativemarks() {
		return negativemarks;
	}

	public void setNegativemarks(int negativemarks) {
		this.negativemarks = negativemarks;
	}

	public String getNegativemarks1() {
		return negativemarks1;
	}

	public void setNegativemarks1(String negativemarks1) {
		this.negativemarks1 = negativemarks1;
	}

	public List<String> getTopiclist() {
		return topiclist;
	}

	public void setTopiclist(List<String> topiclist) {
		this.topiclist = topiclist;
	}

}
