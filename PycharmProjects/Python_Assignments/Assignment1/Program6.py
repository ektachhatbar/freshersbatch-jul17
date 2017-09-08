numberList=input("Enter list of numbers : ")
n_list=numberList.split(",")
list=[]
for i in n_list:
    i=int(i)
    list.append(str(int(((2*50*i)/30)**(1/2))))
print(','.join(list))