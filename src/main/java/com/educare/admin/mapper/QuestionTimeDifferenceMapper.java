package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.Questionanalysispojo;

public class QuestionTimeDifferenceMapper implements RowMapper<Questionanalysispojo> {

	@Override
	public Questionanalysispojo mapRow(ResultSet rs, int arg1) throws SQLException {
		Questionanalysispojo qs=new Questionanalysispojo();
		qs.setSelectedanswer(rs.getString("selected_answer"));
		qs.setFilename(rs.getString("filenames"));
		qs.setTimedifference(rs.getString("timedifference"));
		qs.setQuestionid(rs.getString("question_Id"));
		
		return qs;
	}

}
