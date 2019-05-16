package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.Adminofflinedatapojo;

public class AdminGetSubjectidsFromOfflineMapper implements RowMapper<Adminofflinedatapojo> {

	@Override
	public Adminofflinedatapojo mapRow(ResultSet rs, int arg1) throws SQLException {
		Adminofflinedatapojo ad=new Adminofflinedatapojo();
		ad.setSubjectid(rs.getString("el_subject_id"));
		return ad;
	}

}
