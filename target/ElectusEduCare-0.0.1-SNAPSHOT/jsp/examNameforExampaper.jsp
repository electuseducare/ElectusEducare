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
      <div style="width:70%; float:left; background-color: #ffffff">
         <div class="panel panel-info">
            <div class="panel-heading">
               <center><b>Please select exam to view question paper.</b></center>
            </div>
         </div>
         <div class="row"></div>
               <form:form modelAttribute="epaper" action="load-viewKeyButtons">
               <div class="form-row">
                  <div class="form-group col-md-4">
                    </div>
                   <div class="form-group col-md-6">
                  <label for="inputPassword4">Exam Name</label>
              <form:select path="examname" id="selectedexam" class="chosen-select">
                     <option value="0">--Please Select--</option>
                     <c:forEach items="${examlist}" var="examname">
                        <option value="${examname.examname}">${examname.examname}</option>
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