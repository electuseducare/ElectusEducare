package com.educare.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.model.Register;


public class RegisterMapper implements RowMapper<Register> {

	@Override
	public Register mapRow(ResultSet rs, int row1) throws SQLException {
		Register logdata = new Register();
		logdata.setEmail_id(rs.getString("Email"));
		logdata.setMobile_Number(rs.getString("phone"));
		logdata.setName(rs.getString("First_Name"));
		logdata.setLname(rs.getString("Last_Name"));
		logdata.setPassword(rs.getString("password"));
		logdata.setStatus(rs.getString("status"));	
		logdata.setStudent_id(rs.getString("student_id"));
		logdata.setUsername(rs.getString("user_name"));
		logdata.setCollegename(rs.getString("collegename"));
		return logdata;

	}

}
