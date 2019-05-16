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
      <%@include file="newtemplateDataTableCss.jsp" %>
      <script type="text/javascript" src="${pageContext.request.contextPath}/theme/js/graph.js"></script>
      <style>
         .one {
         width: 70%;
         height: 200px;
         float: left;
         }
         .two {
         float: right;
         height: 500px;
         width:30%;
         }
      </style>
      <script type="text/javascript">
         // Load google charts
         google.charts.load('current', {'packages':['corechart']});
         google.charts.setOnLoadCallback(drawChart);
         
         // Draw the chart and set the chart values
         function drawChart() {
         	var wrongans=  document.getElementById('wrongans').value;
         	var corrct=  document.getElementById('correctans').value;
         	var unattemp=  document.getElementById('unattempt').value;
         	
         	var wrongans1 = parseInt(wrongans);
         	var correct1 = parseInt(corrct);
         	var unattempt1 = parseInt(unattemp);
           var data = google.visualization.arrayToDataTable([
           ['Task', 'Hours per Day'],
           ['UnAttempted', unattempt1],
           ['Wrong Answers', wrongans1],
         	[,0] ,
           ['Correct Answers', correct1]
          /*  ['Sleep', 8] */
         ]);
         
           // Optional; add a title and set the width and height of the chart
           var options = {'title':'Performance Analysis', 'width':650, 'height': 400};
         		
           // Display the chart inside the <div> element with id="piechart"
           var chart = new google.visualization.PieChart(document.getElementById('piechart'));
           chart.draw(data, options);
         }
         
         
      </script>
      <script type="text/javascript">
         function errorAnnalysis_ByQid(questionId, autoincr)
         {
         
         var xmlhttp;
         
         var qid=questionId;
         var autoIncId = autoincr;
         
         var urls="load-errorAnalysis?ver="+qid;
         
         if (window.XMLHttpRequest)
           {
           xmlhttp=new XMLHttpRequest();
           }
         else
           {
           xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
           }
         xmlhttp.onreadystatechange=function()
           {
           if (xmlhttp.readyState==4)
             {
         	  
         	 
                 //document.getElementById("err").style.color="red";
                 document.getElementById("wlg").innerHTML=xmlhttp.responseText;
            
             }
           }
         xmlhttp.open("POST",urls,true);
         xmlhttp.send();
         }
      </script>
      <script type="text/javascript">
         google.charts.load("current", {packages:['corechart']});
         google.charts.setOnLoadCallback(drawChart);
         function drawChart() {
         	var wrongans=  document.getElementById('wrongans').value;
         	var corrct=  document.getElementById('correctans').value;
         	var unattemp=  document.getElementById('unattempt').value;
         var total=document.getElementById('total').value;
         var totalmarks=document.getElementById('totalmarks').value;
         var yourmarks=document.getElementById('yourmarks').value;
         	
         	
         	var wrongans1 = parseInt(wrongans);
         	var correct1 = parseInt(corrct);
         	var unattempt1 = parseInt(unattemp);
         	var total1= parseFloat(total); 
         	var totalmarks1= parseFloat(totalmarks); 
         	var yourmarks1= parseFloat(yourmarks); 
         	
         	
           var data = google.visualization.arrayToDataTable([
             ["Element", "Score", { role: "style" } ],
            ["T_marks", totalmarks1, "CORAL"],
             ["Ur_marks", yourmarks1, "SLATEGRAY"] 
         
           ]);
         
           var view = new google.visualization.DataView(data);
           view.setColumns([0, 1,
                            { calc: "stringify",
                              sourceColumn: 1,
                              type: "string",
                              role: "annotation" },
                            2]);
         
           var options = {
             title: " Results",
             width: 200,
             height: 400,
             bar: {groupWidth: "100%"},
             legend: { position: "none" },
           };
           var chart = new google.visualization.ColumnChart(document.getElementById("columnchart_values"));
           chart.draw(view, options);
         }
      </script>
      <script type="text/javascript">
         $(document).ready(function(){
             $("#button").click(function(){
                 $("#wlg").toggle('show');
             });
             
           	 
             
             
         });
         
      </script>
   </head>
   <body>
      <%@include file="adminUserTopMenu.jsp" %>
      <%@include file="adminUserHeader.jsp" %>
      <!-- start header -->
      <div class="row"> </div>
      <div style="width:22%; float:left; background-color: #ffffff;"><%@include file="AdminDashboardLeftMenu.jsp" %></div>
      <div style="width:70%; float:left; background-color: #ffffff">
         <div class="row">
            <div class="col-lg-12">
               <div class="panel panel-default">
                  <div class="panel-heading" style="text-align: center;font-size: 24px;text-decoration: underline;font-weight: bolder;color:white;background-color: #428BCA;">
                     Score Card 
                  </div>
                  <!-- /.panel-heading -->
                  <div class="panel-body">
                     <div class="table-responsive table-bordered">
                        <table class="table">
                           <thead>
                              <tr >
                                 <th style="background-color: #FF7F50 ;color:white">Exam Name</th>
                                 <th style="background-color: #428BCA;color:white">Subject</th>
                                 <th style="background-color: #FF7F50;text-align: center;color:white ">Total Marks</th>
                                 <!-- <th style="background-color: #ccf2ff ">Negative Marks</th> -->
                                 <th style="background-color: #428BCA;text-align: center;color:white ">Scored Marks</th>
                              </tr>
                           </thead>
                           <tbody>
                              <c:forEach items="${results}" var="sublist">
                                 <tr>
                                    <td>${examname}</td>
                                    <td> ${sublist.subject}</td>
                                    <td style="text-align: center;">${sublist.subjectwisetotal}</td>
                                    <%-- <td>${sublist.negativemarks}</td> --%>
                                    <td style="text-align: center;">${sublist.scoredmarks}</td>
                                 </tr>
                              </c:forEach>
                           </tbody>
                        </table>
                     </div>
                     <div class="row"></div>
                     <div class="col-lg-12">
                        <div class="col-lg-8" id="piechart" ></div>
                        <div class="col-lg-4" id="columnchart_values" ></div>
                     </div>
                     <input type="hidden" id="wrongans" value='${totalWrongAnswered}' />
                     <input type="hidden" id="correctans" value='${totalAnswered}' />
                     <input type="hidden" id="unattempt" value='${totalnotAnswered}' />
                     <input type="hidden" id="total" value='${totalQuestions}' />
                     <input type="hidden" id="examname" value='${examname}' />
                     <input type="hidden" id="yourmarks" value='${yourmarks}' />
                     <input type="hidden" id="totalmarks" value='${totalmarks}' />
                     <form:form modelAttribute="fp" id="springform" method="POST" action="load-filterform">
                     </form:form>
                     <!-- /.table-responsive -->
                  </div>
                  <!-- /.panel-body -->
               </div>
               <!-- /.panel-body -->
            </div>
            <!-- /.panel -->
         </div>
      </div>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.js" type="text/javascript"></script>
      <%@include file="adminfooter.jsp" %>
      <script>
         $(document).ready(function() {
             $('#dataTables-example').DataTable({
                 responsive: false
                 
             });
         });
      </script>
   </body>
</html>