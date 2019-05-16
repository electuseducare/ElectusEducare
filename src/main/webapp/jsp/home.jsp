<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%-- <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %> --%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en" class="body-full-height">
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
      <link rel="stylesheet" href="${pageContext.request.contextPath}/theme/css/downloadcss/maxcdnbootstratpmin.css">
      <link rel="stylesheet" href="${pageContext.request.contextPath}/theme/css/chosen.css">
      <link rel="stylesheet" href="${pageContext.request.contextPath}/theme/css/logincss.css" id="bootstrap-css">
      <!------ Include the above in your HEAD tag ---------->
      <style type="text/css">
         .select,
         .chosen-select,
         .chosen-select-no-single,
         .chosen-select-no-results,
         .chosen-select-deselect,
         .chosen-select-rtl,
         .chosen-select-width {
         width: 280px;;
         }
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
         .login-block{
         background: #428bca; /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
         float:left;
         width:100%;
         padding : 150px 0;
         }
         .banner-sec{background:url(https://static.pexels.com/photos/33972/pexels-photo.jpg)  no-repeat left bottom; background-size:cover; min-height:500px; border-radius: 0 10px 10px 0; padding:0;}
         .container{background:#fff; border-radius: 10px; box-shadow:15px 20px 0px rgba(0,0,0,0.1);}
         .carousel-inner{border-radius:0 10px 10px 0;}
         .carousel-caption{text-align:left; left:5%;}
         .login-sec{padding: 50px 30px; position:relative;}
         .login-sec .copy-text{position:absolute; width:80%; bottom:20px; font-size:13px; text-align:center;}
         .login-sec .copy-text i{color:#FEB58A;}
         .login-sec .copy-text a{color:#E36262;}
         .login-sec h2{margin-bottom:30px; font-weight:800; font-size:30px; color: #DE6262;}
         .login-sec h2:after{content:" "; width:100px; height:5px; background:#FEB58A; display:block; margin-top:20px; border-radius:3px; margin-left:auto;margin-right:auto}
         .btn-login{background: #DE6262; color:#fff; font-weight:600;}
         .banner-text{width:70%; position:absolute; bottom:40px; padding-left:20px;}
         .banner-text h2{color:#fff; font-weight:600;}
         .banner-text h2:after{content:" "; width:100px; height:5px; background:#FFF; display:block; margin-top:20px; border-radius:3px;}
         .banner-text p{color:#fff;}
         button {
         padding: 12px 24px;
         background: #428bca;
         font-weight: bold;
         font-size:28px;
         border-radius: 5px;
         cursor: pointer;
         text-align: center;
         }
      </style>
      <script type="text/javascript">
      
         function validateschool() {
         	 var school=document.getElementById("school").value;
         	 if(school=='0'){
         			alert("Please select one school");
         			return false;
         			}
         	
         }
      </script>
      <script type = "text/javascript" >
         function preventBack(){window.history.forward();}
         
          setTimeout("preventBack()", 0);
         
          window.onunload=function(){null};
         
      </script>
      <script type="text/javascript">
         var windowObjectReference;
         var params  = 'width='+screen.width;
         params += ', height='+screen.height;
         params += ', top=0, left=0'
         params += ', fullscreen=yes';
         
         var strWindowFeatures = "menubar=no,toolbar=no, location=no,resizable=yes,scrollbars=yes,status=no, top=0, bottom=0, left=0, right=0";
         
         function myFunction() {
          var username = document.getElementById("username").value;
          var password = document.getElementById("password").value;
          var uri = "load-loginform?username="+username+"&password="+password;
           windowObjectReference = window.open(uri, "", params);
           windowObjectReference.opener.close();
           windowObjectReference.opener.document.write("");
           windowObjectReference.opener.location.href='http://www.google.com'
         }
      </script> 
   </head>
   <body >
      <header>
         <div class="container">
            <div class="navbar-header" >
               <a  href="http://electus.co.in"><img src="${pageContext.request.contextPath}/theme/images/Electus-Logo-RGB.jpg" height="70" width="230" alt="logo"/></a>
            </div>
         </div>
      </header>
      <!-- end header -->
      <section class="login-block">
         <div class="container">
            <div class="row">
               <div class="col-md-4 login-sec">
                  <h2 class="text-center">Login to Electus</h2>
                  <form action="selectSchool" >
                     <div class="form-group">
                        <label class="col-md-12  control-label text-left" style="font-size:16px">School</label>
                        <div class="col-md-12">
                           <spring:eval expression="@environment.getProperty('school1.id')" var="schoolid" />
                           <spring:eval expression="@environment.getProperty('school1.name')" var="schoolname" />
                           
                           <spring:eval expression="@environment.getProperty('school2.id')" var="schoolid2" />
                           <spring:eval expression="@environment.getProperty('school2.name')" var="schoolname2" />
                           
                           <spring:eval expression="@environment.getProperty('school3.id')" var="schoolid3" />
                           <spring:eval expression="@environment.getProperty('school3.name')" var="schoolname3" />
                           
                           <spring:eval expression="@environment.getProperty('school4.id')" var="schoolid4" />
                           <spring:eval expression="@environment.getProperty('school4.name')" var="schoolname4" />
                           
                           <spring:eval expression="@environment.getProperty('school5.id')" var="schoolid5" />
                           <spring:eval expression="@environment.getProperty('school5.name')" var="schoolname5" />
                           
                           <spring:eval expression="@environment.getProperty('school6.id')" var="schoolid6" />
                           <spring:eval expression="@environment.getProperty('school6.name')" var="schoolname6" />
                           
                           <spring:eval expression="@environment.getProperty('school7.id')" var="schoolid7" />
                           <spring:eval expression="@environment.getProperty('school7.name')" var="schoolname7" />
                           
                           <spring:eval expression="@environment.getProperty('school8.id')" var="schoolid8" />
                           <spring:eval expression="@environment.getProperty('school8.name')" var="schoolname8" />
                           
                           <spring:eval expression="@environment.getProperty('school9.id')" var="schoolid9" />
                           <spring:eval expression="@environment.getProperty('school9.name')" var="schoolname9" />
                           
                           <spring:eval expression="@environment.getProperty('school10.id')" var="schoolid10" />
                           <spring:eval expression="@environment.getProperty('school10.name')" var="schoolname10" />
                           <select id="school" name="selectschool"  class="chosen-select">
                              <option value="0">-- Choose One --</option>
                              <option value="${schoolid}">${schoolname}</option>
                              <option value="${schoolid2}">${schoolname2}</option>
                              <option value="${schoolid3}">${schoolname3}</option>
                              <option value="${schoolid4}">${schoolname4}</option>
                              <option value="${schoolid5}">${schoolname5}</option>
                              <option value="${schoolid6}">${schoolname6}</option>
                              <option value="${schoolid7}">${schoolname7}</option>
                              <option value="${schoolid8}">${schoolname8}</option>
                              <option value="${schoolid9}">${schoolname9}</option>
                              <option value="${schoolid10}">${schoolname10}</option>
                           </select>
                        </div>
                     </div>
                     <div class="form-group">
                        <label for="exampleInputPassword1" class="text-uppercase"></label>
                        <input type="password" class="form-control" placeholder="" style="display: none">
                     </div>
                     <div style="text-align: center;">
                        <button type="submit" class="btn btn-primary"  onclick="return validateschool()">Submit</button>
                     </div>
                  </form>
                  <div class="copy-text">Developed <i class="fa fa-heart"></i> by <a href="https://chiselontechnologies.com/" target="_blank">Chiselon Technologies Pvt Ltd.</a></div>
               </div>
               <div class="col-md-8 banner-sec">
                  <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                     <div class="carousel-inner" role="listbox">
                        <div class="carousel-item active">
                           <img class="d-block img-fluid" src="https://static.pexels.com/photos/33972/pexels-photo.jpg" alt="First slide">
                           <div class="carousel-caption d-none d-md-block">
                              <div class="banner-text">
                                 <h2>Electus Educare Private Limited</h2>
                                 <p></p>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </section>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.js" type="text/javascript"></script>
      <script src="${pageContext.request.contextPath}/theme/js/chosenjquery.js"></script>
      <script src="${pageContext.request.contextPath}/theme/js/init.js"></script>
   </body>
</html>