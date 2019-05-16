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
import com.educare.controller.LoginController;
import com.educare.services.AdminRegisterServiceImpl;

import org.slf4j.Logger;

@Controller
public class AdminAddSectionController {

	private static final Logger logger = LoggerFactory.getLogger(AdminAddSectionController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;

	@RequestMapping("/load-sectionform")
	public String loadAdminAddSectionPage(Model model, AdminCategory adc, HttpSession ses,HttpServletRequest req) {

		String start = "Entry of loadAdminAddSectionPage method....";
		String end = "End of loadAdminAddSectionPage method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		model.addAttribute("adminsection", adc);
		List<AdminCategory> classnames = adminuserservice.searchClassesFromAdmin();
		model.addAttribute("classnames", classnames);

		logger.info(end);

		return "AdminAddSection";
	}

	@RequestMapping("/process-sectionform")
	public String processSectionForm(Model model, AdminCategory adc, HttpSession ses,HttpServletRequest req) {

		String start = "Entry of processSectionForm method....";
		String end = "End of processSectionForm method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		String msg = null;
		int insertsectionname = 0;
		String sectionname = adc.getSection();
		String classname = adc.getClassname();
		int cnameid = (new Integer(classname)).intValue();
		List<AdminCategory> value = adminuserservice.searchSectionFromAdmin1(cnameid);

		for (AdminCategory adminCategory : value) {

			if (sectionname.equalsIgnoreCase(adminCategory.getSection())) {
				msg = "Section Name Already Exist";
				model.addAttribute("emsg", msg);
				return "forward:/load-sectionform";
			}

		}

		insertsectionname = adminuserservice.insertSectionsFromAdmin(sectionname, cnameid);
		if (insertsectionname > 0) {
			msg = "Section Added Successfully";

		}
		model.addAttribute("admincategory", adc);
		model.addAttribute("smsg", msg);

		logger.info(end);

		return "forward:/load-sectionform";
	}

}
