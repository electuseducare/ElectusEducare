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
import com.educare.admin.model.AdminCategory;
import com.educare.admin.model.AdminEditStudentFormPojo;
import com.educare.controller.LoginController;
import com.educare.services.AdminRegisterServiceImpl;
@Controller
public class AdminDeleteStudentController {

	private static final Logger logger = LoggerFactory.getLogger(AdminDeleteStudentController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;
	
	String sidval="student_id";
	
	
	@RequestMapping("/load-classfilterstudentsfordel")
	public String loadFilterClassnames(Model model, AdminAddNewStudent filter, HttpSession ses,HttpServletRequest req) {
		
		String start="Entry of loadFilterClassnames method....";
		String end="End of loadFilterClassnames method....";

		logger.info(start);
		
		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
        /**************Get class list****************/
		List<AdminCategory> classnames = adminuserservice.searchClassesFromAdmin();
		model.addAttribute("classnames", classnames);
		model.addAttribute("filter", filter);
		ses.removeAttribute("smsg");
		ses.removeAttribute("emsg");

		logger.info(end);

		return "classFilterStudentsForDel";
	}

	@RequestMapping("/load-DeleteStudentform")
	public String deleteStudent(Model model, AdminAddNewStudent adc, AdminEditStudentFormPojo editpojo,
			HttpSession ses,HttpServletRequest req) {

		String start="Entry of deleteStudent method....";
		String end="End of deleteStudent method....";

		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		int buttonid = 0;
		List<AdminAddNewStudent> listval = adminuserservice.getUserNamenadEmailofAdminfromuser1(adc);
		if (!listval.isEmpty()) {
			buttonid = 1;
		}
		editpojo.setStudentformlist(listval);
		model.addAttribute("buttonid", buttonid);
		model.addAttribute("studentlistvalue", editpojo);

		logger.info(end);

		return "AdminDeleteStudent";
	}

	@RequestMapping("/load-processstudentdelete")
	public String loadprocessdeletecategory(Model model, AdminAddNewStudent adc, AdminEditStudentFormPojo editpojo,
			HttpSession ses,HttpServletRequest req) {
		
		String start="Entry of loadprocessdeletecategory method....";
		String end="End of loadprocessdeletecategory method....";

		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		String msg = null;
		String smsg = null;
		int update = 0;
		int update1 = 0;
		int buttonid = 1;
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
			smsg = "Student record deleted successfully";
			msg = null;
		}

		else {
			msg = "Please select atleast one entry";
		}

		model.addAttribute("smsg", smsg);
		model.addAttribute("emsg", msg);
		model.addAttribute("buttonid", buttonid);
		ses.setAttribute("smsg", smsg);
		ses.setAttribute("emsg", msg);
		model.addAttribute("categorylistvalue", editpojo);

		logger.info(end);

		
		return "redirect:/redirect-classFilterStudentsForDel";
	}
	
	@RequestMapping("/redirect-classFilterStudentsForDel")
	public String loadprocessdeletecategory1(Model model, AdminAddNewStudent adc, AdminEditStudentFormPojo editpojo,
			HttpSession ses,HttpServletRequest req) {
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		model.addAttribute("smsg", ses.getAttribute("smsg"));
		model.addAttribute("emsg", ses.getAttribute("emsg"));
		
		
		return "forward:/load-classfilterstudentsfordel";
		
	}
	

}
