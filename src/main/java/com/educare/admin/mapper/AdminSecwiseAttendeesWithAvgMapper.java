package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminSecwiseAttendeesWithAvgPojo;

public class AdminSecwiseAttendeesWithAvgMapper implements RowMapper<AdminSecwiseAttendeesWithAvgPojo> {

	@Override
	public AdminSecwiseAttendeesWithAvgPojo mapRow(ResultSet rs, int arg1) throws SQLException {

		AdminSecwiseAttendeesWithAvgPojo category=new AdminSecwiseAttendeesWithAvgPojo();
		category.setCampusid(rs.getInt("el_branch_id"));
		category.setCampusname(rs.getString("el_branch_name"));
		category.setSectionid(rs.getInt("el_section_id"));
		category.setSectionname(rs.getString("el_section_name"));
		return category;
	}

}
