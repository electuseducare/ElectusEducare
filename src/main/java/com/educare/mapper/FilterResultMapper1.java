package com.educare.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.springframework.jdbc.core.RowMapper;

import com.educare.model.FilterResultPojo;

public class FilterResultMapper1 implements RowMapper<FilterResultPojo> {

	@Override
	public FilterResultPojo mapRow(ResultSet rs, int rowNum) throws SQLException {
		FilterResultPojo resultObject = new FilterResultPojo();
		List<FilterResultPojo> listresults=new ArrayList<>();
		
		resultObject.setAnswered(rs.getString("right_answered"));
		resultObject.setNotanswered(rs.getString("not_answered"));
		resultObject.setWronganswered(rs.getString("wrong_answered"));
		resultObject.setQuestion_Id(rs.getInt("Question_Id"));
		resultObject.setQanswer(rs.getString("correct_answer"));
		resultObject.setSubjname(rs.getString("el_subject_name"));
		resultObject.setQanswer(rs.getString("correct_answer"));
		resultObject.setTimedifference(rs.getInt("time_difference"));
		String qns = (rs.getString("ques"));
		org.jsoup.nodes.Document doc =  Jsoup.parse(qns);
		resultObject.setQues(doc);
		listresults.add(resultObject);
		
		return resultObject;
	}

}
