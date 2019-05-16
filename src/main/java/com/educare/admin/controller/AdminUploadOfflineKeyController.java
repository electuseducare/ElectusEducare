package com.educare.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.educare.DatabaseValueController;
import com.educare.admin.model.AdminAddNewStudent;
import com.educare.admin.model.AdminCategory;
import com.educare.admin.model.AdminEditStudentFormPojo;
import com.educare.admin.model.Adminofflinedatapojo;
import com.educare.controller.LoginController;
import com.educare.services.AdminRegisterServiceImpl;

@Controller
public class AdminUploadOfflineKeyController {
	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;

	String sidval = "student_id";
	String redirecturl = "redirect:/process-successUploadKeys";
	String finalmsg = "You haven't selected Questions From drop-down value. Please enter valid data to submit answer key!";

	@RequestMapping("/load-uploadKeyFile")
	public String uploadKeyFilefromadmin(Model model, Adminofflinedatapojo adc, HttpSession ses,HttpServletRequest req) {

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";

		List<AdminCategory> examtypeslist = adminuserservice.searchexamtypesFromAdmin();
		List<AdminCategory> classnames = adminuserservice.searchClassesFromAdmin();
		List<AdminCategory> questiontype = adminuserservice.searchQuestiontypeFromAdmin();

		model.addAttribute("classnames", classnames);
		model.addAttribute("examtypeslist", examtypeslist);
		model.addAttribute("questiontype", questiontype);

		model.addAttribute("dataval", adc);
		return "uploadOflinekey";
	}

	@RequestMapping("/loadKeyFilebyexcel")
	public String loadsampleBulkFile(Model model, Adminofflinedatapojo ad, HttpServletRequest req, HttpSession ses) {
		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		model.addAttribute("reg", ad);
		return "loadsampleKeyFilebyexcel";
	}

	@RequestMapping("/offlineKeyExcelFormat")
	public String offlineKeyExcelFormat(Model model, HttpServletRequest req, HttpSession ses) {
		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		model.addAttribute("emsg", model.asMap().get("emsg"));
		model.addAttribute("msg", model.asMap().get("msg"));
		return "offlineExcelKeyPage";
	}

	@RequestMapping("/load-uploadKeyFileBySystemOrExcel")
	public String uploadKeyFilefromSystemOrExcel(Model model, HttpSession ses,HttpServletRequest req) {
		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";

		return "uploadOflinekeyBySysOrExcel";
	}

	@RequestMapping("/load-uploadKeyFilebyexcel")
	public String loadKeyFilefromExcelForm(Model model, HttpSession ses, Adminofflinedatapojo adc,HttpServletRequest req) {
		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		List<AdminCategory> examtypeslist = adminuserservice.searchexamtypesFromAdmin();
		List<AdminCategory> classnames = adminuserservice.searchClassesFromAdmin();
		List<AdminCategory> classsubjlist = adminuserservice.searchSubjectFromAdmin();
		List<AdminCategory> qtypelist = adminuserservice.searchQuestiontypeFromAdmin();

		model.addAttribute("classnames", classnames);
		model.addAttribute("examtypeslist", examtypeslist);
		model.addAttribute("classsubjlist", classsubjlist);
		model.addAttribute("qtypelist", qtypelist);
		model.addAttribute("keyval", adc);
		return "uploadOflinekeyByExcel";
	}

