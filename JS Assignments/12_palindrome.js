function palindrome(){
	var wrd = document.getElementById("word").value;
	var wrd1=wrd;
	wrd1=wrd1.split("");
	wrd1=wrd1.reverse();
	wrd1=wrd1.join("");
	if(wrd==wrd1){
		alert("It is a palindrome");
	}else{
		alert("It is a consonant");
	}
}