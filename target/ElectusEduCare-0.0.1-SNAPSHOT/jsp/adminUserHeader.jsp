<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
   <head>
      <%@include file="DisplayLogo.jsp" %>
      <%@page import="org.springframework.web.bind.annotation.RequestMapping"%>
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
      <link rel="stylesheet" href="https://cdn.datatables.net/1.10.15/css/dataTables.bootstrap.min.css">
      <link rel="stylesheet" href="https://cdn.datatables.net/responsive/2.1.1/css/responsive.bootstrap.min.css">
      <spring:url value="/theme/css/style.css" var="var1"></spring:url>
      <link rel="stylesheet" href="${var1}">
      <%!
         @RequestMapping("/forwardpage")
         public String returnerrorpage(){
         	
         return "load-loginform";	
         }%>
      <%
         session = request.getSession(false);// don't create if it doesn't exist
         if(session != null && !session.isNew()) {
            
         } else {
             response.sendRedirect(returnerrorpage());
         }
         %>
      <style>
         /*----------------------------------------------
         CSS settings for HTML div Exact Center
         ------------------------------------------------*/
         #finishabc {
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
         div#popupContact {
         position:absolute;
         left:50%;
         width:50%;
         height:25%;
         top:15%;
         margin-left:-202px;
         -moz-box-shadow: 20px 20px 20px 20px #888;
         -webkit-box-shadow: 20px 20px 20px 20px#888;
         box-shadow: 20px 20px 10px #888888;
         font-family:'Raleway',sans-serif;
         background-color: #e6f7ff;
         }
      </style>
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
                  </div>
               </div>
            </div>
         </div>
      </div>
   </body>
</html>