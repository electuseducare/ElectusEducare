package com.educare.admin.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.stringtemplate.v4.ST;

import com.educare.DatabaseValueController;
import com.educare.admin.model.AdminAddNewStudent;
import com.educare.admin.model.AdminCategory;
import com.educare.admin.model.AdminEditStudentFormPojo;
import com.educare.controller.LoginController;
import com.educare.model.MailPojo;
import com.educare.services.AdminRegisterServiceImpl;
import com.educare.utility.EditPasswordTemplate;
import com.educare.utility.MailUtilities;
@Controller
public class AdminEditStudentController {

	private static final Logger logger = LoggerFactory.getLogger(AdminEditStudentController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;
	
	String sidval="student_id";
	String sval="student";
	

	@RequestMapping("/load-classfilterstudents")
	public String loadFilterClassnames(Model model, AdminAddNewStudent filter, HttpSession ses,HttpServletRequest req) {

		String start="Entry of loadFilterClassnames method....";
		String end="End of loadFilterClassnames method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		/************** Get class list ****************/
		List<AdminCategory> classnames = adminuserservice.searchClassesFromAdmin();
		model.addAttribute("classnames", classnames);
		
		model.addAttribute("filter", filter);

		logger.info(end);

		return "classFilterStudents";
	}

	@RequestMapping("/load-EditStudentform")
	public String editStudent(Model model, AdminAddNewStudent adc, AdminEditStudentFormPojo editpojo, HttpSession ses,HttpServletRequest req) {

		String start="Entry of editStudent method....";
		String end="End of editStudent method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		int buttonid = 0;
		List<AdminAddNewStudent> listval=null;
		if(adc.getStudentid().equals("0")){
			listval = adminuserservice.getUserNamenadEmailofAdminfromuser1(adc);
		}else{
			listval = adminuserservice.getUserNamenadEmailofAdminfromuser12(adc);
		}
		if (!listval.isEmpty()) {
			buttonid = 1;
		}
		editpojo.setStudentformlist(listval);
		List<AdminCategory> statenames = adminuserservice.searchStateFromAdmin();
		List<AdminCategory> classnames = adminuserservice.searchClassesFromAdmin();

		model.addAttribute("statenames", statenames);
		model.addAttribute("classnames", classnames);
		model.addAttribute("studentlistvalue", editpojo);
		model.addAttribute("buttonid", buttonid);

		logger.info(end);

		return "AdminEditStudent";
	}

	@RequestMapping("/load-branchform12")
	public @ResponseBody List<AdminCategory> loadLocationsFromStates12(Model model, AdminAddNewStudent adc,
			HttpSession ses, HttpServletRequest req) {

		String start="Entry of loadLocationsFromStates12 method....";
		String end="End of loadLocationsFromStates12 method....";
		logger.info(start);

		model.addAttribute(sval, adc);
		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		String stateid = req.getParameter("stateid");

		List<AdminCategory> location = adminuserservice.searchLocationsFromAdminBasedonStates(stateid);

		model.addAttribute("location", location);

		logger.info(end);

		return location;
	}

	@RequestMapping("/load-BranchesBasedonLocation12")
	public @ResponseBody List<AdminCategory> loadBranchesFromLocation12(Model model, AdminAddNewStudent adc,
			HttpSession ses, HttpServletRequest req) {

		String start="Entry of loadBranchesFromLocation12 method....";
		String end="End of loadBranchesFromLocation12 method....";
		logger.info(start);

		model.addAttribute(sval, adc);
		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		String locationid = req.getParameter("locationid");
		List<AdminCategory> branches = adminuserservice.searchBranchesFromAdminBasedonLocation(locationid);
		model.addAttribute("branches", branches);

		logger.info(end);

		return branches;
	}

	@RequestMapping("/get-sectiondetailsfromClass12")
	public @ResponseBody List<AdminCategory> loadSectionsFromClasses(Model model, AdminAddNewStudent adc,
			HttpSession ses, HttpServletRequest req) {

		String start="Entry of loadSectionsFromClasses method....";
		String end="End of loadSectionsFromClasses method....";
		logger.info(start);

		model.addAttribute(sval, adc);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		String classids = req.getParameter("classid");
		List<AdminCategory> sectiondetails = null;
		if (classids != null) {
			int classid = (new Integer(classids)).intValue();
			sectiondetails = adminuserservice.getsectionsfromClass(classid);
		}
		model.addAttribute("secitonnameval", sectiondetails);

		logger.info(end);

		return sectiondetails;
	}
	@RequestMapping("/get-studsfromClassNdSection")
	public @ResponseBody List<AdminCategory> getStudDetails(Model model, AdminAddNewStudent adc,
			HttpSession ses, HttpServletRequest req) {
		
		String start="Entry of getStudDetails method....";
		String end="End of getStudDetails method....";
		logger.info(start);
		
		model.addAttribute(sval, adc);
		
		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		String classids = req.getParameter("classid");
		String sectionids = req.getParameter("sectionid");
		List<AdminCategory> studedetails = null;
		if (classids != null && sectionids != null) {
			int classid = (new Integer(classids)).intValue();
			int sectionid = (new Integer(sectionids)).intValue();
			studedetails = adminuserservice.getStudentNames(classid,sectionid);
		}
		
		logger.info(end);
		
		return studedetails;
	}

	@RequestMapping("/load-processRolesModify")
	public String addReferenceData(Model model, AdminAddNewStudent adc, AdminEditStudentFormPojo editpojo,
			HttpSession ses,HttpServletRequest req) {

		String start="Entry of addReferenceData method....";
		String end="End of addReferenceData method....";
		logger.info(start);

		String school = (String) ses.getAttribute("getschool");
		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		String newuid = null;
		String username = null;
		String firstname = null;
		String lastname = null;
		String password = null;
		String email = null;
		String mobile = null;
		String sid = null;
		String stdclass = null;
		String section = null;
		String branch = null;
		String statenames = null;
		String locationname = null;
		String status = null;
		int update = 0;
		String msg = null;
		String emsg = null;
		int updateyes = 0;
		int buttonid = 1;
		
		List<AdminAddNewStudent> listval = editpojo.getStudentformlist();
		for (AdminAddNewStudent adminAddStudent : listval) {
			newuid = adminAddStudent.getUseridlist();
			if (newuid != null) {

				username = adminAddStudent.getUsername().trim();
				firstname = adminAddStudent.getFirstname().trim();
				lastname = adminAddStudent.getLastname().trim();
				password = adminAddStudent.getPassword().trim();
				mobile = adminAddStudent.getMobile().trim();
				sid = adminAddStudent.getStudentid();
				email = adminAddStudent.getEmail().trim();
				statenames = adminAddStudent.getState();
				locationname = adminAddStudent.getLocation();
				stdclass = adminAddStudent.getStudentclass();
				section = adminAddStudent.getSection();
				branch = adminAddStudent.getBranch();
				status = adminAddStudent.getStatus();

				if (firstname.length() != 0 && lastname.length() != 0 && username.length() != 0
						&& password.length() != 0 && email.length() != 0 && mobile.length() != 0
						&& !(locationname.equals("0")) && !(branch.equals("0")) && !(section.equals("0"))
						&& status.length() != 0) {
					
					List<Map<String, Object>> upass=adminuserservice.getPasswordBaseOnId(sid);
					for(Map<String, Object> map : upass){
						String pass=(String) map.get("password");
						adc.setPassword(pass);
					}
					String pass1=adc.getPassword();
					
					update = adminuserservice.updatestudentDetailsFromAdmin(sid, firstname, lastname, username, email,
							password, mobile, statenames, locationname, branch, stdclass, section, newuid, status);
					
					if(!password.equals(pass1)){
					MailPojo mp = new MailPojo();
					mp.setMailSubject("Student Changed Password");

					
					List<Map<String, Object>> getempdet = adminuserservice.getMailId();
					if (!(getempdet.isEmpty())){
					for (Map<String, Object> map : getempdet) {

						String enmail = (String) map.get("mail_type_id");
						String epwd = (String) map.get("mail_password");
						mp.setMailid(enmail);
						mp.setMailpwd(epwd);
					}
					String mailid = mp.getMailid();
					ST stringTemplate = new ST(EditPasswordTemplate.updatPasswordTemplate());
					stringTemplate.add("Lname", lastname);
					stringTemplate.add("Fname", firstname);
					stringTemplate.add("Uname", username);
					stringTemplate.add("pwd", password);
					stringTemplate.add("sid", sid);
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
				}}}
				if (update > 0) {
					updateyes++;
				}

			}
		}
		if (updateyes > 0) {

			
			
			
			msg = "Student record updated successfully";
			emsg = null;

		} else {
			emsg = "Please select atleast one entry and data should not be empty";
			msg = null;
		}

		model.addAttribute("buttonid", buttonid);
		model.addAttribute("smsg", msg);
		model.addAttribute("emsg", emsg);

		logger.info(end);

		return "forward:/load-classfilterstudents";

	}

}