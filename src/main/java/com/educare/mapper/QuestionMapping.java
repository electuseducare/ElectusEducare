package com.educare.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.springframework.jdbc.core.RowMapper;

import com.educare.model.OptionPojo;
import com.educare.model.QuestionPojo;

public class QuestionMapping  implements RowMapper<QuestionPojo> {

	public QuestionPojo mapRow(ResultSet resultSet, int arg1) throws SQLException {
		QuestionPojo questions = new QuestionPojo();

		List<QuestionPojo> questionPojo = new ArrayList<>();
		String qns = (resultSet.getString("ques"));
		org.jsoup.nodes.Document doc =  Jsoup.parse(qns);
		questions.setQues(doc);
		questions.setTypeOfQuestion(resultSet.getString("question_type"));
		questions.setSubject(resultSet.getString("el_subject_name"));
		questions.setTopicid(resultSet.getString("topic"));
		questions.setSubtopicid(resultSet.getString("subtopic"));
		questions.setQustypeid(resultSet.getString("Question_type_id"));
		questions.setSubjectid(resultSet.getInt("el_subject_id"));
		List<OptionPojo> optionsList = new ArrayList<>();
		
		OptionPojo optionPojoA = new OptionPojo();
		optionPojoA.setOptionType("A");
		optionPojoA.setOption(resultSet.getString("OptionA"));		
		optionsList.add(optionPojoA);
		
		OptionPojo optionPojoB = new OptionPojo();
		optionPojoB.setOptionType("B");
		optionPojoB.setOption(resultSet.getString("OptionB"));
		optionsList.add(optionPojoB);
		
		OptionPojo optionPojoC = new OptionPojo();
		optionPojoC.setOptionType("C");
		optionPojoC.setOption(resultSet.getString("OptionC"));
		optionsList.add(optionPojoC);
		
		OptionPojo optionPojoD = new OptionPojo();
		optionPojoD.setOptionType("D");
		optionPojoD.setOption(resultSet.getString("OptionD"));
		optionsList.add(optionPojoD);

		questions.setOptionsList(optionsList);
		questions.setAnswer( resultSet.getString("answer").replaceAll("\\<.*?\\>", "").replaceAll("\\s+", ""));
		questions.setQuestion_id(resultSet.getString("question_Id"));
		
		questionPojo.add(questions);
		return questions;
	}
}
