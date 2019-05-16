package com.educare.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.educare.DatabaseValueController;
import com.educare.admin.model.AdminAddCompQuesInExamModel;
import com.educare.controller.LoginController;
import com.educare.services.AdminRegisterServiceImpl;

@Controller
public class AdminCreateExamwithRandamQuestionsController {
	@Autowired
	private AdminRegisterServiceImpl adminuserservice;
	
	@Autowired
	private DatabaseValueController dv;

	@Autowired
	private LoginController lc;

	@RequestMapping("load-availableExamsToAddRandomQues")
	private String displayAvaiExamsInCreateExamWithRandaomQues(Model model, HttpSession ses,
			AdminAddCompQuesInExamModel ad,HttpServletRequest req) {
		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";

		List<AdminAddCompQuesInExamModel> examlist = adminuserservice.getExamNameForAddComphQues();

		model.addAttribute("examlist", examlist);
		model.addAttribute("getexamnames", ad);
		model.addAttribute("loadexamdetails", ad);

		return "AdminGetExamNamesForRandomQues";

	}

	private int updatecount = 0;

	@RequestMapping("load-adminaddrandomquestions")
	private String loadRandomQuestions(AdminAddCompQuesInExamModel ad, HttpSession ses,HttpServletRequest req) {
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		String selectedExam = ad.getSelectedexam();
		String isJumbling = "yes";
		updatecount = adminuserservice.updateRandomQuestionsInExampaper(selectedExam, isJumbling);

		return "redirect:/redirectRandomQues";

	}

	@RequestMapping(value = "/redirectRandomQues", method = RequestMethod.GET)
	public String finalCreateExamPage(Model model, HttpServletRequest req, HttpSession ses) {
		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		String smsg = null;
		String emsg = null;

		if (updatecount > 0) {
			smsg = "Random Questions successfully set for this exam";
		} else {

			emsg = "Please select valid exam name;";
		}
		model.addAttribute("smsg", smsg);
		model.addAttribute("emsg", emsg);
		return "AdminSuccessRandomQuestions";
	}
}
