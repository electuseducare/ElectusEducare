package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.Adminofflinedatapojo;

public class OfflineExamNamesMapper implements RowMapper<Adminofflinedatapojo> {

	@Override
	public Adminofflinedatapojo mapRow(ResultSet rs, int arg1) throws SQLException {

		Adminofflinedatapojo adm=new Adminofflinedatapojo();
		adm.setExamname(rs.getString("exam_name"));
		return adm;
	}

}
