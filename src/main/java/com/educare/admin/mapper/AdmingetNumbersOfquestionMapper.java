package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminAddCompQuesInExamModel;

public class AdmingetNumbersOfquestionMapper implements RowMapper<AdminAddCompQuesInExamModel> {

	@Override
	public AdminAddCompQuesInExamModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		AdminAddCompQuesInExamModel ac=new AdminAddCompQuesInExamModel();
		ac.setSubjectid(rs.getString("subject_type"));
		ac.setNumofquestions(rs.getInt("numofquestions"));
		ac.setSubjectname(rs.getString("el_subject_name"));
		return ac;
	}

}
