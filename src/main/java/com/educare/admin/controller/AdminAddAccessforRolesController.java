package com.educare.admin.controller;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.educare.DatabaseValueController;
import com.educare.admin.model.AdminAddEditDeleteAccessforRolesPojo;
import com.educare.controller.LoginController;
import com.educare.services.AdminRegisterServiceImpl;

@Controller
public class AdminAddAccessforRolesController {

	private static final Logger logger = LoggerFactory.getLogger(AdminAddAccessforRolesController.class);

	@Autowired
	private AdminRegisterServiceImpl adminuserservice;

	@Autowired
	private LoginController lc;
	
	@Autowired
	private DatabaseValueController dv;
	
	@Value("${super.admin.roleid}")
	String superadmroleid;
	
	String url="forward:/load-addaccessforRolese";
	String sidval="student_id";
	String acuserval="accesusersroles";

	@RequestMapping(value = "/load-addaccessforRolese")
	public String adminloadaccessforRoles(Model model, AdminAddEditDeleteAccessforRolesPojo aedAccRoles,
			HttpSession ses,HttpServletRequest req) {

		String start = "Start of adminloadaccessforRoles method....";
		String end = "End of adminloadaccessforRoles method....";

		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";

		List<AdminAddEditDeleteAccessforRolesPojo> rolesdesc = adminuserservice.getRolesforAdmin(superadmroleid);
		adminloadlistofpermissionsAvailable(model);
		model.addAttribute(acuserval, aedAccRoles);
		model.addAttribute("roledesc", rolesdesc);

		logger.info(end);

		return "adminAddAccessforRoles";
	}

	public void adminloadlistofpermissionsAvailable(Model model) {

		String start = "Entry of adminloadlistofpermissionsAvailable method....";
		String end = "End of adminloadlistofpermissionsAvailable method....";

		logger.info(start);

		List<AdminAddEditDeleteAccessforRolesPojo> permissiondesc = adminuserservice.getListofPermissions();
		model.addAttribute("permissiondesc", permissiondesc);

		logger.info(end);
	}

	@RequestMapping(value = "/load-addusernamesforRoles")
	public String adminGetAddUsernamesforAccess(Model model, AdminAddEditDeleteAccessforRolesPojo aedAccRoles,
			HttpServletRequest req, HttpSession ses) {

		String start = "Entry of adminGetAddUsernamesforAccess method.....";
		String end = "End of adminGetAddUsernamesforAccess method....";

		logger.info(start);

		String studentid = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";

		model.addAttribute(acuserval, aedAccRoles);
		String rolid = req.getParameter("roleid");
		int roleid = (new Integer(rolid)).intValue();
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

		return "adminAddAccessforRoles";
	}

	@RequestMapping(value = "/add-accessforRoles")
	public String adminAddaccessforRoles(Model model, AdminAddEditDeleteAccessforRolesPojo aedAccRoles,
			HttpServletRequest req, HttpServletResponse res, HttpSession ses) {

		String start = "Entry of adminAddaccessforRoles method.....";
		String end = "End of adminAddaccessforRoles method....";

		logger.info(start);

		String studentid1 = (String) ses.getAttribute(sidval);
		lc.getpermissionsforloggedusers(model, studentid1);
		
		/**** return default database value *****/
		String dbval=dv.getDatabaseValue(ses,req);
		if(dbval.equals("0"))
		return "defaultDatabaseErrorPage";

		model.addAttribute(acuserval, aedAccRoles);
		String roleid = aedAccRoles.getAdminrnames();
		String permssionid1 = aedAccRoles.getPermcheckbox();
		String studentid = aedAccRoles.getUsername();
		int insertrids = 0;
		String emsg = null;
		String smsg = null;

		if (roleid.equals("0")) {
			emsg = "Please select valid Roles";
			model.addAttribute("emsg", emsg);
			return url;
		}

		if (studentid.equals("0")) {
			emsg = "Please select valid Users";
			model.addAttribute("emsg", emsg);
			return url;
		}
		int alreadyinserted = 0;
		if (permssionid1 != null) {
			String[] spltpermssionidchkbox = permssionid1.split(",");
			for (int i = 0; i < spltpermssionidchkbox.length; i++) {
				String permissionids = spltpermssionidchkbox[i];
				int roleid1 = (new Integer(roleid)).intValue();
				int permssionid = (new Integer(permissionids)).intValue();
				alreadyinserted = adminuserservice.getalreadyinsertedinPermissions(roleid1, permssionid, studentid);
				if (alreadyinserted == 0) {
					insertrids = adminuserservice.insertPermissions(roleid1, permssionid, studentid);
				}
			}
		} else {
			emsg = "Please select valid Permissions";
			model.addAttribute("emsg", emsg);
			return url;
		}

		if (insertrids == 0) {
			emsg = "Please select valid data in access screen";
		} else {
			smsg = "Access added successfully";
		}

		model.addAttribute("emsg", emsg);
		model.addAttribute("smsg", smsg);

		logger.info(end);

		return "forward:/load-addaccessforRolese";
	}

}
