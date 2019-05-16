package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminCategory;

public class GetDetailsForBulkSmsMapper implements RowMapper<AdminCategory> {

	@Override
	public AdminCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
		AdminCategory ad=new AdminCategory();
		ad.setStudentid(rs.getString("Student_Id"));
		ad.setFirstname(rs.getString("first_name"));
		ad.setMobile(rs.getString("phone"));
		return ad;
	}

}
