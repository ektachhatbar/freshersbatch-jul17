inputs=input("Enter numbers in binary format : ")
number=inputs.split(",");
list=[]
for i in number:
    num=int(i,2)
    if(num%5==0):
        list.append(str(i))
print(",".join(list))