<script>
   var count = 1;
   function setColorforTextbox(qnoval,textval) {    
       var property = document.getElementById("button_"+qnoval);
   if(textval.length >0){
       if (count == 0) {
       	  property.style.backgroundColor = "#febf01";
       		  property.style.color = "#010101";
           count = 1;        
       }
       else {
           property.style.backgroundColor = "#febf01";
           property.style.color = "#010101";
           count = 0;
       }
       }
   else{
    property.style.backgroundColor = "#C82C09";
             count = 0;
   }
   }
</script>
<script>
   var count = 1;
   function setColor(qnoval) {
   
    
       var property = document.getElementById("button_"+qnoval);
   
       if (count == 0) {
       	  property.style.backgroundColor = "#00FF00";
       	  property.style.color = "#010101";
       	 
           count = 1;        
       }
       else {
           property.style.backgroundColor = "#00FF00";
           property.style.color = "#010101";
           
           count = 0;
       }
   }
</script>
<script type="text/javascript">  
   $(function () {  
       $(document).keydown(function (e) {  
           return (e.which || e.keyCode) != 116;  
       });  
   });  
   
   function singleselectcheckbox(checknameval){
   
   	$('.'+checknameval).click(function(){
           var val = $(this).is(":checked");
   		if(val==true){
   		$('.'+checknameval).not(this).prop('checked', false);
   		}
       });
    }
   
   
   function attemptcount() {
   	var noqns = document.getElementById("noOfqbns").value;
   	var sid =  document.getElementById('stu').value;
   	var examname = document.getElementById('examname').value;
   	  $.ajax({
           url : "load-unattemptcount?exmname="+examname+"&studentid="+sid+"",
           type: "GET",
           dataType: "json",
           success : 
           function(data) {
         	 
           	 var attempt=data;
   
           		
                document.getElementById("atmptcount").innerHTML=attempt; 
                optionsById(noqns);
           }
      });	
   	
   }
   
   
   
   function insertBookmarkID(bookmark, item_autoinc,subjectid)
   {
   	event.preventDefault();
   var xmlhttp;
   var qid=bookmark;
   var autoincr = item_autoinc;
   
   var subjectid=subjectid;
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
   
   function markasreview(qnoval) {  
   	
       var property = document.getElementById("button_"+qnoval);
   		
       if (count == 0) {
       	  property.style.backgroundColor = "#febf01";
       	  property.style.color="#010101";
       	 
           count = 1;        
       }
       else {
           property.style.backgroundColor = "#febf01";
           property.style.color="#010101";
           count = 0;
       }
      
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
           attemptcount();
       }
     }
   xmlhttp.open("POST",urls,true);
   xmlhttp.send(); 
   	
   }
   
   
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
   
   function loadEndTimeDatafromserver()
   {
   	var sid =  document.getElementById('stu').value;
   	var examname = document.getElementById('examname').value;
       var urls="load-serverendtimeSlot?examname="+examname+"&sid="+sid;
   
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
   	  
           document.getElementById("different").value=xmlhttp.responseText;
          
       }
    
     }
   xmlhttp.open("POST",urls,true);
   xmlhttp.send();
   }
   
   function startTimer1(){
   	var studentids = document.getElementById('stu').value;
   	//Update the count down every 1 second
   	var x = setInterval(function() {
   		getsessionstid();
   		if(document.getElementById("responsestuid").innerHTML==""){
   			window.location.href="logoutexam?studentid="+studentids;
   			
   		}
   		
   		loadEndTimeDatafromserver();
   		var different = document.getElementById("different").value;
   	 // Find the distance between now an the count down date
   	 var distance =  different;
   	 // Time calculations for days, hours, minutes and seconds
   	 var days = Math.floor(distance / (1000 * 60 * 60 * 24));
   	 var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
   	 var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
   	 var seconds = Math.floor((distance % (1000 * 60)) / 1000);
   	 var hourslength = hours.toString().length;
   	 if(hourslength==1){
   	 	hours="0"+hours;
   	 }
   	 var minuteslength = minutes.toString().length;
   	 if(minuteslength==1){
   	 	minutes="0"+minutes;
   	 }
   	 var secondslength = seconds.toString().length;
   	 if(secondslength==1){
   	 	seconds="0"+seconds;
   	 }
   	 
   	 // Output the result in an element with id="demo"
   	 document.getElementById("time").innerHTML =hours + ":"
   	 + minutes + ":" + seconds + "";
   	 
   	 // If the count down is over, write some text 
   	 if (distance < 0) {
   	     clearInterval(x);
   		 stopFinishTestTime();
   	     document.getElementById("time").innerHTML = "EXPIRED";
   	 }
   	}, 1000);
   	}
   
    
   function getsessionstid() {
   	
   	var sttid="";
   	    $.ajax({
   	        url : "load-getsessionstudentid",
   	        type: "GET",
   	        dataType: "text",
   	        success : 
   	        function(data) {
   	        	document.getElementById("responsestuid").innerHTML=data;
   	                      }
   	   });
   	  
   	   
   	}
   
   
   
   
   function stopSuspendTime() {
   	
       var sttime = document.getElementById("time").innerHTML;
       document.getElementById("timeqtaken").value=sttime;
       
   	
   }
   /* window.onbeforeunload = function fn() {
       return true;
   } */
   function stopFinishTestTime() {
   	
   	var sttime = document.getElementById("time").innerHTML;
       document.getElementById("timeqtaken").value=sttime;
       $("#springform").submit();
     /*   fn(); */
       document.getElementById("yessubmit").disabled=true;
       document.getElementById("loader1").style.display="block";
   }
   
   
   
   
