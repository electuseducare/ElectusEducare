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
import com.educare.admin.model.AdminEditClassFormPojo;
import com.educare.controller.LoginController;
import com.educare.services.AdminRegisterServiceImpl;

@Controller
public class AdminEditLocationController {

	private static final Logger logger = LoggerFactory.getLogger(AdminEditLocationController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;

	@RequestMapping("/load-EditLocationform")
	public String editLocation(Model model, AdminCategory adc, AdminEditClassFormPojo editpojo, HttpSession ses,HttpServletRequest req) {

		String start = "Entry of EditLocation method....";
		String end = "End of EditLocation method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		int buttonid = 0;

		List<AdminCategory> listval = adminuserservice.searchLocationsFromAdmin();
		if (!listval.isEmpty()) {
			buttonid = 1;
		}

		editpojo.setCategorylist(listval);
		model.addAttribute("buttonid", buttonid);
		model.addAttribute("categorylistvalue", editpojo);

		logger.info(end);

		return "AdminEditLocation";
	}

	@RequestMapping("/load-processLocationform")
	public String processLocation(Model model, AdminCategory adc, AdminEditClassFormPojo editpojo, HttpSession ses,
			HttpServletRequest req) {

		String start = "Entry of processLocation method....";
		String end = "End of processLocation method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		String locationname = null;
		String location = null;
		String state = null;
		String msg = null;
		String smsg = null;
		int update = 0;
		int buttonid = 1;
		List<AdminCategory> listcheck = editpojo.getCategorylist();
		for (AdminCategory adminCategory : listcheck) {
			location = adminCategory.getLocation();
			if (adminCategory.getLoactioncheckvalue() != null) {
				locationname = adminCategory.getLoactioncheckvalue().trim();
			} else {
				locationname = adminCategory.getLoactioncheckvalue();
				locationname = "0";
			}
			state = adminCategory.getHiddenstatename();

			if (locationname.length() != 0 && location != null) {
				int value = adminuserservice.searchLocationsFromAdmin1(locationname, state);
				if (value <= 0) {
					update = adminuserservice.updateLocation(locationname, location);
					update++;
				}
			}

		}
		if (update > 0) {
			smsg = "Location updated successfully";
			msg = null;
		} else {
			msg = "Please select atleast one entry and location should not be exist / empty";
		}

		model.addAttribute("smsg", smsg);
		model.addAttribute("emsg", msg);
		model.addAttribute("buttonid", buttonid);
		model.addAttribute("categorylistvalue", editpojo);

		logger.info(end);

		return "forward:/load-EditLocationform";
	}
}
