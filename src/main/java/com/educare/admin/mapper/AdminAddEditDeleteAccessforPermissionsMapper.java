package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminAddEditDeleteAccessforRolesPojo;

public class AdminAddEditDeleteAccessforPermissionsMapper implements RowMapper<AdminAddEditDeleteAccessforRolesPojo>{

	@Override
	public AdminAddEditDeleteAccessforRolesPojo mapRow(ResultSet rs, int arg1) throws SQLException {
		AdminAddEditDeleteAccessforRolesPojo rolespojo=new AdminAddEditDeleteAccessforRolesPojo();
		rolespojo.setPermissionid(rs.getInt("perm_id"));
		rolespojo.setPermissiondesc(rs.getString("perm_desc"));
		rolespojo.setPermurl(rs.getString("perm_url"));
		return rolespojo;
	}
	

}
