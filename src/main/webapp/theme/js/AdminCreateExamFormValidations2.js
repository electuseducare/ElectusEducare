/**
 * 
 */
	var date = new Date();

	 var day = date.getDate();
	 var month = date.getMonth() + 1;
	 var year = date.getFullYear();

	 if (month < 10) month = "0" + month;
	 if (day < 10) day = "0" + day;

	 var today = year + "-" + month + "-" + day;
	
	 
window.onload = function () {
	 var sectionvalues = document.getElementById('sectionvalues').value;
	 var sectionvalues1 = document.getElementById('sectionvalues1').value;
	 document.getElementById("sectionselect").innerHTML="<option value="+sectionvalues+"  >"+sectionvalues1+"</option>";
	 document.getElementById('slotexamstartdate').value = today;
	 document.getElementById('slotexamenddate').value = today;
	  if (document.getElementById('noCheckmarks').checked==true){
		  document.getElementById('marksperqns').style.display = 'none';
		  document.getElementById('negativemarksdivs').style.display = 'none';
	  }
	  document.getElementById('currentsubject').style.display = 'none'; 
	  document.getElementById('currenttopics').style.display = 'none'; 
	  document.getElementById('currentsubtopics').style.display = 'none'; 
}


$(function(){
$('#examname').keyup(function()
{
var yourInput = $(this).val();
re = /[`~!@#$%^&*()|+\=?;:'",.<>\{\}\[\]\\\/]/gi;
var isSplChar = re.test(yourInput);
if(isSplChar)
{
	var no_spl_char = yourInput.replace(/[`~!@#$%^&*()|+\=?;:'",.<>\{\}\[\]\\\/]/gi, '');
	$(this).val(no_spl_char);
}
});

});

function createExamValidations(){



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


var start_actual_time = slotexamstartdate+" "+slotstarttime;
var end_actual_time = slotexamenddate+" "+slotexamendtime;
start_actual_time = new Date(start_actual_time);
end_actual_time = new Date(end_actual_time);

var currentDateTimestamp = start_actual_time.getTime();
var selectedDateTimestamp = end_actual_time.getTime();
if (Math.abs(currentDateTimestamp - selectedDateTimestamp) >= 60 * 60 * 24 * 1000) {
	 alert("Start Date and End Date should not be exceeded 24 hrs.");
	 return false;
 }


if(slotexamstartdate < today){
	var startltmodal =  document.getElementById('startltmodal');
	startltmodal.style.display = "block";
	return false;
}


if(slotexamenddate < slotexamstartdate ){
	var startltendatemodal =  document.getElementById('startltendatemodal');
	startltendatemodal.style.display = "block";
	return false;
}

if ($('#examduration').val().indexOf('-') >= 0) {
	var negativeintestdurationmodal =  document.getElementById('negativeintestdurationmodal');
	negativeintestdurationmodal.style.display = "block";
	return false;
}


var testduration = document.getElementById('examduration').value;
if(testduration=="00:00:00"){
	var zerointestdurationmodal =  document.getElementById('zerointestdurationmodal');
	zerointestdurationmodal.style.display = "block";
	return false;
}
startloader();

}

