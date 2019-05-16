package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.Adminstudentwisequestionerror;

public class AdminquestionwiseerrorreportMapper implements RowMapper<Adminstudentwisequestionerror>{

	@Override
	public Adminstudentwisequestionerror mapRow(ResultSet rs, int arg1) throws SQLException {
		
		Adminstudentwisequestionerror adm=new Adminstudentwisequestionerror();
		adm.setStudentid(rs.getString("student_id"));
		adm.setStudentname(rs.getString("studentname"));
		adm.setSection(rs.getString("el_section_name"));
		adm.setCampus(rs.getString("el_branch_name"));
		adm.setCampusid(rs.getString("campus"));
		adm.setSectionid(rs.getString("section"));
		return adm;
	}

	
}
