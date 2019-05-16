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
                     <a class="navbar-brand" href="${pageContext.request.contextPath}/"><img src="${pageContext.request.contextPath}/theme/images/Electus-Logo-RGB.jpg" alt="logo" style="padding-bottom: 20px;height: 70px;"/></a>
                  </div>
                  <div class="navbar-collapse collapse ">
                     <ul class="nav navbar-nav" >
                        <li class="active"><a href="${pageContext.request.contextPath}/" style="color: white;">Home</a></li>
                        <li><a href="#" style="color: white;">Planning & Execution</a></li>
                        <li><a href="load-staffrecruitment" style="color: white;">Staff-Recruitment & Training</a></li>
                        <li><a href="load-loginform" style="color: white;">Online Exam</a></li>
                        <li><a href="load-material" style="color: white;">Material</a></li>
                        <li><a href="load-clients" style="color: white;">ClientEle</a></li>
                        <li><a href="#" style="color: white;">Contact</a></li>
                     </ul>
                  </div>
               </div>
            </div>
         </header>
         <div class="container">
            <div class="col-lg-12">
               <div class="aligncenter">
                  <h2 class="aligncenter">Planning and Execution</h2>
                  <span class="clear spacer_responsive_hide_mobile " style="height:13px;display:block;"></span>
               </div>
            </div>
            <div class="row" >
               <div class="col-md-4">
                  <div class="textbox" style="height: 170px;">
                     <h3> <a href="#planning" id="planning" style="text-decoration: none;">Board Curriculum design</a></h3>
                     <p>The foundation course is integrated with the board syllabus being followed by the institution.<a href="#" style=" display: block; width: 120px; height: 30px;background: #4E9CAF; padding: 5px;text-align: center;border-radius: 5px;color: white;font-weight: bold;text-transform: uppercase;text-decoration: none;">view more</a></p>
                  </div>
               </div>
               <div class="col-md-4">
                  <div class="textbox" style="height: 170px;">
                     <h3><a href="#planning1" id="planning1" style="text-decoration: none;">IIT/NEET foundation course design</a></h3>
                     <p>The specified course is designed based on the specific output opted by the institution.<a href="#" style=" display: block; width: 120px; height: 30px;background: #4E9CAF; padding: 5px;text-align: center;border-radius: 5px;color: white;font-weight: bold;text-transform: uppercase;text-decoration: none;">view more</a></p>
                  </div>
               </div>
               <div class="col-md-4">
                  <div class="textbox" style="height: 170px;">
                     <h3><a href="#planning2" id="planning2" style="text-decoration: none;">Year wise schedule</a></h3>
                     <p>The total integrated syllabus is micro-scheduled to day- wise, period-wise and minute-wise tasks.<a href="#" style=" display: block; width: 120px; height: 30px;background: #4E9CAF; padding: 5px;text-align: center;border-radius: 5px;color: white;font-weight: bold;text-transform: uppercase;text-decoration: none;">view more</a></p>
                  </div>
               </div>
            </div>
            <div class="row">
               <div class="col-md-4">
                  <div class="textbox" style="height: 170px;">
                     <h3><a href="#planning3" id="planning3" style="text-decoration: none;">Lesson plans</a></h3>
                     <p>The lesson plans are designed along with work sheets.<a href="#" style=" display: block; width: 120px; height: 30px;background: #4E9CAF; padding: 5px;text-align: center;border-radius: 5px;color: white;font-weight: bold;text-transform: uppercase;text-decoration: none;">view more</a></p>
                  </div>
               </div>
               <div class="col-md-4">
                  <div class="textbox" style="height: 170px;">
                     <h3><a href="#planning4" id="planning4" style="text-decoration: none;">Student Activities</a></h3>
                     <p>Activities are planned by the expertise.<a href="#" style=" display: block; width: 120px; height: 30px;background: #4E9CAF; padding: 5px;text-align: center;border-radius: 5px;color: white;font-weight: bold;text-transform: uppercase;text-decoration: none;">view more</a></p>
                  </div>
               </div>
               <div class="col-md-4">
                  <div class="textbox" style="height: 170px;">
                     <h3><a href="#planning5" id="planning5" style="text-decoration: none;">Educational events</a></h3>
                     <p>Month wise Educational Events are designed useful to understand the concepts and applied to the real life experience.<a href="#" style=" display: block; width: 120px; height: 30px;background: #4E9CAF; padding: 5px;text-align: center;border-radius: 5px;color: white;font-weight: bold;text-transform: uppercase;text-decoration: none;">view more</a></p>
                  </div>
               </div>
            </div>
         </div>
         <br><br><br><br><br><br>
         <footer style="background-color: #428bca">
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