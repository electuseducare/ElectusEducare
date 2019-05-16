<link rel="stylesheet"
   href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<%-- <link
   href="${pageContext.request.contextPath}/theme/css/calculator/jquery-ui.min.css"
   rel="stylesheet" type="text/css" />
<script
   src="${pageContext.request.contextPath}/theme/css/calculator/jquery-latest.min.js"></script>
<script
   src="${pageContext.request.contextPath}/theme/css/calculator/jquery-ui.min.js"></script>
<link
   href="${pageContext.request.contextPath}/theme/css/calculator/keyboard.css"
   rel="stylesheet">
<script
   src="${pageContext.request.contextPath}/theme/css/calculator/jquery.keyboard.js"></script>
<script
   src="${pageContext.request.contextPath}/theme/css/calculator/jquery.mousewheel.js"></script>
<script
   src="${pageContext.request.contextPath}/theme/css/calculator/jquery.keyboard.extension-typing.js"></script>
<link
   href="${pageContext.request.contextPath}/theme/css/calculator/calculator.css"
   rel="stylesheet">
<script
   src="${pageContext.request.contextPath}/theme/css/calculator/calculator.js"></script> --%>
<style type="text/css">
   body {
   margin: 0;
   padding: 0;
   overflow: hidden;
   height: 100%;
   max-height: 100%;
   font-family: Sans-serif;
   line-height: 1.5em;
   }
   .btn:hover, .btn:focus, .btn:active, .btn.active, .open>.dropdown-toggle.btn-add
   {
   background-color: #0C7CD5;
   border-color: #398439;
   color: #fff;
   }
   main {
   position: fixed;
   top: 140px; /* Set this to the height of the header */
   bottom: 50px; /* Set this to the height of the footer */
   left: 0;
   width: 100%;
   overflow: auto;
   background: #fff;
   }
   #header {
   position: absolute;
   top: 0;
   left: 0;
   width: 100%;
   height: 50px;
   overflow: hidden;
   /* Disables scrollbars on the header frame. To enable scrollbars, change "hidden" to "scroll" */
   background: #5BB1FA;
   }
   #instuctionsbtn {
   position: fixed;
   top: 50px;
   left: 0;
   width: 100%;
   text-align: right;
   color: #FFFFFF;
   height: 30px;
   overflow: hidden;
   /* Disables scrollbars on the header frame. To enable scrollbars, change "hidden" to "scroll" */
   background: #000000;
   }
   .instructionheader {
   background: #000000;
   color: #FFFFFF;
   font-family: Arial, Helvetica, sans-serif;
   height: 30px;
   padding: 0;
   font-size: 1em;
   font-weight: bold;
   text-align: right;
   padding-left: 10px;
   cursor: pointer;
   line-height: 30px;
   }
   .instructionheader a {
   color: white;
   padding: 8px;
   }
   #examheader {
   position: absolute;
   top: 80px;
   left: 0;
   width: 75%;
   height: 50px;
   overflow: hidden;
   /* Disables scrollbars on the header frame. To enable scrollbars, change "hidden" to "scroll" */
   background: #f7fcfc;
   }
   .timeheader {
   width: 75%;
   position: fixed;
   top: 135px;
   height: 20px;
   border-bottom: 1px solid #C6c9ce;
   padding: 0;
   left: 0px;
   right: 0px;
   }
   .footer1 {
   position: fixed;
   left: 0;
   bottom: 0;
   width: 100%;
   height: 30px;
   overflow: hidden;
   /* Disables scrollbars on the footer frame. To enable scrollbars, change "hidden" to "scroll" */
   background: #617B8C;
   }
   #nav {
   position: fixed;
   top: 80px; /* Set this to the height of the header */
   bottom: 0px; /* Set this to the height of the footer */
   right: 0;
   width: 25%;
   height: 100%;
   overflow: auto;
   /* Scrollbars will appear on this frame only when there's enough content to require scrolling. To disable scrollbars, change to "hidden", or use "scroll" to enable permanent scrollbars */
   background: #FFFFFF;
   }
   .innertube {
   margin: 15px; /* Provides padding for the content */
   }
   p {
   color: #555;
   }
   nav ul {
   list-style-type: none;
   margin: 0;
   padding: 0;
   }
   nav ul a {
   color: darkgreen;
   text-decoration: none;
   }
   /*IE6 fix*/
   * html body {
   padding: 50px 0 50px 230px;
   /* Set the first value to the height of the header, the third value to the height of the footer, and last value to the width of the nav */
   }
   * html main {
   height: 100%;
   width: 100%;
   }
   .shadow1 {
   width: 100%;
   height: 100px;
   box-shadow: 5px 5px 5px rgba(68, 68, 68, 0.6);
   background-color: white;
   position: fixed;
   top: 80px;
   }
   .shadow2 {
   width: 90%;
   height: 460px;
   box-shadow: 5px 5px 5px rgba(68, 68, 68, 0.6);
   background-color: white;
   border-top-color: black;
   margin-top: 0px;
   border-left: 1px solid #000;
   background-color: #E5F6FD;
   position: fixed;
   top: 380px;
   }
   .shadow3 {
   width: 25%;
   height: 280px;
   box-shadow: 5px 5px 5px rgba(68, 68, 68, 0.6);
   background-color: white;
   margin-top: 1px;
   border-left: 1px solid #000;
   border-top: 1px solid #000;
   position: fixed;
   top: 180px;
   }
   .rightshadowbtns {
   background: #FFFFFF;
   border-top: 1px solid #7691A2;
   color: #FFFFFF;
   font-family: Arial, Helvetica, sans-serif;
   height: 80px;
   padding: 10px;;
   font-size: 1em;
   font-weight: bold;
   text-align: center;
   padding-right: 20px;
   cursor: pointer;
   line-height: 10px;
   bottom: 30px;
   width: 25%;
   position: fixed;
   }
   #btnfooter {
   background: #363636;
   border-top: 1px solid #7691A2;
   color: #FFFFFF;
   font-family: Arial, Helvetica, sans-serif;
   height: 80px;
   padding: 10px;;
   font-size: 1em;
   font-weight: bold;
   text-align: center;
   padding-left: 20px;
   cursor: pointer;
   line-height: 10px;
   bottom: 30px;
   width: 75%;
   position: fixed;
   }
   .profile_details {
   float: right;
   left: 85%;
   top: 130px;
   position: fixed;
   }
   #Username {
   color: #2c363f;
   float: left;
   font-size: 1.2em;
   font-weight: bold;
   width: 100%;
   padding: 4px;
   }
