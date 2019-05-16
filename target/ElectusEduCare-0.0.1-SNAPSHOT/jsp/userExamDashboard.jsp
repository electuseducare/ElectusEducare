<%@page import="java.math.BigInteger"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta name="description" content="">
      <meta name="author" content="">
      <title>Welcome User</title>
      <%@include file="DisplayLogo.jsp" %>
      <%@include file="userSessionExpire.jsp" %>
      <jsp:include page="gateCss.jsp"></jsp:include>
      <script >
         function preventBack(){window.history.forward();}
         setTimeout("preventBack()", 0);
         window.onunload=function(){null}; 
         document.addEventListener('contextmenu', event =event.preventDefault());
      </script>
      <script type="text/javascript"> 
         $(document).ready(function() {  
                 $('#button1').click(function(){ 
         });
         
         });  
      </script>  
      <script type="text/javascript">
         function startloader() {
          document.getElementById("loaderstart").style.display='block';
         }
      </script>
      <script type="text/javascript">
         var getInstructionDetails = function(examname,examid,patterntypeids){
                 
                 //If we select more than one subject, pass the subjectids with comma seperater
                 
                 
                 
                 
             $.ajax({
                     url : "load-DashboardInstructionForm?exam_name="+examname,
                     
                     type: "GET",
                     dataType: "json",
                    
                     success : 
                     
                     function(data) {
                             
                             var EditBlockBeanArray = data;
                             
                         var _html = '<table class="table table-bordered table-striped" style="width:100%;">';
                         _html += '<tr>';
                         _html += '<th>Subject</th>';
                         _html += '<th>Question Type</th>';
                         _html += '<th>No of Questions</th>';
                         _html += '<th>Positive Marks</th>';
                         _html += '<th>Negative Marks</th>';
                         _html += '</tr>';
         
                         var i = 0;
                         while (i < EditBlockBeanArray.length) {
                             var ebbObject = EditBlockBeanArray[i];
         
                             _html += '<tr class="tblRw" id="row' + i + '">';
                             _html += '<td>' + ebbObject.subjectname + '</td>';
                             _html += '<td>' + ebbObject.questiontype + '</td>';
                             _html += '<td>' + ebbObject.noofques + '</td>';
                             _html += '<td>' + ebbObject.marksperqtype + '</td>';
                             _html += '<td>' + ebbObject.negativemarks + '</td>';
                             _html += '</tr>';
         
                             i++;
                         }
         
                         _html += '</table>';
                         if(patterntypeids=='1'){
                         	
                             $('#gatepattern_'+examid).show();	 
                             $('#tetpattern_'+examid).hide();	 
                             	
                              }else{
                             	 $('#gatepattern_'+examid).hide();	 
                                  $('#tetpattern_'+examid).show();	
                              }
                         document.getElementById('results_'+examid).innerHTML = _html;
                     }
             });
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
         .notansweredbtn{
         padding: 8px 8px 4px 8px;
         text-decoration: none;
         border: 1px solid #ccc;
         color: navy;
         background-color: #ffffff;
         margin-right:3px;
         float:left;
         -webkit-transition: background 200ms linear;
         transition: background 200ms linear;
         border-Bottom-left-radius: 20px;
         border-Bottom-right-radius:20px;
         moz-border-radius: 10px;
         webkit-border-radius:10px;
         display: inline;
         font-size:12px;
         margin-bottom: :25px;
         z-index:5;
         }
         .notansweredvisitedbtn{
         padding: 8px 8px 4px 8px;
         text-decoration: none;
         border: 1px solid #ccc;
         color: white;
         background-color: red;
         margin-right:3px;
         float:left;
         -webkit-transition: background 200ms linear;
         transition: background 200ms linear;
         border-Bottom-left-radius: 20px;
         border-Bottom-right-radius:20px;
         moz-border-radius: 10px;
         webkit-border-radius:10px;
         display: inline;
         font-size:12px;
         margin-bottom: :25px;
         z-index:5;
         }
         .answeredbtn{
         padding: 8px 8px 4px 8px;
         text-decoration: none;
         border: 1px solid #ccc;
         text-decoration: none;
         margin-right:3px;
         float:left;
         -webkit-transition: background 200ms linear;
         transition: background 200ms linear;
         border-top-left-radius: 20px;
         border-top-right-radius:20px;
         moz-border-radius: 10px;
         webkit-border-radius:10px;
         display: inline;
         margin-bottom: :25px;
         }
         .markforreviewansw{
         padding: 9px 8px 4px 8px;
         text-decoration: none;
         border: 1px solid #ccc;
         color: navy;
         background-color: #714F91;
         margin-right:3px;
         float:left;
         -webkit-transition: background 200ms linear;
         transition: background 200ms linear;
         border-radius: 5px 20px 5px;
         display: inline;
         margin-bottom: :25px;
         color: white;
         }
         .currentques{
         padding: 8px 8px 4px 8px;
         text-decoration: none;
         border: 1px solid #ccc;
         text-decoration: none;
         color: #FFFFFF;
         background-color: #4E85C5;
         margin-right:3px;
         float:left;
         -webkit-transition: background 200ms linear;
         transition: background 200ms linear;
         border-Bottom-left-radius: 20px;
         border-Bottom-right-radius:20px;
         moz-border-radius: 10px;
         webkit-border-radius:10px;
         display: inline;
         margin-bottom: :25px;
         color: white;
         }
         #markforreview{
         padding: 8px 8px 4px 8px;
         text-decoration: none;
         border: 1px solid #ccc;
         color: navy;
         background-color: #714F91;
         margin-right:3px;
         float:left;
         -webkit-transition: background 200ms linear;
         transition: background 200ms linear;
         border-Bottom-left-radius: 50px;
         border-Bottom-right-radius:50px;
         border-Top-left-radius: 50px;
         border-Top-right-radius:50px;
         moz-border-radius: 10px;
         webkit-border-radius:10px;
         display: inline;
         margin-bottom: :25px;
         color: white;
         }
      </style>
      <%-- <%@include file="userNewTemplateCss.jsp" %> --%>
      <%@include file="newtemplateDataTableCss.jsp" %>
   </head>
   <body>
      <div id="loaderstart" class="loader" style="display: none;"></div>
      <div id="wrapper">
      <!-- Navigation -->
      <%@include file="usernewleftmenu.jsp" %>
      <div id="page-wrapper">
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
                     My Exams
                  </div>
                  <!-- /.panel-heading -->
                  <div class="panel-body">
                <%--      <form:form modelAttribute="userstartexam" id="testform" method="POST" action="load-ExamForm" > --%>
                        <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example" style="font-size: 12px;">
                           <thead>
                              <tr>
                                 <th>EXAM</th>
                                 <th title="Subject"> SUBJ</th>
                                 <th> DATE</th>
                                 <th>START <span class="glyphicon glyphicon-time"></span></th>
                                 <th>END <span class="glyphicon glyphicon-time"></span></th>
                                 <th>ACTION</th>
                                 <th>INSTRUCTIONS</th>
                              </tr>
                           </thead>
                           <tbody>
                              <c:forEach items="${questionlist}" var="displayexam" varStatus="packageloop">
                                 <c:set var="expDate" value="${displayexam.enddate}">
                                 </c:set>
                                 <c:set var="slotdate" value="${displayexam.slotdate}">
                                 </c:set>
                                 <c:set var="slotstarttime" value="${displayexam.starttime}">
                                 </c:set>
                                 <c:set var="slotendtime" value="${displayexam.endtime}">
                                 </c:set>
                                 <%
                                    /*  response.setIntHeader("Refresh", 5); */
                                    String exDate=(String)pageContext.getAttribute("expDate");
                                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS"); 
                                    Date currentdate = new Date();
                                    
                                    String srsdate=dateFormat.format(currentdate);
                                    System.out.println(srsdate);
                                    pageContext.setAttribute("exdate", exDate);
                                    String slotdate=(String)pageContext.getAttribute("slotdate");
                                    DateFormat dateformat1=new SimpleDateFormat("yyyy-MM-dd" );
                                     Date currentdate1 = new Date();
                                        String sysdate=dateformat1.format(currentdate1);
                                        DateFormat fmt = new SimpleDateFormat("kk:mm:ss");
                                        String currenttime = fmt.format(new Date());
                                        
                                         String slotstarttime=(String)pageContext.getAttribute("slotstarttime");
                                         String slotendtime=(String)pageContext.getAttribute("slotendtime");
                                    
                                    pageContext.setAttribute("exdate", exDate);
                                    pageContext.setAttribute("srsdate", srsdate);
                                    pageContext.setAttribute("sysdate", sysdate);
                                    pageContext.setAttribute("slotdate", slotdate);
                                    pageContext.setAttribute("slotstarttime", slotstarttime);
                                    pageContext.setAttribute("slotendtime", slotendtime);
                                    pageContext.setAttribute("currenttime", currenttime);
                                    
                                     %>
                                 <c:if test="${!((slotdate > sysdate || slotdate < sysdate) || (slotendtime<=currenttime)) }" >
                                    <tr>
                                       <td style="font-weight: bold;"> ${displayexam.examname}-${displayexam.exam_type}</td>
                                       <td style="font-weight: bold;">
                                          <c:forEach items="${displayexam.sublist}" var="sublist"> ${sublist}
                                          </c:forEach>
                                       </td>
                                       <td style="font-weight: bold;"> ${displayexam.slotdate}</td>
                                       <td style="font-weight: bold;"> ${displayexam.starttime}</td>
                                       <td style="font-weight: bold;"> ${displayexam.endtime}</td>
                                       <c:forEach items="${displayexam.subidlist}" var="subidlist" varStatus="stat">
                                          <c:set var="myVar" value="${stat.first ?'' : myVar} ${subidlist}" />
                                       </c:forEach>
                                       <c:set var="srsdate" value="${srsdate}"> </c:set>
                                       <c:set var="exdate" value="${exdate}"> </c:set>
                                       <td>
                                          <c:if test="${(slotdate > sysdate || slotdate < sysdate) || (slotendtime<=currenttime) }" >
                                             <label style="color: red;">Exam Expired</label>
                                          </c:if>
                                          <c:if test="${displayexam.exam_status == 'NotStarted'}">
                                             <c:if test="${(slotdate == sysdate)&&((currenttime == slotstarttime)|| (slotstarttime <  currenttime)&&(currenttime <=  slotendtime))}" >
                                                <%-- <td> <button class="btn-primary" id="popup2" onclick="return packageexam_div_show('packageExam${packageloop.index}');"> Start Exam </button></td> --%>
                                             <c:if test="${displayexam.patterntypeid==1}">
                                              <a href="load-slotInstructions?exam=${displayexam.examname},start,${myVar}">   <button id="start_${packageloop.index}" class="btn btn-primary" style="background-color: #5C99C8;border:thin;color: white; font-weight: bold;border-radius:20px ; width: 115px;" value="${displayexam.examname},start,${myVar}"  name="exam" onclick="return startloader();">Start Exam</button></a>                                                <%-- <button class="btn-primary" style="background-color: #5C99C8;border:thin;color: white; font-weight: bold; " value="${displayexam.examname},start,${myVar}"  name="exam" >Start Exam</button> --%>
                                            </c:if>
                                          
                                               <c:if test="${displayexam.patterntypeid!=1}">
                                             <a href="load-ExamForm?exam=${displayexam.examname},start,${myVar}"><button id="start_${packageloop.index}" class="btn-primary" 
                                                style="padding: 5px 10px;
                                                font-size: 15px;
                                                text-align: center;
                                                cursor: pointer;
                                                outline: none;
                                                color: #fff;
                                                background-color: #5C99C8;
                                                border: none;
                                                border-radius:20px ;
                                                font-weight: bold;"
                                                onclick="return startloader();">START EXAM</button></a>
                                                </c:if>
                                            
                                             </c:if>
                                          </c:if>
                                          <c:if test="${displayexam.exam_status == 'start'}">
                                             <c:if test="${(slotdate == sysdate)&&((currenttime == slotstarttime)|| (slotstarttime <  currenttime)&&(currenttime <=  slotendtime))}" >
                                                <%-- <td> <button class="btn-primary" id="popup2" onclick="return packageexam_div_show('packageExam${packageloop.index}');"> Start Exam </button></td> --%>
                                             <c:if test="${displayexam.patterntypeid==1}">
                                             <a href="load-slotInstructions?exam=${displayexam.examname},restart,${myVar}">     <button class="btn btn-primary"  style="padding: 5px 10px;
                                                   text-align: center;
                                                   cursor: pointer;
                                                   outline: none;
                                                   color: #fff;
                                                   background-color: #4CAF50;
                                                   border: none;
                                                   border-radius:20px ;
                                                   font-weight: bold;" value="${displayexam.examname},restart,${myVar}"  name="exam" id="exam"  onclick="return startloader();"> Resume Exam</button></a>
                                                   </c:if>
                                                   
                                                      <c:if test="${displayexam.patterntypeid!=1}">
                                           <a href="load-ExamForm?exam=${displayexam.examname},restart,${myVar}">
                                             <button class="btn-primary"  
                                                style="padding: 5px 10px;
                                                font-size: 15px;
                                                text-align: center;
                                                cursor: pointer;
                                                outline: none;
                                                color: #fff;
                                                background-color: #4CAF50;
                                                border: none;
                                                border-radius:20px ;
                                                font-weight: bold;" 
                                                value="${displayexam.examname},restart,${myVar}"  name="exam" id="exam" onclick="return startloader();" > RESUME EXAM</button>
                                        </a>
                                          </c:if>
                                                   
                                             </c:if>
                                          </c:if>
                                          <c:if test="${displayexam.exam_status == 'Finish'}">
                                             <c:if test="${(slotdate == sysdate)&&((currenttime == slotstarttime)|| (slotstarttime <  currenttime)&&(currenttime <=  slotendtime))}" >
                                                <label style="color: red;">Exam Completed</label>
                                             </c:if>
                                          </c:if>
                                       </td>
                                       <td><button type="button" id="start_${packageloop.index}" class="btn btn-primary" data-toggle="modal" data-target="#myModal_${packageloop.index}" style=" display: block;
                                          width: 120px;
                                          height: 30px;
                                          background: #4E9CAF;
                                          padding: 5px;
                                          text-align: center;
                                          border-radius: 5px;
                                          color: white;
                                          font-weight: bold;text-transform: uppercase;text-decoration: none;" onclick="getInstructionDetails('${displayexam.examname}',${packageloop.index},${displayexam.patterntypeid});">Instructions</button></td>
                                       <div class="modal fade" id="myModal_${packageloop.index}">
                                          <div class="modal-dialog">
                                             <div class="modal-content">
                                                <!-- Modal Header -->
                                                <div class="modal-header">
                                                   <center>
                                                      <h1 style="margin-top: 0px;height: 5px;font-weight: lighter;padding-top: 10px ">Exam Instructions</h1>
                                                   </center>
                                                   <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                </div>
                                                <!-- Modal body -->
                                                <div class="modal-body">
                                                   <p style="font-weight:bold;text-decoration: underline; ">Read the following instructions carefully</p>
                                                   <div><label id="results_${packageloop.index}"></label></div>
                                                   <div id="gatepattern_${packageloop.index}" style="display: none">
                                                      <p>1.Total duration of the examination is <label>${displayexam.testduration} HOURS</label>.</p>
                                                      <p>2.The clock will be set at the server. The countdown timer at the top, right-hand side of the screen will display the time available for you to complete the examination. When the timer reaches zero, the examination will end automatically. You will not be required to end or submit your examination..</p>
                                                      <p>3.The Question Palette displayed on the right-hand side of the screen will show the status of each question using one of the following symbols:</p>
                                                      <span class="collapse_icon"></span>
                                                      <div class="diff_type_notation_area_outer">
                                                         <div class="diff_type_notation_area_inner">
                                                            <div class="notation_type_description">
                                                               <p><span class="not_visited notVisitedCount">N</span> <span class="type_title notVisitedLabel longtext-hide" id="" title="Not Visited">This question has not been answered yet.</span></p>
                                                               <br>
                                                               <p><span class="not_answered notAnsweredCount">V</span> <span class="type_title notAnsweredLabel longtext-hide" id="" title="Not Answered">This question has been visited but not answered.</span></p>
                                                               <br>
                                                               <p><span class="answered answeredCount" >A</span> <span class="type_title answeredLabel longtext-hide" id="" title="Answered">This question has been answered and will be considered for evaluation.</span></p>
                                                               <br>
                                                               <p><span class="review markedCount" >0</span> <span class="type_title markedLabel longtext-hide" id="" title="Marked for Review">This question has been marked for review and has not been answered.</span></p>
                                                               <br>
                                                               <p><span class="review_marked markedReviewCount" >0</span><span class="type_title markedAndAnsweredLabel" id="" title="Answered &amp; Marked for Review">This question has been marked for review and has been answered.</span></p>
                                                               <br>
                                                            </div>
                                                         </div>
                                                      </div>
                                                      <p style="font-weight: bold;text-decoration: underline;">
                                                         Navigating to a Question:
                                                      </p>
                                                      <p>4.Click on the question number in the Question Palette to go to that particular question directly.</p>
                                                      <p>5.You can view all the questions by clicking on the Question Paper button that appears at top, right-hand side of the screen.</p>
                                                      <p style="font-weight: bold;text-decoration: underline;">Answering a Question :</p>
                                                      <p><b>Procedure for answering a multiple choice type question (MCQ) :</b></p>
                                                      <p>a.To select your answer, click on the button of the corresponding option.</p>
                                                      <p>b.To deselect your chosen answer, click on the button of the chosen option once again or click on the Clear Response button.</p>
                                                      <p>c.To change your chosen answer, click on the button of the newly identified answer.</p>
                                                      <p><b>Procedure for answering a numerical answer type (NAT) question:</b></p>
                                                      <p>a.To enter a numerical answer, use the virtual numeric keypad that appears below the question.</p>
                                                      <p>b.A fractional number in the decimal notation (e.g. -0.3 or -.3) can be entered as an answer with or without '0' before the decimal point.</p>
                                                      <p>c.To clear your answer, click on the Clear Response button.</p>
                                                      <p style="font-weight: bold;text-decoration: underline;">Saving your answer:</p>
                                                      <p>7.To save your answer, You just need to select the answer it will be saved.</p>
                                                      <p>8.After the elapse of time scheduled for the examination, all the answers (including those Answered and Marked for Review) will be automatically submitted.</p>
                                                      <p style="font-weight: bold;text-decoration: underline;">Navigating through sections:</p>
                                                      <p>9.Sections in this question paper are displayed above the Question Area. Questions in a section can be viewed by clicking on the section name. The section you are currently viewing is highlighted.</p>
                                                      <p>10.clicking on move to next subject you will navigate to that page.</p>
                                                      <p>11.You can shuffle between sections and questions anytime during the examination.</p>
                                                      <p>12.You can see the section summary as a part of the legend appearing above the Question Palette of every section.</p>
                                                   </div>
                                                   <div id="tetpattern_${packageloop.index}"  style="display: none">
                                                      <p>1. Total duration of the examination is <label>${displayexam.testduration} HOURS</label>.</p>
                                                      <p>2. In single answer type you can select any one answer.</p>
                                                      <p>3. In multi answer type you can select multiple answer.</p>
                                                      <p>4. In matrix match you can select multiple answers by holding
                                                         ctrl key.
                                                      </p>
                                                      <p>5. In comprehension type question will be continued and
                                                         paragraph will be in first question.
                                                      </p>
                                                      <p>6. Next and Previous Button are available on top of the
                                                         question.
                                                      </p>
                                                      <p>7. You can navigate to particular question on clicking
                                                         particular number.
                                                      </p>
                                                      <p>8. You can go to next subject by clicking the next tab.</p>
                                                      <p>9. You can check your question status.If its color is green
                                                         than it is attempted.
                                                      </p>
                                                      <p>10. If its color is yellow than it is Tagged.</p>
                                                      <p>11. If its color is not colored than it is not attempted or not
                                                         visited.
                                                      </p>
                                                      <p>12. You can check number of question attempted count,un-attempt
                                                         count on top of screen.
                                                      </p>
                                                      <p>13. If your Exam gets terminated due to power failure or system
                                                         crash you can resume your exam.
                                                      </p>
                                                      <p>14. After completing your exam and analysis you need to logout.
                                                      </p>
                                                      <p style="color: red;">15. Do not refresh your page during exam.</p>
                                                      <p style="color: red;">16. Please do not double click on the start
                                                         exam button.
                                                      </p>
                                                   </div>
                                                </div>
                                                <!-- Modal footer -->
                                                <div class="modal-footer">
                                                   <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                                                </div>
                                             </div>
                                          </div>
                                       </div>
                                    </tr>
                                 </c:if>
                              </c:forEach>
                           </tbody>
                        </table>
                  <%--  </form:form>  --%>
                     <!-- /.table-responsive -->
                  </div>
                  <!-- /.panel-body -->
               </div>
               <!-- /.panel -->
            </div>
            <!-- /.col-lg-12 -->
         </div>
         <!-- /.col-lg-6 -->
      </div>
      <!-- /#wrapper -->
      <%@ include file="newtemplateDataTableJs.jsp" %>
      <script>
         $(document).ready(function() {
             $('#dataTables-example').DataTable({
                 responsive: true,
                 "order": [[ 3, "asc" ]]
             });
         });
      </script>
   </body>
</html>