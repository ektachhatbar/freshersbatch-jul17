var count=0;
function login(){
	count=count+1;
	var usr = document.getElementById("uname").value;
	var pass = document.getElementById("pwd").value;
			if(usr=="admin" && pass=="admin123"){
				alert("Welcome");
			}else{
			alert("Try Again");
				document.getElementById("uname").reset;
				document.getElementById("pwd").reset;
			}
			if(count>3){
				document.write("Error");
			}
}
