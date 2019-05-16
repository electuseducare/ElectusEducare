package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminAddCompQuesInExamModel;

public class AdmingetExamdataBasedonexamnamemapper implements RowMapper<AdminAddCompQuesInExamModel> {

	@Override
	public AdminAddCompQuesInExamModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		AdminAddCompQuesInExamModel ac = new AdminAddCompQuesInExamModel();
		ac.setStateid(rs.getString("state_type_id"));
		ac.setLocationid(rs.getString("location_id"));
		ac.setBranchid(rs.getString("branch_id"));
		ac.setClassid(rs.getString("class_id"));
		ac.setSectionid(rs.getString("section_id"));
		ac.setTopicid(rs.getString("topic_id"));
		ac.setSubtopicid(rs.getString("subtopic_id"));
		ac.setQuestionleveltypeid(rs.getString("question_level_type_id"));
		ac.setExamtypeid(rs.getString("exam_type_id"));
		ac.setStartdate(rs.getString("startdate"));		
		ac.setEnddate(rs.getString("enddate"));
		ac.setStarttime(rs.getString("starttime"));
		ac.setEndtime(rs.getString("endtime"));
		ac.setTestduration(rs.getString("testduration"));
		ac.setTotalstudentsavilable(rs.getInt("total_students_available"));
		ac.setIsmarks(rs.getString("is_marks"));
		return ac;
	}

}
