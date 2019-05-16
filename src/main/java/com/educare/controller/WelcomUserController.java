
package com.educare.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.educare.DatabaseValueController;
import com.educare.model.BookmarkPojo;
import com.educare.model.ExamCompletionState;
import com.educare.model.Instructionspojo;
import com.educare.model.LoginPojo;
import com.educare.model.QuestionPojo;
import com.educare.model.WelcomeUserFormPojo;
import com.educare.model.WelcomeUserPojo;
import com.educare.services.RegisterServiceImpl;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Controller
public class WelcomUserController {


	@Autowired
	private RegisterServiceImpl userservice;
	
	@Autowired
	private DatabaseValueController dv;
	
	String sidval="student_id";

	@RequestMapping("/load-welcomeUser")
	public String welcomUserController(Model model, HttpSession session, LoginPojo lp, WelcomeUserPojo wup,
			WelcomeUserFormPojo wp, QuestionPojo qup,HttpServletRequest req) {


		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(session,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		model.addAttribute("welcome", wup);
		String studentid = (String) session.getAttribute(sidval);
		/* Getting Student data based on Student id */
		List<LoginPojo> userdetails = userservice.getUserdetails(studentid);
		for (LoginPojo loginPojo : userdetails) {

			session.setAttribute("classname", loginPojo.getClassname());
			session.setAttribute("sectionname", loginPojo.getSection());
			session.setAttribute("branchname", loginPojo.getBarnch());
			session.setAttribute("username", loginPojo.getFirstname());
			session.setAttribute("state", loginPojo.getState());
			session.setAttribute("locationid", loginPojo.getLocationid());
		}


		return "welcomeUser";
	}

	@RequestMapping("load-userExamDashboard")
	public String userExamDashBoard(Model model, HttpSession session, LoginPojo lp, WelcomeUserPojo wup,HttpServletRequest req) {


		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(session,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		String studentid = (String) session.getAttribute(sidval);
		List<LoginPojo> userdetails = userservice.getUserdetails(studentid);
		String examnewstatus = null;
		String stateid = null;
		String locationid = null;
		String branchid = null;
		String classid = null;
		String sectionid = null;
		for (LoginPojo loginPojo : userdetails) {
			stateid = loginPojo.getState();
			locationid = loginPojo.getLocationid();
			branchid = loginPojo.getBarnch();
			classid = loginPojo.getClassname();
			sectionid = loginPojo.getSection();
		}

		List<QuestionPojo> questionlist = new ArrayList<>();
		List<QuestionPojo> examdata = userservice.getExams(stateid, locationid, branchid, classid, sectionid);

		System.out.println("examdata : "+examdata.size());
		
		String examname = null;
		List<ExamCompletionState> examstatus = null;
		for (QuestionPojo ques : examdata) {
			QuestionPojo questionpo = new QuestionPojo();
			List<String> subjectnames = new ArrayList<>();
			List<String> subjectids = new ArrayList<>();
			examname = ques.getExamname();
			questionpo.setExamname(examname);
			questionpo.setSubject(ques.getSubject());
			questionpo.setSlotdate(ques.getSlotdate());
			questionpo.setStarttime(ques.getStarttime());
			questionpo.setEnddate(ques.getEnddate());
			questionpo.setEndtime(ques.getEndtime());
			questionpo.setSubjectid(ques.getSubjectid());
			questionpo.setExam_type(ques.getExam_type());
			questionpo.setPatterntypeid(ques.getPatterntypeid());
			questionpo.setTestduration(ques.getTestduration());

			List<QuestionPojo> subjects = userservice.getSubjectnamesInSubjectTable(examname);
			/** Set Subject name list */
			int listsize = 1;
			for (QuestionPojo subj : subjects) {
				String subjnames = subj.getSubject_type();
				if (listsize == 1) {
					subjectnames.add(subjnames);
				}
				if ((listsize != 1)) {
					subjectnames.add("," + subjnames);
				}
				listsize++;
			}
			questionpo.setSublist(subjectnames);

			/** Set Subject id list */
			int listidsize = 1;
			for (QuestionPojo subj1 : subjects) {
				int subjids = subj1.getSubjectid();
				String subjidstring = String.valueOf(subjids);
				if (listidsize == 1) {
					subjectids.add(subjidstring);
				}
				if ((listidsize != 1)) {
					subjectids.add("," + subjidstring);
				}
				listidsize++;
			}
			questionpo.setSubidlist(subjectids);

			examstatus = userservice.getExamCompletionStatusQuery(studentid, stateid, locationid, branchid, classid,
					sectionid, examname);

			if (examstatus.isEmpty()) {
				examnewstatus = "false";
				questionpo.setExam_status(examnewstatus);
			}

			else {
				for (ExamCompletionState examComplete : examstatus) {

					String exstatus = examComplete.getExamn_status();
					questionpo.setExam_status(exstatus);
					if (exstatus.equals("start")) {
						examnewstatus = "start";
						questionpo.setExam_status(examnewstatus);
					} else {
						examnewstatus = "Finish";
					}
				}
			}

			questionlist.add(questionpo);
			model.addAttribute("examstatus", examnewstatus);
		}

		
		model.addAttribute("examdata", examdata);
		model.addAttribute("questionlist", questionlist);

		return "userExamDashboard";

	}
	
	
	
	
	

	@RequestMapping("/load-DashboardBookmarkquestions")
	public String dashboardBookmarkquestions(Model model, HttpSession session,HttpServletRequest req) {

		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(session,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		String sid = (String) session.getAttribute(sidval);
		List<BookmarkPojo> bookmarkQuestions = userservice.getBookmarkQuestions(sid);
		model.addAttribute("bques", bookmarkQuestions);


		return "bookmarkTestDashboard";
	}

	@RequestMapping("/load-DashboardInstructionForm")
	public @ResponseBody String dashboardInstructionForm(Model model, HttpSession session, HttpServletRequest req) {

		String examname = req.getParameter("exam_name");
		List<Instructionspojo> getdetails = userservice.getAllInstructionDetails(examname);

		String jsonResult = "";
		try {
			if (getdetails != null && !getdetails.isEmpty()) {
				JsonArray jsonArray = new JsonArray();
				for (Instructionspojo ebb : getdetails) {
					JsonObject jsonObject = new JsonObject();
					jsonObject.addProperty("subjectname", ebb.getSubjectname());
					jsonObject.addProperty("questiontype", ebb.getQuestiontype());
					jsonObject.addProperty("marksperqtype", ebb.getMarksperquestype());
					jsonObject.addProperty("negativemarks", ebb.getNegativemarks());
					jsonObject.addProperty("noofques", ebb.getNoofquestions());

					jsonArray.add(jsonObject);
				}
				jsonResult = jsonArray.toString();
			}
		} catch (Exception ex) {
			jsonResult = "";
		}
		model.addAttribute("details", getdetails);
		return jsonResult;
	}

	@RequestMapping("/load-Planandexecution")
	public String planningandExecution(Model model, HttpSession session, LoginPojo lp, WelcomeUserPojo wup,
			WelcomeUserFormPojo wp, QuestionPojo qup) {

		return "planningandExecution";
	}

	@RequestMapping("/load-staffrecruitment")
	public String staffRecruitmentandTraining(Model model, HttpSession session, LoginPojo lp, WelcomeUserPojo wup,
			WelcomeUserFormPojo wp, QuestionPojo qup) {

		return "staffrecruitment";
	}

	@RequestMapping("/load-onlineexamportal")
	public String onlineExamPortal(Model model, HttpSession session, LoginPojo lp, WelcomeUserPojo wup,
			WelcomeUserFormPojo wp, QuestionPojo qup) {

		return "onlineexamportal";
	}

	@RequestMapping("/load-material")
	public String material(Model model, HttpSession session, LoginPojo lp, WelcomeUserPojo wup, WelcomeUserFormPojo wp,
			QuestionPojo qup) {

		return "material";
	}
	
	@RequestMapping("/load-clients")
	public String clients(Model model, HttpSession session, LoginPojo lp, WelcomeUserPojo wup, WelcomeUserFormPojo wp,
			QuestionPojo qup) {
		
		return "clients";
	}
	
	
	
}
