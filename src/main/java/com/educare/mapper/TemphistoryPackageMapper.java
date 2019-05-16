package com.educare.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.model.TempHistoryPackage;

public class TemphistoryPackageMapper implements RowMapper<TempHistoryPackage> {

	public TempHistoryPackage mapRow(ResultSet rs, int arg1) throws SQLException {
		TempHistoryPackage thp  = new TempHistoryPackage();
		thp.setStudent_Id(rs.getString("student_Id"));
		thp.setExamname(rs.getString("examname"));
		thp.setSubjectid(rs.getInt("subjectid"));
		thp.setQuestionid(rs.getInt("question_Id"));
		thp.setSelectedanswer(rs.getString("selected_answer"));
		thp.setBranchid(rs.getInt("branch_id"));
		thp.setLocationid(rs.getInt("location_id"));
		thp.setClassid(rs.getInt("class_id"));
		thp.setSectionid(rs.getInt("section_id"));
		thp.setTime_taken_val(rs.getString("time_taken_value"));
		thp.setActualexamstarttime(rs.getString("actual_exam_start_time"));
		thp.setActualqunattemptime(rs.getString("actual_answer_question_time"));
		thp.setTimediff(rs.getString("time_difference"));
		return thp;
	}

}