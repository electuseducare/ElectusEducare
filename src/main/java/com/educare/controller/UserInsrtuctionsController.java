package com.educare.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.educare.DatabaseValueController;
import com.educare.model.Instructionspojo;
import com.educare.services.RegisterServiceImpl;

@Controller
public class UserInsrtuctionsController {

	@Autowired
	private RegisterServiceImpl userservice;
	
	@Autowired
	private DatabaseValueController dv;

	/********************* Without Slot Instructions ***********************/
	
	
	@RequestMapping(value = "/load-instructions")
	public String loadInstructionMethod(HttpServletRequest request, HttpServletResponse response, Model model,HttpSession ses) {
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,request);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		String examname = request.getParameter("exam");
		model.addAttribute("examname", examname);
		
		return "loadinstruction";
	}

	@RequestMapping(value = "/load-instructionssecondpage")
	public String loadinstructionssecondpage(HttpServletRequest request, HttpServletResponse response, Model model,HttpSession ses) {
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,request);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		String examname = request.getParameter("exam");
		model.addAttribute("examname", examname);
		String[] examarry=examname.trim().split("\\s*,\\s*");
		String examval=examarry[0].toString();
		List<Instructionspojo> getdetails = userservice.getAllInstructionDetails(examval);
		model.addAttribute("getdetails", getdetails);
		model.addAttribute("examname1", examval);

		return "loadinstructionpage2";
	}

	
	/********************* Without Instructions *************************/
	
	@RequestMapping(value = "/load-slotInstructions")
	public String slotInstructions(HttpServletRequest request, HttpServletResponse response, Model model,HttpSession ses) {
	
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,request);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		String examname = request.getParameter("exam");
		model.addAttribute("examname", examname);
		
		return "loadSlotInstruction";
	}

	@RequestMapping(value = "/load-slotInstructionssecondpage")
	public String slotInstructionssecondpage(HttpServletRequest request, HttpServletResponse response, Model model,HttpSession ses) {
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,request);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		String examname = request.getParameter("exam");
		model.addAttribute("examname", examname);
		String[] examarry=examname.trim().split("\\s*,\\s*");
		String examval=examarry[0].toString();
		List<Instructionspojo> getdetails = userservice.getAllInstructionDetails(examval);
		model.addAttribute("getdetails", getdetails);
		model.addAttribute("examname1", examval);

		return "loadSlotInstructionpage2";
	}

	
}
