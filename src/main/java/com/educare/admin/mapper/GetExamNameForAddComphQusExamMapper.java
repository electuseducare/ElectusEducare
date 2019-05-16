package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminAddCompQuesInExamModel;

public class GetExamNameForAddComphQusExamMapper implements RowMapper<AdminAddCompQuesInExamModel> {

	@Override
	public AdminAddCompQuesInExamModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		AdminAddCompQuesInExamModel ac=new AdminAddCompQuesInExamModel();
		ac.setSelectedexam(rs.getString("exam_name"));
		return ac;
	}

}
