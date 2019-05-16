package com.educare.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.educare.DatabaseValueController;
import com.educare.admin.model.AdminExamNameforReport;
import com.educare.controller.LoginController;
import com.educare.services.AdminRegisterServiceImpl;

import org.slf4j.Logger;
@Controller
public class AdminViewExamsForSubmitExamController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminViewExamsForSubmitExamController.class);
	
	@Autowired
	private LoginController lc;
	
	@Autowired
	private AdminRegisterServiceImpl adminuserservice;
	
	@Autowired
	private DatabaseValueController dv;
	
	@RequestMapping(value="/load-viewexamnamesforsubmitexam")
	public String loadExamNameForSubmitTest(Model model, AdminExamNameforReport submitexam, HttpSession ses,HttpServletRequest req) {

		String start="Entry of loadExamNameForSubmitTest method....";
		String end="End of loadExamNameForSubmitTest method....";
		
		logger.info(start);

		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		List<AdminExamNameforReport> examlist = adminuserservice.getExamnamesForSubmitExam();

		model.addAttribute("examlist", examlist);
		model.addAttribute("submitexam", submitexam);

		logger.info(end);

		return "examNameforSubmitExam";
	}
	
	
	@RequestMapping(value="/view-notfinishedstudsbasedonexamname")
	public String loadStudsBasedonExamname(Model model, AdminExamNameforReport submitexam, HttpSession ses,HttpServletRequest req) {
		
		String start="Entry of loadStudsBasedonExamname method....";
		String end="End of loadStudsBasedonExamname method....";
		
		logger.info(start);
		
		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		List<AdminExamNameforReport> studlist = adminuserservice.getNotFishedStdsBasedonExamname(submitexam);
		model.addAttribute("selexam", submitexam.getExamname());
		
		model.addAttribute("studlist", studlist);
		model.addAttribute("submitexam", submitexam);
		
		logger.info(end);
		
		return "studsIdsForSubmitExam";
	}

}
