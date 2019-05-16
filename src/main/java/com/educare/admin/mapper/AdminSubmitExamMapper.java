package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.model.QuestionPojo;

public class AdminSubmitExamMapper implements RowMapper<QuestionPojo> {

	@Override
	public QuestionPojo mapRow(ResultSet rs, int arg1) throws SQLException {
		QuestionPojo qp  = new QuestionPojo();
		qp.setSectionid(rs.getInt("el_section_id"));
		qp.setBranchid(rs.getInt("el_branch_id"));
		qp.setClassid(rs.getInt("el_class_generated_id"));
		qp.setStateid(rs.getInt("state_type_id"));
		qp.setLocationid(rs.getInt("el_location_id"));
		String name=rs.getString("first_name")+" "+rs.getString("last_name");
		qp.setUsername(name);
		return qp;
	}

}
