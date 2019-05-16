<!-- <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script> -->
<script src="${pageContext.request.contextPath}/theme/js/downloadjs/ajax1111.js"></script>
<script>
   /** Allow Alphabets with spaces **/
   $(document).ready(function(){
   $("#statename").keypress(function (e){
      var code =e.keyCode || e.which;
         if((code<65 || code>90)
         &&(code<97 || code>122)&&code!=32&&code!=46)  
        {
        // alert("Only alphabates are allowed");
         return false;
        }
      });
   });
   
   
   
   /* Allow only alphabets  */
          function onlyAlphabets(e, t) {
              try {
                  if (window.event) {
                      var charCode = window.event.keyCode;
                  }
                  else if (e) {
                      var charCode = e.which;
                  }
                  else { return true; }
                  if ((charCode > 64 && charCode < 91) || (charCode > 96 && charCode < 123) )
                      return true;
                  else
                      return false;
              }
              catch (err) {
                  alert(err.Description);
              }
          }
   
          /* Allow only alphabets with spaces  */
          function ValidateAlpha(evt)
          {
              var keyCode = (evt.which) ? evt.which : evt.keyCode;
              if ((keyCode < 65 || keyCode > 90) && (keyCode < 97 || keyCode > 123) && (keyCode != 32)){
               
              return false;
              }
              else{
                  return true;
              }
          }
       /* Add class validations---Allow alphabets,numbers,-,_   */
       
      $(function(){
   $('#class').keyup(function()
   {
   	var yourInput = $(this).val();
   	re = /[`~!@#$%^&*()|+\=?;:'",._<>\{\}\[\]\\\/]/gi;
   	var isSplChar = re.test(yourInput);
   	if(isSplChar)
   	{
   		var no_spl_char = yourInput.replace(/[`~!@#$%^&*()|+\=?;:'",._<>\{\}\[\]\\\/]/gi, '');
   		$(this).val(no_spl_char);
   	}
   });
   
   });
       
      $(function(){
      	$('#topicnametext').keyup(function()
      	{
      		var yourInput = $(this).val();
      		re = /[`~!@#$%^&*()|+\=?;:'",._<>\{\}\[\]\\\/]/gi;
      		var isSplChar = re.test(yourInput);
      		if(isSplChar)
      		{
      			var no_spl_char = yourInput.replace(/[`~!@#$%^&*()|+\=?;:'",._<>\{\}\[\]\\\/]/gi, '');
      			$(this).val(no_spl_char);
      		}
      	});
   
      });
      $(function(){
      	$('#subtopicnametext').keyup(function()
      	{
      		var yourInput = $(this).val();
      		re = /[`~!@#$%^&*()|+\=?;:'",._<>\{\}\[\]\\\/]/gi;
      		var isSplChar = re.test(yourInput);
      		if(isSplChar)
      		{
      			var no_spl_char = yourInput.replace(/[`~!@#$%^&*()|+\=?;:'",._<>\{\}\[\]\\\/]/gi, '');
      			$(this).val(no_spl_char);
      		}
      	});
   
      });
       
      /* Add Section validations---Allow alphabets,numbers,-,_   */
       
          $(function(){
   $('#section').keyup(function()
   {
   	var yourInput = $(this).val();
   	re = /[`~!@#$%^&*()|+\=?;:'",._<>\{\}\[\]\\\/]/gi;
   	var isSplChar = re.test(yourInput);
   	if(isSplChar)
   	{
   		var no_spl_char = yourInput.replace(/[`~!@#$%^&*()|+\=?;:'",._<>\{\}\[\]\\\/]/gi, '');
   		$(this).val(no_spl_char);
   	}
   });
   
   });
      
      
          /* Examname validations in Createexam---Allow alphabets,numbers,-,_   */
          
          $(function(){
   $('#examname').keyup(function()
   {
   	var yourInput = $(this).val();
   	re = /[`~!@#$%^&*()|+\=?;:'",.<>\{\}\[\]\\\/]/gi;
   	var isSplChar = re.test(yourInput);
   	if(isSplChar)
   	{
   		var no_spl_char = yourInput.replace(/[`~!@#$%^&*()|+\=?;:'",.<>\{\}\[\]\\\/]/gi, '');
   		$(this).val(no_spl_char);
   	}
   });
   
   });
          
          function isNumberKey(evt) {
              evt = (evt) ? evt : window.event;
              var charCode = (evt.which) ? evt.which : evt.keyCode;
              if (charCode > 31 && (charCode < 48 || charCode > 57)) {
                  return false;
              }
              return true;
          }
       
</script>