<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <%@include file="/jsp/DisplayLogo.jsp" %>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>Below 100 RNK_Subject-wise</title>
   </head>
   <body>
      <%@include file="/jsp/adminUserTopMenu.jsp" %>
      <%@include file="/jsp/adminUserHeader.jsp" %> 
      <%@include file="/jsp/adminDataTableForReports.jsp" %>
      <%-- <!-- start header -->
         <div class="row"> </div>
         <%-- <div style="width:22%; float:left; background-color: #ffffff;">
         <%@include file="AdminDashboardLeftMenu.jsp" %></div> --%>
      <div style="width:5%; float:left; background-color: #ffffff;"> &nbsp; </div>
      <div style="width:90%; float:left; background-color: #ffffff">
         <legend style="text-align: center;">Below 100 RNK_Subject-wise</legend>
         <table id="studentmarks" class="table table-bordered table-striped nowrap" cellspacing="0" width="100%" style="text-align: center;">
            <thead>
               <tr>
                  <th >Campus </th>
                  <th >EAS </th>
                  <c:forEach items="${model1.subjects}" var="subjects" varStatus="loop">
                     <th >  ${subjects.subjectname} / (100 < Rank)</th>
                  </c:forEach>
                  <c:forEach items="${model1.subjects}" var="subjects" varStatus="loop">
                     <th > ${subjects.subjectname} / (Max_Marks)  </th>
                  </c:forEach>
               </tr>
            </thead>
            <tbody>
               <c:forEach items="${model1.allDetails}" var="sturesults1" varStatus="loop">
                  <tr>
                     <td >${sturesults1.campus}</td>
                     <td >${sturesults1.examstrength}</td>
                     <c:forEach items="${sturesults1.lsub_rankcount}" var="lsub_rankcount" varStatus="loop">
                        <td> ${lsub_rankcount} </td>
                     </c:forEach>
                     <c:forEach items="${sturesults1.lmaxmarkst}" var="lmaxmarks" varStatus="loop">
                        <td> ${lmaxmarks} </td>
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