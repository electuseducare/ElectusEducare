package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.Adminofflinedatapojo;

public class OfflineUserDataMapper implements RowMapper<Adminofflinedatapojo> {

	@Override
	public Adminofflinedatapojo mapRow(ResultSet rs, int arg1) throws SQLException {

		Adminofflinedatapojo adm=new Adminofflinedatapojo();
		adm.setBranchid(rs.getInt("el_branch_id"));
		adm.setClassid(rs.getInt("el_class_generated_id"));
		adm.setSectionid(rs.getInt("el_section_id"));
		adm.setStateid(rs.getInt("state_type_id"));
		adm.setLocationid(rs.getInt("el_location_id"));
		adm.setFirstname(rs.getString("first_name"));
		adm.setStudentid(rs.getString("Student_ID"));
		return adm;
	}

}
