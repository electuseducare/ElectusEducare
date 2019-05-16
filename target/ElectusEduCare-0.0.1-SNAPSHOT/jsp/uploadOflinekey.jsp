<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <%@include file="DisplayLogo.jsp" %>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <%@include file="adminDataTable.jsp" %>
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
      <script src="${pageContext.request.contextPath}/theme/js/AdminOfflineAjaxScripts.js"></script>
      <script src="${pageContext.request.contextPath}/theme/js/AdminOfflineFormValidations.js"></script>
      <link rel="stylesheet" href="${pageContext.request.contextPath}/theme/css/AdminCreateExamStyleSheet.css">
      <title>Insert title here</title>
      <script>
         var examnameexists = null;
         function validExamnameexists(){
         	var examnamevalue = document.getElementById('examname').value;
         	
         	var urls="verify-examnamealreadyExistsforofflinekey?examnamevalue="+examnamevalue;
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
             	 examnameexists = xmlhttp.responseText;
             	 if(xmlhttp.responseText=="Exam name already exists. Please try with other name"){
                   	 document.getElementById("examerror").innerHTML=xmlhttp.responseText;
                   	 document.getElementById("examvalid").innerHTML="";
             	 }
             	 else{
             		 document.getElementById("examvalid").innerHTML=xmlhttp.responseText;
             		 document.getElementById("examerror").innerHTML="";
             	 }
               }
            
             }
           xmlhttp.open("POST",urls,true);
           xmlhttp.send();
           }
           
           function addQuestionsToValues(fromname, fromValue){
         	  var replqntypename =  fromname.replace("questionsfrom","_");
         	  var qntypeqns = $("input[name="+replqntypename+"]").val();
         	 
         	  var replqnstoname =  fromname.replace("questionsfrom","questionsto");
         	  qntypeqns = parseInt(qntypeqns);
         	  fromValue = parseInt(fromValue);
         	  
         	  var minusqns = qntypeqns + fromValue;
         	 
         	  var tovalue =  minusqns - 1;
         	  document.getElementsByName(replqnstoname)[0].value = tovalue ;
           }
           
         function secondpageValidations(){
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
         		
         		var sbid = null;
         		var sbid1 = 0;
         		var temptotqns = 0;
         		$("[name='subjectname']").each( function() {
         			sbid=$('input[name="subjectname"]')[sbid1].id;
         		 	 
         		 	if( document.getElementById(sbid).checked==true){
         		 	 var noofqnspers = document.getElementById("noofqns_"+sbid).value;
         		 	 var totalqns1 = parseInt(noofqnspers);
         			  	temptotqns = temptotqns + totalqns1;
         		 	}
         		 	sbid1 ++;
         		 });
         		document.getElementById('totalquestions').value=temptotqns;
         		
         }
         
         
         
         
         var fileExtensions = true;
         function validateExtension() {
         var allowedFiles = [".xlsx"];
         var fileUpload = document.getElementById("uploadBtn");
         var lblError = document.getElementById("lblError2");
         var regex = new RegExp("([a-zA-Z0-9\s_\\.\-:])+(" + allowedFiles.join('|') + ")$");
         if (!regex.test(fileUpload.value.toLowerCase())) {
            lblError.innerHTML = "Please upload files having extensions: <b>" + allowedFiles.join(', ') + "</b> only.";
            fileExtensions = false;
            return false;
         }else{
         
         lblError.innerHTML = "";
         fileExtensions = true;
         return true;
         }
         }
         
      </script>
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
         width: 50.00%;
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
   </head>
   <body>
      <%@include file="adminUserTopMenu.jsp" %>
      <%@include file="adminUserHeader.jsp" %>
      <%@include file="AdminCreateExamModelWindows.jsp" %>
      <!-- =============================================== -->
      <div class="row"></div>
      <div class="panel-heading" style="background-color:#ccf2ff;color:black; font-weight: bold;">
         <a href="load-uploadKeyFile"><img border="0" alt="W3Schools" src="${pageContext.request.contextPath}/theme/images/addicon.jpg" width="40" height="40" style="background-color: skyblue;"></a>
         SUBMIT KEY
         <span style="float: right;"><a href="load-OfflineAnalysis"> Back to Offline Data </a></span>
      </div>
      <div class="row"></div>
      <form:form action="excelupload" method="post" enctype="multipart/form-data">
         <TR>
            <TD align="center">
               <h5 style="color: red">&nbsp;&nbsp;Note: </h5>
               <ul>
                  <li>&nbsp;&nbsp;&nbsp;&nbsp;* Please do not close this window or click on the Back / Refresh button on your browser when upload is processing.</li>
                  <li>&nbsp;&nbsp;&nbsp;&nbsp;* Please use the below id value in place of name in excel.</li>
                  <li>&nbsp;&nbsp;&nbsp;&nbsp;* In download format excel please delete the <span style="color:red"><b>"First Row"</b></span> in excel.</li>
                  <li>&nbsp;&nbsp;&nbsp;&nbsp;* In download format excel please delete the <span style="color:red"><b>"First Column"</b></span> in excel.</li>
                  <li>&nbsp;&nbsp;&nbsp;&nbsp;* In download format excel please enter  the <span style="color:red"><b>"Keys"</b></span> in excel for particular Question Ids provided in excel.</li>
                  <li>&nbsp;&nbsp;&nbsp;&nbsp;* Please download the .xlsx format to upload data: <a href="offlineKeyExcelFormat" class="btn-primary">Download Format</a>
                  </li>
               </ul>
            </TD>
         </TR>
      </form:form>
      <div id="msform">
         <!-- progressbar -->
         <ul id="progressbar">
            <li class="active">Exam Info1</li>
            <li>Exam Info2</li>
         </ul>
         <form:form  method="post" modelAttribute="dataval" enctype="multipart/form-data" action="processOmrKeyData">
            <center>
               <h4 style="color:green">${smsg}</h4>
            </center>
            <center>
               <h4 style="color:red">${emsg}</h4>
            </center>
            <c:if test="${smsg==null}" >
               <c:if test="${emsg==null}" >
                  <!-- fieldsets -->
                  <fieldset>
                     <h2 class="fs-title">Submit Key</h2>
                     <div id="examerror" class="col-sm-20" style="color: red;"></div>
                     <div id="examvalid" class="col-sm-20" style="color: green;"></div>
                     <div class="col-sm-12" style="padding: 4px; float: left;">
                        <label style="float: left;;">ExamName :*</label>
                        <form:input path="examname" id="examname" class="form-control" placecholder="Exam Name" autocomplete="off" onkeyup="validExamnameexists();"/>
                     </div>
                     <div class="col-sm-12" style="padding: 4px; float: left;">
                        <label style="float: left;;">Exam Type :*</label>
                        <form:select path="examtypeselectbox" id="examtypeselectbox" class="form-control"  required="required" >
                           <c:forEach  items="${examtypeslist}" var="examtypeslist" >
                              <form:option value="${examtypeslist.examtypeid}"  >${examtypeslist.examtype}</form:option>
                           </c:forEach>
                        </form:select>
                     </div>
                     <div class="col-sm-12" style="padding: 4px; float: left;">
                        <label for="status"  style="float: left;">Class :*</label>
                        <form:select path="classname" id="classselect" class="form-control"  required="required" onchange="getsectionsFromClass(this.id); getsubjectsFromClasses(this.id);">
                           <form:option value="0"  >--Select--</form:option>
                           <c:forEach  items="${classnames}" var="classname" >
                              <form:option value="${classname.categoryid}"  >${classname.category}</form:option>
                           </c:forEach>
                        </form:select>
                     </div>
                     <div class="col-sm-12" style="padding: 4px; float: left;">
                        <label for="status"  style="float: left;">Subjects :*</label>
                     </div>
                     <div class="col-sm-12 "  id="subjecttypediv" style="float: left;text-align: left;"> </div>
                     <div class="col-sm-12" style="float: left;">
                        <div class="col-sm-8" id="noofquestions" style="float: left;">    </div>
                        <div class="col-sm-2" id="questionsfrm" style="float: left;">    </div>
                        <div class="col-sm-2" id="questionsto" style="float: left;">    </div>
                     </div>
                     <div class="col-sm-12" style="padding: 4px; float: left;">
                        <label for="status"  style="float: left;"> Question Type :*</label>
                        <label for="status"  style="float: right; margin-right: 35px">Questions To :*</label>
                        <label for="status"  style="float: right; margin-right: 35px">Questions From :*</label>
                     </div>
                     <TABLE>
                        <c:forEach items="${questiontype}" var="questiontype" varStatus="qtloop">
                           <TR>
                              <TD align="left">
                                 <c:if test="${questiontype.questiontypeid!=105}">
                                    <form:checkbox path="qntypes"  class="check21" id="selectquestiontype${qtloop.index}" value="${questiontype.questiontypeid}" onclick="qusperqustype(${questiontype.questiontypeid},this.id,'marks${qtloop.index}','${questiontype.questiontype}','negmarks${qtloop.index}','qnsfrom${qtloop.index}','qnsto${qtloop.index}');"/>
                                    ${questiontype.questiontype}
                                 </c:if>
                              </TD>
                           </TR>
                           <TR>
                              <TD  style="padding: 3px" id="${questiontype.questiontypeid}"> </TD>
                           </TR>
                           <TR>
                              <TD  style="padding: 3px" id="marks${qtloop.index}"> </TD>
                              <TD  style="padding: 3px" id="qnsfrom${qtloop.index}"> </TD>
                              <TD  style="padding: 3px" id="qnsto${qtloop.index}"> </TD>
                           </TR>
                           <TR>
                              <TD  style="padding: 3px" id="negmarks${qtloop.index}"> </TD>
                           </TR>
                        </c:forEach>
                     </TABLE>
                     <div class="col-sm-12" style="padding: 4px; float: left;">
                        <label style="float: left;">File Path:*</label>
                        <input class="inputfile"  id="uploadBtn" name="excelfile2007" type="file" accept=".xlsx" onchange="return validateExtension();">
                     </div>
                     <div class="col-sm-12" style="padding: 4px; float: left;">
                        <label id="lblError2" style="text-align: center; color: red; font-weight: bold"></label>
                     </div>
                     <input type="button" name="next" class="next action-button" value="Next" onclick="return secondpageValidations();"/>
                     <div class="row"></div>
                     <div class="row"></div>
                     <div class="row"></div>
                     <div class="row"></div>
                  </fieldset>
                  <fieldset>
                     <h2 class="fs-title"> Submit Key </h2>
                     <div class="col-sm-12" style="padding: 4px; float: left; display: none">
                        <label style="float: left;">Exam Pattern with variation in marks : </label> 
                        <form:radiobutton path="fixedmarks" value="yes" label="NO" id="yesCheckmarks" onchange="fixedmarksischecked();"/>
                        <form:radiobutton path="fixedmarks" value="no" label="YES" checked="checked" id="noCheckmarks" onchange="fixedmarksischecked();"/>
                     </div>
                     <div class="col-sm-12">
                        <label for="totalmarks" >  Total Questions :  </label>
                        <form:input class="form-control"  path="totalquestions" id="totalquestions"   readonly="true" />
                     </div>
                     <div class="col-sm-12">
                        <label for="totalmarks" >  Total Marks :  </label>
                        <form:input class="form-control"  path="totalmarks" id="totalmarks"   readonly="true" />
                     </div>
                     <input type="button" name="previous" class="previous action-button" value="Previous" />
                     <input type="submit" name="submit" class="submit action-button" value="Submit" onclick="return createExamValidations();"/>
                  </fieldset>
               </c:if>
            </c:if>
         </form:form>
      </div>
      <center>
         <div style="width: 10%;float:right;background-color: #ffffff"> </div>
      </center>
      <script src='//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
      <!-- <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js'></script> -->
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
         
         var classmodel = document.getElementById('classmodel');
         var classselect = document.getElementById('classselect').value; 
         if(classselect=="0"){
         classmodel.style.display = "block";
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
         
         $("[name='subjectname']").each( function() {
         
            if($(this).prop("checked") == true){
            	 var subjectid = $(this).val();
            	 var subjectquestions = document.getElementById("noofqns_"+subjectid).value;
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
            		 questionsarenotmatched = false;
            	 }
            	
            }
         });
         
         var qnsandqtypeqnsnotmatchedmodal = document.getElementById('qnsandqtypeqnsnotmatchedmodal');
         if(questionsarenotmatched==false){
         qnsandqtypeqnsnotmatchedmodal.style.display = "block";
         	return false;
         }
         
         if($("#uploadBtn").val() == ''){
         alert("Please browse answer key.")
         return false;
         }
         
         var selectflag = true;
         $.each($('select'),function()
            {
                 if ($(this).val()=="0"){
                	 selectflag=false;
                	 alert("Please select values from - Questions From drop-down.");
                 return false;
                 }
            });
         
          
         
         if(fileExtensions==false){
         alert("Please choose .xlsx format to submit key.");
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