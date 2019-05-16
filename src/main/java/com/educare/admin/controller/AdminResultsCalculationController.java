package com.educare.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.educare.DatabaseValueController;
import com.educare.admin.model.AdminExamNameforReport;
import com.educare.admin.model.ResultCalculationModel;
import com.educare.controller.LoginController;
import com.educare.model.QuestionPojo;
import com.educare.services.AdminRegisterServiceImpl;
import com.educare.services.RegisterServiceImpl;

@Controller
public class AdminResultsCalculationController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminResultsCalculationController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private RegisterServiceImpl userservice;

	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;
	
	@RequestMapping(value = "/load-resultsCalculation")
	public String resultsCalculation(Model model, ResultCalculationModel rcm, HttpSession ses, RedirectAttributes ra,HttpServletRequest req) {
		String start = "Entry of resultsCalculation method....";
		String end = "End of resultsCalculation method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);

		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		List<AdminExamNameforReport> examlist = adminuserservice.getExamNameWiseReportFromAdmin();
		model.addAttribute("examlist", examlist);

		model.addAttribute("rcm", rcm);

		model.addAttribute("smsg", model.asMap().get("smsg"));
		model.addAttribute("emsg", model.asMap().get("emsg"));
		logger.info(end);
		return "resultsCalculation";
	}

	@RequestMapping("/load-resultsCalcHistory")
	public String adminUpdatereults(Model model, ResultCalculationModel rcm, HttpSession ses, RedirectAttributes ra,HttpServletRequest req) {

		String start = "Entry of adminUpdatereults method....";
		String end = "End of adminUpdatereults method....";
		logger.info(start);
		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";

		String examname = rcm.getExamname();
		String examstatus = "Finish";
		float actualscore = 0;

		float examscoredmarks = 0;
		int totalAnswered1 = 0;
		int totalnotAnswered1 = 0;
		int totalWrongAnswered1 = 0;
		String smsg = null;
		String emsg = null;
		int updateres = 0;
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

		List<ResultCalculationModel> stuidlst = adminuserservice.getStudentidsBaseExam(rcm);
		model.addAttribute("stuidlst", stuidlst);

		for (ResultCalculationModel studid : stuidlst) {

			String stid = studid.getStudentid();

			for (int j = 0; j < subarray.length; j++) {

				List<QuestionPojo> tempexamdata = userservice.getExamdataIntempHistory(examname, stid, examstatus,
						subarray[j]);
				String marksperqustype1;
				float marksPerQusType = 0;
				float nmarks = 0;
				String nmarks1 = null;
				int totalAnswered = 0;
				float finalmarks = 0;
				float yourMarks1 = 0;
				int totalnotAnswered = 0;
				int totalWrongAnswered = 0;

				for (QuestionPojo ques : tempexamdata) {
					String questionid = ques.getQuestion_id();
					int qid = (new Integer(questionid)).intValue();
					String ans = userservice.getCorrectAnswer(questionid);
					if (ans != null) {
						ans = ans.trim();
						ans = ans.replaceAll("\\s+", "");
					}
					String selectedanswer = ques.getSelected_answer();
					if (selectedanswer != null) {
						selectedanswer = selectedanswer.trim();
						selectedanswer = selectedanswer.replaceAll("\\s+", "");
					}
					String notanswered = null;
					String rightanswer = null;
					String wronganswer = null;
					int questionrowid = ques.getQuestionrowid();
					int qustype = userservice.getQustypeBasedonQuestionIb(qid);

					marksperqustype1 = userservice.getScoredmarksInDemoExam(qustype, examname, subarray[j]);
					marksPerQusType = Float.valueOf(marksperqustype1);
					nmarks1 = userservice.getNegativeMarksInExamPaper(qustype, examname, subarray[j]);
					nmarks = Float.valueOf(nmarks1);
					if (selectedanswer != null) {
						if (selectedanswer.equalsIgnoreCase(ans)) {
							rightanswer = selectedanswer;

							finalmarks = finalmarks + marksPerQusType;
							actualscore = marksPerQusType;
							totalAnswered++;
							userservice.updateStudentResultsHistory(stid, examname, qid, rightanswer, notanswered,
									wronganswer, subarray[j], actualscore, questionrowid);
						}

						else {
							totalWrongAnswered++;
							finalmarks = finalmarks - nmarks;
							wronganswer = selectedanswer;
							actualscore = marksPerQusType;
							float yourMarks = -nmarks;
							userservice.updateStudentResultsHistory(stid, examname, qid, rightanswer, notanswered,
									wronganswer, subarray[j], yourMarks, questionrowid);
						}

					} else {

						totalnotAnswered++;
						notanswered = "NA";
						int actualscore1 = 0;
						userservice.updateStudentResultsHistory(stid, examname, qid, rightanswer, notanswered,
								wronganswer, subarray[j], actualscore1, questionrowid);
					}

				}
				yourMarks1 = finalmarks;
				userservice.updateStudentResultsSubjMarks(stid, examname, subarray[j], yourMarks1, totalAnswered,
						totalWrongAnswered, totalnotAnswered);
				examscoredmarks = examscoredmarks + yourMarks1;
				totalAnswered1 = totalAnswered1 + totalAnswered;
				totalnotAnswered1 = totalnotAnswered1 + totalnotAnswered;
				totalWrongAnswered1 = totalWrongAnswered1 + totalWrongAnswered;

			}
			updateres = userservice.updateExamscoredMarks(stid, examname, examscoredmarks);

		}

		if (updateres > 0) {
			smsg = "Results Updated Successfully";
		} else {
			emsg = "Results Not Updated Successfully";
		}

		ra.addFlashAttribute("smsg", smsg);
		ra.addFlashAttribute("emsg", emsg);
		logger.info(end);
		return "redirect:/load-resultsCalculation";
	}

}
