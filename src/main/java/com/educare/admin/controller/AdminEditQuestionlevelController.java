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
import com.educare.admin.model.AdminEditQuestionlevelFormPojo;
import com.educare.controller.LoginController;
import com.educare.services.AdminRegisterServiceImpl;

import org.slf4j.Logger;

@Controller
public class AdminEditQuestionlevelController {

	private static final Logger logger = LoggerFactory.getLogger(AdminEditQuestionlevelController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;

	String sidval = "student_id";
	String btnval = "buttonid";
	String catval = "categorylistvalue";

	@RequestMapping("/load-EditQuestionlevelform")
	public String editQuestionlevel(Model model, AdminCategory adc, AdminEditQuestionlevelFormPojo editpojo,
			HttpSession ses,HttpServletRequest req) {

		String start = "Entry of editQuestionlevel method....";
		String end = "End of editQuestionlevel method....";

		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		int buttonid = 0;
		List<AdminCategory> listval = adminuserservice.searchQuestionlevelFromAdmin();
		if (!listval.isEmpty()) {
			buttonid = 1;
		}
		editpojo.setQuestionlevellist(listval);
		model.addAttribute(btnval, buttonid);
		model.addAttribute(catval, editpojo);

		logger.info(end);

		return "AdminEditQuestionlevel";
	}

	@RequestMapping("/load-processQuestionlevelform")
	public String loadProcessQuestionLevel(Model model, AdminCategory adc, AdminEditQuestionlevelFormPojo editpojo,
			HttpSession ses,HttpServletRequest req) {

		String start = "Entry of loadProcessQuestionLevel method....";
		String end = "End of loadProcessQuestionLevel method....";

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
		List<AdminCategory> listcheck = editpojo.getQuestionlevellist();
		for (AdminCategory adminCategory : listcheck) {
			examtypeid = adminCategory.getQnlevelckeckbox();
			examtype = adminCategory.getQuesntion_level();
			if (examtypeid != null && examtype != null) {

				int value = adminuserservice.searchQuestionlevelFromAdmin1(examtype);

				if (value <= 0) {
					update = adminuserservice.updateQuestionlevel(examtype, examtypeid);

					update++;
				}

			}

		}

		if (update > 0) {
			smsg = "Questionlevel updated successfully";
			msg = null;
		} else {
			msg = "Please select atleast one entry and questionlevel should not be exist / empty";
		}

		model.addAttribute("smsg", smsg);
		model.addAttribute("emsg", msg);
		model.addAttribute(btnval, buttonid);
		model.addAttribute(catval, editpojo);

		logger.info(end);

		return "forward:/load-EditQuestionlevelform";
	}

	@RequestMapping("/load-DeleteQuestionlevelform")
	public String deleteQuestionlevel(Model model, AdminCategory adc, AdminEditQuestionlevelFormPojo editpojo,
			HttpSession ses,HttpServletRequest req) {

		String start = "Entry of deleteQuestionlevel method....";
		String end = "End of deleteQuestionlevel method....";

		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		int buttonid = 0;
		List<AdminCategory> listval = adminuserservice.searchQuestionlevelFromAdmin();
		if (!listval.isEmpty()) {
			buttonid = 1;
		}
		editpojo.setQuestionlevellist(listval);
		model.addAttribute(btnval, buttonid);
		model.addAttribute("deletelistvalue", editpojo);

		logger.info(end);

		return "AdminDeleteQuestionlevel";
	}

	@RequestMapping("/load-processdeleteQuestionlevelform")
	public String loadProcessdeleteQuestionlevel(Model model, AdminCategory adc,
			AdminEditQuestionlevelFormPojo editpojo, HttpSession ses,HttpServletRequest req) {

		String start = "Entry of loadProcessdeleteQuestionlevel method....";
		String end = "End of loadProcessdeleteQuestionlevel method....";

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
		List<AdminCategory> listcheck = editpojo.getQuestionlevellist();
		for (AdminCategory adminCategory : listcheck) {
			classid = adminCategory.getQnlevelckeckbox();
			classname = adminCategory.getQuesntion_level();
			if (classid != null && classname != null) {

				update = adminuserservice.deleteQuestionlevelFromAdmin(classid);
				if (update > 0) {
					update++;
				}

			}

		}
		if (update > 0) {
			smsg = "Questionlevel deleted successfully";
			msg = null;
		} else {
			msg = "Please select atleast one entry";
		}

		model.addAttribute("smsg", smsg);
		model.addAttribute("emsg", msg);
		model.addAttribute("buttonid", buttonid);
		model.addAttribute(catval, editpojo);

		logger.info(end);

		return "forward:/load-DeleteQuestionlevelform";
	}

}
