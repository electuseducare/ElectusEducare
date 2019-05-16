<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <%@include file="DisplayLogo.jsp" %>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>UploadKeys</title>
   </head>
   <body>
      <%@include file="adminUserTopMenu.jsp" %>
      <%@include file="adminUserHeader.jsp" %> 
      <%@include file="adminDataTableForReports.jsp" %>
      <div class="container">
         <table id="example" >
            Export:
            <thead>

<tr>
<th>Question ID</th>
<c:forEach var = "i" begin = "1" end = "180">
        <th>${i}</th>
      </c:forEach>

</tr>

               
</thead>
<thead>

<tr><th>Keys</th>
<c:forEach var = "i" begin = "1" end = "180">
        <th>0</th>
      </c:forEach>

</tr>
</thead>
         </table>
      </div>
      <script>
         $(document).ready(function() {
             $('#example').DataTable( {
                 dom: 'Bfrtip',
                 buttons: [
                      'excel'
                 ]
             } );
         } );
      </script>
   </body>
</html>