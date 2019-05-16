package com.educare.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.model.SelfassessmentModel;

public class SelfPerformanceAnalysisMapper implements RowMapper<SelfassessmentModel> {

	@Override
	public SelfassessmentModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		SelfassessmentModel sef=new SelfassessmentModel();
		sef.setExamtype(rs.getString("Exam_Type"));
		sef.setExamtypeid(rs.getString("Exam_Type_Id"));
		return sef;
	}

}
