<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <%@include file="/jsp/DisplayLogo.jsp" %>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>Subject-wise_Wrong, Right & Un-attempted Counts</title>
   </head>
   <body>
      <%@include file="/jsp/adminUserTopMenu.jsp" %>
      <%@include file="/jsp/adminUserHeader.jsp" %> 
      <%@include file="/jsp/adminDataTableForReports.jsp" %>
      <!-- start header -->
      <center>
         <legend>Subject-wise_Wrong, Right & Un-attempted Counts</legend>
      </center>
      <div class="container">
         <table id="example" class="table table-bordered table-striped nowrap" cellspacing="0" width="100%" style="text-align:center;">
            <form:form  name="EditRoles" method="post" action="#"  modelAttribute="adminbranch"  >
               <thead>
                  <tr>
                     <th>Student Id</th>
                     <th>Student Name</th>
                     <th>Section </th>
                     <th>Campus </th>
                     <c:forEach items="${model1.subjectval}" var="subjects" varStatus="loop">
                        <th> ${subjects.subjectname}/W</th>
                        <th> ${subjects.subjectname}/R</th>
                        <th> ${subjects.subjectname}/U</th>
                     </c:forEach>
                  </tr>
               </thead>
               <tbody>
                  <c:forEach  items="${model1.contval}" var="editdetails" varStatus="loop1">
                     <tr>
                        <td>${editdetails.studentid}</td>
                        <td>${editdetails.studentname}</td>
                        <td>${editdetails.section}</td>
                        <td>${editdetails.branch}</td>
                        <td>${editdetails.wrongcount}</td>
                        <td>${editdetails.rightcount}</td>
                        <td>${editdetails.unattempt}</td>
                        <c:forEach  items="${editdetails.lwrongcount}" var="editdetails2" varStatus="loop2">
                           <td>${editdetails2}</td>
                           <c:forEach  items="${editdetails.lrightcount}" var="editdetails3"  begin="${loop2.index}" end="${loop2.index}">
                              <td>${editdetails3}</td>
                              <c:forEach  items="${editdetails.lunattempcount}" var="editdetails4"  begin="${loop2.index}" end="${loop2.index}">
                                 <td>${editdetails4}</td>
                              </c:forEach>
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