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
import com.educare.admin.model.AdminEditSubjectFormPojo;
import com.educare.controller.LoginController;
import com.educare.services.AdminRegisterServiceImpl;

import org.slf4j.Logger;

@Controller
public class AdminEditSubjectController {

	private static final Logger logger = LoggerFactory.getLogger(AdminEditSubjectController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;

	@RequestMapping("/load-EditSubjectform")
	public String editSubject(Model model, AdminCategory adc, AdminEditSubjectFormPojo editpojo, HttpSession ses,HttpServletRequest req) {

		String start = "Entry of editSubject method....";
		String end = "End of editSubject method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		int buttonid = 0;
		List<AdminCategory> listval = adminuserservice.searchSubjectFromAdmin();
		if (!listval.isEmpty()) {
			buttonid = 1;
		}
		editpojo.setSubjectlist(listval);
		model.addAttribute("buttonid", buttonid);
		model.addAttribute("categorylistvalue", editpojo);

		logger.info(end);

		return "AdminEditSubject";
	}

	@RequestMapping("/load-processSubjectform")
	public String processSubject(Model model, AdminCategory adc, AdminEditSubjectFormPojo editpojo, HttpSession ses,HttpServletRequest req) {

		String start = "Entry of processSubject method....";
		String end = "End of processSubject method....";
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
		String classname = null;
		List<AdminCategory> listcheck = editpojo.getSubjectlist();
		for (AdminCategory adminCategory : listcheck) {
			sectionid = adminCategory.getSubject();
			if (adminCategory.getSubjectcheckvalue() != null) {
				sectionname = adminCategory.getSubjectcheckvalue().trim();
			} else {
				sectionname = adminCategory.getSubjectcheckvalue();
			}
			classname = adminCategory.getHiddenclassname();
			if (sectionid != null && sectionname != null && sectionid.length() != 0) {

				int value = adminuserservice.searchSubjectFromAdmin1(sectionid, classname);
				if (value <= 0) {
					update = adminuserservice.updateSubject(sectionid, sectionname);

					update++;
				}

			}

		}
		if (update > 0) {
			smsg = "Subject updated successfully";
			msg = null;
		} else {
			msg = "Please select atleast one entry and subject should not be exist / empty";
		}

		model.addAttribute("smsg", smsg);
		model.addAttribute("emsg", msg);
		model.addAttribute("buttonid", buttonid);
		model.addAttribute("categorylistvalue", editpojo);

		logger.info(end);

		return "forward:/load-EditSubjectform";
	}
}
