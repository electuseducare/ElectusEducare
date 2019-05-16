package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminCategory;

public class AdminGetFilenamesMapper implements RowMapper<AdminCategory> {

	@Override
	public AdminCategory mapRow(ResultSet rs, int arg1) throws SQLException {
		AdminCategory as=new AdminCategory();
		as.setFilenames(rs.getString("import_file_name"));
		as.setQuestions(rs.getString("ques"));
		as.setCategory(rs.getString("subjtopic"));
		
		return as;
	}

}
