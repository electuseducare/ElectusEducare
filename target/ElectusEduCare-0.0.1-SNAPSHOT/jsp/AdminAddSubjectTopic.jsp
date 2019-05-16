<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <%@include file="DisplayLogo.jsp" %>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>Add Subject Topics</title>
      <%@include file="AdminModuleValidations.jsp" %>
      <script type="text/javascript">
         var getsubjectsFromClass = function(classid){
         	var classid = document.getElementById(classid).value;
             $.ajax({
                     url : "load-subjectsforclass?classid="+classid,
                     type: "POST",
                     dataType: 'text',
                     success : 
                     function(data) {
                        	document.getElementById("subject").innerHTML=data;
                  }    	
             });
         }
         
         var getTopicsFromClassSubject = function(subjectid){
         	var classid = document.getElementById("classname").value;
         	var subjectid = document.getElementById(subjectid).value;
             $.ajax({
                     url : "load-topicsforSubjects?classid="+classid+"&subjectid="+subjectid,
                     type: "POST",
                     dataType: 'text',
                     success : 
                     function(data) {
                        	document.getElementById("topicnames").innerHTML=data;
                  }    	
             });
         }
         
         function displaytopicnametextBox(topicid){
         	var topicid = document.getElementById(topicid).value;
         	var topicname = document.getElementById("topicnamediv");
         	if(topicid!=0){
         		topicname.style.display='block';
         	}
         	if(topicid==0){
         		topicname.style.display='none';
         	}
         }
         
         window.onload = function () {
         	var errormsg = document.getElementById("errormsg").value;
         	 document.getElementById("subject").innerHTML="	<option value='0'  >--Select--</option>";
         	 document.getElementById("topicnames").innerHTML="	<option value='0'  >--Select--</option>";
         	if((errormsg!='null') || (errormsg!==null)){
         		document.getElementById("classname").value="0";
         		
         	}
         }
         
      </script>
   </head>
   <body>
      <%@include file="adminUserTopMenu.jsp" %>
      <%@include file="adminUserHeader.jsp" %>
      <div class="row"> </div>
      <div style="width:22%; float:left; background-color: #ffffff;"><%@include file="AdminDashboardLeftMenu.jsp" %></div>
      <div style="width:65%; float:left; background-color: #ffffff">
         <ul class="nav nav-tabs">
            <li class="active" ><a href="#" >ADD SUBJECT TOPICS</a></li>
            <li ><a href="load-addsubjectsubtopic" >ADD SUBJECT SUB TOPICS</a></li>
            <li ><a href="load-editsubjecttopic" >MODIFY SUBJECT TOPICS</a></li>
            <li ><a href="load-editsubjectsubtopic" >MODIFY SUBJECT SUB TOPICS</a></li>
            <li ><a href="load-deletesubjecttopic" >DELETE SUBJECT TOPICS</a></li>
            <li ><a href="load-deletesubjectsubtopic" >DELETE SUBJECT SUB TOPICS</a></li>
         </ul>
         <div class="panel-heading" style="background-color:#ccf2ff;color:black; font-weight: bold;">
            <a href="load-addsubjecttopic">
            <img border="0" alt="W3Schools" src="${pageContext.request.contextPath}/theme/images/addicon.jpg" width="40" height="40" style="background-color: skyblue;">
            </a>
         </div>
         <div class="panel-body" id="mockTabs" style="background-color:#DFE2DB;">
            <form:form  method="post" action="insert-subjecttopiclist"  modelAttribute="SubjectTopicForm" >
               <center>
                  <h4 style="color: green">${smsg}</h4>
                  <input type="hidden" id="errormsg" value="${emsg}">
                  <h4  style="color: red">${emsg}</h4>
               </center>
               <c:if test="${smsg==null}" >
                  <div class="col-md-12 col-sm-12" id="classnamediv">
                     <label>Class :*</label>
                     <form:select path="classname" id="classname" class="form-control"  required="required" onchange="getsubjectsFromClass(this.id);">
                        <form:option value="0"  >--Select--</form:option>
                        <c:forEach  items="${classnames}" var="classname" >
                           <form:option value="${classname.categoryid}"  >${classname.category}</form:option>
                        </c:forEach>
                     </form:select>
                  </div>
                  <div class="col-md-12 col-sm-12" id="subjectdiv">
                     <label>Subject :*</label>
                     <form:select path="subjectname" id="subject" class="form-control" onchange="getTopicsFromClassSubject(this.id);">
                        <c:forEach items="${subject}" var="subject" >
                           <form:option value="${subject.subjectid}"  >${subject.subject}</form:option>
                        </c:forEach>
                     </form:select>
                  </div>
                  <div class="col-md-12 col-sm-12" id="topiiddiv">
                     <label>Topic Id :*</label>
                     <form:select path="topicnames" id="topicnames" class="form-control" onchange="displaytopicnametextBox(this.id)">
                        <c:forEach items="${topiclist}" var="topiclist" >
                           <form:option value="${topiclist.topicid}"  >${topiclist.topicid}</form:option>
                        </c:forEach>
                     </form:select>
                  </div>
                  <div class="col-md-12 col-sm-12" id="topicnamediv" style="display: none;">
                     <label>Topic Name :*</label>
                     <form:input path="topicnametext" id="topicnametext" class="form-control" onkeypress="return event.charCode >= 45 && event.charCode <= 57  && event.charCode != 46 && event.charCode != 77  && event.charCode = 32" maxlength="60"/>
                  </div>
                  <div class="row"></div>
                  <div class="col-md-12 col-sm-12" id="buttondiv">
                     <div class="col-md-5 col-sm-5" id="buttondiv"> &nbsp; </div>
                     <div class="col-md-6 col-sm-6" id="buttondiv">
                        <button class="btn-primary" style="background-color: #00a3cc;color:white;align-text:center;"> ADD TOPICS </button>
                     </div>
                  </div>
               </c:if>
            </form:form>
         </div>
      </div>
      <div style="width:13%; float:left; background-color: #ffffff">&nbsp;</div>
      <%@include file="adminfooter.jsp" %>
   </body>
</html>