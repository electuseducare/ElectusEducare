package com.educare.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.model.StudentExamAssignModel;

public class GetStudentDetBasClsSecMapper implements RowMapper<StudentExamAssignModel> {

	@Override
	public StudentExamAssignModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		StudentExamAssignModel view=new StudentExamAssignModel();
		view.setStudentid(rs.getString("student_id"));
		view.setUserid(rs.getString("user_name"));
		return view;
	}

}
