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
      <div id="loaderstart" class="loader" style="display: none;"></div>
      <div id="wrapper">
      <!-- Navigation -->
      <%@include file="usernewleftmenu.jsp" %>
      <div id="page-wrapper">
         <div class="row">
            <div class="col-lg-12">
               <h1 class="page-header">Dashboard</h1>
                <%
                        String clientDatabse=(String)session.getAttribute("keyDS");
                        pageContext.setAttribute("clientDatabse", clientDatabse);
                        %>
                        <c:choose>
                        <c:when test="${clientDatabse==8}">
                         <table id="customers">
                  <tr>
                     <td colspan="6">
                        <div>
                       
                           <ul style="cursor: pointer;">
                              <li>Graduate Aptitude Test in Engineering (GATE) is basically an examination on the comprehensive understanding of the candidates in various undergraduate subjects inEngineering/Technology/Architecture and post-graduate level subjects in Science</li>
                              <li>The examination would be purely a Computer BasedTest (CBT).The GATE score would reflect the relative performance level of the candidate in a particular subject, which is quantified based on the several years of examination data. Note that the GATE</li>
                              <li>GATE score is valid for THREE YEARS from the date of announcement of the results.GATE is administered jointly by the Indian Institute of Science (IISc), Bangalore and seven IndianInstitutes of Technology (namely, IITs at Bombay, Delhi, Guwahati, Kanpur, Kharagpur, Madrasand Roorkee). </li>
                              <li>The GATE Committee, which comprises of representatives from the administering institutes, is the sole authority for regulating the examination and for declaring the results. </li>
                              <li>Qualifying in GATE is a mandatory requirement for seeking admission and/or financial assistance to: (i) Master’s programs and direct Doctoral programs in Engineering/Technology/Architectureand (ii) Doctoral programs in relevant branches of Science, in the institutions supported by theMHRD and other Government agencies. </li>
                              <li>Even in some colleges and institutions, which admit students without MHRD scholarship/assistantship, the GATE qualification is mandatory. </li>
                              <li>Further, many Public Sector Undertakings (PSUs) have been using the GATE score in their recruitment process.</li>
                           </ul>
                           
                        </div>
                     </td>
                  </tr>
               </table>
                        </c:when>
                        <c:otherwise>
                         <table id="customers">
                  <tr>
                     <td colspan="6">
                        <div>
                       
                           <ul style="cursor: pointer;">
                              <li>By taking the JEE, you would be able to show your caliber to this society and actually compete with outside world and know your place.</li>
                              <li>The main reason is that it would give you a way in to prestigious institutes of India in field of technology, which is good to shape your future.</li>
                              <li>You get a number of opportunities to achieve something in research and development and various other professions.</li>
                              <li>Joint Entrance Examination (JEE) is an all India common engineering entrance examination conducted for admission to various engineering colleges and courses all over the country. </li>
                              <li>The test comprises of two stages - JEE Main and the JEE Advanced. The exams are of the objective pattern. </li>
                              <li>JEE-Main exam is for admission to NITs, IIITs, Centrally Funded Technical Institutes (CFTIs) while JEE-Advanced is for admission to the elite IITs.</li>
                              <li> Only the students selected in JEE Mains are eligible for appearing in JEE Advanced.</li>
                              <li>If you want to get admission into NITs and other engineering colleges except IITs, no change is there.</li>
                              <li>AIEEE has been replaced by JEE Main, Syllabus and format is almost similar as it was for AIEEE. </li>
                              <li>Format of IIT entrace test 'JEE Advanced' is similar to IIT JEE. </li>
                              <li> But Now to get admission into IITs you have to face two exams - JEE Main and JEE Advanced.Only top students in JEE Main will be eligible to write JEE Advanced.</li>
                           </ul>
                           
                        </div>
                     </td>
                  </tr>
               </table>
                        </c:otherwise>
                        </c:choose>
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