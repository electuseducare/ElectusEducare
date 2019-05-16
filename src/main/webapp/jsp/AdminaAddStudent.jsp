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
      <script src="${pageContext.request.contextPath}/theme/js/downloadjs/ajax1111.js"></script>
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
         var getLocationsBasedonState1 = function(stateid){
         
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
         
         
         var getBranchesBasedonLocation = function(locationid){
         
         	var locationids = document.getElementById(locationid).value;
         
             $.ajax({
                     url : "load-BranchesBasedonLocation11?locationid="+locationids,
                     type: "POST",
                     dataType: 'text',
                     success : 
                     function(data) {
                      	document.getElementById("branchidval").innerHTML=data;
                      
                  }    	
             });
         }
         
         
         var getsectionsFromClass1 = function(classid){
         
          var classid = document.getElementById(classid).value;
         
             $.ajax({
                     url : "get-sectiondetailsfromClass11?classid="+classid,
                     type: "POST",
                     dataType: 'text',
                     success : 
                     function(data) {
                      	document.getElementById("sectionidval").innerHTML=data;
                      
                  }    	
             });
         }
         
         
         
         var validData = true;
         function whitespaceValidation(textvalue){
          
         var len =textvalue.replace(/\s+$/, '');
         if(len==''){
         	//alert('Text box values should not be empty');
         	validData = false;
         	return false;
         }
         else{
         	validData = true;
         }
         
         }
         
         function formValidation(){
         if(validData==false){
         	alert('Text box values should not be empty');
         	return false;
         }
         
         if(document.getElementById("statename").value=="0"){
         	alert("Please select state value from drop-down");
         	return false;
         }
         
         if(document.getElementById("locationidval").value=="0"){
         	alert("Please select location value from drop-down");
         	return false;
         }
         if(document.getElementById("branchidval").value=="0"){
         	alert("Please select branch value from drop-down");
         	return false;
         }
         
         if(document.getElementById("classidval").value=="0"){
         	alert("Please select class value from drop-down");
         	return false;
         }
         if(document.getElementById("sectionidval").value=="0"){
         	alert("Please select section value from drop-down");
         	return false;
         }
         
         }
         
         window.onload = function () {
          document.getElementById("locationidval").innerHTML="	<option value='0'  >--Select One--</option>";
          document.getElementById("branchidval").innerHTML="	<option value='0'  >--Select One--</option>";
          document.getElementById("sectionidval").innerHTML="	<option value='0'  >--Select One--</option>";
          document.getElementById("statename").value="0";
          document.getElementById("classidval").value="0";
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
            <li class="active" ><a href="#" >ADD STUDENT</a></li>
            <li ><a href="load-classfilterstudents" >MODIFY STUDENT</a></li>
            <li ><a href="load-classfilterstudentsfordel" >DELETE STUDENT</a></li>
         </ul>
         <div class="panel-heading" style="background-color:#ccf2ff;color:black; font-weight: bold;">
            <a href="load-studentform">
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
               <form:form  name="AddRoleform" method="post" action="load-ProcessStudent"  modelAttribute="student" >
                  <div class="col-md-12 col-sm-12" id="deceased">
                     <div class="form-group col-md-6 col-sm-6">
                        <label for="firstname">First Name :*</label>
                        <form:input path="firstname" name="firstname" class="form-control" placeholder="firstname" required="required" maxlength="60" minlength="2" onkeyup="return whitespaceValidation(this.value);"/>
                     </div>
                     <div class="form-group col-md-6 col-sm-6">
                        <label for="lastname">Last Name :*</label>
                        <form:input path="lastname" name="lastname" class="form-control" placeholder="lastname" required="required" maxlength="60" minlength="2" pattern="^[a-zA-Z\\-\\s]+$" title="accept only alphabets" onkeyup="return whitespaceValidation(this.value);"/>
                     </div>
                  </div>
                  <div class="col-md-12 col-sm-12" id="deceased">
                     <div class="form-group col-md-6 col-sm-6">
                        <label for="username">User Name :*</label>
                        <form:input path="username" name="username" class="form-control" placeholder="username" required="required" maxlength="60" minlength="5" onkeyup="return whitespaceValidation(this.value);"/>
                     </div>
                     <div class="form-group col-md-6 col-sm-6">
                        <label for="password">Password :*</label>
                        <form:input path="password" name="password" class="form-control" placeholder="password" required="required" maxlength="60" minlength="5" onkeyup="return whitespaceValidation(this.value);"/>
                     </div>
                  </div>
                  <div class="col-md-12 col-sm-12" id="deceased">
                     <div class="form-group col-md-12 col-sm-12">
                        <label for="state">State :*</label>
                        <form:select path="statename" class="form-control"  required="required" id="statename" onchange="getLocationsBasedonState1(this.id);">
                           <form:option value="0"  >--Select One--</form:option>
                           <c:forEach  items="${statenames}" var="branchname" >
                              <form:option value="${branchname.stateid}"  >${branchname.statename}</form:option>
                           </c:forEach>
                        </form:select>
                     </div>
                  </div>
                  <div class="col-md-12 col-sm-12" id="deceased">
                     <div class="form-group col-md-6 col-sm-6">
                        <label for="location">Location :*</label>
                        <form:select path="location" class="form-control" id="locationidval" required="required" onchange="getBranchesBasedonLocation(this.id);">
                           <c:forEach  items="${location}" var="location" >
                              <form:option value="${location.locationid}"  >${location.location}</form:option>
                           </c:forEach>
                        </form:select>
                     </div>
                     <div class="form-group col-md-6 col-sm-6">
                        <label for="branch">Branch :*</label>
                        <form:select path="branch" id="branchidval" class="form-control"  required="required" >
                           <c:forEach  items="${bracnh1}" var="branchname" >
                              <form:option value="${branchname.branchid}" >${branchname.branch}</form:option>
                           </c:forEach>
                        </form:select>
                     </div>
                  </div>
                  <div class="col-md-12 col-sm-12" id="deceased">
                     <div class="form-group col-md-6 col-sm-6">
                        <label for="class">Class :*</label>
                        <form:select path="studentclass" class="form-control" id="classidval"  required="required" onchange="getsectionsFromClass1(this.id)">
                           <c:forEach  items="${classnames}" var="classname" >
                              <form:option value="${classname.categoryid}"  >${classname.category}</form:option>
                           </c:forEach>
                        </form:select>
                     </div>
                     <div class="form-group col-md-6 col-sm-6">
                        <label for="section">Section :*</label>
                        <form:select path="section" id="sectionidval" class="form-control"  required="required" >
                           <c:forEach  items="${secitonnameval}" var="sectionname" >
                              <form:option value="${sectionname.sectionid}" >${sectionname.section}</form:option>
                           </c:forEach>
                        </form:select>
                     </div>
                  </div>
                  <div class="col-md-12 col-sm-12" id="deceased">
                     <div class="form-group col-md-6 col-sm-6">
                        <label for="email">Email Id :</label>
                        <form:input path="email" type="email" id="emailid"   class="form-control" placeholder="email" required="required" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" title="xyz@something.com" autocomplete="off"/>
                        <div class="help-block with-errors"></div>
                     </div>
                     <div class="form-group col-md-6 col-sm-6">
                        <label for="mobile">Mobile No :</label>
                        <form:input path="Mobile"   class="form-control" placeholder="Mobile" required="required" pattern="^\d{10}$" title="10 numeric characters only" maxlength="10" minlength="10" onkeypress="return event.charCode >= 48 && event.charCode <= 57"/>
                     </div>
                  </div>
                  <div class="row"></div>
                  <center><button class="btn-primary" style="background-color: #00a3cc;color:white;width:15%;align-text:center;" onclick="return formValidation();">ADD STUDENT</button></center>
               </form:form>
            </c:if>
         </div>
      </div>
      <center>
         <div style="width: 10%;float:right;background-color: #ffffff"> </div>
      </center>
      <script>
         var input = document.getElementById('emailid');
         
         input.onkeyup = function(){
             this.value = this.value.toLowerCase();
         }
         
      </script>
      <%@include file="adminfooter.jsp" %>
   </body>
</html>