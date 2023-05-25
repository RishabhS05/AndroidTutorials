function callMe(){
    if (!validiate("txtName","spnNameErr","* Name Field is required!!!")){
       validChar("txtName","spnNameErr","* Name Field is always characters!!!");
    }
    
    if (!validiate("txtAge","spnAgeErr","* Age Field is required!!!")){
        validAge("txtAge","spnAgeErr","* Age Field is always a number!!!");
    }
     validiate("txtEmail","spnEMailErr","* Email Field is required!!!");
     validiate("txtAddress","spnAddressErr","* Address Field is required!!!");
 } 
 
  function validiate(txtbox,spnErr,errorMessage){
      var isempty=false;
      var textBoxValue = document.getElementById(txtbox);
      var sp = document.getElementById(spnErr);
      if (textBoxValue.value.trim()==""){
          isempty=true;
          sp.innerText= errorMessage;
      }else{ isEmpty=false;
          sp.innerText= ""; }
return isempty ;
  }
function validAge(txtbox,spnErr,errorMessage){
  var textBoxValue = document.getElementById(txtbox);
      var sp = document.getElementById(spnErr);
      sp.innerText= isNaN(textBoxValue.value.trim())?errorMessage:"";
}
function validChar(txtbox,spnErr,errorMessage){
  var textBoxValue = document.getElementById(txtbox);
      var sp = document.getElementById(spnErr);
      sp.innerText= !isNaN(textBoxValue.value.trim())?errorMessage:"";
}