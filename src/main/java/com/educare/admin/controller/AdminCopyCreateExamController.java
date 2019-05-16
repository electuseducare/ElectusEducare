package com.educare.admin.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import com.educare.admin.model.AdminCategory;
import com.educare.controller.LoginController;
import com.educare.services.AdminRegisterServiceImpl;

@Controller
public class AdminCopyCreateExamController {

	private static final Logger logger = LoggerFactory.getLogger(AdminCopyCreateExamController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;

	@Value("${exam.withslot}")
	String isslotYes;
	
	@Value("${is_marks}")
	String isMarks;

	@RequestMapping("load-availableExamsInCopyCreateExam")
	private String displayAvailableExamsInCopyCreateExam(Model model, HttpSession ses, AdminCategory ad,HttpServletRequest req) {

		String start = "Entry of displayAvailableExamsInCopyCreateExam method....";
		String end = "End of displayAvailableExamsInCopyCreateExam method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";

		/** get slot based exam names**/
		List<AdminCategory> examlist = adminuserservice.getExamNameForCopySlotExam(isslotYes);

		model.addAttribute("examlist", examlist);
		model.addAttribute("getexamnames", ad);
		model.addAttribute("loadexamdetails", ad);

		logger.info(end);

		return "AdminGetExamNamesForCopyExam";

	}

	@RequestMapping("display-selectedExamDetails")
	private String displaySelectedExamDetails(Model model, HttpSession ses, AdminCategory ad,HttpServletRequest req) {

		String start = "Entry of displaySelectedExamDetails method....";
		String end = "End of displaySelectedExamDetails method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";

		String selectedExam = ad.getSelectedexam();
		model.addAttribute("selectedExam", selectedExam);

		/******* Exam types *******/
		List<AdminCategory> examtypeslist = adminuserservice.searchexamtypesFromAdmin();
		List<AdminCategory> examdetails = adminuserservice.getExamnameAndExamTypeForCopyExam(selectedExam);
		int examtypeid=0;
		for (AdminCategory adc : examdetails) {
			examtypeid= (new Integer(adc.getExamtype_id())).intValue() ;
			model.addAttribute("examdetails", adc);
		}
		model.addAttribute("examtypeslist", examtypeslist);

		/******* States *******/
		List<AdminCategory> statenames = adminuserservice.searchStateFromAdmin();
		List<AdminCategory> prvstates = adminuserservice.getPreviousStatesForCopyExam(selectedExam);
		for (AdminCategory adc1 : prvstates) {
			model.addAttribute("prvstates", adc1);
		}
		model.addAttribute("statenames", statenames);

		/******* Locations *******/
		List<AdminCategory> locationdetails = adminuserservice.searchLocationsFromAdmin();
		List<AdminCategory> prvlocations = adminuserservice.getPreviousLocationsForCopyExam(selectedExam);
		for (AdminCategory adc2 : prvlocations) {
			model.addAttribute("prvlocations", adc2);
		}
		model.addAttribute("locationdetails", locationdetails);

		/******* Branches *******/
		List<AdminCategory> branchdetails = adminuserservice.searchBranchesFromAdmin();
		List<AdminCategory> prvbranches = adminuserservice.getPreviousBranchesForCopyExam(selectedExam);
		for (AdminCategory adc3 : prvbranches) {
			model.addAttribute("prvbranches", adc3);
		}
		model.addAttribute("branchdetails", branchdetails);

		/******* Question level types *******/
		List<AdminCategory> questionlevelslist = adminuserservice.searchquestionleveltypesFromAdmin();
		List<AdminCategory> prvquslevl = adminuserservice.getPreviousQuelevelidsForCopyExam(selectedExam);
		for (AdminCategory adc4 : prvquslevl) {
			model.addAttribute("prvquslevl", adc4);
		}
		model.addAttribute("questionlevelslist", questionlevelslist);

		/******* Classes *******/
		List<AdminCategory> classnames = adminuserservice.searchClassesFromAdmin();
		List<AdminCategory> prvclass = adminuserservice.getPreviousClassidsForCopyExam(selectedExam);
		String classid1 = null;
		int classid = 0;
		for (AdminCategory adc5 : prvclass) {
			classid1 = adc5.getSelectedclassid();
			classid = Integer.valueOf(classid1);
			model.addAttribute("prvclass", adc5);
		}
		model.addAttribute("classnames", classnames);

		/******* Sections *******/
		List<AdminCategory> sectiondetails = adminuserservice.getsectionsfromClass(classid);
		model.addAttribute("secitonnameval", sectiondetails);
		List<AdminCategory> prvsections = adminuserservice.getPreviousSectionidsForCopyExam(selectedExam, classid);
		for (AdminCategory adc6 : prvsections) {
			model.addAttribute("prvsections", adc6);
		}

		/******* Subjects *******/
		String preselectedsubids = null;
		List<AdminCategory> prvsubjects = adminuserservice.getPreviousSubjectsForCopyExam(selectedExam);
		for (AdminCategory adc7 : prvsubjects) {
			preselectedsubids = adc7.getSelectedsubjectid();
			model.addAttribute("prvsubjects", adc7);
		}
		List<AdminCategory> selclasssubjects = adminuserservice.getSelectedClassSubjectsForCopyExam(selectedExam);
		model.addAttribute("selclasssubjects", selclasssubjects);

		List<AdminCategory> selsubjectqns = adminuserservice.getSelectedSubjectQnsForCopyExam(selectedExam);
		model.addAttribute("selsubjectqns", selsubjectqns);

		/******* Topics *******/
		String topicidval=null;
		String ttlTopicids="";
		String[] spltCommaSubj = preselectedsubids.split(",");
		ArrayList<AdminCategory> subjtopiclist = new ArrayList<>();
		for (int i = 0; i < spltCommaSubj.length; i++) {
			AdminCategory tplist = new AdminCategory();
			/** Get subject name based on subject id **/
			String subjname=adminuserservice.getSubjectNameBasedonSubjid(spltCommaSubj[i]);
			tplist.setSubjectid(subjname);
			ArrayList<String> topicStrlist = new ArrayList<>();
			int subji = (new Integer(spltCommaSubj[i].trim())).intValue();
			/**Get Topic# from el_exam Per Subject id**/
			String listtids = adminuserservice.getSelectedTopicIdsForCopyExamPerSubj(selectedExam,
					spltCommaSubj[i].trim());
			topicidval=listtids+"-"+spltCommaSubj[i].trim()+"@";
			String str=topicidval;
			ttlTopicids=str+ttlTopicids;
			/** Get Topic Name From Topic Table based on Topic# and Subject# and Examtype# **/
			List<Map<String, Object>> topicNamelst = adminuserservice.getTopicNameListFromTopicTable(classid, subji,
					listtids,examtypeid);
			String topicnames = "";
			for (Map<String, Object> map : topicNamelst) {
				topicnames = (String) map.get("subject_topic_type");
			}
			topicStrlist.add(topicnames);
			tplist.setTopiclist(topicStrlist);
			subjtopiclist.add(tplist);
		}
		model.addAttribute("subjtopiclist", subjtopiclist);
		model.addAttribute("hidtempTopicIds", ttlTopicids);
		
		/******* Sub Topics *******/
		String stopicidval=null;
		String ttlStopicids="";
		ArrayList<AdminCategory> subjstopiclist = new ArrayList<>();
		for (int i = 0; i < spltCommaSubj.length; i++) {
			AdminCategory stplist = new AdminCategory();
			/** Get subject name based on subject id **/
			String subjname=adminuserservice.getSubjectNameBasedonSubjid(spltCommaSubj[i]);
			stplist.setSubjectid(subjname);
			ArrayList<String> stopicStrlist = new ArrayList<>();
			int subji = (new Integer(spltCommaSubj[i].trim())).intValue();
			/**Get Sub Topic# from el_exam Per Subject id**/
			String stlisttids = adminuserservice.getSelectedSubTopicIdsForCopyExamPerSubj(selectedExam,
					spltCommaSubj[i].trim());
			stopicidval=stlisttids+"-"+spltCommaSubj[i].trim()+"@";
			String str=stopicidval;
			ttlStopicids=str+ttlStopicids;
			/** Get SubTopic Name From Sub Topic Table based on Sub Topic# and Subject# and Examtype# **/
			List<Map<String, Object>> stopicNamelst = adminuserservice.getSubTopicNameListFromTopicTable(classid, subji,
					stlisttids,examtypeid);
			String stopicnames = "";
			for (Map<String, Object> map : stopicNamelst) {
				stopicnames = (String) map.get("subject_subtopic_type");
			}
			stopicStrlist.add(stopicnames);
			stplist.setStopiclist(stopicStrlist);
			subjstopiclist.add(stplist);
		}
		model.addAttribute("subjstopiclist", subjstopiclist);
		model.addAttribute("hidtempStopicIds", ttlStopicids);
		
		
		String ismarks = adminuserservice.getPreviousIsmarksForCopyExam(selectedExam);
		model.addAttribute("is_marks", ismarks);

		List<AdminCategory> questiontype = adminuserservice.searchQuestiontypeFromAdmin();
		List<AdminCategory> categorylist = new ArrayList<>();
		for (AdminCategory adminCategory : questiontype) {
			AdminCategory adm = new AdminCategory();
			String qustypeid = adminCategory.getQuestiontypeid();
			String questype = adminCategory.getQuestiontype();
			adm.setQuestiontype(questype);
			adm.setQuestiontypeid(qustypeid);
			List<String> marks = new ArrayList<>();
			List<String> ques = new ArrayList<>();
			List<String> subjectidlist = new ArrayList<>();
			List<String> nmarks = new ArrayList<>();
			List<AdminCategory> qustypesdata = adminuserservice.getPreviousQuestionstypeDataForCopyExam(selectedExam,
					qustypeid);
			for (AdminCategory ac : qustypesdata) {
				subjectidlist.add(ac.getSelectedsubjectid());
				adm.setSubjectlist(subjectidlist);

				String subjectids = ac.getSelectedsubjectid();

				List<AdminCategory> marksdata = adminuserservice.getPreviousQtypeMarksDataForCopyExam(selectedExam,
						qustypeid, subjectids);
				for (AdminCategory ac1 : marksdata) {

					ques.add(ac1.getNumofqusperqustype());
				}
				adm.setSelectednumofqusperqustype(ques);
				if (ismarks.equalsIgnoreCase("no")) {
					for (AdminCategory ac2 : marksdata) {
						marks.add(ac2.getMarksperquestiontype());
					}
					adm.setSelectedmarksperqustype(marks);
					for (AdminCategory ac3 : marksdata) {
						nmarks.add(ac3.getNmarksperquestiontype());
					}
					adm.setSelnegmarksperqntype(nmarks);
				}

			}
			categorylist.add(adm);

		}

		/******* Question types *******/
		List<AdminCategory> prvquestiontype = adminuserservice.getPreviousQuestiontypeForCopyExam(selectedExam);
		for (AdminCategory adc10 : prvquestiontype) {
			model.addAttribute("prvquestiontype", adc10);
		}
		model.addAttribute("questiontype", questiontype);

		/******* Is marks *******/
		if (ismarks.equalsIgnoreCase("yes")) {
			int marksperqustype = adminuserservice.getPreviousMarksperQustypeForCopyexam(selectedExam,isMarks);
			model.addAttribute("marksperqustype", marksperqustype);
			String prevnegativemarks = adminuserservice.getPreviousNegativemarksForCopyexam(selectedExam);
			model.addAttribute("prevnegativemarks", prevnegativemarks);
		}

		/******* Start time *******/
		String previousstarttime = adminuserservice.getPreviousStarttimeForCopyexam(selectedExam);
		String prevstarttime = previousstarttime.substring(0, previousstarttime.length() - 3);
		model.addAttribute("prevstarttime", prevstarttime);

		/******* End time *******/
		String previousendtime = adminuserservice.getPreviousEndtimeForCopyexam(selectedExam);
		String prevendtime = previousendtime.substring(0, previousendtime.length() - 3);
		model.addAttribute("prevendtime", prevendtime);

		/******* Test duration *******/
		String prevtestduration = adminuserservice.getPreviousTestdurationForCopyexam(selectedExam);
		model.addAttribute("prevtestduration", prevtestduration);

		model.addAttribute("categorylist", categorylist);
		model.addAttribute("loadexamdetails", ad);
		model.addAttribute("getexamnames", ad);

		logger.info(end);
		return "AdminCopyCreateExam";

	}

}
