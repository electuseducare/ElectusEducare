package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminInsertQuestionsInTempModel;

public class AdmingetDataInExampaperMapper implements RowMapper<AdminInsertQuestionsInTempModel> {

	@Override
	public AdminInsertQuestionsInTempModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		AdminInsertQuestionsInTempModel aq=new AdminInsertQuestionsInTempModel();
		aq.setSubjectid(rs.getInt("subject_id"));
		aq.setQuestionid(rs.getInt("Question_id"));
        aq.setMarkperquestiontype(rs.getInt("marks_per_qus_type"));		
        aq.setNagativemarks(rs.getInt("Negative_marks"));
        aq.setQuestionpaperid(rs.getInt("exam_paper_id"));
        aq.setQuestiontypeid(rs.getString("Question_type_id"));
		return aq;
	}

}
