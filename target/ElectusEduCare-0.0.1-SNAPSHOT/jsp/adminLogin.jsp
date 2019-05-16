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
      <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
      <title>Admin Login Page</title>
      <link rel="stylesheet" href="${pageContext.request.contextPath}/theme/css/downloadcss/maxcdnbootstratpmin.css">
      <link rel="stylesheet" href="${pageContext.request.contextPath}/theme/css/downloadcss/cdnbootstratpmin.css">
      <link rel="stylesheet" href="${pageContext.request.contextPath}/theme/css/downloadcss/cdnresponsive.css">
      <%!
         public String returnerrorpage(){
         	
         return "load-selectschool";	
         }
         
         
         %>
      <%
         session = request.getSession(false);// don't create if it doesn't exist
         if(session != null && !session.isNew()) {
         	if(session.getAttribute("adminrole")!=null){
         		response.sendRedirect("load-AdminDashboard");
         	}
         } else {
             response.sendRedirect(returnerrorpage());
         }
         %>
      <script>
         function mouseoverPass(obj) {
         	  var obj = document.getElementById('password');
         	  obj.type = "text";
         	}
         	function mouseoutPass(obj) {
         	  var obj = document.getElementById('password');
         	  obj.type = "password";
         	}
         
      </script>
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
      <style type="text/css">
         .fake-input { position: relative; width:240px; }
         .fake-input input { border:none: background:#fff; display:block; width: 100%; box-sizing: border-box }
         .fake-input img { position: absolute; top: 2px; right: 5px }
      </style>
     <!--  <script type="text/javascript">
         var windowObjectReference;
         var params  = 'width='+screen.width;
         params += ', height='+screen.height;
         params += ', top=0, left=0'
         params += ', fullscreen=yes';
         
         var strWindowFeatures = "menubar=no,toolbar=no, location=no,resizable=yes,scrollbars=yes,status=no, top=0, bottom=0, left=0, right=0";
         
         function myFunction() {
          var username = document.getElementById("username").value;
          var password = document.getElementById("password").value;
          var uri = "load-adminloginform?username="+username+"&password="+password;
           windowObjectReference = window.open(uri, "", params);
           windowObjectReference.opener.close();
           windowObjectReference.opener.document.write("");
           windowObjectReference.opener.location.href='http://www.google.com'
         }
      </script>  -->
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
      <div id="loginModal" class="modal show" style="box-shadow: none;">
         <div class="modal-dialog"  style="box-shadow: none;">
            <div class="modal-content" style="box-shadow: none;">
               <div class="modal-header" style="background-color: #428BCA;color:white">
                  <label style="font-size: 18px; color: white;">Admin Login to <%=session.getAttribute("getschool") %></label> 
               </div>
               <div class="form-group" style="color:red;" id ="otperror">  </div>
               <div class="modal-body" style="overflow:auto">
                  <form:form modelAttribute="form" method="POST" action="load-adminloginform" id="formnames">
                     <form:hidden path="fname" value=""/>
                     <form:hidden path="student_id" value=""/>
                     <div class="form-group" style="color:red;"> ${message}  </div>
                     <div class="form-group">
                        <form:input path="username" id="username" class="form-control input-lg" placeholder="User Name" />
                     </div>
                     <div class="fake-input" style="width:100%">
                        <form:password path="password" id="password" class="form-control input-lg" placeholder="Password" />
                        <img src="${pageContext.request.contextPath}/theme/images/pass1.jpg" onmouseover="mouseoverPass();" onmouseout="mouseoutPass();"/>
                     </div>
                     <br>
                     <div class="col-md-6 col-sm-6" style="padding-bottom: 30px;">
                        <!-- <a href="javascript:window.open('load-loginform?username='+document.getElementById('username').value+'&password='+document.getElementById('password').value,'','toolbar=no, location=no, status=no, menubar=no, scrollbars=yes, resizable=yes, width=800, height=600');document.getElementById('formnames').submit();" onClick="window.open('','_self');window.close();" style="display:inline-block; border-radius:10px; -webkit-border-radius:10px; -moz-border-radius:10px; background:#b0090f; font:normal 18px MyriadPro-Bold, Arial, Helvetica, sans-serif; color:#ffffff; padding:8px 25px; margin:10px 10px; border:0; cursor:pointer;text-decoration: none;">Login to IndusNet</a> -->
                        <button class="btn btn-primary btn-lg btn-block" name="loginbutton" value="signin" onclick="myFunction();">Sign In</button>
                     </div>
                  </form:form>
                  <form:form modelAttribute="form" method="POST" action="load-loginoptform">
                     <div class="col-md-6 col-sm-6" style="padding-bottom: 30px;">
                        <button class="btn btn-primary btn-lg btn-block" value="signinotp" >Sign In with OTP</button>
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