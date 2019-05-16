package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminCategory;

public class AdminAddSubjectTopicMapper implements RowMapper<AdminCategory> {

	@Override
	public AdminCategory mapRow(ResultSet rs, int arg1) throws SQLException {
		AdminCategory adm=new AdminCategory();
		adm.setSubject(rs.getString("el_subject_name"));
		adm.setSubjectid(rs.getString("el_subject_id"));
		adm.setCategoryid(rs.getString("el_class_generated_id"));
		return adm;
	}

}
