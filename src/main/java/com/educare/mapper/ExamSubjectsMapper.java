package com.educare.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.model.QuestionPojo;

public class ExamSubjectsMapper implements RowMapper<QuestionPojo>
{

	@Override
	public QuestionPojo mapRow(ResultSet rs, int arg1) throws SQLException {
		QuestionPojo ques=new QuestionPojo();
		ques.setSubjectid(rs.getInt("subject_id"));
		return ques;
	}

}
