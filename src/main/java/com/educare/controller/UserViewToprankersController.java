package com.educare.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.educare.DatabaseValueController;
import com.educare.model.UserTopRankersModel;
import com.educare.services.RegisterServiceImpl;
@Controller
public class UserViewToprankersController {

	@Autowired
	private RegisterServiceImpl userservice;
	
	@Autowired
	private DatabaseValueController dv;
	
	@RequestMapping("load-examnamesforranks")
	private String getExamnamesForToprankers(UserTopRankersModel ut,Model model,HttpServletRequest req,HttpSession ses){
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		model.addAttribute("ut", ut);
		List<UserTopRankersModel> usertoprankers=new ArrayList<>();
		List<UserTopRankersModel> exmalistforranks=userservice.getExamnamesForTopRanks();
		for (UserTopRankersModel utr : exmalistforranks) {
			UserTopRankersModel toprankers=new UserTopRankersModel();
			toprankers.setExamname(utr.getExamname());
			toprankers.setExamtype(utr.getExamtype());
			usertoprankers.add(toprankers);
		}
		model.addAttribute("exmalistforranks", usertoprankers);
		
		return "userGetExamnamesForRanks";
		
	}
	
	
	@RequestMapping("/process-viewtoprankers")
	public String viewTopRankers(UserTopRankersModel ut,Model model,HttpServletRequest req,HttpSession ses){
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		model.addAttribute("ut", ut);
		String examname=req.getParameter("examnamebtn");
		List<UserTopRankersModel> usertoprankerslist=new ArrayList<>();
		List<UserTopRankersModel> topperslist=userservice.getToppersListBasedonExamanme(examname);
		for (UserTopRankersModel utm : topperslist) {
			UserTopRankersModel utr=new UserTopRankersModel();
			utr.setExamname(utm.getExamname());
			utr.setStudentname(utm.getStudentname());
			utr.setExamtotalmarks(utm.getExamtotalmarks());
			utr.setExamscoredmarks(utm.getExamscoredmarks());
			utr.setRank(utm.getRank());
			usertoprankerslist.add(utr);
		}
		
        model.addAttribute("usertoprankerslist", usertoprankerslist);
		return "userToprankersForExam";
		
	}
	

}
