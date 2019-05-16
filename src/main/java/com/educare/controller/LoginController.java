package com.educare.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.educare.DatabaseValueController;
import com.educare.admin.model.AdminAddEditDeleteAccessforRolesPojo;
import com.educare.exception.EducareCustomException;
import com.educare.model.LoginPojo;
import com.educare.services.AdminRegisterServiceImpl;
import com.educare.services.RegisterServiceImpl;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private RegisterServiceImpl userservice;

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;
	
	@Autowired
	private DatabaseValueController dv;

	String msgval = "message";
	
	@Value("${status.id}")
	String userstatus;


	@RequestMapping("/loadl-form")
	public String loginStudent(Model model, LoginPojo form,HttpServletRequest req,HttpSession ses) {

		String start = "Entry of loginStudent method....";
		String end = "End of loginStudent method....";

		logger.info(start);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		model.addAttribute("form", form);
		model.addAttribute("message1", model.asMap().get(msgval));
		logger.info(end);

		return "login";
	}

	@RequestMapping("/loadl-indexform")
	public String indexloginUser(Model model, LoginPojo form1,HttpServletRequest req,HttpSession ses) {

		String start = "Entry of indexloginUser method....";
		String end = "End of indexloginUser method....";

		logger.info(start);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		model.addAttribute("form", form1);
		logger.info(end);

		return "index";
	}

	@RequestMapping(value = "/load-loginform")
	public String processLoginForm(Model model, String uname, LoginPojo lp, HttpSession session, HttpServletRequest req,
			RedirectAttributes ra) {

		String start = "Entry of processLoginForm method....";
		String end = "End of processLoginForm method....";

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
			int userstatus = 0;
			if (username.equalsIgnoreCase(usname) && !(usname.isEmpty())) {
				session.setAttribute("username", username);
				String studentid = row.getStudent_id();
				model.addAttribute("row", row);
				session.setAttribute("student_id", row.getStudent_id());
				session.setAttribute("first_name", row.getFname());
				session.setAttribute("email_id", row.getEmail());
				session.setAttribute("uname", row.getUsername());

				int roleid = userservice.getRoleIDfromUserRole(username);
				int usersatatus1 = userservice.getUserStatus(studentid);
				if (roleid == 1) {
					if (usersatatus1 == 0) {
						userstatus = 1;
						userservice.insertUserStatus(studentid, userstatus);
						session.setAttribute("userrole", "userrole");
						DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						Date now = new Date();
						String logintime = dateFormat.format(now);
						session.setAttribute("logintime", logintime);
						userservice.insertAuditlogs(studentid, username, logintime);
						sessionVariables(session, studentid);
						return "redirect:/load-welcomeUser";
					}

					else {
						msg = "Current user is already logged in. Please try again after some time!";
						model.addAttribute(msgval, msg);
						return "forward:/loadl-form";
					}
				}
			}
		}

		msg = "Please enter valid Username/Password";
		ra.addFlashAttribute(msgval, msg);

		logger.info(end);

		return "redirect:/loadl-form";

	}

	private void sessionVariables(HttpSession session, String studentid) {
		List<LoginPojo> userdetails = userservice.getUserdetails(studentid);
		for (LoginPojo loginPojo : userdetails) {
			session.setAttribute("classname", loginPojo.getClassname());
			session.setAttribute("sectionname", loginPojo.getSection());
			session.setAttribute("branchname", loginPojo.getBarnch());
			session.setAttribute("username", loginPojo.getFirstname());
			session.setAttribute("state", loginPojo.getState());
			session.setAttribute("locationid", loginPojo.getLocationid());
		}
	}

	public String getpermissionsforloggedusers(Model model, String studentid) {

		List<AdminAddEditDeleteAccessforRolesPojo> userperm = adminuserservice.getpermissionsforloggedusers(studentid);
		model.addAttribute("userperm", userperm);

		return "AdminDashboardLeftMenu";
	}

	@ExceptionHandler(EducareCustomException.class)
	public ModelAndView handleCustomException(EducareCustomException ex) {

		String start = "Entry of handleCustomException method....";
		String end = "End of handleCustomException method....";

		logger.info(start);
		ModelAndView model = new ModelAndView("error/generic_error");
		model.addObject("errCode", ex.getErrCode());
		model.addObject("errMsg", ex.getErrMsg());
		logger.info(end);

		return model;

	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {

		String start = "Entry of handleAllException method....";
		String end = "End of handleAllException method....";

		logger.info(start);

		ModelAndView model = new ModelAndView("error/generic_error");
		model.addObject("errMsg", "this is Exception.class");

		logger.info(end);

		return model;

	}

}
