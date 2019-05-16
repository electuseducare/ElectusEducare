<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <%@include file="DisplayLogo.jsp" %>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Hello World</title>
   </head>
   <body>
      <h1>${error}</h1>
      <form:form action="excelupload" method="post"
         enctype="multipart/form-data">
         <div>Excel File 2007:</div>
         <input name="excelfile2007" type="file">		
         <input type="submit" value="processExcel2007">
      </form:form>
      <hr>
      <h3>Users List</h3>
      <c:if test="${!empty lstUser}">
         <table class="tg">
            <tr>
               <th width="80">User ID</th>
               <th width="120">UserName</th>
               <th width="120">Input Date</th>
            </tr>
            <c:forEach items="${lstUser}" var="user">
               <tr>
                  <td>${user.firstname}</td>
                  <td>${user.lastname}</td>
                  <td>${user.username}</td>
                  <td>${user.email}</td>
                  <td>${user.password}</td>
                  <td>${user.mobilenumber1}</td>
                  <td>${user.classid}</td>
                  <td>${user.sectionid}</td>
                  <td>${user.branchid}</td>
                  <td>${user.stateid}</td>
                  <td>${user.locationid}</td>
               </tr>
            </c:forEach>
         </table>
      </c:if>
   </body>
</html>