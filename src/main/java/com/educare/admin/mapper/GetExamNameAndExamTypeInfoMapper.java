package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminCategory;

public class GetExamNameAndExamTypeInfoMapper implements RowMapper<AdminCategory> {

	@Override
	public AdminCategory mapRow(ResultSet rs, int arg1) throws SQLException {
		AdminCategory ac = new AdminCategory();
		ac.setExamname(rs.getString("Exam_Name"));
		ac.setExamdate(rs.getString("exam_conducted_date"));
		return ac;
	}

}
