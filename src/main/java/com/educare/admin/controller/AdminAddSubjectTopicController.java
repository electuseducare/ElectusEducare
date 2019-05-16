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
public class AdminAddSubjectTopicController {

	private static final Logger logger = LoggerFactory.getLogger(AdminAddSubjectTopicController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;
	
    String frwdurl="forward:/load-addsubjecttopic";
    String finalmsg="Please select/enter valid data";
    String subjval="SubjectTopicForm";
    String sidval="student_id";
    String returnjsp="AdminAddSubjectTopic";
	
	@RequestMapping("/load-addsubjecttopic")
	public String loadaddSubjecttopicFormPage(Model model, AdminCategory adc, HttpSession ses,HttpServletRequest req) {

		String start="Entry of loadaddSubjecttopicFormPage method....";
		String end="End of loadaddSubjecttopicFormPage method....";
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

		return returnjsp;
	}

	@RequestMapping(value = "/load-subjectsforclass")
	public String loadAjaxsubjectsforclass(Model model, AdminCategory adc, HttpSession ses, HttpServletRequest req) {

		String start="Entry of loadAjaxsubjectsforclass method....";
		String end="End of loadAjaxsubjectsforclass method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		model.addAttribute(subjval, adc);
		String classids = req.getParameter("classid");
		int classid =(new Integer(classids)).intValue();
		List<AdminCategory> subject = adminuserservice.searchSubjectforClassFromAdmin(classid);
		model.addAttribute("subject", subject);

		logger.info(end);

		return returnjsp;
	}

	@RequestMapping(value = "/load-topicsforSubjects")
	public String loadAjaxtopicsforSubjects(Model model, AdminCategory adc, HttpSession ses, HttpServletRequest req) {

		String start="Entry of loadAjaxtopicsforSubjects method....";
		String end="End of loadAjaxtopicsforSubjects method....";
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
		int subjectid =(new Integer(subjectids)).intValue();
		int classid =(new Integer(classids)).intValue();

		List<AdminCategory> topiclist = adminuserservice.searchTopicsforSubjectsFromAdmin(classid, subjectid);
		model.addAttribute("topiclist", topiclist);

		logger.info(end);

		return returnjsp;
	}

	@RequestMapping("/insert-subjecttopiclist")
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
			emsg =finalmsg;
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
			emsg =finalmsg;
			smsg = null;
			model.addAttribute("emsg", emsg);
			return frwdurl;
		}

		model.addAttribute("smsg", smsg);

		logger.info(end);

		return returnjsp;
	}

}
