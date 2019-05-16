package com.educare.admin.controller;

import java.util.ArrayList;
import java.util.HashMap;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.educare.DatabaseValueController;
import com.educare.admin.model.AdminCategory;
import com.educare.controller.LoginController;
import com.educare.services.AdminRegisterServiceImpl;

@Controller
public class AdminStudentProfileMarksController {

	private static final Logger logger = LoggerFactory.getLogger(AdminStudentProfileMarksController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;
	
	String sidval="student_id";
	String estavgval="estavg";
	String returnjsp="adminStudentMarksProfileSearch";

	@RequestMapping("/load-studentmarksprofilesearch")
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
		List<AdminCategory> examtypeslist = adminuserservice.searchexamtypesFromAdmin();

		model.addAttribute("statenames", statenames);
		model.addAttribute("classnames", classnames);
		model.addAttribute("examtypeslist", examtypeslist);

		logger.info(end);

		return returnjsp;
	}

	@RequestMapping("/load-locationsformForStudMarksEstAvg")
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

	@RequestMapping("/load-BranchformForStudMarksEstAvg")
	public String loadBranchFromLocations(Model model, AdminCategory ac, HttpSession ses, HttpServletRequest req) {

		String start = "Entry of loadBranchFromLocations method....";
		String end = "End of loadBranchFromLocations method....";
		logger.info(start);

		model.addAttribute(estavgval, ac);
		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		String locationid = req.getParameter("locationid");
		List<AdminCategory> branch = adminuserservice.searchBranchesFromAdminBasedonLocation(locationid);

		model.addAttribute("branch", branch);

		logger.info(end);

		return returnjsp;
	}

	@RequestMapping("/get-sectiondetailsfromClassForStudMarksEstAvg")
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

	@RequestMapping("/get-allStudentsFromInputsForStudMarksEstAvg")
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

	@RequestMapping(value = "/viewStuProfileMarksEstAvg")
	public ModelAndView viewStudentFullProfile(Model model, AdminCategory ac, HttpSession ses,HttpServletRequest req) {
		
		String start = "Entry of viewStudentFullProfile method....";
		String end = "End of viewStudentFullProfile method....";
		logger.info(start);
		model.addAttribute(estavgval, ac);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		Map<String, Object> model1 = new HashMap<>();
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return new ModelAndView("defaultDatabaseErrorPage", "model1", model1);


		String studentidchkname = ac.getStudentidchkname();
		String examtypeid = ac.getExamtypeselectbox();

		/************************
		 * GET Student name,class,section,state,location,branch
		 ***********************/
		List<Map<String, Object>> studentinfo = adminuserservice.getSelectedStudentInformation(studentidchkname);
		String username = "";
		String stuname = "";
		String classname = "";
		String sectioname = "";
		String statename = "";
		String locationname = "";
		String branchname = "";
		for (Map<String, Object> map : studentinfo) {
			username = (String) map.get("user_name");
			stuname = (String) map.get("stuname");
			classname = (String) map.get("el_class_name");
			sectioname = (String) map.get("el_section_name");
			statename = (String) map.get("state_type");
			locationname = (String) map.get("el_location_name");
			branchname = (String) map.get("el_branch_name");
		}
		model.addAttribute("username", username);
		model.addAttribute("stuname", stuname);
		model.addAttribute("classname", classname);
		model.addAttribute("sectioname", sectioname);
		model.addAttribute("statename", statename);
		model.addAttribute("locationname", locationname);
		model.addAttribute("branchname", branchname);

		List<AdminCategory> getsubjects = adminuserservice.getSubjectIdsForStudent(studentidchkname, examtypeid);
		String examtype = "";
		for (AdminCategory act : getsubjects) {
			examtype = act.getExamtype();
		}
		model.addAttribute("examtype", examtype);
		int i = 0;
		String subjectids = null;
		int countofsub = getsubjects.size();
		String[] subjs1 = new String[countofsub];
		for (AdminCategory subnames : getsubjects) {
			subjectids = subnames.getSubjectid();
			subjs1[i] = subjectids;
			i++;
		}

		ArrayList<AdminCategory> catlist = new ArrayList<>();
		List<AdminCategory> getExamNames = adminuserservice.getExamTypeAndExamNameFromElExam(studentidchkname,
				examtypeid);
		for (AdminCategory ex : getExamNames) {
			String examname = ex.getExamname();
			AdminCategory acpojo = new AdminCategory();
			ArrayList<String> totalmarkslist = new ArrayList<>();
			acpojo.setExamdate(ex.getExamdate());

			List<Map<String, Object>> stuinfo = adminuserservice.getStudentMarksperSubject(studentidchkname, examname,
					subjs1[0]);
			String scoredmarks = "NA";

			if (!stuinfo.isEmpty()) {
				for (Map<String, Object> map : stuinfo) {
					int scoredmarks1 = (Integer) map.get("SCORED_MARKS");
					scoredmarks = String.valueOf(scoredmarks1);
				}
			}
			acpojo.setScoredmarks(scoredmarks);
			/**************************
			 * GET EXAM TOTAL MARKS
			 ***********************************/
			List<Map<String, Object>> examtotmarks = adminuserservice.getExamTotalMarksPerExam(studentidchkname,
					examname);
			String extotalmarks = "NA";
			if (!examtotmarks.isEmpty()) {
				for (Map<String, Object> map : examtotmarks) {
					int examtotalmarks = (Integer) map.get("EXAM_SCORED_MARKS");
					extotalmarks = String.valueOf(examtotalmarks);
				}
			}

			/**************************
			 * GET EXAM RANK
			 ******************************************/
			int examranks = adminuserservice.getExamRankPerExam(studentidchkname, examname);

			acpojo.setExamwiserank(String.valueOf(examranks));
			acpojo.setExamtotalmarks(extotalmarks);
			/**************************
			 * GET EXAM SCORED MARKS FOR NEXT SUBJECT
			 *****************/
			for (int j = 1; j < subjs1.length; j++) {
				List<Map<String, Object>> stuinfo1 = adminuserservice.getStudentMarksperSubject(studentidchkname,
						examname, subjs1[j]);
				if (!stuinfo1.isEmpty()) {
					for (Map<String, Object> map : stuinfo1) {
						int scoredmarks1 = (Integer) map.get("SCORED_MARKS");
						scoredmarks = String.valueOf(scoredmarks1);
					}
				} else {
					scoredmarks = "NA";
				}
				totalmarkslist.add(scoredmarks);
				acpojo.setSubscoremarkslist(totalmarkslist);

			}
			catlist.add(acpojo);

		}

		List<AdminCategory> studentavg = adminuserservice.calculateStudentAverageMarks(studentidchkname, examtypeid);
		ArrayList<AdminCategory> adlist = new ArrayList<>();
		double totalavg = 0;
		for (AdminCategory map : studentavg) {
			AdminCategory act = new AdminCategory();
			ArrayList<String> avglist = new ArrayList<>();
			String avgmarks = map.getAvgmarks();
			double totalavg1 =(new Double(avgmarks)).doubleValue();
			avglist.add(avgmarks);
			act.setAvgmarkslist(avglist);
			adlist.add(act);
			totalavg = totalavg + totalavg1;
		}

		model.addAttribute("totalavg", totalavg);
		model.addAttribute("adlist", adlist);

		model1.put("subjects", getsubjects);
		model1.put("catlist", catlist);
		
		logger.info(end);

		return new ModelAndView("studentEstProfileReport", "model1", model1);

	}

}
