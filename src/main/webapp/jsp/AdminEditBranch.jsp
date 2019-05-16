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
   </head>
   <body>
      <%@include file="adminUserTopMenu.jsp" %>
      <%@include file="adminUserHeader.jsp" %>
      <!-- start header -->
      <div class="row"> </div>
      <div style="width:22%; float:left; background-color: #ffffff;"><%@include file="AdminDashboardLeftMenu.jsp" %></div>
      <div style="width:70%; float:left; background-color: #ffffff">
         <ul class="nav nav-tabs">
            <li  ><a href="load-branchform" >ADD BRANCH</a></li>
            <li class="active"><a href="#" >MODIFY BRANCH</a></li>
            <li ><a href="load-Deletebranchform" >DELETE BRANCH</a></li>
         </ul>
         <div class="panel-heading" style="background-color:#ccf2ff;color:black; font-weight: bold;"><a href="load-EditBranchform"><img border="0" alt="W3Schools" src="${pageContext.request.contextPath}/theme/images/edit.jpg" width="40" height="40" ></a></div>
         <div class="panel-body" id="mockTabs" style="background-color:#DFE2DB;">
            <center>
               <h4 style="color:green">${smsg}</h4>
            </center>
            <center>
               <h4 style="color:red">${emsg}</h4>
            </center>
            <c:if test="${smsg==null}" >
               <form:form  name="AddRoleform" method="post" action="load-processbranchform"  modelAttribute="categorylistvalue" >
                  <TABLE width="100%" style="padding: 6px">
                     <TR>
                        <TD width="5%">&nbsp;</TD>
                        <TD width="90%" align="left">
                           <c:if test="${buttonid eq 0}">
                              <center>
                                 <h4 style="color:red">You don't have any branches available to update</h4>
                              </center>
                           </c:if>
                           <TABLE id="editbranch" class="display" cellspacing="0" width="100%">
                              <thead>
                                 <c:if test="${buttonid eq 1}">
                                    <TR>
                                       <TH >No</TH>
                                       <TH style="text-align: center;">State-ID</TH>
                                       <TH style="text-align: left;">Location</TH>
                                       <TH style="text-align: center;">Branch-ID</TH>
                                       <TH style="text-align: center;">&nbsp;&nbsp;&nbsp;Branch  </TH>
                                       <TH >Select All<input type="checkbox" id="selectalllocations" value="0" onclick="selectAllLocations();" style="margin-left:5px;"> </TH>
                                    </TR>
                                 </c:if>
                              </thead>
                              <tbody>
                                 <c:forEach items="${categorylistvalue.categorylist}" var="editdetails" varStatus="loop">
                                    <TR>
                                       <TD align="center"> ${loop.index+1}  </TD>
                                       <TD align="left">
                                          ${editdetails.stateid} 
                                          <form:hidden  path="categorylist[${loop.index}].hiddenstateid" value="${editdetails.stateid}"/>
                                       </TD>
                                       <TD align="left">
                                          ${editdetails.locationid} 
                                          <form:hidden  path="categorylist[${loop.index}].hiddenlocationname" value="${editdetails.location}"/>
                                       </TD>
                                       <TD align="center"> ${editdetails.branchid}  </TD>
                                       <TD style="padding: 10px" align="center">
                                          <form:input path="categorylist[${loop.index}].branchcheckname" name="category" value="${editdetails.branch}" class="form-control" placeholder="Enter branch"  style="width:100%;margin-left:10px;" onKeyPress="return ValidateAlpha(event);" maxlength="60"/>
                                          <span style="display: none">${editdetails.branch}</span>
                                       </TD>
                                       <TD style="padding: 6px">
                                          <form:checkbox path="categorylist[${loop.index}].branch" id="selectloc${loop.index}"  value="${editdetails.branchid}" style="margin-left:78px;"/>
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
                        <TD colspan="5" align="center">
                           <c:if test="${buttonid eq 1}">
                              <button class="btn-primary" style="background-color: #00a3cc;color:white;" id="popup" onclick="return finish_div_show();"> UPDATE</button>
                           </c:if>
                        </TD>
                     </TR>
                  </TABLE>
                  <script type="text/javascript">
                     $(document).ready(function() {
                         $('#editbranch').DataTable( {
                             
                         } );
                     } ); 
                     
                  </script>	
                  <div id="finishabc" style="overflow:hidden;">
                     <div id="popupContact" >
                        <div class="panel" style="width: 100%; background-color: #117584;">
                           <div class="panel-heading"  style="font-size: 18px;font-weight: bold; color: #ffffff;">Modify Branch</div>
                        </div>
                        <table width="100%" height="65%">
                           <tr>
                              <td valign="middle" align="center" colspan="2" style="font-weight: bold; color: #00004d;"> Do you want to modify Branch? </td>
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
            </c:if>
         </div>
      </div>
      <center>
         <div style="width: 10%;float:right;background-color: #ffffff"> </div>
      </center>
      <%@include file="adminfooter.jsp" %>
   </body>
</html>