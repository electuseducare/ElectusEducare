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
public class AdminEditBranchController {

	private static final Logger logger = LoggerFactory.getLogger(AdminEditBranchController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;

	@RequestMapping("/load-EditBranchform")
	public String editBranch(Model model, AdminCategory adc, AdminEditClassFormPojo editpojo, HttpSession ses,HttpServletRequest req) {

		String start = "Entry of editBranch method....";
		String end = "End of editBranch method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		int buttonid = 0;
		List<AdminCategory> listval = adminuserservice.searchBranchesFromAdmin();
		if (!listval.isEmpty()) {
			buttonid = 1;
		}
		editpojo.setCategorylist(listval);
		model.addAttribute("buttonid", buttonid);
		model.addAttribute("categorylistvalue", editpojo);

		logger.info(end);

		return "AdminEditBranch";
	}

	@RequestMapping("/load-processbranchform")
	public String loadprocesscategory(Model model, AdminCategory adc, AdminEditClassFormPojo editpojo,
			HttpSession ses,HttpServletRequest req) {

		String start = "Entry of loadprocesscategory method....";
		String end = "End of loadprocesscategory method....";
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
		String location = null;
		String stateid = null;
		List<AdminCategory> listcheck = editpojo.getCategorylist();
		for (AdminCategory adminCategory : listcheck) {
			sectionid = adminCategory.getBranch();
			if (adminCategory.getBranchcheckname() != null) {
				sectionname = adminCategory.getBranchcheckname().trim();
			} else {
				sectionname = adminCategory.getBranchcheckname();
			}
			location = adminCategory.getHiddenlocationname();
			stateid = adminCategory.getHiddenstateid();
			if (sectionid != null && sectionname.length() != 0) {

				int value = adminuserservice.searchBranchesFromAdmin1(sectionname, location, stateid);

				if (value <= 0) {

					update = adminuserservice.updateBranch(sectionname, sectionid);
					update++;
				}
			}

			if (update > 0) {
				smsg = "Branch updated successfully";
				msg = null;
			} else {
				msg = "Please select atleast one entry and branch should not be exist / empty";
			}
		}

		model.addAttribute("smsg", smsg);
		model.addAttribute("emsg", msg);
		model.addAttribute("buttonid", buttonid);
		model.addAttribute("categorylistvalue", editpojo);

		logger.info(end);

		return "forward:/load-EditBranchform";
	}

}
