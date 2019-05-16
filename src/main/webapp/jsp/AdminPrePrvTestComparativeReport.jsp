<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>    
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <%@include file="DisplayLogo.jsp" %>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>Present & Previous Test Comparative Report </title>
   </head>
   <body>
      <%@include file="adminUserTopMenu.jsp" %>
      <%@include file="adminUserHeader.jsp" %> 
      <%@include file="adminDataTableForReports.jsp" %>
      <div style="width:5%; float:left; background-color: #ffffff;"> &nbsp; </div>
      <div style="width:90%; float:left; background-color: #ffffff">
         <legend style="text-align: center;">Present & Previous Test Comparative Report</legend>
         <table id="studentmarks" class="table table-bordered table-striped nowrap" cellspacing="0" width="100%" style="text-align: center;">
            <thead>
               <tr>
                  <th >Student ID  </th>
                  <th > Student Name </th>
                  <th > Section </th>
                  <c:forEach items="${model1.subjects}" var="subjectsval" varStatus="loop">
                     <th >  ${subjectsval.subjectname}  </th>
                  </c:forEach>
                  <c:forEach items="${model1.subjects}" var="subjectsval" varStatus="loop">
                     <th >  ${subjectsval.subjectname} / Rank </th>
                  </c:forEach>
                  <th> TOTAL </th>
                  <th> AIR </th>
                  <c:forEach items="${model1.prevSubject}" var="prevsubjectsval" varStatus="loop">
                     <th>prev-${prevsubjectsval.subjectname} </th>
                  </c:forEach>
                  <c:forEach items="${model1.prevSubject}" var="prevsubjectsval" varStatus="loop">
                     <th>prev-${prevsubjectsval.subjectname} / Rank </th>
                  </c:forEach>
                  <th>PRV TOTAL </th>
                  <th>PRV AIR </th>
                  <th >Campus</th>
                  <th >State</th>
               </tr>
            </thead>
            <tbody>
               <c:forEach items="${model1.allDetails}" var="sturesults1" varStatus="loop">
                  <tr>
                     <td >${sturesults1.studentid}</td>
                     <td >${sturesults1.studentname}</td>
                     <td >${sturesults1.sectionname}</td>
                     <td >${sturesults1.scoredmarks1}</td>
                     <c:set var="scoremarks1" value="${sturesults1.scoredmarks1}"></c:set>
                     <% 
                        int scoremarks_1 = 0;
                        float temptscoremarks_1=0;
                        String scoremarks_12 =(String)pageContext.getAttribute("scoremarks1");
                        float scoremarks_13=Float.valueOf(scoremarks_12);
                        pageContext.setAttribute("temptscoremarks_11", scoremarks_13);
                        %>
                     <c:forEach items="${sturesults1.presnextsubjectsmarkslist}" var="sturesults12" >
                        <th>${sturesults12}</th>
                        <c:set var="scoremarks_1" value="${sturesults12}"> </c:set>
                        <% 
                           String scoremarks_2 =(String)pageContext.getAttribute("scoremarks_1");
                           float scoremarks_3=Float.valueOf(scoremarks_2);
                           temptscoremarks_1 = temptscoremarks_1+scoremarks_3; 
                           
                           pageContext.setAttribute("temptscoremarks_1", temptscoremarks_1);
                           %>
                     </c:forEach>
                     <td>${sturesults1.subjectrank}</td>
                     <c:forEach items="${sturesults1.presnextsubjectsranklist}" var="sturesults13" >
                        <th>${sturesults13}</th>
                     </c:forEach>
                     <th>
                        <fmt:formatNumber type="number" maxFractionDigits="2" value="${temptscoremarks_1+temptscoremarks_11}"/>
                     </th>
                     <td>${sturesults1.allindiarank} </td>
                     <% int scoremarks_2 = 0;
                        float temptscoremarks_2=0;%>
                     <c:forEach items="${sturesults1.prevnextsubjectsmarkslist}" var="sturesults14" >
                        <th>${sturesults14}</th>
                        <c:set var="scoremarks_2" value="${sturesults14}"> </c:set>
                        <%String scoremarks_3 = (String) pageContext.getAttribute("scoremarks_2");
                           float scoremarks_4=Float.valueOf(scoremarks_3);
                           temptscoremarks_2 = temptscoremarks_2+scoremarks_4; 
                           pageContext.setAttribute("temptscoremarks_2", temptscoremarks_2);
                           %>
                     </c:forEach>
                     <c:forEach items="${sturesults1.prevnextsubjectsranklist}" var="sturesults15" >
                        <th>${sturesults15}</th>
                     </c:forEach>
                     <th>
                        <fmt:formatNumber type="number" maxFractionDigits="2" value="${temptscoremarks_2}"/>
                     </th>
                     <td>${sturesults1.allindiarankex2} </td>
                     <td >${sturesults1.campusname}</td>
                     <td >${sturesults1.state}</td>
                  </tr>
               </c:forEach>
            </tbody>
         </table>
         <script>
            $(document).ready(function() {
                $('#studentmarks').DataTable( {
                    dom: 'Bfrtip',
                    buttons: [
                        'copy', 'csv', 'excel', 'pdf', 'print'
                    ]
                } );
            } );
         </script>
      </div>
      <center> <button onclick="history.back();" style="cursor: pointer; background-color: aqua; height: 30px">Back to Reports</button></center>
   </body>
</html>