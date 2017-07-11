function calculate(){
	var numarr = [1,2,3,4,5];
	var i,sum=0,avg;
	document.write("Given Array is ",numarr,"<br>")
	document.write("Maximum Number in array : ",Math.max(numarr[0],numarr[1],numarr[2],numarr[3],numarr[4]),"<br>");
	document.write("Minimum Number in array : ",Math.min(numarr[0],numarr[1],numarr[2],numarr[3],numarr[4]),"<br>");
	for(i=0;i<numarr.length;i++){
		sum=sum+numarr[i];
	}
	document.write("Sum of Array is ",sum,"<br>")
	document.write("Average of Array is ",sum/numarr.length,"<br>")
}