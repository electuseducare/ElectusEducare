package com.educare.admin.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.educare.DatabaseValueController;
import com.educare.admin.model.AdminExamNameforReport;
import com.educare.admin.model.AdminFormViewExamQuesPaperModel;
import com.educare.admin.model.AdminViewExamQuesPaperModel;
import com.educare.controller.LoginController;
import com.educare.services.AdminRegisterServiceImpl;

import org.slf4j.Logger;

@Controller
public class AdminViewExamQuesPaperController {

	private static final Logger logger = LoggerFactory.getLogger(AdminViewExamQuesPaperController.class);

	@Autowired
	private LoginController lc;

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;
	
	@Autowired
	private DatabaseValueController dv;

	String sidval = "student_id";
	String epaperval = "epaper";

	@RequestMapping("/load-viewexamnamesforqpaper")
	public String loadExamNameForQuspaper(Model model, AdminViewExamQuesPaperModel epaper, HttpSession ses,HttpServletRequest req) {

		String start = "Entry of loadExamNameForQuspaper method....";
		String end = "End of loadExamNameForQuspaper method....";

		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		List<AdminExamNameforReport> examlist = adminuserservice.getExamnamesFromExampaper();

		model.addAttribute("examlist", examlist);
		model.addAttribute(epaperval, epaper);

		logger.info(end);

		return "examNameforExampaper";
	}

	@RequestMapping("/load-viewKeyButtons")
	public String viewKeyButtons(Model model, AdminViewExamQuesPaperModel epaper, HttpSession ses,
			HttpServletRequest req) {

		String start = "Entry of viewKeyButtons method....";
		String end = "End of viewKeyButtons method....";

		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		model.addAttribute(epaperval, epaper);
		String enam = epaper.getExamname();
		model.addAttribute("enam", enam);
		logger.info(end);

		return "questonPaperTwoButtons";
	}

	@RequestMapping("/load-viewexamquestionpaper")
	public ModelAndView viewExamQuestionPaper(Model model, AdminViewExamQuesPaperModel epaper, HttpSession ses,
			HttpServletRequest req) {

		String start = "Entry of viewExamQuestionPaper method....";
		String end = "End of viewExamQuestionPaper method....";

		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		Map<String, Object> model1 = new HashMap<>();
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return new ModelAndView("defaultDatabaseErrorPage", "model1", model1);

		String en = req.getParameter("enmahidden");
		epaper.setExamname(en);
		model.addAttribute(epaperval, epaper);
		String subjid = adminuserservice.getSubjectidBasedonExamname(epaper);
		List<AdminViewExamQuesPaperModel> subjlist = adminuserservice.getsubjectnamefromsubjectid(subjid);
		model.addAttribute("subjlist", subjlist);

		List<AdminFormViewExamQuesPaperModel> fq = new ArrayList<>();
		List<AdminViewExamQuesPaperModel> quslist = null;

		for (AdminViewExamQuesPaperModel sbl : subjlist) {
			AdminFormViewExamQuesPaperModel temp = new AdminFormViewExamQuesPaperModel();
			temp.setSubjectname(sbl.getSubjectname());
			temp.setSubjectid(sbl.getSubjectid());
			epaper.setSubjectid(sbl.getSubjectid());
			quslist = adminuserservice.getDisplayQuesToViewQuepaper(epaper);
			temp.setList(quslist);
			fq.add(temp);

		}
		model1.put("fqp", fq);
		model.addAttribute("examname", epaper.getExamname());

		logger.info(end);

		return new ModelAndView("adminViewExamQuestionPaper", "model1", model1);
	}

	@RequestMapping("/load-viewexamquestionpaperwithkey")
	public ModelAndView viewexamquestionpaperwithkey(Model model, AdminViewExamQuesPaperModel epaper, HttpSession ses,
			HttpServletRequest req) {

		String start = "Entry of viewexamquestionpaperwithkey method....";
		String end = "End of viewexamquestionpaperwithkey method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		Map<String, Object> model1 = new HashMap<>();
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return new ModelAndView("defaultDatabaseErrorPage", "model1", model1);

		String en = req.getParameter("enmahidden");
		epaper.setExamname(en);
		model.addAttribute(epaperval, epaper);
		String subjid = adminuserservice.getSubjectidBasedonExamname(epaper);
		List<AdminViewExamQuesPaperModel> subjlist = adminuserservice.getsubjectnamefromsubjectid(subjid);
		model.addAttribute("subjlist", subjlist);

		List<AdminFormViewExamQuesPaperModel> fq = new ArrayList<>();
		List<AdminViewExamQuesPaperModel> quslist = null;

		for (AdminViewExamQuesPaperModel sbl : subjlist) {
			AdminFormViewExamQuesPaperModel temp = new AdminFormViewExamQuesPaperModel();
			temp.setSubjectname(sbl.getSubjectname());
			temp.setSubjectid(sbl.getSubjectid());
			epaper.setSubjectid(sbl.getSubjectid());
			quslist = adminuserservice.getDisplayQuesToViewQuepaper(epaper);
			temp.setList(quslist);
			fq.add(temp);

		}
		model1.put("fqp", fq);
		model.addAttribute("examname", epaper.getExamname());

		logger.info(end);

		return new ModelAndView("adminViewExamQuestionPaperWithKey", "model1", model1);
	}

}
