package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminAddStudent;

public class AdminUsernameValuesForRoleMapper1 implements RowMapper<AdminAddStudent> {

	@Override
	public AdminAddStudent mapRow(ResultSet rs, int arg1) throws SQLException {
		AdminAddStudent adstu=new AdminAddStudent();
		adstu.setEmail(rs.getString("email"));
		adstu.setUsername(rs.getString("user_name"));
		adstu.setStudentfirstname(rs.getString("first_name"));
		adstu.setStudentlastname(rs.getString("last_name"));
		adstu.setMobile(rs.getString("phone"));
		adstu.setPassword(rs.getString("password"));
		adstu.setCollegename(rs.getString("collegename"));
		adstu.setStudent_id(rs.getString("student_id"));
		adstu.setUserid(rs.getString("user_id"));
	
		return adstu;
	}

}
