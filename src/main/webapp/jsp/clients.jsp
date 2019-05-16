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
      <style type="text/css">
      </style>
      <style type="text/css">
         h2{
         text-align:center;
         padding: 20px;
         }
         /* Slider */
         .slick-slide {
         margin: 0px 20px;
         }
         .slick-slide img {
         width: 100%;
         }
         .slick-slider
         {
         position: relative;
         display: block;
         box-sizing: border-box;
         -webkit-user-select: none;
         -moz-user-select: none;
         -ms-user-select: none;
         user-select: none;
         -webkit-touch-callout: none;
         -khtml-user-select: none;
         -ms-touch-action: pan-y;
         touch-action: pan-y;
         -webkit-tap-highlight-color: transparent;
         }
         .slick-list
         {
         position: relative;
         display: block;
         overflow: hidden;
         margin: 0;
         padding: 0;
         }
         .slick-list:focus
         {
         outline: none;
         }
         .slick-list.dragging
         {
         cursor: pointer;
         cursor: hand;
         }
         .slick-slider .slick-track,
         .slick-slider .slick-list
         {
         -webkit-transform: translate3d(0, 0, 0);
         -moz-transform: translate3d(0, 0, 0);
         -ms-transform: translate3d(0, 0, 0);
         -o-transform: translate3d(0, 0, 0);
         transform: translate3d(0, 0, 0);
         }
         .slick-track
         {
         position: relative;
         top: 0;
         left: 0;
         display: block;
         }
         .slick-track:before,
         .slick-track:after
         {
         display: table;
         content: '';
         }
         .slick-track:after
         {
         clear: both;
         }
         .slick-loading .slick-track
         {
         visibility: hidden;
         }
         .slick-slide
         {
         display: none;
         float: left;
         height: 100%;
         min-height: 1px;
         }
         [dir='rtl'] .slick-slide
         {
         float: right;
         }
         .slick-slide img
         {
         display: block;
         }
         .slick-slide.slick-loading img
         {
         display: none;
         }
         .slick-slide.dragging img
         {
         pointer-events: none;
         }
         .slick-initialized .slick-slide
         {
         display: block;
         }
         .slick-loading .slick-slide
         {
         visibility: hidden;
         }
         .slick-vertical .slick-slide
         {
         display: block;
         height: auto;
         border: 1px solid transparent;
         }
         .slick-arrow.slick-hidden {
         display: none;
         }
      </style>
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
                     <a class="navbar-brand" href="${pageContext.request.contextPath}/"><img src="${pageContext.request.contextPath}/theme/images/Electus-Logo-RGB.jpg" alt="logo" style="padding-bottom: 20px;height: 70px; "/></a>
                  </div>
                  <div class="navbar-collapse collapse ">
                     <ul class="nav navbar-nav" >
                        <li class="active"><a href="${pageContext.request.contextPath}/" style="color: white;">Home</a></li>
                        <li><a href="load-Planandexecution" style="color: white;">Planning & Execution</a></li>
                        <li><a href="load-staffrecruitment" style="color: white;">Staff-Recruitment & Training</a></li>
                        <li><a href="load-selectschool" style="color: white;">Online Exam</a></li>
                        <li><a href="load-material" style="color: white;">Material</a></li>
                        <li><a href="load-clients" style="color: white;">ClientEle</a></li>
                        <li><a href="#" style="color: white;">Contact</a></li>
                     </ul>
                  </div>
                  <!--  <center><b><span style="color:white;">Learning for every one and every where</span></b></center> -->
               </div>
            </div>
         </header>
         <!-- end header -->
         <div class="container">
            <div class="col-lg-12">
               <div class="aligncenter">
                  <h2 class="aligncenter">Our Clients</h2>
                  <span class="clear spacer_responsive_hide_mobile " style="height:13px;display:block;"></span>
               </div>
            </div>
         </div>
         <br><br><br><br><br>
         <section class="vc_custom_1439892679087">
            <div class="wpb_column col-md-12">
               <div id="tribe-events-content" class="tribe-events-single">
                  <div class="wpb_column col-md-12">
                     <div class="wpb_wrapper">
                        <div class="wpb_text_column wpb_content_element ">
                           <div class="wpb_wrapper">
                              <div class="container">
                                 <section class="customer-logos slider">
                                    <div class="slide"><img src="${pageContext.request.contextPath}/theme/images/1.jpg" ></div>
                                    <div class="slide"><img src="${pageContext.request.contextPath}/theme/images/2.jpg" ></div>
                                    <div class="slide"><img src="${pageContext.request.contextPath}/theme/images/3.jpg" ></div>
                                    <div class="slide"><img src="${pageContext.request.contextPath}/theme/images/4.jpg"></div>
                                    <div class="slide"><img src="${pageContext.request.contextPath}/theme/images/5.jpg" ></div>
                                    <div class="slide"><img src="${pageContext.request.contextPath}/theme/images/6.jpg"></div>
                                    <div class="slide"><img src="${pageContext.request.contextPath}/theme/images/7v.jpg"></div>
                                 </section>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </section>
         <footer style="vertical-align: bottom;text-align: right;margin-bottom: 0px; bottom: 0px;position:fixed; width: 100%;background-color: #428bca">
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
      <script src="${pageContext.request.contextPath}/theme/js/slick.js"></script>
      <script>
         $('.carousel').carousel()
         
         
         $(document).ready(function(){
             $('.customer-logos').slick({
                 slidesToShow: 6,
                 slidesToScroll: 1,
                 autoplay: true,
                 autoplaySpeed: 1500,
                 arrows: false,
                 dots: false,
                 pauseOnHover: false,
                 responsive: [{
                     breakpoint: 768,
                     settings: {
                         slidesToShow: 4
                     }
                 }, {
                     breakpoint: 520,
                     settings: {
                         slidesToShow: 3
                     }
                 }]
             });
         });
      </script>
   </body>
</html>