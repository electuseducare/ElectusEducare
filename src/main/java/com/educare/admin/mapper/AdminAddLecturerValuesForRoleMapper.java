package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminAddNewStudent;

public class AdminAddLecturerValuesForRoleMapper implements RowMapper<AdminAddNewStudent> {

	@Override
	public AdminAddNewStudent mapRow(ResultSet rs, int arg1) throws SQLException {
				AdminAddNewStudent adm=new AdminAddNewStudent();
				adm.setFirstname(rs.getString("first_name"));
				adm.setLastname(rs.getString("last_name"));
				adm.setUsername(rs.getString("user_name"));
				adm.setPassword(rs.getString("password"));
				adm.setStudentid(rs.getString("student_id"));
				adm.setUserid(rs.getString("user_id"));
				adm.setEmail(rs.getString("email"));
				adm.setMobile(rs.getString("phone"));
		return adm;
	}
}