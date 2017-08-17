class Account{
        private int accid;
        private String accname;
        private double accbal;
        Account(int accid,String accname,double accbal){
            this.accid=accid;
            this.accname=accname;
            this.accbal=accbal;
        }
        public double getBalance(){
            return this.accbal;
        }
    }
    class SavingAccount extends Account{
        private double interest;
        SavingAccount(int accid,String accname,double accbal,double interest){
            super(accid,accname,accbal);
            this.interest=interest;
        }
        public double getBalance(){
            return this.interest+super.getBalance();
        }
    }
    class CurrentAccount extends Account{
        private double cashcredit;
        CurrentAccount(int accid,String accname,double accbal,double cashcredit){
            super(accid,accname,accbal);
            this.cashcredit=cashcredit;
        }
        public double getBalance(){
            return this.cashcredit+super.getBalance();
        }
    }

class AccountTest{
	public static double getTotalCash(Account acc[]){
		double totalCash=0.0;
		for(int i=0;i<acc.length;i++){
			totalCash=totalCash+acc[i].getBalance();
		}
		return totalCash;
	}
	public static void main(String args[]){
		Account []acc=new Account[6];
		acc[0]=new SavingAccount(1,"abc",1000,200);
		acc[1]=new SavingAccount(2,"def",2000,300);
		acc[2]=new SavingAccount(3,"ghi",3000,400);
		acc[3]=new CurrentAccount(4,"jkl",4000,500);
		acc[4]=new CurrentAccount(5,"mno",5000,600);
		acc[5]=new CurrentAccount(6,"pqr",6000,700);
		System.out.println("Total Cash = "+getTotalCash(acc));
	}
}