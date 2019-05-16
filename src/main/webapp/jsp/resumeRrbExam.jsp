<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<!-- Template by quackit.com -->
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
      <title>Electus Resume Exam</title>
      <%@include file="DisplayLogo.jsp"%>
      <%@include file="QuestionpageRRBCss.jsp"%>
      <jsp:include page="QuestionpageScripts.jsp"/>
      <jsp:include page="QuestionpageRRBJs.jsp"/>
      <jsp:include page="ResumeExamRRBJsScripts.jsp"/>
      <jsp:include page="resumeextendscripts.jsp"/>
      <jsp:include page="gateCss.jsp"></jsp:include>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/theme/css/calculator/calclayout.css"  />	 
	<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/theme/calculator/jquery-1.8.0.min.js"></script> --%>
	<script type="text/javascript" src="${pageContext.request.contextPath}/theme/css/calculator/oscZenoedited.js" ></script>           
	<script type="text/javascript" src="${pageContext.request.contextPath}/theme/css/calculator/jquery-ui.min.js"></script>
 	
      <script>
         window.onload = function () {
         	var subjectid=document.getElementById("subjectidforcnt").value;
         	 $(".loader").fadeOut("slow");
         	attemptcount(subjectid);
         	startTimer1();
             selectcolor();
         }
         
      </script>
      <style type="text/css">
         /* The Close Button */
         .close3 {
         color: #aaaaaa;
         text-align:center; 
         font-size: 14px;
         font-weight: bold;
         vertical-align: top;
         }
         .close3:hover,
         .close3:focus {
         color: #000;
         text-decoration: none;
         cursor: pointer;
         }
         
          div.ex3 {

  width: 250px;
  height: 110px;
  overflow: auto;
}
         
      </style>
      <script type="text/javascript">
         function submit()
         {
             document.getElementById("testbtn").click(); // Simulates button click
             document.submitForm.submit(); // Submits the form without the button
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
         
         
      </script>
   </head>
   <body>
      <div class="loader"></div>
      <div id="responsestuid" style="display: none"></div>
      <div id="atmptcount" style="display: none;"></div>
      <header id="header">
         <%
            Calendar now = Calendar.getInstance();
            int curyear = now.get(Calendar.YEAR);
            pageContext.setAttribute("curyear", curyear);
            %>
         <c:set var="curyear" value="${curyear}"></c:set>
         <img src="${pageContext.request.contextPath}/theme/images/weblogo.jpg"
            height="50px" width="50px" alt="logo"
            onmouseout="myPopUpImageMouseOut()" /> <span
            style="color: white; font-size: 28px; font-weight: bold">${examname}
         ${curyear} </span>
      </header>
      <header id="instuctionsbtn">
         <span class="instructionheader"> <span
            class="fa fa-check-circle-o" style="font-size: 20px; color: #4FD485"></span><a
            class="" onclick="return getAllQuestionDetails();">Question Paper</a>
         <span class="fa fa-info-circle"
            style="font-size: 20px; color: #5BB1FA"> </span><a class=""
            onclick="return getInstructionDetails();">Instructions</a> <span
            class="fa fa-question-circle" style="font-size: 20px; color: red"></span><a
            class="" onclick="showHelpContent(event);">Useful Data</a>
         </span>
      </header>
      <header id="examheader">
         <div class="innertube">
            <span><i class="fa fa-caret-left"
               style="font-size: 15px; color: #BDC6CF">&nbsp;&nbsp;&nbsp;</i></span> <span
               class="btn btn-info "> ${examname} <span
               class="fa fa-info-circle" onmouseover="myfunction()"></span>
            </span> <span style="text-align: right; float: right;"> <i
               class="fa fa-caret-right" style="font-size: 15px; color: #BDC6CF">&nbsp;&nbsp;&nbsp;</i>
               <img src="${pageContext.request.contextPath}/theme/images/calculator2.png" height="30px;" width="30px;" style="cursor: pointer;" onclick="openCalculator();"/>
            </span>
         </div>
      </header>
      <main>
      <div id="keyPad" class="ui-widget-content calc_container" style="display: none;position: absolute;
        right: 50px;
        top: 0;
        width: 463px;
        z-index: 99">
    <!-- new Help changes -->
    <div id="helptopDiv">
	<span><b>Scientific Calculator</b></span>
	<div href="#nogo" id="keyPad_Help"  onclick="openHelpCalcContent();" style="color: white;"><b>Help</b></div>
	<div style="display:none;" href="#nogo" id="keyPad_Helpback" class="help_back" onclick="closeKeyPadHelpBack()"></div>
	</div>
     <!-- new Help changes -->
     <div class="calc_min" id="calc_min" onclick="minimizeCalculator();" style="display: none;"></div>
     <div class="calc_max hide" id="calc_max" onclick="maximizeCalculator();"></div>
	 <div class="calc_close" id="closeButton" onclick="closeCalculator();">X</div>
	 <!-- main content start here-->
	 <div id="mainContentArea">
		<input type="text" id="keyPad_UserInput1" class="keyPad_TextBox1" readonly />
		 <div class="text_container">
			<input type="text" id="keyPad_UserInput" class="keyPad_TextBox" maxlength="30" readonly />
			<span id="memory" class="memoryhide"><font size="2">M</span> 
		</div>
		<div class="clear"></div>
		<div class="left_sec">
			<div class="calc_row clear">
				<a href="#nogo" id="keyPad_btnMod" class="keyPad_btnBinaryOp" >mod</a>
				<div class="degree_radian">
					<input type="radio" name="degree_or_radian" value="deg" checked="checked">Deg</input>
					<input type="radio" name="degree_or_radian" value="rad">Rad</input>
				</div>
				<a href="#nogo" id="keyPad_btnPi" class="keyPad_btnConst" style="visibility:hidden;">&#960;</a>
				<a href="#nogo" id="keyPad_btnE" class="keyPad_btnConst" style="visibility:hidden;">e</a>
				<a href="#nogo" id="keyPad_btnE" class="keyPad_btnConst" style="visibility:hidden;">e</a>
				<a href="#nogo" id="keyPad_MC" class="keyPad_btnMemoryOp">MC</a>
				<a href="#nogo" id="keyPad_MR" class="keyPad_btnMemoryOp">MR</a>
				<a href="#nogo" id="keyPad_MS"	class="keyPad_btnMemoryOp">MS</a>
				<a href="#nogo" id="keyPad_M+"	class="keyPad_btnMemoryOp">M+</a>
				<a href="#nogo" id="keyPad_M-" class="keyPad_btnMemoryOp">M-</a>
                
			</div>
			<div class="calc_row clear">
			    <a href="#nogo" id="keyPad_btnSinH" class="keyPad_btnUnaryOp min">sinh</a>
				<a href="#nogo" id="keyPad_btnCosinH" class="keyPad_btnUnaryOp min">cosh</a>
				<a href="#nogo" id="keyPad_btnTgH" class="keyPad_btnUnaryOp min">tanh</a>
				<a href="#nogo" id="keyPad_EXP" class="keyPad_btnBinaryOp">Exp</a>
				<a href="#nogo" id="keyPad_btnOpen" class="keyPad_btnBinaryOp ">(</a>
				<a href="#nogo" id="keyPad_btnClose" class="keyPad_btnBinaryOp ">)</a>
				<a href="#nogo" id="keyPad_btnBack" class="keyPad_btnCommand calc_arrows">
					<div style="position: relative; top: -3px">&#8592;</div>
				</a>
				<a href="#nogo" id="keyPad_btnAllClr" class="keyPad_btnCommand">C</a>
				<a href="#nogo" id="keyPad_btnInverseSign" class="keyPad_btnUnaryOp">+/-</a>
				<a href="#nogo" id="keyPad_btnSquareRoot" class="keyPad_btnUnaryOp">
					<div style="position: relative; top: 1px">&#8730;</div>
				</a>
			</div>
			<div class="calc_row clear" style="margin-top: 5px;">
			<a href="#nogo" id="keyPad_btnAsinH" class="keyPad_btnUnaryOp min "><span class='baseele'>sinh</span><span class='superscript'>-1</span></a>
				<a href="#nogo" id="keyPad_btnAcosH" class="keyPad_btnUnaryOp min "><span class='baseele'>cosh</span><span class='superscript'>-1</span></a>
				<a href="#nogo" id="keyPad_btnAtanH" class="keyPad_btnUnaryOp min "><span class='baseele'>tanh</span><span class='superscript'>-1</span></a>
				<a href="#nogo" id="keyPad_btnLogBase2"	class="keyPad_btnUnaryOp"><span class='baseele'>log</span><span	class='subscript'>2</span><span class='baseele'>x</span></a>
				<a href="#nogo" id="keyPad_btnLn" class="keyPad_btnUnaryOp">ln</a>
				<a href="#nogo" id="keyPad_btnLg" class="keyPad_btnUnaryOp">log</a>			
				<a href="#nogo" id="keyPad_btn7" class="keyPad_btnNumeric">7</a>
				<a href="#nogo" id="keyPad_btn8" class="keyPad_btnNumeric">8</a>
				<a href="#nogo" id="keyPad_btn9" class="keyPad_btnNumeric ">9</a>
				<a href="#nogo" id="keyPad_btnDiv" class="keyPad_btnBinaryOp">/</a>
				<a href="#nogo" id="keyPad_%" class="keyPad_btnBinaryOp">%</a>
			</div>
			<div class="calc_row clear">
			<a href="#nogo" id="keyPad_btnPi" class="keyPad_btnConst">&#960;</a>
				<a href="#nogo" id="keyPad_btnE" class="keyPad_btnConst">e</a>
				<a href="#nogo" id="keyPad_btnFact" class="keyPad_btnUnaryOp">n!</a>
				<a href="#nogo" id="keyPad_btnYlogX" class="keyPad_btnBinaryOp "><span class='baseele'>log</span><span class='subscript'>y</span><span class='baseele'>x</span></a>
				<a href="#nogo" id="keyPad_btnExp" class="keyPad_btnUnaryOp"><span class='baseele'>e</span><span class='superscript'>x</span></a>
				<a href="#nogo" id="keyPad_btn10X" class="keyPad_btnUnaryOp"><span class='baseele'>10</span><span class='superscript'>x</span></a>
			
				
				<a href="#nogo" id="keyPad_btn4" class="keyPad_btnNumeric">4</a>
				<a href="#nogo" id="keyPad_btn5" class="keyPad_btnNumeric">5</a>
				<a href="#nogo" id="keyPad_btn6" class="keyPad_btnNumeric ">6</a>
				<a href="#nogo" id="keyPad_btnMult" class="keyPad_btnBinaryOp"><div style="position: relative; top: 3px; font-size: 20px">*</div></a>
				<a href="#nogo" id="keyPad_btnInverse" class="keyPad_btnUnaryOp"><span class='baseele'>1/x</span></a>
			</div>
			<div class="calc_row clear">
				<a href="#nogo" id="keyPad_btnSin" class="keyPad_btnUnaryOp min ">sin</a>
				<a href="#nogo" id="keyPad_btnCosin" class="keyPad_btnUnaryOp min">cos</a>
				<a href="#nogo" id="keyPad_btnTg" class="keyPad_btnUnaryOp min">tan</a>
				<a href="#nogo" id="keyPad_btnYpowX" class="keyPad_btnBinaryOp"><span class='baseele'>x</span><span class='superscript'>y</span></a>
				<a href="#nogo" id="keyPad_btnCube" class="keyPad_btnUnaryOp"><span	class='baseele'>x</span><span class='superscript'>3</span></a>
				<a href="#nogo" id="keyPad_btnSquare" class="keyPad_btnUnaryOp"><span class='baseele'>x</span><span class='superscript'>2</span></a>
				<a href="#nogo" id="keyPad_btn1" class="keyPad_btnNumeric">1</a>
				<a href="#nogo" id="keyPad_btn2" class="keyPad_btnNumeric">2</a>
				<a href="#nogo" id="keyPad_btn3" class="keyPad_btnNumeric">3</a>
				<a href="#nogo" id="keyPad_btnMinus" class="keyPad_btnBinaryOp"><div style="position: relative; top: -1px; font-size: 20px">-</div></a>
			</div>
			<div class="calc_row clear">
				<a href="#nogo" id="keyPad_btnAsin" class="keyPad_btnUnaryOp min"><span	class='baseele'>sin</span><span class='superscript'>-1</span></a>
				<a href="#nogo" id="keyPad_btnAcos" class="keyPad_btnUnaryOp min"><span class='baseele'>cos</span><span class='superscript'>-1</span></a>
				<a href="#nogo" id="keyPad_btnAtan" class="keyPad_btnUnaryOp min"><span class='baseele'>tan</span><span class='superscript'>-1</span></a>
				<a href="#nogo" id="keyPad_btnYrootX" class="keyPad_btnBinaryOp"><span class='superscript' style='top: -8px;'>y</span><span class='baseele' style='font-size: 1.2em; margin: -6px 0 0 -9px;'>&#8730;x</span></a>
				<a href="#nogo" id="keyPad_btnCubeRoot" class="keyPad_btnUnaryOp"><font	size="3">&#8731; </font></a>
				<a href="#nogo" id="keyPad_btnAbs" class="keyPad_btnUnaryOp"><span class='baseele'>|x|</span></a>
				<a href="#nogo" id="keyPad_btn0" class="keyPad_btnNumeric">0</a>
				<a href="#nogo" id="keyPad_btnDot" class="keyPad_btnNumeric ">.</a>
				<a href="#nogo" id="keyPad_btnPlus" class="keyPad_btnBinaryOp">+</a>
				<a href="#nogo" id="keyPad_btnEnter" class="keyPad_btnCommand "><div style="margin-bottom: 2px;">=</div></a>
			</div>
		</div>
		<div class="clear"></div>
         <!-- new Help changes -->
       	<div id="helpContent" onmousedown="return false" style="display:none;">
		  <h3 style="text-align:center;"><strong>Calculator Instructions</strong></h3>
		  Allows you to perform basic and complex mathematical operations such as modulus, square root, cube root, trigonometric, exponential, logarithmic, hyperbolic functions, etc. 
		  <br> You can operate the calculator using the buttons provided on screen with your mouse. <br>
		  <br>
		 <h3 style=" text-decoration: underline;color: green">Do's:</h3>
		 <ul>
		<li> Be sure to press [C] when beginning a new calculation.</li>	
		<li> Simply an equation using parenthesis and other mathematical operators.</li>
		<li> Use the predefined operations such as p (Pi), log, Exp to save time during calculation.</li>
		<li> Use memory function for calculating cumulative totals.</li>
		<strong>
		[M+]: Will add displayed value to memory.
		<br>
		[MR]: Will recall the value stored in memory.
		<br>
		[M-]: Subtracts the displayed value from memory.
		</strong>
		<li> Be sure select the angle unit (Deg or Rad) before beginning any calculation.</li>
		<strong>Note: By default angle unit is set as Degree</strong> 
	</ul>
 	<h3><span style=" text-decoration: underline;color: red">Dont's:</span></h3>
		<ul>
		<li> Perform multiple operations together.</li>
		<li> Leave parenthesis unbalanced.</li>
		<li> Change the angle unit (Deg or Rad) while performing a calculation..</li>
		</ul>
 	<h3><span style=" text-decoration: underline;">Limitations:</span></h3>
	<ul>
	<li> Keyboard operation is disabled.</li>
	<li> The output for a Factorial calculation is precise up to 14 digits.</li>
	<li> The output for Logarithmic and Hyperbolic calculations is precise up to 5 digits.</li>
	<li> Modulus (mod) operation performed on decimal numbers with 15 digits would not be precise.</li>
	<br>
	<strong> Use mod operation only if the number comprises of less than 15 digits i.e. mod operation provides best results for smaller numbers.</strong>
	<br>
	<li>The range of value supported by the calculator is 10(-323) to 10(308).</li>
	</ul>
	<br>
	<br>
</div>
         <!-- new Help changes -->
		 <!-- main content end here-->
	</div>
	</div>
         <div class="innertube">
            <div class="timeheader">
               <span style="text-align: left; float: left;">&nbsp;&nbsp;Section
               </span> <span style="text-align: right; float: right;"> <font
                  style="font-size: 14px; font-weight: bold;">Time Left:</font> <span
                  id="time"
                  style="color: black; font-size: 100%; font-weight: bold; vertical-align: middle; text-align: right;">
               </span>
               </span>
            </div>
         </div>
         <form:form modelAttribute="qp" id="springform" method="POST"
            action="load-qform">
            <input type="hidden" name="suspendexams" id="suspendexams" />
            <input type="hidden" id="totalqtime" name="totalqtime"
               value="${totalqtime}">
            <input type="hidden" id="timeqtaken" name="timeqtaken">
            <input type="hidden" name="noOfqbns" id="noOfqbns" value="${nofques}">
            <input type="hidden" name="subject" id="subject" value="${subject}" />
            <input type="hidden" name="examname" id="examname" value="${examname}" />
            <input type="hidden" name="sid" id="stu" value="${stuid}" />
            <input type="hidden" name="location_id" id="location_id"
               value="${location_id}" />
            <input type="hidden" name="branch_id" id="branch_id"
               value="${branch_id}" />
            <input type="hidden" name="class_id" id="class_id" value="${class_id}" />
            <input type="hidden" name="section_id" id="section_id"
               value="${section_id}" />
            <input type="hidden" id="timeqval" name="timeqval"
               value="${time_val_q}">
            <input type="hidden" id="endtime" name="endtime" value="${endtime}">
            <input type="hidden" id="prevansweredCnt" value="${answeredCnt}">
            <input type="hidden" id="different" name="different">
            <div id="unattemptcountforsub" style="display: none;"></div>
            <div id="attemptcountforsub" style="display: none;"></div>
            <ul class="nav nav-tabs">
               <c:forEach items="${model1.qp}" var="subrow" varStatus="loop2">
                  <c:choose>
                     <c:when test="${loop2.index==0}">
                        <input type="hidden" id="subjectidforcnt"
                           value="${subrow.subjectid}">
                        <li class="active"><a href="#tab_${loop2.index}" id="test"
                           data-toggle="tab" onclick="attemptcount(${subrow.subjectid})">${subrow.subjectname}
                           &nbsp;&nbsp;<span class="fa fa-info-circle"
                              style="font-size: 20px; color: #5BB1FA"> </span>
                           </a>
                        </li>
                     </c:when>
                     <c:otherwise>
                        <li><a href="#tab_${loop2.index}" data-toggle="tab"
                           onclick="attemptcount(${subrow.subjectid})">${subrow.subjectname}&nbsp;&nbsp;<span
                           class="fa fa-info-circle"
                           style="font-size: 20px; color: #5BB1FA"> </span></a></li>
                     </c:otherwise>
                  </c:choose>
               </c:forEach>
            </ul>
            <%
               int quesno = 1, paginationsno = 1,paginationsno1 = 1,bookmarkqutoInc = 9000,optionsloop = 0,selectedno = 1;
               %>
            <div class="tab-content">
               <%
                  String temp = ",", temp1 = "";
                  	int tempval = 0;
                  %>
               <c:forEach items="${model1.qp}" var="subrow" varStatus="loop2">
                  <c:choose>
                     <c:when test="${loop2.index==0}">
                        <div class="tab-pane active" id="tab_${loop2.index}">
                           <nav id="nav">
                              <div class="innertube">
                                 <div class="shadow1">
                                    <img alt="User Pic"
                                       src="${pageContext.request.contextPath}/theme/images/profile.jpg"
                                       id="profile-image1" class="img-circle img-responsive"
                                       style="width: 100px; height: 100px;">
                                    <div class="profile_details">
                                       <div id="Username" class="candOriginalName"
                                          title="<%=session.getAttribute("first_name")%>"><%=session.getAttribute("first_name")%></div>
                                    </div>
                                 </div>
                                 <div class="row" style=" margin-right: 0px;margin-top:120px;">
                                    <div class="question_description_number_panel" id="rightDivision">
                                       <div class="Rght_Section column" id="col2">
                                          <div class="collapsebel_panel">
                                             <span class="collapse_icon"></span>
                                             <div class="diff_type_notation_area_outer">
                                                <div class="diff_type_notation_area_inner">
                                                   <div class="notation_type_description">
                                                      <table >
                                                         <tr>
                                                            <td style="padding-top:10px;padding-bottom:10px; padding-right:10px;padding-left: 10px; "><span class="answered answeredCount" id="${subrow.subjectid}_answeredbtn"></span> <span class="type_title answeredLabel longtext-hide" id="" title="Answered">Answered</span></td>
                                                         </tr>
                                                         <tr>
                                                            <td style="padding-top:10px;padding-bottom:10px; padding-right:10px;padding-left: 10px; "><span class="not_answered notAnsweredCount" id="${subrow.subjectid}_notansweredbtn"></span> <span class="type_title notAnsweredLabel longtext-hide" id="" title="Not Answered">Not Answered</span></td>
                                                         </tr>
                                                         <tr>
                                                            <td style="padding-top:10px;padding-bottom:10px; padding-right:10px;padding-left: 10px; "><span class="not_visited notVisitedCount" id="${subrow.subjectid}_visnotansweredbtn">N</span> <span class="type_title notVisitedLabel longtext-hide" id="" title="Not Visited">Not Visited</span></td>
                                                         </tr>
                                                         <tr>
                                                            <td style="padding-top:10px;padding-bottom:10px; padding-right:10px;padding-left: 10px; "><span class="review markedCount" id="${subrow.subjectid}_markasrevnotansbtn">0</span> <span class="type_title markedLabel longtext-hide" id="" title="Marked for Review">Marked for Review</span></td>
                                                         </tr>
                                                         <tr>
                                                            <td style="padding-top:10px;padding-bottom:10px; padding-right:10px;padding-left: 10px;"><span class="review_marked markedReviewCount" id="${subrow.subjectid}_markasrevansbtn">0</span><span class="type_title markedAndAnsweredLabel" id="" title="Answered &amp; Marked for Review">Answered &amp; Marked for Reviewed</span></td>
                                                         </tr>
                                                      </table>
                                                   </div>
                                                </div>
                                             </div>
                                             <div class="rightSectionDiv" id="rightSectionDiv1">
                                                <div class="content"></div>
                                             </div>
                                             <div id="galleryalt_<%=tempval%>" >
                                                <div class="rightSectionDiv" id="rightSectionDiv2">
                                                   <div class="header">
                                                      &nbsp;<span class="viewSection"><b title="Section A"><span  class="nxtsubje" style="background-color: #4E85c5; height: 30px;  line-height: 30px; color: white;font-weight: bold;text-align: center;cursor: pointer;" onclick="viewNextTabSubjects();">
                                                      Click &amp; View Next Subject Questions</span></b> </span>
                                                   </div>
                                                   <div class="ex3"  id="question_area" style="height: 244px;">
                                                      <div class="question_area nano-content" tabindex="0" style="right: -17px;">
                                                         <div class="numberpanelQues" id="numberpaneldiv">
                                                            <div class="flatview" style="width:100%;"></div>
                                                         </div>
                                                      </div>
                                                      <div class="nano-pane" style="display: none;">
                                                         <div class="nano-slider" style="height: 228px; transform: translate(0px, 0px);"></div>
                                                      </div>
                                                   </div>
                                                </div>
                                                <div class="rightshadowbtns">
                                                   <a href="#" rel="next" class="btn btn-info" style="color: white; border-radius: 0px; height: 25px;padding-bottom: 28px; background-color: #0C7CD5;margin-right: 50px" onclick="visitednumber(this.id)">Next</a>
                                               
                                                 
               <span style="text-align: right;float: right; padding-right: 75px; ">
               <input type="button" id="popup" class="normalBtn btn btn-info" value="Submit"  title="Submit" onclick="return finish_div_show();">
               </span>
                                               
                                                </div>
                                             </div>
                                             <div class="clear"></div>
                                          </div>
                                       </div>
                                    </div>
                                 </div>
                              </div>
                           </nav>
                           <c:forEach items="${subrow.list}" var="row1" varStatus="loop">
                              <%
                                 pageContext.setAttribute("optionsloop", optionsloop);
                                 					pageContext.setAttribute("quesno", quesno);
                                 					pageContext.setAttribute("selectedno", selectedno);
                                 %>
                              <c:set var="optionsloop" value="${optionsloop}"></c:set>
                              <c:set var="quesno" value="${quesno}"></c:set>
                              <%
                                 temp1 = temp1 + "'" + paginationsno + "'" + temp;
                                 					paginationsno++;
                                 %>
                              <div class="virtualpage<%=tempval%> hidepiece">
                                 <div class="nextpages">
                                    <TABLE style="width: 75%;">
                                       <tr>
                                          <td colspan="2">
                                             <div class="" style="height: 30px;">
                                                <div class="panel-heading" style="color: #0059b3">
                                                   <table width="100%">
                                                      <tr>
                                                         <td style="text-align: left;"><font
                                                            color="#F07F5F" style="font-weight: bold;"><b>Question
                                                            Type</b>: ${row1.typeOfQuestion}</font>
                                                         </td>
                                                         <td style="text-align: right; float: right;"><font
                                                            style="color: black"> Marks per correct answer
                                                            </font> <font color="green" style="font-weight: bold;">${row1.marks_per_qus_type}</font>
                                                            <font style="color: black"> | Negative Marks </font> <font
                                                               color="red"> ${row1.negative_marks}</font>
                                                         </td>
                                                      </tr>
                                                   </table>
                                                </div>
                                             </div>
                                             <div class="panel panel-primary"
                                                style="border: 1px solid #C6c9ce; height: 60px;">
                                                <div class="panel-heading" style="height: 32px;"></div>
                                                <b> Question <%=paginationsno1%> : 
                                                </b>
                                                <!-- <span style="float: right;font-size: 30px; color: #5bc0de" class="fa fa-arrow-circle-down"> </span> -->
                                             </div>
                                             <div class="panel-body"
                                                style="max-height: 300px; overflow-x: auto; overflow-y: auto">
                                                <form:hidden path="list[${loop.index}].displayquest"
                                                   value="${row1.ques}" class="form-control" />
                                                <label> ${row1.ques} </label>
                                                <table width="100%" id="optionsTable">
                                                   <%
                                                      int integertypeval = 0,matrixflag = 0, multiflag = 0;
                                                      %>
                                                   <c:forEach items="${row1.optionsList}" var="options"
                                                      varStatus="i">
                                                      <%
                                                         pageContext.setAttribute("integertypeval", integertypeval);
                                                         %>
                                                      <c:set var="integertypeval" value="${integertypeval}"></c:set>
                                                      <tr>
                                                         <td width="2%">
                                                            <TABLE width="100%">
                                                               <c:choose>
                                                                  <c:when
                                                                     test="${row1.typeOfQuestion == 'Single answer'}">
                                                                     <tr>
                                                                        <td width="5%" style="font-weight: bold;"
                                                                           valign="baseline">${options.optionType})</td>
                                                                        <td width="95%" align="left" valign="baseline">
                                                                           <c:if
                                                                              test="${row1.selected_answer eq options.optionType}">
                                                                              <input type="hidden" value="${quesno}"
                                                                                 id="selectval_${selectedno}" />
                                                                              <input type="radio"
                                                                                 name="list[${optionsloop}].options"
                                                                                 value="${options.optionType}"
                                                                                 onclick="saveExamStatus_ByQid(this.value,${row1.question_id},${row1.subjectid},${row1.questionrowid}); "
                                                                                 checked="checked">
                                                                              <%
                                                                                 selectedno++;
                                                                                 %>
                                                                           </c:if>
                                                                           <c:if
                                                                              test="${row1.selected_answer != options.optionType}">
                                                                              <form:radiobutton
                                                                                 path="list[${optionsloop}].options"
                                                                                 value="${options.optionType}"
                                                                                 onclick=" saveExamStatus_ByQid(this.value,${row1.question_id},${row1.subjectid},${row1.questionrowid}); setColor(${quesno});attemptcount(${row1.subjectid});" />
                                                                           </c:if>
                                                                           <label for="list[${optionsloop}].options">
                                                                           ${options.option} </label>
                                                                        </td>
                                                                     </tr>
                                                                  </c:when>
                                                                  <c:when
                                                                     test="${row1.typeOfQuestion == 'Single type'}">
                                                                     <tr>
                                                                        <td width="5%" style="font-weight: bold;"
                                                                           valign="baseline">${options.optionType})</td>
                                                                        <td width="95%" align="left" valign="baseline">
                                                                           <c:if
                                                                              test="${row1.selected_answer eq options.optionType}">
                                                                              <input type="hidden" value="${quesno}"
                                                                                 id="selectval_${selectedno}" />
                                                                              <input type="radio"
                                                                                 name="list[${optionsloop}].options"
                                                                                 value="${options.optionType}"
                                                                                 onclick="saveExamStatus_ByQid(this.value,${row1.question_id},${row1.subjectid},${row1.questionrowid}); "
                                                                                 checked="checked">
                                                                              <%
                                                                                 selectedno++;
                                                                                 %>
                                                                           </c:if>
                                                                           <c:if
                                                                              test="${row1.selected_answer != options.optionType}">
                                                                              <form:radiobutton
                                                                                 path="list[${optionsloop}].options"
                                                                                 value="${options.optionType}"
                                                                                 onclick="saveExamStatus_ByQid(this.value,${row1.question_id},${row1.subjectid},${row1.questionrowid});  setColor(${quesno})" />
                                                                           </c:if>
                                                                           <label for="list[${optionsloop}].options">
                                                                           ${options.option} </label>
                                                                        </td>
                                                                     </tr>
                                                                  </c:when>
                                                                  <c:when test="${row1.typeOfQuestion == 'Multi Answer'}">
                                                                     <tr>
                                                                        <c:set var="selectedanswer"
                                                                           value="${row1.selected_answer}" />
                                                                        <c:if
                                                                           test="${selectedanswer!=null and selectedanswer!=''}">
                                                                           <%multiflag = 1;%>
                                                                        </c:if>
                                                                        <%
                                                                           pageContext.setAttribute("multiflag", multiflag);
                                                                           %>
                                                                        <c:set var="optionsvalue"
                                                                           value="${options.optionType}" />
                                                                        <c:if test="${i.index==0}">
                                                                           <c:if test="${multiflag==1}">
                                                                              <input type="hidden" value="${quesno}"
                                                                                 id="selectval_${selectedno}" />
                                                                              <%
                                                                                 selectedno++;
                                                                                 %>
                                                                           </c:if>
                                                                        </c:if>
                                                                        <c:if
                                                                           test="${fn:contains(selectedanswer,optionsvalue)}">
                                                                           <td width="5%" style="font-weight: bold;"
                                                                              valign="baseline">${options.optionType})</td>
                                                                           <td width="95%" align="left" valign="baseline">
                                                                              <input type="checkbox"
                                                                                 name="list[${optionsloop}].options"
                                                                                 value="${options.optionType}"
                                                                                 id='list[${optionsloop}].options'
                                                                                 checked="checked"
                                                                                 onclick="multiselectval('list[${optionsloop}].options',${row1.question_id},${row1.subjectid},${row1.questionrowid}); " />
                                                                              <label for="list[${optionsloop}].options">
                                                                              ${options.option} </label>
                                                                           </td>
                                                                        </c:if>
                                                                        <c:if
                                                                           test="${not fn:contains(selectedanswer,optionsvalue)}">
                                                                           <td width="5%" style="font-weight: bold;"
                                                                              valign="baseline">${options.optionType})</td>
                                                                           <td width="95%" align="left" valign="baseline">
                                                                              <form:checkbox
                                                                                 path="list[${optionsloop}].options"
                                                                                 value="${options.optionType}"
                                                                                 id='list[${optionsloop}].options'
                                                                                 onclick="multiselectval('list[${optionsloop}].options',${row1.question_id},${row1.subjectid},${row1.questionrowid}); setColor(${quesno})" />
                                                                              <label for="list[${optionsloop}].options">
                                                                              ${options.option} </label>
                                                                           </td>
                                                                        </c:if>
                                                                     </tr>
                                                                  </c:when>  <c:when        test="${row1.typeOfQuestion == 'Numerical Ability'}">
              
               <c:if test="${integertypeval eq 0}">
               <tr>
               <td width="95%" align="left" valign="baseline">
               <c:if test="${row1.selected_answer eq null}">
               <form:input
                  path="list[${optionsloop}].options"
                  id="list[${optionsloop}].options"
                  style="width:50%;height:40px;"
                  readonly="true"
                  />
               </c:if>
               <c:if test="${row1.selected_answer != null}">
               <input type="hidden" value="${quesno}"
                  id="selectval_${selectedno}" />
               <form:input
                  path="list[${optionsloop}].options"
                  id="list[${optionsloop}].options"
                  value="${row1.selected_answer}"
                  style="width:50%;height:40px;"
                  readonly="true"
                  />
               <%
                  selectedno++;
                  %>
               </c:if>
               <div class="col-md-12">
               <div class="col-md-2">&nbsp;</div>
               <div class="col-md-4" >
               <div id="vKeyboard" class="vKeyboard" style="width: 145px;">
               <span class="vKeyboardSplKeys" style="border-radius: 6px;" onClick="deleteKeyBoardvalye('list[${optionsloop}].options',${row1.question_id},${row1.subjectid},${row1.questionrowid},${quesno});">Backspace</span><br>
               <span class="vKeyboardKeys" style="border-radius: 6px;" onClick="document.getElementById('list[${optionsloop}].options').value+='7';saveExamStatus_ByQid(document.getElementById('list[${optionsloop}].options').value,${row1.question_id},${row1.subjectid},${row1.questionrowid});setColor(${quesno});attemptcount(${row1.subjectid});">7</span>
               <span class="vKeyboardKeys" style="border-radius: 6px;" onClick="document.getElementById('list[${optionsloop}].options').value+='8';saveExamStatus_ByQid(document.getElementById('list[${optionsloop}].options').value,${row1.question_id},${row1.subjectid},${row1.questionrowid});setColor(${quesno});attemptcount(${row1.subjectid});">8</span>
               <span class="vKeyboardKeys" style="border-radius: 6px;" onClick="document.getElementById('list[${optionsloop}].options').value+='9';saveExamStatus_ByQid(document.getElementById('list[${optionsloop}].options').value,${row1.question_id},${row1.subjectid},${row1.questionrowid});setColor(${quesno});attemptcount(${row1.subjectid});">9</span><br>
               <span class="vKeyboardKeys" style="border-radius: 6px;" onClick="document.getElementById('list[${optionsloop}].options').value+='4';saveExamStatus_ByQid(document.getElementById('list[${optionsloop}].options').value,${row1.question_id},${row1.subjectid},${row1.questionrowid});setColor(${quesno});attemptcount(${row1.subjectid});">4</span>
               <span class="vKeyboardKeys" style="border-radius: 6px;" onClick="document.getElementById('list[${optionsloop}].options').value+='5';saveExamStatus_ByQid(document.getElementById('list[${optionsloop}].options').value,${row1.question_id},${row1.subjectid},${row1.questionrowid});setColor(${quesno});attemptcount(${row1.subjectid});">5</span>
               <span class="vKeyboardKeys" style="border-radius: 6px;" onClick="document.getElementById('list[${optionsloop}].options').value+='6';saveExamStatus_ByQid(document.getElementById('list[${optionsloop}].options').value,${row1.question_id},${row1.subjectid},${row1.questionrowid});setColor(${quesno});attemptcount(${row1.subjectid});">6</span><br>
               <span class="vKeyboardKeys" style="border-radius: 6px;" onClick="document.getElementById('list[${optionsloop}].options').value+='1';saveExamStatus_ByQid(document.getElementById('list[${optionsloop}].options').value,${row1.question_id},${row1.subjectid},${row1.questionrowid});setColor(${quesno});attemptcount(${row1.subjectid});">1</span>
               <span class="vKeyboardKeys" style="border-radius: 6px;" onClick="document.getElementById('list[${optionsloop}].options').value+='2';saveExamStatus_ByQid(document.getElementById('list[${optionsloop}].options').value,${row1.question_id},${row1.subjectid},${row1.questionrowid});setColor(${quesno});attemptcount(${row1.subjectid});">2</span>
               <span class="vKeyboardKeys" style="border-radius: 6px;" onClick="document.getElementById('list[${optionsloop}].options').value+='3';saveExamStatus_ByQid(document.getElementById('list[${optionsloop}].options').value,${row1.question_id},${row1.subjectid},${row1.questionrowid});setColor(${quesno});attemptcount(${row1.subjectid});">3</span><br>
               <span class="vKeyboardKeys" style="border-radius: 6px;" onClick="document.getElementById('list[${optionsloop}].options').value+='0';saveExamStatus_ByQid(document.getElementById('list[${optionsloop}].options').value,${row1.question_id},${row1.subjectid},${row1.questionrowid});setColor(${quesno});attemptcount(${row1.subjectid});">0</span>
               <span class="vKeyboardKeys" style="border-radius: 6px;" onClick="document.getElementById('list[${optionsloop}].options').value+='.';saveExamStatus_ByQid(document.getElementById('list[${optionsloop}].options').value,${row1.question_id},${row1.subjectid},${row1.questionrowid});setColor(${quesno});attemptcount(${row1.subjectid});">.</span>
               <br>
               <span class="vKeyboardSplKeys" style="border-radius: 6px;" onclick="clearAllValues('list[${optionsloop}].options');removeRadiobuttonSelection('list[${optionsloop}].options',${row1.question_id},${row1.subjectid},${row1.questionrowid},${quesno},'#101010');">Clear All</span><br></div>
               </div>
               </div>
               </td>
               </tr>
               </c:if>
               </c:when>
                                            
                                                                  <c:when
                                                                     test="${row1.typeOfQuestion == 'Integer Type'}">
                                                                     <c:if test="${integertypeval eq 0}">
                                                                        <tr>
                                                                           <td width="95%" align="left" valign="baseline">
                                                                              <c:if test="${row1.selected_answer eq null}">
                                                                                 <form:input path="list[${optionsloop}].options"
                                                                                    onkeypress="return event.charCode >= 48 && event.charCode <= 57"
                                                                                    maxlength="1" style="width:50%;height:40px;"
                                                                                    onkeyup="saveExamStatus_ByQid(this.value,${row1.question_id},${row1.subjectid},${row1.questionrowid}); setColorforTextbox(${quesno},this.value);" />
                                                                              </c:if>
                                                                              <c:if test="${row1.selected_answer != null}">
                                                                                 <input type="hidden" value="${quesno}"
                                                                                    id="selectval_${selectedno}" />
                                                                                 <form:input path="list[${optionsloop}].options"
                                                                                    value="${row1.selected_answer}"
                                                                                    onkeypress="return event.charCode >= 48 && event.charCode <= 57"
                                                                                    maxlength="1" style="width:50%;height:40px;"
                                                                                    onkeyup="saveExamStatus_ByQid(this.value,${row1.question_id},${row1.subjectid},${row1.questionrowid}); attemptcount();" />
                                                                                 <%
                                                                                    selectedno++;
                                                                                    %>
                                                                              </c:if>
                                                                           </td>
                                                                        </tr>
                                                                     </c:if>
                                                                  </c:when>
                                                                  <c:when
                                                                     test="${row1.typeOfQuestion == 'Fill in the blanks'}">
                                                                     <c:if test="${integertypeval eq 0}">
                                                                        <tr>
                                                                           <td width="95%" align="left" valign="baseline">
                                                                              <c:if test="${row1.selected_answer eq null}">
                                                                                 <form:input path="list[${optionsloop}].options"
                                                                                    maxlength="500" style="width:50%;height:40px;"
                                                                                    onkeyup="saveExamStatus_ByQid(this.value,${row1.question_id},${row1.subjectid},${row1.questionrowid}); attemptcount();setColorforTextbox(${quesno},this.value);" />
                                                                              </c:if>
                                                                              <c:if test="${row1.selected_answer != null}">
                                                                                 <input type="hidden" value="${quesno}"
                                                                                    id="selectval_${selectedno}" />
                                                                                 <form:input path="list[${optionsloop}].options"
                                                                                    value="${row1.selected_answer}"
                                                                                    maxlength="500" style="width:50%;height:40px;"
                                                                                    onkeyup="saveExamStatus_ByQid(this.value,${row1.question_id},${row1.subjectid},${row1.questionrowid}); attemptcount();" />
                                                                                 <%
                                                                                    selectedno++;
                                                                                    %>
                                                                              </c:if>
                                                                           </td>
                                                                        </tr>
                                                                     </c:if>
                                                                  </c:when>
                                                                  <c:when
                                                                     test="${row1.typeOfQuestion == 'True Or False'}">
                                                                     <tr>
                                                                        <td width="95%" align="left" valign="baseline">
                                                                           <c:if
                                                                              test="${row1.selected_answer eq options.optionType}">
                                                                              <input type="hidden" value="${quesno}"
                                                                                 id="selectval_${selectedno}" />
                                                                              <input type="radio"
                                                                                 name="list[${optionsloop}].options"
                                                                                 value="${options.optionType}"
                                                                                 onclick="saveExamStatus_ByQid(this.value,${row1.question_id},${row1.subjectid},${row1.questionrowid}); "
                                                                                 checked="checked">
                                                                              <%
                                                                                 selectedno++;
                                                                                 %>
                                                                           </c:if>
                                                                           <c:if
                                                                              test="${row1.selected_answer != options.optionType}">
                                                                              <form:radiobutton
                                                                                 path="list[${optionsloop}].options"
                                                                                 value="${options.optionType}"
                                                                                 onclick="saveExamStatus_ByQid(this.value,${row1.question_id},${row1.subjectid},${row1.questionrowid}); setColor(${quesno})" />
                                                                           </c:if>
                                                                           <label for="list[${optionsloop}].options">
                                                                           ${options.option} </label>
                                                                        </td>
                                                                     </tr>
                                                                  </c:when>
                                                                  <c:when
                                                                     test="${row1.typeOfQuestion == 'Reasoning Type'}">
                                                                     <tr>
                                                                        <td width="5%" style="font-weight: bold;"
                                                                           valign="baseline">${options.optionType})</td>
                                                                        <td width="95%" align="left" valign="baseline">
                                                                           <c:if
                                                                              test="${row1.selected_answer eq options.optionType}">
                                                                              <input type="hidden" value="${quesno}"
                                                                                 id="selectval_${selectedno}" />
                                                                              <input type="radio"
                                                                                 name="list[${optionsloop}].options"
                                                                                 value="${options.optionType}"
                                                                                 onclick="saveExamStatus_ByQid(this.value,${row1.question_id},${row1.subjectid},${row1.questionrowid}); "
                                                                                 checked="checked">
                                                                              <%
                                                                                 selectedno++;
                                                                                 %>
                                                                           </c:if>
                                                                           <c:if
                                                                              test="${row1.selected_answer != options.optionType}">
                                                                              <form:radiobutton
                                                                                 path="list[${optionsloop}].options"
                                                                                 value="${options.optionType}"
                                                                                 onclick="saveExamStatus_ByQid(this.value,${row1.question_id},${row1.subjectid},${row1.questionrowid}); setColor(${quesno})" />
                                                                           </c:if>
                                                                           <label for="list[${optionsloop}].options">
                                                                           ${options.option} </label>
                                                                        </td>
                                                                     </tr>
                                                                  </c:when>
                                                                  <c:when
                                                                     test="${row1.typeOfQuestion == 'Matrix Match'}">
                                                                     <c:set var="selectedanswer"
                                                                        value="${row1.selected_answer}" />
                                                                     <c:set var="splitanwer"
                                                                        value="${fn:split(selectedanswer, ',')}" />
                                                                     <c:set value="${options.option}" var="matrixoption"></c:set>
                                                                     <%
                                                                        String thirdSubStringspli = "";
                                                                        								String firstSubStringspli = "";
                                                                        								String secondSubStringspli = "";
                                                                        								String matrixoption = (String) pageContext.getAttribute("matrixoption");
                                                                        								String[] splitmatr = matrixoption.split("matrix_option");
                                                                        
                                                                        								firstSubStringspli = splitmatr[0];
                                                                        
                                                                        								if (splitmatr.length == 2) {
                                                                        									secondSubStringspli = splitmatr[1];
                                                                        								}
                                                                        								if (splitmatr.length == 3) {
                                                                        									secondSubStringspli = splitmatr[1];
                                                                        
                                                                        									thirdSubStringspli = splitmatr[2];
                                                                        								}
                                                                        								request.setAttribute("firstSubStringspli", firstSubStringspli);
                                                                        								request.setAttribute("secondSubStringspli", secondSubStringspli);
                                                                        								request.setAttribute("thirdSubStringspli", thirdSubStringspli);
                                                                        %>
                                                                     <c:if
                                                                        test="${selectedanswer!=null and selectedanswer!=''}">
                                                                        <%
                                                                           matrixflag = 1;
                                                                           %>
                                                                     </c:if>
                                                                     <%
                                                                        pageContext.setAttribute("matrixflag", matrixflag);
                                                                        %>
                                                                     <tr>
                                                                        <td>
                                                                           <table id="matrixtable" width="100%"
                                                                              style="right: 10; border: 1px solid #ddd;">
                                                                              <c:if test="${(i.index)==0}">
                                                                                 <tr>
                                                                                    <td width="40%"><label>Column I </label></td>
                                                                                    <td width="40%"><label>Column II
                                                                                       </label>
                                                                                    </td>
                                                                                    <td width="20%"><label>Select
                                                                                       Answer </label>
                                                                                    </td>
                                                                                 </tr>
                                                                              </c:if>
                                                                              <tr>
                                                                                 <td width="40%"><label
                                                                                    for="list[${optionsloop}].options">
                                                                                    ${firstSubStringspli}</label>
                                                                                 </td>
                                                                                 <td width="40%"><label
                                                                                    for="list[${optionsloop}].options">${secondSubStringspli}</label></td>
                                                                                 <td width="20%">
                                                                                    <c:if
                                                                                       test="${(i.index)==0}">
                                                                                       <select name="list[${optionsloop}].options"
                                                                                          multiple="multiple" style="height: 100px;"
                                                                                          onchange="matrixselectval('list[${optionsloop}].options',${row1.question_id},${row1.subjectid},${row1.questionrowid});setColor(${quesno});attemptcount(${row1.subjectid});">
                                                                                          <option value="0">Select-Value</option>
                                                                                          <c:choose>
                                                                                             <c:when
                                                                                                test="${fn:contains(row1.selected_answer, 'A-P')}">
                                                                                                <option value="A-P" selected="selected">P</option>
                                                                                             </c:when>
                                                                                             <c:otherwise>
                                                                                                <option value="A-P">P</option>
                                                                                             </c:otherwise>
                                                                                          </c:choose>
                                                                                          <c:choose>
                                                                                             <c:when
                                                                                                test="${fn:contains(row1.selected_answer,'A-Q')}">
                                                                                                <option value="A-Q" selected="selected">Q</option>
                                                                                             </c:when>
                                                                                             <c:otherwise>
                                                                                                <option value="A-Q">Q</option>
                                                                                             </c:otherwise>
                                                                                          </c:choose>
                                                                                          <c:choose>
                                                                                             <c:when
                                                                                                test="${fn:contains(row1.selected_answer,'A-R')}">
                                                                                                <option value="A-R" selected="selected">R</option>
                                                                                             </c:when>
                                                                                             <c:otherwise>
                                                                                                <option value="A-R">R</option>
                                                                                             </c:otherwise>
                                                                                          </c:choose>
                                                                                          <c:choose>
                                                                                             <c:when
                                                                                                test="${fn:contains(row1.selected_answer,'A-S')}">
                                                                                                <option value="A-S" selected="selected">S</option>
                                                                                             </c:when>
                                                                                             <c:otherwise>
                                                                                                <option value="A-S">S</option>
                                                                                             </c:otherwise>
                                                                                          </c:choose>
                                                                                          <c:choose>
                                                                                             <c:when
                                                                                                test="${fn:contains(row1.selected_answer,'A-T')}">
                                                                                                <option value="A-T" selected="selected">T</option>
                                                                                             </c:when>
                                                                                             <c:otherwise>
                                                                                                <option value="A-T">T</option>
                                                                                             </c:otherwise>
                                                                                          </c:choose>
                                                                                       </select>
                                                                                       <c:if test="${matrixflag==1}">
                                                                                          <input type="hidden" value="${quesno}"
                                                                                             id="selectval_${selectedno}" />
                                                                                          <%
                                                                                             selectedno++;
                                                                                             %>
                                                                                       </c:if>
                                                                                    </c:if>
                                                                                    <c:if test="${(i.index)==1}">
                                                                                       <select name="list[${optionsloop}].options"
                                                                                          multiple="multiple" style="height: 100px;"
                                                                                          onchange="matrixselectval('list[${optionsloop}].options',${row1.question_id},${row1.subjectid},${row1.questionrowid});setColor(${quesno});attemptcount(${row1.subjectid});">
                                                                                          <option value="0">Select-Value</option>
                                                                                          <c:choose>
                                                                                             <c:when
                                                                                                test="${fn:contains(row1.selected_answer,'B-P')}">
                                                                                                <option value="B-P" selected="selected">P</option>
                                                                                             </c:when>
                                                                                             <c:otherwise>
                                                                                                <option value="B-P">P</option>
                                                                                             </c:otherwise>
                                                                                          </c:choose>
                                                                                          <c:choose>
                                                                                             <c:when
                                                                                                test="${fn:contains(row1.selected_answer,'B-Q')}">
                                                                                                <option value="B-Q" selected="selected">Q</option>
                                                                                             </c:when>
                                                                                             <c:otherwise>
                                                                                                <option value="B-Q">Q</option>
                                                                                             </c:otherwise>
                                                                                          </c:choose>
                                                                                          <c:choose>
                                                                                             <c:when
                                                                                                test="${fn:contains(row1.selected_answer,'B-R')}">
                                                                                                <option value="B-R" selected="selected">R</option>
                                                                                             </c:when>
                                                                                             <c:otherwise>
                                                                                                <option value="B-R">R</option>
                                                                                             </c:otherwise>
                                                                                          </c:choose>
                                                                                          <c:choose>
                                                                                             <c:when
                                                                                                test="${fn:contains(row1.selected_answer,'B-S')}">
                                                                                                <option value="B-S" selected="selected">S</option>
                                                                                             </c:when>
                                                                                             <c:otherwise>
                                                                                                <option value="B-S">S</option>
                                                                                             </c:otherwise>
                                                                                          </c:choose>
                                                                                          <c:choose>
                                                                                             <c:when
                                                                                                test="${fn:contains(row1.selected_answer,'B-T')}">
                                                                                                <option value="B-T" selected="selected">T</option>
                                                                                             </c:when>
                                                                                             <c:otherwise>
                                                                                                <option value="B-T">T</option>
                                                                                             </c:otherwise>
                                                                                          </c:choose>
                                                                                       </select>
                                                                                    </c:if>
                                                                                    <c:if test="${(i.index)==2}">
                                                                                       <select name="list[${optionsloop}].options"
                                                                                          multiple="multiple" style="height: 100px;"
                                                                                          onchange="matrixselectval('list[${optionsloop}].options',${row1.question_id},${row1.subjectid},${row1.questionrowid});setColor(${quesno});attemptcount(${row1.subjectid});">
                                                                                          <option value="0">Select-Value</option>
                                                                                          <c:choose>
                                                                                             <c:when
                                                                                                test="${fn:contains(row1.selected_answer,'C-P')}">
                                                                                                <option value="C-P" selected="selected">P</option>
                                                                                             </c:when>
                                                                                             <c:otherwise>
                                                                                                <option value="C-P">P</option>
                                                                                             </c:otherwise>
                                                                                          </c:choose>
                                                                                          <c:choose>
                                                                                             <c:when
                                                                                                test="${fn:contains(row1.selected_answer,'C-Q')}">
                                                                                                <option value="C-Q" selected="selected">Q</option>
                                                                                             </c:when>
                                                                                             <c:otherwise>
                                                                                                <option value="C-Q">Q</option>
                                                                                             </c:otherwise>
                                                                                          </c:choose>
                                                                                          <c:choose>
                                                                                             <c:when
                                                                                                test="${fn:contains(row1.selected_answer,'C-R')}">
                                                                                                <option value="C-R" selected="selected">R</option>
                                                                                             </c:when>
                                                                                             <c:otherwise>
                                                                                                <option value="C-R">R</option>
                                                                                             </c:otherwise>
                                                                                          </c:choose>
                                                                                          <c:choose>
                                                                                             <c:when
                                                                                                test="${fn:contains(row1.selected_answer,'C-S')}">
                                                                                                <option value="C-S" selected="selected">S</option>
                                                                                             </c:when>
                                                                                             <c:otherwise>
                                                                                                <option value="C-S">S</option>
                                                                                             </c:otherwise>
                                                                                          </c:choose>
                                                                                          <c:choose>
                                                                                             <c:when
                                                                                                test="${fn:contains(row1.selected_answer,'C-T')}">
                                                                                                <option value="C-T" selected="selected">T</option>
                                                                                             </c:when>
                                                                                             <c:otherwise>
                                                                                                <option value="C-T">T</option>
                                                                                             </c:otherwise>
                                                                                          </c:choose>
                                                                                       </select>
                                                                                    </c:if>
                                                                                    <c:if test="${(i.index)==3}">
                                                                                       <select name="list[${optionsloop}].options"
                                                                                          multiple="multiple" style="height: 100px;"
                                                                                          onchange="matrixselectval('list[${optionsloop}].options',${row1.question_id},${row1.subjectid},${row1.questionrowid});setColor(${quesno});attemptcount(${row1.subjectid});">
                                                                                          <option value="0">Select-Value</option>
                                                                                          <c:choose>
                                                                                             <c:when
                                                                                                test="${fn:contains(row1.selected_answer,'D-P')}">
                                                                                                <option value="D-P" selected="selected">P</option>
                                                                                             </c:when>
                                                                                             <c:otherwise>
                                                                                                <option value="D-P">P</option>
                                                                                             </c:otherwise>
                                                                                          </c:choose>
                                                                                          <c:choose>
                                                                                             <c:when
                                                                                                test="${fn:contains(row1.selected_answer,'D-Q')}">
                                                                                                <option value="D-Q" selected="selected">Q</option>
                                                                                             </c:when>
                                                                                             <c:otherwise>
                                                                                                <option value="D-Q">Q</option>
                                                                                             </c:otherwise>
                                                                                          </c:choose>
                                                                                          <c:choose>
                                                                                             <c:when
                                                                                                test="${fn:contains(row1.selected_answer,'D-R')}">
                                                                                                <option value="D-R" selected="selected">R</option>
                                                                                             </c:when>
                                                                                             <c:otherwise>
                                                                                                <option value="D-R">R</option>
                                                                                             </c:otherwise>
                                                                                          </c:choose>
                                                                                          <c:choose>
                                                                                             <c:when
                                                                                                test="${fn:contains(row1.selected_answer,'D-S')}">
                                                                                                <option value="D-S" selected="selected">S</option>
                                                                                             </c:when>
                                                                                             <c:otherwise>
                                                                                                <option value="D-S">S</option>
                                                                                             </c:otherwise>
                                                                                          </c:choose>
                                                                                          <c:choose>
                                                                                             <c:when
                                                                                                test="${fn:contains(row1.selected_answer,'D-T')}">
                                                                                                <option value="D-T" selected="selected">T</option>
                                                                                             </c:when>
                                                                                             <c:otherwise>
                                                                                                <option value="D-T">T</option>
                                                                                             </c:otherwise>
                                                                                          </c:choose>
                                                                                       </select>
                                                                                    </c:if>
                                                                                 </td>
                                                                              </tr>
                                                                              <c:if test="${(i.index)==3}">
                                                                                 <c:if test="${thirdSubStringspli != ''}">
                                                                                    <tr>
                                                                                       <td width="40%"><label
                                                                                          for="list[${optionsloop}].options"></label></td>
                                                                                       <td width="40%"><label
                                                                                          for="list[${optionsloop}].options">
                                                                                          ${thirdSubStringspli}</label>
                                                                                       </td>
                                                                                       <td width="20%"></td>
                                                                                    </tr>
                                                                                 </c:if>
                                                                              </c:if>
                                                                           </table>
                                                                        </td>
                                                                     </tr>
                                                                  </c:when>
                                                                  <c:when
                                                                     test="${row1.typeOfQuestion == 'Comprehension'}">
                                                                     <tr>
                                                                        <td width="5%" style="font-weight: bold;"
                                                                           valign="baseline">${options.optionType})</td>
                                                                        <td width="95%" align="left" valign="baseline">
                                                                           <c:if
                                                                              test="${row1.selected_answer eq options.optionType}">
                                                                              <input type="hidden" value="${quesno}"
                                                                                 id="selectval_${selectedno}" />
                                                                              <input type="radio"
                                                                                 name="list[${optionsloop}].options"
                                                                                 value="${options.optionType}"
                                                                                 onclick="saveExamStatus_ByQid(this.value,${row1.question_id},${row1.subjectid},${row1.questionrowid}); "
                                                                                 checked="checked">
                                                                              <%
                                                                                 selectedno++;
                                                                                 %>
                                                                           </c:if>
                                                                           <c:if
                                                                              test="${row1.selected_answer != options.optionType}">
                                                                              <form:radiobutton
                                                                                 path="list[${optionsloop}].options"
                                                                                 value="${options.optionType}"
                                                                                 onclick="saveExamStatus_ByQid(this.value,${row1.question_id},${row1.subjectid},${row1.questionrowid});  setColor(${quesno})" />
                                                                           </c:if>
                                                                           <label for="list[${optionsloop}].options">
                                                                           ${options.option} </label>
                                                                        </td>
                                                                     </tr>
                                                                  </c:when>
                                                               </c:choose>
                                                            </TABLE>
                                                         </td>
                                                         <%-- <td align="left"> ${options.option} </td> --%>
                                                      </tr>
                                                      <%
                                                         integertypeval++;
                                                         %>
                                                   </c:forEach>
                                                   <tr>
                                                      <td>
                                                         <div class="row"></div>
                                                      </td>
                                                   </tr>
                                                   <tr>
                                                      <td colspan="2">
                                                         <form:hidden
                                                            path="list[${loop.index}].bquestion_id"
                                                            id="bquestion_id" value="${row1.question_id}" />
                                                         <%-- Question ID: ${row1.question_id} --%>
                                                      </td>
                                                   </tr>
                                                </table>
                                             </div>
                                             <div class="footerbtngrup1">
                                                <div id="btnfooter"
                                                   style="background-color: rgb(255, 255, 255);">
                                                   <span
                                                      style="text-align: left; float: left; padding-right: 20px;">
                                                   <input type="button" class="btn btn-default"
                                                      value="Mark for Review" title="Mark for Review"
                                                      id="mark_${quesno}"
                                                      onclick="markAsReviewAndAttempted('list[${optionsloop}].options',${quesno},${row1.subjectid},${row1.question_id},${row1.questionrowid});">
                                                   </span> <span
                                                      style="text-align: left; float: left; padding-right: 20px;">
                                                   <input type="button" class="btn btn-default"
                                                      value="Bookmark" title="Bookmark"
                                                      id="${row1.question_id}"
                                                      onclick="insertBookmarkID(${row1.question_id}, <%=bookmarkqutoInc%>,${subrow.subjectid});">
                                                   </span> <span style="text-align: left; float: left;"> <input
                                                      type="button" class="btn btn-default"
                                                      value="Clear Response" title="Clear Response"
                                                      onclick="removeRadiobuttonSelection('list[${optionsloop}].options',${row1.question_id},${row1.subjectid},${row1.questionrowid},${quesno},'#101010');">
                                                   </span> <!-- <span
                                                      style="text-align: right; float: right; padding-right: 75px;">
                                                   <input type="button" id="popup"
                                                      class="normalBtn btn btn-info" value="Submit"
                                                      title="Submit" onclick="return finish_div_show();">
                                                   </span> -->
                                                </div>
                                             </div>
                                             <div class="" style="width: 100%">
                                                <table width="100%">
                                                   <tr>
                                                      <td colspan="3" align="center" id="<%=bookmarkqutoInc%>"
                                                         style="color: blue; font-weight: bold;" align="center">
                                                      </td>
                                                   </tr>
                                                </table>
                                                <%
                                                   quesno++;
                                                   %>
                                             </div>
                                          </td>
                                       </tr>
                                       <%
                                          bookmarkqutoInc++;optionsloop++;paginationsno1++;
                                          %>
                                    </TABLE>
                                 </div>
                              </div>
                           </c:forEach>
                           <%
                              temp1 = temp1.substring(0, temp1.length() - 1);
                              %>
                           <script type="text/javascript">
                              var tempval=<%=tempval%>;
                              var gallery4=new virtualpaginate({
                              piececlass: 'virtualpage'+tempval,
                              piececontainer: 'div',
                              pieces_per_page: 1,
                              defaultpage: 0,
                              wraparound: false,
                              persist: true
                              })
                              gallery4.buildpagination(["galleryalt_<%=tempval%>"],<%=temp1%>)
                              
                              
                           </script>
                        </div>
                     </c:when>
                     <c:otherwise>
                        <%
                           temp1 = "";
                           %>
                        <div class="tab-pane" id="tab_${loop2.index}">
                           <nav id="nav">
                              <div class="innertube">
                                 <div class="shadow1">
                                    <img alt="User Pic"
                                       src="${pageContext.request.contextPath}/theme/images/profile.jpg"
                                       id="profile-image1" class="img-circle img-responsive"
                                       style="width: 100px; height: 100px;">
                                    <div class="profile_details">
                                       <div id="Username" class="candOriginalName"
                                          title="<%=session.getAttribute("first_name")%>"><%=session.getAttribute("first_name")%></div>
                                    </div>
                                 </div>
                                 <div class="row" style=" margin-right: 0px;margin-top:120px;">
                                    <div class="question_description_number_panel" id="rightDivision">
                                       <div class="Rght_Section column" id="col2">
                                          <div class="collapsebel_panel">
                                             <span class="collapse_icon"></span>
                                             <div class="diff_type_notation_area_outer">
                                                <div class="diff_type_notation_area_inner">
                                                   <div class="notation_type_description">
                                                      <table >
                                                         <tr>
                                                            <td style="padding-top:10px;padding-bottom:10px; padding-right:10px;padding-left: 10px; "><span class="answered answeredCount" id="${subrow.subjectid}_answeredbtn"></span> <span class="type_title answeredLabel longtext-hide" id="" title="Answered">Answered</span></td>
                                                         </tr>
                                                         <tr>
                                                            <td style="padding-top:10px;padding-bottom:10px; padding-right:10px;padding-left: 10px; "><span class="not_answered notAnsweredCount" id="${subrow.subjectid}_notansweredbtn"></span> <span class="type_title notAnsweredLabel longtext-hide" id="" title="Not Answered">Not Answered</span></td>
                                                         </tr>
                                                         <tr>
                                                            <td style="padding-top:10px;padding-bottom:10px; padding-right:10px;padding-left: 10px; "><span class="not_visited notVisitedCount" id="${subrow.subjectid}_visnotansweredbtn">N</span> <span class="type_title notVisitedLabel longtext-hide" id="" title="Not Visited">Not Visited</span></td>
                                                         </tr>
                                                         <tr>
                                                            <td style="padding-top:10px;padding-bottom:10px; padding-right:10px;padding-left: 10px; "><span class="review markedCount" id="${subrow.subjectid}_markasrevnotansbtn">0</span> <span class="type_title markedLabel longtext-hide" id="" title="Marked for Review">Marked for Review</span></td>
                                                         </tr>
                                                         <tr>
                                                            <td style="padding-top:10px;padding-bottom:10px; padding-right:10px;padding-left: 10px;"><span class="review_marked markedReviewCount" id="${subrow.subjectid}_markasrevansbtn">0</span><span class="type_title markedAndAnsweredLabel" id="" title="Answered &amp; Marked for Review">Answered &amp; Marked for Reviewed</span></td>
                                                         </tr>
                                                      </table>
                                                   </div>
                                                </div>
                                             </div>
                                             <div class="rightSectionDiv" id="rightSectionDiv1">
                                                <div class="content"></div>
                                             </div>
                                             <div id="galleryalt_<%=tempval%>" >
                                                <div class="rightSectionDiv" id="rightSectionDiv2">
                                                   <div class="header">
                                                      &nbsp;<span class="viewSection"><b title="Section A"><span  class="nxtsubje" style="background-color: #4E85c5; height: 30px;  line-height: 30px; color: white;font-weight: bold;text-align: center;cursor: pointer;" onclick="viewNextTabSubjects();">
                                                      Click &amp; View Next Subject Questions</span></b> </span>
                                                   </div>
                                                   <div class="content nano has-scrollbar" id="question_area" style="height: 244px;">
                                                      <div class="question_area nano-content" tabindex="0" style="right: -17px;">
                                                         <div class="numberpanelQues" id="numberpaneldiv">
                                                            <div class="flatview" style="width:100%;"></div>
                                                         </div>
                                                      </div>
                                                      <div class="nano-pane" style="display: none;">
                                                         <div class="nano-slider" style="height: 228px; transform: translate(0px, 0px);"></div>
                                                      </div>
                                                   </div>
                                                </div>
                                                <div class="rightshadowbtns">
                                                   <a href="#" rel="next" class="btn btn-info" style="color: white; border-radius: 0px; height: 25px;padding-bottom: 28px; background-color: #0C7CD5;margin-right: 50px" onclick="visitednumber(this.id)">Save&amp;Next</a>
                                                </div>
                                             </div>
                                             <div class="clear"></div>
                                          </div>
                                       </div>
                                    </div>
                                 </div>
                              </div>
                           </nav>
                           <c:forEach items="${subrow.list}" var="row1" varStatus="loop">
                              <%
                                 pageContext.setAttribute("optionsloop", optionsloop);
                                     pageContext.setAttribute("quesno", quesno);
                                 pageContext.setAttribute("selectedno", selectedno);
                                 %>
                              <c:set var="optionsloop" value="${optionsloop}"></c:set>
                              <c:set var="quesno" value="${quesno}"></c:set>
                              <c:set var="selectedno" value="${selectedno}"></c:set>
                              <%
                                 temp1 = temp1 + "'" + paginationsno + "'" + temp;
                                 					paginationsno++;
                                 %>
                              <div class="virtualpage<%=tempval%> hidepiece"
                                 style="width: 100%">
                                 <div style="width: 100%">
                                    <TABLE style="width: 75%;">
                                       <tr>
                                          <td colspan="2">
                                             <div class="" style="height: 30px;">
                                                <div class="panel-heading" style="color: #0059b3">
                                                   <table width="100%">
                                                      <tr>
                                                         <td style="text-align: left;"><font
                                                            color="#F07F5F" style="font-weight: bold;"><b>Question
                                                            Type</b>: ${row1.typeOfQuestion}</font>
                                                         </td>
                                                         <td style="text-align: right; float: right;"><font
                                                            style="color: black"> Marks per correct answer
                                                            </font> <font color="green" style="font-weight: bold;">${row1.marks_per_qus_type}</font>
                                                            <font style="color: black"> | Negative Marks </font> <font
                                                               color="red"> ${row1.negative_marks}</font>
                                                         </td>
                                                      </tr>
                                                   </table>
                                                </div>
                                             </div>
                                             <div class="panel panel-primary" style="border: 1px solid #C6c9ce; height: 60px;">
                                                <div class="panel-heading" style="height: 32px;"></div>
                                                <b> Question <%=paginationsno1%> :
                                                </b>
                                                <!-- <span style="float: right;font-size: 30px; color: #5bc0de" class="fa fa-arrow-circle-down"> </span>											</div> -->
                                                <div class="panel-body"
                                                   style="overflow-x: auto; overflow-y: auto; max-height: 300px">
                                                   <form:hidden path="list[${loop.index}].displayquest"
                                                      value="${row1.ques}" class="form-control" />
                                                   <label> ${row1.ques} </label>
                                                   <table width="100%" id="optionsTable">
                                                      <%
                                                         int integertypeval = 0;
                                                         %>
                                                      <%				pageContext.setAttribute("integertypeval", integertypeval);
                                                         int matrixflag=0,multiflag=0;
                                                         %>
                                                      <c:set var="integertypeval" value="${integertypeval}"></c:set>
                                                      <c:forEach items="${row1.optionsList}" var="options"
                                                         varStatus="i">
                                                         <%pageContext.setAttribute("integertypeval", integertypeval);
                                                            %>
                                                         <c:set var="integertypeval" value="${integertypeval}"></c:set>
                                                         <tr>
                                                            <td width="2%">
                                                               <TABLE width="100%">
                                                                  <c:choose>
                                                                     <c:when
                                                                        test="${row1.typeOfQuestion == 'Single answer'}">
                                                                        <tr>
                                                                           <td width="5%" style="font-weight: bold;"
                                                                              valign="baseline">${options.optionType})
                                                                           </td>
                                                                           <td width="95%" align="left" valign="baseline">
                                                                              <c:if
                                                                                 test="${row1.selected_answer eq options.optionType}">
                                                                                 <input type="hidden" value="${quesno}"
                                                                                    id="selectval_${selectedno}" />
                                                                                 <input type="radio"
                                                                                    name="list[${optionsloop}].options"
                                                                                    value="${options.optionType}"
                                                                                    onclick="saveExamStatus_ByQid(this.value,${row1.question_id},${row1.subjectid},${row1.questionrowid}); "
                                                                                    checked="checked">
                                                                                 <%
                                                                                    selectedno++;
                                                                                    %>
                                                                              </c:if>
                                                                              <c:if
                                                                                 test="${row1.selected_answer != options.optionType}">
                                                                                 <form:radiobutton
                                                                                    path="list[${optionsloop}].options"
                                                                                    value="${options.optionType}"
                                                                                    onclick="saveExamStatus_ByQid(this.value,${row1.question_id},${row1.subjectid},${row1.questionrowid});  setColor(${quesno})" />
                                                                              </c:if>
                                                                              <label for="list[${optionsloop}].options">
                                                                              ${options.option} </label>
                                                                           </td>
                                                                        </tr>
                                                                     </c:when>
                                                                     <c:when
                                                                        test="${row1.typeOfQuestion == 'Single type'}">
                                                                        <tr>
                                                                           <td width="5%" style="font-weight: bold;"
                                                                              valign="baseline">${options.optionType})</td>
                                                                           <td width="95%" align="left" valign="baseline">
                                                                              <c:if
                                                                                 test="${row1.selected_answer eq options.optionType}">
                                                                                 <input type="hidden" value="${quesno}"
                                                                                    id="selectval_${selectedno}" />
                                                                                 <input type="radio"
                                                                                    name="list[${optionsloop}].options"
                                                                                    value="${options.optionType}"
                                                                                    onclick="saveExamStatus_ByQid(this.value,${row1.question_id},${row1.subjectid},${row1.questionrowid}); "
                                                                                    checked="checked">
                                                                                 <%
                                                                                    selectedno++;
                                                                                    %>
                                                                              </c:if>
                                                                              <c:if
                                                                                 test="${row1.selected_answer != options.optionType}">
                                                                                 <form:radiobutton
                                                                                    path="list[${optionsloop}].options"
                                                                                    value="${options.optionType}"
                                                                                    onclick="saveExamStatus_ByQid(this.value,${row1.question_id},${row1.subjectid},${row1.questionrowid});  setColor(${quesno})" />
                                                                              </c:if>
                                                                              <label for="list[${optionsloop}].options">
                                                                              ${options.option} </label>
                                                                           </td>
                                                                        </tr>
                                                                     </c:when>
                                                                     <c:when
                                                                        test="${row1.typeOfQuestion == 'Multi Answer'}">
                                                                        <tr>
                                                                           <c:set var="selectedanswer"
                                                                              value="${row1.selected_answer}" />
                                                                           <c:if test="${selectedanswer!=null and selectedanswer!=''}">
                                                                              <%	multiflag=1;%>
                                                                           </c:if>
                                                                           <%pageContext.setAttribute("multiflag", multiflag);	%>
                                                                           <c:set var="optionsvalue"
                                                                              value="${options.optionType}" />
                                                                           <c:if test="${i.index==0}">
                                                                              <c:if test="${multiflag==1}">
                                                                                 <input type="hidden" value="${quesno}"	id="selectval_${selectedno}" />
                                                                                 <%selectedno++;	%>
                                                                              </c:if>
                                                                           </c:if>
                                                                           <c:if test="${fn:contains(selectedanswer,optionsvalue)}">
                                                                              <td width="5%" style="font-weight: bold;"
                                                                                 valign="baseline">${options.optionType})</td>
                                                                              <td width="95%" align="left" valign="baseline">
                                                                                 <input type="checkbox" name="list[${optionsloop}].options"
                                                                                    value="${options.optionType}" id='list[${optionsloop}].options'
                                                                                    checked="checked"
                                                                                    onclick="multiselectval('list[${optionsloop}].options',${row1.question_id},${row1.subjectid},${row1.questionrowid}); " />
                                                                                 <label for="list[${optionsloop}].options">
                                                                                 ${options.option} </label>
                                                                              </td>
                                                                           </c:if>
                                                                           <c:if test="${not fn:contains(selectedanswer,optionsvalue)}">
                                                                              <td width="5%" style="font-weight: bold;"
                                                                                 valign="baseline">${options.optionType})</td>
                                                                              <td width="95%" align="left" valign="baseline">
                                                                                 <form:checkbox
                                                                                    path="list[${optionsloop}].options"
                                                                                    value="${options.optionType}"
                                                                                    id='list[${optionsloop}].options'
                                                                                    onclick="multiselectval('list[${optionsloop}].options',${row1.question_id},${row1.subjectid},${row1.questionrowid}); setColor(${quesno})" />
                                                                                 <label for="list[${optionsloop}].options">
                                                                                 ${options.option} </label>
                                                                              </td>
                                                                           </c:if>
                                                                        </tr>
                                                                     </c:when>
                                                                     
                                      <c:when	test="${row1.typeOfQuestion == 'Integer Type'}">
                                                                        <c:if test="${integertypeval eq 0}">
                                                                           <tr>
                                                                              <td width="95%" align="left" valign="baseline">
                                                                                 <c:if test="${row1.selected_answer eq null}">
                                                                                    <form:input path="list[${optionsloop}].options"
                                                                                       onkeypress="return event.charCode >= 48 && event.charCode <= 57"
                                                                                       maxlength="1" style="width:50%;height:40px;"
                                                                                       onkeyup="saveExamStatus_ByQid(this.value,${row1.question_id},${row1.subjectid},${row1.questionrowid}); attemptcount();setColorforTextbox(${quesno},this.value);" />
                                                                                 </c:if>
                                                                                 <c:if test="${row1.selected_answer != null}">
                                                                                    <input type="hidden" value="${quesno}"
                                                                                       id="selectval_${selectedno}" />
                                                                                    <form:input path="list[${optionsloop}].options"
                                                                                       value="${row1.selected_answer}"
                                                                                       onkeypress="return event.charCode >= 48 && event.charCode <= 57"
                                                                                       maxlength="1" style="width:50%;height:40px;"
                                                                                       onkeyup="saveExamStatus_ByQid(this.value,${row1.question_id},${row1.subjectid},${row1.questionrowid}); attemptcount();" />
                                                                                    <%selectedno++;	%>
                                                                                 </c:if>
                                                                              </td>
                                                                           </tr>
                                                                        </c:if>
                                                                     </c:when>
                                                                     <c:when
                                                                        test="${row1.typeOfQuestion == 'Fill in the blanks'}">
                                                                        <c:if test="${integertypeval eq 0}">
                                                                           <tr>
                                                                              <td width="95%" align="left" valign="baseline">
                                                                                 <c:if test="${row1.selected_answer eq null}">
                                                                                    <form:input path="list[${optionsloop}].options"
                                                                                       maxlength="500" style="width:50%;height:40px;"
                                                                                       onkeyup="saveExamStatus_ByQid(this.value,${row1.question_id},${row1.subjectid},${row1.questionrowid}); attemptcount();setColorforTextbox(${quesno},this.value);" />
                                                                                 </c:if>
                                                                                 <c:if test="${row1.selected_answer != null}">
                                                                                    <input type="hidden" value="${quesno}"
                                                                                       id="selectval_${selectedno}" />
                                                                                    <form:input path="list[${optionsloop}].options"
                                                                                       value="${row1.selected_answer}"
                                                                                       maxlength="500" style="width:50%;height:40px;"
                                                                                       onkeyup="saveExamStatus_ByQid(this.value,${row1.question_id},${row1.subjectid},${row1.questionrowid}); attemptcount();" />
                                                                                    <%selectedno++;%>
                                                                                 </c:if>
                                                                              </td>
                                                                           </tr>
                                                                        </c:if>
                                                                     </c:when>
                                                                     <c:when
                                                                        test="${row1.typeOfQuestion == 'True Or False'}">
                                                                        <tr>
                                                                           <td width="95%" align="left" valign="baseline">
                                                                              <c:if test="${row1.selected_answer eq options.optionType}">
                                                                                 <input type="hidden" value="${quesno}"
                                                                                    id="selectval_${selectedno}" />
                                                                                 <input type="radio" name="list[${optionsloop}].options" value="${options.optionType}"
                                                                                    onclick="saveExamStatus_ByQid(this.value,${row1.question_id},${row1.subjectid},${row1.questionrowid}); "
                                                                                    checked="checked">
                                                                                 <%
                                                                                    selectedno++;
                                                                                    %>
                                                                              </c:if>
                                                                              <c:if
                                                                                 test="${row1.selected_answer != options.optionType}">
                                                                                 <form:radiobutton path="list[${optionsloop}].options" value="${options.optionType}"
                                                                                    onclick="saveExamStatus_ByQid(this.value,${row1.question_id},${row1.subjectid},${row1.questionrowid}); setColor(${quesno})" />
                                                                              </c:if>
                                                                              <label for="list[${optionsloop}].options">
                                                                              ${options.option} </label>
                                                                           </td>
                                                                        </tr>
                                                                     </c:when>
                                                                     <c:when
                                                                        test="${row1.typeOfQuestion == 'Reasoning Type'}">
                                                                        <tr>
                                                                           <td width="5%" style="font-weight: bold;"
                                                                              valign="baseline">${options.optionType})</td>
                                                                           <td width="95%" align="left" valign="baseline">
                                                                              <c:if
                                                                                 test="${row1.selected_answer eq options.optionType}">
                                                                                 <input type="hidden" value="${quesno}"
                                                                                    id="selectval_${selectedno}" />
                                                                                 <input type="radio"
                                                                                    name="list[${optionsloop}].options"
                                                                                    value="${options.optionType}"
                                                                                    onclick="saveExamStatus_ByQid(this.value,${row1.question_id},${row1.subjectid},${row1.questionrowid}); "
                                                                                    checked="checked">
                                                                                 <%
                                                                                    selectedno++;
                                                                                    %>
                                                                              </c:if>
                                                                              <c:if
                                                                                 test="${row1.selected_answer != options.optionType}">
                                                                                 <form:radiobutton
                                                                                    path="list[${optionsloop}].options"
                                                                                    value="${options.optionType}"
                                                                                    onclick="saveExamStatus_ByQid(this.value,${row1.question_id},${row1.subjectid},${row1.questionrowid}); setColor(${quesno})" />
                                                                              </c:if>
                                                                              <label for="list[${optionsloop}].options">
                                                                              ${options.option} </label>
                                                                           </td>
                                                                        </tr>
                                                                     </c:when>
                                                                     <c:when
                                                                        test="${row1.typeOfQuestion == 'Matrix Match'}">
                                                                        <c:set var="selectedanswer"
                                                                           value="${row1.selected_answer}" />
                                                                        <c:set var="splitanwer"
                                                                           value="${fn:split(selectedanswer, ',')}" />
                                                                        <c:set value="${options.option}" var="matrixoption"></c:set>
                                                                        <%
                                                                           String thirdSubStringspli = "";
                                                                           						String firstSubStringspli = "";
                                                                           						String secondSubStringspli = "";
                                                                           						String matrixoption = (String) pageContext.getAttribute("matrixoption");
                                                                           						String[] splitmatr = matrixoption.split("matrix_option");
                                                                           
                                                                           						firstSubStringspli = splitmatr[0];
                                                                           
                                                                           						if (splitmatr.length == 2) {
                                                                           							secondSubStringspli = splitmatr[1];
                                                                           						}
                                                                           						if (splitmatr.length == 3) {
                                                                           							secondSubStringspli = splitmatr[1];
                                                                           
                                                                           							thirdSubStringspli = splitmatr[2];
                                                                           						}
                                                                           						request.setAttribute("firstSubStringspli", firstSubStringspli);
                                                                           						request.setAttribute("secondSubStringspli", secondSubStringspli);
                                                                           						request.setAttribute("thirdSubStringspli", thirdSubStringspli);
                                                                           %>
                                                                        <c:if test="${selectedanswer!=null and selectedanswer!=''}">
                                                                           <%	matrixflag=1;%>
                                                                        </c:if>
                                                                        <%pageContext.setAttribute("matrixflag", matrixflag);%>
                                                                        <tr>
                                                                           <td >
                                                                              <table id="matrixtable" width="100%" style="right: 10; border: 1px solid #ddd;">
                                                                                 <c:if test="${(i.index)==0}">
                                                                                    <tr>
                                                                                       <td width="40%"><label>Column I </label></td>
                                                                                       <td width="40%"><label>Column II
                                                                                          </label>
                                                                                       </td>
                                                                                       <td width="20%"><label>Select
                                                                                          Answer </label>
                                                                                       </td>
                                                                                    </tr>
                                                                                 </c:if>
                                                                                 <tr>
                                                                                    <td width="40%"><label
                                                                                       for="list[${optionsloop}].options">
                                                                                       ${firstSubStringspli}</label>
                                                                                    </td>
                                                                                    <td width="40%"><label
                                                                                       for="list[${optionsloop}].options">${secondSubStringspli}</label></td>
                                                                                    <td width="20%">
                                                                                       <c:if
                                                                                          test="${(i.index)==0}">
                                                                                          <select name="list[${optionsloop}].options"
                                                                                             multiple="multiple" style="height: 100px;"
                                                                                             onchange="matrixselectval('list[${optionsloop}].options',${row1.question_id},${row1.subjectid},${row1.questionrowid});setColor(${quesno});attemptcount(${row1.subjectid});">
                                                                                             <option value="0">Select-Value</option>
                                                                                             <c:choose>
                                                                                                <c:when
                                                                                                   test="${fn:contains(row1.selected_answer, 'A-P')}">
                                                                                                   <option value="A-P" selected="selected">P</option>
                                                                                                </c:when>
                                                                                                <c:otherwise>
                                                                                                   <option value="A-P">P</option>
                                                                                                </c:otherwise>
                                                                                             </c:choose>
                                                                                             <c:choose>
                                                                                                <c:when
                                                                                                   test="${fn:contains(row1.selected_answer,'A-Q')}">
                                                                                                   <option value="A-Q" selected="selected">Q</option>
                                                                                                </c:when>
                                                                                                <c:otherwise>
                                                                                                   <option value="A-Q">Q</option>
                                                                                                </c:otherwise>
                                                                                             </c:choose>
                                                                                             <c:choose>
                                                                                                <c:when
                                                                                                   test="${fn:contains(row1.selected_answer,'A-R')}">
                                                                                                   <option value="A-R" selected="selected">R</option>
                                                                                                </c:when>
                                                                                                <c:otherwise>
                                                                                                   <option value="A-R">R</option>
                                                                                                </c:otherwise>
                                                                                             </c:choose>
                                                                                             <c:choose>
                                                                                                <c:when
                                                                                                   test="${fn:contains(row1.selected_answer,'A-S')}">
                                                                                                   <option value="A-S" selected="selected">S</option>
                                                                                                </c:when>
                                                                                                <c:otherwise>
                                                                                                   <option value="A-S">S</option>
                                                                                                </c:otherwise>
                                                                                             </c:choose>
                                                                                             <c:choose>
                                                                                                <c:when
                                                                                                   test="${fn:contains(row1.selected_answer,'A-T')}">
                                                                                                   <option value="A-T" selected="selected">T</option>
                                                                                                </c:when>
                                                                                                <c:otherwise>
                                                                                                   <option value="A-T">T</option>
                                                                                                </c:otherwise>
                                                                                             </c:choose>
                                                                                          </select>
                                                                                          <c:if test="${matrixflag==1}">
                                                                                             <input type="hidden" value="${quesno}"
                                                                                                id="selectval_${selectedno}" />
                                                                                             <%selectedno++;%>
                                                                                          </c:if>
                                                                                       </c:if>
                                                                                       <c:if test="${(i.index)==1}">
                                                                                          <select name="list[${optionsloop}].options"
                                                                                             multiple="multiple" style="height: 100px;"
                                                                                             onchange="matrixselectval('list[${optionsloop}].options',${row1.question_id},${row1.subjectid},${row1.questionrowid});attemptcount();setColor(${quesno});attemptcount(${row1.subjectid});">
                                                                                             <option value="0">Select-Value</option>
                                                                                             <c:choose>
                                                                                                <c:when
                                                                                                   test="${fn:contains(row1.selected_answer,'B-P')}">
                                                                                                   <option value="B-P" selected="selected">P</option>
                                                                                                </c:when>
                                                                                                <c:otherwise>
                                                                                                   <option value="B-P">P</option>
                                                                                                </c:otherwise>
                                                                                             </c:choose>
                                                                                             <c:choose>
                                                                                                <c:when
                                                                                                   test="${fn:contains(row1.selected_answer,'B-Q')}">
                                                                                                   <option value="B-Q" selected="selected">Q</option>
                                                                                                </c:when>
                                                                                                <c:otherwise>
                                                                                                   <option value="B-Q">Q</option>
                                                                                                </c:otherwise>
                                                                                             </c:choose>
                                                                                             <c:choose>
                                                                                                <c:when
                                                                                                   test="${fn:contains(row1.selected_answer,'B-R')}">
                                                                                                   <option value="B-R" selected="selected">R</option>
                                                                                                </c:when>
                                                                                                <c:otherwise>
                                                                                                   <option value="B-R">R</option>
                                                                                                </c:otherwise>
                                                                                             </c:choose>
                                                                                             <c:choose>
                                                                                                <c:when
                                                                                                   test="${fn:contains(row1.selected_answer,'B-S')}">
                                                                                                   <option value="B-S" selected="selected">S</option>
                                                                                                </c:when>
                                                                                                <c:otherwise>
                                                                                                   <option value="B-S">S</option>
                                                                                                </c:otherwise>
                                                                                             </c:choose>
                                                                                             <c:choose>
                                                                                                <c:when
                                                                                                   test="${fn:contains(row1.selected_answer,'B-T')}">
                                                                                                   <option value="B-T" selected="selected">T</option>
                                                                                                </c:when>
                                                                                                <c:otherwise>
                                                                                                   <option value="B-T">T</option>
                                                                                                </c:otherwise>
                                                                                             </c:choose>
                                                                                          </select>
                                                                                       </c:if>
                                                                                       <c:if test="${(i.index)==2}">
                                                                                          <select name="list[${optionsloop}].options"
                                                                                             multiple="multiple" style="height: 100px;"
                                                                                             onchange="matrixselectval('list[${optionsloop}].options',${row1.question_id},${row1.subjectid},${row1.questionrowid});attemptcount();setColor(${quesno});attemptcount(${row1.subjectid});">
                                                                                             <option value="0">Select-Value</option>
                                                                                             <c:choose>
                                                                                                <c:when
                                                                                                   test="${fn:contains(row1.selected_answer,'C-P')}">
                                                                                                   <option value="C-P" selected="selected">P</option>
                                                                                                </c:when>
                                                                                                <c:otherwise>
                                                                                                   <option value="C-P">P</option>
                                                                                                </c:otherwise>
                                                                                             </c:choose>
                                                                                             <c:choose>
                                                                                                <c:when
                                                                                                   test="${fn:contains(row1.selected_answer,'C-Q')}">
                                                                                                   <option value="C-Q" selected="selected">Q</option>
                                                                                                </c:when>
                                                                                                <c:otherwise>
                                                                                                   <option value="C-Q">Q</option>
                                                                                                </c:otherwise>
                                                                                             </c:choose>
                                                                                             <c:choose>
                                                                                                <c:when
                                                                                                   test="${fn:contains(row1.selected_answer,'C-R')}">
                                                                                                   <option value="C-R" selected="selected">R</option>
                                                                                                </c:when>
                                                                                                <c:otherwise>
                                                                                                   <option value="C-R">R</option>
                                                                                                </c:otherwise>
                                                                                             </c:choose>
                                                                                             <c:choose>
                                                                                                <c:when
                                                                                                   test="${fn:contains(row1.selected_answer,'C-S')}">
                                                                                                   <option value="C-S" selected="selected">S</option>
                                                                                                </c:when>
                                                                                                <c:otherwise>
                                                                                                   <option value="C-S">S</option>
                                                                                                </c:otherwise>
                                                                                             </c:choose>
                                                                                             <c:choose>
                                                                                                <c:when
                                                                                                   test="${fn:contains(row1.selected_answer,'C-T')}">
                                                                                                   <option value="C-T" selected="selected">T</option>
                                                                                                </c:when>
                                                                                                <c:otherwise>
                                                                                                   <option value="C-T">T</option>
                                                                                                </c:otherwise>
                                                                                             </c:choose>
                                                                                          </select>
                                                                                       </c:if>
                                                                                       <c:if test="${(i.index)==3}">
                                                                                          <select name="list[${optionsloop}].options"
                                                                                             multiple="multiple" style="height: 100px;"
                                                                                             onchange="matrixselectval('list[${optionsloop}].options',${row1.question_id},${row1.subjectid},${row1.questionrowid});attemptcount();setColor(${quesno});attemptcount(${row1.subjectid});">
                                                                                             <option value="0">Select-Value</option>
                                                                                             <c:choose>
                                                                                                <c:when
                                                                                                   test="${fn:contains(row1.selected_answer,'D-P')}">
                                                                                                   <option value="D-P" selected="selected">P</option>
                                                                                                </c:when>
                                                                                                <c:otherwise>
                                                                                                   <option value="D-P">P</option>
                                                                                                </c:otherwise>
                                                                                             </c:choose>
                                                                                             <c:choose>
                                                                                                <c:when
                                                                                                   test="${fn:contains(row1.selected_answer,'D-Q')}">
                                                                                                   <option value="D-Q" selected="selected">Q</option>
                                                                                                </c:when>
                                                                                                <c:otherwise>
                                                                                                   <option value="D-Q">Q</option>
                                                                                                </c:otherwise>
                                                                                             </c:choose>
                                                                                             <c:choose>
                                                                                                <c:when
                                                                                                   test="${fn:contains(row1.selected_answer,'D-R')}">
                                                                                                   <option value="D-R" selected="selected">R</option>
                                                                                                </c:when>
                                                                                                <c:otherwise>
                                                                                                   <option value="D-R">R</option>
                                                                                                </c:otherwise>
                                                                                             </c:choose>
                                                                                             <c:choose>
                                                                                                <c:when
                                                                                                   test="${fn:contains(row1.selected_answer,'D-S')}">
                                                                                                   <option value="D-S" selected="selected">S</option>
                                                                                                </c:when>
                                                                                                <c:otherwise>
                                                                                                   <option value="D-S">S</option>
                                                                                                </c:otherwise>
                                                                                             </c:choose>
                                                                                             <c:choose>
                                                                                                <c:when
                                                                                                   test="${fn:contains(row1.selected_answer,'D-T')}">
                                                                                                   <option value="D-T" selected="selected">T</option>
                                                                                                </c:when>
                                                                                                <c:otherwise>
                                                                                                   <option value="D-T">T</option>
                                                                                                </c:otherwise>
                                                                                             </c:choose>
                                                                                          </select>
                                                                                       </c:if>
                                                                                    </td>
                                                                                 </tr>
                                                                                 <c:if test="${(i.index)==3}">
                                                                                    <c:if test="${thirdSubStringspli != ''}">
                                                                                       <tr>
                                                                                          <td width="40%"><label
                                                                                             for="list[${optionsloop}].options"></label></td>
                                                                                          <td width="40%"><label for="list[${optionsloop}].options">	${thirdSubStringspli}</label></td>
                                                                                          <td width="20%"></td>
                                                                                       </tr>
                                                                                    </c:if>
                                                                                 </c:if>
                                                                              </table>
                                                                           </td>
                                                                        </tr>
                                                                     </c:when>
                                                                     <c:when
                                                                        test="${row1.typeOfQuestion == 'Comprehension'}">
                                                                        <tr>
                                                                           <td width="5%" style="font-weight: bold;"
                                                                              valign="baseline">${options.optionType})</td>
                                                                           <td width="95%" align="left" valign="baseline">
                                                                              <c:if
                                                                                 test="${row1.selected_answer eq options.optionType}">
                                                                                 <input type="hidden" value="${quesno}"
                                                                                    id="selectval_${selectedno}" />
                                                                                 <input type="radio"
                                                                                    name="list[${optionsloop}].options"
                                                                                    value="${options.optionType}"
                                                                                    onclick="saveExamStatus_ByQid(this.value,${row1.question_id},${row1.subjectid},${row1.questionrowid}); "
                                                                                    checked="checked">
                                                                                 <%
                                                                                    selectedno++;
                                                                                    %>
                                                                              </c:if>
                                                                              <c:if
                                                                                 test="${row1.selected_answer != options.optionType}">
                                                                                 <form:radiobutton
                                                                                    path="list[${optionsloop}].options"
                                                                                    value="${options.optionType}"
                                                                                    onclick="saveExamStatus_ByQid(this.value,${row1.question_id},${row1.subjectid},${row1.questionrowid});  setColor(${quesno})" />
                                                                              </c:if>
                                                                              <label for="list[${optionsloop}].options">
                                                                              ${options.option} </label>
                                                                           </td>
                                                                        </tr>
                                                                     </c:when>
                                                                  </c:choose>
                                                               </TABLE>
                                                            </td>
                                                         </tr>
                                                         <%integertypeval++;	%>
                                                      </c:forEach>
                                                      <tr>
                                                         <td>
                                                            <div class="row"></div>
                                                         </td>
                                                      </tr>
                                                      <tr>
                                                         <td colspan="2">
                                                            <form:hidden
                                                               path="list[${loop.index}].bquestion_id"
                                                               id="bquestion_id" value="${row1.question_id}" />
                                                            <%-- Question ID: ${row1.question_id} --%>
                                                         </td>
                                                      </tr>
                                                      <!-- <div id="log"></div> -->
                                                   </table>
                                                </div>
                                             </div>
                                             <div class="footerbtngrup1">
                                                <div id="btnfooter"
                                                   style="background-color: rgb(255, 255, 255);">
                                                   <span
                                                      style="text-align: left; float: left; padding-right: 20px;">
                                                   <input type="button" class="btn btn-default"
                                                      value="Mark for Review" title="Mark for Review"
                                                      id="mark_${quesno}"
                                                      onclick="markAsReviewAndAttempted('list[${optionsloop}].options',${quesno},${row1.subjectid},${row1.question_id},${row1.questionrowid});">
                                                   </span> <span
                                                      style="text-align: left; float: left; padding-right: 20px;">
                                                   <input type="button" class="btn btn-default"
                                                      value="Bookmark" title="Bookmark"
                                                      id="${row1.question_id}"
                                                      onclick="insertBookmarkID(${row1.question_id}, <%=bookmarkqutoInc%>,${subrow.subjectid});">
                                                   </span> <span style="text-align: left; float: left;"> <input
                                                      type="button" class="btn btn-default"
                                                      value="Clear Response" title="Clear Response"
                                                      onclick="removeRadiobuttonSelection('list[${optionsloop}].options',${row1.question_id},${row1.subjectid},${row1.questionrowid},${quesno},'#101010');">
                                                   </span> <span
                                                      style="text-align: right; float: right; padding-right: 75px;">
                                                   <input type="button" id="popup"
                                                      class="normalBtn btn btn-info" value="Submit"
                                                      title="Submit" onclick="return finish_div_show();">
                                                   </span>
                                                </div>
                                             </div>
                                             <div class="" style="width: 100%">
                                                <table width="100%">
                                                   <tr>
                                                      <td colspan="3" align="center"
                                                         id="<%=bookmarkqutoInc%>"
                                                         style="color: blue; font-weight: bold;" align="center">
                                                      </td>
                                                   </tr>
                                                </table>
                                                <%
                                                   quesno++;
                                                   %>
                                             </div>
                                          </td>
                                       </tr>
                                       <%
                                          bookmarkqutoInc++; optionsloop++;paginationsno1++;
                                          %>
                                    </TABLE>
                                 </div>
                              </div>
                           </c:forEach>
                           <%
                              temp1 = temp1.substring(0, temp1.length() - 1);
                              %>
                           <script type="text/javascript">
                              var tempval=<%=tempval%>;
                              
                              var gallery4=new virtualpaginate({
                              piececlass: 'virtualpage'+tempval,
                              piececontainer: 'div',
                              pieces_per_page: 1,
                              defaultpage: 0,
                              wraparound: false,
                              persist: true
                              })
                              
                              gallery4.buildpagination(["galleryalt_<%=tempval%>"],[<%=temp1%>])
                              
                           </script>
                        </div>
                     </c:otherwise>
                  </c:choose>
                  <%
                     tempval++;
                     %>
               </c:forEach>
            </div>
         </form:form>
      </main>
      <div class="footer1">
         <font
            style="color: white; text-align: center; line-height: 28px; display: block;">
         Developed by Chiselon Technologies Pvt Ltd.</font>
      </div>
      <script>
         $('.item span').hide();
         
         $('.item a').click(function(e){
             
             e.preventDefault();
             // hide all span
             var $this = $(this).parent().find('span');
             $(".item span").not($this).hide();
             
             // here is what I want to do
             $this.toggle();
             
         });
      </script>
      <c:if test="${msg==null}">
         <%@include file="resumefinishmodel.jsp" %>
      </c:if>
      <div id="myModal3" class="modal3">
         <!-- Modal content -->
         <div class="modal-content3">
            <div class="modal-header">
               <p style="text-align: center;font-weight: bold;font-size: 18px;text-decoration: underline;">Exam Instructions <button style="float: right;" title="close" type="button" class="close3" id="test1">&times</button></p>
               <br>
               <p style="font-weight:bold;text-decoration: underline; ">Read the following instructions carefully  
               </p>
            </div>
            <!-- Modal body -->
            <div class="modal-body">
               <div><label id="results"></label></div>
               <div >
                  <p>1.Total duration of the examination is <label>${examtime} HOURS</label>.</p>
                  <p>2.The clock will be set at the server. The countdown timer at the top, right-hand side of the screen will display the time available for you to complete the examination. When the timer reaches zero, the examination will end automatically. You will not be required to end or submit your examination..</p>
                  <p>3.The Question Palette displayed on the right-hand side of the screen will show the status of each question using one of the following symbols:</p>
                  <span class="collapse_icon"></span>
                  <div class="diff_type_notation_area_outer">
                     <div class="diff_type_notation_area_inner">
                        <div class="notation_type_description">
                           <p><span class="not_visited notVisitedCount">N</span> <span class="type_title notVisitedLabel longtext-hide" id="" title="Not Visited">This question has not been answered yet.</span></p>
                           <br>
                           <p><span class="not_answered notAnsweredCount">V</span> <span class="type_title notAnsweredLabel longtext-hide" id="" title="Not Answered">This question has been visited but not answered.</span></p>
                           <br>
                           <p><span class="answered answeredCount" >A</span> <span class="type_title answeredLabel longtext-hide" id="" title="Answered">This question has been answered and will be considered for evaluation.</span></p>
                           <br>
                           <p><span class="review markedCount" >0</span> <span class="type_title markedLabel longtext-hide" id="" title="Marked for Review">This question has been marked for review and has not been answered.</span></p>
                           <br>
                           <p><span class="review_marked markedReviewCount" >0</span><span class="type_title markedAndAnsweredLabel" id="" title="Answered &amp; Marked for Review">This question has been marked for review and has been answered.</span></p>
                           <br>
                        </div>
                     </div>
                  </div>
                  <p style="font-weight: bold;text-decoration: underline;">
                     Navigating to a Question:
                  </p>
                  <p>4.Click on the question number in the Question Palette to go to that particular question directly.</p>
                  <p>5.You can view all the questions by clicking on the Question Paper button that appears at top, right-hand side of the screen.</p>
                  <p style="font-weight: bold;text-decoration: underline;">Answering a Question :</p>
                  <p><b>Procedure for answering a multiple choice type question (MCQ) :</b></p>
                  <p>a.To select your answer, click on the button of the corresponding option.</p>
                  <p>b.To deselect your chosen answer, click on the button of the chosen option once again or click on the Clear Response button.</p>
                  <p>c.To change your chosen answer, click on the button of the newly identified answer.</p>
                  <p><b>Procedure for answering a numerical answer type (NAT) question:</b></p>
                  <p>a.To enter a numerical answer, use the virtual numeric keypad that appears below the question.</p>
                  <p>b.A fractional number in the decimal notation (e.g. -0.3 or -.3) can be entered as an answer with or without '0' before the decimal point.</p>
                  <p>c.To clear your answer, click on the Clear Response button.</p>
                  <p style="font-weight: bold;text-decoration: underline;">Saving your answer:</p>
                  <p>7.To save your answer, You just need to select the answer it will be saved.</p>
                  <p>8.After the elapse of time scheduled for the examination, all the answers (including those Answered and Marked for Review) will be automatically submitted.</p>
                  <p style="font-weight: bold;text-decoration: underline;">Navigating through sections:</p>
                  <p>9.Sections in this question paper are displayed above the Question Area. Questions in a section can be viewed by clicking on the section name. The section you are currently viewing is highlighted.</p>
                  <p>10.clicking on move to next subject you will navigate to that page.</p>
                  <p>11.You can shuffle between sections and questions anytime during the examination.</p>
                  <p>12.You can see the section summary as a part of the legend appearing above the Question Palette of every section.</p>
               </div>
               <div id="tetpattern_${packageloop.index}"  style="display: none">
                  <p>1.Total TET duration of the examination is 180 minutes. Calculator is available on top, right-hand side of the screen.</p>
                  <p>2.The clock will be set at the server. The countdown timer at the top, right-hand side of the screen will display the time available for you to complete the examination. When the timer reaches zero, the examination will end automatically. You will not be required to end or submit your examination..</p>
                  <p>3.The Question Palette displayed on the right-hand side of the screen will show the status of each question using one of the following symbols:</p>
                  <p><a href="#" class="notansweredbtn" id="notansweredbtn">1</a>This question has not been answered yet.</p>
                  <p><a href="#" class="notansweredvisitedbtn" id="notansweredvisitedbtn" style="background-color: red;color:white;">2</a>This question has been visited but not answered. </p>
                  <p><a href="#" class="answeredbtn" id="answeredbtn" style="background-color: #29D28A;color:white;">3</a>This question has been answered and will be considered for evaluation.</p>
                  <p><a href="#" class="markforreviewansw" id="markforreviewansw" style="background-color: #714F91;color:white;">4</a>This question has been marked for review and has been answered.</p>
                  <p><a href="#" class="currentques" id="currentques" style="background-color: #4E85C5;color:white;">5</a>This question is currently viewing.</p>
                  <p><a href="#" class="markforreview" id="markforreview">6</a>This question has been marked for review and has not been answered.</p>
                  <p style="font-weight: bold;text-decoration: underline;">
                     Navigating to a Question:
                  </p>
                  <p>4.Click on the question number in the Question Palette to go to that particular question directly.</p>
                  <p>5.You can view all the questions by clicking on the Question Paper button that appears at top, right-hand side of the screen.</p>
                  <p style="font-weight: bold;text-decoration: underline;">Answering a Question :</p>
                  <p><b>Procedure for answering a multiple choice type question (MCQ) :</b></p>
                  <p>a.To select your answer, click on the button of the corresponding option.</p>
                  <p>b.To deselect your chosen answer, click on the button of the chosen option once again or click on the Clear Response button.</p>
                  <p>c.To change your chosen answer, click on the button of the newly identified answer.</p>
                  <p><b>Procedure for answering a numerical answer type (NAT) question:</b></p>
                  <p>a.To enter a numerical answer, use the virtual numeric keypad that appears below the question.</p>
                  <p>b.A fractional number in the decimal notation (e.g. -0.3 or -.3) can be entered as an answer with or without '0' before the decimal point.</p>
                  <p>c.To clear your answer, click on the Clear Response button.</p>
                  <p style="font-weight: bold;text-decoration: underline;">Saving your answer:</p>
                  <p>7.To save your answer, You just need to select the answer it will be saved.</p>
                  <p>8.After the elapse of time scheduled for the examination, all the answers (including those Answered and Marked for Review) will be automatically submitted.</p>
                  <p style="font-weight: bold;text-decoration: underline;">Navigating through sections:</p>
                  <p>9.Sections in this question paper are displayed above the Question Area. Questions in a section can be viewed by clicking on the section name. The section you are currently viewing is highlighted.</p>
                  <p>10.clicking on move to next subject you will navigate to that page.</p>
                  <p>11.You can shuffle between sections and questions anytime during the examination.</p>
                  <p>12.You can see the section summary as a part of the legend appearing above the Question Palette of every section.</p>
               </div>
            </div>
            <center><button style="text-align: center;" type="button" class="close3" id="btntest">CLOSE  </button> </center>
         </div>
      </div>
      <!-- Instruction Modal -->
      <!--Display all Questions in The Modal -->
      <%@include file="resumefullquestionpapermodel.jsp" %>
      <div class="modal fade" id="basicModal" tabindex="-1" role="dialog"
         aria-labelledby="basicModal" aria-hidden="true">
         <div class="modal-dialog">
            <div class="modal-content" style="width: 200px;">
               <!--        <div class="modal-header">
                  <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                  </div> -->
               <div class="modal-body">
                  <h4 class="modal-title" id="questions"></h4>
               </div>
               <div class="modal-footer">
                  <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
               </div>
            </div>
         </div>
      </div>
      <script>
         //Get the modal
          var modal = document.getElementById('myModal3');
         
          // Get the button that opens the modal
          // Get the <span> element that closes the modal
          var span = document.getElementsByClassName("close3")[0];
         
          // When the user clicks the button, open the modal 
          var btntest = document.getElementById("btntest");
          var btntest1 = document.getElementById("test1");
         
         
          btntest.onclick=function(){
         
          	modal.style.display = "none";	
          }
          btntest1.onclick=function(){
          	modal.style.display = "none";	
          }
         
         
         
         
          //Get the button that opens the modal
          var modal1 = document.getElementById('myModal4');
         
          //When the user clicks the button, open the modal 
          var btntestc1 = document.getElementById("close21");
          var btntestc2 = document.getElementById("close31");
         
         
          btntestc1.onclick=function(){
          	modal1.style.display = "none";	
          }
          btntestc2.onclick=function(){
          	modal1.style.display = "none";	
          }
         
             
      </script>
      <script>
         <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js">
      </script>
      <!-- Include all compiled plugins (below), or include individual files as needed -->
      <script
         src="http://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.4/js/bootstrap.min.js"></script>
   </body>
</html>