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
import com.educare.controller.LoginController;
import com.educare.services.AdminRegisterServiceImpl;

@Controller
public class AdminAddSubjectSubtopicController {

	private static final Logger logger = LoggerFactory.getLogger(AdminAddSubjectSubtopicController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;

	String frwdurl = "forward:/load-addsubjectsubtopic";
	String finalmsg = "Please select/enter valid data";
	String subjval= "SubjectTopicForm";
	String sidval= "student_id";
	String retrunjsp= "adminAddSubjectSubtopic";

	@RequestMapping("/load-addsubjectsubtopic")
	public String loadaddSubjecttopicFormPage1(Model model, AdminCategory adc, HttpSession ses,HttpServletRequest req) {

		String start = "Entry of loadaddSubjecttopicFormPage1 method....";
		String end = "End of loadaddSubjecttopicFormPage1 method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		model.addAttribute(subjval, adc);
		List<AdminCategory> classnames = adminuserservice.searchClassesFromAdmin();
		model.addAttribute("classnames", classnames);

		logger.info(end);

		return retrunjsp;
	}

	@RequestMapping("/load-topicsforSubject")
	public String gettopics(Model model, AdminCategory adc, HttpSession ses, HttpServletRequest req) {

		String start = "Entry of gettopics method....";
		String end = "End of gettopics method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		model.addAttribute(subjval, adc);
		String subjectids = req.getParameter("subjectid");
		String classids = req.getParameter("classid");
		int subjectid = (new Integer(subjectids)).intValue();
		int classid = (new Integer(classids)).intValue();
		List<AdminCategory> topicnames = adminuserservice.getTopicsFromAdmin(classid, subjectid);
		model.addAttribute("topicnames", topicnames);

		logger.info(end);

		return retrunjsp;
	}

	@RequestMapping("/load-subtopicsforSubject")
	public String getsubtopics(Model model, AdminCategory adc, HttpSession ses, HttpServletRequest req) {

		String start = "Entry of getsubtopics method....";
		String end = "End of getsubtopics method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		model.addAttribute(subjval, adc);
		String subjectids = req.getParameter("subjectid");
		String classids = req.getParameter("classid");
		String topicids = req.getParameter("topicid");

		int subjectid = (new Integer(subjectids)).intValue();
		int classid = (new Integer(classids)).intValue();
		int topicid = (new Integer(topicids)).intValue();

		List<AdminCategory> subtopicnames = adminuserservice.getSubtopicsFromAdmin(classid, subjectid, topicid);
		model.addAttribute("subtopicnames", subtopicnames);

		logger.info(end);

		return retrunjsp;
	}

	@RequestMapping("/insert-subjectsubtopiclist")
	public String insertSubjectsubtopicFormPage(Model model, AdminCategory adc, HttpSession ses,HttpServletRequest req) {

		String start = "Entry of insertSubjectsubtopicFormPage method....";
		String end = "End of insertSubjectsubtopicFormPage method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";

		model.addAttribute(subjval, adc);
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

		if ((subtopictext.length() <= 0) || (subtopictext == null)) {
			emsg = finalmsg;
			smsg = null;
			model.addAttribute("emsg", emsg);
			return frwdurl;
		}

		model.addAttribute("smsg", smsg);
		model.addAttribute("emsg", emsg);

		logger.info(end);

		return retrunjsp;

	}

}
