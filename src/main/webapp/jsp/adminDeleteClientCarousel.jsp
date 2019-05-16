<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <%@include file="DisplayLogo.jsp" %>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>Electus Educare</title>
      <%@include file="adminDataTable.jsp" %>
      <script>
         //Function To Display Popup
         function finish_div_show(carsid) {
          document.getElementById('carsid').value=carsid;
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
            <li  ><a href="load-uploadClientCarousel" >Upload Carousel</a></li>
            <li class="active" ><a href="#" >Delete Carousel</a></li>
         </ul>
         <div class="panel-heading" style="background-color:#ccf2ff;color:black; font-weight: bold;">
            <a href="load-deleteClientCarousel"> <img border="0" alt="W3Schools" src="${pageContext.request.contextPath}/theme/images/delete.jpg" width="40" height="40" > </a>Delete Carousel 
         </div>
         <div class="panel-body" id="mockTabs" style="background-color:#DFE2DB;">
            <center>
               <h4 style="color:green">${smsg}</h4>
            </center>
            <center>
               <h4 style="color:red">${emsg}</h4>
            </center>
            <c:if test="${smsg==null}" >
               <form:form  name="AddRoleform" method="post" action="process-deleteclientcarousel"  modelAttribute="deletelistvalue">
                  <c:if test="${buttonid eq 0}">
                     <center>
                        <h4 style="color:red">You don't have any Carousel  to delete</h4>
                     </center>
                  </c:if>
                  <div class="row" align="center">
                     <c:forEach items="${deletelistvalue.carousellist}" var="introdetails" varStatus="loop">
                        <br>
                        <img src="${pageContext.request.contextPath}/viewClientCarousel?imageID=${introdetails.carousel}"  alt=""style=" height: 100px;">&nbsp;
                        <button class="btn-primary"    style="background-color: #00a3cc;color:white;width:15%;align-text:left;"   value="${introdetails.clientlogoid}" onclick="return finish_div_show(this.value);" > Delete </button> 
                        <br><br>
                        <div id="finishabc" style="overflow:hidden;">
                           <div id="popupContact" >
                              <div class="panel" style="width: 100%; background-color: #117584;">
                                 <div class="panel-heading"  style="font-size: 18px;font-weight: bold; color: #ffffff;">Delete Carousel</div>
                              </div>
                              <table width="100%" height="65%">
                                 <tr>
                                    <td valign="middle" align="center" colspan="2" style="font-weight: bold; color: #00004d;"> Do you want to delete Carousel? </td>
                                 </tr>
                                 <tr>
                                    <td valign="middle" align="center" colspan="2" style="font-weight: bold; color: #00004d;"> If 'YES' please click on Delete. If 'NO' click on Cancel. </td>
                                 </tr>
                                 <tr>
                                    <td align="left" width="50%" valign="bottom"> 
                                       <button class="button btn-primary"  style="margin-top:40px; margin-left:180px;background-color:#0E8DE2;color: white; font-weight: bold; " id="carsid" name="carouselid"  > DELETE </button>
                                    </td>
                                    <td align="right" width="50%" valign="bottom">
                                       <button class="button btn-primary" style="margin-top:40px; margin-right:180px;background-color:#0E8DE2;color: white; font-weight: bold; " id="cancelFinish" onclick="return cancel_Finish();">Cancel</button>
                                    </td>
                                 </tr>
                              </table>
                           </div>
                        </div>
                     </c:forEach>
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