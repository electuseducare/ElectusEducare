package com.educare.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class AdminUploadQuestionsController {
	@RequestMapping("load-uploadQuestions")
	public void uploadQuestions(){
		String filePath = "E:/WordToHtmldotNet-Phase/WordToHtmlUtility/WordToHtmlUtility/obj/Debug/WordToHtmlUtility.exe";
        try {
             
            Runtime.getRuntime().exec(filePath);
             
        } catch (Exception e) {
            e.printStackTrace();
        }
         
    
	}

}
