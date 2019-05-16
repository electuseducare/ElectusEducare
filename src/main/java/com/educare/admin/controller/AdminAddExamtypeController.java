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
import com.educare.admin.model.AdminCategory;
import com.educare.controller.LoginController;
import com.educare.services.AdminRegisterServiceImpl;

@Controller
public class AdminAddExamtypeController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminAddExamtypeController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;
	
	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;

	@RequestMapping("/load-addexamtype")
	public String loadForgotPasswordPage(Model model, AdminCategory adc, HttpSession ses,HttpServletRequest req) {

		String start = "Entry of loadForgotPasswordPage method....";
		String end = "End of loadForgotPasswordPage method....";

		logger.info(start);

		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		model.addAttribute("admincategory", adc);

		logger.info(end);

		return "AdminAddExamtype";
	}

	@RequestMapping("/process-examtypeform")
	public String loadAddCategoryForm(Model model, AdminCategory adc,HttpSession ses,HttpServletRequest req) {

		String start = "Entry of loadAddCategoryForm method....";
		String end = "End of loadAddCategoryForm method....";

		logger.info(start);

		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		String msg = null;
		int insertexamtype = 0;
		String examtype = adc.getExamtype().trim();
		List<AdminCategory> value = adminuserservice.searchExamtypeFromAdmin();
		for (AdminCategory adminCategory : value) {

			if (examtype.equalsIgnoreCase(adminCategory.getExamtype())) {
				msg = "Examtype Already Exist";
				model.addAttribute("emsg", msg);
				return "forward:/load-addexamtype";
			}

		}

		insertexamtype = adminuserservice.insertExamtypeFromAdmin(examtype);
		if (insertexamtype > 0) {
			msg = "Examtype Added Successfully";

		}
		model.addAttribute("admincategory", adc);
		model.addAttribute("smsg", msg);

		logger.info(end);

		return "forward:/load-addexamtype";
	}

}
