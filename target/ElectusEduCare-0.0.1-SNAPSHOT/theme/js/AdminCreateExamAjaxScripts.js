/**
 * 
 */

/**
 * Exam Name Exist are not 
 */
var examnameexists = null;
function validExamnameexists(examname){
	var examnamevalue = document.getElementById('examname').value;
	var isValid = false;
    var regex = /^[\s,a-z,A-Z,0-9-_()]*$/;
    isValid = regex.test($("#examname").val());
	
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

/**
 * Get Sections From Class
 */


function getsectionsFromClass(classid){
var classid = document.getElementById(classid).value;
	var urls="get-sectiondetailsfromClass?classid="+classid;
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
    	document.getElementById("sectionselect").innerHTML=xmlhttp.responseText;
    	 
      }
   
    }
  xmlhttp.open("POST",urls,true);
  xmlhttp.send();
	
	
}


/**
 * Get Subjects From Class
 */



var getsubjectsFromClasses = function(classid){
	$( "div" ).remove( "#previoussubj" );
	$( "div" ).remove( "#previoussubjlabel" );
	$( "div" ).remove( "#topicsdiv1" );
	$( "#topicsdiv" ).hide();
	$( "div" ).remove( "#prevtopicsdiv1" );
	$( "#subtopicsdiv" ).hide();
	$( "div" ).remove( "#subtopicsdiv1" );
	$( "div" ).remove( "#prevsubtopicsdiv1" );
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
                        	
                        	document.getElementById("subjecttypediv").innerHTML+='<input type="checkbox" name="subjectname" id="'+value1+'" value="'+value1+'" onclick="populateinputBoxes(this.id);getsetTopicstypeAjax(this.id); uncheckquestiontypes_subjectunchecked(this.id);"/>'+""+content;
                        	  qnscontent+='<input type="text" class="form-control" name="noofqns_'+value1+'" id="noofqns_'+value1+'" placeholder="No.of ? in'+value1+'" style="display:none;" style="width:200px;" onkeypress="return event.charCode >= 48 && event.charCode <= 57" maxlength="3" minlength="1"/>';
                        	  incre++;
                        	}
            			});
            	});
            	
            //	document.getElementById("subjecttypediv").innerHTML=content;
            	document.getElementById("noofquestions").innerHTML=qnscontent;
           
            }
    });
}

   /***** get subjects based on class id *******/
var getsubjectsFromClasses1 = function(classid){
	$( "div" ).remove( "#previoussubj" );
	$( "div" ).remove( "#previoussubjlabel" );
	$( "div" ).remove( "#topicsdiv1" );
	$( "#topicsdiv" ).hide();
	$( "div" ).remove( "#prevtopicsdiv1" );
	$( "#subtopicsdiv" ).hide();
	$( "div" ).remove( "#subtopicsdiv1" );
	$( "div" ).remove( "#prevsubtopicsdiv1" );
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
                var topiccontent = "";
                var incre=0;
                document.getElementById("subjecttypediv").innerHTML="";
                document.getElementById("topicsdiv3").innerHTML="";
                document.getElementById("subtopicsdiv4").innerHTML="";
                
            	$.each(data,function(i,val){
            		
            		$.each(val,function(key,value1){
            			
                        if(key=="subject"){
                		content=value1;
                		subjectnmames = value1;
                        }
                        else if(key=="subjectid")
                        	{
                        	
                        	var subjvalue = value1.trim();
                        	document.getElementById("subjecttypediv").innerHTML+='<input type="checkbox" name="subjectname" id="'+value1+'" value="'+value1+'" onclick="populateinputBoxes(this.id);getsetTopicstypeAjax1(this.id); uncheckquestiontypes_subjectunchecked(this.id);"/>'+""+content;
                        	  qnscontent+='<input type="text" class="form-control" name="noofqns_'+value1+'" id="noofqns_'+value1+'" placeholder="No.of ? in '+subjectnmames+'" style="display:none;" style="width:200px;" onkeypress="return event.charCode >= 48 && event.charCode <= 57" maxlength="3" minlength="1"/>';
                        	  document.getElementById("topicsdiv3").innerHTML+=''+content+'<select name="topic_'+subjvalue+'" id="topic_'+subjvalue+'"class="form-control" multiple="true" onchange="selectTopicpersubject1('+subjvalue+');"><option>--Please Select--</option> </select>' ;
                        	  document.getElementById("subtopicsdiv4").innerHTML+=''+content+'<select name="subtopic_'+subjvalue+'" id="subtopic_'+subjvalue+'" class="form-control" multiple="true"><option>--Please Select--</option> </select>' ;
                        	  incre++;
                        	}
            			});
            	});
            	$( "#topicsdiv" ).show();
            //	document.getElementById("subjecttypediv").innerHTML=content;
            	document.getElementById("noofquestions").innerHTML=qnscontent;
           
            }
    });
}


