numList=input("Enter numbers : ")
num=numList.split(",");
numList=[]
for i in num:
    if((int(i)%2)!=0):
        numList.append(str(int(i)*int(i)))
print(",".join(numList))