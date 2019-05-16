package com.educare.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.educare.model.MailPojo;
import com.educare.model.Register;
import com.educare.services.RegisterServiceImpl;
import com.educare.utility.MailUtilities;

import org.slf4j.Logger;

@Controller
public class RegisterationController {

	private static final Logger logger = LoggerFactory.getLogger(RegisterationController.class);

	@Autowired
	private RegisterServiceImpl userservice;

	@RequestMapping("/Register")
	public String viewRegister(Model model, Register form) {

		String start = "Entry of viewRegister method....";
		String end = "End of viewRegister method....";
		logger.info(start);

		model.addAttribute("form", form);

		logger.info(end);

		return "Register";
	}

	@SuppressWarnings("static-access")
	@RequestMapping(value = "/addregister", method = RequestMethod.POST)
	public String registerprocessStudent(@ModelAttribute("regForm") Register register, BindingResult result,
			Model model, HttpSession session) {

		String start = "Entry of registerprocessStudent method....";
		String end = "End of registerprocessStudent method....";
		logger.info(start);

		List<Register> regdetails = userservice.findAll(register);
		model.addAttribute("register", register);
		String inp = register.getName();
		String lastname = register.getLname();
		String username = register.getUsername();
		Pattern choicepattern = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		Matcher namematch = choicepattern.matcher(inp);
		Matcher lastnamematch = choicepattern.matcher(lastname);

		if (namematch.find() || lastnamematch.find()) {
			String msg1 = "Please Do Not Add Special Characters";
			model.addAttribute("msg", msg1);
			model.addAttribute("register", register);
		}

		else {

			for (Register reg : regdetails) {

				if (reg.getUsername().equals(register.getUsername())) {
					String msg = "Username is already exist!Please Try With Different Username";
					model.addAttribute("msg", msg);
					return "Register";
				}

				if (reg.getEmail_id().equals(register.getEmail_id())) {
					String msg = "Eamil Already Exist!Please Try With Different Email Id";
					model.addAttribute("msg", msg);
					return "Register";
				}
				if (reg.getMobile_Number() == register.getMobile_Number()) {
					String msg = "MobileNo Already Exist!Please Try With Different MobileNo";
					model.addAttribute("msg", msg);
					return "Register";
				}

			}
			MailUtilities mailutil = new MailUtilities();
			MailPojo mp = new MailPojo();
			String mailid = register.getEmail_id();
			boolean validatin = mailutil.isValidEmail(mailid);
			if (validatin == false) {
				String msg = "Eamil Address Invalid!Please Try With Different Email Id";
				model.addAttribute("msg", msg);
				return "Register";
			}

			userservice.register(register);
			int uid = userservice.getUserIDfromUsers(username);
			int rid = 1;
			userservice.insertUserRole(uid, rid);
			String smsg = "Registration Done Successfully";
			model.addAttribute("smsg", smsg);
			mp.setMailSubject("Electus Registration Successfull");
			mp.setMsgContent("Dear User Welcome To Electus");

			ArrayList<String> toList = new ArrayList<>();
			toList.add(register.getEmail_id());

			mp.setToRecipients(toList);
			try {
				MailUtilities.sendMail(mp);
			} catch (MessagingException e) {

			}
			String sms = "Registration Done Successfully!UserId and Password Shared With Your Email Id.";
			model.addAttribute("smsg", sms);
		}

		logger.info(end);

		return "Register";

	}

}
