package com.educare.controller;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.educare.DatabaseValueController;
import com.educare.exception.EducareCustomException;
import com.educare.model.FormQuestionPojo;
import com.educare.model.QuestionPojo;
import com.educare.model.ResultsPojo;
import com.educare.model.UserResultsPojo;
import com.educare.services.RegisterServiceImpl;
@Controller
public class ResultsCalculationController {
	
	private static final Logger logger = LoggerFactory.getLogger(ResultsCalculationController.class);

	@Autowired
	private RegisterServiceImpl userservice;
	
	@Autowired
	private DatabaseValueController dv;

	@RequestMapping(value = "/load-qform", method = RequestMethod.POST)
	public String resultsCalculation(Model model, FormQuestionPojo fqp, HttpSession session, HttpServletRequest req,
			@ModelAttribute("mapping1Form") final Object mapping1FormObject) {
		
		String start="Entry of resultsCalculation method....";
		String end="end of resultsCalculation method....";
		logger.info(start);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(session,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
	
		List<QuestionPojo> results = fqp.getList();
		model.addAttribute("qp", results);

		float actualScore = 0;

		String correctAnswer = null;
		String studentid = (String) session.getAttribute("student_id");
		String sectionname = (String) session.getAttribute("sectionname");
		String branchname = (String) session.getAttribute("branchname");
		String username = (String) session.getAttribute("username");
		String username1 = (String) session.getAttribute("uname");
		String classname = (String) session.getAttribute("classname");
		String state = (String) session.getAttribute("state");
		String locationid = (String) session.getAttribute("locationid");
		String subjectname = req.getParameter("subjectname");
		String examname1 = req.getParameter("examname");
		session.setAttribute("examname1", examname1);
		String examname=(String)session.getAttribute("examname1");
		List<String> subjectnames = new ArrayList<>();
		QuestionPojo questionpo = new QuestionPojo();
		List<QuestionPojo> subjects = userservice.getSubjectnamesInSubjectTable(examname);
		/** Set Subject name list */
		int listsize = 1;
		for (QuestionPojo subj : subjects) {
			String subjnames = subj.getSubject_type();
			if (listsize == 1) {
				subjectnames.add(subjnames);
			}
			if ((listsize != 1)) {
				subjectnames.add("," + subjnames);
			}
			listsize++;
		}
		questionpo.setSublist(subjectnames);

		model.addAttribute("questionlist", subjectnames);

		model.addAttribute("subjetname", subjectname);
		session.setAttribute("subjetnameval", subjectname);
		model.addAttribute("examname", examname);

		List<QuestionPojo> subjectnameslist = userservice.getSubjectnamesInExam(examname);
		int countsubjectnames = userservice.getCountOfSubjectnamesInExam(examname);
		String[] subarray = new String[countsubjectnames];
		int i = 0;
		for (QuestionPojo quest : subjectnameslist) {
			int subid = quest.getSubjectid();
			String subjectid = String.valueOf(subid);
			subarray[i] = subjectid;
			i++;

		}

		List<QuestionPojo> values = userservice.getTotalMarksAndTotalAvailablestudents(examname);
		String toatalmarks1 = null;
		float toatalmarks=0;
		int totalAvailableStudents = 0;
		String examConductedDate = null;
		for (QuestionPojo total : values) {
			toatalmarks1 = total.getToatalmarks();
			toatalmarks=Float.valueOf(toatalmarks1);
			totalAvailableStudents = total.getTotal_available_students();
			examConductedDate = total.getSlotdate();

		}
		session.setAttribute("examname", examname);
	
		String totalqtime = req.getParameter("totalqtime");
		String qtimetak = req.getParameter("timeqtaken");
		String[] frmtime = qtimetak.trim().split(":"); // split it at the colons
		int frmtimelen = frmtime.length;
		String mm = frmtime[0];
		String sec = frmtime[1];
		String hh = "00";
		if (frmtimelen > 2) {
			hh = frmtime[0];
			mm = frmtime[1];
			sec = frmtime[2];
		}

		int locationidval =(new Integer(locationid)).intValue();
		int branchid = (new Integer(branchname)).intValue();
		int classid =(new Integer(classname)).intValue();
		int sectionid = (new Integer(sectionname)).intValue();
		String takn = hh + ":" + mm + ":" + sec;
		Time timeqtaken = Time.valueOf(takn);

		float examScoredMarks = 0;
		int totalanswered = 0;
		int totalNotAnswered = 0;
		int totalwrongAnswered = 0;
		float yourmarks1 = 0;
		float finalMarks = 0;
		float subjecttotalmarks = 0;
		model.addAttribute("timeqtaken", timeqtaken);

		String totalqns = req.getParameter("noOfqbns");
		int totalQuestions = (new Integer(totalqns)).intValue();
		userservice.getUpdateExamCompletionStatus(studentid, examname, locationidval, branchid, classid, sectionid);
		String examstatus = "Finish";
		int getexistexamcountforresults=userservice.getCountForExistingResults(examname, studentid);
		if(getexistexamcountforresults>0){
		String emsg="Your Exam was already submitted check your results in dashboard.";
		model.addAttribute("emsg", emsg);
			return "exsistresults";
		}

		for (int j = 0; j < subarray.length; j++) {
			List<QuestionPojo> tempExamData = userservice.getExamdataIntempHistory(examname, studentid, examstatus,
					subarray[j]);
			String marksPerQusType1 = null;
			float marksPerQusType = 0;
			float nmarks=0;
			String nmarks1=null;
			int totalAnswered = 0;
			float finalmarks = 0;
			float yourMarks1 = 0;
			int totalnotAnswered = 0;
			int totalWrongAnswered = 0;
			List<Map<String, Object>> getsubjecttot = userservice.getsubjectwisemarksforExam(examname, subarray[j]);
			for (Map<String, Object> map : getsubjecttot) {
				Object submarks = map.get("total_marks");
				String subjmarks = submarks.toString();
				subjecttotalmarks = Float.valueOf(subjmarks);
			}

			for (QuestionPojo ques : tempExamData) {
				String questionid = ques.getQuestion_id();
				int qid =(new Integer(questionid)).intValue();
				String ans = userservice.getCorrectAnswer(questionid);
				if (ans != null) {
					ans = ans.trim();
					ans = ans.replaceAll("\\s+", "");
				}
				String selectedAnswer = ques.getSelected_answer();
				if (selectedAnswer != null) {
					selectedAnswer = selectedAnswer.trim();
					selectedAnswer = selectedAnswer.replaceAll("\\s+", "");
				}
				correctAnswer = ans.replaceAll("\\<.*?\\>", "").replaceAll("\\s+", "");
				String notanswered = null;
				String rightanswer = null;
				String wronganswer = null;
				int questionrowid = ques.getQuestionrowid();
				int qustype = userservice.getQustypeBasedonQuestionIb(qid);

				marksPerQusType1 = userservice.getScoredmarksInDemoExam(qustype, examname, subarray[j]);
				marksPerQusType=Float.valueOf(marksPerQusType1);
				nmarks1=userservice.getNegativeMarksInExamPaper(qustype, examname, subarray[j]);
				nmarks=Float.valueOf(nmarks1);
				if (selectedAnswer != null) {
					if(qustype==110){
						String[] arr=ans.split("-");
			    		String firstno=arr[0];
			    		String secondno=arr[1];		
			    		double firstn=(new Double(firstno)).doubleValue();
			    		double secndn=(new Double(secondno)).doubleValue();
			    		double otp=(new Double(selectedAnswer)).doubleValue();
			    		if(firstn<=otp && otp<=secndn){
			    			rightanswer = selectedAnswer;
							finalmarks = finalmarks + marksPerQusType;
							actualScore = marksPerQusType;
							totalAnswered++;
							userservice.insertDataintoFilterResult(studentid, examname, qid, rightanswer, notanswered,
									wronganswer, subarray[j], correctAnswer, marksPerQusType, nmarks, actualScore,
									state, locationid, branchname, classname, sectionname, examConductedDate, username,
									questionrowid);
			    		}else{
			    			totalWrongAnswered++;
							finalmarks = finalmarks - nmarks;
							wronganswer = selectedAnswer;
							actualScore = marksPerQusType;
							float yourMarks = -nmarks;
							userservice.insertDataintoFilterResult(studentid, examname, qid, rightanswer, notanswered,
									wronganswer, subarray[j], correctAnswer, marksPerQusType, nmarks, yourMarks, state,
									locationid, branchname, classname, sectionname, examConductedDate, username,
									questionrowid);

			    			
			    		}	
				}
				else if (selectedAnswer.equalsIgnoreCase(ans)) {
						rightanswer = selectedAnswer;

						finalmarks = finalmarks + marksPerQusType;
						actualScore = marksPerQusType;
						totalAnswered++;
						userservice.insertDataintoFilterResult(studentid, examname, qid, rightanswer, notanswered,
								wronganswer, subarray[j], correctAnswer, marksPerQusType, nmarks, actualScore,
								state, locationid, branchname, classname, sectionname, examConductedDate, username,
								questionrowid);
					}

					else {
						totalWrongAnswered++;
						finalmarks = finalmarks - nmarks;
						wronganswer = selectedAnswer;
						actualScore = marksPerQusType;
						float yourMarks = -nmarks;
						userservice.insertDataintoFilterResult(studentid, examname, qid, rightanswer, notanswered,
								wronganswer, subarray[j], correctAnswer, marksPerQusType, nmarks, yourMarks, state,
								locationid, branchname, classname, sectionname, examConductedDate, username,
								questionrowid);
					}

				} else {

					totalnotAnswered++;
					notanswered = "NA";
					int actualScore1 = 0;
					userservice.insertDataintoFilterResult(studentid, examname, qid, rightanswer, notanswered,
							wronganswer, subarray[j], correctAnswer, marksPerQusType, nmarks, actualScore1, state,
							locationid, branchname, classname, sectionname, examConductedDate, username,
							questionrowid);
				}

			}
			yourMarks1 = finalmarks;
			userservice.insertStudentResults(studentid, examname, subarray[j], yourMarks1, totalQuestions,
					totalAnswered, totalqtime, username, sectionname, branchname, state, classname, locationid,
					timeqtaken, toatalmarks, totalAvailableStudents, examConductedDate, nmarks, totalWrongAnswered,
					totalnotAnswered, subjecttotalmarks);
			examScoredMarks = examScoredMarks + yourMarks1;
			totalanswered = totalanswered + totalAnswered;
			totalNotAnswered = totalNotAnswered + totalnotAnswered;
			totalwrongAnswered = totalwrongAnswered + totalWrongAnswered;
			finalMarks = finalmarks;
		}
		
         
		userservice.updateExamscoredMarks(studentid, examname, examScoredMarks);
        userservice.updateExamendtimeInAuditLogs(studentid,examname,username1);  
		float scoreCalc = (float) ((examScoredMarks) * 100 / totalQuestions);
		if (scoreCalc < 0.0) {
			scoreCalc = 0.0f;
		}

		ResultsPojo rp = new ResultsPojo();
		rp.setTotalquestion(totalQuestions);

		model.addAttribute("totalQuestions", totalQuestions);
		model.addAttribute("totalAnswered", totalanswered);
		model.addAttribute("totalnotAnswered", totalNotAnswered);
		model.addAttribute("scoreCalc", scoreCalc);
		model.addAttribute("yourMarks", examScoredMarks);
		model.addAttribute("examname", examname);
		session.setAttribute("examname", examname);
		session.setAttribute("studentid", studentid);
		model.addAttribute("finalmarks", finalMarks);
		model.addAttribute("totalWrongAnswered", totalwrongAnswered);
		model.addAttribute("yourmarks", yourmarks1);
		String tmarks = String.valueOf(toatalmarks);
		model.addAttribute("totalmarks", tmarks);
		
		logger.info(end);
		
		return "redirect:/finalPage";
	}

	@RequestMapping(value = "/finalPage", method = RequestMethod.GET)
	public String finalPage(Model model, @ModelAttribute("mapping1Form") final Object mapping1FormObject,
			HttpSession sess,HttpServletRequest req) {
		
		String start="Entry of finalPage method....";
		String end="End of finalPage method....";
		logger.info(start);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(sess,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		String examname = (String) sess.getAttribute("examname");
		String studentid = (String) sess.getAttribute("studentid");
		int totalAnswered = 0;
		int answered = 0;
		int totalWrongAnswered = 0;
		int wrongAnswered = 0;
		float totalNotAnswered = 0;
		int notAnswered = 0;
		float yourMarks1 = 0;
		float tmarks = 0;

		List<UserResultsPojo> result = userservice.getresultsfordisplay(examname, studentid);
		for (UserResultsPojo userResultsPojo : result) {
			answered = userResultsPojo.getCorrectanswers();
			wrongAnswered = userResultsPojo.getWronganswers();
			tmarks = Float.valueOf(userResultsPojo.getTotalmarks());
			notAnswered = userResultsPojo.getUnattempt();
			yourMarks1 = Float.valueOf(userResultsPojo.getExamscored());
			totalAnswered = totalAnswered + answered;

			totalWrongAnswered = totalWrongAnswered + wrongAnswered;
			totalNotAnswered = totalNotAnswered + notAnswered;
		}

		model.addAttribute("totalWrongAnswered", totalWrongAnswered);
		model.addAttribute("totalAnswered", totalAnswered);
		model.addAttribute("totalnotAnswered", totalNotAnswered);
		model.addAttribute("results", result);
		model.addAttribute("yourmarks", yourMarks1);
		model.addAttribute("totalmarks", tmarks);
		
		logger.info(end);
		
		return "userTestResults";
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
