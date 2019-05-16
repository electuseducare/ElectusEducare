package com.educare.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.model.BookmarkPojo;

public class BookmarkAnalysisMapper implements RowMapper<BookmarkPojo> {

	@Override
	public BookmarkPojo mapRow(ResultSet rs, int arg) throws SQLException {
		BookmarkPojo questions = new BookmarkPojo();

		questions.setQid(rs.getInt("question_id"));
		questions.setExamName(rs.getString("Exam_Name"));
		questions.setSubject(rs.getString("el_subject_name"));
		questions.setQuestion(rs.getString("ques"));
		return questions;
	}

}
