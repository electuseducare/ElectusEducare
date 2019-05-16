package com.educare.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import org.slf4j.Logger;
@Controller
public class AdminDeleteStateController {

	private static final Logger logger = LoggerFactory.getLogger(AdminDeleteStateController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;

	@RequestMapping("/load-Deletestateform")
	public String deleteState(Model model, AdminCategory adc, AdminEditClassFormPojo editpojo, HttpSession ses,HttpServletRequest req) {

		String start = "Entry of deleteState method....";
		String end = "Entry of deleteState method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		int buttonid1 = 0;
		List<AdminCategory> listval = adminuserservice.searchStateFromAdmin();
		if (!listval.isEmpty()) {
			buttonid1 = 1;
		}
		editpojo.setCategorylist(listval);
		model.addAttribute("buttonid", buttonid1);
		model.addAttribute("deletelistvalue", editpojo);

		logger.info(end);

		return "AdminDeleteState";
	}

	@RequestMapping("/load-processdeletestateform")
	public String processDelState(Model model, AdminCategory adc, AdminEditClassFormPojo editpojo,
			HttpSession ses,HttpServletRequest req) {

		String start = "Entry of processDelState method....";
		String end = "Entry of processDelState method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		String sectionname = null;
		String sectionid = null;
		String msg = null;
		String smsg = null;
		int buttonid = 1;
		int update = 0;
		List<AdminCategory> listcheck = editpojo.getCategorylist();
		for (AdminCategory adminCategory : listcheck) {
			sectionid = adminCategory.getStatechckbox();
			sectionname = adminCategory.getStatename();
			if (sectionid != null && sectionname != null) {

				update = adminuserservice.deleteState(sectionid);
				adminuserservice.deleteLocationbasedonState(sectionid);
				if (update > 0) {
					update++;
				}
			}

		}

		if (update > 0) {
			smsg = "State deleted successfully";
			msg = null;
		} else {
			msg = "Please select atleast one entry";
		}

		model.addAttribute("smsg", smsg);
		model.addAttribute("emsg", msg);
		model.addAttribute("buttonid", buttonid);
		model.addAttribute("categorylistvalue", editpojo);

		logger.info(end);

		return "forward:/load-Deletestateform";
	}

}
