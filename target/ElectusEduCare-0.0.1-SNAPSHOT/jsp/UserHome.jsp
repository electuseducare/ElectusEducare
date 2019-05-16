<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
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
                     <a class="navbar-brand" href="#"><img src="${pageContext.request.contextPath}/theme/images/Electus-Logo-RGB.jpg" alt="logo" style="padding-bottom: 20px;height: 70px; "/></a>
                  </div>
                  <div class="navbar-collapse collapse ">
                     <ul class="nav navbar-nav" >
                        <li class="active"><a href="#" style="color: white;">Home</a></li>
                        <li><a href="load-Planandexecution" style="color: white;">Planning & Execution</a></li>
                        <li><a href="load-staffrecruitment" style="color: white;">Staff-Recruitment & Training</a></li>
                        <li><a href="load-selectschool" style="color: white;">Online Exam</a></li>
                        <li><a href="load-material" style="color: white;">Material</a></li>
                        <li><a href="load-clients" style="color: white;">ClientEle</a></li>
                        <li><a href="#" style="color: white;">Contact</a></li>
                     </ul>
                  </div>
               </div>
            </div>
         </header>
         <!-- end header -->
         <section id="featured">
            <!-- Slider -->
            <div id="main-slider" class="flexslider">
               <ul class="slides">
                  <li>
                     <img src="${pageContext.request.contextPath}/theme/images/slide3.jpg" alt=""  />
                  </li>
                  <li>
                     <img src="${pageContext.request.contextPath}/theme/images/slide4.jpg" alt="" />
                  </li>
                  <li>
                     <img src="${pageContext.request.contextPath}/theme/images/slide5.jpg" alt="" />
                  </li>
                  <li>
                     <img src="${pageContext.request.contextPath}/theme/images/slide6.jpg" alt="" />
                  </li>
               </ul>
            </div>
            <!-- end slider -->
         </section>
         <section class="callaction">
            <div class="container">
               <div class="row">
                  <div class="col-lg-12">
                     <div class="aligncenter" style="font-size: 24px;">
                        <h1 class="aligncenter">
                           <marquee behavior="alternate">School as-a Service</marquee>
                        </h1>
                        <span class="clear spacer_responsive_hide_mobile " style="height:13px;display:block;"></span><b>Learning for every one and every where</b>
                     </div>
                  </div>
               </div>
            </div>
         </section>
         <section id="content">
            <div class="container">
               <div class="row">
                  <div class="skill-home">
                     <div class="skill-home-solid clearfix">
                        <div class="col-md-3 text-center">
                           <span class="icons c1"><i class="fa fa-balance-scale"></i></span> 
                           <div class="box-area">
                              <h3><a href="load-Planandexecution"  style="text-decoration: none;color: gray;">Planning and Execution</a></h3>
                              <ul>
                                 <li><a href="load-Planandexecution" id="planning"  style="text-decoration: none;color: gray;">Board Curriculum design</a></li>
                                 <li><a href="load-Planandexecution" id="planning1"  style="text-decoration: none;color: gray;">IIT/NEET foundation course design</a></li>
                                 <li><a href="load-Planandexecution" id="planning2"  style="text-decoration: none;color: gray;">Year wise schedule</a></li>
                                 <li><a href="load-Planandexecution" id="planning3"  style="text-decoration: none;color: gray;">Lesson plans</a> </li>
                                 <li><a href="load-Planandexecution" id="planning4"  style="text-decoration: none;color: gray;">Student Activities</a></li>
                                 <li><a href="load-Planandexecution" id="planning5"  style="text-decoration: none;color: gray;">Educational events</a></li>
                              </ul>
                              <a href="#planning5" id="planning5"  style="text-decoration: none;color: gray;">&nbsp;</a><br>
                           </div>
                        </div>
                        <div class="col-md-3 text-center">
                           <span class="icons c2"><i class="fa fa-graduation-cap"></i></span> 
                           <div class="box-area">
                              <h3><a href="load-staffrecruitment" style="text-decoration: none;color: gray;">Staff Recruitment and Training</a></h3>
                              <ul>
                                 <li>
                                    <a href="load-staffrecruitment" id="planning6"  style="text-decoration: none;color: gray;">Staff requirement analysis</a>
                                 </li>
                                 <li><a href="load-staffrecruitment" id="planning7"  style="text-decoration: none;color: gray;">Staff procurement and appointment</a></li>
                                 <li><a href="load-staffrecruitment" id="planning8"  style="text-decoration: none;color: gray;">Staff training</a></li>
                                 <li><a href="load-staffrecruitment" id="planning9"  style="text-decoration: none;color: gray;">Staff skill enrichment</a></li>
                              </ul>
                              <a href="#planning5" id="planning5"  style="text-decoration: none;color: gray;">&nbsp;</a><br>
                              <a href="#planning5" id="planning5"  style="text-decoration: none;color: gray;">&nbsp;</a><br>
                              <a href="#planning5" id="planning5"  style="text-decoration: none;color: gray;">&nbsp;</a><br>
                           </div>
                        </div>
                        <div class="col-md-3 text-center">
                           <span class="icons c3"><i class="fa fa-desktop"></i></span> 
                           <div class="box-area">
                              <h3><a href="load-onlineexamportal" style="text-decoration: none;color: gray;" >Online exam portal</a></h3>
                              <ul>
                                 <li><a href="load-onlineexamportal" id="planning10"  style="text-decoration: none;color: gray;">Marks analysis</a></li>
                                 <li><a href="load-onlineexamportal" id="erroranalysis"  style="text-decoration: none;color: gray;">Error analysis</a></li>
                                 <li><a href="load-onlineexamportal" id="planning12"  style="text-decoration: none;color: gray;">Time analysis</a></li>
                                 <li><a href="load-onlineexamportal" id="planning13"  style="text-decoration: none;color: gray;">Offline exam analysis</a></li>
                                 <li><a href="load-onlineexamportal" id="planning18"  style="text-decoration: none;color: gray;">Online platform for exams</a></li>
                              </ul>
                              <a href="#planning5" id="planning5"  style="text-decoration: none;color: gray;">&nbsp;</a><br>
                              <a href="#planning5" id="planning5"  style="text-decoration: none;color: gray;">&nbsp;</a><br>
                              <a href="#planning5" id="planning5"  style="text-decoration: none;color: gray;">&nbsp;</a><br>
                           </div>
                        </div>
                        <div class="col-md-3 text-center">
                           <span class="icons c4"><i class="fa fa-book"></i></span> 
                           <div class="box-area">
                              <h3><a href="load-material" style="text-decoration: none;color: gray;" >Material</a></h3>
                              <ul>
                                 <li><a href="load-material" id="planning14"  style="text-decoration: none;color: gray;">IIT-JEE foundation course book (Paper back/ Tablet P.C)</a></li>
                                 <li><a href="load-material" id="planning15"  style="text-decoration: none;color: gray;">IIT-JEE foundation work book(Paper back/ Tablet P.C)</a></li>
                                 <li><a href="load-material" id="planning16"  style="text-decoration: none;color: gray;">NEET foundation course book(Paper back/ Tablet P.C)</a></li>
                                 <li><a href="load-material" id="planning17"  style="text-decoration: none;color: gray;">NEET foundation work book(Paper back/ Tablet P.C)</a></li>
                              </ul>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </section>
         <footer style="background-color: #428BCA">
            <div class="container">
               <div class="row" style="text-align: center">
                  <div class="copyright" style="text-align: center">
                     <span class="x-el x-el-span px_-letter-spacing-normal px_-text-transform-none px_-fs-unset px_-ff-_Lusitana___Georgia__serif px_-fw-700 x-d-ux" style="font-size: 15px;color: black;"><b>Copyright © 2018 Electus Educare Private Limited - All Rights Reserved.</b></span>
                     <p>
                        <span> Powered By </span><a href="http://www.chiselontechnologies.com" target="_blank">Chiselon Technologies Pvt Ltd.</a>
                     </p>
                  </div>
                  <ul class="social-network">
                     <li><a href="https://www.facebook.com/ElectusEducare/" data-placement="top" title="Facebook"><i class="fa fa-facebook"></i></a></li>
                     <li><a href="https://twitter.com/EducareElectus" data-placement="top" title="Twitter"><i class="fa fa-twitter"></i></a></li>
                     <li><a href="#" data-placement="top" title="Linkedin"><i class="fa fa-linkedin"></i></a></li>
                     <li><a href="#" data-placement="top" title="Pinterest"><i class="fa fa-pinterest"></i></a></li>
                     <li><a href="#" data-placement="top" title="Google plus"><i class="fa fa-google-plus"></i></a></li>
                  </ul>
               </div>
            </div>
         </footer>
      </div>
      <a href="#" class="scrollup"><i class="fa fa-angle-up active"></i></a>
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