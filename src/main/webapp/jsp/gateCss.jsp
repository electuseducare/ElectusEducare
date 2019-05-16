<style>
.diff_type_notation_area_inner span {
background: url(theme/images/questions-sprite.png) no-repeat;
	color: #262626;
	line-height: 15px;
	text-align: center;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 1em;
}
.diff_type_notation_area_inner span.answered {
	background-position: -7px -55px;
	float: left;
	height: 26px;
	 line-height: 20px;
	margin-right: 10px;
	width: 29px;
	color: #fff;
	padding-top: 3px;
}
.diff_type_notation_area_inner span.review {
	background-position: -75px -54px;
	float: left;
	height: 28px;
	 line-height: 18px;
	margin-right: 10px;
	width: 28px;
	color: #fff;
	padding-top: 5px;
}
.diff_type_notation_area_inner span.review + span.type_title , .diff_type_notation_area_inner span.review_answered + span.type_title
{
line-height:14px;
display: table-cell;
text-align: left;
}
.diff_type_notation_area_inner span.review_answered {
	background-position: -9px -87px;
	float: left;
	height: 29px;
	 line-height: 15px;
	margin-right: 10px;
	width: 28px;
	color: #fff;
	padding-top: 5px;
}
.diff_type_notation_area_inner span.review_marked {
	background-position: -172px -55px;
	float: left;
	height: 28px;
	 line-height: 15px;
	margin-right: 10px;
	width: 30px;
	color: #fff;
	padding-top: 5px;
}
.diff_type_notation_area_inner span.not_answered {
	background-position: -42px -56px;
	float: left;
	height: 26px;
	line-height:22px;
	margin-right: 10px;
	width: 29px;
	color: #fff;
}
.diff_type_notation_area_inner span.visited {
	background-position:-138px -56px;
	float: left;
	height: 26px;
	 line-height: 21px;
	margin-right: 10px;
	width: 29px;
	color: #fff;
	padding-top: 2px;
}
.diff_type_notation_area_inner span.not_visited {
	background-position: -107px -56px;
	float: left;
	height: 26px;
	 line-height: 21px;
	margin-right: 10px;
	width: 29px;
	color: #000;
	padding-top: 2px;
}
.diff_type_notation_area_inner span.type_title {
	background: none;
	display: table-cell;
    text-align: left;
    white-space: normal;
}
.diff_type_notation_area_inner span.number {
	background: none;
}
.question_area {
	overflow: auto;
	font: 0.917em Arial, Helvetica, sans-serif;
	padding: 5px;
}
.question_area span {
	background: url(theme/images/questions-sprite.png) no-repeat;
	color: #fff;
    cursor: pointer;
    float: left;
    font-size: 1.417em;
    font-weight: normal;
    height: 43px;
    line-height: 42px;
    margin-bottom: 10px;
    margin-right: 2px;
    text-align: center;
    width: 50px;
}
.question_area span.answered {
	 background-position: -4px -5px;
}
.question_area span.review {
	  background-position: -108px -1px;
    height: 50px;
    line-height: 50px;
	margin-bottom: 3px;
}
.question_area span.review_answered {
	background-position: -66px -178px;
    height: 53px;
    line-height: 51px;
    margin-bottom: 0;
  /*  margin-right: 5px;*/
    width: 49px;
}

.question_area span.review_marked {
	background-position: -203px -49px;
    height: 53px;
    line-height: 50px;
    margin-bottom: 0;
  /*  margin-right: 5px;*/
    width: 53px;
}

.question_area span.not_answered {
	background-position: -57px -6px;
	width:49px;
	height: 43px;
}
.question_area span.visited {
	    background-position: -208px -4px;
    height: 43px;
    line-height: 43px;
}

