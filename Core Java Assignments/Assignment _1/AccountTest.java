class Account{
	private int accountId;
	private String accountName;
	private double accountBalance;
	Account(int accountId,String accountName,double accountBalance){
		this.accountId=accountId;
		this.accountName=accountName;
		this.accountBalance=accountBalance;
	}
	public void withdraw(double accBal){
		this.accountBalance=this.accountBalance-accBal;
	}
	public void deposit(double accBal){
		this.accountBalance=this.accountBalance+accBal;
	}
	public void print(){
		System.out.println(" Account-Id : "+this.accountId+" Account-Name : "+this.accountName+" Account-Balance : "+this.accountBalance);	
	}
}
class AccountTest{
	public static void main(String args[]){
		Account account=new Account(123,"xyz",50000);
		System.out.println("Account Information : ");
		account.print();
		account.withdraw(5000);
		System.out.println("After Withdrawing : ");
		account.print();
		account.deposit(10000);
		System.out.println("After Depositing : ");
		account.print();
	}
}