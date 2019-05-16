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
      <link rel="stylesheet" href="${pageContext.request.contextPath}/theme/css/chosen.css">
      <link rel="stylesheet" href="${pageContext.request.contextPath}/theme/css/prism.css">
      <style type="text/css">
         .select,
         .chosen-select,
         .chosen-select-no-single,
         .chosen-select-no-results,
         .chosen-select-deselect,
         .chosen-select-rtl,
         .chosen-select-width {
         width: 350px;
         }
      </style>
      <script>
         function examFormValidation() {
         	var selectedexam = document.getElementById('selectedexam').value;
         	if(selectedexam=='0'){
         		alert("Please select Exam from drop-down");
         		return false;
         	}
         }
         
         
      </script>
   </head>
   <body>
      <%@include file="adminUserTopMenu.jsp" %>
      <%@include file="adminUserHeader.jsp" %>
      <!-- start header -->
      <div class="row"> </div>
      <div style="width:22%; float:left; background-color: #ffffff;"><%@include file="AdminDashboardLeftMenu.jsp" %></div>
      <div style="width:70%; float:left; background-color: #ffffff;">
         <div class="panel panel-info">
            <div class="panel-heading">
               <center><b>Please select exam to view reports.</b></center>
            </div>
         </div>
         <div class="row"></div>
         <div class="col-sm-12" style="padding: 4px; float: left; margin-left: 200px;">
            <div class="side-by-side clearfix">
               <form:form modelAttribute="adminreport" action="load-OfflineExamReports">
                  <select name="exam" id="selectedexam" class="chosen-select">
                     <option value="0">--Please Select Exam--</option>
                     <c:forEach items="${examlist}" var="examname">
                        <option value="${examname.examname}">${examname.examname}</option>
                     </c:forEach>
                  </select>
                  <button class="button btn-primary" onclick="return examFormValidation();"> View Report </button>
                  <div class="row"></div>
                  <div class="row"></div>
                  <div class="row"></div>
                  <div class="col-sm-6" style="margin-left: 100px;">
                     <span style="text-align: center; "><a href="load-OfflineAnalysis"> Back to Offline Data </a></span>
                  </div>
               </form:form>
            </div>
         </div>
      </div>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.js" type="text/javascript"></script>
      <script src="${pageContext.request.contextPath}/theme/js/chosenjquery.js"></script>
      <script src="${pageContext.request.contextPath}/theme/js/prism.js"></script>
      <script src="${pageContext.request.contextPath}/theme/js/init.js"></script>
      <%@include file="adminfooter.jsp" %>
   </body>
</html>