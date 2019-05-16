package com.educare.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminViewAuditLogsModel;

public class GetStudentIdsMapper implements RowMapper<AdminViewAuditLogsModel> {

	@Override
	public AdminViewAuditLogsModel mapRow(ResultSet rs, int arg1) throws SQLException {

		AdminViewAuditLogsModel view = new AdminViewAuditLogsModel();

		view.setStudentid(rs.getString("student_id"));

		view.setUsername(rs.getString("user_name"));

		return view;
	}

}
