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
      <style type="text/css">
         .loader {
         position: fixed;
         left: 0px;
         top: 0px;
         width: 100%;
         height: 100%;
         z-index: 9999;
         background: url('https://loading.io/assets/img/landing/curved-bars.svg')
         50% 50% no-repeat rgb(249, 249, 249);
         opacity: .8;
         }
      </style>
      <script type="text/javascript">
         function startloader() {
         	 document.getElementById("loaderstart").style.display='block';
         }
         	
      </script>
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
      <div id="loaderstart" class="loader" style="display: none;"></div>
      <div class="row"> </div>
      <div style="width:22%; float:left; background-color: #ffffff;">
         <%@include file="AdminDashboardLeftMenu.jsp" %>
      </div>
      <div style="width:70%; float:left; background-color: #ffffff">
         <table>
            <tr>
               <td class="center"><a href="offline-allindiamarksAnalysis" onclick="startloader()">
                  <img border="1" alt="ALL-INDIA-MARKS-ANALYSIS" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/indiawisereport.jpg"  >
                  </a><br><strong >ALL-INDIA-MARKS-ANALYSIS</strong>
               </td>
               <td class="center"><a href="offline-QuestionWiseErrorReport" onclick="startloader()">
                  <img border="1" alt="STUDENTWISE-QUESTIONWISE-ERROR-ANALYSIS" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/questionwiseerrorreport.jpg"  >
                  </a><br><strong >STUDENTWISE-QUESTIONWISE-ERROR-ANALYSIS</strong>
               </td>
               <td class="center"><a href="offline-subjectwiserightwrongreportform" onclick="startloader()">
                  <img border="1" alt="SUBJECT-WISE-WRONG-RIGHT-UNATTEMPT-COUNT" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/subjectwiseerror.jpg" >
                  </a><br><strong >SUBJECT-WISE-WRONG-RIGHT-UNATTEMPT-COUNT</strong>
               </td>
            </tr>
            <tr>
               <td class="center"><a href="offline-campuswiseerrorreport" onclick="startloader()">
                  <img border="1" alt="CAMPUS-WISE-ERROR-REPORT" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/campusewise.jpg" >
                  </a><br><strong>CAMPUS-WISE-ERROR-REPORT</strong>
               </td>
               <td class="center"><a href="offline-Statewiseerrorreport" onclick="startloader()">
                  <img border="1" alt="STATE-WISE-ERROR-REPORT" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/statewise.jpg" >
                  </a><br><strong >STATE-WISE-ERROR-REPORT</strong>
               </td>
               <td class="center"><a href="load-subjectwisemarksrangesoffline" onclick="startloader()">
                  <img border="1" alt="SUBJECT-WISE-MARKS-RANGES" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/subejctewiseavg.jpg"  >
                  </a><br><strong >SUBJECT-WISE-MARKS-RANGES</strong>
               </td>
            </tr>
            <tr>
               <td class="center"><a href="SubjectWiseReportOffline" onclick="startloader()">
                  <img border="1" alt="SUBJECT-WISE-HIGHEST-MARKS-REPORT" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/highestmarks.jpg"  >
                  </a><br><strong>SUBJECT-WISE-HIGHEST-MARKS-REPORT</strong>
               </td>
               <td class="center"><a href="load-fiftypercentmarkssubjectwiseoffline" onclick="startloader()">
                  <img border="1" alt="ABOVE-50%MARKS-SUBJECTWISE" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/abovefifty.jpg" >
                  </a><br><strong >ABOVE-50%MARKS-SUBJECTWISE</strong>
               </td>
               <td class="center"><a href="load-presentprevmarksAnalysisoffline" onclick="startloader()">
                  <img border="1" alt="PRESENT-PREVIOUS-TEST-COMPARE" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/Compare Files and Folders Base.jpg" >
                  </a><br><strong >PRESENT-PREVIOUS-TEST-COMPARE</strong>
               </td>
            </tr>
            <tr>
               <td  class="center"><a href="load-below100rankssubjectwiseincampusoffline" onclick="startloader()">
                  <img border="1" alt="BELOW-100 RANK-SUBJECT-WISE" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/belowhundred.jpg" >
                  </a><br><strong >BELOW-100 RANK-SUBJECT-WISE</strong>
               </td>
               <td  class="center"><a href="load-sectionwiseattendiesAvgsoffline" onclick="startloader()">
                  <img border="1" alt="SECTIONWISE-ATTENDENCE-AVG" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/sectionwiseicon.jpg" >
                  </a><br><strong >SECTIONWISE-ATTENDENCE-AVG</strong>
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