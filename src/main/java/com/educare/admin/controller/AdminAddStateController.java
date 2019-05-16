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
import com.educare.admin.model.AdminCategory;
import com.educare.controller.LoginController;
import com.educare.services.AdminRegisterServiceImpl;

import org.slf4j.Logger;

@Controller
public class AdminAddStateController {

	private static final Logger logger = LoggerFactory.getLogger(AdminAddStateController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;

	@RequestMapping("/load-stateform")
	public String loadstateform(Model model, AdminCategory adc, HttpSession ses,HttpServletRequest req) {

		String start = "Entry of loadstateform method....";
		String end = "End of loadstateform method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		model.addAttribute("adminstate", adc);
		List<AdminCategory> statenames = adminuserservice.searchStateFromAdmin();
		model.addAttribute("statenames", statenames);

		logger.info(end);

		return "AdminAddState";
	}

	@RequestMapping("/process-stateform")
	public String loadAddStateForm(Model model, AdminCategory adc, HttpSession ses,HttpServletRequest req) {

		String start = "Entry of loadAddStateForm method....";
		String end = "End of loadAddStateForm method....";
		logger.info(start);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";

		String msg = null;
		int insertclassname = 0;
		String statename = adc.getStatename().trim();

		List<AdminCategory> value = adminuserservice.searchStateFromAdmin();
		for (AdminCategory adminCategory : value) {

			if (statename.equalsIgnoreCase(adminCategory.getStatename())) {
				msg = "State Already Exist";
				model.addAttribute("emsg", msg);
				return "forward:/load-stateform";
			}

		}

		insertclassname = adminuserservice.insertStateFromAdmin(statename);
		if (insertclassname > 0) {
			msg = "State Added Successfully";

		}
		model.addAttribute("admincategory", adc);
		model.addAttribute("smsg", msg);

		logger.info(end);

		return "forward:/load-stateform";
	}
}
