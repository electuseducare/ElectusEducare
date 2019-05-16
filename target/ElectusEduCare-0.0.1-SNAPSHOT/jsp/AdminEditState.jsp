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
      <script src="${pageContext.request.contextPath}/theme/js/AdminFieldEmptyValidation.js"></script>
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
         
         /* Allow only alphabets with spaces  */
         function ValidateAlpha(evt)
         {
             var keyCode = (evt.which) ? evt.which : evt.keyCode;
             if ((keyCode < 65 || keyCode > 90) && (keyCode < 97 || keyCode > 123) && (keyCode != 32)){
              
             return false;
             }
             else{
                 return true;
             }
         }
         
      </script>
      <script>
         function validatespaces(statename){
         	var examname = document.getElementById(statename).value;
         	var len =examname.replace(/\s+$/, '');
         
         	if(len==''){
         		alert("State name should not be empty");
         		return false;
         	}
         	
         }
         
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
   </head>
   <body>
      <%@include file="adminUserTopMenu.jsp" %>
      <%@include file="adminUserHeader.jsp" %>
      <!-- start header -->
      <div class="row"> </div>
      <div style="width:22%; float:left; background-color: #ffffff;"><%@include file="AdminDashboardLeftMenu.jsp" %></div>
      <div style="width:70%; float:left; background-color: #ffffff">
         <ul class="nav nav-tabs">
            <li  ><a href="load-stateform" >ADD STATE</a></li>
            <li class="active"><a href="#" >MODIFY STATE</a></li>
            <li ><a href="load-Deletestateform" >DELETE STATE</a></li>
         </ul>
         <div class="panel-heading" style="background-color:#ccf2ff;color:black; font-weight: bold;">
            <a href="load-EditStateform">
            <img border="0" alt="W3Schools" src="${pageContext.request.contextPath}/theme/images/edit.jpg" width="40" height="40" ></a>
         </div>
         <div class="panel-body" id="mockTabs" style="background-color:#DFE2DB;">
            <center>
               <h4 style="color:green">${smsg}</h4>
            </center>
            <center>
               <h4 style="color:red">${emsg}</h4>
            </center>
            <c:if test="${smsg==null}" >
               <form:form  name="AddRoleform" method="post" action="load-processeditstateform"  modelAttribute="categorylistvalue" >
                  <TABLE width="100%" style="padding: 6px">
                     <TR>
                        <TD width="5%">&nbsp;</TD>
                        <TD width="90%" align="left">
                           <c:if test="${buttonid eq 0}">
                              <center>
                                 <h4 style="color:red">You don't have any states available to update</h4>
                              </center>
                           </c:if>
                           <TABLE id="editstate" class="display" cellspacing="0" width="100%">
                              <thead>
                                 <c:if test="${buttonid eq 1}">
                                    <TR>
                                       <TH>No</TH>
                                       <TH style="text-align: center;">&nbsp;&nbsp;&nbsp;State ID</TH>
                                       <TH style=" text-align: center;" >&nbsp;&nbsp;&nbsp;State </TH>
                                       <TH >Select All
                                          <input type="checkbox" id="selectalllocations" value="0" onclick="selectAllLocations();" style="margin-left:10px;"> 
                                       </TH>
                                    </TR>
                                 </c:if>
                              </thead>
                              <tbody>
                                 <c:forEach items="${categorylistvalue.categorylist}" var="editdetails" varStatus="loop">
                                    <TR>
                                       <TD align="center"> ${loop.index+1}  </TD>
                                       <TD style="padding: 6px" align="center">  ${editdetails.stateid}</TD>
                                       <TD style="padding: 10px" align="center">
                                          <form:input path="categorylist[${loop.index}].statename" name="category" value="${editdetails.statename}" class="form-control" onKeyPress="return ValidateAlpha(event);" onkeyup="return validatespaces(this.id);" style="width:100%;margin-left:10px;"  maxlength="60"/>
                                          <span  style="display: none">${editdetails.statename}</span>
                                       </TD>
                                       <TD style="padding: 15px" align="left">
                                          <form:checkbox path="categorylist[${loop.index}].statechckbox" id="selectloc${loop.index}"  value="${editdetails.stateid}" style="margin-left:78px;"/>
                                       </TD>
                                    </TR>
                                 </c:forEach>
                              </tbody>
                           </TABLE>
                        </TD>
                        <TD width="5%">&nbsp;</TD>
                     <TR>
                        <TD> &nbsp; </TD>
                     </TR>
                     <TR>
                        <TD colspan="2" align="center">
                           <c:if test="${buttonid eq 1}">
                              <button class="btn-primary" style="background-color: #00a3cc;color:white;" id="popup" onclick="return finish_div_show();"> UPDATE</button>
                           </c:if>
                        </TD>
                     </TR>
                  </TABLE>
                  <script type="text/javascript">
                     $(document).ready(function() {
                         $('#editstate').DataTable( {
                             
                         } );
                     } ); 
                     
                  </script>
                  <div id="finishabc" style="overflow:hidden;">
                     <div id="popupContact" >
                        <div class="panel" style="width: 100%; background-color: #117584;">
                           <div class="panel-heading"  style="font-size: 18px;font-weight: bold; color: #ffffff;">Modify State</div>
                        </div>
                        <table width="100%" height="65%">
                           <tr>
                              <td valign="middle" align="center" colspan="2" style="font-weight: bold; color: #00004d;"> Do you want to modify State? </td>
                           </tr>
                           <tr>
                              <td valign="middle" align="center" colspan="2" style="font-weight: bold; color: #00004d;"> If 'YES' please click on Update. If 'NO' click on Cancel. </td>
                           </tr>
                           <tr>
                              <td align="left" width="50%" valign="bottom">  
                                 <button class="button btn-primary" style="margin-top:40px; margin-left:180px;background-color:#0E8DE2;color: white; font-weight: bold; " name="actionform" value="finishtest" onclick="return formValidation();stopFinishTestTime();"> UPDATE</button>
                              </td>
                              <td align="right" width="50%" valign="bottom">
                                 <button class="button btn-primary" style="margin-top:40px; margin-right:180px;background-color:#0E8DE2;color: white; font-weight: bold; " id="cancelFinish" onclick="return cancel_Finish();">Cancel</button>
                              </td>
                           </tr>
                        </table>
                     </div>
                  </div>
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