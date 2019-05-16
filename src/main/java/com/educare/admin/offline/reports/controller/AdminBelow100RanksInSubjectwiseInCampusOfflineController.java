package com.educare.admin.offline.reports.controller;

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
import org.springframework.web.servlet.ModelAndView;

import com.educare.DatabaseValueController;
import com.educare.admin.controller.AdminBelow100RanksInSubjectwiseInCampusController;
import com.educare.admin.model.AdminAllIndiaMarksAnalysisPojo;
import com.educare.admin.model.AdminBelow100RanksInSubjectInCampusPojo;
import com.educare.services.AdminRegisterServiceImpl;

@Controller
public class AdminBelow100RanksInSubjectwiseInCampusOfflineController {

	private static final Logger logger = LoggerFactory
			.getLogger(AdminBelow100RanksInSubjectwiseInCampusController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;
	
	@Autowired
	private DatabaseValueController dv;

	@RequestMapping("load-below100rankssubjectwiseincampusoffline")
	public ModelAndView getBelow100RanksInSubInCamp(Model model, AdminBelow100RanksInSubjectInCampusPojo ab,
			HttpSession ses,HttpServletRequest req) {

		String start = "Entry of getBelow100RanksInSubInCamp method....";
		String end = "End of getBelow100RanksInSubInCamp method....";
		logger.info(start);
		
		Map<String, Object> model1 = new HashMap<>();
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return new ModelAndView("defaultDatabaseErrorPage", "model1", model1);

		String examname = (String) ses.getAttribute("examnameval");

		List<AdminBelow100RanksInSubjectInCampusPojo> allDetails = new ArrayList<>();
		List<AdminAllIndiaMarksAnalysisPojo> subjects = adminuserservice.getsubjectsfromStudentResultsOffline(examname);

		int i = 0;
		String subjectids = null;
		int countofsub = subjects.size();
		String[] subjs1 = new String[countofsub];
		for (AdminAllIndiaMarksAnalysisPojo subnames : subjects) {
			subjectids = subnames.getSubjectid();
			subjs1[i] = subjectids;
			i++;
		}
		List<AdminBelow100RanksInSubjectInCampusPojo> campusnames = adminuserservice
				.getCampusnamesInStudentResultsoffline(examname);
		for (AdminBelow100RanksInSubjectInCampusPojo below100rank : campusnames) {
			ArrayList<Integer> subrankcount = new ArrayList<>();
			ArrayList<String> maxmarkslist = new ArrayList<>();
			AdminBelow100RanksInSubjectInCampusPojo detailsPojo = new AdminBelow100RanksInSubjectInCampusPojo();
			int campusid = below100rank.getCampusid();
			String campus = below100rank.getCampus();
			detailsPojo.setCampus(campus);
			int examstrength = adminuserservice.getExamstrengthInCampuswiseBelow100Ranksoffline(examname, campusid);
			detailsPojo.setExamstrength(examstrength);

			for (int j = 0; j < subjs1.length; j++) {
				int rankcount = adminuserservice.getRankcountInCampuswiseBelow100Ranksoffline(examname, campusid,
						subjs1[j]);
				subrankcount.add(rankcount);
				detailsPojo.setLsub_rankcount(subrankcount);
				String maxmarks = adminuserservice.getMaxmarksInCampuswiseBelow100Ranksoffline(examname, campusid,
						subjs1[j]);
				maxmarkslist.add(maxmarks);
				detailsPojo.setLmaxmarkst(maxmarkslist);

			}

			allDetails.add(detailsPojo);
		}

		model1.put("subjects", subjects);
		model1.put("allDetails", allDetails);

		logger.info(end);

		return new ModelAndView("offlineReports/AdminBelow100RanksInSubjectwiseInCampusReportoffline", "model1",
				model1);

	}

}
