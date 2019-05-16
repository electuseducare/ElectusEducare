package com.educare.admin.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.educare.DatabaseValueController;
import com.educare.admin.model.Adminofflinedatapojo;
import com.educare.controller.LoginController;
import com.educare.services.AdminRegisterServiceImpl;

@Controller
public class AdminOfflineResultsCalculationController {

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;
	
	private int resultscal = 0;
	
	String sidval="student_id";

	@RequestMapping("/load-ExamNameforoffline")
	public String offlineresults(Model model, Adminofflinedatapojo adc, HttpSession ses,HttpServletRequest req) {

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		String isresult = "no";
		List<Adminofflinedatapojo> examlist = adminuserservice.getExamNameforoffline(isresult);

		model.addAttribute("examlist", examlist);
		model.addAttribute("adminreport", adc);

		return "ExamNameforoflineresults";
	}

	@RequestMapping("/processofflinereports")
	public String processofflinereports(Model model, Adminofflinedatapojo adc, HttpSession ses,
			HttpServletRequest req) {
		String studentid1 = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid1);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";

		String examname = req.getParameter("exam");
		int actual_score = 0;
		List<Adminofflinedatapojo> studentids = adminuserservice.getStudentidsBasedonExamname(examname);
		for (Adminofflinedatapojo adminofflinedatapojo : studentids) {

			String studentid = adminofflinedatapojo.getStudentid();

			List<Adminofflinedatapojo> subjectnameslist = adminuserservice.getSubjectnamesInOfflineExam(examname);
			int countSubjectnames = adminuserservice.getCountOfSubjectnamesInOfflineExam(examname);
			String[] subArray = new String[countSubjectnames];
			int i = 0;
			for (Adminofflinedatapojo quest : subjectnameslist) {
				String subjectid = quest.getSubjectid();
				subArray[i] = subjectid;
				i++;

			}
			int totalmarks = adminuserservice.getTotalmarksForOfflineexam(examname);
			int stateid = 0;
			int locationid = 0;
			int branchid = 0;
			int classid = 0;
			int sectionid = 0;
			String firstname = "";
			List<Adminofflinedatapojo> userdata = adminuserservice.getofflineUserDataBasedonstudentid(studentid);
			for (Adminofflinedatapojo adminofflinedatapojo1 : userdata) {
				stateid = adminofflinedatapojo1.getStateid();
				locationid = adminofflinedatapojo1.getLocationid();
				branchid = adminofflinedatapojo1.getBranchid();
				sectionid = adminofflinedatapojo1.getSectionid();
				classid = adminofflinedatapojo1.getClassid();
				firstname = adminofflinedatapojo1.getFirstname();
			}
			int totalquestions = adminuserservice.getTotalQuestionsInOfflineExam(examname);
			int examscoredmarks = 0;
			int totalanswered = 0;
			int totalNotAnswered = 0;
			int totalwrongAnswered = 0;
			int your_Marks1 = 0;
			int final_marks = 0;
			int subjecttotalmarks = 0;

			for (int j = 0; j < subArray.length; j++) {
				List<Adminofflinedatapojo> tempexamdata = adminuserservice.getOfflineExamdataInHistory(examname,
						studentid, subArray[j]);
				int marksperqustype = 0;
				int nmarks = 0;
				int totalAnswered = 0;
				int finalmarks = 0;
				int yourMarks1 = 0;
				int totalnotAnswered = 0;
				int totalWrongAnswered = 0;
				List<Map<String, Object>> getsubjecttot = adminuserservice.getsubjectwisemarksforOfflineExam(examname,
						subArray[j]);
				for (Map<String, Object> map : getsubjecttot) {
					Object submarks = map.get("total_marks");
					String subjmarks = submarks.toString();
					subjecttotalmarks = Integer.valueOf(subjmarks);
				}
				for (Adminofflinedatapojo ques : tempexamdata) {
					int notanswered = 0;
					String rightanswer = "0";
					String wronganswer = "0";
					int qid = ques.getQuestionid();
					String selectedAnswer = ques.getSelected_answer().trim();
					int qustype = adminuserservice.getQustypeBasedonQidInofflineexam(qid, examname);
					marksperqustype = adminuserservice.getScoredmarksInOfflineExam(qustype, examname, subArray[j]);
					nmarks = adminuserservice.getNegativeMarksInOfflineExam(qustype, examname, subArray[j]);
					String ans = adminuserservice.getCorrectKeyInKeySheet(qid, examname);

					if (selectedAnswer.equals(ans)) {
						rightanswer = selectedAnswer;

						finalmarks = finalmarks + marksperqustype;
						actual_score = marksperqustype;
						totalAnswered++;
					}

					else if (selectedAnswer.equals("0")) {

						totalnotAnswered++;
						notanswered = 0;
						int actualScore1 = 0;

					}

					else {
						totalWrongAnswered++;
						finalmarks = finalmarks - nmarks;
						wronganswer = selectedAnswer;
						actual_score = marksperqustype;
						int yourMarks = -nmarks;
					}
				}
				yourMarks1 = finalmarks;
				adminuserservice.insertStudentResultsForOfflineexam(studentid, examname, subArray[j], yourMarks1,
						totalquestions, totalAnswered, firstname, stateid, locationid, branchid, classid, sectionid,
						totalmarks, nmarks, totalWrongAnswered, totalnotAnswered, subjecttotalmarks);
				examscoredmarks = examscoredmarks + yourMarks1;
				totalanswered = totalanswered + totalAnswered;
				totalNotAnswered = totalNotAnswered + totalnotAnswered;
				totalwrongAnswered = totalwrongAnswered + totalWrongAnswered;
				final_marks = finalmarks;

			}

			adminuserservice.updateExamscoredMarksOfflinexam(studentid, examname, examscoredmarks);
			String isResultscal = "yes";
			adminuserservice.updateIsresultscalculationsStatus(studentid, examname, isResultscal);
			resultscal++;
		}

		return "redirect:/finalRedirectResultscalcul";

	}

	@RequestMapping(value = "/finalRedirectResultscalcul", method = RequestMethod.GET)
	public String finalCreateExamPage(Model model, HttpServletRequest req, HttpSession ses) {
		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		String smsg = null;
		String emsg = null;

		if (resultscal > 0) {
			smsg = resultscal + ":Students results calculated.";
		} else {

			emsg = "Enter students details in Excel";
		}
		model.addAttribute("smsg", smsg);
		model.addAttribute("emsg", emsg);
		return "ResultsCalculationsForOfflineExam";
	}

}
