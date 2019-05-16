package com.educare.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.educare.DatabaseValueController;
import com.educare.admin.model.AdminAddNewStudent;
import com.educare.admin.model.AdminCategory;
import com.educare.controller.LoginController;
import com.educare.model.Register;
import com.educare.services.AdminRegisterServiceImpl;
import com.educare.services.RegisterServiceImpl;

@Controller
public class AdminAddStudentController {

	private static final Logger logger = LoggerFactory.getLogger(AdminAddStudentController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private RegisterServiceImpl userservice;

	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;

	String sval = "student";
	String returnjsp = "AdminaAddStudent";
	String sidval = "student_id";

	@RequestMapping("/load-studentform")
	public String loadStudForm(Model model, AdminAddNewStudent adc, HttpSession ses,HttpServletRequest req) {

		String start = "Entry of loadStudForm method....";
		String end = "End of loadStudForm method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		model.addAttribute(sval, adc);
		List<AdminCategory> statenames = adminuserservice.searchStateFromAdmin();

		AdminCategory test = new AdminCategory();
		test.setCategoryid("0");
		test.setCategory("--Select One--");
		List<AdminCategory> classnames = adminuserservice.searchClassesFromAdmin();
		classnames.add(test);

		model.addAttribute("statenames", statenames);
		model.addAttribute("classnames", classnames);

		logger.info(end);

		return returnjsp;
	}

	@RequestMapping("/load-branchform11")
	public String loadBranchform11(Model model, AdminAddNewStudent adc, HttpSession ses, HttpServletRequest req) {

		String start = "Entry of loadBranchform11 method....";
		String end = "End of loadBranchform11 method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		model.addAttribute(sval, adc);
		String stateid = req.getParameter("stateid");
		List<AdminCategory> location = adminuserservice.searchLocationsFromAdminBasedonStates(stateid);
		model.addAttribute("location", location);

		logger.info(end);

		return returnjsp;
	}

	@RequestMapping("/load-BranchesBasedonLocation11")
	public String loadBranchesFromLocation(Model model, AdminAddNewStudent adc, HttpSession ses,
			HttpServletRequest req) {

		String start = "Entry of loadBranchesFromLocation method....";
		String end = "End of loadBranchesFromLocation method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		model.addAttribute(sval, adc);
		String locationid = req.getParameter("locationid");

		List<AdminCategory> bracnh = adminuserservice.searchBranchesFromAdminBasedonLocation(locationid);

		model.addAttribute("bracnh1", bracnh);

		logger.info(end);

		return returnjsp;
	}

	@RequestMapping("/get-sectiondetailsfromClass11")
	public String loadSectionsFromClasses(Model model, AdminAddNewStudent adc, HttpSession ses,
			HttpServletRequest req) {

		String start = "Entry of loadSectionsFromClasses method....";
		String end = "End of loadSectionsFromClasses method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		model.addAttribute(sval, adc);
		String classids = req.getParameter("classid");
		if (classids != null) {
			int classid = (new Integer(classids)).intValue();
			List<AdminCategory> sectiondetails = adminuserservice.getsectionsfromClass(classid);

			model.addAttribute("secitonnameval", sectiondetails);

		}
		logger.info(end);

		return returnjsp;
	}

	@RequestMapping("/load-ProcessStudent")
	public String addStudentData(Model model, AdminAddNewStudent adstud, Register reg, HttpSession ses,HttpServletRequest req) {

		String start = "Entry of addStudentData method....";
		String end = "End of addStudentData method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		String smsg = null;
		String emsg = null;

		int insertrole = 0;
		int studrole = 1;

		String firstname = adstud.getFirstname();
		String lastname = adstud.getLastname();
		String username = adstud.getUsername();
		String pass = adstud.getPassword();
		String state = adstud.getStatename();
		String location = adstud.getLocation();
		String branch = adstud.getBranch();
		String stcls = adstud.getStudentclass();
		String section = adstud.getSection();
		String email = adstud.getEmail();
		String phone = adstud.getMobile();

		// generating ids
		studentid = userservice.generateStudentID();

		// Check if Exist User Or Not
		int exstuser = adminuserservice.getUserNamenadEmailofAdminfromuser2(adstud);

		if (exstuser > 0) {
			emsg = "Given username or email id is already exist.";
			model.addAttribute("emsg", emsg);
			model.addAttribute(sval, adstud);

			return "forward:/load-studentform";
		}

		// create student from admin

		int insertstudentdetails = adminuserservice.insertstudentDetailsFromAdmin(studentid, firstname, lastname,
				username, pass, state, location, branch, stcls, section, email, phone);
		insertrole = userservice.getUserIDfromUsers(username);
		userservice.insertUserRole(insertrole, studrole);
		if (insertstudentdetails > 0 && insertrole > 0) {
			smsg = "Student Added Successfully";
		}
		model.addAttribute("smsg", smsg);
		model.addAttribute(sval, adstud);

		logger.info(end);

		return "forward:/load-studentform";
	}

}
