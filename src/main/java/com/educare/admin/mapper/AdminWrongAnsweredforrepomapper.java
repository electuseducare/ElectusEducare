package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.Adminstudentwisequestionerror;

public class AdminWrongAnsweredforrepomapper  implements RowMapper<Adminstudentwisequestionerror>{

	@Override
	public Adminstudentwisequestionerror mapRow(ResultSet rs, int arg1) throws SQLException {
		
		Adminstudentwisequestionerror adm=new Adminstudentwisequestionerror();
		adm.setWronganswer(rs.getString("wrong_answered"));
		return adm;
	}

}