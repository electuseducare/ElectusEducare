<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <%@include file="DisplayLogo.jsp" %>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title> Modify Access Roles </title>
      <%@include file="adminDataTable.jsp" %>
      <script type="text/javascript">
         var geteditusersfromtable = function(roleid){
         	var roleid = document.getElementById(roleid).value;
             $.ajax({
                     url : "load-editusernamesforRoles?roleid="+roleid,
                     type: "POST",
                     dataType: 'text',
                     success : 
                     function(data) {
                        	document.getElementById("username1").innerHTML=data;
                  }    	
             });
         }
         
         var geteditpermissionsfromtable = function(){
         	var roleid = document.getElementById("adminrnames").value;
         	var studentid = document.getElementById("username1").value;
             $.ajax({
                     url : "load-editpermissionsforRoles?roleid="+roleid+"&studentid="+studentid,
                     type: "POST",
                     dataType: 'json',
                     success : 
                     function(data) {
                     	var content="";
                     	 var content1="";
                        	$.each(data,function(i,val){
                        	
                     		$.each(val,function(key,value1){
                                 if(key=="permissiondesc"){
                                 	
                         		 content+=value1;
                                 	content+="<br>"
                         	
                                 }
                                 else if(key=="permissionid")
                                 	{
                                 	content+= '<input type="checkbox"  name="permssvalues1" id="'+value1+'" value="'+value1+'" onclick="displayModifyBtn(this.id);"/>' ;
                                 	
                                 	
                                 	
                                 	}
                             
                     			});
                     	});
                        	document.getElementById("permssionchk").innerHTML=content;
                    
                     }
             });
         }
         
         function displayModifyBtn(permids){
         	if(document.getElementById(permids).checked==true){
         		document.getElementById("modifybtns").disabled = false;
         	}
         	
         	if(document.getElementById("adminrnames").value =="0"){
         		document.getElementById("modifybtns").disabled = true;
         	}
         	if(document.getElementById("username1").value =="0"){
         		document.getElementById("modifybtns").disabled = true;
         	}
         	if(document.getElementById(permids).checked==true){
         		document.getElementById("modifybtns").disabled = false;
         	}
         }
         
         function selectonemodifybtndisabled(stids){
         	if(document.getElementById(stids).value=="0"){
         		document.getElementById("modifybtns").disabled = true;	
         	}
         }
         
         function selectoneumodifybtndisabled(rtids){
         	if(document.getElementById(rtids).value=="0"){
         		document.getElementById("modifybtns").disabled = true;	
         	}
         	if(document.getElementById("username1").value =="0"){
         		document.getElementById("modifybtns").disabled = true;
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
      <body>
         <%@include file="adminUserTopMenu.jsp" %>
         <%@include file="adminUserHeader.jsp" %>
         <!-- start header -->
         <div class="row"> </div>
         <div style="width:22%; float:left; background-color: #ffffff;"><%@include file="AdminDashboardLeftMenu.jsp" %></div>
         <div style="width:70%; float:left; background-color: #ffffff">
            <ul class="nav nav-tabs">
               <li ><a href="load-addaccessforRolese">ADD</a></li>
               <li class="active"><a href="#">DELETE</a></li>
            </ul>
            <div class="panel panel-primary">
               <div class="panel-heading" style="background-color:#ccf2ff; font-weight: bold;color:black; font-weight: bold;">
                  <a href="load-editaccessforRolese"> 
                  <img border="0" alt="W3Schools" src="${pageContext.request.contextPath}/theme/images/delete.jpg" width="40" height="40" > </a>
               </div>
               <div class="panel-body"  style="background-color:#E4E4E4;color:black; ">
                  <center>
                     <h4 style="color:green">${smsg}</h4>
                  </center>
                  <center>
                     <h4 style="color:red">${emsg}</h4>
                  </center>
                  <c:if test="${smsg==null}" >
                     <form:form modelAttribute="editaccessroles"  action="edit-accessforRoles">
                        <div class="row"></div>
                        <TABLE width="100%" style="padding: 6px">
                           <TR>
                              <TD width="25%">&nbsp;</TD>
                              <TD width="50%" align="left">
                                 <TABLE width="100%">
                                    <TR>
                                       <TD colspan="2">
                                          <label for="adminrnames" class="col-sm-4 control-label" style="float: left;"> Select Roles<span style="color: red;">*</span> </label>
                                          <div class="col-sm-12">
                                             <form:select path="adminrnames" id="adminrnames" class="form-control" onchange="geteditusersfromtable(this.id); selectoneumodifybtndisabled(this.id);">
                                                <form:option value="0"  >Select One</form:option>
                                                <c:forEach items="${roledesc}" var="accessroles" >
                                                   <c:if test="${accessroles.adminrid!=1}">
                                                      <form:option value="${accessroles.adminrid}">${accessroles.adminrnames}</form:option>
                                                   </c:if>
                                                </c:forEach>
                                             </form:select>
                                          </div>
                                       </TD>
                                    </TR>
                                    <TR>
                                       <TD colspan="2">
                                          <label for="usernames" class="col-sm-4 control-label" style="float: left;"> Select User<span style="color: red;">*</span> </label>
                                          <div class="col-sm-12">
                                             <form:select path="username" id="username1" class="form-control" onchange="geteditpermissionsfromtable(); selectonemodifybtndisabled(this.id);">
                                                <c:forEach items="${userdesc}" var="userrole" >
                                                   <form:option value="${userrole.studentid}"  >${userrole.username}</form:option>
                                                </c:forEach>
                                             </form:select>
                                          </div>
                                       </TD>
                                    </TR>
                                    <TR>
                                       <TD colspan="2">
                                          <label for="permissions" class="col-sm-6 control-label" style="float: left;"> Select Permissions<span style="color: red;">*</span> </label>
                                          <div class="col-sm-12" style="border: 1px solid grey; margin-left:12px; padding: 0.50em; width: 340px; height: 10em;  overflow-x:scroll;">
                                             <div id="permssionchk" class="col-sm-12" style="font-weight: bold;">   </div>
                                          </div>
                                       </TD>
                                    </TR>
                                    <TR>
                                       <TD>&nbsp; </TD>
                                    </TR>
                                    <TR>
                                       <TD colspan="2" align="center">
                                          <button  id = "modifybtns" class="btn-primary" style="background-color: #00a3cc;color:white;" disabled  onclick="return finish_div_show();">DELETE</button>
                                       </TD>
                                    </TR>
                                 </TABLE>
                              </TD>
                              <TD width="25%">&nbsp;</TD>
                           </TR>
                        </TABLE>
                        <div id="finishabc" style="overflow:hidden;">
                           <div id="popupContact" >
                              <div class="panel" style="width: 100%; background-color: #117584;">
                                 <div class="panel-heading"  style="font-size: 18px;font-weight: bold; color: #ffffff;">Delete Access Roles</div>
                              </div>
                              <table width="100%" height="65%">
                                 <tr>
                                    <td valign="middle" align="center" colspan="2" style="font-weight: bold; color: #00004d;"> Do you want to delete Access Roles? </td>
                                 </tr>
                                 <tr>
                                    <td valign="middle" align="center" colspan="2" style="font-weight: bold; color: #00004d;"> If 'YES' please click on Delete. If 'NO' click on Cancel. </td>
                                 </tr>
                                 <tr>
                                    <td align="left" width="50%" valign="bottom">  
                                       <button class="button btn-primary" style="margin-top:40px; margin-left:180px;background-color:#0E8DE2;color: white; font-weight: bold; " name="actionform" value="finishtest" onclick="stopFinishTestTime();"> DELETE </button>
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
         </div>
         <%@include file="adminfooter.jsp" %>
   </body>
</html>