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
      <%@include file="AdminModuleValidations.jsp" %>
      <script type="text/javascript">
         function selectadminroles(role) {
         		if(role==1){
         			var studentrol=role;
         			
         			 document.getElementById("studemntdata").value=studentrol;
         		   document.getElementById('studentrole').style.display = "block";
         		}
         		else{
         			 document.getElementById('studentrole').style.display = "false";
         		}
         	
         	
         	
         	if(role==2){
         		var adminrole=role;
         	
         		document.getElementById("admindata").value=adminrole;
         	   document.getElementById('admin').style.display = "block";
         	}
         	else{
         		 document.getElementById('admin').style.display = "false";
         	}
         	
         	
         	if(role==3){
         		var lecturerrole=role;
         		
         		document.getElementById("lecturerdata").value=lecturerrole;
         		   document.getElementById('lecturer').style.display = "block";
         		}
         		else{
         			 document.getElementById('lecturer').style.display = "false";
         		}
         	
         	
         	   
         	}
      </script>
      <script type="text/javascript">
         function fieldvalidation(){
         	/** Location name is Empty */
         	var examname = document.getElementById('examtype').value;
         	var len =examname.replace(/\s+$/, '');
             if(len==''){
             	alert('Exam type should not be empty');
             	return false;
             }
         	
         	}
         	
         $.fn.regexMask = function(mask) {
             $(this).keypress(function (event) {
                 if (!event.charCode) return true;
                 var part1 = this.value.substring(0, this.selectionStart);
                 var part2 = this.value.substring(this.selectionEnd, this.value.length);
                 if (!mask.test(part1 + String.fromCharCode(event.charCode) + part2))
                     return false;
             });
         };
         
         $(document).ready(function() {
             var mask = new RegExp('^[A-Za-z0-9 ]*$')
             $("input").regexMask(mask) 
         });
         	
      </script>
   </head>
   <body>
      <%@include file="adminUserTopMenu.jsp" %>
      <%@include file="adminUserHeader.jsp" %>
      <!-- start header -->
      <div class="row"> </div>
      <div style="width:22%; float:left; background-color: #ffffff;"><%@include file="AdminDashboardLeftMenu.jsp" %></div>
      <div style="width:70%; float:left; background-color: #ffffff">
         <ul class="nav nav-tabs">
            <li class="active" ><a href="#" >ADD EXAMTYPE</a></li>
            <li ><a href="load-EditExamtypeform" >MODIFY EXAMTYPE</a></li>
            <li ><a href="load-DeleteExamtypeform" >DELETE EXAMTYPE</a></li>
         </ul>
         <div class="panel-heading" style="background-color:#ccf2ff;color:black; font-weight: bold;">
            <a href="load-addexamtype">
            <img border="0" alt="W3Schools" src="${pageContext.request.contextPath}/theme/images/addicon.jpg" width="40" height="40" style="background-color:#ccf2ff">
            </a>
         </div>
         <div class="panel-body" id="mockTabs" style="background-color:#DFE2DB;">
            <center>
               <h4 style="color:green">${smsg}</h4>
            </center>
            <center>
               <h4 style="color:red">${emsg}</h4>
            </center>
            <c:if test="${smsg==null}" >
               <form:form  name="AddRoleform" method="post" action="process-examtypeform"  modelAttribute="admincategory" >
                  <label style="color:black;font-weight: bold;">Examtype</label>
                  <form:input path="examtype" name="examtype" id="examtype" class="form-control" placeholder="Enter Examtype" required="required"  maxlength="60" autocomplete="off"/>
                  <div class="row"></div>
                  <center><button class="btn-primary" style="background-color: #00a3cc;color:white;width:15%;align-text:center;" onclick="return fieldvalidation();">ADD EXAMTYPE</button></center>
               </form:form>
            </c:if>
         </div>
      </div>
      <center>
         <div style="width: 10%;float:right;background-color: #ffffff"> </div>
      </center>
      <%@include file="adminfooter.jsp" %>
   </body>
</html>