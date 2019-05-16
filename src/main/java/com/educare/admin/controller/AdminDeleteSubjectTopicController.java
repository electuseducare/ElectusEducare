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
public class AdminDeleteSubjectTopicController {

	private static final Logger logger = LoggerFactory.getLogger(AdminDeleteSubjectTopicController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;
	
	String subtopicval="SubjectTopicForm";
	String sidval="student_id";
	String returnjspval="AdminDeleteSubjectTopic";
	String frwdurlval="forward:/load-deletesubjecttopic";
	String finalmsg="Please select/enter valid data";

	
	@RequestMapping("/load-deletesubjecttopic")
	public String loaddeleteSubjecttopicFormPage(Model model, AdminCategory adc,HttpSession ses,HttpServletRequest req){
		
		String start="Entry of loaddeleteSubjecttopicFormPage method....";
		String end="End of loaddeleteSubjecttopicFormPage method....";
		logger.info(start);
		
		String studentid = (String)ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		model.addAttribute(subtopicval, adc);
		 List<AdminCategory> classnames=adminuserservice.searchClassesFromAdmin();
		 model.addAttribute("classnames", classnames);
		 
		 logger.info(end);
		 
		return returnjspval;
	}
	
	@RequestMapping("/load-topicsfromtopicsforDelete")
	public String gettopicsforDelete(Model model, AdminCategory adc,HttpSession ses, HttpServletRequest req){
	
		String start="Entry of gettopicsforDelete method....";
		String end="End of gettopicsforDelete method....";
		logger.info(start);
		
		String studentid = (String)ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		model.addAttribute(subtopicval, adc);
		String subjectids = req.getParameter("subjectid");
		String classids = req.getParameter("classid");
		int subjectid =(new Integer(subjectids)).intValue();
		int classid =(new Integer(classids)).intValue();
		List<AdminCategory> topiclist=adminuserservice.getTopicsFromAdmin(classid,subjectid);
		model.addAttribute("topiclist", topiclist);
		
		logger.info(end);
		
		return returnjspval;
	}
	
	@RequestMapping("/load-topicnamefromtopicsforDelete")
	public @ResponseBody List<Map<String, Object>> subjecttopicNameFormPageforDelete(Model model, AdminCategory adc,HttpSession ses,HttpServletRequest req){

		String start="Entry of subjecttopicNameFormPageforDelete method....";
		String end="End of subjecttopicNameFormPageforDelete method....";
		logger.info(start);
		
		String studentid = (String)ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		String subjectids = req.getParameter("subjectid");
		String classids = req.getParameter("classid");
		String topicids = req.getParameter("topicid");
		
		int subjectid =(new Integer(subjectids)).intValue();
		int classid =(new Integer(classids)).intValue(); 
		int topicid =(new Integer(topicids)).intValue();
		
		List<Map<String, Object>> topics =  adminuserservice.getTopicNameFromTopicTable(classid,subjectid, topicid);
		String subjtopicnames = null;
		for (Map<String, Object> map : topics) {
			Object subjtop = map.get("subject_topic_type");
			subjtopicnames = String.valueOf(subjtop);
		}
		
		model.addAttribute("subjtopicnames", subjtopicnames);
		
		logger.info(end);
		
		return topics;
	}
	
	@RequestMapping("/delete-subjecttopiclist")
	public String deleteSubjecttopicFormPage(Model model, AdminCategory adc,HttpSession ses,HttpServletRequest req){
		
		String start="Entry of deleteSubjecttopicFormPage method....";
		String end="End of deleteSubjecttopicFormPage method....";
		logger.info(start);
		
		String studentid = (String)ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		model.addAttribute(subtopicval, adc);
		String classids = adc.getClassname();
		int classid=0;
		if(classids!=null){
		classid = Integer.valueOf(classids);
		}
		String subjectids = adc.getSubjectname();
		int subjectid=0;
		if(subjectids!=null){
		subjectid = Integer.valueOf(subjectids);}
		String topicids = adc.getTopicnames();
		int topicid=0;
		if(topicids!=null){
		topicid = Integer.valueOf(topicids);}
		String topictext = adc.getTopicnametext();
        String smsg = null;
        String emsg = null;
        if(classid==0){
    	 emsg = finalmsg;
    	 smsg = null;
    	 model.addAttribute("emsg", emsg);
    	 return frwdurlval;
    	}
        if(subjectid==0){
       	 emsg = finalmsg;
       	 smsg = null;
       	 model.addAttribute("emsg", emsg);
       	return frwdurlval;
        }
        if(topicid==0){
    	 emsg = finalmsg;
      	 smsg = null;
      	 model.addAttribute("emsg", emsg);
      	 return frwdurlval;
        }
        
        if((topictext.length()<=0)||(topictext==null)){
    	 emsg =finalmsg;
     	 smsg = null;
     	 model.addAttribute("emsg", emsg);
     	 return frwdurlval;	
        }
        
		int deleteTopics = adminuserservice.deleteDataintosubjecttopictypeTable(classid,subjectid,topicid,topictext);
		if(deleteTopics==0){
		  emsg = finalmsg;	
		  smsg=null;
		  model.addAttribute("emsg", emsg);
		  return frwdurlval;
		}
		else{
			smsg = "Topic deleted successfully!";
			emsg = null;
		}
		model.addAttribute("smsg", smsg);
		
		logger.info(end);
		
		return returnjspval;
	}
}
