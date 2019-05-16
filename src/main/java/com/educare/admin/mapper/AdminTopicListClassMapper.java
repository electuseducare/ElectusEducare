package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminSetExamPojo;

public class AdminTopicListClassMapper implements RowMapper<AdminSetExamPojo> {

	@Override
	public AdminSetExamPojo mapRow(ResultSet rs, int arg1) throws SQLException {
		AdminSetExamPojo adm=new AdminSetExamPojo();
		adm.setTopic(rs.getString("subject_topic_type"));
		adm.setTopicid(rs.getString("subject_topic_type_id"));
		return adm;
	}

}
