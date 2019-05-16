package com.educare.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.model.Instructionspojo;

public class InstructionDetailsMapper implements RowMapper<Instructionspojo> {

	@Override
	public Instructionspojo mapRow(ResultSet rs, int arg1) throws SQLException {
		Instructionspojo detail=new Instructionspojo();
		detail.setSubjectname(rs.getString("el_subject_name"));
		detail.setQuestiontype(rs.getString("question_type"));
		detail.setNoofquestions(rs.getString("No_Of_Qus_Per_QusType"));
		detail.setNegativemarks(rs.getString("Negative_marks"));
		detail.setMarksperquestype(rs.getString("marks_per_qus_type"));
		return detail;
	}

}
