package com.educare.admin.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.StringJoiner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.educare.DatabaseValueController;
import com.educare.admin.model.AdminUploadClientLogoModel;
import com.educare.controller.LoginController;
import com.educare.multidb.SelectedDbController;
import com.educare.services.AdminRegisterServiceImpl;

@Controller
public class AdminUploadClientCarouselController {
	
	@Autowired
	AdminRegisterServiceImpl adminuserservice;
	
	@Autowired
	private LoginController lc;
	
	@Autowired
	private SelectedDbController schoolname;
	
	@Autowired
	private DatabaseValueController dv;
	
	@Value("${school1.id}")
	String schoolid;

	@RequestMapping("/load-uploadClientCarousel")
	public String adminUploadClientlogoview(Model model, HttpSession ses, AdminUploadClientLogoModel getcar,HttpServletRequest req) {
		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		model.addAttribute("getlogo", getcar);
		return "adminUploadClientCarousel";
	}

	@RequestMapping("/load-insertclientcarousel")
	public String adminUploadClientLogo(HttpSession ses, Model model,
			@RequestParam(value = "clientlogo") MultipartFile[] photo, RedirectAttributes ra,
			AdminUploadClientLogoModel getlogo,HttpServletRequest req) {
		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		String logo = null;
		String smsg = null;
		String emsg = null;
		int insert = 0;

		int getmaxrowid = adminuserservice.getMaxRowIdFromClientCarousel();
		String getmaxrowid1 = "0";
		if (getmaxrowid >= 0) {
			getmaxrowid = getmaxrowid + 1;
			getmaxrowid1 = String.valueOf(getmaxrowid);
		}
		String filepathname = getmaxrowid1;

		/************* Upload Client Logo ****************/

		String school = (String) ses.getAttribute("school1");
		String getschool = schoolname.getSchhoNameFromSession(school);

		logo = adminUploadClientCarousel(photo, filepathname, getschool);
		getlogo.setCarousel(logo);
		getlogo.setSchoolid(Integer.valueOf(school));
		insert = adminuserservice.getInsertClientCarousel(getlogo);

		if (insert > 0) {
			smsg = " Image Uploaded Successfully";
			emsg = null;
		}

		else {
			emsg = " Image not Uploaded Successfully";
			smsg = null;
		}
		ra.addFlashAttribute("smsg", smsg);
		ra.addFlashAttribute("emsg", emsg);
		return "redirect:/load-uploadClientCarousel";
	}

	/**************** Upload Client Carousel **********/

	public String adminUploadClientCarousel(MultipartFile[] files, String filepathname, String getschool) {
		String screenshots = null;
		String filenameval = null;
		int i = 1;
		StringJoiner jn = new StringJoiner(",");
		for (MultipartFile aFile : files) {
			if (aFile.getSize() > 0) {
				try {
					byte[] bytes = aFile.getBytes();
					// Creating the directory to store file
					String rootPath = System.getProperty("catalina.home");
					File dir = new File(rootPath + File.separator + "Electus_Intranet" + File.separator
							+ "Client_Carsousel" + File.separator + getschool);
					filenameval = "" + filepathname + "_" + i;
					if (!dir.exists())
						dir.mkdirs();
					String prefix = aFile.getOriginalFilename().substring(aFile.getOriginalFilename().lastIndexOf('.'),
							aFile.getOriginalFilename().length());
					// Create the file on server
					File serverFile = new File(dir.getAbsolutePath() + File.separator + filenameval + prefix);
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
					stream.write(bytes);
					stream.close();
					jn.add(filenameval + prefix);
				} catch (IOException e) {
				}
			}
		}
		screenshots = jn.toString();
		return screenshots;

	}

}
