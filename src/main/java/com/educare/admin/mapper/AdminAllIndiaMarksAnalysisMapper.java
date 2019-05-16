package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminAllIndiaMarksAnalysisPojo;

public class AdminAllIndiaMarksAnalysisMapper implements RowMapper<AdminAllIndiaMarksAnalysisPojo> {

	@Override
	public AdminAllIndiaMarksAnalysisPojo mapRow(ResultSet rs, int arg1) throws SQLException {
		
		AdminAllIndiaMarksAnalysisPojo category=new AdminAllIndiaMarksAnalysisPojo();
		category.setStudentid(rs.getString("student_id"));
		category.setStudentname(rs.getString("studentname"));
		category.setSectionname(rs.getString("el_section_name"));
		category.setScoredmarks(rs.getString("SCORED_MARKS"));
		category.setSubjectnames(rs.getString("el_subject_name"));
		category.setCampusid(rs.getInt("campus"));
		category.setStateid(rs.getInt("state"));
		category.setSectionid(rs.getInt("section"));
		category.setCampusname(rs.getString("el_branch_name"));
		category.setTotalmarks(rs.getInt("total_marks"));
		category.setSubjectid(rs.getString("el_subject_id"));
		category.setState(rs.getString("state_type"));
		category.setClassid(rs.getInt("class_id"));
		category.setUsername(rs.getString("username"));
		return category;
	}

}
