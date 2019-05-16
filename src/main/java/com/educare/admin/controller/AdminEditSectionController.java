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
public class AdminEditSectionController {

	private static final Logger logger = LoggerFactory.getLogger(AdminEditSectionController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;

	@RequestMapping("/load-Editsectionform")
	public String editsection(Model model, AdminCategory adc, AdminEditClassFormPojo editpojo, HttpSession ses,HttpServletRequest req) {

		String start = "Entry of editsection method....";
		String end = "End of editsection method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		int buttonid = 0;
		List<AdminCategory> listval = adminuserservice.searchSectionFromAdmin();
		if (!listval.isEmpty()) {
			buttonid = 1;
		}
		editpojo.setCategorylist(listval);
		model.addAttribute("buttonid", buttonid);
		model.addAttribute("categorylistvalue", editpojo);

		logger.info(end);

		return "AdminEditSection";
	}

	@RequestMapping("/load-processsectionform")
	public String processSection(Model model, AdminCategory adc, AdminEditClassFormPojo editpojo, HttpSession ses,HttpServletRequest req) {

		String start = "Entry of processSection method....";
		String end = "End of processSection method....";
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
		String classname = null;
		int update = 0;
		int buttonid = 1;
		List<AdminCategory> listcheck = editpojo.getCategorylist();
		for (AdminCategory adminCategory : listcheck) {
			sectionid = adminCategory.getSection();
			if (adminCategory.getSectioncheckname() != null) {
				sectionname = adminCategory.getSectioncheckname().trim();
			} else {
				sectionname = adminCategory.getSectioncheckname();
			}
			classname = adminCategory.getHiddenclassname();
			if (sectionid != null && sectionname.length() != 0) {
				int value = adminuserservice.searchSectionFromAdmin1(sectionname, classname);
				if (value <= 0) {
					update = adminuserservice.updateSection(sectionname, sectionid);

					update++;
				}

			}

		}
		if (update > 0) {
			smsg = "Section updated successfully";
			msg = null;

		} else {
			msg = "Please select atleast one entry and section should not be exist / empty";
		}

		model.addAttribute("smsg", smsg);
		model.addAttribute("emsg", msg);
		model.addAttribute("buttonid", buttonid);
		model.addAttribute("categorylistvalue", editpojo);

		logger.info(end);

		return "forward:/load-Editsectionform";
	}
}
