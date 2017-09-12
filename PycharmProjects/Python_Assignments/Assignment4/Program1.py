import pymysql
db=pymysql.connect("localhost","root","root","xordb")
cursor=db.cursor()
cursor.execute("drop table if exists BankAccount")
cursor.execute("""create table BankAccount(
                accountNo int not null,
                accountName char(20),
                accountBalance double,
                isSalaryAccount char(10),
                oDLimit int
                )""")
accountNo=int(input("Enter Account Number : "))
accName=input("Enter Account Name : ")
accountBalance=input("Enter Account Balance : ")
inp=input("Enter Account Type : \n 1. Saving Account (Type SA)\n 2. Current Account (Type CA)\n")
if(inp=="SA" or inp=="sa"):
    try:
        cursor.execute("""insert into bankaccount(accountNo,accountName,accountBalance,isSalaryAccount)values(%s,%s,%s,%s)""",(accountNo,accName,accountBalance,'true'))
        db.commit()
    except:
        db.rollback()
elif(inp=="CA" or inp=="ca"):
    try:
        limit = int(input("Enter OD Limit : "))
        cursor.execute("""insert into bankaccount(accountNo,accountName,accountBalance,oDLimit)values(%s,%s,%s,%s)""",(accountNo,accName,accountBalance,limit2))
        db.commit()
    except:
        db.rollback()