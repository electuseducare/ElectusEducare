package com.educare.admin.controller;

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
public class AdminAllIndiaMarksAnalysisController {

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;
	
	@Autowired
	private DatabaseValueController dv;

	@RequestMapping("/load-allindiamarksAnalysis")
	public ModelAndView getAllindiaMarksAnalysisDetails(Model model, AdminAllIndiaMarksAnalysisPojo ad,
			HttpServletRequest req, HttpSession ses) {

		Map<String, Object> model1 = new HashMap<>();
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return new ModelAndView("defaultDatabaseErrorPage", "model1", model1);
		
		String examname = (String) ses.getAttribute("examnameval");

		String subjectids = null;
		List<AdminAllIndiaMarksAnalysisPojo> allDetails = new ArrayList<>();
		List<AdminAllIndiaMarksAnalysisPojo> subjects = adminuserservice.getsubjectsfromStudentResults(examname);
		int i = 0;
		int countofsub = subjects.size();
		String[] subjs1 = new String[countofsub];
		float totalscoredmarks = 0;
		for (AdminAllIndiaMarksAnalysisPojo subnames : subjects) {
			subjectids = subnames.getSubjectid();
			subjs1[i] = subjectids;
			i++;
		}
		List<AdminAllIndiaMarksAnalysisPojo> sturesults = adminuserservice.getuserdetailsfromStudentResults(examname,
				subjs1[0]);
		String subscoredmarks = null;
		for (AdminAllIndiaMarksAnalysisPojo sresults : sturesults) {
			AdminAllIndiaMarksAnalysisPojo detailsPojo = new AdminAllIndiaMarksAnalysisPojo();
			ArrayList<String> subtotalmarkslist = new ArrayList<>();
			ArrayList<String> subjectRank = new ArrayList<>();
			ArrayList<Float> subjectper = new ArrayList<>();

			String username = sresults.getUsername();
			detailsPojo.setUsername(username);
			String studentname = sresults.getStudentname();
			detailsPojo.setStudentname(studentname);
			String sectionname = sresults.getSectionname();
			detailsPojo.setSectionname(sectionname);
			String scoredmarks = sresults.getScoredmarks();
			detailsPojo.setScoredmarks(scoredmarks);
			float scmarks = (new Float(scoredmarks)).floatValue();
			detailsPojo.setScoredmarks1(scoredmarks);
			String campusname = sresults.getCampusname();
			detailsPojo.setCampusname(campusname);
			int totalmarks = sresults.getTotalmarks();
			detailsPojo.setTotalmarks(totalmarks);
			
			String subttlmarks = adminuserservice.getSubjTotalMarks(examname,subjs1[0]);
			int subtotalmarks=(new Integer(subttlmarks)).intValue();
			detailsPojo.setSubttlmarks(subtotalmarks);

			int classid = sresults.getClassid();
			detailsPojo.setClassid(classid);
			float subpercentage = (scmarks * 100) / subtotalmarks;
			detailsPojo.setSub_percentage(subpercentage);

			String studentid = sresults.getStudentid();
			detailsPojo.setStudentid(studentid);
			int campusid = sresults.getCampusid();
			detailsPojo.setCampusid(campusid);
			int stateid = sresults.getStateid();
			detailsPojo.setStateid(stateid);
			int sectionid = sresults.getSectionid();
			detailsPojo.setSectionid(sectionid);
			String subjectrank1 = adminuserservice.getAllIndiaReportSubjectRank(examname, studentid, subjs1[0]);
			detailsPojo.setSubject_rank1(subjectrank1);
			float subjectscoredmarks = adminuserservice.getScoredmarksPerSubject(examname, studentid, subjs1[0]);
			totalscoredmarks = subjectscoredmarks;
			detailsPojo.setSub_totalmarks(totalscoredmarks);
			float totalpercentage = (totalscoredmarks * 100) / totalmarks;
			DecimalFormat df = new DecimalFormat();
			df.setMaximumFractionDigits(2);
			float totalpercentage1 = (new Float(totalpercentage)).floatValue();
			detailsPojo.setTotal_percentage(totalpercentage1);
			
			for (int j = 1; j < subjs1.length; j++) {
				subscoredmarks = adminuserservice.getuserdetailsfromStudentResultsInAnotherSubj(examname, subjs1[j],
						classid, sectionid, campusid, stateid, studentid);
				subtotalmarkslist.add(subscoredmarks);
				detailsPojo.setLtoatlamarks(subtotalmarkslist);
				String subjectrank = adminuserservice.getAllIndiaReportSubjectRank(examname, studentid, subjs1[j]);
				subjectRank.add(subjectrank);
				detailsPojo.setLsubrank(subjectRank);
				float scmarks1 = (new Float(subscoredmarks)).floatValue();
				
				String subttlmarks1 = adminuserservice.getSubjTotalMarks(examname,subjs1[j]);
				int subtotalmarks1=(new Integer(subttlmarks1)).intValue();
				
				subpercentage = (scmarks1 * 100) / subtotalmarks1;
				subjectper.add(subpercentage);
				detailsPojo.setLsub_percentage(subjectper);
				subjectscoredmarks = adminuserservice.getScoredmarksPerSubject(examname, studentid, subjs1[j]);
				totalscoredmarks += subjectscoredmarks;
				detailsPojo.setSub_totalmarks(totalscoredmarks);
				 totalpercentage = (totalscoredmarks * 100) / totalmarks;
				df.setMaximumFractionDigits(2);
				 totalpercentage1 = (new Float(totalpercentage)).floatValue();
				detailsPojo.setTotal_percentage(totalpercentage1);

			}

			model1.put("sub_scoredmarks", subscoredmarks);

			int allindiarank = adminuserservice.getAllIndiaRankBasedOnExamname(examname, studentid);
			detailsPojo.setAllindiarank(allindiarank);

			int allindiacrank = adminuserservice.getAllIndiaCampusRankBasedOnExamname(examname, studentid, campusid);
			detailsPojo.setCampusrank(allindiacrank);

			int allindiastrank = adminuserservice.getAllIndiaStateRankBasedOnExamname(examname, studentid, stateid);
			detailsPojo.setStaterank(allindiastrank);

			int allindiascrank = adminuserservice.getAllIndiaSectionRankBasedOnExamname(examname, studentid, sectionid);
			detailsPojo.setSectionrank(allindiascrank);

			allDetails.add(detailsPojo);
		}

		model1.put("subjects", subjects);
		model1.put("allDetails", allDetails);

		return new ModelAndView("AdminAllIndiaMarksAnalysis", "model1", model1);

	}

}
