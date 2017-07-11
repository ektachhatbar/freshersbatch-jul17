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
function Bank1(_accNo,_accbal,_accName){
	var accno=_accNo;
	var accbal=_accbal;
	var accName=_accName;
	return{
		deposit: function(amt){
			accbal=accbal+amt;
		},
		withdraw: function(amt){
			accbal=accbal-amt;
		},
		getAmount:function(){
			return accbal;
		}
	}
}
var bank1=new Bank1(333,25000,"aaabb");
function testAccount(){
	bank1.deposit(1000);
	alert("\nAfter Deposit Balance is "+bank1.getAmount());
	bank1.withdraw(3000);
	alert("\nAfter Withdraw Balance is "+bank1.getAmount());
}