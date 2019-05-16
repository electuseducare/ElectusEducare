package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.Adminstudentwisequestionerror;

public class AdminRightAnswerforReportMapper implements RowMapper<Adminstudentwisequestionerror>{

	@Override
	public Adminstudentwisequestionerror mapRow(ResultSet rs, int arg1) throws SQLException {
		
		Adminstudentwisequestionerror adm=new Adminstudentwisequestionerror();
		adm.setRightanswer(rs.getString("right_answered"));
		return adm;
	}

}
