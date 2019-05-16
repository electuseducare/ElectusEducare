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
         
         
         
         function UpdateKey(qid,keyvalue)
         {
         	var existval=keyvalue;
         	var examnm=document.getElementById("examname").value;
         	if(keyvalue==''){
         		alert("Value can not be empty.");
         		document.getElementById("key_"+qid).value=existval;
         		return false;
         	}else{
           	  $.ajax({
                     url : "load-updateExamKeys?qid="+qid+"&&keyvalue="+keyvalue+"&&examname="+examnm,
                     type: "GET",
                     dataType: "text",
                     success : 
                     function(data) {
                                   }
           	
                });
         	}
         	}
         
         
         
         
         
         function formValidation(valu){
         	alert(valu);
         	
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
            <li class="active"><a href="load-updateKey" >Select Exam Name</a></li>
         </ul>
         <div class="panel-body" id="mockTabs" style="background-color:#DFE2DB;">
            <label style="text-align:center;">EXAM NAME : ${examname}</label>
            <center>
               <h4 style="color:green">${smsg}</h4>
            </center>
            <center>
               <h4 style="color:red">${emsg}</h4>
            </center>
            <c:if test="${smsg==null}" >
               <form:form  name="AddRoleform" method="post" action="load-editExamKey"  modelAttribute="ukm" >
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
                                 <TR>
                                    <TH >S.No</TH>
                                    <TH style="text-align: left;">File Name</TH>
                                    <TH style="text-align: left;">Questions</TH>
                                    <TH style="text-align: center;">Key</TH>
                                 </TR>
                              </thead>
                              <tbody>
                                 <c:forEach items="${keylst}" var="keylst" varStatus="loop">
                                    <TR>
                                       <TD align="center"> ${loop.index+1}  </TD>
                                       <TD align="center"> ${keylst.impfilename}  </TD>
                                       <TD align="center"> ${keylst.questions}  </TD>
                                       <TD style="padding: 10px" align="center">
                                          <form:input path="key" id="key__${keylst.quesid}" name="category" value="${keylst.key}" class="form-control" placeholder="Enter Key"   onKeyUp="return UpdateKey('${keylst.quesid}',this.value);" maxlength="60"/>
                                          <span style="display: none">  ${keylst.questions}</span>
                                       </TD>
                                       <form:hidden path="examname"/>
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
                           <div class="panel-heading"  style="font-size: 18px;font-weight: bold; color: #ffffff;">Modify Key</div>
                        </div>
                        <table width="100%" height="65%">
                           <tr>
                              <td valign="middle" align="center" colspan="2" style="font-weight: bold; color: #00004d;"> Do you want to modify Key? </td>
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