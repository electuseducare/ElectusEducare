<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <%@include file="DisplayLogo.jsp" %>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>Student Average Report</title>
      <script type="text/javascript" src="http://code.jquery.com/jquery-1.8.2.js"></script>
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
      <%@include file="adminDataTableForReports.jsp" %>
      <!-- start header -->
      <div class="row"> </div>
      <div class="container">
         <div style="width:100%; float:left; background-color: #ffffff">
            <ul class="nav nav-tabs" id="toptabs">
               <li ><a href="load-estimatestudentsearch" >SEARCH ESTIMATED AVERAGE</a></li>
               <li class="active"><a href="#" >VIEW ESTIMATED AVERAGE</a></li>
            </ul>
            <div class="panel-heading" style="background-color:#ccf2ff;color:black; font-weight: bold;">
               <a href="load-estimatestudentsearch">
               <img border="0" id="printpage" alt="assicon" src="${pageContext.request.contextPath}/theme/images/addicon.jpg" width="40" height="40" style="background-color: skyblue;">
               ESTIMATED AVERAGE</a>
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
                     <%-- <img border="0" alt="school img" src="${pageContext.servletContext.contextPath }/ViewImage?imageID=viswasailogo.png"  > --%>
                  </div>
                  <table id="studentinfo" class="table table-bordered table-striped nowrap" cellspacing="0" width="100%" style="text-align: center;">
                     <tr>
                        <th>Class	 :${classname}</th>
                        <th>Section 	 :${sectioname}</th>
                        <th>State 	 :${statename}</th>
                        <th>Location  :${locationname}</th>
                        <th>Branch    :${branchname}</th>
                     </tr>
                  </table>
                  <table id="example" class="table table-condensed" cellspacing="0" width="100%" style="text-align: center;">
                     <thead>
                        <tr>
                           <th>S.No</th>
                           <th>SId</th>
                           <th>SName</th>
                           <c:forEach  items="${studentavgsubjects}" var="editdetails" varStatus="loop">
                              <th>${editdetails.subject}</th>
                              <th>Rank</th>
                           </c:forEach>
                           <th>Avg</th>
                           <th>Rank</th>
                           <th>Exam Count</th>
                        </tr>
                     </thead>
                     <tbody>
                        <c:forEach  items="${studentavgdetails}" var="editdetails" varStatus="loop">
                           <tr>
                              <td>${loop.index+1}</td>
                              <c:forEach  items="${listavg}" var="editdetails1" begin="${loop.index}" end="${loop.index}">
                                 <td>${editdetails1.username}</td>
                              </c:forEach>
                              <td>${editdetails.studentname}</td>
                              <c:forEach  items="${listavg}" var="editdetails1" begin="${loop.index}" end="${loop.index}">
                                 <c:forEach  items="${editdetails1.lsubavg}" var="editdetails2" varStatus="loop3">
                                    <td>${editdetails2} </td>
                                    <c:forEach  items="${editdetails1.lsubrank}" var="editdetails3" begin="${loop3.index}" end="${loop3.index}">
                                       <td>${editdetails3} </td>
                                    </c:forEach>
                                 </c:forEach>
                                 <td>${editdetails1.totalavg}</td>
                                 <td>${editdetails1.ranktotal}</td>
                                 <td>${editdetails1.examcount}</td>
                              </c:forEach>
                           </tr>
                        </c:forEach>
                     </tbody>
                  </table>
               </div>
            </div>
            <script>
               $("button").click(function () {
                   print()
               });
               
            </script> 
         </div>
      </div>
   </body>
</html>