.question_area span.not_visited {
 background-position: -157px -4px;
    color: #474747;
    height: 43px;
    line-height: 43px;
}
.question_area span.not_visited:hover {
	background-position: -157px -4px;
}
.question_area span.visited:hover {
	background-position: -208px -124px;
}
.question_area span.answered:hover {
	background-position: -4px -126px;
}
.question_area span.review:hover {
	background-position: -108px -122px;
}
.question_area span.review_answered:hover {
	background-position: -66px -178px;
}
.question_area span.review_marked:hover {
	background-position: -5px -178px;
}
.question_area span.review_marked {
	background-position: -203px -49px;
}
.question_area span.not_answered:hover {
	background-position: -57px -127px;
}
.question_area span.visited:hover {
	background-position: -208px -124px;
}
#Questn_area_bg { /*border:1px solid #bec2c5;background:#3e5979;*/
	background: #fff; /*height:112px;*/
	position: relative;
	overflow: auto;
}
.Questn_Area {
   float: none;
    height: auto;
    margin-right: 0;
    width: auto;
}
 .filter_section {
        background-color: #fff;
        padding-bottom: 0;
    }
    .fltr_titles div {
        float: left;
        font-size: 13px;
        padding-left: 18px;
        width: auto;
        color: #848484;
    }
    .fltr_titles .def {
        float: right;
        margin-right: 20px;
        color: #4285f4;
        cursor: pointer;
    }
    .fltrs .sm_bxes {
        color: #fff;
        float: left;
        height: 22px;
        line-height: 17px;
        margin-right: 8px;
        padding-top: 3px;
        width: 26px;
        clear: both;
        text-align: center;
    }
    .filter_descp .fltrs:hover {
        background-color: #c6dafc;
    }
    .fltrs .answered {
        background: rgba(0, 0, 0, 0) url("theme/images/questions-sprite.png") no-repeat scroll -301px -123px;
    }
    .fltrs .nt_answered {
        background: rgba(0, 0, 0, 0) url("theme/images/questions-sprite.png") no-repeat scroll -336px -123px;
        line-height: 15px;
    }
    .fltrs .nt_visit {
        background: rgba(0, 0, 0, 0) url("images/questions-sprite.png") no-repeat scroll -371px -123px;
        color: #6e6e6e;
        width: 24px;
    }
    .fltrs .mfr {
        background: rgba(0, 0, 0, 0) url("images/questions-sprite.png") no-repeat scroll -403px -123px;
        width: 24px;
    }
    .fltrs .mfr_ans {
        background: rgba(0, 0, 0, 0) url("images/questions-sprite.png") no-repeat scroll -433px -123px;
        width: 24px;
    }
    .fltrs .type_title {
        width: auto;
        margin-top: 3px;
        font-size: 13px;
    }
    .filter_descp .fltrs {
        padding: 9px 15px;
        text-align: left;
    }
    /** initial setup **/
.nano {
  position : relative;
  width    : 100%;
  height   : 150px;
  overflow : hidden;
}
.nano > .nano-content {
  position      : absolute;
  overflow-y      : scroll;
  overflow-x    : hidden;
  top           : 0;
  right         : 0;
  bottom        : 0;
  left          : 0;
}
.nano > .nano-content:focus {
  outline: thin dotted;
}
.nano > .nano-content::-webkit-scrollbar {
  visibility: hidden;
}
.has-scrollbar > .nano-content::-webkit-scrollbar {
  visibility: visible;
}
.nano > .nano-pane {
 /* background : rgba(0,0,0,.25);*/
 background: #DDDBE6;
  position   : absolute;
  width      : 10px;
  right      : 0;
  top        : 0;
  bottom     : 0;
  visibility : hidden\9; /* Target only IE7 and IE8 with this hack */
  opacity    : .01;
  -webkit-transition    : .2s;
  -moz-transition       : .2s;
  -o-transition         : .2s;
  transition            : .2s;
  -moz-border-radius    : 5px;
  -webkit-border-radius : 5px;
  border-radius         : 5px;
  z-index:99999999;
}
.nano > .nano-pane > .nano-slider {
 /* background: #444;
  background: rgba(0,0,0,.5);*/
  background:#6A6289;
  position              : relative;
  margin                : 0 1px;
  -moz-border-radius    : 3px;
  -webkit-border-radius : 3px;
  border-radius         : 3px;
}
.nano:hover > .nano-pane, .nano-pane.active, .nano-pane.flashed {
  visibility : visible\9; /* Target only IE7 and IE8 with this hack */
  opacity    : 0.99;
}
 .rightSectionDiv {
	width: 100%;
	clear: both;

}

.rightSectionDiv .header {
    background: #4e85c5 none repeat scroll 0 0;
    color: #fff;
    height: 31px;
    line-height: 31px;
    padding-left: 10px;
}
.rightSectionDiv .questionStatus {
	background: #f8fafb;
	font-size: 1em;
	font-weight: bold;
	height: 26px;
	line-height: 26px;
	padding-left: 10px;
}
.rightSectionDiv .questionStatus span {
	font-size: 1.167em;
}
.rightSectionDiv .subheader {
	background: #e5f6fd;
	font-size: 1em;
	font-weight: bold;
	height: 26px;
	line-height: 26px;
	padding-left: 10px;
}
.rightSectionDiv .header .progressBar {
	float: right;
	padding-right: 4px;
}
.rightSectionDiv .content {
background:#e5f6fd;
}
/* ----------------------------------------------------------------------------------------------------------------*/
/* ---------->>> global settings needed for thickbox <<<-----------------------------------------------------------*/
/* ----------------------------------------------------------------------------------------------------------------*/
*{padding: 0; margin: 0;}
html,body{padding: 0; margin: 0;}

