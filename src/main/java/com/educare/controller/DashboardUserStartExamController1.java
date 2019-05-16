
package com.educare.controller;

import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
public class DashboardUserStartExamController1 {

	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(DashboardUserStartExamController1.class);

	@Autowired
	private RegisterServiceImpl userservice;
	
	@Autowired
	private DatabaseValueController dv;

	private String sidsvar = "student_id";
	private String lid = "locationid";
	private String bname = "branchname";
	private String cname = "classname";
	private String sname = "sectionname";
	private String isjum = "isjumbling";
	private String modelone = "model1";
	private String examnameone = "examname1";
	private String subjectidsvar = "subjectids";
	private String dfmtkk = "kk:mm:ss";
	private String yytime = "yyyy-MM-dd HH:mm:ss";
	private String totalqtimevar = "totalqtime";
	private String nofquesvar = "nofques";
	private String examnamevar = "examname";

	/************************* Without Slot Based Examination ******************************/
	
	@RequestMapping(value = "/load-ExamForm1")
	public ModelAndView withoutSlotBasedExams(Model model, FormQuestionPojo fqp, HttpServletRequest request,
			HttpSession session, Exam_DisplayPojo emp, Exam_DisplayListPojo pdlp) throws ParseException {

		
		String start = "Entry of withoutSlotBasedExams method....";
		String end = "End of withoutSlotBasedExams method....";
		logger.info(start);
		
		Map<String, Object> model1 = new HashMap<>();
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(session,request);
		if(dbval.equals("0"))
		return new ModelAndView("defaultDatabaseErrorPage", "model1", model1);
		
		String examname = null;
		String sid = (String) session.getAttribute(sidsvar);
		String value = request.getParameter("exam");
		String[] startbuttonArray = value.trim().split("\\s*,\\s*");
		String examname1 = startbuttonArray[0];
		session.setAttribute(examnameone, examname1);
		examname = (String) session.getAttribute(examnameone);
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

			String examstatus = "start";
			int existresultscount = userservice.getCountForExistingResults(examname, sid);
			if (existresultscount > 0) {
				return new ModelAndView("userExistingResultsError", modelone, model1);

			}
			int existtempcount = userservice.getCountForExistingTempHistory(examname, sid);

			List<QuestionPojo> userstartexam = userservice.getDisplayQuestions(examname);
			DateFormat dateFormat = new SimpleDateFormat(yytime);
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

			if (existtempcount >= 0) {

				for (QuestionPojo questionPojo : userstartexam) {
					endtime = questionPojo.getEndtime();
					DateFormat dateFormat2 = new SimpleDateFormat("HH:mm:ss");
					DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
					Date date = new Date();
					String examstartdate = dateFormat1.format(date);
					String examstartime = dateFormat2.format(date);
					Calendar now1 = Calendar.getInstance();
					String[] entimespl = endtime.split(":");
					String hours1 = entimespl[0];
					int hours = (new Integer(hours1)).intValue();
					String mins1 = entimespl[1];
					int mins = (new Integer(mins1)).intValue();
					String sec1 = entimespl[2];
					int sec = (new Integer(sec1)).intValue();

					now1.setTime(date);
					now1.add(Calendar.HOUR_OF_DAY, hours);
					now1.add(Calendar.MINUTE, mins);
					now1.add(Calendar.SECOND, sec);
					String examendtime = dateFormat2.format(now1.getTime());
					String examenddate = dateFormat1.format(now1.getTime());
					session.setAttribute("examendtime", examendtime);
					session.setAttribute("examenddate", examenddate);

					userservice.updateIntoTempHistoryWithSlot(examstatus,endtime,currenttime,examstartdate, examstartime, examendtime,
							examenddate,sid, examname);
					
					
					

				}

			}

			int existtempcount1 = userservice.getCountForExistingTempHistory(examname, sid);
			int exampaperquscount = userservice.getCountOfQuestionsInExampaper(examname);
			if (existtempcount1 == exampaperquscount) {
				return new ModelAndView("redirect:/examredirectpageslot", modelone, model1);
			} else {
				return new ModelAndView("redirect:/logout404", modelone, model1);
			}

		}

