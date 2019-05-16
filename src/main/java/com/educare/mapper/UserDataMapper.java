package com.educare.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.model.LoginPojo;

public class UserDataMapper implements RowMapper<LoginPojo>
{

	@Override
	public LoginPojo mapRow(ResultSet rs, int arg1) throws SQLException {
		LoginPojo userdata=new LoginPojo();
		userdata.setClassname(rs.getString("el_class_generated_id"));
		userdata.setSection(rs.getString("el_section_id"));
		userdata.setBarnch(rs.getString("el_branch_id"));
		userdata.setFirstname(rs.getString("first_name"));
		userdata.setState(rs.getString("state_type_id"));
		userdata.setStudent_id(rs.getString("student_id"));
		userdata.setLocationid(rs.getString("el_location_id"));
		userdata.setLastname(rs.getString("last_name"));
		return userdata;
	}

}
