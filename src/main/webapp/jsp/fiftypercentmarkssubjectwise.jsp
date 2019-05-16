<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <%@include file="DisplayLogo.jsp" %>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>Above 50% Marks_Subject-wise</title>
   </head>
   <body>
      <%@include file="adminUserTopMenu.jsp" %>
      <%@include file="adminUserHeader.jsp" %> 
      <%@include file="adminDataTableForReports.jsp" %>
      <!-- start header -->
      <center>
         <legend >Above 50% Marks_Subject-wise </legend>
      </center>
      <div class="container">
         <table id="example" class="table table-bordered table-striped nowrap" cellspacing="0" width="100%" style="text-align: center;">
            <form:form  name="EditRoles" method="post" action="#"  modelAttribute="adminbranch" >
               <thead>
                  <tr>
                     <th>Campus</th>
                     <th>Exam Strength</th>
                     <c:forEach items="${model1.subjectval}" var="subjects" varStatus="loop">
                        <th> ${subjects.subjectname}/'>=44'</th>
                        <th>${subjects.subjectname}/'Max Marks'</th>
                     </c:forEach>
                  </tr>
               </thead>
               <tbody>
                  <c:forEach  items="${model1.marks}" var="editdetails" varStatus="loop">
                     <tr>
                        <td>${editdetails.campus}</td>
                        <td>${editdetails.examstrength}</td>
                        <td>${editdetails.greaterthanfortyfour}</td>
                        <td>${editdetails.maxmarks}</td>
                        <c:forEach  items="${editdetails.lgreaterfourtyfour}" var="editdetails2" varStatus="loop2">
                           <td>${editdetails2}</td>
                           <c:forEach  items="${editdetails.maxmarkslist}" var="editdetails3" begin="${loop2.index}" end="${loop2.index}">
                              <td>${editdetails3}</td>
                           </c:forEach>
                        </c:forEach>
                     </tr>
                  </c:forEach>
               </tbody>
            </form:form>
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
      <center> <button onclick="history.back();" style="cursor: pointer; background-color: aqua; height: 30px">Back to Reports</button></center>
   </body>
</html>