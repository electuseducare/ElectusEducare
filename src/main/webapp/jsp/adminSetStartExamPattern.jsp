<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <%@include file="DisplayLogo.jsp" %>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>Electus Educare</title>
      <%@include file="adminDataTable.jsp" %>
      <script>
         //Function To Display Popup
         function finish_div_show() {
         document.getElementById('finishabc').style.display = "block";
         return false;
         }
         //Function to Hide Popup
         function finish_div_hide(){
         document.getElementById('finishabc').style.display = "none";
         }
         
         function cancel_Finish(){
         	document.getElementById('finishabc').style.display = "none";
         	return false;
         }
         
         
         
         
      </script>
   </head>
   <body>
      <%@include file="adminUserTopMenu.jsp" %>
      <%@include file="adminUserHeader.jsp" %>
      <!-- start header -->
      <div class="row"> </div>
      <div style="width:22%; float:left; background-color: #ffffff;"><%@include file="AdminDashboardLeftMenu.jsp" %></div>
      <div style="width:70%; float:left; background-color: #ffffff">
         <ul class="nav nav-tabs">
            <li  class="active"><a href="load-setstartexampattern" >Set Start Exam Pattern</a></li>
         </ul>
         <div class="panel-heading" style="background-color:#ccf2ff;color:black; font-weight: bold;"><a href="load-setstartexampattern"><img border="0" alt="W3Schools" src="${pageContext.request.contextPath}/theme/images/edit.jpg" width="40" height="40" ></a></div>
         <div class="panel-body" id="mockTabs" style="background-color:#DFE2DB;">
            <center>
               <h4 style="color:green">${smsg}</h4>
            </center>
            <center>
               <h4 style="color:red">${emsg}</h4>
            </center>
            <c:if test="${smsg==null}" >
               <form:form  name="AddRoleform" method="post" action="set-startexampattern"  modelAttribute="pattern" >
                  <TABLE width="100%" style="padding: 6px">
                     <TR>
                        <TD width="10%">&nbsp;</TD>
                        <TD width="80%" align="left">
                           <c:if test="${buttonid eq 0}">
                              <center>
                                 <h4 style="color:red">You don't have any Examtype available to set the exam pattern</h4>
                              </center>
                           </c:if>
                           <table id="example" class="display" cellspacing="0" width="100%">
                              <thead>
                                 <c:if test="${buttonid eq 1}">
                                    <TR>
                                       <TH>No</TH>
                                       <TH style="text-align: left;">Exam Type</TH>
                                       <c:forEach items="${exampatternlist}" var="exampattern" varStatus="loop1">
                                          <TH>Exam Pattern</TH>
                                       </c:forEach>
                                    </TR>
                                 </c:if>
                              </thead>
                              <tbody>
                                 <c:forEach items="${examtypeslist}" var="pl" varStatus="loop">
                                    <TR>
                                       <TD align="center"> ${loop.index+1}  </TD>
                                       <TD align="left"> ${pl.examtype}   </TD>
                                       <c:set value="${examtypeidjnr}" var="exmtypjr"/>
                                       <c:set var = "string2" value = "${fn:split(exmtypjr, ',')}" />
                                       <c:forEach items="${exampatternlist}" var="exampattern" varStatus="loop1">
                                          <TD>
                                             <c:set value="${exampattern.patternid}_${pl.examtypeid}" var="patternval"/>
                                             <c:choose>
                                                <c:when test="${patternval== string2[loop.index]}">
                                                   <input id="exampatternval_${loop.index+1}" name="${exampattern.patterntype}_${pl.examtype}" type="checkbox" class="example_${loop.index+1}" value="${exampattern.patternid}_${pl.examtypeid}" checked="checked" > <label>${exampattern.patterntype}</label>
                                                </c:when>
                                                <c:otherwise>
                                                   <input id="exampatternval_${loop.index+1}" name="${exampattern.patterntype}_${pl.examtype}" type="checkbox" class="example_${loop.index+1}" value="${exampattern.patternid}_${pl.examtypeid}" > <label>${exampattern.patterntype}</label>
                                                </c:otherwise>
                                             </c:choose>
                                          </TD>
                                          <script>
                                             $('.example_${loop.index+1}').on('change', function() {
                                               $('.example_${loop.index+1}').not(this).prop('checked', false);  
                                             });
                                               
                                          </script>
                                       </c:forEach>
                                    </TR>
                                 </c:forEach>
                              </tbody>
                           </table>
                        </TD>
                        <TD width="10%">&nbsp;</TD>
                     </TR>
                     <TR>
                        <TD colspan="2" align="center">
                           <c:if test="${buttonid eq 1}">
                              <button class="btn-primary" style="background-color: #00a3cc;color:white;" id="popup" onclick="return finish_div_show();"> UPDATE </button>
                           </c:if>
                        </TD>
                     </TR>
                  </TABLE>
                  <script type="text/javascript">
                     $(document).ready(function() {
                         $('#example').DataTable( {
                             
                         } );
                     } ); 
                     
                  </script>
                  <div id="finishabc" style="overflow:hidden;">
                     <div id="popupContact" >
                        <div class="panel" style="width: 100%; background-color: #117584;">
                           <div class="panel-heading"  style="font-size: 18px;font-weight: bold; color: #ffffff;">Modify Section</div>
                        </div>
                        <table width="100%" height="65%">
                           <tr>
                              <td valign="middle" align="center" colspan="2" style="font-weight: bold; color: #00004d;"> Do you want to modify Section? </td>
                           </tr>
                           <tr>
                              <td valign="middle" align="center" colspan="2" style="font-weight: bold; color: #00004d;"> If 'YES' please click on Update. If 'NO' click on Cancel. </td>
                           </tr>
                           <tr>
                              <td align="left" width="50%" valign="bottom">  
                                 <button class="button btn-primary" style="margin-top:40px; margin-left:180px;background-color:#0E8DE2;color: white; font-weight: bold; " name="actionform" value="finishtest" onclick="return formValidation();stopFinishTestTime();"> UPDATE </button>
                              </td>
                              <td align="right" width="50%" valign="bottom">
                                 <button class="button btn-primary" style="margin-top:40px; margin-right:180px;background-color:#0E8DE2;color: white; font-weight: bold; " id="cancelFinish" onclick="return cancel_Finish();">Cancel</button>
                              </td>
                           </tr>
                        </table>
                     </div>
                  </div>
               </form:form>
            </c:if>
         </div>
      </div>
      <center>
         <div style="width: 10%;float:right;background-color: #ffffff"> </div>
      </center>
      <%@include file="adminfooter.jsp" %>
   </body>
</html>