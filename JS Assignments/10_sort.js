function sorting(){
	var choice= document.getElementById("sort").value;
	var num=[1,55,2,4,33];
	var i,j,temp;
	if(choice=="ascending"){
		for(i=0;i<num.length;i++){
			for(j=i+1;j<num.length;j++){
				if(num[i]>num[j]){
					temp=num[i];
					num[i]=num[j];
					num[j]=temp;
				}
			}
		}
		document.write("ascending ",num);
	}else{
		for(i=0;i<num.length;i++){
			for(j=i+1;j<num.length;j++){
				if(num[i]<num[j]){
					temp=num[i];
					num[i]=num[j];
					num[j]=temp;
				}
			}
		}
		document.write("descending ",num);
	}
}