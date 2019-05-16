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
      <!-- start header -->
      <div class="row"> </div>
      <div style="width:22%; float:left; background-color: #ffffff;"><%@include file="AdminDashboardLeftMenu.jsp" %></div>
      <div style="width:70%; float:left; background-color: #ffffff">
         <ul class="nav nav-tabs">
            <li class="active"><a href="#" >QUESTIONTYPES</a></li>
         </ul>
         <div class="panel-heading" style="background-color:#ccf2ff;color:black; font-weight: bold;"><img border="0" alt="W3Schools" src="${pageContext.request.contextPath}/theme/images/edit.jpg" width="40" height="40" ></div>
         <div class="panel-body" id="mockTabs" style="background-color:#DFE2DB;">
            <center>
               <h4 style="color:green">${smsg}</h4>
            </center>
            <center>
               <h4 style="color:red">${emsg}</h4>
            </center>
            <c:if test="${smsg==null}" >
               <form:form  name="AddRoleform" method="post" action="load-processquestiontypeform"  modelAttribute="categorylistvalue" >
                  <TABLE width="100%" style="padding: 6px">
                     <TR>
                        <TD width="20%">&nbsp;</TD>
                        <TD width="60%" align="center">
                           <TABLE id="questiontype" class="display" cellspacing="0" width="100%">
                              <thead align="center">
                                 <TR align="center">
                                    <TH align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;No</TH>
                                    <TH style="text-align: center;">&nbsp;&nbsp;&nbsp;Question Types </TH>
                                 </TR>
                              </thead>
                              <tbody>
                                 <c:forEach items="${categorylistvalue.questionlistform}" var="editdetails" varStatus="loop">
                                    <TR>
                                       <TD align="center"> ${loop.index+1}  </TD>
                                       <TD style="padding: 10px" align="left"> 
                                          <span >${editdetails.questiontype}</span>
                                       </TD>
                                    </TR>
                                 </c:forEach>
                              </tbody>
                           </TABLE>
                        </TD>
                        <TD width="20%">&nbsp;</TD>
                     </TR>
                     <TR>
                        <TD> &nbsp; </TD>
                     </TR>
                     <TR>
                        <TD colspan="2" align="center">
                        </TD>
                     </TR>
                  </TABLE>
                  <script type="text/javascript">
                     $(document).ready(function() {
                         $('#questiontype').DataTable( {
                             
                         } );
                     } ); 
                     
                  </script>
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