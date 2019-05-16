package com.educare.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.model.Register;

public class GetAllStudenyDetaislMapper implements RowMapper<Register> {

	

	@Override
	public Register mapRow(ResultSet rs, int arg1) throws SQLException {
		Register view= new Register();
		
		view.setEmail_id(rs.getString("email"));
		view.setStudent_id(rs.getString("student_id"));
		view.setName(rs.getString("first_name"));
		view.setUserid(rs.getInt("user_name"));
        view.setLname(rs.getString("last_name"));
		return view;
	}
	
	
}
