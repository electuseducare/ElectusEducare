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
import com.educare.admin.controller.AdminSubjectwiseMarksrangesController;
import com.educare.admin.model.AdminAllIndiaMarksAnalysisPojo;
import com.educare.admin.model.AdminSubjectwisemarksRanges;
import com.educare.services.AdminRegisterServiceImpl;@Controller
public class AdminSubjectwiseMarksrangesOfflineController {

	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(AdminSubjectwiseMarksrangesController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;
	
	@Autowired
	private DatabaseValueController dv;


	@RequestMapping("/load-subjectwisemarksrangesoffline")
	public ModelAndView loadsubjectBranchwisePage(Model model, HttpSession sess,HttpServletRequest req) {

		String start="Entry of loadsubjectBranchwisePage method....";
		String end="End of loadsubjectBranchwisePage method....";
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
		String[] subjids = new String[countofsub];
		String[] subjs = new String[countofsub];
		for (AdminAllIndiaMarksAnalysisPojo subnames : subjects) {
			subjectnames = subnames.getSubjectname();
			subjectids = subnames.getSubjectid();
			subjs[i] = subjectids;
			subjids[i] = subjectnames;
			i++;
		}
		List<AdminSubjectwisemarksRanges> marks = new ArrayList<>();
		List<AdminSubjectwisemarksRanges> getcampus = adminuserservice.adminSujectwiseMarksRangesFromAdminoffline(examname,
				subjs[0]);

		for (AdminSubjectwisemarksRanges campdet : getcampus) {
			AdminSubjectwisemarksRanges adque = new AdminSubjectwisemarksRanges();
			List<String> examstrengthval = new ArrayList<>();
			List<String> greaterfifty = new ArrayList<>();
			List<String> greaterfourty = new ArrayList<>();
			List<String> greaterthirty = new ArrayList<>();
			List<String> greatertwenty = new ArrayList<>();
			List<String> lesstwenty = new ArrayList<>();
			String campus = campdet.getCampus();
			adque.setCampus(campus);
			String campusid = campdet.getCampusid();

			int examstrnth1 = adminuserservice.getexamstrengthformarksrangerepooffline(examname, campusid, subjs[0]);
			adque.setExamstrength1(examstrnth1);

			int greaterthanfifty1 = adminuserservice.getexammarksrangegreaterthanfiftyrepooffline(examname, campusid,
					subjs[0]);
			adque.setGreaterthanfifty1(greaterthanfifty1);

			int greaterthanfourty1 = adminuserservice.getexammarksrangegreaterthanfourtyyrepooffline(examname, campusid,
					subjs[0]);
			adque.setGreaterthanfourty1(greaterthanfourty1);

			int greaterthanthirty1 = adminuserservice.getexammarksrangegreaterthanthirtyyrepooffline(examname, campusid,
					subjs[0]);
			adque.setGreaterthanthirty1(greaterthanthirty1);

			int greterthantwenty1 = adminuserservice.getexammarksrangegreaterthantwentyyrepooffline(examname, campusid,
					subjs[0]);
			adque.setGreaterthantwenty1(greterthantwenty1);

			int lessthantwenty1 = adminuserservice.getexammarksrangelessthantwentyyrepooffline(examname, campusid, subjs[0]);
			adque.setLessthantwenty1(lessthantwenty1);

			for (int j = 1; j < subjs.length; j++) {
				int examstrnth = adminuserservice.getexamstrengthformarksrangerepooffline(examname, campusid, subjs[j]);
				String exams = String.valueOf(examstrnth);
				examstrengthval.add(exams);
				adque.setLexamstrength(examstrengthval);

				int greaterthanfifty = adminuserservice.getexammarksrangegreaterthanfiftyrepooffline(examname, campusid,
						subjs[j]);
				String gratfifty = String.valueOf(greaterthanfifty);
				greaterfifty.add(gratfifty);
				adque.setLgreaterfifty(greaterfifty);

				int greaterthanfourty = adminuserservice.getexammarksrangegreaterthanfourtyyrepooffline(examname, campusid,
						subjs[j]);
				String greatfourty = String.valueOf(greaterthanfourty);
				greaterfourty.add(greatfourty);
				adque.setLgreaterfourty(greaterfourty);

				int greaterthanthirty = adminuserservice.getexammarksrangegreaterthanthirtyyrepooffline(examname, campusid,
						subjs[j]);
				String greatthirty = String.valueOf(greaterthanthirty);
				greaterthirty.add(greatthirty);
				adque.setLgreaterthirty(greaterthirty);

				int greterthantwenty = adminuserservice.getexammarksrangegreaterthantwentyyrepooffline(examname, campusid,
						subjs[j]);
				String greatertwentyval = String.valueOf(greterthantwenty);
				greatertwenty.add(greatertwentyval);
				adque.setLgreatertwenty(greatertwenty);

				int lessthantwenty = adminuserservice.getexammarksrangelessthantwentyyrepooffline(examname, campusid,
						subjs[j]);
				String lessthantwentyval = String.valueOf(lessthantwenty);
				lesstwenty.add(lessthantwentyval);
				adque.setLlessthantwenty(lesstwenty);

			}

			marks.add(adque);
		}

		model1.put("subjectval", subjects);
		model1.put("marks", marks);

		logger.info(end);

		return new ModelAndView("offlineReports/AdminSubjectwiseMarksRangesoffline", "model1", model1);

	}

}
