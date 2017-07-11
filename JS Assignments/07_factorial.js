function fact(){
	var n = document.getElementById("num").value;
	var i,fact=1;
	for(i=1;i<=n;i++){
		fact=fact*i;
	}
	alert("Factorial of "+n+" is "+fact);
}