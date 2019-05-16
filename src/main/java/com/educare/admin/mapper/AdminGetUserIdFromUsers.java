package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.model.Register;

public class AdminGetUserIdFromUsers implements RowMapper<Register> {

	@Override
	public Register mapRow(ResultSet rs, int arg1) throws SQLException {
		Register rg=new Register();
		rg.setUserid(rs.getInt("user_id"));
		return rg;
	}

}
