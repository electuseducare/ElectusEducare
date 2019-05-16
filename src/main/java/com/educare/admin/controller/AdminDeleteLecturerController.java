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
import com.educare.admin.model.AdminEditStudentFormPojo;
import com.educare.controller.LoginController;
import com.educare.services.AdminRegisterServiceImpl;

@Controller
public class AdminDeleteLecturerController {

	private static final Logger logger = LoggerFactory.getLogger(AdminDeleteLecturerController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;

	@RequestMapping("/load-DeleteLecturerform")
	public String deleteLecturer(Model model, AdminAddNewStudent adc, AdminEditStudentFormPojo editpojo,
			HttpSession ses,HttpServletRequest req) {

		String start = "Entry of deleteLecturer method....";
		String end = "Entry of deleteLecturer method....";
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

		return "AdminDeleteLecturer";
	}

	@RequestMapping("/load-processLecturerdelete")
	public String processDelLecturer(Model model, AdminAddNewStudent adc, AdminEditStudentFormPojo editpojo,
			HttpSession ses,HttpServletRequest req) {

		String start = "Entry of processDelLecturer method....";
		String end = "Entry of processDelLecturer method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		String msg = null;
		String smsg = null;
		int update = 0;
		int update1 = 0;
		String userid = null;
		List<AdminAddNewStudent> listcheck = editpojo.getStudentformlist();
		for (AdminAddNewStudent adminCategory : listcheck) {
			userid = adminCategory.getUseridlist();
			if (userid != null) {

				update = adminuserservice.deleteStudent(userid);
				if (update > 0) {
					update1++;
				}
			}

		}
		if (update1 > 0) {
			adminuserservice.deleteuserfromUserRole(userid);
			smsg = "Lecturer record deleted successfully";
			msg = null;
		}

		else {

			msg = "Please select atleast one entry";
		}
		model.addAttribute("smsg", smsg);
		model.addAttribute("emsg", msg);
		model.addAttribute("categorylistvalue", editpojo);

		logger.info(end);

		return "forward:/load-DeleteLecturerform";
	}

}
