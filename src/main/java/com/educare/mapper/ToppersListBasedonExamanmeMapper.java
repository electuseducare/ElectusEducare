package com.educare.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.model.UserTopRankersModel;

public class ToppersListBasedonExamanmeMapper implements RowMapper<UserTopRankersModel> {

	@Override
	public UserTopRankersModel mapRow(ResultSet rs, int arg1) throws SQLException {
		UserTopRankersModel ut=new UserTopRankersModel();
		ut.setStudentname(rs.getString("name"));
		ut.setExamtotalmarks(rs.getString("total_marks"));
		ut.setExamscoredmarks(rs.getString("EXAM_SCORED_MARKS"));
		ut.setRank(rs.getString("rank1"));
		ut.setExamname(rs.getString("Exam_Name"));
		
		return ut;
	}

}
