function calculate(){
	var currage = document.getElementById("age").value;
	var d=new Date();
	var birthyear=d.getFullYear()-currage;
    alert("Your Birth Year is "+birthyear);
}