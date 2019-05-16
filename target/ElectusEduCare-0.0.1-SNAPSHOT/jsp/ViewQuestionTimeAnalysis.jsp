<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <%@include file="DisplayLogo.jsp" %>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>Question Wise Time Analysis</title>
      <script>
         window.onload = function () {
         
         var dps = []; // dataPoints
         var chart = new CanvasJS.Chart("chartContainer", {
         	title :{
         		text: "Order Of Attempt Questions"
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
      </script>
   </head>
   <body>
      <%@include file="adminUserTopMenu.jsp" %>
      <%@include file="adminUserHeader.jsp" %> 
      <%@include file="adminDataTableForReports.jsp" %>
      <!-- start header -->
      <div class="row"></div>
      <div class="container">
         <table id="example" class="table table-bordered table-striped nowrap" cellspacing="0" width="100%" style="text-align: center;">
            <thead>
               <tr>
                  <th class="bg-info" style="color: #00008B">Q.NO</th>
                  <th class="bg-info"  style="color: #00008B">Selected Answer</th>
                  <th class="bg-info" style="color: #00008B"> File Name </th>
                  <th class="bg-info" style="color: #00008B">Attempted Time</th>
                  <th class="bg-info" style="color: #00008B">Time Taken</th>
                  <th class="bg-info" style="color: #00008B">Seconds</th>
                  <!-- <th class="bg-info" style="color: #00008B">Action</th> -->
               </tr>
            </thead>
            <tbody>
               <c:forEach items="${getdifference}" var="quesdt" varStatus="quesdtail">
                  <tr>
                     <td>${quesdtail.index+1}</td>
                     <c:if test="${quesdt.selectedanswer != null}">
                        <td>${quesdt.selectedanswer}</td>
                     </c:if>
                     <c:if test="${quesdt.selectedanswer == null}">
                        <td>NA</td>
                     </c:if>
                     <td><a href="load-AdminFilterCriteria?filename=${quesdt.filename}"> ${quesdt.filename} </a></td>
                     <td>${quesdt.timedifference}</td>
                     <c:forEach items="${model1.ques}" var="quesdeatils" begin="${quesdtail.index}" end="${quesdtail.index}">
                        <td>${quesdeatils.differ}</td>
                        <td>${quesdeatils.totalsec}</td>
                     </c:forEach>
                  </tr>
               </c:forEach>
            </tbody>
         </table>
         <input type="hidden" id="totalques" value="${countques}"/>
         <div class="row"></div>
         <div id="chartContainer" style="height: 300px; width: 100%;"></div>
         <script src="${pageContext.request.contextPath}/theme/js/downloadjs/canvas-js.js"></script>
         <!-- <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script> -->
         <c:forEach items="${model1.ques}" var="quesdeatils" varStatus="quesdeatilsloop">
            <input type="hidden" id="ques_${quesdeatilsloop.index+1}" value="${quesdeatils.totalsec}"/>
         </c:forEach>
      </div>
      <div class="row">&nbsp;</div>
      <div class="col-sm-12">
         <div class="col-sm-5">&nbsp; </div>
         <div class="col-sm-6" style="float: left;"> <a href="load-QuestionwiseTimeAnalysis" style=" display: block; width: 200px; height: 30px; background: #4E9CAF; padding: 5px; text-align: center; border-radius: 5px; color: white; font-weight: bold;text-transform: uppercase;text-decoration: none;">BACK TO SELECT STUDENT</a> </div>
      </div>
      <div class="row">&nbsp;</div>
      <script>
         $(document).ready(function() {
             $('#example').DataTable( {
                 dom: 'Bfrtip',
                 buttons: [
                     'copy', 'csv', 'excel', 'pdf', 'print'
                 ],
                 
             } );
         } );
      </script>
   </body>
</html>