</style>
<script>
   $(document).ready(function(){
       $(".nxtsubje").mouseover(function(){
           $(".nxtsubje").css("background-color", "#5bc0de");
       });
       $(".nxtsubje").mouseout(function(){
           $(".nxtsubje").css("background-color", "#428bca");
       });
      
   });
   
   
</script>
<script>
   var markAsReviewNotAnsweredCount = function(subjectid,questionid,questionrowid,markvalue){
   
   	
   	var sid =  document.getElementById('stu').value;
   	var examname = document.getElementById('examname').value;
   	
   	  $.ajax({
             url : "load-markAsRevNotAnsCntforsubjwise?examname="+examname+"&studentid="+sid+"&subjectid="+subjectid+"&questionid="+questionid+"&questionrowid="+questionrowid+"&markvalue="+markvalue+"",
             type: "POST",
             dataType: 'json',
             success : 
             function(data) {
           	  var attempt=data;
           	 var notanscnt = document.getElementById(subjectid+"_notansweredbtn").innerHTML; 
           	 notanscnt = notanscnt-attempt;
           	 document.getElementById(subjectid+"_notansweredbtn").innerHTML = notanscnt;
                 document.getElementById(subjectid+"_markasrevnotansbtn").innerHTML=attempt; 
                
             }    	
   	    });
   	}
   var markAsReviewAnsweredCount = function(subjectid,questionid,questionrowid,markvalue){
   
   	
   	var sid =  document.getElementById('stu').value;
   	var examname = document.getElementById('examname').value;
   	
   	  $.ajax({
             url : "load-markAsRevAnsCntforsubjwise?examname="+examname+"&studentid="+sid+"&subjectid="+subjectid+"&questionid="+questionid+"&questionrowid="+questionrowid+"&markvalue="+markvalue+"",
             type: "POST",
             dataType: 'json',
             success : 
             function(data) {
           	  var attempt=data;
           	  var notanscnt = document.getElementById(subjectid+"_notansweredbtn").innerHTML; 
            	 notanscnt = notanscnt-attempt;
            	 document.getElementById(subjectid+"_notansweredbtn").innerHTML = notanscnt;
            	 
           	 document.getElementById(subjectid+"_markasrevansbtn").innerHTML=attempt;
           	  attemptcount(subjectid);
                
             }    	
   	    });
   	}
   
   function markAsReviewAndAttempted(selectedname,qnoval, subjectid,questionid,questionrowid) {  
       
       var checkval= selectedname;
             var multiselctvalue="";
             var i=0;
             var valuechecked= $("input[name='"+checkval+"']");
             var inputtype = valuechecked.attr('type');
             if(inputtype===undefined){
                      $("[name='"+checkval+"'] option:selected").each( function(){
      i++;
                      });         
                 }
     
             
             if(inputtype!='text'){
             $(valuechecked).each( function () {
                     
                      if($(this).prop('checked') == true){
                                     i++;
                     }
             });
             }else{
                     valuechecked = valuechecked.val();
                     if(valuechecked.length>0){
                         i++;
                 }
             }
   
             if(i>0){
                      markAsReviewAnsweredCount(subjectid,questionid,questionrowid,"MRA");
                      $("#span_"+qnoval).removeClass().addClass('review_marked auditlog');
             }else{
                     markAsReviewNotAnsweredCount(subjectid,questionid,questionrowid, "MR");        
                      $("#span_"+qnoval).removeClass().addClass('review auditlog');
             }
   
   }
   
   
