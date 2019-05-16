package com.educare.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.educare.DatabaseValueController;
import com.educare.model.FormQuestionPojo;
import com.educare.model.QuestionPojo;
import com.educare.model.TempHistoryPackage;
import com.educare.services.RegisterServiceImpl;

@Controller
public class TempExamHistoryController {

	private static final Logger logger = LoggerFactory.getLogger(TempExamHistoryController.class);

	@Autowired
	private RegisterServiceImpl userservice;
	
	@Autowired
	private DatabaseValueController dv;
	
	String qrowidval = "qrowid";
	String sidval = "studentid";
	String subidval = "subjectid";
	String qidval = "questionid";
	String examnameval = "examname";

	@RequestMapping("/load-updateByqid")
	public String savetoTemp(Model model, QuestionPojo qp, FormQuestionPojo fqp, HttpSession session,
			HttpServletRequest req) {

		String start = "Entry of savetoTemp method....";
		String end = "End of savetoTemp method....";
		logger.info(start);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(session,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";

		TempHistoryPackage thpckg = new TempHistoryPackage();
		model.addAttribute("thp", thpckg);

		logger.info(end);

		return "pacakgeExam";
	}

	@RequestMapping("/load-updateByqandaid")
	public String savetoTempTab(Model model, TempHistoryPackage thpacg, HttpServletRequest req, HttpSession session) {

		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(session,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		return "pacakgeExam";
	}

	@RequestMapping("load-examStatusqid")
	public void setExamStatus(Model model, HttpServletRequest req, HttpSession session) throws ParseException {

		String start = "Entry of setExamStatus method....";
		String end = "End of setExamStatus method....";
		logger.info(start);

		String selectedanswer = req.getParameter("selectedanswer");
		
		String qrowid1 = req.getParameter(qrowidval);
		String examname1 = req.getParameter("exmname");
		String studentid1 = req.getParameter("stu");
		String subjectid1 = req.getParameter("subj");
		String questionid1 = req.getParameter("qbyidval");
		session.setAttribute(qrowidval, qrowid1);
		session.setAttribute(sidval, studentid1);
		session.setAttribute(subidval, subjectid1);
		session.setAttribute(qidval, questionid1);
		session.setAttribute(examnameval, examname1);
		String qrowid = (String) session.getAttribute(qrowidval);
		String studentid = (String) session.getAttribute(sidval);
		String subjectid = (String) session.getAttribute(subidval);
		String questionid = (String) session.getAttribute(qidval);
		String examname = (String) session.getAttribute(examnameval);
		String timeid = req.getParameter("timeid");

		String[] frmtime = timeid.trim().split(":"); // split it at the colons

		int frmtimelen = frmtime.length;
		String mm = frmtime[0];
		String sec = frmtime[1];
		String hh = "00";
		if (frmtimelen > 2) {
			hh = frmtime[0];
			mm = frmtime[1];
			sec = frmtime[2];
		}
		String takn = hh + ":" + mm + ":" + sec;

		List<TempHistoryPackage> tmpobj = userservice.getAllTempHisyPackage(questionid, examname, subjectid, studentid,
				qrowid);

		String actualexamstarttime = null;
		String timediff = null;
		for (TempHistoryPackage tempHistoryPackage : tmpobj) {
			actualexamstarttime = tempHistoryPackage.getActualexamstarttime();
			timediff = tempHistoryPackage.getTimediff();

		}
		int timediffcount = 0;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("kk:mm:ss");
		String currenttime = simpleDateFormat.format(new Date());
		String currenttime1 = simpleDateFormat.format(new Date());
		long timediff1 = 0;
		int intialtimevale = userservice.getIntialTimeValueintemp1(examname, studentid);
		if (intialtimevale != 0) {
			currenttime = userservice.getIntialTimeValueintemp(examname, studentid);
			timediffcount = userservice.getResumetimeDiffrenceBasedonQid1(studentid, examname, questionid, qrowid);
			if (timediffcount != 0) {
				timediff1 = Long.valueOf(timediff);
			}
		} else {
			currenttime = actualexamstarttime;
		}
		long difference = 0;
		Date date1 = simpleDateFormat.parse(currenttime);
		Date date2 = simpleDateFormat.parse(currenttime1);
		difference = date2.getTime() - date1.getTime();

		long diffSec = difference / 1000;
		diffSec = diffSec + timediff1;

		String diffsec1 = String.valueOf(diffSec);

		userservice.updateTempHisyPackage(studentid, examname, subjectid, questionid, selectedanswer, takn,
				qrowid, currenttime1, diffsec1);

		logger.info(end);
	}

	@ResponseBody
	@RequestMapping("/load-unattemptcount")
	public int unattemptcount(Model model, TempHistoryPackage thpacg, HttpServletRequest req, HttpSession session) {

		String start = "Entry of unattemptcount method....";
		String end = "End of unattemptcount method....";
		logger.info(start);

		String studentid = req.getParameter(sidval);
		int unattempt = 0;

		String examname =  req.getParameter("exmname");

		unattempt = userservice.getcountforUnattemptforexam(examname, studentid);

		logger.info(end);

		return unattempt;
	}

	@ResponseBody
	@RequestMapping("/load-unattemptcountforsubjectwise")
	public int unattemptcountforsubjectwise(Model model, TempHistoryPackage thpacg, HttpServletRequest req,
			HttpSession session) {

		String studentid = req.getParameter(sidval);
		String examname = req.getParameter(examnameval);
		String subjectid = req.getParameter(subidval);

		int unattemptforsub = 0;
		unattemptforsub = userservice.getUnattemptedCountForSubj(examname, studentid, subjectid);
		int markasrevcnt = userservice.getmarkforreivewcnt(examname, studentid, subjectid);
		unattemptforsub = unattemptforsub - markasrevcnt;

		return unattemptforsub;
	}

	@ResponseBody
	@RequestMapping("/load-attemptcountforsubjectwise")
	public int attemptcountforsubjectwise(Model model, TempHistoryPackage thpacg, HttpServletRequest req,
			HttpSession session) {

		String studentid = req.getParameter(sidval);
		String examname = req.getParameter(examnameval);
		String subjectid = req.getParameter(subidval);

		int attemptforsub = 0;

		attemptforsub = userservice.getAttemptedCountForSubj(examname, studentid, subjectid);

		return attemptforsub;
	}

	@ResponseBody
	@RequestMapping("/load-markAsRevNotAnsCntforsubjwise")
	public int markAsReviewCountForSubjectWise(Model model, TempHistoryPackage thpacg, HttpServletRequest req,
			HttpSession session) {

		String studentid = req.getParameter(sidval);
		String examname = req.getParameter("examname");
		String subjectid = req.getParameter(subidval);
		String questionid = req.getParameter(qidval);
		String questionrowid = req.getParameter("questionrowid");
		String markvalue = req.getParameter("markvalue");
		int markasreviewcnt = 0;
		userservice.insertMarkForReviewValue(markvalue, examname, studentid, subjectid, questionid, questionrowid);
		markasreviewcnt = userservice.getMarkForReviewNotAnsweredCountForSubj("MR", examname, studentid, subjectid);
		return markasreviewcnt;
	}

	@ResponseBody
	@RequestMapping("/load-markAsRevAnsCntforsubjwise")
	public int markAsReviewAnswCountForSubjectWise(Model model, TempHistoryPackage thpacg, HttpServletRequest req,
			HttpSession session) {

		String studentid = req.getParameter(sidval);
		String examname = req.getParameter("examname");
		String subjectid = req.getParameter(subidval);
		String questionid = req.getParameter(qidval);
		String questionrowid = req.getParameter("questionrowid");
		String markvalue = req.getParameter("markvalue");
		int markasreviewcnt = 0;
		userservice.insertMarkForReviewValue(markvalue, examname, studentid, subjectid, questionid, questionrowid);
		markasreviewcnt = userservice.getMarkForReviewAnsweredCountForSubj("MRA", examname, studentid, subjectid);

		return markasreviewcnt;
	}

}