function populateinputBoxes(subjids){

	if(document.getElementById(subjids).checked == true){
    /*	$( '#topic_'+subjids ).show();
		$( '#subtopic_'+subjids ).show();
		  $( "#topicsdiv1" ).hide();
		  $( "#prevtopicsdiv1" ).hide();
		  $( "#subtopicsdiv1" ).hide();
		  $( "#prevsubtopicsdiv1" ).hide();*/
		$("#noofqns_"+subjids).each(function() {
		    var ClassVal = $(this).val();
		    $('#noofqns_'+subjids).show();
		    
		    $('input.check21').prop('checked',this.checked);
		    //$("#testtest").remove();
		   
		   var elements = document.getElementsByClassName("qntypeqnsclass");

		    for (var i = 0; i < elements.length; i++){
		        elements[i].style.display = 'none';
		    }
		    var elements1 = document.getElementsByClassName("qntypemarksclass");

		    for (var i = 0; i < elements1.length; i++){
		        elements1[i].style.display = 'none';
		    }
		    
        });
		
	}
	
	if(document.getElementById(subjids).checked == false){
		var ql=0;
	/*	$( '#topic_'+subjids ).hide();
		$( '#subtopic_'+subjids ).hide();
		 $( "#topicsdiv1" ).hide();
		  $( "#prevtopicsdiv1" ).hide();
		  $( "#subtopicsdiv1" ).hide();
		  $( "#prevsubtopicsdiv1" ).hide();*/
		$("#noofqns_"+subjids).each(function() {
		    var ClassVal = $(this).val();
		    $('#noofqns_'+subjids).hide();
		    $('input.check21').prop('checked',this.checked);
		    $('input.subtopicclass').prop('checked',this.checked);
		   
		 
		   var elements = document.getElementsByClassName("qntypeqnsclass");

		    for (var i = 0; i < elements.length; i++){
		        elements[i].style.display = 'none';
		    }
		    var elements1 = document.getElementsByClassName("qntypemarksclass");

		    for (var i = 0; i < elements1.length; i++){
		        elements1[i].style.display = 'none';
		    }
        });
		
	}
	

	
}


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
                document.getElementById("topicsdiv").innerHTML="";
            	$.each(data,function(i,val){
            		$.each(val,function(key,value1){
            			
                        if(key=="topic"){
                		content=value1;
                        }
                        else if(key=="topicid")
                        	{
                        	$( "#topicsdiv" ).show();
                        	document.getElementById("topicsdiv").innerHTML+='<input type="checkbox"  name="topic" id="'+value1+'" value="'+value1+'" onclick="selectTopicpersubject(this.id);"/>'+""+content;
                        	 
                        	  incre++;
                        	}
            			});
            	});
            	
            	//document.getElementById("topicsdiv").innerHTML=content;
            	
           
            }
    });
}

/**** Get topics in drop down based on subject id and exam type id *****/
var getsetTopicstypeAjax1 = function(subjectid){
	
	var examtypeid=document.getElementById("examtypeselectbox").value;
	
    $.ajax({
            url : "load-GetTopicsforSubjects?subjectid="+subjectid+"&examtypeid="+examtypeid,
            
            type: "GET",
            dataType: "json",
           
            success : 
            
            function(data) {
            	//alert(data);
                var content="";
                var qnscontent="";
                var incre=0;
                document.getElementById("topicsdiv").innerHTML="";
                qnscontent+='<option value="All Topics" >-- All Topics --</option>';
            	$.each(data,function(i,val){
            		$.each(val,function(key,value1){
            			
                        if(key=="topic"){
                		content=value1;
                        }
                        else if(key=="topicid")
                        	{
                        	$( "#topicsdiv" ).show();
                        	qnscontent+='<option value="'+value1+'" >'+content+'</option>';
                        	  incre++;
                        	}
            			});
            	});
            	

            	document.getElementById("topic_"+subjectid).innerHTML=qnscontent;
            	if(document.getElementById(subjectid).checked == false){
            		
            		qnscontent='<option value="Please Select" >-- Please Select --</option>';
            		document.getElementById("topic_"+subjectid).innerHTML=qnscontent;
            		selectTopicpersubject1(subjectid);
            	}
            	
            	
           
            }
    });
}



