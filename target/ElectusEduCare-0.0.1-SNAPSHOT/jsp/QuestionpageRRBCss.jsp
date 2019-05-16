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
   padding: 14px 14px 14px 14px;
   text-decoration: none;
   border: 1px solid #ccc;
   color: navy;
   background-color: white;
   margin-right:3px;
   float:left;
   -webkit-transition: background 200ms linear;
   transition: background 200ms linear;
   border-bottom-left-radius: 20px;
   border-bottom-right-radius:20px;
   moz-border-radius: 10px;
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
   background-color: #5C99C8;
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
<!-- Scientific Calculator  -->
<script>
   $(function() {
       $("#keyPad").draggable({
           start: function() {
               $(this).css({
                   height: "auto",
                   cursor: "all-scroll",
                   width: "463px"
               });
           },
           stop: function() {
               $(this).css({
                   height: "auto",
                   top: "80px",
                   possition: "fixed",
                   width: "463px"
               });
           }
       });
   
   
   });
   
   function openCalculator() {
       $('#keyPad').show();
   }
   
   function closeCalculator() {
       $('#keyPad').hide();
   }
   
   function minimizeCalculator() {
       $('#mainContentArea').toggle();
       <!-- $('#keyPad_Help').hide(); -->
       <!--  $('#keyPad_Helpback').hide();  -->
       $(".help_back").hide();
       $('#keyPad').addClass("reduceWidth");
       $('#helptopDiv span').addClass("reduceHeader");
       //       		$('#calc_min').toggleClass("reduceHeader");
       $(this).removeClass("calc_min").addClass('calc_max');
   }
   
   function maximizeCalculator() {
       $(this).removeClass("calc_max").addClass('calc_min');
       $('#mainContentArea').toggle();
       if ($("#helpContent").css('display') == 'none') {
           $('#keyPad_Help').show();
       } else {
           $('#keyPad_Helpback').show();
       }
       <!-- $('#keyPad_Help').show(); -->
       $('#keyPad').removeClass("reduceWidth");
       $('#helptopDiv span').removeClass("reduceHeader");
   
   }
   
   function openHelpCalcContent() {
       $(this).hide();
       $('#keyPad_Helpback').show();
       $('.text_container').hide();
       $('.left_sec').hide();
       $('#keyPad_UserInput1').hide();
       $('#helpContent').show();
   }
   
   function closeKeyPadHelpBack() {
       $(this).hide();
       $('#keyPad_Helpback').hide();
       $('#keyPad_Help').show();
       $('.text_container').show();
       $('.left_sec').show();
       $('#keyPad_UserInput1').show();
       $('#helpContent').hide();
   
   }
   
</script>