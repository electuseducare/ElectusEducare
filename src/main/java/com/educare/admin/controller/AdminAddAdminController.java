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
import com.educare.admin.model.AdminAddNewStudent;
import com.educare.controller.LoginController;
import com.educare.services.AdminRegisterServiceImpl;
import com.educare.services.RegisterServiceImpl;

import org.slf4j.Logger;
@Controller
public class AdminAddAdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminAddAdminController.class);
	
	@Autowired
	private RegisterServiceImpl userservice;

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;
	
	String sidaval="student";

	@RequestMapping("/load-Adminform")
	public String loadForgotPasswordPage(Model model, AdminAddNewStudent adc, HttpSession ses,HttpServletRequest req) {
		
		String start="Entry of loadForgotPasswordPage method....";
		String end="End of loadForgotPasswordPage method....";

		logger.info(start);

		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		model.addAttribute(sidaval, adc);
		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);

		logger.info(end);

		return "AdminAddAdmin";
	}

	@RequestMapping("/load-ProcessAdmin")
	public String addStudentData(Model model, AdminAddNewStudent adstud, HttpSession ses,HttpServletRequest req) {
		
		String start="Entry of addStudentData method....";
		String end="End of addStudentData method....";

		logger.info(start);

		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		String smsg = null;
		String emsg = null;
		String lecturer = null;

		int insertrole = 0;
		int studrole = 2;

		String firstname = adstud.getFirstname();
		String lastname = adstud.getLastname();
		String username = adstud.getUsername();
		String pass = adstud.getPassword();
		adstud.getSchool();
		String section = adstud.getSection();
		String email = adstud.getEmail();
		String phone = adstud.getMobile();
		String stcls = adstud.getStudentclass();
		String branch = adstud.getBranch();
		// getting student role id

		// generating ids
		lecturer = userservice.generateAdminID();

		// Check if Exist User Or Not

		List<AdminAddNewStudent> checkexistUser = adminuserservice.getUserNamenadEmailofAdminfromuserforAdmin();
		for (AdminAddNewStudent adminAddNewStudent : checkexistUser) {
			String existusername = adminAddNewStudent.getUsername();
			if (existusername.equals(username)) {
				emsg = "Username Already Exist";
				model.addAttribute("emsg", emsg);
				model.addAttribute(sidaval, adstud);

				return "forward:/load-Adminform";
			}
		}

		// create student from admin

		String state = null;
		String location = null;
		int insertstudentdetails = adminuserservice.insertstudentDetailsFromAdmin(lecturer, firstname, lastname,
				username, pass, state, location, branch, stcls, section, email, phone);
		insertrole = userservice.getUserIDfromUsers(username);
		userservice.insertUserRole(insertrole, studrole);
		if (insertstudentdetails > 0 && insertrole > 0) {
			smsg = "Duplicate Role Added Successfully";
		}
		model.addAttribute("smsg", smsg);
		model.addAttribute(sidaval, adstud);

		logger.info(end);

		return "forward:/load-Adminform";
	}

}
