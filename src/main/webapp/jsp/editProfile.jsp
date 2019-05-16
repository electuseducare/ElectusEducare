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
      <title>Edit Profile</title>
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
                     Profile : ${uprofile.name}
                  </div>
                  <!-- /.panel-heading -->
                  <div class="panel-body">
                     <form:form modelAttribute="updateform" method="GET" action="load-update">
                        <div class="panel-body">
                           <div class="row">
                              <div class="col-lg-12">
                                 <h3 style="color:Green">${msg}</h3>
                                 <form role="form">
                                    <div class="form-group">
                                       <label>Student Id</label>
                                       <input type="text"  class="form-control" name="student_id" value="${uprofile.student_id}" readonly="readonly">
                                    </div>
                                    <div class="form-group">
                                       <label>First Name</label>
                                       <input type="text"  class="form-control" name="firstname" value="${uprofile.name}">
                                    </div>
                                    <div class="form-group">
                                       <label>Last Name</label>
                                       <input type="text"  class="form-control" name="lastname" value="${uprofile.lname}">
                                    </div>
                                    <div class="form-group">
                                       <label>Email Address</label>
                                       <input type="text"   class="form-control" name="email" value="${uprofile.email_id}" readonly="readonly">
                                    </div>
                                    <div class="form-group">
                                       <label>Mobile Number</label>
                                       <input type="text"  class="form-control" name="mobile" value="${uprofile.mobile_Number}" readonly="readonly">
                                    </div>
                                    <input type="submit" class="btn btn-primary" value="Update" >
                                 </form>
                              </div>
                              <!-- /.col-lg-6 (nested) -->
                              <!-- /.col-lg-6 (nested) -->
                           </div>
                           <!-- /.row (nested) -->
                        </div>
                     </form:form>
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