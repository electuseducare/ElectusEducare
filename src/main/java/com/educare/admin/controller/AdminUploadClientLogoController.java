package com.educare.admin.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
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
public class AdminUploadClientLogoController {

	@Autowired
	AdminRegisterServiceImpl adminuserservice;
	
	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;
	
	@Autowired
	private SelectedDbController schoolname;
	
	@Value("${school1.id}")
	String schoolid;

	@RequestMapping("/load-uploadClientlogo")
	public String adminUploadClientlogoview(Model model, HttpSession ses, AdminUploadClientLogoModel getlogo,HttpServletRequest req) {
		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";

		return "adminUploadClientLogo";
	}

	@RequestMapping("/load-insertclientlogo")
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
		String msg = null;
		String emsg = null;
		int updateclintlg = 0;
		int insert = 0;
		/************* Upload Client Logo ****************/

		String school = (String) ses.getAttribute("school1");
		String getschool = schoolname.getSchhoNameFromSession(school);
		List<Map<String, Object>> getclsize = adminuserservice.getClientlogoTblSize(school);

		if (!(getclsize.isEmpty())) {
			updateclintlg = adminuserservice.getUpdateClientLogo(getlogo);
			logo = adminUploadClientlogo(photo, getschool);
		} else {
			logo = adminUploadClientlogo(photo, getschool);
			getlogo.setLogo(logo);
			getlogo.setSchoolid(Integer.valueOf(school));
			insert = adminuserservice.getInsertClientLogo(getlogo);
		}

		if (insert > 0 || updateclintlg >0) {
			emsg = " Logo Uploaded Successfully";
			msg = null;
		}

		else {
			emsg = " Logo Uploaded Successfully";
			msg = null;
		}
		ra.addFlashAttribute("msg", msg);
		ra.addFlashAttribute("emsg", emsg);
		return "redirect:/load-uploadClientlogo";
	}

	/**************** Upload Client Logo **********/

	public String adminUploadClientlogo(MultipartFile[] files, String getschool) {
		String screenshots = null;
		String filenameval = null;
		StringJoiner jn = new StringJoiner(",");
		for (MultipartFile aFile : files) {
			if (aFile.getSize() > 0) {
				try {
					byte[] bytes = aFile.getBytes();
					// Creating the directory to store file
					String rootPath = System.getProperty("catalina.home");
					File dir = new File(rootPath + File.separator + "Electus_Intranet" + File.separator + "Client_Logo"
							+ File.separator + getschool);
					filenameval = "" + schoolid;
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
