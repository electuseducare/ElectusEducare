package com.educare.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.educare.DatabaseValueController;
import com.educare.admin.model.AdminExamNameforReport;
import com.educare.controller.LoginController;

@Controller
public class AdminOfflineExamreportsController {
	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(AdminLoadReportsController.class);

	@Autowired
	private LoginController lc;

	@Autowired
	private DatabaseValueController dv;
	
	@RequestMapping("/load-OfflineExamReports")
	public String adminOfflineLoadreports(Model model, AdminExamNameforReport adc, HttpServletRequest req,
			HttpSession sess) {

		String start = "Start of adminOfflineLoadreports method";
		String end = "End of adminOfflineLoadreports method";

		logger.info(start);

		String studentid = (String) sess.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(sess,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		String examname = req.getParameter("exam");
		sess.setAttribute("examnameval", examname);

		logger.info(end);

		return "AdminOfflineExamReports";
	}

}
