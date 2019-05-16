package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.UpdateKeyModel;

public class GetAllUpdateKeyMapper implements RowMapper<UpdateKeyModel> {

	@Override
	public UpdateKeyModel mapRow(ResultSet rs, int arg1) throws SQLException {
   
		UpdateKeyModel view=new UpdateKeyModel();
		 view.setQuesid(rs.getInt("Question_Id"));
		 view.setQuestions(rs.getString("ques"));
		view.setKey(rs.getString("answer"));
		view.setImpfilename(rs.getString("import_file_name"));
		return view;
	}

}
