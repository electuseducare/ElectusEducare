package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminCategory;

public class AdminGroupClassMapper implements RowMapper<AdminCategory> {

	@Override
	public AdminCategory mapRow(ResultSet rs, int arg1) throws SQLException {
		
		AdminCategory adm=new AdminCategory();
		adm.setGroup(rs.getString("el_group_name"));
		adm.setGroupid(rs.getString("el_group_id"));
		return adm;
	}

}
