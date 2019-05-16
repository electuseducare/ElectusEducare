package com.educare.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.model.QuestionPojo;

public class ExamTotalMarks_and_TotalAvailablestudents implements RowMapper<QuestionPojo>
{

	@Override
	public QuestionPojo mapRow(ResultSet rs, int arg1) throws SQLException {
		QuestionPojo qus=new QuestionPojo();
		qus.setToatalmarks(rs.getString("total_marks"));
		qus.setTotal_available_students(rs.getInt("total_students_available"));
		qus.setSlotdate(rs.getString("startdate"));
		return qus;
	}

}
