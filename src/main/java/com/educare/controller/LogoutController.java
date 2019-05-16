package com.educare.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.educare.DatabaseValueController;
import com.educare.exception.EducareCustomException;
import com.educare.model.LoginPojo;
import com.educare.services.RegisterServiceImpl;

@Controller
public class LogoutController {

	@Autowired
	private RegisterServiceImpl userservice;
	
	@Autowired
	private DatabaseValueController dv;

	@RequestMapping("/logout")
	public String logoutUser(Model model, HttpSession session, LoginPojo form, HttpServletRequest req,
			HttpServletResponse res,HttpSession ses) {
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";

		delete(req, res, session);
		model.addAttribute("form", form);
		session.invalidate();

		return "redirect:/load-selectschool";
	}

	@RequestMapping("/logoutexam")
	public String logoutExamUser(Model model, HttpSession session, LoginPojo form, HttpServletRequest req,
			HttpServletResponse res) {

		int userstatus = 0;
		String studentids = req.getParameter("studentid");
		userservice.insertUserStatus(studentids, userstatus);

		model.addAttribute("form", form);
		session.invalidate();

		return "error/logout404";
	}

	@RequestMapping("/logout404")
	public String logoutUser404(Model model, HttpSession session, LoginPojo form, HttpServletRequest req) {

		String studentid = (String) session.getAttribute("student_id");

		int userstatus = 0;
		userservice.insertUserStatus(studentid, userstatus);

		model.addAttribute("form", form);
		session.invalidate();

		return "error/logout404";
	}

	public void delete(HttpServletRequest req, HttpServletResponse res, HttpSession session) {

		String studentid = (String) session.getAttribute("student_id");

		int userstatus = 0;
		userservice.insertUserStatus(studentid, userstatus);
		String logintime = (String) session.getAttribute("logintime");
		String username = (String) session.getAttribute("uname");
		if (!studentid.contains("AD")) {

			userservice.updateLogouttimeInAuditlogs(studentid, username, logintime);
		}

		Cookie[] cookies = req.getCookies();

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				cookie.setValue(null);
				cookie.setMaxAge(0);
				res.addCookie(cookie);
			}
		}
	}

	@ExceptionHandler(EducareCustomException.class)
	public ModelAndView handleCustomException(EducareCustomException ex) {

		ModelAndView model = new ModelAndView("error/generic_error");
		model.addObject("errCode", ex.getErrCode());
		model.addObject("errMsg", ex.getErrMsg());

		return model;

	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {

		ModelAndView model = new ModelAndView("error/generic_error");
		model.addObject("errMsg", "this is Exception.class");

		return model;

	}

}