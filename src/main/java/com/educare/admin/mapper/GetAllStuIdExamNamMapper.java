package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.ResultCalculationModel;

public class GetAllStuIdExamNamMapper implements RowMapper<ResultCalculationModel> {

	@Override
	public ResultCalculationModel mapRow(ResultSet rs, int arg1) throws SQLException {

		ResultCalculationModel view=new ResultCalculationModel();
		
		view.setStudentid(rs.getString("Student_ID"));
		
		return view;
	}

}
