package com.educare.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.educare.DatabaseValueController;
import com.educare.admin.model.AdminExamNameforReport;
import com.educare.admin.model.UpdateKeyModel;
import com.educare.controller.LoginController;
import com.educare.services.AdminRegisterServiceImpl;

@Controller
public class UpdateKeyController {

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;

	@RequestMapping("/load-updateKey")
	public String loadUpdateKey(Model model, UpdateKeyModel ukm, HttpSession ses,HttpServletRequest req) {

		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		List<AdminExamNameforReport> examlist = adminuserservice.getExamNameWiseReportFromAdmin();

		model.addAttribute("examlist", examlist);
		model.addAttribute("ukm", ukm);

		return "examNameUpdate";
	}

	@RequestMapping("/load-editExamKey")
	public String editExamKey(Model model, UpdateKeyModel ukm, HttpSession ses,HttpServletRequest req) {

		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";

		List<UpdateKeyModel> keylst = adminuserservice.editUpdateKeyExam(ukm);
		model.addAttribute("keylst", keylst);

		model.addAttribute("ukm", ukm);

		model.addAttribute("examname", ukm.getExamname());

		return "editExamKey";
	}

	@RequestMapping(value = "/load-updateExamKeys")
	private @ResponseBody int updateExamKeys(UpdateKeyModel ukm, HttpServletRequest req, HttpSession ses) {

		String qid = req.getParameter("qid");
		String key = req.getParameter("keyvalue");
		String exmnam = req.getParameter("examname");

		int upkeys = adminuserservice.updateKeyValuesInQues(qid, key);

		if (upkeys > 0) {
			adminuserservice.updateKEyInStuResHis(key, qid, exmnam);
		}

		return upkeys;
	}

}
