package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminCategory;

public class GetSubjectIdExamNameInfoMapper implements RowMapper<AdminCategory> {

	@Override
	public AdminCategory mapRow(ResultSet rs, int arg1) throws SQLException {
		AdminCategory ac = new AdminCategory();
		ac.setSubjectid(rs.getString("el_subject_id"));
		ac.setSubjectname(rs.getString("el_subject_name"));
		ac.setExamtype(rs.getString("Exam_Type"));
		return ac;
	}

}
