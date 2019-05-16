package com.educare.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.educare.DatabaseValueController;
import com.educare.admin.model.AdminCategory;
import com.educare.admin.model.AdminTopicSubTopicsNameMoidifyFormModel;
import com.educare.admin.model.AdminTopicSubTopicsNameMoidifyModel;
import com.educare.controller.LoginController;
import com.educare.services.AdminRegisterServiceImpl;

@Controller
public class AdminTopicSubTopicsNameMoidifyController {

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		dataBinder.setAutoGrowCollectionLimit(1024);
	}

	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(AdminTopicSubTopicsNameMoidifyController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;
	
	String sidval="student_id";

	@RequestMapping("/load-subtopicFilter")
	public String subtopicFilter(Model model, AdminTopicSubTopicsNameMoidifyModel filter, HttpSession ses,HttpServletRequest req) {

		String start="Entry of subtopicFilter method....";
		String end="End of subtopicFilter method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		/************** Get class list ****************/
		List<AdminCategory> classnames = adminuserservice.searchClassesFromAdmin();
		model.addAttribute("classnames", classnames);
		
		 List<AdminCategory> examtypeslist = adminuserservice.searchexamtypesFromAdmin();
		 model.addAttribute("examtypeslist", examtypeslist);
		
		model.addAttribute("filter", filter);

		logger.info(end);

		return "subjectTopicFilter";
	}
	
	
	
	@RequestMapping(value = "/load-gettopicandsubtopicids")
	public String displayTopicsAndSubTopicsFromQuestions(Model model, AdminTopicSubTopicsNameMoidifyFormModel ast,
			HttpSession ses,AdminTopicSubTopicsNameMoidifyModel tsm,HttpServletRequest req) {
		String start = "Entry of displayTopicsAndSubTopicsFromQuestions method....";
		String end = "End of displayTopicsAndSubTopicsFromQuestions method....";

		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";

		List<AdminTopicSubTopicsNameMoidifyModel> qntopics=null;
		if(tsm.getSubjecttypeid()==0){
		 qntopics = adminuserservice.getTopicsSubTopicsFromQuestions(tsm);
		ast.setList(qntopics);
		
		}else{
			qntopics = adminuserservice.getTopicsSubTopicsFromQuestionsAll(tsm);
			ast.setList(qntopics);
		}

		model.addAttribute("questiontopics", ast);

		logger.info(end);

		return "AdminTopicSubTopicsNameMoidify";
	}

	@RequestMapping(value = "/update-insert-topicssubtopics")
	public String insertTopicsAndSubTopicsFromQuestions(Model model, AdminTopicSubTopicsNameMoidifyFormModel ast,
			HttpSession ses,HttpServletRequest req) {

		String start = "Entry of insertTopicsAndSubTopicsFromQuestions method....";
		String end = "End of insertTopicsAndSubTopicsFromQuestions method....";

		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";

		int updatecnt = 0;
		String emsg = null;
		String smsg = null;
		List<AdminTopicSubTopicsNameMoidifyModel> topicdetails = ast.getList();

		for (AdminTopicSubTopicsNameMoidifyModel tpdetails : topicdetails) {

			String topiccheckbox = tpdetails.getTopiccheckbox();
			if (topiccheckbox != null) {
				String[] str = topiccheckbox.split(",");
				String classid1 = str[0];
				int classid =(new Integer(classid1)).intValue(); 
				String subjectid1 = str[1];
				int subjectid =(new Integer(subjectid1)).intValue();
				String topicid1 = str[2];
				int topicid =(new Integer(topicid1)).intValue(); 
				String subtopicid1 = str[3];
				int subtopicid =(new Integer(subtopicid1)).intValue();
				String examtypeid1 = str[4];
				int examtypeid = (new Integer(examtypeid1)).intValue();
				String topicname = tpdetails.getTopicname();
				String subtopicname = tpdetails.getSubtopicname();
				int topicnt = adminuserservice.getCountOfTopicsAvailable(classid1, subjectid1, topicid1, examtypeid);

				int subtopicnt = adminuserservice.getCountOfSubTopicsAvailable(classid1, subjectid1, topicid1,
						examtypeid, subtopicid);
				if (classid != 0 && subjectid != 0 && examtypeid != 0 && topicname.length() > 0
						&& subtopicname.length() > 0) {

					if (topicnt <= 0) {

						adminuserservice.insertDataintosubjecttopictypeTable(classid, subjectid, topicid, topicname,
								examtypeid);
						updatecnt++;
					} else {
						adminuserservice.updateDataintosubjecttopictypeTable(classid, subjectid, topicid, topicname,
								examtypeid);
						updatecnt++;
					}
				}
				if (classid != 0 && subjectid != 0 && examtypeid != 0 && topicname.length() > 0
						&& subtopicname.length() > 0) {
					if (subtopicnt <= 0) {
						adminuserservice.insertDataintosubjectsubtopictypeTable(subjectid, topicid, subtopicid,
								subtopicname, classid, examtypeid);
						updatecnt++;
					} else {

						adminuserservice.updateDataintosubjectsubtopictypeTable(subjectid, topicid, subtopicid,
								subtopicname, classid, examtypeid);
						updatecnt++;
					}
				}

			}
		}

		if (updatecnt == 0) {
			emsg = "Please select at least one checkbox / class,subject and exam type should not be empty to update topics";
		} else {
			smsg = "Topic and Sub Topic updated successfully";
			emsg = null;
		}
		model.addAttribute("emsg", emsg);
		model.addAttribute("smsg", smsg);
		model.addAttribute("questiontopics", ast);

		logger.info(end);

		return "forward:/load-subtopicFilter";
	}
	
	@RequestMapping("/getSubjectsFromClass")
	 
	public @ResponseBody List<AdminCategory> getSubjectsFromClass(Model model, AdminTopicSubTopicsNameMoidifyModel adc,
			HttpSession ses, HttpServletRequest req) {
		
		String start="Entry of getSubjectsFromClass method....";
		String end="End of getSubjectsFromClass method....";
		logger.info(start);
		
		model.addAttribute("adc", adc);
		
		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		String classids = req.getParameter("classid");
		
		List<AdminCategory> sublst=adminuserservice.getSunBaseOnClass(classids);
		model.addAttribute("sublst",sublst);
		
		logger.info(end);
		
		return sublst;
	}
	

}
