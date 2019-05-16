package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminCategory;

public class GetExamNameForSeendingBulkSmsMapper implements RowMapper<AdminCategory> {

	@Override
	public AdminCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
		AdminCategory ad=new AdminCategory();
		ad.setExamname(rs.getString("Exam_Name"));
		return ad;
	}

}
