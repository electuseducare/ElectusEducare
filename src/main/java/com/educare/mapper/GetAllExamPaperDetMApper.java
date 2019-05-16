package com.educare.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.model.StudentExamAssignModel;

public class GetAllExamPaperDetMApper implements RowMapper<StudentExamAssignModel> {

	@Override
	public StudentExamAssignModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		StudentExamAssignModel view=new StudentExamAssignModel();
		
		view.setSubjectid(rs.getInt("subject_id"));
		view.setQuestionid(rs.getInt("Question_id"));
		view.setLocationid(rs.getInt("location_id"));
        view.setBranchid(rs.getInt("branch_id"));
        view.setClassid(rs.getString("class_id"));
		view.setSectionid(rs.getInt("section_id"));
		view.setExampaperid(rs.getInt("exam_paper_id"));
		view.setMarksperques(rs.getInt("marks_per_qus_type"));
		view.setNegmarks(rs.getString("Negative_marks"));
		view.setQuestypeid(rs.getInt("Question_type_id"));
		view.setIsjumbling(rs.getString("is_jumbling"));
		view.setFilename(rs.getString("filename"));
		return view;
	}

}