</script>
<script>
   var subjectwisenotanswercount = function(subjectid){
   
   	var examname=document.getElementById('examname').value;
   	var sid =  document.getElementById('stu').value;
       $.ajax({
               url : "load-unattemptcountforsubjectwise?examname="+examname+"&studentid="+sid+"&subjectid="+subjectid+"",
               type: "POST",
               dataType: 'json',
               success : 
               function(data) {
               	 var unattemptcountforsub=data;
          		     document.getElementById(subjectid+"_notansweredbtn").innerHTML=data; 
            }    	
       });
   }
   
   
   
   
   
    function preventBack(){window.history.forward();}
   setTimeout("preventBack()", 0);
   window.onunload=function(){null}; 
   document.addEventListener('contextmenu', event =event.preventDefault());
</script>
<script type="text/javascript">  
   function toggleFullScreen(elem) {
   
       // ## The below if statement seems to work better ## if ((document.fullScreenElement && document.fullScreenElement !== null) || (document.msfullscreenElement && document.msfullscreenElement !== null) || (!document.mozFullScreen && !document.webkitIsFullScreen)) {
       if ((document.fullScreenElement !== undefined && document.fullScreenElement === null) || (document.msFullscreenElement !== undefined && document.msFullscreenElement === null) || (document.mozFullScreen !== undefined && !document.mozFullScreen) || (document.webkitIsFullScreen !== undefined && !document.webkitIsFullScreen)) {
           if (elem.requestFullScreen) {
               elem.requestFullScreen();
           } else if (elem.mozRequestFullScreen) {
               elem.mozRequestFullScreen();
           } else if (elem.webkitRequestFullScreen) {
               elem.webkitRequestFullScreen(Element.ALLOW_KEYBOARD_INPUT);
           } else if (elem.msRequestFullscreen) {
               elem.msRequestFullscreen();
           }
       } else {
           if (document.cancelFullScreen) {
               document.cancelFullScreen();
           } else if (document.mozCancelFullScreen) {
               document.mozCancelFullScreen();
           } else if (document.webkitCancelFullScreen) {
               document.webkitCancelFullScreen();
           } else if (document.msExitFullscreen) {
               document.msExitFullscreen();
           }
       }
   }
