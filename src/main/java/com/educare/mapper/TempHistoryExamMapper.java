package com.educare.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.springframework.jdbc.core.RowMapper;

import com.educare.model.OptionPojo;
import com.educare.model.QuestionPojo;

public class TempHistoryExamMapper implements RowMapper<QuestionPojo> {


@Override
public QuestionPojo mapRow(ResultSet resultSet, int arg1) throws SQLException {
	
	QuestionPojo questions = new QuestionPojo();
	List<QuestionPojo> questionPojo = new ArrayList<>();
	String qns = (resultSet.getString("ques"));
	org.jsoup.nodes.Document doc =  Jsoup.parse(qns);
	questions.setQues(doc);
	questions.setTypeOfQuestion(resultSet.getString("question_type"));
	if(resultSet.getString("selected_answer")!=null){
		questions.setSelected_answer(resultSet.getString("selected_answer").trim());
	}
	else{
    questions.setSelected_answer(resultSet.getString("selected_answer"));
	}
    questions.setQuestionrowid(resultSet.getInt("exam_paper_id"));
    questions.setSubjectid(resultSet.getInt("subjectid"));
    questions.setMarks_per_qus_type(resultSet.getString("marks_per_qus_type"));
	questions.setNegative_marks(resultSet.getString("Negative_marks"));
			/**** important****
		questions.	 
		questions.setSubject_type(resultSet.getString("subject_type"));
		questions.setExam_type(resultSet.getString("exam_type"));
		questions.setOrderid(resultSet.getString("Order_Id"));

	
		questions.setSubject(resultSet.getString("subjectid"));
		questions.setExamname(resultSet.getString("examname"));
		questions.setLocationid(resultSet.getInt("location_id"));
		questions.setLocationid(resultSet.getInt("branch_id"));
		questions.setClassid(resultSet.getInt("class_id"));
		questions.setSectionid(resultSet.getInt("section_id"));
			***/
	questions.setTime_taken_value(resultSet.getString("time_taken_value"));
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
	questions.setEndtime(resultSet.getString("endtime"));
	questions.setOptionsList(optionsList);
	questions.setAnswer( resultSet.getString("answer").replaceAll("\\<.*?\\>", "").replaceAll("\\s+", ""));

	questions.setQuestion_id(resultSet.getString("question_Id"));
	questionPojo.add(questions);
	return questions;
}
	

}
