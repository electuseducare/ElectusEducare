<div id="myModal4" class="modal3">
   <!-- Modal content -->
   <div class="modal-content3">
      <div class="modal-header">
         <button style="float: right;" type="button" class="close3"
            id="close21">&times</button>
      </div>
      <div class="row"></div>
      <div style="overflow-y: scroll; height: 700px;">
         <%int popupcnt=1; %>
         <table border="1" width="100%">
            <c:forEach items="${model1.qp}" var="subrow" varStatus="loop2">
               <tr>
                  <th>No.</th>
                  <th style="text-align: center; background-color: #F5F5F5;">${subrow.subjectname}
                  </th>
               </tr>
               <c:forEach items="${subrow.list}" var="row1" varStatus="loop">
                  <tr>
                     <td width="5%"><%=popupcnt %>)</td>
                     <td width="95%">${row1.ques}<%popupcnt++; %></td>
                  </tr>
               </c:forEach>
            </c:forEach>
         </table>
      </div>
      <%-- <center><button style="text-align: center;" type="button" class="close3" id="close31">CLOSE  </button> </center> --%>
   </div>
</div>