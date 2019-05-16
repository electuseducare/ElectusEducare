<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <%@include file="DisplayLogo.jsp" %>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>COPY PREVIOUS CREATED EXAM</title>
      <link rel="stylesheet" href="${pageContext.request.contextPath}/theme/css/chosen.css">
      <link rel="stylesheet" href="${pageContext.request.contextPath}/theme/css/prism.css">
      <link rel="stylesheet" href="${pageContext.request.contextPath}/theme/css/AdminCreateExamStyleSheet.css">
      <script src="${pageContext.request.contextPath}/theme/js/AdminCreateExamAjaxScripts2.js"></script>
      <script src="${pageContext.request.contextPath}/theme/js/AdminCreateExamFormValidationswithNoSlot.js"></script>
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
      <style>
         /* css class for the registration form generated errors */
         .profilepress-reg-status {
         border-radius: 6px;
         font-size: 17px;
         line-height: 1.471;
         padding: 10px 19px;
         background-color: #e74c3c;
         color: black;
         font-weight: normal;
         display: block;
         text-align: center;
         vertical-align: middle;
         margin: 5px 0;
         }
         /*form styles*/
         #msform {
         width: 100%;
         margin: 50px auto 550px;
         text-align: center;
         position: relative;
         color: black;
         }
         #msform fieldset {
         background: white;
         border: 0 none;
         border-radius: 3px;
         box-shadow: 0 0 15px 1px rgba(0, 0, 0, 0.4);
         padding: 20px 30px;
         box-sizing: border-box;
         width: 80%;
         margin: 0 10%;
         color: black;
         /*stacking fieldsets above each other*/
         position: absolute;
         }
         /*Hide all except first fieldset*/
         #msform fieldset:not(:first-of-type) {
         display: none;
         }
         /*inputs*/
         /*buttons*/
         #msform .action-button {
         width: 100px;
         background: #27AE60;
         font-weight: bold;
         color: black;
         border: 0 none;
         border-radius: 1px;
         cursor: pointer;
         padding: 10px 5px;
         margin: 10px 5px;
         }
         #msform .action-button:hover,
         #msform .action-button:focus {
         box-shadow: 0 0 0 2px white, 0 0 0 3px #27AE60;
         }
         /*headings*/
         .fs-title {
         font-size: 15px;
         text-transform: uppercase;
         color: #2C3E50;
         margin-bottom: 10px;
         }
         .fs-subtitle {
         font-weight: normal;
         font-size: 13px;
         color: #666;
         margin-bottom: 20px;
         }
         /*progressbar*/
         #progressbar {
         margin-bottom: 30px;
         overflow: hidden;
         /*CSS counters to number the steps*/
         counter-reset: step;
         }
         #progressbar li {
         list-style-type: none;
         color: #616161;
         text-transform: uppercase;
         font-size: 9px;
         width: 33.33%;
         float: left;
         position: relative;
         }
         #progressbar li:before {
         content: counter(step);
         counter-increment: step;
         width: 20px;
         line-height: 20px;
         display: block;
         font-size: 15px;
         color: #333;
         background: white;
         border-radius: 3px;
         margin: 0 auto 5px auto;
         }
         #progressbar li:first-child:after {
         /*connector not needed before the first step*/
         content: none;
         }
         /*marking active/completed steps green*/
         /*The number of the step and the connector before it = green*/
         #progressbar li.active:before,
         #progressbar li.active:after {
         background: #27AE60;
         color: white;
         }
         .col1 {
         background-color: #fff;
         float: left;
         }
         .col2 {
         background-color: #fff;
         float: none;
         }
         .col3 {
         background-color: #fff;
         float: right;
         }
         label {
         color: black;
         }
         input[type="checkbox"][readonly] {
         pointer-events: none;
         }
      </style>
      <script>
         function createExamValidations123() {
         	  var slotexamenddate = document.getElementById('slotexamenddate').value;
         	  if((slotexamenddate.length<=0) || (slotexamenddate==null) ||(slotexamenddate=="") ){
         		  endslotdatemodal.style.display = "block";
         		  return false;
         	}
         	else{
         		  startloader();
         	  }
         }
         
         function startloader() {
         	 document.getElementById("loaderstart").style.display='block';
         }
         
         function secondpageValidations(){
         	var ismarksval=document.getElementById('ismarksval').value;
         	  if (ismarksval=='no'){
         			var idincr = 0;
         			var totmarks = 0;
         			var tempmarks = 0;
         		$("[id='nofoqus']").each( function() {
         			 var qlvalue = $("input[id='nofoqus']").eq(idincr).val();
         			 var almarksval = $("input[id='nofoqusmarks']").eq(idincr).val();
         			 totmarks = qlvalue*almarksval;
         			 tempmarks = tempmarks+ totmarks;
         			 idincr++;
         		});	
         
         		document.getElementById('totalmarks').value=tempmarks;
         		}
         	  if(ismarksval=='yes'){
         			var idincr = 0;
         			var totmarks = 0;
         			var tempmarks = 0;
         			$("[id='nofoqus']").each( function() {
         				 var qlvalue = $("input[id='nofoqus']").eq(idincr).val();
         				 var qlvalue1 = parseInt(qlvalue);
         				 tempmarks = parseInt(tempmarks);
         				 tempmarks = tempmarks + qlvalue1;
         				 idincr++;
         			});
         			var marksperqn = document.getElementById('marksperqn').value;
         			var marksperqn1 =   parseInt(marksperqn);
         			tempmarks=tempmarks*marksperqn1;
         			document.getElementById('totalmarks').value=tempmarks;
         		} 
         	 
         }
         
         function displayStateLocations(statevalue){
         	//If we select more than one state, pass the stateid
         	var stateidvalue="";
         
         	$("input[name='statechckbox']:checked").each( function () {
         		stateidvalue=$(this).val();
         		$("tr").each(function() { //get all rows in table
         			  $("td", this).each(function() {
         			//alert(topicidvalue);
         		 $("."+stateidvalue).show();
         		 $('input#locationchckbox').prop('checked',false);
         		 $('input#branchchckbox').prop('checked',false);
         		 $('td#brachtd').hide();
         		});
         	});
         	});
         	
         	$("input[name='statechckbox']:not(:checked)").each( function () {
         		stateidvalue=$(this).val();
         		$("tr").each(function() { //get all rows in table
         			  $("td", this).each(function() {
         			//alert(topicidvalue);
         		 $("."+stateidvalue).hide();
         		 $('input#branchchckbox').prop('checked',false);
         		 $("input[name='state']:checked").each( function () {
         		 $('input#locationchckbox').prop('checked',false);
         		 $('td#brachtd').hide();
         		});
         		 
         		 $("input[name='branch']:checked").each( function () {
         			 $('input#branchchckbox').prop('checked',false);
         			 $('td#brachtd').hide();
         			 
         			});
         		 
         		});
         	});
         	});
         	
         }
         
         
         function displayLocationBranches(locationvalue){
         	var locationidvalue="";
         	
         	$("input[name='statechckbox']:checked").each( function () {
         	$("input[name='state']:checked").each( function () {
         		locationidvalue=$(this).val();
         		$("tr").each(function() { //get all rows in table
         			  $("td", this).each(function() {
         			//alert(topicidvalue);
         		 $("."+locationidvalue).show();
         		});
         	});
           });
         });
         	
         	$("input[name='statechckbox']:not(:checked)").each( function () {
         	$("input[name='state']:not(:checked)").each( function () {
         		locationidvalue=$(this).val();
         		$("tr").each(function() { //get all rows in table
         			  $("td", this).each(function() {
         			//alert(topicidvalue);
         		 $("."+locationidvalue).hide();
         		 
         		 $("input[name='branch']:checked").each( function () {
         			 $('input#branchchckbox').prop('checked',false);
         			 $('td#brachtd').hide();
         			});
         			
         		});
         	});
           });
         });
         	
         
         	
         }
         
         function validateFloatKeyPress(el, evt) {
             var charCode = (evt.which) ? evt.which : event.keyCode;
             var number = el.value.split('.');
             if (charCode != 46 && charCode > 31 && (charCode < 48 || charCode > 57)) {
                 return false;
             }
             //just one dot
             if(number.length>1 && charCode == 46){
                  return false;
             }
             //get the carat position
             var caratPos = getSelectionStart(el);
             var dotPos = el.value.indexOf(".");
             if( caratPos > dotPos && dotPos>-1 && (number[1].length > 1)){
                 return false;
             }
             return true;
         }
         
         //thanks: http://javascript.nwbox.com/cursor_position/
         function getSelectionStart(o) {
                 if (o.createTextRange) {
                         var r = document.selection.createRange().duplicate()
                         r.moveEnd('character', o.value.length)
                         if (r.text == '') return o.value.length
                         return o.value.lastIndexOf(r.text)
                 } else return o.selectionStart
         } 
         
      </script>
   </head>
   <body>
      <%@include file="adminUserTopMenu.jsp" %>
      <%@include file="adminUserHeader.jsp" %>
      <%@include file="AdminCreateExamModelWindows.jsp" %>
      <!-- start header -->
      <div id="loaderstart" class="loader" style="display: none;"></div>
      <div class="row"> </div>
      <div style="width:22%; float:left; background-color: #ffffff;"><%@include file="AdminDashboardLeftMenu.jsp" %></div>
      <div style="width:70%; float:left; background-color: #ffffff">
         <ul class="nav nav-tabs">
            <li ><a href="load-SetExamformwslot">CREATE EXAM WITHOUT SLOT</a></li>
            <li><a href="load-createSelQuesWithoutslotExam">EXAM WITH SELECTED ?</a></li>
            <li class="active"><a href="#">COPY PREVIOUS CREATED EXAM PATTERN WITHOUT SLOT</a></li>
            <li ><a href="load-createSelQuesAndFilesWithoutslotExam">SELECTED FILES</a></li>
         </ul>
         <div class="panel-heading" style="background-color:#ccf2ff;color:black; font-weight: bold;">
            <a href="load-availableExamsInCopyCreateExamNoslot" style="text-decoration: none;">
            <img border="0" alt="Add Create Exam" src="${pageContext.request.contextPath}/theme/images/copyexam.jpg" width="40" height="40" style="background-color: skyblue;">
            COPY PREVIOUS CREATED EXAM PATTERN WITHOUT SLOT </a>
         </div>
         <div class="row"></div>
         <center>
            <h4 style="color:green">${smsg}</h4>
         </center>
         <center>
            <h4 style="color:red">${emsg}</h4>
         </center>
         <c:if test="${smsg==null}" >
            <c:if test="${emsg==null}" >
               <form:form modelAttribute="loadexamdetails" action="insertcopyExamFormNoslot">
                  <input type="hidden" id="selectedExam" value="${selectedExam}">
                  <div id="msform">
                     <!-- progressbar -->
                     <ul id="progressbar">
                        <li class="active">Exam Info1</li>
                        <li>Exam Info2</li>
                        <li>Exam Info3</li>
                     </ul>
                     <!-- fieldsets -->
                     <fieldset>
                        <h2 class="fs-title">Copy Created Exam</h2>
                        <div id="examerror" class="col-sm-20" style="color: red;"></div>
                        <div id="examvalid" class="col-sm-20" style="color: green;"></div>
                        <div class="col-sm-12" style="padding: 4px; float: left;">
                           <label style="float: left;;">ExamName :*</label>
                           <form:input path="examname" id="examname" class="form-control" value=" ${examdetails.examname}" placecholder="Exam Name" autocomplete="true" onkeyup="validExamnameexists();"/>
                        </div>
                        <div class="col-sm-12" style="padding: 4px; float: left;">
                           <label style="float: left;;">Exam Type :*</label>
                           <form:select path="examtypeselectbox" id="examtypeselectbox" class="form-control"  required="required" >
                              <c:forEach  items="${examtypeslist}" var="examtypeslist" >
                                 <c:choose>
                                    <c:when test="${examdetails.examtype_id == examtypeslist.examtypeid}">
                                       <option value="${examtypeslist.examtypeid}"  selected="selected">${examtypeslist.examtype}
                                       <option>
                                    </c:when>
                                    <c:otherwise>
                                    </c:otherwise>
                                 </c:choose>
                              </c:forEach>
                           </form:select>
                        </div>
                        <TABLE width="100%"><TR><TD>  
                        <table> 
                        <tr><td> <label style="float: left;">State :*</label> </td></tr>
                        <tr><td align="left" style="float: left;">
                        <c:forEach  items="${statenames}" var="statenames" >
                        <tr><td align="left"> 
                        <c:choose>
                        <c:when test="${fn:contains(prvstates.selectedstateids,statenames.stateid)}">
                        <input type="checkbox" name="statechckbox" value="${statenames.stateid}" id="statechckbox"  onclick="displayStateLocations(this.value);" checked="checked"/> ${statenames.statename}
                        </c:when>
                        <c:otherwise>
                        <form:checkbox path="statechckbox" name="statechckbox" value="${statenames.stateid}" id="statechckbox"  onclick="displayStateLocations(this.value);"/> ${statenames.statename}
                        </c:otherwise>
                        </c:choose>
                        </td></tr>
                        </c:forEach>
                        </table>
                        </TD>
                        <TD valign="top">
                        <table> 
                        <tr><td>  <label style="float: left;">Location :*</label>  </td></tr>
                        <tr><td align="left" style="float: left;">
                        </td></tr>
                        <c:forEach  items="${locationdetails}" var="locationdetails" >
                        <tr><td align="left" class="${locationdetails.stateid}" > 
                        <c:choose>
                        <c:when test="${fn:contains(prvlocations.selectedlocationids,locationdetails.locationid)}">
                        <input type="checkbox" name="state" id="locationchckbox"  value="${locationdetails.locationid}" onclick="displayLocationBranches(this.value);" checked="checked"/> ${locationdetails.location}
                        </c:when>
                        <c:otherwise>
                        <form:checkbox path="state" id="locationchckbox"  value="${locationdetails.locationid}" onclick="displayLocationBranches(this.value);"/> ${locationdetails.location}
                        </c:otherwise>
                        </c:choose>
                        </td></tr>
                        </c:forEach>
                        </table>
                        </TD>
                        <TD>
                        <TD valign="top">
                        <table> 
                        <tr><td>  <label style="float: left;">Branch :*</label>  </td></tr>
                        <tr><td align="left" style="float: left;">
                        </td></tr>
                        <c:forEach  items="${branchdetails}" var="branchname" >
                        <tr><td align="left" class="${branchname.locationid}" id="brachtd"> 
                        <c:choose>
                        <c:when test="${fn:contains(prvbranches.selectedbranchid,branchname.branchid)}">
                        <input type="checkbox" name="branch" id="branchchckbox" value="${branchname.branchid}" checked="checked"/> ${branchname.branch}
                        </c:when>
                        <c:otherwise>
                        <form:checkbox path="branch" id="branchchckbox" value="${branchname.branchid}"/> ${branchname.branch}
                        </c:otherwise>
                        </c:choose>
                        </td></tr>
                        </c:forEach>
                        </table>
                        </TD>
                        <TD>
                        </TR>
                        </TABLE>
                        <input type="button" name="next" id="next" class="next action-button" value="Next" />
                     </fieldset>
                     <fieldset>
                     <h2 class="fs-title"> Copy Created Exam </h2>
                     <table> 
                     <tr><td>  <label style="float: left;">Question Level :*</label>  </td></tr>
                     <tr><td align="left" style="float: left;">
                     </td></tr>
                     <c:forEach  items="${questionlevelslist}" var="questionlevelslist" >
                     <tr><td align="left"> 
                     <c:choose>
                     <c:when test="${fn:contains(prvquslevl.selectedquslevelid,questionlevelslist.questionleveltypeid)}">
                     <input type="checkbox" name="qnleveltypecheckbox" id="qnleveltypecheckbox" value="${questionlevelslist.questionleveltypeid}" checked="checked" readonly="readonly"/> ${questionlevelslist.questionleveltype}
                     </c:when>
                     <c:otherwise>
                     </c:otherwise>
                     </c:choose>
                     </td></tr>
                     </c:forEach>
                     </table>
                     <div class="col-sm-12" style="padding: 4px; float: left;">
                     <label for="status"  style="float: left;">Class :*</label>
                     <form:select path="classname" id="classselect" class="form-control"  required="required" onchange="getsectionsFromClass(this.id); getsubjectsFromClasses(this.id);">
                     <c:forEach  items="${classnames}" var="classname" >
                     <c:choose>
                     <c:when test="${fn:contains(prvclass.selectedclassid,classname.categoryid)}">
                     <option value="${classname.categoryid}"  selected="selected">${classname.category}</option>
                     </c:when>
                     <c:otherwise>
                     </c:otherwise>
                     </c:choose>
                     </c:forEach>
                     </form:select>
                     </div>
                     <input type="hidden" id="sectionvalues" value="${prvsections.selectedsectionid}">
                     <input type="hidden" id="sectionvalues1" value="${prvsections.section}">
                     <div class="col-sm-12" style="padding: 4px; float: left;">
                     <label for="status"  style="float: left;">Section :*</label>
                     <form:select path="sectionname" id="sectionselect" class="form-control"  required="required" multiple="true">
                     <form:option value="0"  >--Select--</form:option>
                     <c:forEach  items="${sectiondetails}" var="sectiondetails" >
                     <c:choose>
                     <c:when test="${fn:contains(prvsections.selectedsectionid,sectiondetails.sectionid)}">
                     <option value="${sectiondetails.sectionid}" selected="selected" >${sectiondetails.section}</option>
                     </c:when>
                     <c:otherwise>
                     </c:otherwise>
                     </c:choose>
                     </c:forEach>
                     </form:select>
                     </div>
                     <div class="col-sm-12" style="padding: 4px; float: left;" id="previoussubjlabel">
                     <label for="status"  style="float: left;">Previous Subjects :*</label>
                     </div>
                     <c:forEach  items="${selclasssubjects}" var="selclasssubjects" >
                     <div class="col-sm-12" style="padding: 4px; float: left; margin-left: 0px;" id="previoussubj">
                     <c:choose>
                     <c:when test="${fn:contains(prvsubjects.selectedsubjectid,selclasssubjects.subjectid)}">
                     <div style="text-align: left;">
                     <input type="checkbox" name="subjectname" id="${selclasssubjects.subjectid}" value="${selclasssubjects.subjectid}" checked="checked" onclick="populateinputBoxes(this.id);getsetTopicstypeAjax(this.id); uncheckquestiontypes_subjectunchecked(this.id);" readonly="readonly"/> ${selclasssubjects.subjectname}
                     <input type="text" class="form-control" name="noofqns_${selclasssubjects.subjectid}'" id="noofqns_${selclasssubjects.subjectid}"  value="${selclasssubjects.selectedsubjectqns}"  placeholder="No.of ? in ${selclasssubjects.subjectid}"  style="width:200px;" onkeypress="return event.charCode >= 48 && event.charCode <= 57" maxlength="3" minlength="1" readonly="readonly"/>
                     </div>
                     </c:when>
                     <c:otherwise>
                     </c:otherwise>
                     </c:choose>
                     </div>
                     </c:forEach>
                     <div class="col-sm-12" style="padding: 4px; float: left;" id="currentsubject">
                     <label for="status"  style="float: left;">Subjects :*</label>
                     </div>
                     <div class="col-sm-12 "  id="subjecttypediv" style="float: left; text-align: left;"> </div>
                     <div class="col-sm-12" id="noofquestions" style="float: left; text-align: left;"> </div>
                     <div class="col-sm-12" style="padding: 4px; float: left;" >
                     <label for="status"  style="float: left;">Previous Topics :*</label>
                     <div class="row"></div>
                     <c:forEach items="${subjtopiclist}" var="subjtopiclist1">
                     ${subjtopiclist1.subjectid}
                     <c:forEach items="${subjtopiclist1.topiclist}" var="subjtopiclist2">
                     <select class="form-control" multiple="multiple">
                     <c:forTokens items="${subjtopiclist2}" delims="," var="mySplit">
                     <option>${mySplit} </option>
                     </c:forTokens>
                     </select>
                     </c:forEach>
                     </c:forEach>
                     </div>
                     <input type="hidden" name="ttlTopicids" value="${hidtempTopicIds}"> 
                     <input type="hidden" name="ttlStopicids" value="${hidtempStopicIds}"> 
                     <div class="col-sm-12" style="padding: 4px; float: left;" >
                     <label for="status"  style="float: left;">Previous Sub Topics :*</label>
                     <div class="row"></div>
                     <c:forEach items="${subjstopiclist}" var="st1">
                     ${st1.subjectid}
                     <c:forEach items="${st1.stopiclist}" var="st2">
                     <select class="form-control" multiple="multiple">
                     <c:forTokens items="${st2}" delims="," var="mySplit">
                     <option>${mySplit} </option>
                     </c:forTokens>
                     </select>
                     </c:forEach>
                     </c:forEach>
                     </div>
                     <div class="col-sm-12" style="padding: 4px; float: left;">
                     <label style="float: left;">Exam Pattern with variation in marks : </label> 
                     <input type="hidden" id="ismarksval" value="${is_marks}">
                     <c:choose>
                     <c:when test="${is_marks=='no'}">
                     <label>  <input type="radio" name="fixedmarks" value="no"   id="noCheckmarks" onclick="fixedmarksischecked();" checked="checked"/>YES</label>
                     </c:when>
                     <c:otherwise>
                     <label>  <input type="radio" name="fixedmarks" value="yes"  id="yesCheckmarks" onclick="fixedmarksischecked();" checked="checked"/>NO</label>
                     </c:otherwise>
                     </c:choose>
                     </div> 
                     <TABLE>
                     <TR>
                     <TD>
                     <label style="float: left;"> Question Type :*</label>
                     </TD>
                     </TR>
                     <c:forEach items="${categorylist}" var="questiontype" varStatus="qtloop">
                     <TR>
                     <TD style="text-align: left;">
                     <c:choose>
                     <c:when test="${fn:contains(prvquestiontype.selectedqustype,questiontype.questiontypeid)}">
                     <input type="checkbox"  name="qntypes" class="check21" id="selectquestiontype${qtloop.index}" value="${questiontype.questiontypeid}" onclick="qusperqustype(${questiontype.questiontypeid},this.id,'marks${qtloop.index}','${questiontype.questiontype}');"  checked="checked" readonly="readonly"/>
                     ${questiontype.questiontype}
                     <table >
                     <c:forEach items="${questiontype.subjectlist}" var="questiontype3" varStatus="loop" >
                     <tr > 
                     <c:forEach items="${questiontype.selectednumofqusperqustype}" var="questiontype2"  begin="${loop.index }" end="${loop.index }">
                     <td style="text-align: left;"> 
                     <span class="previousqnsdata">
                     <input type="text" name="${questiontype3}_${questiontype.questiontypeid}" class="qntypeqnsclass" id="nofoqus" placeholder="No.of que per Ques type in ${questiontype3}" value="${questiontype2}" style="width:300px;"  onkeypress="return event.charCode >= 48 && event.charCode <= 57" maxlength="3" minlength="1" readonly="readonly"/>
                     </span>
                     </td>		  
                     </c:forEach></tr>
                     <tr> <c:forEach items="${questiontype.selectedmarksperqustype}" var="questiontype1"  begin="${loop.index }" end="${loop.index }">
                     <td style="padding-right : 20px;text-align: left;"> 
                     <span class="previousmarksdata">
                     <input type="text" name="${questiontype3}_marks_${questiontype.questiontypeid}" class="qntypemarksclass" id="nofoqusmarks" placeholder=" Marks assigned per ${questiontype3} per ${questiontype.questiontype}" value="${questiontype1}" style="width:300px;" onkeypress="return event.charCode >= 48 && event.charCode <= 57" maxlength="1" minlength="1" readonly="readonly"/>
                     </span>
                     </td>
                     </c:forEach>
                     </tr>
                     <tr>
                     <c:forEach items="${questiontype.selnegmarksperqntype}" var="questiontype4"  begin="${loop.index }" end="${loop.index }">
                     <td style="padding-right : 20px;text-align: left;"> 
                     <span class="previousnegmarksdata">
                     <input type="text" name="${questiontype3}_negmarks_${questiontype.questiontypeid}" class="qntypemarksclass" id="nofoqusnegmarks" placeholder=" Negative Marks per ${questiontype3} per ${questiontype.questiontype}" value="${questiontype4}" style="width:300px;" onkeypress="return validateFloatKeyPress(this,event);"  maxlength="4" readonly="readonly"/>
                     </span>
                     </td>
                     </c:forEach>
                     </tr>
                     </c:forEach>
                     </table>
                     </c:when>
                     <c:otherwise>
                     </c:otherwise>
                     </c:choose>
                     </TD>
                     </TR>
                     <TR> <TD> <TABLE><TR>
                     <TD  style="padding: 3px;text-align: left;" id="${questiontype.questiontypeid}" > </TD></TR>
                     <TR><TD  style="padding: 3px;text-align: left; " id="marks${qtloop.index}" > </TD>
                     </TR></TABLE>
                     </TD>
                     </TR>
                     <TR>
                     <TD  style="padding: 3px;text-align: left;" id="${questiontype.questiontype}" > </TD>
                     </TR>
                     </c:forEach>
                     </TABLE> 
                     <div class="col-sm-12" id="marksperqns">
                     <label >  Marks per Question :*  </label>
                     <form:input class="form-control"  path="marksperqn" id="marksperqn" value="${marksperqustype}" placeholder="Marks per Question" onkeypress="return isNumberKey(event);"  maxlength="2" readonly="readonly"/> 
                     </div>	
                     <input type="button" name="previous" class="previous action-button" value="Previous" />
                     <input type="button" name="next1" class="next1 action-button" value="Next" onclick="return secondpageValidations();"/>
                     <div class="row"></div>
                     <div class="row"></div>
                     <div class="row"></div>
                     <div class="row"></div>
                     </fieldset>
                     <fieldset>
                        <h2 class="fs-title"> Copy Created Exam </h2>
                        <div class="col-md-12 col-sm-12" id="deceased">
                           <div class="form-group col-md-6 col-sm-6">
                              <label for="enddate">Expiry Date :*</label>
                              <form:input type="date"  class="form-control" path="enddate" id="slotexamenddate" placeholder="DD/MM/YY" />
                           </div>
                           <div class="form-group col-md-6 col-sm-6">
                              <label for="examtime" > Test Duration </label>
                              <form:input class="form-control" path="examtime" id="examduration" value="${prevtestduration}"  pattern="([01]?[0-9]|2[0-3])(:[0-5][0-9]){2}" autocomplete="off" required="required" placeholder="HH:MM:SS" title="Time duration accept HH:MM:SS 24hrs format"  readonly="true"/>
                           </div>
                        </div>
                        <div class="col-md-12 col-sm-12" id="negativemarksdivs">
                           <label for="negativemarks" >  Negative Marks :  </label>
                           <form:input class="form-control"  path="negativemarks1" id="negativemarksids" placeholer="Negative Marks" value="${prevnegativemarks}" onkeypress="return validateFloatKeyPress(this,event);"  maxlength="4" readonly="true"/>
                        </div>
                        <div class="col-md-12 col-sm-12">
                           <label for="totalmarks" >  Total Marks :  </label>
                           <form:input class="form-control"  path="totalmarks" id="totalmarks"   readonly="true" />
                        </div>
                        <input type="button" name="previous" class="previous action-button" value="Previous" />
                        <input type="submit" name="submit" class="submit action-button" value="Submit" onclick="return createExamValidations123();"/>
                     </fieldset>
                  </div>
               </form:form>
            </c:if>
         </c:if>
      </div>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.js" type="text/javascript"></script>
      <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js'></script>
      <script>
         //jQuery time
         (function($) {
         var current_fs, next_fs, previous_fs; //fieldsets
         var left, opacity, scale; //fieldset properties which we will animate
         var animating; //flag to prevent quick multi-click glitches
         
         $(".next").click(function() {
         
         
         /** Exam name is Empty */
         var examnamemodel = document.getElementById('examnamemodel');
         var examname = document.getElementById('examname').value;
         if((examname.length==0)||(examname=="")||(examname==" ")||(examname==null)){
         examnamemodel.style.display = "block";
         return false;
         }  
         
         /** Exam name is already exists */
         var examnameexistmodel = document.getElementById('examnameexistmodel');
         if (examnameexists=="Exam name already exists. Please try with other name"){
         examnameexistmodel.style.display = "block";
         return false;
         }
         
         /** Check Previous Exam name**/
         var selexamnameexistmodel = document.getElementById('selectedexamnameexistmodel');
         
         var selectedExam = document.getElementById('selectedExam').value;
         
         var selectedExam1=selectedExam.toUpperCase();
         selectedExam1=selectedExam1.trim();
         var examname1=examname.toUpperCase();
         examname1=examname1.trim();
         if(selectedExam1 == examname1 ){
          selexamnameexistmodel.style.display = "block";
          	return false;
         }
         
         
         
         /** Exam type is Empty */
         var examtypemodel = document.getElementById('examtypemodel');
         var examtypeselectbox = document.getElementById('examtypeselectbox').value; 
         if(examtypeselectbox=="0"){
         examtypemodel.style.display = "block";
         return false;
         }
         
         /** State is Empty */
         var statemodel = document.getElementById('statemodel');
         var statechckboxval = false;
         $("[id='statechckbox']").each( function() {
          if($(this).prop("checked") == true){
          	statechckboxval = true;
          }
          
         });
         if(statechckboxval==false){
         statemodel.style.display = "block";
         return false;
         }
         
         /** Location is Empty */
         var locationmodel = document.getElementById('locationmodel');
         var locationchckboxval = false;
         $("[id='locationchckbox']").each( function() {
          if($(this).prop("checked") == true){
          	locationchckboxval = true;
          }
          
         });
         if(locationchckboxval==false){
         locationmodel.style.display = "block";
         return false;
         }
         
         /** Branch is Empty */
         var branchmodel = document.getElementById('branchmodel');
         var branchhckboxval = false;
         $("[id='branchchckbox']").each( function() {
          if($(this).prop("checked") == true){
          	branchhckboxval = true;
          }
          
         });
         if(branchhckboxval==false){
         branchmodel.style.display = "block";
         return false;
         }
         
         
         if (animating) return false;
         animating = true;
         
         current_fs = $(this).parent();
         next_fs = $(this).parent().next();
         
         //activate next step on progressbar using the index of next_fs
         $("#progressbar li").eq($("fieldset").index(next_fs)).addClass("active");
         
         //show the next fieldset
         next_fs.show();
         
         //hide the current fieldset with style
         current_fs.animate({
           opacity: 0
         }, {
           step: function(now, mx) {
             //as the opacity of current_fs reduces to 0 - stored in "now"
             //1. scale current_fs down to 80%
             scale = 1 - (1 - now) * 0.2;
             //2. bring next_fs from the right(50%)
             left = (now * 50) + "%";
             //3. increase opacity of next_fs to 1 as it moves in
             opacity = 1 - now;
             current_fs.css({
               'transform': 'scale(' + scale + ')'
             });
             next_fs.css({
               'left': left,
               'opacity': opacity
             });
           },
            duration: 800,
           complete: function() {
             current_fs.hide();
             animating = false;
           }, 
           //this comes from the custom easing plugin
           easing: 'easeInOutBack'
         });
         });
         
         
         
         $(".next1").click(function() {
         
         
         var sectionmodel = document.getElementById('sectionmodel');
         var sectionselect= $('#sectionselect :selected').length;
         var sectionselect1= $('#sectionselect :selected').val();
         if(sectionselect<=0 || sectionselect1=="0"){
         sectionmodel.style.display = "block";
         return false;
         }
         
         if (animating) return false;
         animating = true;
         
         current_fs = $(this).parent();
         next_fs = $(this).parent().next();
         
         //activate next step on progressbar using the index of next_fs
         $("#progressbar li").eq($("fieldset").index(next_fs)).addClass("active");
         
         //show the next fieldset
         next_fs.show();
         
         //hide the current fieldset with style
         current_fs.animate({
           opacity: 0
         }, {
           step: function(now, mx) {
             //as the opacity of current_fs reduces to 0 - stored in "now"
             //1. scale current_fs down to 80%
             scale = 1 - (1 - now) * 0.2;
             //2. bring next_fs from the right(50%)
             left = (now * 50) + "%";
             //3. increase opacity of next_fs to 1 as it moves in
             opacity = 1 - now;
             current_fs.css({
               'transform': 'scale(' + scale + ')'
             });
             next_fs.css({
               'left': left,
               'opacity': opacity
             });
           },
            duration: 800,
           complete: function() {
             current_fs.hide();
             animating = false;
           }, 
           //this comes from the custom easing plugin
           easing: 'easeInOutBack'
         });
         });
         
         $(".previous").click(function() {
         if (animating) return false;
         animating = true;
         
         current_fs = $(this).parent();
         previous_fs = $(this).parent().prev();
         
         //de-activate current step on progressbar
         $("#progressbar li").eq($("fieldset").index(current_fs)).removeClass("active");
         
         //show the previous fieldset
         previous_fs.show();
         //hide the current fieldset with style
         current_fs.animate({
           opacity: 0
         }, {
           step: function(now, mx) {
             //as the opacity of current_fs reduces to 0 - stored in "now"
             //1. scale previous_fs from 80% to 100%
             scale = 0.8 + (1 - now) * 0.2;
             //2. take current_fs to the right(50%) - from 0%
             left = ((1 - now) * 50) + "%";
             //3. increase opacity of previous_fs to 1 as it moves in
             opacity = 1 - now;
             current_fs.css({
               'left': left
             });
             previous_fs.css({
               'transform': 'scale(' + scale + ')',
               'opacity': opacity
             });
           },
            duration: 800,
           complete: function() {
             current_fs.hide();
             animating = false;
           }, 
           //this comes from the custom easing plugin
           easing: 'easeInOutBack'
         });
         });
         
         })(jQuery);
         //# sourceURL=pen.js
      </script>
      <script src="${pageContext.request.contextPath}/theme/js/chosenjquery.js"></script>
      <script src="${pageContext.request.contextPath}/theme/js/prism.js"></script>
      <script src="${pageContext.request.contextPath}/theme/js/init.js"></script>
     
      <%@include file="adminfooter.jsp" %>
   </body>
</html>