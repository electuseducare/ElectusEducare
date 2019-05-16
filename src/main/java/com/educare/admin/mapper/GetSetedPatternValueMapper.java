package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminSetStartExamPatternModel;

public class GetSetedPatternValueMapper implements RowMapper<AdminSetStartExamPatternModel> {

	@Override
	public AdminSetStartExamPatternModel mapRow(ResultSet rs, int arg1) throws SQLException {
		AdminSetStartExamPatternModel as=new AdminSetStartExamPatternModel();
		as.setExamtypeid(rs.getInt("Exam_Type_Id"));
		as.setPatternid(rs.getInt("pattern_type_id"));
		
		return as;
	}

}
