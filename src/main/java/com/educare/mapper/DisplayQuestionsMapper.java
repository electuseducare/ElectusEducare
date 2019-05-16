package com.educare.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.springframework.jdbc.core.RowMapper;

import com.educare.model.OptionPojo;
import com.educare.model.QuestionPojo;

public class DisplayQuestionsMapper implements RowMapper<QuestionPojo> {

	public QuestionPojo mapRow(ResultSet resultSet, int arg1) throws SQLException {
		QuestionPojo questions = new QuestionPojo();

		List<QuestionPojo> questionPojo = new ArrayList<>();
		String qns = (resultSet.getString("ques"));
		org.jsoup.nodes.Document doc =  Jsoup.parse(qns);
		questions.setQues(doc);
		questions.setTypeOfQuestion(resultSet.getString("question_type"));
		
		questions.setExamname(resultSet.getString("exam_name"));
		questions.setStarttime(resultSet.getString("starttime"));
		questions.setEndtime(resultSet.getString("endtime"));
		questions.setSlotdate(resultSet.getString("startdate"));
		questions.setTopicid(resultSet.getString("topic_id"));
		questions.setSubtopicid(resultSet.getString("subtopic_id"));
		questions.setQustypeid(resultSet.getString("Question_type_id"));
		questions.setSubjectid(resultSet.getInt("subject_id"));
		questions.setStartdate(resultSet.getString("startdate"));
		questions.setEnddate(resultSet.getString("enddate"));
		questions.setTestduration(resultSet.getString("testduration"));
		questions.setMarks_per_qus_type(resultSet.getString("marks_per_qus_type"));
		questions.setNegative_marks(resultSet.getString("Negative_marks"));
		questions.setEndtime(resultSet.getString("endtime"));
		questions.setQuestionrowid(resultSet.getInt("exam_paper_id"));
		questions.setIsjumbling(resultSet.getString("is_jumbling"));
		List<OptionPojo> optionsList = new ArrayList<>();
		if(questions.getTypeOfQuestion().equals("True Or False")){
			OptionPojo optionPojoA = new OptionPojo();
			optionPojoA.setOptionType("True");
			optionPojoA.setOption(resultSet.getString("OptionA"));		
			optionsList.add(optionPojoA);
			
			OptionPojo optionPojoB = new OptionPojo();
			optionPojoB.setOptionType("False");
			optionPojoB.setOption(resultSet.getString("OptionB"));
			optionsList.add(optionPojoB);
		}else{
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
		}
		questions.setOptionsList(optionsList);
		questions.setAnswer( resultSet.getString("answer").replaceAll("\\<.*?\\>", "").replaceAll("\\s+", ""));
		questions.setQuestion_id(resultSet.getString("question_Id"));
		questions.setFilenames(resultSet.getString("import_file_name"));
		
		questionPojo.add(questions);
		return questions;
	}
}
