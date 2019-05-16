<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <%@include file="DisplayLogo.jsp" %>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>Electus Educare</title>
      <%@include file="adminDataTable.jsp" %>
      <script type="text/javascript">
         function enabletextboxes(checkboxid, topicname, subtopicname){
         	var checkboxid = document.getElementById(checkboxid);
         	if(checkboxid.checked==true){
         		document.getElementById(topicname).disabled=false;
         		document.getElementById(subtopicname).disabled=false;
         	}
         	else{
         		document.getElementById(topicname).disabled=true;
         		document.getElementById(subtopicname).disabled=true;
         	}
         }
         
         var validData = true;
         
         window.onload = function () {
         	whitespaceValidation(textvalue);
         }
         function whitespaceValidation(textvalue){
         	
         	var len =textvalue.replace(/\s+$/, '');
             if(len==''){
             	alert('Topic / Sub Tocpics should not be empty');
             	validData = false;
             	return false;
             }
             else{
             	validData = true;
             }
         	
         	}
         
         function formValidation(){
         	if(validData==false){
         		alert('Topic / Sub Tocpics should not be empty');
             	return false;
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
            <li class="active"><a href="load-subtopicFilter">ADD / MODIFY Topics </a></li>
         </ul>
         <div class="panel-heading" style="background-color:#ccf2ff;color:black; font-weight: bold;">
            <a href="load-subtopicFilter"> 
            <img border="0" alt="Add/Modify Topics" src="${pageContext.request.contextPath}/theme/images/addicon.jpg" width="40" height="40" > </a>
         </div>
         <label style="font-size:small;color: red; ">Note</label><label style="font-size:small;color: navy; ">:Subjects,Classes,Exam Types should be available to add Topics/Sub Topics</label>
         <div class="col-sm-12" style="border: 0px solid grey; margin-left:0px; padding: 0.50em; width: 100%;background-color:#DFE2DB;  overflow-x:scroll;">
            <center>
               <h4 style="color:green">${smsg}</h4>
            </center>
            <center>
               <h4 style="color:red">${emsg}</h4>
            </center>
            <c:if test="${smsg==null}" >
               <form:form modelAttribute="questiontopics"  method="GET" action="update-insert-topicssubtopics">
                  <table id="example" class="display" cellspacing="0" width="100%">
                     <thead>
                        <tr>
                           <TH>&nbsp;</TH>
                           <TH> E.Type </TH>
                           <TH> Class </TH>
                           <TH> Subject </TH>
                           <TH> Topic# </TH>
                           <TH> Topic </TH>
                           <TH> Sub Topic# </TH>
                           <TH> Sub Topic </TH>
                        </tr>
                     </thead>
                     <c:forEach items="${questiontopics.list}" var="qntopics" varStatus="loop">
                        <tr>
                           <td>
                              <form:checkbox path="list[${loop.index}].topiccheckbox" id="list[${loop.index}].topiccheckbox"  value="${qntopics.classid},${qntopics.subjecttypeid},${qntopics.topicid},${qntopics.subtopicid},${qntopics.examtypeid}" onclick="enabletextboxes(this.id, 'list[${loop.index}].topicname', 'list[${loop.index}].subtopicname');" />
                           </td>
                           <td> ${qntopics.examtype} </td>
                           <td> ${qntopics.classname} </td>
                           <td> ${qntopics.subjectname} </td>
                           <td> ${qntopics.topicid} </td>
                           <td>
                              <form:input path="list[${loop.index}].topicname" id="list[${loop.index}].topicname" pattern="^[a-zA-Z0-9\\-\\s]+$" title="special characters will not allow" value="${qntopics.topicname}" disabled="true" onkeyup="return whitespaceValidation(this.value);"/>
                              <span style="display: none"> ${qntopics.topicname} </span>
                           </td>
                           <td> ${qntopics.subtopicid} </td>
                           <td>
                              <form:input path="list[${loop.index}].subtopicname" id="list[${loop.index}].subtopicname" pattern="^[a-zA-Z0-9\\-\\s]+$" title="special characters will not allow" value="${qntopics.subtopicname}" disabled="true" onkeyup="return whitespaceValidation(this.value);"/>
                              <span style="display: none"> ${qntopics.subtopicname} </span>
                           </td>
                        </tr>
                     </c:forEach>
                     <tbody>
                     </tbody>
                  </table>
                  <center> <button class="btn-primary" style="background-color: #00a3cc;color:white;" id="popup" onclick="return formValidation();"> UPDATE </button> </center>
               </form:form>
            </c:if>
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