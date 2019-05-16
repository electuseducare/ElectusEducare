package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminBelow100RanksInSubjectInCampusPojo;

public class AdminGetCampusnamesInBelow100RanksIncampuswiseReportMapper implements RowMapper<AdminBelow100RanksInSubjectInCampusPojo>
{

	@Override
	public AdminBelow100RanksInSubjectInCampusPojo mapRow(ResultSet rs, int arg1) throws SQLException {
		AdminBelow100RanksInSubjectInCampusPojo admin=new AdminBelow100RanksInSubjectInCampusPojo();
		admin.setCampus(rs.getString("el_branch_name"));
		admin.setCampusid(rs.getInt("el_branch_id"));
		return admin;
	}

}
