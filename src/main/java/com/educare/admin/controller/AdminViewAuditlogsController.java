package com.educare.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.educare.DatabaseValueController;
import com.educare.admin.model.AdminViewAuditLogsModel;
import com.educare.controller.LoginController;
import com.educare.services.AdminRegisterServiceImpl;

@Controller
public class AdminViewAuditlogsController {

	private static final Logger logger = LoggerFactory.getLogger(AdminViewAuditlogsController.class);
	
	@Autowired
	private AdminRegisterServiceImpl adminuserservice;
	
	@Autowired
	private DatabaseValueController dv;

	@Autowired
	private LoginController lc;

	@RequestMapping("/load-classfilterstudentsLog")
	public String loadFilterClassnames(Model model, AdminViewAuditLogsModel filter, HttpSession ses,HttpServletRequest req) {

		String start = "Entry of loadFilterClassnames method....";
		String end = "End of loadFilterClassnames method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		// ************** Get class list ****************//
		List<AdminViewAuditLogsModel> stuid = adminuserservice.getStuentIds();
		model.addAttribute("stuid", stuid);
		model.addAttribute("filter", filter);

		logger.info(end);

		return "userLogFilter";
	}

	@RequestMapping("/load-userslogdata")
	public String adminViewAuditLogs(AdminViewAuditLogsModel av, Model model, HttpSession ses,HttpServletRequest req) {
		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		model.addAttribute("av", av);
		List<AdminViewAuditLogsModel> auditlogs = null;

		auditlogs = adminuserservice.getAllAuditslogsDetails(av);

		model.addAttribute("auditlogs", auditlogs);

		return "adminViewAuditLogs";

	}

}
