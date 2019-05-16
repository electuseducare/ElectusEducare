package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.CampuswiseErrorreportPojo;

public class StateNamesInCampuswiseErrorReportMapper implements RowMapper<CampuswiseErrorreportPojo>  {

	@Override
	public CampuswiseErrorreportPojo mapRow(ResultSet rs, int arg1) throws SQLException {
		
		CampuswiseErrorreportPojo adm=new CampuswiseErrorreportPojo();
		adm.setState(rs.getString("state_type"));
		adm.setStateid(rs.getInt("state_type_id"));
		return adm;
	}


}
