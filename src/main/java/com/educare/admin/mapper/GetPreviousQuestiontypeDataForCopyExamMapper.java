package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminCategory;

public class GetPreviousQuestiontypeDataForCopyExamMapper implements RowMapper<AdminCategory> {

	@Override
	public AdminCategory mapRow(ResultSet rs, int arg1) throws SQLException {
		AdminCategory ad=new AdminCategory();
		ad.setMarksperquestiontype(rs.getString("marks_per_qus_type"));
		ad.setNumofqusperqustype(rs.getString("No_Of_Qus_Per_QusType"));
		ad.setSelectedsubjectid(rs.getString("subject_id"));
		ad.setNmarksperquestiontype(rs.getString("Negative_marks"));
		return ad;
	}

}
