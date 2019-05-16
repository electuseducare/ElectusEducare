<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <%@include file="DisplayLogo.jsp" %>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>Electus Educare</title>
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
         width: 350px;
         }
         .form-control1 {
         display: block;
         width: 350px;
         height: 34px;
         padding: 6px 12px;
         font-size: 14px;
         line-height: 1.42857143;
         color: #555;
         background-color: #fff;
         background-image: none;
         border: 1px solid #ccc;
         border-radius: 4px;
         -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
         box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
         -webkit-transition: border-color ease-in-out .15s, -webkit-box-shadow ease-in-out .15s;
         -o-transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
         transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
         }
      </style>
      <style type="text/css">
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
         function startloader() {
         
         	 document.getElementById("loaderstart").style.display='block';
         }
         	
      </script>
      <script>
         function examFormValidation() {
             var selexam=document.getElementById('selexam').value;
         	var selectedexam = document.getElementById('selclassid').value;
         	//var selsectionid = document.getElementById('sid').value;
         	var selstucount = $("#sid :selected").length;
            if(selexam=='0'){
            	alert("Please select Exam from drop-down");
         		return false;
                }
         	if(selectedexam=='' || selectedexam=='0'){
         		alert("Please select Section from drop-down");
         		return false;
         	}if(selstucount==0){
         		alert("Please select Student from drop-down");
         		return false;
         	}else{
         		startloader();
             	}
         	
         } 
         
         
         
         /** fetch sections based on classid ****/
         function getClassBaseOnExamName(examname) {
        	 document.getElementById("selclassid").innerHTML="";
        	 document.getElementById("sid").innerHTML="";
          
             $.ajax({
             url : "load-getClassBaseOnExamName?examname="+examname,
             type: "GET",
             dataType: "json",
             success : 
             function(data) {
            	 var classid="";
            	 var secid="";
            	 var classname="";
            	 var content="";
            	 content+='<option value="0">--Please Select Class and Section--</option>';
            	  	$.each(data,function(i,val){
                  		$.each(val,function(key,value1){
                  			
                              if(key=="classid"){
                            	  classid=value1;
                              }
                              
                              else if(key=="classname")
                              	{
                            	  classname=value1;
                              	
                              	}
                              else if(key=="sectionid")
                              	{
                            	  secid=value1;
                              	}
                              else if(key=="section")
                            	{
                            	  content+='<option value='+classid+','+secid+'>'+classname+' - '+value1+'</option>';
                            	}
                  			});
                  	});
                 	document.getElementById("selclassid").innerHTML=content;
            	 
             }
         });        
               
         } 
         /** fetch student based on classid and sectionid ****/
         function getStudentBaseOnClassSec() {
          
          
            var examname=document.getElementById("selexam").value;
         var searchTerms = $("#selclassid").val();
            $.ajax({
            url : "load-getStuNameBaseOnClassSec?classsec="+searchTerms+"&examname="+examname,
            type: "GET",
            dataType: "json",
            success : 
            function(data) {
               
           	 var classid="";
           	 var content="";
           	document.getElementById("sid").innerHTML="";
           	 /* content+='<option value="0">--Please Select Student--</option>'; */
           	  	$.each(data,function(i,val){
                 		$.each(val,function(key,value1){
                 			
                             if(key=="studentid"){
                           	  classid=value1;
                             }
                             
                             else if(key=="userid")
                             	{
                            	 /* content+='<option value='+classid+'>'+value1+'</option>'; */
                            	 
                            	 $('#sid').append('<option value='+classid+'>'+value1+'</option>');
                             	
                             	}
                             
                 			});
                 	});
                	/* document.getElementById("sid").innerHTML=content; */
           	 
            }
         });    
                
               
         } 
         
         function selectall (){
          $('#sid option').prop('selected',true);
          
         }
         function deselectall (){
          $('#sid option').prop('selected',false);
          
         }
          
      </script> 
   </head>
   <body>
      <%@include file="adminUserTopMenu.jsp" %>
      <%@include file="adminUserHeader.jsp" %>
      <!-- start header -->
      <div id="loaderstart" class="loader" style="display: none;"></div>
      <div class="row"> </div>
      <div style="width:22%; float:left; background-color: #ffffff;"><%@include file="AdminDashboardLeftMenu.jsp" %></div>
      <div style="width:70%; float:left; background-color: #ffffff">
         <ul class="nav nav-tabs">
            <li class="active"><a  href="load-studentAssign" >STUDENT</a></li>
         </ul>
         <div class="panel panel-info">
            <div class="panel-heading">
               <center><b>Please select Exam</b></center>
            </div>
         </div>
         <div class="row"></div>
         <h4 style="color: green;text-align: center;">${smsg}</h4>
         <h4  style="color: red;text-align: center;">${emsg}</h4>
               <c:if test="${smsg==null}" >
                  <form:form modelAttribute="sem" action="load-insertStudentDetails">
                  
                  <div class="form-row">
                  <div class="form-group col-md-3">
                    </div>
                   <div class="form-group col-md-6">
                  <label for="inputPassword4">Exam Name</label>
              <form:select path="examname" id="selexam"  class="chosen-select" onchange="getClassBaseOnExamName(this.value)">
                              <option value="0">--Please Select Exam--</option>
                              <c:forEach items="${examlist}" var="cl">
                                 <option value="${cl.examname}">${cl.examname}</option>
                              </c:forEach>
                           </form:select>
                    <div class="row"></div>
                  <label for="inputPassword4">Class and Section Name</label>
             <form:select path="classid" id="selclassid" class="form-control1"  required="required" multiple="multiple" onchange="getStudentBaseOnClassSec()">
                           </form:select>
                    <div class="row"></div>
                  <label for="inputPassword4">User Names</label>
            <form:select path="studentid" id="sid" class="form-control1"  required="required" multiple="multiple">
                           </form:select>
                    <div class="row"></div>
                    
                       <div class="col-md-12">
                        <div class="col-md-6">
                           <button class="button btn-success" type="button" id="select-all" onclick="selectall();"> Select All Students</button>
                        </div>
                        <div class="col-md-6">
                           <button class="button btn-info" type="button" id="deselect-all" onclick="deselectall();">De-Select All Students</button>
                        </div>
                     </div>
                     <div class="row"></div>
                    <div class="col-md-12">
                        <div class="col-md-3">
                        </div>
                        <div class="col-md-6">
                           <button class="button btn-primary"  onclick="return examFormValidation();"> Assign Exam </button>
                        </div>
                     </div>
                    </div>
                    </div>
                  
                  
                    
                     <div class="row"></div>
                  
                     
                     
                  </form:form>
               </c:if>
            </div>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.js" type="text/javascript"></script>
      <script src="${pageContext.request.contextPath}/theme/js/downloadjs/ajax321.js"></script>
      <script src="${pageContext.request.contextPath}/theme/js/chosenjquery.js"></script>
      <script src="${pageContext.request.contextPath}/theme/js/prism.js"></script>
      <script src="${pageContext.request.contextPath}/theme/js/init.js"></script>
      <%@include file="adminfooter.jsp" %>
   </body>
</html>