<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <%@include file="DisplayLogo.jsp" %>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>Electus Educare</title>
   </head>
   <body>
      <%@include file="adminUserTopMenu.jsp" %>
      <%@include file="adminUserHeader.jsp" %>
      <%@include file="AdminCreateExamModelWindows.jsp" %>
      <!-- start header -->
      <div class="row"> </div>
      <div style="width:22%; float:left; background-color: #ffffff;"><%@include file="AdminDashboardLeftMenu.jsp" %></div>
      <div style="width:70%; float:left; background-color: #ffffff">
         <ul class="nav nav-tabs">
            <li ><a href="load-SetExamform">CREATE EXAM</a></li>
            <li><a href="load-createSelectedQuestionsExam">EXAM WITH SELECTED QUESTIONS</a></li>
            <li class="active"><a href="#">COPY PREVIOUS CREATED EXAM PATTERN</a></li>
             <li><a href="load-createSelectedQuestionsExamwithFiles">SELECTED FILES</a></li>
            
         </ul>
         <div class="panel-heading" style="background-color:#ccf2ff;color:black; font-weight: bold;">
            <a href="load-availableExamsInCopyCreateExam" style="text-decoration: none;">
            <img border="0" alt="Add Create Exam" src="${pageContext.request.contextPath}/theme/images/copyexam.jpg" width="40" height="40" style="background-color: skyblue;">
            COPY PREVIOUS CREATED EXAM PATTERN </a>
         </div>
         <div class="row"></div>
         <center>
            <h4 style="color:green">${smsg}</h4>
         </center>
         <center>
            <h4 style="color:red">${emsg}</h4>
         </center>
         <center>
            <a href="load-availableExamsInCopyCreateExam"> <button class="btn-primary" style="border:thin;color: white; font-weight: bold; "> Back to Copy Created Exam</button> </a>
         </center>
         <div class="row"></div>
         <center>
            <a href="load-studentAssign"> <button class="btn-primary" style="border:thin;color: white; font-weight: bold; ">Student Assign</button> </a>
         </center>
      </div>
      <%@include file="adminfooter.jsp" %>
   </body>
</html>