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
         button{
         height:30px; 
         width:100px; 
         margin: -20px -50px; 
         position:relative;
         top:50%; 
         left:15%;
         }
      </style>
      <script type="text/javascript">
         function startloader() {
         
         	 document.getElementById("loaderstart").style.display='block';
         }
         	
      </script>
      <script>
         function examFormValidation() {
         	var selectedexam = document.getElementById('selclassid').value;
         	var eid = document.getElementById('eid').value;
         	var subjectype = document.getElementById('subjectype').value;
         	var topicid=document.getElementById('topicids').value;
         	if(selectedexam=='0'){
         		alert("Please select Class from drop-down");
         		return false;
         	}
         	if(eid=='0'){
         		alert("Please select Exam Type from drop-down");
         		return false;
         	}
         	if(subjectype=='0'){
         		alert("Please select Subject from drop-down");
         		return false;
         	}
         	if(topicid==''){
         		alert("Please select Topics from drop-down");
         		return false;
         	}
         	
         	else{
         		startloader();
         		}
         }
         
         /** fetch subjects based on classid ****/
         function getsubjectFromClass(classid) {
         	var classid = document.getElementById('selclassid').value;
             $.ajax({
             url : "getSubjectsFromClass?classid="+classid,
             type: "GET",
             dataType: "json",
             success : 
             function(data) {
            	 var studid="";
            	 var content="";
            	  content+='<option value="0">--Please Select Subject--</option>';
              	$.each(data,function(i,val){
              		$.each(val,function(key,value1){
              			
                          if(key=="subject"){
                        	  studid=value1;
                          }
                          else if(key=="subjectid")
                          	{
                        	  content+='<option value='+value1+'>'+studid+'</option>';
                          	 
                          	}
              			});
              	});
             	document.getElementById("subjectype").innerHTML=content;
         
             }
         });        
               
         }
         
         function getTopicsBasedOnExmtypeAndSubjid(subjid) {
        	 var examtypeid = document.getElementById('eid').value;
        	 
        	 $.ajax({
                 url : "load-GetTopicsforSubjects?subjectid="+subjid+"&examtypeid="+examtypeid,
                 type: "GET",
                 dataType: "json",
                 success : 
                 function(data) {
                	 var topics="";
                	 var content="";
                	  	$.each(data,function(i,val){
                      		$.each(val,function(key,value1){
                      			
                                  if(key=="topic"){
                                	  topics=value1;
                                  }
                                  else if(key=="topicid")
                                	{
                                	  content+='<option value='+value1+'>'+topics+'</option>';
                                	}
                      			});
                      	});
                     	document.getElementById("topicids").innerHTML=content;
                 }
             });
        	 
			
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
         <div class="panel panel-info">
            <div class="panel-heading">
               <center><b>Please select required fields to view Questions.</b></center>
            </div>
         </div>
         <div class="row"></div>
               <form:form modelAttribute="filter" action="load-AdminFilterCriteria">
               <div class="form-row">
                  <div class="form-group col-md-4">
                    </div>
                   <div class="form-group col-md-6">
                  <label for="inputPassword4">Class Name</label>
               <form:select path="classid" id="selclassid" class="chosen-select" onchange="getsubjectFromClass(this.value)">
                     <option value="0">--Please Select Class--</option>
                     <c:forEach items="${classnames}" var="cl">
                        <option value="${cl.categoryid}">${cl.category}</option>
                     </c:forEach>
                  </form:select>
                    <div class="row"></div>
                   <label for="inputPassword4">Exam Type</label>
                  <form:select path="examtype" id="eid"  class="chosen-select">
                     <option value="0">--Please Select Exam type--</option>
                     <c:forEach items="${etype}" var="etype">
                        <option value="${etype.examtypeid}">${etype.examtype}</option>
                     </c:forEach>
                  </form:select>
                    <div class="row"></div>
                   <label for="inputPassword4">Subject Type</label>
                  <form:select path="subjectype"  class="form-control1"   onchange="getTopicsBasedOnExmtypeAndSubjid(this.value);">
                  </form:select>
                    <div class="row"></div>
                   <label for="inputPassword4">Topics</label>
                  <form:select path="topicids"  class="form-control1"  required="required" multiple="multiple">
                   </form:select>
                    <div class="row"></div>
                    
                    <div class="col-md-12">
                        <div class="col-md-2">
                        </div>
                        <div class="col-md-6">
                  <button class="button btn-primary" onclick="return examFormValidation();"> Submit </button>
                        </div>
                     </div>
    </div>
  </div>
               
               
                 
                   
                       
               </form:form>
      </div>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.js" type="text/javascript"></script>
      <script src="${pageContext.request.contextPath}/theme/js/chosenjquery.js"></script>
      <script src="${pageContext.request.contextPath}/theme/js/prism.js"></script>
      <script src="${pageContext.request.contextPath}/theme/js/init.js"></script>
      <%@include file="adminfooter.jsp" %>
   </body>
</html>