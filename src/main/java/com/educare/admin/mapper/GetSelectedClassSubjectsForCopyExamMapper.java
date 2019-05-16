package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminCategory;

public class GetSelectedClassSubjectsForCopyExamMapper implements RowMapper<AdminCategory> {

	@Override
	public AdminCategory mapRow(ResultSet rs, int arg1) throws SQLException {
		AdminCategory ad = new AdminCategory();
		ad.setSubjectid(rs.getString("el_subject_id"));
		ad.setSubjectname(rs.getString("el_subject_name"));
		ad.setSelectedsubjectqns(rs.getString("subjectquestions"));
		return ad;
	}

	

}
