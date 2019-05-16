package com.educare.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.model.ExamCompletionState;

public class ExamStateMapper implements RowMapper<ExamCompletionState>{

	@Override
	public ExamCompletionState mapRow(ResultSet rs, int arg1) throws SQLException {
		ExamCompletionState examst = new ExamCompletionState();
		examst.setExamn_status(rs.getString("Exam_Completion_Status"));
		examst.setExamname(rs.getString("examname"));
		examst.setExenddate(rs.getString("exam_end_date"));
		examst.setExendtime(rs.getString("exam_end_time"));
		return examst;
	}
	
}
