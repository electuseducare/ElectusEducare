<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <%@include file="DisplayLogo.jsp" %>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
      <title>Forgot Password</title>
      <script>
         function validUsernameOrnot(username){
         	alert(username);
         	
         	
         	var urls="load-validUsernameOrnot?username="+username;
             if (window.XMLHttpRequest)
             {
             xmlhttp=new XMLHttpRequest();
             }
           else
             {
             xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
             }
           xmlhttp.onreadystatechange=function()
             {
             if (xmlhttp.readyState==4)
               {
             	 examnameexists = xmlhttp.responseText;
             	 if(xmlhttp.responseText=="Exam name already exists. Please try with other name"){
                   	 document.getElementById("examerror").innerHTML=xmlhttp.responseText;
                   	 document.getElementById("examvalid").innerHTML="";
             	 }
             	 else{
             		 document.getElementById("examvalid").innerHTML=xmlhttp.responseText;
             		 document.getElementById("examerror").innerHTML="";
             	 }
               }
            
             }
           xmlhttp.open("POST",urls,true);
           xmlhttp.send();
           }
      </script>
   </head>
   <body>
      <div id="ForgotModal" class="modal show" >
         <div class="modal-dialog">
            <div class="modal-content">
               <div class="modal-header">
                  <label style="font-size: 18px; color: #150D8A;">Having trouble signing in?</label> 
               </div>
               <div class="form-group" style="color:red;" id ="otperror">  </div>
               <div class="modal-body" style="overflow:auto">
                  <form:form modelAttribute="form" method="POST" action="process-otpnumber">
                     <div class="form-group" style="color:red;"> ${message}  </div>
                     <div class="form-group">
                        <form:input path="username" id="username" class="form-control input-lg" placeholder="Enter Username" onkeyup="validUsernameOrnot(this.value);" />
                     </div>
                     <form:input path="otpval" id="otpvalues" class="form-control input-lg" placeholder="Enter OTP" onkeyup="validateOTP(otpvalues, username)"/>
                     <span id="otperror1" style="color: red"></span>
                     <span id="otpsuccess" style="color: green"></span>
                     <div class="form-group" id="signin" >
                        <button class="btn-primary">Submit</button>
                     </div>
                  </form:form>
               </div>
            </div>
         </div>
      </div>