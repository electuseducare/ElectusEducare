package com.educare.admin.controller;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.educare.DatabaseValueController;
import com.educare.admin.model.AdminAddEditDeleteAccessforRolesPojo;
import com.educare.controller.LoginController;
import com.educare.services.AdminRegisterServiceImpl;

@Controller
public class AdminEditAccessforRolesController {

	private static final Logger logger = LoggerFactory.getLogger(AdminEditAccessforRolesController.class);
	
	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;
	
	@Value("${super.admin.roleid}")
	String superadmroleid;

	String sidval = "student_id";
	String acval = "editaccessroles";

	@RequestMapping(value = "/load-editaccessforRolese")
	public String adminloadEditaccessforRoles(Model model, AdminAddEditDeleteAccessforRolesPojo aedAccRoles,
			HttpSession ses,HttpServletRequest req) {

		String start = "Entry of adminloadEditaccessforRoles method....";
		String end = "End of adminloadEditaccessforRoles method....";

		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";
		
		List<AdminAddEditDeleteAccessforRolesPojo> rolesdesc = adminuserservice.getRolesforAdmin(superadmroleid);
		model.addAttribute(acval, aedAccRoles);
		model.addAttribute("roledesc", rolesdesc);

		logger.info(end);

		return "adminEditAccessforRoles";
	}

	@RequestMapping(value = "/load-editusernamesforRoles")
	public String adminGetEditUsernamesforAccess(Model model, AdminAddEditDeleteAccessforRolesPojo aedAccRoles,
			HttpServletRequest req, HttpSession ses) {

		String start = "Entry of adminGetEditUsernamesforAccess method....";
		String end = "End of adminGetEditUsernamesforAccess method....";

		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";

		model.addAttribute(acval, aedAccRoles);
		String roleId = req.getParameter("roleid");
		int roleid = (new Integer(roleId)).intValue();
		String emsg = null;
		List<AdminAddEditDeleteAccessforRolesPojo> userdescr = null;
		StringJoiner userids = new StringJoiner(",");
		List<Map<String, Object>> userid = adminuserservice.getUserIDsbasedonRoleId(roleid);
		for (Map<String, Object> map : userid) {
			Object uids = map.get("user_id");
			String uid1 = String.valueOf(uids);
			userids.add(uid1);
		}

		String useridsjoined = userids.toString();

		if (useridsjoined.equals("")) {
			emsg = "For this role we don't have users! Please add this role to give access";
		} else {
			userdescr = adminuserservice.getUsersbasedonRoleIds(useridsjoined);

		}

		model.addAttribute("emsg", emsg);

		model.addAttribute("userdesc", userdescr);

		logger.info(end);

		return "adminEditAccessforRoles";
	}

	@RequestMapping(value = "/load-editpermissionsforRoles")
	public @ResponseBody List<AdminAddEditDeleteAccessforRolesPojo> admineditlistofpermissions(Model model,
			HttpServletRequest req, AdminAddEditDeleteAccessforRolesPojo aedAccRoles, HttpSession ses) {

		String start = "Entry of admineditlistofpermissions method....";
		String end = "End of admineditlistofpermissions method....";

		logger.info(start);

		String studentid1 = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid1);

		model.addAttribute(acval, aedAccRoles);
		String roleids = req.getParameter("roleid");
		String studentid = req.getParameter("studentid");
		int roleid = (new Integer(roleids)).intValue();
		List<AdminAddEditDeleteAccessforRolesPojo> permissiondesc = adminuserservice.getListofeditPermissions(roleid,
				studentid);
		model.addAttribute("permissiondesc", permissiondesc);

		logger.info(end);

		return permissiondesc;
	}

	@RequestMapping(value = "/edit-accessforRoles")
	public String updateuserpermissions(Model model, HttpServletRequest req,
			AdminAddEditDeleteAccessforRolesPojo aedAccRoles, HttpSession ses) {

		String start = "Entry of updateuserpermissions method....";
		String end = "End of updateuserpermissions method....";

		logger.info(start);

		String studentid1 = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid1);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";

		model.addAttribute(acval, aedAccRoles);
		String[] permissionvalue;
		permissionvalue = req.getParameterValues("permssvalues1");
		String roleid1 = aedAccRoles.getAdminrnames();
		int roleid = (new Integer(roleid1)).intValue();
		String studentid = aedAccRoles.getUsername();
		String smsg = null;
		int updatepermissions = 0;
		if (permissionvalue != null) {
			for (int i = 0; i < permissionvalue.length; i++) {
				String permssids = permissionvalue[i];
				int permissionid = (new Integer(permssids)).intValue();
				updatepermissions = adminuserservice.updateuserpermissions(permissionid, roleid, studentid);
			}
		}
		if (updatepermissions > 0) {
			smsg = "Access deleted successfully";
		}
		model.addAttribute("smsg", smsg);

		logger.info(end);

		return "forward:/load-editaccessforRolese";
	}

}
