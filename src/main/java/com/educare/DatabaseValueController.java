package com.educare;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;

@Controller
public class DatabaseValueController {

	public String getDatabaseValue(HttpSession session, HttpServletRequest req) {
		String dbval = (StringUtils.isEmpty((String) session.getAttribute("keyDS"))) ? "0"
				: (String) (session.getAttribute("keyDS"));
		return dbval;
	}
	
	
	

}
