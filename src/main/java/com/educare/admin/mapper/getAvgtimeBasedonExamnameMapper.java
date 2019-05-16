package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.Questionanalysispojo;

public class getAvgtimeBasedonExamnameMapper implements RowMapper<Questionanalysispojo> {

	@Override
	public Questionanalysispojo mapRow(ResultSet rs, int arg1) throws SQLException {
		Questionanalysispojo ques=new Questionanalysispojo();
		ques.setFilename(rs.getString("import_file_name"));
		ques.setAvgtime(rs.getString("time_difference"));
		
		return ques;
	}

}
