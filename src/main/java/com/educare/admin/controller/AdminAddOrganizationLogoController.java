package com.educare.admin.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.educare.DatabaseValueController;
import com.educare.admin.model.AdminAddOrganizationLogoModel;
import com.educare.controller.LoginController;
import com.educare.services.AdminRegisterServiceImpl;

import org.slf4j.Logger;

@Controller
public class AdminAddOrganizationLogoController {

	private static final Logger logger = LoggerFactory.getLogger(AdminAddOrganizationLogoController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;

	@RequestMapping("/load-uploadorglogo")
	public String displayOrganizationsLogo(Model model, HttpSession ses, AdminAddOrganizationLogoModel orglogo,HttpServletRequest req) {

		String start = "Entry of displayOrganizationsLogo method....";
		String end = "End of displayOrganizationsLogo method....";
		logger.info(start);

		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		model.addAttribute("orglogo", orglogo);

		logger.info(end);

		return "AdminAddOrganizationLogo";

	}

	@RequestMapping(value = "/load-insertorglogo")
	private String uploadOrgLogo(Model model, HttpSession ses, AdminAddOrganizationLogoModel orglogo,
			@RequestParam("uploadlogo") MultipartFile files, HttpServletRequest req) throws IOException {
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		int getmaxrowid = adminuserservice.getMaxRowIdFromLogo();

		if (getmaxrowid >= 0) {
			getmaxrowid = getmaxrowid + 1;
		}

		String filename = null;
		String smsg = null;
		String emsg = null;
		MultipartFile aFile = files;
		String prefix = null;

		if (aFile.getSize() > 0) {
			byte[] bytes = aFile.getBytes();
			// Creating the directory to store file
			String rootPath = System.getProperty("catalina.home");
			File dir = new File(rootPath + File.separator + "Organizationlogo");
			if (!dir.exists())
				dir.mkdirs();
			prefix = aFile.getOriginalFilename().substring(aFile.getOriginalFilename().lastIndexOf('.'),
					aFile.getOriginalFilename().length());
			// Create the file on server
			File serverFile = new File(dir.getAbsolutePath() + File.separator + getmaxrowid + prefix);
			filename = "" + getmaxrowid + prefix;
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
			stream.write(bytes);
			stream.close();
		}

		int isinserted = adminuserservice.insertOrganization(orglogo, filename);
		if (isinserted > 0) {
			smsg = "Logo successfully inserted.";
			emsg = "";
		} else {
			emsg = "Logo not inserted successfully. Please try again.";
			smsg = "";
		}
		model.addAttribute("smsg", smsg);
		model.addAttribute("emsg", emsg);

		return "redirect:/redirect-addOrglogo";
	}

	@RequestMapping(value = "/redirect-addOrglogo")
	private String testimonialSuccessRedirect(Model model, HttpServletRequest req, HttpSession ses) {
		
		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";

		String smsg = req.getParameter("smsg");
		String emsg = req.getParameter("smsg");
		model.addAttribute("smsg", smsg);
		model.addAttribute("smsg", emsg);
		return "successAdminAddOrganizationLogo";
	}

}
