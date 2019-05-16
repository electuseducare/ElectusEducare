package com.educare.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminCategory;

public class GetSubjectMapper implements RowMapper<AdminCategory> {

	@Override
	public AdminCategory mapRow(ResultSet rs, int arg1) throws SQLException {

		AdminCategory view=new AdminCategory();
		
		view.setSubject(rs.getString("el_subject_name"));
		view.setSubjectid(rs.getString("el_subject_id"));
		
		
		return view;
	}

}
