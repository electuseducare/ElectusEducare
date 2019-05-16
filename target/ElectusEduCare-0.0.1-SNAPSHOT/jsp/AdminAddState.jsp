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
      <link rel="stylesheet" href="${pageContext.request.contextPath}/theme/css/AdminCreateExamStyleSheet.css">
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
         	
         
         	
         /** State name is Empty */
         var examnamemodel = document.getElementById('examnamemodel');
         var examname = document.getElementById('statename').value;
         var len =examname.replace(/\s+$/, '');
         
         if((examname.length==0)||(len=='')||(examname==null)){
         	examnamemodel.style.display = "block";
         	return false;
         }
         
         
         
         }
         /** Close State name modal window */
         function closeexamnamemodelwindow() {
         	 var modal = document.getElementById('examnamemodel');
             modal.style.display = "none";
         }
         
         window.onload = function () {
         	 document.getElementById("availablestates").value="0";
         }
         
         
      </script>
      <%@include file="AdminModuleValidations.jsp" %>
   </head>
   <body>
      <%@include file="adminUserTopMenu.jsp" %>
      <%@include file="adminUserHeader.jsp" %>
      <!-- start header -->
      <div id="examnamemodel" class="modal" style="display: none">
         <!-- Modal content -->
         <div class="modal-content">
            <span id="examnamemodelclose" class="closebtn" onclick="closeexamnamemodelwindow();"><strong >CLOSE</strong></span>
            <p><strong>State name should not be empty</strong></p>
         </div>
      </div>
      <div class="row"> </div>
      <div style="width:22%; float:left; background-color: #ffffff;"><%@include file="AdminDashboardLeftMenu.jsp" %></div>
      <div style="width:70%; float:left; background-color: #ffffff">
         <ul class="nav nav-tabs">
            <li class="active" ><a href="#" >ADD STATE</a></li>
            <li ><a href="load-EditStateform" >MODIFY STATE</a></li>
            <li ><a href="load-Deletestateform" >DELETE STATE</a></li>
         </ul>
         <div class="panel-heading" style="background-color:#ccf2ff;color:black; font-weight: bold;"><a href="load-stateform">
            <img border="0" alt="Add State" src="${pageContext.request.contextPath}/theme/images/addicon.jpg" width="40" height="40" style="background-color: skyblue;"></a>
         </div>
         <div class="panel-body" id="mockTabs" style="background-color:#DFE2DB;">
            <center>
               <h4 style="color:green">${smsg}</h4>
            </center>
            <center>
               <h4 style="color:red">${emsg}</h4>
            </center>
            <c:if test="${smsg==null}" >
               <form:form  name="AddRoleform" method="post" action="process-stateform"  modelAttribute="adminstate" >
                  <label style="color:black;font-weight: bold;">Available States:</label>
                  <form:select path="availablestates" id="availablestates" class="chosen-select" >
                     <form:option value="0"  >--Select One--</form:option>
                     <c:forEach  items="${statenames}" var="branchname" >
                        <form:option value="${branchname.stateid}"  >${branchname.statename}</form:option>
                     </c:forEach>
                  </form:select>
                  <label style="color:black;font-weight: bold;">State:</label>
                  <form:input path="statename" id="statename" class="form-control" placeholder="Enter State" required="required" minlength="2" maxlength="60" autocomplete="off"/>
                  <div class="row"></div>
                  <center>
                     <button class="btn-primary" style="background-color: #00a3cc;color:white;width:15%;align-text:center;" onclick="return fieldvalidation();"> ADD STATE </button>
                  </center>
               </form:form>
            </c:if>
         </div>
      </div>
      <center>
         <div style="width: 10%;float:right;background-color: #ffffff"> </div>
      </center>
      <script>
         var input = document.getElementById('statename');
         
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