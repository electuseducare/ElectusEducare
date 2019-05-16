<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <%@include file="/jsp/DisplayLogo.jsp" %>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>State Wise Error Report</title>
   </head>
   <body>
      <%@include file="/jsp/adminUserTopMenu.jsp" %>
      <%@include file="/jsp/adminUserHeader.jsp" %>
      <%@include file="/jsp/adminDataTableForReports.jsp" %>
      <!-- start header -->
      <div class="row"> </div>
      <div style="width:5%; float:left; background-color: #ffffff;"> &nbsp; </div>
      <div style="width:90%; float:left; background-color: #ffffff">
         <legend style="text-align: center;">State Wise Error Report</legend>
         <table id="studentmarks" class="table table-bordered table-striped nowrap"  cellspacing="0" width="100%" >
            <thead>
               <tr>
                  <th style="text-align: center;">State </th>
                  <th style="text-align: center;"> Exam Strn </th>
                  <th style="text-align: center;"> Subject </th>
                  <c:forEach var="i" begin="1" end="${quescntlenght}">
                     <th>${i} </th>
                  </c:forEach>
               </tr>
            </thead>
            <tbody>
               <c:forEach items="${model1.allDetails}" var="sturesults1" varStatus="loop">
                  <%int i=0; %>
                  <tr >
                     <td >${sturesults1.state}</td>
                     <td style="text-align: center;">${sturesults1.examstrength}</td>
                     <c:forEach items="${sturesults1.listsubject}" var="sturesults2" >
                        <%if(i>0){ %> 
                        <td>${sturesults1.state}</td>
                        <td></td>
                        <%} %>
                        <td> ${sturesults2} <br> Q.Wise_W _Counts <br> % </td>
                        <% int questionerrorcnts = 0, k=1; %>
                        <c:forEach items="${sturesults1.lquestionerrorcnt}" var="sturesults5" varStatus="loop1">
                           <c:if test="${sturesults5.key eq sturesults2 }">
                              <c:forEach items="${sturesults5.value }" var="sturesults6">
                                 <td>  E-${sturesults6} </td>
                                 <% questionerrorcnts ++ ;%>
                              </c:forEach>
                           </c:if>
                        </c:forEach>
                        <%    pageContext.setAttribute("questionerrorcnts", questionerrorcnts);%>
                        <c:if test="${quescntlenght gt questionerrorcnts}">
                           <c:set var="increaseerrortd" value="${quescntlenght-questionerrorcnts}"></c:set>
                           <c:forEach var="j" begin="1" end="${increaseerrortd}">
                              <td>NA</td>
                           </c:forEach>
                        </c:if>
                        <% int questioncnts = 0; %>	     
                  <tr><td>${sturesults1.state}</td><td></td><td></td> 
                  <c:forEach items="${sturesults1.lquestionid}" var="sturesults3" varStatus="loop1">
                  <c:if test="${sturesults3.key eq sturesults2 }"> 
                  <c:forEach items="${sturesults3.value }" var="sturesults4">
                  <th>Q-<%=k%>  </th>
                  <% questioncnts ++ ; k++;%> 
                  </c:forEach>
                  </c:if>
                  </c:forEach>
                  <% pageContext.setAttribute("questioncnts", questioncnts);%>
                  <c:if test="${quescntlenght gt questioncnts}">
                  <c:set var="increasequestiontd" value="${quescntlenght-questioncnts}"></c:set>
                  <c:forEach var="j" begin="1" end="${increasequestiontd}">  
                  <td>NA</td>
                  </c:forEach>
                  </c:if>
                  </tr>
                  <% int percentagecnts = 0; %>	
                  <tr><td>${sturesults1.state}</td><td></td><td></td> 
                  <c:forEach items="${sturesults1.lqnerrorpercentage}" var="sturesults7" varStatus="loop1">
                  <c:if test="${sturesults7.key eq sturesults2 }"> 
                  <c:forEach items="${sturesults7.value }" var="sturesults8">
                  <td>  ${sturesults8} </td>
                  <% percentagecnts ++ ; %> 
                  </c:forEach>
                  </c:if>
                  </c:forEach>
                  <% pageContext.setAttribute("percentagecnts", percentagecnts);%>
                  <c:if test="${quescntlenght gt percentagecnts}">
                  <c:set var="increasepercentagetd" value="${quescntlenght-percentagecnts}"></c:set>
                  <c:forEach var="j" begin="1" end="${increasepercentagetd}">  
                  <td>NA</td>
                  </c:forEach>
                  </c:if>
                  </tr>
                  <% i++; %>
                  </c:forEach>
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