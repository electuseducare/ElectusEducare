
package com.educare.controller;

import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.educare.DatabaseValueController;
import com.educare.exception.EducareCustomException;
import com.educare.model.BookmarkPojo;
import com.educare.model.Exam_DisplayListPojo;
import com.educare.model.Exam_DisplayPojo;
import com.educare.model.FormQuestionPojo;
import com.educare.model.QuestionPojo;
import com.educare.services.RegisterServiceImpl;

@Controller
public class DashboardUserStartExamController {

	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(DashboardUserStartExamController.class);

	@Autowired
	private RegisterServiceImpl userservice;
	
	@Autowired
	private DatabaseValueController dv;

	private String lid = "locationid";
	private String bname = "branchname";
	private String cname = "classname";
	private String sname = "sectionname";
	private String isjum = "isjumbling";
	private String modelone = "model1";
	private String sidsvar = "student_id";
	private String examnameone = "examname1";
	private String subjectidsvar = "subjectids";
	private String dfmtkk = "kk:mm:ss";
	private String totalqtimevar = "totalqtime";
	private String nofquesvar = "nofques";
	private String examnamevar = "examname";

	/************************* With Slot Based Examination ******************************/
	
	@RequestMapping(value = "/load-ExamForm")
	public ModelAndView loadExamForm(Model model, FormQuestionPojo fqp, HttpServletRequest request, HttpSession session,
			Exam_DisplayPojo emp, Exam_DisplayListPojo pdlp) {
		
		Map<String, Object> model1 = new HashMap<>();
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(session,request);
		if(dbval.equals("0"))
		return new ModelAndView("defaultDatabaseErrorPage", "model1", model1);
		
		String sid = (String) session.getAttribute(sidsvar);
		String value = request.getParameter("exam");

		
		String[] startbuttonArray = value.trim().split("\\s*,\\s*");
		String examname1 = startbuttonArray[0];
		session.setAttribute(examnameone, examname1);
		String examname = (String) session.getAttribute(examnameone);
		String reqparam = startbuttonArray[1];
		String removeexamname = value.replace(examname + ",", "");
		String subjectids = removeexamname.replace(reqparam + ",", "").trim();
		session.setAttribute(subjectidsvar, subjectids);

		String endtime = null;

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dfmtkk);
		String currenttime = simpleDateFormat.format(new Date());
		String isjumbling = userservice.getIsjumblingYesOrnoBasedonExamname(examname);
		session.setAttribute(isjum, isjumbling);
		isjumbling = (String) session.getAttribute(isjum);
		if (reqparam.equalsIgnoreCase("start")) {
			String examstatuses = "start";
			int existresultscount = userservice.getCountForExistingResults(examname, sid);
			if (existresultscount > 0) {
				return new ModelAndView("userExistingResultsError", modelone, model1);

			}
			int existtempcount = userservice.getCountForExistingTempHistory(examname, sid);

			List<QuestionPojo> userstartexam = userservice.getDisplayQuestions(examname);
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date now = new Date();
			String examstarttime = dateFormat.format(now);
			String username = (String) session.getAttribute("uname");
			session.setAttribute("examstarttime", examstarttime);
			String logintime = (String) session.getAttribute("logintime");
			int testcount = userservice.countOfExistingTest(sid, username, logintime, examname);
			if (testcount == 0) {
				userservice.insertNextRowdataInAuditlogs(sid, username, logintime, examname, examstarttime);
			} else {
				userservice.insertExamstartTime(sid, username, examname, examstarttime, logintime);
			}
                   System.out.println("inside start method");
			
			if (existtempcount >= 0) {
				for (QuestionPojo questionPojo : userstartexam) {
					endtime = questionPojo.getEndtime();
				}
				userservice.updateIntoTempHistory(examstatuses,endtime,currenttime,sid, examname);

			}
			int existtempcount1 = userservice.getCountForExistingTempHistory(examname, sid);
			int exampaperquscount = userservice.getCountOfQuestionsInExampaper(examname);
			if (existtempcount1 == exampaperquscount) {
				return new ModelAndView("redirect:/examredirectpage", modelone, model1);
			} else {
				userservice.deleteTempDataBasedonExamname(sid, examname);
				return new ModelAndView("redirect:/logout404", modelone, model1);
			}
		}

