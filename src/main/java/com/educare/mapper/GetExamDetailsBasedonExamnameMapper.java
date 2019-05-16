package com.educare.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminExamNameforReport;

public class GetExamDetailsBasedonExamnameMapper implements RowMapper<AdminExamNameforReport> {

	@Override
	public AdminExamNameforReport mapRow(ResultSet rs, int arg1) throws SQLException {
		AdminExamNameforReport ex=new AdminExamNameforReport();
		ex.setStateid(rs.getString("state_type_id"));
		ex.setLocationid(rs.getString("location_id"));
		ex.setBrancid(rs.getString("branch_id"));
		ex.setClassid(rs.getString("class_id"));
		ex.setSectionid(rs.getString("section_id"));
	
		return ex;
	}

}
