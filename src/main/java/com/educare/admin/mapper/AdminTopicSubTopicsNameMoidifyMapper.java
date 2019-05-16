package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminTopicSubTopicsNameMoidifyModel;

public class AdminTopicSubTopicsNameMoidifyMapper implements RowMapper<AdminTopicSubTopicsNameMoidifyModel> {

	@Override
	public AdminTopicSubTopicsNameMoidifyModel mapRow(ResultSet rs, int arg1) throws SQLException {
		AdminTopicSubTopicsNameMoidifyModel adm=new AdminTopicSubTopicsNameMoidifyModel();
		
		adm.setExamtype(rs.getString("exam_type"));
		adm.setClassid(rs.getInt("el_class_generated_id"));
        adm.setClassname(rs.getString("el_class_name"));	
        adm.setSubjecttypeid(rs.getInt("el_subject_id"));
        adm.setSubjectname(rs.getString("el_subject_name"));
        adm.setTopicid(rs.getString("topic"));
        adm.setSubtopicid(rs.getString("subtopic"));
        adm.setTopicname(rs.getString("subject_topic_type"));
        adm.setSubtopicname(rs.getString("subject_subtopic_type"));
        adm.setExamtypeid(rs.getInt("exam_type_id"));
        
		
		return adm;
	}

}
