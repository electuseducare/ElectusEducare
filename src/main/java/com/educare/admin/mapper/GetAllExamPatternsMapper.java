package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminSetStartExamPatternModel;

public class GetAllExamPatternsMapper implements RowMapper<AdminSetStartExamPatternModel> {

	@Override
	public AdminSetStartExamPatternModel mapRow(ResultSet rs, int arg1) throws SQLException {
		
		AdminSetStartExamPatternModel ep=new AdminSetStartExamPatternModel();
		ep.setPatternid(rs.getInt("pattern_type_id"));
		ep.setPatterntype(rs.getString("pattern_type"));
		
		return ep;
	}

}
