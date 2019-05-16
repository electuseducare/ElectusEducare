<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE HTML>
<html>

   <head>
      <%@include file="DisplayLogo.jsp" %>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
          <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
      <meta name="description" content="">
      <meta name="author" content="">
      <title>Electus Educare</title>
      <style type="text/css">
         body {
         padding-top: 0px;
         padding-bottom: 30px;
         }
         #loginModal{
         margin-top: 130px;
         }
         .first {
         background-color: green;
         height: 50px;
         margin-left: 200px;
         width: 100px;
         }
      </style>
      <script type="text/javascript">
         $('a').tooltip({
             position: { my: 'center bottom' , at: 'center top-10' },
             //tooltipClass: "myclass",
             disabled: true,
             close: function( event, ui ) { $(this).tooltip('disable'); }
         });
         
         $('a').on('click', function () {
             $(this).tooltip('enable').tooltip('open');
         });
      </script>
  
      <script type="text/javascript">
         function generateAndValidateOTP(username)
          {
          
          var xmlhttp;
          var uname=document.getElementById(username).value;
          var urls="load-generateOTP?username="+uname;
         
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
            	 if(xmlhttp.responseText=="Please check your email, OTP has been sent to your Email ID!"){
            		 
            	   document.getElementById("otpvalues").disabled=false; 
            	   document.getElementById("errormsg").innerHTML="";
            	     
            	 }
            	 else{
            		
            		 document.getElementById("otpvalues").disabled=true;
            		 document.getElementById("errormsg").innerHTML="";
            	 }
                  document.getElementById("otperror").innerHTML=xmlhttp.responseText;
                 
              }
           
            }
          xmlhttp.open("POST",urls,true);
          xmlhttp.send();
          }
         
         function validateOTP(otpvalues, username)
          {
          
          var xmlhttp;
          var otpva=otpvalues.value;
          var username = username.value;
          var urls="load-validateOTP?getotp="+otpva+"&username="+username;
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
            	
                  
                  if(xmlhttp.responseText=="Matched given OTP value! Please click on Sing in with OTP button"){
                	  document.getElementById("otperror").innerHTML="";
                	  document.getElementById("otperror1").innerHTML="";
                	  document.getElementById("otpsuccess").innerHTML=xmlhttp.responseText; 
                  }
                  else{
                	  document.getElementById("otperror").innerHTML="";
                	  document.getElementById("otperror1").innerHTML=xmlhttp.responseText; 
                	  document.getElementById("otpsuccess").innerHTML=""; 
                  }
                 
              }
           
            }
          xmlhttp.open("POST",urls,true);
          xmlhttp.send();
          }
      </script>
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
      <link rel="stylesheet" href="https://cdn.datatables.net/1.10.15/css/dataTables.bootstrap.min.css">
      <link rel="stylesheet" href="https://cdn.datatables.net/responsive/2.1.1/css/responsive.bootstrap.min.css">
   </head>
   <body>
      <header>
         <div class="navbar navbar-default navbar-static-top">
            <div class="container">
               <div class="navbar-header" >
                  <a  href="load-selectschool"><img src="${pageContext.request.contextPath}/theme/images/Electus-Logo-RGB.jpg" height="60" width="230" alt="logo"/></a>
               </div>
               <c:choose>
                  <c:when test="${clientlogo1=='0' || clientlogo1==''}">
                     <div class="navbar-header" style="float: right;">
                     </div>
                  </c:when>
                  <c:otherwise>
                     <div class="navbar-header" style="float: right;">
                        <img src="${pageContext.request.contextPath}/viewClientimage?imageID=${clientlogo1}" class=""  alt="logo" style="width: 230px;height: 60px;" />
                     </div>
                  </c:otherwise>
               </c:choose>
            </div>
         </div>
      </header>
      <!-- end header -->
      <div id="loginModal" class="modal show" >
         <div class="modal-dialog">
            <div class="modal-content">
               <div class="modal-header">
                  <label style="font-size: 18px; color: #150D8A;">Login with OTP to Electus</label> 
               </div>
               <div class="form-group" style="color:red;" id ="otperror">  </div>
               <div class="modal-body" style="overflow:auto">
                  <form:form modelAttribute="form" method="POST" action="process-loginotpform">
                     <form:hidden path="fname" value=""/>
                     <form:hidden path="student_id" value=""/>
                     <div class="form-group" style="color:red;" id="errormsg"> ${message}  </div>
                     <div class="form-group">
                        <form:input path="username" id="username" class="form-control input-lg" placeholder="User Name" autocomplete="off" onkeyup="generateAndValidateOTP(this.id)" onchange="generateAndValidateOTP(this.id)" onkeydown="if (event.keyCode == 13) {return false;}"/>
                     </div>
                     <div class="form-group" id="otpval">
                        <form:input path="otpval" id="otpvalues" class="form-control input-lg" placeholder="Enter OTP" autocomplete="off" disabled="disabled" onkeyup="validateOTP(otpvalues, username)"/>
                        <span id="otperror1" style="color: red"></span>
                        <span id="otpsuccess" style="color: green"></span>
                     </div>
                     <div class="col-md-6 col-sm-6" style="padding-bottom: 30px;">
                        <button class="btn btn-primary btn-lg btn-block" >Sign In with OTP</button>
                     </div>
                  </form:form>
                  <form:form modelAttribute="form" method="POST" action="loadl-form">
                     <div class="col-md-6 col-sm-6" style="padding-bottom: 30px;">
                        <button class="btn btn-primary btn-lg btn-block" >Sign In</button>
                     </div>
                  </form:form>
                  <div class="col-md-12 col-sm-12">
                     <div class="col-sm-6 text-left">
                        <a class="btn btn-default btn-sm btn-block" href="load-forgotPassword" style="font-weight: bold; color: #150D8A;">Forgot password?</a>
                     </div>
                     <div class="col-sm-6 text-right">
                        <a class="btn btn-default btn-sm btn-block" href="#" title="Phone: +91-xxx xxx xxxx" style="font-weight: bold; color: #150D8A;">Need help?</a>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </body>
</html>