package com.educare.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.model.LoginPojo;



public class LoginMapper implements RowMapper<LoginPojo> {

	@Override
	public LoginPojo mapRow(ResultSet rs, int rowno) throws SQLException {
		LoginPojo logdata = new LoginPojo();
		logdata.setEmail(rs.getString("Email"));
		logdata.setPassword(rs.getString("password"));
		logdata.setFname(rs.getString("first_name"));
		logdata.setStudent_id(rs.getString("student_id"));
		logdata.setUsername(rs.getString("user_name"));
		return logdata;
	}

}
