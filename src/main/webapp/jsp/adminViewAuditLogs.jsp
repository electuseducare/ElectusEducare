<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <%@include file="DisplayLogo.jsp" %>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>Electus Educare</title>
      <%@include file="adminDataTable.jsp" %>
      <script src="${pageContext.request.contextPath}/theme/js/AdminFieldEmptyValidation.js"></script>
      <style type="text/css">
         .pexamTable {
         width:100%;
         height:100%;
         opacity:.95;
         top:0;
         left:0;
         display:none;
         position:fixed;
         background-color:transparent;
         overflow:auto;
         }
         .examTable {
         width:100%;
         height:100%;
         opacity:.95;
         top:0;
         left:0;
         display:none;
         position:fixed;
         background-color:transparent;
         overflow:auto;
         }
         img#close {
         position:absolute;
         right:0px;
         top:0px;
         cursor:pointer
         }
         img#close1 {
         position:absolute;
         right:0px;
         top:0px;
         cursor:pointer
         }
         div#popupContact {
         position:absolute;
         left:40%;
         width:50%;
         height:30%;
         top:35%;
         margin-left:-202px;
         -moz-box-shadow: -20px 20px 20px 20px #888;
         -webkit-box-shadow: -20px 20px 20px 20px#888;
         box-shadow: -20px 20px 10px  #888888;
         font-family:'Raleway',sans-serif;
         background-color: #e6f7ff;
         }
         @-webkit-keyframes blinker {
         from {opacity: 1.0;}
         to {opacity: 0.4;}
         }
         .blink{
         text-decoration: blink;
         -webkit-animation-name: blinker;
         -webkit-animation-duration: 0.6s;
         -webkit-animation-iteration-count:infinite;
         -webkit-animation-timing-function:ease-in-out;
         -webkit-animation-direction: alternate;
         }
      </style>
   </head>
   <body>
      <%@include file="adminUserTopMenu.jsp" %>
      <%@include file="adminUserHeader.jsp" %>
      <div class="row"> </div>
      <div style="width: 22%; float:left; background-color: #ffffff;"><%@include file="AdminDashboardLeftMenu.jsp" %></div>
      <div style="width: 75%; float:left; background-color: #ffffff;">
         <ul class="nav nav-tabs">
            <li><a href="load-classfilterstudentsLog">USERS LOG DATA</a></li>
         </ul>
         <div class="panel-heading" style="background-color:#ccf2ff;color:black; font-weight: bold;">
            <a href="load-classfilterstudentsLog">
            <img border="0" alt="Edit Admin" src="${pageContext.request.contextPath}/theme/images/edit.jpg" width="40" height="40" >
            </a>
         </div>
         <div class="col-sm-12" style="border: 0px solid grey; margin-left:0px; padding: 0.50em; width: 100%;background-color:#DFE2DB;  overflow-x:scroll;">
            <form:form  name="EditRoles" method="post" action="#"  modelAttribute="av" >
               <table id="example" class="display" cellspacing="0" width="100%">
                  <thead>
                     <tr>
                        <th class="bg-info" style="color: #00008B">Student Id</th>
                        <th class="bg-info"  style="color: #00008B">User Name</th>
                        <th class="bg-info" style="color: #00008B"> Login Time </th>
                        <th class="bg-info" style="color: #00008B">Logout Time</th>
                        <th class="bg-info" style="color: #00008B">Exam Name</th>
                        <th class="bg-info" style="color: #00008B">Exam Start Time</th>
                        <th class="bg-info" style="color: #00008B">Exam Resume Time</th>
                        <th class="bg-info" style="color: #00008B">Exam End Time</th>
                     </tr>
                  </thead>
                  <tbody>
                     <c:forEach items="${auditlogs}" var="auditlogs" varStatus="loop">
                        <tr>
                           <td style="font-weight: bold;">
                              <form:input path="studentid" readonly="true" value="${auditlogs.studentid}"/>
                              <span style="display:none;">${auditlogs.studentid}</span>
                           </td>
                           <td style="font-weight: bold;">
                              <form:input path="username" readonly="true" value="${auditlogs.username}"/>
                              <span style="display:none;">${auditlogs.username}</span>
                           </td>
                           <td style="font-weight: bold;">
                              <form:input path="logindate" readonly="true" value="${auditlogs.logindate}"/>
                              <span style="display:none;">${auditlogs.logindate}</span>
                           </td>
                           <td style="font-weight: bold;">
                              <form:input path="logoutdate" readonly="true" value="${auditlogs.logoutdate}"/>
                              <span style="display:none;">${auditlogs.logoutdate}</span>
                           </td>
                           <td style="font-weight: bold;">
                              <form:input path="examname" readonly="true" value="${auditlogs.examname}"/>
                              <span style="display:none;">${auditlogs.examname}</span>
                           </td>
                           <td style="font-weight: bold;">
                              <form:input path="examstarttime" readonly="true" value="${auditlogs.examstarttime}"/>
                              <span style="display:none;">${auditlogs.examstarttime}</span>
                           </td>
                           <td style="font-weight: bold;">
                              <form:input path="examresumetime" readonly= "true" value="${auditlogs.examresumetime}"/>
                              <span style="display:none;">${auditlogs.examresumetime}</span>
                           </td>
                           <td style="font-weight: bold;">
                              <form:input path="examendtime" readonly="true" value="${auditlogs.examendtime}"/>
                              <span style="display:none;">${auditlogs.examendtime}</span>
                           </td>
                        </tr>
                     </c:forEach>
                  </tbody>
               </table>
            </form:form>
         </div>
      </div>
      <script type="text/javascript">
         $(document).ready(function() {
             $('#example').DataTable( {
                 
             } );
         } );
         
      </script>
      <%@include file="adminfooter.jsp" %>
   </body>
</html>