package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.Questionanalysispojo;

public class QuestionwiseAnalysisMapper implements RowMapper<Questionanalysispojo> {

	@Override
	public Questionanalysispojo mapRow(ResultSet rs, int arg1) throws SQLException {
		Questionanalysispojo qp=new Questionanalysispojo();
		
		qp.setFirstname(rs.getString("first_name"));
		qp.setUsername(rs.getString("user_name"));
		qp.setClassval(rs.getString("el_class_name"));
		qp.setStudentid(rs.getString("Student_Id"));
		qp.setSection(rs.getString("el_section_name"));
		qp.setLastname(rs.getString("last_name"));
		return qp;
	}

}