		else {

			return new ModelAndView("redirect:/load-resumeExamForm", modelone, model1);
		}

	}

	@RequestMapping(value = "/examredirectpage", method = RequestMethod.GET)
	public ModelAndView startRedirectExam(Model model, FormQuestionPojo fqp, HttpServletRequest request,
			HttpSession session, Exam_DisplayPojo emp, Exam_DisplayListPojo pdlp) throws ParseException {


		Map<String, Object> model1 = new HashMap<>();
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(session,request);
		if(dbval.equals("0"))
		return new ModelAndView("defaultDatabaseErrorPage", "model1", model1);

		Time totalqtime = null;
		String examname = (String) session.getAttribute(examnameone);
		String time = userservice.getTimeBasedOnSelectedExam(examname);
		totalqtime = Time.valueOf(time);
		String sid = (String) session.getAttribute(sidsvar);
		String clsid = (String) session.getAttribute(cname);
		String sectid = (String) session.getAttribute(sname);
		String brcid = (String) session.getAttribute(bname);
		String locationids = (String) session.getAttribute(lid);
		model.addAttribute("class_id", clsid);
		model.addAttribute("section_id", sectid);
		model.addAttribute("branch_id", brcid);
		model.addAttribute("location_id", locationids);
		model.addAttribute("stuid", sid);
		int quscount = userservice.getNoOfquestions(examname);
		String subjectids = (String) session.getAttribute(subjectidsvar);
		List<QuestionPojo> userstartexam1 = null;
		List<QuestionPojo> subjlist = userservice.getsubjectnamefromsubjectid(subjectids);
		model.addAttribute("subjlist", subjlist);

		List<FormQuestionPojo> fq = new ArrayList<>();

		int subjid = 0;
		String isjumbling = (String) session.getAttribute(isjum);

		for (QuestionPojo subjdetails : subjlist) {
			FormQuestionPojo temp = new FormQuestionPojo();
			String subjname = subjdetails.getSubject_type();
			temp.setSubjectname(subjname);

			subjid = subjdetails.getSubjectid();
			String subjid1 = String.valueOf(subjid);
			temp.setSubjectid(subjid1);
			userstartexam1 = userservice.getDisplayQuestions(examname, subjid, isjumbling);

			temp.setList(userstartexam1);
			fq.add(temp);
		}

		model.addAttribute("qp", fqp);
		model1.put("fqp", fq);
		model.addAttribute(totalqtimevar, totalqtime);
		model.addAttribute(nofquesvar, quscount);
		model.addAttribute("examtime", time);
		model.addAttribute(examnamevar, examname);

		if (userstartexam1.size() == 0) {
			String msg = "You don't have any register exams.";
			model.addAttribute("msg", msg);
		}

		String endtime = userservice.getEndTimeinExamPaper(examname);

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dfmtkk);
		String currenttime = simpleDateFormat.format(new Date());
		Date date1 = simpleDateFormat.parse(currenttime);
		Date date2 = simpleDateFormat.parse(endtime);
		long different = date2.getTime() - date1.getTime();

		long differencems = different / 1000;
		int seconds = (int) Math.floor(differencems % 60);
		differencems = differencems / 60;
		int minutes = (int) Math.floor(differencems % 60);
		differencems = differencems / 60;
		int hours = (int) Math.floor(differencems % 24);
		String hh = String.valueOf(hours);
		String mm = String.valueOf(minutes);
		String ss = String.valueOf(seconds);
		if (hours < 10)
			hh = "0" + hh;
		if (minutes < 10)
			mm = "0" + mm;
		if (seconds < 10)
			ss = "0" + ss;
		String timevalq = hh + ":" + mm + ":" + ss;
		model.addAttribute("time_val_q", timevalq);
		model.addAttribute("endtime", endtime);

		int examtypeid = userservice.getExamTypeIdBasedOnExamName(examname);
		int patterncnt = userservice.getPatternIdBasedOnExamType(examtypeid);
		if (patterncnt == 1) {
			/****************** Gate Pattern Based Exam *****************/
			return new ModelAndView("question1rrb", modelone, model1);
		} else {
			/****************** Tet Pattern Based Exam ******************/
			return new ModelAndView("question1", modelone, model1);

		}

	}

	@RequestMapping(value = "/load-resumeExamForm", method = RequestMethod.GET)
	public ModelAndView restartPackeges(Model model, FormQuestionPojo fqp, HttpServletRequest request,
			HttpSession session, Exam_DisplayPojo emp, Exam_DisplayListPojo pdlp) throws ParseException {

		Map<String, Object> model1 = new HashMap<>();
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(session,request);
		if(dbval.equals("0"))
		return new ModelAndView("defaultDatabaseErrorPage", "model1", model1);

		String sid = (String) session.getAttribute(sidsvar);
		String examname = (String) session.getAttribute(examnameone);
		String subjectids = (String) session.getAttribute(subjectidsvar);

		String timevals;
		Time totalqtime = null;
		Time timeqtaken = null;
		String time = userservice.getTimeBasedOnSelectedExam(examname);
		totalqtime = Time.valueOf(time);

		String clsid = (String) session.getAttribute(cname);
		String sectid = (String) session.getAttribute(sname);
		String brcid = (String) session.getAttribute(bname);
		String locationids = (String) session.getAttribute(lid);
		int locationdival = Integer.parseInt(locationids);
		int brcidval = Integer.parseInt(brcid);
		int clsidval = Integer.parseInt(clsid);
		int sectidval = Integer.parseInt(sectid);

		model.addAttribute("class_id", clsid);
		model.addAttribute("section_id", sectid);
		model.addAttribute("branch_id", brcid);
		model.addAttribute("location_id", locationids);
		model.addAttribute("stuid", sid);

		int quscount = userservice.getNoOfquestions(examname, sid);
		List<QuestionPojo> subjlist = userservice.getsubjectnamefromsubjectid(subjectids);
		model.addAttribute("subjlist", subjlist);
		List<FormQuestionPojo> fq = new ArrayList<>();
		List<QuestionPojo> resumeDetailList = null;
		int subjidval = 0;
		String isjumbling = (String) session.getAttribute(isjum);
		for (QuestionPojo resumesubject : subjlist) {
			FormQuestionPojo temp = new FormQuestionPojo();
			String subjname = resumesubject.getSubject_type();
			temp.setSubjectname(subjname);

			subjidval = resumesubject.getSubjectid();
			String subjid1 = String.valueOf(subjidval);
			temp.setSubjectid(subjid1);
			resumeDetailList = userservice.getQuestyionsFromTempHistoryPackage(sid, examname, locationdival, brcidval,
					clsidval, sectidval, subjid1, isjumbling);
			temp.setList(resumeDetailList);
			fq.add(temp);
		}

		if (resumeDetailList.size() == 0) {
			String msg = "You don't have any exams !";
			model.addAttribute("msg", msg);
		} else {
			timevals = userservice.getLeastTimeFromTempHistoryPackage(sid, locationdival, brcidval, clsidval, sectidval,
					examname);
			timeqtaken = Time.valueOf(timevals);
		}

		int qno = quscount;
		model.addAttribute(nofquesvar, qno);
		String endtimediff = userservice.getEndTimeFromTempHistoryPackage(sid, examname, locationdival, brcidval,
				clsidval, sectidval);

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dfmtkk);
		String currenttime = simpleDateFormat.format(new Date());
		Date date1 = simpleDateFormat.parse(currenttime);
		Date date2 = simpleDateFormat.parse(endtimediff);
		long different = date2.getTime() - date1.getTime();

		long differencems = different / 1000;
		int seconds = (int) Math.floor(differencems % 60);
		differencems = differencems / 60;
		int minutes = (int) Math.floor(differencems % 60);
		differencems = differencems / 60;
		int hours = (int) Math.floor(differencems % 24);
		String hh = String.valueOf(hours);
		String mm = String.valueOf(minutes);
		String ss = String.valueOf(seconds);
		if (hours < 10)
			hh = "0" + hh;
		if (minutes < 10)
			mm = "0" + mm;
		if (seconds < 10)
			ss = "0" + ss;
		String timevalq = hh + ":" + mm + ":" + ss;

		model.addAttribute("time_val_q", timevalq);

		int answeredCnt = userservice.getCountOfAnswersFromTempHistoryPackage(sid, examname, locationdival, brcidval,
				clsidval, sectidval);
		model.addAttribute("answeredCnt", answeredCnt);

		model.addAttribute(totalqtimevar, totalqtime);
		model.addAttribute("examtime", time);
		model.addAttribute(examnamevar, examname);
		model.addAttribute(nofquesvar, qno);
		model1.put("qp", fq);
		model.addAttribute("qp", fqp);
		model.addAttribute(totalqtimevar, totalqtime);
		model.addAttribute("timeqtaken", timeqtaken);

		String username = (String) session.getAttribute("uname");
		String examstarttime1 = (String) session.getAttribute("examstarttime");
		userservice.updateResumetimeInAuditlogs(sid, username, examname, examstarttime1);

		int examtypeid = userservice.getExamTypeIdBasedOnExamName(examname);
		int patterncnt = userservice.getPatternIdBasedOnExamType(examtypeid);
		if (patterncnt == 1) {
			/****************** Gate Pattern Based Exam *****************/
			return new ModelAndView("resumeRrbExam", modelone, model1);
		} else {
			/****************** Tet Pattern Based Exam *****************/
			return new ModelAndView("resumeExam", modelone, model1);

		}

	}

	@ResponseBody
	@RequestMapping(value = "/load-questionid-bookmark", method = RequestMethod.POST)
	public void getQuestionIdfromBookmarkAnalysis(Model model, QuestionPojo qp, BookmarkPojo p, HttpSession session,
			HttpServletRequest request, HttpServletResponse response) {

		String start="Entry of getQuestionIdfromBookmarkAnalysis method....";
		String end="End of getQuestionIdfromBookmarkAnalysis method....";
		logger.info(start);

		String bmcquestionid = request.getParameter("ver");
		int bmcurrentquestionid = Integer.parseInt(bmcquestionid);
		model.addAttribute("qp", qp);

		String examname = request.getParameter(examnamevar);
		String bmsubjectid = request.getParameter("subjectid");
		int subjectid = Integer.parseInt(bmsubjectid);
		String bmlocationid = request.getParameter(lid);
		int locationid = Integer.parseInt(bmlocationid);
		String bmclassid = request.getParameter("classid");
		int classid = Integer.parseInt(bmclassid);
		String bmsectionid = request.getParameter("sectionid");
		int sectionid = Integer.parseInt(bmsectionid);
		String bmbranchid = request.getParameter("branchid");
		int branchid = Integer.parseInt(bmbranchid);
		String studentid = request.getParameter("studentid");
		int bookmarstatustypeid = 20;

		int cntofQtnAvailinBook = userservice.findQuestionIDAvailableinBookmark(examname, studentid,
				bmcurrentquestionid);

		if (cntofQtnAvailinBook == 0) {
			userservice.insertBookmarkAnalysisData(examname, bmcurrentquestionid, studentid, subjectid,
					bookmarstatustypeid, classid, branchid, sectionid, locationid);
			try {
				response.getWriter().write("Current Question Is Bookmarked Successfully");
			} catch (IOException e) {
			}
		} else {
			try {
				response.getWriter().write("Current Question Is Already Bookmarked");

			} catch (IOException e) {

			}

		}
		logger.info(end);

	}

	@RequestMapping(value = "/load-serverendtime")
	public @ResponseBody Long getactualTimeFromServer(HttpServletRequest req) throws ParseException {
		String examnamereq = req.getParameter(examnamevar);
		String endtime = userservice.getExamEndtime(examnamereq);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dfmtkk);
		String currenttime = simpleDateFormat.format(new Date());
		Date date1 = simpleDateFormat.parse(currenttime);
		Date date2 = simpleDateFormat.parse(endtime);
		return date2.getTime() - date1.getTime();

	}

	public Date getactualTimeFromServerForExam() throws ParseException {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dfmtkk);
		String currenttime = simpleDateFormat.format(new Date());
		return simpleDateFormat.parse(currenttime);

	}

	public Date getactualTimeFromServerForEndExam(String currentexam) throws ParseException {

		String endtime = userservice.getExamEndtime(currentexam);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dfmtkk);
		return simpleDateFormat.parse(endtime);

	}

	@RequestMapping(value = "/load-getsessionstudentid")
	public @ResponseBody String getsessionstudentid(HttpSession ses) throws ParseException {
		return (String) ses.getAttribute(sidsvar);
	}

	@ExceptionHandler(EducareCustomException.class)
	public ModelAndView handleCustomException(EducareCustomException ex) {


		ModelAndView model = new ModelAndView("error/generic_error");
		model.addObject("errCode", ex.getErrCode());
		model.addObject("errMsg", ex.getErrMsg());


		return model;

	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {


		ModelAndView model = new ModelAndView("error/generic_error");
		model.addObject("errMsg", "this is Exception.class");


		return model;

	}

}
