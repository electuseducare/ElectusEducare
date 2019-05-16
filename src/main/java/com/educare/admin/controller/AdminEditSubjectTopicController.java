package com.educare.admin.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import org.slf4j.Logger;
@Controller
public class AdminEditSubjectTopicController {

	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(AdminEditSubjectTopicController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;
	
	String subval="SubjectTopicForm";
	String sidval="student_id";
	String returnjsp="AdminEditSubjectTopic";
	String frwdurl="forward:/load-editsubjecttopic";
	String finalmsg="Please select/enter valid data";

	@RequestMapping("/load-editsubjecttopic")
	public String loaddeleteSubjecttopicFormPage(Model model, AdminCategory adc, HttpSession ses,HttpServletRequest req) {

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

		return returnjsp;
	}

	@RequestMapping("/load-topicsfromtopicsforEdit")
	public String gettopicsforEdit(Model model, AdminCategory adc, HttpSession ses, HttpServletRequest req) {

		String start="Entry of gettopicsforEdit method....";
		String end="End of gettopicsforEdit method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		model.addAttribute(subval, adc);
		String subjectids = req.getParameter("subjectid");
		String classids = req.getParameter("classid");
		int subjectid =(new Integer(subjectids)).intValue(); 
		int classid =(new Integer(classids)).intValue(); 
		List<AdminCategory> topiclist = adminuserservice.getTopicsFromAdmin(classid, subjectid);
		model.addAttribute("topiclist", topiclist);

		logger.info(end);

		return returnjsp;
	}

	@RequestMapping("/load-topicnamefromtopicsforEdit")
	public @ResponseBody List<Map<String, Object>> subjecttopicNameFormPageforEdit(Model model, AdminCategory adc,
			HttpSession ses, HttpServletRequest req) {

		String start="Entry of subjecttopicNameFormPageforEdit method....";
		String end="End of subjecttopicNameFormPageforEdit method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);

		String subjectids = req.getParameter("subjectid");
		String classids = req.getParameter("classid");
		String topicids = req.getParameter("topicid");

		int subjectid =(new Integer(subjectids)).intValue(); 
		int classid =(new Integer(classids)).intValue(); 
		int topicid =(new Integer(topicids)).intValue(); 

		List<Map<String, Object>> topics = adminuserservice.getTopicNameFromTopicTable(classid, subjectid, topicid);
		String subjtopicnames = null;
		for (Map<String, Object> map : topics) {
			Object subjtop = map.get("subject_topic_type");
			subjtopicnames = String.valueOf(subjtop);
		}

		model.addAttribute("subjtopicnames", subjtopicnames);

		logger.info(end);

		return topics;
	}

	@RequestMapping("/update-subjecttopiclist")
	public String updateSubjecttopicFormPage(Model model, AdminCategory adc, HttpSession ses,HttpServletRequest req) {

		String start="Entry of updateSubjecttopicFormPage method....";
		String end="End of updateSubjecttopicFormPage method....";
		logger.info(start);

		model.addAttribute(subval, adc);
		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";

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
		String topictext = adc.getTopicnametext();
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

		if ((topictext.length() <= 0) || (topictext == null)) {
			emsg = finalmsg;
			smsg = null;
			model.addAttribute("emsg", emsg);
			return frwdurl;
		}

		model.addAttribute("smsg", smsg);

		logger.info(end);

		return returnjsp;
	}

}
