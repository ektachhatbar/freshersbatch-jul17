export function testClassesModules(){
    class Account{
        constructor(accid,accname,accbal){
            this.accid=accid;
            this.accname=accname;
            this.accbal=accbal;
        }
        getBalance(){
            return this.accbal;
        }
    }
    class SavingAcc extends Account{
        constructor(accid,accname,accbal,interest){
            super(accid,accname,accbal);
            this.interest=interest;
        }
        getBalance(){
            return this.accbal+this.interest;
        }
    }
    class CurrentAcc extends Account{
        constructor(accid,accname,accbal,cashcredit){
            super(accid,accname,accbal);
            this.cashcredit=cashcredit;
        }
        getBalance(){
            return this.accbal+this.cashcredit;
        }
    }
    let accounts=[];
    let s1=new SavingAcc(1,"abc",1000,200);
    accounts.push(s1);
    let s2=new SavingAcc(2,"def",2000,300);
    accounts.push(s2);
    let s3=new SavingAcc(3,"ghi",3000,400);
    accounts.push(s3);
    let c1=new CurrentAcc(4,"jkl",4000,500);
    accounts.push(c1);
    let c2=new CurrentAcc(5,"mno",5000,600);
    accounts.push(c2);
    let c3=new CurrentAcc(6,"pqr",6000,700);
    accounts.push(c3);

    var cash=getTotalAccBal(accounts);
    console.log("Total Cash : ",cash);

    function getTotalAccBal(accounts){
        let total=0;
        accounts.forEach(function(acc){
            total=total+acc.getBalance();
        })
        return total;
    }

}