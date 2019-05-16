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
      <div id="filenamesmodel" class="modal" style="display: none">
         <!-- Modal content -->
         <div class="modal-content">
            <span id="filenamesclose" class="closebtn" onclick="closefilenamesmodel();"><strong >CLOSE</strong></span>
            <p><strong>Please select at least one Filename</strong></p>
         </div>
      </div>
      <div id="noofmarkstypemodal" class="modal" style="display: none">
         <!-- Modal content -->
         <div class="modal-content">
            <span id="noofmarksclose" class="closebtn" onclick="closenoofmarkstypemodal();"><strong >CLOSE</strong></span>
            <p><strong>Please enter number of marks per Subject / per Question type. It should be greater than zero.</strong></p>
         </div>
      </div>
      <div id="noofnegmarkstypemodal" class="modal" style="display: none">
         <!-- Modal content -->
         <div class="modal-content">
            <span id="noofmarksclose" class="closebtn" onclick="closenoofnegmarkstypemodal();"><strong >CLOSE</strong></span>
            <p><strong>Please enter negative marks per Subject / per Question type. It should be zero or greater than zero.</strong></p>
         </div>
      </div>
      <div id="positivemarksmadel" class="modal" style="display: none">
         <!-- Modal content -->
         <div class="modal-content">
            <span id="postivemarksclose" class="closebtn" onclick="closepoistivemarksmodel();"><strong >CLOSE</strong></span>
            <p><strong>Please enter positive marks. It should be greater than zero</strong></p>
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