package com.educare.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.model.StudentExamAssignModel;

public class AdmingetExamNameMapper implements RowMapper<StudentExamAssignModel> {

	@Override
	public StudentExamAssignModel mapRow(ResultSet rs, int arg1) throws SQLException {

		StudentExamAssignModel view=new StudentExamAssignModel();
		
		view.setExamname(rs.getString("exam_name"));
		return view;
	}

}
