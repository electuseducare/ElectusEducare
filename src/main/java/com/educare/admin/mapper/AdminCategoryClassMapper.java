package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminCategory;

public class AdminCategoryClassMapper implements RowMapper<AdminCategory> {

	@Override
	public AdminCategory mapRow(ResultSet rs, int arg1) throws SQLException {
		
		AdminCategory category=new AdminCategory();
		category.setCategory(rs.getString("el_class_name"));
		category.setCategoryid(rs.getString("el_class_generated_id"));
		return category;
	}

}
