<div id="finishabc" style="overflow: hidden;">
   <div id="popupContact">
      <div class="panel" style="width: 100%; background-color: #117584;">
         <div class="panel-heading"
            style="font-size: 18px; font-weight: bold; color: #ffffff;">Finish
            Exam
         </div>
      </div>
      <table width="100%" height="65%">
         <tr>
            <td valign="middle" align="center" colspan="2"
               style="font-weight: bold; color: #00004d;">Do you want to
               submit your exam?
            </td>
         </tr>
         <tr>
            <td valign="middle" align="center" colspan="2"
               style="font-weight: bold; color: #00004d;">If 'YES' please
               click on Finish Test. If 'NO' click on Cancel.
            </td>
         </tr>
         <tr>
            <td align="left" width="50%" valign="bottom">
               <button class="button btn-primary" id="finishbutton"
                  style="margin-top: 40px; margin-left: 180px; background-color: #0E8DE2; color: white; font-weight: bold;"
                  name="actionform" value="finishtest"
                  onclick="stopFinishTestTime();this.disabled=true;">Finish
               Test</button>
            </td>
            <td align="right" width="50%" valign="bottom">
               <button class="button btn-primary"
                  style="margin-top: 40px; margin-right: 180px; background-color: #0E8DE2; color: white; font-weight: bold;"
                  id="cancelFinish" onclick="return cancel_Finish();">Cancel</button>
            </td>
         </tr>
      </table>
   </div>
</div>