package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminCategory;

public class AdminQuestionsFromSelectedFilenamesMapper implements RowMapper<AdminCategory> {

	@Override
	public AdminCategory mapRow(ResultSet rs, int arg1) throws SQLException {
		AdminCategory ad=new AdminCategory();
		ad.setQuestions(rs.getString("ques"));
		ad.setFilenames(rs.getString("import_file_name"));
		return ad;
	}

}
