<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0;background-color:#428bca;">
   <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse" style="background-color:white;">
      <span class="sr-only">Toggle navigation</span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
      </button>
      <%
         String clientlogo=(String)session.getAttribute("clientlogo1");
          pageContext.setAttribute("clientlogo", clientlogo);
          %>
      <c:set value="${clientlogo}" var="clientlogo"></c:set>
      <a class="navbar-brand" href="load-welcomeUser" style="color:white;"><img src="${pageContext.request.contextPath}/theme//images/Electus-Logo-RGB.jpg" style="height: 35px; width: 150px;" title="Electus Educare"></a>
      <c:choose>
         <c:when test="${clientlogo=='0' || clientlogo==''}">
         </c:when>
         <c:otherwise>
            <div class="navbar-header" style="float: center;">
               <a class="navbar-brand"  href="load-welcomeUser" style="color:white;" >  <img src="${pageContext.request.contextPath}/viewClientimage?imageID=<%=session.getAttribute("clientlogo1")%>" class=""  style="width: 150px;height: 35px;" /></a>
            </div>
         </c:otherwise>
      </c:choose>
   </div>
   <ul class="nav navbar-top-links navbar-right" id="menu-main-menu">
      <!-- /.dropdown -->
      <li class="dropdown">
         <a class="dropdown-toggle" data-toggle="dropdown" href="#" style="color:white;">
         <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
         </a>
         <ul class="dropdown-menu dropdown-user">
            <li><a href="load-userProfile"><i class="fa fa-user fa-fw"></i> User Profile</a>
            </li>
            <li class="divider"></li>
            <li><a href="logout"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
            </li>
         </ul>
         <!-- /.dropdown-user -->
      </li>
      <!-- /.dropdown -->
   </ul>
   <!-- /.navbar-header -->
   <!-- /.navbar-top-links -->
   <div class="navbar-default sidebar" role="navigation">
      <div class="sidebar-nav navbar-collapse">
         <div class="row">&nbsp;</div>
         <ul class="nav" id="side-menu">
               <div class="input-group custom-search-form">
                  <input type="text" id="myInput" class="form-control" placeholder="Search..." onkeyup="myFunction()" >
                  <span class="input-group-btn">
                  <button class="btn btn-default" type="button">
                  <i class="fa fa-search"></i>
                  </button>
                  </span>
               </div>
               <!-- /input-group -->
            <li>
               <a href="load-welcomeUser"  onclick="return startloader();"><i class="fa fa-dashboard fa-fw"></i> DASHBOARD</a>
            </li>
            <li>
               <a href="#"><i class="fa fa-table fa-fw"></i>EXAMS<span class="fa arrow"></span></a>
               <ul class="nav nav-second-level">
                  <li>
                     <a href="load-userExamDashboard">SLOT BASED</a>
                  </li>
                  <li>
                     <a href="load-userExamSlotDashboard">WITHOUT SLOT BASED</a>
                  </li>
               </ul>
               <!-- /.nav-second-level -->
            </li>
            <li>
               <a href="load-userdashboardResults"  onclick="return startloader();" ><i class="fa fa-edit fa-fw"></i> RESULTS</a>
            </li>
            <li>
               <a href="load-DashboardBookmarkquestions"  onclick="return startloader();"><i class="fa fa-edit fa-fw"></i> BOOKMARK QUESTIONS</a>
            </li>
            <li>
               <a href="load-selfPerformaneceAnalysis"  onclick="return startloader();"><i class="fa fa-bar-chart-o fa-fw"></i> SPA</a>
            </li>
            <li>
               <a href="load-examnamesforranks"  onclick="return startloader();"><i class="fa fa-trophy fa-fw"></i> RANKS</a>
            </li>
            <li>
               <a href="load-userProfile"  onclick="return startloader();"><i class="fa fa-user fa-fw"></i> PROFILE</a>
            </li>
            <li>
               <a href="logout"><i class="fa fa-lock fa-fw"></i> LOGOUT</a>
            </li>
         </ul>
      </div>
      <!-- /.sidebar-collapse -->
   </div>
   <!-- /.navbar-static-side -->
</nav>
<script>
/****** Left menu search *******/
function myFunction() {
    var input, filter, ul, li, a, i, txtValue;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();
    ul = document.getElementById("side-menu");
    li = ul.getElementsByTagName("li");
    for (i = 0; i < li.length; i++) {
        a = li[i].getElementsByTagName("a")[0];
        txtValue = a.textContent || a.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            li[i].style.display = "";
        } else {
            li[i].style.display = "none";
        }
    }
}
</script>
