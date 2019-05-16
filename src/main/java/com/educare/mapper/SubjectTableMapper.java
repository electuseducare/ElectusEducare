package com.educare.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.model.QuestionPojo;

public class SubjectTableMapper implements RowMapper<QuestionPojo>
{

	@Override
	public QuestionPojo mapRow(ResultSet rs, int arg1) throws SQLException {
		QuestionPojo ques=new QuestionPojo();
		ques.setSubjectid(rs.getInt("el_subject_id"));
		ques.setSubject_type(rs.getString("el_subject_name"));
		return ques;
	}

}
