function sorting(){
	var choice= document.getElementById("sort").value;
	var num=[1,5,2,4,3];
	var i,j,temp;
	if(choice=="ascending"){
		document.write("ascending ",num.sort());
	}else{
		num=num.sort();
		document.write("descending ",num.reverse());
	}
}