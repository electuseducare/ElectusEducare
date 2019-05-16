<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <%@include file="DisplayLogo.jsp" %>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Session Timeout</title>
<style type="text/css">

#notfound .notfound {
  position: absolute;
  left: 50%;
  top: 50%;
  -webkit-transform: translate(-50%, -50%);
      -ms-transform: translate(-50%, -50%);
          transform: translate(-50%, -50%);
}

.notfound {
  max-width: 520px;
  width: 100%;
  text-align: center;
  line-height: 1.4;
}

.notfound h2 {
  font-family: 'Montserrat', sans-serif;
  font-size: 22px;
  font-weight: 700;
  margin: 0;
  text-transform: uppercase;
  color: #232323;
}

.notfound p {
  font-family: 'Montserrat', sans-serif;
  color: #787878;
  font-weight: 300;
}

.notfound a {
  font-family: 'Montserrat', sans-serif;
  display: inline-block;
  padding: 12px 30px;
  font-weight: 700;
  background-color: #f99827;
  color: #fff;
  border-radius: 40px;
  text-decoration: none;
  -webkit-transition: 0.2s all;
  transition: 0.2s all;
}



</style>


</head>
<body>
	<div id="notfound">
		<div class="notfound">
			<div class="notfound-404">
			 <img border="0" alt="W3Schools" src="${pageContext.request.contextPath}/theme/images/emoji.png" style="height: 180px;width: 250px">
				
			</div>
			<h2>Oops! Session Timeout</h2>
			<p>Sorry but the page you are looking for does not exist due to session timeout.</p>
			<a href="load-selectschool">Back to Home Page</a>
		</div>
	</div>
</body>
</html>