package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminCategory;

public class AdminBranchClassMapper implements RowMapper<AdminCategory>{

	@Override
	public AdminCategory mapRow(ResultSet rs, int arg1) throws SQLException {
		AdminCategory br=new AdminCategory();
		br.setBranch(rs.getString("el_branch_name"));
		br.setBranchid(rs.getString("el_branch_id"));
		br.setLocationid(rs.getString("el_location_id"));
		br.setLocation(rs.getString("el_location_name"));
		br.setStateid(rs.getInt("state_type_id"));
		return br;
	}

}
