package com.educare.servicecalls.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.educare.model.LoginPojo;
import com.educare.servicecalls.model.LoginServiceModel;
import com.educare.services.RegisterServiceImpl;

@RestController
public class LoginServiceController {
	@Autowired
	private RegisterServiceImpl userservice;

	@RequestMapping(value = "/checklogin", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<LoginServiceModel> checklogin(@RequestParam("username") String username,
			@RequestParam("password") String password,@RequestParam("keyDS") String keyDS, LoginPojo lp, HttpSession session, HttpServletRequest req) {

		/** database selection**/
		session.setAttribute("keyDS", keyDS);
		LoginServiceModel lsm = new LoginServiceModel();
		String status = null;
		lp.setUsername(username);
		lp.setPassword(password);
		int cnt = userservice.checkUserExistOrNot(lp);
		List<LoginPojo> customers = userservice.loginDetails(lp);
		String getusernames = lp.getUsername();
		
		if(cnt>0){
			String dbpassword=userservice.getUserPassword(lp);
		           if(!(dbpassword.equals(lp.getPassword()))){
			status = "Please enter Correct password";
			lsm.setStatus(status);
			return new ResponseEntity<>(lsm, HttpStatus.OK);
		}}

		if (cnt > 0) {
			for (LoginPojo row : customers) {
				int userstatus = 0;
				String uname = lp.getUsername().toLowerCase();
				String uname1 = row.getUsername().toLowerCase();

				if (uname.equals(uname1) && !(row.getUsername().isEmpty())) {
					session.setAttribute("username", username);
					String studentid = row.getStudent_id();
					session.setAttribute("student_id", row.getStudent_id());
					session.setAttribute("first_name", row.getFname());
					session.setAttribute("email_id", row.getEmail());
					session.setAttribute("uname", row.getUsername());
					lsm.setStudentid(row.getStudent_id());
					

					int roleid = userservice.getRoleIDfromUserRole(getusernames);
					int usersatatus1 = userservice.getUserStatus(studentid);
					if (roleid == 1 && usersatatus1 == 0) {
						userstatus = 1;
						userservice.insertUserStatus(studentid, userstatus);
						session.setAttribute("userrole", "userrole");
						DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						Date now = new Date();
						String logintime = dateFormat.format(now);
						session.setAttribute("logintime", logintime);
						userservice.insertAuditlogs(studentid, username, logintime);
						List<LoginPojo> userdetails = userservice.getUserdetails(studentid);
						for (LoginPojo loginPojo : userdetails) {

							session.setAttribute("classname", loginPojo.getClassname());
							session.setAttribute("sectionname", loginPojo.getSection());
							session.setAttribute("branchname", loginPojo.getBarnch());
							session.setAttribute("username", loginPojo.getFirstname());
							session.setAttribute("state", loginPojo.getState());
							session.setAttribute("locationid", loginPojo.getLocationid());
						}
						/*** Dont change this set value. This value is used in andriod service call****/
						lsm.setStatus("Successfully logged in");
						return new ResponseEntity<>(lsm, HttpStatus.OK);

					} else {
						status = "Current user is already logged in. Please try again after some time!";
						lsm.setStatus(status);
						return new ResponseEntity<>(lsm, HttpStatus.OK);
					}
				}

			}

		}

		else {
			status = "Please register";
			lsm.setStatus(status);
		}
		return new ResponseEntity<>(lsm, HttpStatus.OK);

	}
}
