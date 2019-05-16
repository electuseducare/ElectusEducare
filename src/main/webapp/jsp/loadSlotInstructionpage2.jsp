<html>
   <%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
      <title>Meta Gate</title>
      <style type="text/css">
         body {
         margin: 0;
         padding: 0;
         overflow: hidden;
         height: 100%; 
         max-height: 100%; 
         font-family:Sans-serif;
         line-height: 1.5em;
         }
         main {
         position: fixed;
         top: 60px; /* Set this to the height of the header */
         right: 230px; /* Set this to the width of the nav bar */
         bottom: 0;
         overflow: auto; 
         background: #fff;
         max-height:550px;
         }
         #header {
         position: absolute;
         top: 0;
         left: 0;
         width: 100%;
         height: 60px; 
         overflow: hidden; /* Disables scrollbars on the header frame. To enable scrollbars, change "hidden" to "scroll" */
         background: #5BB1FA;
         }
         #nav {
         position: absolute; 
         top: 65px; 
         right: 0; 
         bottom: 0;
         width: 230px;
         overflow: auto; /* Scrollbars will appear on this frame only when there's enough content to require scrolling. To disable scrollbars, change to "hidden", or use "scroll" to enable permanent scrollbars */
         background: #FFFFFF; 	
         text-align: center;	
         border: 0.5px;
         }
         #logo {
         padding:10px;
         }
         .innertube {
         margin: 15px; /* Provides padding for the content */
         }
         p {
         color: #555;
         }
         nav ul {
         list-style-type: none;
         margin: 0;
         padding: 0;
         }
         nav ul a {
         color: darkgreen;
         text-decoration: none;
         }
         /*IE6 fix*/
         * html body{
         padding: 100px 230px 0 0; /* Set the first value to the height of the header and second value to the width of the right column */
         }
         * html main{ 
         height: 100%; 
         width: 100%; 
         }
         .footer {
         position: fixed;
         left: 0;
         bottom: 0;
         width: 80%;
         background-color: white;
         color: white;
         text-align: center;
         border: 1px solid;
         }
         a:link, a:visited {
         background-color: white;
         color: black;
         padding: 6px 18px;
         text-align: center;
         text-decoration: none;
         display: inline-block;
         border:1px solid;
         }
         .notansweredbtn{
         padding: 8px 8px 8px 8px;
         text-decoration: none;
         border: 1px solid #ccc;
         color: navy;
         background-color: #ffffff;
         margin-right:3px;
         float:left;
         -webkit-transition: background 200ms linear;
         transition: background 200ms linear;
         border-Bottom-left-radius: 20px;
         border-Bottom-right-radius:20px;
         moz-border-radius: 10px;
         webkit-border-radius:10px;
         display: inline;
         font-size:12px;
         margin-bottom: :25px;
         }
         #currentques{
         padding: 8px 8px 4px 8px;
         text-decoration: none;
         border: 1px solid #ccc;
         text-decoration: none;
         color: #FFFFFF;
         background-color: #4E85C5;
         margin-right:3px;
         float:left;
         -webkit-transition: background 200ms linear;
         transition: background 200ms linear;
         border-Bottom-left-radius: 20px;
         border-Bottom-right-radius:20px;
         moz-border-radius: 10px;
         webkit-border-radius:10px;
         display: inline;
         margin-bottom: :25px;
         color: white;
         }
         .answeredbtn{
         padding: 8px 8px 4px 8px;
         text-decoration: none;
         border: 1px solid #ccc;
         color: navy;
         background-color: #29D28A;
         margin-right:3px;
         float:left;
         -webkit-transition: background 200ms linear;
         transition: background 200ms linear;
         border-top-left-radius: 20px;
         border-top-right-radius:20px;
         moz-border-radius: 10px;
         webkit-border-radius:10px;
         display: inline;
         margin-bottom: :25px;
         color: white;
         }
         #markforreview{
         padding: 8px 8px 4px 8px;
         text-decoration: none;
         border: 1px solid #ccc;
         color: navy;
         background-color: #714F91;
         margin-right:3px;
         float:left;
         -webkit-transition: background 200ms linear;
         transition: background 200ms linear;
         border-Bottom-left-radius: 50px;
         border-Bottom-right-radius:50px;
         border-Top-left-radius: 50px;
         border-Top-right-radius:50px;
         moz-border-radius: 10px;
         webkit-border-radius:10px;
         display: inline;
         margin-bottom: :25px;
         color: white;
         }
         #examtab td, #examtab tr {
         padding: 10px;
         }
         #customers td, #customers th {
         border: 1px solid #ddd;
         padding: 8px;
         text-align: center;
         }
         #customers tr:nth-child(even){background-color: #f2f2f2;}
         #customers tr:hover {background-color: #ddd;}
         #customers {
         font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
         border-collapse: collapse;
         width: 100%;
         }
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
      <script></script>
      <script type="text/javascript">
         /* =============================
         This script generates sample text for the body content. 
         You can remove this script and any reference to it. 
          ============================= */
         var bodyText=["The smaller your reality, the more convinced you are that you know everything.", "If the facts don't fit the theory, change the facts.", "The past has no power over the present moment.", "This, too, will pass.", "</p><p>You will not be punished for your anger, you will be punished by your anger.", "Peace comes from within. Do not seek it without.", "<h3>Heading</h3><p>The most important moment of your life is now. The most important person in your life is the one you are with now, and the most important activity in your life is the one you are involved with now."]
         function generateText(sentenceCount){
         	for (var i=0; i<sentenceCount; i++)
         	document.write(bodyText[Math.floor(Math.random()*7)]+" ")
         }
      </script>	
      <script type="text/javascript">
         function startloader() {
         
          if(document.getElementById("terms").checked==false){
                 alert("Please accept terms and conditions before proceeding.");
         	  return false;
                   }else{
          document.getElementById("loaderstart").style.display='block';
         }
         }
      </script>
   </head>
   <body>
      <div id="loaderstart" class="loader" style="display: none"></div>
      <header id="header">
         <%-- <img src="${pageContext.request.contextPath}/theme/images/gate.jpg" height="50px" width="50px" alt="logo" onmouseout="myPopUpImageMouseOut()"/>
            <span style="color: white; font-size: 28px; font-weight: bold">GATE 2018
            </span> --%>
         <h1 style="margin-top: 0px;height: 35px;font-weight: lighter;padding-top: 12px ">Other Important Instructions</h1>
      </header>
      <form:form id="springform" method="POST" action="load-ExamForm">
         <main>
            <div class="innertube">
               <p style="text-align: center;font-weight: bold;font-size: 18px;text-decoration: underline;">Paper Specific Instructions</p>
               <br>
               <p style="text-align: center;font-weight: bold;font-size: 18px;text-decoration: underline;">Exam Name:${examname1}</p>
               <p style="font-weight:bold;text-decoration: underline; ">Read the following instructions carefully</p>
               <table id="examtab">
                  <tr>
                     <td>1.Go through various question palette symbols and understand their meanings before starting the examination.</td>
                  </tr>
                  <tr>
                     <td>2.After the start of the examination, you can view all the questions by clicking on the Question Paper button on the screen.</td>
                  </tr>
                  <tr>
                     <td>
                        3.This question paper consists of following data
                        <div class="table-responsive">
                           <table id="customers">
                              <tr>
                                 <th>Subject</th>
                                 <th>Question Type</th>
                                 <th>No of Questions</th>
                                 <th>Positive Marks</th>
                                 <th>Negative Marks</th>
                              </tr>
                              <c:forEach items="${getdetails}" var="details">
                                 <tr class="tblRw">
                                    <td>${details.subjectname} </td>
                                    <td>${details.questiontype}</td>
                                    <td>${details.noofquestions}</td>
                                    <td>${details.marksperquestype} </td>
                                    <td>${details.negativemarks}</td>
                                 </tr>
                              </c:forEach>
                           </table>
                        </div>
                     </td>
                  </tr>
                  <tr>
                     <td style="font-weight: bold;text-decoration: underline;">
                     </td>
                  </tr>
                  <tr>
                     <td>
                        4.Your answers will be saved on the server periodically and also at the end of the examination. The examination will stop automatically at the end of the time.
                     </td>
                  </tr>
                  <tr>
                     <td>
                        5.You are not allowed to leave the examination hall until the completion of the examination.	
                     </td>
                  </tr>
                  <tr>
                     <td>
                        6.Charts, graph sheets, calculators and mathematical tables are NOT allowed in the examination hall. You must use the scribble pad provided to you in the examination hall for your rough work, which must be returned at the end of the examination.	
                     </td>
                  </tr>
                  <tr>
                     <td>
                        7.For numerical answer type questions, a numerical answer should be entered with the help of the mouse and the virtual numeric keypad, which will appear below the question.	
                     </td>
                  </tr>
               </table>
            </div>
            <div class="footer">
               <div class="container">
                  <input type="checkbox" name="terms" id="terms" ><span style="font-size:14px;font-weight:bold;font-decoration:underline;color:black;">Declaration by the candidate:</span> <span style="color:black;font-size:13px;text-justify: inter-word;text-align: justify;">I have read and understood all the instructions.all the computer hardware alloted to me in proper condition.I declare i am not carrying any prohibited gadgets like mobile phone,bluetooth devices,wrist watch,etc..any prohibited material with me in to the examination hall.I agree that if found to be non-compliment with the above declaration,I shall be liable to be debarred from this examination and/or to disciplinary action,which may include ban from future examinations/tests. </span> 
               </div>
               <br><br> 
               <a href="load-instructions?exam=${examname}"  style="color:black;height:20px;float: left; ">&larr;Previous</a>	 	
               <input type="hidden" name="exam" value="${examname}">
               <input type="submit" name="exam" id="submit" value="I am ready to begin" style="background-color:#0C7CD5;color:white;height:35px; cursor: pointer;" onclick="return startloader();">	 	
            </div>
         </main>
      </form:form>
      <nav id="nav">
         <div class="innertube">
            <div class="shadow1">
               <img alt="User Pic" src="${pageContext.request.contextPath}/theme/images/profile.jpg" id="profile-image1" class="img-circle img-responsive" style="width:100px;height: 100px;">
               <div class="profile_details">
                  <div id="Username" class="candOriginalName" title="<%=session.getAttribute("first_name")  %>"><%=session.getAttribute("first_name")  %> </div>
               </div>
            </div>
         </div>
      </nav>
   </body>
</html>