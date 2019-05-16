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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.educare.DatabaseValueController;
import com.educare.admin.model.AdminAddNewStudent;
import com.educare.admin.model.AdminCategory;
import com.educare.controller.LoginController;
import com.educare.services.AdminRegisterServiceImpl;

@Controller
public class AdminActiveStudentsController {

	private static final Logger logger = LoggerFactory.getLogger(AdminActiveStudentsController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private LoginController lc;

	@Autowired
	private DatabaseValueController dv;

	@Value("${session.id}")
	int sessionid;

	String sidval = "student_id";

	@RequestMapping("/load-getclassandsect")
	public String getclassAndSec(Model model, AdminAddNewStudent actstud, HttpServletRequest req, HttpSession ses) {

		String start = "Entry of getclassAndSec method....";
		String end = "End of getclassAndSec method....";
		logger.info(start);
		
		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);

		/**** return default database value *****/
		String dbval = dv.getDatabaseValue(ses, req);
		if (dbval.equals("0"))
			return "defaultDatabaseErrorPage";

		/************** Get Classes ****************/
		List<AdminCategory> classnames = adminuserservice.searchClassesFromAdmin();
		model.addAttribute("classnames", classnames);
		model.addAttribute("actstud", actstud);

		model.addAttribute("smsg", model.asMap().get("smsg"));
		model.addAttribute("emsg", model.asMap().get("emsg"));
		
		logger.info(end);
		return "adminActiveStudents";
	}

	@RequestMapping("/load-admiinactivestudents")
	public String activeStudBasedOnclassandSect(Model model, RedirectAttributes ra, AdminAddNewStudent actstud,
			HttpServletRequest req, HttpSession ses) {

		String start = "Entry of AdminActiveStudents method....";
		String end = "End of AdminActiveStudents method....";
		logger.info(start);
		
		/**** return default database value *****/
		String dbval = dv.getDatabaseValue(ses, req);
		if (dbval.equals("0"))
			return "defaultDatabaseErrorPage";

		String smsg = "";
		String emsg = "";
		/*** Active Students Based on class and section ***/
		actstud.setSessionid(sessionid);
		int updatestatus = adminuserservice.activeStudentsBasedOnClassAndSec(actstud);
		if (updatestatus > 0) {
			smsg = "Student Status  Updated Successfully";
		} else {
			emsg = "Student Status Not Updated Successfully";
		}
		ra.addFlashAttribute("smsg", smsg);
		ra.addFlashAttribute("emsg", emsg);

		logger.info(end);
		return "redirect:/load-getclassandsect";
	}
}
