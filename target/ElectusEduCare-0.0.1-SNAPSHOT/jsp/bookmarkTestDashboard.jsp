<%@page import="java.math.BigInteger"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta name="description" content="">
      <meta name="author" content="">
      <title>Book Mark</title>
      <%@include file="DisplayLogo.jsp" %>
      <%@include file="userSessionExpire.jsp" %>
      <%@include file="newtemplateDataTableCss.jsp" %>
   </head>
   <body>
      <div id="wrapper">
         <!-- Navigation -->
         <%@include file="usernewleftmenu.jsp" %>
         <div id="page-wrapper">
            <div class="row">
               <div class="col-lg-12">
                  <div class="row">&nbsp;</div>
               </div>
               <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
               <div class="col-lg-12">
                  <div class="panel panel-default">
                     <div class="panel-heading">
                        BookMarked Questions
                     </div>
                     <!-- /.panel-heading -->
                     <div class="panel-body">
                        <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                           <thead>
                              <tr>
                                 <th>EXAM </th>
                                 <th> SUBJECT</th>
                                 <th>QUESTIONS</th>
                              </tr>
                           </thead>
                           <tbody>
                              <c:forEach items="${bques}" var="bookques" varStatus="loop">
                                 <tr>
                                    <td> ${bookques.examName}</td>
                                    <td> ${bookques.subject}</td>
                                    <td> ${bookques.question}</td>
                                 </tr>
                              </c:forEach>
                           </tbody>
                        </table>
                     </div>
                     <!-- /.table-responsive -->
                  </div>
                  <!-- /.panel-body -->
               </div>
               <!-- /.panel -->
            </div>
            <!-- /.col-lg-12 -->
         </div>
         <!-- /.col-lg-6 -->
      </div>
      <!-- /#wrapper -->
      <%@ include file="newtemplateDataTableJs.jsp" %>
      <script>
         $(document).ready(function() {
             $('#dataTables-example').DataTable({
                 responsive: true
             });
         });
      </script>
   </body>
</html>