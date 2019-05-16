<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
   <head>
      <%@include file="DisplayLogo.jsp" %>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <title>Welcome User</title>
      <style type="text/css">
         .inputfile  {
         font-size: 1.25em;
         font-weight: 700;
         color: white;
         background-color: black;
         display: inline-block;
         }
         .loader {
         position: fixed;
         left: 0px;
         top: 0px;
         width: 100%;
         height: 100%;
         z-index: 9999;
         background: url('https://loading.io/assets/img/landing/curved-bars.svg') 50% 50% no-repeat rgb(249,249,249);
         opacity: .8;
         }
      </style>
      <script>
         function whitespaceValidation(textvalue){
         	
         	var len =textvalue.replace(/\s+$/, '');
             if(len==''){
             	validData = false;
             	return false;
             }
             else{
             	validData = true;
             }
         	
         	}
         
         function formValidation(){
         	if(validData==false){
         		alert('Value should not be empty');
             	return false;
         	}
         }
         document.getElementById("uploadBtn").onchange = function () {
             document.getElementById("uploadFile").value = this.value;
         };
         
         
         
      </script>
   </head>
   <body>
      <%@include file="adminUserTopMenu.jsp" %>
      <%@include file="adminUserHeader.jsp" %>
      <!-- =============================================== -->
      <div class="loader" style="display: none" id="addloader1"> </div>
      <div class="row"></div>
      <div style="width:22%; float:left; background-color: #ffffff;"><%@include file="AdminDashboardLeftMenu.jsp" %></div>
      <div class="content-wrapper">
         <div class="panel-heading" style="background-color:#ccf2ff;color:black; font-weight: bold;"><a href="load-uploaddata"><img border="0" alt="W3Schools" src="${pageContext.request.contextPath}/theme/images/addicon.jpg" width="40" height="40" style="background-color: skyblue;"></a>
            Upload Student Records
         </div>
         <form:form action="excelupload" method="post" enctype="multipart/form-data">
            <div>
               <h5 style="color: red">  Note: </h5>
               <ul>
                  <li>* User name and Email Id should be unique.</li>
                  <li>* Please do not close this window or click on the Back / Refresh button on your browser when upload is processing.</li>
                  <li>* In download format excel please delete the "Student Records" header row.</li>
               </ul>
            </div>
            <div class="panel-body" id="mockTabs" style="background-color:#DFE2DB; height: 200px;">
               <div style="text-align: center;"><label style="color:green">${msg}</label> </div>
               <div style="text-align: center;">  <label style="color:red">${emsg}</label> </div>
               <c:if test="${msg==null}">
                  <table>
                     <tr>
                        <td colspan="2">Please download the .xlsx format to upload data: <a href="loadsampleBulkFile" class="btn-primary">Downloadable Format</a></td>
                     </tr>
                     <tr>
                        <td>
                           <div>&nbsp;</div>
                        </td>
                     </tr>
                     <tr>
                        <td colspan="2">
                           <div><span id="lblError2" style="color: red;"></span></div>
                        </td>
                     </tr>
                     <tr>
                        <td><input class="inputfile"  id="uploadBtn" name="excelfile2007" type="file" accept=".xlsx"> </td>
                        <td> <input type="submit" class="btn-primary" value="UPLOAD" onclick="return ValidateExtension()"> </td>
                     </tr>
                  </table>
               </c:if>
            </div>
         </form:form>
      </div>
      <script>
         $(document).ready(function () {
           $('.sidebar-menu').tree()
         })
         
         function ValidateExtension() {
                   var allowedFiles = [".xlsx"];
                   var fileUpload = document.getElementById("uploadBtn");
                   var lblError = document.getElementById("lblError2");
                   var regex = new RegExp("([a-zA-Z0-9\s_\\.\-:])+(" + allowedFiles.join('|') + ")$");
                   if (!regex.test(fileUpload.value.toLowerCase())) {
                       lblError.innerHTML = "Please upload files having extensions: <b>" + allowedFiles.join(', ') + "</b> only.";
                       return false;
                   }
                   lblError.innerHTML = "";
                   document.getElementById("addloader1").style.display='block';
               	pageerrormsg.innerHTML="Page Loading....";
                   return true;
               }
         $(document).ready(function () {
           $('.sidebar-menu').tree()
         })
      </script>
      <%@include file="adminfooter.jsp" %>
   </body>
</html>