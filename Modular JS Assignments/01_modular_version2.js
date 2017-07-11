function Bank(accNo,accbal,accName){
	this.accNo=accNo;
	this.accbal=accbal;
	this.accName=accName;
	this.dep=function deposit(amt){
		this.accbal=this.accbal+amt;
	},
	this.draw=function withdraw(amt){
		this.accbal=this.accbal-amt;
	}
}
var bank=new Bank(12,33333,"abc");
function testAccount(){
	alert("Account Number : "+bank.accNo+"\nBalance : "+bank.accbal);
	bank.dep(22222);
	alert("\nAfter Deposit Balance is "+bank.accbal);
	bank.draw(11111);
	alert("\nAfter Withdraw Balance is "+bank.accbal);
}