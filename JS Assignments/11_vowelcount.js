function countvowel(){
	var sen1 = document.getElementById("sen").value;
	var ca=0,ce=0,ci=0,co=0,cu=0,i;
	for(i=0;i<sen1.length;i++){
		if(sen1[i]=='a' || sen1[i]=='A'){
			ca++;
		}else if(sen1[i]=='e' || sen1[i]=='E'){
			ce++;
		}else if(sen1[i]=='i' || sen1[i]=='I'){
			ci++;
		}else if(sen1[i]=='o' || sen1[i]=='O'){
			co++;
		}else if(sen1[i]=='u' || sen1[i]=='U'){
			cu++;
		}
	}
	alert(" a = "+ca+" , e = "+ce+" , i = "+ci+" , o = "+co+" , u = "+cu);
}