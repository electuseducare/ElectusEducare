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
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
      <script type="text/javascript">
         var examnameexists = null;
         var getsetTopicstypeAjax = function(subjectid){
         	
         	//If we select more than one subject, pass the subjectids with comma seperater
         	var topicidvalue="";
         	var i=1;
         	var temp=",";
         	$("input[name='subjectname']:checked").each( function () {
         		if(i==1){
         		topicidvalue=$(this).val();
         		}
         		if(i>1){
         			topicidvalue+=temp+""+$(this).val();	
         		}
         		i++;
         	});
         	
         	
         	var subject_type1 = subjectid;
         	
             $.ajax({
                     url : "load-GetTopicsforSubjects?subjectid="+topicidvalue,
                     
                     type: "GET",
                     dataType: "json",
                    
                     success : 
                     
                     function(data) {
                     	//alert(data);
                         var content="";
                         var qnscontent="";
                         var incre=0;
                  
                     	$.each(data,function(i,val){
                     		$.each(val,function(key,value1){
                     			
                                 if(key=="topic"){
                         		content+=value1;
                                 }
                                 else if(key=="topicid")
                                 	{
                                 	  content+='<input type="checkbox"  name="topic" id="'+value1+'" value="'+value1+'" onclick="selectTopicpersubject(this.id);"/>';
                                 	 
                                 	  incre++;
                                 	}
                     			});
                     	});
                     	
                     	document.getElementById("subjecttypediv").innerHTML=content;
                     	
                    
                     }
             });
         }
         
         
      </script>
      <script type="text/javascript">
         var selectTopicpersubject = function(topicid){
         	var topicidvalue="";
         	var i=1;
         	var temp="','";
         	$("input[name='topic']:checked").each( function () {
         		if(i==1){
         		topicidvalue=$(this).val();
         		}
         		if(i>1){
         			topicidvalue+=temp+""+$(this).val();	
         		}
         		i++;
         	});
         	
         	
         
         	$.ajax({
                 url : "load-getSubtopicsinSubjects?topicid="+topicidvalue,
                 type: "GET",
                 dataType: "json",
                
                 success : 
                 function(data) {
                 	
                     var content="";
                     var qnscontent="";
                     var incre=0;
                 	$.each(data,function(i,val){
                 		$.each(val,function(key,value1){
                 			
                             if(key=="subtopic")
                     		content+=value1;
                             else if(key=="subtopicid")
                             	{
                             	  content+='<input type="checkbox"  name="subtopic" id="'+value1+'" value="'+value1+'"/>';
                             	 
                             	  incre++;
                             	}
                 			});
                 	});
                 	
                 	document.getElementById("subtopicsinsubjs").innerHTML=content;
                 	
                
                 }
         });
         	}
         function getexamdurations(){
         	 var slotexamstartdate = document.getElementById('slotexamstartdate').value;
         	  var slotstarttime = document.getElementById('slotstarttime').value;
         	  var slotexamenddate = document.getElementById('slotexamenddate').value;
         	  var slotexamendtime = document.getElementById('slotexamendtime').value;
         
         	  var date1 = new Date(slotexamstartdate+" "+slotstarttime);
         	  var date2 = new Date(slotexamenddate+" "+slotexamendtime);
         	// Convert both dates to milliseconds
         	  var date1_ms = date1.getTime();
         	  var date2_ms = date2.getTime();
         
         	  // Calculate the difference in milliseconds
         	  var difference_ms = date2_ms - date1_ms;
         	  //take out milliseconds
         	  difference_ms = difference_ms/1000;
         	  var seconds = Math.floor(difference_ms % 60);
         	  var secondslength = seconds.toString().length;
         	  if(secondslength==1){
         		  seconds = "0"+seconds;
         	  }
         	  difference_ms = difference_ms/60; 
         	  var minutes = Math.floor(difference_ms % 60);
         	  var minuteslength = minutes.toString().length;
         	  if(minuteslength==1){
         		  minutes = "0"+minutes;
         	  }
         	  difference_ms = difference_ms/60; 
         	  var hours = Math.floor(difference_ms % 24);
         	  var hourslength = hours.toString().length;
         	  if(hourslength==1){
         		  hours = "0"+hours;
         	  }
         	  //var days = Math.floor(difference_ms/24);
         	  examduration = hours + ':' + minutes + ':' + seconds;
         	  document.getElementById("examduration").value=examduration;
         	
         }
         function selectAllQuestiontypes(questtype){
         	//alert(questtype);
         	if(document.getElementById(questtype).checked == true){
         		//qusperqustype(questtype,qtid);
         		var i=0;
         		$(':checkbox').each(function() {
         			document.getElementById("selectquestiontype"+i).checked = true;  
         			i++;
                 });
         	}
         	
         	if(document.getElementById(questtype).checked == false){
         		var j=0;
         		$(':checkbox').each(function() {
         		document.getElementById("selectquestiontype"+j).checked = false;  
         		j++;
         		 });
         	}
         }
         
         function fixedmarksischecked() {
             if (document.getElementById('yesCheckmarks').checked) {
                 document.getElementById('marksperqns').style.display = 'block';
             }
             else {
             	document.getElementById('marksperqns').style.display = 'none';
             }
         }
         
         function qusperqustype(qustypeid,qtid,qmarksclass, qtypename){
         	
         	var mrksperqntype = "";
         	var subjectcnt = 0;
         	var subjectids = "";
         	var content="";
             var qnscontent="";
             
             $("[name='subjectname']").each( function() {
             	subjectids=$('input[name="subjectname"]')[subjectcnt].id
             	if (document.getElementById(subjectids).checked){
             		if( document.getElementById(qtid).checked==true){
             	         qnscontent+='<input type="text" name="'+subjectids+"_"+qustypeid+'" id="nofoqus" placeholder="No.of que pre Ques type in '+subjectids+'" style="width:350px;" onkeypress="return event.charCode >= 48 && event.charCode <= 57" maxlength="3" minlength="1"/>';
             	         if (document.getElementById('yesCheckmarks').checked==false){ 
                 	         mrksperqntype+='<input type="text" name="marks_'+qustypeid+'" id="nofoqusmarks" placeholder=" Marks assigned per '+subjectids+' per '+qtypename+'" style="width:350px;" onkeypress="return event.charCode >= 48 && event.charCode <= 57" maxlength="1" minlength="1"/>';
                 	         }
                 	         if (document.getElementById('yesCheckmarks').checked==true){ 
                     	         mrksperqntype+='';
                     	         }   
             		
             		}if( document.getElementById(qtid).checked==false){
             	         qnscontent+='';
             	         mrksperqntype+="";
             	        }
             	}
             	subjectcnt ++;
             });
             
             
             document.getElementById(qustypeid).innerHTML=qnscontent;
             document.getElementById(qmarksclass).innerHTML=mrksperqntype;
             
         }
         
         
         
         function createExamValidations(){
         
         var examnamemodel = document.getElementById('examnamemodel');
         var examname = document.getElementById('examname').value;
         if((examname.length==0)||(examname=="")){
         	examnamemodel.style.display = "block";
         	return false;
         }
         
         var examnameexistmodel = document.getElementById('examnameexistmodel');
         if (examnameexists=="Exam name already exists. Please try with other name"){
         	examnameexistmodel.style.display = "block";
         	return false;
         }
         
         var statemodel = document.getElementById('statemodel');
         //var statechckbox = document.getElementById('statechckbox').value;
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
         
         var locationmodel = document.getElementById('locationmodel');
         //var locationchckbox = document.getElementById('locationchckbox').value;
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
         
         var branchmodel = document.getElementById('branchmodel');
         //var branchhckbox = document.getElementById('branchchckbox').value;
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
         
         var classmodel = document.getElementById('classmodel');
         var classchkboxval = false;
         $("[id='classselect']").each( function() {
             if($(this).prop("checked") == true){
             	classchkboxval = true;
             }
             
         });
         if(classchkboxval==false){
         	classmodel.style.display = "block";
         	return false;
         }
         
         var sectionmodel = document.getElementById('sectionmodel');
         //var sectionchckbox = document.getElementById('sectionchckbox').value;
         var sectionckboxval = false;
         $("[id='sectionchckbox']").each( function() {
             if($(this).prop("checked") == true){
             	sectionckboxval = true;
             }
             
         });
         if(sectionckboxval==false){
         	sectionmodel.style.display = "block";
         	return false;
         }
         
         var subjectmodel = document.getElementById('subjectmodel');
         var subjecttypess = false;
         
         $("[name='subjectname']").each( function() {
             if($(this).prop("checked") == true){
             	subjecttypess = true;
             }
             
         });
         
         if(subjecttypess==false){
         	subjectmodel.style.display = "block";
         	return false;
         }
         
         
         
         //Validate no of Questions empty per Subject -
         var qnsPersubjectmodel = document.getElementById('qnsPersubjectmodel');
         var qpers = 0;
         qsubjvalueempty = true;
         $("[name='subjectname']").each( function() {
         	
             if($(this).prop("checked") == true){
         	 var qlvalue1 = $("input[id='questionpersubj']").eq(qpers).val();
             if((qlvalue1==null)||(qlvalue1==" ")||(qlvalue1=="")||(qlvalue1.length==0)){
             	qsubjvalueempty = false;   
            	   return false;
             }
            
             }
             qpers++;
         });
         
         if(qsubjvalueempty == false){
         	qnsPersubjectmodel.style.display = "block";
             return false;
         }
         
         var topicmodal = document.getElementById('topicmodal');
         var topictypes = false;
         //Topics are not selected
         $("[name='topic']").each( function() {
                if($(this).prop("checked") == true){
                	topictypes = true;
                }
                
            });
         if(topictypes==false){
         	 topicmodal.style.display = "block";
         		return false;
         	}
         
         var subtopicmodal = document.getElementById('subtopicmodal');
         var subtopictypes = false;
         //Sub Topics are not selected
         $("[name='subtopic']").each( function() {
                if($(this).prop("checked") == true){
                	subtopictypes = true;
                }
                
            });
         if(subtopictypes==false){
         	 subtopicmodal.style.display = "block";
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
         // Validate no of Questions empty per question type - 
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
         }
         }
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
         
         
         
         
         
         var slotexamstartdate = document.getElementById('slotexamstartdate').value;
         var slotstarttime = document.getElementById('slotstarttime').value;
         var slotexamenddate = document.getElementById('slotexamenddate').value;
         var slotexamendtime = document.getElementById('slotexamendtime').value;
         if((slotexamstartdate.length<=0) || (slotexamstartdate==null) ||(slotexamstartdate=="") ){
         	  startslotdatemodal.style.display = "block";
         	  return false;
         }
         if((slotstarttime.length<=0) || (slotstarttime==null) ||(slotstarttime=="") ){
         	  startslottimemodal.style.display = "block";
         	  return false;
         }
         if((slotexamenddate.length<=0) || (slotexamenddate==null) ||(slotexamenddate=="") ){
         	  endslotdatemodal.style.display = "block";
         	  return false;
         }
         if((slotexamendtime.length<=0) || (slotexamendtime==null) ||(slotexamendtime=="") ){
         	  endslottimemodal.style.display = "block";
         	  return false;
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
         		 tempmarks = tempmarks + qlvalue;
         		 idincr++;
         	});
         	var marksperqn = document.getElementById('marksperqn').value;
         	tempmarks=tempmarks*marksperqn;
         	document.getElementById('totalmarks').value=tempmarks;
         }
         
         
         
         }
         
         //Close Exam name modal window
         function closeexamnamemodelwindow() {
         	 var modal = document.getElementById('examnamemodel');
             modal.style.display = "none";
         }
         
         function closestatemodelwindow(){
         	 var modal = document.getElementById('statemodel');
         	    modal.style.display = "none";
         }
         function closelocationmodelwindow(){
         	 var modal = document.getElementById('locationmodel');
         	    modal.style.display = "none";
         }
         function closebranchmodelwindow(){
         	 var modal = document.getElementById('branchmodel');
         	    modal.style.display = "none";
         }
         function closeclassmodelwindow(){
         	 var modal = document.getElementById('classmodel');
         	    modal.style.display = "none";
         }
         function closesectionmodelwindow(){
         	 var modal = document.getElementById('sectionmodel');
         	    modal.style.display = "none";
         }
         function closesubjectmodelwindow(){
         	 var modal = document.getElementById('subjectmodel');
         	    modal.style.display = "none";
         }
         function closeqnsPersubjectmodelwindow(){
         	 var modal = document.getElementById('qnsPersubjectmodel');
         	    modal.style.display = "none";
         }
         //Close topic modal window
         function closetopicsmodel() {
         	 var modal = document.getElementById('topicmodal');
         	    modal.style.display = "none";
         	}
         
         //Close sub topic modal window
         function closesubtopicsmodel() {
         	 var modal = document.getElementById('subtopicmodal');
         	    modal.style.display = "none";
         	}
         	
         //Close question type modal window
         function closequestiontypemodel() {
         	 var modal = document.getElementById('questiontypemodal');
         	    modal.style.display = "none";
         	}
         	
         //Close no of qn type modal window
         function closenoofquestiontypemodel() {
         	 var modal = document.getElementById('noofquestiontypemodal');
         	    modal.style.display = "none";
         	}	
         	
         //Close no of qn marks type modal window
         function closemarksmodel() {
         	 var modal = document.getElementById('noofmarksmodalperqt');
         	    modal.style.display = "none";
         	}	
         //Close startslotdate modal window
         function closesdatemodel() {
         	 var modal = document.getElementById('startslotdatemodal');
         	    modal.style.display = "none";
         	}
         //Close startslottime modal window
           function closestimemodel() {
           	 var modal = document.getElementById('startslottimemodal');
           	    modal.style.display = "none";
           	}
         //Close endslotdate modal window
         function closedatemodel() {
         	 var modal = document.getElementById('endslotdatemodal');
         	    modal.style.display = "none";
         	}
         //Close endslottime modal window
         function closeetimemodel() {
         	 var modal = document.getElementById('endslottimemodal');
         	    modal.style.display = "none";
         	}
         
         function closemarksperqnmodel(){
         	var modal = document.getElementById('marksperqnmodal');
             modal.style.display = "none";
         } 
         
         function closeexamnameexistmodelwindow(){
         	var modal = document.getElementById('examnameexistmodel');
             modal.style.display = "none";
         }
         
         function validExamnameexists(examname){
         	var examnamevalue = document.getElementById('examname').value;
         	
         	var urls="verify-examnamealreadyExists?examnamevalue="+examnamevalue;
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
           
           
         
         
      </script>
      <style>
         /* The Modal (background) */
         .modal {
         position: fixed; /* Stay in place */
         z-index: 1; /* Sit on top */
         padding-top: 150px; /* Location of the box */
         left: 0;
         top: 0;
         width: 100%; /* Full width */
         height: 100%; /* Full height */
         overflow: auto; /* Enable scroll if needed */
         background-color: rgb(0,0,0); /* Fallback color */
         background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
         }
         /* Modal Content */
         .modal-content {
         background-color: #fefefe;
         left:60px;
         margin: auto;
         padding: 20px;
         border: 1px solid #888;
         width: 60%;
         }
         /* The Close Button */
         .closebtn {
         color: red;
         float: right;
         font-size: 22px;
         font-weight: bold;
         cursor: pointer;
         }
      </style>
   </head>
   <body>
      <%@include file="adminUserTopMenu.jsp" %>
      <%@include file="adminUserHeader.jsp" %>
      <%@include file="adminDataTable.jsp" %>
      <!-- start header -->
      <div class="row"> </div>
      <div style="width:22%; float:left; background-color: #ffffff;"><%@include file="AdminDashboardLeftMenu.jsp" %></div>
      <div style="width:70%; float:left; background-color: #ffffff">
         <ul class="nav nav-tabs">
            <li class="active" ><a href="#" >ADD Exam</a></li>
            <!--   <li ><a href="load-DeleteExamform" >DELETE EXAM</a></li> -->
         </ul>
         <!-- Validations Modal Windows -->
         <div id="examnamemodel" class="modal" style="display: none">
            <!-- Modal content -->
            <div class="modal-content">
               <span id="examnamemodelclose" class="closebtn" onclick="closeexamnamemodelwindow();"><strong >CLOSE</strong></span>
               <p><strong>Please Enter Exam Name</strong></p>
            </div>
         </div>
         <div id="examnameexistmodel" class="modal" style="display: none">
            <!-- Modal content -->
            <div class="modal-content">
               <span id="examnameexistmodelclose" class="closebtn" onclick="closeexamnameexistmodelwindow();"><strong >CLOSE</strong></span>
               <p><strong>Please Enter valid exam name. Entered exam name is already exists.</strong></p>
            </div>
         </div>
         <div id="statemodel" class="modal" style="display: none">
            <!-- Modal content -->
            <div class="modal-content">
               <span id="statemodelclose" class="closebtn" onclick="closestatemodelwindow();"><strong >CLOSE</strong></span>
               <p><strong>Please select at least one state</strong></p>
            </div>
         </div>
         <div id="locationmodel" class="modal" style="display: none">
            <!-- Modal content -->
            <div class="modal-content">
               <span id="locationmodelclose" class="closebtn" onclick="closelocationmodelwindow();"><strong >CLOSE</strong></span>
               <p><strong>Please select at least one location</strong></p>
            </div>
         </div>
         <div id="branchmodel" class="modal" style="display: none">
            <!-- Modal content -->
            <div class="modal-content">
               <span id="branchmodelclose" class="closebtn" onclick="closebranchmodelwindow();"><strong >CLOSE</strong></span>
               <p><strong>Please select at least one Branch</strong></p>
            </div>
         </div>
         <div id="classmodel" class="modal" style="display: none">
            <!--   Modal content -->
            <div class="modal-content">
               <span id="classmodelclose" class="closebtn" onclick="closeclassmodelwindow();"><strong >CLOSE</strong></span>
               <p><strong>Please select at least one Class</strong></p>
            </div>
         </div>
         <div id="sectionmodel" class="modal" style="display: none">
            <!-- Modal content -->
            <div class="modal-content">
               <span id="sectionmodelclose" class="closebtn" onclick="closesectionmodelwindow();"><strong >CLOSE</strong></span>
               <p><strong>Please select at least one Section</strong></p>
            </div>
         </div>
         <div id="subjectmodel" class="modal" style="display: none">
            <!-- Modal content -->
            <div class="modal-content">
               <span id="subjectmodelclose" class="closebtn" onclick="closesubjectmodelwindow();"><strong >CLOSE</strong></span>
               <p><strong>Please select at least one Subject</strong></p>
            </div>
         </div>
         <div id="qnsPersubjectmodel" class="modal" style="display: none">
            <!-- Modal content -->
            <div class="modal-content">
               <span id="qnsPersubjectmodelclose" class="closebtn" onclick="closeqnsPersubjectmodelwindow();"><strong >CLOSE</strong></span>
               <p><strong>Please enter number of Questions per subject</strong></p>
            </div>
         </div>
         <div id="topicmodal" class="modal" style="display: none">
            <!-- Modal content -->
            <div class="modal-content">
               <span id="topicsclose" class="closebtn" onclick="closetopicsmodel();"><strong >CLOSE</strong></span>
               <p><strong>Please select at least one topic check box</strong></p>
            </div>
         </div>
         <div id="subtopicmodal" class="modal" style="display: none">
            <!-- Modal content -->
            <div class="modal-content">
               <span id="subtopicsclose" class="closebtn" onclick="closesubtopicsmodel();"><strong >CLOSE</strong></span>
               <p><strong>Please select at least one sub topic check box</strong></p>
            </div>
         </div>
         <div id="questiontypemodal" class="modal" style="display: none">
            <!-- Modal content -->
            <div class="modal-content">
               <span id="qntypeclose" class="closebtn" onclick="closequestiontypemodel();"><strong >CLOSE</strong></span>
               <p><strong>Please select at least one question type check box</strong></p>
            </div>
         </div>
         <div id="noofquestiontypemodal" class="modal" style="display: none">
            <!-- Modal content -->
            <div class="modal-content">
               <span id="noofqntypeclose" class="closebtn" onclick="closenoofquestiontypemodel();"><strong >CLOSE</strong></span>
               <p><strong>Please enter number of questions per question type </strong></p>
            </div>
         </div>
         <div id="noofmarksmodalperqt" class="modal" style="display: none">
            <!-- Modal content -->
            <div class="modal-content">
               <span id="marksclose" class="closebtn" onclick="closemarksmodel();"><strong >CLOSE</strong></span>
               <p><strong>Please enter number of marks per question type</strong></p>
            </div>
         </div>
         <div id="startslotdatemodal" class="modal" style="display: none">
            <!-- Modal content -->
            <div class="modal-content">
               <span id="sdateclose" class="closebtn" onclick="closesdatemodel();"><strong >CLOSE</strong></span>
               <p><strong>Please enter start date</strong></p>
            </div>
         </div>
         <div id="startslottimemodal" class="modal" style="display: none">
            <!-- Modal content -->
            <div class="modal-content">
               <span id="stimeclose" class="closebtn" onclick="closestimemodel();"><strong >CLOSE</strong></span>
               <p><strong>Please enter start time</strong></p>
            </div>
         </div>
         <div id="endslotdatemodal" class="modal" style="display: none">
            <!-- Modal content -->
            <div class="modal-content">
               <span id="edateclose" class="closebtn" onclick="closedatemodel();"><strong >CLOSE</strong></span>
               <p><strong>Please enter end date</strong></p>
            </div>
         </div>
         <div id="endslottimemodal" class="modal" style="display: none">
            <!-- Modal content -->
            <div class="modal-content">
               <span id="etimeclose" class="closebtn" onclick="closeetimemodel();"><strong >CLOSE</strong></span>
               <p><strong>Please enter end time</strong></p>
            </div>
         </div>
         <div id="marksperqnmodal" class="modal" style="display: none">
            <!-- Modal content -->
            <div class="modal-content">
               <span id="marksperqnclose" class="closebtn" onclick="closemarksperqnmodel();"><strong >CLOSE</strong></span>
               <p><strong>Please enter Marks per Question</strong></p>
            </div>
         </div>
         <div class="panel-heading" style="background-color:#ccf2ff;color:black; font-weight: bold;"><img border="0" alt="W3Schools" src="${pageContext.request.contextPath}/theme/images/addicon.jpg" width="40" height="40" style="background-color: skyblue;"></div>
         <div class="panel-body" id="mockTabs" style="background-color:#DFE2DB;height: 100%;">
            <center>
               <h4 style="color:green">${smsg}</h4>
            </center>
            <center>
               <h4 style="color:red">${emsg}</h4>
            </center>
            <c:if test="${smsg==null}" >
               <c:if test="${emsg==null}" >
                  <form:form  name="AddRoleform" method="post" action="insert-ProcessExamForm"  modelAttribute="setexam" >
                     <div>
                        <label for="status" class="col-sm-6 control-label" style="float: left;">Exam Pattern with variation in marks : </label>
                        <form:radiobutton path="fixedmarks" value="yes" label="Yes" id="yesCheckmarks" onchange="fixedmarksischecked();"/>
                        <form:radiobutton path="fixedmarks" value="no" label="No" checked="checked" id="noCheckmarks" onchange="fixedmarksischecked();"/>
                     </div>
                     <div id="examerror" class="col-sm-20" style="color: red;"></div>
                     <div id="examvalid" class="col-sm-20" style="color: green;"></div>
                     <label for="status" class="col-sm-4 control-label" style="float: left;">ExamName :*</label>
                     <div class="col-sm-12" style="box-shadow: 2px 2px 5px #888888; padding: 4px;">
                        <form:input path="examname" id="examname" class="form-control" placecholder="Exam Name" style="background-color: #ccf2ff;" autocomplete="true" onkeyup="validExamnameexists();"/>
                     </div>
                     <br>
                     <label for="status" class="col-sm-4 control-label" style="float: left;">State :*</label>
                     <div class="col-sm-12" style="box-shadow: 2px 2px 5px #888888; padding: 4px;" id="statecheckall">
                        <input type="checkbox" id="checkallstate" value="0" style="margin-left:5px;">Select All
                        <c:forEach  items="${statenames}" var="statenames" >
                           <span >
                              <form:checkbox path="statechckbox" name="statechckbox" value="${statenames.stateid}" id="statechckbox" />
                              ${statenames.statename} 
                           </span>
                        </c:forEach>
                     </div>
                     <script>
                        $("#checkallstate").click(function() {
                          var allChecked = $(this);
                          $("#statecheckall input[type=checkbox]").each(function() {
                            $(this).prop("checked", allChecked.is(':checked'));
                          })
                        });	
                     </script>
                     <br>
                     <label for="status" class="col-sm-4 control-label" style="float: left;">Location :*</label>
                     <div class="col-sm-12" style="box-shadow: 2px 2px 5px #888888; padding: 4px;" id="locatiocheckall">
                        <input type="checkbox" id="checkalllocation" value="0" style="margin-left:5px;">Select All
                        <c:forEach  items="${stateval}" var="classname" >
                           <span class="location" id="location_${classname.stateid}" >
                              <form:checkbox path="state" id="locationchckbox" value="${classname.locationid}"/>
                              ${classname.location} 
                           </span>
                        </c:forEach>
                     </div>
                     <script>
                        $("#checkalllocation").click(function() {
                          var allChecked = $(this);
                          $("#locatiocheckall input[type=checkbox]").each(function() {
                            $(this).prop("checked", allChecked.is(':checked'));
                          })
                        });	
                     </script>
                     <br>
                     <label for="status" class="col-sm-4 control-label" style="float: left;">Branch :*</label>
                     <div class="col-sm-12" style="box-shadow: 2px 2px 5px #888888; padding: 4px;" id="branchcheckall">
                        <input type="checkbox" id="checkallbranch" value="0" style="margin-left:5px;" >Select All
                        <c:forEach  items="${bracnh}" var="branchname" >
                           <span id="${branchname.locationid}" >
                              <form:checkbox path="branch" id="branchchckbox" value="${branchname.branchid}"/>
                              ${branchname.branch} 
                           </span>
                        </c:forEach>
                     </div>
                     <script>
                        $("#checkallbranch").click(function() {
                          var allChecked = $(this);
                          $("#branchcheckall input[type=checkbox]").each(function() {
                            $(this).prop("checked", allChecked.is(':checked'));
                          })
                        });	
                     </script>
                     <br>
                     <label for="status" class="col-sm-4 control-label" style="float: left;">Class :*</label>
                     <div class="col-sm-12" style="box-shadow: 2px 2px 5px #888888; padding: 4px;">
                        <c:forEach  items="${classnames}" var="classname" >
                           <form:checkbox path="classname"  id="classselect" value="${classname.categoryid}"  />
                           ${classname.category}
                        </c:forEach>
                     </div>
                     <br>
                     <label for="status" class="col-sm-4 control-label" style="float: left;">Section :*</label>
                     <div class="col-sm-12" style="box-shadow: 2px 2px 5px #888888; padding: 4px;" id="sectioncheckall">
                        <input type="checkbox" id="checkallsection" value="0" style="margin-left:5px;" >Select All
                        <c:forEach  items="${secitonnameval}" var="secval" >
                           <div id="${secval.categoryid}"  class="${secval.categoryid}">
                              <form:checkbox path="sectionname" id="sectionchckbox" value="${secval.sectionid}"/>
                              ${secval.categoryname}-${secval.section} 
                           </div>
                        </c:forEach>
                     </div>
                     <script>
                        $("#checkallsection").click(function() {
                          var allChecked = $(this);
                          $("#sectioncheckall input[type=checkbox]").each(function() {
                            $(this).prop("checked", allChecked.is(':checked'));
                          })
                        });
                        
                     </script>
                     <label for="status" class="col-sm-4 control-label" style="float: left;">Subject :*</label>
                     <div class="col-sm-12" style="box-shadow: 2px 2px 5px #888888; padding: 4px; display: inline;">
                        <table style="display:inline">
                           <% int subjectrow = 0; %>
                           <c:forEach  items="${subjectval}" var="secval" >
                              <% if(subjectrow==0) { %>
                              <tr>
                                 <%} %>
                                 <td style="padding: 4px">
                                    <form:checkbox path="subjectname"  id="${secval.subjectid}-${secval.subject}" value="${secval.subjectid}" onclick="getsetTopicstypeAjax(this.id); showquestionpersubjectTextBox(this.id);"/>
                                    ${secval.categoryname}-${secval.subject} 
                                 </td>
                                 <td style="padding: 4px; display: none;" id="subqnstab_${secval.subjectid}-${secval.subject}"><input type="text" name="questionsspersubject_${secval.subjectid}" id="questionpersubj" placeholder="No.Of ? in ${secval.subject}" onkeypress="return event.charCode >= 48 && event.charCode <= 57" maxlength="3" minlength="1"> 
                                 </td>
                                 <% if(subjectrow==1) { %> 
                              </tr>
                              <%} %>
                              <% subjectrow++; %>
                              <% if(subjectrow==2) {subjectrow=0; }%>		
                           </c:forEach>
                        </table>
                     </div>
                     <script type="text/javascript">
                        function showquestionpersubjectTextBox(subjectid){
                        	if( document.getElementById(subjectid).checked==true){
                        		document.getElementById('subqnstab_'+subjectid).style.display='block';
                        	}
                        	if( document.getElementById(subjectid).checked==false){
                        		document.getElementById("subqnstab_"+subjectid).style.display='none';
                        		
                        	}
                        }
                        
                     </script>
                     <div class="row"> </div>
                     <label for="status" class="col-sm-4 control-label" style="float: left;">Topics :*</label>
                     <div class="col-sm-12"  id="subjecttypediv" style="box-shadow: 2px 2px 5px #888888; padding: 4px;">
                     </div>
                     <label for="status" class="col-sm-4 control-label" style="float: left;">Sub Topics :*</label>
                     <div class="col-sm-12" id="subtopicsinsubjs" style="box-shadow: 2px 2px 5px #888888; padding: 4px;"> 	</div>
                     <label for="status" class="col-sm-4 control-label" style="float: left;"> Question Type :*</label>
                     <div class="col-sm-12" style="box-shadow: 2px 2px 5px #888888; padding: 4px;">
                        <c:forEach items="${questiontype}" var="questiontype" varStatus="qtloop">
                           <div class="col-sm-12" style="padding: 3px">	<input type="checkbox" name="qntypes" id="selectquestiontype${qtloop.index}" value="${questiontype.questiontypeid}" onclick="qusperqustype(${questiontype.questiontypeid},this.id,'marks${qtloop.index}','${questiontype.questiontype}');"/>
                              ${questiontype.questiontype}
                           </div>
                           <div class="col-sm-6" style="padding: 3px" id="${questiontype.questiontypeid}">  </div>
                           <div class="col-sm-6" style="padding: 3px" id="marks${qtloop.index}"> </div>
                        </c:forEach>
                     </div>
                     <div class="row"></div>
                     <div class="col-md-12 col-sm-12" id="deceased">
                        <div class="form-group col-md-3 col-sm-3">
                           <label for="startdate">Start Date :*</label>
                           <form:input type="date" path="startdate" id="slotexamstartdate" placeholder="DD/MM/YY" style="background-color: #ccf2ff;"/>
                        </div>
                        <div class="form-group col-md-3 col-sm-3">
                           <label for="starttime">Start Time :*</label>
                           <form:input path="starttime" id="slotstarttime" placeholder="HH:MM:SS" style="background-color: #ccf2ff;"/>
                        </div>
                        <div class="form-group col-md-3 col-sm-3">
                           <label for="enddate">End Date :*</label>
                           <form:input type="date" path="enddate" id="slotexamenddate" placeholder="DD/MM/YY" style="background-color: #ccf2ff;"/>
                        </div>
                        <div class="form-group col-md-3 col-sm-3">
                           <label for="endtime">End Time :*</label>
                           <form:input  path="endtime" id="slotexamendtime" placeholder="HH:MM:SS" style="background-color: #ccf2ff;" onchange="getexamdurations();"/>
                        </div>
                     </div>
                     <div class="col-md-12 col-sm-12" id="deceased">
                        <div class="form-group col-md-3 col-sm-3">
                           <label for="examtime" > Test Duration </label>
                           <form:input class="form-control" path="examtime" id="examduration" style="background-color: #ccf2ff;" readonly="true" />
                        </div>
                        <div class="form-group col-md-3 col-sm-3" id="marksperqns" style="display: none;">
                           <label for="examtime" >  Marks per Question :*  </label>
                           <form:input class="form-control"  path="marksperqn" id="marksperqn" style="background-color: #ccf2ff;"  placeholder="Marks per Question" />
                        </div>
                        <div class="form-group col-md-3 col-sm-3" >
                           <label for="negativemarks" >  Negative Marks :  </label>
                           <form:input class="form-control"  path="negativemarks" style="background-color: #ccf2ff;"  placeholer="Negative Marks" onkeypress="return isNumberKey(event);"/>
                        </div>
                        <div class="form-group col-md-3 col-sm-3" >
                           <label for="totalmarks" >  Total Marks :  </label>
                           <form:input class="form-control"  path="totalmarks" id="totalmarks" style="background-color: #ccf2ff;"  readonly="true" />
                        </div>
                     </div>
                     <div class="row"></div>
                     <div class="col-md-12 col-sm-12">
                        <div class="form-group col-md-3 col-sm-3" > &nbsp; </div>
                        <div class="form-group col-md-2 col-sm-2" > &nbsp; </div>
                        <div class="form-group col-md-3 col-sm-3" >
                           <button class="btn-primary" onclick="return createExamValidations();"> SUBMIT </button>
                        </div>
                     </div>
                  </form:form>
               </c:if>
            </c:if>
         </div>
      </div>
      <center>
         <div style="width: 10%;float:right;background-color: #ffffff"> </div>
      </center>
      <%@include file="adminfooter.jsp" %>
   </body>
</html>