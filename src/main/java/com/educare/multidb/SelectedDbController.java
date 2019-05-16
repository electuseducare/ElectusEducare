package com.educare.multidb;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.educare.admin.model.AdminUploadClientLogoModel;
import com.educare.model.LoginPojo;
import com.educare.scheduler.DeleteExamPapersController;
import com.educare.services.AdminRegisterServiceImpl;

@Controller
public class SelectedDbController {

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;
	
	@Autowired
	private DeleteExamPapersController ec;

	@Value("${school1.name}")
	String school1;
	@Value("${school2.name}")
	String school2;
	@Value("${school3.name}")
	String school3;
	@Value("${school4.name}")
	String school4;
	@Value("${school5.name}")
	String school5;
	@Value("${school6.name}")
	String school6;
	@Value("${school7.name}")
	String school7;
	@Value("${school8.name}")
	String school8;
	@Value("${school9.name}")
	String school9;
	@Value("${school10.name}")
	String school10;

	@RequestMapping(value = "/selectSchool", method = RequestMethod.GET)
	public String publisher(Model model, HttpServletRequest req, LoginPojo form, HttpSession sess
			) throws SQLException {
		String school = req.getParameter("selectschool");

		model.addAttribute("form", form);
		sess.setAttribute("school1", school);

		sess.setAttribute("keyDS", school);
		String clientlogo = adminuserservice.getClientLogoBasedOnSchoolId(school);
		sess.setAttribute("clientlogo1", clientlogo);

		List<AdminUploadClientLogoModel> getcarousel = adminuserservice.getClientCarouselBasedOnSchool(school);
		model.addAttribute("getcarousel", getcarousel);
		List<AdminUploadClientLogoModel> getExstContactDet = adminuserservice.getExistingCountFromClientContactDetTb(school);
		
		model.addAttribute("getdet", getExstContactDet);

		String getschool = getSchhoNameFromSession(school);
		sess.setAttribute("getschool", getschool);

		model.addAttribute("clientlogo", clientlogo);
		
		/**** Deleting previous Exam papers before current date ****/
		ec.deleteExam();
		
		return "UserHome1";
	}

	public String getSchhoNameFromSession(String schoolvalue) {
		String schoolname = "";
		switch (schoolvalue) {
		case "1":
			schoolname = school1;
			break;
		case "2":
			schoolname = school2;
			break;
		case "3":
			schoolname = school3;
			break;
		case "4":
			schoolname = school4;
			break;
		case "5":
			schoolname = school5;
			break;
		case "6":
			schoolname = school6;
			break;
		case "7":
			schoolname = school7;
			break;
		case "8":
			schoolname = school8;
			break;
		case "9":
			schoolname = school9;
			break;
		case "10":
			schoolname = school10;
			break;
		default:
			break;
		}

		return schoolname;
	}

	@RequestMapping(value = "/viewClientimage", method = RequestMethod.GET)
	public void viewClientLogo(HttpServletResponse response, HttpServletRequest request, HttpSession ses)
			throws IOException {

		String school = (String) ses.getAttribute("school1");
		String getschool = getSchhoNameFromSession(school);

		String imageName = request.getParameter("imageID");
		File file = null;
		String rootPath = System.getProperty("catalina.home");

		File dir = new File(rootPath + File.separator + "Electus_Intranet" + File.separator + "Client_Logo"
				+ File.separator + getschool);
		file = new File(dir + File.separator + imageName);
		if (!file.exists()) {
			if (!file.exists()) {
				String errorMessage = "";

				OutputStream outputStream = response.getOutputStream();
				outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
				outputStream.close();
				return;
			}

		}

		String mimeType = URLConnection.guessContentTypeFromName(file.getName());

		if (mimeType == null) {
			mimeType = "application/octet-stream";
		}

		response.setContentType(mimeType);

		response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));

		response.setContentLength((int) file.length());

		InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

		FileCopyUtils.copy(inputStream, response.getOutputStream());
	}

	@RequestMapping(value = "/viewClientCarousel", method = RequestMethod.GET)
	public void viewWebSiteImageDetails(HttpServletResponse response, HttpSession ses, HttpServletRequest request)
			throws IOException {
		String imageName = request.getParameter("imageID");
		File file = null;

		String school = (String) ses.getAttribute("school1");

		String getschool = getSchhoNameFromSession(school);

		String rootPath = System.getProperty("catalina.home");

		File dir = new File(rootPath + File.separator + "Electus_Intranet" + File.separator + "Client_Carsousel"
				+ File.separator + getschool);

		file = new File(dir + file.separator + imageName);

		if (!file.exists()) {

			file = new File(request.getRealPath("theme") + "/img/about-mission.jpg");
			if (!file.exists()) {
				String errorMessage = "No Image";

				OutputStream outputStream = response.getOutputStream();
				outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
				outputStream.close();
				return;
			}

		}

		String mimeType = URLConnection.guessContentTypeFromName(file.getName());

		if (mimeType == null) {

			mimeType = "application/octet-stream";
		}

		response.setContentType(mimeType);

		response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));

		response.setContentLength((int) file.length());

		InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

		FileCopyUtils.copy(inputStream, response.getOutputStream());
	}

}
