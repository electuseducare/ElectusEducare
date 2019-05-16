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
import com.educare.model.MailPojo;
import com.educare.model.Register;
import com.educare.model.UserHomePojo;
import com.educare.services.AdminRegisterServiceImpl;
import com.educare.services.RegisterServiceImpl;
import com.educare.utility.EditPasswordTemplate;
import com.educare.utility.MailUtilities;

@Controller
public class UserProfileController {

	private static final Logger logger = LoggerFactory.getLogger(UserProfileController.class);

	@Autowired
	private RegisterServiceImpl userservice;

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;
	
	@Autowired
	private DatabaseValueController dv;

	private String uprofile = "uprofile";
	private String uname = "uname";

	@RequestMapping("/load-userProfile")
	public String processUserProfile(Model model, Register form1, UserHomePojo uh, HttpSession session,HttpServletRequest req) {

		String start = "Entry of processUserProfile method....";
		String end = "End of processUserProfile method....";
		logger.info(start);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(session,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";

		String username = (String) session.getAttribute(uname);
		List<Register> customers = userservice.getUserProfile1(username);
		for (Register row1 : customers) {
			model.addAttribute(uprofile, row1);
			model.addAttribute("classname", row1.getClassname());
			model.addAttribute("sectionname", row1.getSectionname());
			model.addAttribute("statename", row1.getStatename());
			model.addAttribute("locationname", row1.getLocationname());
			model.addAttribute("branchname", row1.getBranchname());
		}

		logger.info(end);

		return "userProfile";
	}

	@RequestMapping("/load-edit")
	public String processUserProfileEdit(Model model, Register form1, UserHomePojo uh, HttpSession session,HttpServletRequest req) {

		String start = "Entry of processUserProfileEdit method....";
		String end = "End of processUserProfileEdit method....";
		logger.info(start);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(session,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";

		model.addAttribute("editform", model);
		String username = (String) session.getAttribute(uname);
		List<Register> customers = userservice.getUserProfile(username);
		for (Register row1 : customers) {
			model.addAttribute(uprofile, row1);
		}

		logger.info(end);

		return "editProfile";
	}

	@RequestMapping("/load-update")
	public String processUserProfileUpdate(Model model, Register form1, UserHomePojo uh, HttpSession session,
			HttpServletRequest request) {

		String start = "Entry of processUserProfileUpdate method....";
		String end = "End of processUserProfileUpdate method....";
		logger.info(start);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(session,request);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";

		model.addAttribute("updateform", model);
		model.addAttribute(uprofile, model);
		model.addAttribute("editform", model);
		String username = (String) session.getAttribute(uname);
		String studentid = (String) session.getAttribute("student_id");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String phone = request.getParameter("mobile");
		String collegename = request.getParameter("college");
		List<Register> customers = userservice.getUserProfile(username);
		for (Register row1 : customers) {
			model.addAttribute(uprofile, row1);
		}
		userservice.updateUserProfile(firstname, lastname, email, phone, studentid, collegename);
		session.setAttribute("first_name", firstname);
		String msg = "Profile Updated Successfully";
		model.addAttribute("msg", msg);

		logger.info(end);

		return "forward:/load-edit";

	}

	@RequestMapping("load-changeUserPassword")
	public String changePasswordForUser(Model model, Register form1, HttpSession session,HttpServletRequest req) {

		String start = "Entry of changePasswordForUser method....";
		String end = "End of changePasswordForUser method....";
		logger.info(start);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(session,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";

		String smsg = null;
		String emsg = null;
		String studentid = (String) session.getAttribute("student_id");
		model.addAttribute("chnpass", form1);
		String school = (String) session.getAttribute("getschool");
		String currentpwd = form1.getPassword();
		if (currentpwd != null) {
			currentpwd = currentpwd.trim();
		}
		String newpwd = form1.getChangePassword();
		if (newpwd != null) {
			newpwd = newpwd.trim();
		}
		String confirmpwd = form1.getReenterpassword();
		if (confirmpwd != null) {
			confirmpwd = confirmpwd.trim();
		}
		String pass = userservice.getuserExistingPassword(studentid);
		List<Register> stulst = userservice.getStudentDetBaseOnId(studentid);
		if (pass.equals(currentpwd)) {
			if (newpwd.equals(confirmpwd)) {
				MailPojo mp = new MailPojo();
				mp.setMailSubject("Student Changed Password");

				List<Map<String, Object>> getempdet = adminuserservice.getMailId();
				if (!(getempdet.isEmpty())) {
					for (Map<String, Object> map : getempdet) {

						String enmail = (String) map.get("mail_type_id");
						String epwd = (String) map.get("mail_password");
						mp.setMailid(enmail);
						mp.setMailpwd(epwd);
					}
					String mailid = mp.getMailid();

					for (Register map : stulst) {

						form1.setUserid(map.getUserid());
						form1.setName(map.getName());
						form1.setLname(map.getLname());
						form1.setEmail_id(map.getEmail_id());

					}

					String email = form1.getEmail_id();
					ST stringTemplate = new ST(EditPasswordTemplate.updatPasswordProfile());
					stringTemplate.add("name", form1.getName());
					stringTemplate.add("lname", form1.getLname());
					stringTemplate.add("email", form1.getEmail_id());
					stringTemplate.add("uid", form1.getUserid());
					stringTemplate.add("pwd", newpwd);
					stringTemplate.add("sid", studentid);
					stringTemplate.add("school", school);
					mp.setMsgContent(stringTemplate.render());

					ArrayList<String> toList = new ArrayList<>();
					toList.add(mailid);
					toList.add(email);
					mp.setToRecipients(toList);
					try {
						MailUtilities.sendMail(mp);
					} catch (MessagingException e) {
						e.getMessage();
					}
				}
				userservice.changeUserPassword(studentid, newpwd);

				smsg = "Password updated successfully.";

			} else {
				emsg = "New password and confirm password does not match.";
			}
		} else {
			if (currentpwd != null) {
				emsg = "Enter password does not exist.";
			}

		}
		model.addAttribute("smsg", smsg);
		model.addAttribute("emsg", emsg);
		logger.info(end);

		return "userChangePassword";

	}

}
