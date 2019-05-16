package com.educare.admin.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.educare.DatabaseValueController;
import com.educare.admin.model.AdminCategory;
import com.educare.admin.model.AdminFormSetExamPojo;
import com.educare.admin.model.AdminSetExamPojo;
import com.educare.controller.LoginController;
import com.educare.model.QuestionPojo;
import com.educare.services.AdminRegisterServiceImpl;
import com.educare.services.RegisterServiceImpl;

@Controller
public class AdminCreateExamController {

	private static final Logger logger = LoggerFactory.getLogger(AdminCreateExamController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private RegisterServiceImpl userservice;
	
	@Autowired
	private DatabaseValueController dv;

	@Autowired
	private LoginController lc;
	private int examavailable = 0;

	@Value("${exam.withslot}")
	String isslotNo;

	String sidval = "student_id";
	String setexamval = "setexam";

	@RequestMapping("/load-SetExamform")
	public String createExams(Model model, AdminCategory ad, HttpServletRequest req, HttpSession ses) {

		String start = "Entry of CreateExams method....";
		String end = "End of CreateExams method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		List<AdminCategory> statenames = adminuserservice.searchStateFromAdmin();
		List<AdminCategory> classnames = adminuserservice.searchClassesFromAdmin();
		List<AdminCategory> location = adminuserservice.searchLocationsFromAdmin();
		List<AdminCategory> bracnh = adminuserservice.searchBranchesFromAdmin();
		List<AdminCategory> seciton = adminuserservice.searchSectionFromAdmin();
		List<AdminCategory> subject = adminuserservice.searchSubjectFromAdmin();
		List<AdminCategory> questiontype = adminuserservice.searchQuestiontypeFromAdmin();
		List<AdminCategory> examtypeslist = adminuserservice.searchexamtypesFromAdmin();
		List<AdminCategory> questionlevelslist = adminuserservice.searchquestionleveltypesFromAdmin();

		model.addAttribute("statenames", statenames);
		model.addAttribute("questiontype", questiontype);
		model.addAttribute("subjectval", subject);
		model.addAttribute("secitonnameval", seciton);
		model.addAttribute("bracnh", bracnh);
		model.addAttribute("stateval", location);
		model.addAttribute("classnames", classnames);
		model.addAttribute("examtypeslist", examtypeslist);
		model.addAttribute("questionlevelslist", questionlevelslist);

		model.addAttribute(setexamval, ad);

		logger.info(end);

		return "AdminCreateExam2";
	}

	@RequestMapping("/get-sectiondetailsfromClass")
	public String getsectiondetailsfromselectedClass(Model model, AdminCategory adc, HttpSession ses,
			HttpServletRequest req) {

		String start = "Entry of getsectiondetailsfromselectedClass method....";
		String end = "End of getsectiondetailsfromselectedClass method....";
		logger.info(start);

		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		model.addAttribute(setexamval, adc);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		String classids = req.getParameter("classid");
		if (classids != null) {
			int classid = (new Integer(classids)).intValue();
			List<AdminCategory> sectiondetails = adminuserservice.getsectionsfromClass(classid);

			model.addAttribute("sectiondetails", sectiondetails);
		}

		logger.info(end);

		return "AdminCreateExam2";
	}

	@RequestMapping(value = "/load-getSubjectsfromClasses")
	public @ResponseBody List<AdminCategory> getSubjecTypess(Model model, AdminCategory ad, HttpServletRequest req,
			HttpSession ses) {

		String start = "Entry of getSubjecTypess method....";
		String end = "End of getSubjecTypess method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);

		model.addAttribute(setexamval, ad);
		String classids = req.getParameter("classid");
		int classid = 0;
		if (classids != null) {
			classid = Integer.valueOf(classids);
		}
		List<AdminCategory> subjects = adminuserservice.getsubjectsfromClass(classid);
		model.addAttribute("subjects", subjects);

		logger.info(end);

		return subjects;
	}

	@RequestMapping("load-GetTopicsforSubjects")
	public @ResponseBody List<AdminSetExamPojo> getTopicsinSubjs(Model model, AdminFormSetExamPojo adf,
			AdminSetExamPojo ad, HttpServletRequest req, HttpSession ses) {

		String start = "Entry of getTopicsinSubjs method....";
		String end = "End of getTopicsinSubjs method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		String subjecttypeid = req.getParameter("subjectid");
		String examtypeid = req.getParameter("examtypeid");
		if (subjecttypeid.equals("")) {
			subjecttypeid = "0";
		}
		if (examtypeid.equals("")) {
			examtypeid = "0";
		}
		List<AdminSetExamPojo> topics = adminuserservice.gettopicsinsubject(subjecttypeid, examtypeid);
		model.addAttribute("tpoics", ad);
		model.addAttribute("subjectstpoics", topics);

		logger.info(end);

		return topics;
	}

	@RequestMapping("load-getSubtopicsinSubjects")
	public @ResponseBody List<AdminSetExamPojo> getSubTopicsinSubjs(Model model, AdminFormSetExamPojo adf,
			AdminSetExamPojo ad, HttpServletRequest req, HttpSession ses) {

		String start = "Entry of getSubTopicsinSubjs method....";
		String end = "End of getSubTopicsinSubjs method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		String examtypeid = req.getParameter("examtypeid");
		String subjid = req.getParameter("subjid");
		String topicid = req.getParameter("topicid");
		List<AdminSetExamPojo> subtopics = null;

		if (topicid.equals("")) {
			topicid = "0";
		}

		if (topicid.contains("All Topics")) {
			subtopics = adminuserservice.getAllsubtopicsinsubject(examtypeid, subjid);

		} else {
			subtopics = adminuserservice.getsubtopicsinsubject(examtypeid, subjid, topicid);
		}

		model.addAttribute("stpoics", ad);
		model.addAttribute("subtopics", subtopics);

		logger.info(end);

		return subtopics;
	}

	@RequestMapping(value = "/insert-ProcessExamForm", method = RequestMethod.POST)
	public String insertgivenExam(Model model, AdminCategory ad, HttpServletRequest req, HttpSession ses)
			throws ParseException {

		String start = "Entry of insertgivenExam method....";
		String end = "End of insertgivenExam method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";

		String fixedmarks = ad.getFixedmarks();
		String examname = ad.getExamname().trim().toUpperCase();
		String statechckbox = ad.getStatechckbox();
		// location = state
		String state = ad.getState();
		String branch = ad.getBranch();
		String classname = ad.getClassname();
		String sectionname = ad.getSectionname();
		String subjectname = ad.getSubjectname();
		String[] spltsubtypes = null;

		String examtypeids = ad.getExamtypeselectbox();
		int examtypeid = (new Integer(examtypeids)).intValue();

		String questionlevelid = ad.getQnleveltypecheckbox();
		String questiontypeid = ad.getQntypes();

		String startdate = ad.getStartdate();
		String enddate = ad.getEnddate();
		String starttime1 = ad.getStarttime();
		String endtime1 = ad.getEndtime();
		String examtime = ad.getExamtime();
		int marksperqn = ad.getMarksperqn();
		String negativemarks = ad.getNegativemarks1();
		int totalmarks = 0;

		String starttime = starttime1.concat(":00");
		String endtime = endtime1.concat(":00");

		String[] splqustype = null;
		if (questiontypeid != null) {
			splqustype = questiontypeid.split(",");
		}

		if (subjectname != null) {
			spltsubtypes = subjectname.split(",");
		}
		int noofqnsperqntype = 0;
		int toatlStdsAvailable = 0;
		String negativemarksperqustype = "0";
		List<QuestionPojo> userexam = null;

		for (int k = 0; k <= spltsubtypes.length - 1; k++) {
			// get subject type id
			String getsubjecttypeids = spltsubtypes[k];
			int spltsubjecttypeid = (new Integer(getsubjecttypeids)).intValue();

			// get topic ids based on subject id
			String[] tids = req.getParameterValues("topic_" + getsubjecttypeids);
			StringBuffer topids = new StringBuffer();
			for (String str : tids) {
				topids.append(str + ",");
			}
			String topicjoined1 = topids.toString();
			String topicjoined = topicjoined1.substring(0, topicjoined1.length() - 1);
			if(topicjoined.contains("All Topics")){
				topicjoined=adminuserservice.getAllTopicIds(getsubjecttypeids,examtypeid);
			}

			// get sub topic ids based on subject id
			String[] stids = req.getParameterValues("subtopic_" + getsubjecttypeids);
			StringBuffer stopids = new StringBuffer();
			for (String str : stids) {
				stopids.append(str + ",");
			}
			String subjoinedsubtopicids1 = stopids.toString();
			String subjoinedsubtopicids = subjoinedsubtopicids1.substring(0, subjoinedsubtopicids1.length() - 1);
			if(subjoinedsubtopicids.contains("All STopics")){
				subjoinedsubtopicids=adminuserservice.getAllSubTopicIds(getsubjecttypeids,examtypeid);
			}
			
			
			// get subject type questions

			for (int j = 0; j <= splqustype.length - 1; j++) {
				String spltquestiontypeid = splqustype[j];
				int questiontypeidvalue = (new Integer(spltquestiontypeid)).intValue();
				// get question type questions
				String qnsfromquestiontype = req.getParameter(getsubjecttypeids + "_" + spltquestiontypeid);
				int spltqnsfromquestiontype = (new Integer(qnsfromquestiontype)).intValue();
				// get question type marks if fixedmarks no
				if (fixedmarks.equals("no")) {
					String marksfromquestiontype = req.getParameter(getsubjecttypeids + "_marks_" + spltquestiontypeid);
					String negmarksfromquestiontype = req
							.getParameter(getsubjecttypeids + "_negmarks_" + spltquestiontypeid);
					noofqnsperqntype = Integer.valueOf(marksfromquestiontype);
					negativemarksperqustype = negmarksfromquestiontype;
					userexam = userservice.getAllQuestionsfromtable(examtypeid, spltsubjecttypeid, questionlevelid,
							questiontypeidvalue, topicjoined, subjoinedsubtopicids, spltqnsfromquestiontype);
					if (!userexam.isEmpty()) {

						totalmarks = spltqnsfromquestiontype * noofqnsperqntype;
						toatlStdsAvailable = adminuserservice.getCountOfTotalStudentsAvailable(classname, sectionname,
								branch, statechckbox, state);
						adminuserservice.insertcreatedExaminexamTable(examname, statechckbox, state, branch, classname,
								sectionname, spltsubjecttypeid, topicjoined, subjoinedsubtopicids, questiontypeidvalue,
								questionlevelid, examtypeid, startdate, enddate, starttime, endtime, examtime,
								noofqnsperqntype, marksperqn, negativemarksperqustype, totalmarks, toatlStdsAvailable,
								spltqnsfromquestiontype, fixedmarks, isslotNo);
						examavailable++;
					}
					for (QuestionPojo questionPojo : userexam) {
						String qno = questionPojo.getQuestion_id();
						int qid = (new Integer(qno)).intValue();
						userservice.insertQuestionsForTestExams(examname, qid, statechckbox, state, branch, classname,
								sectionname, spltsubjecttypeid, topicjoined, subjoinedsubtopicids, questiontypeidvalue,
								startdate, enddate, starttime, endtime, examtime, noofqnsperqntype, totalmarks,
								negativemarksperqustype, toatlStdsAvailable, questionlevelid, examtypeid, isslotNo);
						int maxid = userservice.getMaxExampaperid();
						userservice.insertQuestionsForTestExams1(examname, qid, statechckbox, state, branch, classname,
								sectionname, spltsubjecttypeid, topicjoined, subjoinedsubtopicids, questiontypeidvalue,
								startdate, enddate, starttime, endtime, examtime, noofqnsperqntype, totalmarks,
								negativemarksperqustype, toatlStdsAvailable, questionlevelid, examtypeid, maxid,
								isslotNo);

						examavailable++;
					}
				}

				if (fixedmarks.equals("yes")) {
					noofqnsperqntype = marksperqn;
					userexam = userservice.getAllQuestionsfromtable(examtypeid, spltsubjecttypeid, questionlevelid,
							questiontypeidvalue, topicjoined, subjoinedsubtopicids, spltqnsfromquestiontype);
					if (!userexam.isEmpty()) {
						totalmarks = spltqnsfromquestiontype * noofqnsperqntype;
						toatlStdsAvailable = adminuserservice.getCountOfTotalStudentsAvailable(classname, sectionname,
								branch, statechckbox, state);
						adminuserservice.insertcreatedExaminexamTable(examname, statechckbox, state, branch, classname,
								sectionname, spltsubjecttypeid, topicjoined, subjoinedsubtopicids, questiontypeidvalue,
								questionlevelid, examtypeid, startdate, enddate, starttime, endtime, examtime,
								noofqnsperqntype, marksperqn, negativemarks, totalmarks, toatlStdsAvailable,
								spltqnsfromquestiontype, fixedmarks, isslotNo);
						examavailable++;
					}

					for (QuestionPojo questionPojo : userexam) {
						String qno = questionPojo.getQuestion_id();
						int qid = (new Integer(qno)).intValue();
						userservice.insertQuestionsForTestExams(examname, qid, statechckbox, state, branch, classname,
								sectionname, spltsubjecttypeid, topicjoined, subjoinedsubtopicids, questiontypeidvalue,
								startdate, enddate, starttime, endtime, examtime, noofqnsperqntype, totalmarks,
								negativemarks, toatlStdsAvailable, questionlevelid, examtypeid, isslotNo);
						int maxid = userservice.getMaxExampaperid();
						userservice.insertQuestionsForTestExams1(examname, qid, statechckbox, state, branch, classname,
								sectionname, spltsubjecttypeid, topicjoined, subjoinedsubtopicids, questiontypeidvalue,
								startdate, enddate, starttime, endtime, examtime, noofqnsperqntype, totalmarks,
								negativemarks, toatlStdsAvailable, questionlevelid, examtypeid, maxid, isslotNo);
						examavailable++;
					}
				}
			}
		}

		logger.info(end);

		return "redirect:/finalCreatedExam";
	}

	@RequestMapping(value = "/finalCreatedExam", method = RequestMethod.GET)
	public String finalCreateExamPage(Model model, HttpServletRequest req, HttpSession ses) {
		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		String smsg = null;
		String emsg = null;
		if (examavailable > 0) {
			smsg = "Exam created successfully";
		} else {

			emsg = "There is no questions available for given criteria!";
		}
		model.addAttribute("smsg", smsg);
		model.addAttribute("emsg", emsg);
		return "AdminSuccessCreateExam";
	}

	@ResponseBody
	@RequestMapping(value = "/verify-examnamealreadyExists", method = RequestMethod.POST)
	public void validateExamnamevalues(Model model, AdminCategory ad, HttpServletRequest req, HttpSession ses,
			HttpServletResponse response) {

		String start = "Entry of validateExamnamevalues method....";
		String end = "End of validateExamnamevalues method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		String examnamevalue = req.getParameter("examnamevalue");

		examnamevalue = examnamevalue.trim();
		examnamevalue = examnamevalue.toLowerCase();
		String examname = null;

		List<Map<String, Object>> getotbfromdb = adminuserservice.validateExamnameinelexamtable(examnamevalue);
		if (!getotbfromdb.isEmpty()) {
			for (Map<String, Object> map : getotbfromdb) {
				examname = (String) map.get("exam_name");
				examname = examname.toLowerCase().trim();
			}
		} else {

			try {
				response.getWriter().write("Please enter valid exam name");
			} catch (IOException e) {

			}

		}

		if (examnamevalue.equals(examname)) {

			try {
				response.getWriter().write("Exam name already exists. Please try with other name");
			} catch (IOException e) {

			}

		}

		else {
			try {
				response.getWriter().write("Entered exam name is valid");
			} catch (IOException e) {

			}
		}

		logger.info(end);
	}

	@ResponseBody
	@RequestMapping(value = "/load-compareQuestionscount")
	public int getQuestionsCount(Model model, HttpServletRequest req, HttpSession ses, HttpServletResponse res) {
		String etid = req.getParameter("etid");
		int examtypeid=(new Integer(etid)).intValue();
		String subid = req.getParameter("subid");
		String questiontypeids = req.getParameter("questiontypeids");
		String topicids = req.getParameter("topicids");
		/**** get all topics ***/
		if(topicids.contains("All Topics")){
			topicids=adminuserservice.getAllTopicIds(subid,examtypeid);
		}
		/*** get all sub topics ***/
		String subtopicids = req.getParameter("subtopicids");
		if(subtopicids.contains("All STopics")){
			subtopicids=adminuserservice.getAllSubTopicIds(subid,examtypeid);
		}
		String qlevelids1 = req.getParameter("qlevelids");
		String qlevelids=null;
		if(qlevelids1.equals("")){
			 qlevelids="0";
		}else{
			qlevelids = qlevelids1.substring(0, qlevelids1.length() - 1);
		}
		String subjectquestions = req.getParameter("subjectquestions");
		if (subjectquestions.equals("")) {
			subjectquestions = "0";
		}
		return userservice.getCompareQuestionsCount(subid, questiontypeids, subtopicids, topicids, qlevelids, etid,
				subjectquestions);
	}

}
