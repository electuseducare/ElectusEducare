package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminCategory;

public class StudentProfileAverageMarks implements RowMapper<AdminCategory> {

	@Override
	public AdminCategory mapRow(ResultSet rs, int arg1) throws SQLException {
		AdminCategory ac = new AdminCategory();
		ac.setAvgmarks(rs.getString("avgscoredmarks"));
		return ac;
	}

}
