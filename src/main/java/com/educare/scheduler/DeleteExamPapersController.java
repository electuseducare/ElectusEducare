package com.educare.scheduler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import com.educare.services.RegisterServiceImpl;

@Controller
public class DeleteExamPapersController {
	
	@Autowired
	private RegisterServiceImpl userservice;
	
	@Value("${exam.completion.status}")
	String examNotStartedStatus;
	
	public int deleteExam() {
          int del=0;
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		   LocalDateTime now = LocalDateTime.now();
		   String cdate=dtf.format(now);
		List<Map<String, Object>> examplst=userservice.getExamInBetDate(cdate);

		for(Map<String, Object> map : examplst ){
			String examname = (String) map.get("exam_name");
			del=userservice.deleteExampaperInTab(examname);
			userservice.delTempNotStartedExams(examNotStartedStatus,examname);
		}
		

		return del;
	}
}
