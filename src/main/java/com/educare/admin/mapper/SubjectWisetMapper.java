package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.SubjectWiseHighest;

public class SubjectWisetMapper implements RowMapper<SubjectWiseHighest>{

	@Override
	public SubjectWiseHighest mapRow(ResultSet rs, int arg1) throws SQLException {
		
		SubjectWiseHighest subjecrs = new SubjectWiseHighest();
		subjecrs.setHighestscore(rs.getString("highest"));
		return subjecrs;
	}

	
}
