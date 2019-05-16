package com.educare.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.educare.DatabaseValueController;
import com.educare.admin.model.AdminUploadClientLogoModel;
import com.educare.controller.LoginController;
import com.educare.services.AdminRegisterServiceImpl;

@Controller
public class AdminAddContactDetailsController {
	
	@Autowired
	AdminRegisterServiceImpl adminuserservice;
	
	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;
	
	@Value("${school1.id}")
	String schoolid;

	@RequestMapping("/load-addContactdet")
	public String adminAddContactDeatils(Model model, HttpSession ses, AdminUploadClientLogoModel addcontact,HttpServletRequest req) {
		
		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";

		model.addAttribute("addcontact", addcontact);
		String school = (String) ses.getAttribute("school1");
		List<AdminUploadClientLogoModel> getExstContactDet = adminuserservice
				.getExistingCountFromClientContactDetTb(school);
		if (!(getExstContactDet.isEmpty())) {
			getExstContactDet.forEach(rs -> {
				addcontact.setContactid(rs.getContactid());
				addcontact.setContactinfo(rs.getContactinfo());
				addcontact.setEmailid(rs.getEmailid());
				addcontact.setAddress(rs.getAddress());
			});
		}
		return "adminAddContactDeatils";
	}

	@RequestMapping("/process-contactform")
	public String adminInsertContactDet(Model model, HttpSession ses, AdminUploadClientLogoModel insertcont,
			RedirectAttributes ra,HttpServletRequest req) {
		
		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";

		String smsg = null;
		String emsg = null;
		int updatecontctdet = 0;
		int insertcontctdet = 0;

		String school = (String) ses.getAttribute("school1");
		insertcont.setSchoolid(Integer.parseInt(school));

		List<AdminUploadClientLogoModel> getExstContactDet = adminuserservice
				.getExistingCountFromClientContactDetTb(school);
		if (!(getExstContactDet.isEmpty())) {
			getExstContactDet.forEach(rs -> {
				insertcont.setContactid(rs.getContactid());

			});
			updatecontctdet = adminuserservice.getUpdateContactDet(insertcont);
		} else {
			insertcontctdet = adminuserservice.getInsertContactDet(insertcont);
		}

		if (insertcontctdet > 0 || updatecontctdet > 0) {
			smsg = " Contact Deatils Added Successfully";
			emsg = null;
		}

		else {
			emsg = "  Contact Deatils Not  Added  Successfully";
			smsg = null;
		}

		ra.addFlashAttribute("smsg", smsg);
		ra.addFlashAttribute("emsg", emsg);
		return "redirect:/load-addContactdet";

	}

}
