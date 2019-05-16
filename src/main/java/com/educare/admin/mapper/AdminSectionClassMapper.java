package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminCategory;

public class AdminSectionClassMapper implements RowMapper<AdminCategory>{

	@Override
	public AdminCategory mapRow(ResultSet rs, int arg1) throws SQLException {
		AdminCategory section=new AdminCategory();
		section.setSection(rs.getString("el_section_name"));
		section.setSectionid(rs.getString("el_section_id"));
		section.setCategoryid(rs.getString("el_class_generated_id"));
		section.setCategoryname(rs.getString("el_class_name"));
		return section;
	}

}
