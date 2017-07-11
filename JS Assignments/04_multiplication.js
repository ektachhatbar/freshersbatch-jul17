function mul(){
	var n1 = document.getElementById("num1").value;
	var i;
	var res;
	do{
		for(i=1;i<11;i++){
			res=n1*i;
			document.write(n1+" * "+i+" = "+res+"<br>");	
		}
		n1++;
	}while(confirm("Do you want to continue with next number?"));
}