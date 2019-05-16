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
import com.educare.controller.LoginController;
import com.educare.services.AdminRegisterServiceImpl;

import org.slf4j.Logger;
@Controller
public class AdminDeleteSubjectSubtopicController {

	private static final Logger logger = LoggerFactory.getLogger(AdminDeleteSubjectSubtopicController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;
	
	String frwdurl="forward:/load-deletesubjectsubtopic";
	String finalmsg="Please select/enter valid data";

	@RequestMapping("/load-deletesubjectsubtopic")
	public String loadeditSubjecttopicFormPage1(Model model, AdminCategory adc, HttpSession ses,HttpServletRequest req) {

		String start="Entry of loadeditSubjecttopicFormPage1 method....";
		String end="End of loadeditSubjecttopicFormPage1 method....";

		logger.info(start);

		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		model.addAttribute("SubjectTopicForm", adc);
		List<AdminCategory> classnames = adminuserservice.searchClassesFromAdmin();
		model.addAttribute("classnames", classnames);

		logger.info(end);

		return "adminDeleteSubjectSubtopic";
	}

	@RequestMapping("/delete-subjectsubtopiclist")
	public String delSubjecttopicFormPage(Model model, AdminCategory adc, HttpSession ses,HttpServletRequest req) {

		String start="Entry of delSubjecttopicFormPage method....";
		String end="End of delSubjecttopicFormPage method....";

		logger.info(start);

		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";

		model.addAttribute("SubjectTopicForm", adc);
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

		int updateSubTopics = adminuserservice.deleteDataintosubjectsubtopictypeTable(topicid, subtopicid,
				subtopictext);
		if (updateSubTopics == 0) {
			emsg = finalmsg;
			smsg = null;
			model.addAttribute("emsg", emsg); 
			return frwdurl;
		} else {
			smsg = "Sub-Topic deleted successfully!";
			emsg = null;
		}
		model.addAttribute("smsg", smsg);

		logger.info(end);

		return "adminDeleteSubjectSubtopic";
	}

}
