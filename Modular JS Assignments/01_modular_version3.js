var BankAccount=Object.create(Object.prototype);
var Bank ={
	accNo :0,
	accbal :0,
	accName : "null",
	withdraw : function(amt) {
			this.accbal=this.accbal-amt;
		},
	deposit : function(amt) {
		this.accbal=this.accbal+amt;
	}
}
var bank=Object.create(Bank);
function testAccount(){
	bank.accNo=12;
	bank.accbal=9000;
	accName="xyz";
	bank.withdraw(1000);
	alert("After Withdraw Balance is "+bank.accbal);
    bank.deposit(5000);
	alert("After Deposit Balance is "+bank.accbal);
}