number=int(input("Enter an integer: "))
fact=1
for i in range(2,number+1):
    fact=fact*i
print("Factorial of ",number," is ",fact)