		else {

			logger.info(end);

			return new ModelAndView("redirect:/load-resumeExamFormSlot", modelone, model1);
		}

	}

	@RequestMapping(value = "/examredirectpageslot", method = RequestMethod.GET)
	public ModelAndView startRedirectExam(Model model, FormQuestionPojo fqp, HttpServletRequest request,
			HttpSession session, Exam_DisplayPojo emp, Exam_DisplayListPojo pdlp) throws ParseException {

		
		String start="Entry of startRedirectExam method....";
		String end="End of startRedirectExam method....";
		logger.info(start);

		Map<String, Object> model1 = new HashMap<>();
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(session,request);
		if(dbval.equals("0"))
		return new ModelAndView("defaultDatabaseErrorPage", "model1", model1);

		Time totalqtime = null;
		String examname = (String) session.getAttribute(examnameone);
		String time = userservice.getTimeBasedOnSelectedExam(examname);
		totalqtime = Time.valueOf(time);

		String clsid = (String) session.getAttribute(cname);
		String sectid = (String) session.getAttribute(sname);
		String brcid = (String) session.getAttribute(bname);
		String locationids = (String) session.getAttribute(lid);

		String sid = (String) session.getAttribute(sidsvar);
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

		String endtime = userservice.getEndTimeinTempHostory(examname, sid);
		DateFormat dateFormat = new SimpleDateFormat(yytime);
		Date now = new Date();
		String currenttime = dateFormat.format(now);
		Date date1 = dateFormat.parse(currenttime);
		String enddatevalue = (String) session.getAttribute("examenddate");
		String endtimeval = (String) session.getAttribute("examendtime");
		String endatevalue1 = enddatevalue + " " + endtimeval;
		Date date2 = dateFormat.parse(endatevalue1);
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
		Time totaltime = Time.valueOf(timevalq);

		model.addAttribute("time_val_q", totaltime);
		model.addAttribute("endtime", endtime);

		logger.info(end);

		int examtypeid = userservice.getExamTypeIdBasedOnExamName(examname);
		int patterncnt = userservice.getPatternIdBasedOnExamType(examtypeid);
		if (patterncnt == 1) {
			/****************** Gate Pattern Based Exam *****************/
			return new ModelAndView("questionSlot", modelone, model1);
		} else {
			/****************** Tet Pattern Based Exam *****************/
			return new ModelAndView("questionSlotrrb", modelone, model1);

		}

	}

	@RequestMapping(value = "/load-resumeExamFormSlot", method = RequestMethod.GET)
	public ModelAndView restartExmas(Model model, FormQuestionPojo fqp, HttpServletRequest request,
			HttpSession session, Exam_DisplayPojo emp, Exam_DisplayListPojo pdlp) throws ParseException {

		String start="Entry of restartExmas method....";
		String end="End of restartExmas method....";
		logger.info(start);
		
		Map<String, Object> model1 = new HashMap<>();
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(session,request);
		if(dbval.equals("0"))
		return new ModelAndView("defaultDatabaseErrorPage", "model1", model1);

		String sid = (String) session.getAttribute(sidsvar);
		String examname = (String) session.getAttribute(examnameone);
		String subjectids = (String) session.getAttribute(subjectidsvar);

		String timeval;
		Time totalqtime = null;
		Time timeqtaken = null;
		String time = userservice.getTimeBasedOnSelectedExam(examname);
		totalqtime = Time.valueOf(time);

		String clsid = (String) session.getAttribute(cname);
		String sectid = (String) session.getAttribute(sname);
		String brcid = (String) session.getAttribute(bname);
		String locationid = (String) session.getAttribute(lid);
		int locationdival = (new Integer(locationid)).intValue();
		int brcidval = (new Integer(brcid)).intValue();
		int clsidval = (new Integer(clsid)).intValue();
		int sectidval = (new Integer(sectid)).intValue();

		model.addAttribute("class_id", clsid);
		model.addAttribute("section_id", sectid);
		model.addAttribute("branch_id", brcid);
		model.addAttribute("location_id", locationid);
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
			timeval = userservice.getLeastTimeFromTempHistoryPackage(sid, locationdival, brcidval, clsidval, sectidval,
					examname);
			timeqtaken = Time.valueOf(timeval);
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

		logger.info(end);

		int examtypeid = userservice.getExamTypeIdBasedOnExamName(examname);
		int patterncnt = userservice.getPatternIdBasedOnExamType(examtypeid);
		if (patterncnt == 1) {
			/****************** Gate Pattern Based Exam *****************/
			return new ModelAndView("resumeExamSlot", modelone, model1);
		} else {
			/****************** Tet Pattern Based Exam *****************/
			return new ModelAndView("resumeExamRRbSlot", modelone, model1);

		}

	}

	@ResponseBody
	@RequestMapping(value = "/load-questionid-bookmarkSlot", method = RequestMethod.POST)
	public void getQuestionIdfromBookmarkAnalysis(Model model, QuestionPojo qp, BookmarkPojo p, HttpSession session,
			HttpServletRequest request, HttpServletResponse response) {

		String start="Entry of getQuestionIdfromBookmarkAnalysis method....";
		String end="End of getQuestionIdfromBookmarkAnalysis method....";
		logger.info(start);

		String cquestionid = request.getParameter("ver");
		int currentquestionid = Integer.parseInt(cquestionid);
		model.addAttribute("qp", qp);

		String examname = request.getParameter(examnamevar);
		String emsubjectid = request.getParameter("subjectid");
		int subjectid = Integer.parseInt(emsubjectid);
		String emlocationid = request.getParameter(lid);
		int locationid = Integer.parseInt(emlocationid);
		String emclassid = request.getParameter("classid");
		int classid = Integer.parseInt(emclassid);
		String emsectionid = request.getParameter("sectionid");
		int sectionid = Integer.parseInt(emsectionid);
		String embranchid = request.getParameter("branchid");
		int branchid = Integer.parseInt(embranchid);
		String studentid = request.getParameter("studentid");
		int bookmarkStatusTypeId = 20;

		int cntofQtnAvailinBook = userservice.findQuestionIDAvailableinBookmark(examname, studentid, currentquestionid);

		if (cntofQtnAvailinBook == 0) {
			userservice.insertBookmarkAnalysisData(examname, currentquestionid, studentid, subjectid,
					bookmarkStatusTypeId, classid, branchid, sectionid, locationid);
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

	@RequestMapping(value = "/load-serverendtimeSlot")
	public @ResponseBody Long getactualTimeFromServer(HttpSession session, HttpServletRequest request)
			throws ParseException {
		String examname = request.getParameter(examnamevar);
		String sid = (String) session.getAttribute(sidsvar);
		DateFormat dateFormat = new SimpleDateFormat(yytime);
		Date now = new Date();
		String currenttime = dateFormat.format(now);
		Date date1 = dateFormat.parse(currenttime);
		String endtime = userservice.getEndTimeinTempHostory(examname, sid);
		String enddatevalue = userservice.getEndDateinTempHostory(examname, sid);
		String endatevalue1 = enddatevalue + " " + endtime;
		Date date2 = dateFormat.parse(endatevalue1);

		return date2.getTime() - date1.getTime();
	}

	@ExceptionHandler(EducareCustomException.class)
	public ModelAndView handleCustomException(EducareCustomException ex) {

		String start="Entry of handleCustomException method....";
		String end="End of handleCustomException method....";
		logger.info(start);

		ModelAndView model = new ModelAndView("error/generic_error");
		model.addObject("errCode", ex.getErrCode());
		model.addObject("errMsg", ex.getErrMsg());

		logger.info(end);

		return model;

	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {

		String start="Entry of handleAllException method....";
		String end="End of handleAllException method....";
		logger.info(start);

		ModelAndView model = new ModelAndView("error/generic_error");
		model.addObject("errMsg", "this is Exception.class");

		logger.info(end);

		return model;

	}

}
