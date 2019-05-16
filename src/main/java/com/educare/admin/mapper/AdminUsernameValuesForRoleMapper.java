package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminAddNewStudent;

public class AdminUsernameValuesForRoleMapper implements RowMapper<AdminAddNewStudent> {

	@Override
	public AdminAddNewStudent mapRow(ResultSet rs, int arg1) throws SQLException {
				AdminAddNewStudent adm=new AdminAddNewStudent();
				adm.setFirstname(rs.getString("first_name"));
				adm.setLastname(rs.getString("last_name"));
				adm.setUsername(rs.getString("user_name"));
				adm.setPassword(rs.getString("password"));
				adm.setSection(rs.getString("el_section_name"));
				adm.setBranch(rs.getString("el_branch_name"));
				adm.setStudentid(rs.getString("student_id"));
				adm.setStudentclass(rs.getString("el_class_name"));
				adm.setUserid(rs.getString("user_id"));
				adm.setEmail(rs.getString("email"));
				adm.setMobile(rs.getString("phone"));
				adm.setLocation(rs.getString("el_location_name"));
				adm.setStatetypeid(rs.getString("state_type_id"));
				adm.setState(rs.getString("state_type"));
				adm.setLocationid(rs.getString("el_location_id"));
				adm.setBranchid(rs.getString("el_branch_id"));
				adm.setSectionid(rs.getString("el_section_id"));
				adm.setStatus(rs.getString("session_id"));
			    return adm;
	}

}
