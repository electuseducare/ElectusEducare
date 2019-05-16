<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
    <title>UploadKeys</title>
      <%@include file="DisplayLogo.jsp" %>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
                  <th>Question No</th>
                  <th>Key</th>
                  <th>Subject code</th>
                  <th>Question Type code</th>
                  <th>Positive marks per question type</th>
                  <th>Negative marks per question type</th>
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