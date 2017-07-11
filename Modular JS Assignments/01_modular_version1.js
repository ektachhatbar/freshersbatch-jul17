var BankAccount={
		accNo : 1234,
		accbal : 50000,
		accName : "xyz",
		withdraw : function(amt) {
			this.accbal=this.accbal-amt;
		},
		deposit : function(amt) {
			this.accbal=this.accbal+amt;
		}
};
function testAccount(){
	BankAccount.withdraw(1000);
	alert("After Withdraw Balance is "+BankAccount.accbal);
    BankAccount.deposit(5000);
	alert("After Deposit Balance is "+BankAccount.accbal);
}