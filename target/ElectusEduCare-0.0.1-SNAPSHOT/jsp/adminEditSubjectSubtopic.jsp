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
      <script src="${pageContext.request.contextPath}/theme/js/AdminFieldEmptyValidation.js"></script>
      <style>
         /*----------------------------------------------
         CSS settings for HTML div Exact Center
         ------------------------------------------------*/
         #finishabc {
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
         div#popupContact {
         position:absolute;
         left:50%;
         width:50%;
         height:30%;
         top:35%;
         margin-left:-202px;
         -moz-box-shadow: 20px 20px 20px 20px #888;
         -webkit-box-shadow: 20px 20px 20px 20px#888;
         box-shadow: 20px 20px 10px #888888;
         font-family:'Raleway',sans-serif;
         background-color: #e6f7ff;
         }
      </style>
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
                     url : "load-topicsforSubject?classid="+classid+"&subjectid="+subjectid,
                     type: "POST",
                     dataType: 'text',
                     success : 
                     function(data) {
                        	document.getElementById("topicnames").innerHTML=data;
                  }    	
             });
         }
         
         var getSubtopicsFromClassSubject = function(topicid){
         	
         	var classid = document.getElementById("classname").value;
         	var subjectid = document.getElementById("subject").value;
         	var topicid = document.getElementById(topicid).value;
         	//alert(topicid);
             $.ajax({
                     url : "load-subtopicsforSubject1?classid="+classid+"&subjectid="+subjectid+"&topicid="+topicid,
                     type: "POST",
                     dataType: 'text',
                     success : 
                     function(data) {
                        	document.getElementById("subtopicnames").innerHTML=data;
                  }    	
             });
         }
         
         
         
         
         
         function displaytopicnametextBox(subtopicid){
         	var topicid = document.getElementById(subtopicid).value;
         	var topicname = document.getElementById("subtopicnamediv");
         	if(topicid!=0){
         		topicname.style.display='block';
         	}
         	if(topicid==0){
         		topicname.style.display='none';
         	}
         	
         }
         
         var getSubTopicNamesforEdit = function(subtopicnames){
         	var topicid = document.getElementById("topicnames").value;
         	var subtopicid = document.getElementById(subtopicnames).value;
         
         	
             $.ajax({
                     url : "load-subtopicnamefromtopics?topicid="+topicid+"&subtopicid="+subtopicid,
                     type: "GET",
                     dataType: 'json',
                     success : 
                     function(data) {
                     	var content="";
                     	$.each(data,function(i,val){
                     		$.each(val,function(key,value1){
                     			//alert("key: "+key);	
                                 if(key=="subject_subtopic_type"){
                                 
                         		    content=value1;
                             
                     	   // document.getElementById("topicnametext1").innerHTML='<input type="text" id="topicajaxval" value="'+content+'">';
                     	    document.getElementById("subtopicnametext").value = content;
                                 }
                     		});
                     	});
                  }    	
             });
         }
         
         window.onload = function () {
         	var errormsg = document.getElementById("errormsg").value;
         	 document.getElementById("subject").innerHTML="	<option value='0'  >--Select--</option>";
         	 document.getElementById("topicnames").innerHTML="	<option value='0'  >--Select--</option>";
         	 document.getElementById("subtopicnames").innerHTML="	<option value='0'  >--Select--</option>";
         	 
         	 if((errormsg!='null') || (errormsg!==null)){
         		document.getElementById("classname").value="0";
         		
         	}
         }
         
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
      <div class="row"> </div>
      <div style="width:22%; float:left; background-color: #ffffff;"><%@include file="AdminDashboardLeftMenu.jsp" %></div>
      <div style="width:65%; float:left; background-color: #ffffff">
         <ul class="nav nav-tabs">
            <li  ><a href="load-addsubjecttopic" >ADD SUBJECT TOPICS</a></li>
            <li ><a href="load-addsubjectsubtopic" >ADD SUBJECT SUB TOPICS</a></li>
            <li ><a href="load-editsubjecttopic" >MODIFY SUBJECT TOPICS</a></li>
            <li class="active" ><a href="#" >MODIFY SUBJECT SUB TOPICS</a></li>
            <li ><a href="load-deletesubjecttopic" >DELETE SUBJECT TOPICS</a></li>
            <li ><a href="load-deletesubjectsubtopic" >DELETE SUBJECT SUB TOPICS</a></li>
         </ul>
         <div class="panel-heading" style="background-color:#ccf2ff;color:black; font-weight: bold;">
            <a href="load-editsubjectsubtopic">
            <img border="0" alt="W3Schools" src="${pageContext.request.contextPath}/theme/images/edit.jpg" width="40" height="40" style="background-color: skyblue;">
            </a>
         </div>
         <div class="panel-body" id="mockTabs" style="background-color:#DFE2DB;">
            <form:form  method="post" action="update-subjectsubtopiclist"  modelAttribute="SubjectTopicForm" >
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
                     <form:select path="topicnames" id="topicnames" class="form-control" onchange="getSubtopicsFromClassSubject(this.id)">
                        <c:forEach items="${topicnames}" var="topiclist" >
                           <form:option value="${topiclist.topicid}"  >${topiclist.topicid}</form:option>
                        </c:forEach>
                     </form:select>
                  </div>
                  <div class="col-md-12 col-sm-12" id="topiiddiv">
                     <label>Sub-Topic Id :*</label>
                     <form:select path="subtopicnames" id="subtopicnames" class="form-control" onchange="displaytopicnametextBox(this.id);getSubTopicNamesforEdit(this.id);">
                        <c:forEach items="${subtopicnames}" var="subtopiclist" >
                           <form:option value="${subtopiclist.subtopicid}"  >${subtopiclist.subtopicid}</form:option>
                        </c:forEach>
                     </form:select>
                  </div>
                  <div class="col-md-12 col-sm-12" id="subtopicnamediv" style="display: none;">
                     <label>Sub-Topic Name :*</label>
                     <form:input path="subtopicnametext" id="subtopicnametext" class="form-control" onkeypress="return event.charCode >= 45 && event.charCode <= 57  && event.charCode != 46 && event.charCode != 77  && event.charCode = 32" maxlength="60"/>
                  </div>
                  <div class="row"></div>
                  <div class="col-md-12 col-sm-12" id="buttondiv">
                     <div class="col-md-5 col-sm-5" id="buttondiv"> &nbsp; </div>
                     <div class="col-md-6 col-sm-6" id="buttondiv">
                        <button class="btn-primary" style="background-color: #00a3cc;color:white;align-text:center;" id="popup" onclick="return finish_div_show();"> UPDATE</button>
                     </div>
                  </div>
                  <div id="finishabc" style="overflow:hidden;">
                     <div id="popupContact" >
                        <div class="panel" style="width: 100%; background-color: #117584;">
                           <div class="panel-heading"  style="font-size: 18px;font-weight: bold; color: #ffffff;">Modify Subject Sub-Topic</div>
                        </div>
                        <table width="100%" height="65%">
                           <tr>
                              <td valign="middle" align="center" colspan="2" style="font-weight: bold; color: #00004d;"> Do you want to modify Subject Sub-Topic? </td>
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
               </c:if>
            </form:form>
         </div>
      </div>
      <div style="width:13%; float:left; background-color: #ffffff">&nbsp;</div>
      <%@include file="adminfooter.jsp" %>
   </body>
</html>