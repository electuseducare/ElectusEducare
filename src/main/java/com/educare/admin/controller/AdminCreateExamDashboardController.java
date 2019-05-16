package com.educare.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.educare.DatabaseValueController;
import com.educare.controller.LoginController;

@Controller
public class AdminCreateExamDashboardController {
	
	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;

	String sidval = "student_id";
	
	@RequestMapping("/view-createexamdashboard")
	public String viewCreateExamDashboard(Model model, HttpSession ses,HttpServletRequest req) {
		
		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		return "createExamDashboard";
	}

}
