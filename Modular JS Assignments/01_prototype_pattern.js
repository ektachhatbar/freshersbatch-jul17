function Bank(accNo,accbal,accName){
	this.accNo=accNo;
	this.accbal=accbal;
	this.accName=accName;
}
Bank.prototype.deposit=function(amt){
	this.accbal=this.accbal+amt;
}
Bank.prototype.withdraw=function(amt){
	this.accbal=this.accbal-amt;
}
Bank.prototype.getAmount=function(){
	return this.accbal;
}
var bank=new Bank(12,33333,"abc");
function testAccount(){
	alert("Account Number : "+bank.accNo+"\nBalance : "+bank.accbal);
	bank.deposit(22222);
	alert("\nAfter Deposit Balance is "+bank.accbal);
	bank.withdraw(11111);
	alert("\nAfter Withdraw Balance is "+bank.accbal);
}