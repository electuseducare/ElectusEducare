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
         <table>
            <tr style="paddipadding-right: 40px;">
               <td class="center"><a href="load-offlinestudendata">
                  <img border="1" alt="Offline student data" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/offlineupload.png"  >
                  </a><br><strong >UPLOAD STUDENT DATA</strong>
               </td>
               <td class="center"><a href="load-uploadKeyFileBySystemOrExcel">
                  <img border="1" alt="REQUIRED DATA" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/key.jpg"  >
                  </a><br><strong >UPLOAD KEY FILE</strong>
               </td>
               <td class="center"><a href="load-uploadDatFile">
                  <img border="1" alt="REQUIRED DATA" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/omrsheet.jpg"  >
                  </a><br><strong >UPLOAD OMR SHEET</strong>
               </td>
               <td class="center"><a href="load-ExamNameforoffline">
                  <img border="1" alt="REQUIRED DATA" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/results.jpg"  >
                  </a><br><strong >RESULT CALCULATION</strong>
               </td>
               <td class="center"><a href="load-examnameforofflinereports">
                  <img border="1" alt="REQUIRED DATA" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/offlinereports.png"  >
                  </a><br><strong >VIEW REPORTS</strong>
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