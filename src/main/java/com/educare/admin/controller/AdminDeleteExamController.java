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
public class AdminDeleteExamController {
	private static final Logger logger = LoggerFactory.getLogger(AdminCopyCreateExamController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;

	@RequestMapping("load-availableExamNamesToDelete")
	private String displayAvailableExamsToDelete(Model model, HttpSession ses, AdminCategory ad,HttpServletRequest req) {

		String start = "Entry of displayAvailableExamsToDelete method....";
		String end = "Entry of displayAvailableExamsToDelete method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";

		List<AdminCategory> examlist = adminuserservice.getExamNameForCopyExam();

		model.addAttribute("examlist", examlist);
		model.addAttribute("getexamnames", ad);
		model.addAttribute("loadexamdetails", ad);

		logger.info(end);

		return "AdminGetExamNamesForDelete";

	}

	@RequestMapping("load-deleteexam")
	private String deleteExamname(Model model, HttpSession ses, AdminCategory ad,HttpServletRequest req) {
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		String selectedExam = ad.getSelectedexam();
		model.addAttribute("selectedExam", selectedExam);
		String emsg = null;
		String smsg = null;

		int sturesultcount = adminuserservice.getSelectExamnameInstudentResults(selectedExam);
		int sturesulthistorycount = adminuserservice.getSelectExamnameInstudentResultsHistory(selectedExam);
		if (sturesultcount > 0 && sturesulthistorycount > 0) {

			emsg = "You can't delete selected exam. Because it is already exist in results.";
		} else {

			adminuserservice.getDeleteExamname(selectedExam);
			adminuserservice.getDeleteExamnameInExampaper(selectedExam);
			adminuserservice.getDeleteExamnameInExampaper1(selectedExam);
			adminuserservice.getDeleteExamnameInTempHistrory(selectedExam);
			
			smsg = "Exam deleted successfully";
		}
		model.addAttribute("emsg", emsg);
		model.addAttribute("smsg", smsg);

		return "forward:load-availableExamNamesToDelete";

	}

}
