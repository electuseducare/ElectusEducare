package com.educare.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.educare.model.WelcomeUserPojo;

public class UserDashboardViewResultsMapper implements RowMapper<WelcomeUserPojo>{

	@Override
	public WelcomeUserPojo mapRow(ResultSet rs, int arg1) throws SQLException {
		WelcomeUserPojo user=new WelcomeUserPojo();
		List<WelcomeUserPojo> userlist = new ArrayList<>();
        user.setExamName(rs.getString("Exam_Name"));
        user.setSubject(rs.getString("el_subject_name"));
        user.setSubjectTypeId(rs.getString("el_subject_id"));
        user.setTotalQuestions(rs.getInt("Total_Questions"));
        user.setScoredMarks(rs.getString("SCORED_MARKS"));
        user.setCorrectAnswers(rs.getInt("Correct_Answers"));
        user.setExamscoredmarks(rs.getString("EXAM_SCORED_MARKS"));
        user.setTotalmarks(rs.getString("total_marks"));
        user.setCorrectanswer1(rs.getInt("Correct_Answers_1"));
        userlist.add(user);
		return user;
	}

}