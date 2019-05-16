package com.educare.admin.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.educare.DatabaseValueController;
import com.educare.admin.model.Adminstudentwisequestionerror;
import com.educare.services.AdminRegisterServiceImpl;

import org.slf4j.Logger;

@Controller
public class AdminStudentwiseQuestionwiseErrorAnalysisController {

	@Autowired
	private static final Logger logger = LoggerFactory
			.getLogger(AdminStudentwiseQuestionwiseErrorAnalysisController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;
	
	@Autowired
	private DatabaseValueController dv;

	@RequestMapping("/load-QuestionWiseErrorReport")
	public ModelAndView loadquestionwiseErrorReport(Model model, HttpSession sess,HttpServletRequest req) {

		String start = "Entry of loadquestionwiseErrorReport method....";
		String end = "End of loadquestionwiseErrorReport method....";
		logger.info(start);
		
		Map<String, Object> model1 = new HashMap<>();
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(sess,req);
		if(dbval.equals("0"))
		return new ModelAndView("defaultDatabaseErrorPage", "model1", model1);


		String examname = (String) sess.getAttribute("examnameval");
		List<Adminstudentwisequestionerror> questionid1 = null;
		List<Adminstudentwisequestionerror> questionid = null;
		List<Adminstudentwisequestionerror> qerror = new ArrayList<>();

		questionid1 = adminuserservice.admingetQuestionIdsforQerror1(examname);
		List<Integer> qidee = new ArrayList<>();

		List<Adminstudentwisequestionerror> adm = adminuserservice.adminQuestionWiseErrorReport(examname);
		for (Adminstudentwisequestionerror error : adm) {

			Adminstudentwisequestionerror adque = new Adminstudentwisequestionerror();
			String studentid = error.getStudentid();
			String studename = error.getStudentname();
			String section = error.getSection();
			String campus = error.getCampus();
			String sectionid = error.getSectionid();
			String campusid = error.getCampusid();
			adque.setStudentid(studentid);
			adque.setStudentname(studename);
			adque.setSection(section);
			adque.setCampus(campus);

			ArrayList<String> liscorct = new ArrayList<>();
			ArrayList<String> liswron = new ArrayList<>();
			ArrayList<String> lisunatt = new ArrayList<>();

			questionid = adminuserservice.admingetQuestionIdsforQerror(examname, campusid);
			for (Adminstudentwisequestionerror quesreport : questionid) {
				int qid = quesreport.getQuestionid();
				int questionrowid = quesreport.getQuestionrowid();
				qidee.add(qid);
				List<Adminstudentwisequestionerror> correct = adminuserservice.getrightvalueforerrorreport(qid,
						examname, studentid, sectionid, campusid, questionrowid);
				for (Adminstudentwisequestionerror adminstudentwisequestionerror : correct) {
					String right = adminstudentwisequestionerror.getRightanswer();
					liscorct.add(right);

				}
				adque.setLcorrect(liscorct);

				List<Adminstudentwisequestionerror> wrong = adminuserservice.getwrongvalueforerrorreport(qid, examname,
						studentid, sectionid, campusid, questionrowid);

				for (Adminstudentwisequestionerror adminstudentwisequestionerror : wrong) {
					String wrongval = adminstudentwisequestionerror.getWronganswer();
					liswron.add(wrongval);

				}
				adque.setLwrong(liswron);

				List<Adminstudentwisequestionerror> unattemp = adminuserservice.getnotansweredvalueforerrorreport(qid,
						examname, studentid, sectionid, campusid, questionrowid);
				for (Adminstudentwisequestionerror adminstudentwisequestionerror : unattemp) {

					String unattempt = adminstudentwisequestionerror.getUnattempt();
					lisunatt.add(unattempt);

				}
				adque.setLunattempt(lisunatt);

			}
			adque.setLquestionid(qidee);
			qerror.add(adque);
		}

		model1.put("qerror", qerror);
		model1.put("qiderror", questionid1);

		logger.info(end);

		return new ModelAndView("studentquestionwiseerrorreport", "model1", model1);

	}

}
