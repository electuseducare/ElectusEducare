<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <%@include file="DisplayLogo.jsp" %>
      <%@include file="adminDataTable.jsp" %>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
      <script src="${pageContext.request.contextPath}/theme/js/AdminOfflineAjaxScripts.js"></script>
      <script src="${pageContext.request.contextPath}/theme/js/AdminOfflineFormValidations.js"></script>
      <link rel="stylesheet" href="${pageContext.request.contextPath}/theme/css/AdminCreateExamStyleSheet.css">
      <title>Electus Educare</title>
   </head>
   <style>
      .center {
      padding: 40px 0;
      padding-right:15px;
      text-align: center;
      }
      .center img{
      width: 100px;
      height: 100px;
      }
   </style>
   <script type="text/javascript">
      var examnameexists = null;
      function validExamnameexists(){
      	var examnamevalue = document.getElementById('examname').value;
      	var urls="verify-examnamealreadyExistsforofflinekey?examnamevalue="+examnamevalue;
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
          	 examnameexists = xmlhttp.responseText;
          	 if(xmlhttp.responseText=="Exam name already exists. Please try with other name"){
                	 document.getElementById("examerror").innerHTML=xmlhttp.responseText;
                	 document.getElementById("examvalid").innerHTML="";
          	 }
          	 else{
          		 document.getElementById("examvalid").innerHTML=xmlhttp.responseText;
          		 document.getElementById("examerror").innerHTML="";
          	 }
            }
         
          }
        xmlhttp.open("POST",urls,true);
        xmlhttp.send();
        }
      
      
      var fileExtensions = true;
      function validateExtension() {
      
      	 /** Exam name is Empty */
      	  var examnamemodel = document.getElementById('examnamemodel');
      	  var examname = document.getElementById('examname').value;
      	  if((examname.length==0)||(examname=="")||(examname==" ")||(examname==null)){
      	  	examnamemodel.style.display = "block";
      	  	return false;
      	  }
      
      	  /** Exam name is already exists */
      	  var examnameexistmodel = document.getElementById('examnameexistmodel');
      	  if (examnameexists=="Exam name already exists. Please try with other name"){
      	  	examnameexistmodel.style.display = "block";
      	  	return false;
      	  }
      
      	  /** Exam type is Empty */
      	  var examtypemodel = document.getElementById('examtypemodel');
      	  var examtypeselectbox = document.getElementById('examtypeselectbox').value; 
      	  if(examtypeselectbox=="0"){
      	  	examtypemodel.style.display = "block";
      	  	return false;
      	  }
      
      	  var classmodel = document.getElementById('classmodel');
      	  var classselect = document.getElementById('classselect').value; 
      	  if(classselect=="0"){
      	  	classmodel.style.display = "block";
      	  	return false;
      	  }
      
      	  var totalquestions = document.getElementById('totalquestions').value; 
      	  if((totalquestions=="0")||(totalquestions==null)||(totalquestions.length<=0)){
      		  	alert("Please enter number of questions available to submit key.");
      		  	document.getElementById('totalquestions').focus();
      		  	return false;
      		  }
      
      	
      var allowedFiles = [".xlsx"];
      var fileUpload = document.getElementById("uploadBtn");
      var lblError = document.getElementById("lblError2");
      var regex = new RegExp("([a-zA-Z0-9\s_\\.\-:])+(" + allowedFiles.join('|') + ")$");
      if (!regex.test(fileUpload.value.toLowerCase())) {
         lblError.innerHTML = "Please upload files having extensions: <b>" + allowedFiles.join(', ') + "</b> only.";
         fileExtensions = false;
         return false;
      }else{
      
      lblError.innerHTML = "";
      fileExtensions = true;
      return true;
      }
      }
      
   </script>
   <body>
      <%@include file="adminUserTopMenu.jsp" %>
      <%@include file="adminUserHeader.jsp" %>
      <%@include file="AdminCreateExamModelWindows.jsp" %>
      <!-- start header -->
      <div class="row"> </div>
      <div style="width:22%; float:left; background-color: #ffffff;">
         <%@include file="AdminDashboardLeftMenu.jsp" %>
      </div>
      <div style="width:70%; float:left; background-color: #ffffff">
         <div class="panel-heading" style="background-color:#ccf2ff;color:black; font-weight: bold;">
            <a href="load-uploadKeyFilebyexcel"><img border="0" alt="" src="${pageContext.request.contextPath}/theme/images/addicon.jpg" width="40" height="40" style="background-color: skyblue;"></a>
            Upload Key File From Excel Sheet
            <span style="float: right;"><a href="load-uploadKeyFileBySystemOrExcel "> Back to Select Key Option </a></span>
         </div>
         <div class="row"></div>
         <form:form  method="post" modelAttribute="keyval" enctype="multipart/form-data" action="processExcelKeyData">
            <TR>
               <TD>
                  <h5 style="color: red">  Note: </h5>
                  <ul>
                     <li>* Please do not close this window or click on the Back / Refresh button on your browser when upload is processing.</li>
                     <li>* Please use the below id value in place of name in excel.</li>
                     <li>* In download format excel please delete the <span style="color:red"><b>"First Row"</b></span> in excel.</li>
                     <li>* Please download the .xlsx format to upload data: <a href="loadKeyFilebyexcel" class="btn-primary">Download Format</a>
                     </li>
                  </ul>
               </TD>
            </TR>
            <div id="examerror" class="col-sm-20" style="color: red;"></div>
            <div id="examvalid" class="col-sm-20" style="color: green;"></div>
            <div class="col-sm-12" style="padding: 4px; float: left;">
               <label style="float: left;;">ExamName :*</label>
               <form:input path="examname" id="examname" class="form-control" placecholder="Exam Name" autocomplete="off" onkeyup="validExamnameexists();"/>
            </div>
            <div class="col-sm-12" style="padding: 4px; float: left;">
               <label style="float: left;;">Exam Type :*</label>
               <form:select path="examtypeselectbox" id="examtypeselectbox" class="form-control"  required="required" >
                  <c:forEach  items="${examtypeslist}" var="examtypeslist" >
                     <form:option value="${examtypeslist.examtypeid}"  >${examtypeslist.examtype}</form:option>
                  </c:forEach>
               </form:select>
            </div>
            <div class="col-sm-12" style="padding: 4px; float: left;">
               <label for="status"  style="float: left;">Class :*</label>
               <form:select path="classname" id="classselect" class="form-control"  required="required" >
                  <form:option value="0"  >--Select--</form:option>
                  <c:forEach  items="${classnames}" var="classname" >
                     <form:option value="${classname.categoryid}"  >${classname.category}</form:option>
                  </c:forEach>
               </form:select>
            </div>
            <div class="col-sm-12" style="padding: 4px; float: left;">
               <label for="totalmarks" >  Total Questions :  </label>
               <form:input class="form-control"  path="totalquestions" id="totalquestions"  />
            </div>
            <div class="col-sm-12" style="padding: 4px; text-align: center;">
               <label style="float: left;">File Path:*</label>
               <input class="inputfile"  id="uploadBtn" name="excelfile2007" type="file" accept=".xlsx">
            </div>
            <div class="col-sm-12" style="padding: 4px; float: left;">
               <label id="lblError2" style="text-align: center; color: red; font-weight: bold"></label>
            </div>
            <div class="col-sm-12" style="padding: 4px; float: left; text-align: center;">
               <input type="submit" name="submit" class="btn-primary" value="Submit Key" onclick="return validateExtension();"/>
            </div>
         </form:form>
         <div class="row"></div>
         <div class="panel-heading" style="background-color:#ccf2ff;color:black; font-weight: bold; height: 40px;">
            <span style="float: left;"> CLASS - SUBJECT DETAILS </span>
            <span style="float: right;"> QUESTION TYPE - ID DETAILS </span>
         </div>
         <div class="row"></div>
         <TABLE width="100%" style="padding: 6px">
            <TR>
               <TD width="50%" align="left">
                  <TABLE id="editsubject" class="display" cellspacing="0" width="100%">
                     <thead>
                        <TR>
                           <TH style="text-align: center;">No</TH>
                           <TH style="">Class</TH>
                           <TH style="text-align: center;">Subject #</TH>
                           <TH style="">Subject</TH>
                        </TR>
                     </thead>
                     <tbody>
                        <c:forEach items="${classsubjlist}" var="editdetails" varStatus="loop">
                           <TR>
                              <TD align="center"> ${loop.index+1}  </TD>
                              <TD align="left">${editdetails.categoryname}  
                              <TD align="center">${editdetails.subjectid}</TD>
                              <TD >${editdetails.subject}</TD>
                           </TR>
                        </c:forEach>
                     </tbody>
                  </TABLE>
               </TD>
               <TD width="5%" align="left"> &nbsp; </TD>
               <TD width="45%" align="left">
                  <TABLE id="questiontype" class="display" cellspacing="0" width="100%">
                     <thead align="center">
                        <TR >
                           <TH style="text-align: center;"> No </TH>
                           <TH >Question Types </TH>
                           <TH style="text-align: center;">Q.Type # </TH>
                        </TR>
                     </thead>
                     <tbody>
                        <c:forEach items="${qtypelist}" var="editdetails" varStatus="loop">
                           <TR>
                              <TD align="center"> ${loop.index+1}  </TD>
                              <TD > 
                                 <span >${editdetails.questiontype}</span>
                              </TD>
                              <TD align="center"> ${editdetails.questiontypeid}  </TD>
                           </TR>
                        </c:forEach>
                     </tbody>
                  </TABLE>
               </TD>
            </TR>
         </TABLE>
      </div>
      <center>
         <div style="width: 10%;float:right;background-color: #ffffff"> </div>
      </center>
      <%@include file="adminfooter.jsp" %>
      <script type="text/javascript">
         $(document).ready(function() {
             $('#editsubject').DataTable( {
             	 "bInfo": false 
             } );
         } ); 
         
         $(document).ready(function() {
             $('#questiontype').DataTable( {
             	 "bInfo": false 
             } );
         } ); 
         
      </script>
   </body>
</html>