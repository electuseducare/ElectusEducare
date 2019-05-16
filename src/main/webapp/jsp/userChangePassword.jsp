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
      <title>Change Password</title>
      <%@include file="DisplayLogo.jsp" %>
      <%@include file="userSessionExpire.jsp" %>
      <%@include file="newtemplateDataTableCss.jsp" %>
      <script>
         var isValid = true;
         $(document).ready(function() {
          $('#popup').click(function(e) {
         $('input[type="text"]').each(function() {
             if ($.trim($(this).val()) == '') {
                 isValid = false;
                 $(this).css({
                     "border": "1px solid red",
                     "background": "#FFCECE"
                 });
                 
                 return false;
             }
             else {
             	isValid = true;
                 $(this).css({
                     "border": "",
                     "background": ""
                     	
                 });
                 return true;
             }
         });
         });
         }); 
         
         function formValidation(){
         
         	if(isValid==false){
         		alert('Text box values should not be empty');
         	return false;
         	}
         }
      </script>
      <%-- <%@include file="userNewTemplateCss.jsp" %> --%>
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
                     Change Password: ${uprofile.name}
                  </div>
                  <!-- /.panel-heading -->
                  <div class="panel-body">
                     <form:form modelAttribute="chnpass" method="post" action="load-changeUserPassword">
                        <div class="panel-body">
                           <div class="row">
                              <div class="col-lg-12">
                                 <center>
                                    <h4 style="color: green;">${smsg}</h4>
                                 </center>
                                 <center>
                                    <h4 style="color: red;">${emsg}</h4>
                                 </center>
                                 <form role="form">
                                    <div class="form-group">
                                       <label>Current Password</label>
                                       <form:input path="password" class="form-control" name="password"  placeholder="Enter Current Password" required="required"/>
                                    </div>
                                    <div class="form-group">
                                       <label>New Password</label>
                                       <form:input path="changePassword" class="form-control" name="newpassword"  placeholder="Enter New Password" required="required"/>
                                    </div>
                                    <div class="form-group">
                                       <label>Confirm Password</label>
                                       <form:input path="reenterpassword" class="form-control"  name="confirmpassword"  placeholder="Enter Confirm Password" required="required" />
                                    </div>
                                    <button name="success" class="btn btn-primary" id="popup" onclick="return formValidation();" >Change Password
                                    </button>
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