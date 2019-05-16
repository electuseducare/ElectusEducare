package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.SubjectWiseHighestReport;

public class SubjectWiseHighestMapper implements RowMapper<SubjectWiseHighestReport>{
	
	@Override
	public SubjectWiseHighestReport mapRow(ResultSet rs, int arg1) throws SQLException {
		
		
		SubjectWiseHighestReport  subjhrepo= new SubjectWiseHighestReport() ;
		subjhrepo.setCampus(rs.getString("el_branch_name"));
		subjhrepo.setCampusid(rs.getString("campus"));
		return subjhrepo;
	}

}
