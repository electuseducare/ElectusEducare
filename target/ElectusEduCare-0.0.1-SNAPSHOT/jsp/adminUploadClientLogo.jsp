<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html>
<html>
<head> <%@include file="DisplayLogo.jsp" %>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Upload Client Logo</title>

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



function formValidation(){
	clientlogo=document.getElementById("clientlogo").value ;
	if(clientlogo==''){
		alert('Please Choose File');
    	return false;
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
  <div class="content-wrapper">

 		  <div class="panel-heading" style="background-color:#ccf2ff;color:black; font-weight: bold;"><a href="load-uploadClientlogo"><img border="0" alt="W3Schools" src="${pageContext.request.contextPath}/theme/images/addicon.jpg" width="40" height="40" style="background-color: skyblue;"></a>
 		  Upload Client Logo</div>
 		 
      <form:form  enctype="multipart/form-data"  action="load-insertclientlogo" onsubmit="return Validate(this);"  >
         
		<div class="panel-body" id="mockTabs" style="background-color:#DFE2DB; height: 200px;">
		 <div style="text-align: left;"><label style="color:red">${msg}</label> </div>
        
          <c:if test="${msg==null}">
     <div style="text-align: left;">  <label style="color:green">${emsg}</label> </div>
 		    </c:if>
 		 <table>
            <tr><td colspan="2"><div><span id="lblError2" style="color: red;"></span></div></td></tr>
                 
                 <tr> <td><input type="file" name="clientlogo" id="clientlogo" class="inputfile"  required="required" accept=".jpg,.jpeg,.png"> </td>	
                <tr> <th>Note: Image pixel should be width:850px, height:850px;</th></tr>
                  <td> <input type="submit" class="btn-primary" value="UPLOAD" > </td>	
                 </tr>
           </table>
			
		  
	    	</div>
	     </form:form>
	     
	     
       </div>
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



<%@include file="adminfooter.jsp" %>
</body>
</html>



