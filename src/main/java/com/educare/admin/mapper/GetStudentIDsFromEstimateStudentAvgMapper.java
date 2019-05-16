package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminCategory;

public class GetStudentIDsFromEstimateStudentAvgMapper implements RowMapper<AdminCategory> {

	@Override
	public AdminCategory mapRow(ResultSet rs, int arg1) throws SQLException {
		AdminCategory ac = new AdminCategory();
		ac.setUsername(rs.getString("user_name"));
		ac.setStudentid(rs.getString("student_id"));
		return ac;
	}

}
