<%@taglib  uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<!-- Template by html.am -->
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
      <title>Electus Resume Exam</title>
      <%@include file="DisplayLogo.jsp"%>
      <%@include file="QuestionpageScripts.jsp"%>
      <%@include file="QuestionpageCss.jsp"%>
      <%@include file="QuestionpageJs.jsp"%>
      <%@include file="ResumeExamRRBSlotJsScripts.jsp"%>
      <style>
         *:fullscreen
         *:-ms-fullscreen, *:-webkit-full-screen, *:-moz-full-screen {
         overflow: auto !important;
         }
         /* The Modal (background) */
         .modal3 {
         display: none;
         position: fixed; /* Stay in place */
         z-index: 1; /* Sit on top */
         padding-top: 100px; /* Location of the box */
         left: 0;
         top: 0;
         width: 100%; /* Full width */
         height: 100%; /* Full height */
         overflow: auto; /* Enable scroll if needed */
         background-color: rgb(0, 0, 0); /* Fallback color */
         background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
         }
         /* Modal Content */
         .modal-content3 {
         background-color: #fefefe;
         margin: auto;
         padding: 20px;
         border: 1px solid #888;
         width: 60%;
         }
         /* The Close Button */
         .close3 {
         color: #aaaaaa;
         text-align: center;
         font-size: 14px;
         font-weight: bold;
         vertical-align: top;
         }
         .close3:hover, .close3:focus {
         color: #000;
         text-decoration: none;
         cursor: pointer;
         }
      </style>
      <script  type="text/javascript" src="${pageContext.request.contextPath}/theme/exam/tinybox.js"></script>
      <script type="text/javascript">
         function removeRadiobuttonSelection(radionames, questionid, subjectid, questionrowid, qnumber, colorcode){
         
         	
         	var radList = document.getElementsByName(radionames);
         
         	for (var i = 0; i < radList.length; i++) {
         	      if(radList[i].checked) radList[i].checked = false;
         	    }
         	saveExamStatus_ByQid("",questionid, subjectid, questionrowid);
         	  var property = document.getElementById("button_"+qnumber);
         	  property.style.backgroundColor = "#FFFFFF";
         	  property.style.color="#5C99C8";
         	
         }
         
         
         var getAllQuestionDetails = function(){
         	var modal = document.getElementById('myModal4');
         	 modal.style.display = "block";
         	
         }
         
         
         var getInstructionDetails = function(instrid){
         	//If we select more than one subject, pass the subjectids with comma seperater
         	var examname=document.getElementById('examname').value;
         	var modal = document.getElementById('myModal3');
         	 modal.style.display = "block";
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
                         document.getElementById('results').innerHTML = _html;
                     }
             }); 
         }
         
         
         
      </script>
   </head>
   <body onkeypress="return disableCtrlKeyCombination(event);"
      onkeydown="return disableCtrlKeyCombination(event);">
      <div id="responsestuid" style="display: none"></div>
      <div class="loader"></div>
      <div id="loader1" class="loader" style="display: none;"></div>
      <div id="atmptcount" style="display: none;"></div>
      <div id="header_container">
         <div id="header_container_inner">
            <!-- <div id="header_sify_logo"><img src="themes/default/images/sify_logo.png" width="70" height="37" /></div> -->
            <div id="header_sify_logo">
               <table width="850px" border="0" cellspacing="0" cellpadding="0">
                  <tbody>
                     <tr>
                        <td width="25%" align="left"></td>
                        <td width="50%" align="center"><img src="${pageContext.request.contextPath}/theme/exam/Electus-Logo-RGB.jpg" alt="ELECTUS" height="45"></td>
                        <td width="25%"></td>
                     </tr>
                  </tbody>
               </table>
            </div>
         </div>
      </div>
      <div id="top-container-wrapper">
      <div id="top-container" class="container">
         <div class="text_bold">
            <font style="color:blue;font-weight: bold;">Exam :</font> ${examname}
            <c:if test="${msg!=null}">${msg}</c:if>
            <label style="font-weight: bold;" id="questions"></label>
            <span style="float: right;background:#606a74;color:#ffffff;padding:4px 2px; font-weight: bold;">hrs</span>
            <span class="sam_quest_ti_lt_hrs" id="time" style="float: right;background:#606a74;color:#ffffff;padding:4px 10px; font-weight: bold;"></span>
            <span style="float: right; font-weight: bold;padding-top: 3px;">Time Left &nbsp;&nbsp;&nbsp;</span>
         </div>
         <div class="sam_quest_ti_lt_container">
            <span class="sam_quest_ti_lt_hrs" id="timeleft">&nbsp;</span>
         </div>
      </div>
      <main>
         <div class="innertube">
            <form:form modelAttribute="qp" id="springform" method="POST"
               action="load-qform">
               <input type="hidden" id="totalqtime" name="totalqtime" 	value="${totalqtime}">
               <input type="hidden" id="timeqtaken" name="timeqtaken">
               <input type="hidden" name="noOfqbns" id="noOfqbns" value="${nofques}">
               <input type="hidden" name="suspendexams" id="suspendexams" />
               <input type="hidden" name="examname" id="examname" value="${examname}" />
               <input type="hidden" name="sid" id="stu" value="${stuid}" />
               <input type="hidden" name="suspendexams" id="suspendexams" />
               <input type="hidden" name="location_id" id="location_id" value="${location_id}" />
               <input type="hidden" name="branch_id" id="branch_id" value="${branch_id}" />
               <input type="hidden" name="class_id" id="class_id" value="${class_id}" />
               <input type="hidden" name="section_id" id="section_id" value="${section_id}" />
               <input type="hidden" id="prevansweredCnt" value="${answeredCnt}">
               <input type="hidden" id="timeqval" name="timeqval" value="${time_val_q}">
               <input type="hidden" id="different" name="different">
               <%
                  int bookmarkqutoInc = 9000,optionsloop = 0,quesno = 1,paginationsno = 1,paginationsno1 = 1,selectedno=1;
                  
                  %>
               <div class="container" style="margin-right: 0px;">
                  <ul class="nav nav-tabs"  style="width: 80%">
                     <c:forEach items="${model1.qp}" var="subrow" varStatus="loop2">
                        <c:choose>
                           <c:when test="${loop2.index==0}">
                              <li class="active"><a href="#tab_${loop2.index}"
                                 data-toggle="tab">${subrow.subjectname}</a></li>
                           </c:when>
                           <c:otherwise>
                              <li><a href="#tab_${loop2.index}" 
                                 data-toggle="tab">${subrow.subjectname}</a></li>
                           </c:otherwise>
                        </c:choose>
                     </c:forEach>
                     <li><a href="#" onclick="return getInstructionDetails();"
                        style="float: left; display: block;">Instructions</a></li>
                     <li><a href="#" id="myBtn${loop2.index}"
                        onclick="return getAllQuestionDetails();"
                        style="float: left; display: block;">View All Questions</a></li>
                  </ul>
                  <div class="tab-content" style="width: 90%">
                     <% String temp=",",temp1="";int tempval=0; %>
                     <c:forEach items="${model1.qp}" var="subrow" varStatus="loop2">
                        <c:choose>
                           <c:when test="${loop2.index==0}">
                              <div class="tab-pane active"  id="tab_${loop2.index}">
                           </c:when>
                           <c:otherwise>
                           <div class="tab-pane"  id="tab_${loop2.index}">
                           <%temp1=""; %>
                           </c:otherwise>
                        </c:choose>
                        <div id="galleryalt_<%=tempval%>" class="paginationstyle" style=" text-align: left;width: 88%">
                        <a href="#" rel="previous">Previous</a> <span class="flatview"></span> <a href="#" rel="next">Next</a>
                        </div>
                        <c:forEach items="${subrow.list}" var="row1" varStatus="loop">
                        <%
                           pageContext.setAttribute("optionsloop", optionsloop);
                           			pageContext.setAttribute("quesno", quesno);
                           			pageContext.setAttribute("selectedno", selectedno);
                           %>
                        <c:set var="optionsloop" value="${optionsloop}"></c:set>
                        <c:set var="quesno" value="${quesno}"></c:set>
                        <c:set var="selectedno" value="${selectedno}"></c:set>
                        <%
                           temp1=temp1+"'"+paginationsno+"'"+temp;
                           System.out.println(temp1);
                           paginationsno++;
                           %>
                        <div class="virtualpage<%=tempval%> hidepiece">
                        <div>
                        <TABLE width="88%">
                        <tr>
                        <td colspan="2" >
                        <div class="panel " >
                        <div class="panel-heading" style="color: #0059b3;">
                        <table width="88%">
                        <tr>
                        <td style="text-align: left;color: #93ad03;"><b>Question Type</b>:<font
                           color="black" style="font-weight: bold;">${row1.typeOfQuestion}</font></td>
                        <td style="text-align: center;color: #93ad03;"><b>Marks per
                        Question</b>:<font color="black" style="font-weight: bold;">${row1.marks_per_qus_type}</font></td>
                        <td style="text-align: right;color: #93ad03;"><b>Negative Marks</b>:<font
                           color="black" style="font-weight: bold;">
                        ${row1.negative_marks}</font></td>
                        </tr>
                        </table>
                        </div>
                        </div>
                        <div class="col-lg-12">
                        <div class="panel" style="overflow: auto; max-height: 430px;">
                        <div class="panel-heading">
                        <b> Question <%=paginationsno1 %>: </b><br>
                        <form:hidden path="list[${loop.index}].displayquest"
                           value="${row1.ques}" class="form-control" />
                        <label> ${row1.ques}</label>
                        </div>
                        <div class="panel-body">
                        <table width="100%" id="optionsTable">
                        <%
                           int integertypeval = 0;
                           %>
                        <c:forEach items="${row1.optionsList}" var="options"
                           varStatus="i">
                        <%
                           pageContext.setAttribute("integertypeval", integertypeval);
                           int matrixflag=0,multiflag=0;
                           %>
                        <c:set var="integertypeval" value="${integertypeval}"></c:set>
                        <tr>
                        <td width="2%">
                        <TABLE width="100%">
                        <c:choose>
                        <c:when
                           test="${row1.typeOfQuestion == 'Single answer'}">
                        <tr>
                        <td width="5%" style="font-weight: bold;"
                           valign="baseline">${options.optionType})</td>
                        <td width="95%" align="left" valign="baseline">
                        <c:if
                           test="${row1.selected_answer eq options.optionType}">
                        <input type="hidden" value="${quesno}"
                           id="selectval_${selectedno}" />
                        <input type="radio"
                           name="list[${optionsloop}].options"
                           value="${options.optionType}"
                           onclick="atleastQById(this.id);saveExamStatus_ByQid(this.value,${row1.question_id},${row1.subjectid},${row1.questionrowid}); optionsById(${nofques});"
                           checked="checked">
                        <%
                           selectedno++;
                           %>
                        </c:if> <c:if
                           test="${row1.selected_answer != options.optionType}">
                        <form:radiobutton
                           path="list[${optionsloop}].options"
                           value="${options.optionType}"
                           onclick="atleastQById(this.id); saveExamStatus_ByQid(this.value,${row1.question_id},${row1.subjectid},${row1.questionrowid}); optionsById(${nofques}); setColor(${quesno},'#101010')" />
                        </c:if> <label for="list[${optionsloop}].options">
                        ${options.option} </label>
                        </td>
                        </tr>
                        </c:when>
                        <c:when
                           test="${row1.typeOfQuestion == 'Single type'}">
                        <tr>
                        <td width="5%" style="font-weight: bold;"
                           valign="baseline">${options.optionType})</td>
                        <td width="95%" align="left" valign="baseline">
                        <c:if
                           test="${row1.selected_answer eq options.optionType}">
                        <input type="hidden" value="${quesno}"
                           id="selectval_${selectedno}" />
                        <input type="radio"
                           name="list[${optionsloop}].options"
                           value="${options.optionType}"
                           onclick="atleastQById(this.id);saveExamStatus_ByQid(this.value,${row1.question_id},${row1.subjectid},${row1.questionrowid}); optionsById(${nofques});"
                           checked="checked">
                        <%
                           selectedno++;
                           %>
                        </c:if> <c:if
                           test="${row1.selected_answer != options.optionType}">
                        <form:radiobutton
                           path="list[${optionsloop}].options"
                           value="${options.optionType}"
                           onclick="atleastQById(this.id);saveExamStatus_ByQid(this.value,${row1.question_id},${row1.subjectid},${row1.questionrowid}); optionsById(${nofques}); setColor(${quesno},'#101010')" />
                        </c:if> <label for="list[${optionsloop}].options">
                        ${options.option} </label>
                        </td>
                        </tr>
                        </c:when>
                        <c:when
                           test="${row1.typeOfQuestion == 'Multi Answer'}">
                        <tr>
                        <c:set var="selectedanswer"
                           value="${row1.selected_answer}" />
                        <c:if test="${selectedanswer!=null and selectedanswer!=''}">
                        <%	multiflag=1;
                           %>
                        </c:if>
                        <%
                           pageContext.setAttribute("multiflag", multiflag);
                           %>
                        <c:set var="optionsvalue"
                           value="${options.optionType}" />
                        <c:if test="${i.index==0}">
                        <c:if test="${multiflag==1}">
                        <input type="hidden" value="${quesno}"
                           id="selectval_${selectedno}" />
                        <%
                           selectedno++;
                           
                           %>
                        </c:if>
                        </c:if>
                        <c:if
                           test="${fn:contains(selectedanswer,optionsvalue)}">
                        <td width="5%" style="font-weight: bold;"
                           valign="baseline">${options.optionType})</td>
                        <td width="95%" align="left" valign="baseline">
                        <input type="checkbox"
                           name="list[${optionsloop}].options"
                           value="${options.optionType}"
                           id='list[${optionsloop}].options'
                           checked="checked"
                           onclick="atleastQById(this.id); multiselectval('list[${optionsloop}].options',${row1.question_id},${row1.subjectid},${row1.questionrowid}); optionsById(${nofques});" />
                        <label for="list[${optionsloop}].options">
                        ${options.option} </label>
                        </td>
                        </c:if>
                        <c:if
                           test="${not fn:contains(selectedanswer,optionsvalue)}">
                        <td width="5%" style="font-weight: bold;"
                           valign="baseline">${options.optionType})</td>
                        <td width="95%" align="left" valign="baseline">
                        <form:checkbox
                           path="list[${optionsloop}].options"
                           value="${options.optionType}"
                           id='list[${optionsloop}].options'
                           onclick="atleastQById(this.id); multiselectval('list[${optionsloop}].options',${row1.question_id},${row1.subjectid},${row1.questionrowid}); optionsById(${nofques});setColor(${quesno},'#101010')" />
                        <label for="list[${optionsloop}].options">
                        ${options.option} </label>
                        </td>
                        </c:if>
                        </tr>
                        </c:when>
                        <c:when
                           test="${row1.typeOfQuestion == 'Integer Type'}">
                        <c:if test="${integertypeval eq 0}">
                        <tr>
                        <td width="95%" align="left" valign="baseline">
                        <c:if test="${row1.selected_answer eq null}">
                        <form:input path="list[${optionsloop}].options"
                           onkeypress="return event.charCode >= 48 && event.charCode <= 57"
                           maxlength="1" style="width:50%;height:40px;"
                           onkeyup="atleastQById(this.id);saveExamStatus_ByQid(this.value,${row1.question_id},${row1.subjectid},${row1.questionrowid}); optionsById(${nofques});attemptcount();setColorforTextbox(${quesno},this.value);" />
                        </c:if> <c:if test="${row1.selected_answer != null}">
                        <input type="hidden" value="${quesno}"
                           id="selectval_${selectedno}" />
                        <form:input path="list[${optionsloop}].options"
                           value="${row1.selected_answer}"
                           onkeypress="return event.charCode >= 48 && event.charCode <= 57"
                           maxlength="1" style="width:50%;height:40px;"
                           onkeyup="atleastQById(this.id);saveExamStatus_ByQid(this.value,${row1.question_id},${row1.subjectid},${row1.questionrowid}); optionsById(${nofques});attemptcount();" />
                        <%
                           selectedno++;
                           %>
                        </c:if>
                        </td>
                        </tr>
                        </c:if>
                        </c:when>
                        <c:when
                           test="${row1.typeOfQuestion == 'Fill in the blanks'}">
                        <c:if test="${integertypeval eq 0}">
                        <tr>
                        <td width="95%" align="left" valign="baseline">
                        <c:if test="${row1.selected_answer eq null}">
                        <form:input path="list[${optionsloop}].options"
                           maxlength="500" style="width:50%;height:40px;"
                           onkeyup="atleastQById(this.id);saveExamStatus_ByQid(this.value,${row1.question_id},${row1.subjectid},${row1.questionrowid}); optionsById(${nofques});attemptcount();setColorforTextbox(${quesno},this.value);" />
                        </c:if> <c:if test="${row1.selected_answer != null}">
                        <input type="hidden" value="${quesno}"
                           id="selectval_${selectedno}" />
                        <form:input path="list[${optionsloop}].options"
                           value="${row1.selected_answer}"
                           maxlength="500" style="width:50%;height:40px;"
                           onkeyup="atleastQById(this.id);saveExamStatus_ByQid(this.value,${row1.question_id},${row1.subjectid},${row1.questionrowid}); optionsById(${nofques});attemptcount();" />
                        <%
                           selectedno++;
                           %>
                        </c:if>
                        </td>
                        </tr>
                        </c:if>
                        </c:when>
                        <c:when
                           test="${row1.typeOfQuestion == 'True Or False'}">
                        <tr>
                        <td width="95%" align="left" valign="baseline">
                        <c:if
                           test="${row1.selected_answer eq options.optionType}">
                        <input type="hidden" value="${quesno}"
                           id="selectval_${selectedno}" />
                        <input type="radio"
                           name="list[${optionsloop}].options"
                           value="${options.optionType}"
                           onclick="atleastQById(this.id);saveExamStatus_ByQid(this.value,${row1.question_id},${row1.subjectid},${row1.questionrowid}); optionsById(${nofques});"
                           checked="checked">
                        <%
                           selectedno++;
                           %>
                        </c:if> <c:if
                           test="${row1.selected_answer != options.optionType}">
                        <form:radiobutton
                           path="list[${optionsloop}].options"
                           value="${options.optionType}"
                           onclick="atleastQById(this.id);saveExamStatus_ByQid(this.value,${row1.question_id},${row1.subjectid},${row1.questionrowid}); optionsById(${nofques});setColor(${quesno},'#101010')" />
                        </c:if><label for="list[${optionsloop}].options">
                        ${options.option} </label>
                        </td>
                        </tr>
                        </c:when>
                        <c:when
                           test="${row1.typeOfQuestion == 'Reasoning Type'}">
                        <tr>
                        <td width="5%" style="font-weight: bold;"
                           valign="baseline">${options.optionType})</td>
                        <td width="95%" align="left" valign="baseline">
                        <c:if
                           test="${row1.selected_answer eq options.optionType}">
                        <input type="hidden" value="${quesno}"
                           id="selectval_${selectedno}" />
                        <input type="radio"
                           name="list[${optionsloop}].options"
                           value="${options.optionType}"
                           onclick="atleastQById(this.id);saveExamStatus_ByQid(this.value,${row1.question_id},${row1.subjectid},${row1.questionrowid}); optionsById(${nofques});"
                           checked="checked">
                        <%
                           selectedno++;
                           %>
                        </c:if> <c:if
                           test="${row1.selected_answer != options.optionType}">
                        <form:radiobutton
                           path="list[${optionsloop}].options"
                           value="${options.optionType}"
                           onclick="atleastQById(this.id);saveExamStatus_ByQid(this.value,${row1.question_id},${row1.subjectid},${row1.questionrowid}); optionsById(${nofques});setColor(${quesno},'#101010')" />
                        </c:if> <label for="list[${optionsloop}].options">
                        ${options.option} </label>
                        </td>
                        </tr>
                        </c:when>
                        <c:when
                           test="${row1.typeOfQuestion == 'Matrix Match'}">
                        <c:set var="selectedanswer"
                           value="${row1.selected_answer}" />
                        <c:set var="splitanwer"
                           value="${fn:split(selectedanswer, ',')}" />
                        <c:set value="${options.option}" var="matrixoption"></c:set>
                        <%
                           String thirdSubStringspli = "";
                           						String firstSubStringspli = "";
                           						String secondSubStringspli = "";
                           						String matrixoption = (String) pageContext.getAttribute("matrixoption");
                           						String[] splitmatr = matrixoption.split("matrix_option");
                           
                           						firstSubStringspli = splitmatr[0];
                           
                           						if (splitmatr.length == 2) {
                           							secondSubStringspli = splitmatr[1];
                           						}
                           						if (splitmatr.length == 3) {
                           							secondSubStringspli = splitmatr[1];
                           
                           							thirdSubStringspli = splitmatr[2];
                           						}
                           						request.setAttribute("firstSubStringspli", firstSubStringspli);
                           						request.setAttribute("secondSubStringspli", secondSubStringspli);
                           						request.setAttribute("thirdSubStringspli", thirdSubStringspli);
                           %>
                        <c:if test="${selectedanswer!=null and selectedanswer!=''}">
                        <%	matrixflag=1;
                           %>
                        </c:if>
                        <%
                           pageContext.setAttribute("matrixflag", matrixflag);
                           %>
                        <tr>
                        <td >
                        <table id="matrixtable" width="100%" style="right: 10; border: 1px solid #ddd;">
                        <c:if test="${(i.index)==0}">
                        <tr>
                        <td width="40%"><label>Column I </label></td>
                        <td width="40%"><label>Column II
                        </label></td>
                        <td width="20%"><label>Select
                        Answer </label></td>
                        </tr>
                        </c:if>
                        <tr>
                        <td width="40%"><label
                           for="list[${optionsloop}].options">
                        ${firstSubStringspli}</label></td>
                        <td width="40%"><label
                           for="list[${optionsloop}].options">${secondSubStringspli}</label></td>
                        <td width="20%"><c:if
                           test="${(i.index)==0}">
                        <select name="list[${optionsloop}].options"
                           multiple="multiple" style="height: 100px;"
                           onchange="matrixselectval('list[${optionsloop}].options',${row1.question_id},${row1.subjectid},${row1.questionrowid});optionsById(${nofques});attemptcount();setColor(${quesno},'#101010');">
                        <option value="0">Select-Value</option>
                        <c:choose>
                        <c:when
                           test="${fn:contains(row1.selected_answer, 'A-P')}">
                        <option value="A-P" selected="selected">P</option>
                        </c:when>
                        <c:otherwise>
                        <option value="A-P">P</option>
                        </c:otherwise>
                        </c:choose>
                        <c:choose>
                        <c:when
                           test="${fn:contains(row1.selected_answer,'A-Q')}">
                        <option value="A-Q" selected="selected">Q</option>
                        </c:when>
                        <c:otherwise>
                        <option value="A-Q">Q</option>
                        </c:otherwise>
                        </c:choose>
                        <c:choose>
                        <c:when
                           test="${fn:contains(row1.selected_answer,'A-R')}">
                        <option value="A-R" selected="selected">R</option>
                        </c:when>
                        <c:otherwise>
                        <option value="A-R">R</option>
                        </c:otherwise>
                        </c:choose>
                        <c:choose>
                        <c:when
                           test="${fn:contains(row1.selected_answer,'A-S')}">
                        <option value="A-S" selected="selected">S</option>
                        </c:when>
                        <c:otherwise>
                        <option value="A-S">S</option>
                        </c:otherwise>
                        </c:choose>
                        <c:choose>
                        <c:when
                           test="${fn:contains(row1.selected_answer,'A-T')}">
                        <option value="A-T" selected="selected">T</option>
                        </c:when>
                        <c:otherwise>
                        <option value="A-T">T</option>
                        </c:otherwise>
                        </c:choose>
                        </select>	<c:if test="${matrixflag==1}">
                        <input type="hidden" value="${quesno}"
                           id="selectval_${selectedno}" />
                        <%
                           selectedno++;
                           
                           %>
                        </c:if>
                        </c:if> <c:if test="${(i.index)==1}">
                        <select name="list[${optionsloop}].options"
                           multiple="multiple" style="height: 100px;"
                           onchange="matrixselectval('list[${optionsloop}].options',${row1.question_id},${row1.subjectid},${row1.questionrowid});optionsById(${nofques});attemptcount();setColor(${quesno},'#101010');">
                        <option value="0">Select-Value</option>
                        <c:choose>
                        <c:when
                           test="${fn:contains(row1.selected_answer,'B-P')}">
                        <option value="B-P" selected="selected">P</option>
                        </c:when>
                        <c:otherwise>
                        <option value="B-P">P</option>
                        </c:otherwise>
                        </c:choose>
                        <c:choose>
                        <c:when
                           test="${fn:contains(row1.selected_answer,'B-Q')}">
                        <option value="B-Q" selected="selected">Q</option>
                        </c:when>
                        <c:otherwise>
                        <option value="B-Q">Q</option>
                        </c:otherwise>
                        </c:choose>
                        <c:choose>
                        <c:when
                           test="${fn:contains(row1.selected_answer,'B-R')}">
                        <option value="B-R" selected="selected">R</option>
                        </c:when>
                        <c:otherwise>
                        <option value="B-R">R</option>
                        </c:otherwise>
                        </c:choose>
                        <c:choose>
                        <c:when
                           test="${fn:contains(row1.selected_answer,'B-S')}">
                        <option value="B-S" selected="selected">S</option>
                        </c:when>
                        <c:otherwise>
                        <option value="B-S">S</option>
                        </c:otherwise>
                        </c:choose>
                        <c:choose>
                        <c:when
                           test="${fn:contains(row1.selected_answer,'B-T')}">
                        <option value="B-T" selected="selected">T</option>
                        </c:when>
                        <c:otherwise>
                        <option value="B-T">T</option>
                        </c:otherwise>
                        </c:choose>
                        </select>
                        </c:if> <c:if test="${(i.index)==2}">
                        <select name="list[${optionsloop}].options"
                           multiple="multiple" style="height: 100px;"
                           onchange="matrixselectval('list[${optionsloop}].options',${row1.question_id},${row1.subjectid},${row1.questionrowid});optionsById(${nofques});attemptcount();setColor(${quesno},'#101010');">
                        <option value="0">Select-Value</option>
                        <c:choose>
                        <c:when
                           test="${fn:contains(row1.selected_answer,'C-P')}">
                        <option value="C-P" selected="selected">P</option>
                        </c:when>
                        <c:otherwise>
                        <option value="C-P">P</option>
                        </c:otherwise>
                        </c:choose>
                        <c:choose>
                        <c:when
                           test="${fn:contains(row1.selected_answer,'C-Q')}">
                        <option value="C-Q" selected="selected">Q</option>
                        </c:when>
                        <c:otherwise>
                        <option value="C-Q">Q</option>
                        </c:otherwise>
                        </c:choose>
                        <c:choose>
                        <c:when
                           test="${fn:contains(row1.selected_answer,'C-R')}">
                        <option value="C-R" selected="selected">R</option>
                        </c:when>
                        <c:otherwise>
                        <option value="C-R">R</option>
                        </c:otherwise>
                        </c:choose>
                        <c:choose>
                        <c:when
                           test="${fn:contains(row1.selected_answer,'C-S')}">
                        <option value="C-S" selected="selected">S</option>
                        </c:when>
                        <c:otherwise>
                        <option value="C-S">S</option>
                        </c:otherwise>
                        </c:choose>
                        <c:choose>
                        <c:when
                           test="${fn:contains(row1.selected_answer,'C-T')}">
                        <option value="C-T" selected="selected">T</option>
                        </c:when>
                        <c:otherwise>
                        <option value="C-T">T</option>
                        </c:otherwise>
                        </c:choose>
                        </select>
                        </c:if> <c:if test="${(i.index)==3}">
                        <select name="list[${optionsloop}].options"
                           multiple="multiple" style="height: 100px;"
                           onchange="matrixselectval('list[${optionsloop}].options',${row1.question_id},${row1.subjectid},${row1.questionrowid});optionsById(${nofques});attemptcount();setColor(${quesno},'#101010');">
                        <option value="0">Select-Value</option>
                        <c:choose>
                        <c:when
                           test="${fn:contains(row1.selected_answer,'D-P')}">
                        <option value="D-P" selected="selected">P</option>
                        </c:when>
                        <c:otherwise>
                        <option value="D-P">P</option>
                        </c:otherwise>
                        </c:choose>
                        <c:choose>
                        <c:when
                           test="${fn:contains(row1.selected_answer,'D-Q')}">
                        <option value="D-Q" selected="selected">Q</option>
                        </c:when>
                        <c:otherwise>
                        <option value="D-Q">Q</option>
                        </c:otherwise>
                        </c:choose>
                        <c:choose>
                        <c:when
                           test="${fn:contains(row1.selected_answer,'D-R')}">
                        <option value="D-R" selected="selected">R</option>
                        </c:when>
                        <c:otherwise>
                        <option value="D-R">R</option>
                        </c:otherwise>
                        </c:choose>
                        <c:choose>
                        <c:when
                           test="${fn:contains(row1.selected_answer,'D-S')}">
                        <option value="D-S" selected="selected">S</option>
                        </c:when>
                        <c:otherwise>
                        <option value="D-S">S</option>
                        </c:otherwise>
                        </c:choose>
                        <c:choose>
                        <c:when
                           test="${fn:contains(row1.selected_answer,'D-T')}">
                        <option value="D-T" selected="selected">T</option>
                        </c:when>
                        <c:otherwise>
                        <option value="D-T">T</option>
                        </c:otherwise>
                        </c:choose>
                        </select>
                        </c:if>
                        </td>
                        </tr>
                        <c:if test="${(i.index)==3}">
                        <c:if test="${thirdSubStringspli != ''}">
                        <tr>
                        <td width="40%"><label
                           for="list[${optionsloop}].options"></label></td>
                        <td width="40%"><label
                           for="list[${optionsloop}].options">
                        ${thirdSubStringspli}</label></td>
                        <td width="20%"></td>
                        </tr>
                        </c:if>
                        </c:if>
                        </table>
                        </td>
                        </tr>
                        </c:when>
                        <c:when
                           test="${row1.typeOfQuestion == 'Comprehension'}">
                        <tr>
                        <td width="5%" style="font-weight: bold;"
                           valign="baseline">${options.optionType})</td>
                        <td width="95%" align="left" valign="baseline">
                        <c:if
                           test="${row1.selected_answer eq options.optionType}">
                        <input type="hidden" value="${quesno}"
                           id="selectval_${selectedno}" />
                        <input type="radio"
                           name="list[${optionsloop}].options"
                           value="${options.optionType}"
                           onclick="atleastQById(this.id);saveExamStatus_ByQid(this.value,${row1.question_id},${row1.subjectid},${row1.questionrowid}); optionsById(${nofques});"
                           checked="checked">
                        <%
                           selectedno++;
                           %>
                        </c:if> <c:if
                           test="${row1.selected_answer != options.optionType}">
                        <form:radiobutton
                           path="list[${optionsloop}].options"
                           value="${options.optionType}"
                           onclick="atleastQById(this.id); saveExamStatus_ByQid(this.value,${row1.question_id},${row1.subjectid},${row1.questionrowid}); optionsById(${nofques}); setColor(${quesno},'#101010')" />
                        </c:if> <label for="list[${optionsloop}].options">
                        ${options.option} </label>
                        </td>
                        </tr>
                        </c:when>
                        </c:choose>
                        </TABLE>
                        </td>
                        <%-- <td align="left"> ${options.option} </td> --%>
                        </tr>
                        <%
                           integertypeval++;
                           %>
                        </c:forEach>
                        <tr>
                        <td>
                        <div class="row"></div>
                        </td>
                        </tr>
                        <tr>
                        <%-- <td colspan="2"><form:hidden
                           path="list[${loop.index}].actualAnswer"
                           value="${row1.answer}" /> Answer: ${row1.answer}</td> --%>
                        </tr>
                        <tr>
                        <td colspan="2"><form:hidden
                           path="list[${loop.index}].bquestion_id"
                           id="bquestion_id" value="${row1.question_id}" /> <%-- Question ID: ${row1.question_id} --%>
                        </td>
                        </tr>
                        <tr>
                        <td><div id="log"></div></td>
                        </tr>
                        </table>
                        </div>
                        </div>
                        </div>
                        <div class="clear"></div>
                        <div  class="btnfooter">
                        <div class="container">
                        <table width="100%">
                        <tr>
                        <td align="center"><input type="button"
                           value="Tag" class="aref" id="mark_${quesno}"
                           onclick="markasreview(${quesno});" style="background-color: #febf01;color: black; border: 0px;" ></td>
                        <td align="center"><a href="#"
                           id="${row1.question_id}" class="aref"
                           style="height: 60px; text-decoration: none;"
                           onclick="insertBookmarkID(${row1.question_id}, <%=bookmarkqutoInc%>,${subrow.subjectid});">
                        Bookmark </a>
                        </td>
                        <td align="center">
                        <a href="#" class="aref" style="text-decoration: none; background-color: #FF1A00;border: 0px; border-radius: 10px;" onclick="removeRadiobuttonSelection('list[${optionsloop}].options',${row1.question_id},${row1.subjectid},${row1.questionrowid},${quesno},'#101010');">Erase</a>
                        </td>
                        <td style="float:left">
                        <div id="final_submit_btn_div">
                        <div id="final_submit_arrow_div"><a href="#" onclick="preview_submit(0)"><img src="${pageContext.request.contextPath}/theme/exam/final_submit_arow.png" width="23" height="20"></a></div>
                        <div id="final_submit_arrow_text">
                        <a title="Click to submit Question Paper" href="#" id="popup" onclick="return finish_div_show();">Preview Submit</a></div>
                        </div>
                        </td>
                        </tr>
                        <tr>
                        <td>&nbsp;</td>
                        </tr>
                        </table>
                        </div>
                        <div class="container">
                        &nbsp;
                        </div>
                        <div class="container">
                        &nbsp;
                        </div>
                        <div class="container">
                        &nbsp;
                        </div>
                        </div>
                        <div class="" style="width: 100%">
                        <table width="100%">
                        <tr>
                        <td colspan="3" align="center" id="<%=bookmarkqutoInc%>"
                           style="color: #428bca; font-weight: bold;" align="center">
                        </td>
                        </tr>
                        </table>
                        <%
                           quesno++;
                           %>
                        </div>
                        </td>
                        </tr>
                        <%
                           bookmarkqutoInc++;
                           			optionsloop++;
                           			paginationsno1++;
                           %>
                        </TABLE>
                        </div>
                        </div>
                        </c:forEach>
                        <% 
                           temp1 = temp1.substring(0, temp1.length() - 1); 
                           %>
                        <script type="text/javascript">
                           var tempval=<%=tempval%>;
                           var gallery<%=tempval%>=new virtualpaginate({
                           piececlass: 'virtualpage'+tempval,
                           piececontainer: 'div',
                           pieces_per_page: 1,
                           defaultpage: 0,
                           wraparound: false,
                           persist: true
                           })
                           gallery<%=tempval%>.buildpagination(["galleryalt_<%=tempval%>"], [<%=temp1%>])
                        </script>
                        </div>
                        <%tempval++; %>
                     </c:forEach>
                     </div>
                  </div>
                  <div id="unanswered"></div>
            </form:form>
            </div>
         </div>
      </main>
      <nav id="nav1">
         <div class="innertube">
            <div class="sam_quest_photo"><img src="${pageContext.request.contextPath}/theme/exam/photo_no.jpg" width="150" height="150"></div>
         </div>
         <div style="top: 130px; position: fixed; right:15px; width: 130px;text-align: left">
            Login ID <br>
            <b> <%=session.getAttribute("uname") %> </b>
            <br>
            Candidate Name
            <br>
            <b> <%=session.getAttribute("username") %>  </b>
         </div>
      </nav>
      <nav id="nav">
         <div class="innertube">
            <div id="que-scroll">
               <div id="contentmodel" style="float: left; padding: 5px;">
                  <%
                     int j = 1,l=0;
                     int k = 1;
                     %>
                  <c:forEach items="${model1.qp}" var="subrow" varStatus="loop2">
                     <p
                        style=" box-shadow: 4px 4px 5px #888888;background:url(${pageContext.request.contextPath}/theme/exam/sample_question_header_bg.jpg) repeat-x ; color: white; text-align: center;">
                        <b>${fn:toUpperCase(subrow.subjectname)}</b>
                     </p>
                     <c:forEach items="${subrow.list}" var="row1" varStatus="loop">
                        <%
                           pageContext.setAttribute("subjectno", j);
                           %>
                        <c:set value="${subjectno}" var="subjeno"></c:set>
                        <a href="javascript:gallery<%=l%>.navigate(${loop.index})" type="button" class="rightpagination"
                           id="button_${subjeno}"
                           style="display: block; width: 30px; height: 25px; line-height: 20px; border: 2px solid #f5f5f5; display: inline-block; text-align: center; text-decoration: none; background: #ffffff; box-shadow: 0 0 3px gray; font-size: 12px; font-weight: bold;padding:4px 0 3px 0;" ><%=k%></a>
                        <%
                           j++;
                           k++;
                           %>
                     </c:forEach>
                     <br>
                     <br>
                     <%l++;
                        %>
                  </c:forEach>
               </div>
            </div>
            <div class="attempt_container">
               <div class="sam_attempt" id="no_attempt">0</div>
               <div class="sam_attempt_txt">Attempted</div>
               <div class="sam_tag " id="no_tagged">T</div>
               <div class="sam_tag_text">Tagged</div>
               <!--  <div class="sam_ans_tag" id="no_ans_tagged">0</div> -->
               <!--  <div class="sam_ans_tag_text">Tagged &amp;<br> Attempted</div> -->
               <div class="sam_unattempt" id="no_unattempt">0</div>
               <div class="sam_unattempt_text">Unattempted</div>
            </div>
         </div>
      </nav>
      <!-- Instruction Modal -->
      <div id="myModal3" class="modal3">
         <!-- Modal content -->
         <div class="modal-content3">
            <div id="analysis123"
               style="font-weight: bold; text-align: center; font-size: medium; text-decoration: underline;">Exam
               Instructions
            </div>
            <button style="float: right;" type="button" class="close3" id="test1">&times</button>
            <div class="row"></div>
            <ul style="color: black">
               <li>Please read the instructions carefully before starting your
                  exam <label></label>
               </li>
               <li>
                  Exam Criteria:
                  <div>
                     <label id="results"></label>
                  </div>
               </li>
               <li>In single answer type you can select any one answer.</li>
               <li>In multi answer type you can select multiple answer.</li>
               <li>In matrix match you can select multiple answers by holding
                  ctrl key.
               </li>
               <li>Next and Previous Button are available on top of the
                  question.
               </li>
               <li>You can navigate to particular question on clicking
                  particular number.
               </li>
               <li>You can go to next subject by clicking the next tab.</li>
               <li>You can check your question status.If its color is green
                  than it is attempted.
               </li>
               <li>If its color is yellow than it is mark for review.</li>
               <li>If its color is not colored than it is not attempted or not
                  visited.
               </li>
               <li>You can check number of question attempted count,un-attempt
                  count on top of screen.
               </li>
               <li>If your Exam gets terminated due to power failure or system
                  crash you can resume your exam.
               </li>
               <li>After completing your exam and analysis you need to logout.
               </li>
               <li style="color: red;">Do not refresh your page during exam.</li>
               <li style="color: red;">Please do not double click on the start
                  exam button.
               </li>
            </ul>
            <center>
               <button style="text-align: center;" type="button" class="close3"
                  id="test">CLOSE</button>
            </center>
         </div>
      </div>
      <!--Display all Questions in The Modal -->
      <div id="myModal4" class="modal3">
         <!-- Modal content -->
         <div class="modal-content3" style="overflow-y: scroll; height: 700px;">
            <button style="float: right;" type="button" class="close3"
               id="close21">&times</button>
            <div class="row"></div>
            <div>
               <%
                  int popupcnt = 1;
                  %>
               <table border="1" width="100%">
                  <c:forEach items="${model1.qp}" var="subrow" varStatus="loop2">
                     <tr>
                        <th>No.</th>
                        <th style="text-align: center; background-color: #F5F5F5;">${subrow.subjectname}
                        </th>
                     </tr>
                     <c:forEach items="${subrow.list}" var="row1" varStatus="loop">
                        <tr>
                           <td width="5%"><%=popupcnt%>)</td>
                           <td width="95%">${row1.ques}<%
                              popupcnt++;
                              %></td>
                        </tr>
                     </c:forEach>
                  </c:forEach>
               </table>
            </div>
            <center>
               <button style="text-align: center;" type="button" class="close3"
                  id="close31">CLOSE</button>
            </center>
         </div>
      </div>
      <script>
         //Get the modal
          var modal = document.getElementById('myModal3');
         
          // Get the button that opens the modal
          // Get the <span> element that closes the modal
          var span = document.getElementsByClassName("close3")[0];
         
          // When the user clicks the button, open the modal 
          var btntest = document.getElementById("test");
          var btntest1 = document.getElementById("test1");
         
         
          btntest.onclick=function(){
         
          	modal.style.display = "none";	
          }
          btntest1.onclick=function(){
          	modal.style.display = "none";	
          }
         
         
         
         
          //Get the button that opens the modal
          var modal1 = document.getElementById('myModal4');
         
          //When the user clicks the button, open the modal 
          var btntestc1 = document.getElementById("close21");
          var btntestc2 = document.getElementById("close31");
         
         
          btntestc1.onclick=function(){
          	modal1.style.display = "none";	
          }
          btntestc2.onclick=function(){
          	modal1.style.display = "none";	
          }
         
             
      </script>
      <script>
         $('.item span').hide();
         
         $('.item a').click(function(e){
             
             e.preventDefault();
             // hide all span
             var $this = $(this).parent().find('span');
             $(".item span").not($this).hide();
             
             // here is what I want to do
             $this.toggle();
             
         });
      </script>
      <script
         src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
      <!-- Include all compiled plugins (below), or include individual files as needed -->
      <script
         src="http://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.4/js/bootstrap.min.js"></script>
   </body>
</html>