package com.educare.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.educare.DatabaseValueController;
import com.educare.admin.model.AdminAddNewStudent;
import com.educare.admin.model.AdminEditStudentFormPojo;
import com.educare.controller.LoginController;
import com.educare.services.AdminRegisterServiceImpl;

@Controller
public class AdminEditAdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminEditAdminController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;

	@Value("${admin.roleid}")
	String roleid;

	@RequestMapping("/load-EditAdminform")
	public String editAdmin(Model model, AdminAddNewStudent adc, AdminEditStudentFormPojo editpojo, HttpSession ses,HttpServletRequest req) {

		String start = "Entry of editAdmin method....";
		String end = "Entd of editAdmin method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		int buttonid = 0;
		List<AdminAddNewStudent> listval = adminuserservice.getUserNamenadEmailofAdminfromuserforAdmin1(roleid);
		if (!listval.isEmpty()) {
			buttonid = 1;
		}
		editpojo.setStudentformlist(listval);
		model.addAttribute("buttonid", buttonid);
		model.addAttribute("studentlistvalue", editpojo);

		logger.info(end);

		return "AdminEditAdmin";
	}

	@RequestMapping("/load-processAdminModify")
	public String addReferenceData(Model model, AdminAddNewStudent adc, AdminEditStudentFormPojo editpojo,
			HttpSession ses,HttpServletRequest req) {

		String start = "Entry of addReferenceData method....";
		String end = "Entd of addReferenceData method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		String newuid = null;
		String username = null;
		String firstname = null;
		String lastname = null;
		String password = null;
		String email = null;
		String mobile = null;
		String sid = null;
		String stdclass = null;
		String section = null;
		String branch = null;
		int update = 0;
		int update1 = 0;
		int buttonid = 1;
		String msg = null;
		String smsg = null;
		String statenames = null;
		String locationname = null;
		String status = "0";

		List<AdminAddNewStudent> listval = editpojo.getStudentformlist();
		for (AdminAddNewStudent adminAddStudent : listval) {
			newuid = adminAddStudent.getUseridlist();
			if (newuid != null) {
				username = adminAddStudent.getUsername().trim();
				firstname = adminAddStudent.getFirstname().trim();
				lastname = adminAddStudent.getLastname().trim();
				password = adminAddStudent.getPassword().trim();
				mobile = adminAddStudent.getMobile().trim();
				sid = adminAddStudent.getStudentid();
				email = adminAddStudent.getEmail().trim();
				stdclass = adminAddStudent.getStudentclass();
				section = adminAddStudent.getSection();
				branch = adminAddStudent.getBranch();

				if (firstname.length() != 0 && lastname.length() != 0 && username.length() != 0 && email.length() != 0
						&& password.length() != 0 && mobile.length() != 0) {
					update = adminuserservice.updatestudentDetailsFromAdmin(sid, firstname, lastname, username, email,
							password, mobile, statenames, locationname, branch, stdclass, section, newuid, status);

				}

				if (update > 0) {
					update1++;
				}

			}
		}
		if (update1 > 0) {
			smsg = "Admin record updated successfully";
			msg = null;
		} else {
			msg = "Please select atleast one entry and data should not be empty";
			smsg = null;
		}
		model.addAttribute("smsg", smsg);
		model.addAttribute("emsg", msg);
		model.addAttribute("buttonid", buttonid);

		logger.info(end);

		return "forward:/load-EditAdminform";
	}

}
