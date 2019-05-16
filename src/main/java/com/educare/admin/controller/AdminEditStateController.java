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
public class AdminEditStateController {

	private static final Logger logger = LoggerFactory.getLogger(AdminEditStateController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private LoginController lc;

	@Autowired
	private DatabaseValueController dv;
	
	@RequestMapping("/load-EditStateform")
	public String editState(Model model, AdminCategory adc, AdminEditClassFormPojo editpojo, HttpSession ses,HttpServletRequest req) {

		String start = "Entry of editState method....";
		String end = "End of editState method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		int buttonid = 0;
		List<AdminCategory> listval = adminuserservice.searchStateFromAdmin();
		if (!listval.isEmpty()) {
			buttonid = 1;
		}
		model.addAttribute("buttonid", buttonid);
		editpojo.setCategorylist(listval);

		model.addAttribute("categorylistvalue", editpojo);

		logger.info(end);

		return "AdminEditState";
	}

	@RequestMapping("/load-processeditstateform")
	public String processEditState(Model model, AdminCategory adc, AdminEditClassFormPojo editpojo, HttpSession ses,HttpServletRequest req) {

		String start = "Entry of processEditState method....";
		String end = "End of processEditState method....";
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
		int update = 0;
		int buttonid = 1;
		List<AdminCategory> listcheck = editpojo.getCategorylist();

		for (AdminCategory adminCategory : listcheck) {
			sectionid = adminCategory.getStatechckbox();
			if (adminCategory.getStatename() != null) {
				sectionname = adminCategory.getStatename().trim();
			} else {
				sectionname = adminCategory.getStatename();
			}
			if (sectionid != null && sectionname.length() != 0) {

				int value = adminuserservice.searchstateFromAdmin1(sectionname);

				if (value <= 0) {
					update = adminuserservice.updateState(sectionname, sectionid);

					update++;
				}

			}

		}

		if (update > 0) {
			smsg = "State updated successfully";
			msg = null;
		} else {
			msg = "Please select atleast one entry and state should not be exist / empty ";
		}

		model.addAttribute("smsg", smsg);
		model.addAttribute("emsg", msg);
		model.addAttribute("buttonid", buttonid);
		model.addAttribute("categorylistvalue", editpojo);

		logger.info(end);

		return "forward:/load-EditStateform";
	}
}