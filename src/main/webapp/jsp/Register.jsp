<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ page import="java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
   <head>
      <%@include file="DisplayLogo.jsp" %>
      <style type="text/css">
         .btn1 {
         -webkit-border-radius: 28;
         -moz-border-radius: 28;
         border-radius: 28px;
         -webkit-box-shadow: 0px 1px 3px #FFFFFF;
         -moz-box-shadow: 0px 1px 3px #FFFFFF;
         box-shadow: 0px 1px 3px #FFFFFF;
         font-family: Arial;
         color: #000000;
         font-size: 20px;
         background: #ccffcc;
         padding: 6px 14px 6px 14px;
         text-decoration: none;
         }
         .btn1:hover {
         background: #3cb0fd;
         background-image: -webkit-linear-gradient(top, #3cb0fd, #3498db);
         background-image: -moz-linear-gradient(top, #3cb0fd, #3498db);
         background-image: -ms-linear-gradient(top, #3cb0fd, #3498db);
         background-image: -o-linear-gradient(top, #3cb0fd, #3498db);
         background-image: linear-gradient(to bottom, #3cb0fd, #3498db);
         text-decoration: none;
         }
         body {
         padding-top: 70px;
         padding-bottom: 30px;
         }
         .theme-dropdown .dropdown-menu {
         position: static;
         display: block;
         margin-bottom: 20px;
         }
         .theme-showcase > p > .btn {
         margin: 5px 0;
         }
         .theme-showcase .navbar .container {
         width: auto;
         }
         h1, h2, h3, h4, h5, h6{margin:0 0 20px 0; padding:0 0 8px 0; font-size:20px; font-weight:normal; font-family:Georgia, "Times New Roman", Times, serif; border-bottom:1px dotted #DDDDDD;}
         table{width:100%; border-collapse:collapse; table-layout:auto; vertical-align:top; margin-bottom:15px; border:0px solid #CCCCCC;}
         table thead th{color:#FFFFFF; background-color:#11EB82; border:0px solid #CCCCCC; border-collapse:collapse; text-align:center; table-layout:auto; vertical-align:middle;}
         table tbody td{vertical-align:top; border-collapse:collapse; border-left:0px solid #CCCCCC; border-right:0px solid #CCCCCC;}
         table thead th, table tbody td{padding:5px; border-collapse:collapse;}
         table tbody tr.light{color:#666666; background-color:#F08080;}
         table tbody tr.dark{color:#666666; background-color:#11EB82;}
         .tablebdy{
         vertical-align:top; border-collapse:collapse; border-left:1px solid #CCCCCC; border-right:1px solid #CCCCCC; border-bottom:1px solid #CCCCCC; padding:5px; table-layout:auto; background-color:#F7F7F7;
         }
         .tablebdy tr
         {
         color:#666666; border-collapse:collapse; border:1px dotted #CCCCCC;
         }
         .tablebdy td
         {
         vertical-align:middle;
         }
         .inntable thead th{background-image:url(../../images/tabimg.png); border:1px solid #CCCCCC; border-collapse:collapse; text-align:left; table-layout:auto; vertical-align:middle;}
         .inntable tr
         {
         color:#666666; border-collapse:collapse; border:1px dotted #CCCCCC; height:auto;
         }
         .inntable1 thead th{background-image:url(../../images/tabimg.png); border:1px solid #CCCCCC; border-collapse:collapse; text-align:left; table-layout:auto; vertical-align:middle;}
         .inntable1 tr
         {
         color:#666666; border-collapse:collapse; border:1px dotted #CCCCCC; height:auto; background-color:#F7F7F7;
         }
         .subtab{
         border:0px solid #CCCCCC; border-collapse:collapse; text-align:left; table-layout:auto; vertical-align:middle;
         }
         .subtab tr
         {
         color:#666666; border-collapse:collapse; border:0px dotted #CCCCCC; height:auto; background-color:#F7F7F7;
         }
      </style>
      <script type="text/javascript">
         function loadXMLDoc()
         {
         var xmlhttp;
         var k=document.getElementById("emailid").value;
         
         var urls="checkajax.jsp?ver="+k;
         
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
                 //document.getElementById("err").style.color="red";
                 document.getElementById("err").innerHTML=xmlhttp.responseText;
          
             }
           }
         xmlhttp.open("GET",urls,true);
         xmlhttp.send();
         }
         
         
         function usernameValidation()
         {
         var xmlhttp;
         var username=document.getElementById("username").value;
         
         var urls="checkajax.jsp?uname="+username;
         
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
                 //document.getElementById("err").style.color="red";
                 document.getElementById("username_error").innerHTML=xmlhttp.responseText;
          
             }
           }
         xmlhttp.open("GET",urls,true);
         xmlhttp.send();
         }
         function isNumberKey(evt)
         {
            var charCode = (evt.which) ? evt.which : event.keyCode
            if (charCode != 45  && charCode > 31 && (charCode < 48 || charCode > 57))
               return false;
         
            return true;
         }
         
         
      </script>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
      <meta name="description" content="">
      <meta name="author" content="">
      <title>Electus Educare</title>
      <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
      <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
   </head>
   <body>
      <div id="RegisterModal" class="modal show" >
         <div class="modal-dialog">
            <div class="modal-content">
               <div class="modal-header">
                  <label style="font-size: 18px; color: #150D8A;">Signup to Electus</label> 
               </div>
               <div class="modal-body" style="overflow:auto">
                  <div style="color:Red;">${msg} </div>
                  <div style="color:Green;">${smsg} </div>
                  <form:form name="regform" method="post" action="addregister"  modelAttribute="register" >
                     <div class="form-group">
                        <form:input path="name" class="form-control" id="uname"  placeholder="First Name" required="required"/>
                     </div>
                     <div class="form-group">
                        <form:input  path="Lname" class="form-control" id="Lname"  placeholder="Last Name" required="required"/>
                     </div>
                     <div class="form-group">
                        <form:input  path="username" class="form-control" id="username"  placeholder="User Name" autocomplete="off" onkeyup="usernameValidation()" required="required"/>
                        <form:errors path="email_id" cssClass="error"/>
                        <span id="username_error"> </span>
                     </div>
                     <div class="form-group">
                        <form:input path='email_id' class="form-control" id="emailid" autocomplete="off" onkeyup="loadXMLDoc()"  aria-describedby="emailHelp" placeholder="Enter email" />
                        <form:errors path="email_id" cssClass="error"/>
                        <span id="err"> </span>
                        <small id="emailHelp" style="color:#000000"class="form-text text-muted">We'll never share your email with anyone else.</small>
                     </div>
                     <div class="form-group">
                        <form:input  path="password" type="password" class="form-control" id="password"   placeholder="password" required="required"/>
                     </div>
                     <div class="form-group">
                        <form:input path="Mobile_Number" class="form-control" id="mobilenumber" autocomplete="off" maxlength="10"  onkeypress="return isNumberKey(event);" placeholder="+91" required="required"/>
                     </div>
                     <div class="form-group">
                        <button class="btn-primary">Register</button>
                     </div>
                  </form:form>
                  <div class="col-sm-4 text-center">
                     <a class="btn btn-default btn-sm btn-block" href="loadl-form" style="font-weight: bold; color: #150D8A;">Login here</a>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </body>
</html>