package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminCategory;

public class AdminGetTopicIdsMapper implements RowMapper<AdminCategory>{

	@Override
	public AdminCategory mapRow(ResultSet rs, int arg1) throws SQLException {
		AdminCategory adm=new AdminCategory();
		adm.setTopicid(rs.getString("subject_topic_type_id"));
		return adm;
	}

}
