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
      <script src="${pageContext.request.contextPath}/theme/js/downloadjs/ajax1111.js"></script>
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
       <script type="text/javascript">
      $(document).ready(function(){
          $(document).ajaxStart(function(){
            $("#loaderstart").css("display", "block");
          });
          $(document).ajaxComplete(function(){
            $("#loaderstart").css("display", "none");
          });
          
        });
      </script>
      <script>
         function examFormValidation() {
         	var selectedexam = document.getElementById('selclassid').value;
         	var selsectionid = document.getElementById('selsectionid').value;
         	if(selectedexam=='0'){
         		alert("Please select Class from drop-down");
         		return false;
         	}if(selsectionid=='0'){
         		alert("Please select Section from drop-down");
         		return false;
         	}
         	else{
         		startloader();
         	}
         }
         
         /** fetch sections based on classid ****/
         function getsectionsFromClass(classid) {
             $.ajax({
             url : "get-sectiondetailsfromClass?classid="+classid,
             type: "GET",
             dataType: "text",
             success : 
             function(data) {
             	document.getElementById("selsectionid").innerHTML=data;
         
             }
         });        
               
         }
         
         /** fetch students based on sectionid ****/
         function getstudsFromSection(sectionid) {
         	var classid = document.getElementById('selclassid').value;
             $.ajax({
             url : "get-studsfromClassNdSection?classid="+classid+"&sectionid="+sectionid,
             type: "GET",
             dataType: "json",
             success : 
             function(data) {
            	 var studid="";
            	 var content="";
            	  document.getElementById("studentid").innerHTML="";
            	  content+='<option value="0">--Please Select User Name--</option>';
              	$.each(data,function(i,val){
              		$.each(val,function(key,value1){
              			
                          if(key=="studentid"){
                        	  studid=value1;
                          }
                          else if(key=="username")
                          	{
                        	  content+='<option value='+studid+'>'+value1+'</option>';
                          	 
                          	}
              			});
              	});
            	 
             	document.getElementById("studentid").innerHTML=content;
         
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
         <ul class="nav nav-tabs">
            <li ><a href="load-studentform" >ADD STUDENT</a></li>
            <li class="active" ><a href="load-classfilterstudents" >MODIFY STUDENT</a></li>
            <li ><a href="load-classfilterstudentsfordel" >DELETE STUDENT</a></li>
         </ul>
         <div class="panel panel-info">
            <div class="panel-heading">
               <center><b>Please select class and section to view Students.</b></center>
            </div>
         </div>
         <div class="row"></div>
         <h4 style="color: green;text-align: center;">${smsg}</h4>
         <h4  style="color: red;text-align: center;">${emsg}</h4>
               <form:form modelAttribute="filter" action="load-EditStudentform">
               <div class="form-row">
                  <div class="form-group col-md-4">
                    </div>
                   <div class="form-group col-md-6">
                  <label for="inputPassword4">Class Name</label>
                 <form:select path="classid" id="selclassid" class="chosen-select" onchange="getsectionsFromClass(this.value)">
                     <option value="0">--Please Select Class Name--</option>
                     <c:forEach items="${classnames}" var="cl">
                        <option value="${cl.categoryid}">${cl.category}</option>
                     </c:forEach>
                  </form:select>
                    <div class="row"></div>
                  <label for="inputPassword4">Section Name</label>
               <form:select path="sectionid" id="selsectionid" class="form-control1"  required="required" onchange="getstudsFromSection(this.value)">
                     <option value="0">--Please Select Section--</option>
                     <c:forEach  items="${sectiondetails}" var="sectiondetails" >
                        <form:option value="${sectiondetails.sectionid}"  >${sectiondetails.section}</form:option>
                     </c:forEach>
                  </form:select>
                    <div class="row"></div>
                  <label for="inputPassword4">User Name</label>
                <form:select path="studentid" id="studentid" class="form-control1"  required="required" >
                  </form:select>
                  <div class="row"></div>
                  <div class="col-md-12">
                        <div class="col-md-2">
                        </div>
                        <div class="col-md-6">
                  <button class="button btn-primary" onclick="return examFormValidation();"> Fetch Students </button>
                        </div>
                     </div>
                  
                    </div>
                    </div>
               </form:form>
            </div>
      <script src="${pageContext.request.contextPath}/theme/js/chosenjquery.js"></script>
      <script src="${pageContext.request.contextPath}/theme/js/prism.js"></script>
      <script src="${pageContext.request.contextPath}/theme/js/init.js"></script>
      <%@include file="adminfooter.jsp" %>
   </body>
</html>