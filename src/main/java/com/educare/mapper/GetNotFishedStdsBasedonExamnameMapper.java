package com.educare.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminExamNameforReport;

public class GetNotFishedStdsBasedonExamnameMapper implements RowMapper<AdminExamNameforReport> {

	@Override
	public AdminExamNameforReport mapRow(ResultSet rs, int arg1) throws SQLException {
		AdminExamNameforReport sd=new AdminExamNameforReport();
		sd.setUsername(rs.getString("user_name"));
		sd.setStudentid(rs.getString("Student_Id"));
		
		return sd;
	}

}
