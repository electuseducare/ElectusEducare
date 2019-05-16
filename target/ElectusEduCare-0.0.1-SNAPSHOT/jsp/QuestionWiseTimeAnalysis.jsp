<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <%@include file="DisplayLogo.jsp" %>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>Order of question attempted</title>
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
         window.onload = function () {
         
         var dps = []; // dataPoints
         var chart = new CanvasJS.Chart("chartContainer", {
         	title :{
         		text: "Avg time of attempted Questions"
         	},
         	exportEnabled: true,
         	axisY: {
         		includeZero: false,
         		suffix: "sec"
         	},      
         	data: [{
         		type: "line",
         		dataPoints: dps
         	}]
         });
         var quest=document.getElementById("totalques").value;
         var xVal = 0;
         var yVal = 100; 
         var updateInterval = 1000;
         var dataLength = quest; // number of dataPoints visible at any point
         
         var updateChart = function (count) {
         	count = count || 1;
         
         	for (var j = 1; j < count; j++) {
         		var yvalln=document.getElementById('ques_'+j).value;
         		var finalval=parseInt(yvalln);
         		yVal = yVal +  Math.round(5 + Math.random() *(-5-5));
         		
         		dps.push({
         			x: j,
         			y: finalval
         		});
         		xVal++;
         	}
         
         	if (dps.length > dataLength) {
         		dps.shift();
         	}
         
         	chart.render();
         };
         
         updateChart(dataLength);
         
         }
         
         function startloader() {
         	 document.getElementById("loaderstart").style.display='block';
         }
         
      </script>
   </head>
   <body>
      <%@include file="adminUserTopMenu.jsp" %>
      <%@include file="adminUserHeader.jsp" %> 
      <%@include file="adminDataTableForReports.jsp" %>
      <!-- start header -->
      <div id="loaderstart" class="loader" style="display: none;"></div>
      <div class="row"></div>
      <div class="container">
         <table id="example" class="table table-bordered table-striped nowrap" cellspacing="0" width="100%" style="text-align: center;">
            <form:form  name="Timeanalysis" method="post" action="process-QuestionTimeAnalysis"  modelAttribute="qs" >
               <thead>
                  <tr>
                     <th class="bg-info" style="color: #00008B">FirstName</th>
                     <th class="bg-info"  style="color: #00008B">User Name</th>
                     <th class="bg-info" style="color: #00008B"> Class Name </th>
                     <th class="bg-info" style="color: #00008B">Student_Id</th>
                     <th class="bg-info" style="color: #00008B">Section Name</th>
                     <th class="bg-info" style="color: #00008B">Action</th>
                  </tr>
               </thead>
               <tbody>
                  <c:forEach items="${qdetails}" var="quesdt">
                     <tr>
                        <td>${quesdt.firstname} ${quesdt.lastname}</td>
                        <td>${quesdt.username}</td>
                        <td>${quesdt.classval}</td>
                        <td>${quesdt.studentid}</td>
                        <td>${quesdt.section}</td>
                        <td><a href="process-QuestionTimeAnalysis?&examname=${examname}&stdid=${quesdt.studentid}"   style=" display: block; width: 80px; height: 30px; background: #4E9CAF; padding: 5px; text-align: center; border-radius: 5px; color: white; font-weight: bold;text-transform: uppercase;text-decoration: none;" onclick="startloader()">View</a></td>
                     </tr>
                  </c:forEach>
               </tbody>
            </form:form>
         </table>
      </div>
      <script>
         $(document).ready(function() {
             $('#example').DataTable( {
                
                 
             } );
         } );
      </script>
      <div class="row"></div>
      <div class="container">
         <table id="example1" class="table table-bordered table-striped nowrap" cellspacing="0" width="100%" style="text-align: center;">
            <form:form  name="Timeanalysis" method="post" action="#"  modelAttribute="qs" >
               <thead>
                  <tr>
                     <th class="bg-info" style="color: #00008B">S.NO</th>
                     <th class="bg-info" style="color: #00008B">Filename</th>
                     <th class="bg-info" style="color: #00008B">Q.Avg time</th>
                  </tr>
               </thead>
               <tbody>
                  <c:forEach items="${avgstimedata}" var="quesdt" varStatus="loop">
                     <tr>
                        <td>${loop.index+1}</td>
                        <td><a href="load-AdminFilterCriteria?filename=${quesdt.filename}">${quesdt.filename}</a></td>
                        <td>${quesdt.avgtime}</td>
                     </tr>
                  </c:forEach>
               </tbody>
            </form:form>
         </table>
      </div>
      <div class="col-sm-12">
         <div class="col-sm-5">&nbsp; </div>
         <div class="col-sm-6" style="float: left;"> <a href="load-ExamNameReports" style=" display: block; width: 200px; height: 30px; background: #4E9CAF; padding: 5px; text-align: center; border-radius: 5px; color: white; font-weight: bold;text-transform: uppercase;text-decoration: none;">BACK TO SELECT EXAM</a> </div>
      </div>
      <script>
         $(document).ready(function() {
             $('#example1').DataTable( {
                
                 
             } );
         } );
      </script>
      <div class="row"></div>
      <div class="container">
         <input type="hidden" id="totalques" value="${questioncount}"/>
         <div id="chartContainer" style="height: 300px; width: 100%;"></div>
         <script src="${pageContext.request.contextPath}/theme/js/downloadjs/canvas-js.js"></script>
         <!-- <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script> -->
         <c:forEach items="${avgstimedata}" var="quesdeatils" varStatus="quesdeatilsloop">
            <input type="hidden" id="ques_${quesdeatilsloop.index+1}" value="${quesdeatils.avgtime}"/>
         </c:forEach>
      </div>
      <%-- <center> <button onclick="history.back();" style="cursor: pointer; background-color: aqua; height: 30px">Back to Reports</button></center>
         --%>
   </body>
</html>