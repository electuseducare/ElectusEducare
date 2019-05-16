package com.educare.multidb;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
 
// This is a DataSource.
public class MyRoutingDataSource extends AbstractRoutingDataSource {
	

  String keydsvalue = "keyDS";
	
   @Override
   protected Object determineCurrentLookupKey() {
 
      HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
            .getRequest();
 
     
      HttpSession session = request.getSession();
     
     
      String keyDS=(String) session.getAttribute(keydsvalue);
      
      
      if(keyDS==null){
    	  request.setAttribute(keydsvalue, "0");
    	  keyDS = "0";
      }
      if(keyDS.equals("1")){
    	 
      	 request.setAttribute(keydsvalue, "1");
      	  keyDS = "1";
      }
      if(keyDS.equals("2")){
    	  
    	  request.setAttribute(keydsvalue, "2");
    	  keyDS = "2";
      }
      if(keyDS.equals("3")){
    	  
    	  request.setAttribute(keydsvalue, "3");
    	  keyDS = "3";
      }
      if(keyDS.equals("4")){
    	  
    	  request.setAttribute(keydsvalue, "4");
    	  keyDS = "4";
      }
      if(keyDS.equals("5")){
    	  
    	  request.setAttribute(keydsvalue, "5");
    	  keyDS = "5";
      }
      if(keyDS.equals("6")){
    	  
    	  request.setAttribute(keydsvalue, "6");
    	  keyDS = "6";
      }
      if(keyDS.equals("7")){
    	  
    	  request.setAttribute(keydsvalue, "7");
    	  keyDS = "7";
      }
      if(keyDS.equals("8")){
    	  
    	  request.setAttribute(keydsvalue, "8");
    	  keyDS = "8";
      }
      if(keyDS.equals("9")){
    	  
    	  request.setAttribute(keydsvalue, "9");
    	  keyDS = "9";
      }
      if(keyDS.equals("10")){
    	  
    	  request.setAttribute(keydsvalue, "10");
    	  keyDS = "10";
      }
     
 
      session.setAttribute(keydsvalue, keyDS);
      
      return keyDS;
   }
   
   public void initDataSources(DataSource dataSourcedefault, DataSource electusQA,DataSource shivajividhya,DataSource vagdhevi,DataSource surya,DataSource akshara,DataSource vishra,DataSource shakuntala, DataSource metagate, DataSource chiselon,DataSource pioneer) {
      Map<Object, Object> dsMap = new HashMap<>();
      dsMap.put("0", dataSourcedefault);
      dsMap.put("1", electusQA);
      dsMap.put("2", shivajividhya);
      dsMap.put("3", vagdhevi);
      dsMap.put("4", surya);
      dsMap.put("5", akshara);
      dsMap.put("6", vishra);
      dsMap.put("7", shakuntala);
      dsMap.put("8", metagate);
      dsMap.put("9", chiselon);
      dsMap.put("10", pioneer);
 
      this.setTargetDataSources(dsMap);
   }
 
}