	@RequestMapping("/processExcelKeyData")
	public String uploadKeyFilefromExcelData(Model model, @RequestParam("excelfile2007") MultipartFile excelfile,
			RedirectAttributes ra, HttpSession ses, Adminofflinedatapojo adc,HttpServletRequest req) {
		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		String examname = adc.getExamname();
		if (examname != null) {
			examname = examname.toUpperCase().trim();
		}
		String examtypeid = adc.getExamtypeselectbox();
		String classid = adc.getClassname();
		int numberofqns = adc.getTotalquestions();
		int totalkeys = 0;
		try {
			List<Adminofflinedatapojo> lstUser = new ArrayList<>();
			int i = 0;
			int startwithrow = 0;
			// Creates a workbook object from the uploaded excelfile
			XSSFWorkbook workbook = new XSSFWorkbook(excelfile.getInputStream());
			// Creates a worksheet object representing the first sheet
			XSSFSheet worksheet = workbook.getSheetAt(0);
			// Reads the data in excel file until last row is encountered
			DataFormatter formatter = new DataFormatter();
			Cell cell = null;
			while (i <= numberofqns) {
				// Creates an object for the UserInfo Model
				Adminofflinedatapojo keydata = new Adminofflinedatapojo();
				// Creates an object representing a single row in excel
				XSSFRow row = worksheet.getRow(i++);
				// Sets the Read data to the model class
				if (startwithrow > 0) {

					cell = row.getCell(0);
					keydata.setQnid(formatter.formatCellValue(cell));
					if (keydata.getQnid() != null) {
						keydata.setQnid(formatter.formatCellValue(cell).trim());
					}
					cell = row.getCell(1);
					keydata.setSelected_answer(formatter.formatCellValue(cell));
					if (keydata.getSelected_answer() != null) {
						keydata.setSelected_answer(formatter.formatCellValue(cell));
					}

					cell = row.getCell(2);
					keydata.setSubjectid(formatter.formatCellValue(cell));
					if (keydata.getSubjectid() != null) {
						keydata.setSubjectid(formatter.formatCellValue(cell));
					}

					cell = row.getCell(3);
					keydata.setQuestiontypeid(formatter.formatCellValue(cell));
					if (keydata.getQuestiontypeid() != null) {
						keydata.setQuestiontypeid(formatter.formatCellValue(cell));
					}

					cell = row.getCell(4);
					keydata.setMarksperqn(formatter.formatCellValue(cell));
					if (keydata.getMarksperqn() != null) {
						keydata.setMarksperqn(formatter.formatCellValue(cell));
					}

					cell = row.getCell(5);
					keydata.setNegamarksperqn(formatter.formatCellValue(cell));
					if (keydata.getNegamarksperqn() != null) {
						keydata.setNegamarksperqn(formatter.formatCellValue(cell));
					}

					int insertcount = adminuserservice.insertOfflineKeyFromExcel(examname, examtypeid, classid,
							numberofqns, keydata);
					if (insertcount > 0) {
						totalkeys++;
					}
					// persist data into database in here
					lstUser.add(keydata);
				}
				startwithrow++;

			}
			workbook.close();

			model.addAttribute("lstUser", lstUser);
		} catch (Exception e) {

		}
		int totalmarks = adminuserservice.getTotalmarksFromExamOffline(examname);
		adminuserservice.updateTotalmarksFrommExamOffline(examname, totalmarks);
		List<Adminofflinedatapojo> subjlist = adminuserservice.getSubjectidsFromExamOffline(examname);
		for (Adminofflinedatapojo ado : subjlist) {
			String subjectids = ado.getSubjectid();
			int subjtotalques = adminuserservice.getSubjectTotalqusOffline(examname, examtypeid, subjectids);
			adminuserservice.updateSubjectTotalQusfromExamOffline(examname, subjectids, subjtotalques);
			List<Adminofflinedatapojo> qtypelist = adminuserservice.getQntypeidFromExamOffline(examname, subjectids);
			for (Adminofflinedatapojo adq : qtypelist) {
				String quntypeid = adq.getQuestiontypeid();
				int numofqusperQustype = adminuserservice.getnumofQusperqunstype(examname, examtypeid, subjectids,
						quntypeid);
				adminuserservice.updateNumofquestionperQustype(examname, subjectids, quntypeid, numofqusperQustype);
				int qustypetotalmarks = adminuserservice.getQustypetotalmarks(examname, examtypeid, subjectids,
						quntypeid);
				adminuserservice.updateQuestypeToatlamarks(examname, subjectids, quntypeid, qustypetotalmarks);
			}
		}

		String msg = totalkeys + ":Excell keys uploaded successfully.";
		ra.addFlashAttribute("msg", msg);
		model.addAttribute("keyval", adc);
		return redirecturl;
	}

	@ResponseBody
	@RequestMapping("/verify-examnamealreadyExistsforofflinekey")
	public void getExamnameforOffline(Model model, AdminAddNewStudent adc, AdminEditStudentFormPojo editpojo,
			HttpSession ses, HttpServletRequest req, HttpServletResponse response) {

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		String examnamevalue = req.getParameter("examnamevalue");
		examnamevalue = examnamevalue.trim();
		examnamevalue = examnamevalue.toLowerCase();
		String examName = null;

		List<Map<String, Object>> getotbfromdb = adminuserservice.validateExamnameforofflinekey(examnamevalue);

		if (!getotbfromdb.isEmpty()) {
			for (Map<String, Object> map : getotbfromdb) {
				examName = (String) map.get("exam_name");
				examName = examName.toLowerCase();
			}
		}

		if (examnamevalue != null) {
		} else {

			try {
				response.getWriter().write("Please enter valid exam name");
			} catch (IOException e) {

			}

		}
		if (examnamevalue.equals(examName)) {
			try {
				response.getWriter().write("Exam name already exists. Please try with other name");
			} catch (IOException e) {

			}

		}

		else {
			try {
				response.getWriter().write("Entered exam name is valid");
			} catch (IOException e) {

			}
		}
	}

