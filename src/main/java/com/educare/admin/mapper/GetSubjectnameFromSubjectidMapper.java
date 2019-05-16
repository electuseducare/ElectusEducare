package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminViewExamQuesPaperModel;

public class GetSubjectnameFromSubjectidMapper implements RowMapper<AdminViewExamQuesPaperModel> {

	@Override
	public AdminViewExamQuesPaperModel mapRow(ResultSet rs, int arg1) throws SQLException {
		AdminViewExamQuesPaperModel av=new AdminViewExamQuesPaperModel();
		av.setSubjectid(rs.getInt("el_subject_id"));
		av.setSubjectname(rs.getString("el_subject_name"));
		
		return av;
	}

}
