<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <%@include file="DisplayLogo.jsp" %>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   </head>
   <body>
      <!-- Validations Modal Windows -->
      <div id="examnamemodel" class="modal" style="display: none">
         <!-- Modal content -->
         <div class="modal-content">
            <span id="examnamemodelclose" class="closebtn" onclick="closeexamnamemodelwindow();"><strong >CLOSE</strong></span>
            <p><strong>Please Enter Exam Name</strong></p>
         </div>
      </div>
      <div id="examtypemodel" class="modal" style="display: none">
         <!-- Modal content -->
         <div class="modal-content">
            <span id="examtypemodelclose" class="closebtn" onclick="closeexamtypemodelwindow();"><strong >CLOSE</strong></span>
            <p><strong>Please select at least one exam type</strong></p>
         </div>
      </div>
      <div id="examnameexistmodel" class="modal" style="display: none">
         <!-- Modal content -->
         <div class="modal-content">
            <span id="examnameexistmodelclose" class="closebtn" onclick="closeexamnameexistmodelwindow();"><strong >CLOSE</strong></span>
            <p><strong>Please Enter valid exam name. Entered exam name is already exists.</strong></p>
         </div>
      </div>
      <div id="selectedexamnameexistmodel" class="modal" style="display: none">
         <!-- Modal content -->
         <div class="modal-content">
            <span id="selectedexamnameexistmodelclose" class="closebtn" onclick="closeselectedexamnameexistmodelwindow();"><strong >CLOSE</strong></span>
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
      <div id="questionlevelmodel" class="modal" style="display: none">
         <!--   Modal content -->
         <div class="modal-content">
            <span id="questionlevelmodelclose" class="closebtn" onclick="closequestionlevelmodelwindow();"><strong >CLOSE</strong></span>
            <p><strong>Please select at least one Question level</strong></p>
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
      <div id="noofqnspersubjmodal" class="modal" style="display: none">
         <!-- Modal content -->
         <div class="modal-content">
            <span id="noofqnspersubjclose" class="closebtn" onclick="closenoofqnspersubjmodel();"><strong >CLOSE</strong></span>
            <p><strong>Please enter valid number of questions per subject</strong></p>
         </div>
      </div>
      <div id="topicmodal" class="modal" style="display: none">
         <!-- Modal content -->
         <div class="modal-content">
            <span id="topicsclose" class="closebtn" onclick="closetopicsmodel();"><strong >CLOSE</strong></span>
            <p><strong>Please select at least one topic check box / If no topics available please add topic for that subject.</strong></p>
         </div>
      </div>
      <div id="subtopicmodal" class="modal" style="display: none">
         <!-- Modal content -->
         <div class="modal-content">
            <span id="subtopicsclose" class="closebtn" onclick="closesubtopicsmodel();"><strong >CLOSE</strong></span>
            <p><strong>Please select at least one sub topic check box / If no sub topics available please add sub topic for that topic.</strong></p>
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
            <span id="marksclose" class="closebtn" onclick="closemarkstypemodel();"><strong >CLOSE</strong></span>
            <p><strong>Please enter number of marks per question type</strong></p>
         </div>
      </div>
      <div id="negmarksmodalperqt" class="modal" style="display: none">
         <!-- Modal content -->
         <div class="modal-content">
            <span id="negmarksclose" class="closebtn" onclick="closenegmarkstypemodel();"><strong >CLOSE</strong></span>
            <p><strong>Please enter negative marks per question type</strong></p>
         </div>
      </div>
      <div id="marksperqnmodal" class="modal" style="display: none">
         <!-- Modal content -->
         <div class="modal-content">
            <span id="marksperqnclose" class="closebtn" onclick="closemarksperqnmodel();"><strong >CLOSE</strong></span>
            <p><strong>Please enter marks per question</strong></p>
         </div>
      </div>
      <div id="qnsandqtypeqnsnotmatchedmodal" class="modal" style="display: none">
         <!-- Modal content -->
         <div class="modal-content">
            <span id="qnsandqtypeqnsnotmatchedclose" class="closebtn" onclick="closeqnsandqtypeqnsnotmatchedmodel();"><strong >CLOSE</strong></span>
            <p><strong>No.of Subject Questions and No.of Question Type Questions are not matched</strong></p>
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
      <div id="startltmodal" class="modal" style="display: none">
         <!-- Modal content -->
         <div class="modal-content">
            <span id="startltmodalclose" class="closebtn" onclick="closestartltmodel();"><strong >CLOSE</strong></span>
            <p><strong> Start Date should not be past date  </strong></p>
         </div>
      </div>
      <div id="startltendatemodal" class="modal" style="display: none">
         <!-- Modal content -->
         <div class="modal-content">
            <span id="startltendateclose" class="closebtn" onclick="closestartltendatemodel();"><strong >CLOSE</strong></span>
            <p><strong> End Date should not be less than Start Date </strong></p>
         </div>
      </div>
      <div id="negativeintestdurationmodal" class="modal" style="display: none">
         <!-- Modal content -->
         <div class="modal-content">
            <span id="negativeintestdurationclose" class="closebtn" onclick="closenegativeintestdurationmodel();"><strong >CLOSE</strong></span>
            <p><strong> Please enter valid start date/time and end date/time  </strong></p>
         </div>
      </div>
      <div id="zerointestdurationmodal" class="modal" style="display: none">
         <!-- Modal content -->
         <div class="modal-content">
            <span id="zerointestdurationclose" class="closebtn" onclick="zerointestdurationmodel();"><strong >CLOSE</strong></span>
            <p><strong> Test Duration should be greater than "00:00:00" </strong></p>
         </div>
      </div>
   </body>
</html>