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
import com.educare.model.ExamCompletionState;
import com.educare.model.LoginPojo;
import com.educare.model.QuestionPojo;
import com.educare.model.WelcomeUserPojo;
import com.educare.services.RegisterServiceImpl;

@Controller
public class WelcomeSlotUserController {

	@Autowired
	private RegisterServiceImpl userservice;
	
	@Autowired
	private DatabaseValueController dv;
	
	@RequestMapping("load-userExamSlotDashboard")
	public String userExamSlotDashboard(Model model, HttpSession session, LoginPojo lp, WelcomeUserPojo wup,HttpServletRequest req) {

		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(session,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";

		String studentid = (String) session.getAttribute("student_id");
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
		List<QuestionPojo> examdata = userservice.getExams1(stateid, locationid, branchid, classid, sectionid);

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
						questionpo.setExamenddate(examComplete.getExenddate());
						questionpo.setExamendtime(examComplete.getExendtime());
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
		
		

		return "userSlotExamDashboard";

	}
	
	@RequestMapping("/load-getExamPattrenId")
	
	private @ResponseBody int getExamPattrenId(HttpServletRequest req){
		
		String examname=req.getParameter("exam_name");
		
		int examtypeid = userservice.getExamTypeIdBasedOnExamName(examname);
		return   userservice.getPatternIdBasedOnExamType(examtypeid);
		
	}
	
	
}
