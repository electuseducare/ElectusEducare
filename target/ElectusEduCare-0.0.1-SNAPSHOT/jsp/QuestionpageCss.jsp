<style type="text/css">
   /*Sample CSS used for the Virtual Pagination Demos. Modify/ remove as desired*/
   .paginationstyle{ /*Style for demo pagination divs*/
   float: left;
   display: inline-block;
   padding: 5px;
   margin-right: 10px;
   text-decoration: none;
   background: #fff;
   max-height:500px;
   overflow-y:auto;
   overflow-x:auto;
   width: 100%;
   }
   .paginationstyle select{ /*Style for demo pagination divs' select menu*/
   border: 1px solid navy;
   margin: 1 15px;
   }
   .paginationstyle a{ /*Pagination links style*/
   padding: 8px 8px 6px 8px;
   text-decoration: none;
   border: 1px solid #ccc;
   color: navy;
   background-color: white;
   margin-right:3px;
   float:left;
   -webkit-transition: background 200ms linear;
   transition: background 200ms linear;
   webkit-border-radius:10px;
   display: inline-block;
   margin-bottom: :25px;
   }
   .paginationstyle a:hover, .paginationstyle a.selected{
   color: #000;
   background-color: #5C99C8;
   }
   .paginationstyle a.disabled, .paginationstyle a.disabled:hover{ /*Style for "disabled" previous or next link*/
   background-color: white;
   cursor: default;
   color: #929292;
   border-color: transparent;
   }
   .paginationstyle a.imglinks{ /*Pagination Image links style (class="imglinks") */
   border: 0;
   padding: 0;
   }
   .paginationstyle a.imglinks img{
   vertical-align: bottom;
   border: 0;
   }
   .paginationstyle a.imglinks a:hover{
   background: none;
   }
   .paginationstyle .flatview a:hover, .paginationstyle .flatview a.selected { /*Pagination div "flatview" links style*/
   color: white;
   font-weight:bold;
   background-color: #BBD42D;
   }
   .paginationstyle .flatview a:hover, .paginationstyle .flatview a.selected1 { /*Pagination div "flatview" links style*/
   color: white;
   font-weight:bold;
   background-color: red;
   }
</style>
<style type="text/css">
   .pg-normal {
   font: bold 11px Arial;
   text-decoration: none;
   background-color: #020D56;
   color: #FFFFFF;
   padding: 6px 8px 6px 8px;
   border-top: 1px solid #CCCCCC;
   border-right: 1px solid #333333;
   border-bottom: 1px solid #333333;
   border-left: 1px solid #CCCCCC;
   cursor: pointer;
   margin: 2px;
   display: inline-block;
   }
   .pg-selected {
   font: bold 11px Arial;
   text-decoration: none;
   background-color: #ff0000;
   color: #333333;
   padding: 6px 8px 6px 8px;
   border-top: 1px solid #CCCCCC;
   border-right: 1px solid #333333;
   border-bottom: 1px solid #333333;
   border-left: 1px solid #CCCCCC;
   cursor: pointer;
   }
   .button {
   font: bold 11px Arial;
   text-decoration: none;
   background-color: #020D56;
   color: #FFFFFF;
   padding: 8px 10px 8px 10px;
   border-top: 1px solid #CCCCCC;
   border-right: 1px solid #333333;
   border-bottom: 1px solid #333333;
   border-left: 1px solid #CCCCCC;
   }
   .aref {
   font: bold 14px Arial;
   text-decoration: none;
   background-color: #0077b3;
   color: #ffffff;
   padding: 8px 14px 8px 14px;
   border-top: 1px solid #CCCCCC;
   border-right: 1px solid #333333;
   border-bottom: 1px solid #333333;
   border-left: 1px solid #CCCCCC;
   }
   .aref:hover {
   color: #ffffff;
   }
   .aref:visited {
   color: #ffffff;
   }
   .pg-answered {
   font: bold 11px Arial;
   text-decoration: none;
   background-color: green;
   color: #333333;
   padding: 6px 8px 6px 8px;
   border-top: 1px solid #CCCCCC;
   border-right: 1px solid #333333;
   border-bottom: 1px solid #333333;
   border-left: 1px solid #CCCCCC;
   cursor: pointer;
   }
   input[type=radio] {
   cursor: pointer;
   }
   input[type=radio]+label {
   color: black;
   font-style: italic;
   }
   input[type=radio]:checked+label {
   color: blue;
   font-style: normal;
   }
   .applycss {
   color: #fffefc;
   font-family: "Times New Roman", Times, serif;
   font-weight: bold;
   font-size: 6 px;
   }
   div.new {
   }
   .black_overlay {
   background-color: black;
   opacity: 0.65;
   }
