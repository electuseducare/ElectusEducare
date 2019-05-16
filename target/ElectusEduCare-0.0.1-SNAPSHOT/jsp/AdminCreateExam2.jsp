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
      <%@include file="adminDataTable.jsp" %>
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
      <link rel="stylesheet" href="${pageContext.request.contextPath}/theme/css/AdminCreateExamStyleSheet.css">
      <script src="${pageContext.request.contextPath}/theme/js/AdminCreateExamAjaxScripts.js"></script>
      <script src="${pageContext.request.contextPath}/theme/js/AdminCreateExamFormValidations.js"></script>
      <style>
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
      </style>
      <script type="text/javascript">
         function secondpageValidations(){
          if (document.getElementById('noCheckmarks').checked==true){
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
          
          if (document.getElementById('yesCheckmarks').checked==true){
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
         
         function isNumberKey(evt)
         {
            var charCode = (evt.which) ? evt.which : event.keyCode
            if (charCode != 45  && charCode > 31 && (charCode < 48 || charCode > 57))
               return false;
         
            return true;
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
         
         var questioncountmsg1=true;
         //***** Questions are not matched with question types
          function dataBaseValidations(qntypevalue,subjectid,qntypeid){ 
         
         	//Get Question Levels
         	 var questioncountmsg=true;
         	 var qleveltmp=",";
            	 var qlevelids="";
            	 $("[name='qnleveltypecheckbox']").each( function() {
            	       if($(this).prop("checked") == true){
            	    	   var qids = $(this).val(); 
            	    	 qlevelids+=qids+qleveltmp;
            	    	   
            	      }
            	 });
         
         
            	 //Exam Type ID
            	var etid=document.getElementById("examtypeselectbox").value;
         
              //Get Topics
             	var topicids = $('#topic_'+subjectid).val();
                 
             	//Get Sub Topics
             	var subtopicids = $('#subtopic_'+subjectid).val();
         
                 $.ajax({
                     url : "load-compareQuestionscount?subid="+subjectid+"&questiontypeids="+qntypeid+"&subtopicids="+subtopicids+"&topicids="+topicids+"&qlevelids="+qlevelids+"&etid="+etid+"&subjectquestions="+qntypevalue,
                     
                     type: "GET",
                     dataType: "text",
                    
                     success : 
                     
                     function(data) {
                     
                     	var quscount1=parseInt(data);
                     	/* qntypevalue = parseInt(qntypevalue); */
                     	var quscount="Entered questions: "+qntypevalue+ " are not available in our database. Only available : "+quscount1+" questions.";
                     
                     	if(qntypevalue!=quscount1){
                     	alert(quscount);
                     	
                     	questioncountmsg1=false;
                     } else{
                    	 questioncountmsg1 = true;
                         }
                  
                     }
             });
         
         
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
            <li class="active"><a href="#">CREATE EXAM</a></li>
            <li><a href="load-createSelectedQuestionsExam">EXAM WITH SELECTED QUESTIONS</a></li>
            <li><a href="load-availableExamsInCopyCreateExam">COPY PREVIOUS CREATED EXAM PATTERN</a></li>
            <li><a href="load-createSelectedQuestionsExamwithFiles">SELECTED FILES</a></li>
         </ul>
         <div class="panel-heading" style="background-color:#ccf2ff;color:black; font-weight: bold;">
            <a href="load-SetExamform" style="text-decoration: none;">
            <img border="0" alt="Add Create Exam" src="${pageContext.request.contextPath}/theme/images/addicon.jpg" width="40" height="40" style="background-color: skyblue;">
            CREATE EXAM </a>
         </div>
         <center>
            <h4 style="color:green">${smsg}</h4>
         </center>
         <center>
            <h4 style="color:red">${emsg}</h4>
         </center>
         <c:if test="${smsg==null}" >
            <c:if test="${emsg==null}" >
               <form:form  name="AddRoleform" method="post" action="insert-ProcessExamForm"  modelAttribute="setexam" >
                  <div id="msform">
                     <!-- progressbar -->
                     <ul id="progressbar">
                        <li class="active">Exam Info1</li>
                        <li>Exam Info2</li>
                        <li>Exam Info3</li>
                     </ul>
                     <!-- fieldsets -->
                     <fieldset>
                        <h2 class="fs-title">Create Exam</h2>
                        <!-- <h3 class="fs-subtitle">This is step 1</h3> -->
                        <div id="examerror" class="col-sm-20" style="color: red;"></div>
                        <div id="examvalid" class="col-sm-20" style="color: green;"></div>
                        <div class="col-sm-12" style="padding: 4px; float: left;">
                           <label style="float: left;;">ExamName :*</label>
                           <form:input path="examname" id="examname" class="form-control" placecholder="Exam Name" autocomplete="true" onkeyup="validExamnameexists();"/>
                        </div>
                        <div class="col-sm-12" style="padding: 4px; float: left;">
                           <label style="float: left;;">Exam Type :*</label>
                           <form:select path="examtypeselectbox" id="examtypeselectbox" class="form-control"  required="required" >
                              <c:forEach  items="${examtypeslist}" var="examtypeslist" >
                                 <form:option value="${examtypeslist.examtypeid}"  >${examtypeslist.examtype}</form:option>
                              </c:forEach>
                           </form:select>
                        </div>
                        <TABLE width="100%">
                           <TR>
                              <TD>
                                 <table>
                                    <tr>
                                       <td> <label style="float: left;">State :*</label> </td>
                                    </tr>
                                    <tr>
                                       <td align="left" style="float: left;">
                                          <c:forEach  items="${statenames}" var="statenames" >
                                    <tr><td align="left"> 
                                    <form:checkbox path="statechckbox" name="statechckbox" value="${statenames.stateid}" id="statechckbox"  onclick="displayStateLocations(this.value);"/> ${statenames.statename}
                                    </td></tr>
                                    </c:forEach>
                                 </table>
                              </TD>
                              <TD>
                                 <table>
                                    <tr>
                                       <td>  <label style="float: left;">Location :*</label>  </td>
                                    </tr>
                                    <tr>
                                       <td align="left" style="float: left;">
                                       </td>
                                    </tr>
                                    <c:forEach  items="${stateval}" var="classname" >
                                       <tr>
                                          <td align="left" class="${classname.stateid}" style="display: none;">
                                             <form:checkbox path="state" id="locationchckbox"  value="${classname.locationid}" onclick="displayLocationBranches(this.value);"/>
                                             ${classname.location}
                                          </td>
                                       </tr>
                                    </c:forEach>
                                 </table>
                              </TD>
                              <TD>
                                 <table>
                                    <tr>
                                       <td>  <label style="float: left;">Branch :*</label>  </td>
                                    </tr>
                                    <tr>
                                       <td align="left" style="float: left;">
                                       </td>
                                    </tr>
                                    <c:forEach  items="${bracnh}" var="branchname" >
                                       <tr>
                                          <td align="left" class="${branchname.locationid}" style="display: none;" id="brachtd">
                                             <form:checkbox path="branch" id="branchchckbox" value="${branchname.branchid}"/>
                                             ${branchname.branch}
                                          </td>
                                       </tr>
                                    </c:forEach>
                                 </table>
                              </TD>
                           </TR>
                        </TABLE>
                        <input type="button" name="next" class="next action-button" value="Next" />
                     </fieldset>
                     <fieldset>
                        <h2 class="fs-title"> Create Exam </h2>
                        <table>
                           <tr>
                              <td>  <label style="float: left;">Question Level :*</label>  </td>
                           </tr>
                           <tr>
                              <td align="left" style="float: left;">
                              </td>
                           </tr>
                           <c:forEach  items="${questionlevelslist}" var="questionlevelslist" >
                              <tr>
                                 <td align="left">
                                    <form:checkbox path="qnleveltypecheckbox" id="qnleveltypecheckbox" value="${questionlevelslist.questionleveltypeid}"/>
                                    ${questionlevelslist.questionleveltype}
                                 </td>
                              </tr>
                           </c:forEach>
                        </table>
                        <div class="col-sm-12" style="padding: 4px; float: left;">
                           <label for="status"  style="float: left;">Class :*</label>
                           <form:select path="classname" id="classselect" class="form-control"  required="required" onchange="getsectionsFromClass(this.id); getsubjectsFromClasses1(this.id);">
                              <form:option value="0"  >--Select--</form:option>
                              <c:forEach  items="${classnames}" var="classname" >
                                 <form:option value="${classname.categoryid}"  >${classname.category}</form:option>
                              </c:forEach>
                           </form:select>
                        </div>
                        <div class="col-sm-12" style="padding: 4px; float: left;">
                           <label for="status"  style="float: left;">Section :*</label>
                           <form:select path="sectionname" id="sectionselect" class="form-control"  required="required" multiple="true" >
                              <c:forEach  items="${sectiondetails}" var="sectiondetails" >
                                 <form:option value="${sectiondetails.sectionid}"  >${sectiondetails.section}</form:option>
                              </c:forEach>
                           </form:select>
                        </div>
                        <div class="col-sm-12" style="padding: 4px; float: left;">
                           <label for="status"  style="float: left;">Subjects :*</label>
                        </div>
                        <div class="col-sm-12 "  id="subjecttypediv" style="float: left;text-align: left;"> </div>
                        <div class="col-sm-12" id="noofquestions" style="float: left;"> </div>
                        <div class="col-sm-12"  style="padding: 4px; float: left;">
                           <label for="status"  style="float: left;">Topics :*</label>
                           <div id="topicsdiv" style="float: left;"></div>
                           <div class="col-sm-12" id="topicsdiv3" style="float: left;">
                           </div>
                        </div>
                        <div class="col-sm-12"  style="padding: 4px; float: left;">
                           <label for="status"  style="float: left;">Sub Topics :*</label>
                           <div id="subtopicsdiv" style="float: left;"></div>
                           <div class="col-sm-12" id="subtopicsdiv4" style="float: left;">
                           </div>
                        </div>
                        <div class="col-sm-12" style="padding: 4px; float: left;">
                           <label style="float: left;">Exam Pattern with variation in marks : </label> 
                           <form:radiobutton path="fixedmarks" value="yes" label="NO" id="yesCheckmarks" onchange="fixedmarksischecked();"/>
                           <form:radiobutton path="fixedmarks" value="no" label="YES" checked="checked" id="noCheckmarks" onchange="fixedmarksischecked();"/>
                        </div>
                        <TABLE>
                           <TR>
                              <TD>
                                 <label style="float: left;"> Question Type :*</label>
                              </TD>
                           </TR>
                           <c:forEach items="${questiontype}" var="questiontype" varStatus="qtloop">
                              <TR>
                                 <TD align="left">
                                    <c:if test="${questiontype.questiontypeid!=105}">
                                       <form:checkbox path="qntypes"  class="check21" id="selectquestiontype${qtloop.index}" value="${questiontype.questiontypeid}" onclick="qusperqustype(${questiontype.questiontypeid},this.id,'marks${qtloop.index}','${questiontype.questiontype}','negmarks${qtloop.index}');"/>
                                       ${questiontype.questiontype}
                                    </c:if>
                                 </TD>
                              </TR>
                              <TR>
                                 <TD  style="padding: 3px" id="${questiontype.questiontypeid}"> </TD>
                              </TR>
                              <TR>
                                 <TD  style="padding: 3px" id="marks${qtloop.index}"> </TD>
                              </TR>
                              <TR>
                                 <TD  style="padding: 3px" id="negmarks${qtloop.index}"> </TD>
                              </TR>
                           </c:forEach>
                        </TABLE>
                        <div class="col-sm-12" id="marksperqns" style="display: none;">
                           <label >  Marks per Question :*  </label>
                           <form:input class="form-control"  path="marksperqn" id="marksperqn"  placeholder="Marks per Question" onkeypress="return isNumberKey(event);"  maxlength="2" />
                        </div>
                        <span id="questionscount" style="display: none"> </span>
                        <input type="button" name="previous" class="previous action-button" value="Previous" />
                        <input type="button" name="next1" class="next1 action-button" value="Next" onclick="return secondpageValidations();"/>
                        <div class="row"></div>
                        <div class="row"></div>
                        <div class="row"></div>
                        <div class="row"></div>
                     </fieldset>
                     <fieldset>
                        <h2 class="fs-title">Create Exam</h2>
                        <div class="col-md-12 col-sm-12" style="float: left;">
                           <div class="form-group col-md-6 col-sm-6">
                              <label for="startdate">Start Date :*</label>
                              <form:input type="date"  class="form-control" pattern="dd/mm/yyyy" path="startdate" id="slotexamstartdate" placeholder="DD/MM/YY" />
                           </div>
                           <div class="form-group col-md-6 col-sm-6">
                              <label for="starttime">Start Time :*</label>
                              <form:input path="starttime" type="time"  class="form-control" id="slotstarttime" placeholder="HH:MM:SS" />
                           </div>
                        </div>
                        <div class="col-md-12 col-sm-12" id="deceased">
                           <div class="form-group col-md-6 col-sm-6">
                              <label for="enddate">End Date :*</label>
                              <form:input type="date"  class="form-control" path="enddate" id="slotexamenddate" placeholder="DD/MM/YY" />
                           </div>
                           <div class="form-group col-md-6 col-sm-6">
                              <label for="endtime">End Time :*</label>
                              <form:input type="time"  path="endtime"  class="form-control" id="slotexamendtime" placeholder="HH:MM:SS"  onchange="getexamdurations();"/>
                           </div>
                        </div>
                        <div class="col-md-12 col-sm-12">
                           <label for="examtime" > Test Duration </label>
                           <form:input class="form-control" path="examtime" id="examduration"  readonly="true" />
                        </div>
                        <div class="col-md-12 col-sm-12" id="negativemarksdivs" style="display: none;">
                           <label for="negativemarks"  >  Negative Marks :  </label>
                           <form:input class="form-control"  path="negativemarks1"  placeholer="Negative Marks" onkeypress="return validateFloatKeyPress(this,event);" maxlength="4"/>
                        </div>
                        <div class="col-md-12 col-sm-12">
                           <label for="totalmarks" >  Total Marks :  </label>
                           <form:input class="form-control"  path="totalmarks" id="totalmarks"   readonly="true" />
                        </div>
                        <input type="button" name="previous" class="previous action-button" value="Previous" />
                        <input type="submit" name="submit" class="submit action-button" value="Submit" onclick="return createExamValidations();"/>
                     </fieldset>
                  </div>
               </form:form>
            </c:if>
         </c:if>
      </div>
      <script src='//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
      <script src="${pageContext.request.contextPath}/theme/js/downloadjs/jquery-easing-min.js"></script>
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
         
         
         /** Question level is Empty */
         var questionlevelmodel = document.getElementById('questionlevelmodel');
         var questionlevelckboxval = false;
         $("[id='qnleveltypecheckbox']").each( function() {
          if($(this).prop("checked") == true){
           questionlevelckboxval = true;
          }
          
         });
         if(questionlevelckboxval==false){
         questionlevelmodel.style.display = "block";
         return false;
         }
         
         var classmodel = document.getElementById('classmodel');
         var classselect = document.getElementById('classselect').value; 
         if(classselect=="0"){
         classmodel.style.display = "block";
         return false;
         }
         
         
         
         var sectionmodel = document.getElementById('sectionmodel');
         var sectionselect= $('#sectionselect :selected').length;
         var sectionselect1= $('#sectionselect :selected').val();
         if(sectionselect<=0 || sectionselect1=="0"){
         sectionmodel.style.display = "block";
         return false;
         }
         
         var subjecttpes = false;
         var subjectmodal = document.getElementById('subjectmodel');
         //Subject types are not selected
         $("[name='subjectname']").each( function() {
               if($(this).prop("checked") == true){
               	subjecttpes = true;
               }
               
           });
         if(subjecttpes==false){
          subjectmodal.style.display = "block";
         	return false;
         }
         
         //number of questions per subject validation
         var noofqnspersubjmodal = document.getElementById('noofqnspersubjmodal');
         var subjectcnt1=0;
         var subjectids1 = 0;
         var noofqnspersubjmodal1 = true;
         $("[name='subjectname']").each( function() {
          subjectids1=$('input[name="subjectname"]')[subjectcnt1].id;
          
         if( document.getElementById(subjectids1).checked==true){
          var noofqnspers = document.getElementById("noofqns_"+subjectids1).value;
          if((noofqnspers=="")||(noofqnspers.length==0)||(noofqnspers==0)){
         	  $("noofqns_"+subjectids1).focus();
         	document.getElementById("noofqns_"+subjectids1).focus();
         	noofqnspersubjmodal1 = false;
          }
         }
         subjectcnt1 ++;
         });
         
         if(noofqnspersubjmodal1==false){
          noofqnspersubjmodal.style.display = "block";
         	return false;
         }
         
         var questiontypemodal = document.getElementById('questiontypemodal');
         var questiontype1 = false;
         //question types are not selected
         $("[name='qntypes']").each( function() {
               if($(this).prop("checked") == true){
               	questiontype1 = true;
               }
               
           });
         if(questiontype1==false){
         questiontypemodal.style.display = "block";
         	return false;
         }
         
         var noofquestiontypemodal = document.getElementById('noofquestiontypemodal');
         //Validate no of Questions empty per question type - 
         var ql = 0;
         qlvalueempty = true;
         $("[id='nofoqus']").each( function() {
              var qlvalue = $("input[id='nofoqus']").eq(ql).val();
         
         if((qlvalue=="")||(qlvalue.length==0)){
                 qlvalueempty = false;   
                 return false;
         }
         ql++;
         });
         
         if(qlvalueempty == false){
              noofquestiontypemodal.style.display = "block";
                     return false;
         }
         
         
         var questionsarenotmatched = false;
         var noofmarksmodalperqt = document.getElementById('noofmarksmodalperqt');
         var  is_marks = document.getElementById('noCheckmarks').value;
         if (document.getElementById('noCheckmarks').checked==true){
         if(is_marks=='no'){
         var ql1 = 0;
         qlvalueempty1 = true;
         $("[id='nofoqusmarks']").each( function() {
              var almarksval = $("input[id='nofoqusmarks']").eq(ql1).val();
         if((almarksval=="")||(almarksval.length==0)){
                 qlvalueempty1= false;   
                 return false;
         }
         ql1++;
         
         });
         if(qlvalueempty1 == false){
          noofmarksmodalperqt.style.display = "block";
         	return false;
         }else{
         questionsarenotmatched = true;
         }
         }
         }
         
         //If Negative Marks empty
         var negmarksmodalperqt = document.getElementById('negmarksmodalperqt');
         var  is_marks1 = document.getElementById('noCheckmarks').value;
         if (document.getElementById('noCheckmarks').checked==true){
         if(is_marks1=='no'){
         var ql2 = 0;
         negvalueempty = true;
         $("[id='nofoqusnegmarks']").each( function() {
              var alnegmarksval = $("input[id='nofoqusnegmarks']").eq(ql2).val();
              
         if((alnegmarksval=="")||(alnegmarksval.length==0)){
          $("input[id='nofoqusnegmarks']").eq(ql2).focus();
          negvalueempty= false;   
                 return false;
         }
         ql2++;
         
         });
         if(negvalueempty == false){
         negmarksmodalperqt.style.display = "block";
         	return false;
         }
         }
         }
         
         //***** Questions are not matched with subjects
         var questionsarenotmatched1=true;
         $("[name='subjectname']").each( function() {
         
            if($(this).prop("checked") == true){
            	 var subjectid = $(this).val();
            	 var subjectquestions = document.getElementById("noofqns_"+subjectid).value;
            	subjectquestions = parseInt(subjectquestions);
            	 var tempsubquestions =0;
            	 $("[name='qntypes']").each( function() {
            	       if($(this).prop("checked") == true){
            	    	   var questiontypeid = $(this).val();  
            	    	   var qntypequestionsid = subjectid+"_"+questiontypeid;
            	    	   var qntypesubjectquestions = $("input[name="+qntypequestionsid+"]").val();
            	    	   var qntypesubjectquestions1 = parseInt(qntypesubjectquestions);
            	    	   tempsubquestions = tempsubquestions + qntypesubjectquestions1;
            	       }
            	 });
            	 if(subjectquestions!=tempsubquestions){
            		 alert("Subject Questions-"+subjectquestions+": Question Type Questions: "+tempsubquestions);
            		questionsarenotmatched1 = false;
            	 }
            }
         });
         
         var qnsandqtypeqnsnotmatchedmodal = document.getElementById('qnsandqtypeqnsnotmatchedmodal');
         if(questionsarenotmatched1==false){
         qnsandqtypeqnsnotmatchedmodal.style.display = "block";
         	return false;
         }
         
         
         if (document.getElementById('noCheckmarks').checked==true){
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
         
         
         var is_marks_yes = document.getElementById('yesCheckmarks').value;
         if (document.getElementById('yesCheckmarks').checked==true){
         if(is_marks_yes=='yes'){
         var marksperqnmodal = document.getElementById('marksperqnmodal');
         var marksperqn = document.getElementById('marksperqn').value;
         if((marksperqn.length<=0) || (marksperqn==null) ||(marksperqn=="")||(marksperqn=="0") ){
         marksperqnmodal.style.display = "block";
           return false;
         }
         }
         }
         
         if (document.getElementById('yesCheckmarks').checked==true){
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
         
         if(questioncountmsg1==false){
         qnsandqtypeqnsnotmatchedmodal.style.display = "block";
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
     
      <%@include file="adminfooter.jsp" %>
   </body>
</html>