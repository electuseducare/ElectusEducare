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
      <title>User Results</title>
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
                        My Exam Results
                     </div>
                     <!-- /.panel-heading -->
                     <div class="panel-body">
                        <form:form modelAttribute="userviewResults" method="POST" action="load-filterform">
                           <center>
                              <h4 style="color:green">
                                 <c:if test="${smsg<0}">${smsg}</c:if>
                              </h4>
                           </center>
                           <center>
                              <h4 style="color:red">
                                 <c:if test="${smsg<=0}">${emsg}</c:if>
                              </h4>
                           </center>
                           <c:if test="${smsg>0}">
                              <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                 <thead>
                                    <tr>
                                       <th>Exam Name</th>
                                       <th> Total Questions</th>
                                       <th>Total Marks</th>
                                       <th> Achieved Marks </th>
                                       <th> Right Answers </th>
                                       <th> Detailed Results </th>
                                    </tr>
                                 </thead>
                                 <tbody>
                                    <c:forEach items="${userresults}" var="userresults">
                                       <tr>
                                          <td>${userresults.examName}</td>
                                          <td>${userresults.totalQuestions}</td>
                                          <td>${userresults.totalmarks}</td>
                                          <td>${userresults.examscoredmarks}</td>
                                          <td>${userresults.correctanswer1}</td>
                                          <td> <button class="btn btn-primary" name="actionform" value="Summary,${userresults.examName}" onclick="return startloader();">View Detailed Results</button> </td>
                                       </tr>
                                    </c:forEach>
                                 </tbody>
                              </table>
                           </c:if>
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