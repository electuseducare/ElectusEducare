package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminViewExamQuesPaperModel;
import com.educare.model.OptionPojo;

public class GetDisplayQuesToViewQuepaperMapper implements RowMapper<AdminViewExamQuesPaperModel> {

	@Override
	public AdminViewExamQuesPaperModel mapRow(ResultSet rs, int arg1) throws SQLException {
		AdminViewExamQuesPaperModel av=new AdminViewExamQuesPaperModel();
		List<AdminViewExamQuesPaperModel> questionPojo = new ArrayList<>();
		String qns = (rs.getString("ques"));
		org.jsoup.nodes.Document doc =  Jsoup.parse(qns);
		String sol = (rs.getString("analysis"));
		org.jsoup.nodes.Document sols =  Jsoup.parse(sol);
		av.setSolutions(sols);
		av.setQues(doc);
		av.setTypeOfQuestion(rs.getString("question_type"));
		
		List<OptionPojo> optionsList = new ArrayList<>();
		if(av.getTypeOfQuestion().equals("True Or False")){
			OptionPojo optionPojoA = new OptionPojo();
			optionPojoA.setOptionType("True");
			optionPojoA.setOption(rs.getString("OptionA"));		
			optionsList.add(optionPojoA);
			
			OptionPojo optionPojoB = new OptionPojo();
			optionPojoB.setOptionType("False");
			optionPojoB.setOption(rs.getString("OptionB"));
			optionsList.add(optionPojoB);
		}else{
		OptionPojo optionPojoA = new OptionPojo();
		optionPojoA.setOptionType("A");
		optionPojoA.setOption(rs.getString("OptionA"));		
		optionsList.add(optionPojoA);
		
		OptionPojo optionPojoB = new OptionPojo();
		optionPojoB.setOptionType("B");
		optionPojoB.setOption(rs.getString("OptionB"));
		optionsList.add(optionPojoB);
		
		OptionPojo optionPojoC = new OptionPojo();
		optionPojoC.setOptionType("C");
		optionPojoC.setOption(rs.getString("OptionC"));
		optionsList.add(optionPojoC);
		
		OptionPojo optionPojoD = new OptionPojo();
		optionPojoD.setOptionType("D");
		optionPojoD.setOption(rs.getString("OptionD"));
		optionsList.add(optionPojoD);
		
		String optione=rs.getString("OptionE");
		if(optione!=null){
			OptionPojo optionPojoE = new OptionPojo();
			optionPojoE.setOptionType("E");
		optionPojoE.setOption(rs.getString("OptionE"));
		optionsList.add(optionPojoE);
		}

		}
		
		av.setOptionsList(optionsList);
		av.setAnswer( rs.getString("answer").replaceAll("\\<.*?\\>", "").replaceAll("\\s+", ""));
		av.setQuestion_id(rs.getString("question_Id"));
		questionPojo.add(av);
		
		return av;
	}

}
