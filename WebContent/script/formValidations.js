function resertLocMsgs(){
	document.getElementById("locNameErr").innerHTML='';
	document.getElementById("locTypeErr").innerHTML='';
}
function validateLoc(){

	var exp2=/^[A-Za-z]{3,8}$/;
	resertLocMsgs();
	if(!(document.locForm.locName.value.match(exp2))){
		document.getElementById("locNameErr").innerHTML=' Invalid data for Location Name';
		return false;
	}
	if(document.locForm.locType[0].checked==false && document.locForm.locType[1].checked==false){
		document.getElementById("locTypeErr").innerHTML='  ** Select any one Type';
		return false;
	}
	return true;
}