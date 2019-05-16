package com.educare.admin.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

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
import com.educare.admin.model.Questionanalysispojo;
import com.educare.services.AdminRegisterServiceImpl;

@Controller
public class QuestionwiseTimanalysisController {
	private static final Logger logger = LoggerFactory.getLogger(QuestionwiseTimanalysisController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;
	
	@Autowired
	private DatabaseValueController dv;

	@RequestMapping("load-QuestionwiseTimeAnalysis")
	public String questionwiseTimanalysis(HttpSession ses, Model model, Questionanalysispojo qs,HttpServletRequest req) {

		String start = "Entry of questionwiseTimanalysis method....";
		String end = "End of questionwiseTimanalysis method....";
		logger.info(start);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		String examname = (String) ses.getAttribute("examnameval");
		StringJoiner str = new StringJoiner(",");

		List<Map<String, Object>> getstudentid = adminuserservice.getStudentidforQuestionanalysis(examname);
		for (Map<String, Object> map : getstudentid) {
			Object studentids = map.get("student_id");
			String stdid = String.valueOf(studentids);
			str.add(stdid);
		}
		String studentjoined = str.toString();
		String[] splsttudent = null;
		splsttudent = studentjoined.split(",");
		StringJoiner studentjoin = new StringJoiner("','");
		for (int a = 0; a < splsttudent.length; a++) {
			String splstudentnames = splsttudent[a];
			studentjoin.add(splstudentnames);
		}

		String subjoinedstudentids = studentjoin.toString();
		String examstatus = "Finish";
		List<Questionanalysispojo> details = adminuserservice.getQuestionWiseAnalysisData(examname, examstatus,
				subjoinedstudentids);
		List<Questionanalysispojo> avgstimedata = adminuserservice.getAvgtimeBasedonExamname(examname, examstatus);
		int questioncount = adminuserservice.getQuestionsCountBasedonExamname(examname);
		
		model.addAttribute("questioncount", questioncount);
		model.addAttribute("avgstimedata", avgstimedata);
		model.addAttribute("qs", qs);
		model.addAttribute("qdetails", details);
		model.addAttribute("examname", examname);
		logger.info(end);

		return "QuestionWiseTimeAnalysis";
	}

	@RequestMapping("process-QuestionTimeAnalysis")
	public ModelAndView processQuestionTimeAnalsyis(HttpSession ses, Model model, Questionanalysispojo qs,
			HttpServletRequest req) throws ParseException {
		
		Map<String, Object> model1 = new HashMap<>();
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return new ModelAndView("defaultDatabaseErrorPage", "model1", model1);

		
		String examname = req.getParameter("examname");
		String studentid = req.getParameter("stdid");
		String diffsec1 = "";
		int gettotalquescnt = adminuserservice.getQuestionWiseCountforAnalalysis(examname, studentid);
		List<Questionanalysispojo> getdata = adminuserservice.getQuestinonWiseTimeDifferencevalues(examname, studentid);
		List<Questionanalysispojo> getdifflistval = new ArrayList<>();
		String finaldiff = "";
		int startPoint = 1;
		for (Questionanalysispojo questionanalysispojo : getdata) {
			Questionanalysispojo ques = new Questionanalysispojo();
			String presnttime = questionanalysispojo.getTimedifference();

			if (startPoint == 1) {
				String actualstarttime = adminuserservice.getActualStartTimeFromTemp(examname, studentid);
				SimpleDateFormat format = new SimpleDateFormat("kk:mm:ss");
				Date date11 = format.parse(actualstarttime);
				Date date21 = format.parse("00:00:00");
				if (presnttime != null) {
					date21 = format.parse(presnttime);
				} else {
					date11 = format.parse("00:00:00");
				}
				long difference1 = 0;
				difference1 = date21.getTime() - date11.getTime();
				long diffSec1 = difference1 / 1000;
				diffsec1 = String.valueOf(diffSec1);
				long min1 = diffSec1 / 60;
				String mm1 = String.valueOf(min1);

				long sec1 = diffSec1 % 60;
				String ss1 = String.valueOf(sec1);

				if (mm1.length() <= 1) {
					mm1 = "0" + mm1;
				}
				if (ss1.length() <= 1) {
					ss1 = "0" + ss1;
				}
				finaldiff = "00:" + mm1 + ":" + ss1;

			}

			else {
				int getcountforques = adminuserservice.getcountNextQuestionTimetakenvalue(presnttime, examname,
						studentid);
				if (getcountforques == 1) {
					String nexttime1 = adminuserservice.getNextQuestionTimetakenvalue(presnttime, examname, studentid);
					SimpleDateFormat format = new SimpleDateFormat("kk:mm:ss");
					Date date1 = format.parse(presnttime);
					Date date2 = format.parse(nexttime1);
					long difference = 0;

					difference = date2.getTime() - date1.getTime();
					long diffSec = difference / 1000;
					diffsec1 = String.valueOf(diffSec);
					long min = diffSec / 60;
					String mm = String.valueOf(min);

					long sec = diffSec % 60;
					String ss = String.valueOf(sec);

					if (mm.length() <= 1) {
						mm = "0" + mm;
					}
					if (ss.length() <= 1) {
						ss = "0" + ss;
					}
					finaldiff = "00:" + mm + ":" + ss;

				} else {
					finaldiff = "00:00:00";
					diffsec1 = "0";
				}
			}
			ques.setTotalsec(diffsec1);
			ques.setDiffer(finaldiff);
			getdifflistval.add(ques);
			startPoint++;
		}
		model1.put("ques", getdifflistval);
		model.addAttribute("countques", gettotalquescnt);
		model.addAttribute("getdifference", getdata);
		return new ModelAndView("ViewQuestionTimeAnalysis", "model1", model1);
	}

}
