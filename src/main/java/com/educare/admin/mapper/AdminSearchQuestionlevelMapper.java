package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminCategory;

public class AdminSearchQuestionlevelMapper implements RowMapper<AdminCategory> {

	@Override
	public AdminCategory mapRow(ResultSet rs, int arg1) throws SQLException {
		
		AdminCategory category=new AdminCategory();
		category.setQuestionlevel(rs.getString("Question_Level_Type"));
		category.setQuestionleveltypeid(rs.getInt("Question_Level_Type_Id"));;
		return category;
	}

}
