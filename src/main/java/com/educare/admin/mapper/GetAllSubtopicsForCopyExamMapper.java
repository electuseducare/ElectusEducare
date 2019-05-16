package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminCategory;

public class GetAllSubtopicsForCopyExamMapper implements RowMapper<AdminCategory> {

	@Override
	public AdminCategory mapRow(ResultSet rs, int arg1) throws SQLException {
		AdminCategory ad=new AdminCategory();
		ad.setSubtopicid(rs.getString("subject_subtopic_type_id"));
		ad.setSubtopicnames(rs.getString("subject_subtopic_type"));
		return ad;
	}

}
