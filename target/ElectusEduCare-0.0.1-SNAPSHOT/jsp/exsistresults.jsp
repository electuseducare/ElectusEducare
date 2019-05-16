<%@page import="java.math.BigInteger"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <%@include file="DisplayLogo.jsp" %>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>Electus Educare</title>
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
      <%@include file="userTopMenu.jsp" %>
      <%@include file="userHeader.jsp" %>
      <div id="inner-headline">
      </div>
      <div class="row" > </div>
      <div style="width: 22%; float:left; background-color: #ffffff;"><%@include file="userDashboardLeftMenu.jsp" %></div>
      <div style="width: 75%; float:left; background-color: #ffffff;">
         <div class="panel panel-primary" >
            <div class="panel-heading" style="background-color: #020D56;  font-weight: bold;"></div>
            Your Exam was already submitted check your results in dashboard. Please <a href="load-userdashboardResults" >Click here</a> to check your results.
         </div>
      </div>
      <div style="width: 3%; float:left; background-color: #ffffff;"> &nbsp; </div>
      <div id="RSS_Feed"></div>
      <%@include file="adminfooter.jsp" %>
   </body>
</html>