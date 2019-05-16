package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminFilterCriteria;

public class AdminFilterCriteriaMapper implements RowMapper<AdminFilterCriteria> {

	@Override
	public AdminFilterCriteria mapRow(ResultSet rs, int arg1) throws SQLException {
		AdminFilterCriteria adf=new AdminFilterCriteria();
		adf.setExamtype(rs.getString("exam_type"));
		adf.setSubjectype(rs.getString("el_subject_name"));
		adf.setSubjecttopic(rs.getString("subject_topic_type"));
		adf.setSubjectsubtopic(rs.getString("subject_subtopic_type"));
		adf.setFilename(rs.getString("import_file_name"));
		adf.setQuestiontype(rs.getString("Question_Type"));
		adf.setQuestnlevel(rs.getString("Question_Level_Type"));
		adf.setQuestion(rs.getString("ques"));
		adf.setClasstype(rs.getString("el_class_name"));
		return adf;
	}

}
