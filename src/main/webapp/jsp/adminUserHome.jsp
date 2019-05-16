<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <%@include file="DisplayLogo.jsp" %>
      <style>
         #rcorners2 {
         border-radius: 25px;
         border: 2px solid   #99ccff;
         padding: 20px; 
         width: 130px;
         height: 130px; 
         }
         #rcorners2:hover {
         background-color:  #99ffbb;
         }
         td{
         font-size: 13px;
         }
      </style>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>Electus Educare</title>
   </head>
   <body>
      <div id="dialog" style="display:none;" title="Dialog Title">Your session is going to expire in 3 min</div>
      <%@include file="adminUserTopMenu.jsp" %>
      <%@include file="adminUserHeader.jsp" %>
      <!-- start header -->
      <div id="inner-headline" style="background-color: #ffffff">
         <div class="container">
            <div class="col-lg-12">
            </div>
         </div>
      </div>
      <div class="row"> </div>
      <div style="width:10%; float:left; background-color: #ffffff;">&nbsp;<%-- <%@include file="AdminDashboardLeftMenu.jsp" %> --%></div>
      <div style="width: 75%; float: left;margin-left: 50px;">
         <%int row=0; %>
         <h3 style="background-color:skyblue;text-align:center;padding: 10px">Website-Details</h3>
         <table>
            <c:forEach items="${userperm}" var="userperm" varStatus="loop">
               <%if(row==0){ %>
               <tr>
                  <%} %>
                  <c:if test="${userperm.permissiondesc=='ADD CONTACT DETAILS'}">
                     <td style="padding-left: 40px;"><a href="load-addContactdet">
                        <img border="1" alt="Contact Details" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/contact.png" width="100" height="100" >
                        </a><br><strong style="margin-left:5px">Contact Details</strong>
                     </td>
                  </c:if>
                  <c:if test="${userperm.permissiondesc=='CLIENT LOGO'}">
                     <td style="padding-left: 40px;"><a href="load-uploadClientlogo">
                        <img border="1" alt="Upload Logo" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/logos.png" width="100" height="100" >
                        </a><br><strong style="margin-left:15px">Upload Logo</strong>
                     </td>
                  </c:if>
                  <c:if test="${userperm.permissiondesc=='CLIENT CAROUSEL'}">
                     <td style="padding-left: 40px;"><a href="load-uploadClientCarousel">
                        <img border="1" alt="Upload Carousel" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/carousel.png" width="100" height="100" >
                        </a><br><strong style="margin-left:15px">Upload Carousel</strong>
                     </td>
                  </c:if>
                  <%if(row==4){ %>
               </tr>
               <%} %>
               <%row++;%>
            </c:forEach>
         </table>
         <br>
         <table>
            <h3 style="background-color:skyblue;text-align:center;padding: 10px">Pre-Settings</h3>
            <c:forEach items="${userperm}" var="userperm" varStatus="loop">
               <%if(row==5){ %>
               <tr>
                  <%} %>
                  <c:if test="${userperm.permissiondesc=='STATE'}">
                     <td style="padding-left: 40px;">
                        <a href="load-stateform">
                        <img border="1" alt="State" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/map.jpg" width="50" height="50" >
                        </a><br><strong style="margin-left: 35px">State</strong>
                     </td>
                  </c:if>
                  <c:if test="${userperm.permissiondesc=='LOCATION'}">
                     <td style="padding-left: 40px;"><a href="load-Locationform">
                        <img border="1" alt="Location" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/location.jpg" width="100" height="100" >
                        </a><br><strong style="margin-left: 40px">Location</strong>
                     </td>
                  </c:if>
                  <c:if test="${userperm.permissiondesc=='BRANCH'}">
                     <td style="padding-left: 40px;"><a href="load-branchform">
                        <img border="1" alt="Branch" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/school.jpg" width="100" height="100" >
                        </a><br><strong style="margin-left: 40px">Branch</strong>
                     </td>
                  </c:if>
                  <c:if test="${userperm.permissiondesc=='CLASS'}">
                     <td style="padding-left: 40px;">
                        <a href="load-categoryform">
                        <img border="1" alt="Class" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/class.jpg" width="100" height="100" >
                        </a><br><strong style="margin-left: 40px">Class</strong>
                     </td>
                  </c:if>
                  <c:if test="${userperm.permissiondesc=='SECTION'}">
                     <td style="padding-left: 40px;"><a href="load-sectionform">
                        <img border="1" alt="Section" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/subcateg.jpg" width="100" height="100" >
                        </a><br><strong style="margin-left: 40px">Section</strong>
                     </td>
                  </c:if>
                  <%if(row==9){ %>
               </tr>
               <%} %>
               <%row++;%>
            </c:forEach>
         </table>
         <table>
            <c:forEach items="${userperm}" var="userperm" varStatus="loop">
               <%if(row==10){ %>
               <tr>
                  <%} %>
                  <c:if test="${userperm.permissiondesc=='EXAM TYPE'}">
                     <td style="padding-left: 40px;"><a href="load-addexamtype">
                        <img border="1" alt="Examtype" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/examtype.jpg" width="100" height="100" >
                        </a><br><strong style="margin-left:30px">Examtype</strong>
                     </td>
                  </c:if>
                  <c:if test="${userperm.permissiondesc=='SUBJECT'}">
                     <td style="padding-left: 40px;">
                        <a href="load-Subjectform">
                        <img border="1" alt="Subject" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/subject.jpg" width="100" height="100" >
                        </a><br><strong style="margin-left: 40px">Subject</strong>
                     </td>
                  </c:if>
                  <c:if test="${userperm.permissiondesc=='SUBJECT TOPICS'}">
                     <td style="padding-left: 40px;"><a href="load-subtopicFilter">
                        <img border="1" alt="Subject Topics " id="rcorners2" src="${pageContext.request.contextPath}/theme/images/topic (2).jpg" width="100" height="100" >
                        </a><br><strong style="margin-left:15px">Subject Topics</strong>
                     </td>
                  </c:if>
                  <c:if test="${userperm.permissiondesc=='QUESTION TYPE'}">
                     <td style="padding-left: 40px;"><a href="load-EditQustiontypeform">
                        <img border="1" alt="Question Type" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/questiontype.jpg" width="100" height="100" >
                        </a><br><strong style="margin-left:15px">Question Type</strong>
                     </td>
                  </c:if>
                  <c:if test="${userperm.permissiondesc=='QUESTION LEVEL'}">
                     <td style="padding-left:40px;"><a href="load-addquestionlevel">
                        <img border="1" alt="Question Level" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/questionlevel.jpg" width="100" height="100" >
                        </a><br><strong style="margin-left:15px">Question Level</strong>
                     </td>
                  </c:if>
                  <%if(row==14){ %>
               </tr>
               <%} %>
               <%row++;%>
            </c:forEach>
         </table>
         <table>
            <c:forEach items="${userperm}" var="userperm" varStatus="loop">
               <%if(row==15){ %>
               <tr>
                  <%} %>
                  <c:if test="${userperm.permissiondesc=='NEW-STUDENT'}">
                     <td style="padding-left:40px;"><a href="load-studentform">
                        <img border="5" alt="New Student" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/student.jpg" width="100" height="100" >
                        </a><br><strong style="margin-left: 35px">Student</strong>
                     </td>
                  </c:if>
                  <c:if test="${userperm.permissiondesc=='STUDENT BULK UPDATE'}">
                     <td style="padding-left: 40px;"><a href="load-uploaddata">
                        <img border="1" alt="Student Bulk Updated" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/bulkupdate.jpg" width="100" height="100" >
                        </a><br><strong>Student Bulk Update</strong>
                     </td>
                  </c:if>
                  <c:if test="${userperm.permissiondesc=='NEW-ADMIN'}">
                     <td style="padding-left: 40px;"><a href="load-Adminform">
                        <img border="5" alt="New Admin" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/admin.png" width="100" height="100" >
                        </a><br><strong style="margin-left: 35px">Admin</strong>
                     </td>
                  </c:if>
                  <c:if test="${userperm.permissiondesc=='NEW-LECTURER'}">
                     <td style="padding-left: 40px;"><a href="load-lecturerform">
                        <img border="1" alt="New Lecturer" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/guest-lecture.jpg" width="100" height="100" >
                        </a><br><strong style="margin-left:30px">Lecturer</strong>
                     </td>
                  </c:if>
                  <c:if test="${userperm.permissiondesc=='FILTER EXAM CRITERIA'}">
                     <td style="padding-left: 40px;"><a href="load-classfilterquestions">
                        <img border="1" alt="Filter Exam Criteria" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/filter.jpg" width="100" height="100" >
                        </a><br><strong >Filter Exam Criteria</strong>
                     </td>
                  </c:if>
                  <%if(row==19){ %>
               </tr>
               <%} %>
               <%row++;%>
            </c:forEach>
         </table>
         <br>
         <table>
            <h3 style="background-color:skyblue;text-align:center;padding: 10px">Daily Activity</h3>
            <c:forEach items="${userperm}" var="userperm" varStatus="loop">
               <%if(row==20){ %>
               <tr>
                  <%} %>	 
                  <c:if test="${userperm.permissiondesc=='CREATE EXAM'}">
                     <td style="padding-left: 40px;"><a href="view-createexamdashboard">
                        <img border="1" alt="Create Exam" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/exam.jpg" width="100" height="100" >
                        </a><br><strong style="margin-left: 20px">Create Exam</strong>
                     </td>
                  </c:if>
                  <c:if test="${userperm.permissiondesc=='STUDENT ASSIGNMENT'}">
                     <td style="padding-left: 40px;"><a href="load-studentAssign">
                        <img border="1" alt="Student Assignment" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/assign.jpg" width="100" height="100" >
                        </a><br><strong style="margin-left: 5px">Student Assignment</strong>
                     </td>
                  </c:if>
                  <c:if test="${userperm.permissiondesc=='EXAM PAPER'}">
                     <td style="padding-left: 40px;"><a href="load-viewexamnamesforqpaper">
                        <img border="1" alt="Exam Question Paper" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/qpaper.jpg" width="100" height="100" >
                        </a><br><strong >Exam Question Paper</strong>
                     </td>
                  </c:if>
                  <c:if test="${userperm.permissiondesc=='Student Exam Count'}">
                     <td style="padding-left: 30px;"><a href="view-examnameforstudcount">
                        <img border="1" alt="Student Exam Count" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/count.jpg" width="100" height="100" >
                        </a><br><strong>Student Exam Count</strong>
                     </td>
                  </c:if>
                  <c:if test="${userperm.permissiondesc=='EXAM STATUS'}">
                     <td style="padding-left: 40px;"><a href="load-viewexamnamesforstdexamstatus">
                        <img border="1" alt="Student Exam Status" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/right.png" width="100" height="100" >
                        </a><br><strong >Student Exam Status</strong>
                     </td>
                  </c:if>
                  <%if(row==24){ %>
               </tr>
               <%} %>
               <%row++;%>
            </c:forEach>
         </table>
         <table>
            <c:forEach items="${userperm}" var="userperm" varStatus="loop">
               <%if(row==25){ %>
               <tr>
                  <%} %>
                  <c:if test="${userperm.permissiondesc=='SET EXAM PATTERN'}">
                     <td style="padding-left: 40px;"><a href="load-setstartexampattern">
                        <img border="1" alt="Set Exam Pattern" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/exampattern.jpg" width="100" height="100" >
                        </a><br><strong >Set Exam Pattern</strong>
                     </td>
                  </c:if>
                  <c:if test="${userperm.permissiondesc=='UPDATE KEY'}">
                     <td style="padding-left: 40px;"><a href="load-updateKey">
                        <img border="1" alt="Update Key" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/key.jpg" width="100" height="100" >
                        </a><br><strong style="margin-left:25px">Update Key</strong>
                     </td>
                  </c:if>
                  <c:if test="${userperm.permissiondesc=='REPORTS'}">
                     <td style="padding-left: 40px;"><a href="load-ExamNameReports">
                        <img border="1" alt="Reports" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/reports.jpg" width="100" height="100" >
                        </a><br><strong style="margin-left:35px">Reports</strong>
                     </td>
                  </c:if>
                  <c:if test="${userperm.permissiondesc=='SUBMIT EXAM'}">
                     <td style="padding-left: 40px;"><a href="load-viewexamnamesforsubmitexam">
                        <img border="1" alt="Submit Exam" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/submit.jpg" width="100" height="100" >
                        </a><br><strong style="margin-left:20px">Submit Exam</strong>
                     </td>
                  </c:if>
                  <c:if test="${userperm.permissiondesc=='Results Calculation'}">
                     <td style="padding-left: 40px;"><a href="load-resultsCalculation">
                        <img border="1" alt="Results Calculation" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/resultc.jpg" width="100" height="100" >
                        </a><br><strong style="margin-left:5px">Results Calculation</strong>
                     </td>
                  </c:if>
                  <%if(row==29){ %>
               </tr>
               <% } %>
               <%row++;%>
            </c:forEach>
         </table>
         <table>
            <c:forEach items="${userperm}" var="userperm" varStatus="loop">
               <%if(row==30){ %>
               <tr>
                  <%} %>
                  <c:if test="${userperm.permissiondesc=='USERS LOG DATA'}">
                     <td style="padding-left: 40px;"><a href="load-classfilterstudentsLog">
                        <img border="1" alt="Users Log Data" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/logdata.png" width="100" height="100" >
                        </a><br><strong >Users Log Data</strong>
                     </td>
                  </c:if>
                  <c:if test="${userperm.permissiondesc=='PROGRESS CARD'}">
                     <td style="padding-left: 40px;"><a href="load-progresscard">
                        <img border="1" alt="Progress Report" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/progresscard.jpg" width="100" height="100" >
                        </a><br><strong style="margin-left:10px">Progress Report</strong>
                     </td>
                  </c:if>
                  <c:if test="${userperm.permissiondesc=='ACCESS FOR ROLES'}">
                     <td style="padding-left: 40px;"><a href="load-addaccessforRolese">
                        <img border="1" alt="Access for roles" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/permission.jpg" width="100" height="100" >
                        </a><br><strong style="margin-left:10px">Access For Roles</strong>
                     </td>
                  </c:if>
                  <c:if test="${userperm.permissiondesc=='OFFLINE ANALYSIS'}">
                     <td style="padding-left: 40px;"><a href="load-OfflineAnalysis">
                        <img border="1" alt="Upload Offline Files" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/Upload-icon.png" width="100" height="100" >
                        </a><br><strong >Upload Offline Files</strong>
                     </td>
                  </c:if>
                  <c:if test="${userperm.permissiondesc=='STUDENT STATUS'}">
                     <td style="padding-left: 40px;"><a href="load-getclassandsect">
                        <img border="1" alt="Student Status" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/studentstatus.jpg" width="100" height="100" >
                        </a><br><strong style="margin-left:5px">Student Status</strong>
                     </td>
                  </c:if>
                  <%if(row==34){ %>
               </tr>
               <% } %>
               <%row++;%>
            </c:forEach>
         </table>
         <table>
         </table>
         <div class="row"></div>
         <div class="row"></div>
         <div class="row"></div>
         <div class="row"></div>
         <div class="row"></div>
      </div>
      <div style="width:10%; float:left; background-color: #ffffff;">&nbsp;<%-- <%@include file="AdminDashboardLeftMenu.jsp" %> --%></div>
      <%-- <%@include file="adminfooter.jsp" %> --%>
   </body>
</html>