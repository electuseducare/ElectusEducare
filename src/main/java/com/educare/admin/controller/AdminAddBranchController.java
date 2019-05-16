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
import com.educare.admin.model.AdminCategory;
import com.educare.controller.LoginController;
import com.educare.services.AdminRegisterServiceImpl;

@Controller
public class AdminAddBranchController {

	private static final Logger logger = LoggerFactory.getLogger(AdminAddBranchController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;

	String sidval = "student_id";
	String adbranchval = "adminbranch";
	String retrunjsp = "AdminAddBranch";

	@RequestMapping("/load-branchform")
	public String loadAdminDisplayStates(Model model, AdminCategory adc, HttpSession ses,HttpServletRequest req) {

		String start = "Entry of loadAdminDisplayStates method....";
		String end = "End of loadAdminDisplayStates method....";

		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		model.addAttribute(adbranchval, adc);
		List<AdminCategory> state = adminuserservice.searchStateFromAdmin();
		model.addAttribute("state", state);

		logger.info(end);

		return retrunjsp;
	}

	@RequestMapping("/load-branchform1")
	public String loadForgotPasswordPage(Model model, AdminCategory adc, HttpSession ses, HttpServletRequest req) {

		String start = "Entry of loadForgotPasswordPage method....";
		String end = "End of loadForgotPasswordPage method....";

		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		model.addAttribute(adbranchval, adc);
		String stateid = req.getParameter("stateid");
		List<AdminCategory> location = adminuserservice.searchLocationsFromAdminBasedonStates(stateid);
		model.addAttribute("location", location);

		logger.info(end);

		return retrunjsp;
	}

	@RequestMapping("/load-BranchesBasedonLocation1")
	public String branchesBasedonLocation(Model model, AdminCategory adc, HttpSession ses, HttpServletRequest req) {

		String start = "Entry of branchesBasedonLocation method....";
		String end = "End of branchesBasedonLocation method....";

		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		model.addAttribute(adbranchval, adc);
		String locationid = req.getParameter("locationid");

		List<AdminCategory> bracnh = adminuserservice.searchBranchesFromAdminBasedonLocation(locationid);

		model.addAttribute("bracnh1", bracnh);

		logger.info(end);

		return retrunjsp;
	}

	@RequestMapping("/process-branchform")
	public String loadAddBranchForm(Model model, AdminCategory adc, HttpSession ses,HttpServletRequest req) {

		String start = "Entry of loadAddBranchForm method....";
		String end = "End of loadAddBranchForm method....";

		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		String msg = null;
		int insertclassname = 0;
		String branchname = adc.getBranch().trim();
		String location = adc.getLocation();
		int locationid = (new Integer(location)).intValue();
		List<AdminCategory> value = adminuserservice.searchBranchesFromAdmin();
		for (AdminCategory adminCategory : value) {

			if (branchname.equalsIgnoreCase(adminCategory.getBranch())) {
				msg = "Branch Name Already Exist";
				model.addAttribute("emsg", msg);
				return "forward:/load-branchform";
			}

		}

		insertclassname = adminuserservice.insertBranchFromAdmin(branchname, locationid);
		if (insertclassname > 0) {
			msg = "Branch Added Successfully";

		}
		model.addAttribute("admincategory", adc);
		model.addAttribute("smsg", msg);

		logger.info(end);

		return "forward:/load-branchform";
	}
}
