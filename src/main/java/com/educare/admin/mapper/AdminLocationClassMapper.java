package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminCategory;

public class AdminLocationClassMapper implements RowMapper<AdminCategory> {

	@Override
	public AdminCategory mapRow(ResultSet rs, int arg1) throws SQLException {
		
		AdminCategory adm=new AdminCategory();
		adm.setLocation(rs.getString("el_location_name"));
		adm.setLocationid(rs.getString("el_location_id"));
		adm.setStateid(rs.getInt("state_type_id"));
		adm.setStatename(rs.getString("state_type"));
		return adm;
	}



}
