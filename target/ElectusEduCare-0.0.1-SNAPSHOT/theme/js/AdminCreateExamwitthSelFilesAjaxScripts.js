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
                        document.getElementById("subjecttypediv").innerHTML+='<input type="checkbox" name="subjectname" id="'+value1+'" value="'+value1+'" onclick="populateinputBoxes(this.id); uncheckquestiontypes_subjectunchecked(this.id);" />'+""+content;
                      	qnscontent+='<input type="text" class="form-control" name="impfiles1_'+value1+'" id="impfiles1_'+value1+'" placeholder="File Name for '+subjectnmames+'" style="display:none;" style="width:200px;" />';
                      	qnscontent1+='<input type="text" class="form-control" name="impfiles2_'+value1+'" id="impfiles2_'+value1+'" placeholder="File Name for '+subjectnmames+'" style="display:none;" style="width:200px;" />';
                      	    incre++;
                        	}
            			});
            	});

            	 //	document.getElementById("subjecttypediv").innerHTML=content;
            	document.getElementById("noofquestions").innerHTML=qnscontent;
            	document.getElementById("noofquestions1").innerHTML=qnscontent1;
           
           
            }
    });
}

/**
 * Get Subjects From Class
 */


  
function populateinputBoxes(subjids){

	if(document.getElementById(subjids).checked == true){
    
		$("#impfiles1_"+subjids).each(function() {
		    var ClassVal = $(this).val();
		    $('#impfiles1_'+subjids).show();
		    $('#impfiles2_'+subjids).show();
		  /*  var elements = document.getElementsByClassName("qntypeqnsclass");

		    for (var i = 0; i < elements.length; i++){
		        elements[i].style.display = 'none';
		    }
		    var elements1 = document.getElementsByClassName("qntypemarksclass");

		    for (var i = 0; i < elements1.length; i++){
		        elements1[i].style.display = 'none';
		    }*/
        });
		
	}
	
	if(document.getElementById(subjids).checked == false){
		var ql=0;
	
		$("#impfiles1_"+subjids).each(function() {
		    var ClassVal = $(this).val();
		    $('#impfiles1_'+subjids).hide();
		    $('#impfiles1_'+subjids).val("");
		    $('#impfiles2_'+subjids).hide();
		    $("#positivemarks").val("");
		    /*$("#dataTables-example_wrapper").hide();*/
		    $('#impfiles2_'+subjids).val("");
		    
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
