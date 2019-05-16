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
            <div class="navbar navbar-default navbar-static-top" style="background-color:#ff9900;">
               <div class="container">
                  <div class="navbar-header">
                     <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                     <span class="icon-bar"></span>
                     <span class="icon-bar"></span>
                     <span class="icon-bar"></span>
                     </button>
                     <a class="navbar-brand" href="#"><img src="${pageContext.request.contextPath}/theme/images/Electus-Logo-RGB.jpg" alt="logo" style="padding-bottom: 20px;height: 70px;"/></a>
                  </div>
                  <div class="navbar-collapse collapse ">
                     <ul class="nav navbar-nav" >
                        <li class="active"><a href="load-UserHome" style="color: white;">Home</a></li>
                        <li><a href="load-Planandexecution" style="color: white;">Planning & Execution</a></li>
                        <li><a href="load-staffrecruitment" style="color: white;">Staff-Recruitment & Training</a></li>
                        <li><a href="load-loginform" style="color: white;">Online Exam</a></li>
                        <li><a href="load-material" style="color: white;">Material</a></li>
                        <li><a href="#" style="color: white;">ClientEle</a></li>
                        <li><a href="#" style="color: white;">Contact</a></li>
                     </ul>
                  </div>
                  <center><b><span style="color:white;">Learning for every one and every where</span></b></center>
               </div>
            </div>
         </header>
         <div class="container">
            <div class="col-lg-12">
               <div class="aligncenter">
                  <h2 class="aligncenter">Online Exam Portal</h2>
                  <span class="clear spacer_responsive_hide_mobile " style="height:13px;display:block;"></span>
               </div>
            </div>
            <div class="row">
               <div class="col-md-4">
                  <div class="textbox" style="height: 170px;">
                     <h3> <a href="#planning10" id="planning" style="text-decoration: none;">Marks analysis</a></h3>
                     <p>Subject wise ranking, totals wise ranking, branch wise and institution wise ranking slides are provided.<a href="#" style=" display: block; width: 120px; height: 30px;background: #4E9CAF; padding: 5px;text-align: center;border-radius: 5px;color: white;font-weight: bold;text-transform: uppercase;text-decoration: none;">view more</a></p>
                  </div>
               </div>
               <div class="col-md-4">
                  <div class="textbox" style="height: 170px;">
                     <h3><a href="#erroranalysis" id="erroranalysis" style="text-decoration: none;">Error analysis</a></h3>
                     <p>Student wise, branch wise and institution wise Error analysis slides are provided.<a href="#" style=" display: block; width: 120px; height: 30px;background: #4E9CAF; padding: 5px;text-align: center;border-radius: 5px;color: white;font-weight: bold;text-transform: uppercase;text-decoration: none;">view more</a></p>
                  </div>
               </div>
               <div class="col-md-4">
                  <div class="textbox" style="height: 170px;">
                     <h3><a href="#planning12" id="planning12" style="text-decoration: none;">Time analysis</a></h3>
                     <p>Time taken for each question by the student is captured.<a href="#" style=" display: block; width: 120px; height: 30px;background: #4E9CAF; padding: 5px;text-align: center;border-radius: 5px;color: white;font-weight: bold;text-transform: uppercase;text-decoration: none;">view more</a></p>
                  </div>
               </div>
            </div>
            <div class="row">
               <div class="col-md-4">
                  <div class="textbox" style="height: 170px;">
                     <h3><a href="#planning13" id="planning13" style="text-decoration: none;">Offline exam analysis</a></h3>
                     <p>Marks analysis is provided, Based on the "OMR sheet reading data".<a href="#" style=" display: block; width: 120px; height: 30px;background: #4E9CAF; padding: 5px;text-align: center;border-radius: 5px;color: white;font-weight: bold;text-transform: uppercase;text-decoration: none;">view more</a></p>
                  </div>
               </div>
            </div>
         </div>
         <footer>
            <div class="container">
               <div class="row">
                  <div class="col-lg-3">
                     <div class="widget">
                        <h5 class="widgetheading">Our Contact</h5>
                        <address>
                           <strong>Abovecompany Inc</strong><br>
                           JC Main Road, Near Silnile tower<br>
                           Pin-21542 NewYork US.
                        </address>
                        <p>
                           <i class="icon-phone"></i> (123) 456-789 - 1255-12584 <br>
                           <i class="icon-envelope-alt"></i> email@domainname.com
                        </p>
                     </div>
                  </div>
                  <div class="col-lg-3">
                     <div class="widget">
                        <h5 class="widgetheading">Quick Links</h5>
                        <ul class="link-list">
                           <li><a href="#">Latest Events</a></li>
                           <li><a href="#">Terms and conditions</a></li>
                           <li><a href="#">Privacy policy</a></li>
                           <li><a href="#">Career</a></li>
                           <li><a href="#">Contact us</a></li>
                        </ul>
                     </div>
                  </div>
                  <div class="col-lg-3">
                     <div class="widget">
                        <h5 class="widgetheading">Latest posts</h5>
                        <ul class="link-list">
                           <li><a href="#">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</a></li>
                           <li><a href="#">Pellentesque et pulvinar enim. Quisque at tempor ligula</a></li>
                           <li><a href="#">Natus error sit voluptatem accusantium doloremque</a></li>
                        </ul>
                     </div>
                  </div>
                  <div class="col-lg-3">
                     <div class="widget">
                        <h5 class="widgetheading">Recent News</h5>
                        <ul class="link-list">
                           <li><a href="#">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</a></li>
                           <li><a href="#">Pellentesque et pulvinar enim. Quisque at tempor ligula</a></li>
                           <li><a href="#">Natus error sit voluptatem accusantium doloremque</a></li>
                        </ul>
                     </div>
                  </div>
               </div>
            </div>
            <div id="sub-footer">
               <div class="container">
                  <div class="row">
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