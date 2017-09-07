numberList=[]
for number in range(2000,3201):
    if(number%7==0 and number%5!=0):
        numberList.append(str(number))
print(" , ".join(numberList))