</script>
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
<script type="text/javascript">
   var qidval ;
   var ret_rev ;
   var n_que=new Array();
   function singleselectcheckbox(checknameval){
   	 
   	$('.'+checknameval).click(function(){
           var val = $(this).is(":checked");
   		if(val==true){
   		$('.'+checknameval).not(this).prop('checked', false);
   		}
       });
    }
   
   
   
   $(document).ready(function(){
   	$("#myModal").modal('show');
   });
   
   
   window.onload = function () {
   	var subjectid=document.getElementById("subjectidforcnt").value;
   
   	 $(".loader").fadeOut("slow");
   	   attemptcount(subjectid);
           startTimer1();
           $('#activeclass ul > li:first-child a').addClass('active');
           
           
   }
   function submit()
   {
       document.getElementById("testbtn").click(); // Simulates button click
       document.submitForm.submit(); // Submits the form without the button
   }
   
   
   
   /* window.onbeforeunload = function fn() {
       return true;
   } */
   function stopFinishTestTime() {
   	
   	
   	var sttime = document.getElementById("time").innerHTML;
       document.getElementById("timeqtaken").value=sttime;
       $( "#springform" ).submit();
   /*    fn(); */
       document.getElementById("finishbutton").disabled=true;
   
   }
   
   
   function optionsById(totalquestions) {
   
   	 var attemtedcount = document.getElementById('atmptcount').innerHTML;
   	 var text="";
   	 if(attemtedcount =="" ){
   		 attemtedcount=0;
   	
   	 } else {
   		 attemtedcount= parseInt(attemtedcount); 
   
   	 } 
   	// alert(attemtedcount);
   	 var remainingQns = totalquestions -attemtedcount;
    	/*  document.getElementById("answeredbtn").innerHTML=attemtedcount;
   	 document.getElementById("notansweredbtn").innerHTML=remainingQns; */
            text+=  "<div class='diff_type_notation_area_outer'><div class='diff_type_notation_area_inner'><div class='notation_type_description'><span class='not_visited notVisitedCount' >"+ totalquestions +"</span><font style='font-size:12px;'>&nbsp; Total Questions </font></div></div></div><br>";
            text+=  "<div class='diff_type_notation_area_outer'><div class='diff_type_notation_area_inner'><div class='notation_type_description'><span class='answered answeredCount'>"+ attemtedcount +"</span><font style='font-size:12px;'>&nbsp;&nbsp;&nbsp;&nbsp;Answered</font></div></div></div> <br>";
            text+=  "<div class='diff_type_notation_area_outer'><div class='diff_type_notation_area_inner'><div class='notation_type_description'><span class='not_answered notAnsweredCount'>"+ remainingQns +"</span><font style='font-size:12px;'>&nbsp;&nbsp;Not Answered</font></div></div></div>"; 
    	 document.getElementById("questions").innerHTML =text ;
   
   }
   
   
   
</script>
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
   
   
   function saveExamStatus_ByQid(selectvalue,qvalue,subjectid,qrowid)
   {
   	
   
   	var selectedanswer=selectvalue;
   	var sid =  document.getElementById('stu').value;
   	var subjecttypeid=subjectid;
   	var examname = document.getElementById('examname').value;
   
   	var qid =qvalue;
   	var display = document.querySelector('#time').innerHTML;
   	var timeid= display;
   	var lct =  document.getElementById('location_id').value;
   	var brc = document.getElementById('branch_id').value;
   	var cls =document.getElementById('class_id').value;
   	var sect =document.getElementById('section_id').value;
   	var urls="load-examStatusqid?selectedanswer="+selectedanswer+"&stu="+sid+"&subj="+subjecttypeid+"&exmname="+examname+"&qbyidval="+qid+"&timeid="+timeid+"&locid="+lct+"&brcid="+brc+"&clsid="+cls+"&seid="+sect+"&qrowid="+qrowid;    
   
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
   //markAsReviewNotAnsweredCount(subjectid,qid,qrowid,"");
           attemptcount(subjecttypeid);
       }
     }
   xmlhttp.open("POST",urls,true);
   xmlhttp.send(); 
   }
   
   //disable right click
   /* document.addEventListener('contextmenu', event => event.preventDefault()); */
