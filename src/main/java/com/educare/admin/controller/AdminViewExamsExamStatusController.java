package com.educare.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.educare.DatabaseValueController;
import com.educare.admin.model.AdminExamNameforReport;
import com.educare.controller.LoginController;
import com.educare.services.AdminRegisterServiceImpl;

@Controller
public class AdminViewExamsExamStatusController {

	private static final Logger logger = LoggerFactory.getLogger(AdminViewExamsExamStatusController.class);

	@Autowired
	private LoginController lc;

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;
	
	@Autowired
	private DatabaseValueController dv;

	@RequestMapping("/load-viewexamnamesforstdexamstatus")
	public String loadExamNameForExamstatus(Model model, AdminExamNameforReport submitexam, HttpSession ses,HttpServletRequest req) {

		String start = "Entry of loadExamNameForSubmitTest method....";
		String end = "End of loadExamNameForSubmitTest method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		List<AdminExamNameforReport> examlist = adminuserservice.getExamnamesForExamStatus1();

		model.addAttribute("examlist", examlist);
		model.addAttribute("submitexam", submitexam);

		logger.info(end);

		return "examNameforExamStatus";
	}

	@RequestMapping(value = "/view-detailedstudentsstatus")
	public String viewDetailedStudentsExam(Model model, AdminExamNameforReport submitexam, HttpSession ses,HttpServletRequest req) {

		String start = "Entry of viewDetailedStudentsExam method....";
		String end = "End of viewDetailedStudentsExam method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		List<AdminExamNameforReport> examdetailedlist = adminuserservice.getExamdetailsBasedonExamanme(submitexam);
		List<AdminExamNameforReport> examresultslist = null;

		for (AdminExamNameforReport exam : examdetailedlist) {
			submitexam.setStateid(exam.getStateid());
			submitexam.setBrancid(exam.getBrancid());
			submitexam.setLocationid(exam.getLocationid());
			submitexam.setClassid(exam.getClassid());
			submitexam.setSectionid(exam.getSectionid());
			examresultslist = adminuserservice.getExamResultsStatus(submitexam);
		}

		model.addAttribute("examresultslist", examresultslist);
		model.addAttribute("submitexam", submitexam);
		model.addAttribute("examname", submitexam.getExamname());

		logger.info(end);

		return "examnameResultsStatusReport";
	}

}
