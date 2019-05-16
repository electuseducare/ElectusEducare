<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <%@include file="DisplayLogo.jsp" %>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>Student-Wise-Question-Wise-Error-Report</title>
   </head>
   <body>
      <%@include file="adminUserTopMenu.jsp" %>
      <%@include file="adminUserHeader.jsp" %> 
      <%@include file="adminDataTableForReports.jsp" %>
      <!-- start header -->
      <center>
         <legend>Student-Wise-Question-Wise-Error-Report</legend>
      </center>
      <div class="container">
         <table id="example" class="table table-bordered table-striped nowrap" cellspacing="0" width="100%" style="text-align: center;">
            <form:form  name="EditRoles" method="post" action="#"  modelAttribute="adminbranch" >
               <thead>
                  <tr>
                     <th>Student Id</th>
                     <th >Student Name</th>
                     <th>Section</th>
                     <th>Campus</th>
                     <c:forEach  items="${model1.qiderror}" var="editdetails1" varStatus="loop">
                        <th>Q${loop.index+1}</th>
                     </c:forEach>
                  </tr>
               </thead>
               <tbody>
                  <c:forEach  items="${model1.qerror}" var="editdetails" varStatus="loop">
                     <tr>
                        <td>${editdetails.studentid}</td>
                        <td>${editdetails.studentname}</td>
                        <td>${editdetails.section}</td>
                        <td>${editdetails.campus}</td>
                        <c:forEach items="${editdetails.lquestionid}" var="editdetails1" varStatus="loop1">
                           <c:forEach items="${editdetails.lcorrect}" var="questionrepo2" begin="${loop1.index}" end="${loop1.index}">
                              <c:if test="${questionrepo2!=null}">
                                 <td id="test">R </td>
                              </c:if>
                           </c:forEach>
                           <c:forEach items="${editdetails.lwrong}" var="questionrepo3" begin="${loop1.index}" end="${loop1.index}">
                              <c:if test="${questionrepo3!=null}">
                                 <td id="test">W</td>
                              </c:if>
                           </c:forEach>
                           <c:forEach items="${editdetails.lunattempt}" var="questionrepo4" begin="${loop1.index}" end="${loop1.index}">
                              <c:if test="${questionrepo4!=null}">
                                 <td id="test">U </td>
                              </c:if>
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