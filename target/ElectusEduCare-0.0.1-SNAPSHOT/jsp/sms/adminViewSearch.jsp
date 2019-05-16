<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <%@include file="/jsp/DisplayLogo.jsp" %>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>Electus Educare</title>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
      <script>
         var getLocationsBasedonStatesAAL = function(stateid,statename){
         
         	var stateids = document.getElementById(stateid).value;
         
            /*  var selO = document.getElementsByName(statename)[0];
             var selValues = [];
             for(i=0; i < selO.length; i++){
                 if(selO.options[i].selected){
                     selValues.push("'"+selO.options[i].value+"'");
                 }
             }
             selValues = selValues.substring(1); */
             $.ajax({
                     url : "load-locationsformForStudSMS?stateid="+stateids,
                     type: "POST",
                     dataType: 'text',
                     success : 
                     function(data) {
                     	    	document.getElementById("locationidval").innerHTML=data;
                  }    	
             });
         }
         
         var getBranchBasedonLocationid = function(locationid){
         
         	var locationid = document.getElementById(locationid).value;
         
             $.ajax({
                     url : "load-BranchformForStudSMS?locationid="+locationid,
                     type: "POST",
                     dataType: 'text',
                     success : 
                     function(data) {
                     	    	document.getElementById("branchidval").innerHTML=data;
                  }    	
             });
         }
         var getsectionsFromClass = function(classid){
         
         	var classid = document.getElementById(classid).value;
         
             $.ajax({
                     url : "get-sectiondetailsfromClassForStudSMS?classid="+classid,
                     type: "POST",
                     dataType: 'text',
                     success : 
                     function(data) {
                  
                     	    	 document.getElementById("sectionidval").innerHTML=data;
                     	    	 
         
                     	    	
                  }    	
             });
         }
         var getsectionsFromClass = function(classid){
         
         	var classid = document.getElementById(classid).value;
         
             $.ajax({
                     url : "get-sectiondetailsfromClassForStudSMS?classid="+classid,
                     type: "POST",
                     dataType: 'text',
                     success : 
                     function(data) {
                  
                     	    	 document.getElementById("sectionidval").innerHTML=data;
                     	    	 
         
                     	    	
                  }    	
             });
         }
         var getExamNameFromStudentResults= function(){
         
         	var classid = document.getElementById("classidval").value;
         	var sectionid = document.getElementById("sectionidval").value;
         	var branch = document.getElementById("branchidval").value;
         	var state = document.getElementById("statechckbox").value;
         	var location = document.getElementById("locationidval").value;
             $.ajax({
                     url : "get-examdetailsfromResultsForStudSMS?classid="+classid+"&&sectionid="+sectionid+"&&campus="+branch+"&&location="+location+"&&state="+state,
                     type: "POST",
                     dataType: 'text',
                     success : 
                     function(data) {
                 
                     	    	 document.getElementById("examidval").innerHTML=data;
                     	    	 
         
                     	    	
                  }    	
             });
         }
         
         
         
         
         window.onload = function () {
         	document.getElementById("locationidval").innerHTML="<option value='0'  >--Please Select--</option>";
         	document.getElementById("branchidval").innerHTML="<option value='0'  >--Please Select--</option>";
         	document.getElementById("sectionidval").innerHTML="<option value='0'  >--Please Select--</option>";
         	document.getElementById("examidval").innerHTML="<option value='0'  >--Please Select--</option>";
         	
         	// document.getElementById("availablestates").value="0";
         }
         $(document).ready(function() {
         	   $('input[type="radio"]').click(function() {
         	       if($(this).attr('id') == 'results') {
         	            $('#examnamediv').show();           
         	       }
         
         	       else {
         	            $('#examnamediv').hide();   
         	       }
         	   });
         	   
         	   $('input[type="radio"]').click(function() {
         	       if($(this).attr('id') == 'normal') {
         	            $('#normaldiv').show();           
         	       }
         
         	       else {
         	            $('#normaldiv').hide();   
         	       }
         	   });
         	});
         
         function validateForm() {
             var statevalue = document.forms["myForm"]["statechckbox"].value;
             var location = document.forms["myForm"]["locationidval"].value;
             var branchidval = document.forms["myForm"]["branchidval"].value;
             var sectionidval = document.forms["myForm"]["sectionidval"].value;
             
             if (statevalue == 0) {
                 alert("Please select any one state");
                 return false;
             }
             if (location == 0) {
                 alert("Please select any one location");
                 return false;
             }
             if (branchidval == 0) {
                 alert("Please select any one branch");
                 return false;
             }
             if (sectionidval == 0) {
                 alert("Please select any one section");
                 return false;
             }
             
         }
      </script>
   </head>
   <body>
      <%@include file="/jsp/adminUserTopMenu.jsp" %>
      <%@include file="/jsp/adminUserHeader.jsp" %>
      <!-- start header -->
      <div class="row"></div>
      <div style="width:22%; float:left; background-color: #ffffff;">
         <%@include file="/jsp/AdminDashboardLeftMenu.jsp" %>
      </div>
      <div style="width:70%; float:left; background-color: #ffffff">
         <ul class="nav nav-tabs">
            <li class="active"><a href="#" >SEARCH SMS &amp; SEND </a></li>
         </ul>
         <div class="panel panel-info">
            <div class="panel-heading">
               <center><b>Select Search Categories and Send SMS to Students.</b></center>
            </div>
         </div>
         <form:form name="myForm" modelAttribute="smssearch" action="Load-ProcessSendBulkSms" onsubmit="return validateForm()">
            <c:if test="${smsg!=null}">
               <h4 style="color: green">${smsg}</h4>
            </c:if>
            <!-- ==============    result sms div          =================== -->
            <div class="col-md-12 col-sm-12" id="">
               <div class="form-group col-md-6 col-sm-6">
                  <label for="firstname">State :*</label>
                  <form:select path="statechckbox" id="statechckbox" class="form-control" onchange="getLocationsBasedonStatesAAL(this.id,this.name);">
                     <option value="0">--Please Select--</option>
                     <c:forEach items="${statenames}" var="statenames">
                        <option value="${statenames.stateid}">${statenames.statename}</option>
                     </c:forEach>
                  </form:select>
               </div>
               <div class="form-group col-md-6 col-sm-6">
                  <label style="color:black;font-weight: bold;">Locations</label>
                  <form:select path="loactioncheckvalue"  id="locationidval"  class="form-control"   onchange="getBranchBasedonLocationid(this.id);">
                     <c:forEach  items="${location}" var="locationanames" >
                        <form:option value="${locationanames.locationid}"  >${locationanames.location}</form:option>
                     </c:forEach>
                  </form:select>
               </div>
            </div>
            <div class="col-md-12 col-sm-12" id="">
               <div class="form-group col-md-6 col-sm-6">
                  <label style="color:black;font-weight: bold;">Branch</label>
                  <form:select path="branchcheckname"  id="branchidval"  class="form-control"   >
                     <c:forEach  items="${branch}" var="branch" >
                        <form:option value="${branch.branchid}"  >${branch.branch}</form:option>
                     </c:forEach>
                  </form:select>
               </div>
               <div class="form-group col-md-6 col-sm-6">
                  <label style="color:black;font-weight: bold;">Class</label>
                  <form:select path="classname"  id="classidval"  class="form-control"   onchange="getsectionsFromClass(this.id)">
                     <c:forEach  items="${classnames}" var="classnames" >
                        <form:option value="${classnames.categoryid}"  >${classnames.category}</form:option>
                     </c:forEach>
                  </form:select>
               </div>
            </div>
            <div class="col-md-12 col-sm-12" id="">
               <div class="form-group col-md-12 col-sm-12">
                  <label style="color:black;font-weight: bold;">Section</label>
                  <form:select path="sectioncheckname"  id="sectionidval"  class="form-control">
                     <c:forEach  items="${secitonnameval}" var="secitonnameval" >
                        <form:option value="${secitonnameval.sectionid}"  >${secitonnameval.section}</form:option>
                     </c:forEach>
                  </form:select>
               </div>
            </div>
            <!-- ============== End   result sms div          =================== -->
            <div class="form-group col-md-6 col-sm-6">
               <label>Sms Type:*</label>
               Results
               <form:radiobutton path="smstype" id="results" value="resultsms" onclick="getExamNameFromStudentResults();showdiv(this.value)"/>
               Normal Sms
               <form:radiobutton path="smstype" id="normal" value="normalsms" onclick="showdiv(this.value)"/>
            </div>
            <div id="examnamediv" style="display: none;">
               <div class="form-group col-md-12 col-sm-12">
                  <div class="form-group col-md-6 col-sm-6">
                     <label style="color:black;font-weight: bold;">Exams</label>
                     <form:select path="examname"  id="examidval"  class="form-control"   onchange="getstudentidsBasedOnExamname(this.id)">
                        <c:forEach  items="${examnames}" var="exams" >
                           <form:option value="${exams.examname}"  >${exams.examname}</form:option>
                        </c:forEach>
                     </form:select>
                  </div>
               </div>
            </div>
            <div id="normaldiv" style="display: none;">
               <div class="form-group col-md-12 col-sm-12">
                  <div class="form-group col-md-6 col-sm-6">
                     <label>SMS Description:*</label>
                     <form:textarea path="smsdescription" cols="80" rows="4"/>
                  </div>
               </div>
            </div>
            <!-- ==============   End Normal sms div          =================== -->
            <div class="form-group col-md-12 col-sm-12">
               <center><button  style="background-color:#002E5B;color: white;height: 60%;width:70px;text-align: center;">Send</button></center>
            </div>
         </form:form>
      </div>
      <center>
         <div style="width: 10%;float:right;background-color: #ffffff"> </div>
      </center>
      <%@include file="/jsp/adminfooter.jsp" %>
   </body>
</html>