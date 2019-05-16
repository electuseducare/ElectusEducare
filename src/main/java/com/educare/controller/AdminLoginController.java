package com.educare.controller;

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
import com.educare.model.LoginPojo;
import com.educare.services.RegisterServiceImpl;

@Controller
public class AdminLoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminLoginController.class);
	
	@Autowired
	private RegisterServiceImpl userservice;
	
	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;
	
	String msgval = "message";
	
	@Value("${status.id}")
	String userstatus;

	@RequestMapping(value = "/Admin")
	private String adminLoginPage(Model model, LoginPojo form,HttpServletRequest req,HttpSession session) {
		String start = "Entry of adminLoginPage method....";
		String end = "End of adminLoginPage method....";
		logger.info(start);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(session,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		model.addAttribute("form", form);
		model.addAttribute("message1", model.asMap().get(msgval));
		logger.info(end);
		return "adminLogin";

	}
	
	@RequestMapping(value = "/load-adminloginform")
	public String processAdminLoginForm(Model model,LoginPojo lp, HttpSession session, HttpServletRequest req,
			RedirectAttributes ra) {

		String start = "Entry of processAdminLoginForm method....";
		String end = "End of processAdminLoginForm method....";

		logger.info(start);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(session,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";

		model.addAttribute("form", lp);
		String username = lp.getUsername();
		lp.setUserstatus(userstatus);
		String msg = null;
		List<LoginPojo> customers = userservice.loginDetails(lp);
		for (LoginPojo row : customers) {
			String usname = row.getUsername().toLowerCase();
			if (username.equalsIgnoreCase(usname) && !(usname.isEmpty())) {
				session.setAttribute("username", username);
				String studentid = row.getStudent_id();
				model.addAttribute("row", row);
				session.setAttribute("student_id", row.getStudent_id());
				session.setAttribute("first_name", row.getFname());
				session.setAttribute("email_id", row.getEmail());
				session.setAttribute("uname", row.getUsername());
				int roleid = userservice.getRoleIDfromUserRole(username);
				if (roleid != 1) {
					lc.getpermissionsforloggedusers(model, studentid);
					session.setAttribute("adminrole", "adminrole");
					return "redirect:/load-AdminDashboard";
				}
			}
		}

		msg = "Please enter valid Username/Password";
		ra.addFlashAttribute(msgval, msg);

		logger.info(end);

		return "redirect:/Admin";

	}

}
