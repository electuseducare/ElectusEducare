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
      <%@include file="AdminModuleValidations.jsp" %>
      <script type="text/javascript">
         var validData = true;
         
         function whitespaceValidation(textvalue){
         	
         	var len =textvalue.replace(/\s+$/, '');
             if(len==''){
             	//alert('Topic / Sub Tocpics should not be empty');
             	validData = false;
             	return false;
             }
             else{
             	validData = true;
             }
         	
         	}
         
         function formValidation(){
         	if(validData==false){
         		alert('Fields should not be empty');
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
         <ul class="nav nav-tabs">
            <li class="active" ><a href="#" >ADD LECTURER</a></li>
            <li ><a href="load-EditLecturerform" >MODIFY LECTURER</a></li>
            <li ><a href="load-DeleteLecturerform" >DELETE LECTURER</a></li>
         </ul>
         <div class="panel-heading" style="background-color:#ccf2ff;color:black; font-weight: bold;">
            <a href="load-lecturerform">
            <img border="0" alt="W3Schools" src="${pageContext.request.contextPath}/theme/images/addicon.jpg" width="40" height="40" style="background-color: skyblue;">
            </a>
         </div>
         <div class="panel-body" id="mockTabs" style="background-color:#DFE2DB;">
            <center>
               <h4 style="color:green">${smsg}</h4>
            </center>
            <center>
               <h4 style="color:red">${emsg}</h4>
            </center>
            <c:if test="${smsg==null}" >
               <form:form  name="AddRoleform" method="post" action="load-ProcessLecturer"  modelAttribute="student" >
                  <div class="col-md-12 col-sm-12" id="deceased">
                     <div class="form-group col-md-6 col-sm-6">
                        <label for="firstname">First Name :*</label>
                        <form:input path="firstname" name="firstname" class="form-control" placeholder="firstname" required="required" pattern="^[a-zA-Z\\-\\s]+$" title="accept only alphabets" minlength="2" maxlength="60" onkeyup="return whitespaceValidation(this.value);"/>
                     </div>
                     <div class="form-group col-md-6 col-sm-6">
                        <label for="lastname">Last Name :*</label>
                        <form:input path="lastname" name="lastname" class="form-control" placeholder="lastname" required="required" pattern="^[a-zA-Z\\-\\s]+$" title="accept only alphabets" minlength="2" maxlength="60" onkeyup="return whitespaceValidation(this.value);"/>
                     </div>
                  </div>
                  <div class="col-md-12 col-sm-12" id="deceased">
                     <div class="form-group col-md-6 col-sm-6">
                        <label for="username">User Name :*</label>
                        <form:input path="username" name="username" class="form-control" placeholder="username" required="required" maxlength="60" minlength="6" onkeyup="return whitespaceValidation(this.value);"/>
                     </div>
                     <div class="form-group col-md-6 col-sm-6">
                        <label for="password">Password :*</label>
                        <form:input path="password" name="password" class="form-control" placeholder="password" required="required" maxlength="60" minlength="6" onkeyup="return whitespaceValidation(this.value);"/>
                     </div>
                  </div>
                  <div class="col-md-12 col-sm-12" id="deceased">
                     <div class="form-group col-md-6 col-sm-6">
                        <label for="email">Email Id :</label>
                        <form:input path="email" type="email" id="emailid" class="form-control" placeholder="email" required="required" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" title="xyz@something.com" onkeyup="return whitespaceValidation(this.value);"/>
                     </div>
                     <div class="form-group col-md-6 col-sm-6">
                        <label for="mobile">Mobile No :</label>
                        <form:input path="mobile"  class="form-control" placeholder="Mobile" required="required" pattern="^\d{10}$" title="10 numeric characters only" maxlength="10" minlength="10" onkeyup="return whitespaceValidation(this.value);"/>
                     </div>
                  </div>
                  <div class="row"></div>
                  <center><button class="btn-primary" style="background-color: #00a3cc;color:white;width:15%;align-text:center;" onclick="return formValidation();">ADD LECTURER</button></center>
               </form:form>
            </c:if>
         </div>
      </div>
      <center>
         <div style="width: 10%;float:right;background-color: #ffffff"> </div>
      </center>
      <script>
         var input = document.getElementById('emailid');
         
         input.onkeyup = function(){
             this.value = this.value.toLowerCase();
         }
         
      </script>
      <%@include file="adminfooter.jsp" %>
   </body>
</html>