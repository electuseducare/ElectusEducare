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
public class AdminAddQuestionLevelControlller {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminAddQuestionLevelControlller.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;

	@RequestMapping("/load-addquestionlevel")
	public String loadAddQlevel(Model model, AdminCategory adc, HttpSession ses,HttpServletRequest req) {

		String start = "Entry of loadAddQlevel method....";
		String end = "End of loadAddQlevel method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		model.addAttribute("admincategory", adc);

		logger.info(end);

		return "AdminAddQuestionlevel";
	}

	@RequestMapping("/process-questionlevelform")
	public String processQlevele(Model model, AdminCategory adc, HttpSession ses,HttpServletRequest req) {

		String start = "Entry of processQlevele method....";
		String end = "End of processQlevele method....";
		logger.info(start);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";

		String msg = null;
		int insertexamtype = 0;
		String examtype = adc.getQuestionlevel().trim();
		List<AdminCategory> value = adminuserservice.searchQuestionlevelFromAdmin();
		for (AdminCategory adminCategory : value) {

			if (examtype.equalsIgnoreCase(adminCategory.getQuestionlevel())) {
				msg = "Question Level already exist";
				model.addAttribute("emsg", msg);
				return "forward:/load-addquestionlevel";
			}

		}

		insertexamtype = adminuserservice.insertQuestionlevelFromAdmin(examtype);
		if (insertexamtype > 0) {
			msg = "Question level added Successfully";

		}
		model.addAttribute("admincategory", adc);
		model.addAttribute("smsg", msg);

		logger.info(end);

		return "forward:/load-addquestionlevel";
	}

}
