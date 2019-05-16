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
import org.springframework.web.bind.annotation.RequestMethod;

import com.educare.DatabaseValueController;
import com.educare.admin.model.AdminCategory;
import com.educare.controller.LoginController;
import com.educare.model.QuestionPojo;
import com.educare.services.AdminRegisterServiceImpl;
import com.educare.services.RegisterServiceImpl;

@Controller
public class AdminInsertCopyExamController {
	private static final Logger logger = LoggerFactory.getLogger(AdminCreateExamController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private RegisterServiceImpl userservice;

	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;
	
	@Value("${exam.withslot}")
	String isslotNo;
	
	private int examavailable = 0;

	@RequestMapping(value = "insert-copyExamForm", method = RequestMethod.POST)
	public String insertCopyExam(Model model, AdminCategory ad, HttpServletRequest req, HttpSession ses)
			throws ParseException {

		String start = "Entry of insertCopyExam method....";
		String end = "Entry of insertCopyExam method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute("student_id");
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
		String topicvids = null;
		String subtopicvids = null;

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
		int totalMarks = 0;

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
			
			/******* Topics  *******/
			String topicval=req.getParameter("ttlTopicids");
			String topicjoinedval = topicval.substring(0, topicval.length() - 1);
			String[] topicSplt=topicjoinedval.split("@");
			for (int i = 0; i < topicSplt.length; i++) {
				String topicids=topicSplt[i];
				String[] topicvalSplt=topicids.split("-");
				for (int j = 0; j < topicvalSplt.length; j++) {
					String subjid = topicvalSplt[1];
					if(getsubjecttypeids.equals(subjid)){
						topicvids = topicvalSplt[0];
					}
				}
			}
			
			/******* Sub Topics  *******/
			String subtopicval=req.getParameter("ttlStopicids");
			String subtopicjoinedval=subtopicval.substring(0, subtopicval.length() - 1);
			String[] subTopicSplt=subtopicjoinedval.split("@");
			for (int i = 0; i < subTopicSplt.length; i++) {
				String subtopicids=subTopicSplt[i];
				String[] subTopicvalSplt=subtopicids.split("-");
				for (int j = 0; j < subTopicvalSplt.length; j++) {
					String subjid = subTopicvalSplt[1];
					if(getsubjecttypeids.equals(subjid)){
						subtopicvids = subTopicvalSplt[0];
					}
				}
			}
			
			int spltsubjecttypeid = (new Integer(getsubjecttypeids)).intValue();
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
					if (marksfromquestiontype != null) {
						noofqnsperqntype = Integer.valueOf(marksfromquestiontype);
					}
					if (negmarksfromquestiontype != null) {
						negativemarksperqustype = negmarksfromquestiontype;
					}
					userexam = userservice.getAllQuestionsfromtable(examtypeid, spltsubjecttypeid, questionlevelid,
							questiontypeidvalue, topicvids, subtopicvids, spltqnsfromquestiontype);
					if (!userexam.isEmpty()) {
						totalMarks = spltqnsfromquestiontype * noofqnsperqntype;
						toatlStdsAvailable = adminuserservice.getCountOfTotalStudentsAvailable(classname, sectionname,
								branch, statechckbox, state);
						adminuserservice.insertcreatedExaminexamTable(examname, statechckbox, state, branch, classname,
								sectionname, spltsubjecttypeid, topicvids, subtopicvids, questiontypeidvalue, questionlevelid,
								examtypeid, startdate, enddate, starttime, endtime, examtime, noofqnsperqntype,
								marksperqn, negativemarksperqustype, totalMarks, toatlStdsAvailable,
								spltqnsfromquestiontype, fixedmarks, isslotNo);
						examavailable++;
					}
					for (QuestionPojo questionPojo : userexam) {
						String qno = questionPojo.getQuestion_id();
						int qid = (new Integer(qno)).intValue();
						userservice.insertQuestionsForTestExams(examname, qid, statechckbox, state, branch, classname,
								sectionname, spltsubjecttypeid, topicvids, subtopicvids, questiontypeidvalue, startdate,
								enddate, starttime, endtime, examtime, noofqnsperqntype, totalMarks,
								negativemarksperqustype, toatlStdsAvailable, questionlevelid, examtypeid, isslotNo);
						int maxid = userservice.getMaxExampaperid();
						userservice.insertQuestionsForTestExams1(examname, qid, statechckbox, state, branch, classname,
								sectionname, spltsubjecttypeid, topicvids, subtopicvids, questiontypeidvalue, startdate,
								enddate, starttime, endtime, examtime, noofqnsperqntype, totalMarks,
								negativemarksperqustype, toatlStdsAvailable, questionlevelid, examtypeid, maxid,
								isslotNo);

						examavailable++;
					}
				}

				if (fixedmarks.equals("yes")) {
					noofqnsperqntype = marksperqn;
					userexam = userservice.getAllQuestionsfromtable(examtypeid, spltsubjecttypeid, questionlevelid,
							questiontypeidvalue, topicvids, subtopicvids, spltqnsfromquestiontype);
					if (!userexam.isEmpty()) {
						totalMarks = spltqnsfromquestiontype * noofqnsperqntype;
						toatlStdsAvailable = adminuserservice.getCountOfTotalStudentsAvailable(classname, sectionname,
								branch, statechckbox, state);
						adminuserservice.insertcreatedExaminexamTable(examname, statechckbox, state, branch, classname,
								sectionname, spltsubjecttypeid, topicvids, subtopicvids, questiontypeidvalue, questionlevelid,
								examtypeid, startdate, enddate, starttime, endtime, examtime, noofqnsperqntype,
								marksperqn, negativemarks, totalMarks, toatlStdsAvailable, spltqnsfromquestiontype,
								fixedmarks, isslotNo);
						examavailable++;
					}

					for (QuestionPojo questionPojo : userexam) {
						String qno = questionPojo.getQuestion_id();
						int qid = (new Integer(qno)).intValue();
						userservice.insertQuestionsForTestExams(examname, qid, statechckbox, state, branch, classname,
								sectionname, spltsubjecttypeid, topicvids, subtopicvids, questiontypeidvalue, startdate,
								enddate, starttime, endtime, examtime, noofqnsperqntype, totalMarks, negativemarks,
								toatlStdsAvailable, questionlevelid, examtypeid, isslotNo);
						int maxid = userservice.getMaxExampaperid();
						userservice.insertQuestionsForTestExams1(examname, qid, statechckbox, state, branch, classname,
								sectionname, spltsubjecttypeid, topicvids, subtopicvids, questiontypeidvalue, startdate,
								enddate, starttime, endtime, examtime, noofqnsperqntype, totalMarks, negativemarks,
								toatlStdsAvailable, questionlevelid, examtypeid, maxid, isslotNo);
						examavailable++;
					}
				}
			}
		}

		logger.info(end);

		return "redirect:/finalCopyCreatedExam";
	}

	@RequestMapping(value = "/finalCopyCreatedExam", method = RequestMethod.GET)
	public String finalCopyExamPage(Model model, HttpServletRequest req, HttpSession ses) {
		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		String smsg = null;
		String emsg = null;

		if (examavailable > 0) {
			smsg = "Copy Exam created successfully";
		} else {

			emsg = "There is no questions available for given criteria!";
		}
		model.addAttribute("smsg", smsg);
		model.addAttribute("emsg", emsg);
		return "AdminSuccessCopyCreateExam";
	}

}
