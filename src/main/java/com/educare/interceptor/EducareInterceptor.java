package com.educare.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class EducareInterceptor implements HandlerInterceptor {
	private static final  Logger logger = LoggerFactory.getLogger(EducareInterceptor.class);

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object object, Exception exception)
			throws Exception {
	 
		String start="After Complition -- afterCompletion@@@";
		logger.info(start);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object object, ModelAndView modelAndView) throws Exception {
		
		String start="Post Handler -- postHandle ^^^^^";
		logger.info(start);
		logger.info(start);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object object) throws Exception {
		try {
			ModelAndView modelAndView=new ModelAndView();
			HttpSession session = request.getSession();
			String studentid=(String)session.getAttribute("student_id");
			if(studentid != null){
				modelAndView.addObject("studentid",studentid);
			}else{
				modelAndView.addObject("studentidnull",null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
		    
		   
		}
	
	@ExceptionHandler(ChiselonCustomException.class)
	public ModelAndView handleCustomException(ChiselonCustomException ex) {


		ModelAndView model = new ModelAndView("load-UserHome");
		model.addObject("errCode", ex.getErrCode());
		model.addObject("errMsg", ex.getErrMsg());


		return model;

	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {


		ModelAndView model = new ModelAndView("load-UserHome");
		model.addObject("errMsg", "this is Exception.class");

		return model;

	}

}

