package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.Adminofflinedatapojo;

public class AdminOfflineExamNamesReportMapper implements RowMapper<Adminofflinedatapojo> {

	@Override
	public Adminofflinedatapojo mapRow(ResultSet rs, int arg1) throws SQLException {
		Adminofflinedatapojo old=new Adminofflinedatapojo();
		old.setExamname(rs.getString("exam_name"));
		return old;
	}

}
