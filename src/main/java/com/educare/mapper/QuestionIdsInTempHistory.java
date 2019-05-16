package com.educare.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.model.QuestionPojo;

public class QuestionIdsInTempHistory implements RowMapper<QuestionPojo>{

	@Override
	public QuestionPojo mapRow(ResultSet rs, int arg1) throws SQLException {
		QuestionPojo ques=new QuestionPojo();
		ques.setQuestion_id(rs.getString("question_Id"));
		ques.setSelected_answer(rs.getString("selected_answer"));
		ques.setSubjectid(rs.getInt("subjectid"));
		ques.setExam_status(rs.getString("Exam_Completion_Status"));
		ques.setQuestionrowid(rs.getInt("exam_paper_id"));
		return ques;
	}

}
