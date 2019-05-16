package com.educare.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.educare.DatabaseValueController;@Controller
public class AdminHelpContentController {
	
	@Autowired
	private DatabaseValueController dv;

	@RequestMapping("/load-adminHelpContent")
	private String adminHelpViewContent(HttpServletRequest req,HttpSession ses){
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		return "AdminIntranetdocument";
		
	}
	
}
