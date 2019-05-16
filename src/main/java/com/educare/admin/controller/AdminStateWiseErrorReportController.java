package com.educare.admin.controller;

import java.util.ArrayList;
import java.util.Collections;
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
import org.springframework.web.servlet.ModelAndView;

import com.educare.DatabaseValueController;
import com.educare.admin.model.AdminAllIndiaMarksAnalysisPojo;
import com.educare.admin.model.CampuswiseErrorreportPojo;
import com.educare.services.AdminRegisterServiceImpl;

@Controller
public class AdminStateWiseErrorReportController {

	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(AdminStateWiseErrorReportController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;
	
	@Autowired
	private DatabaseValueController dv;

	@RequestMapping("load-Statewiseerrorreport")
	public ModelAndView getCampusWiseErrorReport(Model model, CampuswiseErrorreportPojo cwe, HttpSession sess,HttpServletRequest req) {

		String start = "Entry of getCampusWiseErrorReport method....";
		String end = "Entry of getCampusWiseErrorReport method....";
		logger.info(start);
		
		Map<String, Object> model1 = new HashMap<>();
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(sess,req);
		if(dbval.equals("0"))
			return new ModelAndView("defaultDatabaseErrorPage", "model1", model1);

		String examname = (String) sess.getAttribute("examnameval");
		List<CampuswiseErrorreportPojo> allDetails = new ArrayList<>();

		List<CampuswiseErrorreportPojo> qid = null;

		List<CampuswiseErrorreportPojo> campusnames = adminuserservice
				.getuserdetailsfromStudentResultsHistoryforState(examname);
		List<CampuswiseErrorreportPojo> qid1 = adminuserservice.getAllQidsInCampuswise1(examname);
		int questionsize = 0;
		ArrayList<Integer> maxquestioncntarraylist = new ArrayList<>();
		for (CampuswiseErrorreportPojo campusname : campusnames) {

			CampuswiseErrorreportPojo campus = new CampuswiseErrorreportPojo();
			List<String> subjectlist = new ArrayList<>();
			List<Integer> quscountlist = new ArrayList<>();
			List<Float> errorpercentage = new ArrayList<>();

			int stateid = campusname.getStateid();
			String state = campusname.getState();
			campus.setState(state);
			int examStrength = adminuserservice.getStatewiseExamstrength(examname, stateid);
			campus.setExamstrength(examStrength);

			HashMap<String, ArrayList<String>> questionlist = new HashMap<>();
			HashMap<String, ArrayList<Integer>> errorlist = new HashMap<>();
			HashMap<String, ArrayList<Float>> percentagelist = new HashMap<>();

			List<AdminAllIndiaMarksAnalysisPojo> subjects = adminuserservice
					.getsubjectsfromStudentResultsforstate(examname, stateid);
			for (AdminAllIndiaMarksAnalysisPojo subjectsdetails : subjects) {

				ArrayList<String> questionIds = new ArrayList<>();
				ArrayList<Integer> hmap = new ArrayList<>();
				ArrayList<Float> hmapp = new ArrayList<>();

				String subjectname = subjectsdetails.getSubjectname();
				String subjectid = subjectsdetails.getSubjectid();

				int maxquestionlength = adminuserservice.getmaxquestionlength(examname, subjectid);
				maxquestioncntarraylist.add(maxquestionlength);

				subjectlist.add(subjectname);

				qid = adminuserservice.getAllQidsInStatewise(examname, stateid, subjectid);
				questionsize = qid.size();
				for (CampuswiseErrorreportPojo countqid : qid) {

					int questionid1 = countqid.getQuestionid();
					int questionrowid = countqid.getQuestionrowid();
					String questionid = String.valueOf(questionid1);

					questionIds.add(questionid);

					int countofErrorQid = adminuserservice.getCountOfAllErrorQuestionIdsInstatewise(examname, stateid,
							questionid1, subjectid, questionrowid);

					quscountlist.add(countofErrorQid);

					float qiderrorpercentage = 0;
					try {
						qiderrorpercentage = (float) ((countofErrorQid * 100) / examStrength);
						errorpercentage.add(qiderrorpercentage);
					} catch (Exception e) {
					}

					hmap.add(countofErrorQid);
					hmapp.add(qiderrorpercentage);

				}

				questionlist.put(subjectname, questionIds);
				errorlist.put(subjectname, hmap);
				percentagelist.put(subjectname, hmapp);

			}

			campus.setLquestionid(questionlist);
			campus.setLqnerrorpercentage(percentagelist);
			campus.setLquestionerrorcnt(errorlist);

			campus.setListsubject(subjectlist);

			allDetails.add(campus);

		}

		/* Sorting in decreasing order */
		Collections.sort(maxquestioncntarraylist, Collections.reverseOrder());

		/* Sorted List in reverse order */
		int j = 1;
		for (Integer str : maxquestioncntarraylist) {
			if (j == 1) {
				model.addAttribute("quescntlenght", str);
			}
			j++;
		}

		model1.put("allDetails", allDetails);
		model1.put("questionsize", questionsize);
		model1.put("qid1", qid1);
		model1.put("qid", qid);

		logger.info(end);

		return new ModelAndView("AdminStateWiseErrorReport", "model1", model1);

	}

}
