function validatemandatory(obj,objname,val,allowspl){
	
	if(val==''){
		alert('Please enter value in '+objname);
		return false;
	}
	
	if(!allowspl){
		if(/^[a-zA-Z0-9- ]*$/.test(val) == false) {
		    alert('Special Characters are not allowed for '+objname);
		    return false;
		}
	}
	
	return true;
}

function validateemail(obj,objname,val,allowspl)   
{  
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/; 
 if (!val.value.match(mailformat))  
  {  
	 alert("Please enter a valid email");  
	    return false;
  }
 return true;
}  

function validatemobile(obj,objname,val,allowspl)  
{  
  var phoneno = /^\d{10}$/;  
  if((val.value.match(phoneno))){  
      return true;  
      }else  
      {  
        alert("Please enter a valid phone number");  
        return false;  
        }  
}  

