package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.Adminofflinedatapojo;


public class AdminGetQustypeidFromOfflineMapper implements RowMapper<Adminofflinedatapojo> {

	@Override
	public Adminofflinedatapojo mapRow(ResultSet rs, int arg1) throws SQLException {
		Adminofflinedatapojo ad=new Adminofflinedatapojo();
		ad.setQuestiontypeid(rs.getString("question_type_id"));
		return ad;
	}

}
