<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html>
<html>
<head> <%@include file="DisplayLogo.jsp" %>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>File upload success</title>
</head>
<body>
	<%@include file="adminUserTopMenu.jsp" %>
<%@include file="adminUserHeader.jsp" %>
 <div class="row"></div>
<div style="width:22%; float:left; background-color: #ffffff;"><%@include file="AdminDashboardLeftMenu.jsp" %></div>
  <div class="content-wrapper">

 		  <div class="panel-heading" style="background-color:#ccf2ff;color:black; font-weight: bold;"><a href="load-uploaddata"><img border="0" alt="W3Schools" src="${pageContext.request.contextPath}/theme/images/addicon.jpg" width="40" height="40" style="background-color: skyblue;"></a>
 		  Upload Student Records</div>
		 <div style="text-align: center;"><label style="color:green">${msg}</label> </div>
         <div style="text-align: center;">  <label style="color:red">${emsg}</label> </div>
         </div>
         <%@include file="adminfooter.jsp" %>
</body>
</html>