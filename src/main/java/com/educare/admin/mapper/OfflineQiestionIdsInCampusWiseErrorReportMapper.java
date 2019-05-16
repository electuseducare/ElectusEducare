package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.CampuswiseErrorreportPojo;

public class OfflineQiestionIdsInCampusWiseErrorReportMapper implements RowMapper<CampuswiseErrorreportPojo>{

	@Override
	public CampuswiseErrorreportPojo mapRow(ResultSet rs, int arg1) throws SQLException {
		CampuswiseErrorreportPojo campus=new CampuswiseErrorreportPojo();
		campus.setQuestionid(rs.getInt("Question_Id"));
		campus.setQuestionrowid(rs.getInt("offline_key_id"));
		return campus;
	}

}
