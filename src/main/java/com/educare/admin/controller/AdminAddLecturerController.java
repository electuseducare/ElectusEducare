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
import com.educare.admin.model.AdminAddNewStudent;
import com.educare.controller.LoginController;
import com.educare.model.Register;
import com.educare.services.AdminRegisterServiceImpl;
import com.educare.services.RegisterServiceImpl;

@Controller
public class AdminAddLecturerController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminAddLecturerController.class);

	@Autowired
	private RegisterServiceImpl userservice;

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;

	String sval = "student";

	@RequestMapping("/load-lecturerform")
	public String loadLectureForm(Model model, AdminAddNewStudent adc, HttpSession ses,HttpServletRequest req) {

		String start = "Entry of loadLectureForm method....";
		String end = "End of loadLectureForm method....";

		logger.info(start);

		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		model.addAttribute(sval, adc);

		logger.info(end);

		return "AdminaAddLecturer";
	}

	@RequestMapping("/load-ProcessLecturer")
	public String processLecture(Model model, AdminAddNewStudent adstud, Register reg, HttpSession ses,HttpServletRequest req) {

		String start = "Entry of processLecture method....";
		String end = "End of processLecture method....";

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
		int studrole = 3;

		String firstname = adstud.getFirstname();
		String lastname = adstud.getLastname();
		String username = adstud.getUsername();
		String pass = adstud.getPassword();

		String email = adstud.getEmail();
		String phone = adstud.getMobile();

		// getting student role id

		// generating ids
		lecturer = userservice.generateLecturerID();

		// Check if Exist User Or Not

		List<AdminAddNewStudent> checkexistUser = adminuserservice.getUserNamenadEmailofAdminfromuserforAdmin();
		for (AdminAddNewStudent adminAddNewStudent : checkexistUser) {
			String existusername = adminAddNewStudent.getUsername();

			if (existusername.equals(username)) {
				emsg = "Username Already Exist";
				model.addAttribute("emsg", emsg);
				model.addAttribute(sval, adstud);

				return "forward:/load-lecturerform";
			}
		}

		// create student from admin

		String state = null;
		String location = null;
		String branch = null;
		String stcls = null;
		String section = null;
		int insertstudentdetails = adminuserservice.insertstudentDetailsFromAdmin(lecturer, firstname, lastname,
				username, pass, state, location, branch, stcls, section, email, phone);

		insertrole = userservice.getUserIDfromUsers(adstud.getUsername());
		userservice.insertUserRole(insertrole, studrole);
		if (insertstudentdetails > 0 && insertrole > 0) {
			smsg = "Lecturer Added Successfully";
		}
		model.addAttribute("smsg", smsg);
		model.addAttribute(sval, adstud);

		logger.info(end);

		return "forward:/load-lecturerform";
	}

}
