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
         function fieldvalidation(){
         	
         	var availablestates = document.getElementById('availablestates').value;
         	if(availablestates=='0'){
         		alert("Please select State from drop-down");
         		return false;
         	}
         	
         	/** Location name is Empty */
         	var examname = document.getElementById('location').value;
         	var len =examname.replace(/\s+$/, '');
             if(len==''){
             	alert('Location should not be empty');
             	return false;
             }
         	
         	}
         	
         /** Allow Alphabets with spaces **/
         $(document).ready(function(){
         $("#location").keypress(function (e){
            var code =e.keyCode || e.which;
               if((code<65 || code>90)
               &&(code<97 || code>122)&&code!=32&&code!=46)  
              {
              // alert("Only alphabates are allowed");
               return false;
              }
            });
         });
         
         window.onload = function () {
         	 document.getElementById("availablestates").value="0";
         }
         
         var getLocationsBasedonStatesAAL = function(stateid){
         
         	var stateids = document.getElementById(stateid).value;
         
             $.ajax({
                     url : "load-branchform11?stateid="+stateids,
                     type: "POST",
                     dataType: 'text',
                     success : 
                     function(data) {
                     	
                      	document.getElementById("locationidval").innerHTML=data;
                      
                  }    	
             });
         }
         
      </script>
   </head>
   <body>
      <%@include file="adminUserTopMenu.jsp" %>
      <%@include file="adminUserHeader.jsp" %>
      <!-- start header -->
      <div id="loaderstart" class="loader" style="display: none;"></div>
      <div class="row"> </div>
      <div style="width:22%; float:left; background-color: #ffffff;"><%@include file="AdminDashboardLeftMenu.jsp" %></div>
      <div style="width:70%; float:left; background-color: #ffffff">
         <ul class="nav nav-tabs">
            <li class="active" ><a href="#" >ADD LOCATION</a></li>
            <li ><a href="load-EditLocationform" >MODIFY LOCATION</a></li>
            <li ><a href="load-DeleteLocationform" >DELETE LOCATION</a></li>
         </ul>
         <div class="panel-heading" style="background-color:#ccf2ff;color:black; font-weight: bold;"><a href="load-Locationform"><img border="0" alt="W3Schools" src="${pageContext.request.contextPath}/theme/images/addicon.jpg" width="40" height="40" style="background-color: skyblue;"></a></div>
         <div class="panel-body" id="mockTabs" style="background-color:#DFE2DB;">
            <center>
               <h4 style="color:green">${smsg}</h4>
            </center>
            <center>
               <h4 style="color:red">${emsg}</h4>
            </center>
            <c:if test="${smsg==null}" >
               <form:form  name="AddRoleform" method="post" action="process-Locationform"  modelAttribute="adminbranch" >
                  <label style="color:black;font-weight: bold;">State:</label>
                  <form:select path="statename" id="availablestates" class="chosen-select"  required="required" onchange="getLocationsBasedonStatesAAL(this.id);">
                     <form:option value="0"  >--Select One--</form:option>
                     <c:forEach  items="${statenames}" var="branchname" >
                        <form:option value="${branchname.stateid}"  >${branchname.statename}</form:option>
                     </c:forEach>
                  </form:select>
                  <label style="color:black;font-weight: bold;">Available Locations</label>
                  <form:select path="hiddenlocationname"  id="locationidval"  class="form-control"   >
                     <c:forEach  items="${location}" var="locationanames" >
                        <form:option value="${locationanames.locationid}"  >${locationanames.location}</form:option>
                     </c:forEach>
                  </form:select>
                  <label style="color:black;font-weight: bold;">Add New Location:</label>
                  <form:input path="location" name="branch" id="location" class="form-control" placeholder="Enter Location" required="required" onKeyPress="return ValidateAlpha(event);" maxlength="60" autocomplete="off"/>
                  <div class="row"></div>
                  <center><button class="btn-primary" style="background-color: #00a3cc;color:white;width:15%;align-text:center;" onclick="return fieldvalidation();">ADD LOCATION</button></center>
               </form:form>
            </c:if>
         </div>
      </div>
      <center>
         <div style="width: 10%;float:right;background-color: #ffffff"> </div>
      </center>
      <script>
         var input = document.getElementById('location');
         
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