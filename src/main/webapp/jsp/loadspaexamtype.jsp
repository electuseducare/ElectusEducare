<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta name="description" content="">
      <meta name="author" content="">
      <title>Welcome User</title>
      <%@include file="DisplayLogo.jsp" %>
      <%@include file="userSessionExpire.jsp" %>
      <%@include file="userNewTemplateCss.jsp" %>
      <style>
         #customers {
         font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
         border-collapse: collapse;
         width: 100%;
         background-color: #428BCA;
         color:white;
         }
         #customers td, #customers th {
         border: 1px solid #ddd;
         padding: 8px;
         color:white;
         }
         #customers tr:nth-child(even){background-color: #f2f2f2;      color:white;}
         #customers tr:hover {color:white;}
         #customers th {
         padding-top: 12px;
         padding-bottom: 12px;
         text-align: left;
         background-color: #4CAF50;
         color: white;
         }
      </style>
      <style type="text/css">
         .loader {
         position: fixed;
         left: 0px;
         top: 0px;
         width: 100%;
         height: 100%;
         z-index: 9999;
         background: url('https://loading.io/assets/img/landing/curved-bars.svg')
         50% 50% no-repeat rgb(249, 249, 249);
         opacity: .8;
         }
      </style>
      <script type="text/javascript">
         function startloader() {
         
         	 document.getElementById("loaderstart").style.display='block';
         }
         	
      </script>
   </head>
   <body>
      <!-- start header -->
      <div id="loaderstart" class="loader" style="display: none;"></div>
      <div id="wrapper">
      <!-- Navigation -->
      <%@include file="usernewleftmenu.jsp" %>
      <div id="page-wrapper">
         <div class="row">
            <div class="col-lg-12">
               <h1 class="page-header">Select Exam Type to check your analysis.</h1>
               <c:forEach items="${getexamtyp}" var="examtypeval">
                  <a href="process-SPA?examtype=${examtypeval.examtypeid}" class="btn btn-lg btn-primary" onclick="return startloader();">${examtypeval.examtype}</a>
               </c:forEach>
            </div>
            <!-- /.col-lg-12 -->
         </div>
         <!-- /.row -->
         <!-- /#page-wrapper -->
      </div>
      <!-- /#wrapper -->
      <%@ include file="userNewTemplateJs.jsp" %>
   </body>
</html>