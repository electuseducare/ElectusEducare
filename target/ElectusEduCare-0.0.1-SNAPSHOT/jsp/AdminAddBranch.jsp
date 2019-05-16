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
      <style>
         .loader {
         position: fixed;
         left: 0px;
         top: 0px;
         width: 100%;
         height: 100%;
         z-index: 9999;
         background: url('${pageContext.request.contextPath}/theme/images/demo_wait.gif')
         50% 50% no-repeat rgb(249, 249, 249);
         opacity: .8;
         }
      </style>
      <script type="text/javascript">
         $(document).ready(function(){
             $(document).ajaxStart(function(){
               $("#loaderstart").css("display", "block");
             });
             $(document).ajaxComplete(function(){
               $("#loaderstart").css("display", "none");
             });
             
           });
      </script>
      <script type="text/javascript">
         var getLocationsBasedonState = function(stateid){
         
         var stateids = document.getElementById(stateid).value;
         
            $.ajax({
                    url : "load-branchform1?stateid="+stateids,
                    type: "POST",
                    dataType: 'text',
                    success : 
                    function(data) {
                    	
                     	document.getElementById("locationidval").innerHTML=data;
                     
                 }    	
            });
         }
         
         
      </script>
      <script type="text/javascript">
         function fieldvalidation(){
         	var availablestates = document.getElementById('statename').value;
         	if(availablestates=='0'){
         		alert("Please select State from drop-down");
         		return false;
         	}
         	
         	var locationidval = document.getElementById('locationidval').value;
         	if(locationidval=='0'){
         		alert("Please select Location from drop-down");
         		return false;
         	}
         	
         	/** Location name is Empty */
         	var examname = document.getElementById('branch').value;
         	var len =examname.replace(/\s+$/, '');
             if(len==''){
             	alert('Branch should not be empty');
             	return false;
             }
         	
         	}
         	
         window.onload = function () {
         	 document.getElementById("statename").value="0";
         	 document.getElementById("locationidval").innerHTML="	<option value='0'  >---Select One---</option>";
         }
         	
      </script>
   </head>
   <body>
      <%@include file="adminUserTopMenu.jsp" %>
      <%@include file="adminUserHeader.jsp" %>
      <div id="loaderstart" class="loader" style="display: none;"></div>
      <!-- start header -->
      <div class="row"> </div>
      <div style="width:22%; float:left; background-color: #ffffff;"><%@include file="AdminDashboardLeftMenu.jsp" %></div>
      <div style="width:70%; float:left; background-color: #ffffff">
         <ul class="nav nav-tabs">
            <li class="active" ><a href="#" >ADD BRANCH</a></li>
            <li ><a href="load-EditBranchform" >MODIFY BRANCH</a></li>
            <li ><a href="load-Deletebranchform" >DELETE BRANCH</a></li>
         </ul>
         <div class="panel-heading" style="background-color:#ccf2ff;color:black; font-weight: bold;"><a href="load-branchform"><img border="0" alt="W3Schools" src="${pageContext.request.contextPath}/theme/images/addicon.jpg" width="40" height="40" style="background-color: skyblue;"></a></div>
         <div class="panel-body" id="mockTabs" style="background-color:#DFE2DB;">
            <center>
               <h4 style="color:green">${smsg}</h4>
            </center>
            <center>
               <h4 style="color:red">${emsg}</h4>
            </center>
            <c:if test="${smsg==null}" >
               <form:form  name="AddRoleform" method="post" action="process-branchform"  modelAttribute="adminbranch" >
                  <label>State:</label>
                  <form:select path="statename" class="form-control" id="statename"  required="required"  onchange="getLocationsBasedonState(this.id);">
                     <form:option value="0"  >---Select One---</form:option>
                     <c:forEach  items="${state}" var="statename" >
                        <form:option value="${statename.stateid}"  >${statename.statename}</form:option>
                     </c:forEach>
                  </form:select>
                  <label>Location:</label>
                  <form:select path="location"  id="locationidval"  class="form-control"   required="required" >
                     <c:forEach  items="${location}" var="locationanames" >
                        <form:option value="${locationanames.locationid}"  >${locationanames.location}</form:option>
                     </c:forEach>
                  </form:select>
                  <label style="color:black;font-weight: bold;">Branch:</label>
                  <form:input path="branch" name="branch" id="branch" class="form-control" placeholder="Enter Branch" required="required" onKeyPress="return ValidateAlpha(event);" maxlength="60" autocomplete="off"/>
                  <div class="row"></div>
                  <center><button class="btn-primary" style="background-color: #00a3cc;color:white;width:15%;align-text:center;" onclick="return fieldvalidation();">ADD BRANCH</button></center>
               </form:form>
            </c:if>
         </div>
      </div>
      <center>
         <div style="width: 10%;float:right;background-color: #ffffff"> </div>
      </center>
      <script>
         var input = document.getElementById('branch');
         
         input.onkeyup = function(){
             this.value = this.value.toUpperCase();
         }
         
      </script>
      <%@include file="adminfooter.jsp" %>
   </body>
</html>