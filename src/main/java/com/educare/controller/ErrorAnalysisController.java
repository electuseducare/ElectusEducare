package com.educare.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.educare.model.ErrorAnalysisPojo;
import com.educare.services.RegisterServiceImpl;

@Controller
public class ErrorAnalysisController {
	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(ErrorAnalysisController.class);

	@Autowired
	private RegisterServiceImpl userservice;
	
	@ResponseBody
	@RequestMapping(value = "/load-errorAnalysis", method = RequestMethod.POST)
	public void errorAnalysisByQuestionId(HttpServletRequest request, HttpServletResponse response) {

		String start = "Entry of errorAnalysisByQuestionId method....";
		String end = "End of errorAnalysisByQuestionId method....";

		logger.info(start);

		String qusid = request.getParameter("ver");
		String qidanalysis = "";
		List<ErrorAnalysisPojo> errorAnalysis = userservice.getAnalysis(qusid);
		for (ErrorAnalysisPojo errorAnalysisPojo : errorAnalysis) {
			qidanalysis = errorAnalysisPojo.getQuestion_Analysis();

		}

		try {
			response.getWriter().write(qidanalysis);
		} catch (IOException e) {

		}

		logger.info(end);

	}

}
