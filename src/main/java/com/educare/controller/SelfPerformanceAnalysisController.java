package com.educare.controller;

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
import com.educare.model.SelfassessmentModel;
import com.educare.services.RegisterServiceImpl;

@Controller
public class SelfPerformanceAnalysisController {
	private static final Logger logger = LoggerFactory.getLogger(SelfPerformanceAnalysisController.class);

	@Autowired
	private RegisterServiceImpl userservice;

	@Autowired
	private DatabaseValueController dv;
	
	@RequestMapping("/load-selfPerformaneceAnalysis")
	public String selfAssessment(Model model, SelfassessmentModel self,HttpServletRequest req,HttpSession ses) {
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		List<SelfassessmentModel> getexamtyp = userservice.getExamtypeforSelfassessment();
		model.addAttribute("getexamtyp", getexamtyp);
		String startmethod = "selfAssessment Start Method";
		logger.info(startmethod);
		return "loadspaexamtype";
	}

	@RequestMapping("/process-SPA")
	public String processperformaneceAnalysis(Model model, HttpSession ses, HttpServletRequest req,
			SelfassessmentModel self) {

		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		String examtype = req.getParameter("examtype");
		String studentid = (String) ses.getAttribute("student_id");
		List<SelfassessmentModel> getspa = userservice.getSelfAsssessmentdetails(studentid, examtype);
		model.addAttribute("getspa", getspa);
		return "processspa";
	}

}
