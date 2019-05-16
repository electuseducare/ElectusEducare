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
public class AdminAddLocation {

	private static final Logger logger = LoggerFactory.getLogger(AdminAddLocation.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;

	@RequestMapping("/load-Locationform")
	public String loadLocationform(Model model, AdminCategory adc, HttpSession ses,HttpServletRequest req) {

		String start = "Entry of loadLocationform method....";
		String end = "End of loadLocationform method....";

		logger.info(start);

		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		model.addAttribute("adminbranch", adc);
		List<AdminCategory> statenames = adminuserservice.searchStateFromAdmin();
		model.addAttribute("statenames", statenames);

		logger.info(end);

		return "AdminAddLocation";
	}

	@RequestMapping("/process-Locationform")
	public String processLocationform(Model model, AdminCategory adc, HttpSession ses,HttpServletRequest req) {

		String start = "Entry of processLocationform method....";
		String end = "End of processLocationform method....";

		logger.info(start);

		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		String msg = null;
		int insertclassname = 0;
		String locationname = adc.getLocation().trim();
		String stateids = adc.getStatename();
		int stateid = (new Integer(stateids)).intValue();
		List<AdminCategory> value = adminuserservice.searchLocationsFromAdmin();
		for (AdminCategory adminCategory : value) {

			if (locationname.equalsIgnoreCase(adminCategory.getLocation())) {
				msg = "Location Name Already Exist";
				model.addAttribute("emsg", msg);
				return "forward:/load-Locationform";
			}

		}

		insertclassname = adminuserservice.insertLocationFromAdmin(locationname, stateid);
		if (insertclassname > 0) {
			msg = "Location Added Successfully";

		}
		model.addAttribute("admincategory", adc);
		model.addAttribute("smsg", msg);

		logger.info(end);

		return "forward:/load-Locationform";
	}
}