</script>
<script type="text/javascript">  
   $(function () {  
       $(document).keydown(function (e) {  
           return (e.which || e.keyCode) != 116;  
       });  
   });  
   
   function multiselectval(multiselectname,qvalue,subjectid,qrowid){
   	
   	var sometes=document.getElementsByName(multiselectname);
   	var checkval= multiselectname;
   	var multiselctvalue="";
   	var i=1;
   	var temp=",";
   	var valuechecked= $("input[name='"+checkval+"']");
   	$(valuechecked).each( function () {
   		
   		 if($(this).prop('checked') == true){
   			 if(i==1){
   			 multiselctvalue=$(this).val();
   			 }
   			 if(i>1){
   				 multiselctvalue+=temp+""+$(this).val();	
   				}
   				i++;
   		}
   	});
   	
   
   	
   	var selectedanswer=multiselctvalue;
   	var sid =  document.getElementById('stu').value;
   	var subjecttypeid=subjectid;
   	var examname = document.getElementById('examname').value;
   
   	var qid =qvalue;
   	var display = document.querySelector('#time').innerHTML;
   	var timeid= display;
   	var lct =  document.getElementById('location_id').value;
   	var brc = document.getElementById('branch_id').value;
   	var cls =document.getElementById('class_id').value;
   	var sect =document.getElementById('section_id').value;
   	var urls="load-examStatusqid?selectedanswer="+selectedanswer+"&stu="+sid+"&subj="+subjecttypeid+"&exmname="+examname+"&qbyidval="+qid+"&timeid="+timeid+"&locid="+lct+"&brcid="+brc+"&clsid="+cls+"&seid="+sect+"&qrowid="+qrowid;    
   
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
     //markAsReviewNotAnsweredCount(subjectid,qvalue,qrowid,"");
           attemptcount(subjecttypeid);
       }
     }
   xmlhttp.open("POST",urls,true);
   xmlhttp.send(); 
   	
   }
   	
   	
   
   
   function matrixselectval(multiselectname,qvalue,subjectid,qrowid){
   
   	var temp="";
   	   
   		  
   		  $("[name='"+multiselectname+"'] option:selected").each( function(){
   			  var myele = '';
   			
   					
   	                myele = $(this).val();
   					
   					if(myele!=0){
   					
   					temp=temp+","+myele;
   					 
   					while(temp.charAt(0) === ',')
   					{
   					 temp = temp.substr(1);
   					
   					}
   					 
   					}
   			  
   		  });
   
   	 
   	var selectedanswer=temp;
   	var sid =  document.getElementById('stu').value;
   	var subjecttypeid=subjectid;
   	var examname = document.getElementById('examname').value;
   
   	var qid =qvalue;
   	var display = document.querySelector('#time').innerHTML;
   	var timeid= display;
   	var lct =  document.getElementById('location_id').value;
   	var brc = document.getElementById('branch_id').value;
   	var cls =document.getElementById('class_id').value;
   	var sect =document.getElementById('section_id').value;
   	var urls="load-examStatusqid?selectedanswer="+selectedanswer+"&stu="+sid+"&subj="+subjecttypeid+"&exmname="+examname+"&qbyidval="+qid+"&timeid="+timeid+"&locid="+lct+"&brcid="+brc+"&clsid="+cls+"&seid="+sect+"&qrowid="+qrowid;    
   
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
     //markAsReviewNotAnsweredCount(subjectid,qvalue,qrowid,"");
           attemptcount(subjecttypeid);
       }
     }
   xmlhttp.open("POST",urls,true);
   xmlhttp.send(); 
   	
   }
   
   
   
   function comprehensionselectval(comprehension,qvalue,subjectid,qrowid){
   	var sometes=document.getElementsByName(comprehension);
   	var checkval= comprehension;
   	var multiselctvalue="";
   	var i=1;
   	var temp=",";
   	var valuechecked= $("input[name='"+checkval+"']");
   	$(valuechecked).each( function () {
   		
   		 if($(this).prop('checked') == true){
   			 if(i==1){
   			 multiselctvalue=$(this).val();
   			 }
   			 if(i>1){
   				 multiselctvalue+=temp+""+$(this).val();	
   				}
   				i++;
   		}
   	});
   	
   
   	
   	var selectedanswer=multiselctvalue;
   	
   	var sid =  document.getElementById('stu').value;
   	var subjecttypeid=subjectid;
   	var examname = document.getElementById('examname').value;
   
   	var qid =qvalue;
   	var display = document.querySelector('#time').innerHTML;
   	var timeid= display;
   	var lct =  document.getElementById('location_id').value;
   	var brc = document.getElementById('branch_id').value;
   	var cls =document.getElementById('class_id').value;
   	var sect =document.getElementById('section_id').value;
   	var urls="load-examStatusqid?selectedanswer="+selectedanswer+"&stu="+sid+"&subj="+subjecttypeid+"&exmname="+examname+"&qbyidval="+qid+"&timeid="+timeid+"&locid="+lct+"&brcid="+brc+"&clsid="+cls+"&seid="+sect+"&qrowid="+qrowid;    
   
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
     //markAsReviewNotAnsweredCount(subjectid,qvalue,qrowid,"");
           attemptcount(subjecttypeid);
       }
     }
   xmlhttp.open("POST",urls,true);
   xmlhttp.send(); 
   	
   }
   
   
   
   /* <script>
   $("#myform").submit(function( event ) {
       $("#mySubmitButton").prop("disabled", true).addClass("disabled");
   }); */
