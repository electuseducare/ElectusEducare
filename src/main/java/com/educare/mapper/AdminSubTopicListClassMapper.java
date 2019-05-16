package com.educare.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminSetExamPojo;

public class AdminSubTopicListClassMapper implements RowMapper<AdminSetExamPojo>{

	@Override
	public AdminSetExamPojo mapRow(ResultSet rs, int arg1) throws SQLException {
		AdminSetExamPojo adm=new AdminSetExamPojo();
		adm.setSubtopic(rs.getString("topicname"));
		adm.setSubtopicid(rs.getString("subject_subtopic_type_id"));
		return adm;
	}

}
