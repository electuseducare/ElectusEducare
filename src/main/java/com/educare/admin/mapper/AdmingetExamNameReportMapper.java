package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminExamNameforReport;

public class AdmingetExamNameReportMapper implements RowMapper<AdminExamNameforReport> {

	@Override
	public AdminExamNameforReport mapRow(ResultSet rs, int arg1) throws SQLException {
		AdminExamNameforReport adm=new AdminExamNameforReport();
		adm.setExamname(rs.getString("Exam_Name"));
		return adm;
	}

}
