<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>Insert title here</title>
      <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
      <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.6.3/css/bootstrap-select.min.css" />
      <style type="text/css">
         .select,
         .chosen-select,
         .chosen-select-no-single,
         .chosen-select-no-results,
         .chosen-select-deselect,
         .chosen-select-rtl,
         .chosen-select-width {
         width: 350px;
         }
      </style>
   </head>
   <body>
      <%@include file="adminUserTopMenu.jsp" %>
      <%@include file="adminUserHeader.jsp" %> 
      <div class="row"> </div>
      <div style="width:22%; float:left; background-color: #ffffff;"><%@include file="AdminDashboardLeftMenu.jsp" %></div>
      <div style="width:70%; float:left; background-color: #ffffff">
         <div class="panel panel-info">
            <div class="panel-heading">
               <a href="load-uploadorglogo">
                  <center><b>Upload Organization Logo</b></center>
               </a>
            </div>
         </div>
         <div class="row"></div>
         <div style="text-align: center; color: green;font-weight: bold;">${smsg} </div>
         <div style="text-align: center; color: red;font-weight: bold;"> ${emsg} </div>
      </div>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
      <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.6.3/js/bootstrap-select.min.js"></script>
   </body>
</html>