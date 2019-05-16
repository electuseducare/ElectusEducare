<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <%@include file="DisplayLogo.jsp" %>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>Admin Create Exam Selected Questions</title>
      <link href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css" rel="stylesheet">
      <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
      <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
      <link rel="stylesheet" href="${pageContext.request.contextPath}/theme/css/multiselectcss/style.css">
      <link rel="stylesheet" href="${pageContext.request.contextPath}/theme/css/AdminCreateExamStyleSheet.css">
      <link  href="${pageContext.request.contextPath}/theme/css/multiselectcss/fSelect.css" rel="stylesheet">
      <script src="${pageContext.request.contextPath}/theme/js/AdminCreateExamAjaxScripts.js"></script>
      <script src="${pageContext.request.contextPath}/theme/js/AdminCreateExamFormValidations1.js"></script>
      <script src="${pageContext.request.contextPath}/theme/js/multiselectjs/jquery1111min.js"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
      <script src="${pageContext.request.contextPath}/theme/js/multiselectjs/fSelect.js"></script>
      <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
      <script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
     
      <style>
         /* The Modal (background) */
         .modal3 {
         display : none;
         position: fixed; /* Stay in place */
         z-index: 1; /* Sit on top */
         padding-top: 100px; /* Location of the box */
         left: 0;
         top: 0;
         width: 100%; /* Full width */
         height: 100%; /* Full height */
         overflow: auto; /* Enable scroll if needed */
         background-color: rgb(0,0,0); /* Fallback color */
         background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
         }
         /* Modal Content */
         .modal-content3 {
         background-color: #fefefe;
         margin: auto;
         padding: 20px;
         border: 1px solid #888;
         width: 80%;
         }
         /* The Close Button */
         .close3 {
         color: #aaaaaa;
         text-align:center; 
         font-size: 14px;
         font-weight: bold;
         }
         .close3:hover,
         .close3:focus {
         color: #000;
         text-decoration: none;
         cursor: pointer;
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
         width: 25%;
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
         td{
         vertical-align: top;
         }
         .loader {
         position: fixed;
         left: 0px;
         top: 0px;
         width: 100%;
         height: 100%;
         z-index: 9999;
         background: url('${pageContext.request.contextPath}/theme/images/demo_wait.gif')
         50% 50% no-repeat rgb(249, 249, 249);
         opacity: .8;
         }
      </style>
      <script type="text/javascript">
         $(document).ready(function(){
             $(document).ajaxStart(function(){
               $("#loaderstart").css("display", "block");
             });
             $(document).ajaxComplete(function(){
               $("#loaderstart").css("display", "none");
             });
             
           });
         
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
         
         var getsubfromClasForselexam = function(classid){
            	var classid = document.getElementById(classid).value;
                $.ajax({
                        url : "load-getSubjectsfromClasses?classid="+classid,
                        
                        type: "GET",
                        dataType: "json",
                       
                        success : 
                        
                        function(data) {
                        	//alert(data);
                            var content="";
                            var qnscontent="";
                            var qnscontent1="";
                            var incre=0;
                            document.getElementById("subjecttypediv").innerHTML="";
                        	$.each(data,function(i,val){
                        		
                        		$.each(val,function(key,value1){
                        			
                                    if(key=="subject"){
                            		content=value1;
                            		subjectnmames = value1;
                                    }
                                    else if(key=="subjectid")
                                    	{
                                    	
                                 	   var subjvalue = value1.trim();
                                     	document.getElementById("subjecttypediv").innerHTML+='<input type="checkbox" name="subjectname" id="'+value1+'" value="'+value1+'" onclick="getsetTopicstypeAjax1(this.id);"/>'+""+content;
                                     	document.getElementById("topicsdiv3").innerHTML+=''+content+'<select name="topic_'+subjvalue+'" id="topic_'+subjvalue+'"class="form-control" multiple="true" onchange="selectTopicpersubject1('+subjvalue+');"><option>--Please Select--</option> </select>' ;
                                  	    document.getElementById("subtopicsdiv4").innerHTML+=''+content+'<select name="subtopic_'+subjvalue+'" id="subtopic_'+subjvalue+'" class="form-control" multiple="true"><option>--Please Select--</option> </select>' ;
                                     	  incre++;
                                    	}
                        			});
                        	});
                        	
                        	$("#topicsdiv").show();
                       
                        }
                });
            }
         
         
         var fetchQuestions = function(){
               var examtypeid = document.getElementById('examtypeselectbox').value;
               	//If we select more than one subject, pass the subjectids with comma seperater
               var subidval="";
               var subjectid="";
               var tempval="";
               var temp=",";
               var i=1;
               var totalval="";
               $("input[name='subjectname']:checked").each( function () {
               	if(i==1){
               		subidval=$(this).val();
               	}
               	if(i>1){
               		subidval+=temp+""+$(this).val();	
               	}
               	i++;
               });
               var sublist=subidval.split(',');
               for(var j = 0; j < sublist.length; j++) {
               	var subjectid=sublist[j];
               	//Get Topics
               	var topicids = $('#topic_'+subjectid).val();
                   
               	//Get Sub Topics
               	var subtopicids = $('#subtopic_'+subjectid).val();
               
                    tempval=subjectid+"-"+topicids+"_"+subtopicids+"@";
                    totalval=tempval+totalval;
               	
               }
               
               
               	var content1="";
                   $.ajax({
                           url : "load-GetFilenamesforSubjects1?subjectid="+subidval+"&examtypeid="+examtypeid+"&totalval="+totalval,
                           
                           type: "GET",
                           dataType: "json",
                          
                           success : 
                           
               			function(data) {
                           	
                            var datavalues = "";
                            var subjtopic = "";
                           	var content="";
                           	var content1="";
                           	
                           	var temp="";
                           	$('#dataTables-example').dataTable().fnClearTable();
                           	    	$.each(data,function(i,val){
                           	    	  $.each(val,function(key,value1){
                           	    		  if(key=="filenames"){
                           	    			  content1 = value1;
                           	    		  }
                           	    		if(key=="category"){
                      	    			  subjtopic = value1;
                      	    		  }
                           	    			 if(key=="questions"){
                                           		datavalues = value1;
                           	    	      $('#dataTables-example').DataTable().row.add([
                           	    	    	 '<input type="checkbox" name="selectfilenamedata" value='+content1+' onclick="getMultiSelValue(this.id)"> <span style="display:none">'+content1+' </span>',subjtopic,datavalues
                 	            	    		]).draw();
                 	            	    	  
                                           	}
                           	    		 
                           	    });
                           	    	 });
                           }
                  
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
      </script>
      <script>
         function getMultiSelValue(multiselid)
         {
         	//If we select more than one File, pass the filenames with comma seperater
         	var filenamevalue="";
         	var j=1;
         	var temp="','";
         	
         	
         	var oTable = $("#dataTables-example").dataTable();
         	$("input:checkbox", oTable.fnGetNodes()).each(function () {
                 var datachecked = $(this).is(":checked");
                 if (datachecked) {
                 	if(j==1){
             			filenamevalue=$(this).val();
             		}
             		if(j>1){
             			filenamevalue+=temp+""+$(this).val();	
             		}
             		j++;
                 }
             });
         	
         	document.getElementById("filenamesdiv").value = filenamevalue;
           $.ajax({
               url : "load-getQuestionTypesFromFilenames?filenamegroup="+filenamevalue,
               
               type: "GET",
               dataType: "json",
               success : 
               
               function(data) {
         
             	  var qtypenames = "";
             	  var qdatavalues = "";
               	  var questionscontent="";
               	  var negmarkscontent="";
               	  var subjectqnscnt = "";
               	  var temp="";
               	  var kknames="";
               	  var mm=0;
               	     document.getElementById("questiontypeqnsdiv").innerHTML="";
         	    	 document.getElementById("negquestiontypeqnsdiv").innerHTML="";
         	    	 document.getElementById("noofqnspersubject").innerHTML="";
               	    	$.each(data,function(i,val){
               	    	  $.each(val,function(key,value1){
               	    		if(key=="questiontype"){
               	    			qtypenames = value1;
               	    		}
               	    		else if (key=="questiontype1"){
               	    			kknames = value1;
                               		questionscontent +='<input type="text" name="'+qtypenames+'_qtmarks" class="qntypemarksclass" id="qntypemarks" placeholder="Enter +ve marks in '+value1+'" style="width:300px;" onkeypress="return event.charCode >= 48 && event.charCode <= 57" maxlength="1" minlength="1" onkeyup="calculateTotalMarksPerSubject(this.id);"/>';
                               		negmarkscontent +='<input type="text" name="'+qtypenames+'_negmarks" class="qntypemarksclass" id="nofonegqusmarks" placeholder="Enter -ve marks in '+value1+'" style="width:300px;" onkeypress="return validateFloatKeyPress(this,event);" maxlength="4" minlength="1"/>';
                               	}else if(key=="noofqnspersubject"){
                   	    			subjectqnscnt = value1;
                   	    			
                   	    			document.getElementById("noofqnspersubject").innerHTML+='<div class="form-group col-md-6 col-sm-6" style="float:left"> <div class="col-sm-10">'+ kknames+'</div> <div class="col-sm-2"> <input type="text" name="'+qtypenames+'_qnscnt" id="qnscnt"  value ="'+subjectqnscnt+'"  style="width:50px;" readonly="readonly"></div></div>';
                       	    		}
               	    		
               	    });
               	 });
               	    	 document.getElementById("questiontypeqnsdiv").innerHTML=questionscontent;
               	    	 document.getElementById("negquestiontypeqnsdiv").innerHTML=negmarkscontent;
               }
           });
         
         
         }
         
         
         
         
         function calculateTotalMarksPerSubject(positivemarksid){
         
              var totalmarks23 = 0;
              $("[id='qnscnt']").each( function() {
         		 var qlvalue = $(this).attr('name');
         		 var subjectqnscnt = $("input[name="+qlvalue+"]").val(); 
         		 
         		 var enterqnmarksname = qlvalue.replace("_qnscnt","_qtmarks");
         		 var enterqnmarksvalue = $("input[name="+enterqnmarksname+"]").val();   
         		 
         		 if((enterqnmarksvalue!="")){
         			 subjectqnscnt = parseInt(subjectqnscnt);
         			 enterqnmarksvalue = parseInt(enterqnmarksvalue);
         			 var mulCntAndMarks = subjectqnscnt * enterqnmarksvalue;
         			  totalmarks23 = totalmarks23 + mulCntAndMarks;
         			 }
              });
              document.getElementById("positivemarks").value=totalmarks23;
             
         }
         
         function startloader() {
         	document.getElementById("loaderstart").style.display='block';
         }
         
      </script>
      <style type="text/css">
         .button{
         padding: 10px;
         display: inline;
         border-radius: 2px;
         font-family: "Arial";
         border: 0;
         background: red;
         font-size: 15px;
         line-height: 15px;
         color: white;
         width: auto;
         height: auto;
         box-sizing: content-box;
         cursor: pointer;
         }
         #noofqnspersubject {
         -webkit-column-count: 1;
         -moz-column-count: 1;
         column-count: 1;
         -moz-column-gap: 2em;
         -webkit-column-gap: 2em;
         column-gap: 2em;
         }
      </style>
   </head>
   <body>
      <%@include file="adminUserTopMenu.jsp" %>
      <%@include file="adminUserHeader1.jsp" %>
      <%@include file="AdminCreateExamModelWindows1.jsp" %>
      <div id="loaderstart" class="loader" style="display: none;"></div>
      <div class="row"> </div>
      <div style="width:22%; float:left; background-color: #ffffff;"><%@include file="AdminDashboardLeftMenu.jsp" %></div>
      <div style="width:70%; float:left; background-color: #ffffff">
         <ul class="nav nav-tabs">
            <li><a href="load-SetExamformwslot">CREATE EXAM WITHOUT SLOT</a></li>
            <li class="active"><a href="load-createSelQuesWithoutslotExam">EXAM WITH SELECTED ?</a></li>
            <li><a href="load-availableExamsInCopyCreateExamNoslot">COPY PREVIOUS CREATED EXAM PATTERN WITHOUT SLOT</a></li>
             <li ><a href="load-createSelQuesAndFilesWithoutslotExam">SELECTED FILES</a></li>
         </ul>
         <div class="panel-heading" style="background-color:#ccf2ff;color:black; font-weight: bold;">
            <a href="load-createSelQuesWithoutslotExam" style="text-decoration: none;">
            <img border="0" alt="Add Create Exam" src="${pageContext.request.contextPath}/theme/images/addicon.jpg" width="40" height="40" style="background-color: skyblue;">
            CREATE SELECTED QUESTIONS EXAM </a>
         </div>
         <center>
            <h4 style="color:green">${smsg}</h4>
         </center>
         <center>
            <h4 style="color:red">${emsg}</h4>
         </center>
         <c:if test="${smsg==null}" >
            <c:if test="${emsg==null}" >
               <form:form  name="AddRoleform" method="post" action="insert-withoutSlotSelQuesExam"  modelAttribute="setselectedquesexam" >
                  <div id="msform">
                     <ul id="progressbar">
                        <li class="active">Exam Info1</li>
                        <li>Exam Info2</li>
                        <li>Exam Info3</li>
                        <li>Exam Info3</li>
                     </ul>
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
                        <div class="col-sm-12" style="padding: 4px; float: left;">
                           <label for="status"  style="float: left;">Class :*</label>
                           <form:select path="classname" id="classselect" class="form-control"  required="required" onchange="getsectionsFromClass(this.id);getsubfromClasForselexam(this.id);">
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
                        <div class="col-sm-12 ">
                           <div class="col-sm-6" id="noofquestions" style="float: left;"> </div>
                           <div class="col-sm-6" id="noofquestions1" style="float: left;"> </div>
                        </div>
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
                        <div class="row "></div>
                        <div class="row "></div>
                        <div class="col-sm-12 ">
                           <input type="button" name="fetchfiles"  value="Fetch Files" onclick="fetchQuestions();"/>
                        </div>
                        <div class="col-sm-12" id="noofquestions" style="float: left;"> </div>
                        <div class="col-sm-12" style="padding: 4px; float: left;">
                           <label for="status"  style="float: left;">Filenames :*</label>
                           <input type="hidden" name="filenames" id="filenamesdiv">
                        </div>
                       
                        <div class="col-sm-12" style="float: left;">
                           <table class="table table-striped table-bordered table-hover" id="dataTables-example" border="1">
                              <thead>
                                 <tr>
                                     <th width="15%">Select ?</th>
                                    <th width="20%">Subj - Topic</th>
                                    <th width="65%">Question</th>
                                 </tr>
                              </thead>
                              <tbody>
                              </tbody>
                           </table>
                        </div>
                        
                        <div class="col-sm-12" style="padding: 4px; float: left;">
                           <label style="float: left;;">Selected Questions Count :*</label>
                        </div>
                        <TABLE width="100%">
                           <TR>
                              <TD style="padding: 2px; display: inline-block;" id="noofqnspersubject">  </TD>
                           </TR>
                        </TABLE>
                        <div class="col-sm-12" style="padding: 4px; float: left;" id="questiontypeqnsdiv"> 	  </div>
                        <div class="col-sm-12" style="padding: 4px; float: left;" id="negquestiontypeqnsdiv"> 	  </div>
                        <div class="col-sm-12" style="padding: 4px; float: left;">
                           <label style="float: left;;">Total Marks :*</label>
                           <form:input path="positivemarks" id="positivemarks" class="form-control"  autocomplete="true" readonly="true"/>
                        </div>
                       
                        <input type="button" name="previous" class="previous action-button" value="Previous" />
                        <input type="button" name="next1" class="next1 action-button" value="Next" onclick="return secondpageValidations();"/>
                     </fieldset>
                     <fieldset>
                        <h2 class="fs-title">Create Exam</h2>
                       
                        <div class="col-md-12 col-sm-12" id="deceased">
                           <div class="form-group col-md-6 col-sm-6">
                              <label for="enddate">Expiry Date :*</label>
                              <form:input type="date"  class="form-control" path="enddate" id="slotexamenddate" placeholder="DD/MM/YY" />
                           </div>
                          
                           <div class="form-group col-md-6 col-sm-6">
                              <label for="examtime" > Test Duration </label>
                              <form:input class="form-control" path="examtime" id="examduration" pattern="([01]?[0-9]|2[0-3])(:[0-5][0-9]){2}" autocomplete="off" required="true" placeholder="HH:MM:SS" title="Time duration accept HH:MM:SS 24hrs format"  />
                           </div>
                        </div>
                       
                        <div class="col-md-12 col-sm-12" style="display: none;">
                           <label for="negativemarks" >  Negative Marks :  </label>
                           <form:input class="form-control"  path="negativemarks1"  placeholer="Negative Marks" onkeypress="return validateFloatKeyPress(this,event);"  maxlength="4" />
                        </div>
                        <div class="col-md-12 col-sm-12" style="display: none;">
                           <label for="totalmarks" >  Total Marks :  </label>
                           <form:input class="form-control"  path="totalmarks" id="totalmarks"   readonly="true" />
                        </div>
                        <input type="button" name="previous" class="previous action-button" value="Previous" />
                        <input type="button" name="next2" class="next2 action-button" value="Next" onclick="return createExamValidations();"/>
                     </fieldset>
                     <fieldset>
                        <h2 class="fs-title">QUESTIONS REVIEW</h2>
                        <div class="col-md-12 col-sm-12" >
                           <label for="review" > Please Click on below button to Review selected Questions :  </label>   
                           <div class="col-md-4 col-sm-4" style="float: right;">
                              <button type="button" id="myBtn3"  style="float: left;display: block;">REVIEW QUESTION PAPER</button>
                           </div>
                           <!-- The Modal -->
                           <div id="myModal3" class="modal3">
                              <!-- Modal content -->
                              <div class="modal-content3">
                                 <div id="analysis123">REVIEW QUESTIONS</div>
                                 <div class="row"></div>
                                 <button style="text-align: center;" type="button" class="close3">CLOSE  </button> 
                              </div>
                           </div>
                           <script>
                              // Get the modal
                              var modal = document.getElementById('myModal3');
                              
                              // Get the button that opens the modal
                              var btn = document.getElementById("myBtn3");
                              
                              // Get the <span> element that closes the modal
                              var span = document.getElementsByClassName("close3")[0];
                              
                              // When the user clicks the button, open the modal 
                              btn.onclick = function() {
                                  modal.style.display = "block";
                                  
                              	//If we select more than one File, pass the filenames with comma seperater
                              	var filenamevalue="";
                              	var j=1;
                              	var temp="','";
                              	
                              	
                              	var oTable = $("#dataTables-example").dataTable();
                              	$("input:checkbox", oTable.fnGetNodes()).each(function () {
                                      var datachecked = $(this).is(":checked");
                                      if (datachecked) {
                                      	if(j==1){
                                  			filenamevalue=$(this).val();
                                  		}
                                  		if(j>1){
                                  			filenamevalue+=temp+""+$(this).val();	
                                  		}
                                  		j++;
                                      }
                                  });
                              	
                                  
                              	   $.ajax({
                              	        url : "load-getQuestionsBaesedonOnfilenames?filenames="+filenamevalue,
                              	        
                              	        type: "GET",
                              	        dataType: "json",
                              	        success : 
                              	       
                              	        function(data) {
                              	      	  var ques="";
                              	      	  var filenames="";
                              	      	  document.getElementById("analysis123").innerHTML="";
                              	      	  $.each(data,function(i,val){
                              	        		$.each(val,function(key,value1){
                              	               	if(key=="filenames"){
                              	               		ques=value1;
                              	              
                              	                	} else if(key=="questions"){
                              	                		filenames=value1;
                              	                		document.getElementById("analysis123").innerHTML+='<table border="1"  width="100%"><tr><td style="text-align:center;background-color:#E4E4E4" width="100%"><label style="color:red">Filename:</label> '+ques+'</td></tr><tr><td style="float:left;text-align:left" colspan="2" width="100%">'+filenames+'</td></tr></table>';
                              	                	}
                              	  	
                              	  	    	 });
                              	        	    	 
                              	        	 });	
                              	        }
                              	    }); 
                              	    
                              	}
                              
                              // When the user clicks on <span> (x), close the modal
                              span.onclick = function() {
                                  modal.style.display = "none";
                              }
                              
                              
                           </script>
                        </div>
                        <input type="button" name="previous" class="previous action-button" value="Previous" />
                        <input type="submit" name="submit" class="submit action-button" onclick="startloader();" value="Submit" />
                     </fieldset>
                  </div>
               </form:form>
            </c:if>
         </c:if>
      </div>
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
         
         
         /** Class is Empty */
         var classmodel = document.getElementById('classmodel');
         var classselect = document.getElementById('classselect').value; 
         if(classselect=="0"){
         classmodel.style.display = "block";
         return false;
         }
         
         
         
         
         /** Section is Empty */
         var sectionmodel = document.getElementById('sectionmodel');
         var sectionselect = $('#sectionselect :selected').length;
         var sectionselect1= $('#sectionselect :selected').val();
         if((sectionselect<=0 || sectionselect1=="0")){
         sectionmodel.style.display = "block";
         return false;
         }
         
         /** Subject is Empty */
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
         
         
         
         /** Filename is Empty */
         var filenameischecked = false;
         var oTable = $("#dataTables-example").dataTable();
         $("input:checkbox", oTable.fnGetNodes()).each(function () {
             var tuisre = $(this).is(":checked");
             if (tuisre) {
             	filenameischecked = true;
             }
         })
         
         // var filenamesdiv1 =$('#filenamesdiv :selected').length;
         var filenamesmodel = document.getElementById('filenamesmodel');
         if(filenameischecked==false){
         filenamesmodel.style.display = "block";
         	return false;
         }
         
         //Validate no of marks empty per question type 
         var noofmarkstypemodal = document.getElementById('noofmarkstypemodal');
         var ql = 0;
         noofmarkseempty = true;
         $("[id='qntypemarks']").each( function() {
              var qlvalue = $("input[id='qntypemarks']").eq(ql).val();
         
         if((qlvalue=="")||(qlvalue.length==0)||(qlvalue==0)){
          noofmarkseempty = false;   
                 return false;
         }
         ql++;
         });
         
         if(noofmarkseempty == false){
         noofmarkstypemodal.style.display = "block";
           return false;
         }
         //Validate no of negative marks empty per question type 
         var noofnegmarkstypemodal = document.getElementById('noofnegmarkstypemodal');
         var ql = 0;
         negmarkseempty = true;
         $("[id='nofonegqusmarks']").each( function() {
              var qlvalue = $("input[id='nofonegqusmarks']").eq(ql).val();
         
         if((qlvalue=="")||(qlvalue.length==0)||(qlvalue==" ")||(qlvalue=="  ")){
          negmarkseempty = false;   
                 return false;
         }
         ql++;
         });
         
         if(negmarkseempty == false){
         noofnegmarkstypemodal.style.display = "block";
           return false;
         }
         
         
         
         
         
         /** Positivemarks is Empty */
         var positivemarksmadel = document.getElementById('positivemarksmadel');
         var positivemarks = document.getElementById('positivemarks').value;
         if((positivemarks.length==0)||(positivemarks=="")||(positivemarks==" ")||(positivemarks==null)||(positivemarks==0)){
         positivemarksmadel.style.display = "block";
         return false;
         }
         
         var filenamesdiv=$('#filenamesdiv :selected').length;
         var positivemarks1 = document.getElementById('positivemarks').value;
         positivemarks1=parseInt(positivemarks1);
         positivemarks1=positivemarks1*filenamesdiv;
         document.getElementById('totalmarks').value=positivemarks1;
         
         
         
         
         
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
         
         $(".next2").click(function() {
         
         
         
         var slotexamenddate = document.getElementById('slotexamenddate').value;
         
         if((slotexamenddate.length<=0) || (slotexamenddate==null) ||(slotexamenddate=="") ){
         endslotdatemodal.style.display = "block";
           return false;
         }
         var exdrmodal = document.getElementById('exdrmodal');
         var slotexamenddate = document.getElementById('examduration').value;
         var regexp = new RegExp(/^([0-2][0-3]):([0-5][0-9]):([0-5][0-9])$/);
         if(regexp.test(slotexamenddate)==false){
         exdrmodal.style.display = "block";
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
         
         
         })(jQuery);
         //# sourceURL=pen.js
      </script>
     
   </body>
</html>