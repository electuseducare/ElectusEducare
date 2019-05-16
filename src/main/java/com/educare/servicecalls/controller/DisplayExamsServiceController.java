package com.educare.servicecalls.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.educare.model.ExamCompletionState;
import com.educare.model.LoginPojo;
import com.educare.model.QuestionPojo;
import com.educare.servicecalls.model.DisplayExamsServiceListModel;
import com.educare.servicecalls.model.DisplayExamsServiceModel;
import com.educare.services.RegisterServiceImpl;

@RestController
public class DisplayExamsServiceController {

	@Autowired
	private RegisterServiceImpl userservice;

	@RequestMapping(value = "/displaystudentexams", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<DisplayExamsServiceListModel> displayStudentExams(@RequestParam("studentid") String studentid,
			@RequestParam("keyDS") String keyDS, DisplayExamsServiceListModel dl, HttpSession session) {

		/** database selection **/
		session.setAttribute("keyDS", keyDS);

		List<DisplayExamsServiceModel> des1 = new ArrayList<>();
		List<LoginPojo> userdetails = userservice.getUserdetails(studentid);
		String examnewstatus = null;
		String stateid = null;
		String locationid = null;
		String branchid = null;
		String classid = null;
		String sectionid = null;
		for (LoginPojo loginPojo : userdetails) {
			stateid = loginPojo.getState();
			locationid = loginPojo.getLocationid();
			branchid = loginPojo.getBarnch();
			classid = loginPojo.getClassname();
			sectionid = loginPojo.getSection();
		}

		List<QuestionPojo> examdata = userservice.getExams(stateid, locationid, branchid, classid, sectionid);
		String examname = null;
		List<ExamCompletionState> examstatus = null;
		for (QuestionPojo ques : examdata) {

			DisplayExamsServiceModel des = new DisplayExamsServiceModel();
			List<String> subjectnames = new ArrayList<>();
			List<String> subjectids = new ArrayList<>();
			examname = ques.getExamname();

			/** Set the values to model **/
			setToModel(des1, examname, ques, des);

			List<QuestionPojo> subjects = userservice.getSubjectnamesInSubjectTable(examname);

			/** Set Subject name list */
			subjectNameList(subjectnames, subjects);
			des.setSubnamelist(subjectnames);

			/** Set Subject id list */
			subjectIdList(subjectids, subjects);
			des.setSubidlist(subjectids);

			examstatus = userservice.getExamCompletionStatusQuery(studentid, stateid, locationid, branchid, classid,
					sectionid, examname);

			if (examstatus.isEmpty()) {
				examnewstatus = "false";
				des.setExamstatus(examnewstatus);
			}

			else {
				for (ExamCompletionState examComplete : examstatus) {

					String exstatus = examComplete.getExamn_status();
					des.setExamstatus(exstatus);
					if (exstatus.equals("start")) {
						examnewstatus = "start";
						des.setExamstatus(examnewstatus);
					} else {
						examnewstatus = "Finish";
						des.setExamstatus(examnewstatus);
					}
				}
			}

			dl.setData(des1);
		}
		return new ResponseEntity<>(dl, HttpStatus.OK);

	}

	/** Set the values to model **/
	public void setToModel(List<DisplayExamsServiceModel> des1, String examname, QuestionPojo ques,
			DisplayExamsServiceModel des) {
		des.setExamname(examname);
		des.setEnddate(ques.getEnddate());
		des.setEndtime(ques.getEndtime());
		des.setExamtype(ques.getExam_type());
		des.setSlotdate(ques.getSlotdate());
		des.setStarttime(ques.getStarttime());
		des1.add(des);
	}

	/** Set Subject name list */
	public void subjectNameList(List<String> subjectnames, List<QuestionPojo> subjects) {
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
	}

	/** Set Subject id list */
	public void subjectIdList(List<String> subjectids, List<QuestionPojo> subjects) {
		int listidsize = 1;
		for (QuestionPojo subj1 : subjects) {
			int subjids = subj1.getSubjectid();
			String subjidstring = String.valueOf(subjids);
			if (listidsize == 1) {
				subjectids.add(subjidstring);
			}
			if ((listidsize != 1)) {
				subjectids.add("," + subjidstring);
			}
			listidsize++;
		}
	}

}
