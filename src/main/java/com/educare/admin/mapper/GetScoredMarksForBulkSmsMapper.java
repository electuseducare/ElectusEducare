package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminCategory;

public class GetScoredMarksForBulkSmsMapper implements RowMapper<AdminCategory> {

	@Override
	public AdminCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
		AdminCategory ad=new AdminCategory();
		ad.setScoredmarks(rs.getString("SCORED_MARKS"));
		ad.setStudentid(rs.getString("student_id"));
		ad.setSubjectname(rs.getString("el_subject_name"));
		
		return ad;
	}

}
