package com.educare.controller;

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
import com.educare.model.WelcomeUserPojo;
import com.educare.services.RegisterServiceImpl;
@Controller
public class DashboardViewUserTestResultsController {

	private static final Logger logger = LoggerFactory.getLogger(DashboardViewUserTestResultsController.class);

	@Autowired
	private RegisterServiceImpl userservice;
	
	@Autowired
	private DatabaseValueController dv;

	@RequestMapping("/load-userdashboardResults")
	public String viewDashboardResults(Model model, HttpSession session, WelcomeUserPojo wup,HttpServletRequest req) {
		
		String start="Entry of viewDashboardResults method....";
		String end="End of viewDashboardResults method....";

		logger.info(start);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(session,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";

		String studentid = (String) session.getAttribute("student_id");

		List<WelcomeUserPojo> userresults = userservice.userResults(studentid);
	

		model.addAttribute("userresults", userresults);
		String emsg="";
		if(!userresults.isEmpty()){
			emsg="You don't have any results.";
			model.addAttribute("emsg", emsg);
		}
		model.addAttribute("smsg", userresults.size());

		logger.info(end);

		return "userViewResultsDashboard";
	}

}
