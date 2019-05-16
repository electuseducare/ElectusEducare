<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <%@include file="DisplayLogo.jsp" %>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>Electus Educare</title>
      <style>
         tfoot input {
         width: 100%;
         padding: 3px;
         box-sizing: border-box;
         }
      </style>
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
      <link rel="stylesheet" href="https://cdn.datatables.net/1.10.15/css/dataTables.bootstrap.min.css">
      <link rel="stylesheet" href="https://cdn.datatables.net/responsive/2.1.1/css/responsive.bootstrap.min.css">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
      <script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
      <script src="https://cdn.datatables.net/1.10.15/js/dataTables.bootstrap.min.js"></script>
      <script src="https://cdn.datatables.net/responsive/2.1.1/js/dataTables.responsive.min.js"></script>
      <script src="https://cdn.datatables.net/responsive/2.1.1/js/responsive.bootstrap.min.js"></script>
      <style type="text/css">
         .loader {
         position: fixed;
         left: 0px;
         top: 0px;
         width: 100%;
         height: 100%;
         z-index: 9999;
         background: url('https://loading.io/assets/img/landing/curved-bars.svg')
         50% 50% no-repeat rgb(249, 249, 249);
         opacity: .8;
         }
      </style>
      <script type="text/javascript">
         window.onload = function () {
         	 $(".loader").fadeOut("slow");
         }
      </script>
   </head>
   <body>
      <%@include file="adminUserTopMenu.jsp" %>
      <%@include file="adminUserHeader.jsp" %>
      <div class="loader"></div>
      <div class="row"> </div>
      <div style="width:22%; float:left; background-color: #ffffff;"><%@include file="AdminDashboardLeftMenu.jsp" %></div>
      <div style="width:70%; float:left; background-color: #ffffff">
         <table id="example" class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
            <thead>
               <tr>
                  <th>File Name</th>
                  <th>E.Type</th>
                  <th>Class</th>
                  <th>Subject</th>
                  <th>Topic</th>
                  <th>Sub Topic</th>
                  <th>Q.Type</th>
                  <th>Q.Level</th>
                  <th>Question</th>
               </tr>
            </thead>
            <tfoot>
               <tr>
                  <th>File Name</th>
                  <th>E.Type</th>
                  <th>Class</th>
                  <th>Subject</th>
                  <th>Topic</th>
                  <th>Sub Topic</th>
                  <th>Q.Type</th>
                  <th>Q.Level</th>
                  <th>Question</th>
               </tr>
            </tfoot>
            <tbody>
               <c:forEach items="${filterques}" var="filter">
                  <tr>
                     <td>${filter.filename}</td>
                     <td>${filter.examtype}</td>
                     <td>${filter.classtype}</td>
                     <td>${filter.subjectype}</td>
                     <td>${filter.subjecttopic}</td>
                     <td>${filter.subjectsubtopic}</td>
                     <td>${filter.questiontype}</td>
                     <td>${filter.questnlevel}</td>
                     <td>${filter.question}</td>
                  </tr>
               </c:forEach>
            </tbody>
         </table>
      </div>
      <script>
         $(document).ready(function() {
             // Setup - add a text input to each footer cell
             $('#example tfoot th').each( function () {
                 var title = $(this).text();
                 
                 $(this).html( '<input type="text" placeholder="Search '+title+'"/>' );
             } );
         
         
             // DataTable
             var table = $('#example').DataTable();
          
             // Apply the search
             table.columns().every( function () {
                 var that = this;
          
                 $( 'input', this.footer() ).on( 'keyup change', function () {
                     if ( that.search() !== this.value ) {
                         that
                             .search( this.value )
                             .draw();
                         
                     }
                 } );
             } );
         } );
         
         $(document).ready(function() {
             oTable = $('#example').dataTable();
             var url_string = window.location.href
         	var url = new URL(url_string);
         	
         	var c = url.searchParams.get("filename");
         	if(c!=null){
         		 /* Filter immediately */
         	    oTable.fnFilter(c);
         		}else{
         			 /* Filter immediately */
         		    oTable.fnFilter("");
         			}
            
         } );
         
      </script>
      <%@include file="adminfooter.jsp" %>
   </body>
</html>