</style>
<style>
   /*----------------------------------------------
   CSS settings for HTML div Exact Center
   ------------------------------------------------*/
   #finishabc {
   width: 100%;
   height: 100%;
   opacity: .95;
   top: 0;
   left: 0;
   display: none;
   position: fixed;
   background-color: transparent;
   overflow: auto;
   }
   #suspendabc {
   width: 100%;
   height: 100%;
   opacity: .95;
   top: 0;
   left: 0;
   display: none;
   position: fixed;
   background-color: transparent;
   overflow: auto;
   }
   img#close {
   position: absolute;
   right: 0px;
   top: 0px;
   cursor: pointer
   }
   img#close1 {
   position: absolute;
   right: 0px;
   top: 0px;
   cursor: pointer
   }
   div#popupContact {
   position: absolute;
   left: 40%;
   width: 50%;
   height: 30%;
   top: 35%;
   margin-left: -202px;
   -moz-box-shadow: 20px 20px 20px 20px #888;
   -webkit-box-shadow: 20px 20px 20px 20px #888;
   box-shadow: 20px 20px 10px #888888;
   font-family: 'Raleway', sans-serif;
   background-color: #e6f7ff;
   }
   /* 
   table#matrixtable {
   border-collapse: collapse;
   width: 100%;
   border: 1px solid #ddd;
   text-align: left;
   }
   */
   #matrixtable td {
   border: 1px solid #ddd;
   text-align: left;
   padding: 15px;
   text-align: left;
   }
   .sample {
   border: 2px solid #a1a1a1;
   background: #5C99C8;
   color: white;
   width: 300px;
   height: 35px;
   padding: 2px;
   border-radius: 25px;
   margin-top: 10px;
   box-shadow: 6px 6px 5px #888888;
   color: white;
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
   .answeredbtn1{
   padding: 4px 4px 4px 4px;
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
   font-size:12px;
   color: white;
   }
   .notansweredbtn1{
   padding: 4px 4px 4px 4px;
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
   .answeredbtn{
   padding: 8px 8px 4px 8px;
   text-decoration: none;
   border: 1px solid #ccc;
   color: navy;
   background-color: #29D28A;
   margin-right:3px;
   margin-left:3px;
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
   .notansweredbtn{
   padding: 8px 8px 4px 8px;
   text-decoration: none;
   border: 1px solid #ccc;
   color: navy;
   background-color: #ffffff;
   margin-right:3px;
   margin-left:3px;
   float:left;
   -webkit-transition: background 200ms linear;
   transition: background 200ms linear;
   border-Bottom-left-radius: 20px;
   border-Bottom-right-radius:20px;
   moz-border-radius: 10px;
   webkit-border-radius:10px;
   display: inline;
   margin-bottom: :25px;
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
   .markforreview{
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
   .markforreviewansw{
   padding: 9px 8px 4px 8px;
   text-decoration: none;
   border: 1px solid #ccc;
   color: navy;
   background-color: #714F91;
   margin-right:3px;
   margin-left:3px;
   float:left;
   -webkit-transition: background 200ms linear;
   transition: background 200ms linear;
   border-radius: 5px 15px 5px;
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
</style>
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
   #header {
   position: absolute;
   top: 0;
   left: 0;
   right:0;
   width: 100%;
   height: 70px; 
   overflow: hidden; /* Disables scrollbars on the header frame. To enable scrollbars, change "hidden" to "scroll" */
   background: threedhighlight;
   }
   #header_container{
   margin:0 auto;
   position:relative;
   background:url(${pageContext.request.contextPath}/theme/exam/header_bg.jpg) repeat-x left top ;
   height:71px;
   }
   #header_container_inner{ width:982px; margin:0 auto; position:relative;}
   #header_sify_logo{ float:left; position:relative; margin-left:14px; margin-top:11px;}
   #Sam_quest_header{ width:100%; margin:0 auto; background: url(${pageContext.request.contextPath}/theme/exam/sample_question_header_bg.jpg) repeat-x  left top; height:30px;}
   /* Top Container */
   #top-container-wrapper{ position:relative;background:url(${pageContext.request.contextPath}/theme/exam/sample_question_header_bg.jpg) repeat-x  left top;}
   #top-container-wrapper #top-container{ position:relative; height:auto;}
   #top-container h1{font:normal 14px Arial, Helvetica, sans-serif; padding:7px 0; margin-left:0px;  }
   .fixed-btm{bottom:0;float: left;height: 32px;left: 0;position: fixed !important;right:0;width: 100%;}
   .attempt_container{ float:left; position:relative; width:340px;font:normal 12px Arial, Helvetica, sans-serif;}
   .sam_attempt { position:absolute; top:5px; left:20px;background:#00FF00;padding:4px 12px;border:1px solid #fff; width:auto;}
   .sam_attempt_txt{position:absolute; top:35px; left:11px;  color:#010101;} 
   .sam_tag {position:absolute; left:104px;top:5px;background:#febf01;padding:4px 12px;color:#000;border:1px solid #bcbcbc; width:auto; border:1px solid #fff;}
   .sam_tag_text{position:absolute; top:35px; left:104px; color:#010101;}
   .sam_unattempt {position:absolute;left:182px;top:5px;background:#fff;padding:4px 12px;border:1px solid #bcbcbc;width:auto;border:1px solid #fff;}
   .sam_unattempt_text{position:absolute; top:35px; left:182px; color:#010101;}
   #tinybox{position:absolute;display:none;z-index:2000}
   #tinymask{position:absolute;display:none;top:0;left:0;height:100%;width:100%;z-index:1500;background:#000;}
   .green_button{font:normal 14px Arial, Helvetica, sans-serif; width: auto; height:30px;  background: url(${pageContext.request.contextPath}/theme/exam/btn_bg.jpg) repeat-x; padding: 4px 20px;*padding: 4px 8px;  text-align: center;  color:#000;   border:1px solid #fff; border-radius:5px; margin:0 1px 0 0;behavior:url(js/PIE.htc); position:relative;}
   .green_button:hover{ cursor:pointer;}
   .content_container_confi_wrapper {
   /*position:absolute; top:120px; left:280px;*/ width:500px; height: auto; /*border: 1px solid red;*/
   }
   .innerbox_container_confi_login {
   position:relative;
   margin: 0px auto;
   width:100%;
   height: 260px;
   -webkit-border-radius: 20px;
   -moz-border-radius: 20px;
   border-radius: 20px;
   }
   .content_container_confi_login {
   position:relative;
   float:left;
   width:100%;
   height: 104px;
   padding: 20px 0px;
   }
   .content_container_confi_wrapper {
   /*position:absolute; top:120px; left:280px;*/ width:500px; height: auto; /*border: 1px solid red;*/
   }
   #confo_div{ width:95%; margin:0 auto; text-align:center;}
   #confo_div h1{ font:normal 14px/24px Arial, Helvetica, sans-serif; color:#434a53; }
   #confo_div h1 span{ font:bold 14px Arial, Helvetica, sans-serif;}
   #confo_div h2{ font:normal 14px/24px Arial, Helvetica, sans-serif; color:#434a53; margin-top:10px; text-align:center;}
   .outerbox {
   position:relative; margin: 0px auto; width:100%; height: auto; padding: 2px;
   -webkit-border-radius: 24px;
   -moz-border-radius: 24px;
   border-radius: 24px;
   border: 4px solid #ccc;
   background-color:#FFFFFF;
   }
   .innerbox {
   position:relative; margin: 0px auto; width:100%; height: auto;
   -webkit-border-radius: 20px;
   -moz-border-radius: 20px;
   border-radius: 20px;
   background-color:#eeeeee;
   }
   .innerbox_container_common {
   position:relative; margin: 0px auto; width:100%; height: 570px;
   -webkit-border-radius: 20px;
   -moz-border-radius: 20px;
   border-radius: 20px;
   }
   .pager_header_common {
   position:relative; float:left; width:100%; height: 50px; font:normal 26px Arial, Helvetica, sans-serif; color:#000; text-align:center; padding-top:16px;
   -webkit-border-top-left-radius: 20px;
   -webkit-border-top-right-radius: 20px;
   -moz-border-radius-topleft: 20px;
   -moz-border-radius-topright: 20px;
   border-top-left-radius: 20px;
   border-top-right-radius: 20px;
   background:url(${pageContext.request.contextPath}/theme/exam/canddate_header_bg.jpg) repeat-x left top;;
   }
   .content_container_common {
   position:relative; float:left; width:100%; height: 414px; padding: 20px 0px;
   }
   .content_container_box_common {
   position:relative; margin:0 auto; width:95%; overflow:auto;  height: 414px; /*background-color:yellow;*/
   }
   .button_container_common {
   position:relative; float:left; width:100%; height: 35px; text-align:center;/* background-color:#999999;*/ padding-top:5px; padding-bottom:10px;
   }
   .innerbox_container_calogin_above{
   border-radius: 20px 20px 20px 20px;
   height: 160px;
   margin: 0 auto;
   position: relative;
   width: 100%;
   }
   .innerbox_container_calogin_wrapper_above {
   height: auto;
   left: 195px;
   position: absolute;
   top: 43px;
   width: 600px;
   }
   .label-header{ 
   font:14px Arial,Helvetica,sans-serif; 
   color:#4B4C51; 
   padding:5px 12px;
   }
   #final_submit_arrow_div{
   float:left;
   position:relative;
   width:30px;
   height:30px;
   background:#8a919a;
   -webkit-border-top-left-radius: 5px;
   -webkit-border-bottom-left-radius: 5px;
   -moz-border-radius-topleft: 5px;
   -moz-border-radius-bottomleft: 5px;
   border-top-left-radius: 5px;
   border-bottom-left-radius: 5px;
   border-radius:5px 0 0  5px;
   background-color: #73880a;
   }
   #final_submit_arrow_div img{ padding:7px 0 0 9px;}
   #final_submit_btn_div{ float: right; position:relative; margin:5px 0 0 10px; border:1px solid  #FFF; border-radius: 5px; margin-right:40px; }
   #final_submit_arrow_text{ font:normal 14px Arial, Helvetica, sans-serif;float:left;position:relative; width:auto; background: url(${pageContext.request.contextPath}/theme/exam/final_submit_bg.jpg) repeat-x left top; height:30px;line-height:30px; padding:0 10px; color:#fff;-webkit-border-top-right-radius: 5px;
   -webkit-border-bottom-right-radius: 5px;
   -moz-border-radius-topright: 5px;
   -moz-border-radius-bottomright: 5px;
   border-top-right-radius: 5px;
   border-bottom-right-radius: 5px 5px;border-radius:  0  5px  5px  0; }
   #final_submit_arrow_text a{ text-decoration:none; color:#000;}
   #final_submit_arrow_text a:hover{ text-decoration: none; }
   .paginationstylediv .flatview1 a:hover, .paginationstylediv .flatview1 a.selected1 { /*Pagination div "flatview" links style*/
   color: red;
   font-weight:bold;
   background-color: red;
   }
   .btnfooter{
   bottom: 0px;
   height: 60px;
   width: 100%;
   background-color: #d4d4d4;
   position: fixed;
   right: 0px;
   }
   #nav1 {
   position: fixed; 
   top: 110px;
   bottom: 0;
   right: 0;
   width: 330px;
   overflow: auto; /* Scrollbars will appear on this frame only when there's enough content to require scrolling. To disable scrollbars, change to "hidden", or use "scroll" to enable permanent scrollbars */
   height:240px; background:#bbd42d; border-radius:15px 15px 0 0 ;  		
   }
   #nav {
   float:right;right: 0; position:fixed;  margin-top:250px; width:330px; height:346px; background:#d9d9d9;border-radius:0 0 15px 15px;
   }
   #nav #que-scroll{ position:relative; height:250px; overflow-y: scroll; overflow-x:hidden; margin-bottom:10px; }
   #logo {
   padding:10px;
   right: 0;
   }
   main {
   position: fixed;
   top: 110px; /* Set this to the height of the header */
   right: 240px; /* Set this to the width of the nav bar */
   bottom: 0;
   overflow: auto; 
   background: #fff;
   text-align: left;
   left: 10px;
   width: 74%
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
   padding: 100px 230px 0 0; /* Set the first value to the height of the header and second value to the width of the nav */
   }
   * html main{ 
   height: 100%; 
   width: 100%; 
   }
</style>