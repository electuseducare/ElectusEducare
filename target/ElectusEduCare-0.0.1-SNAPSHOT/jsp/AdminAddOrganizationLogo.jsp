<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>Insert title here</title>
      <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
      <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.6.3/css/bootstrap-select.min.css" />
      <script type="text/javascript">
         var validData = true;
         
         function whitespaceValidation(textvalue){
         	
         	var len =textvalue.replace(/\s+$/, '');
             if(len==''){
             	//alert('Topic / Sub Tocpics should not be empty');
             	validData = false;
             	return false;
             }
             else{
             	validData = true;
             }
         	
         	}
         
         function formValidation(){
         	if(validData==false){
         		alert('Text box fields should not be empty');
             	return false;
         	}
         }
         
      </script>
   </head>
   <body>
      <%@include file="adminUserTopMenu.jsp" %>
      <%@include file="adminUserHeader.jsp" %> 
      <div class="row"> </div>
      <div style="width:22%; float:left; background-color: #ffffff;"><%@include file="AdminDashboardLeftMenu.jsp" %></div>
      <div style="width:70%; float:left; background-color: #ffffff">
         <div class="panel panel-info">
            <div class="panel-heading">
               <center><b>Upload Organization Logo</b></center>
            </div>
         </div>
         <div class="row"></div>
         <form:form modelAttribute="orglogo" action="load-insertorglogo" enctype="multipart/form-data">
            <div class="col-sm-12" style="padding: 4px; float: left;">
               <label style="float: left;" >Oraganization Name :*</label>
               <form:input path="organizationname" id="organizationname" class="form-control" required="required" onkeyup="return whitespaceValidation(this.value);"/>
            </div>
            <div class="col-md-12 col-sm-12" id="deceased">
               <div class="form-group col-md-12 col-sm-12">
                  <label >Upload Logo :*</label>
                  <input class="inputfile"  id="uploadBtn" name="uploadlogo" type="file"  required="required">
               </div>
            </div>
            <div class="col-md-12 col-sm-12" id="">
               <div class="form-group col-md-7 col-sm-12" style="float: right;">
                  <button class="btn-primary" type="submit" onclick="return formValidation();">UPLOAD</button>
               </div>
            </div>
         </form:form>
      </div>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
      <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.6.3/js/bootstrap-select.min.js"></script>
   </body>
</html>