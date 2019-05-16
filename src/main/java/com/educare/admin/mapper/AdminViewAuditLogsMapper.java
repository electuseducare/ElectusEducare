package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminViewAuditLogsModel;

public class AdminViewAuditLogsMapper implements RowMapper<AdminViewAuditLogsModel> {

	@Override
	public AdminViewAuditLogsModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		AdminViewAuditLogsModel av=new AdminViewAuditLogsModel();
		av.setStudentid(rs.getString("student_id"));
		av.setUsername(rs.getString("username"));
		av.setLogindate(rs.getString("login_date"));
		av.setLogoutdate(rs.getString("logout_date"));
		av.setExamname(rs.getString("exam_name"));
		av.setExamstarttime(rs.getString("exam_start_date"));
		av.setExamendtime(rs.getString("exam_end_date"));
		av.setExamresumetime(rs.getString("exam_resume_date"));
		
		return av;
	}

}
