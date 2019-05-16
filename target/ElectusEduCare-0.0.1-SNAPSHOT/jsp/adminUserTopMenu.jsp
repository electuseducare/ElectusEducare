<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
   <head>
      <%@include file="DisplayLogo.jsp" %>
      <style>
         .shoppingbasket {
         width:20px;
         height:20px;
         position:relative;
         font-family: 'Comfortaa', cursive;
         }
         .shoppingbasket .top {
         width:60%;
         height:10%;
         border-radius:1000px;
         background-color:#fff;
         position:absolute;
         top:70%;
         left:-30%;
         -webkit-transform: translateX(-50%);
         -moz-transform: translateX(-50%);
         transform: translateX(-50%);
         }
      </style>
   </head>
   <body>
      <!-- start header -->
      <header>
         <div class="navbar navbar-default navbar-static-top">
            <div class="container">
               <div class="navbar-header">
                  <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse" style="background-color:white;">
                  <span class="sr-only">Toggle navigation</span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                  </button>
                  <%
                     String clientlogo=(String)session.getAttribute("clientlogo1");
                      pageContext.setAttribute("clientlogo", clientlogo);
                      %>
                  <c:set value="${clientlogo}" var="clientlogo"></c:set>
                  <a  href="load-AdminDashboard"><img src="${pageContext.request.contextPath}/theme/images/Electus-Logo-RGB.jpg" height="60" width="230" alt="logo"/></a>
                  <c:choose>
                     <c:when test="${clientlogo=='0' || clientlogo==''}">
                     </c:when>
                     <c:otherwise>
                        <a  href="load-AdminDashboard">  <img src="${pageContext.request.contextPath}/viewClientimage?imageID=<%=session.getAttribute("clientlogo1")%>" class=""  height="60" width="230" alt="logo" /></a>
                     </c:otherwise>
                  </c:choose>
               </div>
               <div class="navbar-collapse collapse " >
                  <ul class="nav navbar-nav">
                     <li><a href="load-AdminDashboard" >DASHBOARD</a></li>
                     <li><a href="load-adminHelpContent" >HELP</a></li>
                     <li><a href="logout">LOGOUT</a></li>
                  </ul>
               </div>
            </div>
         </div>
      </header>
      <!-- end header -->
   </body>
</html>