package com.educare.admin.controller;

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
import com.educare.admin.model.AdminSubjectwisemarksRanges;
import com.educare.services.AdminRegisterServiceImpl;

@Controller
public class AdminAbove50perMarksController {

	private static final Logger logger = LoggerFactory.getLogger(AdminAbove50perMarksController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;
	
	@Autowired
	private DatabaseValueController dv;

	@RequestMapping("/load-fiftypercentmarkssubjectwise")
	public ModelAndView loadfiftypercentmarkssubject(Model model, HttpSession sess,HttpServletRequest req) {

		String start = "Entry of loadfiftypercentmarkssubject method....";
		String end = "---End of loadfiftypercentmarkssubject method....";

		logger.info(start);
		Map<String, Object> model1 = new HashMap<>();
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(sess,req);
		if(dbval.equals("0"))
		return new ModelAndView("defaultDatabaseErrorPage", "model1", model1);

		String examname = (String) sess.getAttribute("examnameval");

		List<AdminAllIndiaMarksAnalysisPojo> subjects = adminuserservice.getsubjectsfromStudentResults(examname);
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
		List<AdminSubjectwisemarksRanges> getcampus = adminuserservice.adminSujectwiseMarksRangesFromAdmin(examname,
				subjs[0]);

		for (AdminSubjectwisemarksRanges campdet : getcampus) {
			AdminSubjectwisemarksRanges adque = new AdminSubjectwisemarksRanges();
			List<String> greaterfourtyfour = new ArrayList<>();
			List<String> maxmarkslist = new ArrayList<>();

			String campus = campdet.getCampus();
			adque.setCampus(campus);
			String campusid = campdet.getCampusid();

			int examstrength = adminuserservice.getExamStrength(examname, campusid);
			adque.setExamstrength(examstrength);

			int greaterfourtyfourmarks = adminuserservice.getexammarksrangegreaterthanfourtyfourrepo(examname, campusid,
					subjs[0]);
			adque.setGreaterthanfortyfour(greaterfourtyfourmarks);

			String maxmarksval = adminuserservice.getmaxmarksinsubjectwiserange(examname, campusid, subjs[0]);
			adque.setMaxmarks(maxmarksval);

			for (int j = 1; j < subjs.length; j++) {
				int greaterff = adminuserservice.getexammarksrangegreaterthanfourtyfourrepo(examname, campusid,
						subjs[j]);
				String greaterffval = String.valueOf(greaterff);
				greaterfourtyfour.add(greaterffval);
				adque.setLgreaterfourtyfour(greaterfourtyfour);

				String maxmarksa = adminuserservice.getmaxmarksinsubjectwiserange(examname, campusid, subjs[j]);
				String maxmarksvales = String.valueOf(maxmarksa);
				maxmarkslist.add(maxmarksvales);
				adque.setMaxmarkslist(maxmarkslist);
			}

			marks.add(adque);

		}

		model1.put("subjectval", subjects);
		model1.put("marks", marks);

		logger.info(end);

		return new ModelAndView("fiftypercentmarkssubjectwise", "model1", model1);

	}

}
