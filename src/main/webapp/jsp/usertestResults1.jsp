<%@page import="java.math.BigInteger"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta name="description" content="">
      <meta name="author" content="">
      <title>User Detail Results</title>
      <%@include file="DisplayLogo.jsp" %>
      <%@include file="userSessionExpire.jsp" %>
      <%-- <%@include file="userNewTemplateCss.jsp" %> --%>
      <%@include file="newtemplateDataTableCss.jsp" %>
      <style>
         @import url(//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css);
         hr {
         height: 4px;
         margin-left: 15px;
         margin-bottom:-3px;
         }
         .hr-warning{
         background-image: -webkit-linear-gradient(left, rgba(210,105,30,.8), rgba(210,105,30,.6), rgba(0,0,0,0));
         }
         .hr-success{
         background-image: -webkit-linear-gradient(left, rgba(15,157,88,.8), rgba(15, 157, 88,.6), rgba(0,0,0,0));
         }
         .hr-primary{
         background-image: -webkit-linear-gradient(left, rgba(66,133,244,.8), rgba(66, 133, 244,.6), rgba(0,0,0,0));
         }
         .hr-danger{
         background-image: -webkit-linear-gradient(left, rgba(244,67,54,.8), rgba(244,67,54,.6), rgba(0,0,0,0));
         }
         .breadcrumb {
         background: rgba(245, 245, 245, 0); 
         border: 0px solid rgba(245, 245, 245, 1); 
         border-radius: 25px; 
         display: block;
         }
         .btn-bread{
         margin-top:10px;
         font-size: 12px;
         border-radius: 3px;
         }
         .bs-test{
         margin: 48px;
         }
         .test-nav{
         margin: 68px;
         }
      </style>
      <script type="text/javascript"> 
         $(document).ready(function() {  
          $('#button1').click(function(){ 
         });
         
         });  
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
                 document.getElementById("analysis").innerHTML=xmlhttp.responseText;
          
             }
           }
         xmlhttp.open("POST",urls,true);
         xmlhttp.send();
         }
         
      </script>
      <script type="text/javascript">
         $(document).ready(function(){
             $("button").click(function(){
                 $("#wlg").toggle('show');
             });
             
           	 $('#button1').click(function(){ 
             });
             
             
         });
         
      </script>
   </head>
   <body>
      <div id="wrapper">
         <!-- Navigation -->
         <%@include file="usernewleftmenu.jsp" %>
         <div id="page-wrapper">
            <div class="row">&nbsp;</div>
            <form:form modelAttribute="fp" id="springform" method="POST" action="load-filterform">
               <div class="dropdown">
                  <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Filter Exam Results
                  <span class="caret"></span></button>
                  <ul class="dropdown-menu">
                     <c:set var="allvalue" value="${fn:contains(requestObject, 'all')}"></c:set>
                     <c:set var="correctvalue" value="${fn:contains(requestObject, 'Correct')}"></c:set>
                     <li><button class="btn btn-primary" style="width: 100%; " name="actionform" value="all,${examname}" > All </button></li>
                     <li><button class="btn btn-success" style="width: 100%; " name="actionform" value="Correct,${examname}" > Correct Answered </button></li>
                     <li><button class="btn btn-danger" style="width: 100%; " name="actionform" value="InCorrect,${examname}" >Wrong Answered </button></li>
                     <li><button class="btn btn-warning" style="width: 100%; " name="actionform" value="UnAttempted,${examname}" >UnAttempted </button></li>
                  </ul>
                  <a href="load-selfPerformaneceAnalysis" class="btn btn-success" >Self Performance Analysis</a>
               </div>
            </form:form>
            <div class="row">
               <div class="col-lg-12">
                  <div class="row">&nbsp;</div>
               </div>
               <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
               <div class="col-lg-12">
                  <div class="panel panel-default">
                     <div class="panel-heading">
                        View Results Summary
                     </div>
                     <!-- /.panel-heading -->
                     <div class="panel-body">
                        <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                           <thead>
                              <tr>
                                 <th>Qno</th>
                                 <th>Subject</th>
                                 <th>Question</th>
                                 <c:if test="${incorrect_answer == null }">
                                    <c:if test="${unattempted_answer == null}">
                                       <th>Correct</th>
                                       <c:if test = "${allvalue==false}">
                                          <c:if test = "${requestObject!='Summary'}">
                                             <th>Time Taken by me</th>
                                             <th>Least Time</th>
                                          </c:if>
                                       </c:if>
                                    </c:if>
                                 </c:if>
                                 <c:if test="${incorrect_answer == null }">
                                    <c:if test="${correct_answ == null }">
                                       <th>Unattempted</th>
                                    </c:if>
                                 </c:if>
                                 <c:if test="${unattempted_answer == null}">
                                    <c:if test="${correct_answ == null }">
                                       <th>Wrong</th>
                                    </c:if>
                                 </c:if>
                                 <c:set value="${examdate}" var="examdate"></c:set>
                                 <% 
                                    DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                                    Date date = new Date();
                                    String curtime=dateFormat.format(date);
                                    pageContext.setAttribute("curtime", curtime);
                                    
                                    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                                    Date curdate = df.parse(df.format(date));
                                    String examdate=(String)pageContext.getAttribute("examdate");
                                    Date exenddate=df.parse(examdate);
                                    if(curdate.compareTo(exenddate)>0){
                                    pageContext.setAttribute("status", "1");
                                    }else{
                                    pageContext.setAttribute("status", "2");
                                    }
                                    
                                    %>
                                 <c:if test="${status==1}">
                                    <th>Key</th>
                                    <th>Solution</th>
                                 </c:if>
                                 <c:if test="${status==2 && curtime>=examendtime}">
                                    <th>Key</th>
                                    <th>Solution</th>
                                 </c:if>
                              </tr>
                           </thead>
                           <tbody>
                              <c:forEach items="${question}" var="rownew" varStatus="loop">
                                 <tr>
                                    <td style="font-weight: bold;">${loop.index+1} </td>
                                    <td style="font-weight: bold;">${rownew.subjname} </td>
                                    <%-- <td style="font-weight: bold;">${rownew.getQuestion_Id()}</td> --%>
                                    <td style="font-weight: bold;">
                                       <span style="color: red;">Question:</span><br> ${rownew.getQues()} <br>
                                       <c:if test="${(rownew.questiontype=='Single answer') || (rownew.questiontype=='Multi Answer') || (rownew.questiontype=='Reasoning Type') || (rownew.questiontype=='Comprehension')}">
                                          <span style="color: green;">Option A:</span>
                                          <br> ${rownew.optiona}<br>
                                          <span style="color: green;">Option B:</span>
                                          <br> ${rownew.optionb}<br>
                                          <span style="color: green;">Option C:</span>
                                          <br> ${rownew.optionc}<br>
                                          <span style="color: green;">Option D:</span>
                                          <br> ${rownew.optiond}<br>
                                       </c:if>
                                       <c:if test="${rownew.questiontype=='True Or False'}">
                                          <span style="color: green;">Option A:</span>
                                          ${rownew.optiona}<br>
                                          <span style="color: green;">Option B:</span>
                                          <${rownew.optionb}
                                       </c:if>
                                       <c:if test="${rownew.questiontype=='Matrix Match'}">
                                          <c:set var = "opA" value = "${rownew.optiona}"/>
                                          <c:set var = "optionA" value = "${fn:substringAfter(opA,'matrix_option')}" />
                                          <c:set var = "optionA1" value = "${fn:substringBefore(opA,'matrix_option')}" />
                                          <c:set var = "opB" value = "${rownew.optionb}"/>
                                          <c:set var = "optionB" value = "${fn:substringAfter(opB,'matrix_option')}" />
                                          <c:set var = "optionB1" value = "${fn:substringBefore(opB,'matrix_option')}" />
                                          <c:set var = "opC" value = "${rownew.optionc}"/>
                                          <c:set var = "optionC" value = "${fn:substringAfter(opC,'matrix_option')}" />
                                          <c:set var = "optionC1" value = "${fn:substringBefore(opC,'matrix_option')}" />
                                          <c:set var = "opD" value = "${rownew.optiond}"/>
                                          <c:set var = "optionD" value = "${fn:substringAfter(opD,'matrix_option')}" />
                                          <c:set var = "optionD1" value = "${fn:substringBefore(opD,'matrix_option')}" />
                                          <div style="float: left;">
                                             ${optionA1}<br>
                                             ${optionB1}<br>
                                             ${optionC1}<br>
                                             ${optionD1}<br>
                                          </div>
                                          <div style="float: right;">
                                             ${optionA}<br>
                                             ${optionB}<br>
                                             ${optionC}<br>
                                          </div>
                                          <c:choose>
                                             <c:when test="${fn:contains(optionD, 'matrix_option')}">
                                                <c:set var = "abc" value = "${fn:substringAfter(optionD,'matrix_option')}"/>
                                                <c:set var = "pqr" value = "${fn:substringBefore(optionD,'matrix_option')}" />
                                                <div style="float: right;">
                                                   ${pqr}<br>
                                                   ${abc}<br>
                                                </div>
                                             </c:when>
                                             <c:otherwise>
                                                <div style="float: right;">
                                                   ${optionD}<br>
                                                </div>
                                             </c:otherwise>
                                          </c:choose>
                                       </c:if>
                                    </td>
                                    <c:if test="${incorrect_answer == null }">
                                       <c:if test="${unattempted_answer == null}">
                                          <td style="font-weight: bold;">
                                             <span class="col-sm-1">
                                                <c:if test="${rownew.answered=='null'}"> N/A </c:if>
                                                <c:if test="${rownew.answered !='null'}"> ${rownew.answered}</c:if>
                                             </span>
                                          </td>
                                          <c:if test = "${allvalue==false}">
                                             <c:if test = "${requestObject!='Summary'}">
                                                <td>${rownew.timedifference}</td>
                                                <td>${rownew.leasttime}</td>
                                             </c:if>
                                          </c:if>
                                       </c:if>
                                    </c:if>
                                    <c:if test="${incorrect_answer == null }">
                                       <c:if test="${correct_answ == null }">
                                          <td style="font-weight: bold;">
                                             <span class="col-sm-1">
                                                <c:if test="${rownew.notanswered=='null'}"> N/A </c:if>
                                                <c:if test="${rownew.notanswered !='null'}"> ${rownew.notanswered}</c:if>
                                             </span>
                                          </td>
                                       </c:if>
                                    </c:if>
                                    <c:if test="${unattempted_answer == null}">
                                       <c:if test="${correct_answ == null }">
                                          <td style="font-weight: bold;">
                                             <span class="col-sm-1">
                                                <c:if test="${rownew.wronganswered=='null'}"> N/A </c:if>
                                                <c:if test="${rownew.wronganswered !='null'}"> ${rownew.wronganswered}</c:if>
                                             </span>
                                          </td>
                                       </c:if>
                                    </c:if>
                                    <c:if test="${curtime>=examendtime  && status==2}">
                                       <td style="font-weight: bold;">${rownew.qanswer}<span class="col-sm-1"></span></td>
                                       <td style="font-weight: bold;"><span class="col-sm-1">
                                          <button  id="${rownew.getQuestion_Id()}" class="btn btn-primary" data-toggle = "modal" data-target = "#myModal"  onclick="errorAnnalysis_ByQid(${rownew.getQuestion_Id()}, 'analysis${loop.index}')"> Solution  </button> 
                                          </span>
                                       </td>
                                    </c:if>
                                    <c:if test="${status==1}">
                                       <td style="font-weight: bold;">${rownew.qanswer}<span class="col-sm-1"></span></td>
                                       <td style="font-weight: bold;"><span class="col-sm-1">
                                          <button  id="${rownew.getQuestion_Id()}" class="btn btn-primary" data-toggle = "modal" data-target = "#myModal"  onclick="errorAnnalysis_ByQid(${rownew.getQuestion_Id()}, 'analysis${loop.index}')"> Solution  </button> 
                                          </span>
                                       </td>
                                    </c:if>
                                 </tr>
                              </c:forEach>
                           </tbody>
                        </table>
                     </div>
                     <!-- /.table-responsive -->
                  </div>
                  <!-- /.panel-body -->
               </div>
               <!-- /.panel -->
            </div>
            <!-- /.col-lg-12 -->
         </div>
         <div class="container">
            <!-- Trigger the modal with a button -->
            <!-- Modal -->
            <div class="modal fade" id="myModal" role="dialog">
               <div class="modal-dialog">
                  <!-- Modal content-->
                  <div class="modal-content">
                     <div class="modal-header" style="background-color: #428BCA;color:white;">
                        <button type="button" class="close" data-dismiss="modal" style="color:maroon;font: bolder;">&times;</button>
                        <h4 class="modal-title">Solution Description</h4>
                     </div>
                     <div class="modal-body" id="analysis">
                     </div>
                     <div class="modal-footer">
                        <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
                     </div>
                  </div>
               </div>
            </div>
         </div>
         <!-- /.col-lg-6 -->
      </div>
      <!-- /#wrapper -->
      <%@ include file="newtemplateDataTableJs.jsp" %>
      <script>
         $(document).ready(function() {
             $('#dataTables-example').DataTable({
                 responsive: true
             });
         });
      </script>
   </body>
</html>