package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminCategory;

public class AdminStateAssociatedLCAndBRMapper implements RowMapper<AdminCategory> {

	@Override
	public AdminCategory mapRow(ResultSet rs, int arg1) throws SQLException {
		AdminCategory ac = new AdminCategory();
		ac.setStatename(rs.getString("state_type"));
		ac.setStateid(rs.getInt("state_type_id"));
		ac.setLocation(rs.getString("el_location_name"));
		ac.setLocationid(rs.getString("el_location_id"));
		ac.setBranch(rs.getString("el_branch_name"));
		ac.setBranchid(rs.getString("el_branch_id"));
		return ac;
	}

}
