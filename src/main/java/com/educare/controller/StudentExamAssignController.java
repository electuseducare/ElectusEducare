package com.educare.controller;

import java.util.List;
import java.util.StringJoiner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.educare.DatabaseValueController;
import com.educare.admin.model.AdminAddCompQuesInExamModel;
import com.educare.model.StudentExamAssignModel;
import com.educare.services.AdminRegisterServiceImpl;

@Controller
public class StudentExamAssignController {

	private static final Logger logger = LoggerFactory.getLogger(StudentExamAssignController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;

	String sidval = "student_id";
	String sval = "student";

	@RequestMapping("/load-studentAssign")
	public String studentAssign(Model model, StudentExamAssignModel sem, HttpSession ses,HttpServletRequest req) {

		String start = "Entry of studentExamAssign method....";
		String end = "End of studentExamAssign method....";
		logger.info(start);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";

		/************** Get Exam Name ****************/
		List<StudentExamAssignModel> examlist = adminuserservice.getExamnamesBaseOnDate();
		model.addAttribute("examlist", examlist);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		model.addAttribute("sem", sem);

		logger.info(end);

		return "studentExamassignFilters";
	}

	@RequestMapping("/load-getClassBaseOnExamName")
	private @ResponseBody List<StudentExamAssignModel> getClassBaseOnExamName(Model model, StudentExamAssignModel sem,
			HttpServletRequest req) {

		String examname = req.getParameter("examname");

		List<StudentExamAssignModel> classlst = adminuserservice.getClassBaseOnExamName(examname,examname);
		model.addAttribute("classlst", classlst);

		return classlst;

	}
	
	@RequestMapping("/load-getStuNameBaseOnClassSec")
	private @ResponseBody List<StudentExamAssignModel> getStuNameBaseOnClassSec(Model model, StudentExamAssignModel sem,
			HttpServletRequest req) {
		String claasid=null;
		
		String classid = req.getParameter("classsec");
		String examname = req.getParameter("examname");
		sem.setExamname(examname);
		List<AdminAddCompQuesInExamModel> examdata=adminuserservice.getExamdataBasedonExamname(examname);
		for (AdminAddCompQuesInExamModel exdata : examdata) {
			sem.setStatidval(exdata.getStateid());
			sem.setLocationidval(exdata.getLocationid());
			sem.setBrachidval(exdata.getBranchid());
		}
		
		String[] classsplit=classid.split(",");
		StringJoiner secidss= new StringJoiner(",");
		for(int i=0;i<classsplit.length;i++){
			 claasid=classsplit[0];
			 sem.setClassid(claasid);
			
			if(i%2!=0){
				
				String secid=classsplit[i];
				secidss.add(secid);
			}
		}
		String sectionids=secidss.toString();
		sem.setSection(sectionids);
        int temexistcount=adminuserservice.getCountInTempHistrory(sem);
        List<StudentExamAssignModel> studlist;
        if(temexistcount==0){
        	studlist=adminuserservice.getStuDetBAsOnSecClassid(sem);
        }else{
        	studlist=adminuserservice.getStuDetBAsOnSecClassid1(sem);
        }
		return studlist;
	
		
	}
	
	@RequestMapping("/load-insertStudentDetails")
	private String  insertStudentDetails(Model model, StudentExamAssignModel sem,
			HttpServletRequest req,HttpSession ses) {
		String start = "Entry of insertStudentDetails method....";
		String end = "End of insertStudentDetails method....";
		logger.info(start);
		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
	    String exname=sem.getExamname();
		String stuname=sem.getStudentid();
		int insertexm=0;
		String msg = null;
		String emsg = null;
		String[] stusplit=stuname.split(",");
		
		for(int i=0;i<stusplit.length;i++){
			
			String stuid=stusplit[i];
			List<StudentExamAssignModel> qustlst=adminuserservice.getExamPaperDetBaseOnExmName(exname);
			List<StudentExamAssignModel> stdetlst=adminuserservice.getStudentDetails(stuid);
			for(StudentExamAssignModel sea : stdetlst){
				sem.setBranchid(sea.getBranchid());
				sem.setClassid(sea.getClassid());
				sem.setLocationid(sea.getLocationid());
				sem.setSectionid(sea.getSectionid());
			}
			
			int aldycunt=adminuserservice.getAlredyStudentCount(stuid,exname);
			if(aldycunt==0){
			for(StudentExamAssignModel pap:qustlst ){
				
				pap.setClassid(sem.getClassid());
				pap.setSectionid(sem.getSectionid());
				pap.setLocationid(sem.getLocationid());
			    pap.setBranchid(sem.getBranchid());	
				insertexm=adminuserservice.insertIntoTempHistory(pap,stuid,exname);
			}
			}else{
				
				emsg="Student Already Added";
			}
		}
		if (insertexm > 0) {
			msg = "Student Added Successfully";

		}

		
		model.addAttribute("sem", sem);
		model.addAttribute("smsg", msg);
		model.addAttribute("emsg", emsg);
		logger.info(end);
		return "forward:/load-studentAssign";
		
	}
}
