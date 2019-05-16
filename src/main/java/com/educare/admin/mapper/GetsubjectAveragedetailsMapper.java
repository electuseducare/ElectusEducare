package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminCategory;

public class GetsubjectAveragedetailsMapper implements RowMapper<AdminCategory> {

	@Override
	public AdminCategory mapRow(ResultSet rs, int arg1) throws SQLException {
		AdminCategory ad=new AdminCategory();
		ad.setSubject(rs.getString("el_subject_name"));
		ad.setSubjectid(rs.getString("el_subject_id"));
		return ad;
	}

}
