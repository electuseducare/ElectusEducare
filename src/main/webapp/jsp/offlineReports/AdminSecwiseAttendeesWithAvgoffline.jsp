<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <%@include file="/jsp/DisplayLogo.jsp" %>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>Secwise_Attnd._with_Avg's</title>
   </head>
   <body>
      <%@include file="/jsp/adminUserTopMenu.jsp" %>
      <%@include file="/jsp/adminUserHeader.jsp" %> 
      <%@include file="/jsp/adminDataTableForReports.jsp" %>
      <!-- start header -->
      <div class="row"> </div>
      <div style="width:5%; float:left; background-color: #ffffff;"> &nbsp; </div>
      <div style="width:90%; float:left; background-color: #ffffff">
         <legend style="text-align: center;">Section wise attendees with averages</legend>
         <table id="studentmarks" class="table table-bordered table-striped nowrap" cellspacing="0" width="100%"  style="text-align: center;">
            <thead style="text-align: center;">
               <tr style="text-align: center;">
                  <th style="text-align: center;"> CAMPUS  </th>
                  <th style="text-align: center;"> SECTION </th>
                  <th style="text-align: center;"> SEC_ACT_CNT </th>
                  <th style="text-align: center;"> EXM_APP_CNT_TOTAL </th>
                  <c:forEach items="${model1.subjects}" var="subjects" varStatus="loop">
                     <th style="text-align: center;"> AVG_${subjects.subjectname}</th>
                  </c:forEach>
                  <th style="text-align: center;"> AVG_TOTAL </th>
               </tr>
            </thead>
            <tbody>
               <c:forEach items="${model1.allDetails}" var="sturesults" varStatus="loop">
                  <tr>
                     <td> ${sturesults.campusname} </td>
                     <td> ${sturesults.sectionname} </td>
                     <td> ${sturesults.stusectionactcnt}</td>
                     <td> ${sturesults.examappcnttotal}</td>
                     <%--  <td> ${sturesults.averageinsubject}</td> --%>
                     <c:forEach items="${sturesults.lsubjectavg}" var="averageinsubject" varStatus="loop">
                        <td> ${averageinsubject} </td>
                     </c:forEach>
                     <td> ${sturesults.averageintotal}</td>
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
      <div style="width:5%; float:left; background-color: #ffffff;"> &nbsp; </div>
      <center> <button onclick="history.back();" style="cursor: pointer; background-color: aqua; height: 30px">Back to Reports</button></center>
   </body>
</html>