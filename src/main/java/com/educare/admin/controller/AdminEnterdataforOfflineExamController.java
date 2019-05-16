package com.educare.admin.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.educare.DatabaseValueController;
import com.educare.admin.model.AdminEditStudentFormPojo;
import com.educare.admin.model.Adminofflinedatapojo;
import com.educare.controller.LoginController;
import com.educare.services.AdminRegisterServiceImpl;

@Controller
public class AdminEnterdataforOfflineExamController {

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private LoginController lc;

	@Autowired
	private DatabaseValueController dv;

	@RequestMapping("/load-uploadDatFile")
	public String uploadDatFilefromadmin(Model model, Adminofflinedatapojo adc, AdminEditStudentFormPojo editpojo,
			HttpSession ses, HttpServletRequest req) {

		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);

		/**** return default database value *****/
		String dbval = dv.getDatabaseValue(ses, req);
		if (dbval.equals("0"))
			return "defaultDatabaseErrorPage";

		String isgenerated = "no";
		List<Map<String, Object>> examlist = adminuserservice.getExamnameFromKeyTable(isgenerated);
		List<String> enamelist = new ArrayList<>();
		for (Map<String, Object> map : examlist) {
			String ename = (String) map.get("exam_name");
			enamelist.add(ename);
		}
		model.addAttribute("enamelist", enamelist);

		model.addAttribute("dataval", adc);
		return "uploadOflinedata";
	}

	@RequestMapping("/processOmrData")
	public String processOmrData(Model model, Adminofflinedatapojo adc, AdminEditStudentFormPojo editpojo,
			RedirectAttributes ra, HttpSession ses, HttpServletRequest req,
			@RequestParam("excelfile2007") MultipartFile datfile) throws IOException {
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		MultipartFile docFile = datfile;
		String examname = adc.getExamname();
		File tempFile = new File(docFile.getOriginalFilename());
		docFile.transferTo(tempFile);
		String userid = "";
		String series = "";
		model.addAttribute("dataval", adc);
		String rightanswer = "R";
		String colname1 = "right_answered";
		String wronganswer = "W";
		String colname2 = "not_answered";
		String unattempted = "NA";
		String colname3 = "wrong_answered";
		String firstname = "";
		String answer = "";
		String subjectid = "";
		String offlineKeyid = "";
		int stateid = 0;
		int locationid = 0;
		int branchid = 0;
		int classid = 0;
		int sectionid = 0;
		String studentid = "";
		String[] lines = Files.readAllLines(new File(datfile.getOriginalFilename()).toPath()).toArray(new String[0]);

		int k = 1;
		for (String string : lines) {

			if (string.length() == 11) {
				userid = string.replace("No.=", "");
				List<Adminofflinedatapojo> userdata = adminuserservice.getofflineUserDataBasedonUserName(userid);
				for (Adminofflinedatapojo adminofflinedatapojo : userdata) {
					stateid = adminofflinedatapojo.getStateid();
					locationid = adminofflinedatapojo.getLocationid();
					branchid = adminofflinedatapojo.getBranchid();
					sectionid = adminofflinedatapojo.getSectionid();
					classid = adminofflinedatapojo.getClassid();
					firstname = adminofflinedatapojo.getFirstname();
					studentid = adminofflinedatapojo.getStudentid();
				}

			}
			if (string.length() == 10) {
				series = string;

			}

			if (k != 1) {
				if (string.length() >= 800) {
					int j = 1;
					int l = 1;
					int countforkey = adminuserservice.getcountforOfflinekeys(examname);
					StringJoiner strj = new StringJoiner(",");
					String[] arra = string.split("\\s+");
					for (int i = 0; i < countforkey; i++) {

						String stname = arra[l];
						strj.add(stname);
						List<Map<String, Object>> listval = adminuserservice.getActualOfflineKey(examname, j);
						for (Map<String, Object> map : listval) {
							Object answer1 = map.get("question_key");
							Object subjectval = map.get("el_subject_id");
							Object keyid = map.get("offline_key_id");
							subjectid = subjectval.toString();
							answer = answer1.toString();
							offlineKeyid = keyid.toString();
						}
						if (stname.equals("4")) {
							stname = "3";
						}

						if (stname.equals("8")) {
							stname = "4";
						}

						if (answer.equals(stname)) {
							adminuserservice.insertintoOmrSheetData(examname, studentid, series, j, stname, rightanswer,
									colname1, stateid, locationid, branchid, classid, sectionid, firstname, subjectid,
									offlineKeyid);
						} else if (stname.equals("0")) {
							adminuserservice.insertintoOmrSheetData(examname, studentid, series, j, stname, unattempted,
									colname2, stateid, locationid, branchid, classid, sectionid, firstname, subjectid,
									offlineKeyid);
						} else {
							adminuserservice.insertintoOmrSheetData(examname, studentid, series, j, stname, wronganswer,
									colname3, stateid, locationid, branchid, classid, sectionid, firstname, subjectid,
									offlineKeyid);
						}

						j++;
						l++;
					}
				}
			}
			k++;
			if (k == 3) {
				k = 1;
			}
		}
		String isdatfilegenerated = "yes";
		adminuserservice.updateKeyStatus(examname, isdatfilegenerated);

		String msg = "OMR sheet uploaded successfully.";
		ra.addFlashAttribute("msg", msg);
		return "redirect:/process-successUploadDatfile";

	}

	@RequestMapping("/process-successUploadDatfile")
	public String redirectsuccesskeys(Model model, HttpServletRequest req, HttpSession ses, RedirectAttributes ra) {
		String studentid = (String) ses.getAttribute("student_id");
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		model.addAttribute("emsg", model.asMap().get("emsg"));
		model.addAttribute("msg", model.asMap().get("msg"));
		return "successUploadDatfile";
	}

}
