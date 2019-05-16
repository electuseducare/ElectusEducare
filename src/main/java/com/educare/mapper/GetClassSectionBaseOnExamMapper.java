package com.educare.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.model.StudentExamAssignModel;

public class GetClassSectionBaseOnExamMapper implements RowMapper<StudentExamAssignModel> {

	@Override
	public StudentExamAssignModel mapRow(ResultSet rs, int arg1) throws SQLException {
		
		StudentExamAssignModel view=new StudentExamAssignModel();
		
		view.setExamname(rs.getString("exam_name"));
		view.setClassname(rs.getString("el_class_name"));
		view.setSection(rs.getString("el_section_name"));
		view.setClassid(rs.getString("el_class_generated_id"));
		view.setSectionid(rs.getInt("secid"));
		
		return view;
	}

}
