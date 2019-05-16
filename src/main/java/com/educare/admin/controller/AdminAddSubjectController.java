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
public class AdminAddSubjectController {

	private static final Logger logger = LoggerFactory.getLogger(AdminAddSubjectController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;

	@RequestMapping("/load-Subjectform")
	public String loadAdminAddSubjectPage(Model model, AdminCategory adc, HttpSession ses,HttpServletRequest req) {

		String start = "Entry of loadAdminAddSubjectPage method....";
		String end = "End of loadAdminAddSubjectPage method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		model.addAttribute("adminbranch", adc);
		List<AdminCategory> classnames = adminuserservice.searchClassesFromAdmin();
		model.addAttribute("classnames", classnames);

		logger.info(end);

		return "AdminAddSubject";
	}

	@RequestMapping("/process-Subjectform")
	public String processSubjForm(Model model, AdminCategory adc, HttpSession ses,HttpServletRequest req) {

		String start = "Entry of processSubjForm method....";
		String end = "End of processSubjForm method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		String msg = null;
		int insertclassname = 0;
		String branchname = adc.getSubject();
		String classname = adc.getClassname();
		int classid = (new Integer(classname)).intValue();
		List<AdminCategory> value = adminuserservice.searchSubjectFromAdmin1(classid);
		for (AdminCategory adminCategory : value) {

			if (branchname.equalsIgnoreCase(adminCategory.getSubject())) {
				msg = "Subject name already exist";
				model.addAttribute("emsg", msg);
				return "forward:/load-Subjectform";
			}

		}

		insertclassname = adminuserservice.insertSubjectFromAdmin(branchname, classid);
		if (insertclassname > 0) {
			msg = "Subject added successfully";

		}
		model.addAttribute("admincategory", adc);
		model.addAttribute("smsg", msg);

		logger.info(end);

		return "forward:/load-Subjectform";
	}
}
