/**
 * 
 */


var isValid = true;

$(document).ready(function() {
    $('#popup').click(function(e) {
     
        $('input[type="text"]').each(function() {
            if ($.trim($(this).val()) == '') {
                isValid = false;
                $(this).css({
                    "border": "1px solid red",
                    "background": "#FFCECE"
                });
                return false;
            }
            else {
            	isValid = true;
                $(this).css({
                    "border": "",
                    "background": ""
                    	
                });
                return true;
            }
        });
        /* if (isValid == false) 
            e.preventDefault();
        else 
            alert('Thank you for submitting'); */
    });
});

function formValidation(){
	if(isValid==false){
		alert('Text box values should not be empty');
	return false;
	}
	/*if(isValid==true){
		alert('Thank you for submitting');
	return true;
	}*/
}

