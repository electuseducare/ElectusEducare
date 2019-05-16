package com.educare.admin.controller;

import java.util.List;
import java.util.StringJoiner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.educare.DatabaseValueController;
import com.educare.admin.model.AdminSetStartExamPatternModel;
import com.educare.controller.LoginController;
import com.educare.services.AdminRegisterServiceImpl;

@Controller
public class AdminSetStartExamPatternController {
	private static final Logger logger = LoggerFactory.getLogger(AdminSetStartExamPatternController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;

	@RequestMapping(value = "/load-setstartexampattern")
	public String setStartExamPattern(Model model, AdminSetStartExamPatternModel pattern, HttpSession ses,HttpServletRequest req) {

		String start = "**********Start setStartExamPattern ***********";
		String end = "**********End setStartExamPattern ***********";
		logger.info(start);
		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		int buttonid = 0;

		List<AdminSetStartExamPatternModel> patternlistval = adminuserservice.getSetPatternValue();

		StringJoiner strexamtyids = new StringJoiner(",");
		StringJoiner strptrids = new StringJoiner(",");
		if (!patternlistval.isEmpty()) {
			for (AdminSetStartExamPatternModel ptl : patternlistval) {
				String examtypeid = String.valueOf(ptl.getExamtypeid());
				String pattrenid = String.valueOf(ptl.getPatternid());
				strexamtyids.add(pattrenid + "_" + examtypeid);

			}
			String examtypeidjnr = strexamtyids.toString();
			String pattrenidjnr = strptrids.toString();
			model.addAttribute("examtypeidjnr", examtypeidjnr);
			model.addAttribute("pattrenidjnr", pattrenidjnr);

		}

		List<AdminSetStartExamPatternModel> examtypeslist = adminuserservice.getAllExamtypes();
		model.addAttribute("examtypeslist", examtypeslist);
		if (!examtypeslist.isEmpty()) {
			buttonid = 1;
		}

		List<AdminSetStartExamPatternModel> exampatternlist = adminuserservice.getAllExamPatterns();
		model.addAttribute("exampatternlist", exampatternlist);

		model.addAttribute("pattern", pattern);
		model.addAttribute("buttonid", buttonid);

		logger.info(end);

		return "adminSetStartExamPattern";
	}

	@RequestMapping(value = "/set-startexampattern")
	public String setExamPattern(Model model, AdminSetStartExamPatternModel pattern, HttpSession ses,
			HttpServletRequest req) {

		String start = "**********Start setExamPattern ***********";
		String end = "**********End setExamPattern ***********";
		logger.info(start);
		int cntval = 0;
		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";

		String msg = null;
		String smsg = null;
		List<AdminSetStartExamPatternModel> examtypeslist = adminuserservice.getAllExamtypes();
		for (AdminSetStartExamPatternModel ex : examtypeslist) {
			List<AdminSetStartExamPatternModel> exampatternlist = adminuserservice.getAllExamPatterns();
			for (AdminSetStartExamPatternModel exp : exampatternlist) {

				String patterndesign = req.getParameter(exp.getPatterntype() + "_" + ex.getExamtype());
				if (patterndesign != null) {
					String[] arry = patterndesign.split("_");
					int exitxnt = adminuserservice.checkExistinExamPattern(arry[0], arry[1]);
					if (exitxnt == 0) {
						adminuserservice.insertStartExamPatternData(arry[0], arry[1]);
						cntval++;
					} else {
						adminuserservice.updateStartExamPattern(arry[0], arry[1]);
						cntval++;
					}

				}
			}
		}
		if (cntval > 0) {
			smsg = "Start Exam pattern updated successfully";
			msg = null;

		} else {
			msg = "Please select atleast one Exam pattern to update the start exam.";
		}

		model.addAttribute("smsg", smsg);
		model.addAttribute("emsg", msg);

		logger.info(end);

		return "forward:/load-setstartexampattern";
	}

}
