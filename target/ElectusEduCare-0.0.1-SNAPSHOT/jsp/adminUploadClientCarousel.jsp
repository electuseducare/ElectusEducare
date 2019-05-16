<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
       <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> <%@include file="DisplayLogo.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Electus Educare</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/theme/css/AdminCreateExamStyleSheet.css">	
 <link rel="stylesheet" href="${pageContext.request.contextPath}/theme/css/chosen.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/theme/css/prism.css">
<style type="text/css">

.select,
.chosen-select,
.chosen-select-no-single,
.chosen-select-no-results,
.chosen-select-deselect,
.chosen-select-rtl,
.chosen-select-width {
  width: 100%;
}


</style>


<%@include file="AdminModuleValidations.jsp" %>
</head>




<body>
<%@include file="adminUserTopMenu.jsp" %>
<%@include file="adminUserHeader.jsp" %>

	<!-- start header -->




<div class="row"> </div>
<div style="width:22%; float:left; background-color: #ffffff;"><%@include file="AdminDashboardLeftMenu.jsp" %></div>
<div style="width:70%; float:left; background-color: #ffffff">

  <ul class="nav nav-tabs">
    <li class="active" ><a href="#" >Upload Client Carousel</a></li>
    <li ><a href="load-deleteClientCarousel" >Delete Carousel</a></li>
    </ul>
    
  <div class="panel-heading" style="background-color:#ccf2ff;color:black; font-weight: bold;"><a href="load-uploadClientCarousel"><img border="0" alt="W3Schools" src="${pageContext.request.contextPath}/theme/images/addicon.jpg" width="40" height="40" style="background-color: skyblue;"></a>
 		  Upload Client Carousel</div>
 	
  <div class="panel-body" id="mockTabs" style="background-color:#DFE2DB;">
	<center><h4 style="color:green">${smsg}</h4></center>	
	<center><h4 style="color:red">${emsg}</h4></center>	  
		<c:if test="${smsg==null}" > 
	<form:form   modelAttribute="getlogo"    action="load-insertclientcarousel"   enctype="multipart/form-data" onsubmit="return Validate(this);">
	
	 <label style="color:black;font-weight: bold;">Upload Carousel:</label>
		<input type="file" name="clientlogo" id="carousel" class="inputfile"   required="required" accept="image/x-png,image/gif,image/jpeg"  onkeyup="ValidateFileUpload()"/>
		<label>Note: Image pixel should be width:1000px, height:1000px;</label>
		<div class="row"></div>
		<center>
		<button class="btn-primary" style="background-color: #00a3cc;color:white;width:15%;align-text:center;" onClick="return validation();"> Submit</button>
	
		</center>
	
	</form:form>
	
	
	</c:if>
	
	
</div>

    


</div>

   
       
<%@include file="adminfooter.jsp" %>
 <script src="${pageContext.request.contextPath}/theme/js/chosenjquery.js"></script>
<script src="${pageContext.request.contextPath}/theme/js/prism.js"></script>
<script src="${pageContext.request.contextPath}/theme/js/init.js"></script>
<script>

	var uploadField = document.getElementById("carousel");
	
	uploadField.onchange = function() {
		
	    if(this.files[0].size > 1048576){
	       alert("File is too big!");
	       this.value = "";
	    };
	};

</script>


<SCRIPT type="text/javascript">
var _validFileExtensions = [".jpg", ".jpeg",  ".png"];    
function Validate(oForm) {
    var arrInputs = oForm.getElementsByTagName("input");
    for (var i = 0; i < arrInputs.length; i++) {
        var oInput = arrInputs[i];
        if (oInput.type == "file") {
            var sFileName = oInput.value;
            if (sFileName.length > 0) {
                var blnValid = false;
                for (var j = 0; j < _validFileExtensions.length; j++) {
                    var sCurExtension = _validFileExtensions[j];
                    if (sFileName.substr(sFileName.length - sCurExtension.length, sCurExtension.length).toLowerCase() == sCurExtension.toLowerCase()) {
                        blnValid = true;
                        break;
                    }
                }
                
                if (!blnValid) {
                    alert("Sorry,  allowed extensions are" + _validFileExtensions.join(","));
                    return false;
                }
            }
        }
    }
  
    return true;
}
    
    
</SCRIPT>




</body>
</html>