<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <%@include file="DisplayLogo.jsp" %>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>Electus Educare</title>
   </head>
   <style>
      .center {
      padding: 40px 0;
      padding-right:15px;
      text-align: center;
      }
      .center img{
      width: 100px;
      height: 100px;
      }
   </style>
   <body>
      <%@include file="adminUserTopMenu.jsp" %>
      <%@include file="adminUserHeader.jsp" %>
      <!-- start header -->
      <div class="row"> </div>
      <div style="width:22%; float:left; background-color: #ffffff;">
         <%@include file="AdminDashboardLeftMenu.jsp" %>
      </div>
      <div style="width:70%; float:left; background-color: #ffffff">
         <div class="panel-heading" style="background-color:#ccf2ff;color:black; font-weight: bold;">
            <a href="load-uploadKeyFilebyexcel"><img border="0" alt="" src="${pageContext.request.contextPath}/theme/images/addicon.jpg" width="40" height="40" style="background-color: skyblue;"></a>
            Upload Key File From Excel Sheet / From System
            <span style="float: right;"><a href="load-OfflineAnalysis"> Back to Offline Data </a></span>
         </div>
         <table>
            <tr style="paddipadding-right: 40px;">
               <td class="center"><a href="load-uploadKeyFile">
                  <img border="1" alt="REQUIRED DATA" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/key.jpg"  >
                  </a><br><strong >UPLOAD KEY FILE - SYSTEM</strong>
               </td>
               <td class="center"><a href="load-uploadKeyFilebyexcel">
                  <img border="1" alt="REQUIRED DATA" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/key.jpg"  >
                  </a><br><strong >UPLOAD KEY FILE - EXCEL</strong>
               </td>
            </tr>
         </table>
      </div>
      <center>
         <div style="width: 10%;float:right;background-color: #ffffff"> </div>
      </center>
      <%@include file="adminfooter.jsp" %>
   </body>
</html>