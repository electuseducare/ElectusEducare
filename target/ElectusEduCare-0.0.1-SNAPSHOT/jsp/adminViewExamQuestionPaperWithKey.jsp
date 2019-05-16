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
      <script type="text/javascript">
         function printData()
         {
            var divToPrint=document.getElementById("printcontent");
            var examname=document.getElementById("examname").value;
            newWin= window.open("");
            newWin.document.write("<title>"+examname+" Question Paper</title>");
            newWin.document.write(divToPrint.outerHTML);
            newWin.print();
            newWin.close();
         }
         
         $('button').on('click',function(){
         printData();
         })
         
         
      </script>
      <style> 
         input[type=button] {
         background-color: grey;
         border: none;
         color: white;
         padding: 10px 28px;
         text-decoration: none;
         margin: 4px 4px;
         cursor: pointer;
         }
      </style>
      <style>
         #printcontent{
         }
         tfoot input {
         width: 100%;
         padding: 3px;
         box-sizing: border-box;
         }
      </style>
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
      <link rel="stylesheet" href="https://cdn.datatables.net/1.10.15/css/dataTables.bootstrap.min.css">
      <link rel="stylesheet" href="https://cdn.datatables.net/responsive/2.1.1/css/responsive.bootstrap.min.css">
      <script>
         function goBack() {
             window.history.back()
         }
      </script>
   </head>
   <body>
      <%@include file="adminUserTopMenu.jsp" %>
      <%@include file="adminUserHeader.jsp" %>
      <div class="row"> </div>
      <div style="width:22%; float:left; background-color: #ffffff;"><%@include file="AdminDashboardLeftMenu.jsp" %></div>
      <div style="width:70%; float:left; background-color: #ffffff">
         <input type="hidden" id="examname" value="${examname}">
         <!-- Modal content -->
         <div class="modal-content3"  style="border-radius: 25px;
            background:  #D9EDF7;
            padding: 20px;
            font-weight: bold;
            ">
            <div class="modal-header" style="background-color:#D9EDF7	">
               <b>Detailed Question Paper of <span style="color: green;">${examname}</span></b>
               <span style="float: right;"><button class="btn btn-success" data-toggle="modal" data-target="#acdemicyearModal" style="margin-right: 10px" onclick="printData()"><span class="glyphicon glyphicon-print"></span>Print</button></span> 
               <input type="button" style="float: right;" value="Back" onclick="goBack()">
            </div>
            <div class="row"></div>
            <div style="display: block;width: auto;height: auto;overflow: visible;" id="printcontent">
               <%int popupcnt=1; %>
               <table border="1" width="100%" id="customers" >
                  <c:forEach items="${model1.fqp}" var="subrow" varStatus="loop2">
                     <tr>
                        <th style="color: red">No.</th>
                        <th style="color: red">${subrow.subjectname} </th>
                     </tr>
                     <c:forEach items="${subrow.list}" var="row1" varStatus="loop">
                        <tr >
                           <td width="5%" style="vertical-align: top;"> <%=popupcnt %>)  </td>
                           <td width="95%">
                              <label style="color:green;font-weight: bold;">Question:</label> 
                              <p>${row1.ques} <%popupcnt++; %></p>
                              <c:forEach items="${row1.optionsList}" var="options" varStatus="i">
                                 <c:choose>
                                    <c:when test="${row1.typeOfQuestion == 'Matrix Match'}">
                                       <c:set value="${options.option}" var="matrixoption"></c:set>
                                       <%
                                          String matrixoption = (String) pageContext.getAttribute("matrixoption");
                                          String[] splitmatr = matrixoption.split("matrix_option");
                                          int j = 0;
                                          String storeVal1 = "";
                                          String storeVal2 = "";
                                          for (int i=0; i<splitmatr.length; i++){
                                          String a = splitmatr[i];
                                          if(j==0){
                                          storeVal1 += a;
                                          }
                                          if(j==1){
                                          storeVal2 += a;
                                          j=0;
                                          }
                                          j++;
                                          
                                          }
                                          
                                          
                                          
                                          %>
                                       <%=storeVal1 %> <span style="padding-right: 10px;"></span> <%=storeVal2 %> 
                                    </c:when>
                                    <c:otherwise>
                                       <table>
                                          <tr>
                                             <td style="padding-right: 10px"> Option ${options.optionType}: </td>
                                             <td colspan="4"> ${options.option} </td>
                                          </tr>
                                       </table>
                                    </c:otherwise>
                                 </c:choose>
                              </c:forEach>
                              <table>
                                 <tr>
                                    <td style="padding-right: 10px"> Key :  </td>
                                    <td colspan="4"> ${row1.answer} </td>
                                 </tr>
                              </table>
                              <table>
                                 <tr>
                                    <td style="padding-right: 10px"> Solution :  </td>
                                    <td colspan="4"> ${row1.solutions} </td>
                                 </tr>
                              </table>
                           </td>
                        </tr>
                     </c:forEach>
                  </c:forEach>
               </table>
            </div>
         </div>
      </div>
      <%@include file="adminfooter.jsp" %>
   </body>
</html>