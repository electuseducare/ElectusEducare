<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
   <head>
      <%@include file="DisplayLogo.jsp" %>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0" />
      <meta name="description" content="" />
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>Electus Edu-Care Online Exam</title>
      <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/theme/css/userhomecss/bootstrap.min.css">
      <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/theme/css/userhomecss/flexslider.css">
      <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/theme/css/userhomecss/jquery.fancybox.css">
      <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/theme/css/userhomecss/style.css">
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
   </head>
   <body>
      <div id="wrapper">
         <!-- start header -->
         <header >
            <div class="navbar navbar-default navbar-static-top" style="background-color:#428bca;">
               <div class="container">
                  <div class="navbar-header">
                     <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                     <span class="icon-bar"></span>
                     <span class="icon-bar"></span>
                     <span class="icon-bar"></span>
                     </button>
                     <%--   <a class="navbar-brand" href="#"><img src="${pageContext.request.contextPath}/theme/images/sivaji-logo.jpg" alt="logo" style="padding-bottom: 10px;height: 100px;"/></a>
                        --%>
                     <c:choose>
                        <c:when test="${clientlogo=='0' || clientlogo==''}">
                           <div class="navbar-header" style="float: left;">
                           </div>
                        </c:when>
                        <c:otherwise>
                           <div class="navbar-header" style="float: left;">
                              <img src="${pageContext.request.contextPath}/viewClientimage?imageID=${clientlogo}" class=""  alt="logo" style="width: 150px;height: 70px;" />
                           </div>
                        </c:otherwise>
                     </c:choose>
                  </div>
                  <div class="navbar-collapse collapse ">
                     <ul class="nav navbar-nav" >
                        <li class="active"><a href="http://electus.co.in" style="color: white;">Home</a></li>
                        <li><a href="loadl-form" style="color: white;">Online Exam</a></li>
                        <li><a href="#" style="color: white;">Contact</a></li>
                     </ul>
                  </div>
                  <center><b><span style="color:white;">Learning for every one and every where</span></b></center>
               </div>
            </div>
         </header>
         <!-- end header -->
         <section id="featured">
            <!-- Slider -->
            <div id="main-slider" class="flexslider">
               <ul class="slides">
                  <c:forEach items="${getcarousel}" var="introdetails" varStatus="loop">
                     <li>
                        <img src="${pageContext.request.contextPath}/viewClientCarousel?imageID=${introdetails.carousel}" alt=""style=" height: 500px;"  >
                     </li>
                  </c:forEach>
               </ul>
            </div>
            <!-- end slider -->
         </section>
         <footer>
            <div class="container">
               <div class="col-lg-3">
                  <div class="widget">
                     <h5 class="widgetheading">Address</h5>
                     <address>
                        <c:forEach items="${getdet}" var="getExstContactDet1" varStatus="loop">
                           ${getExstContactDet1.address}
                        </c:forEach>
                     </address>
                     <p>
                        <c:forEach items="${getdet}" var="getmn" varStatus="loop">
                           <i class="icon-phone">   ${getmn.emailid} </i>
                        </c:forEach>
                     </p>
                  </div>
               </div>
               <div class="col-lg-3">
               </div>
               <div class="col-lg-3">
               </div>
               <div class="col-lg-3">
                  <div class="widget">
                     <h5 class="widgetheading">Contact</h5>
                     <c:forEach items="${getdet}" var="getdet1" varStatus="loop">
                        ${getdet1.contactinfo} 
                     </c:forEach>
                  </div>
               </div>
            </div>
            <div id="sub-footer">
               <div class="container">
                  <div class="col-lg-6">
                     <div class="copyright">
                        <p>
                           <span> Develop By </span><a href="http://www.chiselontechnologies.com" target="_blank">Chiselon Technologies</a>
                        </p>
                     </div>
                  </div>
                  <div class="col-lg-6">
                     <ul class="social-network">
                        <li><a href="#" data-placement="top" title="Facebook"><i class="fa fa-facebook"></i></a></li>
                        <li><a href="#" data-placement="top" title="Twitter"><i class="fa fa-twitter"></i></a></li>
                        <li><a href="#" data-placement="top" title="Linkedin"><i class="fa fa-linkedin"></i></a></li>
                        <li><a href="#" data-placement="top" title="Pinterest"><i class="fa fa-pinterest"></i></a></li>
                        <li><a href="#" data-placement="top" title="Google plus"><i class="fa fa-google-plus"></i></a></li>
                     </ul>
                  </div>
               </div>
            </div>
         </footer>
      </div>
      <!-- <a href="#" class="scrollup"><i class="fa fa-angle-up active"></i></a> -->
      <!-- ====================== js files=========== -->
      <script src="${pageContext.request.contextPath}/theme/js/userhomejs/jquery.js"></script>
      <script src="${pageContext.request.contextPath}/theme/js/userhomejs/jquery.easing.1.3.js"></script>
      <script src="${pageContext.request.contextPath}/theme/js/userhomejs/bootstrap.min.js"></script>
      <script src="${pageContext.request.contextPath}/theme/js/userhomejs/jquery.fancybox.pack.js"></script>
      <script src="${pageContext.request.contextPath}/theme/js/userhomejs/jquery.fancyboxmedia.js"></script>
      <script src="${pageContext.request.contextPath}/theme/js/userhomejs/jquery.quicksand.js"></script>
      <script src="${pageContext.request.contextPath}/theme/js/userhomejs/setting.js"></script>
      <script src="${pageContext.request.contextPath}/theme/js/userhomejs/jquery.flexslider.js"></script>
      <script src="${pageContext.request.contextPath}/theme/js/userhomejs/animate.js"></script>
      <script src="${pageContext.request.contextPath}/theme/js/userhomejs/custom.js"></script>
   </body>
</html>