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
      <%@include file="adminDataTable.jsp" %>
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
      <div class="row"></div>
      <div style="width:5%; float:left; background-color: #ffffff;">
         <%-- <%@include file="AdminDashboardLeftMenu.jsp" %> --%> &nbsp;
      </div>
      <div class="content-wrapper" style="width:100%;">
         <TABLE style="width: 92%">
            <TR>
               <TD colspan="2">
                  <div class="panel-heading" style="background-color:#ccf2ff;color:black; font-weight: bold;">
                     <a href="load-uploaddata"><img border="0" alt="W3Schools" src="${pageContext.request.contextPath}/theme/images/addicon.jpg" width="40" height="40" style="background-color: skyblue;"></a>
                     Upload Student Records
                     <span style="float: right;"><a href="load-OfflineAnalysis"> Back to Offline Data </a></span>
                  </div>
               </TD>
            </TR>
            <form:form action="excelupload" method="post" enctype="multipart/form-data">
               <TR>
                  <TD>
                     <h5 style="color: red">  Note: </h5>
                     <ul>
                        <li>* User name and Email Id should be unique.</li>
                        <li>* Please do not close this window or click on the Back / Refresh button on your browser when upload is processing.</li>
                        <li>* In download format excel please delete the "Student Records" header row.</li>
                        <li>*  Please use the below id value in place of name in excel.</li>
                     </ul>
                  </TD>
               </TR>
               <TR>
                  <TD colspan="2">
                     <c:if test="${msg==null}">
                        <table style="background-color: powderblue; width: 100%; color: white;">
                           <tr>
                              <td colspan="2">Please download the .xlsx format to upload data: <a href="loadsampleBulkFile" class="btn-primary">Download Format</a>
                                 <span style="float: right;color: white; font-weight: bold; margin-right: 10px;"><a href="load-OfflineAnalysis" > Back to Offline Data </a></span>
                              </td>
                           </tr>
                           <tr>
                              <td>
                                 <div>&nbsp;</div>
                              </td>
                           </tr>
                           <tr>
                              <td colspan="2">
                                 <div><span id="lblError2" style="color: red; background-color: white;"></span></div>
                              </td>
                           </tr>
                           <tr>
                              <td width="20%"><input class="inputfile"  id="uploadBtn" name="excelfile2007" type="file"> </td>
                              <td style="margin-left: 100px;"> <input type="submit" class="btn-primary" value="UPLOAD" onclick="return ValidateExtension()"> </td>
                           </tr>
                        </table>
                     </c:if>
                  </TD>
               </TR>
            </form:form>
            <TR>
               <TD> &nbsp; </TD>
            </TR>
            <TR>
               <TD width="60%"  valign="top">
                  <TABLE id="statedetails" class="display" cellspacing="0" width="100%">
                     <thead>
                        <TR >
                           <TH style="text-align: center;"> STATE    	 </TH>
                           <TH style="text-align: center;"> S# 	 </TH>
                           <TH style="text-align: center;"> LOCATION 	 </TH>
                           <TH style="text-align: center;"> L# </TH>
                           <TH style="text-align: center;"> BRANCH		 </TH>
                           <TH style="text-align: center;"> B#	 </TH>
                        </TR>
                     </thead>
                     <tbody>
                        <c:forEach items="${statelist}" var="statelist" varStatus="loop">
                           <TR>
                              <TD style="text-align: center;"> ${statelist.statename} </TD>
                              <TD style="text-align: center;"> ${statelist.stateid} </TD>
                              <TD style="text-align: center;"> ${statelist.location} </TD>
                              <TD style="text-align: center;"> ${statelist.locationid} </TD>
                              <TD style="text-align: center;"> ${statelist.branch} </TD>
                              <TD style="text-align: center;"> ${statelist.branchid} </TD>
                           </TR>
                        </c:forEach>
                     </tbody>
                  </TABLE>
               </TD>
               <TD width="60%">
                  <TABLE id="classdetails1" class="display" cellspacing="0" width="100%">
                     <thead>
                        <TR >
                           <TH> CLASS   </TH>
                           <TH> C#      </TH>
                           <TH> SECTION </TH>
                           <TH> S#	  </TH>
                        </TR>
                     </thead>
                     <tbody>
                        <c:forEach  items="${clsection}" var="section" >
                           <TR>
                              <TD>${section.categoryname} </TD>
                              <TD>${section.categoryid} </TD>
                              <TD>${section.section} </TD>
                              <TD>${section.sectionid} </TD>
                           </TR>
                        </c:forEach>
                     </tbody>
                  </TABLE>
               </TD>
            </TR>
         </TABLE>
      </div>
      <script>
         $(document).ready(function () {
         
           $('#statedetails').DataTable( {
           	    "bLengthChange": false,
           	    "bInfo": false,
           } );
           $('#classdetails1').DataTable( {
           	    "bLengthChange": false,
           	    "bInfo": false,
           } );
           
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
                   return true;
               }
         $(document).ready(function () {
           $('.sidebar-menu').tree()
         })
      </script>
      <%@include file="adminfooter.jsp" %>
   </body>
</html>