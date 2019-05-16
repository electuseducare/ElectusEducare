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
import com.educare.admin.model.AdminEditStudentFormPojo;
import com.educare.controller.LoginController;
import com.educare.services.AdminRegisterServiceImpl;

import org.slf4j.Logger;

@Controller
public class AdminEditLecturerController {

	private static final Logger logger = LoggerFactory.getLogger(AdminEditLecturerController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;

	@RequestMapping("/load-EditLecturerform")
	public String editLecturer(Model model, AdminAddNewStudent adc, AdminEditStudentFormPojo editpojo,
			HttpSession ses,HttpServletRequest req) {

		String start = "Entry of EditLecturer method....";
		String end = "End of EditLecturer method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		int buttonid = 0;
		List<AdminAddNewStudent> listval = adminuserservice.getUserNamenadEmailofAdminfromuserforLecturer();
		if (!listval.isEmpty()) {
			buttonid = 1;
		}
		editpojo.setStudentformlist(listval);
		model.addAttribute("buttonid", buttonid);
		model.addAttribute("studentlistvalue", editpojo);

		logger.info(end);

		return "AdminEditLecturer";
	}

	@RequestMapping("/load-processLecturerModify")
	public String addReferenceData(Model model, AdminAddNewStudent adc, AdminEditStudentFormPojo editpojo,
			HttpSession ses,HttpServletRequest req) {

		String start = "Entry of addReferenceData method....";
		String end = "End of addReferenceData method....";
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
		String statenames = null;
		String locationname = null;
		int update = 0;
		int update1 = 0;
		String msg = null;
		String smsg = null;
		String status = "0";

		List<AdminAddNewStudent> listval = editpojo.getStudentformlist();
		for (AdminAddNewStudent adminAddStudent : listval) {
			newuid = adminAddStudent.getUseridlist();
			if (newuid != null) {

				username = adminAddStudent.getUsername().trim();
				firstname = adminAddStudent.getFirstname().trim();
				lastname = adminAddStudent.getLastname().trim();

				mobile = adminAddStudent.getMobile().trim();
				sid = adminAddStudent.getStudentid();
				email = adminAddStudent.getEmail().trim();
				password = adminAddStudent.getPassword().trim();
				stdclass = adminAddStudent.getStudentclass();
				section = adminAddStudent.getSection();
				branch = adminAddStudent.getBranch();

				if (firstname.length() != 0 && lastname.length() != 0
						&& adminAddStudent.getUsername().trim().length() != 0 && password.length() != 0
						&& email.length() != 0 && mobile.length() != 0) {
					update = adminuserservice.updatestudentDetailsFromAdmin(sid, firstname, lastname, username, email,
							password, mobile, statenames, locationname, branch, stdclass, section, newuid, status);
				}

				if (update > 0) {
					update1++;
				}
			}
		}

		if (update1 > 0) {
			smsg = "Lecturer record updated successfully";

		} else {
			msg = "Please select atleast one entry and data should not be empty";
		}

		model.addAttribute("smsg", smsg);
		model.addAttribute("emsg", msg);

		logger.info(end);

		return "forward:/load-EditLecturerform";
	}

}
