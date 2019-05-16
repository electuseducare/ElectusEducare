<%@include file="DisplayLogo.jsp" %>
<header>
   <div class="navbar navbar-default navbar-static-top">
      <div class="container">
         <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            </button>
            <div class="navbar-header" >
               <a  href="load-welcomeUser"><img src="${pageContext.request.contextPath}/theme/images/Electus-Logo-RGB.jpg" height="60" width="230" alt="logo"/></a>
            </div>
         </div>
         <div class="navbar-collapse collapse ">
            <ul class="nav navbar-nav">
               <li><a href="load-welcomeUser" >DASHBOARD</a></li>
               <li ><a href="load-userExamDashboard">Start Test</a></li>
               <li ><a href="load-userdashboardResults">Results</a></li>
               <li ><a href="load-DashboardBookmarkquestions">Bookmarks Questions</a></li>
               <li><a href="load-userProfile" >PROFILE</a></li>
               <li><a href="logout">LOGOUT</a></li>
               <!--  <li><a href="load-registerexam">ExamRegistration</a></li> -->
            </ul>
         </div>
      </div>
   </div>
</header>