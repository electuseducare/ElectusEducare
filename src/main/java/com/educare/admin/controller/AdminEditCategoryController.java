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
public class AdminEditCategoryController {

	private static final Logger logger = LoggerFactory.getLogger(AdminEditCategoryController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;

	String sidval = "student_id";
	String btnval = "buttonid";
	String catval = "categorylistvalue";

	@RequestMapping("/load-Editcategoryform")
	public String editcategory(Model model, AdminCategory adc, AdminEditClassFormPojo editpojo, HttpSession ses,HttpServletRequest req) {

		String start = "Entry of editcategory method....";
		String end = "End of editcategory method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		int buttonid1 = 0;
		List<AdminCategory> listval = adminuserservice.searchClassesFromAdmin();
		if (!listval.isEmpty()) {
			buttonid1 = 1;
		}
		editpojo.setCategorylist(listval);
		model.addAttribute(btnval, buttonid1);
		model.addAttribute(catval, editpojo);

		logger.info(end);

		return "AdminEditCategory";
	}

	@RequestMapping("/load-Deletecategoryform")
	public String deleteCategory(Model model, AdminCategory adc, AdminEditClassFormPojo editpojo, HttpSession ses,HttpServletRequest req) {

		String start = "Entry of deleteCategory method....";
		String end = "End of deleteCategory method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		int buttonid = 0;
		List<AdminCategory> listval = adminuserservice.searchClassesFromAdmin();
		if (!listval.isEmpty()) {
			buttonid = 1;
		}
		editpojo.setCategorylist(listval);
		model.addAttribute(btnval, buttonid);
		model.addAttribute("deletelistvalue", editpojo);

		logger.info(end);

		return "AdminDeleteCategory";
	}

	@RequestMapping("/load-processcategoryform")
	public String loadprocesscategory(Model model, AdminCategory adc, AdminEditClassFormPojo editpojo,
			HttpSession ses,HttpServletRequest req) {

		String start = "Entry of loadprocesscategory method....";
		String end = "End of loadprocesscategory method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		String classname = null;
		String classid = null;
		String msg = null;
		String smsg = null;
		int update = 0;
		int buttonid = 1;
		List<AdminCategory> listcheck = editpojo.getCategorylist();
		for (AdminCategory adminCategory : listcheck) {
			classid = adminCategory.getCategory();
			if (adminCategory.getCategoryname() != null) {
				classname = adminCategory.getCategoryname().trim();
			} else {
				classname = adminCategory.getCategoryname();
			}
			if (classid != null && classname.length() != 0) {
				int value = adminuserservice.searchClassesFromAdmin1(classname);
				if (value <= 0) {
					update = adminuserservice.updateclass(classname, classid);

					update++;
				}

			}

		}

		if (update > 0) {
			smsg = "Class updated successfully";
			msg = null;
		} else {
			msg = "Please select atleast one entry and class should not be exist / empty";
		}

		model.addAttribute("smsg", smsg);
		model.addAttribute("emsg", msg);
		model.addAttribute(btnval, buttonid);
		model.addAttribute(catval, editpojo);

		logger.info(end);

		return "forward:/load-Editcategoryform";
	}

	@RequestMapping("/load-processdeletecategoryform")
	public String loadprocessdeletecategory(Model model, AdminCategory adc, AdminEditClassFormPojo editpojo,
			HttpSession ses,HttpServletRequest req) {

		String start = "Entry of loadprocessdeletecategory method....";
		String end = "End of loadprocessdeletecategory method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		String classname = null;
		String classid = null;
		String msg = null;
		String smsg = null;
		int update = 0;
		int buttonid = 1;
		List<AdminCategory> listcheck = editpojo.getCategorylist();
		for (AdminCategory adminCategory : listcheck) {
			classid = adminCategory.getCategory();
			classname = adminCategory.getCategoryname();
			if (classid != null && classname != null) {

				update = adminuserservice.deleteclass(classid);
				adminuserservice.deleteSubjectbasedonClass(classid);
				adminuserservice.deleteSectionbasedonClass(classid);
				adminuserservice.deleteSujectTopicsOnClass(classid);
				if (update > 0) {
					update++;
				}

			}

		}

		if (update > 0) {
			smsg = "Class deleted successfully";
			msg = null;
		} else {
			msg = "Please select atleast one entry";
		}

		model.addAttribute("smsg", smsg);
		model.addAttribute("emsg", msg);
		model.addAttribute(btnval, buttonid);
		model.addAttribute(catval, editpojo);

		logger.info(end);

		return "forward:/load-Deletecategoryform";
	}

}
