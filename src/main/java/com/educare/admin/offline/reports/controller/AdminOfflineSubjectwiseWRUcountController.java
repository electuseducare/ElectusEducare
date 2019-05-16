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
import com.educare.admin.model.AdminAllIndiaMarksAnalysisPojo;
import com.educare.admin.model.AdminSubjectWiserightwrongrepo;
import com.educare.services.AdminRegisterServiceImpl;

@Controller
public class AdminOfflineSubjectwiseWRUcountController {
	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(AdminOfflineSubjectwiseWRUcountController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;
	
	@Autowired
	private DatabaseValueController dv;

	@RequestMapping("/offline-subjectwiserightwrongreportform")
	public ModelAndView offlinesubjectwisewrongrightReportPage(Model model, HttpSession sess,HttpServletRequest req) {

		String start = "Entry of offlinesubjectwisewrongrightReportPage method....";
		String end = "End of offlinesubjectwisewrongrightReportPage method....";
		logger.info(start);
		
		Map<String, Object> model1 = new HashMap<>();
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(sess,req);
		if(dbval.equals("0"))
		return new ModelAndView("defaultDatabaseErrorPage", "model1", model1);

		String examname = (String) sess.getAttribute("examnameval");
		String studid = null;
		String studentname = null;
		String section = null;
		String campus = null;
		String subject = null;


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
		List<AdminSubjectWiserightwrongrepo> quesval = new ArrayList<>();
		List<AdminSubjectWiserightwrongrepo> getdetails = adminuserservice
				.adminSujectwiseRightWrongReportFromAdminOffline(examname, subjs[0]);
		for (AdminSubjectWiserightwrongrepo adminSubjectWiserightwrongrepo : getdetails) {
			AdminSubjectWiserightwrongrepo admque = new AdminSubjectWiserightwrongrepo();
			List<String> lwrong = new ArrayList<>();
			List<String> lcorrect = new ArrayList<>();
			List<String> lunattempt = new ArrayList<>();

			studid = adminSubjectWiserightwrongrepo.getStudentid();
			admque.setStudentid(studid);
			studentname = adminSubjectWiserightwrongrepo.getStudentname();
			admque.setStudentname(studentname);
			section = adminSubjectWiserightwrongrepo.getSection();
			admque.setSection(section);
			campus = adminSubjectWiserightwrongrepo.getBranch();
			admque.setBranch(campus);
			subject = adminSubjectWiserightwrongrepo.getSubject();
			admque.setSubject(subject);
			String campusid = adminSubjectWiserightwrongrepo.getCampusid();
			String sectionid = adminSubjectWiserightwrongrepo.getSectionid();

			int getwrongcount = adminuserservice.getsubjectwisewrongcountOffline(studid, sectionid, campusid, examname,
					subjs[0]);
			admque.setWrongcount(getwrongcount);

			int getrightcount = adminuserservice.getsubjectwisecorrectcountOffline(studid, sectionid, campusid,
					examname, subjs[0]);

			admque.setRightcount(getrightcount);
			int getunattemptcount = adminuserservice.getsubjectwiseunattemptcountOffline(studid, sectionid, campusid,
					examname, subjs[0]);

			admque.setUnattempt(getunattemptcount);

			for (int j = 1; j < subjs.length; j++) {

				int getwrongcount1 = adminuserservice.getsubjectwisewrongcountOffline(studid, sectionid, campusid,
						examname, subjs[j]);
				String getwrng1 = String.valueOf(getwrongcount1);
				lwrong.add(getwrng1);
				admque.setLwrongcount(lwrong);

				int getrightcount1 = adminuserservice.getsubjectwisecorrectcountOffline(studid, sectionid, campusid,
						examname, subjs[j]);

				String getrightcount11 = String.valueOf(getrightcount1);
				lcorrect.add(getrightcount11);
				admque.setLrightcount(lcorrect);

				int getunattemptcount1 = adminuserservice.getsubjectwiseunattemptcountOffline(studid, sectionid,
						campusid, examname, subjs[j]);
				String getrightcoun = String.valueOf(getunattemptcount1);

				lunattempt.add(getrightcoun);
				admque.setLunattempcount(lunattempt);

			}

			quesval.add(admque);

		}

		model1.put("subjectval", subjects);
		model1.put("contval", quesval);
		model1.put("getdetails", getdetails);

		logger.info(end);

		return new ModelAndView("offlineReports/AdminOfflineSubjectwiserightwrongcount", "model1", model1);
	}

}