var selectTopicpersubject = function(topicid){
	var topicidvalue="";
	var i=1;
	var temp=",";
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
            document.getElementById("subtopicsdiv").innerHTML="";
        	$.each(data,function(i,val){
        		$.each(val,function(key,value1){
        			
                    if(key=="subtopic")
            		content=value1;
                    else if(key=="subtopicid")
                    	{
                    	$( "#subtopicsdiv" ).show();
                    	document.getElementById("subtopicsdiv").innerHTML+='<input type="checkbox" class="subtopicclass"  name="subtopic" id="'+value1+'" value="'+value1+'"/>'+""+content;
                    	 
                    	  incre++;
                    	}
        			});
        	});
        	
        	//document.getElementById("subtopicsdiv").innerHTML=content;
        	
       
        }
});
}

/**** Get sub-topics in drop down based on topic ids, subject id and exam type id *****/

var selectTopicpersubject1 = function(subjid){
	
	var examtypeid=document.getElementById("examtypeselectbox").value;
	var topicids = $('#topic_'+subjid).val();

	$.ajax({
        url : "load-getSubtopicsinSubjects?topicid="+topicids+"&examtypeid="+examtypeid+"&subjid="+subjid,
        type: "GET",
        dataType: "json",
       
        success : 
        function(data) {
        	
            var content="";
            var qnscontent="";
            var incre=0;
            document.getElementById("subtopicsdiv").innerHTML="";
            qnscontent+='<option value="All STopics" >-- All Sub Topics --</option>';
        	$.each(data,function(i,val){
        		$.each(val,function(key,value1){
        			
                    if(key=="subtopic")
            		content=value1;
                    else if(key=="subtopicid")
                    	{
                    	$( "#subtopicsdiv" ).show();
                    	qnscontent+='<option value="'+value1+'">'+content+'</option>';
                    	  incre++;
                    	}
        			});
        	});
        	
        	document.getElementById("subtopic_"+subjid).innerHTML=qnscontent;
        	if(topicids==null){
        		qnscontent='<option value="Please Select">-- Please Select --</option>';
        		document.getElementById("subtopic_"+subjid).innerHTML=qnscontent;
        	}
       
        }
});
}



function qusperqustype(qustypeid,qtid,qmarksclass, qtypename,negativmarksdiv){
	var mrksperqntype = "";
	var subjectcnt = 0;
	var subjectids = "";
	var content="";
    var qnscontent="";
    var netativecontent="";
    var qtypename1 = qtypename;
    $("[name='subjectname']").each( function() {
    	subjectids=$('input[name="subjectname"]')[subjectcnt].id;
    	if (document.getElementById(subjectids).checked){
    		if( document.getElementById(qtid).checked==true){
    			//alert(qtid);
    	         qnscontent+='<table><tr><td><input type="text" name="'+subjectids+"_"+qustypeid+'" class="qntypeqnsclass" id="nofoqus" placeholder="No.of que per Ques type in '+subjectids+'" style="width:300px;"  onkeypress="return event.charCode >= 48 && event.charCode <= 57" maxlength="3" minlength="1" onkeyup="dataBaseValidations(this.value,'+subjectids+','+qustypeid+');"/></table></td></tr>';
    	         if (document.getElementById('yesCheckmarks').checked==false){ 
        	         mrksperqntype+='<table><tr><td><input type="text" name="'+subjectids+"_marks_"+qustypeid+'" class="qntypemarksclass" id="nofoqusmarks" placeholder=" Marks assigned per '+subjectids+' per '+qtypename+'" style="width:300px;" onkeypress="return event.charCode >= 48 && event.charCode <= 57" maxlength="1" minlength="1"/></table></td></tr>';
        	         netativecontent+='<table><tr><td><input type="text" name="'+subjectids+"_negmarks_"+qustypeid+'" class="qntypemarksclass" id="nofoqusnegmarks" placeholder=" Negative Marks per '+subjectids+' per '+qtypename+'" style="width:300px;" onkeypress="return validateFloatKeyPress(this,event);" maxlength="4" minlength="1" /></table></td></tr>';
    	         }
        	         if (document.getElementById('yesCheckmarks').checked==true){ 
            	         mrksperqntype+='';
            	         netativecontent+='';
            	         }   
    		
    		}if( document.getElementById(qtid).checked==false){
    	         qnscontent+='';
    	         mrksperqntype+="";
    	         netativecontent+='';
    	        }
    	}
    	
    	subjectcnt ++;
    });
    
    
    document.getElementById(qustypeid).innerHTML=qnscontent;
    document.getElementById(qmarksclass).innerHTML=mrksperqntype;
    document.getElementById(negativmarksdiv).innerHTML=netativecontent;
    
}