	@RequestMapping("/processOmrKeyData")
	public String uploadKeyValuesFromExcel(Model model, Adminofflinedatapojo adc, HttpSession ses,
			HttpServletRequest req, RedirectAttributes ra, @RequestParam("excelfile2007") MultipartFile excelfile)
			throws IOException {
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";

		String examname = adc.getExamname().trim().toUpperCase();
		String examtypeid = adc.getExamtypeselectbox();
		String classid = adc.getClassname();
		String subjectid = adc.getSubjectname();
		int totalquestions = adc.getTotalquestions();
		String[] spltsubjid = subjectid.split(",");
		/**
		 * Split For Subject ID: AND GET 1. No.of Questions Per Subject 2.
		 * Questions From - Questions To
		 **/
		int totalkeys = 0;
		for (int i = 0; i < spltsubjid.length; i++) {
			String subjid = spltsubjid[i];
			String numberofQnsPerSubj = req.getParameter("noofqns_" + subjid);

			String questiontype = adc.getQntypes();
			String[] spltqntype = questiontype.split(",");
			/**
			 * Split For Question Type ID: AND GET 1. No.of Questions Per
			 * Question Type 2. Marks Per Question Type 3. Negative Marks Per
			 * Question Type 4. Questions From - Questions To
			 **/
			for (int k = 0; k < spltqntype.length; k++) {
				String emsg = null;
				String qntypeid = spltqntype[k];
				String qnsPerQntype = req.getParameter(subjid + "_" + qntypeid);
				int qnsPerQntype1 = (new Integer(qnsPerQntype)).intValue();
				String marksPerQntype = req.getParameter(subjid + "_marks_" + qntypeid);
				int marksPerQntype1 = (new Integer(marksPerQntype)).intValue();
				String negPerQntype = req.getParameter(subjid + "_negmarks_" + qntypeid);

				String qtypeFrom = req.getParameter(subjid + "questionsfrom" + qntypeid);
				int qtypeFrom1 = 0;
				if (qtypeFrom != null) {
					qtypeFrom1 = Integer.valueOf(qtypeFrom);
				} else {
					emsg = finalmsg;
					ra.addFlashAttribute("emsg", emsg);
					adminuserservice.deleteOfflineInvalidKeyEntries(examname);
					return redirecturl;
				}

				if (qtypeFrom1 == 0) {
					emsg = finalmsg;
					ra.addFlashAttribute("emsg", emsg);
					adminuserservice.deleteOfflineInvalidKeyEntries(examname);
					return redirecturl;
				}

				String qtypeTo = req.getParameter(subjid + "questionsto" + qntypeid);
				int qtypeTo1 = 0;
				if (qtypeTo != null) {
					qtypeTo1 = Integer.valueOf(qtypeTo);
				} else {
					emsg = finalmsg;
					ra.addFlashAttribute("emsg", emsg);
					adminuserservice.deleteOfflineInvalidKeyEntries(examname);
					return redirecturl;
				}

				if (qtypeTo1 == 0) {
					emsg = finalmsg;
					model.addAttribute("emsg", emsg);
					adminuserservice.deleteOfflineInvalidKeyEntries(examname);
					return redirecturl;
				}

				// Creates a workbook object from the uploaded excelfile
				XSSFWorkbook workbook = new XSSFWorkbook(excelfile.getInputStream());
				// Creates a worksheet object representing the first sheet
				XSSFSheet worksheet = workbook.getSheetAt(0);
				// Reads the data in excel file until last row is encountered
				DataFormatter formatter = new DataFormatter();
				Cell cell = null;
				XSSFRow row = worksheet.getRow(1);

				/** Assign Question Type ID - Question From to Question To **/
				for (int l = qtypeFrom1; l <= qtypeTo1; l++) {
					int totalmarksperQntype = qnsPerQntype1 * marksPerQntype1;
					int totalmarks = adc.getTotalmarks();

					int questionid = l;
					l--;
					cell = row.getCell(l);
					String keyvalues = formatter.formatCellValue(cell);
					if (!keyvalues.isEmpty()) {
						keyvalues = keyvalues;
					} else {
						keyvalues = "0";
					}
					l++;

					int totalkeys1 = adminuserservice.insertOfflineKey(examname, classid, subjid, examtypeid,
							questionid, keyvalues, numberofQnsPerSubj, qntypeid, qnsPerQntype1, marksPerQntype1,
							negPerQntype, totalmarksperQntype, totalquestions, totalmarks);
					if (totalkeys1 > 0) {
						totalkeys++;
					}

				}
				workbook.close();

			}

		}

		String msg = totalkeys + ": keys uploaded successfully.";
		ra.addFlashAttribute("msg", msg);
		return redirecturl;

	}

	@RequestMapping("/process-successUploadKeys")
	public String redirectsuccesskeys(Model model, HttpServletRequest req, HttpSession ses) {
		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		model.addAttribute("emsg", model.asMap().get("emsg"));
		model.addAttribute("msg", model.asMap().get("msg"));
		return "successUploadKeys";
	}

}
