        <%
pageContext.setAttribute("student_id", session.getAttribute("student_id"));
%>  
<c:set value="${student_id}" var="student_id"></c:set>
  <c:if test="${studentidnull==student_id}">
<%response.sendRedirect("load-selectschool"); %>
  </c:if>