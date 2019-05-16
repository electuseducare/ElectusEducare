<!DOCTYPE html>
<html>
   <head> <%@include file="DisplayLogo.jsp" %></head>
   <body>
      <div id="dialog" style="display:none;" title="Dialog Title">Your session is going to expire in 3 min</div>
      <%@include file="adminUserTopMenu.jsp" %>
      <%@include file="adminUserHeader.jsp" %>
      <!-- start header -->
      <div id="inner-headline" style="background-color: #ffffff">
         <div class="container">
            <div class="col-lg-12">
            </div>
         </div>
      </div>
      <div class="row"> </div>
      <div style="width:10%; float:left; background-color: #ffffff;">&nbsp;<%-- <%@include file="AdminDashboardLeftMenu.jsp" %> --%></div>
      <div style="width: 75%; float: left;margin-left: 50px;">
         <object data="${pageContext.request.contextPath}/theme/Intranetdocument.pdf" 
            type="application/pdf" width="100%" height="900px">
         </object>
      </div>
   </body>
</html>