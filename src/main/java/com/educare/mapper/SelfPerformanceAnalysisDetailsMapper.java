package com.educare.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.model.SelfassessmentModel;

public class SelfPerformanceAnalysisDetailsMapper implements RowMapper<SelfassessmentModel> {

	@Override
	public SelfassessmentModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		SelfassessmentModel self=new SelfassessmentModel();
		
		self.setExamname(rs.getString("Exam_Name"));
		self.setScoredmarks(rs.getString("EXAM_SCORED_MARKS"));
		self.setTotalmarks(rs.getString("total_marks"));
		return self;
	}

}
