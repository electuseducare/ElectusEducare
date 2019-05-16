package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminAllIndiaMarksAnalysisPojo;

public class AdminAllIndiaMarksAnalysisMapper1 implements RowMapper<AdminAllIndiaMarksAnalysisPojo>{

	@Override
	public AdminAllIndiaMarksAnalysisPojo mapRow(ResultSet rs, int arg1) throws SQLException {
	
		AdminAllIndiaMarksAnalysisPojo results = new AdminAllIndiaMarksAnalysisPojo();
		results.setSubjectname(rs.getString("el_subject_name"));
		results.setTotalmarks(rs.getInt("total_marks"));
		results.setSubjectid(rs.getString("el_subject_id"));
		results.setSubjecttotalmarks(rs.getInt("subject_total_marks"));
		return results;
	}
	

}
