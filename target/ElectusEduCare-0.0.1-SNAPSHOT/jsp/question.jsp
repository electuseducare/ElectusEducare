<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <%@include file="DisplayLogo.jsp" %>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <style type="text/css">
         .pg-normal {
         font: bold 11px Arial;
         text-decoration: none;
         background-color:#020D56;
         color: #FFFFFF;
         padding: 6px 8px 6px 8px;
         border-top: 1px solid #CCCCCC;
         border-right: 1px solid #333333;
         border-bottom: 1px solid #333333;
         border-left: 1px solid #CCCCCC;
         cursor: pointer;
         margin: 2px;
         display:inline-block;
         }
         .pg-selected {
         font: bold 11px Arial;
         text-decoration: none;
         background-color: #ff0000;
         color: #333333;
         padding: 6px 8px 6px 8px;
         border-top: 1px solid #CCCCCC;
         border-right: 1px solid #333333;
         border-bottom: 1px solid #333333;
         border-left: 1px solid #CCCCCC;
         cursor: pointer;
         }
         .button {
         font: bold 11px Arial;
         text-decoration: none;
         background-color: #020D56;
         color: #FFFFFF;
         padding: 8px 10px 8px 10px;
         border-top: 1px solid #CCCCCC;
         border-right: 1px solid #333333;
         border-bottom: 1px solid #333333;
         border-left: 1px solid #CCCCCC;
         }
         .pg-answered	 {
         font: bold 11px Arial;
         text-decoration: none;
         background-color: green;
         color: #333333;
         padding: 6px 8px 6px 8px;
         border-top: 1px solid #CCCCCC;
         border-right: 1px solid #333333;
         border-bottom: 1px solid #333333;
         border-left: 1px solid #CCCCCC;
         cursor: pointer;
         }
         input[type=radio] {
         cursor: pointer;
         }
         input[type=radio] + label {
         color: black;
         font-style: italic;
         } 
         input[type=radio]:checked + label {
         color: blue;
         font-style: normal;
         } 
         .applycss{
         color: #fffefc;
         font-family: "Times New Roman", Times, serif;
         font-weight: bold;
         font-size: 6 px;
         }
         div.new{
         }  
         .black_overlay {
         background-color:black; opacity: 0.65;
         }
      </style>
      <script>
         function unattemptcount()
         {
         	var noqns = document.getElementById("noOfqbns").value;
         	optionsById(noqns);
         	var sid =  document.getElementById('stu').value;
         	var subjecttypeid=document.getElementById('subject').value;
         	var examname = document.getElementById('examname').value;
         	var urls="load-unattemptcount?exmname="+examname+"&studentid="+sid+"&subjid="+subjecttypeid+"";    
         
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
         	  //alert(xmlhttp.responseText);
         	    //document.getElementById("err").style.color="red";
                  document.getElementById("wlg").innerHTML=xmlhttp.responseText; 
           // alert("req");
             }
           }
         xmlhttp.open("POST",urls,true);
         xmlhttp.send(); 
         }
         
         
          function preventBack(){window.history.forward();}
         setTimeout("preventBack()", 0);
         window.onunload=function(){null}; 
         document.addEventListener('contextmenu', event =event.preventDefault());
      </script>
      <script type="text/javascript">
         var qidval ;
         var ret_rev ;
         var n_que=new Array();
         
         function atleastQById(qid) {
         
         	attempted(qid);
         		
         }
         function attempted(qid){
         	qidval = true;
         		
         }
         function storeAndRetrieve() {
         	var storenum =4;
             ret_rev = true;
         }
         
         function Pager(tableName, itemsPerPage) {
             this.tableName = tableName;
             this.itemsPerPage = itemsPerPage;
             this.currentPage = 1;
             this.pages = 0;
             this.inited = false;
             
             this.showRecords = function(from, to) {        
                 var rows = document.getElementById(tableName).rows;
                 // i starts from 1 to skip table header row
                 for (var i = 0; i < rows.length; i++) {
                     if (i < from || i > to)  
                         rows[i].style.display = 'none';
                     else
                         rows[i].style.display = '';
                    
                      if($('input[type=radio]:checked', rows[i]).length)
                    
                     	//document.getElementById('pg'+this.currentPage).className = 'pg-selected';
                     	rows[i].style.color='orange';
                     else
                     	//document.getElementById('pg'+this.currentPage).className = 'pg-normal';
                     	rows[i].style.color='maroon'; 
                 }
             }
             this.showPage = function(pageNumber) {
              if (! this.inited) {
              // alert("not inited");
               return;
              }
              
              if(ret_rev) {
             	 this.currentPage=4;
             	 ret_rev=false;
             	 return;
              }
              
              
         
              var oldPageAnchor = document.getElementById('pg'+this.currentPage);
              oldPageAnchor.className = 'pg-normal';
              this.currentPage = pageNumber;
                    
              	var newPageAnchor = document.getElementById('pg'+this.currentPage);
             	newPageAnchor.className = 'pg-selected';
             	
             	if(qidval){
            		 n_que.push(pageNumber);
            		  oldPageAnchor.className = 'pg-answered';
            		// var selval = getvalue(pageNumber);
                    
                	 qidval=false;
            	 } 
         
                  var from = (pageNumber - 2) * itemsPerPage + 1;
                  var to = from + itemsPerPage-1;
                  this.showRecords(from, to);
             
             } 
             this.prev = function() {
                 if (this.currentPage > 1)
                     this.showPage(this.currentPage - 1);
             }
              
             this.next = function() {
                 if (this.currentPage < this.pages) {
                     this.showPage(this.currentPage + 1);
                    
                 }
             }                        
              
             this.init = function() {
                 var rows = document.getElementById(tableName).rows;
                 var records = (rows.length); 
                 this.pages = Math.ceil(records / itemsPerPage);
                 this.inited = true;
             }
             
             this.pages = function(){
             	//alert("DFDASF");
             }
             
         
          
             this.showPageNav = function(pagerName, positionId) {
              if (! this.inited) {
               //alert("not inited");
               return;
              }
             
              var element = document.getElementById(positionId);
             
              var pagerHtml = '<span onclick="' + pagerName + '.prev(); unattemptcount();" class="pg-normal"> « Prev </span> &nbsp;  ';
                
              for (var page = 1; page <= this.pages; page++) 
                     pagerHtml += '<span id="pg' + page + '" class="pg-normal" onclick="' + pagerName + '.showPage(' + page + '); unattemptcount();">' + page + '</span>  ';
                     pagerHtml += '<span onclick="'+pagerName+'.next(); unattemptcount();" class="pg-normal"> &nbsp; Next »</span>';            
                   
                 element.innerHTML = pagerHtml;
             }
         	
         }
         
          
         function insertBookmarkID(bookmark, item_autoinc)
         {
         var xmlhttp;
         var qid=bookmark;
         var autoincr = item_autoinc;
         
         var subjectid=document.getElementById("subject").value;
         var examname=document.getElementById("examname").value;
         var locationid=document.getElementById("location_id").value;
         var classid=document.getElementById("class_id").value;
         var sectionid=document.getElementById("section_id").value;
         var branchid=document.getElementById("branch_id").value;
         var studentid=document.getElementById("stu").value;
         
         
         var urls="load-questionid-bookmark?ver="+qid+"&subjectid="+subjectid+"&examname="+examname+"&locationid="+locationid+"&classid="+classid+"&sectionid="+sectionid+"&branchid="+branchid+"&studentid="+studentid;
         
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
         	  
                 document.getElementById(autoincr).innerHTML=xmlhttp.responseText;
                
             }
          
           }
         xmlhttp.open("POST",urls,true);
         xmlhttp.send();
         }
         
         function startTimer(duration, display) {
             var timer = duration, minutes, seconds;
             
             setInterval(function () {
                 minutes = parseInt(timer / 60, 10);
                 seconds = parseInt(timer % 60, 10);
         
                 minutes = minutes < 10 ? "0" + minutes : minutes;
                 seconds = seconds < 10 ? "0" + seconds : seconds;
                 var hours   = Math.floor(timer / 3600) % 24;
                 var hourslength = hours.toString().length;
                 if(hourslength==1){
                 	hours="0"+hours;
                 }
                 var minutes = Math.floor(timer / 60) % 60;
                 var minuteslength = minutes.toString().length;
                 if(minuteslength==1){
                 	minutes="0"+minutes;
                 }
                 var seconds = timer % 60  ;
                 var secondslength = seconds.toString().length;
                 if(secondslength==1){
                 	seconds="0"+seconds;
                 }
                 display.textContent = hours +":"+minutes+":"+seconds;
         
                 if (--timer < 0) {
                 	 var totaltime = document.getElementById("totalqtime").value;
                      document.getElementById("timeqtaken").value=totaltime;
                      document.getElementById("suspendexams").value="autosubmit";
                      
                 	 document.getElementById("springform").submit();
                     timer = duration;
                     
                 }
             }, 1000);
         }
         
         window.onload = function () {
         	unattemptcount();
         	document.getElementById("suspendexams").value="manualsubmit";
         
         	var noqns = document.getElementById("noOfqbns").value;
         	optionsById(noqns);
         	var qtime = document.getElementById("timeqval").value;
         	var a = qtime.split(':'); // split it at the colons
         
         	// minutes are worth 60 seconds. Hours are worth 60 minutes.
         	var seconds = (+a[0]) * 60 * 60 + (+a[1]) * 60 + (+a[2]);
         	
             var fiveMinutes = seconds;
             
                 display = document.querySelector('#time');
             startTimer(fiveMinutes, display);
         }
         
         function stopSuspendTime() {
         	
             var sttime = document.getElementById("time").innerHTML;
             document.getElementById("timeqtaken").value=sttime;
             
         	
         }
         
         function stopFinishTestTime() {
         	
         	var sttime = document.getElementById("time").innerHTML;
             document.getElementById("timeqtaken").value=sttime;
         }
         
         
         function optionsById(s) {
         	
         	 var attemtedcount = document.getElementById('wlg').innerHTML;
         		
         	 if(attemtedcount >  0 ){
         	 var ctr= parseInt(attemtedcount);
         	 var n = 	 ctr;  
         	 } else {
         		 var n = 0;
         	 } 
         	 
         	 var w = s -n;
              var text =  "<u>Question Status: </u> Qns Anwsered:  "+ n  + "|| Remaining Qns: "+w+"";
          	 document.getElementById("questions").innerHTML =text ;
         }
         
         
         
      </script>
      <style>
         /*----------------------------------------------
         CSS settings for HTML div Exact Center
         ------------------------------------------------*/
         #finishabc {
         width:100%;
         height:100%;
         opacity:.95;
         top:0;
         left:0;
         display:none;
         position:fixed;
         background-color:transparent;
         overflow:auto;
         }
         #suspendabc {
         width:100%;
         height:100%;
         opacity:.95;
         top:0;
         left:0;
         display:none;
         position:fixed;
         background-color:transparent;
         overflow:auto;
         }
         img#close {
         position:absolute;
         right:0px;
         top:0px;
         cursor:pointer
         }
         img#close1 {
         position:absolute;
         right:0px;
         top:0px;
         cursor:pointer
         }
         div#popupContact {
         position:absolute;
         left:40%;
         width:50%;
         height:30%;
         top:35%;
         margin-left:-202px;
         -moz-box-shadow: 20px 20px 20px 20px #888;
         -webkit-box-shadow: 20px 20px 20px 20px#888;
         box-shadow: 20px 20px 10px #888888;
         font-family:'Raleway',sans-serif;
         background-color: #e6f7ff;
         }
      </style>
      <script>
         //Function To Display Popup
         function finish_div_show() {
         document.getElementById('finishabc').style.display = "block";
         return false;
         }
         //Function to Hide Popup
         function finish_div_hide(){
         document.getElementById('finishabc').style.display = "none";
         }
         
         function cancel_Finish(){
         	document.getElementById('finishabc').style.display = "none";
         	return false;
         }
         
         //Function To Display Popup
         function suspend_div_show() {
         
         document.getElementById('suspendabc').style.display = "block";
         return false;
         
         }
         //Function to Hide Popup
         function suspend_div_hide(){
         document.getElementById('suspendabc').style.display = "none";
         }
         
         function cancel_Suspend(){
         	document.getElementById('suspendabc').style.display = "none";
         	return false;
         }
         function saveExamStatus_ByQid(selectvalue,qvalue)
         {
         	
         	display = document.querySelector('#time').innerHTML;
         	var timeid= display;
         	
         //	var subjecttypeid=document.getElementById('subject').value;
         //alert(timeid);
         	var sid =  document.getElementById('stu').value;
         
         
         	var examname = document.getElementById('examname').value;
         	
         //	var subjecttypeid =	document.getElementById('extype').value;
         	var qid =qvalue;
         	var subjecttypeid=document.getElementById('subject').value;
         	var lct =  document.getElementById('location_id').value;
         	var brc = document.getElementById('branch_id').value;
         	var cls =document.getElementById('class_id').value;
         	var sect =document.getElementById('section_id').value;
         	
         	
         	var urls="load-examStatusqid?qidval="+selectvalue+"&stu="+sid+"&subj="+subjecttypeid+"&exmname="+examname+"&qbyidval="+qid+"&timeid="+timeid+"&locid="+lct+"&brcid="+brc+"&clsid="+cls+"&seid="+sect;    
         
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
                 /* document.getElementById("wlg").innerHTML=xmlhttp.responseText; */
           // alert("req");
                 unattemptcount();
             }
           }
         xmlhttp.open("POST",urls,true);
         xmlhttp.send(); 
         }
         
         //disable right click
         document.addEventListener('contextmenu', event => event.preventDefault());
      </script>
      <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>  
      <script type="text/javascript">  
         $(function () {  
             $(document).keydown(function (e) {  
                 return (e.which || e.keyCode) != 116;  
             });  
         });  
      </script>  
      <style type="text/css">
         .sample
         {
         border:2px solid #a1a1a1;
         background:#dddddd;
         width:300px;
         height:35px;
         padding:2px;
         border-radius:25px;
         margin-top: 10px;
         }
      </style>
      <title>Electus Educare</title>
   </head>
   <body >
      <%@include file="userExamHeader.jsp" %>
      <div id="wlg" style="display: none"></div>
      <Table width="100%">
         <tr>
            <td width="5%"></td>
            <td>
               <div id="form" class="sample" style="width:100%;">
                  <fieldset>
                     <table>
                        <tr>
                           <td width="50%" style="text-align: left;">
                              <legend style="color:blue;font-weight:bold; font-size: 14px;">
                                 <u>Exam Info:</u>  
                                 Exam Name: ${examname} ||
                                 <c:if test = "${msg==null}"> Total Qns: ${nofques}  || </c:if>
                                 <c:if test = "${msg!=null}"> Total Qns: ${nofques}|| </c:if>
                                 <c:if test = "${msg==null}"> Subject: ${subjectname}</c:if>
                              </legend>
                           </td>
                           <td width="50%" style="text-align: right;">
                              <legend style="color:blue;font-weight:bold; font-size: 14px;" id="questions" >Question Status</legend>
                           </td>
                        </tr>
                     </table>
                  </fieldset>
               </div>
            </td>
            <td width="5%"></td>
         </tr>
      </Table>
      <div class="row">  </div>
      <c:if test = "${msg==null}">
         <div style="width: 10%; float:left;">&nbsp;	</div>
         <div style="width: 70%; float:left;">
            <div class = "col-lg-4" style="width: 100%;">
               <div id="pageNavPosition"> </div>
            </div>
         </div>
      </c:if>
      <c:if test = "${msg!=null}">
         <table align="center" style="color: red;">
            <tr>
               <td>  ${msg} </td>
            </tr>
         </table>
      </c:if>
      <c:if test = "${msg==null}">
         <div style="width: 13%; float:left; background-color: #ffffff; border-color: black;">	
            <img src="${pageContext.request.contextPath}/theme/images/clock.gif" style="height:40px; width:40px;"/> 
            <span id="time" style="color: black; font-size:210%;font-weight:bold; vertical-align: middle;">  </span>
         </div>
      </c:if>
      <div style="width: 7%; float:left;">  </div>
      <div class="row"></div>
      <div style="width: 10%; float:left;">  &nbsp;	</div>
      <div style="width: 80%; float:left;" id="contentmodel">
         <form:form modelAttribute="qp" id="springform" method="POST" action="load-qform">
            <input type="hidden" id="totalqtime" name="totalqtime" value="${totalqtime}">
            <input type="hidden" id="timeqtaken" name="timeqtaken" >
            <input type="hidden" name="noOfqbns" id="noOfqbns" value="${nofques}">
            <input type="hidden" name="suspendexams" id="suspendexams"/>
            <input type="hidden" name="subject" id="subject" value="${subject}"/>
            <input type="hidden" name="examname" id="examname" value="${examname}"/>
            <input type="hidden" name="sid" id="stu" value="${stuid}"/>
            <input type="hidden" name="location_id" id="location_id" value="${location_id}"/>
            <input type="hidden" name="branch_id" id="branch_id" value="${branch_id}"/>
            <input type="hidden" name="class_id" id="class_id" value="${class_id}"/>
            <input type="hidden" name="section_id" id="section_id" value="${section_id}"/>
            <input type="hidden" name="subjectname" value="${subjectname}"/>
            <input type="hidden" id="timeqval" name="timeqval" value="${time_val_q}">
            <table  id="results" width="100%">
               <% int bookmarkqutoInc = 9000; %>        
               <c:forEach items="${qp.list}" var="row1" varStatus="loop">
                  <input type="hidden" name="reg_id" value="${row1.exam_reg_id}"> 
                  <tr>
                     <td colspan = "2">
                        <div class = "col-lg-4" style = "width:100%">
                           <div class = "panel panel-info">
                              <div class = "panel-heading">
                                 <b>	Question ${loop.index + 1} : </b> 
                                 <form:hidden path="list[${loop.index}].displayquest" value= "${row1.ques}" class="form-control"/>
                                 <label> ${row1.ques} </label>
                              </div>
                              <div class = "panel-body">
                                 <table width = "100%" id = "optionsTable">
                                    <c:forEach items = "${row1.optionsList}" var = "options" varStatus = "i">
                                       <tr>
                                          <td width="2%">
                                             <TABLE width="100%">
                                                <c:choose>
                                                   <c:when test = "${row1.typeOfQuestion == 'Single answer'}">
                                                      <tr>
                                                         <td width="5%" style="font-weight: bold;" valign="baseline"> ${options.optionType} ) </td>
                                                         <td width="95%" align="left" valign="baseline">
                                                            <form:radiobutton path = "list[${loop.index}].options" value = "${options.optionType}" onclick="atleastQById(this.id);saveExamStatus_ByQid(this.value,${row1.question_id}); optionsById(${nofques});"/>
                                                            <label for="list[${loop.index}].options"> ${options.option} </label>
                                                         </td>
                                                      </tr>
                                                   </c:when>
                                                   <c:when test = "${row1.typeOfQuestion == 'Single type'}">
                                                      <tr>
                                                         <td  width="5%" style="font-weight: bold;" valign="baseline"> ${options.optionType} ) </td>
                                                         <td  width="95%" align="left" valign="baseline">
                                                            <form:radiobutton path = "list[${loop.index}].options" value = "${options.optionType}" onclick="atleastQById(this.id);saveExamStatus_ByQid(this.value,${row1.question_id}); optionsById(${nofques});"/>
                                                            <label for="list[${loop.index}].options"> ${options.option} </label> 
                                                         </td>
                                                      </tr>
                                                   </c:when>
                                                   <c:when test = "${row1.typeOfQuestion == 'Multiple answers'}">
                                                      <tr>
                                                         <td  width="5%" style="font-weight: bold;" valign="baseline"> ${options.optionType} ) </td>
                                                         <td  width="95%" align="left" valign="baseline">
                                                            <form:checkbox path = "list[${loop.index}].options" value = "${options.optionType}" onclick="atleastQById(this.id);saveExamStatus_ByQid(this.value,${row1.question_id}); optionsById(${nofques});"/>
                                                            <label for="list[${loop.index}].options"> ${options.option} </label> 
                                                         </td>
                                                      </tr>
                                                   </c:when>
                                                </c:choose>
                                             </TABLE>
                                          </td>
                                       </tr>
                                    </c:forEach>
                                    <tr>
                                       <td colspan="2">
                                          <form:input path="list[${loop.index}].actualAnswer" value="${row1.answer}"/>
                                          <%-- Answer: ${row1.answer} --%>
                                       </td>
                                    </tr>
                                    <tr>
                                       <td colspan="2">
                                          <form:hidden path="list[${loop.index}].bquestion_id" id="bquestion_id" value="${row1.question_id}"/>
                                          <%-- Question ID: ${row1.question_id} --%>
                                       </td>
                                    </tr>
                                    <div id="log"> </div>
                                 </table>
                              </div>
                           </div>
                        </div>
                        <div class="panel-footer" style="width:100%">
                           <table width="100%">
                              <tr>
                                 <td align="left"> 
                                    <a href="#" id="${row1.question_id}"  class="button" onclick="insertBookmarkID(${row1.question_id}, <%=bookmarkqutoInc%>);"> Bookmark  </a>  
                                 <td id="<%=bookmarkqutoInc%>" style="color: blue; font-weight: bold;" align="center"> </td>
                              </tr>
                           </table>
                        </div>
                     </td>
                  </tr>
                  <% bookmarkqutoInc++; %>
               </c:forEach>
            </table>
            <c:if test = "${msg==null}">
               <div class="panel-footer" style="width: 100%">
                  <table width="100%">
                     <tr>
                        <td align="center"> <button class="btn-primary" id="popup" onclick="return finish_div_show();">Finish Test</button>  </td>
                     </tr>
                  </table>
               </div>
               <div id="finishabc" style="overflow:hidden;">
                  <div id="popupContact" >
                     <div class="panel" style="width: 100%; background-color: #117584;">
                        <div class="panel-heading"  style="font-size: 18px;font-weight: bold; color: #ffffff; ">Finish Exam</div>
                     </div>
                     <table width="100%" height="65%">
                        <tr>
                           <td valign="middle" align="center" colspan="2" style="font-weight: bold; color: #00004d;"> Do you want to submit your exam? </td>
                        </tr>
                        <tr>
                           <td valign="middle" align="center" colspan="2" style="font-weight: bold; color: #00004d;"> If 'YES' please click on Finish Test. If 'NO' click on Cancel. </td>
                        </tr>
                        <tr>
                           <td align="left" width="50%" valign="bottom">  
                              <button class="button btn-primary" style="margin-top:40px; margin-left:180px;background-color:#0E8DE2;color: white; font-weight: bold; " name="actionform" value="finishtest" onclick="stopFinishTestTime();"> Finish Test </button> 
                           </td>
                           <td align="right" width="50%" valign="bottom">
                              <button class="button btn-primary" style="margin-top:40px; margin-right:180px;background-color:#0E8DE2;color: white; font-weight: bold; " id="cancelFinish" onclick="return cancel_Finish();">Cancel</button>
                           </td>
                        </tr>
                     </table>
                  </div>
               </div>
            </c:if>
            <div id="unanswered">
            </div>
         </form:form>
      </div>
      <div style="width: 10%; float:left;"> </div>
      <script type="text/javascript">
         var pager = new Pager('results', 1); 
            pager.init(); 
            pager.showPageNav('pager', 'pageNavPosition'); 
            pager.showPage(1);
            
      </script>
   </body>
</html>