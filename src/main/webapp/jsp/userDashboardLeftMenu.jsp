<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <%@include file="DisplayLogo.jsp" %>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <link rel="stylesheet" href="${pageContext.request.contextPath}/theme/css/userDashboardLeftMenu.css">
      <title>Electus Educare</title>
      <style type="text/css">
         fieldset { 
         display: block;
         margin-top:-6px;
         margin-left: 2px;
         margin-right: 2px;
         padding-top: 0.35em;
         padding-bottom: 0.625em;
         padding-left: 0.75em;
         padding-right: 0.75em;
         background-color: #00a3cc;
         color:white;
         font-weight:bold;
         border: 2px groove (internal value);
         }
         .menuactivate { 
         display: block;
         margin-left: 2px;
         margin-right: 2px;
         padding-bottom: 0.6em;
         padding-right: 0.75em;
         background-color:#ccf2ff;
         color:white;
         height:40px;
         font-weight:bold;
         border: 2px groove (internal value);
         }
      </style>
      <script>
         $( document ).ready(function() {
         
             var url = document.URL; 
             
             $("#menuList a").each(function() {
             	
                    if(url == (this.href)) { 
                     $(this).closest("li").addClass("menuactivate");
                     
                 }
             });
         
         });
      </script>
   </head>
   <body >
      <div class="container"  >
         <div class="row" style="width:100%;" >
            <div class="col-sm-3">
               <nav class="nav-sidebar"  style="border-left: 2px solid #ddd;border-bottom: 2px solid #ddd; background-color:#E4E4E4;">
               <img border="0" alt="W3Schools" src="${pageContext.request.contextPath}/theme/images/dashboardicon.jpg" width="100" height="100" border-bottom: 2px solid #ddd;> 
               <label >User DashBoard </label>
               <ul class="nav" id="menuList" >
                  <li ><a href="load-userExamDashboard">Start Test</a></li>
                  <li ><a href="load-userdashboardResults">View Results</a></li>
                  <li ><a href="load-DashboardBookmarkquestions">View Bookmarks Questions</a></li>
                  <li class="nav-divider" style="margin-top: 120% ;" ></li>
               </ul>
            </div>
         </div>
      </div>
   </body>
</html>