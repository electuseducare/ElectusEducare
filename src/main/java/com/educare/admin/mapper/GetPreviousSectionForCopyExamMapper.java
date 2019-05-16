package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminCategory;

public class GetPreviousSectionForCopyExamMapper implements RowMapper<AdminCategory> {

	@Override
	public AdminCategory mapRow(ResultSet rs, int arg1) throws SQLException {
		AdminCategory ad = new AdminCategory();
		ad.setSelectedsectionid(rs.getString("el_section_id"));
		ad.setSection(rs.getString("el_section_name"));
		return ad;
	}

}