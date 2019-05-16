<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
      <title>Meta Gate</title>
      <style type="text/css">
         body {
         margin: 0;
         padding: 0;
         overflow: scroll;
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
         th, td {
         padding: 10px;
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
         position: relative;
         left: 0;
         bottom: 10;
         top:90%;
         width: 80%;
         background-color: white;
         color: white;
         text-align: center;
         border: 1px solid;
         z-index:5;
         opacity:2;
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
         padding: 8px 8px 4px 8px;
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
         z-index:5;
         }
         .markforreviewansw{
         padding: 9px 8px 4px 8px;
         text-decoration: none;
         border: 1px solid #ccc;
         color: navy;
         background-color: #714F91;
         margin-right:3px;
         float:left;
         -webkit-transition: background 200ms linear;
         transition: background 200ms linear;
         border-radius: 5px 20px 5px;
         display: inline;
         margin-bottom: :25px;
         color: white;
         }
         .currentques{
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
         .notansweredvisitedbtn{
         padding: 8px 8px 4px 8px;
         text-decoration: none;
         border: 1px solid #ccc;
         color: white;
         background-color: red;
         margin-right:3px;
         float:left;
         -webkit-transition: background 200ms linear;
         transition: background 200ms linear;
         border-Bottom-left-radius: 20px;
         border-Bottom-right-radius:20px;
         moz-border-radius: 10px;
         webkit-border-radius:10px;
         display: inline-block;
         margin-bottom: :25px;
         }
         .answeredbtn{
         padding: 8px 8px 4px 8px;
         text-decoration: none;
         border: 1px solid #ccc;
         text-decoration: none;
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
      </style>
         <jsp:include page="gateCss.jsp"></jsp:include>
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
   </head>
   <body>
      <header id="header">
         <%-- <img src="${pageContext.request.contextPath}/theme/images/gate.jpg" height="50px" width="50px" alt="logo" onmouseout="myPopUpImageMouseOut()"/>
            <span style="color: white; font-size: 28px; font-weight: bold">GATE 2018
            </span> --%>
         <h1 style="margin-top: 0px;height: 35px;font-weight: lighter;padding-top: 12px ">Instructions</h1>
      </header>
      <main>
         <div class="innertube">
            <p style="text-align: center;font-weight: bold;font-size: 18px;text-decoration: underline;">General Instructions</p>
            <p style="font-weight:bold;text-decoration: underline; ">Read the following instructions carefully</p>
           
                                                     
           
           
           
            <table >
               <tr style="padding: 10px;">
                  <td>1.Total duration of the examination is 180 minutes. Calculator is available on top, right-hand side of the screen.</td>
               </tr>
               <tr >
                  <td>2.The clock will be set at the server. The countdown timer at the top, right-hand side of the screen will display the time available for you to complete the examination. When the timer reaches zero, the examination will end automatically. You will not be required to end or submit your examination..</td>
               </tr>
               <tr>
                  <td>3.The Question Palette displayed on the right-hand side of the screen will show the status of each question using one of the following symbols:</td>
               </tr>
               <tr>
                  <td>
                     <table>
                         <div class="diff_type_notation_area_inner">
                                                         <div class="notation_type_description">
                                                            <p><span class="not_visited notVisitedCount">N</span> <span class="type_title notVisitedLabel longtext-hide" id="" title="Not Visited">This question has not been answered yet.</span></p>
                                                            <br>
                                                            <p><span class="not_answered notAnsweredCount">V</span> <span class="type_title notAnsweredLabel longtext-hide" id="" title="Not Answered">This question has been visited but not answered.</span></p>
                                                            <br>
                                                            <p><span class="answered answeredCount" >A</span> <span class="type_title answeredLabel longtext-hide" id="" title="Answered">This question has been answered and will be considered for evaluation.</span></p>
                                                            <br>
                                                            <p><span class="review markedCount" >0</span> <span class="type_title markedLabel longtext-hide" id="" title="Marked for Review">This question has been marked for review and has not been answered.</span></p>
                                                            <br>
                                                            <p><span class="review_marked markedReviewCount" >0</span><span class="type_title markedAndAnsweredLabel" id="" title="Answered &amp; Marked for Review">This question has been marked for review and has been answered.</span></p>
                                                            <br>
                                                         </div>
                                                      </div>
                     </table>
                  </td>
               </tr>
               <tr>
                  <td style="font-weight: bold;text-decoration: underline;">
                     Navigating to a Question:
                  </td>
               </tr>
               <tr>
                  <td>
                     4.Click on the question number in the Question Palette to go to that particular question directly.
                  </td>
               </tr>
               <tr>
                  <td>
                     5.You can view all the questions by clicking on the Question Paper button that appears at top, right-hand side of the screen.	
                  </td>
               </tr>
               <tr>
                  <td style="font-weight: bold;text-decoration: underline;">Answering a Question :</td>
               </tr>
               <tr>
                  <td >Procedure for answering a multiple choice type question (MCQ) :</td>
               </tr>
               <tr>
                  <td>
                     <table>
                        <tr>
                           <td>
                              a.To select your answer, click on the button of the corresponding option.
                           </td>
                        </tr>
                        <tr>
                           <td>
                              b.To deselect your chosen answer, click on the button of the chosen option once again or click on the Clear Response button.
                           </td>
                        </tr>
                        <tr>
                           <td>
                              c.To change your chosen answer, click on the button of the newly identified answer.
                           </td>
                        </tr>
                     </table>
                  </td>
               </tr>
               <tr>
                  <td>Procedure for answering a numerical answer type (NAT) question:</td>
               </tr>
               <tr>
                  <td>
                     <table>
                        <tr>
                           <td>
                              a.To enter a numerical answer, use the virtual numeric keypad that appears below the question.
                           </td>
                        </tr>
                        <tr>
                           <td>
                              b.A fractional number in the decimal notation (e.g. -0.3 or -.3) can be entered as an answer with or without '0' before the decimal point.
                           </td>
                        </tr>
                        <tr>
                           <td>
                              c.To clear your answer, click on the Clear Response button.
                           </td>
                        </tr>
                     </table>
                  </td>
               </tr>
               <tr>
                  <td>6.To change your answer to a question that has already been answered, first select that question and then follow the usual procedure for answering any question.</td>
               </tr>
               <tr>
                  <td style="font-weight: bold;text-decoration: underline;">Saving your answer:</td>
               </tr>
               <tr>
                  <td>7.To save your answer, You just need to select the answer it will be saved.</td>
               </tr>
               <tr>
                  <td>8.After the elapse of time scheduled for the examination, all the answers (including those Answered and Marked for Review) will be automatically submitted.</td>
               </tr>
               <tr>
                  <td style="font-weight: bold;text-decoration: underline;">Navigating through sections:</td>
               </tr>
               <tr>
                  <td>9.Sections in this question paper are displayed above the Question Area. Questions in a section can be viewed by clicking on the section name. The section you are currently viewing is highlighted.
                  </td>
               </tr>
               <tr>
                  <td>10.clicking on move to next subject you will navigate to that page.
                  </td>
               </tr>
               <tr>
                  <td>11.You can shuffle between sections and questions anytime during the examination.
                  </td>
               </tr>
               <tr>
                  <td>12.You can see the section summary as a part of the legend appearing above the Question Palette of every section.
                  </td>
               </tr>
            </table>
         </div>
      </main>
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
      <div class="footer"><a href="load-instructionssecondpage?exam=${examname}" style="background-color:#0C7CD5;color:white; ">Next</a></div>
   </body>
</html>