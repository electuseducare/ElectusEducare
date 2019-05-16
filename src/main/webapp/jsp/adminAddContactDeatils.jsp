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
      <script src="${pageContext.request.contextPath}/theme/js/downloadjs/ajax1111.js"></script>
      <script type="text/javascript">
         function fieldvalidation(){
         	/** Location name is Empty */
         	var mobilenum = document.getElementById('contactinfo').value;
         	var address = document.getElementById('address').value;
         	var mail = document.getElementById('emailid').value;
         	var len =contact.replace(/\s+$/, '');
         	var len1 =address.replace(/\s+$/, '');
         	var len2 =mail.replace(/\s+$/, '');
             if(len==''){
             	alert('Mobile Number should not be empty');
             	return false;
             }
             else  if(len1==''){
             	alert('Address should not be empty');
             	return false;
             }
             
             else  if(len2==''){
             	alert('MailId should not be empty');
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
            <li class="active" ><a href="#" >ADD CONTACT DETAILS</a></li>
         </ul>
         <div class="panel-heading" style="background-color:#ccf2ff;color:black; font-weight: bold;"><a href="load-addContactdet"><img border="0" alt="W3Schools" src="${pageContext.request.contextPath}/theme/images/addicon.jpg" width="40" height="40" style="background-color:#ccf2ff"></a></div>
         <div class="panel-body" id="mockTabs" style="background-color:#DFE2DB;">
            <center>
               <h4 style="color:green">${smsg}</h4>
            </center>
            <center>
               <h4 style="color:red">${emsg}</h4>
            </center>
            <c:if test="${smsg==null}" >
               <form:form  name="AddRoleform" method="post" action="process-contactform"  modelAttribute="addcontact" >
                  <label style="color:black;font-weight: bold;">Mobile Number:</label>
                  <form:input path="contactinfo"   class="form-control" placeholder="Mobile" required="required" pattern="^\d{10}$" title="10 numeric characters only" maxlength="10" minlength="10" onkeypress="return event.charCode >= 48 && event.charCode <= 57"/>
                  <div class="row"></div>
                  <label style="color:black;font-weight: bold;">Email Id:</label>
                  <form:input path="emailid"  class="form-control" placeholder="Enter EmailId"  type="mailid"   maxlength="60" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" title="Invalid email address"  autocomplete="off"/>
                  <div class="row"></div>
                  <label style="color:black;font-weight: bold;">Address:</label>
                  <form:textarea  path="address" row="1000" cols="1000" class="form-control" placeholder="Enter Address" required="required"  maxlength="60" autocomplete="off"/>
                  <div class="row"></div>
                  <center><button class="btn-primary" style="background-color: #00a3cc;color:white;width:15%;align-text:center;" onclick="return fieldvalidation();">ADD CONTACT DETAILS</button></center>
               </form:form>
            </c:if>
         </div>
      </div>
      <center>
         <div style="width: 10%;float:right;background-color: #ffffff"> </div>
      </center>
      <%@include file="adminfooter.jsp" %>
   </body>
</html>