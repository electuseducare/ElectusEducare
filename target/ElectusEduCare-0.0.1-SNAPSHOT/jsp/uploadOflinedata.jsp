<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <%@include file="DisplayLogo.jsp" %>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
      <link rel="stylesheet" href="${pageContext.request.contextPath}/theme/css/AdminCreateExamStyleSheet.css">
      <title>Insert title here</title>
      <style>
         /* css class for the registration form generated errors */
         .profilepress-reg-status {
         border-radius: 6px;
         font-size: 17px;
         line-height: 1.471;
         padding: 10px 19px;
         background-color: #e74c3c;
         color: black;
         font-weight: normal;
         display: block;
         text-align: center;
         vertical-align: middle;
         margin: 5px 0;
         }
         /*form styles*/
         #msform {
         width: 100%;
         margin: 50px auto 550px;
         text-align: center;
         position: relative;
         color: black;
         }
         #msform fieldset {
         background: white;
         border: 0 none;
         border-radius: 3px;
         box-shadow: 0 0 15px 1px rgba(0, 0, 0, 0.4);
         padding: 20px 30px;
         box-sizing: border-box;
         width: 80%;
         margin: 0 10%;
         color: black;
         /*stacking fieldsets above each other*/
         position: absolute;
         }
         /*Hide all except first fieldset*/
         #msform fieldset:not(:first-of-type) {
         display: none;
         }
         /*inputs*/
         /*buttons*/
         #msform .action-button {
         width: 100px;
         background: #27AE60;
         font-weight: bold;
         color: black;
         border: 0 none;
         border-radius: 1px;
         cursor: pointer;
         padding: 10px 5px;
         margin: 10px 5px;
         }
         #msform .action-button:hover,
         #msform .action-button:focus {
         box-shadow: 0 0 0 2px white, 0 0 0 3px #27AE60;
         }
         /*headings*/
         .fs-title {
         font-size: 15px;
         text-transform: uppercase;
         color: #2C3E50;
         margin-bottom: 10px;
         }
         .fs-subtitle {
         font-weight: normal;
         font-size: 13px;
         color: #666;
         margin-bottom: 20px;
         }
         /*progressbar*/
         #progressbar {
         margin-bottom: 30px;
         overflow: hidden;
         /*CSS counters to number the steps*/
         counter-reset: step;
         }
         #progressbar li {
         list-style-type: none;
         color: #616161;
         text-transform: uppercase;
         font-size: 9px;
         width: 33.33%;
         float: left;
         position: relative;
         }
         #progressbar li:before {
         content: counter(step);
         counter-increment: step;
         width: 20px;
         line-height: 20px;
         display: block;
         font-size: 15px;
         color: #333;
         background: white;
         border-radius: 3px;
         margin: 0 auto 5px auto;
         }
         #progressbar li:first-child:after {
         /*connector not needed before the first step*/
         content: none;
         }
         /*marking active/completed steps green*/
         /*The number of the step and the connector before it = green*/
         #progressbar li.active:before,
         #progressbar li.active:after {
         background: #27AE60;
         color: white;
         }
         .col1 {
         background-color: #fff;
         float: left;
         }
         .col2 {
         background-color: #fff;
         float: none;
         }
         .col3 {
         background-color: #fff;
         float: right;
         }
         label {
         color: black;
         }
         .button {
         display: block;
         height: 35px;
         background: #4E9CAF;
         padding: 10px;
         text-align: center;
         border-radius: 5px;
         color: white;
         font-weight: bold;
         }
         .loader {
         position: fixed;
         left: 0px;
         top: 0px;
         width: 100%;
         height: 100%;
         z-index: 9999;
         background: url('https://loading.io/assets/img/landing/curved-bars.svg')
         50% 50% no-repeat rgb(249, 249, 249);
         opacity: .8;
         }
      </style>
      <script type="text/javascript">
         var fileExtensions = true;
         function validateExtension() {
         	 var examname = document.getElementById('examname').value;
         		if(examname=='0'){
         			alert("Please select Examname from drop-down");
         			return false;
         		}
         
         		
         var allowedFiles = [".dat"];
         var fileUpload = document.getElementById("uploadBtn");
         var lblError = document.getElementById("lblError2");
         var pageerrormsg = document.getElementById("addloader");
         var regex = new RegExp("([a-zA-Z0-9\s_\\.\-:])+(" + allowedFiles.join('|') + ")$");
         if (!regex.test(fileUpload.value.toLowerCase())) {
            lblError.innerHTML = "Please upload files having extensions: <b>" + allowedFiles.join(', ') + "</b> only.";
            fileExtensions = false;
            return false;
         }else{
         
         lblError.innerHTML = "";
         fileExtensions = true;
         if((examname!='0')&&(fileExtensions==true)){
         	document.getElementById("addloader1").style.display='block';
         	pageerrormsg.innerHTML="Page Loading....";
             }
         return true;
         }
         
         
         
         }
         
      </script>
   </head>
   <body>
      <%@include file="adminUserTopMenu.jsp" %>
      <%@include file="adminUserHeader.jsp" %>
      <!-- =============================================== -->
      <div class="loader" style="display: none" id="addloader1"> </div>
      <div class="row"></div>
      <div style="width:22%; float:left; background-color: #ffffff;"><%@include file="AdminDashboardLeftMenu.jsp" %></div>
      <div style="width:70%; float:left; background-color: #ffffff;">
         <div class="panel panel-info">
            <div class="panel-heading">
               <center><b>Please upload scanned OMR sheets.</b></center>
            </div>
         </div>
         <div id="addloader"> </div>
         <div id="msform">
            <!-- progressbar -->
            <ul id="progressbar">
            </ul>
            <!-- fieldsets -->
            <fieldset>
               <h2 class="fs-title">Upload Offline Data</h2>
               <center>
                  <h4 style="color:green">${smsg}</h4>
               </center>
               <center>
                  <h4 style="color:red">${emsg}</h4>
               </center>
               <c:if test="${smsg==null}" >
                  <c:if test="${emsg==null}" >
                     <form:form  method="post" modelAttribute="dataval" enctype="multipart/form-data" action="processOmrData">
                        <div class="form-group">
                           <i class="fa fa-envelope prefix grey-text"></i>
                           <label for="defaultForm-pass">Select Exam Name :*</label>
                           <form:select path="examname" id="examname">
                              <form:option value="0"  >---Select One---</form:option>
                              <c:forEach  items="${enamelist}" var="enamelist" >
                                 <form:option value="${enamelist}"></form:option>
                              </c:forEach>
                           </form:select>
                        </div>
                        <div class="form-group">
                           <i class="fa fa-lock prefix grey-text"></i>
                           <label>Browse .dat File :* </label>
                           <input  id="uploadBtn" name="excelfile2007" type="file" style="margin-left: 230px;" >
                           <span id="lblError2" style="color: red;"></span>
                        </div>
                        <div class="col-sm-12" style="padding: 4px; float: left;">
                           <span style="float: left; "><a href="load-OfflineAnalysis"> Back to Offline Data </a></span>
                           <span style="float: right;"><input type="submit" value="SUBMIT DATA" class="btn-info" onclick="return validateExtension();"></span>
                        </div>
                     </form:form>
                  </c:if>
               </c:if>
            </fieldset>
         </div>
      </div>
      <center>
         <div style="width: 10%;float:right;background-color: #ffffff"> </div>
      </center>
      <%@include file="adminfooter.jsp" %>
   </body>
</html>