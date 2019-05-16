package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminCategory;

public class GetAlltopicsForCopyExamMapper implements RowMapper<AdminCategory> {

	

	@Override
	public AdminCategory mapRow(ResultSet rs, int arg1) throws SQLException {
		AdminCategory ad=new AdminCategory();
		ad.setTopicnames(rs.getString("subject_topic_type"));
		ad.setTopicid(rs.getString("subject_topic_type_id"));
		ad.setSubjectid(rs.getString("subject_type_id"));
		
		return ad;
	}

}
