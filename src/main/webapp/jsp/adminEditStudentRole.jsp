<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <%@include file="DisplayLogo.jsp" %>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>Electus Educare</title>
      <link href="//code.jquery.com/jquery-1.12.4.js"  >
      <link href="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js" >
      <link href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css" type="text/css" rel="stylesheet">
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
      <section id="inner-headline">
         <div class="container">
            <div class="col-lg-12">
               <center>
                  <h3 class="pageTitle" >Admin Add Roles </h3>
               </center>
            </div>
         </div>
      </section>
      <div class="row"> </div>
      <div style="width: 22%; float:left; background-color: #ffffff;"><%@include file="AdminDashboardLeftMenu.jsp" %></div>
      <div style="width: 75%; float:left; background-color: #ffffff;">
         <ul class="nav nav-tabs">
            <li><a href="load-AddAdminRoles">ADD ROLE</a></li>
            <li  class="active"><a href="load-ModifyAdminRoles">MODIFY ROLE</a></li>
            <li><a href="load-DeleteAdminRoles">DELETE ROLE</a></li>
         </ul>
         <div class="col-sm-12" style="border: 0px solid grey; margin-left:12px; padding: 0.50em; width: 100%;  overflow-x:scroll;">
            <form:form  name="EditRoles" method="post" action="load-processRolesModify"  modelAttribute="roleforadmin" >
               <h4 style="color: green">${smsg}</h4>
               <h4  style="color: red">${emsg}</h4>
               <h6  style="color: blue;text-decoration: underline;">Note:Select Items Which You Want To Modify</h6>
               <table id="example" class="display" cellspacing="0" width="100%">
                  <thead>
                     <tr>
                        <th class="bg-info" style="color: #00008B">select</th>
                        <th class="bg-info" style="color: #00008B">ID</th>
                        <th class="bg-info" style="color: #00008B">FirstName</th>
                        <th class="bg-info" style="color: #00008B">LastName</th>
                        <th class="bg-info"  style="color: #00008B">User Name</th>
                        <th class="bg-info" style="color: #00008B">Password</th>
                        <th class="bg-info" style="color: #00008B">Mobile</th>
                        <th class="bg-info" style="color: #00008B"> Email </th>
                        <th class="bg-info" style="color: #00008B">College</th>
                        <th class="bg-info" style="color: #00008B">Update</th>
                     </tr>
                  </thead>
                  <tbody>
                     <c:forEach items="${roleforadmin.admineditlist}" var="editdetails" varStatus="loop">
                        <tr>
                           <td style="font-weight: bold;">
                              <form:checkbox path="admineditlist[${loop.index}].useridlistval"  value="${editdetails.userid}" />
                           </td>
                           <td style="font-weight: bold;">
                              <form:input path="admineditlist[${loop.index}].student_id" readonly="true"/>
                              <span style="display:none;">${editdetails.student_id}</span>
                           </td>
                           <td style="font-weight: bold;">
                              <form:input path="admineditlist[${loop.index}].studentfirstname" />
                              <span style="display:none;">${editdetails.studentfirstname}</span>
                           </td>
                           <td style="font-weight: bold;">
                              <form:input path="admineditlist[${loop.index}].studentlastname" />
                              <span style="display:none;">${editdetails.studentlastname}</span>
                           </td>
                           <td style="font-weight: bold;">
                              <form:input path="admineditlist[${loop.index}].username" readonly="true"/>
                              <span style="display:none;">${editdetails.username}</span>
                           </td>
                           <td style="font-weight: bold;">
                              <form:input path="admineditlist[${loop.index}].password"/>
                              <span style="display:none;">${editdetails.password}</span>
                           </td>
                           <td style="font-weight: bold;">
                              <form:input path="admineditlist[${loop.index}].mobile" />
                              <span style="display:none;">${editdetails.mobile}</span>
                           </td>
                           <td style="font-weight: bold;">
                              <form:input path="admineditlist[${loop.index}].email" />
                              <span style="display:none;">${editdetails.email}</span>
                           </td>
                           <td style="font-weight: bold;">
                              <form:input path="admineditlist[${loop.index}].collegename" />
                              <span style="display:none;">${editdetails.collegename}</span>
                           </td>
                           <td style="font-weight: bold;"><button id="editusers" class="btn-primary">UPDATE</button></td>
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