<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <%@include file="DisplayLogo.jsp" %>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>Insert title here</title>
      <script src="${pageContext.request.contextPath}/theme/js/downloadjs/ajax1111.js"></script>
      <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
      <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.6.3/css/bootstrap-select.min.css" />
      <style type="text/css">
         .select,
         .chosen-select,
         .chosen-select-no-single,
         .chosen-select-no-results,
         .chosen-select-deselect,
         .chosen-select-rtl,
         .chosen-select-width {
         width: 350px;
         }
      </style>
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
         
         function validation() {
         	var stateid = document.getElementById("statechckbox").value;
         	var locationid = document.getElementById("locationidval").value;
         	var branchid = document.getElementById("branchidval").value;
         	var classid = document.getElementById("classidval").value;
         	var sectionid = document.getElementById("sectionidval").value;
         	if(stateid==0 || locationid==0 || branchid==0 || classid==0 || sectionid==0){
         		return false;
         	}else{
         		startloader();
         	}
         }
         	
      </script>
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
      <script>
         var getLocationsBasedonStatesAAL = function(stateid){
         
         	var stateids = document.getElementById(stateid).value;
         
             $.ajax({
                     url : "load-locationsformForStudEstAvg?stateid="+stateids,
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
                     url : "load-BranchformForStudEstAvg?locationid="+locationid,
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
                     url : "get-sectiondetailsfromClassForStudEstAvg?classid="+classid,
                     type: "POST",
                     dataType: 'text',
                     success : 
                     function(data) {
                  
                     	    	 document.getElementById("sectionidval").innerHTML=data;
                     	    	 
         
                     	    	
                  }    	
             });
         }
         
         window.onload = function () {
         	document.getElementById("locationidval").innerHTML="<option value='0'  >--Please Select--</option>";
         	document.getElementById("branchidval").innerHTML="<option value='0'  >--Please Select--</option>";
         	document.getElementById("sectionidval").innerHTML="<option value='0'  >--Please Select--</option>";
         	
         	// document.getElementById("availablestates").value="0";
         }
         
      </script>
   </head>
   <body>
      <div id="loaderstart" class="loader" style="display: none;"></div>
      <%@include file="adminUserTopMenu.jsp" %>
      <%@include file="adminUserHeader.jsp" %> 
      <div class="row"> </div>
      <div style="width:22%; float:left; background-color: #ffffff;"><%@include file="AdminDashboardLeftMenu.jsp" %></div>
      <div style="width:70%; float:left; background-color: #ffffff">
         <ul class="nav nav-tabs">
            <li ><a href="load-studentmarksprofilesearch" >SEARCH STUDENT PROFILE</a></li>
            <li class="active"><a href="load-estimatestudentsearch" >SEARCH STUDENTS AVERAGE</a></li>
         </ul>
         <div class="panel panel-info">
            <div class="panel-heading">
               <center><b>View Student Average Marks Report.</b></center>
            </div>
         </div>
         <div class="row"></div>
         <form:form modelAttribute="estavg" action="viewStuEstAvg">
            <div class="col-md-12 col-sm-12" id="">
               <div class="form-group col-md-6 col-sm-6">
                  <label for="firstname">State :*</label>
                  <select name="statechckbox" id="statechckbox" class="form-control" onchange="getLocationsBasedonStatesAAL(this.id);">
                     <option value="0">--Please Select--</option>
                     <c:forEach items="${statenames}" var="statenames">
                        <option value="${statenames.stateid}">${statenames.statename}</option>
                     </c:forEach>
                  </select>
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
                     <form:option value="0"  >--Please Select--</form:option>
                     <c:forEach  items="${classnames}" var="classnames" >
                        <form:option value="${classnames.categoryid}"  >${classnames.category}</form:option>
                     </c:forEach>
                  </form:select>
               </div>
            </div>
            <div class="col-md-12 col-sm-12" id="">
               <div class="form-group col-md-6 col-sm-6">
                  <label style="color:black;font-weight: bold;">Section</label>
                  <form:select path="sectioncheckname"  id="sectionidval"  class="form-control">
                     <c:forEach  items="${secitonnameval}" var="secitonnameval" >
                        <form:option value="${secitonnameval.sectionid}"  >${secitonnameval.section}</form:option>
                     </c:forEach>
                  </form:select>
               </div>
            </div>
            <div class="col-md-12 col-sm-12" id="">
               <div class="form-group col-md-7 col-sm-12" style="float: right;">
                  <button class="btn-primary" type="submit" onclick="return validation()">GET STUDENT RECORD</button>
               </div>
            </div>
         </form:form>
      </div>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
      <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.6.3/js/bootstrap-select.min.js"></script>
   </body>
</html>