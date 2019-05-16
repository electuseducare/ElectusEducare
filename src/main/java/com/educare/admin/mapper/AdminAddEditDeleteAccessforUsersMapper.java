package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminAddEditDeleteAccessforRolesPojo;

public class AdminAddEditDeleteAccessforUsersMapper implements RowMapper<AdminAddEditDeleteAccessforRolesPojo> {

	@Override
	public AdminAddEditDeleteAccessforRolesPojo mapRow(ResultSet rs, int arg1) throws SQLException {
		AdminAddEditDeleteAccessforRolesPojo userdesc=new AdminAddEditDeleteAccessforRolesPojo();
		
		userdesc.setStudentid(rs.getString("student_id"));
		userdesc.setUsername(rs.getString("user_name"));;
		return userdesc;
	}
}