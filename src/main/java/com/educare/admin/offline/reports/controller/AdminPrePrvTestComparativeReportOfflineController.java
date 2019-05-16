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
import com.educare.admin.controller.AdminPrePrvTestComparativeReportController;
import com.educare.admin.model.AdminAllIndiaMarksAnalysisPojo;
import com.educare.services.AdminRegisterServiceImpl;

@Controller
public class AdminPrePrvTestComparativeReportOfflineController {

	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(AdminPrePrvTestComparativeReportController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;
	
	@Autowired
	private DatabaseValueController dv;

	@RequestMapping("/load-presentprevmarksAnalysisoffline")
	public ModelAndView getPresentPreviousMarksAnalysisDetails(Model model, HttpServletRequest req, HttpSession ses) {

		String start = "Entry of getPresentPreviousMarksAnalysisDetails method....";
		String end = "End of getPresentPreviousMarksAnalysisDetails method....";

		logger.info(start);
		
		Map<String, Object> model1 = new HashMap<>();
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return new ModelAndView("defaultDatabaseErrorPage", "model1", model1);

		String examname = (String) ses.getAttribute("examnameval");
		String examname1 = null;
		int prevtotalmarks = 0;
		String presstateid = null;
		String preslocationid = null;
		String presbranchid = null;
		String presclassid = null;
		String pressectionid = null;
		List<Map<String, Object>> examiddetails = adminuserservice.getDetailsOfPresentExamoffline(examname);
		for (Map<String, Object> map : examiddetails) {
			Object presstateid1 = map.get("state");
			Object presllocationid1 = map.get("el_location_id");
			Object presbranchid1 = map.get("campus");
			Object presclassid1 = map.get("class_id");
			Object pressectionid1 = map.get("section");
			presstateid = String.valueOf(presstateid1);
			preslocationid = String.valueOf(presllocationid1);
			presbranchid = String.valueOf(presbranchid1);
			presclassid = String.valueOf(presclassid1);
			pressectionid = String.valueOf(pressectionid1);

		}

		List<Map<String, Object>> examName1 = adminuserservice.getpreviousexamnameforreportoffline(examname,
				presstateid, preslocationid, presbranchid, presclassid, pressectionid);
		if (!examName1.isEmpty()) {
			for (Map<String, Object> map : examName1) {

				Object examName = map.get("exam_name");
				Object totlamarks = map.get("total_marks");
				examname1 = String.valueOf(examName);
				prevtotalmarks = Integer.valueOf(totlamarks.toString());
			}
		}
		model.addAttribute("prevtotalmarks", prevtotalmarks);

		List<AdminAllIndiaMarksAnalysisPojo> prevSubject = adminuserservice
				.getpreviousexamSubjectforreportoffline(examname1);
		int k = 0;
		int previouscount = prevSubject.size();
		String prevsubjidval = null;
		String[] prevsubjids = new String[previouscount];

		for (AdminAllIndiaMarksAnalysisPojo adminAllIndiaMarksAnalysisPojo : prevSubject) {

			prevsubjidval = adminAllIndiaMarksAnalysisPojo.getSubjectid();

			prevsubjids[k] = prevsubjidval;
			k++;
		}

		List<AdminAllIndiaMarksAnalysisPojo> allDetails = new ArrayList<>();
		List<AdminAllIndiaMarksAnalysisPojo> subjects = adminuserservice.getsubjectsfromStudentResultsOffline(examname);
		String subjectnames = null;
		String subjectid1 = null;
		int i = 0;
		int countofsub = subjects.size();
		String[] subjs = new String[countofsub];
		String[] subjsid = new String[countofsub];
		for (AdminAllIndiaMarksAnalysisPojo subnames : subjects) {
			subjectnames = subnames.getSubjectname();
			subjectid1 = subnames.getSubjectid();
			subjs[i] = subjectnames;
			subjsid[i] = subjectid1;
			i++;
		}

		List<AdminAllIndiaMarksAnalysisPojo> sturesults = adminuserservice
				.getuserdetailsfromStudentResultsOffline(examname, subjsid[0]);
		for (AdminAllIndiaMarksAnalysisPojo sresults : sturesults) {
			AdminAllIndiaMarksAnalysisPojo detailsPojo = new AdminAllIndiaMarksAnalysisPojo();

			List<String> listpresnextsubjectsmarks = new ArrayList<>();
			List<Integer> listpresnextsubjectsrank = new ArrayList<>();
			List<String> listprevnextsubjectsmarks = new ArrayList<>();
			List<Integer> listprevnextsubjectsrank = new ArrayList<>();

			String state = sresults.getState();
			detailsPojo.setState(state);
			String subjectid = sresults.getSubjectid();
			String studentname = sresults.getStudentname();
			detailsPojo.setStudentname(studentname);
			String sectionname = sresults.getSectionname();
			detailsPojo.setSectionname(sectionname);
			String scoredmarks = sresults.getScoredmarks();
			detailsPojo.setScoredmarks(scoredmarks);
			detailsPojo.setScoredmarks1(scoredmarks);
			String campusname = sresults.getCampusname();
			detailsPojo.setCampusname(campusname);
			int totalmarks = sresults.getTotalmarks();
			detailsPojo.setTotalmarks(totalmarks);

			String studentid = sresults.getStudentid();
			detailsPojo.setStudentid(studentid);
			int campusid = sresults.getCampusid();
			detailsPojo.setCampusid(campusid);
			int stateid = sresults.getStateid();
			detailsPojo.setStateid(stateid);
			int sectionid = sresults.getSectionid();
			detailsPojo.setSectionid(sectionid);

			if (subjectid != null) {
				int allindiarank = adminuserservice.getAllIndiaRankBasedOnExamnameoffline(examname, studentid);
				detailsPojo.setAllindiarank(allindiarank);
			}

			int allindiasubjrank = adminuserservice.getAllIndiaReportSubjectRank1offline(examname, studentid,
					subjsid[0]);
			detailsPojo.setSubjectrank(allindiasubjrank);

			// ============ next subject present in present exam
			for (int j = 1; j <= subjsid.length - 1; j++) {

				int prsntexamScoredmarksCount = adminuserservice.getCountofScoredmarksForExam2offline(examname,
						campusid, stateid, subjsid[j], studentid, sectionid);
				if (prsntexamScoredmarksCount > 0) {
					String prsntexamScoredmarks = adminuserservice.getScoredmarksForExam2offline(examname, campusid,
							stateid, subjsid[j], studentid, sectionid);
					listpresnextsubjectsmarks.add(prsntexamScoredmarks);
				}
				int allindiasubjrank1 = adminuserservice.getAllIndiaReportSubjectRank1offline(examname, studentid,
						subjsid[j]);
				listpresnextsubjectsrank.add(allindiasubjrank1);

				detailsPojo.setPresnextsubjectsmarkslist(listpresnextsubjectsmarks);
				detailsPojo.setPresnextsubjectsranklist(listpresnextsubjectsrank);
			}

			// ============= Previous subject present in previous exam

			if (subjectid != null) {
				int allindiarank = adminuserservice.getAllIndiaRankBasedOnExamnameoffline(examname1, studentid);
				detailsPojo.setAllindiarankex2(allindiarank);
			}

			for (k = 0; k < prevsubjids.length; k++) {
				int prevexamScoredmarksCount = 0;
				if (examname1 != null) {
					prevexamScoredmarksCount = adminuserservice.getCountofScoredmarksForExam2offline(examname1,
							campusid, stateid, prevsubjids[k], studentid, sectionid);
					if (prevexamScoredmarksCount > 0) {
						String prevexamScoredmarks = adminuserservice.getScoredmarksForExam2offline(examname1, campusid,
								stateid, prevsubjids[k], studentid, sectionid);
						listprevnextsubjectsmarks.add(prevexamScoredmarks);
					}
					int allindiasubjrank2 = adminuserservice.getAllIndiaReportSubjectRank1offline(examname1, studentid,
							prevsubjids[k]);
					listprevnextsubjectsrank.add(allindiasubjrank2);

				}
				if (prevexamScoredmarksCount == 0) {
					listprevnextsubjectsmarks.add("0");
				}

				detailsPojo.setPrevnextsubjectsmarkslist(listprevnextsubjectsmarks);
				detailsPojo.setPrevnextsubjectsranklist(listprevnextsubjectsrank);
			}

			allDetails.add(detailsPojo);
		}

		model1.put("prevSubject", prevSubject);
		model1.put("subjects", subjects);
		model1.put("allDetails", allDetails);

		logger.info(end);

		return new ModelAndView("offlineReports/AdminPrePrvTestComparativeReportoffline", "model1", model1);
	}
}
