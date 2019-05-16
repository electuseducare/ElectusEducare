package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminSubjectwisemarksRanges;

public class Adminsubjectwisemarksrangemapper implements RowMapper<AdminSubjectwisemarksRanges> {

	@Override
	public AdminSubjectwisemarksRanges mapRow(ResultSet rs, int arg1) throws SQLException {
		AdminSubjectwisemarksRanges adm=new AdminSubjectwisemarksRanges();
		adm.setCampus(rs.getString("el_branch_name"));
	
		adm.setCampusid(rs.getString("campus"));
		return adm;
	}

}
