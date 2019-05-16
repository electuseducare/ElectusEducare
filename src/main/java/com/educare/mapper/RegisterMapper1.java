package com.educare.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.model.Register;

public class RegisterMapper1 implements RowMapper<Register> {

	@Override
	public Register mapRow(ResultSet rs, int arg1) throws SQLException {
		Register userdata = new Register();
		userdata.setEmail_id(rs.getString("Email"));
		userdata.setMobile_Number(rs.getString("phone"));
		userdata.setName(rs.getString("First_Name"));
		userdata.setLname(rs.getString("Last_Name"));
		userdata.setPassword(rs.getString("password"));
		userdata.setStatus(rs.getString("status"));	
		userdata.setStudent_id(rs.getString("student_id"));
		userdata.setUsername(rs.getString("user_name"));
		userdata.setCollegename(rs.getString("collegename"));
		userdata.setClassname(rs.getString("classname"));
		userdata.setSectionname(rs.getString("sectionname"));
		userdata.setStatename(rs.getString("statename"));
		userdata.setLocationname(rs.getString("locationname"));
		userdata.setBranchname(rs.getString("branchname"));
		return userdata;
	}

}
