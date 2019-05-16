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
      <style type="text/css">
         .form-gap {
         padding-top: 70px;
         }
      </style>
      <script type="text/javascript">
         function startloader() {
         
         	 document.getElementById("loaderstart").style.display='block';
         }
         	
      </script>
      <style type="text/css">
         .loader {
         position: fixed;
         left: 0px;
         top: 0px;
         width: 100%;
         height: 100%;
         z-index: 9999;
         background: url('https://loading.io/assets/img/landing/curved-bars.svg')
         50% 50% no-repeat rgb(249, 249, 249);
         opacity: .8;
         }
      </style>
   </head>
   <body>
      <div id="loaderstart" class="loader" style="display: none;"></div>
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
      <div class="form-gap"></div>
      <div class="container">
         <div class="row">
            <div class="col-md-4 col-md-offset-4">
               <div class="panel panel-default">
                  <div class="panel-body">
                     <div class="text-center">
                        <h3><i class="fa fa-lock fa-4x"></i></h3>
                        <h2 class="text-center">Forgot Password?</h2>
                        <p>You can reset your password here.</p>
                        <div class="panel-body">
                           <form:form modelAttribute="forgotform" method="POST" action="process-forgotform">
                              <div class="form-group" style="color:green;"><b>${message} </b> </div>
                              <div class="form-group" style="color:red;"> <b>${message1}</b>  </div>
                              <div class="form-group">
                                 <div class="input-group">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-envelope color-blue"></i></span>
                                    <form:input path="email" id="email" class="form-control input-lg" placeholder="Enter your Email ID" autocomplete="off" />
                                 </div>
                              </div>
                              <div class="form-group">
                                 <input name="recover-submit" class="btn btn-lg btn-primary btn-block" onclick="startloader()" value="Reset Password" type="submit">
                              </div>
                              <div class="col-sm-6 text-center">
                                 <a class="btn btn-default btn-sm btn-block" href="loadl-form" style="font-weight: bold; color: #150D8A;">Login here</a>
                              </div>
                              <div class="col-sm-6 text-right">
                                 <a class="btn btn-default btn-sm btn-block" href="#" style="font-weight: bold; color: #150D8A;">Need help?</a>
                              </div>
                              <input type="hidden" class="hide" name="token" id="token" value=""> 
                           </form:form>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </body>
</html>