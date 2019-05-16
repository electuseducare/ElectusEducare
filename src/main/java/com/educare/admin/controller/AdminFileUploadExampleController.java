package com.educare.admin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.educare.DatabaseValueController;
import com.educare.admin.model.AdminFileUploadExampleModel;
import com.educare.controller.LoginController;
import com.educare.model.Register;
import com.educare.services.AdminRegisterServiceImpl;
import com.educare.services.RegisterServiceImpl;
@Controller
public class AdminFileUploadExampleController {
	
	@Autowired
	ServletContext context;
	
	@Autowired
	AdminRegisterServiceImpl adminuserservice;
	
	@Autowired
	private RegisterServiceImpl userservice;
	
	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;
	
	@Value("${session.id}")
	int sessoinid;

	@Value("${status.id}")
	int statusid;
	
	String sidval="student_id";
		
	@RequestMapping(value = "/load-uploaddata", method = RequestMethod.GET)
	public String helloWorld(Model model,HttpSession ses,HttpServletRequest req) {		
		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		return "UploadImage";
	}
	
	@RequestMapping(value = "/excelupload", method = RequestMethod.POST)
	public String processExcel2007(Model model, @RequestParam("excelfile2007") MultipartFile excelfile,HttpSession ses,HttpServletRequest req) {	
		int updateque = 0;
		String emsg="";
		String msg=null;
		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		int successcount=0;
		try {
			List<AdminFileUploadExampleModel> lstUser = new ArrayList<>();
			int i = 0;
			int startwithrow=0;
			// Creates a workbook object from the uploaded excelfile
			XSSFWorkbook workbook = new XSSFWorkbook(excelfile.getInputStream());
			// Creates a worksheet object representing the first sheet
			XSSFSheet worksheet = workbook.getSheetAt(0);
			// Reads the data in excel file until last row is encountered
			DataFormatter formatter = new DataFormatter();
			Cell cell=null;
			while (i <= worksheet.getLastRowNum()) {
				// Creates an object for the UserInfo Model
				AdminFileUploadExampleModel user = new AdminFileUploadExampleModel();
				// Creates an object representing a single row in excel
				XSSFRow row = worksheet.getRow(i++);
				// Sets the Read data to the model class
				if(startwithrow>0){
				 cell = row.getCell(0);
				user.setFirstname(formatter.formatCellValue(cell));
				if(user.getFirstname()!=null){
					user.setFirstname(formatter.formatCellValue(cell).trim());
				}
				 cell = row.getCell(1);
				user.setLastname(formatter.formatCellValue(cell));
				if(user.getLastname()!=null){
					user.setLastname(formatter.formatCellValue(cell).trim());
				}
				 cell = row.getCell(2);
				user.setUsername(formatter.formatCellValue(cell));
				if(user.getUsername()!=null){
					user.setUsername(formatter.formatCellValue(cell).trim());
				}
				 cell = row.getCell(3);
				user.setEmail(formatter.formatCellValue(cell));
				if(user.getEmail()!=null){
					user.setEmail(formatter.formatCellValue(cell).trim().toLowerCase());
				}
				 cell = row.getCell(4);
				user.setPassword(formatter.formatCellValue(cell));
				if(user.getPassword()!=null){
					user.setPassword(formatter.formatCellValue(cell).trim());
				}
				 cell = row.getCell(5);
				user.setMobilenumber1(formatter.formatCellValue(cell));
				if(user.getMobilenumber1()!=null){
					user.setMobilenumber1(formatter.formatCellValue(cell).trim());
				}
				 cell = row.getCell(6);
				user.setClassid(formatter.formatCellValue(cell));
				if(user.getClassid()!=null){
					user.setClassid(formatter.formatCellValue(cell).trim());
				}
				 cell = row.getCell(7);
				user.setSectionid(formatter.formatCellValue(cell));
				if(user.getSectionid()!=null){
					user.setSectionid(formatter.formatCellValue(cell).trim());
				}
				 cell = row.getCell(8);
				user.setBranchid(formatter.formatCellValue(cell));
				if(user.getBranchid()!=null){
					user.setBranchid(formatter.formatCellValue(cell).trim());
				}
				 cell = row.getCell(9);
				user.setStateid(formatter.formatCellValue(cell));
				if(user.getStateid()!=null){
					user.setStateid(formatter.formatCellValue(cell).trim());
				}
				 cell = row.getCell(10);
				user.setLocationid(formatter.formatCellValue(cell));
				if(user.getLocationid()!=null){
					user.setLocationid(formatter.formatCellValue(cell).trim());
				}
				
				user.setStatusid(statusid);
				user.setSessionid(sessoinid);
				int existsusercount=adminuserservice.getUsernameAndEmail(user);
				if(existsusercount>0){
						emsg+=user.getUsername()+" User already exists"+"</br>";
				}
			
				if(existsusercount==0){
					 updateque=adminuserservice.insertBulkdataintoUsers(user);
					 successcount++;
				}
				int existsusercount1=adminuserservice.getUsernameAndEmail1(user);
				if(existsusercount1>0){
					int useridexiscount=adminuserservice.userroleIdAlreadyexistCount(user);
					if(useridexiscount==0){
						int uid = userservice.getUserIDfromUsers(user.getUsername());
						int rid = 1;
						adminuserservice.getUpdateUseridInUSerRoles(uid,rid);
					}
				}
				
				// persist data into database in here
				lstUser.add(user);
				}
				startwithrow++;
			
			}			
			workbook.close();
			model.addAttribute("lstUser", lstUser);
		} catch (Exception e) {
		}

		if(updateque>0){		
			msg=successcount +" : Records Uploaded Successfully";
			}
		model.addAttribute("emsg", emsg);
		model.addAttribute("msg", msg);
	

		return "FileUploadSuccess";
	}
	
	@RequestMapping("/loadsampleBulkFile")
	public String loadsampleBulkFile(Model model, Register ad, HttpServletRequest req, HttpSession ses) {
		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		model.addAttribute("reg", ad);
		return "loadsampleBulkFile";
	}

}
