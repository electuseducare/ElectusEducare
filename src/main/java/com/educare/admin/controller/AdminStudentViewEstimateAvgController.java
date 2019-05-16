package com.educare.admin.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.educare.DatabaseValueController;
import com.educare.admin.model.AdminCategory;
import com.educare.controller.LoginController;
import com.educare.services.AdminRegisterServiceImpl;

@Controller
public class AdminStudentViewEstimateAvgController {

	private static final Logger logger = LoggerFactory.getLogger(AdminStudentViewEstimateAvgController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;

	String sidval = "student_id";
	String estavgval = "estavg";
	String returnjsp = "adminEstimateStudentAvg";

	@RequestMapping("/load-estimatestudentsearch")
	public String searchStudentForEstimates(Model model, AdminCategory ac, HttpSession ses,HttpServletRequest req) {

		String start = "Entry of searchStudentForEstimates method....";
		String end = "End of searchStudentForEstimates method....";
		logger.info(start);
		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		
		/**** return default database value *****/
			String dbval=dv.getDatabaseValue(ses,req);
			if(dbval.equals("0"))
			return "defaultDatabaseErrorPage";
		
		model.addAttribute(estavgval, ac);
		List<AdminCategory> statenames = adminuserservice.searchStateFromAdmin();
		List<AdminCategory> classnames = adminuserservice.searchClassesFromAdmin();

		model.addAttribute("statenames", statenames);
		model.addAttribute("classnames", classnames);
		logger.info(end);
		return returnjsp;
	}

	@RequestMapping("/load-locationsformForStudEstAvg")
	public String loadLocationsFromStates(Model model, AdminCategory ac, HttpSession ses, HttpServletRequest req) {

		String start = "Entry of loadLocationsFromStates method....";
		String end = "End of loadLocationsFromStates method....";
		logger.info(start);

		model.addAttribute(estavgval, ac);
		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		
		/**** return default database value *****/
			String dbval=dv.getDatabaseValue(ses,req);
			if(dbval.equals("0"))
			return "defaultDatabaseErrorPage";
		
		String stateid = req.getParameter("stateid");
		List<AdminCategory> location = adminuserservice.searchLocationsFromAdminBasedonStates(stateid);

		model.addAttribute("location", location);

		logger.info(end);

		return returnjsp;
	}

	@RequestMapping("/load-BranchformForStudEstAvg")
	public String loadBranchFromLocations(Model model, AdminCategory ac, HttpSession ses, HttpServletRequest req) {

		String start = "Entry of loadLocationsFromStates method....";
		String end = "End of loadLocationsFromStates method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		
		/**** return default database value *****/
			String dbval=dv.getDatabaseValue(ses,req);
			if(dbval.equals("0"))
			return "defaultDatabaseErrorPage";
		
		model.addAttribute(estavgval, ac);
		String locationid = req.getParameter("locationid");
		List<AdminCategory> branch = adminuserservice.searchBranchesFromAdminBasedonLocation(locationid);

		model.addAttribute("branch", branch);

		logger.info(end);

		return returnjsp;
	}

	@RequestMapping("/get-sectiondetailsfromClassForStudEstAvg")
	public String loadSectionsFromClassesForEstStuAvg(Model model, AdminCategory ac, HttpSession ses,
			HttpServletRequest req) {

		String start = "Entry of loadSectionsFromClassesForEstStuAvg method....";
		String end = "End of loadSectionsFromClassesForEstStuAvg method....";
		logger.info(start);

		model.addAttribute(estavgval, ac);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
			String dbval=dv.getDatabaseValue(ses,req);
			if(dbval.equals("0"))
			return "defaultDatabaseErrorPage";
		
		String classids = req.getParameter("classid");
		if (classids != null) {
			int classid = (new Integer(classids)).intValue();
			List<AdminCategory> sectiondetails = adminuserservice.getsectionsfromClass(classid);

			model.addAttribute("secitonnameval", sectiondetails);

		}
		logger.info(end);

		return returnjsp;
	}

	@RequestMapping("/get-allStudentsFromInputsForStudEstAvg")
	public @ResponseBody List<AdminCategory> loadStudentsForEstStuAvg(Model model, AdminCategory ac, HttpSession ses,
			HttpServletRequest req) {

		String start = "Entry of loadStudentsForEstStuAvg method....";
		String end = "End of loadStudentsForEstStuAvg method....";
		logger.info(start);

		model.addAttribute(estavgval, ac);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		String stateid = req.getParameter("stateid");
		String locationid = req.getParameter("locationid");
		String branchid = req.getParameter("branchid");
		String classids = req.getParameter("classid");
		String sectionid = req.getParameter("sectionid");

		List<AdminCategory> studentdetails = adminuserservice.getallStudentsFromAllInputs(stateid, locationid, branchid,
				classids, sectionid);

		model.addAttribute("studentdetails", studentdetails);
		logger.info(end);

		return studentdetails;
	}

	@RequestMapping("load-progresscard")
	public String progreecard(Model model, HttpSession ses,HttpServletRequest req) {
		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		
		/**** return default database value *****/
			String dbval=dv.getDatabaseValue(ses,req);
			if(dbval.equals("0"))
			return "defaultDatabaseErrorPage";

		return "StudentProgressCard";

	}

	@RequestMapping("/viewStuEstAvg")
	public String loadprocessstudentavg(Model model, AdminCategory ac, HttpSession ses, HttpServletRequest req) {

		String start = "Entry of loadprocessstudentavg method....";
		String end = "End of loadprocessstudentavg method....";
		logger.info(start);
		
		
		/**** return default database value *****/
			String dbval=dv.getDatabaseValue(ses,req);
			if(dbval.equals("0"))
			return "defaultDatabaseErrorPage";
		
		String classid = ac.getClassname();
		String section = ac.getSectioncheckname();
		String branch = ac.getBranchcheckname();
		String location = ac.getLoactioncheckvalue();
		String state = ac.getStatechckbox();

		String classname = adminuserservice.getclassnamefromclassis(classid);
		String sectionname = adminuserservice.getsectionnamefromsection(section);
		String branchname = adminuserservice.getbranchnamefrombranch(branch);
		String locationname = adminuserservice.getlocationnamefromlocation(location);
		String statename = adminuserservice.getstatenamefromstate(state);

		model.addAttribute("classname", classname);
		model.addAttribute("sectioname", sectionname);
		model.addAttribute("statename", statename);
		model.addAttribute("locationname", locationname);
		model.addAttribute("branchname", branchname);

		List<AdminCategory> getsubject = null;
		List<AdminCategory> studentsid = adminuserservice.getstudentaveragereportmrksforstudent(classid, section,
				branch, location, state);

		String subjectids = null;
		String convetavg = "";

		getsubject = adminuserservice.getsubjectaveragereportmrksforstudent(classid, section, branch, location, state);

		int i = 0;
		int countofsub = getsubject.size();
		String[] subjs1 = new String[countofsub];
		for (AdminCategory subnames : getsubject) {
			subjectids = subnames.getSubjectid();
			subjs1[i] = subjectids;
			i++;
		}
		List<AdminCategory> listavg = new ArrayList<>();

		for (AdminCategory adminCategory : studentsid) {
			String username = adminuserservice.getUserIDsbasedonstudentid(adminCategory.getStudentid());

			Double test = 0.0;
			int ranktotal = 0;
			AdminCategory detailsPojo = new AdminCategory();
			ArrayList<String> subjectavglst = new ArrayList<>();
			ArrayList<Integer> subjectrankavglst = new ArrayList<>();
			detailsPojo.setUsername(username);
			int examattempts = adminuserservice.getexamcountforrepo(adminCategory.getStudentid());
			detailsPojo.setExamcount(examattempts);
			for (String subjects : subjs1) {
				String getavgscore = adminuserservice.getsubjectaveragescorereportmrksforstudent(classid, section,
						branch, location, state, adminCategory.getStudentid(), subjects);
				subjectavglst.add(getavgscore);
				detailsPojo.setLsubavg(subjectavglst);

				Double testval = Double.valueOf(getavgscore);
				test = test + testval;
				int rank = adminuserservice.getrankforaverage(classid, section, branch, location, state,
						adminCategory.getStudentid(), subjects);
				subjectrankavglst.add(rank);
				detailsPojo.setLsubrank(subjectrankavglst);

				ranktotal = ranktotal + rank;
			}
			test = test / subjs1.length;
			ranktotal = ranktotal / subjs1.length;
			convetavg = new DecimalFormat("##.##").format(test);
			String avg = String.valueOf(convetavg);
			detailsPojo.setTotalavg(avg);
			detailsPojo.setRanktotal(String.valueOf(ranktotal));
			listavg.add(detailsPojo);
		}

		model.addAttribute("studentavgdetails", studentsid);
		model.addAttribute("listavg", listavg);
		model.addAttribute("studentavgsubjects", getsubject);
		logger.info(end);
		return "viewstuestavg";

	}

}