/* ----------------------------------------------------------------------------------------------------------------*/
/* ---------->>> thickbox specific link and font settings <<<------------------------------------------------------*/
/* ----------------------------------------------------------------------------------------------------------------*/
#TB_window {
	font: 11px "Tahoma", Arial, Helvetica, sans-serif;
	color: #333333;
}

#TB_secondLine {
	font: 10px "Tahoma",Arial, Helvetica, sans-serif;
	color:#666666;
}

/* ----------------------------------------------------------------------------------------------------------------*/
/* ---------->>> thickbox settings <<<-----------------------------------------------------------------------------*/
/* ----------------------------------------------------------------------------------------------------------------*/
#TB_overlay {
	position: fixed;
	z-index:99;
	top: 0px;
	left: 0px;
	height:100%;
	width:100%;
}

.TB_overlayMacFFBGHack {background: url(macFFBgHack.png) repeat;}
.TB_overlayBG {
	background-color:#000;
	filter:alpha(opacity=60);
	-moz-opacity: 0.60;
	opacity: 0.60;
}

* html #TB_overlay { /* ie6 hack */
     position: absolute;
     height: expression(document.body.scrollHeight > document.body.offsetHeight ? document.body.scrollHeight : document.body.offsetHeight + 'px');
}

#TB_window {
	position: fixed;
	background:none;
	z-index: 1200;
	color:#000000;
	display:none;
	/*border: 2px solid #8babc2;*/
	text-align:left;
	top:10%;
	left:10%;
	
}

* html #TB_window { /* ie6 hack */
position: absolute;
margin-top: expression(0 - parseInt(this.offsetHeight / 2) + (TBWindowMargin = document.documentElement && document.documentElement.scrollTop || document.body.scrollTop) + 'px');
}

#TB_window img#TB_Image {
	display:block;
	margin: 15px 0 0 15px;
	border-right: 1px solid #ccc;
	border-bottom: 1px solid #ccc;
	border-top: 1px solid #666;
	border-left: 1px solid #666;
}

#TB_caption{
	height:25px;
	padding:7px 30px 10px 25px;
	float:left;
}

#TB_closeWindow{
	height:25px;
	padding:11px 25px 10px 0;
	float:right;
}

#TB_closeAjaxWindow{
	padding:7px 10px 5px 0;
	margin-bottom:1px;
	text-align:right;
	float:right;
}

#TB_ajaxWindowTitle{
	float:left;
	padding:7px 0 5px 10px;
	margin-bottom:1px;
}

#TB_title{
	background-color:#dbf3ff;
	height:27px;
}

#TB_ajaxContent{
	clear:both;
	padding:2px 15px 15px 15px;
	overflow:hidden;
	text-align:left;
	line-height:1.4em; background:#fff;
}

#TB_ajaxContent.TB_modal{
	padding:0px;
}

#TB_ajaxContent p{
	padding:5px 0px 5px 0px;
}

#TB_load{
	position: fixed;
	display:none;
	height:13px;
	width:208px;
	z-index:103;
	top: 50%;
	left: 50%;
	margin: -6px 0 0 -104px; /* -height/2 0 0 -width/2 */
}

* html #TB_load { /* ie6 hack */
position: absolute;
margin-top: expression(0 - parseInt(this.offsetHeight / 2) + (TBWindowMargin = document.documentElement && document.documentElement.scrollTop || document.body.scrollTop) + 'px');
}

#TB_HideSelect{
	z-index:20;
	position:fixed;
	top: 0;
	left: 0;
	background-color:#fff;
	border:none;
	filter:alpha(opacity=0);
	-moz-opacity: 0;
	opacity: 0;
	height:100%;
	width:100%;
}

* html #TB_HideSelect { /* ie6 hack */
     position: absolute;
     height: expression(document.body.scrollHeight > document.body.offsetHeight ? document.body.scrollHeight : document.body.offsetHeight + 'px');
}

#TB_iframeContent{
	clear:both;
	border:none;
	margin-bottom:-1px;
	margin-top:1px;
	_margin-bottom:1px;
}
.Rght_Section {
	background: none repeat scroll 0 0 #f8fbff;
	border-bottom: 0 none;
	float: right;
	 margin-right: 0;
	height: auto;
	width:250px;
}
.Rght_tdbg {
	background: #f8fbff;
}
.collapsebel_panel
{
border:2px solid #000;
border-right:none;
position:relative;
}

   
</style>