<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta name="description" content="">
      <meta name="author" content="">
      <title>Welcome User</title>
      <script src="${pageContext.request.contextPath}/theme/js/jquery-311min.js"></script>
      <script src="${pageContext.request.contextPath}/theme/js/highcharts.js"></script>
      <script src="${pageContext.request.contextPath}/theme/js/highcharts-more.js"></script>
      <script src="${pageContext.request.contextPath}/theme/js/exporting.js"></script>
      <%@include file="DisplayLogo.jsp" %>
      <%@include file="userSessionExpire.jsp" %>
      <%@include file="userNewTemplateCss.jsp" %>
      <style>
         #customers {
         font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
         border-collapse: collapse;
         width: 100%;
         background-color: #428BCA;
         color:white;
         }
         #customers td, #customers th {
         border: 1px solid #ddd;
         padding: 8px;
         color:white;
         }
         #customers tr:nth-child(even){background-color: #f2f2f2;      color:white;}
         #customers tr:hover {color:white;}
         #customers th {
         padding-top: 12px;
         padding-bottom: 12px;
         text-align: left;
         background-color: #4CAF50;
         color: white;
         }
      </style>
   </head>
   <body>
      <!-- Navigation -->
      <%@include file="usernewleftmenu.jsp" %>
      <div id="page-wrapper">
         <div class="row">
            <div class="col-lg-12">
               <h1 class="page-header">SPA</h1>
               <c:forEach items="${getspa}" var="getspaval" varStatus="stat">
                  <c:set var="examnames" value="${stat.first ?'' : examnames} ${getspaval.examname}," />
                  <c:set var="totalmarks" value="${stat.first ?'' : totalmarks} ${getspaval.totalmarks}," />
                  <c:set var="scoredmarks" value="${stat.first ?'' : scoredmarks} ${getspaval.scoredmarks}," />
               </c:forEach>
               <input type="hidden" id="exmnames" value="${examnames}">
               <input type="hidden" id="totalmarks" value="${totalmarks}">
               <input type="hidden" id="scoredmarks" value="${scoredmarks}">
               <button class="btn btn-primary" id="plain">Plain</button>
               <button class="btn btn-success" id="inverted">Inverted</button>
               <button class="btn btn-warning"  id="polar">Polar</button>
               <div id="container"></div>
               <script>
                  var examname=document.getElementById("exmnames").value;
                     examname= examname.substring(0, examname.length - 1);
                     
                  var totalmrk=document.getElementById("totalmarks").value;
                     totalmrk= totalmrk.substring(0, totalmrk.length - 1);
                     
                     var scoredmarks=document.getElementById("scoredmarks").value;
                     scoredmarks= scoredmarks.substring(0, scoredmarks.length - 1);
                     
                  
                    var arr=[];
                   var examnames="",totalmrks="",scoretemp="";
                     var spltexm=examname.split(",");
                     var totmrk=totalmrk.split(",");
                     var scrmrk=scoredmarks.split(",");
                  
                     var totalarr=[];
                      var scorearr=[];
                      for(var i=0;i<=spltexm.length-1;i++){
                    	  totalarr.push(parseInt(totmrk[i]));
                  			 arr.push(spltexm[i]+"-"+parseInt(totmrk[i]));
                   	examnames=arr;
                   	scorearr.push(parseInt(scrmrk[i]));
                    	  scoretemp=scorearr;
                     } 
                  
                  var chart = Highcharts.chart('container', {
                  
                     title: {
                         text: 'Self Performance Analysis'
                  
                     },
                     subtitle: {
                         text: 'Graphical Representation For Exams Taken'
                     },
                  
                     xAxis: {
                         categories: examnames
                     },
                  
                     series: [{
                         type: 'column',
                         colorByPoint: true,
                         data: scorearr,
                         showInLegend: false
                     }]
                  
                  });
                  
                  
                  $('#plain').click(function () {
                     chart.update({
                         chart: {
                             inverted: false,
                             polar: false
                         },
                         subtitle: {
                             text: 'Plain'
                         }
                     });
                  });
                  
                  $('#inverted').click(function () {
                     chart.update({
                         chart: {
                             inverted: true,
                             polar: false
                         },
                         subtitle: {
                             text: 'Inverted'
                         }
                     });
                  });
                  
                  $('#polar').click(function () {
                     chart.update({
                         chart: {
                             inverted: false,
                             polar: true
                         },
                         subtitle: {
                             text: 'Polar'
                         }
                     });
                  });
                  
               </script>
            </div>
            <!-- /.col-lg-12 -->
         </div>
         <!-- /.row -->
         <!-- /#page-wrapper -->
      </div>
      <!-- /#wrapper -->
      <%@ include file="userNewTemplateJs.jsp" %>
   </body>
</html>