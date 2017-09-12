import datetime

print("Enter birthdate")
year=int(input("Year : "))
month=int(input("Month : "))
date=int(input("Date : "))
print("Alive ",(datetime.date.today()-datetime.date(year,month,date)).days,"Days")