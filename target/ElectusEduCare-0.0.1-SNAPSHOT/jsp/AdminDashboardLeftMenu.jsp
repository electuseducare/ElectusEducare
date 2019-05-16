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
                  <label>Admin <br> DashBoard </label>
                  <ul class="nav" id="menuList">
                     <c:forEach items="${userperm}" var="userperm">
                        <c:if test="${userperm.permissiondesc=='CLIENT LOGO'}">
                           <li ><a href="load-uploadClientlogo" ><img border="1" alt="Client logo" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/logos.png" width="25" height="25" >&nbsp;&nbsp;Upload Logo</a></li>
                        </c:if>
                        <c:if test="${userperm.permissiondesc=='CLIENT CAROUSEL'}">
                           <li ><a href="load-uploadClientCarousel" ><img border="1" alt="Client carousel" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/carousel.png" width="25" height="25" >&nbsp;&nbsp;Upload Carousel</a></li>
                        </c:if>
                        <c:if test="${userperm.permissiondesc=='ADD CONTACT DETAILS'}">
                           <li ><a href="load-addContactdet" ><img border="1" alt="Contact details" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/contact.png" width="25" height="25" >&nbsp;&nbsp;Contact Details</a></li>
                           <hr>
                        </c:if>
                        <c:if test="${userperm.permissiondesc=='STATE'}">
                           <li ><a href="load-stateform"><img border="1" alt="State" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/india.jpg" width="25" height="25" >&nbsp;&nbsp;STATE </a></li>
                        </c:if>
                        <c:if test="${userperm.permissiondesc=='LOCATION'}">
                           <li ><a href="load-Locationform"><img border="1" alt="Location" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/location_dashboard.jpg" width="25" height="25" >&nbsp;&nbsp;LOCATION </a></li>
                        </c:if>
                        <c:if test="${userperm.permissiondesc=='BRANCH'}">
                           <li ><a href="load-branchform"> <img border="1" alt="Branch" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/schooldashboard.jpg" width="25" height="25" >&nbsp;&nbsp;BRANCH</a></li>
                        </c:if>
                        <c:if test="${userperm.permissiondesc=='CLASS'}">
                           <li ><a href="load-categoryform"> <img border="1" alt="Class" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/classimage.jpg" width="25" height="25" >&nbsp;&nbsp;CLASS</a></li>
                        </c:if>
                        <c:if test="${userperm.permissiondesc=='SECTION'}">
                           <li ><a href="load-sectionform"><img border="1" alt="Section" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/section.jpg" width="25" height="25" >&nbsp;&nbsp;SECTION</a></li>
                        </c:if>
                        <c:if test="${userperm.permissiondesc=='SUBJECT'}">
                           <li ><a href="load-Subjectform"> <img border="1" alt="Subject" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/subjectdashboard.jpg" width="25" height="25" >&nbsp;&nbsp;SUBJECT</a></li>
                        </c:if>
                        <c:if test="${userperm.permissiondesc=='EXAM TYPE'}">
                           <li ><a href="load-addexamtype"> <img border="1" alt="Exam type" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/examtypesmall.jpg" width="25" height="25" >&nbsp;&nbsp;EXAM TYPE</a></li>
                        </c:if>
                        <c:if test="${userperm.permissiondesc=='QUESTION LEVEL'}">
                           <li ><a href="load-addquestionlevel"> <img border="1" alt="Question Level" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/smalllevel.jpg" width="25" height="25" >&nbsp;&nbsp;QUESTION LEVEL</a></li>
                           <hr>
                        </c:if>
                        <c:if test="${userperm.permissiondesc=='SUBJECT TOPICS'}">
                           <li ><a href="load-subtopicFilter"> <img border="1" alt="Subject Topics" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/smalltopic.jpg" width="25" height="25" >&nbsp;&nbsp;SUBJECT TOPICS</a></li>
                        </c:if>
                        <c:if test="${userperm.permissiondesc=='QUESTION TYPE'}">
                           <li ><a href="load-EditQustiontypeform"><img border="1" alt="Question Type" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/questiontypedashboard.jpg" width="25" height="25" >&nbsp;&nbsp;QUESTION TYPE </a></li>
                        </c:if>
                        <c:if test="${userperm.permissiondesc=='STUDENT BULK UPDATE'}">
                           <li ><a href="load-uploaddata"><img border="1" alt="Student Bulk Update" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/bulk.jpg" width="25" height="25" >&nbsp;&nbsp;STUDENT BULK UPDATE</a></li>
                        </c:if>
                        <c:if test="${userperm.permissiondesc=='NEW-ADMIN'}">
                           <li ><a href="load-Adminform"><img border="1" alt="New Admin" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/admin_icon.jpg" width="25" height="25" >&nbsp;&nbsp;NEW-ADMIN </a></li>
                        </c:if>
                        <c:if test="${userperm.permissiondesc=='NEW-LECTURER'}">
                           <li ><a href="load-lecturerform"><img border="1" alt="New Lecturer" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/lecturer.jpg" width="25" height="25" > &nbsp;&nbsp;NEW-LECTURER </a></li>
                        </c:if>
                        <c:if test="${userperm.permissiondesc=='NEW-STUDENT'}">
                           <li ><a href="load-studentform"><img border="1" alt="New Student" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/studentdashboard.jpg" width="25" height="25" > &nbsp;&nbsp;NEW-STUDENT</a></li>
                        </c:if>
                        <c:if test="${userperm.permissiondesc=='FILTER EXAM CRITERIA'}">
                           <li ><a href="load-classfilterquestions"><img border="1" alt="Filter Exam Criteria" id="rcorners2" src="${pageContext.request.contextPath}/theme/images/filter.jpg" width="25" height="25" >&nbsp;&nbsp;FILTER CRITERIA</a></li>
                           <hr>
                        </c:if>
                        <li class="nav-divider" style="margin-top:0% ;" ></li>
                     </c:forEach>
                  </ul>
               </nav>
            </div>
         </div>
      </div>
   </body>
</html>