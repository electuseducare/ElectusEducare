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
import com.educare.admin.model.AdminFilterCriteria;
import com.educare.admin.model.AdminSetStartExamPatternModel;
import com.educare.controller.LoginController;
import com.educare.services.AdminRegisterServiceImpl;
import com.educare.services.RegisterServiceImpl;

@Controller
public class AdminFilterCriteriaForCreateExamController {

	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(AdminFilterCriteriaForCreateExamController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private LoginController lc;

	@Autowired
	private DatabaseValueController dv;

	@RequestMapping("/load-classfilterquestions")
	public String loadFilterClassnames(Model model, AdminFilterCriteria filter, HttpSession ses,
			HttpServletRequest req) {

		String start = "Entry of loadFilterClassnames method....";
		String end = "End of loadFilterClassnames method....";
		logger.info(start);
		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);

		/**** return default database value *****/
		String dbval = dv.getDatabaseValue(ses, req);
		if (dbval.equals("0"))
			return "defaultDatabaseErrorPage";

		model.addAttribute("filter", filter);

		/************** Get class list ****************/
		List<AdminCategory> classnames = adminuserservice.searchClassesFromAdmin();
		model.addAttribute("classnames", classnames);
		/************** Get Exam Type ****************/
		List<AdminSetStartExamPatternModel> etype = adminuserservice.getAllExamtypes();
		model.addAttribute("etype", etype);

		logger.info(end);

		return "classFilterQuestions";
	}

	@RequestMapping("/load-AdminFilterCriteria")
	public String loadAdminFilterCriteria(Model model, AdminFilterCriteria adc, HttpSession ses,
			HttpServletRequest req) {

		String start = "Entry of loadAdminFilterCriteria method....";
		String end = "End of loadAdminFilterCriteria method....";
		logger.info(start);
		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		String filename = req.getParameter("filename");
		List<AdminFilterCriteria> filterques = null;
		if (filename != null) {
			int classid = adminuserservice.getClassidBasedonFilenmae(filename);
			adc.setClassid(classid);
			String examtype = adminuserservice.getExamtypeBasedOnFilename(filename);
			adc.setExamtype(examtype);
			String subjid = adminuserservice.getSubjidBasedOnFilename(filename);
			adc.setSubjectype(subjid);
			String topicid = adminuserservice.getTopicidsBasedonFilename(filename);
			adc.setTopicids(topicid);
			filterques = adminuserservice.adminFilterCriteriaForCreateExam(adc);

		} else {
			filterques = adminuserservice.adminFilterCriteriaForCreateExam(adc);
		}

		model.addAttribute("filterques", filterques);

		logger.info(end);

		return "AdminFilterCriteriaForCreateExam";
	}

}
