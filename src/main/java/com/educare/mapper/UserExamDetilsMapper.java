package com.educare.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.model.QuestionPojo;

public class UserExamDetilsMapper implements RowMapper<QuestionPojo>
{

	@Override
	public QuestionPojo mapRow(ResultSet rs, int arg1) throws SQLException {
		QuestionPojo user=new QuestionPojo();
		user.setExamname(rs.getString("exam_name"));
		user.setStarttime(rs.getString("starttime"));
		user.setEndtime(rs.getString("endtime"));
		user.setSlotdate(rs.getString("startdate"));
		user.setEnddate(rs.getString("enddate"));
		user.setSubject(rs.getString("el_subject_name"));
		user.setSubjectid(rs.getInt("subject_id"));
		user.setTopicid(rs.getString("topic_id"));
		user.setSubtopicid(rs.getString("subtopic_id"));
		user.setNumofquesperqustype(rs.getInt("marks_per_qus_type"));
		user.setQustypeid(rs.getString("Question_type_id"));
		user.setExam_type(rs.getString("Exam_Type"));
		user.setPatterntypeid(rs.getString("pattern_type_id"));
		user.setTestduration(rs.getString("testduration"));
		return user;
	}

}
