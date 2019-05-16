package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminCategory;

public class AdminBranchNamesMapper implements RowMapper<AdminCategory>{

	@Override
	public AdminCategory mapRow(ResultSet rs, int arg1) throws SQLException {
		AdminCategory adm=new AdminCategory();
		adm.setBranch(rs.getString("el_branch_name"));
		adm.setBranchid(rs.getString("el_branch_id"));
		
		return adm;
	}

}
