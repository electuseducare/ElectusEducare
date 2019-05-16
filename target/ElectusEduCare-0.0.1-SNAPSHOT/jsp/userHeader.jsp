<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
   <head>
      <%@include file="DisplayLogo.jsp" %>
      <title>Header</title>
      <%@page import="org.springframework.web.bind.annotation.RequestMapping"%>
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
      <link rel="stylesheet" href="https://cdn.datatables.net/1.10.15/css/dataTables.bootstrap.min.css">
      <link rel="stylesheet" href="https://cdn.datatables.net/responsive/2.1.1/css/responsive.bootstrap.min.css">
      <spring:url value="/theme/css/style.css" var="var1"></spring:url>
      <link rel="stylesheet" href="${var1}">
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
      <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
      <script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
      <script src="https://cdn.datatables.net/1.10.15/js/dataTables.bootstrap.min.js"></script>
      <script src="https://cdn.datatables.net/responsive/2.1.1/js/dataTables.responsive.min.js"></script>
      <script src="https://cdn.datatables.net/responsive/2.1.1/js/responsive.bootstrap.min.js"></script> 
      <%!
         @RequestMapping("/forwardpage")
         public String returnerrorpage(){
         	
         return "load-loginform";	
         }%>
      <%
         if(session != null && !session.isNew()) {
            
         } else {
             response.sendRedirect(returnerrorpage());
         }
         %>
   </head>
   <body>
      <div id="wrapper">
         <div class="topbar">
            <div class="container">
               <div class="row">
                  <div class="col-md-12">
                     <p class="pull-left hidden-xs">
                        <span style="font-size:14px;font-weight: bold;margin-left: 4px;">Welcome: </span> <span> <%=session.getAttribute("uname") %>,  <%=session.getAttribute("first_name") %></span> 
                     </p>
                     <!-- <p class="pull-right">Home|My Center|Help|Contact</p> -->
                  </div>
               </div>
            </div>
         </div>
      </div>
   </body>
</html>