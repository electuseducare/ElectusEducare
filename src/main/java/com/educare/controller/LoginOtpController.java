package com.educare.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.educare.DatabaseValueController;
import com.educare.model.LoginPojo;
import com.educare.model.MailPojo;
import com.educare.services.RegisterServiceImpl;
import com.educare.utility.MailUtilities;

@Controller
public class LoginOtpController {
	private static final Logger logger = LoggerFactory.getLogger(LoginOtpController.class);

	@Autowired
	private RegisterServiceImpl userservice;

	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;
	
	String finalmsg="Please enter valid Username/OTP value";
	String emailval="email";
	String sidval="student_id";
	String fnameval="first_name";
	

	@RequestMapping("/load-loginoptform")
	public String loginStudent(Model model, LoginPojo form,HttpServletRequest req,HttpSession ses) {

		String start = "Entry of loginStudent method....";
		String end = "End of loginStudent method....";
		logger.info(start);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";

		model.addAttribute("form", form);

		logger.info(end);

		return "loginwithOTP";
	}

	public String random(int otpsize) {

		String start = "Entry of random method....";
		String end = "End of random method....";
		logger.info(start);

		StringBuilder generatedToken = new StringBuilder();
		try {
			SecureRandom number = SecureRandom.getInstance("SHA1PRNG");
			for (int i = 0; i < otpsize; i++) {
				generatedToken.append(number.nextInt(9));
			}
		} catch (NoSuchAlgorithmException e) {
		}

		logger.info(end);

		return generatedToken.toString();
	}

	@ResponseBody
	@RequestMapping(value = "/load-generateOTP", method = RequestMethod.POST)
	public void processLoginFormwithOTP(Model model, LoginPojo lp, HttpSession session, HttpServletRequest request,
			HttpServletResponse response) {

		String start = "Entry of processLoginFormwithOTP method....";
		String end = "End of processLoginFormwithOTP method....";
		logger.info(start);

		model.addAttribute("form", lp);
		String username = request.getParameter("username");
		int unameAvailable = userservice.getEmailIDfromusername(username);

		if (unameAvailable == 0) {

			String msg = "Please provide valid username to send OTP";
			try {
				response.getWriter().write(msg);
			} catch (IOException e) {

			}
		} else {
			List<Map<String, Object>> getEmail = userservice.retriveEmailIDfromUsername(username);
			String emailid = null;
			for (Map<String, Object> map : getEmail) {
				emailid = (String) map.get(emailval);
			}
			String msg = "Please check your email, OTP has been sent to your Email ID!";
			try {
				response.getWriter().write(msg);
			} catch (IOException e) {

			}
			int otpsize = 6;
			String otpnumber = random(otpsize);
			userservice.updateOTP(username, emailid, otpnumber);
			MailPojo mp = new MailPojo();

			mp.setMailSubject("Electus OTP number");
			mp.setMsgContent(otpnumber);
			ArrayList<String> toList = new ArrayList<>();
			toList.add(emailid);
			mp.setToRecipients(toList);
			try {
				MailUtilities.sendMail(mp);
			} catch (MessagingException e) {

			}
		}

		logger.info(end);

	}

	@ResponseBody
	@RequestMapping(value = "/load-validateOTP", method = RequestMethod.POST)
	public void validateOTPValue(Model model, LoginPojo lp, HttpSession session, HttpServletRequest request,
			HttpServletResponse response) {

		String start = "Entry of validateOTPValue method....";
		String end = "End of validateOTPValue method....";
		logger.info(start);

		model.addAttribute("form", lp);
		String getotp = request.getParameter("getotp");
		String username = request.getParameter("username");
		String otps = null;
		String studentid = null;
		String fname = null;
		String emailid = null;
		String uname = null;

		List<Map<String, Object>> getotbfromdb = userservice.validateOTP(username, getotp);
		for (Map<String, Object> map : getotbfromdb) {
			otps = (String) map.get("otp_code");
			studentid = (String) map.get(sidval);
			fname = (String) map.get(fnameval);
			emailid = (String) map.get(emailval);
			uname = (String) map.get("user_name");
		}

		if (getotp.equals(otps)) {

			request.setAttribute("student_User", studentid);

			session.setAttribute(sidval, studentid);
			session.setAttribute(fnameval, fname);
			session.setAttribute("email_id", emailid);
			session.setAttribute("uname", uname);
			try {
				response.getWriter().write("Matched given OTP value! Please click on Sing in with OTP button");
			} catch (IOException e) {

			}

		} else {
			try {
				response.getWriter().write("Please enter valid OTP / Username");
			} catch (IOException e) {

			}
		}

		logger.info(end);
	}

	@RequestMapping("/process-loginotpform")
	public String processLoginOTPForm(Model model, String uname, LoginPojo lp, HttpSession session,
			HttpServletRequest req) {

		String start = "Entry of processLoginOTPForm method....";
		String end = "End of processLoginOTPForm method....";
		logger.info(start);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(session,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";

		model.addAttribute("form", lp);
		String msg = null;

		String usernames = lp.getUsername();
		String otpvalue = lp.getOtpval();
		boolean flag = true;

		if (usernames != null && otpvalue != null) {
			if ((usernames.length() <= 0) || (otpvalue.length() <= 0)) {
				msg = finalmsg;
				flag = false;
			}
		} else {
			msg = finalmsg;
			flag = false;
		}
		String dbStudentid = "";
		String firstname = "";
		String emailid = "";
		String dbusername = "";

		if (flag == true) {
			List<Map<String, Object>> getstudentids = userservice.retriveStudentIDfromUsername(usernames);
			for (Map<String, Object> map : getstudentids) {
				Object dbstudentid1 = map.get(sidval);
				dbStudentid = String.valueOf(dbstudentid1);
				Object dbusername1 = map.get("user_name");
				dbusername = String.valueOf(dbusername1);
				Object dbotpvalue1 = map.get("OTP_Code");
				String dbotpvalue = String.valueOf(dbotpvalue1);
				Object dbfirstname1 = map.get(fnameval);
				firstname = String.valueOf(dbfirstname1);
				Object dbemailid1 = map.get(emailval);
				emailid = String.valueOf(dbemailid1);

				if (!(dbusername.equalsIgnoreCase(usernames))) {
					flag = false;
					msg = finalmsg;
				} else if (!(dbotpvalue.equalsIgnoreCase(otpvalue))) {
					flag = false;
					msg =finalmsg;
				} else {
					flag = true;
					session.setAttribute(sidval, dbStudentid);
					session.setAttribute(fnameval, firstname);
					session.setAttribute("email_id", emailid);
					session.setAttribute("uname", dbusername);
				}
			}
		}
		if (flag == true) {
			int roleid = userservice.getRoleIDfromUserRole(usernames);

			if (roleid == 1) {
				session.setAttribute("userrole", "userrole");
				return "forward:/load-welcomeUser";
			}
			if ((roleid == 2) || (roleid == 3) || (roleid == 4)) {
				lc.getpermissionsforloggedusers(model, dbStudentid);
				session.setAttribute("adminrole", "adminrole");
				return "adminUserHome";
			}
		}
		model.addAttribute("message", msg);

		logger.info(end);

		return "loginwithOTP";

	}

}
