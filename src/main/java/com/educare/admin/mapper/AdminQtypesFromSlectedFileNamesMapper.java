package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminQtypesFromSlectedFileNamesModel;

public class AdminQtypesFromSlectedFileNamesMapper implements RowMapper<AdminQtypesFromSlectedFileNamesModel> {

	@Override
	public AdminQtypesFromSlectedFileNamesModel mapRow(ResultSet rs, int arg1) throws SQLException {
		AdminQtypesFromSlectedFileNamesModel aq = new AdminQtypesFromSlectedFileNamesModel();
		aq.setQuestiontype(rs.getString("questiontypeid"));
		aq.setNoofqnspersubject(rs.getInt("numberofqns"));
		aq.setQuestiontype1(rs.getString("question_type"));
		return aq;
	}

}
