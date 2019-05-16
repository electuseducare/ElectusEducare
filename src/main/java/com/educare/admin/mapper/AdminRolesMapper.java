package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.Adminaddrolespojo;

public class AdminRolesMapper implements RowMapper<Adminaddrolespojo> {

	@Override
	public Adminaddrolespojo mapRow(ResultSet rs, int arg1) throws SQLException {
		Adminaddrolespojo adrole=new Adminaddrolespojo();
		adrole.setRoles(rs.getString("role_name"));
		adrole.setRoleid(rs.getString("role_id"));

		
		return adrole;
	}

}
