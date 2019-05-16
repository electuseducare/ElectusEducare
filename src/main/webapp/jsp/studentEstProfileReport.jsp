<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>Student Profile Estimate </title>
      <%@include file="adminDataTableForReports.jsp" %>
      <script type="text/javascript" src="jquery.print.js"></script>
      <style type="text/css">
         body {
         padding:30px;
         }
         @media print {
         .panel-heading {
         display:none
         }
         #toptabs {
         display:none
         }
         #printbutton {
         display:none
         }
         }
      </style>
   </head>
   <body>
      <%@include file="adminUserTopMenu.jsp" %>
      <%@include file="adminUserHeader.jsp" %> 
      <div class="row"> </div>
      <div class="container">
         <div style="width:100%; float:left; background-color: #ffffff">
            <ul class="nav nav-tabs" id="toptabs">
               <li ><a href="load-studentmarksprofilesearch" >SEARCH STUDENT PROFILE</a></li>
               <li class="active"><a href="#" >VIEW STUDENT PROFILE</a></li>
            </ul>
            <div class="panel-heading" style="background-color:#ccf2ff;color:black; font-weight: bold;">
               <a href="load-studentmarksprofilesearch">
               <img border="0" id="printpage" alt="assicon" src="${pageContext.request.contextPath}/theme/images/addicon.jpg" width="40" height="40" style="background-color: skyblue;">
               BACK TO STUDENT SEARCH</a>
            </div>
            <div  id="printdiv" class="printable" style="text-align: right;">
               <button class="btn-primary  btn-default" id="printbutton"> <span class="glyphicon glyphicon-print" aria-hidden="true"></span>Print</button>
               <div class="col-md-12 col-sm-12" id="printdata">
                  <div style="text-align: center;">
                     <%
                        clientlogo=(String)session.getAttribute("clientlogo1");
                        pageContext.setAttribute("clientlogo", clientlogo);
                        %>
                     <c:set value="${clientlogo}" var="clientlogo"></c:set>
                     <c:choose>
                        <c:when test="${clientlogo=='0' || clientlogo==''}">
                        </c:when>
                        <c:otherwise>
                           <a  href="load-AdminDashboard">  <img src="${pageContext.request.contextPath}/viewClientimage?imageID=<%=session.getAttribute("clientlogo1")%>" class=""  height="60" width="230" alt="logo" /></a>
                        </c:otherwise>
                     </c:choose>
                     <%-- <img border="0" alt="W3Schools" src="${pageContext.servletContext.contextPath }/ViewImage?imageID=viswasailogo.png"  > --%>
                  </div>
                  <table id="studentinfo" class="table table-bordered table-striped nowrap" cellspacing="0" width="100%" style="text-align: center;">
                     <tr>
                        <th>Name      :${stuname}</th>
                        <th>Exam Type :${examtype}</th>
                        <th>ID		 :${username}</th>
                        <th>Class	 :${classname}</th>
                     </tr>
                     <tr>
                        <th>Section 	 :${sectioname}</th>
                        <th>State 	 :${statename}</th>
                        <th>Location  :${locationname}</th>
                        <th>Branch    :${branchname}</th>
                     </tr>
                     <tr>
                        <td colspan="4">
                           <table id="studentmarks" class="table table-bordered table-striped nowrap" cellspacing="0" width="100%" style="text-align: center;">
                              <thead>
                                 <tr>
                                    <th style="text-align: center;">S.NO  </th>
                                    <th style="text-align: center;">Date  </th>
                                    <c:forEach items="${model1.subjects}" var="subjects" varStatus="loop">
                                       <th style="text-align: center;">${subjects.subjectname}</th>
                                    </c:forEach>
                                    <th style="text-align: center;"> Total </th>
                                    <th style="text-align: center;"> Rank </th>
                                 </tr>
                              </thead>
                              <tbody>
                                 <c:forEach items="${model1.catlist}" var="sturesults" varStatus="loop">
                                    <tr>
                                       <td>${loop.index+1}</td>
                                       <td>
                                          <c:set var = "nowvalue" value = "${fn:split(sturesults.examdate, '-')}" />
                                          <c:set var = "nowvalues" value = "${nowvalue[2]}-${nowvalue[1]}-${nowvalue[0]}" />
                                          ${nowvalues}
                                       </td>
                                       <td> ${sturesults.scoredmarks} </td>
                                       <c:forEach items="${sturesults.subscoremarkslist}" var="totalmarks" varStatus="loop">
                                          <td> ${totalmarks} </td>
                                       </c:forEach>
                                       <td> ${sturesults.examtotalmarks} </td>
                                       <td> ${sturesults.examwiserank} </td>
                                    </tr>
                                 </c:forEach>
                                 <tr>
                                    <td>TOTAL </td>
                                    <td style="font-weight: bold">Average</td>
                                    <c:forEach items="${adlist}" var="avglist" varStatus="loop1">
                                       <c:forEach items="${avglist.avgmarkslist}" var="avglist1" varStatus="loop1">
                                          <td style="font-weight: bold">
                                             <fmt:formatNumber type="number" minFractionDigits="2" value="${avglist1}" />
                                          </td>
                                       </c:forEach>
                                    </c:forEach>
                                    <td style="font-weight: bold">
                                       <fmt:formatNumber type="number" minFractionDigits="2" value="${totalavg}" />
                                    </td>
                                    <td>&nbsp;</td>
                                 </tr>
                              </tbody>
                           </table>
                        </td>
                     </tr>
                  </table>
               </div>
            </div>
         </div>
      </div>
      <script>
         $("button").click(function () {
             print()
         });
         
      </script> 
   </body>
</html>