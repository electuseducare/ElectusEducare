<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <%@include file="DisplayLogo.jsp" %>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>Modify Student</title>
      <%@include file="adminDataTable.jsp" %>
      <script src="${pageContext.request.contextPath}/theme/js/AdminFieldEmptyValidation.js"></script>
      <style type="text/css">
         .pexamTable {
         width:100%;
         height:100%;
         opacity:.95;
         top:0;
         left:0;
         display:none;
         position:fixed;
         background-color:transparent;
         overflow:auto;
         }
         .examTable {
         width:100%;
         height:100%;
         opacity:.95;
         top:0;
         left:0;
         display:none;
         position:fixed;
         background-color:transparent;
         overflow:auto;
         }
         img#close {
         position:absolute;
         right:0px;
         top:0px;
         cursor:pointer
         }
         img#close1 {
         position:absolute;
         right:0px;
         top:0px;
         cursor:pointer
         }
         div#popupContact {
         position:absolute;
         left:40%;
         width:50%;
         height:30%;
         top:35%;
         margin-left:-202px;
         -moz-box-shadow: -20px 20px 20px 20px #888;
         -webkit-box-shadow: -20px 20px 20px 20px#888;
         box-shadow: -20px 20px 10px  #888888;
         font-family:'Raleway',sans-serif;
         background-color: #e6f7ff;
         }
         @-webkit-keyframes blinker {
         from {opacity: 1.0;}
         to {opacity: 0.4;}
         }
         .blink{
         text-decoration: blink;
         -webkit-animation-name: blinker;
         -webkit-animation-duration: 0.6s;
         -webkit-animation-iteration-count:infinite;
         -webkit-animation-timing-function:ease-in-out;
         -webkit-animation-direction: alternate;
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
         window.onload = function () {
         	 $(".loader").fadeOut("slow");
         }
      </script>
      <script type="text/javascript">
         var getLocationsBasedonState12 = function(stateid, locationid1){
         var stateids = document.getElementById(stateid).value;
         
         
           $.ajax({
                   url : "load-branchform12?stateid="+stateids,
                   type: "GET",
                   dataType: 'json',
                   success : 
                   function(data) {
                   	
                   	 var content="";
                        var qnscontent="";
                        var locationlength=0;
                        document.getElementById(locationid1).innerHTML="";
                    	$.each(data,function(i,val){
                    		
                    		$.each(val,function(key,value1){
                    			
                                if(key=="location"){
                               	 content="";
                        		     content+=value1;
                        		
                                }
                                else if(key=="locationid")
                                	{
                               	 if(locationlength==0){
                               		 document.getElementById(locationid1).innerHTML += '<option value="'+0+'">--Select One--</option>' ;
                               	 }
                               	
                               	 document.getElementById(locationid1).innerHTML += '<option value="'+value1+'">'+content+'</option>' ;
                               	 locationlength++;
                                	}
                    			});
                    	});
                    	if(locationlength==0){
                    	document.getElementById(locationid1).innerHTML = '<option value="'+0+'">No Locations Available</option>' ;
                    	}
                }    	
           });
         } 
         
         
         
         
         var getBranchesBasedonLocation12 = function(locationid, branchid1){
         
         var locationids = document.getElementById(locationid).value;
         
            $.ajax({
                    url : "load-BranchesBasedonLocation12?locationid="+locationids,
                    type: "GET",
                    dataType: 'json',
                    success : 
                    function(data) {
                    	
                    	 var content="";
                         var qnscontent="";
                         document.getElementById(branchid1).innerHTML="";
                         var branchlength=0;
                     	$.each(data,function(i,val){
                     		
                     		$.each(val,function(key,value1){
                                 if(key=="branch"){
                                	 content="";
                         		content+=value1;
                         		
                                 }
                                 
                                 else if(key=="branchid")
                                 	{
                                	 if(branchlength==0){
                                		 document.getElementById(branchid1).innerHTML += '<option value="'+0+'">--Select One--</option>' ;
                                	 }
                                	 document.getElementById(branchid1).innerHTML += '<option value="'+value1+'">'+content+'</option>' ;
                                	 branchlength++;
                                 	}
                     			});
                     	});
                     	 if(branchlength==0){
                       		 document.getElementById(branchid1).innerHTML = '<option value="'+0+'">--No Branches Available--</option>' ;
                       	 }
                 }    	
            });
         } 
         
         
         var getsectionsFromClass12 = function(classid, sectionid1){
         
         var classid = document.getElementById(classid).value;
         
            $.ajax({
                    url : "get-sectiondetailsfromClass12?classid="+classid,
                    type: "GET",
                    dataType: 'json',
                    success : 
                    function(data) {
                     	var content="";
                        var qnscontent="";
                        document.getElementById(sectionid1).innerHTML="";
                        var sectionlength=0;
                     	$.each(data,function(i,val){
                     		
                     		$.each(val,function(key,value1){
                                 if(key=="section"){
                                	 content="";
                         		     content+=value1;
                                 }
                                 if(key=="sectionid"){
                                	 if(sectionlength==0){
                                		 document.getElementById(sectionid1).innerHTML += '<option value="'+0+'">--Select One--</option>' ;
                                	 }
                                	 document.getElementById(sectionid1).innerHTML += '<option value="'+value1+'">'+content+'</option>' ;
                                	 sectionlength++;
                                 	}
                     			});
                     	});
                     	if(sectionlength==0){
                      		 document.getElementById(sectionid1).innerHTML = '<option value="'+0+'">--No Sections Available--</option>' ;
                      	 }
                 }    	
            });
         } 
         
         
      </script>
      <script>
         //Function To Display Popup
         function finish_div_show() {
         document.getElementById('finishabc').style.display = "block";
         return false;
         }
         //Function to Hide Popup
         function finish_div_hide(){
         document.getElementById('finishabc').style.display = "none";
         }
         
         function cancel_Finish(){
         	document.getElementById('finishabc').style.display = "none";
         	return false;
         }
      </script>
      <script type="text/javascript">
         function selectAllLocations(){
         	if(document.getElementById("selectalllocations").checked == true){
         		var ql=0;
         		$(':checkbox').each(function() {
         			document.getElementById("selectloc"+ql).checked = true;  
         			ql++;
                 });
         	}
         	if(document.getElementById("selectalllocations").checked == false){
         		var ql=0;
         		$(':checkbox').each(function() {
         			document.getElementById("selectloc"+ql).checked = false;  
         			ql++;
                 });
         	}
         }
         
         
         
         
         
         
      </script>
   </head>
   <body>
      <!-- start header -->
      <%@include file="adminUserTopMenu.jsp" %>
      <%@include file="adminUserHeader.jsp" %>
      <div class="loader"></div>
      <div class="row"> </div>
      <div style="width: 22%; float:left; background-color: #ffffff;"><%@include file="AdminDashboardLeftMenu.jsp" %></div>
      <div style="width: 75%; float:left; background-color: #ffffff;">
         <ul class="nav nav-tabs">
            <li><a href="load-studentform">ADD STUDENT</a></li>
            <li  class="active"><a href="#">MODIFY STUDENT</a></li>
            <li><a href="load-classfilterstudentsfordel">DELETE STUDENT</a></li>
         </ul>
         <div class="panel-heading" style="background-color:#ccf2ff;color:black; font-weight: bold;">
            <a href="load-classfilterstudents">
            <img border="0" alt="W3Schools" src="${pageContext.request.contextPath}/theme/images/edit.jpg" width="40" height="40" >
            </a>
         </div>
         <div class="col-sm-12" style="border: 0px solid grey; margin-left:0px; padding: 0.50em; width: 100%;background-color:#DFE2DB;  overflow-x:scroll;">
            <form:form  name="EditRoles" method="post" action="load-processRolesModify"  modelAttribute="studentlistvalue" >
               <h4 style="color: green;text-align: center;">${smsg}</h4>
               <h4  style="color: red;text-align: center;">${emsg}</h4>
               <div id="test"> </div>
               <table id="example" class="display" cellspacing="0" width="100%">
                  <thead>
                     <c:if test="${buttonid eq 0}">
                        <center>
                           <h4 style="color:red">You don't have any students available to update</h4>
                        </center>
                     </c:if>
                     <c:if test="${buttonid eq 1}">
                        <tr>
                           <th class="bg-info" style="color: #00008B"><input type="checkbox" id="selectalllocations" value="0" onclick="selectAllLocations();" style="margin-left:5px;"></th>
                           <th class="bg-info" style="color: #00008B">ID</th>
                           <th class="bg-info" style="color: #00008B">FirstName</th>
                           <th class="bg-info" style="color: #00008B">LastName</th>
                           <th class="bg-info"  style="color: #00008B">User Name</th>
                           <th class="bg-info" style="color: #00008B"> Email </th>
                           <th class="bg-info" style="color: #00008B">Password</th>
                           <th class="bg-info" style="color: #00008B">Mobile</th>
                           <th class="bg-info" style="color: #00008B">State</th>
                           <th class="bg-info" style="color: #00008B">Location</th>
                           <th class="bg-info" style="color: #00008B">Branch</th>
                           <th class="bg-info" style="color: #00008B">Class</th>
                           <th class="bg-info" style="color: #00008B">Section</th>
                           <th class="bg-info" style="color: #00008B">Status</th>
                        </tr>
                     </c:if>
                  </thead>
                  <tbody>
                     <c:forEach items="${studentlistvalue.studentformlist}" var="editdetails" varStatus="loop">
                        <tr>
                           <td style="font-weight: bold;">
                              <form:checkbox path="studentformlist[${loop.index}].useridlist" id="selectloc${loop.index}" value="${editdetails.userid}" />
                           </td>
                           <td style="font-weight: bold;">
                              <form:input path="studentformlist[${loop.index}].studentid" readonly="true"/>
                              <span style="display:none;">${editdetails.studentid}</span>
                           </td>
                           <td style="font-weight: bold;">
                              <form:input path="studentformlist[${loop.index}].firstname"  minlength="2" maxlength="60" onkeyup="return whitespaceValidation(this.value);"/>
                              <span style="display:none;">${editdetails.firstname}</span>
                           </td>
                           <td style="font-weight: bold;">
                              <form:input path="studentformlist[${loop.index}].lastname" pattern="^[a-zA-Z\\-\\s]+$" title="accept only alphabets" minlength="2" maxlength="60" onkeyup="return whitespaceValidation(this.value);"/>
                              <span style="display:none;">${editdetails.lastname}</span>
                           </td>
                           <td style="font-weight: bold;">
                              <form:input path="studentformlist[${loop.index}].username" readonly="true"/>
                              <span style="display:none;">${editdetails.username}</span>
                           </td>
                           <td style="font-weight: bold;">
                              <form:input path="studentformlist[${loop.index}].email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" title="xyz@something.com" onkeyup="return whitespaceValidation(this.value);"/>
                              <span style="display:none;">${editdetails.email}</span>
                           </td>
                           <td style="font-weight: bold;">
                              <form:input path="studentformlist[${loop.index}].password"/>
                              <span style="display:none;">${editdetails.password}</span>
                           </td>
                           <td style="font-weight: bold;">
                              <form:input path="studentformlist[${loop.index}].mobile" pattern="^\d{10}$" title="10 numeric characters only" onkeyup="return whitespaceValidation(this.value);"/>
                              <span style="display:none;">${editdetails.studentclass}</span>
                           </td>
                           <td style="font-weight: bold;">
                              <form:select path="studentformlist[${loop.index}].state" id="studentformlist[${loop.index}].state" class="form-control"  required="required" onchange="getLocationsBasedonState12(this.id,'studentformlist[${loop.index}].location');">
                                 <c:forEach  items="${statenames}" var="statenames" >
                                    <c:if test="${editdetails.state == statenames.statename}">
                                       <option value="${statenames.stateid}" selected="selected">${statenames.statename}</option>
                                    </c:if>
                                    <c:if test="${editdetails.state != statenames.statename}">
                                       <form:option value="${statenames.stateid}"  >${statenames.statename}</form:option>
                                    </c:if>
                                 </c:forEach>
                              </form:select>
                           </td>
                           <td style="font-weight: bold;">
                              <form:select path="studentformlist[${loop.index}].location" id="studentformlist[${loop.index}].location" class="form-control"  required="required" onchange="getBranchesBasedonLocation12(this.id, 'studentformlist[${loop.index}].branch')">
                                 <option value="${editdetails.locationid}" selected="selected">${editdetails.location}</option>
                              </form:select>
                           </td>
                           <td style="font-weight: bold;">
                              <form:select path="studentformlist[${loop.index}].branch" id="studentformlist[${loop.index}].branch" class="form-control"  required="required" >
                                 <option value="${editdetails.branchid}" selected="selected">${editdetails.branch}</option>
                              </form:select>
                           </td>
                           <%-- 	<span style="display:none;">${editdetails.school}</span></td>  --%>
                           <td style="font-weight: bold;">
                              <form:select path="studentformlist[${loop.index}].studentclass" class="form-control"  required="required" onchange="getsectionsFromClass12(this.id,'studentformlist[${loop.index}].section')">
                                 <c:forEach  items="${classnames}" var="classname" >
                                    <c:if test="${editdetails.studentclass == classname.category}">
                                       <option value="${classname.categoryid}" selected="selected">${classname.category}</option>
                                    </c:if>
                                    <c:if test="${editdetails.studentclass != classname.category}">
                                       <form:option value="${classname.categoryid}"  >${classname.category}</form:option>
                                    </c:if>
                                 </c:forEach>
                              </form:select>
                           <td style="font-weight: bold;">
                              <form:select path="studentformlist[${loop.index}].section" id="studentformlist[${loop.index}].section" class="form-control"  required="required" >
                                 <option value="${editdetails.sectionid}" selected="selected">${editdetails.section}</option>
                              </form:select>
                           </td>
                           <td style="font-weight: bold;">
                              <form:select path="studentformlist[${loop.index}].status">
                                 <c:if test="${editdetails.status==0}">
                                    <option value="0" selected="selected">ACTIVATE</option>
                                    <option value="1" >IN ACTIVATE</option>
                                 </c:if>
                                 <c:if test="${editdetails.status==1}">
                                    <option value="1" selected="selected">IN ACTIVATE</option>
                                    <option value="0" >ACTIVATE</option>
                                 </c:if>
                              </form:select>
                        </tr>
                     </c:forEach>
                  </tbody>
               </table>
               <div class="col-md-12 col-sm-12" >
                  <div class="col-md-6 col-sm-6" > &nbsp; </div>
                  <div class="col-md-6 col-sm-6" style="float: left;">
                     <c:if test="${buttonid eq 1}">
                        <button class="btn-primary" style="background-color: #00a3cc;color:white;" id="popup" onclick="return finish_div_show();"> UPDATE</button>
                     </c:if>
                  </div>
               </div>
               <div id="finishabc" style="overflow:hidden;">
                  <div id="popupContact" >
                     <div class="panel" style="width: 100%; background-color: #117584;">
                        <div class="panel-heading"  style="font-size: 18px;font-weight: bold; color: #ffffff;">Modify Student</div>
                     </div>
                     <table width="100%" height="65%">
                        <tr>
                           <td valign="middle" align="center" colspan="2" style="font-weight: bold; color: #00004d;"> Do you want to modify Student? </td>
                        </tr>
                        <tr>
                           <td valign="middle" align="center" colspan="2" style="font-weight: bold; color: #00004d;"> If 'YES' please click on Update. If 'NO' click on Cancel. </td>
                        </tr>
                        <tr>
                           <td align="left" width="50%" valign="bottom">  
                              <button class="button btn-primary" style="margin-top:40px; margin-left:180px;background-color:#0E8DE2;color: white; font-weight: bold; " name="actionform" value="finishtest" onclick="return formValidation();stopFinishTestTime();"> UPDATE </button>
                           </td>
                           <td align="right" width="50%" valign="bottom">
                              <button class="button btn-primary" style="margin-top:40px; margin-right:180px;background-color:#0E8DE2;color: white; font-weight: bold; " id="cancelFinish" onclick="return cancel_Finish();">Cancel</button>
                           </td>
                        </tr>
                     </table>
                  </div>
               </div>
            </form:form>
         </div>
      </div>
      <script type="text/javascript">
         $(document).ready(function() {
             $('#example').DataTable( {
                 
             } );
         } );
         
      </script>
      <%@include file="adminfooter.jsp" %>
   </body>
</html>