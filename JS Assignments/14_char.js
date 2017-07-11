function countchar(){
	var sen1 = document.getElementById("sen").value;
	var count=0,i;
	for(i=0;i<sen1.length;i++){
		if(sen1[i]==" "){
			count++;
		}
	}
	var res=sen1.length-count;
	alert("Number of characters in a sentence are "+res);
}