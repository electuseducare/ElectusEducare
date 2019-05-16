<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>    
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <%@include file="DisplayLogo.jsp" %>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>All India Marks Analysis</title>
      <%@include file="adminDataTableForReports1.jsp" %>
   </head>
   <body>
      <%@include file="adminUserTopMenu.jsp" %>
      <%@include file="adminUserHeader.jsp" %> 
      <div style="width:5%; float:left; background-color: #ffffff;"> &nbsp; </div>
      <div style="width:90%; float:left; background-color: #ffffff">
         <legend style="text-align: center;">All India_Marks_Analysis</legend>
         <table id="studentmarks" class="table table-bordered table-striped nowrap" cellspacing="0" width="100%" style="text-align: center;">
            <thead>
               <tr>
                  <th >S.NO  </th>
                  <th >S#ID  </th>
                  <th >Username  </th>
                  <th > S.Name </th>
                  <th > Section </th>
                  <c:forEach items="${model1.subjects}" var="subjects" varStatus="loop">
                     <th>
                        ${subjects.subjectname} / ( ${subjects.subjecttotalmarks} )
                        <c:set var="totalmarks" value="${subjects.totalmarks}"></c:set>
                     </th>
                     <th>${subjects.subjectname}_%</th>
                     <th>${subjects.subjectname}_Rank </th>
                  </c:forEach>
                  <th >Total/${totalmarks}</th>
                  <th >%</th>
                  <th >AIR Rank</th>
                  <th >State Rank</th>
                  <th >Campus Rank</th>
                  <th >Sec Rank</th>
                  <th >Campus</th>
               </tr>
            </thead>
            <tbody>
               <c:forEach items="${model1.allDetails}" var="sturesults1" varStatus="loop">
                  <c:set var="smarks" value="${sturesults1.scoredmarks1}"></c:set>
                  <c:set var="tmarks" value="${sturesults1.subttlmarks}"></c:set>
                  <%
                     String smarks1= (String) pageContext.getAttribute("smarks");
                     float smarks=Float.valueOf(smarks1);
                     int tmarks= (Integer) pageContext.getAttribute("tmarks");
                     float mpercentage = (float) ((smarks*100)/tmarks);
                     pageContext.setAttribute("mpercentage", mpercentage);
                     %>
                  <tr>
                     <td >${loop.index+1}</td>
                     <td >${sturesults1.studentid}</td>
                     <td >${sturesults1.username}</td>
                     <td >${sturesults1.studentname}</td>
                     <td >${sturesults1.sectionname}</td>
                     <td >${sturesults1.scoredmarks1}</td>
                     <td >
                        <fmt:formatNumber type="number" maxFractionDigits="2" value="${mpercentage}"/>
                     </td>
                     <td >${sturesults1.subject_rank1}</td>
                     <c:forEach items="${sturesults1.ltoatlamarks}" var="totalmarks" varStatus="loop">
                        <td> ${totalmarks} </td>
                        <c:forEach items="${sturesults1.lsub_percentage}" var="sub_percentage" begin="${loop.index}" end="${loop.index}">
                           <td>
                              <fmt:formatNumber type="number" maxFractionDigits="2" value="${sub_percentage}"/>
                           </td>
                        </c:forEach>
                        <c:forEach items="${sturesults1.lsubrank}" var="submarks" begin="${loop.index}" end="${loop.index}">
                           <td> ${submarks} </td>
                        </c:forEach>
                     </c:forEach>
                     <td >${sturesults1.sub_totalmarks}</td>
                     <td >${sturesults1.total_percentage}</td>
                     <td >${sturesults1.allindiarank}</td>
                     <td >${sturesults1.staterank}</td>
                     <td >${sturesults1.campusrank}</td>
                     <td >${sturesults1.sectionrank}</td>
                     <td >${sturesults1.campusname}</td>
                  </tr>
               </c:forEach>
            </tbody>
         </table>
      </div>
      <script>
         
         $(document).ready(function() {
             var buttonCommon = {
                 exportOptions: {
                     format: {
                         body: function ( data, row, column, node ) {
                             // Strip $ from salary column to make it numeric
                             return column === 5 ?
                                 data.replace( /[$,]/g, '' ) :
                                 data;
                         }
                     }
                 }
             };
          
             $('#studentmarks').DataTable( {
               
                 dom: 'Bfrtip',
                 buttons: [
                 
                     $.extend( true, {}, buttonCommon, {
                         extend: 'copyHtml5'
                     } ),
                     $.extend( true, {}, buttonCommon, {
                         extend: 'excelHtml5'
                     } ),
                     $.extend( true, {}, buttonCommon, {
                         extend: 'pdfHtml5',
                         orientation: 'landscape',
                         pageSize: 'LEGAL'
                     } ),
                     $.extend( true, {}, buttonCommon, {
                         extend: 'print',
                         orientation: 'landscape',
                         	pageSize: 'LEGAL'
                     } ),'colvis'
                
                 ],
             columnDefs: [ {
                 targets: -1,
                 visible: false
             } ]
             } );
         } );
      </script>
      <center> <button onclick="history.back();" style="cursor: pointer; background-color: aqua; height: 30px">Back to Reports</button></center>
      <div style="width:5%; float:left; background-color: #ffffff;"> &nbsp; </div>
   </body>
</html>