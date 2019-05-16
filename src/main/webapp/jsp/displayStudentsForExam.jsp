<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <%@include file="DisplayLogo.jsp" %>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>Student names for ${examname}</title>
   </head>
   <body>
      <%@include file="adminUserTopMenu.jsp" %>
      <%@include file="adminUserHeader.jsp" %> 
      <%@include file="adminDataTableForReports.jsp" %>
      <!-- <div class="container"> -->
      <center>
         <legend>Student names for ${examname}</legend>
      </center>
      <div class="container">
         <table id="example" class="table table-bordered table-striped nowrap" cellspacing="0" width="100%" style="text-align: center;">
            <thead>
               <tr>
                  <th>S.NO</th>
                  <th>User Name</th>
                  <th>Student Name</th>
               </tr>
            </thead>
            <tbody>
               <c:forEach items="${studlist}"  var="sl" varStatus="loop">
                  <tr>
                     <td> ${loop.index+1}</td>
                     <td>${sl.username}</td>
                     <td>${sl.studentname} </td>
                  </tr>
               </c:forEach>
            </tbody>
         </table>
      </div>
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
      <center> <button onclick="history.back();" style="cursor: pointer; background-color: aqua; height: 30px">Back to Select Exam</button></center>
   </body>
</html>