</script>
<script>
   function optionsById(totalQns) {
   	
   	//var prevacnt = document.getElementById('prevansweredCnt').value;
   	var attemtedcount = document.getElementById('atmptcount').innerHTML;
   	
   	//alert("test: "+attemtedcount);
   	
   	 var attemptedqns1 = parseInt(attemtedcount);
   	
   	 var attemptedqns2 = attemptedqns1;
   	 
   	 var remainingQns = totalQns - attemptedqns2;
   		
   	 var text =  "<font color='red'> Question Status:</font>  Total ?: "+ totalQns +" || ? Anwsered:  "+ attemptedqns2  + " || Remaining ?: "+remainingQns+"";
   	 document.getElementById("questions").innerHTML = text;
   	 document.getElementById("no_attempt").innerHTML =attemtedcount ;
    	 document.getElementById("no_unattempt").innerHTML =remainingQns ;
   }
   
   //Function To Display Popup
   function finish_div_show() {
   	
   
   //document.getElementById('finishabc').style.display = "block";
   var timeleft = document.getElementById("time").innerHTML; 
   var UNANSWERCOUNT = document.getElementById("no_unattempt").innerHTML; 
   var totalqnscnt = document.getElementById("noOfqbns").value; 
   var ANSWERCOUNT = document.getElementById("no_attempt").innerHTML; 
   
   
   	var unmsg="Your total number of questions: <b>"+totalqnscnt+ "</b>  You have left  <span><b>"+timeleft+"</b></span> to answer <span> <b>"+UNANSWERCOUNT+" </b></span>    Answered count is: <span> <b>"+ ANSWERCOUNT  +" </b></span> <br><br> Still do you want to proceed with your submit?<br><br><br>";
   	var unmsg1='Do you want to proceed with your submit? <br>';
   	var totmsg = unmsg1 +""+unmsg;
   	//document.getElementById("popupmsg").innnerHTML=totmsg;
   
   	alertbox(2,totmsg);
   
   
   }
   
   function alertbox(type,msg)
   {		
   		var content='<div class="content_container_confi_wrapper"><div class="outerbox">'+
                   '<div class="innerbox">'+
                   '<div class="innerbox_container_confi_login">'+
                   '<div class="pager_header_common">Confirmation</div>'+
                   '<div class="content_container_confi_login">'+
                   '<div id="confo_div">'+msg+
                   '</div>'+
                   '</div>'+
                   '<div class="button_container_common">'+
                   '<br><br><input name="button" type="button" id="yessubmit"  class="green_button" onclick="alertbox_callback(this)" value="YES"/>'+
                   '<input name="button" type="button" class="green_button" onclick="alertbox_callback(this)" value="NO"/>'+
                   '</div>'+
                   '</div>'+
                   '</div>'+
                   '</div></div>';
   	TINY.box.show(content,0,0,0,0,0);
   }
   var alertbox_callback=function(obj){				
   	if(obj.id == 'yessubmit'){
   		 TINY.box.hide();
   		 stopFinishTestTime();
   		 return true;
   	}else{		
   		TINY.box.hide();
   		return false;
   	}	
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
   
           attemptcount();
       }
     }
   xmlhttp.open("POST",urls,true);
   xmlhttp.send(); 
   }
   
   
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
           attemptcount();
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
           attemptcount();
       }
     }
   xmlhttp.open("POST",urls,true);
   xmlhttp.send(); 
   	
   }
   
   function selectcolor(){
   	var tot=document.getElementById("noOfqbns").value;
   	for(var i=1;i<=tot;i++){
   		
          var selectedval=document.getElementById("selectval_"+i).value;
     
      			
             var property = document.getElementById("button_"+selectedval);
                    
             	  property.style.backgroundColor = "#00FF00";
             	 property.style.color = "#000000";
             	  
   	}
             	 
   	}
   	
   window.onload = function () {
   	getsessionstid();
   	 $(".loader").fadeOut("slow");
   	attemptcount();
   	document.getElementById("suspendexams").value="manualsubmit";
   	
   	startTimer1();
       selectcolor();
   }
   
   
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
   var forbiddenKeys = new Array('a', 'n', 'c', 'x', 'v', 'j' , 'w', 'u', 's');
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
   alert('Key combination CTRL + '+String.fromCharCode(key) +' has been disabled.');
   return false;
   }
   }
   }
   return true;
   }
</script>