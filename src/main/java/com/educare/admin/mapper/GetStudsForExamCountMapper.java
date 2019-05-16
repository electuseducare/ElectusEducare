package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.StudentExamCountModel;

public class GetStudsForExamCountMapper implements RowMapper<StudentExamCountModel> {

	@Override
	public StudentExamCountModel mapRow(ResultSet rs, int arg1) throws SQLException {
		StudentExamCountModel se = new StudentExamCountModel();
		
		se.setStudentname(rs.getString("studentname"));
		se.setUsername(rs.getString("user_name"));

		return se;
	}

}
