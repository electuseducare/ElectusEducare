package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminAllIndiaMarksAnalysisPojo;

public class Admingetsubjectidforpresentprevreportmapper implements RowMapper<AdminAllIndiaMarksAnalysisPojo> {

	@Override
	public AdminAllIndiaMarksAnalysisPojo mapRow(ResultSet rs, int arg1) throws SQLException {
		AdminAllIndiaMarksAnalysisPojo adm=new AdminAllIndiaMarksAnalysisPojo();
		adm.setSubjectname(rs.getString("el_subject_name"));
		adm.setSubjectid(rs.getString("el_subject_id"));
		return adm;
	}

}
