package com.educare.servicecalls.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.educare.model.Instructionspojo;
import com.educare.servicecalls.model.InstructionsListModel;
import com.educare.services.RegisterServiceImpl;

@RestController
public class ExamInstructionsServiceController {

	@Autowired
	private RegisterServiceImpl userservice;

	@RequestMapping(value = "/get-examinstructions")
	private ResponseEntity<InstructionsListModel> getExamInstructions(HttpSession session,
			@RequestParam("keyDS") String keyDS, @RequestParam("examname") String examname,
			InstructionsListModel inlp) {

		/** database selection **/
		session.setAttribute("keyDS", keyDS);

		List<Instructionspojo> ip = new ArrayList<>();

		List<Instructionspojo> getdetails = userservice.getAllInstructionDetails(examname);

		if (getdetails != null && !getdetails.isEmpty()) {

			for (Instructionspojo ebb : getdetails) {

				Instructionspojo inp = new Instructionspojo();

				inp.setSubjectname(ebb.getSubjectname());
				inp.setQuestiontype(ebb.getQuestiontype());
				inp.setMarksperquestype(ebb.getMarksperquestype());
				inp.setNegativemarks(ebb.getNegativemarks());
				inp.setNoofquestions(ebb.getNoofquestions());

				ip.add(inp);
				inlp.setData(ip);

			}

		}

		return new ResponseEntity<>(inlp, HttpStatus.OK);

	}

}
