package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.Adminstudentwisequestionerror;

public class AdminQuestionidforqerrormapper implements RowMapper<Adminstudentwisequestionerror> {

	@Override
	public Adminstudentwisequestionerror mapRow(ResultSet rs, int arg1) throws SQLException {
		
		Adminstudentwisequestionerror adm=new Adminstudentwisequestionerror();
		adm.setQuestionid(rs.getInt("question_id"));
		adm.setQuestionrowid(rs.getInt("exam_paper_id"));
		return adm;
	}

}
