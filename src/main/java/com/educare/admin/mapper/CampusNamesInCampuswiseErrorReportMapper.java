package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.CampuswiseErrorreportPojo;

public class CampusNamesInCampuswiseErrorReportMapper implements RowMapper<CampuswiseErrorreportPojo>
{

	@Override
	public CampuswiseErrorreportPojo mapRow(ResultSet rs, int arg1) throws SQLException {
		CampuswiseErrorreportPojo campus=new CampuswiseErrorreportPojo();
		campus.setCampus(rs.getString("el_branch_name"));
		campus.setCampusid(rs.getInt("el_branch_id"));
		
		return campus;
	}

}
