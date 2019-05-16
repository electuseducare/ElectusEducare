package com.educare.admin.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.educare.DatabaseValueController;
import com.educare.admin.model.AdminAddNewStudent;
import com.educare.admin.model.AdminCategory;
import com.educare.admin.model.AdminEditStudentFormPojo;
import com.educare.controller.LoginController;
import com.educare.services.AdminRegisterServiceImpl;

@Controller
public class AdminOfflineAnalysisController {

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;

	String sidval = "student_id";

	@RequestMapping("/load-OfflineAnalysis")
	public String offlineAnalysisController(Model model, AdminAddNewStudent adc, AdminEditStudentFormPojo editpojo,
			HttpSession ses,HttpServletRequest req) {
		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";

		return "offlineAnalysis";
	}

	@RequestMapping("/load-offlinestudendata")
	public String uploadOfflineStudentdata(Model model, AdminAddNewStudent adc, AdminEditStudentFormPojo editpojo,
			HttpSession ses,HttpServletRequest req) {
		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";

		List<AdminCategory> clsection = adminuserservice.searchSectionFromAdmin();
		List<AdminCategory> statelist = adminuserservice.viewStateAssociateLcBr();
		model.addAttribute("statelist", statelist);
		model.addAttribute("clsection", clsection);

		return "offlinestudentdata";
	}

	@ResponseBody
	@RequestMapping("/verify-examnamealreadyExistsforoffline")
	public void getExamnameforOffline(Model model, AdminAddNewStudent adc, AdminEditStudentFormPojo editpojo,
			HttpSession ses, HttpServletRequest req, HttpServletResponse response) {

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		String examnamevalue = req.getParameter("examnamevalue");
		examnamevalue = examnamevalue.trim();
		examnamevalue = examnamevalue.toLowerCase();
		String examname = null;

		List<Map<String, Object>> getotbfromdb = adminuserservice.validateExamnameforoffline(examnamevalue);

		if (!getotbfromdb.isEmpty()) {
			for (Map<String, Object> map : getotbfromdb) {
				examname = (String) map.get("exam_name");
				examname = examname.toLowerCase();
			}
		}

		if (examnamevalue != null) {
		} else {

			try {
				response.getWriter().write("Please enter valid exam name");
			} catch (IOException e) {

			}

		}

		if (examnamevalue.equals(examname)) {

			try {
				response.getWriter().write("Exam name already exists. Please try with other name");
			} catch (IOException e) {

			}

		}

		else {
			try {
				response.getWriter().write("Entered exam name is valid");
			} catch (IOException e) {

			}
		}
	}

}
