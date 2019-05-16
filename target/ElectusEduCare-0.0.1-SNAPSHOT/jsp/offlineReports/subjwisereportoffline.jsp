<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <%@include file="/jsp/DisplayLogo.jsp" %>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>Subject Wise Highest Marks Report</title>
   </head>
   <body>
      <%@include file="/jsp/adminUserTopMenu.jsp" %>
      <%@include file="/jsp/adminUserHeader.jsp" %> 
      <%@include file="/jsp/adminDataTableForReports.jsp" %>
      <!-- <div class="container"> -->
      <center>
         <legend>Subject Wise Highest Marks Report </legend>
      </center>
      <div class="container">
         <table id="example" class="table table-bordered table-striped nowrap" cellspacing="0" width="100%" style="text-align: center;">
            <thead>
               <tr>
                  <th>Campus</th>
                  <th>Exam Strength </th>
                  <c:forEach items="${model1.subjectval}" var="editdetails">
                     <th>${editdetails.subjectname}
                     </th>
                     <th>Rank
                     </th>
                  </c:forEach>
                  <th>Total</th>
                  <th>AIR</th>
               </tr>
            </thead>
            <tbody>
               <c:forEach items="${model1.highscore}"  var="row1">
                  <tr>
                     <td>${row1.campus}/campus wise topper</td>
                     <td>${row1.examstrength} </td>
                     <td>${row1.scoredmarkspercampus}</td>
                     <td>${row1.campuswiserank}</td>
                     <c:forEach  items="${row1.campusscore}" var="editdetails2" varStatus="loop2">
                        <td>${editdetails2}  </td>
                        <c:forEach  items="${row1.campusranklist}" var="editdetails4"  begin="${loop2.index}" end="${loop2.index}">
                           <td>${editdetails4}</td>
                        </c:forEach>
                     </c:forEach>
                     <td>${row1.totalscoreval}</td>
                     <td>${row1.rank}</td>
                  </tr>
                  <tr>
                     <td>${row1.campus}/ subject wise topper</td>
                     <td>${row1.examstrength} </td>
                     <td>  ${row1.subjectwisemarks} </td>
                     <td> ${row1.subjectwisevalue}</td>
                     <c:forEach  items="${row1.subjectwisescore}"  var="editdetails2" varStatus="loop3">
                        <td>${editdetails2}  </td>
                        <c:forEach  items="${row1.subjectwiseranklist}" var="editdetails5"  begin="${loop3.index}" end="${loop3.index}">
                           <td>${editdetails5}</td>
                        </c:forEach>
                     </c:forEach>
                     <td>0</td>
                     <td>0</td>
                  </tr>
               </c:forEach>
            </tbody>
         </table>
      </div>
      <!--    </div> -->
      <script>
         $(document).ready(function() {
             $('#example').DataTable( {
                 dom: 'Bfrtip',
                 buttons: [
                     'copy', 'csv', 'excel', 'pdf', 'print'
                 ]
             } );
         } );
      </script>
      <center> <button onclick="history.back();" style="cursor: pointer; background-color: aqua; height: 30px">Back to Reports</button></center>
   </body>
</html>