</script>
<script language="JavaScript">
   //////////back button////////////////////////
   
   
   //////////F12 disable code////////////////////////
       document.onkeypress = function (event) {
           event = (event || window.event);
           if (event.keyCode == 123) {
              //alert('No F-12');
               return false;
           }
       }
   
       document.onmousedown = function (event) {
           event = (event || window.event);
           if (event.keyCode == 123) {
               //alert('No F-keys');
               return false;
           }
       }
   document.onkeydown = function (event) {
           event = (event || window.event);
           if (event.keyCode == 123) {
               //alert('No F-keys');
               return false;
           }
       }
   
   
   /////////////////////end///////////////////////
   
   
   //Disable right click script 
   //visit http://www.rainbow.arch.scriptmania.com/scripts/ 
   var message="Sorry, right-click has been disabled"; 
   /////////////////////////////////// 
   function clickIE() {if (document.all) {(message);return false;}} 
   function clickNS(e) {if 
   (document.layers||(document.getElementById&&!document.all)) { 
   if (e.which==2||e.which==3) {(message);return false;}}} 
   if (document.layers) 
   {document.captureEvents(Event.MOUSEDOWN);document.onmousedown=clickNS;} 
   else{document.onmouseup=clickNS;document.oncontextmenu=clickIE;} 
   document.oncontextmenu=new Function("return false") 
   // 
   function disableCtrlKeyCombination(e)
   {
   //list all CTRL + key combinations you want to disable
   var forbiddenKeys = new Array('a', 'n', 'c', 'x', 'v', 'j' , 'w', 'u', 's','p');
   var key;
   var isCtrl;
   if(window.event)
   {
   key = window.event.keyCode;     //IE
   if(window.event.ctrlKey)
   isCtrl = true;
   else
   isCtrl = false;
   }
   else
   {
   key = e.which;     //firefox
   if(e.ctrlKey)
   isCtrl = true;
   else
   isCtrl = false;
   }
   //if ctrl is pressed check if other key is in forbidenKeys array
   if(isCtrl)
   {
   for(i=0; i<forbiddenKeys.length; i++)
   {
   //case-insensitive comparation
    if(forbiddenKeys[i].toLowerCase() == String.fromCharCode(key).toLowerCase())
   {
   /* alert('Key combination CTRL + '+String.fromCharCode(key) +' has been disabled.');
    */return false;
   } 
   }
   }
   
   
   
   
   return true;
   
   
   
   }
   
   
   