function startloader() {
	document.getElementById("loaderstart").style.display='block';
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





function fixedmarksischecked() {

    if (document.getElementById('yesCheckmarks').checked) {
    	
        document.getElementById('marksperqns').style.display = 'block';
        document.getElementById('negativemarksdivs').style.display = 'block';
        $("[name='qntypes']").each( function() {
        	 $('input.check21').prop('checked',false);
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
    else {
    	
    document.getElementById('marksperqns').style.display = 'none';
    document.getElementById('negativemarksdivs').style.display = 'none';
    	$("[name='qntypes']").each( function() {
       	 $('input.check21').prop('checked',false);
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



/** Close Exam name modal window */
function closeexamnamemodelwindow() {
	 var modal = document.getElementById('examnamemodel');
    modal.style.display = "none";
}

/** Close Exam name already exist modal window */
function closeexamnameexistmodelwindow(){
	var modal = document.getElementById('examnameexistmodel');
    modal.style.display = "none";
}
/** Close selected Exam name already exist modal window */
function closeselectedexamnameexistmodelwindow(){
	var modal = document.getElementById('selectedexamnameexistmodel');
	modal.style.display = "none";
}

/** Close Exam type modal window */
function closeexamtypemodelwindow() {
	 var modal = document.getElementById('examtypemodel');
    modal.style.display = "none";
}

/** Close state modal window */
function closestatemodelwindow(){
	 var modal = document.getElementById('statemodel');
	    modal.style.display = "none";
}
/** close location modal window */
function closelocationmodelwindow(){
	 var modal = document.getElementById('locationmodel');
	    modal.style.display = "none";
}
/** close branch  modal window */
function closebranchmodelwindow(){
	 var modal = document.getElementById('branchmodel');
	    modal.style.display = "none";
}
/** close Question level  modal window */
function closequestionlevelmodelwindow(){
	 var modal = document.getElementById('questionlevelmodel');
	    modal.style.display = "none";
}
/** close class  modal window */
function closeclassmodelwindow(){
	 var modal = document.getElementById('classmodel');
	    modal.style.display = "none";
}
/** close section  modal window */
function closesectionmodelwindow(){
    var modal = document.getElementById('sectionmodel');
       modal.style.display = "none";
}

//Close subject modal window
function closesubjectmodelwindow() {
	 var modal = document.getElementById('subjectmodel');
    modal.style.display = "none";
}

//Close number of questions per subject modal window
function closenoofqnspersubjmodel() {
	 var modal = document.getElementById('noofqnspersubjmodal');
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
function closemarkstypemodel() {
	 var modal = document.getElementById('noofmarksmodalperqt');
	    modal.style.display = "none";
	}	
//Close no of negative marks type modal window
function closenegmarkstypemodel() {
         var modal = document.getElementById('negmarksmodalperqt');
            modal.style.display = "none";
        }
//Close no of qns are not matched modal window
function closeqnsandqtypeqnsnotmatchedmodel() {
	 var modal = document.getElementById('qnsandqtypeqnsnotmatchedmodal');
	    modal.style.display = "none";
	}	


//Close number of marks text box if is marks yes
function closemarksperqnmodel(){
	var modal = document.getElementById('marksperqnmodal');
    modal.style.display = "none";
} 

//Close start slot date modal window
function closesdatemodel() {
	 var modal = document.getElementById('startslotdatemodal');
	    modal.style.display = "none";
	}
//Close start slot time modal window
  function closestimemodel() {
  	 var modal = document.getElementById('startslottimemodal');
  	    modal.style.display = "none";
  	}
//Close end slot date modal window
function closedatemodel() {
	 var modal = document.getElementById('endslotdatemodal');
	    modal.style.display = "none";
	}
//Close end slot time modal window
function closeetimemodel() {
	 var modal = document.getElementById('endslottimemodal');
	    modal.style.display = "none";
	}


//Close end date < start date modal window
function closestartltmodel() {
	 var modal = document.getElementById('startltmodal');
	    modal.style.display = "none";
	}

//Close end date < start date modal window
function closestartltendatemodel() {
	 var modal = document.getElementById('startltendatemodal');
	    modal.style.display = "none";
	}

//Close -ve time modal window
function closenegativeintestdurationmodel() {
	 var modal = document.getElementById('negativeintestdurationmodal');
	    modal.style.display = "none";
	}

//Close zero time modal window
function zerointestdurationmodel() {
	 var modal = document.getElementById('zerointestdurationmodal');
	    modal.style.display = "none";
	}

function uncheckquestiontypes_subjectunchecked(subjectid){
	
	if(document.getElementById(subjectid).checked==false){
		
	}
	
}

