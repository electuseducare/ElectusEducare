package com.educare.admin.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.educare.DatabaseValueController;
import com.educare.admin.model.AdminCategory;
import com.educare.controller.LoginController;
import com.educare.services.AdminRegisterServiceImpl;
@Controller
public class AdminEditSubjectSubtopicController {

	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(AdminEditSubjectSubtopicController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;
	
	String frwdurl="forward:/load-editsubjectsubtopic";
	String subval="SubjectTopicForm";
	String sidval="student_id";
	String returnjspval="adminEditSubjectSubtopic";
	String finalmsg="Please select/enter valid data";

	@RequestMapping("/load-editsubjectsubtopic")
	public String loadeditSubjecttopicFormPage1(Model model, AdminCategory adc, HttpSession ses,HttpServletRequest req) {

		String start="Entry of loadeditSubjecttopicFormPage1 method....";
		String end="End of loadeditSubjecttopicFormPage1 method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		model.addAttribute(subval, adc);
		List<AdminCategory> classnames = adminuserservice.searchClassesFromAdmin();
		model.addAttribute("classnames", classnames);

		logger.info(end);

		return returnjspval;
	}

	@RequestMapping("/load-subtopicsforSubject1")
	public String getsubtopics(Model model, AdminCategory adc, HttpSession ses, HttpServletRequest req) {

		String start="Entry of getsubtopics method....";
		String end="End of getsubtopics method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		model.addAttribute(subval, adc);
		String subjectids = req.getParameter("subjectid");
		String topicids = req.getParameter("topicid");

		int subjectid = (new Integer(subjectids)).intValue();
		int topicid = (new Integer(topicids)).intValue(); 

		List<AdminCategory> subtopicnames = adminuserservice.getSubtopicsFromAdminInEditModule(subjectid, topicid);
		model.addAttribute("subtopicnames", subtopicnames);

		logger.info(end);

		return returnjspval;
	}

	@RequestMapping("/load-subtopicnamefromtopics")
	public @ResponseBody List<Map<String, Object>> subjectsubtopicNameFormPage(Model model, AdminCategory adc,
			HttpSession ses, HttpServletRequest req) {

		String start="Entry of subjectsubtopicNameFormPage method....";
		String end="End of subjectsubtopicNameFormPage method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);

		String topicids = req.getParameter("topicid");
		String subtopicids = req.getParameter("subtopicid");

		int topicid = (new Integer(topicids)).intValue();
		int subtopicid =(new Integer(subtopicids)).intValue(); 

		List<Map<String, Object>> subtopics = adminuserservice.getSubTopicNameFromSubtopicTable(topicid, subtopicid);
		String subSubtopicnames = null;
		for (Map<String, Object> map : subtopics) {
			Object subjtop = map.get("subject_subtopic_type");
			subSubtopicnames = String.valueOf(subjtop);
		}

		model.addAttribute("subjtopicnames", subSubtopicnames);

		logger.info(end);

		return subtopics;
	}

	@RequestMapping("/update-subjectsubtopiclist")
	public String insertSubjecttopicFormPage(Model model, AdminCategory adc, HttpSession ses,HttpServletRequest req) {

		String start="Entry of insertSubjecttopicFormPage method....";
		String end="End of insertSubjecttopicFormPage method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";

		model.addAttribute(subval, adc);
		String classids = adc.getClassname();
		int classid = 0;
		if (classids != null) {
			classid = Integer.valueOf(classids);
		}
		String subjectids = adc.getSubjectname();
		int subjectid = 0;
		if (subjectids != null) {
			subjectid = Integer.valueOf(subjectids);
		}
		String topicids = adc.getTopicnames();
		int topicid = 0;
		if (topicids != null) {
			topicid = Integer.valueOf(topicids);
		}
		String subtopicids = adc.getSubtopicnames();
		int subtopicid = 0;
		if (subtopicids != null) {
			subtopicid = Integer.valueOf(subtopicids);
		}
		String subtopictext = adc.getSubtopicnametext();
		String smsg = null;
		String emsg = null;
		if (classid == 0) {
			emsg = finalmsg;
			smsg = null;
			model.addAttribute("emsg", emsg);
			return frwdurl;
		}
		if (subjectid == 0) {
			emsg = finalmsg;
			smsg = null;
			model.addAttribute("emsg", emsg);
			return frwdurl;
		}
		if (topicid == 0) {
			emsg = finalmsg;
			smsg = null;
			model.addAttribute("emsg", emsg);
			return frwdurl;
		}
		if (subtopicid == 0) {
			emsg = finalmsg;
			smsg = null;
			model.addAttribute("emsg", emsg);
			return frwdurl;
		}

		if ((subtopictext.length() <= 0) || (subtopictext == null)) {
			emsg = finalmsg;
			smsg = null;
			model.addAttribute("emsg", emsg);
			return frwdurl;
		}

		model.addAttribute("smsg", smsg);

		logger.info(end);

		return returnjspval;
	}

}
