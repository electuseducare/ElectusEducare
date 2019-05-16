package com.educare.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.model.UserResultsPojo;

public class UserResultsMapper implements RowMapper<UserResultsPojo> {

	@Override
	public UserResultsPojo mapRow(ResultSet rs, int arg1) throws SQLException {
		UserResultsPojo user=new UserResultsPojo();
		user.setScoredmarks(rs.getFloat("SCORED_MARKS"));
		user.setSubject(rs.getString("el_subject_name"));
		user.setTotalmarks(rs.getString("total_marks"));
		user.setNegativemarks(rs.getString("negative_marks"));
		user.setCorrectanswers(rs.getInt("Correct_Answers"));
		user.setWronganswers(rs.getInt("wrong_answers"));
		user.setUnattempt(rs.getInt("not_answered"));
		user.setExamscored(rs.getString("EXAM_SCORED_MARKS"));
		user.setSubjectwisetotal(rs.getString("subject_total_marks"));
	
		return user;
	}

}
