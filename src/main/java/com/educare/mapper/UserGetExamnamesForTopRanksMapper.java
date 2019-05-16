package com.educare.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.model.UserTopRankersModel;

public class UserGetExamnamesForTopRanksMapper implements RowMapper<UserTopRankersModel> {

	@Override
	public UserTopRankersModel mapRow(ResultSet rs, int arg1) throws SQLException {
		UserTopRankersModel ut=new UserTopRankersModel();
		ut.setExamname(rs.getString("Exam_Name"));
		ut.setExamtype(rs.getString("Exam_Type"));
		return ut;
	}

}
