<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <%@include file="DisplayLogo.jsp" %>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>Electus Educare</title>
   </head>
   <body>
      <div id="examnamemodel" class="modal" style="display: none">
         <!-- Modal content -->
         <div class="modal-content">
            <span id="examnamemodelclose" class="closebtn" onclick="closeexamnamemodelwindow();"><strong >CLOSE</strong></span>
            <p><strong>State name should not be empty</strong></p>
         </div>
      </div>
   </body>
</html>