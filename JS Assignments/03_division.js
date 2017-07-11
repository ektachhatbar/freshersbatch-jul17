function division(){
	var n1 = document.getElementById("num1").value;
	var n2 = document.getElementById("num2").value
	if(n2==0){
		alert("2nd Number can't be zero");
	}else{
			document.write("Answer of Division is ",n1/n2);
	}
}