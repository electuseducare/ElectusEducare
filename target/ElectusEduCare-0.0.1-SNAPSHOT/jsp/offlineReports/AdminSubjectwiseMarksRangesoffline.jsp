<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <%@include file="/jsp/DisplayLogo.jsp" %>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>Subject-Wise-Marks-Ranges</title>
   </head>
   <body>
      <%@include file="/jsp/adminUserTopMenu.jsp" %>
      <%@include file="/jsp/adminUserHeader.jsp" %> 
      <%@include file="/jsp/adminDataTableForReports.jsp" %>
      <!-- start header -->
      <center>
         <legend>Subject-Wise-Marks-Ranges</legend>
      </center>
      <div class="container">
         <table id="example" class="table table-bordered table-striped nowrap" cellspacing="0" width="100%" style="text-align: center;">
            <form:form  name="EditRoles" method="post" action="#"  modelAttribute="adminbranch" >
               <thead>
                  <tr>
                     <th>Campus</th>
                     <th>Exam Strength</th>
                     <c:forEach items="${model1.subjectval}" var="subjects" varStatus="loop">
                        <th> ${subjects.subjectname}>=50</th>
                        <th>${subjects.subjectname}>=40</th>
                        <th>${subjects.subjectname}>=30</th>
                        <th>${subjects.subjectname}>=20</th>
                        <th>${subjects.subjectname}<20</th>
                     </c:forEach>
                  </tr>
               </thead>
               <tbody>
                  <c:forEach  items="${model1.marks}" var="editdetails" varStatus="loop">
                     <tr>
                        <td>${editdetails.campus}</td>
                        <td>${editdetails.examstrength1}</td>
                        <%-- <c:forEach  items="${editdetails.lexamstrength}" var="editdetails1" varStatus="loop">
                           <td>${editdetails1}</td>	
                           </c:forEach>  --%>
                        <td>${editdetails.greaterthanfifty1}</td>
                        <td>${editdetails.greaterthanfourty1}</td>
                        <td>${editdetails.greaterthanthirty1}</td>
                        <td>${editdetails.greaterthantwenty1}</td>
                        <td>${editdetails.lessthantwenty1}</td>
                        <c:forEach  items="${editdetails.lgreaterfifty}" var="editdetails2" varStatus="loop2">
                           <td>${editdetails2}</td>
                           <c:forEach  items="${editdetails.lgreaterfourty}" var="editdetails3"  begin="${loop2.index}" end="${loop2.index}">
                              <td>${editdetails3}</td>
                              <c:forEach  items="${editdetails.lgreaterthirty}" var="editdetails4"  begin="${loop2.index}" end="${loop2.index}">
                                 <td>${editdetails4}</td>
                                 <c:forEach  items="${editdetails.lgreatertwenty}" var="editdetails5"  begin="${loop2.index}" end="${loop2.index}">
                                    <td>${editdetails5}</td>
                                    <c:forEach  items="${editdetails.llessthantwenty}" var="editdetails6"  begin="${loop2.index}" end="${loop2.index}">
                                       <td>${editdetails6}</td>
                                    </c:forEach>
                                 </c:forEach>
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