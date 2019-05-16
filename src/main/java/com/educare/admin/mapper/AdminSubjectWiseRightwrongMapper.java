package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminSubjectWiserightwrongrepo;

public class AdminSubjectWiseRightwrongMapper implements RowMapper<AdminSubjectWiserightwrongrepo> {

	@Override
	public AdminSubjectWiserightwrongrepo mapRow(ResultSet rs, int arg1) throws SQLException {
		AdminSubjectWiserightwrongrepo adm=new AdminSubjectWiserightwrongrepo();
		adm.setStudentid(rs.getString("student_id"));
		adm.setStudentname(rs.getString("studentname"));
		adm.setSection(rs.getString("el_section_name"));
		adm.setBranch(rs.getString("el_branch_name"));
		adm.setSubject(rs.getString("el_subject_name"));
		adm.setCampusid(rs.getString("campus"));
		adm.setSectionid(rs.getString("section"));
		adm.setSubjectid(rs.getString("el_subject_id"));
		return adm;
	}

}