</script>
<script type="text/javascript">
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
   
   	 function removeRadiobuttonSelection(radionames, questionid, subjectid, questionrowid, qnumber, colorcode){
   	             
   	                  var radList = document.getElementsByName(radionames);
   	                  var valuechecked= $("input[name='"+radionames+"']");
   	                  var valuetype = valuechecked.attr('type');
   	                  if(valuetype=='text'){
   	                          document.getElementsByName(radionames)[0].value = '';
   	                          }
   	                  for (var i = 0; i < radList.length; i++) {
   	                        if(radList[i].checked) radList[i].checked = false;
   	                      }
   	          
   	                   $("[name='"+radionames+"'] option:selected").each( function(){
   	                           $(this).prop('selected', false);
   	                   });
   	                           
   	                     saveExamStatus_ByQid("",questionid, subjectid, questionrowid);
   	                     markAsReviewAnsweredCount(subjectid,questionid,questionrowid,"");
   	                     markAsReviewNotAnsweredCount(subjectid,questionid,questionrowid, ""); 
   	                    var property = document.getElementById("button_"+qnumber);
   	                  $("#span_"+qnumber).removeClass().addClass('not_answered auditlog');
   	          }
   
   function viewNextTabSubjects(){
   	 $('.nav-tabs > .active').next('li').find('a').trigger('click');
   	 alert( $.inArray(index, $(".nav-tabs > .active").tabs("option", "disabled")));
   }
   
   function totalAttemptedQuestionsCount()
   {
   	var noqns = document.getElementById("noOfqbns").value;
   	//optionsById(noqns);
   	var sid =  document.getElementById('stu').value;
   	
   	var examname = document.getElementById('examname').value;
   	var urls="load-unattemptcount?exmname="+examname+"&studentid="+sid+"";    
   
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
   	  var attempt=xmlhttp.responseText;
   
   	
            document.getElementById("atmptcount").innerHTML=attempt; 
            optionsById(noqns);
   
       }
     }
   xmlhttp.open("POST",urls,true);
   xmlhttp.send(); 
   }
   
   function myfunction(){
   	
   	totalAttemptedQuestionsCount();
   		           $('#basicModal').modal({
   		        show: true
   		    });
   }
   function myPopUpImageMouseOut(){
   
   		           $('#basicModal').modal({
   		        show: false
   		    });
   }
   
   /* $(function() {
       $("#testingdivs").find("span").remove();
       $("#next").remove();
       
       for (var i = 1; i < 10; i++) {
       $("#testingdivs"+i).find("span").remove();
       $("#next"+i).remove();
   	}
       
   }); */
   
   
   
   	function deleteKeyBoardvalye(backspaceid,questionid,subjectid, questionrowid,qnumber){
   		
   		var a=document.getElementById(backspaceid).value;
   		var b=a.substring(0,a.length-1);
   		if(b.length==0){
   			saveExamStatus_ByQid("",questionid, subjectid, questionrowid);
   			  var property = document.getElementById("button_"+qnumber);
   			 /*  property.style.backgroundColor = "#FFFFFF";
   			  property.style.color="#5C99C8";
   			  property.style.borderTopLeftRadius = "0px";
   			  property.style.borderTopRightRadius = "0px";
   			  property.style.borderBottomLeftRadius = "20px";
   			  property.style.borderBottomRightRadius = "20px"; */
   
   			  $("#button_"+qnumber).removeAttr('style');
   			  $("#button_"+qnumber).addClass('selected');
   			  
   			  subjectwisenotanswercount(subjectid);
   			  attemptcount(subjectid);
   		}
   		
   		document.getElementById(backspaceid).value=b;
   
   	}
   	
   	function clearAllValues(backspaceid){
   		document.getElementById(backspaceid).value='';
   
   	}
</script>