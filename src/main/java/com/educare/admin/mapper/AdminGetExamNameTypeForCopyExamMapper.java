package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminCategory;

public class AdminGetExamNameTypeForCopyExamMapper implements RowMapper<AdminCategory> {

	@Override
	public AdminCategory mapRow(ResultSet rs, int arg1) throws SQLException {
		AdminCategory ad = new AdminCategory();
		ad.setExamname(rs.getString("Exam_Name"));
		ad.setExamtype(rs.getString("Exam_Type"));
		ad.setExamtype_id(rs.getString("Exam_Type_Id"));
		return ad;
	}

}
