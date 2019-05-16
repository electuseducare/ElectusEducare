package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminAddEditDeleteAccessforRolesPojo;


public class AdminAddEditDeleteAccessforRolesMapper implements RowMapper<AdminAddEditDeleteAccessforRolesPojo> {

	@Override
	public AdminAddEditDeleteAccessforRolesPojo mapRow(ResultSet rs, int arg1) throws SQLException {
		AdminAddEditDeleteAccessforRolesPojo roledesc=new AdminAddEditDeleteAccessforRolesPojo();
		roledesc.setAdminrnames(rs.getString("role_name"));
		roledesc.setAdminrid(rs.getInt("role_id"));
		return roledesc;
	}
}