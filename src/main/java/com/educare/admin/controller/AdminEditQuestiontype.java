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
import com.educare.admin.model.AdminEditQuestiontypeform;
import com.educare.controller.LoginController;
import com.educare.services.AdminRegisterServiceImpl;

@Controller
public class AdminEditQuestiontype {

	private static final Logger logger = LoggerFactory.getLogger(AdminEditQuestiontype.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;

	@RequestMapping("/load-EditQustiontypeform")
	public String editQustiontype(Model model, AdminCategory adc, AdminEditQuestiontypeform editpojo, HttpSession ses,HttpServletRequest req) {

		String start = "Entry of editQustiontype method....";
		String end = "End of editQustiontype method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		List<AdminCategory> listval = adminuserservice.searchQuestiontypeFromAdmin();
		editpojo.setQuestionlistform(listval);

		model.addAttribute("categorylistvalue", editpojo);

		logger.info(end);

		return "AdminEditQuestionType";
	}

	@RequestMapping("/load-processquestiontypeform")
	public String processQuestiontype(Model model, AdminCategory adc, AdminEditQuestiontypeform editpojo,
			HttpSession ses,HttpServletRequest req) {

		String start = "Entry of processQuestiontype method....";
		String end = "End of processQuestiontype method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		String sectionname = null;
		String sectionid = null;
		String msg = "";
		String smsg = "";
		int update = 0;
		List<AdminCategory> listcheck = editpojo.getQuestionlistform();
		for (AdminCategory adminCategory : listcheck) {
			sectionid = adminCategory.getQuestiontype();
			sectionname = adminCategory.getQuestiontypecheckvalue().trim();

			if (sectionid != null && sectionname != null) {

				update = adminuserservice.updateQuestiontype(sectionid, sectionname);

			}

			if (update > 0) {
				smsg = "data updated successfully";
				msg = null;
			} else {
				msg = "please select One";
			}

		}

		model.addAttribute("smsg", smsg);
		model.addAttribute("emsg", msg);
		model.addAttribute("categorylistvalue", editpojo);

		logger.info(end);

		return "forward:/load-EditQustiontypeform";
	}
}
