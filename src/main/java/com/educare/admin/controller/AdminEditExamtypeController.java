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
import com.educare.admin.model.AdminEditExamtypeFormPojo;
import com.educare.controller.LoginController;
import com.educare.services.AdminRegisterServiceImpl;

import org.slf4j.Logger;
@Controller
public class AdminEditExamtypeController {

	private static final Logger logger = LoggerFactory.getLogger(AdminEditExamtypeController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;
	
	String sidval="student_id";
	String btnval="buttonid";
	String catval="categorylistvalue";

	@RequestMapping("/load-EditExamtypeform")
	public String editExamtype(Model model, AdminCategory adc, AdminEditExamtypeFormPojo editpojo, HttpSession ses,HttpServletRequest req) {

		String start="Entry of editExamtype method....";
		String end="End of editExamtype method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		int buttonid = 0;
		List<AdminCategory> listval = adminuserservice.searchExamtypeFromAdmin();
		if (!listval.isEmpty()) {
			buttonid = 1;
		}
		editpojo.setExamtypelist(listval);
		model.addAttribute(btnval, buttonid);
		model.addAttribute(catval, editpojo);

		logger.info(end);

		return "AdminEditExamtype";
	}

	@RequestMapping("/load-processExamtypeform")
	public String processExamtypeForm(Model model, AdminCategory adc, AdminEditExamtypeFormPojo editpojo,
			HttpSession ses,HttpServletRequest req) {

		String start="Entry of processExamtypeForm method....";
		String end="End of processExamtypeForm method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		String examtype = null;
		String examtypeid = null;
		String msg = null;
		String smsg = null;
		int update = 0;
		int buttonid = 1;
		List<AdminCategory> listcheck = editpojo.getExamtypelist();
		for (AdminCategory adminCategory : listcheck) {
			examtypeid = adminCategory.getExamtypeckeckbox();
			if(adminCategory.getExamtype_name()!=null){
				examtype = adminCategory.getExamtype_name().trim();
				}else{
					examtype = adminCategory.getExamtype_name();
				}
			if (examtypeid != null && examtype.length() != 0) {
				int value = adminuserservice.searchExamtypeFromAdmin1(examtype);
				if (value <= 0) {
					update = adminuserservice.updateEXamtype(examtype, examtypeid);

					update++;
				}

			}

		}

		if (update > 0) {
			smsg = "Examtype updated successfully";
			msg = null;
		} else {
			msg = "Please select atleast one entry and examtype should not be exist / empty";
		}

		model.addAttribute("smsg", smsg);
		model.addAttribute("emsg", msg);
		model.addAttribute(catval, editpojo);
		model.addAttribute(btnval, buttonid);

		logger.info(end);

		return "forward:/load-EditExamtypeform";
	}

	@RequestMapping("/load-DeleteExamtypeform")
	public String deleteExamtype(Model model, AdminCategory adc, AdminEditExamtypeFormPojo editpojo, HttpSession ses,HttpServletRequest req) {

		String start="Entry of deleteExamtype method....";
		String end="End of deleteExamtype method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		int buttonid = 0;
		List<AdminCategory> listval = adminuserservice.searchExamtypeFromAdmin();
		if (!listval.isEmpty()) {
			buttonid = 1;
		}
		editpojo.setExamtypelist(listval);
		model.addAttribute(btnval, buttonid);
		model.addAttribute("deletelistvalue", editpojo);

		logger.info(end);

		return "AdminDeleteExamtype";
	}

	@RequestMapping("/load-processdeleteExamtypeform")
	public String processDelexamtype(Model model, AdminCategory adc, AdminEditExamtypeFormPojo editpojo,
			HttpSession ses,HttpServletRequest req) {

		String start="Entry of processDelexamtype method....";
		String end="End of processDelexamtype method....";
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
		List<AdminCategory> listcheck = editpojo.getExamtypelist();
		for (AdminCategory adminCategory : listcheck) {
			classid = adminCategory.getExamtypeckeckbox();
			classname = adminCategory.getExamtype_name();
			if (classid != null && classname != null) {

				update = adminuserservice.deleteExamtype(classid);
				if (update > 0) {
					update++;
				}

			}

		}

		if (update > 0) {
			smsg = "Examtype deleted successfully";
			msg = null;
		} else {
			msg = "Please select atleast one entry";
		}

		model.addAttribute("smsg", smsg);
		model.addAttribute("emsg", msg);
		model.addAttribute(btnval, buttonid);
		model.addAttribute(catval, editpojo);

		logger.info(end);

		return "forward:/load-DeleteExamtypeform";
	}

}
