package com.educare.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.educare.DatabaseValueController;
import com.educare.admin.model.AdminExamNameforReport;
import com.educare.admin.model.StudentExamCountModel;
import com.educare.controller.LoginController;
import com.educare.services.AdminRegisterServiceImpl;

@Controller
public class StudentExamCountController {
	
	private static final Logger logger = LoggerFactory.getLogger(StudentExamCountController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;
	
	@Autowired
	private DatabaseValueController dv;
	
	@Autowired
	private LoginController lc;

	@Value("${exam.completion.status}")
	String examNotStartedStatus;
	
	@RequestMapping("/view-examnameforstudcount")
	public String viewExamsForStudCnt(Model model, StudentExamCountModel examcnt, HttpSession ses,HttpServletRequest req) {

		String start = "Entry of viewExamsForStudCnt method....";
		String end = "End of viewExamsForStudCnt method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		List<AdminExamNameforReport> examlist = adminuserservice.getExamnamesForExamStatus1();

		model.addAttribute("examlist", examlist);
		model.addAttribute("examcnt", examcnt);

		logger.info(end);

		return "examsForStudentCount";
	}
	
	@RequestMapping(value = "/display-studentsforexam")
	public String displayStudents(Model model, StudentExamCountModel stud, HttpSession ses,HttpServletRequest req) {

		String start = "Entry of displayStudents method....";
		String end = "End of displayStudents method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		stud.setExamstatus(examNotStartedStatus);
		List<StudentExamCountModel> studlist=adminuserservice.getStudentsForExam(stud);
		
		model.addAttribute("stud", stud);
		model.addAttribute("studlist", studlist);
		model.addAttribute("examname", stud.getExamname());

		logger.info(end);

		return "displayStudentsForExam";
	}

}
