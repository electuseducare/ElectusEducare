<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <%@include file="DisplayLogo.jsp" %>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>COPY PREVIOUS CREATED EXAM PATTERN</title>
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
      <%@include file="AdminCreateExamModelWindows.jsp" %>
      <!-- start header -->
      <div class="row"> </div>
      <div style="width:22%; float:left; background-color: #ffffff;"><%@include file="AdminDashboardLeftMenu.jsp" %></div>
      <div style="width:70%; float:left; background-color: #ffffff">
         <ul class="nav nav-tabs">
            <li ><a href="load-SetExamform">CREATE EXAM</a></li>
            <li><a href="load-createSelectedQuestionsExam">EXAM WITH SELECTED QUESTIONS</a></li>
            <li class="active"><a href="#">COPY PREVIOUS CREATED EXAM PATTERN</a></li>
          <li><a href="load-createSelectedQuestionsExamwithFiles">SELECTED FILES</a></li>
         </ul>
         <div class="panel-heading" style="background-color:#ccf2ff;color:black; font-weight: bold;">
            <a href="load-availableExamsInCopyCreateExam" style="text-decoration: none;">
            <img border="0" alt="Add Create Exam" src="${pageContext.request.contextPath}/theme/images/copyexam.jpg" width="40" height="40" style="background-color: skyblue;">
            COPY PREVIOUS CREATED EXAM PATTERN </a>
         </div>
         <div class="row"></div>
               <form:form modelAttribute="getexamnames" action="display-selectedExamDetails">
               <div class="form-row">
                  <div class="form-group col-md-4">
                    </div>
                   <div class="form-group col-md-6">
                  <label for="inputPassword4">Exam Name</label>
               <form:select path="selectedexam" id="selectedexam" class="chosen-select">
                     <form:option value="0">--Please Select Exam Name--</form:option>
                     <c:forEach items="${examlist}" var="examname">
                        <form:option value="${examname.examname}"></form:option>
                     </c:forEach>
                  </form:select>
                    <div class="row"></div>
                    <div class="col-md-12">
                        <div class="col-md-2">
                        </div>
                        <div class="col-md-6">
                  <button class="button btn-primary" onclick="return examFormValidation();"> Select Exam </button>
                        </div>
                     </div>
                    
                    </div>
                    </div>
               </form:form>
            </div>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.js" type="text/javascript"></script>
      <script src="${pageContext.request.contextPath}/theme/js/chosenjquery.js"></script>
      <script src="${pageContext.request.contextPath}/theme/js/prism.js"></script>
      <script src="${pageContext.request.contextPath}/theme/js/init.js"></script>
      <%@include file="adminfooter.jsp" %>
   </body>
</html>