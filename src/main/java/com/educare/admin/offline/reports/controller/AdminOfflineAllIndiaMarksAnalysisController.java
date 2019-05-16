package com.educare.admin.offline.reports.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.educare.DatabaseValueController;
import com.educare.admin.model.AdminAllIndiaMarksAnalysisPojo;
import com.educare.services.AdminRegisterServiceImpl;

@Controller
public class AdminOfflineAllIndiaMarksAnalysisController {

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;
	
	@Autowired
	private DatabaseValueController dv;

	@RequestMapping("/offline-allindiamarksAnalysis")
	public ModelAndView getOfflineAllindiaMarksAnalysisDetails(Model model, AdminAllIndiaMarksAnalysisPojo ad,
			HttpServletRequest req, HttpSession ses) {

		Map<String, Object> model1 = new HashMap<>();
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return new ModelAndView("defaultDatabaseErrorPage", "model1", model1);
		
		String examname = (String) ses.getAttribute("examnameval");

		String subjectids = null;
		List<AdminAllIndiaMarksAnalysisPojo> allDetails = new ArrayList<>();
		List<AdminAllIndiaMarksAnalysisPojo> subjects = adminuserservice.getsubjectsfromStudentResultsOffline(examname);
		int i = 0;
		int countofsub = subjects.size();
		String[] subjs1 = new String[countofsub];
		int totalscoredmarks = 0;
		for (AdminAllIndiaMarksAnalysisPojo subnames : subjects) {
			subjectids = subnames.getSubjectid();
			subjs1[i] = subjectids;
			i++;
		}
		List<AdminAllIndiaMarksAnalysisPojo> sturesults = adminuserservice
				.getuserdetailsfromStudentResultsOffline(examname, subjs1[0]);
		String subScoredmarks = null;
		for (AdminAllIndiaMarksAnalysisPojo sresults : sturesults) {
			AdminAllIndiaMarksAnalysisPojo detailsPojo = new AdminAllIndiaMarksAnalysisPojo();
			ArrayList<String> subTotalmarkslist = new ArrayList<>();
			ArrayList<String> subjectRank = new ArrayList<>();
			ArrayList<Float> subjectPer = new ArrayList<>();

			String studentname = sresults.getStudentname();
			detailsPojo.setStudentname(studentname);
			detailsPojo.setUsername(sresults.getUsername());
			String sectionname = sresults.getSectionname();
			detailsPojo.setSectionname(sectionname);
			int scoredmarks = Integer.parseInt(sresults.getScoredmarks());
			detailsPojo.setScoredmarks(String.valueOf(scoredmarks));

			float scmarks = (new Float(scoredmarks)).floatValue();

			detailsPojo.setScoredmarks1(String.valueOf(scmarks));
			String campusname = sresults.getCampusname();
			detailsPojo.setCampusname(campusname);
			int totalmarks = sresults.getTotalmarks();
			detailsPojo.setTotalmarks(totalmarks);

			int classid = sresults.getClassid();
			detailsPojo.setClassid(classid);
			float subPercentage = (scmarks * 100) / totalmarks;
			detailsPojo.setSub_percentage(subPercentage);

			String studentid = sresults.getStudentid();
			detailsPojo.setStudentid(studentid);
			int campusid = sresults.getCampusid();
			detailsPojo.setCampusid(campusid);
			int stateid = sresults.getStateid();
			detailsPojo.setStateid(stateid);
			int sectionid = sresults.getSectionid();
			detailsPojo.setSectionid(sectionid);
			String subjectRank1 = adminuserservice.getAllIndiaReportSubjectRankOffline(examname, studentid, subjs1[0]);
			detailsPojo.setSubject_rank1(subjectRank1);
			int subjectScoredmarks = adminuserservice.getScoredmarksPerSubjectOffline(examname, studentid, subjs1[0]);
			totalscoredmarks = subjectScoredmarks;
			detailsPojo.setSub_totalmarks(totalscoredmarks);
			float totalpercentage = (totalscoredmarks * 100) / totalmarks;
			DecimalFormat df = new DecimalFormat();
			df.setMaximumFractionDigits(2);
			float totalpercentage1 = (new Float(totalpercentage)).floatValue();
			detailsPojo.setTotal_percentage(totalpercentage1);
			
			for (int j = 1; j < subjs1.length; j++) {
				subScoredmarks = adminuserservice.getuserdetailsfromStudentResultsInAnotherSubjOffline(examname,
						subjs1[j], classid, sectionid, campusid, stateid, studentid);
				subTotalmarkslist.add(subScoredmarks);
				detailsPojo.setLtoatlamarks(subTotalmarkslist);
				String subjectRanks = adminuserservice.getAllIndiaReportSubjectRankOffline(examname, studentid,
						subjs1[j]);
				subjectRank.add(subjectRanks);
				detailsPojo.setLsubrank(subjectRank);
				int scMarks = (new Integer(subScoredmarks)).intValue();
				subPercentage = (scMarks * 100) / totalmarks;
				subjectPer.add(subPercentage);
				detailsPojo.setLsub_percentage(subjectPer);
				subjectScoredmarks = adminuserservice.getScoredmarksPerSubjectOffline(examname, studentid, subjs1[j]);
				totalscoredmarks += subjectScoredmarks;
				detailsPojo.setSub_totalmarks(totalscoredmarks);
				totalpercentage = (totalscoredmarks * 100) / totalmarks;
				df.setMaximumFractionDigits(2);
				 totalpercentage1 = (new Float(totalpercentage)).floatValue();
				detailsPojo.setTotal_percentage(totalpercentage1);

			}

			model1.put("sub_scoredmarks", subScoredmarks);

			int allindiarank = adminuserservice.getAllIndiaRankBasedOnExamnameOffline(examname, studentid);
			detailsPojo.setAllindiarank(allindiarank);

			int allindiacrank = adminuserservice.getAllIndiaCampusRankBasedOnExamnameOffline(examname, studentid,
					campusid);
			detailsPojo.setCampusrank(allindiacrank);

			int allindiastrank = adminuserservice.getAllIndiaStateRankBasedOnExamnameOffline(examname, studentid,
					stateid);
			detailsPojo.setStaterank(allindiastrank);

			int allindiascrank = adminuserservice.getAllIndiaSectionRankBasedOnExamnameOffline(examname, studentid,
					sectionid);
			detailsPojo.setSectionrank(allindiascrank);

			allDetails.add(detailsPojo);
		}

		model1.put("subjects", subjects);
		model1.put("allDetails", allDetails);

		return new ModelAndView("offlineReports/AdminOfflineAllIndiaMarksAnalysis", "model1", model1);

	}

}
