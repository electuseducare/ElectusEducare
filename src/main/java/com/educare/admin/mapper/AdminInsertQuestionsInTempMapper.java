package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminInsertQuestionsInTempModel;

public class AdminInsertQuestionsInTempMapper implements RowMapper<AdminInsertQuestionsInTempModel> {

	@Override
	public AdminInsertQuestionsInTempModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		AdminInsertQuestionsInTempModel aq=new AdminInsertQuestionsInTempModel();
		aq.setStudentid(rs.getString("student_id"));
		aq.setClassid(rs.getInt("el_class_generated_id"));
		aq.setSectionid(rs.getInt("el_section_id"));
		aq.setBrancid(rs.getInt("el_branch_id"));
		aq.setLocationid(rs.getInt("el_location_id"));
		return aq;
	}

}
