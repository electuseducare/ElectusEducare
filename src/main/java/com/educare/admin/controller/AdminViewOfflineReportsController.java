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
import com.educare.admin.model.Adminofflinedatapojo;
import com.educare.controller.LoginController;
import com.educare.services.AdminRegisterServiceImpl;

@Controller
public class AdminViewOfflineReportsController {

	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(AdminViewOfflineReportsController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;

	@RequestMapping("/load-examnameforofflinereports")
	public String offlineresults(Model model, Adminofflinedatapojo adc, HttpSession ses,HttpServletRequest req) {

		String start = "Entry of offlineresults method....";
		String end = "End of offlineresults method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		String isresult = "yes";
		List<Adminofflinedatapojo> examlist = adminuserservice.getExamNameforofflineReport(isresult);

		model.addAttribute("examlist", examlist);
		model.addAttribute("adminreport", adc);

		logger.info(end);

		return "loadOfflineExamnames";
	}

}
