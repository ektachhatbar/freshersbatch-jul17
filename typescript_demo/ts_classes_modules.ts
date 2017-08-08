    class Account{
        accid:number;
        accname:string;
        accbal:number;
        constructor(accid:number,accname:string,accbal:number){
            this.accid=accid;
            this.accname=accname;
            this.accbal=accbal;
        }
        getBalance():number{
            return this.accbal;
        }
    }
    class SavingAcc extends Account{
        interest:number;
        constructor(accid:number,accname:string,accbal:number,interest:number){
            super(accid,accname,accbal);
            this.interest=interest;
        }
        getBalance():number{
            return this.accbal+this.interest;
        }
    }
    class CurrentAcc extends Account{
        cashcredit:number;
        constructor(accid:number,accname:string,accbal:number,cashcredit:number){
            super(accid,accname,accbal);
            this.cashcredit=cashcredit;
        }
        getBalance():number{
            return this.accbal+this.cashcredit;
        }
    }
    let s1=new SavingAcc(1,"abc",1000,200);
    let s2=new SavingAcc(2,"def",2000,300);
    let s3=new SavingAcc(3,"ghi",3000,400);
    let c1=new CurrentAcc(4,"jkl",4000,500);
    let c2=new CurrentAcc(5,"mno",5000,600);
    let c3=new CurrentAcc(6,"pqr",6000,700);
    let accounts: Array<object>=[s1,s2,s3,c1,c2,c3];

    var cash:number=getTotalAccBal(accounts);
    console.log("Total Cash : ",cash);

    function getTotalAccBal(accounts : any):number{
        let total:number=0;
        accounts.forEach(function(acc:any){
            total=total+acc.getBalance();
        })
        return total;
    }