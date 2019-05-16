package com.educare.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminExamNameforReport;

public class GetExamResultStausDetailsMapper implements RowMapper<AdminExamNameforReport> {

	@Override
	public AdminExamNameforReport mapRow(ResultSet rs, int arg1) throws SQLException {
		AdminExamNameforReport ex=new AdminExamNameforReport();
		ex.setStudentid(rs.getString("Student_Id"));
		ex.setUsername(rs.getString("username"));
		ex.setScoredmarks(rs.getString("EXAM_SCORED_MARKS"));
		ex.setExamstatus(rs.getString("examstatus"));
		return ex;
	}

}
