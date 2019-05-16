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
public class AdminDeleteBranchController {

	private static final Logger logger = LoggerFactory.getLogger(AdminDeleteBranchController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private LoginController lc;

	@Autowired
	private DatabaseValueController dv;
	
	@RequestMapping("/load-Deletebranchform")
	public String deleteBranch(Model model, AdminCategory adc, AdminEditClassFormPojo editpojo, HttpSession ses,HttpServletRequest req) {

		String start = "Entry of deleteBranch method....";
		String end = "Entry of deleteBranch method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		int buttonid = 0;
		List<AdminCategory> listval = adminuserservice.searchBranchesFromAdmin();
		editpojo.setCategorylist(listval);
		if (!listval.isEmpty()) {
			buttonid = 1;
		}
		model.addAttribute("buttonid", buttonid);
		model.addAttribute("deletelistvalue", editpojo);

		logger.info(end);

		return "AdminDeleteBranch";
	}

	@RequestMapping("/load-processdeletebranchform")
	public String processDelBranch(Model model, AdminCategory adc, AdminEditClassFormPojo editpojo, HttpSession ses,HttpServletRequest req) {

		String start = "Entry of processDelBranch method....";
		String end = "Entry of processDelBranch method....";
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
			sectionid = adminCategory.getBranch();
			sectionname = adminCategory.getBranchcheckname();
			if (sectionid != null && sectionname != null) {

				update = adminuserservice.deleteBranch(sectionid);
				if (update > 0) {
					update++;
				}

			}

		}
		if (update > 0) {
			smsg = "Branch deleted successfully";
			msg = null;
		} else {
			msg = "Please select atleast one entry";
		}

		model.addAttribute("smsg", smsg);
		model.addAttribute("emsg", msg);
		model.addAttribute("buttonid", buttonid);
		model.addAttribute("categorylistvalue", editpojo);

		logger.info(end);

		return "forward:/load-Deletebranchform";
	}

}
