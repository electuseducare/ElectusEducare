<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <%@include file="DisplayLogo.jsp" %>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title> Add Access Roles </title>
      <%@include file="adminDataTable.jsp" %>
      <script type="text/javascript">
         window.onload = function () {
         	 document.getElementById("username1").innerHTML="	<option value='0'  >--Select--</option>";
         	 document.getElementById("adminrnames1").value="0";
         }
         
         function getusersfromtable(roleid)
         {
         	 
         var xmlhttp;
         var roleid= document.getElementById(roleid).value;
         
         var urls="load-addusernamesforRoles?roleid="+roleid;
         
         if (window.XMLHttpRequest)
           {
           xmlhttp=new XMLHttpRequest();
           }
         else
           {
           xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
           }
         xmlhttp.onreadystatechange=function()
           {
           if (xmlhttp.readyState==4)
             {
           	
                 document.getElementById("username1").innerHTML=xmlhttp.responseText;
                
             }
          
           }
         xmlhttp.open("POST",urls,true);
         xmlhttp.send();
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
            <li class="active"><a href="#">ADD</a></li>
            <li ><a href="load-editaccessforRolese">DELETE</a></li>
         </ul>
         <div class="panel panel-primary">
            <div class="panel-heading" style="background-color:#ccf2ff; font-weight: bold;color:black; font-weight: bold;">
               <a href="load-addaccessforRolese"> 
               <img border="0" alt="W3Schools" src="${pageContext.request.contextPath}/theme/images/addicon.jpg" width="40" height="40" style="background-color: skyblue;">
               </a>
            </div>
            <div class="panel-body"  style="background-color:#E4E4E4;color:black; ">
               <center>
                  <h4 style="color:green">${smsg}</h4>
               </center>
               <center>
                  <h4 style="color:red">${emsg}</h4>
               </center>
               <c:if test="${smsg==null}" >
                  <form:form modelAttribute="accesusersroles"  action="add-accessforRoles">
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
                                          <form:select path="adminrnames" id="adminrnames1" class="form-control" onchange="getusersfromtable(this.id);">
                                             <form:option value="0"> -- Select -- </form:option>
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
                                          <form:select path="username" id="username1" class="form-control">
                                             <c:forEach items="${userdesc}" var="userrole" >
                                                <form:option value="${userrole.studentid}"  >${userrole.username}</form:option>
                                             </c:forEach>
                                          </form:select>
                                       </div>
                                    </TD>
                                 </TR>
                                 <TR>
                                    <TD colspan="2">
                                       <label for="usernames" class="col-sm-6 control-label" style="float: left;"> Select Permissions<span style="color: red;">*</span> </label>
                                       <div class="col-sm-12" style="border: 1px solid grey; margin-left:12px; padding: 0.50em; width: 340px; height: 10em;  overflow-x:scroll;">
                                          <c:forEach items="${permissiondesc}" var="permdisc" >
                                             <label>
                                                <form:checkbox path="permcheckbox" value="${permdisc.permissionid}"/>
                                                ${permdisc.permissiondesc} 
                                             </label>
                                             <br>
                                          </c:forEach>
                                       </div>
                                    </TD>
                                 </TR>
                                 <TR>
                                    <TD>&nbsp; </TD>
                                 </TR>
                                 <TR>
                                    <TD colspan="2" align="center">
                                       <button class="btn-primary" style="background-color: #00a3cc;color:white;">ADD</button>
                                    </TD>
                                 </TR>
                              </TABLE>
                           </TD>
                           <TD width="25%">&nbsp;</TD>
                        </TR>
                     </TABLE>
                  </form:form>
               </c:if>
            </div>
         </div>
      </div>
      <%@include file="adminfooter.jsp" %>
   </body>
</html>