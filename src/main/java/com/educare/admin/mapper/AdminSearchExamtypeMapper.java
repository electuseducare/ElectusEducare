package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminCategory;

public class AdminSearchExamtypeMapper implements RowMapper<AdminCategory> {

	@Override
	public AdminCategory mapRow(ResultSet rs, int arg1) throws SQLException {
		
		AdminCategory category=new AdminCategory();
		category.setExamtype(rs.getString("Exam_Type"));
		category.setExamtype_id(rs.getString("Exam_Type_Id"));
		return category;
	}

}

