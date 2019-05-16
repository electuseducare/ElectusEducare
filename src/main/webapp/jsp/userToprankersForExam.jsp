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
      <title>User Top Rankers </title>
      <%@include file="DisplayLogo.jsp" %>
      <%@include file="userSessionExpire.jsp" %>
      <%-- <%@include file="userNewTemplateCss.jsp" %> --%>
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
                        Top 100 Rankers
                     </div>
                     <!-- /.panel-heading -->
                     <div class="panel-body">
                        <form:form modelAttribute="ut" method="POST" action="process-viewtoprankers">
                           <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                              <thead>
                                 <tr>
                                    <th>Exam Name</th>
                                    <th>Student Name</th>
                                    <th>Total Marks</th>
                                    <th>Scored Marks</th>
                                    <th>Rank</th>
                                 </tr>
                              </thead>
                              <tbody>
                                 <c:forEach items="${usertoprankerslist}" var="ranklist">
                                    <tr>
                                       <td>${ranklist.examname}</td>
                                       <td>${ranklist.studentname}</td>
                                       <td align="center">${ranklist.examtotalmarks}</td>
                                       <td align="center">${ranklist.examscoredmarks}</td>
                                       <td>${ranklist.rank}</td>
                                    </tr>
                                 </c:forEach>
                              </tbody>
                           </table>
                        </form:form>
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