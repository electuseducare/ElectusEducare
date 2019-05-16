package com.educare.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.model.StudentExamAssignModel;

public class GetStudentDetMApper implements RowMapper<StudentExamAssignModel> {

	@Override
	public StudentExamAssignModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		StudentExamAssignModel view=new StudentExamAssignModel();
		view.setBranchid(rs.getInt("el_branch_id"));
		view.setLocationid(rs.getInt("el_location_id"));
		view.setClassid(rs.getString("el_class_generated_id"));
		view.setSectionid(rs.getInt("el_section_id"));
		return view;
	}

}
