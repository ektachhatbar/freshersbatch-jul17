function prime(){
	var n1 = document.getElementById("num1").value;
	var n2 = document.getElementById("num2").value
	var i,j,flag=0;
	for(i = n1; i <= n2; i++){
             for( j = 2; j < i; j++){
                 if(i % j == 0){
                     flag = 0;
                     break;
                 }else{
                     flag = 1;
                 }
             }
             if(flag == 1){
				document.write(i,"<br>");
			}
         }
}