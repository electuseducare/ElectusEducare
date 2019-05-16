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
      <%@include file="adminDataTable.jsp" %>
      <link rel="stylesheet" href="${pageContext.request.contextPath}/theme/css/chosen.css">
      <link rel="stylesheet" href="${pageContext.request.contextPath}/theme/css/prism.css">
      <style type="text/css">
         .select,
         .chosen-select,
         .chosen-select-no-single,
         .chosen-select-no-results,
         .chosen-select-deselect,
         .chosen-select-rtl,
         .chosen-select-width {
         width: 100%;
         }
      </style>
      <script type="text/javascript">
         function fieldvalidation(){
         	
         	var classname = document.getElementById('classname').value;
         	if(classname=='0'){
         		alert("Please select Class from drop-down");
         		return false;
         	}
         	
         	/** Location name is Empty */
         	var examname = document.getElementById('subject').value;
         	var len =examname.replace(/\s+$/, '');
             if(len==''){
             	alert('Subject should not be empty');
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
         
         window.onload = function () {
         	 document.getElementById("classname").value="0";
         }
         
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
            <li class="active" ><a href="#" >ADD SUBJECT</a></li>
            <li ><a href="load-EditSubjectform" >MODIFY SUBJECT</a></li>
            <li ><a href="load-DeleteSubjectform" >DELETE SUBJECT</a></li>
         </ul>
         <div class="panel-heading" style="background-color:#ccf2ff;color:black; font-weight: bold;">
            <a href="load-Subjectform">
            <img border="0" alt="W3Schools" src="${pageContext.request.contextPath}/theme/images/addicon.jpg" width="40" height="40" style="background-color: skyblue;">
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
               <form:form  name="AddRoleform" method="post" action="process-Subjectform"  modelAttribute="adminbranch" >
                  <label>Class:</label>
                  <form:select path="classname" id="classname" class="chosen-select"  required="required" >
                     <form:option value="0"  >--Select One--</form:option>
                     <c:forEach  items="${classnames}" var="classname" >
                        <form:option value="${classname.categoryid}"  >${classname.category}</form:option>
                     </c:forEach>
                  </form:select>
                  <label style="color:black;font-weight: bold;">Subject:</label>
                  <form:input path="subject" name="subject" id="subject" class="form-control" placeholder="Enter Subject Name" required="required"  maxlength="60" autocomplete="off"/>
                  <div class="row"></div>
                  <center><button class="btn-primary" style="background-color: #00a3cc;color:white;width:15%;align-text:center;" onclick="return fieldvalidation();">ADD SUBJECT</button></center>
               </form:form>
            </c:if>
         </div>
      </div>
      <center>
         <div style="width: 10%;float:right;background-color: #ffffff"> </div>
      </center>
      <script>
         var input = document.getElementById('subject');
         
         input.onkeyup = function(){
             this.value = this.value.toUpperCase();
         }
         
      </script>
      <%@include file="adminfooter.jsp" %>
      <script src="${pageContext.request.contextPath}/theme/js/chosenjquery.js"></script>
      <script src="${pageContext.request.contextPath}/theme/js/prism.js"></script>
      <script src="${pageContext.request.contextPath}/theme/js/init.js"></script>
   </body>
</html>