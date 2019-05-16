package com.educare.admin.sms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.educare.DatabaseValueController;
import com.educare.admin.model.AdminCategory;
import com.educare.controller.LoginController;
import com.educare.services.AdminRegisterServiceImpl;

@Controller
public class AdminViewSendSmsSearchController {
	private static final Logger logger = LoggerFactory.getLogger(AdminViewSendSmsSearchController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private LoginController lc;

	@Autowired
	private DatabaseValueController dv;

	String sidval = "student_id";
	String smsval = "smssearch";
	String retrunjspval = "sms/adminViewSearch";

	@RequestMapping("/load-viewSmsSearch")
	private String viewSmsSearchScreen(Model model, HttpSession ses, AdminCategory ac, HttpServletRequest req) {
		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);

		/**** return default database value *****/
		String dbval = dv.getDatabaseValue(ses, req);
		if (dbval.equals("0"))
			return "defaultDatabaseErrorPage";

		model.addAttribute(smsval, ac);

		List<AdminCategory> statenames = adminuserservice.searchStateFromAdmin();
		List<AdminCategory> classnames = adminuserservice.searchClassesFromAdmin();

		model.addAttribute("statenames", statenames);
		model.addAttribute("classnames", classnames);
		model.addAttribute("smsg", req.getParameter("smsg"));

		return retrunjspval;

	}

	@RequestMapping("/load-locationsformForStudSMS")
	public String loadLocationsFromStatesForSMS(Model model, AdminCategory ac, HttpSession ses,
			HttpServletRequest req) {

		String start = "Entry of loadLocationsFromStatesForSMS method....";
		String end = "End of loadLocationsFromStatesForSMS method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		model.addAttribute(smsval, ac);
		String stateid = req.getParameter("stateid");
		List<AdminCategory> location = adminuserservice.searchLocationsFromAdminBasedonStates(stateid);

		model.addAttribute("location", location);

		logger.info(end);

		return retrunjspval;
	}

	@RequestMapping("/load-BranchformForStudSMS")
	public String loadBranchFromLocationsForSMS(Model model, AdminCategory ac, HttpSession ses,
			HttpServletRequest req) {

		String start = "Entry of loadBranchFromLocationsForSMS method....";
		String end = "End of loadBranchFromLocationsForSMS method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		model.addAttribute(smsval, ac);
		String locationid = req.getParameter("locationid");
		List<AdminCategory> branch = adminuserservice.searchBranchesFromAdminBasedonLocation(locationid);

		model.addAttribute("branch", branch);

		logger.info(end);

		return retrunjspval;
	}

	@RequestMapping("/get-sectiondetailsfromClassForStudSMS")
	public String loadSectionsFromClassesForEstStuForSMS(Model model, AdminCategory ac, HttpSession ses,
			HttpServletRequest req) {

		String start = "Entry of loadSectionsFromClassesForEstStuForSMS method....";
		String end = "End of loadSectionsFromClassesForEstStuForSMS method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		model.addAttribute(smsval, ac);
		String classids = req.getParameter("classid");
		if (classids != null) {
			int classid = (new Integer(classids)).intValue();
			List<AdminCategory> sectiondetails = adminuserservice.getsectionsfromClass(classid);

			model.addAttribute("secitonnameval", sectiondetails);

		}
		logger.info(end);

		return retrunjspval;
	}

	@RequestMapping("/get-examdetailsfromResultsForStudSMS")
	public String examdetailsfromResultsForStudSMS(Model model, AdminCategory ac, HttpSession ses,
			HttpServletRequest req) {

		String start = "Entry of examdetailsfromResultsForStudSMS method....";
		String end = "End of examdetailsfromResultsForStudSMS method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		model.addAttribute(smsval, ac);
		String classids = req.getParameter("classid");
		String sectionids = req.getParameter("sectionid");
		String campusids = req.getParameter("campus");
		String locarionids = req.getParameter("location");
		String stateids = req.getParameter("state");
		if (classids != null && sectionids != null && campusids != null && locarionids != null && stateids != null) {
			int classid = (new Integer(classids)).intValue();
			int sectionid = (new Integer(sectionids)).intValue();
			int campusid = (new Integer(campusids)).intValue();
			int locationid = (new Integer(locarionids)).intValue();
			int stateid = (new Integer(stateids)).intValue();
			List<AdminCategory> examnames = adminuserservice.getExamNameForBulkSms(classid, sectionid, campusid,
					locationid, stateid);

			model.addAttribute("examnames", examnames);

		}
		logger.info(end);

		return retrunjspval;
	}

	@RequestMapping("/Load-ProcessSendBulkSms")
	public String loadprocessBulkSms(Model model, AdminCategory ac, HttpSession ses, HttpServletRequest req) {

		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		String mstype = ac.getSmstype();
		String smsg = "";
		if (mstype.equals("resultsms")) {

			List<AdminCategory> getresultsdata = adminuserservice.getAllstudentResultsForBulkSms(ac);

			for (AdminCategory adminCategory : getresultsdata) {
				List<AdminCategory> getscremarksdetail = adminuserservice
						.getAllScoredmarksForBulkUpdate(adminCategory.getStudentid(), ac.getExamname());
				int sizeavail = getscremarksdetail.size();
				String temp = "";
				if (sizeavail > 0) {

					for (AdminCategory adminCategory2 : getscremarksdetail) {
						temp = temp + adminCategory2.getSubjectname() + ":" + adminCategory2.getScoredmarks();
					}
				} else {
					temp = "Absent";
				}

				logger.info("sms:" + adminCategory.getStudentid() + ":" + adminCategory.getFirstname() + "-"
						+ adminCategory.getMobile() + "-" + temp);
			}

		} else {
			List<AdminCategory> getuserdetails = adminuserservice.getAllUserDetailsTosentSms(ac);
			String mobileno = "";
			String firstname = "";
			String studentid = "";
			String messagedesc = "";
			for (AdminCategory adminCategory : getuserdetails) {
				studentid = adminCategory.getStudentid();
				mobileno = adminCategory.getMobile();
				firstname = adminCategory.getFirstname();
				messagedesc = ac.getSmsdescription();

				logger.info("Normal sms:" + studentid + "-" + mobileno + "-" + firstname + "-" + messagedesc);

			}

		}

		smsg = "Messages Sent Successfully";
		model.addAttribute("smsg", smsg);

		return "redirect:/load-viewSmsSearch";
	}

}
