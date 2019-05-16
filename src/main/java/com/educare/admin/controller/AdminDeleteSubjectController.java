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

import com.educare.DatabaseValueController;
import com.educare.admin.model.AdminCategory;
import com.educare.admin.model.AdminEditSubjectFormPojo;
import com.educare.controller.LoginController;
import com.educare.services.AdminRegisterServiceImpl;

@Controller
public class AdminDeleteSubjectController {

	private static final Logger logger = LoggerFactory.getLogger(AdminDeleteSubjectController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;

	@RequestMapping("/load-DeleteSubjectform")
	public String deleteSubject(Model model, AdminCategory adc, AdminEditSubjectFormPojo editpojo, HttpSession ses,HttpServletRequest req) {

		String start = "Entry of deleteSubject method....";
		String end = "End of deleteSubject method....";

		logger.info(start);

		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		int buttonid = 0;
		List<AdminCategory> listval = adminuserservice.searchSubjectFromAdmin();
		if (!listval.isEmpty()) {
			buttonid = 1;
		}
		editpojo.setSubjectlist(listval);
		model.addAttribute("buttonid", buttonid);
		model.addAttribute("deletelistvalue", editpojo);

		logger.info(end);

		return "AdminDeleteSubject";
	}

	@RequestMapping("/load-processdeleteSubjectform")
	public String processDelSubj(Model model, AdminCategory adc, AdminEditSubjectFormPojo editpojo, HttpSession ses,HttpServletRequest req) {

		String start = "Entry of processDelSubj method....";
		String end = "End of processDelSubj method....";

		logger.info(start);

		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		String sectionname = null;
		String subjectid = null;
		String msg = null;
		String smsg = null;
		int update = 0;
		List<AdminCategory> listcheck = editpojo.getSubjectlist();
		for (AdminCategory adminCategory : listcheck) {
			subjectid = adminCategory.getSubjectcheckvalue();
			sectionname = adminCategory.getSubject();

			if (subjectid != null && sectionname != null) {

				update = adminuserservice.deleteSubject(subjectid);
				List<Map<String, Object>> gettopicids = adminuserservice.getTopicIdsBasedonSubjectId(subjectid);
				for (Map<String, Object> map : gettopicids) {
					Object topicids = map.get("subject_topic_type_id");
					String topicid1 = String.valueOf(topicids);
					int topicid = (new Integer(topicid1)).intValue();
					adminuserservice.deletesubtopicsbasedontopicid(topicid);

				}
				adminuserservice.deletetopicsbasedonsubjectid(subjectid);

				if (update > 0) {
					update++;
				}

			}

		}

		if (update > 0) {
			smsg = "Subject deleted successfully";
			msg = null;
		} else {
			msg = "Please select atleast one entry";
		}

		model.addAttribute("smsg", smsg);
		model.addAttribute("emsg", msg);
		model.addAttribute("categorylistvalue", editpojo);

		logger.info(end);

		return "forward:/load-DeleteSubjectform";
	}

}
