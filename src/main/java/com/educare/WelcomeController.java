package com.educare;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class WelcomeController {
  
	

	@RequestMapping("/")
	public String userHome(Model model) {
		
		return "UserHome";
	}
	@RequestMapping("/load-selectschool")
	public String selectSchool(Model model) {
		
		return "home";
	}




}