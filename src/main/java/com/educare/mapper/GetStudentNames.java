package com.educare.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminCategory;

public class GetStudentNames implements RowMapper<AdminCategory> {

	@Override
	public AdminCategory mapRow(ResultSet rs, int arg1) throws SQLException {
		AdminCategory ac=new AdminCategory();
		ac.setStudentid(rs.getString("student_id"));
		ac.setUsername(rs.getString("user_name"));
		return ac;
	}

}
