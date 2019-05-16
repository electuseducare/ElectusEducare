package com.educare.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.educare.DatabaseValueController;
import com.educare.model.FilterResultPojo;
import com.educare.services.RegisterServiceImpl;

@Controller
public class FilterResultController {
	private static final Logger logger = LoggerFactory.getLogger(FilterResultController.class);

	@Autowired
	private RegisterServiceImpl userservice;
	
	@Autowired
	private DatabaseValueController dv;
	
	String qusval="question";

	@RequestMapping("/load-filterform")
	public String resultprocess(Model model, FilterResultPojo fp, HttpSession session, HttpServletRequest req) {

		String start = "Entry of resultprocess method....";
		String end = "Entry of resultprocess method....";
		logger.info(start);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(session,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";

		String actionmethod = req.getParameter("actionform");
		String[] spltactionmethod = actionmethod.split(",");
		actionmethod = spltactionmethod[0];
		String examname = spltactionmethod[1];
		Object sid = session.getAttribute("student_id");
		String incorrectAnswer = null;
		String unattemptedAnswer = null;
		String correctAnsw = null;
		model.addAttribute("requestObject", actionmethod);

		if (actionmethod.equals("Summary") || (actionmethod.equals("all"))) {
			List<FilterResultPojo> filterpojofilterresults = userservice
					.getAllFromFilterResultPojo(sid.toString(), examname);
			model.addAttribute(qusval, filterpojofilterresults);
			model.addAttribute("all", filterpojofilterresults);

		} else if (actionmethod.contains("InCorrect")) {
			incorrectAnswer = "Incorrect Answer";
			model.addAttribute("incorrect_answer", incorrectAnswer);

			List<FilterResultPojo> filterpojofilterresults = userservice
					.getAllInccorrectFromFilterResultPojo(sid.toString(), examname, "Incorrect");

			model.addAttribute(qusval, filterpojofilterresults);

		} else if (actionmethod.contains("Correct")) {

			List<FilterResultPojo> filterpojo = viewCorrectExamResultsWithTimeTaken(model, session, req, examname);

			model.addAttribute(qusval, filterpojo);
			correctAnsw = "correct answer";
			model.addAttribute("correct_answ", correctAnsw);

		} else {

			unattemptedAnswer = "unattempted answer ";
			model.addAttribute("unattempted_answer", unattemptedAnswer);
			List<FilterResultPojo> filterpojoattemt = userservice
					.getAllUnattemtedFromFilterResultPojo(sid.toString(), examname, "UnAttempted");
			model.addAttribute(qusval, filterpojoattemt);

		}

		model.addAttribute("examname", examname);
		String examendtime = userservice.getExamEndtime(examname);
		String examdate=userservice.getExamEndDate(examname);
		model.addAttribute("examdate", examdate);
		model.addAttribute("examendtime", examendtime);

		logger.info(end);

		return "usertestResults1";
	}

	public List<FilterResultPojo> viewCorrectExamResultsWithTimeTaken(Model model, HttpSession session,
			HttpServletRequest req, String examname) {

		String correctAnsw = null;
		Object studentid = session.getAttribute("student_id");

		List<FilterResultPojo> quesid = new ArrayList<>();
		List<FilterResultPojo> ques = userservice.getquestionidfromfilterpojo(studentid.toString(), examname,
				"Correct");

		for (FilterResultPojo filterResultPojo : ques) {
			FilterResultPojo listpojo = new FilterResultPojo();
			Document question = filterResultPojo.getQues();

			listpojo.setQues(question);
			String subjectname = filterResultPojo.getSubjname();
			int timedifferencebyme = filterResultPojo.getTimedifference();
			String answ = filterResultPojo.getAnswered();
			listpojo.setSubjname(subjectname);
			listpojo.setAnswered(answ);
			String wrongansw = filterResultPojo.getWronganswered();
			String notanssw = filterResultPojo.getNotanswered();
			listpojo.setWronganswered(wrongansw);
			listpojo.setNotanswered(notanssw);
			listpojo.setTimedifference(timedifferencebyme);
			String key = filterResultPojo.getQanswer();
			listpojo.setQanswer(key);

			int qid = filterResultPojo.getQuestion_Id();

			correctAnsw = "correct answer";
			model.addAttribute("correct_answ", correctAnsw);

			int getmintime = userservice.getminTimefromfilterresults(examname, qid, "Correct");

			if (answ != null) {
				listpojo.setLeasttime(getmintime);
			}

			quesid.add(listpojo);

		}
		return quesid;

	}

}
