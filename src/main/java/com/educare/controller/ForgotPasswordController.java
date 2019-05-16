package com.educare.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.stringtemplate.v4.ST;

import com.educare.DatabaseValueController;
import com.educare.model.LoginPojo;
import com.educare.model.MailPojo;
import com.educare.services.AdminRegisterServiceImpl;
import com.educare.services.RegisterServiceImpl;
import com.educare.utility.EditPasswordTemplate;
import com.educare.utility.MailUtilities;
@Controller
public class ForgotPasswordController {

	private static final Logger logger = LoggerFactory.getLogger(ForgotPasswordController.class);

	@Autowired
	private RegisterServiceImpl userservice;
	
	@Autowired
	private AdminRegisterServiceImpl adminuserservice;
	
	@Autowired
	private DatabaseValueController dv;

	@RequestMapping("/load-forgotPassword")
	public String loadForgotPasswordPage(Model model, LoginPojo lp,HttpSession ses,HttpServletRequest req) {
		
		String start="Entry of loadForgotPasswordPage method....";
		String end="End of loadForgotPasswordPage method....";
		logger.info(start);

		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		model.addAttribute("forgotform", lp);

		logger.info(end);

		return "forgotPassword";
	}

	@RequestMapping("/process-forgotform")
	public String processForgotPasswordPage(Model model, LoginPojo lp,HttpSession ses,HttpServletRequest req) {

		String start="Entry of processForgotPasswordPage method....";
		String end="End of processForgotPasswordPage method....";
		logger.info(start);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		String school = (String) ses.getAttribute("getschool");
		model.addAttribute("forgotform", lp);
		String emailid = lp.getEmail();
		String dbEmail = null;
		String password = null;
		List<Map<String, Object>> getPasswords = userservice.getPasswordFromForgotPasswordPage(emailid);
		if (getPasswords.isEmpty()) {
			String message1 = "Please enter valid email id to recover password! or Please register to continue";
			model.addAttribute("message1", message1);
		} else {
			for (Map<String, Object> map : getPasswords) {
				password = (String) map.get("password");
				dbEmail = (String) map.get("email");
			}
			if (lp.getEmail().equals(dbEmail)) {

				MailPojo mp = new MailPojo();

				mp.setMailSubject("Your Login Password");
				List<Map<String, Object>> getempdet = adminuserservice.getMailId();
				if (!(getempdet.isEmpty())){
				for (Map<String, Object> map : getempdet) {

					String enmail = (String) map.get("mail_type_id");
					String epwd = (String) map.get("mail_password");
					mp.setMailid(enmail);
					mp.setMailpwd(epwd);
				}
				ST stringTemplate = new ST(EditPasswordTemplate.updatPassword());
				stringTemplate.add("password", password);
				stringTemplate.add("school", school);
				mp.setMsgContent(stringTemplate.render());
				ArrayList<String> toList = new ArrayList<>();
				toList.add(emailid);
				mp.setToRecipients(toList);
				try {
					MailUtilities.sendMail(mp);
				} catch (MessagingException e) {

				}}

				String message = "Password has been sent to your email id. Please check your email id";
				model.addAttribute("message", message);

			} else {
				String message1 = "Please enter valid email id to recover password! or Please register to continue";
				model.addAttribute("message1", message1);
			}

		}

		logger.info(end);

		return "forgotPassword";
	}

}
