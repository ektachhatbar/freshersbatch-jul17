function validate(){
	var eid = document.getElementById("emailid").value;
	var p1=eid.indexOf("@");
	var p2=eid.lastIndexOf(".");
	if(p1<1 || p2<p1+2 || p2+2>=eid.length){
		alert("Not a valid e-mail address");
	}else{
		alert("Valid e-mail address");
	}
}