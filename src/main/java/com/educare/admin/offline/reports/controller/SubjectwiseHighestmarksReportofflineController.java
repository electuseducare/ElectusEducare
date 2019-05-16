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
import com.educare.admin.controller.SubjectWiseHighestReportController;
import com.educare.admin.model.AdminAllIndiaMarksAnalysisPojo;
import com.educare.admin.model.SubjectWiseHighestReport;
import com.educare.services.AdminRegisterServiceImpl;@Controller
public class SubjectwiseHighestmarksReportofflineController {
	
	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(SubjectWiseHighestReportController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;
	
	@Autowired
	private DatabaseValueController dv;
	
	@RequestMapping("/SubjectWiseReportOffline")
	public ModelAndView hisghestsubjectproc(HttpSession sess, Model model,HttpServletRequest req) {

		String start="Entry of Hisghestsubjectproc method....";
		String end="End of Hisghestsubjectproc method....";
		logger.info(start);
		
		Map<String, Object> model1 = new HashMap<>();
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(sess,req);
		if(dbval.equals("0"))
		return new ModelAndView("defaultDatabaseErrorPage", "model1", model1);

		String examname = (String) sess.getAttribute("examnameval");
		List<AdminAllIndiaMarksAnalysisPojo> subjects = adminuserservice.getsubjectsfromStudentResultsOffline(examname);
		int i = 0;
		int countofsub = subjects.size();
		String subjectids = null;
		String subjectnames = null;
		String campus = null;
		String campusid = null;
		int examstrength = 0;
		String[] subjids = new String[countofsub];
		String[] subjs = new String[countofsub];
		for (AdminAllIndiaMarksAnalysisPojo subnames : subjects) {
			subjectnames = subnames.getSubjectname();
			subjectids = subnames.getSubjectid();
			subjs[i] = subjectids;
			subjids[i] = subjectnames;
			i++;
		}
		List<SubjectWiseHighestReport> quesval = new ArrayList<>();
		List<SubjectWiseHighestReport> subjreport = adminuserservice.getSubjectWiseHighestCampusNameoffline(examname);
		for (SubjectWiseHighestReport subjectWiseHighestReport : subjreport) {
			SubjectWiseHighestReport admque = new SubjectWiseHighestReport();
			List<String> lcampusscore = new ArrayList<>();
			List<String> lsubject = new ArrayList<>();
			List<Integer> lcampusrank = new ArrayList<>();
			List<Integer> lsubjectrank = new ArrayList<>();

			campus = subjectWiseHighestReport.getCampus();
			admque.setCampus(campus);
			campusid = subjectWiseHighestReport.getCampusid();
			examstrength = adminuserservice.getExamStrengthoffline(examname, campusid);
			admque.setExamstrength(examstrength);

			int totalscore1 = adminuserservice.gettotalscoreforsubjecthighestmarkrepooffline(examname, campusid);
			admque.setTotalscoreval(totalscore1);

			String studenid = adminuserservice.getstudentifforhighestmarkreportoffline(examname, campusid, totalscore1);

			int rank = adminuserservice.getallindiarankforhighestmarkreportoffline(examname, studenid);
			admque.setRank(rank);

			// ==campus wise toper marks
			String scoredmarkspercamus = adminuserservice.getscoremarksforhighestmarkrepooffline(examname, studenid, subjs[0]);
			admque.setScoredmarkspercampus(scoredmarkspercamus);

			int rankpercampus = adminuserservice.getcampuswiserankforsubjecthighestoffline(studenid, examname, subjs[0],
					campusid);
			admque.setCampuswiserank(rankpercampus);

			// ==subject wise toper marks
			String scoredmarkssubjectwise = adminuserservice.getscoremarksforhighestreportsubjectwisesoffline(examname, campusid,
					subjs[0]);
			admque.setSubjectwisemarks(scoredmarkssubjectwise);

			String studentidval = adminuserservice.getstudentifforhighestmarkreportforsubjectoffline(examname, campusid,
					scoredmarkssubjectwise);

			int subjectrank = adminuserservice.getSubjectRankInCampuswiseSubjectTopperoffline(examname, studentidval, campusid,
					subjs[0]);
			admque.setSubjectwisevalue(subjectrank);

			for (int j = 1; j < subjs.length; j++) {

				String scoredmarkspersubval = adminuserservice.getscoremarksforhighestmarkrepooffline(examname, studenid,
						subjs[j]);
				lcampusscore.add(scoredmarkspersubval);
				admque.setCampusscore(lcampusscore);

				String scoredmarkssubjectwiseval = adminuserservice.getscoremarksforhighestreportsubjectwisesoffline(examname,
						campusid, subjs[j]);
				lsubject.add(scoredmarkssubjectwiseval);
				admque.setSubjectwisescore(lsubject);

				int rankpercampuswise = adminuserservice.getcampuswiserankforsubjecthighestoffline(studenid, examname,
						subjs[j], campusid);
				lcampusrank.add(rankpercampuswise);

				admque.setCampusranklist(lcampusrank);

				String scoredmarkssubjectwisehighest = adminuserservice.getscoremarksforhighestreportsubjectwisesoffline(examname,
						campusid, subjs[j]);
				String studentidval1 = adminuserservice.getstudentifforhighestmarkreportforsubjectoffline(examname, campusid,
						scoredmarkssubjectwisehighest);
				int subjectrankvalue = adminuserservice.getSubjectRankInCampuswiseSubjectTopperoffline(examname, studentidval1,
						campusid, subjs[j]);

				lsubjectrank.add(subjectrankvalue);
				admque.setSubjectwiseranklist(lsubjectrank);

			}

			quesval.add(admque);

		}

		model1.put("subjectval", subjects);
		model1.put("highscore", quesval);

		logger.info(end);

		return new ModelAndView("offlineReports/subjwisereportoffline", "model1", model1);

	}

}
