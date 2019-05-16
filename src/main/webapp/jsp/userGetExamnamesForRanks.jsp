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
      <title>User ExamNames For Ranks</title>
      <%@include file="DisplayLogo.jsp" %>
      <%@include file="userSessionExpire.jsp" %>
      <%-- <%@include file="userNewTemplateCss.jsp" %> --%>
      <%@include file="newtemplateDataTableCss.jsp" %>
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
         function startloader() {
         
         	 document.getElementById("loaderstart").style.display='block';
         }
         	
      </script>
   </head>
   <body>
      <!-- start header -->
      <div id="loaderstart" class="loader" style="display: none;"></div>
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
                        Exam Names
                     </div>
                     <!-- /.panel-heading -->
                     <div class="panel-body">
                        <form:form modelAttribute="ut" method="POST" action="process-viewtoprankers">
                           <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                              <thead>
                                 <tr>
                                    <th>Exam Name</th>
                                    <th> Exam Type</th>
                                    <th>View Ranks</th>
                                 </tr>
                              </thead>
                              <tbody>
                                 <c:forEach items="${exmalistforranks}" var="exmalistforranks">
                                    <tr>
                                       <td>${exmalistforranks.examname}</td>
                                       <td>${exmalistforranks.examtype}</td>
                                       <td> <button class="btn btn-primary" name="examnamebtn" value="${exmalistforranks.examname}" onclick="return startloader();">View Top Rankers</button> </td>
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