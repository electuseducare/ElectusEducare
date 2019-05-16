package com.educare.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.model.ErrorAnalysisPojo;

public class ErrorAnalysisMapper implements RowMapper<ErrorAnalysisPojo> {

	@Override
	public ErrorAnalysisPojo mapRow(ResultSet rs, int row1) throws SQLException {
		
		ErrorAnalysisPojo error = new ErrorAnalysisPojo();
		error.setQuestion_Analysis(rs.getString("Analysis"));
		return error;
		
	}
}
