<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <%@include file="DisplayLogo.jsp" %>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>StudentRecords</title>
   </head>
   <body>
      <%@include file="adminUserTopMenu.jsp" %>
      <%@include file="adminUserHeader.jsp" %> 
      <%@include file="adminDataTableForReports.jsp" %>
      <div class="container">
         <table id="example" class="table table-bordered table-striped nowrap" cellspacing="0" width="100%" style="text-align: center;">
            Export:
            <thead>
               <tr>
                  <th>First Name</th>
                  <th>Last Name</th>
                  <th>User name</th>
                  <th>Email Id</th>
                  <th>Password</th>
                  <th>Phone No</th>
                  <th>Class Id</th>
                  <th>Section Id</th>
                  <th>Branch Id</th>
                  <th>State Id</th>
                  <th>Location Id</th>
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