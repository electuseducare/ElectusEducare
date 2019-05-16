package com.educare.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.educare.DatabaseValueController;
import com.educare.admin.model.AdminCategory;
import com.educare.controller.LoginController;
import com.educare.model.QuestionPojo;
import com.educare.services.AdminRegisterServiceImpl;
import com.educare.services.RegisterServiceImpl;

@Controller
public class AdminCreateExamWithoutSlotController {
	private static final Logger logger = LoggerFactory.getLogger(AdminCreateExamWithoutSlotController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private RegisterServiceImpl userservice;

	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;

	private int examavailable = 0;

	@Value("${exam.withoutslot}")
	String isslotNo;

	String sidval = "student_id";

	@RequestMapping("/load-SetExamformwslot")
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

		model.addAttribute("setexam", ad);

		logger.info(end);

		return "AdminCreateExamWithoutSlot";
	}

	@RequestMapping("/insert-ProcessExamFormwithoutslot")
	public String insertGivenExam(Model model, AdminCategory ad, HttpServletRequest req, HttpSession ses)
			throws ParseException {

		String start = "Entry of insertGivenExam method....";
		String end = "End of insertGivenExam method....";
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

		String startdate = ad.getEnddate();
		String enddate = ad.getEnddate();
		String starttime = ad.getExamtime();
		String endtime = ad.getExamtime();
		String examtime = ad.getExamtime();
		int marksperqn = ad.getMarksperqn();
		String negativemarks = ad.getNegativemarks1();
		int totalmarks = 0;

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

		return "redirect:/finalCreatedExamwithoutslot";
	}

	@RequestMapping("/finalCreatedExamwithoutslot")
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
		return "AdminSuccessCreateExamWithoutSlot";
	}

}
