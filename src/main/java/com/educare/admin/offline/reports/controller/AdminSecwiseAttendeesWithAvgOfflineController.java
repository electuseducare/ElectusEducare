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
import com.educare.admin.controller.AdminSecwiseAttendeesWithAvgController;
import com.educare.admin.model.AdminAllIndiaMarksAnalysisPojo;
import com.educare.admin.model.AdminSecwiseAttendeesWithAvgPojo;
import com.educare.services.AdminRegisterServiceImpl;

@Controller
public class AdminSecwiseAttendeesWithAvgOfflineController {

	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(AdminSecwiseAttendeesWithAvgController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;
	
	@Autowired
	private DatabaseValueController dv;

	@RequestMapping("/load-sectionwiseattendiesAvgsoffline")
	public ModelAndView getSectionwiseAttendeesWithAverageDetails(Model model, AdminSecwiseAttendeesWithAvgPojo ad,
			HttpServletRequest req, HttpSession ses) {

		String start = "Entry of getSectionwiseAttendeesWithAverageDetails method....";
		String end = "End of getSectionwiseAttendeesWithAverageDetails method....";
		logger.info(start);
		
		Map<String, Object> model1 = new HashMap<>();
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return new ModelAndView("defaultDatabaseErrorPage", "model1", model1);

		String examname = (String) ses.getAttribute("examnameval");
		List<AdminSecwiseAttendeesWithAvgPojo> allDetails = new ArrayList<>();
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

		List<AdminSecwiseAttendeesWithAvgPojo> sturesults = adminuserservice
				.getCampusSectionfromStudentResultsoffline(examname);
		for (AdminSecwiseAttendeesWithAvgPojo campus : sturesults) {
			AdminSecwiseAttendeesWithAvgPojo secPojo = new AdminSecwiseAttendeesWithAvgPojo();
			ArrayList<Float> subjectAvg = new ArrayList<>();
			String campusname = campus.getCampusname();
			secPojo.setCampusname(campusname);

			int campusid = campus.getCampusid();
			secPojo.setCampusid(campusid);

			String sectionname = campus.getSectionname();
			secPojo.setSectionname(sectionname);

			int sectionid = campus.getSectionid();
			secPojo.setSectionid(sectionid);

			int sectioncntinusers = adminuserservice.getActualStudentsPresencePerSectionoffline(sectionid, campusid);
			secPojo.setStusectionactcnt(sectioncntinusers);

			int sectioncntinresults = adminuserservice.getActualStudentsPresencePerSectionInExamoffline(sectionid,
					examname, campusid);
			secPojo.setExamappcnttotal(sectioncntinresults);

			for (int j = 0; j < subjs1.length; j++) {

				String avginSubj = adminuserservice.getAvginSubjectsfromCampusSectionoffline(campusid, sectionid,
						subjs1[j], examname);
				Float subjavg = Float.valueOf(avginSubj);
				subjectAvg.add(subjavg);
				secPojo.setLsubjectavg(subjectAvg);
			}

			String avgintotalmarks = adminuserservice.getAvgInTotalmarksFromCampusSectionoffline(campusid, sectionid,
					examname);
			Float totalmarksavg = Float.valueOf(avgintotalmarks);
			secPojo.setAverageintotal(totalmarksavg);

			allDetails.add(secPojo);
		}
		model1.put("subjects", subjects);
		model1.put("allDetails", allDetails);

		logger.info(end);

		return new ModelAndView("offlineReports/AdminSecwiseAttendeesWithAvgoffline", "model1", model1);

	}

}
