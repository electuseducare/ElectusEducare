package com.educare.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.educare.DatabaseValueController;
import com.educare.admin.model.AdminUploadClientLogoModel;
import com.educare.controller.LoginController;
import com.educare.services.AdminRegisterServiceImpl;

@Controller
public class AdminDeleteClientCarouselController {

	@Autowired
	AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;
	
	@Value("${school1.id}")
	String schoolid;

	@RequestMapping("/load-deleteClientCarousel")
	public String adminDeleteClientCarouselview(Model model, HttpSession ses, HttpServletRequest req,
			AdminUploadClientLogoModel getcar) {
		
		String studentid = (String) ses.getAttribute("student_id");
		String school = (String) ses.getAttribute("school1");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		int buttonid = 0;
		List<AdminUploadClientLogoModel> listval = adminuserservice.getClientCarouselBasedOnSchool(school);
		if (!listval.isEmpty()) {
			buttonid = 1;
		}
		getcar.setCarousellist(listval);
		model.addAttribute("getcarousel", listval);
		model.addAttribute("buttonid", buttonid);
		model.addAttribute("deletelistvalue", getcar);

		return "adminDeleteClientCarousel";
	}

	@RequestMapping("/process-deleteclientcarousel")
	public String loadprocessdeletecategory(Model model, HttpServletRequest req, AdminUploadClientLogoModel delcaros,
			HttpSession ses) {
		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		String carouselid = null;
		String msg = null;
		String smsg = null;
		int buttonid = 1;
		int update = 0;

		carouselid = req.getParameter("carouselid");
		if (carouselid != null) {
			update = adminuserservice.deleteCarouselImage(carouselid);
			if (update > 0) {
				update++;
			}
		}

		if (update > 0) {
			smsg = "Carousel deleted successfully";
			msg = null;
		} else {
			msg = "Carousel  not deleted successfully";
		}

		model.addAttribute("smsg", smsg);
		model.addAttribute("emsg", msg);
		model.addAttribute("buttonid", buttonid);
		model.addAttribute("categorylistvalue", delcaros);

		return "forward:/load-deleteClientCarousel";
	}

}
