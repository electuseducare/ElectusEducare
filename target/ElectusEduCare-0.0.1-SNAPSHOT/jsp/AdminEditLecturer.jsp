<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <%@include file="DisplayLogo.jsp" %>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>Electus Educare</title>
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
      <%@include file="adminUserTopMenu.jsp" %>
      <%@include file="adminUserHeader.jsp" %>
      <div class="row"> </div>
      <div style="width: 22%; float:left; background-color: #ffffff;"><%@include file="AdminDashboardLeftMenu.jsp" %></div>
      <div style="width: 75%; float:left; background-color: #ffffff;">
         <ul class="nav nav-tabs">
            <li><a href="load-lecturerform">ADD LECTURER</a></li>
            <li  class="active"><a href="#">MODIFY LECTURER</a></li>
            <li><a href="load-DeleteLecturerform">DELETE LECTURER</a></li>
         </ul>
         <div class="panel-heading" style="background-color:#ccf2ff;color:black; font-weight: bold;">
            <a href="load-EditLecturerform">
            <img border="0" alt="W3Schools" src="${pageContext.request.contextPath}/theme/images/edit.jpg" width="40" height="40" >
            </a>
         </div>
         <div class="col-sm-12" style="border: 0px solid grey; margin-left:0px; padding: 0.50em; width: 100%;background-color:#DFE2DB;  overflow-x:scroll;">
            <form:form  name="EditRoles" method="post" action="load-processLecturerModify"  modelAttribute="studentlistvalue" >
               <h4 style="color: green;text-align:center">${smsg}</h4>
               <h4  style="color: red;text-align:center">${emsg}</h4>
               <c:if test="${smsg==null}" >
                  <table id="example" class="display" cellspacing="0" width="100%">
                     <thead>
                        <c:if test="${buttonid eq 0}">
                           <center>
                              <h4 style="color:red">You don't have any lecturer available to update</h4>
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
                           </tr>
                        </c:if>
                     </thead>
                     <tbody>
                        <c:forEach items="${studentlistvalue.studentformlist}" var="editdetails" varStatus="loop">
                           <tr>
                              <td style="font-weight: bold;">
                                 <form:checkbox path="studentformlist[${loop.index}].useridlist" id="selectloc${loop.index}"  value="${editdetails.userid}" />
                              </td>
                              <td style="font-weight: bold;">
                                 <form:input path="studentformlist[${loop.index}].studentid" readonly="true"/>
                                 <span style="display:none;">${editdetails.studentid}</span>
                              </td>
                              <td style="font-weight: bold;">
                                 <form:input path="studentformlist[${loop.index}].firstname" pattern="^[a-zA-Z\\-\\s]+$" title="accept only alphabets" minlength="2" maxlength="60"/>
                                 <span style="display:none;">${editdetails.firstname}</span>
                              </td>
                              <td style="font-weight: bold;">
                                 <form:input path="studentformlist[${loop.index}].lastname" pattern="^[a-zA-Z\\-\\s]+$" title="accept only alphabets" minlength="2" maxlength="60"/>
                                 <span style="display:none;">${editdetails.lastname}</span>
                              </td>
                              <td style="font-weight: bold;">
                                 <form:input path="studentformlist[${loop.index}].username" readonly="true"/>
                                 <span style="display:none;">${editdetails.username}</span>
                              </td>
                              <td style="font-weight: bold;">
                                 <form:input path="studentformlist[${loop.index}].email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" title="xyz@something.com"/>
                                 <span style="display:none;">${editdetails.email}</span>
                              </td>
                              <td style="font-weight: bold;">
                                 <form:input path="studentformlist[${loop.index}].password"/>
                                 <span style="display:none;">${editdetails.password}</span>
                              </td>
                              <td style="font-weight: bold;">
                                 <form:input path="studentformlist[${loop.index}].mobile" pattern="^\d{10}$" title="10 numeric characters only" maxlength="10" minlength="10"/>
                                 <span style="display:none;">${editdetails.mobile}</span>
                              </td>
                           </tr>
                        </c:forEach>
                     </tbody>
                  </table>
                  <div class="col-md-6 col-sm-6" > &nbsp; </div>
                  <c:if test="${buttonid eq 1}">
                     <button class="btn-primary" style="background-color: #00a3cc;color:white;" id="popup" onclick="return finish_div_show();"> UPDATE</button>
                  </c:if>
                  <div id="finishabc" style="overflow:hidden;">
                     <div id="popupContact" >
                        <div class="panel" style="width: 100%; background-color: #117584;">
                           <div class="panel-heading"  style="font-size: 18px;font-weight: bold; color: #ffffff;">Modify Lecturer</div>
                        </div>
                        <table width="100%" height="65%">
                           <tr>
                              <td valign="middle" align="center" colspan="2" style="font-weight: bold; color: #00004d;"> Do you want to modify Lecturer? </td>
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
               </c:if>
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