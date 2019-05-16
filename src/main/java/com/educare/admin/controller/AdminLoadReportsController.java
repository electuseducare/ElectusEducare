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
public class AdminLoadReportsController {

	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(AdminLoadReportsController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;

	@RequestMapping("/load-ExamNameReports")
	public String loadExamNameReports(Model model, AdminExamNameforReport adc, HttpSession ses,HttpServletRequest req) {

		String start = "Entry of loadExamNameReports method....";
		String end = "End of loadExamNameReports method....";

		logger.info(start);

		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		List<AdminExamNameforReport> examlist = adminuserservice.getExamNameWiseReportFromAdmin();

		model.addAttribute("examlist", examlist);
		model.addAttribute("adminreport", adc);

		logger.info(end);

		return "ExamNameforReport";
	}

	@RequestMapping("/load-Jasperreport")
	public String loadReports(Model model, AdminExamNameforReport adc, HttpServletRequest req, HttpSession sess) {

		String start = "Entry of loadReports method....";
		String end = "End of loadReports method....";

		logger.info(start);

		String studentid = (String) sess.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		String examname = req.getParameter("exam");
		sess.setAttribute("examnameval", examname);

		logger.info(end);

		return "AdminReports";
	}

}
