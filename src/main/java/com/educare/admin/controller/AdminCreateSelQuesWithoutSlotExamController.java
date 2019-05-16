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
public class AdminCreateSelQuesWithoutSlotExamController {

	private static final Logger logger = LoggerFactory.getLogger(AdminCreateExamWithSelectedQuestionsController.class);

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

	@RequestMapping("load-createSelQuesWithoutslotExam")
	public String selectedQuestionsExam(Model model, HttpSession ses, AdminCategory ad,HttpServletRequest req) {
		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		List<AdminCategory> examtypeslist = adminuserservice.searchexamtypesFromAdmin();
		List<AdminCategory> statenames = adminuserservice.searchStateFromAdmin();
		List<AdminCategory> classnames = adminuserservice.searchClassesFromAdmin();
		List<AdminCategory> location = adminuserservice.searchLocationsFromAdmin();
		List<AdminCategory> bracnh = adminuserservice.searchBranchesFromAdmin();
		List<AdminCategory> seciton = adminuserservice.searchSectionFromAdmin();

		model.addAttribute("examtypeslist", examtypeslist);
		model.addAttribute("statenames", statenames);
		model.addAttribute("classnames", classnames);
		model.addAttribute("stateval", location);
		model.addAttribute("bracnh", bracnh);
		model.addAttribute("secitonnameval", seciton);

		model.addAttribute("setselectedquesexam", ad);

		return "AdminCreateSelQuesWithoutSlotExam";

	}

	@RequestMapping(value = "/insert-withoutSlotSelQuesExam", method = RequestMethod.POST)
	public String insertSelectedgivenExam(Model model, AdminCategory ad, HttpServletRequest req, HttpSession ses)
			throws ParseException {

		logger.info("Entry of insertSelectedgivenExam method....");
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		String examname = ad.getExamname().trim().toUpperCase();
		String examtypeids = ad.getExamtypeselectbox();
		int examtypeid = (new Integer(examtypeids)).intValue();
		String statechckbox = ad.getStatechckbox();
		// location = state
		String state = ad.getState();
		String branch = ad.getBranch();
		String classname = ad.getClassname();
		String sectionname = ad.getSectionname();
		String subjectids = ad.getSubjectname();
		String[] spltsubtypes = null;
		String filenames = ad.getFilenames();

		String startdate = ad.getEnddate();
		String enddate = ad.getEnddate();
		String starttime = ad.getExamtime();
		String endtime = ad.getExamtime();
		String examtime = ad.getExamtime();
		int toatlStdsAvailable = 0;
		int questiontypeidvalue = 0;

		String topicids = adminuserservice.getTopicsForSelectedQuestions(filenames);
		String subtopicids = adminuserservice.getSubTopicsForSelectedQuestions(filenames);
		String questiontypeids = adminuserservice.getQuesidsForSelectedQuestions(filenames);
		String questionlevelids = adminuserservice.getQuslvlIdsForSelectedQuestions(filenames);
		String fixedmarks = "no";
		String[] splqustype = null;
		if (questiontypeids != null) {
			splqustype = questiontypeids.split(",");
		}

		if (subjectids != null) {
			spltsubtypes = subjectids.split(",");
		}

		List<QuestionPojo> userexam = null;
		int totalsubjectcount = 0;
		int marksperqtype = 0;
		int subjcountforquestion = 0;
		String negativemarksvalue = "0";

		for (int k = 0; k <= spltsubtypes.length - 1; k++) {
			// get subject type id
			String getsubjecttypeids = spltsubtypes[k];
			int spltsubjecttypeid = (new Integer(getsubjecttypeids)).intValue();
			for (int j = 0; j <= splqustype.length - 1; j++) {
				String spltquestiontypeid = splqustype[j].trim();
				questiontypeidvalue = Integer.valueOf(spltquestiontypeid);
				String marksperquestype = req.getParameter(spltsubjecttypeid + "_" + questiontypeidvalue + "_qtmarks");
				if (marksperquestype != null) {
					marksperqtype = Integer.valueOf(marksperquestype);
				}
				String negativemarksperquestype = req
						.getParameter(spltsubjecttypeid + "_" + questiontypeidvalue + "_negmarks");
				if (negativemarksperquestype != null) {
					negativemarksvalue = negativemarksperquestype;
				}
				String subjectquestioncount = req
						.getParameter(spltsubjecttypeid + "_" + questiontypeidvalue + "_qnscnt");
				if (subjectquestioncount != null) {
					subjcountforquestion = Integer.valueOf(subjectquestioncount);
				}

				totalsubjectcount = marksperqtype * subjcountforquestion;

				userexam = adminuserservice.getAllSelectedQuestions(filenames, spltsubjecttypeid, questiontypeidvalue);
				if (!userexam.isEmpty()) {
					toatlStdsAvailable = adminuserservice.getCountOfTotalStudentsAvailable(classname, sectionname,
							branch, statechckbox, state);
					adminuserservice.insertcreatedExaminexamTable(examname, statechckbox, state, branch, classname,
							sectionname, spltsubjecttypeid, topicids, subtopicids, questiontypeidvalue,
							questionlevelids, examtypeid, startdate, enddate, starttime, endtime, examtime,
							marksperqtype, subjcountforquestion, negativemarksvalue, totalsubjectcount,
							toatlStdsAvailable, subjcountforquestion, fixedmarks, isslotNo);
					examavailable++;
				}
				for (QuestionPojo questionPojo : userexam) {
					String qno = questionPojo.getQuestion_id();
					int qid = (new Integer(qno)).intValue();
					userservice.insertQuestionsForTestExams(examname, qid, statechckbox, state, branch, classname,
							sectionname, spltsubjecttypeid, topicids, subtopicids, questiontypeidvalue, startdate,
							enddate, starttime, endtime, examtime, marksperqtype, totalsubjectcount, negativemarksvalue,
							toatlStdsAvailable, questionlevelids, examtypeid, isslotNo);
					int maxid = userservice.getMaxExampaperid();
					userservice.insertQuestionsForTestExams1(examname, qid, statechckbox, state, branch, classname,
							sectionname, spltsubjecttypeid, topicids, subtopicids, questiontypeidvalue, startdate,
							enddate, starttime, endtime, examtime, marksperqtype, totalsubjectcount, negativemarksvalue,
							toatlStdsAvailable, questionlevelids, examtypeid, maxid, isslotNo);

					examavailable++;
				}

			}

		}

		return "redirect:/load-withoutSlotSelQuesCreatedExam";

	}

	@RequestMapping(value = "/load-withoutSlotSelQuesCreatedExam", method = RequestMethod.GET)
	public String finalCreateExamPage(Model model, HttpServletRequest req, HttpSession ses) {
		String studentid = (String) ses.getAttribute("student_id");
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
		return "AdminSuccessWithOutSlotCreateExam";
	}

}
